package com.founder.tzgg.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;
@DBInfoAnnotation(tableName = "ORG_ORGANIZATION", pk = "id")
public class Org_Organization extends BaseEntity implements Serializable{

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	
	@FieldDesc("主键")
	private Long id;
	@FieldDesc("部门代码")
	private String orgcode;
	@FieldDesc("部门名称")
	private String orgname;
	@FieldDesc("部门类型")
	private String orgtype;
	@FieldDesc("部门等级")
	private String orglevel;
	@FieldDesc("部门业务类型")
	private String orgbiztype;
	@FieldDesc("部门顺序号")
	private Long orderno;
	@FieldDesc("上级部门主键")
	private Long parentid;
	@FieldDesc("上级部门ORGCODE树结点路径")
	private String parenttreepath;
	@FieldDesc("部门名称拼音")
	private String orgnamepy;
	@FieldDesc("部门名称五笔")
	private String orgnamewb;
	@FieldDesc("部门简称")
	private String orgjc;
	@FieldDesc("部门全称")
	private String orgqc;
	@FieldDesc("部门地址")
	private String address;
	@FieldDesc("部门电话")
	private String linktel;
	@FieldDesc("部门联系人")
	private String linkman;
	@FieldDesc("部门联系人电话")
	private String linkmantel;
	@FieldDesc("部门主页")
	private String weburl;
	@FieldDesc("部门邮箱")
	private String email;
	@FieldDesc("部门所属行政区划")
	private String xzqh;
	@FieldDesc("备注")
	private String bz;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOrgcode() {
		return orgcode;
	}
	public void setOrgcode(String orgcode) {
		this.orgcode = orgcode;
	}
	public String getOrgname() {
		return orgname;
	}
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}
	public String getOrgtype() {
		return orgtype;
	}
	public void setOrgtype(String orgtype) {
		this.orgtype = orgtype;
	}
	public String getOrglevel() {
		return orglevel;
	}
	public void setOrglevel(String orglevel) {
		this.orglevel = orglevel;
	}
	public String getOrgbiztype() {
		return orgbiztype;
	}
	public void setOrgbiztype(String orgbiztype) {
		this.orgbiztype = orgbiztype;
	}
	public Long getOrderno() {
		return orderno;
	}
	public void setOrderno(Long orderno) {
		this.orderno = orderno;
	}
	public Long getParentid() {
		return parentid;
	}
	public void setParentid(Long parentid) {
		this.parentid = parentid;
	}
	public String getParenttreepath() {
		return parenttreepath;
	}
	public void setParenttreepath(String parenttreepath) {
		this.parenttreepath = parenttreepath;
	}
	public String getOrgnamepy() {
		return orgnamepy;
	}
	public void setOrgnamepy(String orgnamepy) {
		this.orgnamepy = orgnamepy;
	}
	public String getOrgnamewb() {
		return orgnamewb;
	}
	public void setOrgnamewb(String orgnamewb) {
		this.orgnamewb = orgnamewb;
	}
	public String getOrgjc() {
		return orgjc;
	}
	public void setOrgjc(String orgjc) {
		this.orgjc = orgjc;
	}
	public String getOrgqc() {
		return orgqc;
	}
	public void setOrgqc(String orgqc) {
		this.orgqc = orgqc;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLinktel() {
		return linktel;
	}
	public void setLinktel(String linktel) {
		this.linktel = linktel;
	}
	public String getLinkman() {
		return linkman;
	}
	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}
	public String getLinkmantel() {
		return linkmantel;
	}
	public void setLinkmantel(String linkmantel) {
		this.linkmantel = linkmantel;
	}
	public String getWeburl() {
		return weburl;
	}
	public void setWeburl(String weburl) {
		this.weburl = weburl;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getXzqh() {
		return xzqh;
	}
	public void setXzqh(String xzqh) {
		this.xzqh = xzqh;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	

}
