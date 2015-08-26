package com.founder.zafffwqz.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;


/******************************************************************************
 * @Package:      [com.founder.zafffwqz.bean.DxhdCbfxxb.java]  
 * @ClassName:    [DxhdCbfxxb]   
 * @Description:  [大型活动承办方信息表]   
 * @Author:       [xuhaibo@founder.com.cn]  
 * @CreateDate:   [2015-5-14 中午12:50:47]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-14 中午12:50:47，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@DBInfoAnnotation(tableName = "DXQZXHD_CBFXXB", pk = "id")
public class DxqzxhdCbfxxb extends BaseEntity implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@FieldDesc("活动ID")
	private String hdid;
	@FieldDesc("活动承办者代码")
	private String hdcbzdm;
	@FieldDesc("承办部门名称")
	private String cbbmmc;
	@FieldDesc("法人_姓名")
	private String frxm;
	@FieldDesc("法人_证件种类代码")
	private String frzjzldm;
	@FieldDesc("法人_证件号")
	private String frzjhm;
	@FieldDesc("活动负责人")
	private String hdfzr;
	@FieldDesc("活动负责人职务")
	private String hdfzrzw;
	@FieldDesc("活动负责人证件种类代码")
	private String hdfzrzjzldm;
	@FieldDesc("活动负责人证件号码")
	private String hdfzrzjhm;
	@FieldDesc("活动负责人联系电话")
	private String hdfzrlxdh;
	@FieldDesc("活动联系人")
	private String hdlxr;
	@FieldDesc("活动联系人职务")
	private String hdlxrzw;
	@FieldDesc("活动联系人证件种类代码")
	private String hdlxrzjzldm;
	@FieldDesc("活动联系人证件号码")
	private String hdlxrzjhm;
	@FieldDesc("活动联系人联系电话")
	private String hdlxrlxdh;
	@FieldDesc("活动安全负责人")
	private String hdaqfzr;
	@FieldDesc("活动安全负责人职务")
	private String hdaqfzrzw;
	@FieldDesc("活动安全负责人证件种类代码")
	private String hdaqfzrzjzldm;
	@FieldDesc("活动安全负责人证件号码")
	private String hdaqfzrzjhm;
	@FieldDesc("活动安全负责人联系电话")
	private String hdaqfzrlxdh;
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
	public String getHdid() {
		return hdid;
	}
	public void setHdid(String hdid) {
		this.hdid = hdid;
	}
	public String getHdcbzdm() {
		return hdcbzdm;
	}
	public void setHdcbzdm(String hdcbzdm) {
		this.hdcbzdm = hdcbzdm;
	}
	public String getCbbmmc() {
		return cbbmmc;
	}
	public void setCbbmmc(String cbbmmc) {
		this.cbbmmc = cbbmmc;
	}
	public String getFrxm() {
		return frxm;
	}
	public void setFrxm(String frxm) {
		this.frxm = frxm;
	}
	public String getFrzjzldm() {
		return frzjzldm;
	}
	public void setFrzjzldm(String frzjzldm) {
		this.frzjzldm = frzjzldm;
	}
	public String getFrzjhm() {
		return frzjhm;
	}
	public void setFrzjhm(String frzjhm) {
		this.frzjhm = frzjhm;
	}
	public String getHdfzr() {
		return hdfzr;
	}
	public void setHdfzr(String hdfzr) {
		this.hdfzr = hdfzr;
	}
	public String getHdfzrzw() {
		return hdfzrzw;
	}
	public void setHdfzrzw(String hdfzrzw) {
		this.hdfzrzw = hdfzrzw;
	}
	public String getHdfzrzjzldm() {
		return hdfzrzjzldm;
	}
	public void setHdfzrzjzldm(String hdfzrzjzldm) {
		this.hdfzrzjzldm = hdfzrzjzldm;
	}
	public String getHdfzrzjhm() {
		return hdfzrzjhm;
	}
	public void setHdfzrzjhm(String hdfzrzjhm) {
		this.hdfzrzjhm = hdfzrzjhm;
	}
	public String getHdfzrlxdh() {
		return hdfzrlxdh;
	}
	public void setHdfzrlxdh(String hdfzrlxdh) {
		this.hdfzrlxdh = hdfzrlxdh;
	}
	public String getHdlxr() {
		return hdlxr;
	}
	public void setHdlxr(String hdlxr) {
		this.hdlxr = hdlxr;
	}
	public String getHdlxrzw() {
		return hdlxrzw;
	}
	public void setHdlxrzw(String hdlxrzw) {
		this.hdlxrzw = hdlxrzw;
	}
	public String getHdlxrzjzldm() {
		return hdlxrzjzldm;
	}
	public void setHdlxrzjzldm(String hdlxrzjzldm) {
		this.hdlxrzjzldm = hdlxrzjzldm;
	}
	public String getHdlxrzjhm() {
		return hdlxrzjhm;
	}
	public void setHdlxrzjhm(String hdlxrzjhm) {
		this.hdlxrzjhm = hdlxrzjhm;
	}
	public String getHdlxrlxdh() {
		return hdlxrlxdh;
	}
	public void setHdlxrlxdh(String hdlxrlxdh) {
		this.hdlxrlxdh = hdlxrlxdh;
	}
	public String getHdaqfzr() {
		return hdaqfzr;
	}
	public void setHdaqfzr(String hdaqfzr) {
		this.hdaqfzr = hdaqfzr;
	}
	public String getHdaqfzrzw() {
		return hdaqfzrzw;
	}
	public void setHdaqfzrzw(String hdaqfzrzw) {
		this.hdaqfzrzw = hdaqfzrzw;
	}
	public String getHdaqfzrzjzldm() {
		return hdaqfzrzjzldm;
	}
	public void setHdaqfzrzjzldm(String hdaqfzrzjzldm) {
		this.hdaqfzrzjzldm = hdaqfzrzjzldm;
	}
	public String getHdaqfzrzjhm() {
		return hdaqfzrzjhm;
	}
	public void setHdaqfzrzjhm(String hdaqfzrzjhm) {
		this.hdaqfzrzjhm = hdaqfzrzjhm;
	}
	public String getHdaqfzrlxdh() {
		return hdaqfzrlxdh;
	}
	public void setHdaqfzrlxdh(String hdaqfzrlxdh) {
		this.hdaqfzrlxdh = hdaqfzrlxdh;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}
