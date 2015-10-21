package gr.uoa.di.tded.labisp.gstam.domains;

import java.io.Serializable;
import java.util.List;


public class Order implements Serializable {
    private String orderId;
    private List<String> productId;
    private OrderStatus orderStatus;
    private PaymentMethod paymentMethod;
    private ShippingMethod shippingMethod;
    private String warehouseId;

    public Order() {}

    public Order(final String orderId, final List<String> productId, final OrderStatus orderStatus,
            final PaymentMethod paymentMethod, final ShippingMethod shippingMethod, final String warehouseId) {
        this.orderId = orderId;
        this.productId = productId;
        this.orderStatus = orderStatus;
        this.paymentMethod = paymentMethod;
        this.shippingMethod = shippingMethod;
        this.warehouseId = warehouseId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(final String orderId) {
        this.orderId = orderId;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(final OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(final PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public List<String> getProductId() {
        return productId;
    }

    public void setProductId(final List<String> productId) {
        this.productId = productId;
    }

    public ShippingMethod getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(final ShippingMethod shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public String getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(final String warehouseId) {
        this.warehouseId = warehouseId;
    }

    @Override
    public boolean equals(final Object object) {
        return (object instanceof Order) && orderId.equals(((Order)object).orderId);
    }

    @Override
    public int hashCode() {
        return orderId == null ? 0 : orderId.hashCode();
    }

    @Override
    public String toString() {
        return new StringBuilder().
                append(getOrderId()).append(", ").
                append(getProductId()).append(", ").
                append(getOrderStatus()).append(", ").
                append(getPaymentMethod()).append(", ").
                append(getShippingMethod()).append(", ").
                append(getWarehouseId()).toString();
    }
}
