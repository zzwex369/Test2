
package com.xyw.client.henan;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="rk01" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="rk02" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="rk03" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="rk04" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="rk05" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="rk06" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="rk07" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="rk08" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="rk09" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="rk10" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="rk11" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="rk12" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="rk13" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "rk01",
    "rk02",
    "rk03",
    "rk04",
    "rk05",
    "rk06",
    "rk07",
    "rk08",
    "rk09",
    "rk10",
    "rk11",
    "rk12",
    "rk13"
})
@XmlRootElement(name = "rk")
public class Rk {

    protected long rk01;
    @XmlElement(required = true)
    protected String rk02;
    @XmlElement(required = true)
    protected String rk03;
    protected long rk04;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar rk05;
    protected long rk06;
    @XmlElement(required = true)
    protected String rk07;
    @XmlElement(required = true)
    protected String rk08;
    @XmlElement(required = true)
    protected String rk09;
    @XmlElement(required = true)
    protected String rk10;
    @XmlElement(required = true)
    protected String rk11;
    @XmlElement(required = true)
    protected String rk12;
    @XmlElement(required = true)
    protected String rk13;

    /**
     * Gets the value of the rk01 property.
     * 
     */
    public long getRk01() {
        return rk01;
    }

    /**
     * Sets the value of the rk01 property.
     * 
     */
    public void setRk01(long value) {
        this.rk01 = value;
    }

    /**
     * Gets the value of the rk02 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRk02() {
        return rk02;
    }

    /**
     * Sets the value of the rk02 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRk02(String value) {
        this.rk02 = value;
    }

    /**
     * Gets the value of the rk03 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRk03() {
        return rk03;
    }

    /**
     * Sets the value of the rk03 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRk03(String value) {
        this.rk03 = value;
    }

    /**
     * Gets the value of the rk04 property.
     * 
     */
    public long getRk04() {
        return rk04;
    }

    /**
     * Sets the value of the rk04 property.
     * 
     */
    public void setRk04(long value) {
        this.rk04 = value;
    }

    /**
     * Gets the value of the rk05 property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getRk05() {
        return rk05;
    }

    /**
     * Sets the value of the rk05 property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRk05(XMLGregorianCalendar value) {
        this.rk05 = value;
    }

    /**
     * Gets the value of the rk06 property.
     * 
     */
    public long getRk06() {
        return rk06;
    }

    /**
     * Sets the value of the rk06 property.
     * 
     */
    public void setRk06(long value) {
        this.rk06 = value;
    }

    /**
     * Gets the value of the rk07 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRk07() {
        return rk07;
    }

    /**
     * Sets the value of the rk07 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRk07(String value) {
        this.rk07 = value;
    }

    /**
     * Gets the value of the rk08 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRk08() {
        return rk08;
    }

    /**
     * Sets the value of the rk08 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRk08(String value) {
        this.rk08 = value;
    }

    /**
     * Gets the value of the rk09 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRk09() {
        return rk09;
    }

    /**
     * Sets the value of the rk09 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRk09(String value) {
        this.rk09 = value;
    }

    /**
     * Gets the value of the rk10 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRk10() {
        return rk10;
    }

    /**
     * Sets the value of the rk10 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRk10(String value) {
        this.rk10 = value;
    }

    /**
     * Gets the value of the rk11 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRk11() {
        return rk11;
    }

    /**
     * Sets the value of the rk11 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRk11(String value) {
        this.rk11 = value;
    }

    /**
     * Gets the value of the rk12 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRk12() {
        return rk12;
    }

    /**
     * Sets the value of the rk12 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRk12(String value) {
        this.rk12 = value;
    }

    /**
     * Gets the value of the rk13 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRk13() {
        return rk13;
    }

    /**
     * Sets the value of the rk13 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRk13(String value) {
        this.rk13 = value;
    }

}
