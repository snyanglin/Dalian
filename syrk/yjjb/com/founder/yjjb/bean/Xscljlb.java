package com.founder.yjjb.bean;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/**
 * 线索处理记录表</br>
 * 线索处理的详细记录</br>
 * @author dangkp
 * @since 2014-12-03
 * @version 1.0
 */
@DBInfoAnnotation(tableName = "YJJB_XSCLJLB", pk = "id")
	public class Xscljlb extends BaseEntity  {
	
	@FieldDesc("主键")
	private String id;
	
	@FieldDesc("线索编号")
	private String xsbh;
	
	@FieldDesc("操作内容")
	private String cznr;
	
	@FieldDesc("操作类型00-新增 10-递转 20-初查 30-复查 40-注销")
	private String czlx;
	
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

	public String getCznr() {
		return cznr;
	}

	public void setCznr(String cznr) {
		this.cznr = cznr;
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

	public String getCzlx() {
		return czlx;
	}

	public void setCzlx(String czlx) {
		this.czlx = czlx;
	}
}