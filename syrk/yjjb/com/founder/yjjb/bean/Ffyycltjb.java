package com.founder.yjjb.bean;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/**
 * 非法营运车辆统计表</br>
 * @author dangkp
 * @since 2014-12-19
 * @version 1.0
 */
@DBInfoAnnotation(tableName = "YJJB_FFYYCLTJB", pk = "id")
public class Ffyycltjb extends BaseEntity  {
	
	@FieldDesc("主键")
	private String id;

	@FieldDesc("统计类别01-打击团伙构成刑事犯罪的 02查扣收缴套牌、克隆等车辆，构成行政处罚 03 查扣从事非法运营的私家车，构成行政处罚")
	private String tjlb;

	@FieldDesc("司机姓名")
	private String sjxm;

	@FieldDesc("司机身份证号码")
	private String sjsfzhm;

	@FieldDesc("司机电话")
	private String sjdh;

	@FieldDesc("车牌照号码")
	private String cpzhm;

	@FieldDesc("车型：货车、汽车、皮卡、重卡（待确认）02必填")
	private String cx;

	@FieldDesc("案件编号02、03必填")
	private String ajbh;

	@FieldDesc("处罚部门03必填")
	private String cfbm;

	@FieldDesc("处罚结果03必填")
	private String cfjg;

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
	
	@FieldDesc("所属受理分站")
	private String slfzdm;
	
	@FieldDesc("所属受理站")
	private String slzdm;

	@FieldDesc("所属受理中心")
	private String slzxdm;

	public String getSlfzdm() {
		return slfzdm;
	}

	public void setSlfzdm(String slfzdm) {
		this.slfzdm = slfzdm;
	}

	public String getSlzdm() {
		return slzdm;
	}

	public void setSlzdm(String slzdm) {
		this.slzdm = slzdm;
	}

	public String getSlzxdm() {
		return slzxdm;
	}

	public void setSlzxdm(String slzxdm) {
		this.slzxdm = slzxdm;
	}

	//查询用
	@FieldDesc("接报开始时间")
	private String starttime;
	
	@FieldDesc("接报结束时间")
	private String endtime;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTjlb() {
		return tjlb;
	}

	public void setTjlb(String tjlb) {
		this.tjlb = tjlb;
	}

	public String getSjxm() {
		return sjxm;
	}

	public void setSjxm(String sjxm) {
		this.sjxm = sjxm;
	}

	public String getSjsfzhm() {
		return sjsfzhm;
	}

	public void setSjsfzhm(String sjsfzhm) {
		this.sjsfzhm = sjsfzhm;
	}

	public String getSjdh() {
		return sjdh;
	}

	public void setSjdh(String sjdh) {
		this.sjdh = sjdh;
	}

	public String getCpzhm() {
		return cpzhm;
	}

	public void setCpzhm(String cpzhm) {
		this.cpzhm = cpzhm;
	}

	public String getCx() {
		return cx;
	}

	public void setCx(String cx) {
		this.cx = cx;
	}

	public String getAjbh() {
		return ajbh;
	}

	public void setAjbh(String ajbh) {
		this.ajbh = ajbh;
	}

	public String getCfbm() {
		return cfbm;
	}

	public void setCfbm(String cfbm) {
		this.cfbm = cfbm;
	}

	public String getCfjg() {
		return cfjg;
	}

	public void setCfjg(String cfjg) {
		this.cfjg = cfjg;
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

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	
}