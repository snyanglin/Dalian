package com.founder.xjpt.com.founder.noreas.alermAnalyse.services;

import java.io.StringReader;
import java.util.*;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.xml.sax.InputSource;
import com.founder.xjpt.com.founder.noreas.alermAnalyse.bean.PatrolLineBean;
import com.founder.xjpt.com.founder.noreas.alermAnalyse.bean.PatrolPlanBean;
import com.founder.xjpt.com.founder.noreas.alermAnalyse.bean.PatrolPlanSiteBean;
import com.founder.xjpt.com.founder.noreas.alermAnalyse.bean.PatrolSiteBean;

public class PatrolLineServicesNew {
	/**
	 * 巡逻路线服务
	 * @param orgId
	 * @return
	 */
	public List<PatrolLineBean> getXLLX(String orgId){
		List<PatrolLineBean> list=new ArrayList<PatrolLineBean>();
		try {
			String responseXml=invokeJWMWebService("getXLLX",new Object[]{orgId},new Class[]{String.class });
			//System.out.println(responseXml);
			InputSource source=new InputSource(new StringReader(responseXml));
			SAXBuilder build=new SAXBuilder();
			Document doc= build.build(source);
			Element root=doc.getRootElement();
			List<Element> nodeList = root.getChildren("ROUTE");
			for(Element ele:nodeList){
				PatrolLineBean pb=new PatrolLineBean();
				pb.setId(ele.getChildText("ROUTEID"));
				pb.setName(ele.getChildText("ROUTENAME"));
				pb.setOrgId(ele.getChildText("ORGID"));
				List<PatrolSiteBean> siteList=new ArrayList<PatrolSiteBean>();
				List<Element> siteEleList=ele.getChild("SITES").getChildren("SITE");
				for(Element siteEle:siteEleList){
					PatrolSiteBean psb=new PatrolSiteBean();
					psb.setId(siteEle.getChildText("SITEID"));
					psb.setName(siteEle.getChildText("SITENAME"));
					psb.setSn(siteEle.getChildText("SITESN"));
					psb.setX(siteEle.getChildText("PX"));
					psb.setY(siteEle.getChildText("PY"));
					siteList.add(psb);
				}
				Collections.sort(siteList, new Comparator<PatrolSiteBean>() {
					public int compare(PatrolSiteBean psb1,PatrolSiteBean psb2){
						return Integer.parseInt(psb1.getSn())<(Integer.parseInt(psb2.getSn()))?0:1;
					}
				});
				pb.setSites(siteList);
				list.add(pb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
	
	/**
	 * 巡逻计划执行情况统计数据服务
	 * @param orgId
	 * @return
	 */
	public List<PatrolPlanBean> getXLJHTJ(String patrolId,String bdate,String edate){
		List<PatrolPlanBean> list=new ArrayList<PatrolPlanBean>();
		try {
			DatatypeFactory dtf = DatatypeFactory.newInstance();
			XMLGregorianCalendar gcBeginTime = dtf.newXMLGregorianCalendar();
			gcBeginTime.setYear(Integer.parseInt(bdate.substring(0,4)));
			gcBeginTime.setMonth(Integer.parseInt(bdate.substring(5,7)));
			gcBeginTime.setDay(Integer.parseInt(bdate.substring(8,10)));
			XMLGregorianCalendar gcEndTime = dtf.newXMLGregorianCalendar();
			gcEndTime.setYear(Integer.parseInt(edate.substring(0,4)));
			gcEndTime.setMonth(Integer.parseInt(edate.substring(5,7)));
			gcEndTime.setDay(Integer.parseInt(edate.substring(8,10)));
			
//			String responseXml=invokeJWMWebService("getXLJHTJ",new Object[]{patrolId,bdate,edate});
			String responseXml=invokeJWMWebService("getXLJHTJ",new Object[]{Integer.parseInt(patrolId),gcBeginTime,gcEndTime},new Class[]{Integer.class,XMLGregorianCalendar.class,XMLGregorianCalendar.class});
			//System.out.println(responseXml);
			
			InputSource source=new InputSource(new StringReader(responseXml));
			SAXBuilder build=new SAXBuilder();
			Document doc= build.build(source);Element root=doc.getRootElement();
			List<Element> nodeList = root.getChildren("PLAN");
			for(Element ele:nodeList){
				PatrolPlanBean ppb=new PatrolPlanBean();
				ppb.setId(ele.getChildText("PLANID"));
				ppb.setPlanDate(ele.getChildText("PLANDATE"));
				ppb.setBtime(ele.getChildText("BEGINTIME"));
				ppb.setEtime(ele.getChildText("ENDTIME"));
				ppb.setArrCount(ele.getChildText("ARRIVEDCOUNT"));
				ppb.setOmiCount(ele.getChildText("OMITCOUNT"));
				list.add(ppb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 巡逻计划指定时间详细数据服务
	 * @param orgId
	 * @return
	 */
	public List<PatrolPlanSiteBean> getXLJHXX(String planId,String planDate,String btime,String etime){
		List<PatrolPlanSiteBean> list=new ArrayList<PatrolPlanSiteBean>();
		try {
			DatatypeFactory dtf = DatatypeFactory.newInstance();
			XMLGregorianCalendar gcPlanData = dtf.newXMLGregorianCalendar();
			gcPlanData.setYear(Integer.parseInt(planDate.substring(0,4)));
			gcPlanData.setMonth(Integer.parseInt(planDate.substring(5,7)));
			gcPlanData.setDay(Integer.parseInt(planDate.substring(8,10)));
			
			XMLGregorianCalendar gcBeginTime = dtf.newXMLGregorianCalendar();
			gcBeginTime.setYear(Integer.parseInt(btime.substring(0,4)));
			gcBeginTime.setMonth(Integer.parseInt(btime.substring(5,7)));
			gcBeginTime.setDay(Integer.parseInt(btime.substring(8,10)));
			gcBeginTime.setHour(Integer.parseInt(btime.substring(11,13)));
			gcBeginTime.setMinute(Integer.parseInt(btime.substring(14,16)));
			gcBeginTime.setSecond(Integer.parseInt(btime.substring(17,19)));
			
			XMLGregorianCalendar gcEndTime = dtf.newXMLGregorianCalendar();
			gcEndTime.setYear(Integer.parseInt(etime.substring(0,4)));
			gcEndTime.setMonth(Integer.parseInt(etime.substring(5,7)));
			gcEndTime.setDay(Integer.parseInt(etime.substring(8,10)));
			gcEndTime.setHour(Integer.parseInt(etime.substring(11,13)));
			gcEndTime.setMinute(Integer.parseInt(etime.substring(14,16)));
			gcEndTime.setSecond(Integer.parseInt(etime.substring(17,19)));
			
			String responseXml=invokeJWMWebService("getXLJHXX",new Object[]{Integer.parseInt(planId),gcPlanData,gcBeginTime,gcEndTime},new Class[]{Integer.class,XMLGregorianCalendar.class,XMLGregorianCalendar.class,XMLGregorianCalendar.class});
			//System.out.println(responseXml);
			
			InputSource source=new InputSource(new StringReader(responseXml));
			SAXBuilder build=new SAXBuilder();
			Document doc= build.build(source);Element root=doc.getRootElement();
			List<Element> nodeList = root.getChildren("SITE");
			for(Element ele:nodeList){
				PatrolPlanSiteBean ppsb=new PatrolPlanSiteBean();
				ppsb.setId(ele.getChildText("SITEID"));
				ppsb.setName(ele.getChildText("SITENAME"));
				ppsb.setSn(ele.getChildText("SITESN"));
				ppsb.setX(ele.getChildText("PX"));
				ppsb.setY(ele.getChildText("PY"));
				ppsb.setTime(ele.getChildText("PATROLTIME"));
				ppsb.setPerId(ele.getChildText("EMPLOYEEID"));
				ppsb.setPerName(ele.getChildText("EMPLOYEENAME"));
				ppsb.setStatus(ele.getChildText("PATROLSTATUS"));
				list.add(ppsb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 巡逻路线备用点服务
	 * @param orgId
	 * @return
	 */
	public List<PatrolSiteBean> getBYDD(String orgId){
		List<PatrolSiteBean> list=new ArrayList<PatrolSiteBean>();
		
		String responseXml=invokeJWMWebService("getBYDD",new Object[]{orgId},new Class[]{String.class});
		//System.out.println(responseXml);
		
		InputSource source=new InputSource(new StringReader(responseXml));
		SAXBuilder build=new SAXBuilder();
		try {
			Document doc= build.build(source);Element root=doc.getRootElement();
			List<Element> nodeList = root.getChildren("SITE");
			for(Element ele:nodeList){
				PatrolSiteBean psb=new PatrolSiteBean();
				psb.setId(ele.getChildText("SITEID"));
				psb.setName(ele.getChildText("SITENAME"));
				psb.setX(ele.getChildText("PX"));
				psb.setY(ele.getChildText("PY"));
				list.add(psb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 更新巡逻路线服务
	 * @param orgId
	 * @return
	 */
	public boolean updateXLLX(String patrolId,String lineId){
		//System.out.println(lineId);
		String[] ids=lineId.split("@@");
		StringBuffer questXML=new StringBuffer();
		questXML.append("<?xml version='1.0' encoding='UTF-8'?><DDS>");
		for(int i=0;i<ids.length;i++){
			if("".equals(ids[i]))continue;
			questXML.append("<DDXX><XH>"+(i+1)+"</XH><DDID>"+ids[i]+"</DDID></DDXX>");
		}
		questXML.append("</DDS>");
		
		String responseXml=invokeJWMWebService("updateXLLX",new Object[]{Integer.parseInt(patrolId), questXML.toString()},new Class[]{Integer.class,String.class});
		//System.out.println(responseXml);
		
		if("0".equals(responseXml))
			return false;
		else
			return true;
	}
	
	private String invokeJWMWebService(String method,Object[] args,Class[] classes){
		String resultValue="";
		String url="http://10.80.5.228:9090/xjpt/webservice/siteWebService";
		try {
			RPCServiceClient client=new RPCServiceClient();
			Options option=client.getOptions();
			option.setTransportInProtocol("SOAP");
			option.setTimeOutInMilliSeconds(10000);
			option.setAction("");
			EndpointReference targetRPR=new EndpointReference(url);
			option.setTo(targetRPR);
			QName opAddEntity=new QName("http://www.wmkj.com.cn",method);
			resultValue=(String)client.invokeBlocking(opAddEntity,args,classes)[0];
			client.cleanupTransport();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultValue;
	}
	
	public static void main(String[] args) {
		String url="http://10.80.5.228:9090/xjpt/webservice/siteWebService";
		try {
			String resultValue="";
			RPCServiceClient client=new RPCServiceClient();
			Options option=client.getOptions();
			option.setTransportInProtocol("SOAP");
			option.setTimeOutInMilliSeconds(10000);
			option.setAction("");
			EndpointReference targetRPR=new EndpointReference(url);
			option.setTo(targetRPR);
			QName opAddEntity=new QName("http://www.wmkj.com.cn","getXLLX");
			Object[] opAddEntityArgs=new Object[]{"210204410000"};
			Class[] classes=new Class[]{String.class};
			resultValue=(String)client.invokeBlocking(opAddEntity,opAddEntityArgs,classes)[0];
			client.cleanupTransport();
			System.out.println(resultValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
