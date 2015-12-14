package com.founder.ggfw.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

@DBInfoAnnotation(tableName = "RULE_YWXTGZRWB", pk = "id")
public class Ywxtgzrwb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@FieldDesc("业务协同执行记录ID")
	private String id;
	@FieldDesc("业务协同任务ID")
	private String ywxtrwid;
	@FieldDesc("业务ID")
	private String ywid;
	@FieldDesc("业务名称")
	private String ywmc;
	@FieldDesc("业务协同规则任务名称")
	private String ywxtgzrwmc;
	@FieldDesc("协同规则ID")
	private String xtgzid;
	@FieldDesc("协同规则名称")
	private String xtgzmc;
	@FieldDesc("协同规则执行方法")
	private String xtgzzxff;
	@FieldDesc("业务信息查看URL")
	private String ywxxckurl;
	@FieldDesc("业务协同任务描述")
	private String ywxtrwms;
	@FieldDesc("发起时间")
	private String fqsj;
	@FieldDesc("发起人部门ID")
	private String fqrbmid;
	@FieldDesc("发起人部门")
	private String fqrbm;
	@FieldDesc("发起人ID")
	private String fqrid;
	@FieldDesc("发起人")
	private String fqr;
	@FieldDesc("任务处理时间")
	private String rwclsj;
	@FieldDesc("任务处理人部门ID")
	private String rwclrbmid;
	@FieldDesc("任务处理人部门")
	private String rwclrbm;
	@FieldDesc("任务处理人ID")
	private String rwclrid;
	@FieldDesc("任务处理人")
	private String rwclr;
	@FieldDesc("任务处理结果代码")
	private String rwcljgdm;
	@FieldDesc("任务处理说明")
	private String rwclsm;
	@FieldDesc("任务处理执行方法")
	private String rwclzxff;
	@FieldDesc("裁决时间")
	private String cjsj;
	@FieldDesc("裁决人部门ID")
	private String cjrbmid;
	@FieldDesc("裁决人部门")
	private String cjrbm;
	@FieldDesc("裁决人ID")
	private String cjrid;
	@FieldDesc("裁决人")
	private String cjr;
	@FieldDesc("裁决结果代码")
	private String cjjgdm;
	@FieldDesc("裁决执行方法")
	private String cjzxff;
	@FieldDesc("协同任务状态代码")
	private String ywrwztdm;
	@FieldDesc("执行状态")
	private String zxzt;
	@FieldDesc("备注")
	private String bz;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getYwxtrwid() {
		return ywxtrwid;
	}
	public void setYwxtrwid(String ywxtrwid) {
		this.ywxtrwid = ywxtrwid;
	}
	public String getYwid() {
		return ywid;
	}
	public void setYwid(String ywid) {
		this.ywid = ywid;
	}
	public String getYwmc() {
		return ywmc;
	}
	public void setYwmc(String ywmc) {
		this.ywmc = ywmc;
	}
	public String getYwxtgzrwmc() {
		return ywxtgzrwmc;
	}
	public void setYwxtgzrwmc(String ywxtgzrwmc) {
		this.ywxtgzrwmc = ywxtgzrwmc;
	}
	public String getXtgzid() {
		return xtgzid;
	}
	public void setXtgzid(String xtgzid) {
		this.xtgzid = xtgzid;
	}
	public String getXtgzmc() {
		return xtgzmc;
	}
	public void setXtgzmc(String xtgzmc) {
		this.xtgzmc = xtgzmc;
	}
	public String getXtgzzxff() {
		return xtgzzxff;
	}
	public void setXtgzzxff(String xtgzzxff) {
		this.xtgzzxff = xtgzzxff;
	}
	public String getYwxxckurl() {
		return ywxxckurl;
	}
	public void setYwxxckurl(String ywxxckurl) {
		this.ywxxckurl = ywxxckurl;
	}
	public String getYwxtrwms() {
		return ywxtrwms;
	}
	public void setYwxtrwms(String ywxtrwms) {
		this.ywxtrwms = ywxtrwms;
	}
	public String getFqsj() {
		return fqsj;
	}
	public void setFqsj(String fqsj) {
		this.fqsj = fqsj;
	}
	public String getFqrbmid() {
		return fqrbmid;
	}
	public void setFqrbmid(String fqrbmid) {
		this.fqrbmid = fqrbmid;
	}
	public String getFqrbm() {
		return fqrbm;
	}
	public void setFqrbm(String fqrbm) {
		this.fqrbm = fqrbm;
	}
	public String getFqrid() {
		return fqrid;
	}
	public void setFqrid(String fqrid) {
		this.fqrid = fqrid;
	}
	public String getFqr() {
		return fqr;
	}
	public void setFqr(String fqr) {
		this.fqr = fqr;
	}
	public String getRwclsj() {
		return rwclsj;
	}
	public void setRwclsj(String rwclsj) {
		this.rwclsj = rwclsj;
	}
	public String getRwclrbmid() {
		return rwclrbmid;
	}
	public void setRwclrbmid(String rwclrbmid) {
		this.rwclrbmid = rwclrbmid;
	}
	public String getRwclrbm() {
		return rwclrbm;
	}
	public void setRwclrbm(String rwclrbm) {
		this.rwclrbm = rwclrbm;
	}
	public String getRwclrid() {
		return rwclrid;
	}
	public void setRwclrid(String rwclrid) {
		this.rwclrid = rwclrid;
	}
	public String getRwclr() {
		return rwclr;
	}
	public void setRwclr(String rwclr) {
		this.rwclr = rwclr;
	}
	public String getRwcljgdm() {
		return rwcljgdm;
	}
	public void setRwcljgdm(String rwcljgdm) {
		this.rwcljgdm = rwcljgdm;
	}
	public String getRwclsm() {
		return rwclsm;
	}
	public void setRwclsm(String rwclsm) {
		this.rwclsm = rwclsm;
	}
	public String getRwclzxff() {
		return rwclzxff;
	}
	public void setRwclzxff(String rwclzxff) {
		this.rwclzxff = rwclzxff;
	}
	public String getCjsj() {
		return cjsj;
	}
	public void setCjsj(String cjsj) {
		this.cjsj = cjsj;
	}
	public String getCjrbmid() {
		return cjrbmid;
	}
	public void setCjrbmid(String cjrbmid) {
		this.cjrbmid = cjrbmid;
	}
	public String getCjrbm() {
		return cjrbm;
	}
	public void setCjrbm(String cjrbm) {
		this.cjrbm = cjrbm;
	}
	public String getCjrid() {
		return cjrid;
	}
	public void setCjrid(String cjrid) {
		this.cjrid = cjrid;
	}
	public String getCjr() {
		return cjr;
	}
	public void setCjr(String cjr) {
		this.cjr = cjr;
	}
	public String getCjjgdm() {
		return cjjgdm;
	}
	public void setCjjgdm(String cjjgdm) {
		this.cjjgdm = cjjgdm;
	}
	public String getCjzxff() {
		return cjzxff;
	}
	public void setCjzxff(String cjzxff) {
		this.cjzxff = cjzxff;
	}
	public String getYwrwztdm() {
		return ywrwztdm;
	}
	public void setYwrwztdm(String ywrwztdm) {
		this.ywrwztdm = ywrwztdm;
	}
	public String getZxzt() {
		return zxzt;
	}
	public void setZxzt(String zxzt) {
		this.zxzt = zxzt;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
}
