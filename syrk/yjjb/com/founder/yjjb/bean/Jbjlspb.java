package com.founder.yjjb.bean;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;


/**
 * 举报奖励信息表</br>
 * 存放举报奖励申请的基本信息
 * @author yuhongyu
 * @since 2014-11-27
 * @version 1.0
 */
@DBInfoAnnotation(tableName = "YJJB_JBJLSPB", pk = "id")
public class Jbjlspb extends BaseEntity {

	@FieldDesc("主键")
	private String id;

	@FieldDesc("线索征集表的ID")
	private String sqbh;

	@FieldDesc("申请发起的时间")
	private String sqsj;

	@FieldDesc("本条审批记录的发起方")
	private String sqdw;

	@FieldDesc("本条审批记录的接收方（当前处理单位）")
	private String spdw;

	@FieldDesc("审批状态：0-处理中 1-同意 2-拒绝")
	private String spzt;

	@FieldDesc("审批人审批时填写意见")
	private String sphf;

	@FieldDesc("本条申请记录的上一流程的编号")
	private String lybh;

	@FieldDesc("建议发放的金额")
	private Long jyje;

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

	//查询用
	@FieldDesc("接报开始时间")
	private String starttime;
	
	@FieldDesc("接报结束时间")
	private String endtime;
	
	@FieldDesc("审批单位")
	private String spdwV;
	
	@FieldDesc("录入时间")
	private String xt_lrsjV;
	
	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSqbh() {
		return sqbh;
	}

	public void setSqbh(String sqbh) {
		this.sqbh = sqbh;
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

	public String getSpdw() {
		return spdw;
	}

	public void setSpdw(String spdw) {
		this.spdw = spdw;
	}

	public String getSpzt() {
		return spzt;
	}

	public void setSpzt(String spzt) {
		this.spzt = spzt;
	}

	public String getSphf() {
		return sphf;
	}

	public void setSphf(String sphf) {
		this.sphf = sphf;
	}

	public String getLybh() {
		return lybh;
	}

	public void setLybh(String lybh) {
		this.lybh = lybh;
	}

	public Long getJyje() {
		return jyje;
	}

	public void setJyje(Long jyje) {
		this.jyje = jyje;
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

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	/**
	 * @return the spdwV
	 */
	public String getSpdwV() {
		return spdwV;
	}

	/**
	 * @param spdwV the spdwV to set
	 */
	public void setSpdwV(String spdwV) {
		this.spdwV = spdwV;
	}

	/**
	 * @return the xt_lrsjV
	 */
	public String getXt_lrsjV() {
		return xt_lrsjV;
	}

	/**
	 * @param xt_lrsjV the xt_lrsjV to set
	 */
	public void setXt_lrsjV(String xt_lrsjV) {
		this.xt_lrsjV = xt_lrsjV;
	}
	
}
