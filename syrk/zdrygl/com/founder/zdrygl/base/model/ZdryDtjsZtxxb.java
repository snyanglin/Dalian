package com.founder.zdrygl.base.model;

import java.io.Serializable;
import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.bean.ZdryDtjsZtxxb.java]  
 * @ClassName:    [ZdryDtjsZtxxb]   
 * @Description:  [重点人员 动态记实 在逃跑 属性表]   
 * @Author:       [cong_rihong@founder.com.cn]  
 * @CreateDate:   [2015年8月13日 下午7:10:27]   
 * @UpdateUser:   [congrihong(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年12月7日 下午7:10:27，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "ZDRY_DTJS_ZTXXB", pk = "id")
public class ZdryDtjsZtxxb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@FieldDesc("ID")
	private String id;
	@FieldDesc("所属类别")
	private String sslb;
	@FieldDesc("在逃类型")
	private String ztlx;
	@FieldDesc("立案时间")
	private String lasj;
	@FieldDesc("立案单位代码")
	private String ladwdm;
	@FieldDesc("立案单位名称")
	private String ladwmc;
	@FieldDesc("逃跑时间")
	private String tpsj;
	@FieldDesc("逃跑方向")
	private String tpfx;
	@FieldDesc("立逃日期")
	private String ltrq;
	@FieldDesc("立逃单位代码")
	private String ltdwdm;
	@FieldDesc("立逃单位名称")
	private String ltdwmc;
	@FieldDesc("案件类别")
	private String ajlb;
	@FieldDesc("督捕级别")
	private String dbjb;
	@FieldDesc("案情描述")
	private String aqms;
	@FieldDesc("重点证件号码")
	private String zdryzjhm;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSslb() {
		return sslb;
	}
	public void setSslb(String sslb) {
		this.sslb = sslb;
	}
	public String getZtlx() {
		return ztlx;
	}
	public void setZtlx(String ztlx) {
		this.ztlx = ztlx;
	}
	public String getLasj() {
		return lasj;
	}
	public void setLasj(String lasj) {
		this.lasj = lasj;
	}
	public String getLadwdm() {
		return ladwdm;
	}
	public void setLadwdm(String ladwdm) {
		this.ladwdm = ladwdm;
	}
	public String getLadwmc() {
		return ladwmc;
	}
	public void setLadwmc(String ladwmc) {
		this.ladwmc = ladwmc;
	}
	public String getTpsj() {
		return tpsj;
	}
	public void setTpsj(String tpsj) {
		this.tpsj = tpsj;
	}
	public String getTpfx() {
		return tpfx;
	}
	public void setTpfx(String tpfx) {
		this.tpfx = tpfx;
	}
	public String getLtrq() {
		return ltrq;
	}
	public void setLtrq(String ltrq) {
		this.ltrq = ltrq;
	}
	public String getLtdwdm() {
		return ltdwdm;
	}
	public void setLtdwdm(String ltdwdm) {
		this.ltdwdm = ltdwdm;
	}
	public String getLtdwmc() {
		return ltdwmc;
	}
	public void setLtdwmc(String ltdwmc) {
		this.ltdwmc = ltdwmc;
	}
	public String getAjlb() {
		return ajlb;
	}
	public void setAjlb(String ajlb) {
		this.ajlb = ajlb;
	}
	public String getDbjb() {
		return dbjb;
	}
	public void setDbjb(String dbjb) {
		this.dbjb = dbjb;
	}
	public String getAqms() {
		return aqms;
	}
	public void setAqms(String aqms) {
		this.aqms = aqms;
	}
	public String getZdryzjhm() {
		return zdryzjhm;
	}
	public void setZdryzjhm(String zdryzjhm) {
		this.zdryzjhm = zdryzjhm;
	}

	
}
