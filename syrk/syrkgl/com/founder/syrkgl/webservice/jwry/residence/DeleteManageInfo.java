
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
 *         &lt;element name="conditionForDeleteManageInfo" type="{http://www.taiji.com.cn/}ConditionForDeleteManageInfo" minOccurs="0"/>
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
    "conditionForDeleteManageInfo"
})
@XmlRootElement(name = "DeleteManageInfo")
public class DeleteManageInfo {

    protected ConditionForDeleteManageInfo conditionForDeleteManageInfo;

    /**
     * Gets the value of the conditionForDeleteManageInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ConditionForDeleteManageInfo }
     *     
     */
    public ConditionForDeleteManageInfo getConditionForDeleteManageInfo() {
        return conditionForDeleteManageInfo;
    }

    /**
     * Sets the value of the conditionForDeleteManageInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConditionForDeleteManageInfo }
     *     
     */
    public void setConditionForDeleteManageInfo(ConditionForDeleteManageInfo value) {
        this.conditionForDeleteManageInfo = value;
    }

}
