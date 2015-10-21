package gr.uoa.di.tded.labisp.gstam.services.impl;

import gr.uoa.di.tded.labisp.gstam.DatabaseManager;
import java.io.IOException;

public class Service4Impl {

    private DatabaseManager databaseManager;

    public Service4Impl() throws IOException {
        databaseManager = DatabaseManager.getInstance();
    }

    public boolean isProductAvailable(String productId) {
        return databaseManager.isProductAvailable(productId);
    }

    public boolean bookProduct(String productId) {
        return databaseManager.bookProduct(productId);
    }

    public boolean cancelBookProduct(String productId) {
        return databaseManager.cancelBookProduct(productId);
    }
}
