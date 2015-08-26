package com.founder.xlff.bean;

import java.io.Serializable;
import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/**
 * ****************************************************************************
 * @Package:      [com.founder.xlff.bean.Option.java]  
 * @ClassName:    [Option]   
 * @Description:  [巡逻防范设置表]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-6-17 上午11:14:38]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-17 上午11:14:38，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "XLFF_YJFX_FKZL", pk = "id")
public class Fkzl extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private String xfsjB;
	private String xfsjE;
	
	//"反馈意见"
	private String fkyj;
	//签收反馈状态
	private String qsfkzt;
	
	//"签收人DE00002"
	private String qsr;
	//"签收单位名称"
	private String qsdwmc;
	//签收时间"
	private String qssj;
	
	public String getQsr() {
		return qsr;
	}
	public void setQsr(String qsr) {
		this.qsr = qsr;
	}
	public String getQsdwmc() {
		return qsdwmc;
	}
	public void setQsdwmc(String qsdwmc) {
		this.qsdwmc = qsdwmc;
	}
	public String getQssj() {
		return qssj;
	}
	public void setQssj(String qssj) {
		this.qssj = qssj;
	}
	@FieldDesc("ID")
	private String id;
	@FieldDesc("防控级别 1:一级 2:二级 3 三级 ")
	private String fkjb;
	@FieldDesc("标题")
	private String bt;
	@FieldDesc("内容")
	private String nr;
	@FieldDesc("下发单位 多个单位以','隔开")
	private String xfdwdm;
	@FieldDesc("下发时间")
	private String xfsj;
	@FieldDesc("创建时间")
	private String cjsj;
	@FieldDesc("下发单位名称 多个单位以','隔开")
	private String xfdwmc;
	
	public String getQsfkzt() {
		return qsfkzt;
	}
	public void setQsfkzt(String qsfkzt) {
		this.qsfkzt = qsfkzt;
	}
	public String getFkyj() {
		return fkyj;
	}
	public void setFkyj(String fkyj) {
		this.fkyj = fkyj;
	}
	public String getXfsjB() {
		return xfsjB;
	}
	public void setXfsjB(String xfsjB) {
		this.xfsjB = xfsjB;
	}
	public String getXfsjE() {
		return xfsjE;
	}
	public void setXfsjE(String xfsjE) {
		this.xfsjE = xfsjE;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFkjb() {
		return fkjb;
	}
	public void setFkjb(String fkjb) {
		this.fkjb = fkjb;
	}
	public String getBt() {
		return bt;
	}
	public void setBt(String bt) {
		this.bt = bt;
	}
	public String getNr() {
		return nr;
	}
	public void setNr(String nr) {
		this.nr = nr;
	}
	public String getXfdwdm() {
		return xfdwdm;
	}
	public void setXfdwdm(String xfdwdm) {
		this.xfdwdm = xfdwdm;
	}
	public String getXfsj() {
		return xfsj;
	}
	public void setXfsj(String xfsj) {
		this.xfsj = xfsj;
	}
	public String getCjsj() {
		return cjsj;
	}
	public void setCjsj(String cjsj) {
		this.cjsj = cjsj;
	}
	public String getXfdwmc() {
		return xfdwmc;
	}
	public void setXfdwmc(String xfdwmc) {
		this.xfdwmc = xfdwmc;
	}
	
}
