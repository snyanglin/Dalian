package com.founder.framework.message.bean;

/**
 * GzycXxb entity. @author MyEclipse Persistence Tools
 */

public class SysMessage implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String xxnr;
	private String xxlb;
	private String ywurl;
	private String fsr;
	private String fsrdm;
	private String fssj;
	private String fsrssdw;
	private String fsrssdwdm;
	private String dxzt;
	private String jslx;
	private String jsr;
	private String jsrdm;
	private String jsrssdw;
	private String jsrssdwdm;
	private String sfck;
	private String cksj;
	private String xxbt;

	// 这个参数是用来判断存入的ywurl是网址还是主键id;
	private String bool;
	private String dkfs;

	// begin
	private String jssj;
	private String userid;
	private String hfbz;//回复标识
	private String hfnr;//回复内容
	public String getHfbz() {
		return hfbz;
	}

	public void setHfbz(String hfbz) {
		this.hfbz = hfbz;
	}

	public String getHfnr() {
		return hfnr;
	}

	public void setHfnr(String hfnr) {
		this.hfnr = hfnr;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getJssj() {
		return jssj;
	}

	public void setJssj(String jssj) {
		this.jssj = jssj;
	}

	public String getCksj() {
		return cksj;
	}

	public void setCksj(String cksj) {
		this.cksj = cksj;
	}

	public String getXxbt() {
		return xxbt;
	}

	public void setXxbt(String xxbt) {
		this.xxbt = xxbt;
	}

	public SysMessage() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getXxnr() {
		return this.xxnr;
	}

	public void setXxnr(String xxnr) {
		this.xxnr = xxnr;
	}

	public String getXxlb() {
		return this.xxlb;
	}

	public void setXxlb(String xxlb) {
		this.xxlb = xxlb;
	}

	public String getYwurl() {
		return this.ywurl;
	}

	public void setYwurl(String ywurl) {
		this.ywurl = ywurl;
	}

	public String getFsr() {
		return this.fsr;
	}

	public void setFsr(String fsr) {
		this.fsr = fsr;
	}

	public String getFsrdm() {
		return this.fsrdm;
	}

	public void setFsrdm(String fsrdm) {
		this.fsrdm = fsrdm;
	}

	public String getFssj() {
		return this.fssj;
	}

	public void setFssj(String fssj) {
		this.fssj = fssj;
	}

	public String getFsrssdw() {
		return this.fsrssdw;
	}

	public void setFsrssdw(String fsrssdw) {
		this.fsrssdw = fsrssdw;
	}

	public String getFsrssdwdm() {
		return this.fsrssdwdm;
	}

	public void setFsrssdwdm(String fsrssdwdm) {
		this.fsrssdwdm = fsrssdwdm;
	}

	public String getDxzt() {
		return this.dxzt;
	}

	public void setDxzt(String dxzt) {
		this.dxzt = dxzt;
	}

	public String getJslx() {
		return jslx;
	}

	public void setJslx(String jslx) {
		this.jslx = jslx;
	}

	public String getJsr() {
		return this.jsr;
	}

	public void setJsr(String jsr) {
		this.jsr = jsr;
	}

	public String getJsrdm() {
		return this.jsrdm;
	}

	public void setJsrdm(String jsrdm) {
		this.jsrdm = jsrdm;
	}

	public String getJsrssdw() {
		return this.jsrssdw;
	}

	public void setJsrssdw(String jsrssdw) {
		this.jsrssdw = jsrssdw;
	}

	public String getJsrssdwdm() {
		return this.jsrssdwdm;
	}

	public void setJsrssdwdm(String jsrssdwdm) {
		this.jsrssdwdm = jsrssdwdm;
	}

	public String getSfck() {
		return this.sfck;
	}

	public void setSfck(String sfck) {
		this.sfck = sfck;
	}

	public String getBool() {
		return bool;
	}

	public void setBool(String bool) {
		this.bool = bool;
	}

	public String getDkfs() {
		return dkfs;
	}

	public void setDkfs(String dkfs) {
		this.dkfs = dkfs;
	}

}