package com.founder.dbrw.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

@DBInfoAnnotation(tableName = "RULE_YWXTGZRWB", pk = "id")
public class DbrwXtrwb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@FieldDesc("业务协同执行记录ID")private String id;
	@FieldDesc("业务协同任务ID")private String ywxtrwid;
	@FieldDesc("业务ID")private String ywid;
	@FieldDesc("业务名称")private String ywmc;
	@FieldDesc("业务协同规则任务名称")private String ywxtgzrwmc;
	@FieldDesc("协同规则ID")private String xtgzid;
	@FieldDesc("协同规则名称")private String xtgzmc;
	@FieldDesc("协同规则执行方法")private String xtgzzxff;
	@FieldDesc("业务信息查看URL")private String ywxxckurl;
	@FieldDesc("业务协同任务描述")private String ywxtrwms;
	@FieldDesc("发起时间")private String fqsj;
	@FieldDesc("发起人部门ID")private String fqrbmid;
	@FieldDesc("发起人部门")private String fqrbm;
	@FieldDesc("发起人ID")private String fqrid;
	@FieldDesc("发起人")private String fqr;
	@FieldDesc("任务处理时间")private String rwclsj;
	@FieldDesc("任务处理人部门ID")private String rwclrbmid;
	@FieldDesc("任务处理人部门")private String rwclrbm;
	@FieldDesc("任务处理人ID")private String rwclrid;
	@FieldDesc("任务处理人")private String rwclr;
	@FieldDesc("任务处理结果代码")private String rwcljgdm;
	@FieldDesc("任务处理说明")private String rwclsm;
	@FieldDesc("任务处理执行方法")private String rwclzxff;
	@FieldDesc("裁决时间")private String cjsj;
	@FieldDesc("裁决人部门ID")private String cjrbmid;
	@FieldDesc("裁决人部门")private String cjrbm;
	@FieldDesc("裁决人ID")private String cjrid;
	@FieldDesc("裁决人")private String cjr;
	@FieldDesc("裁决结果代码")private String cjjgdm;
	@FieldDesc("裁决执行方法")private String cjzxff;
	@FieldDesc("协同任务状态代码")private String ywrwztdm;
	@FieldDesc("执行状态")private String zxzt;
	@FieldDesc("备注")private String bz;
	@FieldDesc("采集时间")private String xt_cjsj;
	@FieldDesc("录入时间")private String xt_lrsj;
	@FieldDesc("录入人姓名")private String xt_lrrxm;
	@FieldDesc("录入人ID")private String xt_lrrid;
	@FieldDesc("录入人部门")private String xt_lrrbm;
	@FieldDesc("录入人部门ID")private String xt_lrrbmid;
	@FieldDesc("录入IP")private String xt_lrip;
	@FieldDesc("最后修改时间")private String xt_zhxgsj;
	@FieldDesc("最后修改人姓名")private String xt_zhxgrxm;
	@FieldDesc("最后修改人ID")private String xt_zhxgrid;
	@FieldDesc("最后修改人部门")private String xt_zhxgrbm;
	@FieldDesc("最后修改人部门ID")private String xt_zhxgrbmid;
	@FieldDesc("最后修改IP")private String xt_zhxgip;
	@FieldDesc("注销标志")private String xt_zxbz;
	@FieldDesc("注销原因")private String xt_zxyy;
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
	public String getXt_cjsj() {
		return xt_cjsj;
	}
	public void setXt_cjsj(String xt_cjsj) {
		this.xt_cjsj = xt_cjsj;
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
	public String getXt_lrrbm() {
		return xt_lrrbm;
	}
	public void setXt_lrrbm(String xt_lrrbm) {
		this.xt_lrrbm = xt_lrrbm;
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
	public String getXt_zxbz() {
		return xt_zxbz;
	}
	public void setXt_zxbz(String xt_zxbz) {
		this.xt_zxbz = xt_zxbz;
	}
	public String getXt_zxyy() {
		return xt_zxyy;
	}
	public void setXt_zxyy(String xt_zxyy) {
		this.xt_zxyy = xt_zxyy;
	}

	
}
