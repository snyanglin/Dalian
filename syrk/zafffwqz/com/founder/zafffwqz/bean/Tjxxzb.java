package com.founder.zafffwqz.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/******************************************************************************
 * @Package:      [com.founder.zafffwqz.bean.Tjxxzb.java]  
 * @ClassName:    [Tjxxzb]   
 * @Description:  [矛盾-调节实体类]   
 * @Author:       [tian_chengwei@founder.com.cn]  
 * @CreateDate:   [2015-6-2 下午11:51:55]   
 * @UpdateUser:   [lk(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-2 下午11:51:55，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 * 
 * @review      :wu.w@founder.com.cn
 * @reviewDate  : 20150604
 */
@DBInfoAnnotation(tableName = "FWQZ_MD_TJXXZB" , pk = "id")
public class Tjxxzb extends BaseEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@FieldDesc("调解人信息子表ID")
	private String id;
	@FieldDesc("矛盾纠纷信息ID")
	private String mdjfxxid;
	@FieldDesc("人员ID")
	private String ryid;
	@FieldDesc("其他调解人员")
	private String qttjry;
	@FieldDesc("调解单位名称")
	private String tjdwmc;
	@FieldDesc("调解单位ID")
	private String tjdwid;
	@FieldDesc("调解时间")
	private String tjsj;
	@FieldDesc("调解地点")
	private String tjdd;
	@FieldDesc("调解结果代码")
	private String tjjgdm;
	@FieldDesc("调解处理信息")
	private String tjclxx;
	@FieldDesc("未调解工作计划")
	private String wtjgzjh;
	@FieldDesc("调解人")
	private String tjr;
	@FieldDesc("备注")
	private String bz;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMdjfxxid() {
		return mdjfxxid;
	}
	public void setMdjfxxid(String mdjfxxid) {
		this.mdjfxxid = mdjfxxid;
	}
	public String getRyid() {
		return ryid;
	}
	public void setRyid(String ryid) {
		this.ryid = ryid;
	}
	public String getQttjry() {
		return qttjry;
	}
	public void setQttjry(String qttjry) {
		this.qttjry = qttjry;
	}
	public String getTjdwmc() {
		return tjdwmc;
	}
	public void setTjdwmc(String tjdwmc) {
		this.tjdwmc = tjdwmc;
	}
	public String getTjdwid() {
		return tjdwid;
	}
	public void setTjdwid(String tjdwid) {
		this.tjdwid = tjdwid;
	}
	public String getTjsj() {
		return tjsj;
	}
	public void setTjsj(String tjsj) {
		this.tjsj = tjsj;
	}
	public String getTjdd() {
		return tjdd;
	}
	public void setTjdd(String tjdd) {
		this.tjdd = tjdd;
	}
	public String getTjjgdm() {
		return tjjgdm;
	}
	public void setTjjgdm(String tjjgdm) {
		this.tjjgdm = tjjgdm;
	}
	public String getTjclxx() {
		return tjclxx;
	}
	public void setTjclxx(String tjclxx) {
		this.tjclxx = tjclxx;
	}
	public String getWtjgzjh() {
		return wtjgzjh;
	}
	public void setWtjgzjh(String wtjgzjh) {
		this.wtjgzjh = wtjgzjh;
	}
	public String getTjr() {
		return tjr;
	}
	public void setTjr(String tjr) {
		this.tjr = tjr;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	
	
}
