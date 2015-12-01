package com.founder.xjpt.com.founder.noreas.authorityManager;

import java.io.StringReader;
import java.util.List;
import javax.xml.namespace.QName;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.xml.sax.InputSource;

public class AuthorityManagerUtils {
	public static String getUserAuthority(String uid){
		String authority="0";
		InputSource source=new InputSource(new StringReader(invokeAuthorityWebService("210200-00000017",uid)));
		SAXBuilder build=new SAXBuilder();
		Document doc;
		try {
			doc = build.build(source);
			Element root=doc.getRootElement();
			List<Element> nodes = root.getChild("contentBody").getChild("bizs").getChildren("biz");
			for(Element node:nodes){
				//可防性案件分析变更巡逻路线权限   警情分析变更巡逻路线权限
				if("警情分析变更巡逻路线权限".equals(node.getChildText("MENUNAME"))){
					authority="1";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return authority;
	}
	
	public static String getUserOrgCode(String uid){
		String orgcode="";
		InputSource source=new InputSource(new StringReader(invokeAuthorityWebService("210200-00000018",uid)));
		SAXBuilder build=new SAXBuilder();
		Document doc;
		try {
			doc = build.build(source);
			Element root=doc.getRootElement();
			Element node = root.getChild("contentBody").getChild("bizs").getChild("biz");
			String rolename=node.getChildText("ROLENAME");
			if(rolename.contains("市局管理员")||rolename.contains("巡警支队操作员")){
				orgcode="210200000000";
			}else{
				orgcode= "".equals(node.getChildText("SSPCSCODE"))?node.getChildText("SSFSXCODE"):node.getChildText("SSPCSCODE");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orgcode;
	}
	
	public static String[] getUserOrgCodes(String uid){
		String[] orgcode=new String[2];
		InputSource source=new InputSource(new StringReader(invokeAuthorityWebService("210200-00000018",uid)));
		SAXBuilder build=new SAXBuilder();
		Document doc;
		try {
			doc = build.build(source);
			Element root=doc.getRootElement();
			Element node = root.getChild("contentBody").getChild("bizs").getChild("biz");
			String rolename=node.getChildText("ROLENAME");
			if(rolename.contains("市局管理员")||rolename.contains("巡警支队操作员")){
				orgcode[0]="1";
				orgcode[1]="210200000000";
			}else{
				if("".equals(node.getChildText("SSFSXCODE"))){
					orgcode[0]="0";
					orgcode[1]="";
				}else{
					if("".equals(node.getChildText("SSPCSCODE"))){
						orgcode[0]="2";
						orgcode[1]=node.getChildText("SSFSXCODE");
					}else{
						orgcode[0]=node.getChildText("SSFSXCODE");
						orgcode[1]=node.getChildText("SSPCSCODE");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orgcode;
	}
	
	//210200-00000018 
	private static String invokeAuthorityWebService(String serviceID,String uid){
		String resultValue="";
		//String url="http://10.80.5.222:7002/mosty/services/PublicService";
		String url="http://10.80.8.176:7001/mosty/services/PublicService";
		String xmlContent="<?xml version='1.0' encoding='utf-8'?>"
			+"<webservice><serviceID>"+serviceID+"</serviceID>"
			+"<serviceUserID>210203194703112293</serviceUserID>"
			+"<serviceUserPassword>123456</serviceUserPassword>"
			+"<sendID>127.0.0.1</sendID>"
			+"<contentBody><bizParameter><biz>"
			+"<USERID>"+uid+"</USERID>"
			+("210200-00000017".equals(serviceID)?"<SYSTEMCODE>xjpt</SYSTEMCODE>":"")
			+"</biz></bizParameter></contentBody></webservice>";
		try{
			RPCServiceClient client=new RPCServiceClient();
			Options option=client.getOptions();
			option.setTransportInProtocol("SOAP");
			option.setTimeOutInMilliSeconds(10000);
			option.setAction("execute");
			EndpointReference targetRPR=new EndpointReference(url);
			option.setTo(targetRPR);
			QName opAddEntity=new QName("http://servicebus.framework.mos.com","execute");
			Object[] opAddEntityArgs=new Object[]{xmlContent};
			Class[] classes=new Class[]{String.class};
			resultValue=(String)client.invokeBlocking(opAddEntity,opAddEntityArgs,classes)[0];
			client.cleanupTransport();
		}catch(AxisFault a){
			a.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
//		System.out.println(resultValue);
		return resultValue;
	}
	
	public static void main(String[] args) {
		System.out.println(AuthorityManagerUtils.getUserOrgCode("210203194703112293"));
		System.out.println(AuthorityManagerUtils.getUserAuthority("210203194703112293"));
	}
}
