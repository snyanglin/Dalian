
package com.founder.syrkgl.webservice.jwry.residence;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ResidenceInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResidenceInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PersonNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DataSource" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InhabiBusinessNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WorkplaceBusinessNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AreaType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SurnameEN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FirstnameEN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NameCH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Gender" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Birthday" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Homeplace" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Nationality" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PaperType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PaperNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SignDay" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExpiredDay" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DegreeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PersonType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ForeignerId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VisaType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="QtyOfParty" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ResideReason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ResidePermitNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ResidePermitAssignDay" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ResidePermitExpiredDay" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LocalizePeriod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AssignmentOrg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ResideContactTel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Remarks" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReportTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReportOrg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReportOrgName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReportPerson" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Photo" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="StudentsInfo" type="{http://www.taiji.com.cn/}StudentsInfo" minOccurs="0"/>
 *         &lt;element name="Reporter" type="{http://www.taiji.com.cn/}ReporterInfo" minOccurs="0"/>
 *         &lt;element name="TogetherPerson" type="{http://www.taiji.com.cn/}ArrayOfTogetherPersonInfo" minOccurs="0"/>
 *         &lt;element name="RelationPerson" type="{http://www.taiji.com.cn/}ArrayOfRelationPerson" minOccurs="0"/>
 *         &lt;element name="CarInfo" type="{http://www.taiji.com.cn/}CarInfo" minOccurs="0"/>
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
@XmlType(name = "ResidenceInfo", propOrder = {
    "personNO",
    "dataSource",
    "inhabiBusinessNO",
    "workplaceBusinessNO",
    "areaType",
    "surnameEN",
    "firstnameEN",
    "nameCH",
    "gender",
    "birthday",
    "homeplace",
    "nationality",
    "paperType",
    "paperNO",
    "signDay",
    "expiredDay",
    "degreeCode",
    "personType",
    "foreignerId",
    "visaType",
    "qtyOfParty",
    "resideReason",
    "residePermitNO",
    "residePermitAssignDay",
    "residePermitExpiredDay",
    "localizePeriod",
    "assignmentOrg",
    "resideContactTel",
    "remarks",
    "reportTime",
    "reportOrg",
    "reportOrgName",
    "reportPerson",
    "photo",
    "studentsInfo",
    "reporter",
    "togetherPerson",
    "relationPerson",
    "carInfo",
    "create",
    "sjzt",
    "sjddrq",
    "inhabiDetailAddr",
    "workplaceDetailAddr"
})
public class ResidenceInfo {

    @XmlElement(name = "PersonNO")
    protected String personNO;
    @XmlElement(name = "DataSource")
    protected String dataSource;
    @XmlElement(name = "InhabiBusinessNO")
    protected String inhabiBusinessNO;
    @XmlElement(name = "WorkplaceBusinessNO")
    protected String workplaceBusinessNO;
    @XmlElement(name = "AreaType")
    protected String areaType;
    @XmlElement(name = "SurnameEN")
    protected String surnameEN;
    @XmlElement(name = "FirstnameEN")
    protected String firstnameEN;
    @XmlElement(name = "NameCH")
    protected String nameCH;
    @XmlElement(name = "Gender")
    protected String gender;
    @XmlElement(name = "Birthday")
    protected String birthday;
    @XmlElement(name = "Homeplace")
    protected String homeplace;
    @XmlElement(name = "Nationality")
    protected String nationality;
    @XmlElement(name = "PaperType")
    protected String paperType;
    @XmlElement(name = "PaperNO")
    protected String paperNO;
    @XmlElement(name = "SignDay")
    protected String signDay;
    @XmlElement(name = "ExpiredDay")
    protected String expiredDay;
    @XmlElement(name = "DegreeCode")
    protected String degreeCode;
    @XmlElement(name = "PersonType")
    protected String personType;
    @XmlElement(name = "ForeignerId")
    protected String foreignerId;
    @XmlElement(name = "VisaType")
    protected String visaType;
    @XmlElement(name = "QtyOfParty")
    protected String qtyOfParty;
    @XmlElement(name = "ResideReason")
    protected String resideReason;
    @XmlElement(name = "ResidePermitNO")
    protected String residePermitNO;
    @XmlElement(name = "ResidePermitAssignDay")
    protected String residePermitAssignDay;
    @XmlElement(name = "ResidePermitExpiredDay")
    protected String residePermitExpiredDay;
    @XmlElement(name = "LocalizePeriod")
    protected String localizePeriod;
    @XmlElement(name = "AssignmentOrg")
    protected String assignmentOrg;
    @XmlElement(name = "ResideContactTel")
    protected String resideContactTel;
    @XmlElement(name = "Remarks")
    protected String remarks;
    @XmlElement(name = "ReportTime")
    protected String reportTime;
    @XmlElement(name = "ReportOrg")
    protected String reportOrg;
    @XmlElement(name = "ReportOrgName")
    protected String reportOrgName;
    @XmlElement(name = "ReportPerson")
    protected String reportPerson;
    @XmlElement(name = "Photo")
    protected byte[] photo;
    @XmlElement(name = "StudentsInfo")
    protected StudentsInfo studentsInfo;
    @XmlElement(name = "Reporter")
    protected ReporterInfo reporter;
    @XmlElement(name = "TogetherPerson")
    protected ArrayOfTogetherPersonInfo togetherPerson;
    @XmlElement(name = "RelationPerson")
    protected ArrayOfRelationPerson relationPerson;
    @XmlElement(name = "CarInfo")
    protected CarInfo carInfo;
    @XmlElement(name = "Create")
    protected boolean create;
    //系统新增字段
    private String sjzt;
    private String sjddrq;
    private String inhabiDetailAddr;
    private String workplaceDetailAddr;
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
     * Gets the value of the areaType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAreaType() {
        return areaType;
    }

    /**
     * Sets the value of the areaType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAreaType(String value) {
        this.areaType = value;
    }

    /**
     * Gets the value of the surnameEN property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSurnameEN() {
        return surnameEN;
    }

    /**
     * Sets the value of the surnameEN property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSurnameEN(String value) {
        this.surnameEN = value;
    }

    /**
     * Gets the value of the firstnameEN property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstnameEN() {
        return firstnameEN;
    }

    /**
     * Sets the value of the firstnameEN property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstnameEN(String value) {
        this.firstnameEN = value;
    }

    /**
     * Gets the value of the nameCH property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameCH() {
        return nameCH;
    }

    /**
     * Sets the value of the nameCH property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameCH(String value) {
        this.nameCH = value;
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
     * Gets the value of the birthday property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * Sets the value of the birthday property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBirthday(String value) {
        this.birthday = value;
    }

    /**
     * Gets the value of the homeplace property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHomeplace() {
        return homeplace;
    }

    /**
     * Sets the value of the homeplace property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHomeplace(String value) {
        this.homeplace = value;
    }

    /**
     * Gets the value of the nationality property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * Sets the value of the nationality property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNationality(String value) {
        this.nationality = value;
    }

    /**
     * Gets the value of the paperType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaperType() {
        return paperType;
    }

    /**
     * Sets the value of the paperType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaperType(String value) {
        this.paperType = value;
    }

    /**
     * Gets the value of the paperNO property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaperNO() {
        return paperNO;
    }

    /**
     * Sets the value of the paperNO property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaperNO(String value) {
        this.paperNO = value;
    }

    /**
     * Gets the value of the signDay property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSignDay() {
        return signDay;
    }

    /**
     * Sets the value of the signDay property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSignDay(String value) {
        this.signDay = value;
    }

    /**
     * Gets the value of the expiredDay property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpiredDay() {
        return expiredDay;
    }

    /**
     * Sets the value of the expiredDay property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpiredDay(String value) {
        this.expiredDay = value;
    }

    /**
     * Gets the value of the degreeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDegreeCode() {
        return degreeCode;
    }

    /**
     * Sets the value of the degreeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDegreeCode(String value) {
        this.degreeCode = value;
    }

    /**
     * Gets the value of the personType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPersonType() {
        return personType;
    }

    /**
     * Sets the value of the personType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPersonType(String value) {
        this.personType = value;
    }

    /**
     * Gets the value of the foreignerId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getForeignerId() {
        return foreignerId;
    }

    /**
     * Sets the value of the foreignerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setForeignerId(String value) {
        this.foreignerId = value;
    }

    /**
     * Gets the value of the visaType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVisaType() {
        return visaType;
    }

    /**
     * Sets the value of the visaType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVisaType(String value) {
        this.visaType = value;
    }

    /**
     * Gets the value of the qtyOfParty property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQtyOfParty() {
        return qtyOfParty;
    }

    /**
     * Sets the value of the qtyOfParty property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQtyOfParty(String value) {
        this.qtyOfParty = value;
    }

    /**
     * Gets the value of the resideReason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResideReason() {
        return resideReason;
    }

    /**
     * Sets the value of the resideReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResideReason(String value) {
        this.resideReason = value;
    }

    /**
     * Gets the value of the residePermitNO property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResidePermitNO() {
        return residePermitNO;
    }

    /**
     * Sets the value of the residePermitNO property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResidePermitNO(String value) {
        this.residePermitNO = value;
    }

    /**
     * Gets the value of the residePermitAssignDay property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResidePermitAssignDay() {
        return residePermitAssignDay;
    }

    /**
     * Sets the value of the residePermitAssignDay property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResidePermitAssignDay(String value) {
        this.residePermitAssignDay = value;
    }

    /**
     * Gets the value of the residePermitExpiredDay property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResidePermitExpiredDay() {
        return residePermitExpiredDay;
    }

    /**
     * Sets the value of the residePermitExpiredDay property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResidePermitExpiredDay(String value) {
        this.residePermitExpiredDay = value;
    }

    /**
     * Gets the value of the localizePeriod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalizePeriod() {
        return localizePeriod;
    }

    /**
     * Sets the value of the localizePeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalizePeriod(String value) {
        this.localizePeriod = value;
    }

    /**
     * Gets the value of the assignmentOrg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAssignmentOrg() {
        return assignmentOrg;
    }

    /**
     * Sets the value of the assignmentOrg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAssignmentOrg(String value) {
        this.assignmentOrg = value;
    }

    /**
     * Gets the value of the resideContactTel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResideContactTel() {
        return resideContactTel;
    }

    /**
     * Sets the value of the resideContactTel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResideContactTel(String value) {
        this.resideContactTel = value;
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
     * Gets the value of the reportTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportTime() {
        return reportTime;
    }

    /**
     * Sets the value of the reportTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportTime(String value) {
        this.reportTime = value;
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
     * Gets the value of the reportPerson property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportPerson() {
        return reportPerson;
    }

    /**
     * Sets the value of the reportPerson property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportPerson(String value) {
        this.reportPerson = value;
    }

    /**
     * Gets the value of the photo property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getPhoto() {
        return photo;
    }

    /**
     * Sets the value of the photo property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setPhoto(byte[] value) {
        this.photo = value;
    }

    /**
     * Gets the value of the studentsInfo property.
     * 
     * @return
     *     possible object is
     *     {@link StudentsInfo }
     *     
     */
    public StudentsInfo getStudentsInfo() {
        return studentsInfo;
    }

    /**
     * Sets the value of the studentsInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link StudentsInfo }
     *     
     */
    public void setStudentsInfo(StudentsInfo value) {
        this.studentsInfo = value;
    }

    /**
     * Gets the value of the reporter property.
     * 
     * @return
     *     possible object is
     *     {@link ReporterInfo }
     *     
     */
    public ReporterInfo getReporter() {
        return reporter;
    }

    /**
     * Sets the value of the reporter property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReporterInfo }
     *     
     */
    public void setReporter(ReporterInfo value) {
        this.reporter = value;
    }

    /**
     * Gets the value of the togetherPerson property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfTogetherPersonInfo }
     *     
     */
    public ArrayOfTogetherPersonInfo getTogetherPerson() {
        return togetherPerson;
    }

    /**
     * Sets the value of the togetherPerson property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfTogetherPersonInfo }
     *     
     */
    public void setTogetherPerson(ArrayOfTogetherPersonInfo value) {
        this.togetherPerson = value;
    }

    /**
     * Gets the value of the relationPerson property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfRelationPerson }
     *     
     */
    public ArrayOfRelationPerson getRelationPerson() {
        return relationPerson;
    }

    /**
     * Sets the value of the relationPerson property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfRelationPerson }
     *     
     */
    public void setRelationPerson(ArrayOfRelationPerson value) {
        this.relationPerson = value;
    }

    /**
     * Gets the value of the carInfo property.
     * 
     * @return
     *     possible object is
     *     {@link CarInfo }
     *     
     */
    public CarInfo getCarInfo() {
        return carInfo;
    }

    /**
     * Sets the value of the carInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link CarInfo }
     *     
     */
    public void setCarInfo(CarInfo value) {
        this.carInfo = value;
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

	public String getSjzt() {
		return sjzt;
	}

	public void setSjzt(String sjzt) {
		this.sjzt = sjzt;
	}

	public String getSjddrq() {
		return sjddrq;
	}

	public void setSjddrq(String sjddrq) {
		this.sjddrq = sjddrq;
	}

	public String getInhabiDetailAddr() {
		return inhabiDetailAddr;
	}

	public void setInhabiDetailAddr(String inhabiDetailAddr) {
		this.inhabiDetailAddr = inhabiDetailAddr;
	}

	public String getWorkplaceDetailAddr() {
		return workplaceDetailAddr;
	}

	public void setWorkplaceDetailAddr(String workplaceDetailAddr) {
		this.workplaceDetailAddr = workplaceDetailAddr;
	}
}
