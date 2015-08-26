
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
 *         &lt;element name="DownLoadInfoResult" type="{http://www.taiji.com.cn/}ResidenceInfoReturn" minOccurs="0"/>
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
    "downLoadInfoResult"
})
@XmlRootElement(name = "DownLoadInfoResponse")
public class DownLoadInfoResponse {

    @XmlElement(name = "DownLoadInfoResult")
    protected ResidenceInfoReturn downLoadInfoResult;

    /**
     * Gets the value of the downLoadInfoResult property.
     * 
     * @return
     *     possible object is
     *     {@link ResidenceInfoReturn }
     *     
     */
    public ResidenceInfoReturn getDownLoadInfoResult() {
        return downLoadInfoResult;
    }

    /**
     * Sets the value of the downLoadInfoResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResidenceInfoReturn }
     *     
     */
    public void setDownLoadInfoResult(ResidenceInfoReturn value) {
        this.downLoadInfoResult = value;
    }

}
