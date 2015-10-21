
package gr.uoa.di.tded.labisp.gstam.services;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for shippingMethod.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="shippingMethod">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="COURIER"/>
 *     &lt;enumeration value="FROM_STORE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "shippingMethod")
@XmlEnum
public enum ShippingMethod {

    COURIER,
    FROM_STORE;

    public String value() {
        return name();
    }

    public static ShippingMethod fromValue(String v) {
        return valueOf(v);
    }

}
