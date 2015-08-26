
package com.founder.syrkgl.webservice.jwry.residence;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RecordInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RecordInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FIIS_CRJ" type="{http://www.taiji.com.cn/}ArrayOfFIIS_CRJ" minOccurs="0"/>
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
@XmlType(name = "RecordInfo", propOrder = {
    "fiiscrj",
    "arraySize"
})
public class RecordInfo {

    @XmlElement(name = "FIIS_CRJ")
    protected ArrayOfFIISCRJ fiiscrj;
    @XmlElement(name = "ArraySize")
    protected int arraySize;

    /**
     * Gets the value of the fiiscrj property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfFIISCRJ }
     *     
     */
    public ArrayOfFIISCRJ getFIISCRJ() {
        return fiiscrj;
    }

    /**
     * Sets the value of the fiiscrj property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfFIISCRJ }
     *     
     */
    public void setFIISCRJ(ArrayOfFIISCRJ value) {
        this.fiiscrj = value;
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
