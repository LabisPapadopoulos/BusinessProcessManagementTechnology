package gr.uoa.di.tded.labisp.gstam.services;

import gr.uoa.di.tded.labisp.gstam.services.impl.Service2Impl;
import gr.uoa.di.tded.labisp.gstam.domains.Cart;
import java.io.IOException;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;


@WebService()
public class Service2 {

    @WebMethod(operationName = "findCart")
    public Cart findCart(@WebParam(name = "orderId") String orderId) throws IOException {
        return new Service2Impl().findCart(orderId);
    }
}
