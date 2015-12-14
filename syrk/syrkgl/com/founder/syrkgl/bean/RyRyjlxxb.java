package com.founder.syrkgl.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;



/******************************************************************************
 * @Package:      [com.founder.syrkgl.bean.RyRyjlxxb.java]  
 * @ClassName:    [RyRyjlxxb]   
 * @Description:  [人员经历信息表]   
 * @Author:       [congrihong@founder.com.cn]  
 * @CreateDate:   [2015-4-10 上午9:38:52]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-10 上午9:38:52，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@DBInfoAnnotation(tableName = "RY_RYJLXXB", pk = "id")
public class RyRyjlxxb extends BaseEntity implements Serializable {

	
	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;
	@FieldDesc("ID")
	private String id;
	@FieldDesc("人员ID")
	private String ryid;
	@FieldDesc("经历类型代码")
	private String jllxdm;
	@FieldDesc("开始时间")
	private String kssj;
	@FieldDesc("结束时间")
	private String jssj;
	@FieldDesc("单位ID")
	private String dwid;
	@FieldDesc("单位名称")
	private String dwmc;
	@FieldDesc("职业类别代码")
	private String zylbdm;
	@FieldDesc("职务名称")
	private String zwmc;
	@FieldDesc("经历情况")
	private String jlqk;
	@FieldDesc("备注")
	private String bz;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRyid() {
		return ryid;
	}
	public void setRyid(String ryid) {
		this.ryid = ryid;
	}
	public String getJllxdm() {
		return jllxdm;
	}
	public void setJllxdm(String jllxdm) {
		this.jllxdm = jllxdm;
	}
	public String getKssj() {
		return kssj;
	}
	public void setKssj(String kssj) {
		this.kssj = kssj;
	}
	public String getJssj() {
		return jssj;
	}
	public void setJssj(String jssj) {
		this.jssj = jssj;
	}
	public String getDwid() {
		return dwid;
	}
	public void setDwid(String dwid) {
		this.dwid = dwid;
	}
	public String getDwmc() {
		return dwmc;
	}
	public void setDwmc(String dwmc) {
		this.dwmc = dwmc;
	}
	
	public String getZylbdm() {
		return zylbdm;
	}
	public void setZylbdm(String zylbdm) {
		this.zylbdm = zylbdm;
	}
	public String getZwmc() {
		return zwmc;
	}
	public void setZwmc(String zwmc) {
		this.zwmc = zwmc;
	}

	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getJlqk() {
		return jlqk;
	}
	public void setJlqk(String jlqk) {
		this.jlqk = jlqk;
	}

	
}
