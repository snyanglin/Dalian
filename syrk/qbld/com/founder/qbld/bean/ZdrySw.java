package com.founder.qbld.bean;

import java.io.Serializable;
import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.bean.ZdryZt.java]  
 * @ClassName:    [ZdryZt]   
 * @Description:  [重点人员涉稳表]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-5-29 下午5:40:26]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-29 下午5:40:26，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "QBLD_SK_ZDRY_SWXX", pk = "id")
public class ZdrySw extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@FieldDesc("ID")
	private String id;
	@FieldDesc("XSXXBH")
	private String xsxxbh;
	@FieldDesc("SSLB")
	private String sslb;
	@FieldDesc("SSLBXL")
	private String sslbxl;
	@FieldDesc("SSZZ")
	private String sszz;
	@FieldDesc("QKGS")
	private String qkgs;
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
	public String getSslbxl() {
		return sslbxl;
	}
	public void setSslbxl(String sslbxl) {
		this.sslbxl = sslbxl;
	}
	public String getSszz() {
		return sszz;
	}
	public void setSszz(String sszz) {
		this.sszz = sszz;
	}
	public String getQkgs() {
		return qkgs;
	}
	public void setQkgs(String qkgs) {
		this.qkgs = qkgs;
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
