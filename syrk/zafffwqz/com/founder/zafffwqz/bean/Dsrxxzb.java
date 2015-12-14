package com.founder.zafffwqz.bean;
import java.io.Serializable;
import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;
/******************************************************************************
 * @Package:      [com.founder.zafffwqz.bean.Dsrxxzb.java]  
 * @ClassName:    [Dsrxxzb]   
 * @Description:  [矛盾-当事人实体类]   
 * @Author:       [tian_chengwei@founder.com.cn]  
 * @CreateDate:   [2015-6-2 下午11:52:40]   
 * @UpdateUser:   [lk(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-2 下午11:52:40，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@DBInfoAnnotation(tableName = "FWQZ_MD_DSRXXZB" , pk = "id")
public class Dsrxxzb extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@FieldDesc("当事人信息子表ID")
	private String id;
	@FieldDesc("矛盾纠纷信息ID")
	private String mdjfxxid;
	@FieldDesc("人员ID")
	private String ryid;
	@FieldDesc("常用证件代码")
	private String cyzjdm;
	@FieldDesc("证件号码")
	private String zjhm;
	@FieldDesc("姓名")
	private String xm;
	@FieldDesc("性别代码")
	private String xbdm;
	@FieldDesc("出生日期")
	private String csrq;
	@FieldDesc("地址-居住地址代码")
	private String dz_jzdzdm;
	@FieldDesc("地址-居住地址门楼牌代码")
	private String dz_jzdzmlpdm;
	@FieldDesc("地址-居住地址门楼牌详址")
	private String dz_jzdzmlpxz;
	@FieldDesc("地址-居住地址省市县代码")
	private String dz_jzdzssxdm;
	@FieldDesc("地址-居住地址详址")
	private String dz_jzdzxz;
	@FieldDesc("地址-户籍地址代码")
	private String dz_hjdzdm;
	@FieldDesc("地址-户籍地址门楼牌代码")
	private String dz_hjdzmlpdm;
	@FieldDesc("地址-户籍地址门楼牌详址")
	private String dz_hjdzmlpxz;
	@FieldDesc("地址-户籍地址省市县代码")
	private String dz_hjdzssxdm;
	@FieldDesc("地址-户籍地址详址")
	private String dz_hjdzxz;
	@FieldDesc("工作单位")
	private String gzdw;
	@FieldDesc("联系电话")
	private String lxdh;
	@FieldDesc("备注")
	private String bz;
	@FieldDesc("工作单位ID")
	private String gzdwid;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMdjfxxid() {
		return mdjfxxid;
	}
	public void setMdjfxxid(String mdjfxxid) {
		this.mdjfxxid = mdjfxxid;
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
	public String getXm() {
		return xm;
	}
	public void setXm(String xm) {
		this.xm = xm;
	}
	public String getXbdm() {
		return xbdm;
	}
	public void setXbdm(String xbdm) {
		this.xbdm = xbdm;
	}
	public String getCsrq() {
		return csrq;
	}
	public void setCsrq(String csrq) {
		this.csrq = csrq;
	}
	public String getDz_jzdzdm() {
		return dz_jzdzdm;
	}
	public void setDz_jzdzdm(String dz_jzdzdm) {
		this.dz_jzdzdm = dz_jzdzdm;
	}
	public String getDz_jzdzmlpdm() {
		return dz_jzdzmlpdm;
	}
	public void setDz_jzdzmlpdm(String dz_jzdzmlpdm) {
		this.dz_jzdzmlpdm = dz_jzdzmlpdm;
	}
	public String getDz_jzdzmlpxz() {
		return dz_jzdzmlpxz;
	}
	public void setDz_jzdzmlpxz(String dz_jzdzmlpxz) {
		this.dz_jzdzmlpxz = dz_jzdzmlpxz;
	}
	public String getDz_jzdzssxdm() {
		return dz_jzdzssxdm;
	}
	public void setDz_jzdzssxdm(String dz_jzdzssxdm) {
		this.dz_jzdzssxdm = dz_jzdzssxdm;
	}
	public String getDz_jzdzxz() {
		return dz_jzdzxz;
	}
	public void setDz_jzdzxz(String dz_jzdzxz) {
		this.dz_jzdzxz = dz_jzdzxz;
	}
	public String getDz_hjdzdm() {
		return dz_hjdzdm;
	}
	public void setDz_hjdzdm(String dz_hjdzdm) {
		this.dz_hjdzdm = dz_hjdzdm;
	}
	public String getDz_hjdzmlpdm() {
		return dz_hjdzmlpdm;
	}
	public void setDz_hjdzmlpdm(String dz_hjdzmlpdm) {
		this.dz_hjdzmlpdm = dz_hjdzmlpdm;
	}
	public String getDz_hjdzmlpxz() {
		return dz_hjdzmlpxz;
	}
	public void setDz_hjdzmlpxz(String dz_hjdzmlpxz) {
		this.dz_hjdzmlpxz = dz_hjdzmlpxz;
	}
	public String getDz_hjdzssxdm() {
		return dz_hjdzssxdm;
	}
	public void setDz_hjdzssxdm(String dz_hjdzssxdm) {
		this.dz_hjdzssxdm = dz_hjdzssxdm;
	}
	public String getDz_hjdzxz() {
		return dz_hjdzxz;
	}
	public void setDz_hjdzxz(String dz_hjdzxz) {
		this.dz_hjdzxz = dz_hjdzxz;
	}
	public String getGzdw() {
		return gzdw;
	}
	public void setGzdw(String gzdw) {
		this.gzdw = gzdw;
	}
	public String getLxdh() {
		return lxdh;
	}
	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getGzdwid() {
		return gzdwid;
	}
	public void setGzdwid(String gzdwid) {
		this.gzdwid = gzdwid;
	}
	
	

}
