
package com.founder.syrkgl.webservice.jwry.residence;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ResidenceInfoReturn complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResidenceInfoReturn">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Info" type="{http://www.taiji.com.cn/}ArrayOfReportResidenceInfo" minOccurs="0"/>
 *         &lt;element name="ArraySize" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResidenceInfoReturn", propOrder = {
    "info",
    "arraySize"
})
public class ResidenceInfoReturn {

    @XmlElement(name = "Info")
    protected ArrayOfReportResidenceInfo info;
    @XmlElement(name = "ArraySize")
    protected int arraySize;

    /**
     * Gets the value of the info property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfReportResidenceInfo }
     *     
     */
    public ArrayOfReportResidenceInfo getInfo() {
        return info;
    }

    /**
     * Sets the value of the info property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfReportResidenceInfo }
     *     
     */
    public void setInfo(ArrayOfReportResidenceInfo value) {
        this.info = value;
    }

    /**
     * Gets the value of the arraySize property.
     * 
     */
    public int getArraySize() {
        return arraySize;
    }

    /**
     * Sets the value of the arraySize property.
     * 
     */
    public void setArraySize(int value) {
        this.arraySize = value;
    }

}
