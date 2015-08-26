
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
 *         &lt;element name="DeleteInhabitancyResult" type="{http://www.taiji.com.cn/}OperationReturn" minOccurs="0"/>
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
    "deleteInhabitancyResult"
})
@XmlRootElement(name = "DeleteInhabitancyResponse")
public class DeleteInhabitancyResponse {

    @XmlElement(name = "DeleteInhabitancyResult")
    protected OperationReturn deleteInhabitancyResult;

    /**
     * Gets the value of the deleteInhabitancyResult property.
     * 
     * @return
     *     possible object is
     *     {@link OperationReturn }
     *     
     */
    public OperationReturn getDeleteInhabitancyResult() {
        return deleteInhabitancyResult;
    }

    /**
     * Sets the value of the deleteInhabitancyResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link OperationReturn }
     *     
     */
    public void setDeleteInhabitancyResult(OperationReturn value) {
        this.deleteInhabitancyResult = value;
    }

}
