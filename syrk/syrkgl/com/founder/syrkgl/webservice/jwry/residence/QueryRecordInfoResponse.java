
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
 *         &lt;element name="QueryRecordInfoResult" type="{http://www.taiji.com.cn/}RecordInfo" minOccurs="0"/>
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
    "queryRecordInfoResult"
})
@XmlRootElement(name = "QueryRecordInfoResponse")
public class QueryRecordInfoResponse {

    @XmlElement(name = "QueryRecordInfoResult")
    protected RecordInfo queryRecordInfoResult;

    /**
     * Gets the value of the queryRecordInfoResult property.
     * 
     * @return
     *     possible object is
     *     {@link RecordInfo }
     *     
     */
    public RecordInfo getQueryRecordInfoResult() {
        return queryRecordInfoResult;
    }

    /**
     * Sets the value of the queryRecordInfoResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link RecordInfo }
     *     
     */
    public void setQueryRecordInfoResult(RecordInfo value) {
        this.queryRecordInfoResult = value;
    }

}
