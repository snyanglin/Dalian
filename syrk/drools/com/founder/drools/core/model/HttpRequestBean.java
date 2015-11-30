package com.founder.drools.core.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import com.founder.framework.config.SystemConfig;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class HttpRequestBean {
	private String serviceUrl;//服务地址
	private int connectTimeout=3000;
	private int connectionRequestTimeout=3000;
	
	public HttpRequestBean(String serviceUrl){
		this.serviceUrl=serviceUrl;
		
		String httpConnectTimeout = SystemConfig.getString("httpConnectTimeout");
		String httpConnectionRequestTimeout = SystemConfig.getString("httpConnectionRequestTimeout");
		
		if(httpConnectTimeout!=null && httpConnectTimeout.length()>0)
			connectTimeout = Integer.valueOf(httpConnectTimeout).intValue();
		if(httpConnectionRequestTimeout!=null && httpConnectionRequestTimeout.length()>0)
			connectionRequestTimeout = Integer.valueOf(httpConnectionRequestTimeout).intValue();
	}	
	
	/**
	 * 
	 * @Title: doHttpGet
	 * @Description: TODO(通过HttpGet请求服务方法)
	 * @param @param params GET方式的参数String
	 * @param @return
	 * @param @throws Exception    设定文件
	 * @return String    返回类型
	 * @throw
	 */
	public Map doHttpGet(String params) throws Exception{
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("status", "fail");
		map.put("errorMessage", "no error info");
		
		String url=this.serviceUrl;
		if(url==null){
			throw new Exception("ServiceUrl can not be null!");			
		}
		
		if(!"/".equals(url.substring(url.length()-1)))
			url+="/";
		
		url +=this.serviceUrl+"?"+params;
		System.out.println("Get request from:"+url);
		
		HttpGet httpRequst = new HttpGet(url);	

		return this.doHttp(httpRequst);
	}		
	
	
	/**
	 * 
	 * @Title: doHttpPost
	 * @Description: TODO(通过HttpPost请求服务方法)
	 * @param @param httpEntity  参数（参考httpPost参数）
	 * @param @return
	 * @param @throws Exception    设定文件
	 * @return String    返回类型
	 * @throw
	 */
	public Map doHttpPost(RuleBean ruleBean) throws Exception{	
		if(ruleBean==null)
			throw new Exception("RuleBean can not be null!");
		
		if(ruleBean.getRuleFileName()==null || ruleBean.getRuleFileName().length()==0)
			throw new Exception("RuleFileName can not be null!");
		
		if(ruleBean.getRuleName()==null || ruleBean.getRuleName().length()==0)
			throw new Exception("RuleName can not be null!");
		
		
		if(serviceUrl==null){
			throw new Exception("ServiceUrl can not be null!");					
		}
		
		if("/".equals(serviceUrl.substring(serviceUrl.length()-1)))
			serviceUrl = serviceUrl.substring(0,serviceUrl.length()-1);
		
		
		System.out.println("Post request from:"+serviceUrl);
		
		HttpPost httpRequst = new HttpPost(serviceUrl);//创建HttpPost对象
		
		
		HttpEntity httpEntity=getPostEntity(ruleBean);
		
		httpRequst.setEntity(httpEntity);
		
    	return this.doHttp(httpRequst);		    	
	}
	
	private Map doHttp(HttpRequestBase httpRequst) throws Exception{
		try {
			Builder builder = RequestConfig.custom();
			builder.setConnectTimeout(connectTimeout);//连接超时			
			builder.setConnectionRequestTimeout(connectionRequestTimeout);//请求超时
			
			httpRequst.setConfig(builder.build());
			
			HttpResponse httpResponse = HttpClients.createDefault().execute(httpRequst);
		    if(httpResponse.getStatusLine().getStatusCode() == 200){
		    	HttpEntity httpEntity = httpResponse.getEntity();
		    	String res=EntityUtils.toString(httpEntity);//取出应答字符串		
		    	XStream xStream = new XStream(new DomDriver());
				Map map = (Map) xStream.fromXML(res);
		    	return  map;   	
		    }else{
		    	throw new Exception("Service request faild");	
		    }
		    
		} catch (Exception e) {			
			e.printStackTrace();
			throw e;
		}finally{
			httpRequst.releaseConnection();			
		}
	}
	
	public HttpEntity getPostEntity(RuleBean ruleBean) throws Exception{
		XStream xStream = new XStream(new DomDriver());
		String xmlSstr = xStream.toXML(ruleBean);
		
		List params = new ArrayList();    	
    	params.add(new BasicNameValuePair("paramStr", xmlSstr));
    	return new UrlEncodedFormEntity(params,HTTP.UTF_8);
	}
}
