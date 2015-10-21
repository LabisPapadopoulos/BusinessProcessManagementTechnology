package gr.uoa.di.tded.labisp.gstam.domains;

import java.io.Serializable;
import java.util.List;

public class Store implements Serializable {
    private String storeId;
    private String address;
    private double latitude;
    private double lognitude;
    private String phone;
    private List<String> products;

    public Store() {}

    public Store(final String storeId, final String address, final double latitude, 
            final double lognitude, final String phone, final List<String> products) {
        this.storeId = storeId;
        this.address = address;
        this.latitude = latitude;
        this.lognitude = lognitude;
        this.phone = phone;
        this.products = products;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(final String address) {
        this.address = address;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(final String phone) {
        this.phone = phone;
    }

    public List<String> getProducts() {
        return products;
    }

    public void setProducts(final List<String> products) {
        this.products = products;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(final String storeId) {
        this.storeId = storeId;
    }
}
