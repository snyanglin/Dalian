
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
 *         &lt;element name="DeleteWorkplaceResult" type="{http://www.taiji.com.cn/}OperationReturn" minOccurs="0"/>
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
    "deleteWorkplaceResult"
})
@XmlRootElement(name = "DeleteWorkplaceResponse")
public class DeleteWorkplaceResponse {

    @XmlElement(name = "DeleteWorkplaceResult")
    protected OperationReturn deleteWorkplaceResult;

    /**
     * Gets the value of the deleteWorkplaceResult property.
     * 
     * @return
     *     possible object is
     *     {@link OperationReturn }
     *     
     */
    public OperationReturn getDeleteWorkplaceResult() {
        return deleteWorkplaceResult;
    }

    /**
     * Sets the value of the deleteWorkplaceResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link OperationReturn }
     *     
     */
    public void setDeleteWorkplaceResult(OperationReturn value) {
        this.deleteWorkplaceResult = value;
    }

}
