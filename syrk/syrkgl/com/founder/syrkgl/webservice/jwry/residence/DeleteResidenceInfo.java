
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
 *         &lt;element name="conditionFordeleteResidenceInfo" type="{http://www.taiji.com.cn/}ConditionFordeleteResidenceInfo" minOccurs="0"/>
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
    "conditionFordeleteResidenceInfo"
})
@XmlRootElement(name = "DeleteResidenceInfo")
public class DeleteResidenceInfo {

    protected ConditionFordeleteResidenceInfo conditionFordeleteResidenceInfo;

    /**
     * Gets the value of the conditionFordeleteResidenceInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ConditionFordeleteResidenceInfo }
     *     
     */
    public ConditionFordeleteResidenceInfo getConditionFordeleteResidenceInfo() {
        return conditionFordeleteResidenceInfo;
    }

    /**
     * Sets the value of the conditionFordeleteResidenceInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConditionFordeleteResidenceInfo }
     *     
     */
    public void setConditionFordeleteResidenceInfo(ConditionFordeleteResidenceInfo value) {
        this.conditionFordeleteResidenceInfo = value;
    }

}
