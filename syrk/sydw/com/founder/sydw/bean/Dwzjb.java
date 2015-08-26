package com.founder.sydw.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

@DBInfoAnnotation(tableName = "DW_DWZJB", pk = "id")
public class Dwzjb extends BaseEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@FieldDesc("单位证件ID")
	private String id;
	@FieldDesc("单位ID")
	private String dwid;
	@FieldDesc("单位证件种类代码")
	private String dwzjzldm;
	@FieldDesc("单位证件编号")
	private String dwzjbh;
	@FieldDesc("签发日期")
	private String qfrq;
	@FieldDesc("截止日期")
	private String jzrq;
	@FieldDesc("证件审批机关")
	private String zjspjg;
	@FieldDesc("证件年检机关")
	private String zjnjjg;
	@FieldDesc("备注")
	private String bz;
	@FieldDesc("采集时间")
	private String xt_cjsj;
	@FieldDesc("录入时间")
	private String xt_lrsj;
	@FieldDesc("录入人姓名")
	private String xt_lrrxm;
	@FieldDesc("录入人ID")
	private String xt_lrrid;
	@FieldDesc("录入人部门")
	private String xt_lrrbm;
	@FieldDesc("录入人部门ID")
	private String xt_lrrbmid;
	@FieldDesc("录入IP")
	private String xt_lrip;
	@FieldDesc("最后修改时间")
	private String xt_zhxgsj;
	@FieldDesc("最后修改人姓名")
	private String xt_zhxgrxm;
	@FieldDesc("最后修改人ID")
	private String xt_zhxgrid;
	@FieldDesc("最后修改人部门")
	private String xt_zhxgrbm;
	@FieldDesc("最后修改人部门ID")
	private String xt_zhxgrbmid;
	@FieldDesc("最后修改IP")
	private String xt_zhxgip;
	@FieldDesc("注销标志")
	private String xt_zxbz;
	@FieldDesc("注销原因")
	private String xt_zxyy;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the dwid
	 */
	public String getDwid() {
		return dwid;
	}

	/**
	 * @param dwid
	 *            the dwid to set
	 */
	public void setDwid(String dwid) {
		this.dwid = dwid;
	}

	/**
	 * @return the dwzjzldm
	 */
	public String getDwzjzldm() {
		return dwzjzldm;
	}

	/**
	 * @param dwzjzldm
	 *            the dwzjzldm to set
	 */
	public void setDwzjzldm(String dwzjzldm) {
		this.dwzjzldm = dwzjzldm;
	}

	/**
	 * @return the dwzjbh
	 */
	public String getDwzjbh() {
		return dwzjbh;
	}

	/**
	 * @param dwzjbh
	 *            the dwzjbh to set
	 */
	public void setDwzjbh(String dwzjbh) {
		this.dwzjbh = dwzjbh;
	}

	/**
	 * @return the qfrq
	 */
	public String getQfrq() {
		return qfrq;
	}

	/**
	 * @param qfrq
	 *            the qfrq to set
	 */
	public void setQfrq(String qfrq) {
		this.qfrq = qfrq;
	}

	/**
	 * @return the jzrq
	 */
	public String getJzrq() {
		return jzrq;
	}

	/**
	 * @param jzrq
	 *            the jzrq to set
	 */
	public void setJzrq(String jzrq) {
		this.jzrq = jzrq;
	}

	/**
	 * @return the zjspjg
	 */
	public String getZjspjg() {
		return zjspjg;
	}

	/**
	 * @param zjspjg
	 *            the zjspjg to set
	 */
	public void setZjspjg(String zjspjg) {
		this.zjspjg = zjspjg;
	}

	/**
	 * @return the zjnjjg
	 */
	public String getZjnjjg() {
		return zjnjjg;
	}

	/**
	 * @param zjnjjg
	 *            the zjnjjg to set
	 */
	public void setZjnjjg(String zjnjjg) {
		this.zjnjjg = zjnjjg;
	}

	/**
	 * @return the bz
	 */
	public String getBz() {
		return bz;
	}

	/**
	 * @param bz
	 *            the bz to set
	 */
	public void setBz(String bz) {
		this.bz = bz;
	}

	/**
	 * @return the xt_cjsj
	 */
	public String getXt_cjsj() {
		return xt_cjsj;
	}

	/**
	 * @param xtCjsj
	 *            the xt_cjsj to set
	 */
	public void setXt_cjsj(String xtCjsj) {
		xt_cjsj = xtCjsj;
	}

	/**
	 * @return the xt_lrsj
	 */
	public String getXt_lrsj() {
		return xt_lrsj;
	}

	/**
	 * @param xtLrsj
	 *            the xt_lrsj to set
	 */
	public void setXt_lrsj(String xtLrsj) {
		xt_lrsj = xtLrsj;
	}

	/**
	 * @return the xt_lrrxm
	 */
	public String getXt_lrrxm() {
		return xt_lrrxm;
	}

	/**
	 * @param xtLrrxm
	 *            the xt_lrrxm to set
	 */
	public void setXt_lrrxm(String xtLrrxm) {
		xt_lrrxm = xtLrrxm;
	}

	/**
	 * @return the xt_lrrid
	 */
	public String getXt_lrrid() {
		return xt_lrrid;
	}

	/**
	 * @param xtLrrid
	 *            the xt_lrrid to set
	 */
	public void setXt_lrrid(String xtLrrid) {
		xt_lrrid = xtLrrid;
	}

	/**
	 * @return the xt_lrrbm
	 */
	public String getXt_lrrbm() {
		return xt_lrrbm;
	}

	/**
	 * @param xtLrrbm
	 *            the xt_lrrbm to set
	 */
	public void setXt_lrrbm(String xtLrrbm) {
		xt_lrrbm = xtLrrbm;
	}

	/**
	 * @return the xt_lrrbmid
	 */
	public String getXt_lrrbmid() {
		return xt_lrrbmid;
	}

	/**
	 * @param xtLrrbmid
	 *            the xt_lrrbmid to set
	 */
	public void setXt_lrrbmid(String xtLrrbmid) {
		xt_lrrbmid = xtLrrbmid;
	}

	/**
	 * @return the xt_lrip
	 */
	public String getXt_lrip() {
		return xt_lrip;
	}

	/**
	 * @param xtLrip
	 *            the xt_lrip to set
	 */
	public void setXt_lrip(String xtLrip) {
		xt_lrip = xtLrip;
	}

	/**
	 * @return the xt_zhxgsj
	 */
	public String getXt_zhxgsj() {
		return xt_zhxgsj;
	}

	/**
	 * @param xtZhxgsj
	 *            the xt_zhxgsj to set
	 */
	public void setXt_zhxgsj(String xtZhxgsj) {
		xt_zhxgsj = xtZhxgsj;
	}

	/**
	 * @return the xt_zhxgrxm
	 */
	public String getXt_zhxgrxm() {
		return xt_zhxgrxm;
	}

	/**
	 * @param xtZhxgrxm
	 *            the xt_zhxgrxm to set
	 */
	public void setXt_zhxgrxm(String xtZhxgrxm) {
		xt_zhxgrxm = xtZhxgrxm;
	}

	/**
	 * @return the xt_zhxgrid
	 */
	public String getXt_zhxgrid() {
		return xt_zhxgrid;
	}

	/**
	 * @param xtZhxgrid
	 *            the xt_zhxgrid to set
	 */
	public void setXt_zhxgrid(String xtZhxgrid) {
		xt_zhxgrid = xtZhxgrid;
	}

	/**
	 * @return the xt_zhxgrbm
	 */
	public String getXt_zhxgrbm() {
		return xt_zhxgrbm;
	}

	/**
	 * @param xtZhxgrbm
	 *            the xt_zhxgrbm to set
	 */
	public void setXt_zhxgrbm(String xtZhxgrbm) {
		xt_zhxgrbm = xtZhxgrbm;
	}

	/**
	 * @return the xt_zhxgrbmid
	 */
	public String getXt_zhxgrbmid() {
		return xt_zhxgrbmid;
	}

	/**
	 * @param xtZhxgrbmid
	 *            the xt_zhxgrbmid to set
	 */
	public void setXt_zhxgrbmid(String xtZhxgrbmid) {
		xt_zhxgrbmid = xtZhxgrbmid;
	}

	/**
	 * @return the xt_zhxgip
	 */
	public String getXt_zhxgip() {
		return xt_zhxgip;
	}

	/**
	 * @param xtZhxgip
	 *            the xt_zhxgip to set
	 */
	public void setXt_zhxgip(String xtZhxgip) {
		xt_zhxgip = xtZhxgip;
	}

	/**
	 * @return the xt_zxbz
	 */
	public String getXt_zxbz() {
		return xt_zxbz;
	}

	/**
	 * @param xtZxbz
	 *            the xt_zxbz to set
	 */
	public void setXt_zxbz(String xtZxbz) {
		xt_zxbz = xtZxbz;
	}

	/**
	 * @return the xt_zxyy
	 */
	public String getXt_zxyy() {
		return xt_zxyy;
	}

	/**
	 * @param xtZxyy
	 *            the xt_zxyy to set
	 */
	public void setXt_zxyy(String xtZxyy) {
		xt_zxyy = xtZxyy;
	}

}
