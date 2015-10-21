
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

    private final static QName _BookProduct_QNAME = new QName("http://services.gstam.labisp.tded.di.uoa.gr/", "bookProduct");
    private final static QName _IsProductAvailable_QNAME = new QName("http://services.gstam.labisp.tded.di.uoa.gr/", "isProductAvailable");
    private final static QName _IsProductAvailableResponse_QNAME = new QName("http://services.gstam.labisp.tded.di.uoa.gr/", "isProductAvailableResponse");
    private final static QName _BookProductResponse_QNAME = new QName("http://services.gstam.labisp.tded.di.uoa.gr/", "bookProductResponse");
    private final static QName _IOException_QNAME = new QName("http://services.gstam.labisp.tded.di.uoa.gr/", "IOException");
    private final static QName _CancelBookProduct_QNAME = new QName("http://services.gstam.labisp.tded.di.uoa.gr/", "cancelBookProduct");
    private final static QName _CancelBookProductResponse_QNAME = new QName("http://services.gstam.labisp.tded.di.uoa.gr/", "cancelBookProductResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: gr.uoa.di.tded.labisp.gstam.services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link BookProduct }
     * 
     */
    public BookProduct createBookProduct() {
        return new BookProduct();
    }

    /**
     * Create an instance of {@link BookProductResponse }
     * 
     */
    public BookProductResponse createBookProductResponse() {
        return new BookProductResponse();
    }

    /**
     * Create an instance of {@link CancelBookProduct }
     * 
     */
    public CancelBookProduct createCancelBookProduct() {
        return new CancelBookProduct();
    }

    /**
     * Create an instance of {@link IsProductAvailable }
     * 
     */
    public IsProductAvailable createIsProductAvailable() {
        return new IsProductAvailable();
    }

    /**
     * Create an instance of {@link IsProductAvailableResponse }
     * 
     */
    public IsProductAvailableResponse createIsProductAvailableResponse() {
        return new IsProductAvailableResponse();
    }

    /**
     * Create an instance of {@link CancelBookProductResponse }
     * 
     */
    public CancelBookProductResponse createCancelBookProductResponse() {
        return new CancelBookProductResponse();
    }

    /**
     * Create an instance of {@link IOException }
     * 
     */
    public IOException createIOException() {
        return new IOException();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BookProduct }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.gstam.labisp.tded.di.uoa.gr/", name = "bookProduct")
    public JAXBElement<BookProduct> createBookProduct(BookProduct value) {
        return new JAXBElement<BookProduct>(_BookProduct_QNAME, BookProduct.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsProductAvailable }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.gstam.labisp.tded.di.uoa.gr/", name = "isProductAvailable")
    public JAXBElement<IsProductAvailable> createIsProductAvailable(IsProductAvailable value) {
        return new JAXBElement<IsProductAvailable>(_IsProductAvailable_QNAME, IsProductAvailable.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsProductAvailableResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.gstam.labisp.tded.di.uoa.gr/", name = "isProductAvailableResponse")
    public JAXBElement<IsProductAvailableResponse> createIsProductAvailableResponse(IsProductAvailableResponse value) {
        return new JAXBElement<IsProductAvailableResponse>(_IsProductAvailableResponse_QNAME, IsProductAvailableResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BookProductResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.gstam.labisp.tded.di.uoa.gr/", name = "bookProductResponse")
    public JAXBElement<BookProductResponse> createBookProductResponse(BookProductResponse value) {
        return new JAXBElement<BookProductResponse>(_BookProductResponse_QNAME, BookProductResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelBookProduct }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.gstam.labisp.tded.di.uoa.gr/", name = "cancelBookProduct")
    public JAXBElement<CancelBookProduct> createCancelBookProduct(CancelBookProduct value) {
        return new JAXBElement<CancelBookProduct>(_CancelBookProduct_QNAME, CancelBookProduct.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelBookProductResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.gstam.labisp.tded.di.uoa.gr/", name = "cancelBookProductResponse")
    public JAXBElement<CancelBookProductResponse> createCancelBookProductResponse(CancelBookProductResponse value) {
        return new JAXBElement<CancelBookProductResponse>(_CancelBookProductResponse_QNAME, CancelBookProductResponse.class, null, value);
    }

}
