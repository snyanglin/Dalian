package com.founder.zdrygl.base.model;

import java.io.Serializable;
import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.bean.ZdryDtjsSdfdxxb.java]  
 * @ClassName:    [ZdryDtjsSdfdxxb]   
 * @Description:  [重点人员 动态记实 涉毒-贩毒 属性 表]   
 * @Author:       [zhang.hai@founder.com.cn]  
 * @CreateDate:   [2015年8月13日 下午7:00:19]   
 * @UpdateUser:   [ZhangHai(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年8月13日 下午7:00:19，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "ZDRY_DTJS_SDFDXXB", pk = "id")
public class ZdryDtjsSdfdxxb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@FieldDesc("ID")
	private String id;
	@FieldDesc("FMDPZL")
	private String fmdpzl;
	@FieldDesc("DPLY")
	private String dply;
	@FieldDesc("DPLYQT")
	private String dplyqt;
	@FieldDesc("FMDPQD")
	private String fmdpqd;
	@FieldDesc("DPQDQT")
	private String dpqdqt;
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
	@FieldDesc("LYD")
	private String lyd;
	@FieldDesc("DZQXQT")
	private String dzqxqt;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFmdpzl() {
		return fmdpzl;
	}
	public void setFmdpzl(String fmdpzl) {
		this.fmdpzl = fmdpzl;
	}
	public String getDply() {
		return dply;
	}
	public void setDply(String dply) {
		this.dply = dply;
	}
	public String getDplyqt() {
		return dplyqt;
	}
	public void setDplyqt(String dplyqt) {
		this.dplyqt = dplyqt;
	}
	public String getFmdpqd() {
		return fmdpqd;
	}
	public void setFmdpqd(String fmdpqd) {
		this.fmdpqd = fmdpqd;
	}
	public String getDpqdqt() {
		return dpqdqt;
	}
	public void setDpqdqt(String dpqdqt) {
		this.dpqdqt = dpqdqt;
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
	public String getLyd() {
		return lyd;
	}
	public void setLyd(String lyd) {
		this.lyd = lyd;
	}
	public String getDzqxqt() {
		return dzqxqt;
	}
	public void setDzqxqt(String dzqxqt) {
		this.dzqxqt = dzqxqt;
	}

}
