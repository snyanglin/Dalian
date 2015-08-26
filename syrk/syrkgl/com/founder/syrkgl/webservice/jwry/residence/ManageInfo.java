
package com.founder.syrkgl.webservice.jwry.residence;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ManageInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ManageInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PersonNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BusinessNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DataSource" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InfoType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InfoTitle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InfoDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReportOrgName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReportPersonName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReportDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Create" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
@XmlType(name = "ManageInfo", propOrder = {
    "personNO",
    "businessNO",
    "dataSource",
    "infoType",
    "infoTitle",
    "infoDesc",
    "reportOrgName",
    "reportPersonName",
    "reportDate",
    "create",
    "reportOrg"
})
public class ManageInfo {

    @XmlElement(name = "PersonNO")
    protected String personNO;
    @XmlElement(name = "BusinessNO")
    protected String businessNO;
    @XmlElement(name = "DataSource")
    protected String dataSource;
    @XmlElement(name = "InfoType")
    protected String infoType;
    @XmlElement(name = "InfoTitle")
    protected String infoTitle;
    @XmlElement(name = "InfoDesc")
    protected String infoDesc;
    @XmlElement(name = "ReportOrgName")
    protected String reportOrgName;
    @XmlElement(name = "ReportPersonName")
    protected String reportPersonName;
    @XmlElement(name = "ReportDate")
    protected String reportDate;
    @XmlElement(name = "Create")
    protected boolean create;
    @XmlElement(name = "ReportOrg")
    protected String reportOrg;

    /**
     * Gets the value of the personNO property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPersonNO() {
        return personNO;
    }

    /**
     * Sets the value of the personNO property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPersonNO(String value) {
        this.personNO = value;
    }

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
     * Gets the value of the infoType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInfoType() {
        return infoType;
    }

    /**
     * Sets the value of the infoType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInfoType(String value) {
        this.infoType = value;
    }

    /**
     * Gets the value of the infoTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInfoTitle() {
        return infoTitle;
    }

    /**
     * Sets the value of the infoTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInfoTitle(String value) {
        this.infoTitle = value;
    }

    /**
     * Gets the value of the infoDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInfoDesc() {
        return infoDesc;
    }

    /**
     * Sets the value of the infoDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInfoDesc(String value) {
        this.infoDesc = value;
    }

    /**
     * Gets the value of the reportOrgName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportOrgName() {
        return reportOrgName;
    }

    /**
     * Sets the value of the reportOrgName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportOrgName(String value) {
        this.reportOrgName = value;
    }

    /**
     * Gets the value of the reportPersonName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportPersonName() {
        return reportPersonName;
    }

    /**
     * Sets the value of the reportPersonName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportPersonName(String value) {
        this.reportPersonName = value;
    }

    /**
     * Gets the value of the reportDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportDate() {
        return reportDate;
    }

    /**
     * Sets the value of the reportDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportDate(String value) {
        this.reportDate = value;
    }

    /**
     * Gets the value of the create property.
     * 
     */
    public boolean isCreate() {
        return create;
    }

    /**
     * Sets the value of the create property.
     * 
     */
    public void setCreate(boolean value) {
        this.create = value;
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
