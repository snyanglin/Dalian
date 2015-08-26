
package com.founder.syrkgl.webservice.jwry.residence;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfReportResidenceInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfReportResidenceInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ReportResidenceInfo" type="{http://www.taiji.com.cn/}ReportResidenceInfo" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfReportResidenceInfo", propOrder = {
    "reportResidenceInfo"
})
public class ArrayOfReportResidenceInfo {

    @XmlElement(name = "ReportResidenceInfo", nillable = true)
    protected List<ReportResidenceInfo> reportResidenceInfo;

    /**
     * Gets the value of the reportResidenceInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reportResidenceInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReportResidenceInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReportResidenceInfo }
     * 
     * 
     */
    public List<ReportResidenceInfo> getReportResidenceInfo() {
        if (reportResidenceInfo == null) {
            reportResidenceInfo = new ArrayList<ReportResidenceInfo>();
        }
        return this.reportResidenceInfo;
    }

}
