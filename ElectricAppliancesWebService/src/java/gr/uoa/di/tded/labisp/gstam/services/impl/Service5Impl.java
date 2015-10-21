package gr.uoa.di.tded.labisp.gstam.services.impl;

import gr.uoa.di.tded.labisp.gstam.DatabaseManager;
import java.io.IOException;


public class Service5Impl {

    private DatabaseManager databaseManager;

    public Service5Impl() throws IOException {
        databaseManager = DatabaseManager.getInstance();
    }

    public double cartCost(String orderId) {
        return databaseManager.cartCost(orderId);
    }

    public boolean chargeCard(String creditId, double cost) {
        return databaseManager.chargeCard(creditId, cost);
    }

    public boolean refund(String creditId, double cost) {
        return databaseManager.refund(creditId, cost);
    }
}
