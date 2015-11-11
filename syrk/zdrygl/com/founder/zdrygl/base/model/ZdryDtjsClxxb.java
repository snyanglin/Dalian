package com.founder.zdrygl.base.model;

import java.io.Serializable;
import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.bean.Clxxb.java]  
 * @ClassName:    [Clxxb]   
 * @Description:  [车辆信息表]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-6-8 上午9:39:28]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-8 上午9:39:28，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "ZDRY_DTJS_CLXX", pk = "ID")
public class ZdryDtjsClxxb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@FieldDesc("ID")
	private String id;
	@FieldDesc("ZJHM")
	private String zjhm;
	@FieldDesc("CLPP")
	private String clpp;
	@FieldDesc("CLLX")
	private String cllx;
	@FieldDesc("CLYS")
	private String clys;
	@FieldDesc("CLHM")
	private String clhm;
	@FieldDesc("CLLY")
	private String clly;
	@FieldDesc("GSR")
	private String gsr;
	@FieldDesc("CJSJ")
	private String cjsj;
	@FieldDesc("XGSJ")
	private String xgsj;
	@FieldDesc("ZXBS")
	private String zxbs;
	@FieldDesc("CLXXBH")
	private String clxxbh;
	
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
	public String getClys() {
		return clys;
	}
	public void setClys(String clys) {
		this.clys = clys;
	}
	public String getClhm() {
		return clhm;
	}
	public void setClhm(String clhm) {
		this.clhm = clhm;
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
	public String getCjsj() {
		return cjsj;
	}
	public void setCjsj(String cjsj) {
		this.cjsj = cjsj;
	}
	public String getXgsj() {
		return xgsj;
	}
	public void setXgsj(String xgsj) {
		this.xgsj = xgsj;
	}
	public String getZxbs() {
		return zxbs;
	}
	public void setZxbs(String zxbs) {
		this.zxbs = zxbs;
	}
	public String getClxxbh() {
		return clxxbh;
	}
	public void setClxxbh(String clxxbh) {
		this.clxxbh = clxxbh;
	}

}
