package gr.uoa.di.tded.labisp.gstam;

import gr.uoa.di.tded.labisp.gstam.domains.Cart;
import gr.uoa.di.tded.labisp.gstam.domains.CreditCard;
import gr.uoa.di.tded.labisp.gstam.domains.Order;
import gr.uoa.di.tded.labisp.gstam.domains.OrderStatus;
import gr.uoa.di.tded.labisp.gstam.domains.PaymentMethod;
import gr.uoa.di.tded.labisp.gstam.domains.Product;
import gr.uoa.di.tded.labisp.gstam.domains.ShippingMethod;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


public final class DatabaseManager {

    private static final String GET_PRODUCT =
            "SELECT * " +
            "FROM Product " +
            "WHERE productId = ?;";

    private static final String GET_ORDER_PRODUCTS =
            "SELECT productId " +
            "FROM Orders orders, Cart cart " +
            "WHERE orders.userId = cart.userId AND " +
                "orders.date = cart.date AND " +
                "orders.orderId = ?;";

    private static final String GET_CART_INFO =
            "SELECT cart.productCount, cart.paymentMethod, cart.shippingAddress " +
            "FROM Product product, Cart cart " +
            "WHERE product.productId = cart.productId AND " +
                "product.productId = ?;";

    private static final String GET_CREDIT_CARD =
            "SELECT * " +
            "FROM CreditCard " +
            "WHERE userId = ?;";

    private static final String GET_ADDRESSES =
            "SELECT address, address2 " +
            "FROM Users " +
            "WHERE userId = ?;";

    private static final String GET_ORDER_HISTORY =
            "SELECT * " +
            "FROM Orders " +
            "WHERE userId = ?;";

    private static final String GET_PRODUCT_ID_FROM_ORDER =
            "SELECT cart.productId " +
            "FROM Orders orders, Cart cart " +
            "WHERE orders.userId = cart.userId AND " +
                "cart.userId = ? AND " +
                "cart.date = ?;";

    private static final String IS_PRODUCT_AVAILABLE =
            "SELECT productAvailability " +
            "FROM product_available_on_warehouse " +
            "WHERE productId = ?;";

    private static final String GET_WAREHOUSE_ID =
            "SELECT warehouseId " +
            "FROM product_available_on_warehouse " +
            "WHERE productId = ?;";

    private static final String BOOK_PRODUCT =
            "INSERT INTO bookproduct (productId, warehouseId, date, isBooked) VALUES " +
                                    "(?, ?, NOW(), ?);";

    private static final String CANCEL_BOOK_PRODUCT =
            "DELETE FROM bookproduct " +
            "WHERE productId = ?;";

    private static final String GET_CREDIT_CARD_INFO =
            "SELECT creditId, userId, amount " +
            "FROM CreditCard " +
            "WHERE creditId = ?;";

    private static final String UPDATE_CREDIT_CARD =
            "UPDATE CreditCard " +
            "SET amount = ? " +
            "WHERE creditId = ?;";

    private static final Logger LOGGER = Logger.getLogger(DatabaseManager.class.getName());
    private static DatabaseManager databaseManager;
    private Connection connection;

    public static synchronized DatabaseManager getInstance() throws IOException {
        if (databaseManager == null) {
            final Properties properties = new Properties();
            properties.load(new FileInputStream("databaseConfig.properties"));
            return new DatabaseManager(properties.getProperty("jdbcDriver"), properties.getProperty("jdbcUrl"));
        }
        return databaseManager;
    }

    private DatabaseManager(final String jdbcDriver, final String jdbcUrl) {
        try {
            Class.forName(jdbcDriver);
            connection = DriverManager.getConnection(jdbcUrl);
        } catch (final SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        } catch (final ClassNotFoundException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }

    /*** Service 1 ***/

    public Product findProduct(String productId) {
        try {
            final PreparedStatement productPrepareStatement = connection.prepareStatement(GET_PRODUCT);
            productPrepareStatement.setString(1, productId);

            final ResultSet productResultSet = productPrepareStatement.executeQuery();
            try {
                if (productResultSet.next()) {
                    final Product product = new Product(productResultSet.getString("productId"),
                            productResultSet.getString("name"), productResultSet.getString("category"),
                            productResultSet.getDouble("price"), productResultSet.getString("description"),
                            productResultSet.getBoolean("availability"));
                    LOGGER.log(Level.INFO, "For productId: " + productId + " retrieved product: " + product);
                    return product;
                }
            } finally {
                productResultSet.close();
                productPrepareStatement.close();
            }
        } catch (final SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /*** Service 2 ***/

    public Cart findCart(String orderId) {
        try {
            final PreparedStatement orderPrepareStatement = connection.prepareStatement(GET_ORDER_PRODUCTS);
            final PreparedStatement cartPreparedStatement = connection.prepareStatement(GET_CART_INFO);
            try {
                orderPrepareStatement.setString(1, orderId);
                final ResultSet productIdsResultSet = orderPrepareStatement.executeQuery();
                try {
                    final List<String> productIds = new ArrayList<String>();
                    while(productIdsResultSet.next()) {
                        productIds.add(productIdsResultSet.getString("productId"));
                    }
                    LOGGER.log(Level.INFO, "product Ids retrieved: " + productIds);

                    final List<Product> products = new ArrayList<Product>();
                    final Map<Product, Integer> productCountMap = new HashMap<Product, Integer>();
                    PaymentMethod paymentMethod = null;
                    String shippingAddress = null;

                    for (final String productId : productIds) {
                        final Product product = findProduct(productId);
                        LOGGER.log(Level.INFO, "Product retrieved: " + product);
                        products.add(product);
                        cartPreparedStatement.setString(1, productId);

                        final ResultSet cartResultSet = cartPreparedStatement.executeQuery();

                        try {
                            if (cartResultSet.next()) {
                                final int productCount = cartResultSet.getInt("productCount");
                                paymentMethod = PaymentMethod.valueOf(cartResultSet.getString("paymentMethod"));
                                shippingAddress = cartResultSet.getString("shippingAddress");
                                productCountMap.put(product, productCount);
                                LOGGER.log(Level.INFO, "For productId " + productId + " has productCount: " + productCount);
                            }
                        } finally {
                            cartResultSet.close();
                        }
                    }

                    final Cart cart = new Cart(orderId, productIds, productCountMap, paymentMethod, shippingAddress);
                    LOGGER.log(Level.INFO, "Found cart: " + cart);
                    return cart;
                } finally {
                    productIdsResultSet.close();
                }
            } finally {
                orderPrepareStatement.close();
                cartPreparedStatement.close();
            }
        } catch (final SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /*** Service 3 ***/

    public List<CreditCard> getCreditCards(String userId) {
        try {
            final PreparedStatement creditCardPreparedStatement = connection.prepareStatement(GET_CREDIT_CARD);
            try {
                creditCardPreparedStatement.setString(1, userId);
                final ResultSet creditCardResultSet = creditCardPreparedStatement.executeQuery();
                try {
                    final List<CreditCard> creditCardList = new ArrayList<CreditCard>();
                    while (creditCardResultSet.next()) {
                        final CreditCard creditCard = new CreditCard(creditCardResultSet.getString("creditId"),
                                creditCardResultSet.getString("userId"), creditCardResultSet.getDouble("amount"));
                        creditCardList.add(creditCard);
                        LOGGER.log(Level.INFO, "Found creditCart: " + creditCard);
                    }
                    return creditCardList;
                } finally {
                    creditCardResultSet.close();
                }
            } finally {
                creditCardPreparedStatement.close();
            }
        } catch (final SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<String> getAddresses(String userId) {
        try {
            final PreparedStatement addressesPreparedStatement = connection.prepareStatement(GET_ADDRESSES);
            try {
                addressesPreparedStatement.setString(1, userId);
                final ResultSet addressesResultSet = addressesPreparedStatement.executeQuery();
                try {
                    final List<String> addresses = new ArrayList<String>();
                    while (addressesResultSet.next()) {
                        addresses.add(addressesResultSet.getString("address"));
                        addresses.add(addressesResultSet.getString("address2"));
                        LOGGER.log(Level.INFO, "Retrieved for userId: " + userId + " addresses: " + addresses);
                    }
                    return addresses;
                } finally {
                    addressesResultSet.close();
                }
            } finally {
                addressesPreparedStatement.close();
            }
        } catch (final SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Order> getOrderHistory(String userId) {
        try {
            final PreparedStatement ordersHistoryPreparedStatement = connection.prepareStatement(GET_ORDER_HISTORY);
            final PreparedStatement productIdFromOrderPreparedStatement = connection.prepareStatement(GET_PRODUCT_ID_FROM_ORDER);
            try {
                ordersHistoryPreparedStatement.setString(1, userId);
                final ResultSet ordersHistoryResultSet = ordersHistoryPreparedStatement.executeQuery();
                try {
                    final List<Order> orderList = new ArrayList<Order>();
                    while(ordersHistoryResultSet.next()) {
                        final String orderId = ordersHistoryResultSet.getString("orderId");
                        final String warehouseId = ordersHistoryResultSet.getString("warehouseId");
                        final OrderStatus orderStatus = OrderStatus.valueOf(ordersHistoryResultSet.getString("orderStatus"));
                        final PaymentMethod paymentMethod = PaymentMethod.valueOf(ordersHistoryResultSet.getString("paymentMethod"));
                        final ShippingMethod shippingMethod = ShippingMethod.valueOf(ordersHistoryResultSet.getString("shippingMethod"));

                        productIdFromOrderPreparedStatement.setString(1, userId);
                        productIdFromOrderPreparedStatement.setTimestamp(2, ordersHistoryResultSet.getTimestamp("date"));

                        final ResultSet productIdFromOrderResultSet = productIdFromOrderPreparedStatement.executeQuery();
                        try {
                            final List<String> productIdList = new ArrayList<String>();
                            while (productIdFromOrderResultSet.next()) {
                                productIdList.add(productIdFromOrderResultSet.getString("productId"));
                            }
                            final Order order = new Order(orderId, productIdList, orderStatus, paymentMethod, shippingMethod, warehouseId);
                            LOGGER.log(Level.INFO, "For userId: " + userId + ", found orderId: " + orderId + ", and order: " + order);
                            orderList.add(order);
                        } finally {
                            productIdFromOrderResultSet.close();
                        }
                    }
                    LOGGER.log(Level.INFO, "For userId " + userId + "Order History: " + orderList);
                    return orderList;
                } finally {
                    ordersHistoryResultSet.close();
                }
            } finally {
                ordersHistoryPreparedStatement.close();
                productIdFromOrderPreparedStatement.close();
            }
        } catch (final SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /*** Service 4 ***/

    public boolean isProductAvailable(String productId) {
        try {
            final PreparedStatement isProductAvailablePreparedStatement = connection.prepareStatement(IS_PRODUCT_AVAILABLE);
            try {
                isProductAvailablePreparedStatement.setString(1, productId);
                final ResultSet isProductAvailableResultSet = isProductAvailablePreparedStatement.executeQuery();
                try {
                    if (isProductAvailableResultSet.next()) {
                        final boolean isProductAvailable = isProductAvailableResultSet.getBoolean("productAvailability");
                        LOGGER.log(Level.INFO, "Product with id: " + productId + (isProductAvailable ? " is available " : " is not available"));
                        return isProductAvailable;
                    }
                } finally {
                    isProductAvailableResultSet.close();
                }
            } finally {
                isProductAvailablePreparedStatement.close();
            }
            return false;
        } catch (final SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean bookProduct(String productId) {
        try {
            final PreparedStatement getWhareHouseIdPreparedStatement = connection.prepareStatement(GET_WAREHOUSE_ID);
            final PreparedStatement bookProductPreparedStatement = connection.prepareStatement(BOOK_PRODUCT);
            try {

                getWhareHouseIdPreparedStatement.setString(1, productId);
                final ResultSet getWhareHouseIdResultSet = getWhareHouseIdPreparedStatement.executeQuery();

                String wareHouseId = null;
                if (getWhareHouseIdResultSet.next()) {
                    wareHouseId = getWhareHouseIdResultSet.getString("warehouseId");
                    LOGGER.log(Level.INFO, "For productId: " + productId + " found wareHouseId: " + wareHouseId);
                }

                bookProductPreparedStatement.setString(1, productId);
                bookProductPreparedStatement.setString(2, wareHouseId);
                bookProductPreparedStatement.setBoolean(3, Boolean.TRUE);
                bookProductPreparedStatement.executeUpdate();
                LOGGER.log(Level.INFO, "Booked productId " + productId + " successfully!");
                return true;
            } finally {
                getWhareHouseIdPreparedStatement.close();
                bookProductPreparedStatement.close();
            }
        } catch (final SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean cancelBookProduct(String productId) {
        try {
            final PreparedStatement cancelBookProductPreparedStatement = connection.prepareStatement(CANCEL_BOOK_PRODUCT);
            try {

                cancelBookProductPreparedStatement.setString(1, productId);
                cancelBookProductPreparedStatement.executeUpdate();
                LOGGER.log(Level.INFO, "Canceled booked productId " + productId + " successfully!");
                return true;
            } finally {
                cancelBookProductPreparedStatement.close();
            }
        } catch (final SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /*** Service 5 ***/
    public double cartCost(String orderId) {
        final Cart cart = findCart(orderId);
        double sumPrice = 0;
        for (String productId : cart.getProductId()) {
            final Product product = findProduct(productId);
            sumPrice += product.getPrice();
        }
        LOGGER.log(Level.INFO, "cart costs: " + sumPrice + " euros");
        return sumPrice;
    }

    public boolean chargeCard(String creditId, double cost) {
        try {
            final PreparedStatement creditCardPreparedStatement = connection.prepareStatement(GET_CREDIT_CARD_INFO);
            final PreparedStatement chargeCreditCardPreparedStatement = connection.prepareStatement(UPDATE_CREDIT_CARD);
            try {
                creditCardPreparedStatement.setString(1, creditId);
                final ResultSet creditCardResultSet = creditCardPreparedStatement.executeQuery();
                if (creditCardResultSet.next()) {
                    final String userId = creditCardResultSet.getString("userId");
                    final double currentUserAmount = creditCardResultSet.getDouble("amount");
                    LOGGER.log(Level.INFO, "userId: " + userId + " has " + currentUserAmount + " euros");
                    if (currentUserAmount >= cost) {
                        LOGGER.log(Level.INFO, "Start transaction...");
                        final double decreaseUserAmount = currentUserAmount - cost;
                        chargeCreditCardPreparedStatement.setDouble(1, decreaseUserAmount);
                        chargeCreditCardPreparedStatement.setString(2, creditId);

                        chargeCreditCardPreparedStatement.executeUpdate();

                        LOGGER.log(Level.INFO, "charge card with id: " + creditId + " successfully finished!");
                        return true;
                    } else {
                        LOGGER.log(Level.INFO, "Error on transaction");
                        return false;
                    }
                } else {
                    LOGGER.log(Level.INFO, "User Not found for creditId: " + creditId);
                    return false;
                }
            } finally {
                creditCardPreparedStatement.close();
                chargeCreditCardPreparedStatement.close();
            }
        } catch (final SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean refund(String creditId, double cost) {
        try {
            final PreparedStatement creditCardPreparedStatement = connection.prepareStatement(GET_CREDIT_CARD_INFO);
            final PreparedStatement refundCreditCardPreparedStatement = connection.prepareStatement(UPDATE_CREDIT_CARD);
            try {
                creditCardPreparedStatement.setString(1, creditId);
                final ResultSet creditCardResultSet = creditCardPreparedStatement.executeQuery();
                if (creditCardResultSet.next()) {
                    final String userId = creditCardResultSet.getString("userId");
                    final double currentUserAmount = creditCardResultSet.getDouble("amount");
                    LOGGER.log(Level.INFO, "userId: " + userId + " has " + currentUserAmount + " euros");
                    LOGGER.log(Level.INFO, "Start transaction...");
                    final double increaseUserAmount = currentUserAmount + cost;
                    refundCreditCardPreparedStatement.setDouble(1, increaseUserAmount);
                    refundCreditCardPreparedStatement.setString(2, creditId);

                    refundCreditCardPreparedStatement.executeUpdate();

                    LOGGER.log(Level.INFO, "refund card with id: " + creditId + " successfully finished!");
                    return true;
                } else {
                    LOGGER.log(Level.INFO, "User Not found for creditId: " + creditId);
                    return false;
                }
            } finally {
                creditCardPreparedStatement.close();
                refundCreditCardPreparedStatement.close();
            }
        } catch (final SQLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("DatabaseManager does not support clone");
    }

    @Override
    protected void finalize() {
        try {
            connection.close();
            connection = null;
        } catch (final SQLException ex) {
            LOGGER.log(Level.SEVERE, "Database connection do not closed", ex);
        }
    }

    public static void main (String [] args) {
        try {
            DatabaseManager.getInstance().findProduct("2125894");
            DatabaseManager.getInstance().findCart("o12345");
            DatabaseManager.getInstance().getCreditCards("12345");
            DatabaseManager.getInstance().getAddresses("54351");
            DatabaseManager.getInstance().getOrderHistory("54321");
            DatabaseManager.getInstance().isProductAvailable("2025356");
            DatabaseManager.getInstance().bookProduct("2025356");
            DatabaseManager.getInstance().cancelBookProduct("2025356");
            final double cost = DatabaseManager.getInstance().cartCost("o12345");
            DatabaseManager.getInstance().chargeCard("qwerty", cost);
            DatabaseManager.getInstance().refund("qwerty", cost);
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }
}
