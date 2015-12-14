package com.founder.yjjb.bean;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;


/**
 * 线索征集信息表</br>
 * 存放线索征集的基本信息
 * @author chenwenlong
 * @since 2014-11-27
 * @version 1.0
 */
@DBInfoAnnotation(tableName = "YJJB_XSZJXXB", pk = "id")
public class Xszjxxb extends BaseEntity {


	@FieldDesc("主键") 
	private String id;
	
	@FieldDesc("发起申请的单位ID") 
	private String sqdw;
	
	@FieldDesc("发起申请的人员ID") 
	private String sqr;
	
	@FieldDesc("发起申请的人员的联系方式") 
	private String sqrlxfs;
	
	@FieldDesc("发起申请的时间") 
	private String sqsj;
	
	@FieldDesc("要征集线索的案件的简要描述") 
	private String jyaq;
	
	@FieldDesc("盗窃、交通肇事、贩毒等") 
	private String ajxz;
	
	@FieldDesc("最终审批状态：0-处理中 1-同意 2-拒绝") 
	private String spzt;
	
	@FieldDesc("审批通过的时间") 
	private String sptgsj;
	
	@FieldDesc("需要的线索信息") 
	private String zjdxsxx;
	
	@FieldDesc("本线索的最终处理意见") 
	private String cljg;
	
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
	@FieldDesc("开始时间")
	private String starttime;
	
	@FieldDesc("结束时间")
	private String endtime;
	
	@FieldDesc("申请人姓名")
	private String sqrxm;
	
	@FieldDesc("同意")
	private String ty;
	
	public String getTy() {
		return ty;
	}

	public void setTy(String ty) {
		this.ty = ty;
	}

	public String getSqrxm() {
		return sqrxm;
	}

	public void setSqrxm(String sqrxm) {
		this.sqrxm = sqrxm;
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

	public void setXt_zhxgip(String xt_zhxgip) {
		this.xt_zhxgip = xt_zhxgip;
	}

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getSqrlxfs() {
		return sqrlxfs;
	}

	public void setSqrlxfs(String sqrlxfs) {
		this.sqrlxfs = sqrlxfs;
	}

	public String getSqsj() {
		return sqsj;
	}

	public void setSqsj(String sqsj) {
		this.sqsj = sqsj;
	}

	public String getJyaq() {
		return jyaq;
	}

	public void setJyaq(String jyaq) {
		this.jyaq = jyaq;
	}

	public String getAjxz() {
		return ajxz;
	}

	public void setAjxz(String ajxz) {
		this.ajxz = ajxz;
	}

	public String getSpzt() {
		return spzt;
	}

	public void setSpzt(String spzt) {
		this.spzt = spzt;
	}

	public String getSptgsj() {
		return sptgsj;
	}

	public void setSptgsj(String sptgsj) {
		this.sptgsj = sptgsj;
	}

	public String getZjdxsxx() {
		return zjdxsxx;
	}

	public void setZjdxsxx(String zjdxsxx) {
		this.zjdxsxx = zjdxsxx;
	}

	public String getCljg() {
		return cljg;
	}

	public void setCljg(String cljg) {
		this.cljg = cljg;
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

	public void setXt_zhxgid(String xt_zhxgip) {
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
	
	
}
