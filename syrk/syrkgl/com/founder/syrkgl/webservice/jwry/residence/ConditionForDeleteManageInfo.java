
package com.founder.syrkgl.webservice.jwry.residence;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConditionForDeleteManageInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConditionForDeleteManageInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BusinessNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReportOrg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConditionForDeleteManageInfo", propOrder = {
    "businessNO",
    "reportOrg"
})
public class ConditionForDeleteManageInfo {

    @XmlElement(name = "BusinessNO")
    protected String businessNO;
    @XmlElement(name = "ReportOrg")
    protected String reportOrg;

    /**
     * Gets the value of the businessNO property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessNO() {
        return businessNO;
    }

    /**
     * Sets the value of the businessNO property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessNO(String value) {
        this.businessNO = value;
    }

    /**
     * Gets the value of the reportOrg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportOrg() {
        return reportOrg;
    }

    /**
     * Sets the value of the reportOrg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportOrg(String value) {
        this.reportOrg = value;
    }

}
