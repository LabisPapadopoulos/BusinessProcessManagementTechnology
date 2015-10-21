
package gr.uoa.di.tded.labisp.gstam.services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the gr.uoa.di.tded.labisp.gstam.services package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FindProductResponse_QNAME = new QName("http://services.gstam.labisp.tded.di.uoa.gr/", "findProductResponse");
    private final static QName _FindProduct_QNAME = new QName("http://services.gstam.labisp.tded.di.uoa.gr/", "findProduct");
    private final static QName _IOException_QNAME = new QName("http://services.gstam.labisp.tded.di.uoa.gr/", "IOException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: gr.uoa.di.tded.labisp.gstam.services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Product }
     * 
     */
    public Product createProduct() {
        return new Product();
    }

    /**
     * Create an instance of {@link FindProduct }
     * 
     */
    public FindProduct createFindProduct() {
        return new FindProduct();
    }

    /**
     * Create an instance of {@link FindProductResponse }
     * 
     */
    public FindProductResponse createFindProductResponse() {
        return new FindProductResponse();
    }

    /**
     * Create an instance of {@link IOException }
     * 
     */
    public IOException createIOException() {
        return new IOException();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindProductResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.gstam.labisp.tded.di.uoa.gr/", name = "findProductResponse")
    public JAXBElement<FindProductResponse> createFindProductResponse(FindProductResponse value) {
        return new JAXBElement<FindProductResponse>(_FindProductResponse_QNAME, FindProductResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindProduct }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.gstam.labisp.tded.di.uoa.gr/", name = "findProduct")
    public JAXBElement<FindProduct> createFindProduct(FindProduct value) {
        return new JAXBElement<FindProduct>(_FindProduct_QNAME, FindProduct.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IOException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.gstam.labisp.tded.di.uoa.gr/", name = "IOException")
    public JAXBElement<IOException> createIOException(IOException value) {
        return new JAXBElement<IOException>(_IOException_QNAME, IOException.class, null, value);
    }

}
