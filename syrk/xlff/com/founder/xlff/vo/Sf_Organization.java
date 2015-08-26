package com.founder.xlff.vo;
import java.io.Serializable;
import com.founder.framework.base.entity.BaseEntity;

/**
 * ****************************************************************************
 * @Package:      [com.founder.xlff.vo.Sf_Organization.java]  
 * @ClassName:    [Sf_Organization]   
 * @Description:  [巡逻防范-四色预警算法vo; 根据orgcode记录对应的四色预警查询条件]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-6-19 下午3:41:15]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-19 下午3:41:15，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
public class Sf_Organization extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//查询条件
	private String kssj;
	private String jssj;
	private String f1;
	private String f2;
	private String f3;
	private String f4;
	//返回结果
	private String count;
	private String color;
	private String orgcode;
	private String zzjgmc;
	private String zzjgdm;
	private String id;
	private String bjzbz;
	
	public String getZzjgmc() {
		return zzjgmc;
	}
	public void setZzjgmc(String zzjgmc) {
		this.zzjgmc = zzjgmc;
	}
	public String getBjzbz() {
		return bjzbz;
	}
	public void setBjzbz(String bjzbz) {
		this.bjzbz = bjzbz;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getF4() {
		return f4;
	}
	public void setF4(String f4) {
		this.f4 = f4;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getOrgcode() {
		return orgcode;
	}
	public void setOrgcode(String orgcode) {
		this.orgcode = orgcode;
	}
	public String getZzjgdm() {
		return zzjgdm;
	}
	public void setZzjgdm(String zzjgdm) {
		this.zzjgdm = zzjgdm;
	}
	
}
