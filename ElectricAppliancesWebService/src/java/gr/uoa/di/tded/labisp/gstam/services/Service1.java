package gr.uoa.di.tded.labisp.gstam.services;

import gr.uoa.di.tded.labisp.gstam.services.impl.Service1Impl;
import gr.uoa.di.tded.labisp.gstam.domains.Product;
import java.io.IOException;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;


@WebService()
public class Service1 {

    @WebMethod(operationName = "findProduct")
    public Product findProduct(@WebParam(name = "productId") String productId) throws IOException {
        return new Service1Impl().findProduct(productId);
    }
}
