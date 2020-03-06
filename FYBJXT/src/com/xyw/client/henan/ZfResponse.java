
package com.xyw.client.henan;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for zfResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="zfResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="zf01" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="zf05" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "zfResponse", propOrder = {
    "zf01",
    "zf05",
    "status"
})
public class ZfResponse {

    protected long zf01;
    @XmlElement(required = true)
    protected String zf05;
    protected String status;

    /**
     * Gets the value of the zf01 property.
     * 
     */
    public long getZf01() {
        return zf01;
    }

    /**
     * Sets the value of the zf01 property.
     * 
     */
    public void setZf01(long value) {
        this.zf01 = value;
    }

    /**
     * Gets the value of the zf05 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZf05() {
        return zf05;
    }

    /**
     * Sets the value of the zf05 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZf05(String value) {
        this.zf05 = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

}
