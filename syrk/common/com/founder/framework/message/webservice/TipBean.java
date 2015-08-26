
package com.founder.framework.message.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tipBean complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tipBean">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tipBigType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipDate" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="tipTitle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="uploadDate" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="uploadFrom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="uploadIP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="uploadValidate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userPKIID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="winHeight" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="winWidth" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tipBean", propOrder = {
    "tipBigType",
    "tipDate",
    "tipTitle",
    "tipType",
    "tipURL",
    "uploadDate",
    "uploadFrom",
    "uploadIP",
    "uploadValidate",
    "userID",
    "userPKIID",
    "winHeight",
    "winWidth"
})
public class TipBean {

    protected String tipBigType;
    protected long tipDate;
    protected String tipTitle;
    protected String tipType;
    protected String tipURL;
    protected long uploadDate;
    protected String uploadFrom;
    protected String uploadIP;
    protected String uploadValidate;
    protected String userID;
    protected String userPKIID;
    protected Integer winHeight;
    protected Integer winWidth;

    /**
     * Gets the value of the tipBigType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipBigType() {
        return tipBigType;
    }

    /**
     * Sets the value of the tipBigType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipBigType(String value) {
        this.tipBigType = value;
    }

    /**
     * Gets the value of the tipDate property.
     * 
     */
    public long getTipDate() {
        return tipDate;
    }

    /**
     * Sets the value of the tipDate property.
     * 
     */
    public void setTipDate(long value) {
        this.tipDate = value;
    }

    /**
     * Gets the value of the tipTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipTitle() {
        return tipTitle;
    }

    /**
     * Sets the value of the tipTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipTitle(String value) {
        this.tipTitle = value;
    }

    /**
     * Gets the value of the tipType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipType() {
        return tipType;
    }

    /**
     * Sets the value of the tipType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipType(String value) {
        this.tipType = value;
    }

    /**
     * Gets the value of the tipURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipURL() {
        return tipURL;
    }

    /**
     * Sets the value of the tipURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipURL(String value) {
        this.tipURL = value;
    }

    /**
     * Gets the value of the uploadDate property.
     * 
     */
    public long getUploadDate() {
        return uploadDate;
    }

    /**
     * Sets the value of the uploadDate property.
     * 
     */
    public void setUploadDate(long value) {
        this.uploadDate = value;
    }

    /**
     * Gets the value of the uploadFrom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUploadFrom() {
        return uploadFrom;
    }

    /**
     * Sets the value of the uploadFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUploadFrom(String value) {
        this.uploadFrom = value;
    }

    /**
     * Gets the value of the uploadIP property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUploadIP() {
        return uploadIP;
    }

    /**
     * Sets the value of the uploadIP property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUploadIP(String value) {
        this.uploadIP = value;
    }

    /**
     * Gets the value of the uploadValidate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUploadValidate() {
        return uploadValidate;
    }

    /**
     * Sets the value of the uploadValidate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUploadValidate(String value) {
        this.uploadValidate = value;
    }

    /**
     * Gets the value of the userID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserID() {
        return userID;
    }

    /**
     * Sets the value of the userID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserID(String value) {
        this.userID = value;
    }

    /**
     * Gets the value of the userPKIID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserPKIID() {
        return userPKIID;
    }

    /**
     * Sets the value of the userPKIID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserPKIID(String value) {
        this.userPKIID = value;
    }

    /**
     * Gets the value of the winHeight property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getWinHeight() {
        return winHeight;
    }

    /**
     * Sets the value of the winHeight property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setWinHeight(Integer value) {
        this.winHeight = value;
    }

    /**
     * Gets the value of the winWidth property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getWinWidth() {
        return winWidth;
    }

    /**
     * Sets the value of the winWidth property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setWinWidth(Integer value) {
        this.winWidth = value;
    }

}
