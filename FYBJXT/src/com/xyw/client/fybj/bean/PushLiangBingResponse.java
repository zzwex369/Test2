
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
 *         &lt;element name="Push_LiangBingResult" type="{http://schemas.datacontract.org/2004/07/ScreeningSystem.Services}SResult" minOccurs="0"/>
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
    "pushLiangBingResult"
})
@XmlRootElement(name = "Push_LiangBingResponse")
public class PushLiangBingResponse {

    @XmlElementRef(name = "Push_LiangBingResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<SResult> pushLiangBingResult;

    /**
     * Gets the value of the pushLiangBingResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SResult }{@code >}
     *     
     */
    public JAXBElement<SResult> getPushLiangBingResult() {
        return pushLiangBingResult;
    }

    /**
     * Sets the value of the pushLiangBingResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SResult }{@code >}
     *     
     */
    public void setPushLiangBingResult(JAXBElement<SResult> value) {
        this.pushLiangBingResult = value;
    }

}
