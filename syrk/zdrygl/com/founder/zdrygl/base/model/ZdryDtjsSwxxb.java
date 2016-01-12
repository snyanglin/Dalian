package com.founder.zdrygl.base.model;

import java.io.Serializable;
import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.bean.ZdryDtjsSwxxb.java]  
 * @ClassName:    [ZdryDtjsSwxxb]   
 * @Description:  [重点人员 动态记实 涉稳 属性 表]   
 * @Author:       [cong_rihong@founder.com.cn]  
 * @CreateDate:   [2015年12月8日 下午7:07:27]   
 * @UpdateUser:   [congrihong(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年12月8日 下午7:07:27，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "ZDRY_DTJS_SWXXB", pk = "id")
public class ZdryDtjsSwxxb extends BaseEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8958976114056037088L;
	@FieldDesc("ID")
	private String id;
	@FieldDesc("所属类别")
	private String sslb;
	@FieldDesc("所属类别细类")
	private String sslbxl;
	@FieldDesc("所属组织")
	private String sszzdm;	
	@FieldDesc("所属组织名称")
	private String sszzmc;
	@FieldDesc("情况概述")
	private String qkgs;
	@FieldDesc("重点人证件号码")
	private String zdryzjhm;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSslb() {
		return sslb;
	}
	public void setSslb(String sslb) {
		this.sslb = sslb;
	}
	public String getSslbxl() {
		return sslbxl;
	}
	public void setSslbxl(String sslbxl) {
		this.sslbxl = sslbxl;
	}
	public String getSszzdm() {
		return sszzdm;
	}
	public void setSszzdm(String sszz) {
		this.sszzdm = sszz;
	}
	
	public String getSszzmc() {
		return sszzmc;
	}
	public void setSszzmc(String sszzmc) {
		this.sszzmc = sszzmc;
	}
	public String getQkgs() {
		return qkgs;
	}
	public void setQkgs(String qkgs) {
		this.qkgs = qkgs;
	}
	public String getZdryzjhm() {
		return zdryzjhm;
	}
	public void setZdryzjhm(String zdryzjhm) {
		this.zdryzjhm = zdryzjhm;
	}

}
