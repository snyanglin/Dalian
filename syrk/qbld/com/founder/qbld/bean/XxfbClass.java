package com.founder.qbld.bean;

import java.io.Serializable;
import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.bean.XxfbClass.java]  
 * @ClassName:    [XxfbClass]   
 * @Description:  [信息发布类型]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-6-26 上午9:17:33]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-26 上午9:17:33，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "QBLD_XXFB_CLASS", pk = "objectid")
public class XxfbClass extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@FieldDesc("OBJECTID")
	private Long objectid;
	@FieldDesc("FLDM")
	private String fldm;
	@FieldDesc("FLMC")
	private String flmc;
	@FieldDesc("TJYY")
	private String tjyy;
	@FieldDesc("TJSJ")
	private String tjsj;
	@FieldDesc("ZHXXYY")
	private String zhxxyy;
	@FieldDesc("ZHXXSJ")
	private String zhxxsj;
	@FieldDesc("FWDZ")
	private String fwdz;
	@FieldDesc("FWZH")
	private String fwzh;
	@FieldDesc("XFQS")
	private String xfqs;
	public Long getObjectid() {
		return objectid;
	}
	public void setObjectid(Long objectid) {
		this.objectid = objectid;
	}
	public String getFldm() {
		return fldm;
	}
	public void setFldm(String fldm) {
		this.fldm = fldm;
	}
	public String getFlmc() {
		return flmc;
	}
	public void setFlmc(String flmc) {
		this.flmc = flmc;
	}
	public String getTjyy() {
		return tjyy;
	}
	public void setTjyy(String tjyy) {
		this.tjyy = tjyy;
	}
	public String getTjsj() {
		return tjsj;
	}
	public void setTjsj(String tjsj) {
		this.tjsj = tjsj;
	}
	public String getZhxxyy() {
		return zhxxyy;
	}
	public void setZhxxyy(String zhxxyy) {
		this.zhxxyy = zhxxyy;
	}
	public String getZhxxsj() {
		return zhxxsj;
	}
	public void setZhxxsj(String zhxxsj) {
		this.zhxxsj = zhxxsj;
	}
	public String getFwdz() {
		return fwdz;
	}
	public void setFwdz(String fwdz) {
		this.fwdz = fwdz;
	}
	public String getFwzh() {
		return fwzh;
	}
	public void setFwzh(String fwzh) {
		this.fwzh = fwzh;
	}
	public String getXfqs() {
		return xfqs;
	}
	public void setXfqs(String xfqs) {
		this.xfqs = xfqs;
	}
	
}
