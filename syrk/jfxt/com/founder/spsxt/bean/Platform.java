package com.founder.spsxt.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

//公安自建平台实体
@DBInfoAnnotation(tableName = "JF_PTJBXX", pk = "id")
public class Platform extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@FieldDesc("主键")private String id ;//主键
	@FieldDesc("平台名称")private String ptmc ;//平台名称	
	@FieldDesc("平台名称拼音")private String ptmcpy ;//平台名称拼音
	@FieldDesc("平台所属分局")private String ssorgcode ;//平台所属分局

	@FieldDesc("平台厂商")private String ptcs ;//平台厂商
	@FieldDesc("传输网络类型")private String cswlLx ;//传输网络类型	
	@FieldDesc("中心服务器IP")private String zxfwqIp ;//中心服务器IP
	@FieldDesc("中心服务器端口号")private long zxfwqDkh ;//中心服务器端口号
	
	@FieldDesc("运维管理人员姓名")private String ywglryXm ;//运维管理人员姓名
	@FieldDesc("运维管理人员手机")private String ywglryMobile ;//运维管理人员手机	
	@FieldDesc("运维管理人员座机")private String ywglryTele ;//运维管理人员座机
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPtmc() {
		return ptmc;
	}
	public void setPtmc(String ptmc) {
		this.ptmc = ptmc;
	}
	public String getPtcs() {
		return ptcs;
	}
	public void setPtcs(String ptcs) {
		this.ptcs = ptcs;
	}

	public String getCswlLx() {
		return cswlLx;
	}
	public void setCswlLx(String cswlLx) {
		this.cswlLx = cswlLx;
	}
	public String getZxfwqIp() {
		return zxfwqIp;
	}
	public void setZxfwqIp(String zxfwqIp) {
		this.zxfwqIp = zxfwqIp;
	}
	public long getZxfwqDkh() {
		return zxfwqDkh;
	}
	public void setZxfwqDkh(long zxfwqDkh) {
		this.zxfwqDkh = zxfwqDkh;
	}
	public String getYwglryMobile() {
		return ywglryMobile;
	}
	public void setYwglryMobile(String ywglryMobile) {
		this.ywglryMobile = ywglryMobile;
	}
	public String getYwglryXm() {
		return ywglryXm;
	}
	public void setYwglryXm(String ywglryXm) {
		this.ywglryXm = ywglryXm;
	}
	public String getYwglryTele() {
		return ywglryTele;
	}
	public void setYwglryTele(String ywglryTele) {
		this.ywglryTele = ywglryTele;
	}
	public String getPtmcpy() {
		return ptmcpy;
	}
	public void setPtmcpy(String ptmcpy) {
		this.ptmcpy = ptmcpy;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getSsorgcode() {
		return ssorgcode;
	}
	public void setSsorgcode(String ssorgcode) {
		this.ssorgcode = ssorgcode;
	}
	

}
