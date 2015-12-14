package com.founder.qbld.bean;

import java.io.Serializable;
import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.bean.ZdrySf.java]  
 * @ClassName:    [ZdrySf]   
 * @Description:  [涉防信息表]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-5-29 下午5:42:41]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-29 下午5:42:41，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "QBLD_SK_ZDRY_SFXX", pk = "id")
public class ZdrySf extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@FieldDesc("ID")
	private String id;
	@FieldDesc("XSXXBH")
	private String xsxxbh;
	@FieldDesc("SSLB")
	private String sslb;
	@FieldDesc("SSQT")
	private String ssqt;
	@FieldDesc("SFSJ")
	private String sfsj;
	@FieldDesc("SFDD")
	private String sfdd;
	@FieldDesc("BBDWMC")
	private String bbdwmc;
	@FieldDesc("BBLD")
	private String bbld;
	@FieldDesc("SFFS")
	private String sffs;
	@FieldDesc("CZJG")
	private String czjg;
	@FieldDesc("CZRY")
	private String czry;
	@FieldDesc("SQJB")
	private String sqjb;
	@FieldDesc("SFXF")
	private String sfxf;
	@FieldDesc("YJJB")
	private String yjjb;
	@FieldDesc("LXDH")
	private String lxdh;
	@FieldDesc("ZYYY")
	private String zyyy;
	@FieldDesc("ZYSQ")
	private String zysq;
	@FieldDesc("SFGCMS")
	private String sfgcms;
	@FieldDesc("TJSJ")
	private String tjsj;
	@FieldDesc("XGSJ")
	private String xgsj;
	@FieldDesc("ZDRYZJHM")
	private String zdryzjhm;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getXsxxbh() {
		return xsxxbh;
	}
	public void setXsxxbh(String xsxxbh) {
		this.xsxxbh = xsxxbh;
	}
	public String getSslb() {
		return sslb;
	}
	public void setSslb(String sslb) {
		this.sslb = sslb;
	}
	public String getSsqt() {
		return ssqt;
	}
	public void setSsqt(String ssqt) {
		this.ssqt = ssqt;
	}
	public String getSfsj() {
		return sfsj;
	}
	public void setSfsj(String sfsj) {
		this.sfsj = sfsj;
	}
	public String getSfdd() {
		return sfdd;
	}
	public void setSfdd(String sfdd) {
		this.sfdd = sfdd;
	}
	public String getBbdwmc() {
		return bbdwmc;
	}
	public void setBbdwmc(String bbdwmc) {
		this.bbdwmc = bbdwmc;
	}
	public String getBbld() {
		return bbld;
	}
	public void setBbld(String bbld) {
		this.bbld = bbld;
	}
	public String getSffs() {
		return sffs;
	}
	public void setSffs(String sffs) {
		this.sffs = sffs;
	}
	public String getCzjg() {
		return czjg;
	}
	public void setCzjg(String czjg) {
		this.czjg = czjg;
	}
	public String getCzry() {
		return czry;
	}
	public void setCzry(String czry) {
		this.czry = czry;
	}
	public String getSqjb() {
		return sqjb;
	}
	public void setSqjb(String sqjb) {
		this.sqjb = sqjb;
	}
	public String getSfxf() {
		return sfxf;
	}
	public void setSfxf(String sfxf) {
		this.sfxf = sfxf;
	}
	public String getYjjb() {
		return yjjb;
	}
	public void setYjjb(String yjjb) {
		this.yjjb = yjjb;
	}
	public String getLxdh() {
		return lxdh;
	}
	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}
	public String getZyyy() {
		return zyyy;
	}
	public void setZyyy(String zyyy) {
		this.zyyy = zyyy;
	}
	public String getZysq() {
		return zysq;
	}
	public void setZysq(String zysq) {
		this.zysq = zysq;
	}
	public String getSfgcms() {
		return sfgcms;
	}
	public void setSfgcms(String sfgcms) {
		this.sfgcms = sfgcms;
	}
	public String getTjsj() {
		return tjsj;
	}
	public void setTjsj(String tjsj) {
		this.tjsj = tjsj;
	}
	public String getXgsj() {
		return xgsj;
	}
	public void setXgsj(String xgsj) {
		this.xgsj = xgsj;
	}
	public String getZdryzjhm() {
		return zdryzjhm;
	}
	public void setZdryzjhm(String zdryzjhm) {
		this.zdryzjhm = zdryzjhm;
	}

}
