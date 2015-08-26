
package com.founder.syrkgl.webservice.jwry.loginservice;

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
 *         &lt;element name="logoutResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "logoutResult"
})
@XmlRootElement(name = "logoutResponse")
public class LogoutResponse {

    protected boolean logoutResult;

    /**
     * Gets the value of the logoutResult property.
     * 
     */
    public boolean isLogoutResult() {
        return logoutResult;
    }

    /**
     * Sets the value of the logoutResult property.
     * 
     */
    public void setLogoutResult(boolean value) {
        this.logoutResult = value;
    }

}
