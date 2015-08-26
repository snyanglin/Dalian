
package com.founder.syrkgl.webservice.jwry.residence;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FIIS_CRJ complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FIIS_CRJ">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Nationality" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Gender" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Birth" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CertificateType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CertificateNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PersonType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProfCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VisaType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IoDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IoTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IoPort" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InspectorID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TrafficMode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TrafficTool" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Destination" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GrantCertOrg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GrantCertDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OutReason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ChannelNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TourGroupNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NamePY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="QueryStr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ConstructID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FIIS_CRJ", propOrder = {
    "nationality",
    "gender",
    "birth",
    "certificateType",
    "certificateNO",
    "personType",
    "profCode",
    "visaType",
    "ioDate",
    "ioTime",
    "ioPort",
    "inspectorID",
    "trafficMode",
    "trafficTool",
    "destination",
    "grantCertOrg",
    "grantCertDate",
    "outReason",
    "channelNO",
    "tourGroupNO",
    "inTime",
    "id",
    "name",
    "namePY",
    "queryStr",
    "constructID"
})
public class FIISCRJ {

    @XmlElement(name = "Nationality")
    protected String nationality;
    @XmlElement(name = "Gender")
    protected String gender;
    @XmlElement(name = "Birth")
    protected String birth;
    @XmlElement(name = "CertificateType")
    protected String certificateType;
    @XmlElement(name = "CertificateNO")
    protected String certificateNO;
    @XmlElement(name = "PersonType")
    protected String personType;
    @XmlElement(name = "ProfCode")
    protected String profCode;
    @XmlElement(name = "VisaType")
    protected String visaType;
    @XmlElement(name = "IoDate")
    protected String ioDate;
    @XmlElement(name = "IoTime")
    protected String ioTime;
    @XmlElement(name = "IoPort")
    protected String ioPort;
    @XmlElement(name = "InspectorID")
    protected String inspectorID;
    @XmlElement(name = "TrafficMode")
    protected String trafficMode;
    @XmlElement(name = "TrafficTool")
    protected String trafficTool;
    @XmlElement(name = "Destination")
    protected String destination;
    @XmlElement(name = "GrantCertOrg")
    protected String grantCertOrg;
    @XmlElement(name = "GrantCertDate")
    protected String grantCertDate;
    @XmlElement(name = "OutReason")
    protected String outReason;
    @XmlElement(name = "ChannelNO")
    protected String channelNO;
    @XmlElement(name = "TourGroupNO")
    protected String tourGroupNO;
    @XmlElement(name = "InTime")
    protected String inTime;
    @XmlElement(name = "Id")
    protected String id;
    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "NamePY")
    protected String namePY;
    @XmlElement(name = "QueryStr")
    protected String queryStr;
    @XmlElement(name = "ConstructID")
    protected String constructID;

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
     * Gets the value of the birth property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBirth() {
        return birth;
    }

    /**
     * Sets the value of the birth property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBirth(String value) {
        this.birth = value;
    }

    /**
     * Gets the value of the certificateType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCertificateType() {
        return certificateType;
    }

    /**
     * Sets the value of the certificateType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCertificateType(String value) {
        this.certificateType = value;
    }

    /**
     * Gets the value of the certificateNO property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCertificateNO() {
        return certificateNO;
    }

    /**
     * Sets the value of the certificateNO property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCertificateNO(String value) {
        this.certificateNO = value;
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
     * Gets the value of the profCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProfCode() {
        return profCode;
    }

    /**
     * Sets the value of the profCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProfCode(String value) {
        this.profCode = value;
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
     * Gets the value of the ioDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIoDate() {
        return ioDate;
    }

    /**
     * Sets the value of the ioDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIoDate(String value) {
        this.ioDate = value;
    }

    /**
     * Gets the value of the ioTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIoTime() {
        return ioTime;
    }

    /**
     * Sets the value of the ioTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIoTime(String value) {
        this.ioTime = value;
    }

    /**
     * Gets the value of the ioPort property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIoPort() {
        return ioPort;
    }

    /**
     * Sets the value of the ioPort property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIoPort(String value) {
        this.ioPort = value;
    }

    /**
     * Gets the value of the inspectorID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInspectorID() {
        return inspectorID;
    }

    /**
     * Sets the value of the inspectorID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInspectorID(String value) {
        this.inspectorID = value;
    }

    /**
     * Gets the value of the trafficMode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrafficMode() {
        return trafficMode;
    }

    /**
     * Sets the value of the trafficMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrafficMode(String value) {
        this.trafficMode = value;
    }

    /**
     * Gets the value of the trafficTool property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrafficTool() {
        return trafficTool;
    }

    /**
     * Sets the value of the trafficTool property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrafficTool(String value) {
        this.trafficTool = value;
    }

    /**
     * Gets the value of the destination property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestination() {
        return destination;
    }

    /**
     * Sets the value of the destination property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestination(String value) {
        this.destination = value;
    }

    /**
     * Gets the value of the grantCertOrg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGrantCertOrg() {
        return grantCertOrg;
    }

    /**
     * Sets the value of the grantCertOrg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGrantCertOrg(String value) {
        this.grantCertOrg = value;
    }

    /**
     * Gets the value of the grantCertDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGrantCertDate() {
        return grantCertDate;
    }

    /**
     * Sets the value of the grantCertDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGrantCertDate(String value) {
        this.grantCertDate = value;
    }

    /**
     * Gets the value of the outReason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOutReason() {
        return outReason;
    }

    /**
     * Sets the value of the outReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOutReason(String value) {
        this.outReason = value;
    }

    /**
     * Gets the value of the channelNO property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChannelNO() {
        return channelNO;
    }

    /**
     * Sets the value of the channelNO property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChannelNO(String value) {
        this.channelNO = value;
    }

    /**
     * Gets the value of the tourGroupNO property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTourGroupNO() {
        return tourGroupNO;
    }

    /**
     * Sets the value of the tourGroupNO property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTourGroupNO(String value) {
        this.tourGroupNO = value;
    }

    /**
     * Gets the value of the inTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInTime() {
        return inTime;
    }

    /**
     * Sets the value of the inTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInTime(String value) {
        this.inTime = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the namePY property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNamePY() {
        return namePY;
    }

    /**
     * Sets the value of the namePY property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNamePY(String value) {
        this.namePY = value;
    }

    /**
     * Gets the value of the queryStr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQueryStr() {
        return queryStr;
    }

    /**
     * Sets the value of the queryStr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQueryStr(String value) {
        this.queryStr = value;
    }

    /**
     * Gets the value of the constructID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConstructID() {
        return constructID;
    }

    /**
     * Sets the value of the constructID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConstructID(String value) {
        this.constructID = value;
    }

}
