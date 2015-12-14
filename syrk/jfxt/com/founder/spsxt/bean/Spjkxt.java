package com.founder.spsxt.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

@DBInfoAnnotation(tableName = "JF_SPXTJBXX", pk = "xh")
public class Spjkxt extends BaseEntity implements Serializable  {
	@FieldDesc("xh")private String xh ;//
	@FieldDesc("传输网络类型")private String cswl ;//传输网络类型
	@FieldDesc("关机时间")private String gjsj ;//关机时间
	@FieldDesc("存储时长")private long ccsc ;//存储时长
	@FieldDesc("存储设备IP地址")private String ccip ;//存储设备IP地址
	@FieldDesc("建设单位")private String dwbm ;//与视频单位主键id关联字段
	@FieldDesc("建设时间")private String jssj ;//建设时间
	@FieldDesc("开机时间")private String kjsj ;//开机时间
	@FieldDesc("所联平台厂商")private String ptcs ;//所联平台厂商
	@FieldDesc("技术人员姓名")private String jsryxm ;//技术人员姓名
	@FieldDesc("技术人员座机")private String jsryzj ;//技术人员座机
	@FieldDesc("技术人员手机")private String jsryphone ;//技术人员手机
	@FieldDesc("技术人员身份证号")private String jsrysfzh ;//技术人员身份证号
	@FieldDesc("拷贝方式")private String copyfs ;//拷贝方式
	@FieldDesc("平台ID")private String idbm ;//平台ID（原系统ID编码）
	@FieldDesc("系统名称")private String xtmc ;//系统名称
	@FieldDesc("系统密码")private String xtmm ;//系统密码
	@FieldDesc("系统用户名")private String xtyhm ;//系统用户名
	@FieldDesc("平台IP")private String ipdz ;//平台IP(原网络IP地址）
	
	public String getXh() {
		return xh;
	}
	public void setXh(String xh) {
		this.xh = xh;
	}
	public String getCswl() {
		return cswl;
	}
	public void setCswl(String cswl) {
		this.cswl = cswl;
	}
	public String getGjsj() {
		return gjsj;
	}
	public void setGjsj(String gjsj) {
		this.gjsj = gjsj;
	}
	public long getCcsc() {
		return ccsc;
	}
	public void setCcsc(long ccsc) {
		this.ccsc = ccsc;
	}
	public String getCcip() {
		return ccip;
	}
	public void setCcip(String ccip) {
		this.ccip = ccip;
	}
	public String getDwbm() {
		return dwbm;
	}
	public void setDwbm(String dwbm) {
		this.dwbm = dwbm;
	}
	public String getJssj() {
		return jssj;
	}
	public void setJssj(String jssj) {
		this.jssj = jssj;
	}
	public String getKjsj() {
		return kjsj;
	}
	public void setKjsj(String kjsj) {
		this.kjsj = kjsj;
	}
	public String getPtcs() {
		return ptcs;
	}
	public void setPtcs(String ptcs) {
		this.ptcs = ptcs;
	}
	public String getJsryxm() {
		return jsryxm;
	}
	public void setJsryxm(String jsryxm) {
		this.jsryxm = jsryxm;
	}
	public String getJsryzj() {
		return jsryzj;
	}
	public void setJsryzj(String jsryzj) {
		this.jsryzj = jsryzj;
	}
	public String getJsryphone() {
		return jsryphone;
	}
	public void setJsryphone(String jsryphone) {
		this.jsryphone = jsryphone;
	}
	public String getJsrysfzh() {
		return jsrysfzh;
	}
	public void setJsrysfzh(String jsrysfzh) {
		this.jsrysfzh = jsrysfzh;
	}
	public String getCopyfs() {
		return copyfs;
	}
	public void setCopyfs(String copyfs) {
		this.copyfs = copyfs;
	}
	public String getIdbm() {
		return idbm;
	}
	public void setIdbm(String idbm) {
		this.idbm = idbm;
	}
	public String getXtmc() {
		return xtmc;
	}
	public void setXtmc(String xtmc) {
		this.xtmc = xtmc;
	}
	public String getXtmm() {
		return xtmm;
	}
	public void setXtmm(String xtmm) {
		this.xtmm = xtmm;
	}
	public String getXtyhm() {
		return xtyhm;
	}
	public void setXtyhm(String xtyhm) {
		this.xtyhm = xtyhm;
	}
	public String getIpdz() {
		return ipdz;
	}
	public void setIpdz(String ipdz) {
		this.ipdz = ipdz;
	}
	public String getLwsx() {
		return lwsx;
	}
	public void setLwsx(String lwsx) {
		this.lwsx = lwsx;
	}
	public String getSbcs() {
		return sbcs;
	}
	public void setSbcs(String sbcs) {
		this.sbcs = sbcs;
	}
	@FieldDesc("联网属性")private String lwsx ;//联网属性
	@FieldDesc("设备厂商")private String sbcs ;//设备厂商


}
