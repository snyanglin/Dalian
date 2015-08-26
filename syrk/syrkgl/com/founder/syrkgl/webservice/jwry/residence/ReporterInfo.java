
package com.founder.syrkgl.webservice.jwry.residence;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReporterInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReporterInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="InfoNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PersonNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Report" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PhotoInfo" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="PhotoDes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RegDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RegPerson" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RegOrg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Remarks" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReporterInfo", propOrder = {
    "infoNo",
    "personNO",
    "title",
    "report",
    "photoInfo",
    "photoDes",
    "regDate",
    "regPerson",
    "regOrg",
    "remarks"
})
public class ReporterInfo {

    @XmlElement(name = "InfoNo")
    protected String infoNo;
    @XmlElement(name = "PersonNO")
    protected String personNO;
    @XmlElement(name = "Title")
    protected String title;
    @XmlElement(name = "Report")
    protected String report;
    @XmlElement(name = "PhotoInfo")
    protected byte[] photoInfo;
    @XmlElement(name = "PhotoDes")
    protected String photoDes;
    @XmlElement(name = "RegDate")
    protected String regDate;
    @XmlElement(name = "RegPerson")
    protected String regPerson;
    @XmlElement(name = "RegOrg")
    protected String regOrg;
    @XmlElement(name = "Remarks")
    protected String remarks;

    /**
     * Gets the value of the infoNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInfoNo() {
        return infoNo;
    }

    /**
     * Sets the value of the infoNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInfoNo(String value) {
        this.infoNo = value;
    }

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
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the report property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReport() {
        return report;
    }

    /**
     * Sets the value of the report property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReport(String value) {
        this.report = value;
    }

    /**
     * Gets the value of the photoInfo property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getPhotoInfo() {
        return photoInfo;
    }

    /**
     * Sets the value of the photoInfo property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setPhotoInfo(byte[] value) {
        this.photoInfo = value;
    }

    /**
     * Gets the value of the photoDes property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhotoDes() {
        return photoDes;
    }

    /**
     * Sets the value of the photoDes property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhotoDes(String value) {
        this.photoDes = value;
    }

    /**
     * Gets the value of the regDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegDate() {
        return regDate;
    }

    /**
     * Sets the value of the regDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegDate(String value) {
        this.regDate = value;
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
     * Gets the value of the regOrg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegOrg() {
        return regOrg;
    }

    /**
     * Sets the value of the regOrg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegOrg(String value) {
        this.regOrg = value;
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

}
