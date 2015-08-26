package com.founder.xlff.bean;

import java.io.Serializable;
import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/**
 * ****************************************************************************
 * @Package:      [com.founder.xlff.bean.Option.java]  
 * @ClassName:    [Option]   
 * @Description:  [巡逻防范设置表]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-6-17 上午11:14:38]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-17 上午11:14:38，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "XLFF_OPTION", pk = "orgcode")
public class Option extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@FieldDesc("组织机构")
	private String orgcode;
	@FieldDesc("开始日期")
	private String kssj;
	@FieldDesc("结束日期")
	private String jssj;
	@FieldDesc("阀值1")
	private String f1;
	@FieldDesc("阀值2")
	private String f2;
	@FieldDesc("阀值3")
	private String f3;
	@FieldDesc("阀值4")
	private String f4;
	
	public String getF4() {
		return f4;
	}
	public void setF4(String f4) {
		this.f4 = f4;
	}
	public String getOrgcode() {
		return orgcode;
	}
	public void setOrgcode(String orgcode) {
		this.orgcode = orgcode;
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
	public String getF1() {
		return f1;
	}
	public void setF1(String f1) {
		this.f1 = f1;
	}
	public String getF2() {
		return f2;
	}
	public void setF2(String f2) {
		this.f2 = f2;
	}
	public String getF3() {
		return f3;
	}
	public void setF3(String f3) {
		this.f3 = f3;
	}
	
}
