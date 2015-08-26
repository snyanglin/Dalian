
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
 *         &lt;element name="ReporteManageInfoResult" type="{http://www.taiji.com.cn/}OperationReturn" minOccurs="0"/>
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
    "reporteManageInfoResult"
})
@XmlRootElement(name = "ReporteManageInfoResponse")
public class ReporteManageInfoResponse {

    @XmlElement(name = "ReporteManageInfoResult")
    protected OperationReturn reporteManageInfoResult;

    /**
     * Gets the value of the reporteManageInfoResult property.
     * 
     * @return
     *     possible object is
     *     {@link OperationReturn }
     *     
     */
    public OperationReturn getReporteManageInfoResult() {
        return reporteManageInfoResult;
    }

    /**
     * Sets the value of the reporteManageInfoResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link OperationReturn }
     *     
     */
    public void setReporteManageInfoResult(OperationReturn value) {
        this.reporteManageInfoResult = value;
    }

}
