
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
 *         &lt;element name="hfb01" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="hfb02" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="hfb03" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hfb04" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hfb05" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hfb06" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hfb07" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hfb08" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hfb09" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hfb10" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hfb11" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hfb12" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hfb13" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hfb14" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hfb15" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hfb16" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hfb17" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hfb18" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hfb19" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hfb20" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hfb21" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hfb22" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hfb23" type="{http://www.w3.org/2001/XMLSchema}date"/>
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
    "hfb02",
    "hfb03",
    "hfb04",
    "hfb05",
    "hfb06",
    "hfb07",
    "hfb08",
    "hfb09",
    "hfb10",
    "hfb11",
    "hfb12",
    "hfb13",
    "hfb14",
    "hfb15",
    "hfb16",
    "hfb17",
    "hfb18",
    "hfb19",
    "hfb20",
    "hfb21",
    "hfb22",
    "hfb23"
})
@XmlRootElement(name = "hfb")
public class Hfb {

    protected long hfb01;
    protected long hfb02;
    @XmlElement(required = true)
    protected String hfb03;
    @XmlElement(required = true)
    protected String hfb04;
    @XmlElement(required = true)
    protected String hfb05;
    @XmlElement(required = true)
    protected String hfb06;
    @XmlElement(required = true)
    protected String hfb07;
    @XmlElement(required = true)
    protected String hfb08;
    @XmlElement(required = true)
    protected String hfb09;
    @XmlElement(required = true)
    protected String hfb10;
    @XmlElement(required = true)
    protected String hfb11;
    @XmlElement(required = true)
    protected String hfb12;
    @XmlElement(required = true)
    protected String hfb13;
    @XmlElement(required = true)
    protected String hfb14;
    @XmlElement(required = true)
    protected String hfb15;
    @XmlElement(required = true)
    protected String hfb16;
    @XmlElement(required = true)
    protected String hfb17;
    @XmlElement(required = true)
    protected String hfb18;
    @XmlElement(required = true)
    protected String hfb19;
    @XmlElement(required = true)
    protected String hfb20;
    @XmlElement(required = true)
    protected String hfb21;
    @XmlElement(required = true)
    protected String hfb22;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar hfb23;

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
     * Gets the value of the hfb02 property.
     * 
     */
    public long getHfb02() {
        return hfb02;
    }

    /**
     * Sets the value of the hfb02 property.
     * 
     */
    public void setHfb02(long value) {
        this.hfb02 = value;
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
     * Gets the value of the hfb05 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHfb05() {
        return hfb05;
    }

    /**
     * Sets the value of the hfb05 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHfb05(String value) {
        this.hfb05 = value;
    }

    /**
     * Gets the value of the hfb06 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHfb06() {
        return hfb06;
    }

    /**
     * Sets the value of the hfb06 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHfb06(String value) {
        this.hfb06 = value;
    }

    /**
     * Gets the value of the hfb07 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHfb07() {
        return hfb07;
    }

    /**
     * Sets the value of the hfb07 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHfb07(String value) {
        this.hfb07 = value;
    }

    /**
     * Gets the value of the hfb08 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHfb08() {
        return hfb08;
    }

    /**
     * Sets the value of the hfb08 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHfb08(String value) {
        this.hfb08 = value;
    }

    /**
     * Gets the value of the hfb09 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHfb09() {
        return hfb09;
    }

    /**
     * Sets the value of the hfb09 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHfb09(String value) {
        this.hfb09 = value;
    }

    /**
     * Gets the value of the hfb10 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHfb10() {
        return hfb10;
    }

    /**
     * Sets the value of the hfb10 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHfb10(String value) {
        this.hfb10 = value;
    }

    /**
     * Gets the value of the hfb11 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHfb11() {
        return hfb11;
    }

    /**
     * Sets the value of the hfb11 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHfb11(String value) {
        this.hfb11 = value;
    }

    /**
     * Gets the value of the hfb12 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHfb12() {
        return hfb12;
    }

    /**
     * Sets the value of the hfb12 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHfb12(String value) {
        this.hfb12 = value;
    }

    /**
     * Gets the value of the hfb13 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHfb13() {
        return hfb13;
    }

    /**
     * Sets the value of the hfb13 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHfb13(String value) {
        this.hfb13 = value;
    }

    /**
     * Gets the value of the hfb14 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHfb14() {
        return hfb14;
    }

    /**
     * Sets the value of the hfb14 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHfb14(String value) {
        this.hfb14 = value;
    }

    /**
     * Gets the value of the hfb15 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHfb15() {
        return hfb15;
    }

    /**
     * Sets the value of the hfb15 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHfb15(String value) {
        this.hfb15 = value;
    }

    /**
     * Gets the value of the hfb16 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHfb16() {
        return hfb16;
    }

    /**
     * Sets the value of the hfb16 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHfb16(String value) {
        this.hfb16 = value;
    }

    /**
     * Gets the value of the hfb17 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHfb17() {
        return hfb17;
    }

    /**
     * Sets the value of the hfb17 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHfb17(String value) {
        this.hfb17 = value;
    }

    /**
     * Gets the value of the hfb18 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHfb18() {
        return hfb18;
    }

    /**
     * Sets the value of the hfb18 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHfb18(String value) {
        this.hfb18 = value;
    }

    /**
     * Gets the value of the hfb19 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHfb19() {
        return hfb19;
    }

    /**
     * Sets the value of the hfb19 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHfb19(String value) {
        this.hfb19 = value;
    }

    /**
     * Gets the value of the hfb20 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHfb20() {
        return hfb20;
    }

    /**
     * Sets the value of the hfb20 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHfb20(String value) {
        this.hfb20 = value;
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
     * Gets the value of the hfb23 property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getHfb23() {
        return hfb23;
    }

    /**
     * Sets the value of the hfb23 property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setHfb23(XMLGregorianCalendar value) {
        this.hfb23 = value;
    }

}
