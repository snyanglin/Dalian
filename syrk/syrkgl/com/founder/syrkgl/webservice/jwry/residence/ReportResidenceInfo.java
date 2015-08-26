
package com.founder.syrkgl.webservice.jwry.residence;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReportResidenceInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReportResidenceInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ResidenceInfo" type="{http://www.taiji.com.cn/}ResidenceInfo" minOccurs="0"/>
 *         &lt;element name="Inhabitancy" type="{http://www.taiji.com.cn/}Inhabitancy" minOccurs="0"/>
 *         &lt;element name="Workplace" type="{http://www.taiji.com.cn/}Workplace" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReportResidenceInfo", propOrder = {
    "residenceInfo",
    "inhabitancy",
    "workplace"
})
public class ReportResidenceInfo {

    @XmlElement(name = "ResidenceInfo")
    protected ResidenceInfo residenceInfo;
    @XmlElement(name = "Inhabitancy")
    protected Inhabitancy inhabitancy;
    @XmlElement(name = "Workplace")
    protected Workplace workplace;

    /**
     * Gets the value of the residenceInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ResidenceInfo }
     *     
     */
    public ResidenceInfo getResidenceInfo() {
        return residenceInfo;
    }

    /**
     * Sets the value of the residenceInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResidenceInfo }
     *     
     */
    public void setResidenceInfo(ResidenceInfo value) {
        this.residenceInfo = value;
    }

    /**
     * Gets the value of the inhabitancy property.
     * 
     * @return
     *     possible object is
     *     {@link Inhabitancy }
     *     
     */
    public Inhabitancy getInhabitancy() {
        return inhabitancy;
    }

    /**
     * Sets the value of the inhabitancy property.
     * 
     * @param value
     *     allowed object is
     *     {@link Inhabitancy }
     *     
     */
    public void setInhabitancy(Inhabitancy value) {
        this.inhabitancy = value;
    }

    /**
     * Gets the value of the workplace property.
     * 
     * @return
     *     possible object is
     *     {@link Workplace }
     *     
     */
    public Workplace getWorkplace() {
        return workplace;
    }

    /**
     * Sets the value of the workplace property.
     * 
     * @param value
     *     allowed object is
     *     {@link Workplace }
     *     
     */
    public void setWorkplace(Workplace value) {
        this.workplace = value;
    }

}
