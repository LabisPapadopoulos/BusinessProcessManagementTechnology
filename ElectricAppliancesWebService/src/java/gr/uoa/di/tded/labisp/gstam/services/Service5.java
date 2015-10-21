package gr.uoa.di.tded.labisp.gstam.services;

import gr.uoa.di.tded.labisp.gstam.services.impl.Service5Impl;
import java.io.IOException;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;


@WebService()
public class Service5 {

    @WebMethod(operationName = "cartCost")
    public double cartCost(@WebParam(name = "orderId") String orderId) throws IOException {
        return new Service5Impl().cartCost(orderId);
    }

    @WebMethod(operationName = "chargeCard")
    public boolean chargeCard(@WebParam(name = "creditId") String creditId,
                            @WebParam(name = "cost") double cost) throws IOException {
        return new Service5Impl().chargeCard(creditId, cost);
    }

    @WebMethod(operationName = "refund")
    public boolean refund(@WebParam(name = "creditId") String creditId,
            @WebParam(name = "cost") double cost) throws IOException {
        return new Service5Impl().refund(creditId, cost);
    }
}
