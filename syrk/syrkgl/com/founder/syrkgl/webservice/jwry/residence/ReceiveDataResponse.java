
package com.founder.syrkgl.webservice.jwry.residence;

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
 *         &lt;element name="ReceiveDataResult" type="{http://www.taiji.com.cn/}OperationReturn" minOccurs="0"/>
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
    "receiveDataResult"
})
@XmlRootElement(name = "ReceiveDataResponse")
public class ReceiveDataResponse {

    @XmlElement(name = "ReceiveDataResult")
    protected OperationReturn receiveDataResult;

    /**
     * Gets the value of the receiveDataResult property.
     * 
     * @return
     *     possible object is
     *     {@link OperationReturn }
     *     
     */
    public OperationReturn getReceiveDataResult() {
        return receiveDataResult;
    }

    /**
     * Sets the value of the receiveDataResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link OperationReturn }
     *     
     */
    public void setReceiveDataResult(OperationReturn value) {
        this.receiveDataResult = value;
    }

}
