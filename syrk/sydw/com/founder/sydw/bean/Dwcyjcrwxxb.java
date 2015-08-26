package com.founder.sydw.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;
/**
 * ****************************************************************************
 * @Package:      [com.founder.sydw.bean.Dwcyjcrwxxb.java]  
 * @ClassName:    [Dwcyjcrwxxb]   
 * @Description:  单位抽样检查任务表   
 * @Author:       [yu_guangli@founder.com.cn]  
 * @CreateDate:   [2015-7-8 下午3:23:13]   
 * @UpdateUser:   [yuguangli(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-7-8 下午3:23:13，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "DW_DWCYJCRWXXB", pk = "id", logQueryField = "id")
public class Dwcyjcrwxxb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@FieldDesc("主键")
	private String id;
	@FieldDesc("单位ID")
	private String dwid;
	@FieldDesc("单位编码")
	private String dwbm;
	@FieldDesc("单位名称")
	private String dwmc;
	@FieldDesc("单位类别代码")
	private String dwlbdm;
	@FieldDesc("单位地址详址")
	private String dwdzxz;
	@FieldDesc("监管单位类别")
	private String jgdwlb;
	@FieldDesc("消防管辖")
	private String xfgx;
	@FieldDesc("抽样任务ID")
	private String ccrwid;
	@FieldDesc("分配人员ID")
	private String fpryid;
	@FieldDesc("抽查次数")
	private String cccs;
	@FieldDesc("抽查时间开始")
	private String ccsjks;
	@FieldDesc("抽查时间结束")
	private String ccsjjs;
	@FieldDesc("检查ID")
	private String jcid;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDwid() {
		return dwid;
	}
	public void setDwid(String dwid) {
		this.dwid = dwid;
	}
	public String getCcrwid() {
		return ccrwid;
	}
	public void setCcrwid(String ccrwid) {
		this.ccrwid = ccrwid;
	}
	public String getFpryid() {
		return fpryid;
	}
	public void setFpryid(String fpryid) {
		this.fpryid = fpryid;
	}
	public String getDwbm() {
		return dwbm;
	}
	public void setDwbm(String dwbm) {
		this.dwbm = dwbm;
	}
	public String getDwmc() {
		return dwmc;
	}
	public void setDwmc(String dwmc) {
		this.dwmc = dwmc;
	}
	public String getDwdzxz() {
		return dwdzxz;
	}
	public void setDwdzxz(String dwdzxz) {
		this.dwdzxz = dwdzxz;
	}
	public String getXfgx() {
		return xfgx;
	}
	public void setXfgx(String xfgx) {
		this.xfgx = xfgx;
	}
	public String getJgdwlb() {
		return jgdwlb;
	}
	public void setJgdwlb(String jgdwlb) {
		this.jgdwlb = jgdwlb;
	}
	public String getCccs() {
		return cccs;
	}
	public void setCccs(String cccs) {
		this.cccs = cccs;
	}
	public String getCcsjks() {
		return ccsjks;
	}
	public void setCcsjks(String ccsjks) {
		this.ccsjks = ccsjks;
	}
	public String getCcsjjs() {
		return ccsjjs;
	}
	public void setCcsjjs(String ccsjjs) {
		this.ccsjjs = ccsjjs;
	}
	public String getDwlbdm() {
		return dwlbdm;
	}
	public void setDwlbdm(String dwlbdm) {
		this.dwlbdm = dwlbdm;
	}
	public String getJcid() {
		return jcid;
	}
	public void setJcid(String jcid) {
		this.jcid = jcid;
	}
}
