/**********************************************************************   
 * <p>文件名：Cyrydrrwmxb.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author wu_chunhui@founder.com.cn 
 * @date 2014-11-27 下午3:09:49 
 * @history
 * @department：研发部
 *
 */
package com.founder.sydw.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/******************************************************************************
 * @Package: [com.founder.sydw.bean.Cyrydrrwmxb.java]
 * @ClassName: [Cyrydrrwmxb]
 * @Description: [一句话描述该类的功能]
 * @Author: [wu_chunhui@founder.com.cn]
 * @CreateDate: [2014-11-27 下午3:09:49]
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2014-11-27 下午3:09:49，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@DBInfoAnnotation(tableName = "DW_CYRYDRRWMXB", pk = "id")
public class Cyrydrrwmxb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@FieldDesc("id")
	private String id;
	@FieldDesc("导入任务ID")
	private String drrwid;
	@FieldDesc("从业人员")
	private String cyrwid;
	@FieldDesc("姓名")
	private String xm;
	@FieldDesc("性别代码")
	private String xbdm;
	@FieldDesc("出生日期")
	private String csrq;
	@FieldDesc("民族代码")
	private String mzdm;
	@FieldDesc("证件号码")
	private String zjhm;
	@FieldDesc("聘用时间")
	private String pysj;
	@FieldDesc("所在部门名称")
	private String szbmmc;
	@FieldDesc("职业")
	private String zy;
	@FieldDesc("联系电话")
	private String lxdh;
	@FieldDesc("地址-居住地址代码")
	private String dz_xzzdm;
	@FieldDesc("地址-居住地址行政区划代码")
	private String dz_xzzxzqhdm;
	@FieldDesc("地址-居住地址详址")
	private String dz_xzzxz;
	@FieldDesc("导入结果")
	private String drjg;
	@FieldDesc("明细描述")
	private String mxms;
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
	@FieldDesc("采集时间")
	private String xt_cjsj;
	@FieldDesc("是否为在逃人员")
	private String sfzt;
	private String ryid;
	
	

	/**
	 * @return the ryid
	 */
	public String getRyid() {
		return ryid;
	}

	/**
	 * @param ryid the ryid to set
	 */
	public void setRyid(String ryid) {
		this.ryid = ryid;
	}

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
	 * @return the drrwid
	 */
	public String getDrrwid() {
		return drrwid;
	}

	/**
	 * @param drrwid
	 *            the drrwid to set
	 */
	public void setDrrwid(String drrwid) {
		this.drrwid = drrwid;
	}

	/**
	 * @return the cyrwid
	 */
	public String getCyrwid() {
		return cyrwid;
	}

	/**
	 * @param cyrwid
	 *            the cyrwid to set
	 */
	public void setCyrwid(String cyrwid) {
		this.cyrwid = cyrwid;
	}

	/**
	 * @return the xm
	 */
	public String getXm() {
		return xm;
	}

	/**
	 * @param xm
	 *            the xm to set
	 */
	public void setXm(String xm) {
		this.xm = xm;
	}

	/**
	 * @return the xbdm
	 */
	public String getXbdm() {
		return xbdm;
	}

	/**
	 * @param xbdm
	 *            the xbdm to set
	 */
	public void setXbdm(String xbdm) {
		this.xbdm = xbdm;
	}

	/**
	 * @return the csrq
	 */
	public String getCsrq() {
		return csrq;
	}

	/**
	 * @param csrq
	 *            the csrq to set
	 */
	public void setCsrq(String csrq) {
		this.csrq = csrq;
	}

	/**
	 * @return the mzdm
	 */
	public String getMzdm() {
		return mzdm;
	}

	/**
	 * @param mzdm
	 *            the mzdm to set
	 */
	public void setMzdm(String mzdm) {
		this.mzdm = mzdm;
	}

	/**
	 * @return the zjhm
	 */
	public String getZjhm() {
		return zjhm;
	}

	/**
	 * @param zjhm
	 *            the zjhm to set
	 */
	public void setZjhm(String zjhm) {
		this.zjhm = zjhm;
	}

	/**
	 * @return the pysj
	 */
	public String getPysj() {
		return pysj;
	}

	/**
	 * @param pysj
	 *            the pysj to set
	 */
	public void setPysj(String pysj) {
		this.pysj = pysj;
	}

	/**
	 * @return the szbmmc
	 */
	public String getSzbmmc() {
		return szbmmc;
	}

	/**
	 * @param szbmmc
	 *            the szbmmc to set
	 */
	public void setSzbmmc(String szbmmc) {
		this.szbmmc = szbmmc;
	}

	/**
	 * @return the zy
	 */
	public String getZy() {
		return zy;
	}

	/**
	 * @param zy
	 *            the zy to set
	 */
	public void setZy(String zy) {
		this.zy = zy;
	}

	/**
	 * @return the lxdh
	 */
	public String getLxdh() {
		return lxdh;
	}

	/**
	 * @param lxdh
	 *            the lxdh to set
	 */
	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}

	/**
	 * @return the dz_xzzdm
	 */
	public String getDz_xzzdm() {
		return dz_xzzdm;
	}

	/**
	 * @param dz_xzzdm
	 *            the dz_xzzdm to set
	 */
	public void setDz_xzzdm(String dz_xzzdm) {
		this.dz_xzzdm = dz_xzzdm;
	}

	/**
	 * @return the dz_xzzxzqhdm
	 */
	public String getDz_xzzxzqhdm() {
		return dz_xzzxzqhdm;
	}

	/**
	 * @param dz_xzzxzqhdm
	 *            the dz_xzzxzqhdm to set
	 */
	public void setDz_xzzxzqhdm(String dz_xzzxzqhdm) {
		this.dz_xzzxzqhdm = dz_xzzxzqhdm;
	}

	/**
	 * @return the dz_xzzxz
	 */
	public String getDz_xzzxz() {
		return dz_xzzxz;
	}

	/**
	 * @param dz_xzzxz
	 *            the dz_xzzxz to set
	 */
	public void setDz_xzzxz(String dz_xzzxz) {
		this.dz_xzzxz = dz_xzzxz;
	}

	/**
	 * @return the drjg
	 */
	public String getDrjg() {
		return drjg;
	}

	/**
	 * @param drjg
	 *            the drjg to set
	 */
	public void setDrjg(String drjg) {
		this.drjg = drjg;
	}

	/**
	 * @return the mxms
	 */
	public String getMxms() {
		return mxms;
	}

	/**
	 * @param mxms
	 *            the mxms to set
	 */
	public void setMxms(String mxms) {
		this.mxms = mxms;
	}

	/**
	 * @return the xt_lrsj
	 */
	public String getXt_lrsj() {
		return xt_lrsj;
	}

	/**
	 * @param xt_lrsj
	 *            the xt_lrsj to set
	 */
	public void setXt_lrsj(String xt_lrsj) {
		this.xt_lrsj = xt_lrsj;
	}

	/**
	 * @return the xt_lrrxm
	 */
	public String getXt_lrrxm() {
		return xt_lrrxm;
	}

	/**
	 * @param xt_lrrxm
	 *            the xt_lrrxm to set
	 */
	public void setXt_lrrxm(String xt_lrrxm) {
		this.xt_lrrxm = xt_lrrxm;
	}

	/**
	 * @return the xt_lrrid
	 */
	public String getXt_lrrid() {
		return xt_lrrid;
	}

	/**
	 * @param xt_lrrid
	 *            the xt_lrrid to set
	 */
	public void setXt_lrrid(String xt_lrrid) {
		this.xt_lrrid = xt_lrrid;
	}

	/**
	 * @return the xt_lrrbm
	 */
	public String getXt_lrrbm() {
		return xt_lrrbm;
	}

	/**
	 * @param xt_lrrbm
	 *            the xt_lrrbm to set
	 */
	public void setXt_lrrbm(String xt_lrrbm) {
		this.xt_lrrbm = xt_lrrbm;
	}

	/**
	 * @return the xt_lrrbmid
	 */
	public String getXt_lrrbmid() {
		return xt_lrrbmid;
	}

	/**
	 * @param xt_lrrbmid
	 *            the xt_lrrbmid to set
	 */
	public void setXt_lrrbmid(String xt_lrrbmid) {
		this.xt_lrrbmid = xt_lrrbmid;
	}

	/**
	 * @return the xt_lrip
	 */
	public String getXt_lrip() {
		return xt_lrip;
	}

	/**
	 * @param xt_lrip
	 *            the xt_lrip to set
	 */
	public void setXt_lrip(String xt_lrip) {
		this.xt_lrip = xt_lrip;
	}

	/**
	 * @return the xt_zhxgsj
	 */
	public String getXt_zhxgsj() {
		return xt_zhxgsj;
	}

	/**
	 * @param xt_zhxgsj
	 *            the xt_zhxgsj to set
	 */
	public void setXt_zhxgsj(String xt_zhxgsj) {
		this.xt_zhxgsj = xt_zhxgsj;
	}

	/**
	 * @return the xt_zhxgrxm
	 */
	public String getXt_zhxgrxm() {
		return xt_zhxgrxm;
	}

	/**
	 * @param xt_zhxgrxm
	 *            the xt_zhxgrxm to set
	 */
	public void setXt_zhxgrxm(String xt_zhxgrxm) {
		this.xt_zhxgrxm = xt_zhxgrxm;
	}

	/**
	 * @return the xt_zhxgrid
	 */
	public String getXt_zhxgrid() {
		return xt_zhxgrid;
	}

	/**
	 * @param xt_zhxgrid
	 *            the xt_zhxgrid to set
	 */
	public void setXt_zhxgrid(String xt_zhxgrid) {
		this.xt_zhxgrid = xt_zhxgrid;
	}

	/**
	 * @return the xt_zhxgrbm
	 */
	public String getXt_zhxgrbm() {
		return xt_zhxgrbm;
	}

	/**
	 * @param xt_zhxgrbm
	 *            the xt_zhxgrbm to set
	 */
	public void setXt_zhxgrbm(String xt_zhxgrbm) {
		this.xt_zhxgrbm = xt_zhxgrbm;
	}

	/**
	 * @return the xt_zhxgrbmid
	 */
	public String getXt_zhxgrbmid() {
		return xt_zhxgrbmid;
	}

	/**
	 * @param xt_zhxgrbmid
	 *            the xt_zhxgrbmid to set
	 */
	public void setXt_zhxgrbmid(String xt_zhxgrbmid) {
		this.xt_zhxgrbmid = xt_zhxgrbmid;
	}

	/**
	 * @return the xt_zhxgip
	 */
	public String getXt_zhxgip() {
		return xt_zhxgip;
	}

	/**
	 * @param xt_zhxgip
	 *            the xt_zhxgip to set
	 */
	public void setXt_zhxgip(String xt_zhxgip) {
		this.xt_zhxgip = xt_zhxgip;
	}

	/**
	 * @return the xt_zxbz
	 */
	public String getXt_zxbz() {
		return xt_zxbz;
	}

	/**
	 * @param xt_zxbz
	 *            the xt_zxbz to set
	 */
	public void setXt_zxbz(String xt_zxbz) {
		this.xt_zxbz = xt_zxbz;
	}

	/**
	 * @return the xt_zxyy
	 */
	public String getXt_zxyy() {
		return xt_zxyy;
	}

	/**
	 * @param xt_zxyy
	 *            the xt_zxyy to set
	 */
	public void setXt_zxyy(String xt_zxyy) {
		this.xt_zxyy = xt_zxyy;
	}

	/**
	 * @return the xt_cjsj
	 */
	public String getXt_cjsj() {
		return xt_cjsj;
	}

	/**
	 * @param xt_cjsj
	 *            the xt_cjsj to set
	 */
	public void setXt_cjsj(String xt_cjsj) {
		this.xt_cjsj = xt_cjsj;
	}

	/**
	 * @return the sfzt
	 */
	public String getSfzt() {
		return sfzt;
	}

	/**
	 * @param sfzt
	 *            the sfzt to set
	 */
	public void setSfzt(String sfzt) {
		this.sfzt = sfzt;
	}

}
