package com.founder.zdrygl.base.model;

import java.io.Serializable;
import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.bean.ZdryDtjsSfxxb.java]  
 * @ClassName:    [ZdryDtjsSfxxb]   
 * @Description:  [重点人员 动态记实 上访 属性 表]   
 * @Author:       [cong_rihong@founder.com.cn]  
 * @CreateDate:   [2015年12月9日 下午7:06:43]   
 * @UpdateUser:   [ZhangHai(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年12月9日 下午7:06:43，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "ZDRY_DTJS_SFXXB", pk = "id")
public class ZdryDtjsSfxxb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@FieldDesc("ID")
	private String id;
	@FieldDesc("写实信息编号")
	private String xsxxbh;
	@FieldDesc("所属类别")
	private String sslb;
	@FieldDesc("所属群体")
	private String ssqt;
	@FieldDesc("上访时间")
	private String sfsj;
	@FieldDesc("上访地点")
	private String sfdd;
	@FieldDesc("包保单位名称")
	private String bbdwmc;
	@FieldDesc("包保领导")
	private String bbld;
	@FieldDesc("上访方式")
	private String sffs;
	@FieldDesc("处置结果")
	private String czjg;
	@FieldDesc("处置人员")
	private String czry;
	@FieldDesc("诉求级别")
	private String sqjb;
	@FieldDesc("是否息访")
	private String sfxf;
	@FieldDesc("预警级别")
	private String yjjb;
	@FieldDesc("联系电话")
	private String lxdh;
	@FieldDesc("主要原由")
	private String zyyy;
	@FieldDesc("主要事情")
	private String zysq;
	@FieldDesc("上访过程描述")
	private String sfgcms;
	@FieldDesc("填写时间")
	private String tjsj;
	@FieldDesc("修改时间")
	private String xgsj;
	@FieldDesc("重点人员证件号码")
	private String zdryzjhm;
	@FieldDesc("所属类别细类")
	private String sslbxl;
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
	public String getSslbxl() {
		return sslbxl;
	}
	public void setSslbxl(String sslbxl) {
		this.sslbxl = sslbxl;
	}


}
