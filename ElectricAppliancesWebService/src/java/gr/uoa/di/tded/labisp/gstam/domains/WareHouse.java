package gr.uoa.di.tded.labisp.gstam.domains;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class WareHouse implements Serializable {
    private String warehouseId;
    private String address;
    private String country;
    private double latitude;
    private double lognitude;
    private Map<String, Boolean> productAvailability;
    private Map<Integer, List<Date>> bookingProduct;
    private Map<Integer, List<Date>> cancelBooking;
    private List<String> products;

    public WareHouse() {}

    public WareHouse(final String warehouseId, final String address, final String country,
            final double latitude, final double lognitude, final Map<String, Boolean> productAvailability,
            final Map<Integer, List<Date>> bookingProduct, final Map<Integer, List<Date>> cancelBooking,
            final List<String> products) {
        this.warehouseId = warehouseId;
        this.address = address;
        this.country = country;
        this.latitude = latitude;
        this.lognitude = lognitude;
        this.productAvailability = productAvailability;
        this.bookingProduct = bookingProduct;
        this.cancelBooking = cancelBooking;
        this.products = products;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public Map<Integer, List<Date>> getBookingProduct() {
        return bookingProduct;
    }

    public void setBookingProduct(final Map<Integer, List<Date>> bookingProduct) {
        this.bookingProduct = bookingProduct;
    }

    public Map<Integer, List<Date>> getCancelBooking() {
        return cancelBooking;
    }

    public void setCancelBooking(final Map<Integer, List<Date>> cancelBooking) {
        this.cancelBooking = cancelBooking;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(final String country) {
        this.country = country;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(final double latitude) {
        this.latitude = latitude;
    }

    public double getLognitude() {
        return lognitude;
    }

    public void setLognitude(final double lognitude) {
        this.lognitude = lognitude;
    }

    public List<String> getProducts() {
        return products;
    }

    public void setProducts(List<String> products) {
        this.products = products;
    }

    public Map<String, Boolean> getProductAvailability() {
        return productAvailability;
    }

    public void setProductAvailability(final Map<String, Boolean> productAvailability) {
        this.productAvailability = productAvailability;
    }

    public String getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(final String warehouseId) {
        this.warehouseId = warehouseId;
    }
}
