package com.founder.spsxt.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

@DBInfoAnnotation(tableName = "JF_DLQYXXB", pk = "qybh")
public class Spdlqy extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	/*
	@FieldDesc("区域编号")
	private String qybh;
	@FieldDesc("区域名称")
	private String qymc;
	@FieldDesc("区域名称简拼")
	private String qymcjp;
	@FieldDesc("区域名称全拼")
	private String qymcqp;
	*/
	@FieldDesc("录入时间")
	private String xt_lrsj;
	
	private String id;//ID(主键)
	private String code;//代码
	private String meaning;//代码意义
	private String spell;//简拼
	private String parentcode;//父代码
	private String policecode;//分局代码
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMeaning() {
		return meaning;
	}
	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}
	public String getSpell() {
		return spell;
	}
	public void setSpell(String spell) {
		this.spell = spell;
	}
	public String getParentcode() {
		return parentcode;
	}
	public void setParentcode(String parentcode) {
		this.parentcode = parentcode;
	}
	public String getPolicecode() {
		return policecode;
	}
	public void setPolicecode(String policecode) {
		this.policecode = policecode;
	}

	
	@FieldDesc("录入人姓名")
	private String xt_lrrxm;
	@FieldDesc("录入人id")
	private String xt_lrrid;
	@FieldDesc("所属单位")
	private String xt_lrrbm;
	@FieldDesc("录入人部门id")
	private String xt_lrrbmid;
	@FieldDesc("录入ip")
	private String xt_lrip;
	@FieldDesc("最后修改时间")
	private String xt_zhxgsj;
	@FieldDesc("最后修改人姓名")
	private String xt_zhxgrxm;
	@FieldDesc("最后修改人id")
	private String xt_zhxgrid;
	@FieldDesc("最后修改人部门")
	private String xt_zhxgrbm;
	@FieldDesc("最后修改人部门id")
	private String xt_zhxgrbmid;
	@FieldDesc("最后修改id")
	private String xt_zhxgip;
	
	
	
	
	/*
	public String getQybh() {
		return qybh;
	}
	public void setQybh(String qybh) {
		this.qybh = qybh;
	}
	public String getQymc() {
		return qymc;
	}
	public void setQymc(String qymc) {
		this.qymc = qymc;
	}
	public String getQymcjp() {
		return qymcjp;
	}
	public void setQymcjp(String qymcjp) {
		this.qymcjp = qymcjp;
	}
	public String getQymcqp() {
		return qymcqp;
	}
	public void setQymcqp(String qymcqp) {
		this.qymcqp = qymcqp;
	}
	*/
	public String getXt_lrrbm() {
		return xt_lrrbm;
	}
	public void setXt_lrrbm(String xt_lrrbm) {
		this.xt_lrrbm = xt_lrrbm;
	}
	public String getXt_lrsj() {
		return xt_lrsj;
	}
	public void setXt_lrsj(String xt_lrsj) {
		this.xt_lrsj = xt_lrsj;
	}
	public String getXt_lrrxm() {
		return xt_lrrxm;
	}
	public void setXt_lrrxm(String xt_lrrxm) {
		this.xt_lrrxm = xt_lrrxm;
	}
	public String getXt_lrrid() {
		return xt_lrrid;
	}
	public void setXt_lrrid(String xt_lrrid) {
		this.xt_lrrid = xt_lrrid;
	}
	public String getXt_lrrbmid() {
		return xt_lrrbmid;
	}
	public void setXt_lrrbmid(String xt_lrrbmid) {
		this.xt_lrrbmid = xt_lrrbmid;
	}
	public String getXt_lrip() {
		return xt_lrip;
	}
	public void setXt_lrip(String xt_lrip) {
		this.xt_lrip = xt_lrip;
	}
	public String getXt_zhxgsj() {
		return xt_zhxgsj;
	}
	public void setXt_zhxgsj(String xt_zhxgsj) {
		this.xt_zhxgsj = xt_zhxgsj;
	}
	public String getXt_zhxgrxm() {
		return xt_zhxgrxm;
	}
	public void setXt_zhxgrxm(String xt_zhxgrxm) {
		this.xt_zhxgrxm = xt_zhxgrxm;
	}
	public String getXt_zhxgrid() {
		return xt_zhxgrid;
	}
	public void setXt_zhxgrid(String xt_zhxgrid) {
		this.xt_zhxgrid = xt_zhxgrid;
	}
	public String getXt_zhxgrbm() {
		return xt_zhxgrbm;
	}
	public void setXt_zhxgrbm(String xt_zhxgrbm) {
		this.xt_zhxgrbm = xt_zhxgrbm;
	}
	public String getXt_zhxgrbmid() {
		return xt_zhxgrbmid;
	}
	public void setXt_zhxgrbmid(String xt_zhxgrbmid) {
		this.xt_zhxgrbmid = xt_zhxgrbmid;
	}
	public String getXt_zhxgip() {
		return xt_zhxgip;
	}
	public void setXt_zhxgip(String xt_zhxgip) {
		this.xt_zhxgip = xt_zhxgip;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}