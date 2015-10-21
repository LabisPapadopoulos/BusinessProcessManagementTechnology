package gr.uoa.di.tded.labisp.gstam.domains;

import java.io.Serializable;
import java.util.List;

public class Users implements Serializable {
    private String userId;
    private String name;
    private String address;
    private String address2;
    private String phoneNumber;
    private String email;
    private Role role;
    private List<CreditCard> creditCart;
    private List<Product> orderHistory;

    public Users() {}

    public Users(final String userId, final String name, final String address, final String address2, 
            final String phoneNumber, final String email, final Role role, final List<CreditCard> creditCart,
            final List<String> savedAddresses, final List<Product> orderHistory) {
        this.userId = userId;
        this.name = name;
        this.address = address;
        this.address2 = address2;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.role = role;
        this.creditCart = creditCart;
        this.orderHistory = orderHistory;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

     public String getAddress2() {
        return address2;
    }

    public void setAddress2(final String address2) {
        this.address2 = address2;
    }

    public List<CreditCard> getCreditCart() {
        return creditCart;
    }

    public void setCreditCart(final List<CreditCard> creditCart) {
        this.creditCart = creditCart;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public List<Product> getOrderHistory() {
        return orderHistory;
    }

    public void setOrderHistory(final List<Product> orderHistory) {
        this.orderHistory = orderHistory;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(final Role role) {
        this.role = role;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(final Object object) {
        return (object instanceof Users) && userId.equals(((Users)object).userId);
    }

    @Override
    public int hashCode() {
        return userId == null ? 0 : userId.hashCode();
    }
}
