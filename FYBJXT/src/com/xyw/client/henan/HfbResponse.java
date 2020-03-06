
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
 *         &lt;element name="hfb01" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="hfb03" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hfb04" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hfb21" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hfb22" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "hfb01",
    "hfb03",
    "hfb04",
    "hfb21",
    "hfb22",
    "status"
})
@XmlRootElement(name = "hfbResponse")
public class HfbResponse {

    protected long hfb01;
    @XmlElement(required = true)
    protected String hfb03;
    @XmlElement(required = true)
    protected String hfb04;
    @XmlElement(required = true)
    protected String hfb21;
    @XmlElement(required = true)
    protected String hfb22;
    protected String status;

    /**
     * Gets the value of the hfb01 property.
     * 
     */
    public long getHfb01() {
        return hfb01;
    }

    /**
     * Sets the value of the hfb01 property.
     * 
     */
    public void setHfb01(long value) {
        this.hfb01 = value;
    }

    /**
     * Gets the value of the hfb03 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHfb03() {
        return hfb03;
    }

    /**
     * Sets the value of the hfb03 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHfb03(String value) {
        this.hfb03 = value;
    }

    /**
     * Gets the value of the hfb04 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHfb04() {
        return hfb04;
    }

    /**
     * Sets the value of the hfb04 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHfb04(String value) {
        this.hfb04 = value;
    }

    /**
     * Gets the value of the hfb21 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHfb21() {
        return hfb21;
    }

    /**
     * Sets the value of the hfb21 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHfb21(String value) {
        this.hfb21 = value;
    }

    /**
     * Gets the value of the hfb22 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHfb22() {
        return hfb22;
    }

    /**
     * Sets the value of the hfb22 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHfb22(String value) {
        this.hfb22 = value;
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
