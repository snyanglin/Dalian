package com.founder.qbld.bean;

import java.io.Serializable;
import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.bean.ZdryZt.java]  
 * @ClassName:    [ZdryZt]   
 * @Description:  [重点人员在逃表]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-5-29 下午5:38:50]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-29 下午5:38:50，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "QBLD_SK_ZDRY_ZTXX", pk = "id")
public class ZdryZt extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@FieldDesc("ID")
	private String id;
	@FieldDesc("XSXXBH")
	private String xsxxbh;
	@FieldDesc("SSLB")
	private String sslb;
	@FieldDesc("ZTLX")
	private String ztlx;
	@FieldDesc("LASJ")
	private String lasj;
	@FieldDesc("LADWDM")
	private String ladwdm;
	@FieldDesc("LADWMC")
	private String ladwmc;
	@FieldDesc("TPSJ")
	private String tpsj;
	@FieldDesc("TPFX")
	private String tpfx;
	@FieldDesc("LTRQ")
	private String ltrq;
	@FieldDesc("LTDWDM")
	private String ltdwdm;
	@FieldDesc("LTDWMC")
	private String ltdwmc;
	@FieldDesc("AJLB")
	private String ajlb;
	@FieldDesc("DBJB")
	private String dbjb;
	@FieldDesc("AQMS")
	private String aqms;
	@FieldDesc("TXRQ")
	private String txrq;
	@FieldDesc("XGRQ")
	private String xgrq;
	@FieldDesc("ZDRYZJHM")
	private String zdryzjhm;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getXsxxbh() {
		return xsxxbh;
	}
	public void setXsxxbh(String xsxxbh) {
		this.xsxxbh = xsxxbh;
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
	public String getTxrq() {
		return txrq;
	}
	public void setTxrq(String txrq) {
		this.txrq = txrq;
	}
	public String getXgrq() {
		return xgrq;
	}
	public void setXgrq(String xgrq) {
		this.xgrq = xgrq;
	}
	public String getZdryzjhm() {
		return zdryzjhm;
	}
	public void setZdryzjhm(String zdryzjhm) {
		this.zdryzjhm = zdryzjhm;
	}

}
