package com.founder.drools.core.model;

import org.drools.KnowledgeBase;

import com.founder.zdrygl.core.utils.DroolsUtils;

public class RuleConfig {
	//规则服务URL	
	private String url = null;
	//规则服务用户名
	private String userName = null;
	//规则服务密码
	private String userPassword = null;
	//规则服务对象
	private KnowledgeBase kbase = null;
	
	public RuleConfig(){
		
	}
	
	public RuleConfig(String url,String userName,String userPassword){
		this.url=url;
		this.userName=userName;
		this.userPassword=userPassword;
	}		

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public KnowledgeBase getKbase() {
		if(kbase == null){
			kbase = DroolsUtils.buildKnowledgeBaseByUrl(url, userName, userPassword);	
		}
		return kbase;
	}

	public void setKbase(KnowledgeBase kbase) {
		this.kbase = kbase;
	}
			
}
