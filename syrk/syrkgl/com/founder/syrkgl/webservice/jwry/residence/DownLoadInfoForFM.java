
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
 *         &lt;element name="conditionfordownload" type="{http://www.taiji.com.cn/}ConditionForDownLoad" minOccurs="0"/>
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
    "conditionfordownload"
})
@XmlRootElement(name = "DownLoadInfoForFM")
public class DownLoadInfoForFM {

    protected ConditionForDownLoad conditionfordownload;

    /**
     * Gets the value of the conditionfordownload property.
     * 
     * @return
     *     possible object is
     *     {@link ConditionForDownLoad }
     *     
     */
    public ConditionForDownLoad getConditionfordownload() {
        return conditionfordownload;
    }

    /**
     * Sets the value of the conditionfordownload property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConditionForDownLoad }
     *     
     */
    public void setConditionfordownload(ConditionForDownLoad value) {
        this.conditionfordownload = value;
    }

}
