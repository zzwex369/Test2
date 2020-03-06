
package com.xyw.client.fybj.bean;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
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
 *         &lt;element name="SecretKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="model" type="{http://schemas.datacontract.org/2004/07/ScreeningSystem.Services}Model_LiangBing" minOccurs="0"/>
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
    "secretKey",
    "model"
})
@XmlRootElement(name = "Push_LiangBing")
public class PushLiangBing {

    @XmlElementRef(name = "SecretKey", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> secretKey;
    @XmlElementRef(name = "model", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ModelLiangBing> model;

    /**
     * Gets the value of the secretKey property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSecretKey() {
        return secretKey;
    }

    /**
     * Sets the value of the secretKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSecretKey(JAXBElement<String> value) {
        this.secretKey = value;
    }

    /**
     * Gets the value of the model property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ModelLiangBing }{@code >}
     *     
     */
    public JAXBElement<ModelLiangBing> getModel() {
        return model;
    }

    /**
     * Sets the value of the model property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ModelLiangBing }{@code >}
     *     
     */
    public void setModel(JAXBElement<ModelLiangBing> value) {
        this.model = value;
    }

}
