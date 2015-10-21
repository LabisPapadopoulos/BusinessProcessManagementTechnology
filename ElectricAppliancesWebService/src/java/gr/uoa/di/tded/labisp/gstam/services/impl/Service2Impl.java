package gr.uoa.di.tded.labisp.gstam.services.impl;

import gr.uoa.di.tded.labisp.gstam.DatabaseManager;
import gr.uoa.di.tded.labisp.gstam.domains.Cart;
import java.io.IOException;


public class Service2Impl {

    private DatabaseManager databaseManager;

    public Service2Impl() throws IOException {
        databaseManager = DatabaseManager.getInstance();
    }

    public Cart findCart(String orderId) {
        return databaseManager.findCart(orderId);
    }
}
