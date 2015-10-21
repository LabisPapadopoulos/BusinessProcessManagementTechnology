package gr.uoa.di.tded.labisp.gstam.services.impl;

import gr.uoa.di.tded.labisp.gstam.DatabaseManager;
import gr.uoa.di.tded.labisp.gstam.domains.Product;
import java.io.IOException;


public class Service1Impl {

    private DatabaseManager databaseManager;

    public Service1Impl() throws IOException {
        databaseManager = DatabaseManager.getInstance();
    }

    public Product findProduct(String productId) {
        return databaseManager.findProduct(productId);
    }
}
