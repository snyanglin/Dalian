package com.founder.jcj.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;
@DBInfoAnnotation(tableName = "JCJ_CJXXB", pk = "id")
public class JcjCjxxb extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@FieldDesc("处警ID")
	private String id;
	@FieldDesc("行政区划代码")
	private String xzqhdm;
	@FieldDesc("处警单编号")
	private String cjdbh;
	@FieldDesc("接警编号")
	private String jjbh;
	@FieldDesc("处警单位代码")
	private String cjdwdm;
	@FieldDesc("处警警员编号")
	private String cj_jybh;
	@FieldDesc("处警员_姓名")
	private String cjy_xm;
	@FieldDesc("处警录音号")
	private String cjlyh;
	@FieldDesc("处警意见")
	private String cjyj;
	@FieldDesc("出动单位代码")
	private String cddwdm;
	@FieldDesc("出警警员编号")
	private String cdjybh;
	@FieldDesc("出动警员_姓名")
	private String cdjy_xm;
	@FieldDesc("处警_时间")
	private String cj_sj;
	@FieldDesc("派单到达_时间")
	private String pddd_sj;
	@FieldDesc("派单接收_时间")
	private String pdjs_sj;
	@FieldDesc("出动人员")
	private String cdry;
	@FieldDesc("出动车辆")
	private String cdcl;
	@FieldDesc("警情状态代码")
	private String jqztdm;
	
	private String orgseatno;
	
	private String qszt;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getXzqhdm() {
		return xzqhdm;
	}
	public void setXzqhdm(String xzqhdm) {
		this.xzqhdm = xzqhdm;
	}
	public String getCjdbh() {
		return cjdbh;
	}
	public void setCjdbh(String cjdbh) {
		this.cjdbh = cjdbh;
	}
	public String getJjbh() {
		return jjbh;
	}
	public void setJjbh(String jjbh) {
		this.jjbh = jjbh;
	}
	public String getCjdwdm() {
		return cjdwdm;
	}
	public void setCjdwdm(String cjdwdm) {
		this.cjdwdm = cjdwdm;
	}
	public String getCj_jybh() {
		return cj_jybh;
	}
	public void setCj_jybh(String cj_jybh) {
		this.cj_jybh = cj_jybh;
	}
	public String getCjy_xm() {
		return cjy_xm;
	}
	public void setCjy_xm(String cjy_xm) {
		this.cjy_xm = cjy_xm;
	}
	public String getCjlyh() {
		return cjlyh;
	}
	public void setCjlyh(String cjlyh) {
		this.cjlyh = cjlyh;
	}
	public String getCjyj() {
		return cjyj;
	}
	public void setCjyj(String cjyj) {
		this.cjyj = cjyj;
	}
	public String getCddwdm() {
		return cddwdm;
	}
	public void setCddwdm(String cddwdm) {
		this.cddwdm = cddwdm;
	}
	public String getCdjybh() {
		return cdjybh;
	}
	public void setCdjybh(String cdjybh) {
		this.cdjybh = cdjybh;
	}
	public String getCdjy_xm() {
		return cdjy_xm;
	}
	public void setCdjy_xm(String cdjy_xm) {
		this.cdjy_xm = cdjy_xm;
	}
	public String getCj_sj() {
		return cj_sj;
	}
	public void setCj_sj(String cj_sj) {
		this.cj_sj = cj_sj;
	}
	public String getPddd_sj() {
		return pddd_sj;
	}
	public void setPddd_sj(String pddd_sj) {
		this.pddd_sj = pddd_sj;
	}
	public String getPdjs_sj() {
		return pdjs_sj;
	}
	public void setPdjs_sj(String pdjs_sj) {
		this.pdjs_sj = pdjs_sj;
	}
	public String getCdry() {
		return cdry;
	}
	public void setCdry(String cdry) {
		this.cdry = cdry;
	}
	public String getCdcl() {
		return cdcl;
	}
	public void setCdcl(String cdcl) {
		this.cdcl = cdcl;
	}
	public String getJqztdm() {
		return jqztdm;
	}
	public void setJqztdm(String jqztdm) {
		this.jqztdm = jqztdm;
	}
	public String getQszt() {
		return qszt;
	}
	public void setQszt(String qszt) {
		this.qszt = qszt;
	}
	public String getOrgseatno() {
		return orgseatno;
	}
	public void setOrgseatno(String orgseatno) {
		this.orgseatno = orgseatno;
	}
	
	
	
	
    
}
