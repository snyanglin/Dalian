package com.founder.syrkgl.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/**
 * ****************************************************************************
 * @Package:      [com.founder.syrkgl.bean.RyRybmchxxb.java]  
 * @ClassName:    [RyRybmchxxb]   
 * @Description:  [实有人口附加信息-人员别名绰号表]   
 * @Author:       [xu_wenjun@founder.com.cn]  
 * @CreateDate:   [2015-4-3 上午9:12:42]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-3 上午9:12:42，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "RY_RYBMCHXXB", pk = "id")
public class RyRybmchxxb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@FieldDesc("ID")
	private String id;
	@FieldDesc("人员ID")
	private String ryid;
	@FieldDesc("别名绰号类型代码")
	private String bmchlxdm;
	@FieldDesc("别名绰号")
	private String bmch;
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
	public String getBmchlxdm() {
		return bmchlxdm;
	}
	public void setBmchlxdm(String bmchlxdm) {
		this.bmchlxdm = bmchlxdm;
	}
	public String getBmch() {
		return bmch;
	}
	public void setBmch(String bmch) {
		this.bmch = bmch;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	
}
