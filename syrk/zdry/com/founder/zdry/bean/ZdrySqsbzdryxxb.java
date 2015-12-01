package com.founder.zdry.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;


/******************************************************************************
 * @Package:      [com.founder.zdry.bean.ZdrySqsbzdryxxb.java]  
 * @ClassName:    [ZdrySqsbzdryxxb]   
 * @Description:  [涉枪涉爆重点人员信息表]   
 * @Author:       [cong_rihong@founder.com.cn]  
 * @CreateDate:   [2015-8-4 下午1:43:38]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-8-4 下午1:43:38，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@DBInfoAnnotation(tableName = "ZDRY_SQSBZDRYXXB", pk = "id")
public class ZdrySqsbzdryxxb extends BaseEntity implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;
	@FieldDesc("重点人员ID")
	private String id;
	@FieldDesc("管理方法代码")
	private String glffdm;
	@FieldDesc("列管来源代码")
	private String lglydm;
	@FieldDesc("纳入工作依据")
	private String nrgzyj;
	@FieldDesc("案件类别代码")
	private String ajlbdm;
	@FieldDesc("撤管原因代码")
	private String cgyydm;
	@FieldDesc("撤管时间")
	private String cgsj;
	@FieldDesc("备注")
	private String bz;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGlffdm() {
		return glffdm;
	}
	public void setGlffdm(String glffdm) {
		this.glffdm = glffdm;
	}
	public String getLglydm() {
		return lglydm;
	}
	public void setLglydm(String lglydm) {
		this.lglydm = lglydm;
	}
	public String getNrgzyj() {
		return nrgzyj;
	}
	public void setNrgzyj(String nrgzyj) {
		this.nrgzyj = nrgzyj;
	}
	public String getAjlbdm() {
		return ajlbdm;
	}
	public void setAjlbdm(String ajlbdm) {
		this.ajlbdm = ajlbdm;
	}
	public String getCgyydm() {
		return cgyydm;
	}
	public void setCgyydm(String cgyydm) {
		this.cgyydm = cgyydm;
	}
	public String getCgsj() {
		return cgsj;
	}
	public void setCgsj(String cgsj) {
		this.cgsj = cgsj;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}

	
	
	
}
