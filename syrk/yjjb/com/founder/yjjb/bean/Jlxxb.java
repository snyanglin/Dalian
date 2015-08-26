package com.founder.yjjb.bean;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;


/**
 * 奖励信息表</br>
 * 存放奖励的基本信息
 * @author yuhongyu
 * @since 2014-11-27
 * @version 1.0
 */
@DBInfoAnnotation(tableName = "YJJB_JLXXB", pk = "id")
public class Jlxxb extends BaseEntity {

	@FieldDesc("申请编号")
	private String id;

	@FieldDesc("申请的奖励金额")
	private Long sqje;

	@FieldDesc("发起申请的时间")
	private String sqsj;

	@FieldDesc("发起申请的单位ID")
	private String sqdw;

	@FieldDesc("发起申请的人员ID")
	private String sqr;

	@FieldDesc("审批通过、实际发放的金额")
	private Long jlje;

	@FieldDesc("最终审批状态：0-处理中 1-同意 2-拒绝")
	private String spzt;

	@FieldDesc("简要内容")
	private String jynr;
	
	@FieldDesc("受理分站处理意见：查证处理结果")
	private String slfzcljg;

	@FieldDesc("受理站处理意见")
	private String slzcljg;
	
	@FieldDesc("受理中心处理意见")
	private String slzxcljg;
	
	@FieldDesc("奖励的类型：0-举报奖励 1-捡拾物品奖励")
	private String jllx;

	@FieldDesc("申请的其他信息")
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

	@FieldDesc("受理分站审批时间")
	private String slfzspsj;
	
	@FieldDesc("受理站审批时间")
	private String slzspsj;
	
	@FieldDesc("受理中心审批时间")
	private String slzxspsj;
	
	//查询用
	@FieldDesc("接报开始时间")
	private String starttime;
	
	@FieldDesc("接报结束时间")
	private String endtime;
	
	
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getSqje() {
		return sqje;
	}

	public void setSqje(Long sqje) {
		this.sqje = sqje;
	}

	public String getSqsj() {
		return sqsj;
	}

	public void setSqsj(String sqsj) {
		this.sqsj = sqsj;
	}

	public String getSqdw() {
		return sqdw;
	}

	public void setSqdw(String sqdw) {
		this.sqdw = sqdw;
	}

	public String getSqr() {
		return sqr;
	}

	public void setSqr(String sqr) {
		this.sqr = sqr;
	}

	public Long getJlje() {
		return jlje;
	}

	public void setJlje(Long jlje) {
		this.jlje = jlje;
	}

	public String getSpzt() {
		return spzt;
	}

	public void setSpzt(String spzt) {
		this.spzt = spzt;
	}

	public String getSlfzcljg() {
		return slfzcljg;
	}

	public void setSlfzcljg(String slfzcljg) {
		this.slfzcljg = slfzcljg;
	}

	public String getSlzcljg() {
		return slzcljg;
	}

	public void setSlzcljg(String slzcljg) {
		this.slzcljg = slzcljg;
	}

	public String getSlzxcljg() {
		return slzxcljg;
	}

	public void setSlzxcljg(String slzxcljg) {
		this.slzxcljg = slzxcljg;
	}

	public String getJllx() {
		return jllx;
	}

	public void setJllx(String jllx) {
		this.jllx = jllx;
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

	public String getJynr() {
		return jynr;
	}

	public void setJynr(String jynr) {
		this.jynr = jynr;
	}

	public String getSlfzspsj() {
		return slfzspsj;
	}

	public void setSlfzspsj(String slfzspsj) {
		this.slfzspsj = slfzspsj;
	}

	public String getSlzspsj() {
		return slzspsj;
	}

	public void setSlzspsj(String slzspsj) {
		this.slzspsj = slzspsj;
	}

	public String getSlzxspsj() {
		return slzxspsj;
	}

	public void setSlzxspsj(String slzxspsj) {
		this.slzxspsj = slzxspsj;
	}
}
