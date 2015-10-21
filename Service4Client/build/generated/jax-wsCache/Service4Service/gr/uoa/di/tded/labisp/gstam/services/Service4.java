
package gr.uoa.di.tded.labisp.gstam.services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2-hudson-752-
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Service4", targetNamespace = "http://services.gstam.labisp.tded.di.uoa.gr/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Service4 {


    /**
     * 
     * @param productId
     * @return
     *     returns boolean
     * @throws IOException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "isProductAvailable", targetNamespace = "http://services.gstam.labisp.tded.di.uoa.gr/", className = "gr.uoa.di.tded.labisp.gstam.services.IsProductAvailable")
    @ResponseWrapper(localName = "isProductAvailableResponse", targetNamespace = "http://services.gstam.labisp.tded.di.uoa.gr/", className = "gr.uoa.di.tded.labisp.gstam.services.IsProductAvailableResponse")
    @Action(input = "http://services.gstam.labisp.tded.di.uoa.gr/Service4/isProductAvailableRequest", output = "http://services.gstam.labisp.tded.di.uoa.gr/Service4/isProductAvailableResponse", fault = {
        @FaultAction(className = IOException_Exception.class, value = "http://services.gstam.labisp.tded.di.uoa.gr/Service4/isProductAvailable/Fault/IOException")
    })
    public boolean isProductAvailable(
        @WebParam(name = "productId", targetNamespace = "")
        String productId)
        throws IOException_Exception
    ;

    /**
     * 
     * @param productId
     * @return
     *     returns boolean
     * @throws IOException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "bookProduct", targetNamespace = "http://services.gstam.labisp.tded.di.uoa.gr/", className = "gr.uoa.di.tded.labisp.gstam.services.BookProduct")
    @ResponseWrapper(localName = "bookProductResponse", targetNamespace = "http://services.gstam.labisp.tded.di.uoa.gr/", className = "gr.uoa.di.tded.labisp.gstam.services.BookProductResponse")
    @Action(input = "http://services.gstam.labisp.tded.di.uoa.gr/Service4/bookProductRequest", output = "http://services.gstam.labisp.tded.di.uoa.gr/Service4/bookProductResponse", fault = {
        @FaultAction(className = IOException_Exception.class, value = "http://services.gstam.labisp.tded.di.uoa.gr/Service4/bookProduct/Fault/IOException")
    })
    public boolean bookProduct(
        @WebParam(name = "productId", targetNamespace = "")
        String productId)
        throws IOException_Exception
    ;

    /**
     * 
     * @param productId
     * @return
     *     returns boolean
     * @throws IOException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "cancelBookProduct", targetNamespace = "http://services.gstam.labisp.tded.di.uoa.gr/", className = "gr.uoa.di.tded.labisp.gstam.services.CancelBookProduct")
    @ResponseWrapper(localName = "cancelBookProductResponse", targetNamespace = "http://services.gstam.labisp.tded.di.uoa.gr/", className = "gr.uoa.di.tded.labisp.gstam.services.CancelBookProductResponse")
    @Action(input = "http://services.gstam.labisp.tded.di.uoa.gr/Service4/cancelBookProductRequest", output = "http://services.gstam.labisp.tded.di.uoa.gr/Service4/cancelBookProductResponse", fault = {
        @FaultAction(className = IOException_Exception.class, value = "http://services.gstam.labisp.tded.di.uoa.gr/Service4/cancelBookProduct/Fault/IOException")
    })
    public boolean cancelBookProduct(
        @WebParam(name = "productId", targetNamespace = "")
        String productId)
        throws IOException_Exception
    ;

}