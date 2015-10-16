package com.founder.zdrygl.base.model;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.base.model.Zdrylxylbdyb.java]  
 * @ClassName:    [Zdrylxylbdyb]   
 * @Description:  [重点人员类型与类别对应表]   
 * @Author:       [huang_jifei@founder.com.cn]  
 * @CreateDate:   [2015年10月9日 上午10:11:32]   
 * @UpdateUser:   [huangjifei(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年10月9日 上午10:11:32，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "ZDRY_ZDRYLXYLBDYB", pk = "id")
public class Zdrylxylbdyb  extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 3889720693149255293L;
	@FieldDesc("对应ID")private String id;
	@FieldDesc("重点人员类型代码")private String qydm;
	@FieldDesc("重点人员类别代码")private String lbdm;
	@FieldDesc("重点人员类别代码")private String lbdm_p;
	@FieldDesc("备注")private String fz;
	@FieldDesc("备注")private String bz;
	@FieldDesc("采集时间")private String xt_cjsj;
	@FieldDesc("录入时间")private String xt_lrsj;
	@FieldDesc("录入人姓名")private String xt_lrrxm;
	@FieldDesc("录入人ID")private String xt_lrrid;
	@FieldDesc("录入人部门")private String xt_lrrbm;
	@FieldDesc("录入人部门ID")private String xt_lrrbmid;
	@FieldDesc("录入IP")private String xt_lrip;
	@FieldDesc("最后修改时间")private String xt_zhxgsj;
	@FieldDesc("最后修改人姓名")private String xt_zhxgrxm;
	@FieldDesc("最后修改人ID")private String xt_zhxgrid;
	@FieldDesc("最后修改人部门")private String xt_zhxgrbm;
	@FieldDesc("最后修改人部门ID")private String xt_zhxgrbmid;
	@FieldDesc("最后修改IP")private String xt_zhxgip;
	@FieldDesc("注销标志")private String xt_zxbz;
	@FieldDesc("注销原因")private String xt_zxyy;
	@FieldDesc("是否显示在类别列表")private String showflag;
	@FieldDesc("类别对应JAVA服务类全路径名称")private String classname;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getQydm() {
		return qydm;
	}
	public void setQydm(String qydm) {
		this.qydm = qydm;
	}
	public String getLbdm() {
		return lbdm;
	}
	public void setLbdm(String lbdm) {
		this.lbdm = lbdm;
	}
	public String getLbdm_p() {
		return lbdm_p;
	}
	public void setLbdm_p(String lbdm_p) {
		this.lbdm_p = lbdm_p;
	}
	public String getFz() {
		return fz;
	}
	public void setFz(String fz) {
		this.fz = fz;
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
	public String getShowflag() {
		return showflag;
	}
	public void setShowflag(String showflag) {
		this.showflag = showflag;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	
	
}
