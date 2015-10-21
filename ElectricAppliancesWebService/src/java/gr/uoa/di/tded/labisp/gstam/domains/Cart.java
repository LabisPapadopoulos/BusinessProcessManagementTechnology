package gr.uoa.di.tded.labisp.gstam.domains;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Cart implements Serializable {
    private String userId;
    private List<String> productId;
    private Map<Product, Integer> productCount;
    private PaymentMethod paymentMethod;
    private String shippingAddress;

    public Cart() {}

    public Cart(final String userId, final List<String> productId, final Map<Product, Integer> productCount,
            final PaymentMethod paymentMethod, final String shippingAddress) {
        this.userId = userId;
        this.productId = productId;
        this.productCount = productCount;
        this.paymentMethod = paymentMethod;
        this.shippingAddress = shippingAddress;
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

    public void setProductId(final List<String> product) {
        this.productId = product;
    }

    public Map<Product, Integer> getProductCount() {
        return productCount;
    }

    public void setProductCount(final Map<Product, Integer> productCount) {
        this.productCount = productCount;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(final String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return new StringBuilder().
                append(getUserId()).append(", ").
                append(getProductId()).append(", ").
                append(getProductCount()).append(", ").
                append(getPaymentMethod()).append(", ").
                append(getShippingAddress()).append(", ")
                .toString();
    }
}
