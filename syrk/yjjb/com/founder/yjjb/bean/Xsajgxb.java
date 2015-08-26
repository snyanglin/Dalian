package com.founder.yjjb.bean;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/**
 * 案件信息表</br>
 * 存放案件的基本信息
 * @author yuhongyu
 * @since 2014-11-18
 * @version 1.0
 */
@DBInfoAnnotation(tableName = "YJJB_AJXXB", pk = "id")
public class Xsajgxb extends BaseEntity  {

	@FieldDesc("主键")
	private String id;

	@FieldDesc("线索编号")
	private String xsbh;

	@FieldDesc("案件编号")
	private String ajbh;

	@FieldDesc("是否发放奖励：0-否 1-是")
	private String sfffjl;

	@FieldDesc("其他信息")
	private String bz;
	
	@FieldDesc("案件来源")
	private String ajsource;

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
	
	@FieldDesc("案件名称")
	private String	ajmc;
	
	@FieldDesc("办案单位")
	private String	badw;
	
	@FieldDesc("案件状态:0-受案 1-立案 2-破案")
	private String	ajzt;
	
	@FieldDesc("案件主键")
	private String ajId;
	
	@FieldDesc("案件的录入人部门")
	private String bumen;

	@FieldDesc("受理时间")
	private String slsj;
	
	@FieldDesc("简要案情")
	private String jyaq;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getXsbh() {
		return xsbh;
	}

	public void setXsbh(String xsbh) {
		this.xsbh = xsbh;
	}

	public String getAjbh() {
		return ajbh;
	}

	public void setAjbh(String ajbh) {
		this.ajbh = ajbh;
	}

	public String getSfffjl() {
		return sfffjl;
	}

	public void setSfffjl(String sfffjl) {
		this.sfffjl = sfffjl;
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

	public void setXt_cjsj(String xtCjsj) {
		xt_cjsj = xtCjsj;
	}

	public String getXt_lrsj() {
		return xt_lrsj;
	}

	public void setXt_lrsj(String xtLrsj) {
		xt_lrsj = xtLrsj;
	}

	public String getXt_lrrxm() {
		return xt_lrrxm;
	}

	public void setXt_lrrxm(String xtLrrxm) {
		xt_lrrxm = xtLrrxm;
	}

	public String getXt_lrrid() {
		return xt_lrrid;
	}

	public void setXt_lrrid(String xtLrrid) {
		xt_lrrid = xtLrrid;
	}

	public String getXt_lrrbm() {
		return xt_lrrbm;
	}

	public void setXt_lrrbm(String xtLrrbm) {
		xt_lrrbm = xtLrrbm;
	}

	public String getXt_lrrbmid() {
		return xt_lrrbmid;
	}

	public void setXt_lrrbmid(String xtLrrbmid) {
		xt_lrrbmid = xtLrrbmid;
	}

	public String getXt_lrip() {
		return xt_lrip;
	}

	public void setXt_lrip(String xtLrip) {
		xt_lrip = xtLrip;
	}

	public String getXt_zhxgsj() {
		return xt_zhxgsj;
	}

	public void setXt_zhxgsj(String xtZhxgsj) {
		xt_zhxgsj = xtZhxgsj;
	}

	public String getXt_zhxgrxm() {
		return xt_zhxgrxm;
	}

	public void setXt_zhxgrxm(String xtZhxgrxm) {
		xt_zhxgrxm = xtZhxgrxm;
	}

	public String getXt_zhxgrid() {
		return xt_zhxgrid;
	}

	public void setXt_zhxgrid(String xtZhxgrid) {
		xt_zhxgrid = xtZhxgrid;
	}

	public String getXt_zhxgrbm() {
		return xt_zhxgrbm;
	}

	public void setXt_zhxgrbm(String xtZhxgrbm) {
		xt_zhxgrbm = xtZhxgrbm;
	}

	public String getXt_zhxgrbmid() {
		return xt_zhxgrbmid;
	}

	public void setXt_zhxgrbmid(String xtZhxgrbmid) {
		xt_zhxgrbmid = xtZhxgrbmid;
	}

	public String getXt_zhxgip() {
		return xt_zhxgip;
	}

	public void setXt_zhxgip(String xtZhxgip) {
		xt_zhxgip = xtZhxgip;
	}

	public String getXt_zxbz() {
		return xt_zxbz;
	}

	public void setXt_zxbz(String xtZxbz) {
		xt_zxbz = xtZxbz;
	}

	public String getXt_zxyy() {
		return xt_zxyy;
	}

	public void setXt_zxyy(String xtZxyy) {
		xt_zxyy = xtZxyy;
	}

	public void setAjmc(String ajmc) {
		this.ajmc = ajmc;
	}

	public String getAjmc() {
		return ajmc;
	}

	public void setBadw(String badw) {
		this.badw = badw;
	}

	public String getBadw() {
		return badw;
	}

	public void setAjzt(String ajzt) {
		this.ajzt = ajzt;
	}

	public String getAjzt() {
		return ajzt;
	}

	public void setAjId(String ajId) {
		this.ajId = ajId;
	}

	public String getAjId() {
		return ajId;
	}

	public void setBumen(String bumen) {
		this.bumen = bumen;
	}

	public String getBumen() {
		return bumen;
	}

	/**
	 * @return the ajsource
	 */
	public String getAjsource() {
		return ajsource;
	}

	/**
	 * @param ajsource the ajsource to set
	 */
	public void setAjsource(String ajsource) {
		this.ajsource = ajsource;
	}

	/**
	 * @return the slsj
	 */
	public String getSlsj() {
		return slsj;
	}

	/**
	 * @param slsj the slsj to set
	 */
	public void setSlsj(String slsj) {
		this.slsj = slsj;
	}

	/**
	 * @return the jyaq
	 */
	public String getJyaq() {
		return jyaq;
	}

	/**
	 * @param jyaq the jyaq to set
	 */
	public void setJyaq(String jyaq) {
		this.jyaq = jyaq;
	}
}