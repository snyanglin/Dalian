package com.founder.sydw.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

@DBInfoAnnotation(tableName = "DW_LDXXB", pk = "id")
public class Ldxxb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@FieldDesc("旅店ID")
	private String id;
	@FieldDesc("单位ID")
	private String dwid;
	@FieldDesc("旅馆编码")
	private String lgbm;
	@FieldDesc("星级")
	private String xj;
	@FieldDesc("栋数")
	private Long ds;
	@FieldDesc("楼层数")
	private Long lcs;
	@FieldDesc("客房数")
	private Long kefs;
	@FieldDesc("床位数")
	private Long cws;
	@FieldDesc("是否涉外代码")
	private String sfswdm;
	@FieldDesc("附属娱乐项目")
	private String fsylxm;
	@FieldDesc("附属服务项目")
	private String fsfwxm;
	@FieldDesc("经营状态代码")
	private String jyztdm;
	@FieldDesc("经营期")
	private String jyq;
	@FieldDesc("库房数")
	private Long kufs;
	@FieldDesc("库房门窗数")
	private Long kfmcs;
	@FieldDesc("库房有无防盗门代码")
	private String kfywfdmdm;
	@FieldDesc("有无人值宿人代码")
	private String ywrzsrdm;
	@FieldDesc("更值_人数")
	private Long gz_rs;
	@FieldDesc("有无电子监控设备代码")
	private String ywdzjksbdm;
	@FieldDesc("有无闭路电视监控设备代码")
	private String ywbldsjksb;
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
	 * @return the lgbm
	 */
	public String getLgbm() {
		return lgbm;
	}

	/**
	 * @param lgbm
	 *            the lgbm to set
	 */
	public void setLgbm(String lgbm) {
		this.lgbm = lgbm;
	}

	/**
	 * @return the xj
	 */
	public String getXj() {
		return xj;
	}

	/**
	 * @param xj
	 *            the xj to set
	 */
	public void setXj(String xj) {
		this.xj = xj;
	}

	/**
	 * @return the ds
	 */
	public Long getDs() {
		return ds;
	}

	/**
	 * @param ds
	 *            the ds to set
	 */
	public void setDs(Long ds) {
		this.ds = ds;
	}

	/**
	 * @return the lcs
	 */
	public Long getLcs() {
		return lcs;
	}

	/**
	 * @param lcs
	 *            the lcs to set
	 */
	public void setLcs(Long lcs) {
		this.lcs = lcs;
	}

	/**
	 * @return the kefs
	 */
	public Long getKefs() {
		return kefs;
	}

	/**
	 * @param kefs
	 *            the kefs to set
	 */
	public void setKefs(Long kefs) {
		this.kefs = kefs;
	}

	/**
	 * @return the cws
	 */
	public Long getCws() {
		return cws;
	}

	/**
	 * @param cws
	 *            the cws to set
	 */
	public void setCws(Long cws) {
		this.cws = cws;
	}

	/**
	 * @return the sfswdm
	 */
	public String getSfswdm() {
		return sfswdm;
	}

	/**
	 * @param sfswdm
	 *            the sfswdm to set
	 */
	public void setSfswdm(String sfswdm) {
		this.sfswdm = sfswdm;
	}

	/**
	 * @return the fsylxm
	 */
	public String getFsylxm() {
		return fsylxm;
	}

	/**
	 * @param fsylxm
	 *            the fsylxm to set
	 */
	public void setFsylxm(String fsylxm) {
		this.fsylxm = fsylxm;
	}

	/**
	 * @return the fsfwxm
	 */
	public String getFsfwxm() {
		return fsfwxm;
	}

	/**
	 * @param fsfwxm
	 *            the fsfwxm to set
	 */
	public void setFsfwxm(String fsfwxm) {
		this.fsfwxm = fsfwxm;
	}

	/**
	 * @return the jyztdm
	 */
	public String getJyztdm() {
		return jyztdm;
	}

	/**
	 * @param jyztdm
	 *            the jyztdm to set
	 */
	public void setJyztdm(String jyztdm) {
		this.jyztdm = jyztdm;
	}

	/**
	 * @return the jyq
	 */
	public String getJyq() {
		return jyq;
	}

	/**
	 * @param jyq
	 *            the jyq to set
	 */
	public void setJyq(String jyq) {
		this.jyq = jyq;
	}

	/**
	 * @return the kufs
	 */
	public Long getKufs() {
		return kufs;
	}

	/**
	 * @param kufs
	 *            the kufs to set
	 */
	public void setKufs(Long kufs) {
		this.kufs = kufs;
	}

	/**
	 * @return the kfmcs
	 */
	public Long getKfmcs() {
		return kfmcs;
	}

	/**
	 * @param kfmcs
	 *            the kfmcs to set
	 */
	public void setKfmcs(Long kfmcs) {
		this.kfmcs = kfmcs;
	}

	/**
	 * @return the kfywfdmdm
	 */
	public String getKfywfdmdm() {
		return kfywfdmdm;
	}

	/**
	 * @param kfywfdmdm
	 *            the kfywfdmdm to set
	 */
	public void setKfywfdmdm(String kfywfdmdm) {
		this.kfywfdmdm = kfywfdmdm;
	}

	/**
	 * @return the ywrzsrdm
	 */
	public String getYwrzsrdm() {
		return ywrzsrdm;
	}

	/**
	 * @param ywrzsrdm
	 *            the ywrzsrdm to set
	 */
	public void setYwrzsrdm(String ywrzsrdm) {
		this.ywrzsrdm = ywrzsrdm;
	}

	/**
	 * @return the gz_rs
	 */
	public Long getGz_rs() {
		return gz_rs;
	}

	/**
	 * @param gzRs
	 *            the gz_rs to set
	 */
	public void setGz_rs(Long gzRs) {
		gz_rs = gzRs;
	}

	/**
	 * @return the ywdzjksbdm
	 */
	public String getYwdzjksbdm() {
		return ywdzjksbdm;
	}

	/**
	 * @param ywdzjksbdm
	 *            the ywdzjksbdm to set
	 */
	public void setYwdzjksbdm(String ywdzjksbdm) {
		this.ywdzjksbdm = ywdzjksbdm;
	}

	/**
	 * @return the ywbldsjksb
	 */
	public String getYwbldsjksb() {
		return ywbldsjksb;
	}

	/**
	 * @param ywbldsjksb
	 *            the ywbldsjksb to set
	 */
	public void setYwbldsjksb(String ywbldsjksb) {
		this.ywbldsjksb = ywbldsjksb;
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
