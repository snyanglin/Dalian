/**********************************************************************   
 * <p>文件名：Cyrydrrwxxb.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author wu_chunhui@founder.com.cn 
 * @date 2014-11-26 下午3:25:17 
 * @history
 * @department：研发部
 *
 */
package com.founder.sydw_dl.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/******************************************************************************
 * @Package: [com.founder.sydw_dl.bean.Cyrydrrwxxb.java]
 * @ClassName: [Cyrydrrwxxb]
 * @Description: [一句话描述该类的功能]
 * @Author: [wu_chunhui@founder.com.cn]
 * @CreateDate: [2014-11-26 下午3:25:17]
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2014-11-26 下午3:25:17，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@DBInfoAnnotation(tableName = "DW_CYRYDRRWMXB", pk = "id")
public class Cyrydrrwxxb extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@FieldDesc("导入任务id")
	private String id;
	@FieldDesc("单位ID")
	private String dwid;
	@FieldDesc("任务名称")
	private String rwmc;
	@FieldDesc("导入人名称")
	private String drrmc;
	@FieldDesc("导入人部门代码")
	private String drrbmdm;
	@FieldDesc("导入时间")
	private String drsj;
	@FieldDesc("任务状态")
	private String rwzt;
	@FieldDesc("任务说明")
	private String rwsm;
	@FieldDesc("任务耗时")
	private String rwhs;
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
	
	private String dwmc;
	


	/**
	 * @return the dwmc
	 */
	public String getDwmc() {
		return dwmc;
	}

	/**
	 * @param dwmc the dwmc to set
	 */
	public void setDwmc(String dwmc) {
		this.dwmc = dwmc;
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
	 * @return the rwmc
	 */
	public String getRwmc() {
		return rwmc;
	}

	/**
	 * @param rwmc
	 *            the rwmc to set
	 */
	public void setRwmc(String rwmc) {
		this.rwmc = rwmc;
	}

	/**
	 * @return the drrmc
	 */
	public String getDrrmc() {
		return drrmc;
	}

	/**
	 * @param drrmc
	 *            the drrmc to set
	 */
	public void setDrrmc(String drrmc) {
		this.drrmc = drrmc;
	}

	/**
	 * @return the drrbmdm
	 */
	public String getDrrbmdm() {
		return drrbmdm;
	}

	/**
	 * @param drrbmdm
	 *            the drrbmdm to set
	 */
	public void setDrrbmdm(String drrbmdm) {
		this.drrbmdm = drrbmdm;
	}

	/**
	 * @return the drsj
	 */
	public String getDrsj() {
		return drsj;
	}

	/**
	 * @param drsj
	 *            the drsj to set
	 */
	public void setDrsj(String drsj) {
		this.drsj = drsj;
	}

	/**
	 * @return the rwzt
	 */
	public String getRwzt() {
		return rwzt;
	}

	/**
	 * @param rwzt
	 *            the rwzt to set
	 */
	public void setRwzt(String rwzt) {
		this.rwzt = rwzt;
	}

	/**
	 * @return the rwsm
	 */
	public String getRwsm() {
		return rwsm;
	}

	/**
	 * @param rwsm
	 *            the rwsm to set
	 */
	public void setRwsm(String rwsm) {
		this.rwsm = rwsm;
	}

	/**
	 * @return the rwhs
	 */
	public String getRwhs() {
		return rwhs;
	}

	/**
	 * @param rwhs
	 *            the rwhs to set
	 */
	public void setRwhs(String rwhs) {
		this.rwhs = rwhs;
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


}
