package com.founder.zdry.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/***
 * ****************************************************************************
 * 
 * @Package: [com.founder.zdry.bean.Xdryxxb.java]
 * @ClassName: [Xdryxxb]
 * @Description: [一句话描述该类的功能]
 * @Author: [wu_chunhui@founder.com.cn]
 * @CreateDate: [2015-3-11 下午6:13:55]
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-3-11 下午6:13:55，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@DBInfoAnnotation(tableName = "ZDRY_XDRYXXB", pk = "id")
public class ZdryXdryxxb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@FieldDesc("吸毒人员ID")
	private String id;
	@FieldDesc("重点人员ID")
	private String zdryid;
	@FieldDesc("毒品种类代码")
	private String dpzldm;
	@FieldDesc("吸食情况代码")
	private String xsqkdm;
	@FieldDesc("初次吸毒种类代码")
	private String ccxdzldm;
	@FieldDesc("吸毒原因代码")
	private String xdyydm;
	@FieldDesc("吸毒方式代码")
	private String xdfsdm;
	@FieldDesc("毒品来源代码")
	private String dplydm;
	@FieldDesc("毒资来源代码")
	private String dzlydm;
	@FieldDesc("危害社会后果")
	private String whshhg;
	@FieldDesc("初次吸毒_日期")
	private String ccxd_rq;
	@FieldDesc("初次查获_日期")
	private String ccch_rq;
	@FieldDesc("初次查获详址")
	private String ccchxz;
	@FieldDesc("查获机构名称")
	private String chjgmc;
	@FieldDesc("初次查获处置情况代码")
	private String ccchczqkdm;
	@FieldDesc("吸毒人员现状代码")
	private String xdryxzdm;
	@FieldDesc("共同吸毒情况")
	private String gtxdqk;
	@FieldDesc("戒毒情况")
	private String jdqk;
	@FieldDesc("复吸_日期")
	private String fxrq;
	@FieldDesc("复吸次数")
	private Long fxcs;
	@FieldDesc("复吸查获处置情况代码")
	private String fxchczqkdm;
	@FieldDesc("复吸查获处置单位代码")
	private String fxchczdwdm;
	@FieldDesc("复吸查获处置单位名称")
	private String fxchczdwmc;
	@FieldDesc("复吸_毒品种类代码")
	private String fxdpzldm;
	@FieldDesc("复吸查获详址")
	private String fxchxz;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getZdryid() {
		return zdryid;
	}

	public void setZdryid(String zdryid) {
		this.zdryid = zdryid;
	}

	public String getXsqkdm() {
		return xsqkdm;
	}

	public void setXsqkdm(String xsqkdm) {
		this.xsqkdm = xsqkdm;
	}

	public String getCcxdzldm() {
		return ccxdzldm;
	}

	public void setCcxdzldm(String ccxdzldm) {
		this.ccxdzldm = ccxdzldm;
	}

	public String getXdyydm() {
		return xdyydm;
	}

	public void setXdyydm(String xdyydm) {
		this.xdyydm = xdyydm;
	}

	public String getXdfsdm() {
		return xdfsdm;
	}

	public void setXdfsdm(String xdfsdm) {
		this.xdfsdm = xdfsdm;
	}

	public String getDplydm() {
		return dplydm;
	}

	public void setDplydm(String dplydm) {
		this.dplydm = dplydm;
	}

	public String getDzlydm() {
		return dzlydm;
	}

	public void setDzlydm(String dzlydm) {
		this.dzlydm = dzlydm;
	}

	public String getWhshhg() {
		return whshhg;
	}

	public void setWhshhg(String whshhg) {
		this.whshhg = whshhg;
	}

	public String getCcxd_rq() {
		return ccxd_rq;
	}

	public void setCcxd_rq(String ccxd_rq) {
		this.ccxd_rq = ccxd_rq;
	}

	public String getCcch_rq() {
		return ccch_rq;
	}

	public void setCcch_rq(String ccch_rq) {
		this.ccch_rq = ccch_rq;
	}

	public String getCcchxz() {
		return ccchxz;
	}

	public void setCcchxz(String ccchxz) {
		this.ccchxz = ccchxz;
	}

	public String getChjgmc() {
		return chjgmc;
	}

	public void setChjgmc(String chjgmc) {
		this.chjgmc = chjgmc;
	}

	public String getCcchczqkdm() {
		return ccchczqkdm;
	}

	public void setCcchczqkdm(String ccchczqkdm) {
		this.ccchczqkdm = ccchczqkdm;
	}

	public String getXdryxzdm() {
		return xdryxzdm;
	}

	public void setXdryxzdm(String xdryxzdm) {
		this.xdryxzdm = xdryxzdm;
	}

	public String getGtxdqk() {
		return gtxdqk;
	}

	public void setGtxdqk(String gtxdqk) {
		this.gtxdqk = gtxdqk;
	}

	public String getJdqk() {
		return jdqk;
	}

	public void setJdqk(String jdqk) {
		this.jdqk = jdqk;
	}

	public String getFxrq() {
		return fxrq;
	}

	public void setFxrq(String fxrq) {
		this.fxrq = fxrq;
	}

	public Long getFxcs() {
		return fxcs;
	}

	public void setFxcs(Long fxcs) {
		this.fxcs = fxcs;
	}

	public String getFxchczqkdm() {
		return fxchczqkdm;
	}

	public void setFxchczqkdm(String fxchczqkdm) {
		this.fxchczqkdm = fxchczqkdm;
	}

	public String getFxchczdwdm() {
		return fxchczdwdm;
	}

	public void setFxchczdwdm(String fxchczdwdm) {
		this.fxchczdwdm = fxchczdwdm;
	}

	public String getFxchczdwmc() {
		return fxchczdwmc;
	}

	public void setFxchczdwmc(String fxchczdwmc) {
		this.fxchczdwmc = fxchczdwmc;
	}

	public String getFxdpzldm() {
		return fxdpzldm;
	}

	public void setFxdpzldm(String fxdpzldm) {
		this.fxdpzldm = fxdpzldm;
	}

	public String getFxchxz() {
		return fxchxz;
	}

	public void setFxchxz(String fxchxz) {
		this.fxchxz = fxchxz;
	}

	public String getDpzldm() {
		return dpzldm;
	}

	public void setDpzldm(String dpzldm) {
		this.dpzldm = dpzldm;
	}

}
