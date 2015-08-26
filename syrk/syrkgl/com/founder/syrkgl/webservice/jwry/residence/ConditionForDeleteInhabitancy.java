
package com.founder.syrkgl.webservice.jwry.residence;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConditionForDeleteInhabitancy complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConditionForDeleteInhabitancy">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="InhabiBusinessNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DataSource" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "ConditionForDeleteInhabitancy", propOrder = {
    "inhabiBusinessNO",
    "dataSource",
    "reportOrg"
})
public class ConditionForDeleteInhabitancy {

    @XmlElement(name = "InhabiBusinessNO")
    protected String inhabiBusinessNO;
    @XmlElement(name = "DataSource")
    protected String dataSource;
    @XmlElement(name = "ReportOrg")
    protected String reportOrg;

    /**
     * Gets the value of the inhabiBusinessNO property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInhabiBusinessNO() {
        return inhabiBusinessNO;
    }

    /**
     * Sets the value of the inhabiBusinessNO property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInhabiBusinessNO(String value) {
        this.inhabiBusinessNO = value;
    }

    /**
     * Gets the value of the dataSource property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataSource() {
        return dataSource;
    }

    /**
     * Sets the value of the dataSource property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataSource(String value) {
        this.dataSource = value;
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
