
package com.founder.syrkgl.webservice.jwry.residence;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="conditionforReceiveData" type="{http://www.taiji.com.cn/}ConditionForReceiveData" minOccurs="0"/>
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
    "conditionforReceiveData"
})
@XmlRootElement(name = "ReceiveData")
public class ReceiveData {

    protected ConditionForReceiveData conditionforReceiveData;

    /**
     * Gets the value of the conditionforReceiveData property.
     * 
     * @return
     *     possible object is
     *     {@link ConditionForReceiveData }
     *     
     */
    public ConditionForReceiveData getConditionforReceiveData() {
        return conditionforReceiveData;
    }

    /**
     * Sets the value of the conditionforReceiveData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConditionForReceiveData }
     *     
     */
    public void setConditionforReceiveData(ConditionForReceiveData value) {
        this.conditionforReceiveData = value;
    }

}
