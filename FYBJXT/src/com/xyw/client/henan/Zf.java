
package com.xyw.client.henan;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for zf complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="zf">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="zf01" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="zf02" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="zf03" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="zf04" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="zf05" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="zf06" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="zf07" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="zf08" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="zf09" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="zf10" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="zf11" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="zf12" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="zf13" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="zf14" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="zf15" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="zf16" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="zf17" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="zf18" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="zf19" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="zf20" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="zf21" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="zf22" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="zf23" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="zf24" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="zf25" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "zf", propOrder = {
    "zf01",
    "zf02",
    "zf03",
    "zf04",
    "zf05",
    "zf06",
    "zf07",
    "zf08",
    "zf09",
    "zf10",
    "zf11",
    "zf12",
    "zf13",
    "zf14",
    "zf15",
    "zf16",
    "zf17",
    "zf18",
    "zf19",
    "zf20",
    "zf21",
    "zf22",
    "zf23",
    "zf24",
    "zf25"
})
public class Zf {

    protected long zf01;
    @XmlElement(required = true)
    protected String zf02;
    @XmlElement(required = true)
    protected String zf03;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar zf04;
    @XmlElement(required = true)
    protected String zf05;
    @XmlElement(required = true)
    protected String zf06;
    @XmlElement(required = true)
    protected String zf07;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar zf08;
    @XmlElement(required = true)
    protected String zf09;
    @XmlElement(required = true)
    protected String zf10;
    @XmlElement(required = true)
    protected String zf11;
    @XmlElement(required = true)
    protected String zf12;
    @XmlElement(required = true)
    protected String zf13;
    protected long zf14;
    @XmlElement(required = true)
    protected String zf15;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar zf16;
    @XmlElement(required = true)
    protected String zf17;
    @XmlElement(required = true)
    protected String zf18;
    @XmlElement(required = true)
    protected String zf19;
    @XmlElement(required = true)
    protected String zf20;
    @XmlElement(required = true)
    protected String zf21;
    @XmlElement(required = true)
    protected String zf22;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar zf23;
    @XmlElement(required = true)
    protected String zf24;
    @XmlElement(required = true)
    protected String zf25;

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
     * Gets the value of the zf02 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZf02() {
        return zf02;
    }

    /**
     * Sets the value of the zf02 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZf02(String value) {
        this.zf02 = value;
    }

    /**
     * Gets the value of the zf03 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZf03() {
        return zf03;
    }

    /**
     * Sets the value of the zf03 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZf03(String value) {
        this.zf03 = value;
    }

    /**
     * Gets the value of the zf04 property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getZf04() {
        return zf04;
    }

    /**
     * Sets the value of the zf04 property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setZf04(XMLGregorianCalendar value) {
        this.zf04 = value;
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
     * Gets the value of the zf06 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZf06() {
        return zf06;
    }

    /**
     * Sets the value of the zf06 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZf06(String value) {
        this.zf06 = value;
    }

    /**
     * Gets the value of the zf07 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZf07() {
        return zf07;
    }

    /**
     * Sets the value of the zf07 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZf07(String value) {
        this.zf07 = value;
    }

    /**
     * Gets the value of the zf08 property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getZf08() {
        return zf08;
    }

    /**
     * Sets the value of the zf08 property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setZf08(XMLGregorianCalendar value) {
        this.zf08 = value;
    }

    /**
     * Gets the value of the zf09 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZf09() {
        return zf09;
    }

    /**
     * Sets the value of the zf09 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZf09(String value) {
        this.zf09 = value;
    }

    /**
     * Gets the value of the zf10 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZf10() {
        return zf10;
    }

    /**
     * Sets the value of the zf10 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZf10(String value) {
        this.zf10 = value;
    }

    /**
     * Gets the value of the zf11 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZf11() {
        return zf11;
    }

    /**
     * Sets the value of the zf11 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZf11(String value) {
        this.zf11 = value;
    }

    /**
     * Gets the value of the zf12 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZf12() {
        return zf12;
    }

    /**
     * Sets the value of the zf12 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZf12(String value) {
        this.zf12 = value;
    }

    /**
     * Gets the value of the zf13 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZf13() {
        return zf13;
    }

    /**
     * Sets the value of the zf13 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZf13(String value) {
        this.zf13 = value;
    }

    /**
     * Gets the value of the zf14 property.
     * 
     */
    public long getZf14() {
        return zf14;
    }

    /**
     * Sets the value of the zf14 property.
     * 
     */
    public void setZf14(long value) {
        this.zf14 = value;
    }

    /**
     * Gets the value of the zf15 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZf15() {
        return zf15;
    }

    /**
     * Sets the value of the zf15 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZf15(String value) {
        this.zf15 = value;
    }

    /**
     * Gets the value of the zf16 property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getZf16() {
        return zf16;
    }

    /**
     * Sets the value of the zf16 property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setZf16(XMLGregorianCalendar value) {
        this.zf16 = value;
    }

    /**
     * Gets the value of the zf17 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZf17() {
        return zf17;
    }

    /**
     * Sets the value of the zf17 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZf17(String value) {
        this.zf17 = value;
    }

    /**
     * Gets the value of the zf18 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZf18() {
        return zf18;
    }

    /**
     * Sets the value of the zf18 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZf18(String value) {
        this.zf18 = value;
    }

    /**
     * Gets the value of the zf19 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZf19() {
        return zf19;
    }

    /**
     * Sets the value of the zf19 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZf19(String value) {
        this.zf19 = value;
    }

    /**
     * Gets the value of the zf20 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZf20() {
        return zf20;
    }

    /**
     * Sets the value of the zf20 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZf20(String value) {
        this.zf20 = value;
    }

    /**
     * Gets the value of the zf21 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZf21() {
        return zf21;
    }

    /**
     * Sets the value of the zf21 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZf21(String value) {
        this.zf21 = value;
    }

    /**
     * Gets the value of the zf22 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZf22() {
        return zf22;
    }

    /**
     * Sets the value of the zf22 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZf22(String value) {
        this.zf22 = value;
    }

    /**
     * Gets the value of the zf23 property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getZf23() {
        return zf23;
    }

    /**
     * Sets the value of the zf23 property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setZf23(XMLGregorianCalendar value) {
        this.zf23 = value;
    }

    /**
     * Gets the value of the zf24 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZf24() {
        return zf24;
    }

    /**
     * Sets the value of the zf24 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZf24(String value) {
        this.zf24 = value;
    }

    /**
     * Gets the value of the zf25 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZf25() {
        return zf25;
    }

    /**
     * Sets the value of the zf25 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZf25(String value) {
        this.zf25 = value;
    }

}
