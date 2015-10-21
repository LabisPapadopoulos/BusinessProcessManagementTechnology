
package gr.uoa.di.tded.labisp.gstam.services;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for paymentMethod.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="paymentMethod">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CASH"/>
 *     &lt;enumeration value="BANK_PAY"/>
 *     &lt;enumeration value="CREDIT_CARD"/>
 *     &lt;enumeration value="PAYPAL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "paymentMethod")
@XmlEnum
public enum PaymentMethod {

    CASH,
    BANK_PAY,
    CREDIT_CARD,
    PAYPAL;

    public String value() {
        return name();
    }

    public static PaymentMethod fromValue(String v) {
        return valueOf(v);
    }

}
