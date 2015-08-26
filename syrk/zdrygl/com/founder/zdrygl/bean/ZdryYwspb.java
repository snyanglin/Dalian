package com.founder.zdrygl.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/***
 * ****************************************************************************
 * 
 * @Package: [com.founder.zdrygl.bean.Ywspb.java]
 * @ClassName: [Ywspb]
 * @Description: [一句话描述该类的功能]
 * @Author: [wu_chunhui@founder.com.cn]
 * @CreateDate: [2015-3-11 下午6:09:07]
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-3-11 下午6:09:07，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@DBInfoAnnotation(tableName = "ZDRY_YWSPB", pk = "id")
public class ZdryYwspb extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@FieldDesc("重点人员审批ID")
	private String id;
	@FieldDesc("业务表名")
	private String ywbm;
	@FieldDesc("业务表ID")
	private String ywbid;
	@FieldDesc("申请人_姓名")
	private String sqr_xm;
	@FieldDesc("申请人_ID")
	private String sqr_id;
	@FieldDesc("申请时间")
	private String sqsj;
	@FieldDesc("审批部门")
	private String spbm;
	@FieldDesc("审批人_姓名")
	private String spr_xm;
	@FieldDesc("审批人_ID")
	private String spr_id;
	@FieldDesc("审批时间")
	private String spsj;
	@FieldDesc("审批结果")
	private String spjg;
	@FieldDesc("审批意见")
	private String spyj;
	@FieldDesc("备注")
	private String bz;
	@FieldDesc("申请意见")
	private String sqyj;

	
	
	public String getSqyj() {
		return sqyj;
	}

	public void setSqyj(String sqyj) {
		this.sqyj = sqyj;
	}

	public String getSpbm() {
		return spbm;
	}

	public void setSpbm(String spbm) {
		this.spbm = spbm;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getYwbm() {
		return ywbm;
	}

	public void setYwbm(String ywbm) {
		this.ywbm = ywbm;
	}

	public String getYwbid() {
		return ywbid;
	}

	public void setYwbid(String ywbid) {
		this.ywbid = ywbid;
	}

	public String getSqr_xm() {
		return sqr_xm;
	}

	public void setSqr_xm(String sqr_xm) {
		this.sqr_xm = sqr_xm;
	}

	public String getSqr_id() {
		return sqr_id;
	}

	public void setSqr_id(String sqr_id) {
		this.sqr_id = sqr_id;
	}

	public String getSqsj() {
		return sqsj;
	}

	public void setSqsj(String sqsj) {
		this.sqsj = sqsj;
	}

	public String getSpr_xm() {
		return spr_xm;
	}

	public void setSpr_xm(String spr_xm) {
		this.spr_xm = spr_xm;
	}

	public String getSpr_id() {
		return spr_id;
	}

	public void setSpr_id(String spr_id) {
		this.spr_id = spr_id;
	}

	public String getSpsj() {
		return spsj;
	}

	public void setSpsj(String spsj) {
		this.spsj = spsj;
	}

	public String getSpjg() {
		return spjg;
	}

	public void setSpjg(String spjg) {
		this.spjg = spjg;
	}

	public String getSpyj() {
		return spyj;
	}

	public void setSpyj(String spyj) {
		this.spyj = spyj;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

}
