
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
 *         &lt;element name="conditionForQueryRecordInfo" type="{http://www.taiji.com.cn/}ConditionForQueryRecordInfo" minOccurs="0"/>
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
    "conditionForQueryRecordInfo"
})
@XmlRootElement(name = "QueryRecordInfo")
public class QueryRecordInfo {

    protected ConditionForQueryRecordInfo conditionForQueryRecordInfo;

    /**
     * Gets the value of the conditionForQueryRecordInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ConditionForQueryRecordInfo }
     *     
     */
    public ConditionForQueryRecordInfo getConditionForQueryRecordInfo() {
        return conditionForQueryRecordInfo;
    }

    /**
     * Sets the value of the conditionForQueryRecordInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConditionForQueryRecordInfo }
     *     
     */
    public void setConditionForQueryRecordInfo(ConditionForQueryRecordInfo value) {
        this.conditionForQueryRecordInfo = value;
    }

}
