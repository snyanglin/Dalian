
package com.founder.syrkgl.webservice.jwry.residence;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConditionForResideInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConditionForResideInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PaperType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PaperNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Nationality" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Birthday" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SurnameEN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FirstnameEN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NameCH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConditionForResideInfo", propOrder = {
    "paperType",
    "paperNO",
    "nationality",
    "birthday",
    "surnameEN",
    "firstnameEN",
    "nameCH"
})
public class ConditionForResideInfo {

    @XmlElement(name = "PaperType")
    protected String paperType;
    @XmlElement(name = "PaperNO")
    protected String paperNO;
    @XmlElement(name = "Nationality")
    protected String nationality;
    @XmlElement(name = "Birthday")
    protected String birthday;
    @XmlElement(name = "SurnameEN")
    protected String surnameEN;
    @XmlElement(name = "FirstnameEN")
    protected String firstnameEN;
    @XmlElement(name = "NameCH")
    protected String nameCH;

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

}
