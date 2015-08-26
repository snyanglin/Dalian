package com.founder.zdrygl.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
/***
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.bean.Fzcsfryxxb.java]  
 * @ClassName:    [Fzcsfryxxb]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [wu_chunhui@founder.com.cn]  
 * @CreateDate:   [2015-3-11 下午6:08:02]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-3-11 下午6:08:02，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "ZDRY_FZCSFRYXXB", pk = "id")
public class ZdryFzcsfryxxb extends ZdryZdryzb implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@FieldDesc("重点人员ID")
	private String id;
	@FieldDesc("信息上报")
	private String xxsb;
	@FieldDesc("上访原因")
	private String sfyy;
	@FieldDesc("交控部门")
	private String jkbm;
	@FieldDesc("交控级别代码")
	private String jkjbdm;
	@FieldDesc("上访人员类别代码")
	private String sfrylbdm;
	@FieldDesc("已解决上访事项")
	private String yjjsfsx;
	@FieldDesc("未解决上访事项")
	private String wjjsfsx;
	@FieldDesc("制造舆论地点")
	private String zzyldd;
	@FieldDesc("接访部门")
	private String jfbm;
	@FieldDesc("涉访处罚情况")
	private String cfqk;
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
	public String getXxsb() {
		return xxsb;
	}
	public void setXxsb(String xxsb) {
		this.xxsb = xxsb;
	}
	public String getSfyy() {
		return sfyy;
	}
	public void setSfyy(String sfyy) {
		this.sfyy = sfyy;
	}
	public String getJkbm() {
		return jkbm;
	}
	public void setJkbm(String jkbm) {
		this.jkbm = jkbm;
	}
	public String getJkjbdm() {
		return jkjbdm;
	}
	public void setJkjbdm(String jkjbdm) {
		this.jkjbdm = jkjbdm;
	}
	public String getSfrylbdm() {
		return sfrylbdm;
	}
	public void setSfrylbdm(String sfrylbdm) {
		this.sfrylbdm = sfrylbdm;
	}
	public String getYjjsfsx() {
		return yjjsfsx;
	}
	public void setYjjsfsx(String yjjsfsx) {
		this.yjjsfsx = yjjsfsx;
	}
	public String getWjjsfsx() {
		return wjjsfsx;
	}
	public void setWjjsfsx(String wjjsfsx) {
		this.wjjsfsx = wjjsfsx;
	}
	public String getZzyldd() {
		return zzyldd;
	}
	public void setZzyldd(String zzyldd) {
		this.zzyldd = zzyldd;
	}
	public String getJfbm() {
		return jfbm;
	}
	public void setJfbm(String jfbm) {
		this.jfbm = jfbm;
	}
	public String getCfqk() {
		return cfqk;
	}
	public void setCfqk(String cfqk) {
		this.cfqk = cfqk;
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

	
}
