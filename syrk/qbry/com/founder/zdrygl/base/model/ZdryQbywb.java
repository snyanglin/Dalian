package com.founder.zdrygl.base.model;

import java.io.Serializable;
import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.base.model.ZdryQbywb.java]  
 * @ClassName:    [ZdryQbywb]   
 * @Description:  [重点人员情报业务表]   
 * @Author:       [zhang.hai@founder.com.cn]  
 * @CreateDate:   [2015年12月25日 上午10:38:58]   
 * @UpdateUser:   [ZhangHai(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年12月25日 上午10:38:58，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "ZDRY_QBRYXXB", pk = "ID")
public class ZdryQbywb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@FieldDesc("主键id") private String id;
	@FieldDesc("公民身份证号码") private String gmsfhm;
	@FieldDesc("操作类别") private String czlb;
	@FieldDesc("操作意见") private String czyj;
	@FieldDesc("目标部门代码") private String mbbmdm;
	@FieldDesc("目标部门名称") private String mbbmmc;
	@FieldDesc("备注") private String bz;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGmsfhm() {
		return gmsfhm;
	}
	public void setGmsfhm(String gmsfhm) {
		this.gmsfhm = gmsfhm;
	}
	public String getCzlb() {
		return czlb;
	}
	public void setCzlb(String czlb) {
		this.czlb = czlb;
	}
	public String getCzyj() {
		return czyj;
	}
	public void setCzyj(String czyj) {
		this.czyj = czyj;
	}
	public String getMbbmdm() {
		return mbbmdm;
	}
	public void setMbbmdm(String mbbmdm) {
		this.mbbmdm = mbbmdm;
	}
	public String getMbbmmc() {
		return mbbmmc;
	}
	public void setMbbmmc(String mbbmmc) {
		this.mbbmmc = mbbmmc;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
}
