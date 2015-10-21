package gr.uoa.di.tded.labisp.gstam.domains;

import java.io.Serializable;


public class CreditCard implements Serializable {
    private String creditId;
    private String customer;
    private double amount;

    public CreditCard() {}

    public CreditCard(final String creditId, final String customer, final double amount) {
        this.creditId = creditId;
        this.customer = customer;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getCreditId() {
        return creditId;
    }

    public void setCreditId(String id) {
        this.creditId = id;
    }

    public void increaseAmount(final double plusAmount) {
        this.amount += plusAmount;
    }

    public void decreaseAmount(final double minusAmount) {
        this.amount -= minusAmount;
    }

    @Override
    public boolean equals(final Object object) {
        return (object instanceof CreditCard) && creditId.equals(((CreditCard)object).creditId);
    }

    @Override
    public int hashCode() {
        return creditId == null ? 0 : creditId.hashCode();
    }

    @Override
    public String toString() {
        return new StringBuilder().
                append(getCreditId()).append(", ").
                append(getCustomer()).append(", ").
                append(getAmount()).toString();
    }
}
