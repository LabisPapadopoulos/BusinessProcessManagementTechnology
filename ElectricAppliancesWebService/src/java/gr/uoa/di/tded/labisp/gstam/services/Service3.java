package gr.uoa.di.tded.labisp.gstam.services;

import gr.uoa.di.tded.labisp.gstam.services.impl.Service3Impl;
import gr.uoa.di.tded.labisp.gstam.domains.CreditCard;
import gr.uoa.di.tded.labisp.gstam.domains.Order;
import java.io.IOException;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;


@WebService()
public class Service3 {

    @WebMethod(operationName = "getCreditCards")
    public List<CreditCard> getCreditCards(@WebParam(name = "userId") String userId) throws IOException {
        return new Service3Impl().getCreditCards(userId);
    }

    @WebMethod(operationName = "getAddresses")
    public List<String> getAddresses(@WebParam(name = "userId") String userId) throws IOException {
        return new Service3Impl().getAddresses(userId);
    }

    @WebMethod(operationName = "getOrderHistory")
    public List<Order> getOrderHistory(@WebParam(name = "userId") String userId) throws IOException {
        return new Service3Impl().getOrderHistory(userId);
    }
}
