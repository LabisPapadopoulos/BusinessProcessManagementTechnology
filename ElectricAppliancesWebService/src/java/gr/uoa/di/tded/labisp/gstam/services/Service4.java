package gr.uoa.di.tded.labisp.gstam.services;

import gr.uoa.di.tded.labisp.gstam.services.impl.Service4Impl;
import java.io.IOException;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;


@WebService()
public class Service4 {

    @WebMethod(operationName = "isProductAvailable")
    public boolean isProductAvailable(@WebParam(name = "productId") String productId) throws IOException {
        return new Service4Impl().isProductAvailable(productId);
    }

    @WebMethod(operationName = "bookProduct")
    public boolean bookProduct(@WebParam(name = "productId") String productId) throws IOException {
        return new Service4Impl().bookProduct(productId);
    }

    @WebMethod(operationName = "cancelBookProduct")
    public boolean cancelBookProduct(@WebParam(name = "productId") String productId) throws IOException {
        return new Service4Impl().cancelBookProduct(productId);
    }
}
