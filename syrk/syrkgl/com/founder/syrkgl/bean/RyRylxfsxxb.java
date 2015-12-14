package com.founder.syrkgl.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/**
 * ****************************************************************************
 * @Package:      [com.founder.syrkgl.bean.RyRylxfsxxb.java]  
 * @ClassName:    [RyRylxfsxxb]   
 * @Description:  [实有人口附加信息-人员联系方式信息表]   
 * @Author:       [xu_wenjun@founder.com.cn]  
 * @CreateDate:   [2015-4-7 下午7:38:39]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-7 下午7:38:39，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "RY_RYLXFSXXB", pk = "id")
public class RyRylxfsxxb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@FieldDesc("ID")
	private String id;
	@FieldDesc("人员ID")
	private String ryid;
	@FieldDesc("联系方式类型代码")
	private String lxfslxdm;
	@FieldDesc("联系方式")
	private String lxfs;
	@FieldDesc("备注")
	private String bz;
	
	private String xm;
	private String djsj;
	
	public String getXm() {
		return xm;
	}
	public void setXm(String xm) {
		this.xm = xm;
	}
	public String getDjsj() {
		return djsj;
	}
	public void setDjsj(String djsj) {
		this.djsj = djsj;
	}
	
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
	public String getLxfslxdm() {
		return lxfslxdm;
	}
	public void setLxfslxdm(String lxfslxdm) {
		this.lxfslxdm = lxfslxdm;
	}
	public String getLxfs() {
		return lxfs;
	}
	public void setLxfs(String lxfs) {
		this.lxfs = lxfs;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}

}
