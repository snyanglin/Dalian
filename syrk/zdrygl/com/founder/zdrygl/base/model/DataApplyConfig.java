package com.founder.zdrygl.base.model;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;

import com.founder.framework.config.SystemConfig;

public class DataApplyConfig {
	private String dataApplyUrl="http://localhost:8080/syrk/dataApply/syrkApply";
	private int dataApplyTimeOut=10000;
	private int dataApplyConTimeOut=10000;
	private String dataApplyConnection="keep-alive";
	private String dataApplyAuthorization="Bearer bac7aa44ad6318b9d2c8dd1ebad148";
	
	private HttpClient httpClient=null;		
	
	public void init(){
		String url = SystemConfig.getString("DataApplyUrl");
		String timeOut = SystemConfig.getString("DataApplyTimeOut");		
		String conTimeOut = SystemConfig.getString("DataApplyConTimeOut");		
		String connection = SystemConfig.getString("DataApplyConnection");
		String authorization = SystemConfig.getString("DataApplyAuthorization");
		
		if(url!=null && url.length()>0) dataApplyUrl = url;
		if(timeOut!=null && timeOut.length()>0) dataApplyTimeOut = Integer.valueOf(timeOut);
		if(conTimeOut!=null && conTimeOut.length()>0) dataApplyConTimeOut = Integer.valueOf(conTimeOut);
		if(connection!=null && connection.length()>0) dataApplyConnection = connection;
		if(authorization!=null && authorization.length()>0) dataApplyAuthorization = authorization;
	}
	
	public void initHttpClient(){
		init();
		httpClient =  new HttpClient();
		httpClient.setTimeout(dataApplyTimeOut);
		httpClient.setConnectionTimeout(dataApplyConTimeOut);
	}
	
	public GetMethod getMethod(String cyzjdm, String zjhm){
		GetMethod method = new GetMethod(dataApplyUrl+"?cyzjdm="+cyzjdm+"&zjhm="+zjhm);
		method.setRequestHeader("Connection", dataApplyConnection);
		method.setRequestHeader("Authorization", dataApplyAuthorization);
		//设置报文传送的编码格式
		method.setRequestHeader("Content-Type","text/xml;charset=UTF-8");
		return method;
	}

	public String dataApply(String cyzjdm, String zjhm){
		
		GetMethod method=getMethod(cyzjdm,zjhm);
		try{
			if(httpClient==null) initHttpClient();
			int statusCode = httpClient.executeMethod(method);	
			if (statusCode == HttpStatus.SC_OK
					|| statusCode == HttpStatus.SC_INTERNAL_SERVER_ERROR) {
					
				String res=method.getResponseBodyAsString();	
				if(res!=null){
					//res=JsonUtil.string2json(res);
					return res;
				}
					
					
			}
		} catch (Exception e) {
			e.printStackTrace();			
		}finally{
			method.releaseConnection();
		}
		return null;
	}
	
}
