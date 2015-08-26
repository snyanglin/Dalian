
package com.founder.syrkgl.webservice.jwry.residence;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfTogetherPersonInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfTogetherPersonInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TogetherPersonInfo" type="{http://www.taiji.com.cn/}TogetherPersonInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfTogetherPersonInfo", propOrder = {
    "togetherPersonInfo"
})
public class ArrayOfTogetherPersonInfo {

    @XmlElement(name = "TogetherPersonInfo", nillable = true)
    protected List<TogetherPersonInfo> togetherPersonInfo;

    /**
     * Gets the value of the togetherPersonInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the togetherPersonInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTogetherPersonInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TogetherPersonInfo }
     * 
     * 
     */
    public List<TogetherPersonInfo> getTogetherPersonInfo() {
        if (togetherPersonInfo == null) {
            togetherPersonInfo = new ArrayList<TogetherPersonInfo>();
        }
        return this.togetherPersonInfo;
    }

}
