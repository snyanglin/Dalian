package com.founder.zdrygl.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/***
 * ****************************************************************************
 * 
 * @Package: [com.founder.zdrygl.bean.Glpzpzb.java]
 * @ClassName: [Glpzpzb]
 * @Description: [一句话描述该类的功能]
 * @Author: [wu_chunhui@founder.com.cn]
 * @CreateDate: [2015-3-11 下午6:20:49]
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-3-11 下午6:20:49，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@DBInfoAnnotation(tableName = "ZDRY_GLPZPZB", pk = "id")
public class ZdryGlpzpzb extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@FieldDesc("配置ID")
	private String id;
	@FieldDesc("重点人员管理类型代码")
	private String zdrygllxdm;
	@FieldDesc("监管部门代码")
	private String jgbmdm;
	@FieldDesc("监管部门名称")
	private String jgbmmc;
	@FieldDesc("是否上级审批")
	private String sfsjsp;
	@FieldDesc("动态纪实周期代码")
	private String dtjszqdm;
	@FieldDesc("备注")
	private String bz;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getZdrygllxdm() {
		return zdrygllxdm;
	}

	public void setZdrygllxdm(String zdrygllxdm) {
		this.zdrygllxdm = zdrygllxdm;
	}

	public String getJgbmdm() {
		return jgbmdm;
	}

	public void setJgbmdm(String jgbmdm) {
		this.jgbmdm = jgbmdm;
	}

	public String getJgbmmc() {
		return jgbmmc;
	}

	public void setJgbmmc(String jgbmmc) {
		this.jgbmmc = jgbmmc;
	}

	public String getSfsjsp() {
		return sfsjsp;
	}

	public void setSfsjsp(String sfsjsp) {
		this.sfsjsp = sfsjsp;
	}

	public String getDtjszqdm() {
		return dtjszqdm;
	}

	public void setDtjszqdm(String dtjszqdm) {
		this.dtjszqdm = dtjszqdm;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

}
