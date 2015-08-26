
package com.founder.syrkgl.webservice.jwry.residence;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Workplace complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Workplace">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PersonNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DataSource" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WorkplaceBusinessNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RkplaceVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WorkplaceResidence" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WorkplacePoliceStation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WorkplacePoliceStationName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WorkplaceOrgCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WorkplaceName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WorkDegree" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WorkingBeginTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WorkingEndTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WorkingState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WorkingOriStateTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WorkingStateTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CurrValidState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ArchiveUnitType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ArchiveUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RegOrgName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RegTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RegPerson" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WorkChecked" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Remarks" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WorkplaceDetailAddr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Create" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Workplace", propOrder = {
    "personNO",
    "dataSource",
    "workplaceBusinessNO",
    "rkplaceVersion",
    "workplaceResidence",
    "workplacePoliceStation",
    "workplacePoliceStationName",
    "workplaceOrgCode",
    "workplaceName",
    "workDegree",
    "workingBeginTime",
    "workingEndTime",
    "workingState",
    "workingOriStateTime",
    "workingStateTime",
    "currValidState",
    "archiveUnitType",
    "archiveUnit",
    "regOrgName",
    "regTime",
    "regPerson",
    "workChecked",
    "remarks",
    "workplaceDetailAddr",
    "create"
})
public class Workplace {

    @XmlElement(name = "PersonNO")
    protected String personNO;
    @XmlElement(name = "DataSource")
    protected String dataSource;
    @XmlElement(name = "WorkplaceBusinessNO")
    protected String workplaceBusinessNO;
    @XmlElement(name = "RkplaceVersion")
    protected String rkplaceVersion;
    @XmlElement(name = "WorkplaceResidence")
    protected String workplaceResidence;
    @XmlElement(name = "WorkplacePoliceStation")
    protected String workplacePoliceStation;
    @XmlElement(name = "WorkplacePoliceStationName")
    protected String workplacePoliceStationName;
    @XmlElement(name = "WorkplaceOrgCode")
    protected String workplaceOrgCode;
    @XmlElement(name = "WorkplaceName")
    protected String workplaceName;
    @XmlElement(name = "WorkDegree")
    protected String workDegree;
    @XmlElement(name = "WorkingBeginTime")
    protected String workingBeginTime;
    @XmlElement(name = "WorkingEndTime")
    protected String workingEndTime;
    @XmlElement(name = "WorkingState")
    protected String workingState;
    @XmlElement(name = "WorkingOriStateTime")
    protected String workingOriStateTime;
    @XmlElement(name = "WorkingStateTime")
    protected String workingStateTime;
    @XmlElement(name = "CurrValidState")
    protected String currValidState;
    @XmlElement(name = "ArchiveUnitType")
    protected String archiveUnitType;
    @XmlElement(name = "ArchiveUnit")
    protected String archiveUnit;
    @XmlElement(name = "RegOrgName")
    protected String regOrgName;
    @XmlElement(name = "RegTime")
    protected String regTime;
    @XmlElement(name = "RegPerson")
    protected String regPerson;
    @XmlElement(name = "WorkChecked")
    protected String workChecked;
    @XmlElement(name = "Remarks")
    protected String remarks;
    @XmlElement(name = "WorkplaceDetailAddr")
    protected String workplaceDetailAddr;
    @XmlElement(name = "Create")
    protected boolean create;

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
     * Gets the value of the workplaceBusinessNO property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkplaceBusinessNO() {
        return workplaceBusinessNO;
    }

    /**
     * Sets the value of the workplaceBusinessNO property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkplaceBusinessNO(String value) {
        this.workplaceBusinessNO = value;
    }

    /**
     * Gets the value of the rkplaceVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRkplaceVersion() {
        return rkplaceVersion;
    }

    /**
     * Sets the value of the rkplaceVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRkplaceVersion(String value) {
        this.rkplaceVersion = value;
    }

    /**
     * Gets the value of the workplaceResidence property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkplaceResidence() {
        return workplaceResidence;
    }

    /**
     * Sets the value of the workplaceResidence property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkplaceResidence(String value) {
        this.workplaceResidence = value;
    }

    /**
     * Gets the value of the workplacePoliceStation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkplacePoliceStation() {
        return workplacePoliceStation;
    }

    /**
     * Sets the value of the workplacePoliceStation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkplacePoliceStation(String value) {
        this.workplacePoliceStation = value;
    }

    /**
     * Gets the value of the workplacePoliceStationName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkplacePoliceStationName() {
        return workplacePoliceStationName;
    }

    /**
     * Sets the value of the workplacePoliceStationName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkplacePoliceStationName(String value) {
        this.workplacePoliceStationName = value;
    }

    /**
     * Gets the value of the workplaceOrgCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkplaceOrgCode() {
        return workplaceOrgCode;
    }

    /**
     * Sets the value of the workplaceOrgCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkplaceOrgCode(String value) {
        this.workplaceOrgCode = value;
    }

    /**
     * Gets the value of the workplaceName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkplaceName() {
        return workplaceName;
    }

    /**
     * Sets the value of the workplaceName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkplaceName(String value) {
        this.workplaceName = value;
    }

    /**
     * Gets the value of the workDegree property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkDegree() {
        return workDegree;
    }

    /**
     * Sets the value of the workDegree property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkDegree(String value) {
        this.workDegree = value;
    }

    /**
     * Gets the value of the workingBeginTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkingBeginTime() {
        return workingBeginTime;
    }

    /**
     * Sets the value of the workingBeginTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkingBeginTime(String value) {
        this.workingBeginTime = value;
    }

    /**
     * Gets the value of the workingEndTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkingEndTime() {
        return workingEndTime;
    }

    /**
     * Sets the value of the workingEndTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkingEndTime(String value) {
        this.workingEndTime = value;
    }

    /**
     * Gets the value of the workingState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkingState() {
        return workingState;
    }

    /**
     * Sets the value of the workingState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkingState(String value) {
        this.workingState = value;
    }

    /**
     * Gets the value of the workingOriStateTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkingOriStateTime() {
        return workingOriStateTime;
    }

    /**
     * Sets the value of the workingOriStateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkingOriStateTime(String value) {
        this.workingOriStateTime = value;
    }

    /**
     * Gets the value of the workingStateTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkingStateTime() {
        return workingStateTime;
    }

    /**
     * Sets the value of the workingStateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkingStateTime(String value) {
        this.workingStateTime = value;
    }

    /**
     * Gets the value of the currValidState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrValidState() {
        return currValidState;
    }

    /**
     * Sets the value of the currValidState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrValidState(String value) {
        this.currValidState = value;
    }

    /**
     * Gets the value of the archiveUnitType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArchiveUnitType() {
        return archiveUnitType;
    }

    /**
     * Sets the value of the archiveUnitType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArchiveUnitType(String value) {
        this.archiveUnitType = value;
    }

    /**
     * Gets the value of the archiveUnit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArchiveUnit() {
        return archiveUnit;
    }

    /**
     * Sets the value of the archiveUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArchiveUnit(String value) {
        this.archiveUnit = value;
    }

    /**
     * Gets the value of the regOrgName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegOrgName() {
        return regOrgName;
    }

    /**
     * Sets the value of the regOrgName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegOrgName(String value) {
        this.regOrgName = value;
    }

    /**
     * Gets the value of the regTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegTime() {
        return regTime;
    }

    /**
     * Sets the value of the regTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegTime(String value) {
        this.regTime = value;
    }

    /**
     * Gets the value of the regPerson property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegPerson() {
        return regPerson;
    }

    /**
     * Sets the value of the regPerson property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegPerson(String value) {
        this.regPerson = value;
    }

    /**
     * Gets the value of the workChecked property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkChecked() {
        return workChecked;
    }

    /**
     * Sets the value of the workChecked property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkChecked(String value) {
        this.workChecked = value;
    }

    /**
     * Gets the value of the remarks property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * Sets the value of the remarks property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemarks(String value) {
        this.remarks = value;
    }

    /**
     * Gets the value of the workplaceDetailAddr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkplaceDetailAddr() {
        return workplaceDetailAddr;
    }

    /**
     * Sets the value of the workplaceDetailAddr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkplaceDetailAddr(String value) {
        this.workplaceDetailAddr = value;
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

}
