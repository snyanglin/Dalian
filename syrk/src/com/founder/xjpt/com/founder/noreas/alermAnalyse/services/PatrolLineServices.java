package com.founder.xjpt.com.founder.noreas.alermAnalyse.services;

import java.io.StringReader;
import java.util.*;

import javax.xml.namespace.QName;

import org.codehaus.xfire.aegis.AegisBindingProvider;
import org.codehaus.xfire.annotations.AnnotationServiceFactory;
import org.codehaus.xfire.annotations.jsr181.Jsr181WebAnnotations;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.jaxb2.JaxbTypeRegistry;
import org.codehaus.xfire.service.Endpoint;
import org.codehaus.xfire.service.Service;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.xml.sax.InputSource;

import com.founder.xjpt.com.founder.noreas.alermAnalyse.bean.PatrolLineBean;
import com.founder.xjpt.com.founder.noreas.alermAnalyse.bean.PatrolPlanBean;
import com.founder.xjpt.com.founder.noreas.alermAnalyse.bean.PatrolPlanSiteBean;
import com.founder.xjpt.com.founder.noreas.alermAnalyse.bean.PatrolSiteBean;
import com.founder.xjpt.com.founder.noreas.alermAnalyse.dao.PatrolLineDao;
import com.founder.xjpt.com.founder.noreas.alermAnalyse.soap.SiteWebService;

public class PatrolLineServices {
	
	/**
	 * 巡逻路线服务
	 * @param orgId
	 * @return
	 */
	public List<PatrolLineBean> getXLLX(String orgId){
		List<PatrolLineBean> list=new ArrayList<PatrolLineBean>();
		try {
			PatrolLineDao dao=new PatrolLineDao();
			String responseXml=dao.getXLLX(orgId);
			
			System.out.println(responseXml);
			
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
			SiteWebService sws=getSoapEntity();
			String responseXml=sws.getXLJHTJ(patrolId, bdate,edate);
			
			System.out.println(responseXml);
			
			InputSource source=new InputSource(new StringReader(responseXml));
			SAXBuilder build=new SAXBuilder();
			Document doc= build.build(source);Element root=doc.getRootElement();
			List<Element> nodeList = root.getChildren("PLAN");
			for(Element ele:nodeList){
				PatrolPlanBean ppb=new PatrolPlanBean();
				ppb.setId(ele.getChildText("PLANID".toLowerCase()));
				ppb.setPlanDate(ele.getChildText("PLANDATE".toLowerCase()));
				ppb.setBtime(ele.getChildText("BEGINTIME".toLowerCase()));
				ppb.setEtime(ele.getChildText("ENDTIME".toLowerCase()));
				ppb.setArrCount(ele.getChildText("ARRIVEDCOUNT".toLowerCase()));
				ppb.setOmiCount(ele.getChildText("OMITCOUNT".toLowerCase()));
				ppb.setEarCount(ele.getChildText("EARLYCOUNT".toLowerCase()));
				ppb.setLatCount(ele.getChildText("LATECOUNT".toLowerCase()));
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
			SiteWebService sws=getSoapEntity();
			String responseXml=sws.getXLJHXX(planId, planDate, btime, etime);
			
			System.out.println(responseXml);
			
			InputSource source=new InputSource(new StringReader(responseXml));
			SAXBuilder build=new SAXBuilder();
			Document doc= build.build(source);Element root=doc.getRootElement();
			List<Element> nodeList = root.getChildren("SITE");
			String ids="";
			for(Element ele:nodeList){
				PatrolPlanSiteBean ppsb=new PatrolPlanSiteBean();
				ppsb.setId(ele.getChildText("SITEID".toLowerCase()));
				ppsb.setName(ele.getChildText("SITENAME".toLowerCase()));
				ppsb.setSn(ele.getChildText("SITESN".toLowerCase()));
				ppsb.setX(ele.getChildText("PX".toLowerCase()));
				ppsb.setY(ele.getChildText("PY".toLowerCase()));
				ppsb.setTime(ele.getChildText("PATROLTIME".toLowerCase()));
				ppsb.setPerId(ele.getChildText("USERID".toLowerCase()));
				ppsb.setPerName(ele.getChildText("EMPLOYEENAME".toLowerCase()));
				ppsb.setStatus(ele.getChildText("PATROLSTATUS".toLowerCase()));
				list.add(ppsb);
				
				ids+="'"+ppsb.getId()+"',";
			}
			if(ids.length()>0)
				ids=ids.substring(0,ids.length()-1);
			
			PatrolLineDao dao=new PatrolLineDao();
			List<String[]> sites=dao.getStiesByIds(ids);
			if(!sites.isEmpty()){
				for(String[] site:sites){
					for(PatrolPlanSiteBean bean:list){
						if(bean.getId().endsWith(site[0])){
							bean.setX(site[1]);
							bean.setY(site[2]);
						}
					}
				}
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
		
		PatrolLineDao dao=new PatrolLineDao();
		String responseXml=dao.getBYDD(orgId);
		
		System.out.println(responseXml);
		
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
		PatrolLineDao dao=new PatrolLineDao();
		String responseXml=dao.updateXLLX(patrolId, lineId);
		
//		System.out.println(responseXml);
		
		if("0".equals(responseXml))
			return false;
		else
			return true;
	}
	
	public SiteWebService getSoapEntity(){
		try {
			String url="http://10.80.5.228:9080/DLGA_XJPT_V2/webservice/WmkjWebService";
//			String url="http://10.80.5.228:9090/xjpt/webservice/siteWebService";
			QName qnameBinding=new QName("http://www.wmkj.com.cn","siteWebServiceSoapBinding");
			QName qnamePort=new QName("http://www.wmkj.com.cn","SiteWebServiceImplPort");
			
			HashMap<String,Object> props = new HashMap<String,Object>();
			props.put("annotations.allow.interface", true);
			
			AnnotationServiceFactory asf = new AnnotationServiceFactory(new Jsr181WebAnnotations(), org.codehaus.xfire.XFireFactory.newInstance().getXFire().getTransportManager(), new AegisBindingProvider(new JaxbTypeRegistry()));
			
			Service service = asf.create((SiteWebService.class), props);
			asf.createSoap11Binding(service,qnameBinding,"http://schemas.xmlsoap.org/soap/http");
			Endpoint SiteWebServiceImplPortEP = service.addEndpoint(qnamePort, qnameBinding,url);
			
			return (SiteWebService)new XFireProxyFactory().create(SiteWebServiceImplPortEP.getBinding(), url);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	public static void main(String[] args) {
		String url="http://10.80.5.228:9080/DLGA_XJPT_V2/webservice/WmkjWebService";
//		String url="http://10.80.5.228:9090/xjpt/webservice/siteWebService";
		try {
			HashMap<String,Object> props = new HashMap<String,Object>();
			props.put("annotations.allow.interface", true);
			AnnotationServiceFactory asf = new AnnotationServiceFactory(new Jsr181WebAnnotations(), org.codehaus.xfire.XFireFactory.newInstance().getXFire().getTransportManager(), new AegisBindingProvider(new JaxbTypeRegistry()));
			Service service = asf.create((SiteWebService.class), props);
			QName qnameBinding=new QName("http://www.wmkj.com.cn","WmkjWebServiceSoapBinding");
			QName qnamePort=new QName("http://www.wmkj.com.cn","WmkjWebServiceImplPort");
			asf.createSoap11Binding(service,qnameBinding,"http://schemas.xmlsoap.org/soap/http");
			Endpoint SiteWebServiceImplPortEP = service.addEndpoint(qnamePort, qnameBinding,url);
			SiteWebService sws=(SiteWebService)new XFireProxyFactory().create(SiteWebServiceImplPortEP.getBinding(), url);
			System.out.println(sws.getXLJHTJ("6ece6a418b7948d2a4f440c9727db5d4","2014-01-01","2015-01-01"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
