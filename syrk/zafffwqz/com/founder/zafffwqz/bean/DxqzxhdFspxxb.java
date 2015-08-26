package com.founder.zafffwqz.bean;
import java.io.Serializable;

import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/******************************************************************************
 * @Package:      [com.founder.zafffwqz.bean.DxqzxhdFspxxb.java]  
 * @ClassName:    [DxqzxhdFspxxb]   
 * @Description:  [大型群众性活动非审批信息表]   
 * @Author:       [xu_haibo@founder.com.cn]  
 * @CreateDate:   [2015-5-21 上午9:29:34]   
 * @UpdateUser:   [haibo(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-21 上午9:29:34，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
public class DxqzxhdFspxxb  extends BaseEntity implements Serializable{
	@FieldDesc("大型群众性活动基本信息ID")
	private String id;
	@FieldDesc("填报单位")
	private String tbdw;
	@FieldDesc("填报时间")
	private String tbsj;
	@FieldDesc("活动名称")
	private String hdmc;
	@FieldDesc("活动规模")
	private String hdgm;
	@FieldDesc("活动地点")
	private String hddd;
	@FieldDesc("活动开始时间")
	private String hdkssj;
	@FieldDesc("活动结束时间")
	private String hdjssj;
	@FieldDesc("举办单位")
	private String jbdw;
	@FieldDesc("承办单位")
	private String cbdw;
	@FieldDesc("承办单位负责人")
	private String cbdwfzr;
	@FieldDesc("联系方式")
	private String lxfs;
	@FieldDesc("活动主要内容")
	private String hdzynr;
	@FieldDesc("市（县/区）局意见")
	private String sxqjyj;
	@FieldDesc("填表人")
	private String tbr;
	@FieldDesc("审核人")
	private String shr;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTbdw() {
		return tbdw;
	}
	public void setTbdw(String tbdw) {
		this.tbdw = tbdw;
	}
	public String getTbsj() {
		return tbsj;
	}
	public void setTbsj(String tbsj) {
		this.tbsj = tbsj;
	}
	public String getHdmc() {
		return hdmc;
	}
	public void setHdmc(String hdmc) {
		this.hdmc = hdmc;
	}
	public String getHdgm() {
		return hdgm;
	}
	public void setHdgm(String hdgm) {
		this.hdgm = hdgm;
	}
	public String getHddd() {
		return hddd;
	}
	public void setHddd(String hddd) {
		this.hddd = hddd;
	}
	public String getJbdw() {
		return jbdw;
	}
	public void setJbdw(String jbdw) {
		this.jbdw = jbdw;
	}
	public String getCbdw() {
		return cbdw;
	}
	public void setCbdw(String cbdw) {
		this.cbdw = cbdw;
	}
	public String getCbdwfzr() {
		return cbdwfzr;
	}
	public void setCbdwfzr(String cbdwfzr) {
		this.cbdwfzr = cbdwfzr;
	}
	public String getLxfs() {
		return lxfs;
	}
	public void setLxfs(String lxfs) {
		this.lxfs = lxfs;
	}
	public String getHdzynr() {
		return hdzynr;
	}
	public void setHdzynr(String hdzynr) {
		this.hdzynr = hdzynr;
	}
	public String getSxqjyj() {
		return sxqjyj;
	}
	public void setSxqjyj(String sxqjyj) {
		this.sxqjyj = sxqjyj;
	}
	public String getTbr() {
		return tbr;
	}
	public void setTbr(String tbr) {
		this.tbr = tbr;
	}
	public String getShr() {
		return shr;
	}
	public void setShr(String shr) {
		this.shr = shr;
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
	public String getHdkssj() {
		return hdkssj;
	}
	public void setHdkssj(String hdkssj) {
		this.hdkssj = hdkssj;
	}
	public String getHdjssj() {
		return hdjssj;
	}
	public void setHdjssj(String hdjssj) {
		this.hdjssj = hdjssj;
	}
	
	
}
