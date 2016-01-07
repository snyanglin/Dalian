package com.founder.zdrygl.base.model;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.bean.ZdryDtjsClxxb.java]  
 * @ClassName:    [ZdryDtjsClxxb]   
 * @Description:  [车辆信息表]   
 * @Author:       [cong_rihong@founder.com.cn]  
 * @CreateDate:   [2015-12-14 上午9:39:28]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-12-14 上午9:39:28，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "ZDRY_DTJS_CLXX", pk = "ID")
public class ZdryDtjsClxxb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@FieldDesc("ID")
	private String id;
	@FieldDesc("重点人证件号码")
	private String zjhm;
	@FieldDesc("车辆品牌")
	private String clpp;
	@FieldDesc("车辆类型")
	private String cllx;
	@FieldDesc("车辆颜色")
	private String csys;
	@FieldDesc("车辆号码")
	private String jdchphm;
	@FieldDesc("车辆来源")
	private String clly;
	@FieldDesc("归属人")
	private String gsr;
	@FieldDesc("车辆信息编号")
	private String clxxbh;
	@FieldDesc("车主常用证件类型")
	private String cz_cyzjdm;
	@FieldDesc("车主证件号码")
	private String cz_zjhm;
	@FieldDesc("车主姓名")
	private String cz_xm;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getZjhm() {
		return zjhm;
	}
	public void setZjhm(String zjhm) {
		this.zjhm = zjhm;
	}
	public String getClpp() {
		return clpp;
	}
	public void setClpp(String clpp) {
		this.clpp = clpp;
	}
	public String getCllx() {
		return cllx;
	}
	public void setCllx(String cllx) {
		this.cllx = cllx;
	}
	public String getCsys() {
		return csys;
	}
	public void setCsys(String csys) {
		this.csys = csys;
	}
	public String getJdchphm() {
		return jdchphm;
	}
	public void setJdchphm(String jdchphm) {
		this.jdchphm = jdchphm;
	}
	public String getClly() {
		return clly;
	}
	public void setClly(String clly) {
		this.clly = clly;
	}
	public String getGsr() {
		return gsr;
	}
	public void setGsr(String gsr) {
		this.gsr = gsr;
	}
	public String getClxxbh() {
		return clxxbh;
	}
	public void setClxxbh(String clxxbh) {
		this.clxxbh = clxxbh;
	}
	public String getCz_cyzjdm() {
		return cz_cyzjdm;
	}
	public void setCz_cyzjdm(String cz_cyzjdm) {
		this.cz_cyzjdm = cz_cyzjdm;
	}
	public String getCz_zjhm() {
		return cz_zjhm;
	}
	public void setCz_zjhm(String cz_zjhm) {
		this.cz_zjhm = cz_zjhm;
	}
	public String getCz_xm() {
		return cz_xm;
	}
	public void setCz_xm(String cz_xm) {
		this.cz_xm = cz_xm;
	}

	
	
}
