package com.founder.zafffwqz.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

@DBInfoAnnotation(tableName = "ZAFF_SQMJXXB", pk = "id")
public class Sqmjxxb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@FieldDesc("社区民警ID")
	private String id;
	@FieldDesc("社区警务室ID")
	private String sqjwsid;
	@FieldDesc("常用证件代码")
	private String cyzjdm;
	@FieldDesc("证件号码")
	private String zjhm;
	@FieldDesc("姓名")
	private String xm;
	@FieldDesc("警号")
	private String jh;
	@FieldDesc("性别代码")
	private String xbdm;
	@FieldDesc("出生日期")
	private String csrq;
	@FieldDesc("民族代码")
	private String mzdm;
	@FieldDesc("文化程度代码")
	private String whcddm;
	@FieldDesc("政治面貌代码")
	private String zzmmdm;
	@FieldDesc("婚姻状况代码")
	private String hyzkdm;
	@FieldDesc("血型代码")
	private String xxdm;
	@FieldDesc("健康状况代码")
	private String jkzkdm;
	@FieldDesc("联系电话")
	private String lxdh;
	@FieldDesc("参加工作日期")
	private String cjgzrq;
	@FieldDesc("参加公安工作日期")
	private String cjgagzrq;
	@FieldDesc("任职日期")
	private String rzrq;
	@FieldDesc("任职机构名称")
	private String rzjgmc;
	@FieldDesc("警衔")
	private String jx;
	@FieldDesc("岗位代码")
	private String gwdm;
	@FieldDesc("职务")
	private String zw;
	@FieldDesc("职级代码")
	private String zjdm;
	@FieldDesc("警种代码")
	private String jzdm;
	@FieldDesc("警员状态代码")
	private String jyztdm;
	@FieldDesc("登录帐号")
	private String dlzh;
	@FieldDesc("备注")
	private String bz;
	@FieldDesc("人员ID")
	private String ryid;
	//增加的字段 社区兼任职务描述
	private String sqjrzwms;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSqjwsid() {
		return sqjwsid;
	}
	public void setSqjwsid(String sqjwsid) {
		this.sqjwsid = sqjwsid;
	}
	public String getCyzjdm() {
		return cyzjdm;
	}
	public void setCyzjdm(String cyzjdm) {
		this.cyzjdm = cyzjdm;
	}
	public String getZjhm() {
		return zjhm;
	}
	public void setZjhm(String zjhm) {
		this.zjhm = zjhm;
	}
	public String getXm() {
		return xm;
	}
	public void setXm(String xm) {
		this.xm = xm;
	}
	public String getJh() {
		return jh;
	}
	public void setJh(String jh) {
		this.jh = jh;
	}
	public String getXbdm() {
		return xbdm;
	}
	public void setXbdm(String xbdm) {
		this.xbdm = xbdm;
	}
	public String getCsrq() {
		return csrq;
	}
	public void setCsrq(String csrq) {
		this.csrq = csrq;
	}
	public String getMzdm() {
		return mzdm;
	}
	public void setMzdm(String mzdm) {
		this.mzdm = mzdm;
	}
	public String getWhcddm() {
		return whcddm;
	}
	public void setWhcddm(String whcddm) {
		this.whcddm = whcddm;
	}
	public String getZzmmdm() {
		return zzmmdm;
	}
	public void setZzmmdm(String zzmmdm) {
		this.zzmmdm = zzmmdm;
	}
	public String getHyzkdm() {
		return hyzkdm;
	}
	public void setHyzkdm(String hyzkdm) {
		this.hyzkdm = hyzkdm;
	}
	public String getXxdm() {
		return xxdm;
	}
	public void setXxdm(String xxdm) {
		this.xxdm = xxdm;
	}
	public String getJkzkdm() {
		return jkzkdm;
	}
	public void setJkzkdm(String jkzkdm) {
		this.jkzkdm = jkzkdm;
	}
	public String getLxdh() {
		return lxdh;
	}
	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}
	public String getCjgzrq() {
		return cjgzrq;
	}
	public void setCjgzrq(String cjgzrq) {
		this.cjgzrq = cjgzrq;
	}
	public String getCjgagzrq() {
		return cjgagzrq;
	}
	public void setCjgagzrq(String cjgagzrq) {
		this.cjgagzrq = cjgagzrq;
	}
	public String getRzrq() {
		return rzrq;
	}
	public void setRzrq(String rzrq) {
		this.rzrq = rzrq;
	}
	public String getRzjgmc() {
		return rzjgmc;
	}
	public void setRzjgmc(String rzjgmc) {
		this.rzjgmc = rzjgmc;
	}
	public String getJx() {
		return jx;
	}
	public void setJx(String jx) {
		this.jx = jx;
	}
	public String getGwdm() {
		return gwdm;
	}
	public void setGwdm(String gwdm) {
		this.gwdm = gwdm;
	}
	public String getZw() {
		return zw;
	}
	public void setZw(String zw) {
		this.zw = zw;
	}
	public String getZjdm() {
		return zjdm;
	}
	public void setZjdm(String zjdm) {
		this.zjdm = zjdm;
	}
	public String getJzdm() {
		return jzdm;
	}
	public void setJzdm(String jzdm) {
		this.jzdm = jzdm;
	}
	public String getJyztdm() {
		return jyztdm;
	}
	public void setJyztdm(String jyztdm) {
		this.jyztdm = jyztdm;
	}
	public String getDlzh() {
		return dlzh;
	}
	public void setDlzh(String dlzh) {
		this.dlzh = dlzh;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getRyid() {
		return ryid;
	}
	public void setRyid(String ryid) {
		this.ryid = ryid;
	}
	public String getSqjrzwms() {
		return sqjrzwms;
	}
	public void setSqjrzwms(String sqjrzwms) {
		this.sqjrzwms = sqjrzwms;
	}
	
}
