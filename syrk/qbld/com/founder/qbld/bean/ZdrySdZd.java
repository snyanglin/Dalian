package com.founder.qbld.bean;

import java.io.Serializable;
import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.bean.ZdrySdZd.java]  
 * @ClassName:    [ZdrySdZd]   
 * @Description:  [涉毒制毒表]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-5-29 下午5:46:20]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-29 下午5:46:20，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "QBLD_SK_ZDRY_SD_ZDXX", pk = "id")
public class ZdrySdZd extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@FieldDesc("ID")
	private String id;
	@FieldDesc("DPZL")
	private String dpzl;
	@FieldDesc("ZDHXP")
	private String zdhxp;
	@FieldDesc("ZDHXPQT")
	private String zdhxpqt;
	@FieldDesc("DPQX")
	private String dpqx;
	@FieldDesc("DPQXQT")
	private String dpqxqt;
	@FieldDesc("SHDZQX")
	private String shdzqx;
	@FieldDesc("XSBH")
	private String xsbh;
	@FieldDesc("XGSJ")
	private String xgsj;
	@FieldDesc("CJSJ")
	private String cjsj;
	@FieldDesc("DPZLQT")
	private String dpzlqt;
	@FieldDesc("ZDRYZJHM")
	private String zdryzjhm;
	@FieldDesc("FMDD")
	private String fmdd;
	@FieldDesc("DZQXQT")
	private String dzqxqt;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDpzl() {
		return dpzl;
	}
	public void setDpzl(String dpzl) {
		this.dpzl = dpzl;
	}
	public String getZdhxp() {
		return zdhxp;
	}
	public void setZdhxp(String zdhxp) {
		this.zdhxp = zdhxp;
	}
	public String getZdhxpqt() {
		return zdhxpqt;
	}
	public void setZdhxpqt(String zdhxpqt) {
		this.zdhxpqt = zdhxpqt;
	}
	public String getDpqx() {
		return dpqx;
	}
	public void setDpqx(String dpqx) {
		this.dpqx = dpqx;
	}
	public String getDpqxqt() {
		return dpqxqt;
	}
	public void setDpqxqt(String dpqxqt) {
		this.dpqxqt = dpqxqt;
	}
	public String getShdzqx() {
		return shdzqx;
	}
	public void setShdzqx(String shdzqx) {
		this.shdzqx = shdzqx;
	}
	public String getXsbh() {
		return xsbh;
	}
	public void setXsbh(String xsbh) {
		this.xsbh = xsbh;
	}
	public String getXgsj() {
		return xgsj;
	}
	public void setXgsj(String xgsj) {
		this.xgsj = xgsj;
	}
	public String getCjsj() {
		return cjsj;
	}
	public void setCjsj(String cjsj) {
		this.cjsj = cjsj;
	}
	public String getDpzlqt() {
		return dpzlqt;
	}
	public void setDpzlqt(String dpzlqt) {
		this.dpzlqt = dpzlqt;
	}
	public String getZdryzjhm() {
		return zdryzjhm;
	}
	public void setZdryzjhm(String zdryzjhm) {
		this.zdryzjhm = zdryzjhm;
	}
	public String getFmdd() {
		return fmdd;
	}
	public void setFmdd(String fmdd) {
		this.fmdd = fmdd;
	}
	public String getDzqxqt() {
		return dzqxqt;
	}
	public void setDzqxqt(String dzqxqt) {
		this.dzqxqt = dzqxqt;
	}

}
