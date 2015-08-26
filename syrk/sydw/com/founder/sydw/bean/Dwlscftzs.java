package com.founder.sydw.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;
/**
 * ****************************************************************************
 * @Package:      [com.founder.sydw.bean.Dwlscftzs.java]  
 * @ClassName:    [Dwlscftzs]   
 * @Description:  临时查封通知书 
 * @Author:       [yu_guangli@founder.com.cn]  
 * @CreateDate:   [2015-6-24 下午1:32:32]   
 * @UpdateUser:   [yuguangli(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-24 下午1:32:32，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "DW_LSCFTZS", pk = "id")
public class Dwlscftzs  extends BaseEntity implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;
	@FieldDesc("主键")
	private String id;
	@FieldDesc("检查ID")
	private String jcid;
	@FieldDesc("单位ID")
	private String dwid;
	@FieldDesc("公文号")
	private String gwh;
	@FieldDesc("消")
	private String xxh;
	@FieldDesc("编号")
	private String bh;
	@FieldDesc("序号")
	private String xh;
	@FieldDesc("组织机构名称")
	private String zzjgmc;
	@FieldDesc("检查日期")
	private String jcrq;
	@FieldDesc("火灾隐患")
	private String hzyh;
	@FieldDesc("火灾隐患后果")
	private String hzyhhg;
	@FieldDesc("消防法")
	private String xff;
	@FieldDesc("查封范围")
	private String cffw;
	@FieldDesc("查封起始日期")
	private String cf_qsrq;
	@FieldDesc("查封结束日期")
	private String cf_jsrq;
	@FieldDesc("组织机构名称2")
	private String zzjgmc2;
	@FieldDesc("单位名称")
	private String dwmc;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getJcid() {
		return jcid;
	}
	public void setJcid(String jcid) {
		this.jcid = jcid;
	}
	public String getDwid() {
		return dwid;
	}
	public void setDwid(String dwid) {
		this.dwid = dwid;
	}
	public String getGwh() {
		return gwh;
	}
	public void setGwh(String gwh) {
		this.gwh = gwh;
	}
	public String getXxh() {
		return xxh;
	}
	public void setXxh(String xxh) {
		this.xxh = xxh;
	}
	public String getBh() {
		return bh;
	}
	public void setBh(String bh) {
		this.bh = bh;
	}
	public String getXh() {
		return xh;
	}
	public void setXh(String xh) {
		this.xh = xh;
	}
	public String getZzjgmc() {
		return zzjgmc;
	}
	public void setZzjgmc(String zzjgmc) {
		this.zzjgmc = zzjgmc;
	}
	public String getJcrq() {
		return jcrq;
	}
	public void setJcrq(String jcrq) {
		this.jcrq = jcrq;
	}
	public String getHzyh() {
		return hzyh;
	}
	public void setHzyh(String hzyh) {
		this.hzyh = hzyh;
	}
	public String getHzyhhg() {
		return hzyhhg;
	}
	public void setHzyhhg(String hzyhhg) {
		this.hzyhhg = hzyhhg;
	}
	public String getXff() {
		return xff;
	}
	public void setXff(String xff) {
		this.xff = xff;
	}
	public String getCffw() {
		return cffw;
	}
	public void setCffw(String cffw) {
		this.cffw = cffw;
	}
	public String getCf_qsrq() {
		return cf_qsrq;
	}
	public void setCf_qsrq(String cf_qsrq) {
		this.cf_qsrq = cf_qsrq;
	}
	public String getCf_jsrq() {
		return cf_jsrq;
	}
	public void setCf_jsrq(String cf_jsrq) {
		this.cf_jsrq = cf_jsrq;
	}
	public String getZzjgmc2() {
		return zzjgmc2;
	}
	public void setZzjgmc2(String zzjgmc2) {
		this.zzjgmc2 = zzjgmc2;
	}
	public String getDwmc() {
		return dwmc;
	}
	public void setDwmc(String dwmc) {
		this.dwmc = dwmc;
	}
}
