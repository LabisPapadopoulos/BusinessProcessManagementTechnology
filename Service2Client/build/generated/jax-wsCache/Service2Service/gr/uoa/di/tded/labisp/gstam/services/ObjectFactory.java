
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

    private final static QName _FindCartResponse_QNAME = new QName("http://services.gstam.labisp.tded.di.uoa.gr/", "findCartResponse");
    private final static QName _IOException_QNAME = new QName("http://services.gstam.labisp.tded.di.uoa.gr/", "IOException");
    private final static QName _FindCart_QNAME = new QName("http://services.gstam.labisp.tded.di.uoa.gr/", "findCart");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: gr.uoa.di.tded.labisp.gstam.services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Cart.ProductCount }
     * 
     */
    public Cart.ProductCount createCartProductCount() {
        return new Cart.ProductCount();
    }

    /**
     * Create an instance of {@link FindCartResponse }
     * 
     */
    public FindCartResponse createFindCartResponse() {
        return new FindCartResponse();
    }

    /**
     * Create an instance of {@link Cart.ProductCount.Entry }
     * 
     */
    public Cart.ProductCount.Entry createCartProductCountEntry() {
        return new Cart.ProductCount.Entry();
    }

    /**
     * Create an instance of {@link IOException }
     * 
     */
    public IOException createIOException() {
        return new IOException();
    }

    /**
     * Create an instance of {@link Cart }
     * 
     */
    public Cart createCart() {
        return new Cart();
    }

    /**
     * Create an instance of {@link Product }
     * 
     */
    public Product createProduct() {
        return new Product();
    }

    /**
     * Create an instance of {@link FindCart }
     * 
     */
    public FindCart createFindCart() {
        return new FindCart();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindCartResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.gstam.labisp.tded.di.uoa.gr/", name = "findCartResponse")
    public JAXBElement<FindCartResponse> createFindCartResponse(FindCartResponse value) {
        return new JAXBElement<FindCartResponse>(_FindCartResponse_QNAME, FindCartResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IOException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.gstam.labisp.tded.di.uoa.gr/", name = "IOException")
    public JAXBElement<IOException> createIOException(IOException value) {
        return new JAXBElement<IOException>(_IOException_QNAME, IOException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindCart }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.gstam.labisp.tded.di.uoa.gr/", name = "findCart")
    public JAXBElement<FindCart> createFindCart(FindCart value) {
        return new JAXBElement<FindCart>(_FindCart_QNAME, FindCart.class, null, value);
    }

}
