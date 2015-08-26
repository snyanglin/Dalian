
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
 *         &lt;element name="DownLoadInfoForFMResult" type="{http://www.taiji.com.cn/}ResidenceInfoReturn" minOccurs="0"/>
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
    "downLoadInfoForFMResult"
})
@XmlRootElement(name = "DownLoadInfoForFMResponse")
public class DownLoadInfoForFMResponse {

    @XmlElement(name = "DownLoadInfoForFMResult")
    protected ResidenceInfoReturn downLoadInfoForFMResult;

    /**
     * Gets the value of the downLoadInfoForFMResult property.
     * 
     * @return
     *     possible object is
     *     {@link ResidenceInfoReturn }
     *     
     */
    public ResidenceInfoReturn getDownLoadInfoForFMResult() {
        return downLoadInfoForFMResult;
    }

    /**
     * Sets the value of the downLoadInfoForFMResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResidenceInfoReturn }
     *     
     */
    public void setDownLoadInfoForFMResult(ResidenceInfoReturn value) {
        this.downLoadInfoForFMResult = value;
    }

}
