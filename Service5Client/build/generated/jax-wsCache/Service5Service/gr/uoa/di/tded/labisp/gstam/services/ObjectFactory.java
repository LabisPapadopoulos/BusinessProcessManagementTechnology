
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

    private final static QName _ChargeCardResponse_QNAME = new QName("http://services.gstam.labisp.tded.di.uoa.gr/", "chargeCardResponse");
    private final static QName _Refund_QNAME = new QName("http://services.gstam.labisp.tded.di.uoa.gr/", "refund");
    private final static QName _IOException_QNAME = new QName("http://services.gstam.labisp.tded.di.uoa.gr/", "IOException");
    private final static QName _ChargeCard_QNAME = new QName("http://services.gstam.labisp.tded.di.uoa.gr/", "chargeCard");
    private final static QName _RefundResponse_QNAME = new QName("http://services.gstam.labisp.tded.di.uoa.gr/", "refundResponse");
    private final static QName _CartCostResponse_QNAME = new QName("http://services.gstam.labisp.tded.di.uoa.gr/", "cartCostResponse");
    private final static QName _CartCost_QNAME = new QName("http://services.gstam.labisp.tded.di.uoa.gr/", "cartCost");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: gr.uoa.di.tded.labisp.gstam.services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CartCost }
     * 
     */
    public CartCost createCartCost() {
        return new CartCost();
    }

    /**
     * Create an instance of {@link CartCostResponse }
     * 
     */
    public CartCostResponse createCartCostResponse() {
        return new CartCostResponse();
    }

    /**
     * Create an instance of {@link Refund }
     * 
     */
    public Refund createRefund() {
        return new Refund();
    }

    /**
     * Create an instance of {@link ChargeCardResponse }
     * 
     */
    public ChargeCardResponse createChargeCardResponse() {
        return new ChargeCardResponse();
    }

    /**
     * Create an instance of {@link ChargeCard }
     * 
     */
    public ChargeCard createChargeCard() {
        return new ChargeCard();
    }

    /**
     * Create an instance of {@link RefundResponse }
     * 
     */
    public RefundResponse createRefundResponse() {
        return new RefundResponse();
    }

    /**
     * Create an instance of {@link IOException }
     * 
     */
    public IOException createIOException() {
        return new IOException();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChargeCardResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.gstam.labisp.tded.di.uoa.gr/", name = "chargeCardResponse")
    public JAXBElement<ChargeCardResponse> createChargeCardResponse(ChargeCardResponse value) {
        return new JAXBElement<ChargeCardResponse>(_ChargeCardResponse_QNAME, ChargeCardResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Refund }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.gstam.labisp.tded.di.uoa.gr/", name = "refund")
    public JAXBElement<Refund> createRefund(Refund value) {
        return new JAXBElement<Refund>(_Refund_QNAME, Refund.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link ChargeCard }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.gstam.labisp.tded.di.uoa.gr/", name = "chargeCard")
    public JAXBElement<ChargeCard> createChargeCard(ChargeCard value) {
        return new JAXBElement<ChargeCard>(_ChargeCard_QNAME, ChargeCard.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RefundResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.gstam.labisp.tded.di.uoa.gr/", name = "refundResponse")
    public JAXBElement<RefundResponse> createRefundResponse(RefundResponse value) {
        return new JAXBElement<RefundResponse>(_RefundResponse_QNAME, RefundResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CartCostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.gstam.labisp.tded.di.uoa.gr/", name = "cartCostResponse")
    public JAXBElement<CartCostResponse> createCartCostResponse(CartCostResponse value) {
        return new JAXBElement<CartCostResponse>(_CartCostResponse_QNAME, CartCostResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CartCost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.gstam.labisp.tded.di.uoa.gr/", name = "cartCost")
    public JAXBElement<CartCost> createCartCost(CartCost value) {
        return new JAXBElement<CartCost>(_CartCost_QNAME, CartCost.class, null, value);
    }

}
