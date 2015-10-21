
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

    private final static QName _GetCreditCards_QNAME = new QName("http://services.gstam.labisp.tded.di.uoa.gr/", "getCreditCards");
    private final static QName _GetOrderHistory_QNAME = new QName("http://services.gstam.labisp.tded.di.uoa.gr/", "getOrderHistory");
    private final static QName _GetAddressesResponse_QNAME = new QName("http://services.gstam.labisp.tded.di.uoa.gr/", "getAddressesResponse");
    private final static QName _GetCreditCardsResponse_QNAME = new QName("http://services.gstam.labisp.tded.di.uoa.gr/", "getCreditCardsResponse");
    private final static QName _GetOrderHistoryResponse_QNAME = new QName("http://services.gstam.labisp.tded.di.uoa.gr/", "getOrderHistoryResponse");
    private final static QName _IOException_QNAME = new QName("http://services.gstam.labisp.tded.di.uoa.gr/", "IOException");
    private final static QName _GetAddresses_QNAME = new QName("http://services.gstam.labisp.tded.di.uoa.gr/", "getAddresses");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: gr.uoa.di.tded.labisp.gstam.services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreditCard }
     * 
     */
    public CreditCard createCreditCard() {
        return new CreditCard();
    }

    /**
     * Create an instance of {@link GetCreditCards }
     * 
     */
    public GetCreditCards createGetCreditCards() {
        return new GetCreditCards();
    }

    /**
     * Create an instance of {@link GetCreditCardsResponse }
     * 
     */
    public GetCreditCardsResponse createGetCreditCardsResponse() {
        return new GetCreditCardsResponse();
    }

    /**
     * Create an instance of {@link GetOrderHistoryResponse }
     * 
     */
    public GetOrderHistoryResponse createGetOrderHistoryResponse() {
        return new GetOrderHistoryResponse();
    }

    /**
     * Create an instance of {@link Order }
     * 
     */
    public Order createOrder() {
        return new Order();
    }

    /**
     * Create an instance of {@link GetOrderHistory }
     * 
     */
    public GetOrderHistory createGetOrderHistory() {
        return new GetOrderHistory();
    }

    /**
     * Create an instance of {@link IOException }
     * 
     */
    public IOException createIOException() {
        return new IOException();
    }

    /**
     * Create an instance of {@link GetAddressesResponse }
     * 
     */
    public GetAddressesResponse createGetAddressesResponse() {
        return new GetAddressesResponse();
    }

    /**
     * Create an instance of {@link GetAddresses }
     * 
     */
    public GetAddresses createGetAddresses() {
        return new GetAddresses();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCreditCards }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.gstam.labisp.tded.di.uoa.gr/", name = "getCreditCards")
    public JAXBElement<GetCreditCards> createGetCreditCards(GetCreditCards value) {
        return new JAXBElement<GetCreditCards>(_GetCreditCards_QNAME, GetCreditCards.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOrderHistory }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.gstam.labisp.tded.di.uoa.gr/", name = "getOrderHistory")
    public JAXBElement<GetOrderHistory> createGetOrderHistory(GetOrderHistory value) {
        return new JAXBElement<GetOrderHistory>(_GetOrderHistory_QNAME, GetOrderHistory.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAddressesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.gstam.labisp.tded.di.uoa.gr/", name = "getAddressesResponse")
    public JAXBElement<GetAddressesResponse> createGetAddressesResponse(GetAddressesResponse value) {
        return new JAXBElement<GetAddressesResponse>(_GetAddressesResponse_QNAME, GetAddressesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCreditCardsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.gstam.labisp.tded.di.uoa.gr/", name = "getCreditCardsResponse")
    public JAXBElement<GetCreditCardsResponse> createGetCreditCardsResponse(GetCreditCardsResponse value) {
        return new JAXBElement<GetCreditCardsResponse>(_GetCreditCardsResponse_QNAME, GetCreditCardsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOrderHistoryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.gstam.labisp.tded.di.uoa.gr/", name = "getOrderHistoryResponse")
    public JAXBElement<GetOrderHistoryResponse> createGetOrderHistoryResponse(GetOrderHistoryResponse value) {
        return new JAXBElement<GetOrderHistoryResponse>(_GetOrderHistoryResponse_QNAME, GetOrderHistoryResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAddresses }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.gstam.labisp.tded.di.uoa.gr/", name = "getAddresses")
    public JAXBElement<GetAddresses> createGetAddresses(GetAddresses value) {
        return new JAXBElement<GetAddresses>(_GetAddresses_QNAME, GetAddresses.class, null, value);
    }

}
