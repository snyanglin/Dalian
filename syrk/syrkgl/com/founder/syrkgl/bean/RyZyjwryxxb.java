package com.founder.syrkgl.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;


/******************************************************************************
 * @Package:      [com.founder.syrkgl.bean.RyZyjwryxxb.java]  
 * @ClassName:    [RyZyjwryxxb]   
 * @Description:  [人员主要交往人员信息表]   
 * @Author:       [congrihong@founder.com.cn]  
 * @CreateDate:   [2015-4-28 上午9:30:47]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-28 上午9:30:47，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@DBInfoAnnotation(tableName = "RY_ZYJWRYXXB", pk = "id")
public class RyZyjwryxxb extends BaseEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@FieldDesc("主要交往人员ID")
	private String id;
	@FieldDesc("人员ID")
	private String ryid;
	@FieldDesc("主要交往人员_人员ID")
	private String zyjwry_ryid;
	@FieldDesc("证件种类")
	private String cyzjdm;
	@FieldDesc("证件号码")
	private String zjhm;
	@FieldDesc("姓名")
	private String xm;
	@FieldDesc("性别代码")
	private String xbdm;
	@FieldDesc("民族代码")
	private String mzdm;
	@FieldDesc("出生日期")
	private String csrq;
	@FieldDesc("籍贯国家/地区代码")
	private String jggjdqdm;
	@FieldDesc("籍贯省市县代码")
	private String jgssxdm;
	@FieldDesc("居住地_行政区划代码")
	private String jzd_xzqhdm;
	@FieldDesc("居住地_门楼牌代码")
	private String jzd_mlpdm;
	@FieldDesc("居住地_门楼牌详址")
	private String jzd_mlpxz;
	@FieldDesc("居住地_地址ID")
	private String jzd_dzid;
	@FieldDesc("居住地_地址详址")
	private String jzd_dzxz;
	@FieldDesc("联系电话")
	private String lxdh;
	@FieldDesc("工作单位ID")
	private String gzdwid;
	@FieldDesc("工作单位")
	private String gzdw;
	@FieldDesc("职业类别代码")
	private String zylbdm;
	@FieldDesc("职业")
	private String zy;
	@FieldDesc("人员关系")
	private String rygxdm;
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
	public String getZyjwry_ryid() {
		return zyjwry_ryid;
	}
	public void setZyjwry_ryid(String zyjwry_ryid) {
		this.zyjwry_ryid = zyjwry_ryid;
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
	public String getMzdm() {
		return mzdm;
	}
	public void setMzdm(String mzdm) {
		this.mzdm = mzdm;
	}
	public String getCsrq() {
		return csrq;
	}
	public void setCsrq(String csrq) {
		this.csrq = csrq;
	}
	public String getJggjdqdm() {
		return jggjdqdm;
	}
	public void setJggjdqdm(String jggjdqdm) {
		this.jggjdqdm = jggjdqdm;
	}
	public String getJgssxdm() {
		return jgssxdm;
	}
	public void setJgssxdm(String jgssxdm) {
		this.jgssxdm = jgssxdm;
	}
	public String getJzd_xzqhdm() {
		return jzd_xzqhdm;
	}
	public void setJzd_xzqhdm(String jzd_xzqhdm) {
		this.jzd_xzqhdm = jzd_xzqhdm;
	}
	public String getJzd_mlpdm() {
		return jzd_mlpdm;
	}
	public void setJzd_mlpdm(String jzd_mlpdm) {
		this.jzd_mlpdm = jzd_mlpdm;
	}
	public String getJzd_mlpxz() {
		return jzd_mlpxz;
	}
	public void setJzd_mlpxz(String jzd_mlpxz) {
		this.jzd_mlpxz = jzd_mlpxz;
	}
	public String getJzd_dzid() {
		return jzd_dzid;
	}
	public void setJzd_dzid(String jzd_dzid) {
		this.jzd_dzid = jzd_dzid;
	}
	public String getJzd_dzxz() {
		return jzd_dzxz;
	}
	public void setJzd_dzxz(String jzd_dzxz) {
		this.jzd_dzxz = jzd_dzxz;
	}
	public String getLxdh() {
		return lxdh;
	}
	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}
	public String getGzdwid() {
		return gzdwid;
	}
	public void setGzdwid(String gzdwid) {
		this.gzdwid = gzdwid;
	}
	public String getGzdw() {
		return gzdw;
	}
	public void setGzdw(String gzdw) {
		this.gzdw = gzdw;
	}
	public String getZylbdm() {
		return zylbdm;
	}
	public void setZylbdm(String zylbdm) {
		this.zylbdm = zylbdm;
	}
	public String getZy() {
		return zy;
	}
	public void setZy(String zy) {
		this.zy = zy;
	}
	public String getRygxdm() {
		return rygxdm;
	}
	public void setRygxdm(String rygxdm) {
		this.rygxdm = rygxdm;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}

	
}
