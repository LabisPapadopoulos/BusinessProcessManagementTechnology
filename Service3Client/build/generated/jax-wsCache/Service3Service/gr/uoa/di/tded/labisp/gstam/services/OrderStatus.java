
package gr.uoa.di.tded.labisp.gstam.services;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for orderStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="orderStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SUBMITTED"/>
 *     &lt;enumeration value="PENDING"/>
 *     &lt;enumeration value="CANCELED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "orderStatus")
@XmlEnum
public enum OrderStatus {

    SUBMITTED,
    PENDING,
    CANCELED;

    public String value() {
        return name();
    }

    public static OrderStatus fromValue(String v) {
        return valueOf(v);
    }

}
