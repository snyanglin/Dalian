
package com.founder.syrkgl.webservice.jwry.residence;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="conditionForDeleteWorkplace" type="{http://www.taiji.com.cn/}ConditionForDeleteWorkplace" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "conditionForDeleteWorkplace"
})
@XmlRootElement(name = "DeleteWorkplace")
public class DeleteWorkplace {

    protected ConditionForDeleteWorkplace conditionForDeleteWorkplace;

    /**
     * Gets the value of the conditionForDeleteWorkplace property.
     * 
     * @return
     *     possible object is
     *     {@link ConditionForDeleteWorkplace }
     *     
     */
    public ConditionForDeleteWorkplace getConditionForDeleteWorkplace() {
        return conditionForDeleteWorkplace;
    }

    /**
     * Sets the value of the conditionForDeleteWorkplace property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConditionForDeleteWorkplace }
     *     
     */
    public void setConditionForDeleteWorkplace(ConditionForDeleteWorkplace value) {
        this.conditionForDeleteWorkplace = value;
    }

}
