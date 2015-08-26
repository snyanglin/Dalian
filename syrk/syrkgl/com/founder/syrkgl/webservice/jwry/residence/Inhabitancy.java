
package com.founder.syrkgl.webservice.jwry.residence;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Inhabitancy complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Inhabitancy">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PersonNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DataSource" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InhabiBusinessNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InhabiVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InhabiResidence" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InhabiPoliceStation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InhabiPoliceStationName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InhabiDetailAddr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InhabiState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HouseOwner" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Gender" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PaperNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Workplace" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Tel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HouseType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InhabiOriStateTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InhabiStateTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CurrValidState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ArchiveUnitType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ArchiveUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RegOrgName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RegTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Regperson" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InhabiWay" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InhabiChecked" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Remarks" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "Inhabitancy", propOrder = {
    "personNO",
    "dataSource",
    "inhabiBusinessNO",
    "inhabiVersion",
    "inhabiResidence",
    "inhabiPoliceStation",
    "inhabiPoliceStationName",
    "inhabiDetailAddr",
    "inhabiState",
    "houseOwner",
    "gender",
    "paperNo",
    "workplace",
    "tel",
    "houseType",
    "inhabiOriStateTime",
    "inhabiStateTime",
    "currValidState",
    "archiveUnitType",
    "archiveUnit",
    "regOrgName",
    "regTime",
    "regperson",
    "inhabiWay",
    "inhabiChecked",
    "remarks",
    "create"
})
public class Inhabitancy {

    @XmlElement(name = "PersonNO")
    protected String personNO;
    @XmlElement(name = "DataSource")
    protected String dataSource;
    @XmlElement(name = "InhabiBusinessNO")
    protected String inhabiBusinessNO;
    @XmlElement(name = "InhabiVersion")
    protected String inhabiVersion;
    @XmlElement(name = "InhabiResidence")
    protected String inhabiResidence;
    @XmlElement(name = "InhabiPoliceStation")
    protected String inhabiPoliceStation;
    @XmlElement(name = "InhabiPoliceStationName")
    protected String inhabiPoliceStationName;
    @XmlElement(name = "InhabiDetailAddr")
    protected String inhabiDetailAddr;
    @XmlElement(name = "InhabiState")
    protected String inhabiState;
    @XmlElement(name = "HouseOwner")
    protected String houseOwner;
    @XmlElement(name = "Gender")
    protected String gender;
    @XmlElement(name = "PaperNo")
    protected String paperNo;
    @XmlElement(name = "Workplace")
    protected String workplace;
    @XmlElement(name = "Tel")
    protected String tel;
    @XmlElement(name = "HouseType")
    protected String houseType;
    @XmlElement(name = "InhabiOriStateTime")
    protected String inhabiOriStateTime;
    @XmlElement(name = "InhabiStateTime")
    protected String inhabiStateTime;
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
    @XmlElement(name = "Regperson")
    protected String regperson;
    @XmlElement(name = "InhabiWay")
    protected String inhabiWay;
    @XmlElement(name = "InhabiChecked")
    protected String inhabiChecked;
    @XmlElement(name = "Remarks")
    protected String remarks;
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
     * Gets the value of the inhabiVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInhabiVersion() {
        return inhabiVersion;
    }

    /**
     * Sets the value of the inhabiVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInhabiVersion(String value) {
        this.inhabiVersion = value;
    }

    /**
     * Gets the value of the inhabiResidence property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInhabiResidence() {
        return inhabiResidence;
    }

    /**
     * Sets the value of the inhabiResidence property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInhabiResidence(String value) {
        this.inhabiResidence = value;
    }

    /**
     * Gets the value of the inhabiPoliceStation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInhabiPoliceStation() {
        return inhabiPoliceStation;
    }

    /**
     * Sets the value of the inhabiPoliceStation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInhabiPoliceStation(String value) {
        this.inhabiPoliceStation = value;
    }

    /**
     * Gets the value of the inhabiPoliceStationName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInhabiPoliceStationName() {
        return inhabiPoliceStationName;
    }

    /**
     * Sets the value of the inhabiPoliceStationName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInhabiPoliceStationName(String value) {
        this.inhabiPoliceStationName = value;
    }

    /**
     * Gets the value of the inhabiDetailAddr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInhabiDetailAddr() {
        return inhabiDetailAddr;
    }

    /**
     * Sets the value of the inhabiDetailAddr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInhabiDetailAddr(String value) {
        this.inhabiDetailAddr = value;
    }

    /**
     * Gets the value of the inhabiState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInhabiState() {
        return inhabiState;
    }

    /**
     * Sets the value of the inhabiState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInhabiState(String value) {
        this.inhabiState = value;
    }

    /**
     * Gets the value of the houseOwner property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHouseOwner() {
        return houseOwner;
    }

    /**
     * Sets the value of the houseOwner property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHouseOwner(String value) {
        this.houseOwner = value;
    }

    /**
     * Gets the value of the gender property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the value of the gender property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGender(String value) {
        this.gender = value;
    }

    /**
     * Gets the value of the paperNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaperNo() {
        return paperNo;
    }

    /**
     * Sets the value of the paperNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaperNo(String value) {
        this.paperNo = value;
    }

    /**
     * Gets the value of the workplace property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkplace() {
        return workplace;
    }

    /**
     * Sets the value of the workplace property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkplace(String value) {
        this.workplace = value;
    }

    /**
     * Gets the value of the tel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTel() {
        return tel;
    }

    /**
     * Sets the value of the tel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTel(String value) {
        this.tel = value;
    }

    /**
     * Gets the value of the houseType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHouseType() {
        return houseType;
    }

    /**
     * Sets the value of the houseType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHouseType(String value) {
        this.houseType = value;
    }

    /**
     * Gets the value of the inhabiOriStateTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInhabiOriStateTime() {
        return inhabiOriStateTime;
    }

    /**
     * Sets the value of the inhabiOriStateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInhabiOriStateTime(String value) {
        this.inhabiOriStateTime = value;
    }

    /**
     * Gets the value of the inhabiStateTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInhabiStateTime() {
        return inhabiStateTime;
    }

    /**
     * Sets the value of the inhabiStateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInhabiStateTime(String value) {
        this.inhabiStateTime = value;
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
     * Gets the value of the regperson property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegperson() {
        return regperson;
    }

    /**
     * Sets the value of the regperson property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegperson(String value) {
        this.regperson = value;
    }

    /**
     * Gets the value of the inhabiWay property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInhabiWay() {
        return inhabiWay;
    }

    /**
     * Sets the value of the inhabiWay property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInhabiWay(String value) {
        this.inhabiWay = value;
    }

    /**
     * Gets the value of the inhabiChecked property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInhabiChecked() {
        return inhabiChecked;
    }

    /**
     * Sets the value of the inhabiChecked property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInhabiChecked(String value) {
        this.inhabiChecked = value;
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
