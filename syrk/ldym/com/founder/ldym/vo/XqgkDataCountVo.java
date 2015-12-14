package com.founder.ldym.vo;

import org.apache.commons.lang.StringUtils;

public class XqgkDataCountVo {
    
	private String syrkTotal;
	
	private String czrkCount;
	
	private String jzrkCount;
	
	private String ldrkCount;
	
	private String wlhrkCount;
	
	private String jwryCount;
	
	
	private String sydwTotal;
	
	//旅店
	private String ldyCount;
	//特种行业
	private String tzhyCount;
	
	//娱乐场所
	private String ylcsCount;
	
	//其他行业
	private String qthyCount;
	//实有房屋
	private String syfwTotal;
	//出租房屋
	private String czfwCount;
	//标准地址
	private String bzdzCount;
	public String getSyrkTotal() {
		if(StringUtils.isBlank(syrkTotal)){
			return "0";
		}
		return syrkTotal;
	}
	public void setSyrkTotal(String syrkTotal) {
		this.syrkTotal = syrkTotal;
	}
	public String getCzrkCount() {
		if(StringUtils.isBlank(czrkCount)){
			return "0";
		}
		return czrkCount;
	}
	public void setCzrkCount(String czrkCount) {
		this.czrkCount = czrkCount;
	}
	public String getJzrkCount() {
		if(StringUtils.isBlank(jzrkCount)){
			return "0";
		}
		return jzrkCount;
	}
	public void setJzrkCount(String jzrkCount) {
		this.jzrkCount = jzrkCount;
	}
	public String getLdrkCount() {
		if(StringUtils.isBlank(ldrkCount)){
			return "0";
		}
		return ldrkCount;
	}
	public void setLdrkCount(String ldrkCount) {
		this.ldrkCount = ldrkCount;
	}
	public String getWlhrkCount() {
		if(StringUtils.isBlank(wlhrkCount)){
			return "0";
		}
		return wlhrkCount;
	}
	public void setWlhrkCount(String wlhrkCount) {
		this.wlhrkCount = wlhrkCount;
	}
	public String getJwryCount() {
		if(StringUtils.isBlank(jwryCount)){
			return "0";
		}
		return jwryCount;
	}
	public void setJwryCount(String jwryCount) {
		this.jwryCount = jwryCount;
	}
	public String getSydwTotal() {
		if(StringUtils.isBlank(sydwTotal)){
			return "0";
		}
		return sydwTotal;
	}
	public void setSydwTotal(String sydwTotal) {
		this.sydwTotal = sydwTotal;
	}
	public String getLdyCount() {
		if(StringUtils.isBlank(ldyCount)){
			return "0";
		}
		return ldyCount;
	}
	public void setLdyCount(String ldyCount) {
		this.ldyCount = ldyCount;
	}
	public String getTzhyCount() {
		if(StringUtils.isBlank(tzhyCount)){
			return "0";
		}
		return tzhyCount;
	}
	public void setTzhyCount(String tzhyCount) {
		this.tzhyCount = tzhyCount;
	}
	public String getYlcsCount() {
		if(StringUtils.isBlank(ylcsCount)){
			return "0";
		}
		return ylcsCount;
	}
	public void setYlcsCount(String ylcsCount) {
		this.ylcsCount = ylcsCount;
	}
	public String getQthyCount() {
		if(StringUtils.isBlank(qthyCount)){
			return "0";
		}
		return qthyCount;
	}
	public void setQthyCount(String qthyCount) {
		this.qthyCount = qthyCount;
	}
	public String getSyfwTotal() {
		if(StringUtils.isBlank(syfwTotal)){
			return "0";
		}
		return syfwTotal;
	}
	public void setSyfwTotal(String syfwTotal) {
		this.syfwTotal = syfwTotal;
	}
	public String getCzfwCount() {
		if(StringUtils.isBlank(czfwCount)){
			return "0";
		}
		return czfwCount;
	}
	public void setCzfwCount(String czfwCount) {
		this.czfwCount = czfwCount;
	}
	public String getBzdzCount() {
		if(StringUtils.isBlank(bzdzCount)){
			return "0";
		}
		return bzdzCount;
	}
	public void setBzdzCount(String bzdzCount) {
		this.bzdzCount = bzdzCount;
	}

	
}
