
package com.founder.syrkgl.webservice.jwry.residence;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RelationPerson complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RelationPerson">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PersonNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RelationType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SurnameEN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FirstnameEN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NameCH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Gender" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Birthday" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Nationality" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PaperType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PaperNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IdCard" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Relation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Tel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Workplace" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Inhabitancy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Invite" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TechLevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RegOrg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RegPerson" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RegDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RelationPerson", propOrder = {
    "personNO",
    "relationType",
    "surnameEN",
    "firstnameEN",
    "nameCH",
    "gender",
    "birthday",
    "nationality",
    "paperType",
    "paperNO",
    "idCard",
    "relation",
    "tel",
    "workplace",
    "inhabitancy",
    "invite",
    "techLevel",
    "regOrg",
    "regPerson",
    "regDate"
})
public class RelationPerson {

    @XmlElement(name = "PersonNO")
    protected String personNO;
    @XmlElement(name = "RelationType")
    protected String relationType;
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
    @XmlElement(name = "Nationality")
    protected String nationality;
    @XmlElement(name = "PaperType")
    protected String paperType;
    @XmlElement(name = "PaperNO")
    protected String paperNO;
    @XmlElement(name = "IdCard")
    protected String idCard;
    @XmlElement(name = "Relation")
    protected String relation;
    @XmlElement(name = "Tel")
    protected String tel;
    @XmlElement(name = "Workplace")
    protected String workplace;
    @XmlElement(name = "Inhabitancy")
    protected String inhabitancy;
    @XmlElement(name = "Invite")
    protected String invite;
    @XmlElement(name = "TechLevel")
    protected String techLevel;
    @XmlElement(name = "RegOrg")
    protected String regOrg;
    @XmlElement(name = "RegPerson")
    protected String regPerson;
    @XmlElement(name = "RegDate")
    protected String regDate;

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
     * Gets the value of the relationType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRelationType() {
        return relationType;
    }

    /**
     * Sets the value of the relationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRelationType(String value) {
        this.relationType = value;
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
     * Gets the value of the idCard property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * Sets the value of the idCard property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdCard(String value) {
        this.idCard = value;
    }

    /**
     * Gets the value of the relation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRelation() {
        return relation;
    }

    /**
     * Sets the value of the relation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRelation(String value) {
        this.relation = value;
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
     * Gets the value of the inhabitancy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInhabitancy() {
        return inhabitancy;
    }

    /**
     * Sets the value of the inhabitancy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInhabitancy(String value) {
        this.inhabitancy = value;
    }

    /**
     * Gets the value of the invite property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvite() {
        return invite;
    }

    /**
     * Sets the value of the invite property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvite(String value) {
        this.invite = value;
    }

    /**
     * Gets the value of the techLevel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTechLevel() {
        return techLevel;
    }

    /**
     * Sets the value of the techLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTechLevel(String value) {
        this.techLevel = value;
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

}
