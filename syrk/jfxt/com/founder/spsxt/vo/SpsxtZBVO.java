package com.founder.spsxt.vo;

import java.io.Serializable;

public class SpsxtZBVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String barcode;
	private String lon;//经度
	private String lat;//纬度
	private String telori;//朝向
	private String teldegree;//角度
	
	private String jkxtNum;//监控系统数量
	private String jsdwNum;//建设单位数量
	
	private String zpjl;//照片路径
	
	private String sameName;
	
	
	public String getSameName() {
		return sameName;
	}
	public void setSameName(String sameName) {
		this.sameName = sameName;
	}
	public String getJkxtNum() {
		return jkxtNum;
	}
	public void setJkxtNum(String jkxtNum) {
		this.jkxtNum = jkxtNum;
	}
	public String getJsdwNum() {
		return jsdwNum;
	}
	public void setJsdwNum(String jsdwNum) {
		this.jsdwNum = jsdwNum;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getLon() {
		return lon;
	}
	public void setLon(String lon) {
		this.lon = lon;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getTelori() {
		return telori;
	}
	public void setTelori(String telori) {
		this.telori = telori;
	}
	public String getTeldegree() {
		return teldegree;
	}
	public void setTeldegree(String teldegree) {
		this.teldegree = teldegree;
	}
	
	public String getZpjl() {
		return zpjl;
	}
	public void setZpjl(String zpjl) {
		this.zpjl = zpjl;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
