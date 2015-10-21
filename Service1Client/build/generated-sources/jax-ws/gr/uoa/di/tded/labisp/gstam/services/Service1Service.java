
package gr.uoa.di.tded.labisp.gstam.services;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2-hudson-752-
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "Service1Service", targetNamespace = "http://services.gstam.labisp.tded.di.uoa.gr/", wsdlLocation = "file:/C:/Users/Labis/Documents/NetBeansProjects/ElectricAppliancesModule/src/localhost_8080/ElectricAppliancesWebService/Service1Service.wsdl")
public class Service1Service
    extends Service
{

    private final static URL SERVICE1SERVICE_WSDL_LOCATION;
    private final static WebServiceException SERVICE1SERVICE_EXCEPTION;
    private final static QName SERVICE1SERVICE_QNAME = new QName("http://services.gstam.labisp.tded.di.uoa.gr/", "Service1Service");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/C:/Users/Labis/Documents/NetBeansProjects/ElectricAppliancesModule/src/localhost_8080/ElectricAppliancesWebService/Service1Service.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SERVICE1SERVICE_WSDL_LOCATION = url;
        SERVICE1SERVICE_EXCEPTION = e;
    }

    public Service1Service() {
        super(__getWsdlLocation(), SERVICE1SERVICE_QNAME);
    }

    public Service1Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), SERVICE1SERVICE_QNAME, features);
    }

    public Service1Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE1SERVICE_QNAME);
    }

    public Service1Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SERVICE1SERVICE_QNAME, features);
    }

    public Service1Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Service1Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns Service1
     */
    @WebEndpoint(name = "Service1Port")
    public Service1 getService1Port() {
        return super.getPort(new QName("http://services.gstam.labisp.tded.di.uoa.gr/", "Service1Port"), Service1.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Service1
     */
    @WebEndpoint(name = "Service1Port")
    public Service1 getService1Port(WebServiceFeature... features) {
        return super.getPort(new QName("http://services.gstam.labisp.tded.di.uoa.gr/", "Service1Port"), Service1.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SERVICE1SERVICE_EXCEPTION!= null) {
            throw SERVICE1SERVICE_EXCEPTION;
        }
        return SERVICE1SERVICE_WSDL_LOCATION;
    }

}