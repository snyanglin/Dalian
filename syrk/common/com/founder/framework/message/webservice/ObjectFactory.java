
package com.founder.framework.message.webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.demo package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SendTip_QNAME = new QName("http://tip.webservice.portal.modules.portal.magic.com/", "sendTip");
    private final static QName _TestOK_QNAME = new QName("http://tip.webservice.portal.modules.portal.magic.com/", "testOK");
    private final static QName _TestOKResponse_QNAME = new QName("http://tip.webservice.portal.modules.portal.magic.com/", "testOKResponse");
    private final static QName _SendTipResponse_QNAME = new QName("http://tip.webservice.portal.modules.portal.magic.com/", "sendTipResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.demo
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TipBean }
     * 
     */
    public TipBean createTipBean() {
        return new TipBean();
    }

    /**
     * Create an instance of {@link SendTip }
     * 
     */
    public SendTip createSendTip() {
        return new SendTip();
    }

    /**
     * Create an instance of {@link SendTipResponse }
     * 
     */
    public SendTipResponse createSendTipResponse() {
        return new SendTipResponse();
    }

    /**
     * Create an instance of {@link TestOKResponse }
     * 
     */
    public TestOKResponse createTestOKResponse() {
        return new TestOKResponse();
    }

    /**
     * Create an instance of {@link TestOK }
     * 
     */
    public TestOK createTestOK() {
        return new TestOK();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendTip }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tip.webservice.portal.modules.portal.magic.com/", name = "sendTip")
    public JAXBElement<SendTip> createSendTip(SendTip value) {
        return new JAXBElement<SendTip>(_SendTip_QNAME, SendTip.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TestOK }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tip.webservice.portal.modules.portal.magic.com/", name = "testOK")
    public JAXBElement<TestOK> createTestOK(TestOK value) {
        return new JAXBElement<TestOK>(_TestOK_QNAME, TestOK.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TestOKResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tip.webservice.portal.modules.portal.magic.com/", name = "testOKResponse")
    public JAXBElement<TestOKResponse> createTestOKResponse(TestOKResponse value) {
        return new JAXBElement<TestOKResponse>(_TestOKResponse_QNAME, TestOKResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendTipResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tip.webservice.portal.modules.portal.magic.com/", name = "sendTipResponse")
    public JAXBElement<SendTipResponse> createSendTipResponse(SendTipResponse value) {
        return new JAXBElement<SendTipResponse>(_SendTipResponse_QNAME, SendTipResponse.class, null, value);
    }

}
