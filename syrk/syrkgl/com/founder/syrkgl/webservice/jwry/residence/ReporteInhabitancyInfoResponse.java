
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
 *         &lt;element name="ReporteInhabitancyInfoResult" type="{http://www.taiji.com.cn/}OperationReturn" minOccurs="0"/>
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
    "reporteInhabitancyInfoResult"
})
@XmlRootElement(name = "ReporteInhabitancyInfoResponse")
public class ReporteInhabitancyInfoResponse {

    @XmlElement(name = "ReporteInhabitancyInfoResult")
    protected OperationReturn reporteInhabitancyInfoResult;

    /**
     * Gets the value of the reporteInhabitancyInfoResult property.
     * 
     * @return
     *     possible object is
     *     {@link OperationReturn }
     *     
     */
    public OperationReturn getReporteInhabitancyInfoResult() {
        return reporteInhabitancyInfoResult;
    }

    /**
     * Sets the value of the reporteInhabitancyInfoResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link OperationReturn }
     *     
     */
    public void setReporteInhabitancyInfoResult(OperationReturn value) {
        this.reporteInhabitancyInfoResult = value;
    }

}
