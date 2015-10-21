package gr.uoa.di.tded.labisp.gstam.services.impl;

import gr.uoa.di.tded.labisp.gstam.DatabaseManager;
import gr.uoa.di.tded.labisp.gstam.domains.CreditCard;
import gr.uoa.di.tded.labisp.gstam.domains.Order;
import java.io.IOException;
import java.util.List;


public class Service3Impl {

    private DatabaseManager databaseManager;

    public Service3Impl() throws IOException {
        databaseManager = DatabaseManager.getInstance();
    }

    public List<CreditCard> getCreditCards(String userId) {
        return databaseManager.getCreditCards(userId);
    }

    public List<String> getAddresses(String userId) {
        return databaseManager.getAddresses(userId);
    }

    public List<Order> getOrderHistory(String userId) {
        return databaseManager.getOrderHistory(userId);
    }
}
