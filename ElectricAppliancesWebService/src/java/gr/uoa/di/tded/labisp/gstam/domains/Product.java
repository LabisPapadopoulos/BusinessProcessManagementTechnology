package gr.uoa.di.tded.labisp.gstam.domains;

import java.io.Serializable;


public class Product implements Serializable {
    private String productId;
    private String name;
    private String category;
    private double price;
    private String description;
    private Boolean availability;

    public Product() {}

    public Product(final String productId, final String name, final String category,
            final double price, final String description, final Boolean availability) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.price = price;
        this.description = description;
        this.availability = availability;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(final Boolean availability) {
        this.availability = availability;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(final String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(final double price) {
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(final String productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(final Object object) {
        return (object instanceof Product) && productId.equals(((Product)object).productId);
    }

    @Override
    public int hashCode() {
        return name == null ? 0 : name.hashCode();
    }

    @Override
    public String toString() {
        return new StringBuilder().
                append(getProductId()).append(", ").
                append(getName()).append(", ").
                append(getCategory()).append(", ").
                append(getPrice()).append(", ").
                append(getDescription()).append(", ").
                append(getAvailability()).toString();
    }
}
