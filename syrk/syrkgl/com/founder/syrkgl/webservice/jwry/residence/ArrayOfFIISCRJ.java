
package com.founder.syrkgl.webservice.jwry.residence;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfFIIS_CRJ complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfFIIS_CRJ">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FIIS_CRJ" type="{http://www.taiji.com.cn/}FIIS_CRJ" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfFIIS_CRJ", propOrder = {
    "fiiscrj"
})
public class ArrayOfFIISCRJ {

    @XmlElement(name = "FIIS_CRJ", nillable = true)
    protected List<FIISCRJ> fiiscrj;

    /**
     * Gets the value of the fiiscrj property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fiiscrj property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFIISCRJ().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FIISCRJ }
     * 
     * 
     */
    public List<FIISCRJ> getFIISCRJ() {
        if (fiiscrj == null) {
            fiiscrj = new ArrayList<FIISCRJ>();
        }
        return this.fiiscrj;
    }

}
