
package com.xyw.client.henan;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fm01" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="fm05" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fm65" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "", propOrder = {
    "fm01",
    "fm05",
    "fm65",
    "status"
})
@XmlRootElement(name = "fmResponse")
public class FmResponse {

    protected long fm01;
    @XmlElement(required = true)
    protected String fm05;
    @XmlElement(required = true)
    protected String fm65;
    protected String status;

    /**
     * Gets the value of the fm01 property.
     * 
     */
    public long getFm01() {
        return fm01;
    }

    /**
     * Sets the value of the fm01 property.
     * 
     */
    public void setFm01(long value) {
        this.fm01 = value;
    }

    /**
     * Gets the value of the fm05 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFm05() {
        return fm05;
    }

    /**
     * Sets the value of the fm05 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFm05(String value) {
        this.fm05 = value;
    }

    /**
     * Gets the value of the fm65 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFm65() {
        return fm65;
    }

    /**
     * Sets the value of the fm65 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFm65(String value) {
        this.fm65 = value;
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
