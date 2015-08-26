package com.founder.zdrygl.bean;

import java.io.Serializable;
import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.bean.ZdryDtjsSdxdxxb.java]  
 * @ClassName:    [ZdryDtjsSdxdxxb]   
 * @Description:  [重点人员 动态记实 涉毒-吸毒 属性 表]   
 * @Author:       [zhang.hai@founder.com.cn]  
 * @CreateDate:   [2015年8月13日 下午7:05:21]   
 * @UpdateUser:   [ZhangHai(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年8月13日 下午7:05:21，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "ZDRY_DTJS_SDXDXXB", pk = "id")
public class ZdryDtjsSdxdxxb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@FieldDesc("ID")
	private String id;
	@FieldDesc("DPZL")
	private String dpzl;
	@FieldDesc("DPLY")
	private String dply;
	@FieldDesc("DZLY")
	private String dzly;
	@FieldDesc("SFFX")
	private String sffx;
	@FieldDesc("XSCS")
	private Long xscs;
	@FieldDesc("JDSJ")
	private String jdsj;
	@FieldDesc("XSYY")
	private String xsyy;
	@FieldDesc("RYXZ")
	private String ryxz;
	@FieldDesc("WHHG")
	private String whhg;
	@FieldDesc("XSBH")
	private String xsbh;
	@FieldDesc("DPZLQT")
	private String dpzlqt;
	@FieldDesc("DPLYQT")
	private String dplyqt;
	@FieldDesc("DZLYQT")
	private String dzlyqt;
	@FieldDesc("GXRQ")
	private String gxrq;
	@FieldDesc("CJSJ")
	private String cjsj;
	@FieldDesc("SFJD")
	private String sfjd;
	@FieldDesc("ZDRYZJHM")
	private String zdryzjhm;
	
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
	public String getDply() {
		return dply;
	}
	public void setDply(String dply) {
		this.dply = dply;
	}
	public String getDzly() {
		return dzly;
	}
	public void setDzly(String dzly) {
		this.dzly = dzly;
	}
	public String getSffx() {
		return sffx;
	}
	public void setSffx(String sffx) {
		this.sffx = sffx;
	}
	public Long getXscs() {
		return xscs;
	}
	public void setXscs(Long xscs) {
		this.xscs = xscs;
	}
	public String getJdsj() {
		return jdsj;
	}
	public void setJdsj(String jdsj) {
		this.jdsj = jdsj;
	}
	public String getXsyy() {
		return xsyy;
	}
	public void setXsyy(String xsyy) {
		this.xsyy = xsyy;
	}
	public String getRyxz() {
		return ryxz;
	}
	public void setRyxz(String ryxz) {
		this.ryxz = ryxz;
	}
	public String getWhhg() {
		return whhg;
	}
	public void setWhhg(String whhg) {
		this.whhg = whhg;
	}
	public String getXsbh() {
		return xsbh;
	}
	public void setXsbh(String xsbh) {
		this.xsbh = xsbh;
	}
	public String getDpzlqt() {
		return dpzlqt;
	}
	public void setDpzlqt(String dpzlqt) {
		this.dpzlqt = dpzlqt;
	}
	public String getDplyqt() {
		return dplyqt;
	}
	public void setDplyqt(String dplyqt) {
		this.dplyqt = dplyqt;
	}
	public String getDzlyqt() {
		return dzlyqt;
	}
	public void setDzlyqt(String dzlyqt) {
		this.dzlyqt = dzlyqt;
	}
	public String getGxrq() {
		return gxrq;
	}
	public void setGxrq(String gxrq) {
		this.gxrq = gxrq;
	}
	public String getCjsj() {
		return cjsj;
	}
	public void setCjsj(String cjsj) {
		this.cjsj = cjsj;
	}
	public String getSfjd() {
		return sfjd;
	}
	public void setSfjd(String sfjd) {
		this.sfjd = sfjd;
	}
	public String getZdryzjhm() {
		return zdryzjhm;
	}
	public void setZdryzjhm(String zdryzjhm) {
		this.zdryzjhm = zdryzjhm;
	}

}
