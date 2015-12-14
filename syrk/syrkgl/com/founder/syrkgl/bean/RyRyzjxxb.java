package com.founder.syrkgl.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/******************************************************************************
 * @Package:      [com.founder.syrkgl.bean.RyRyzjxxb.java]  
 * @ClassName:    [RyRyzjxxb]   
 * @Description:  [实有人口附加信息-人员证件信息表]   
 * @Author:       [xu_wenjun@founder.com.cn]  
 * @CreateDate:   [2015-4-3 下午3:05:16]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-3 下午3:05:16，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@DBInfoAnnotation(tableName = "RY_RYZJXXB", pk = "id")
public class RyRyzjxxb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@FieldDesc("人员证件ID")
	private String id;
	@FieldDesc("人员ID")
	private String ryid;
	@FieldDesc("证件种类")
	private String cyzjdm;
	@FieldDesc("证件号码")
	private String zjhm;
	@FieldDesc("证件取得时间")
	private String zjqdsj;
	@FieldDesc("证件有效期")
	private String zjyxq;
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
	public String getCyzjdm() {
		return cyzjdm;
	}
	public void setCyzjdm(String cyzjdm) {
		this.cyzjdm = cyzjdm;
	}
	public String getZjhm() {
		return zjhm;
	}
	public void setZjhm(String zjhm) {
		this.zjhm = zjhm;
	}
	public String getZjqdsj() {
		return zjqdsj;
	}
	public void setZjqdsj(String zjqdsj) {
		this.zjqdsj = zjqdsj;
	}
	public String getZjyxq() {
		return zjyxq;
	}
	public void setZjyxq(String zjyxq) {
		this.zjyxq = zjyxq;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}

}
