package com.founder.sydw.bean;

import java.io.Serializable;

import org.springframework.format.annotation.NumberFormat;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

@DBInfoAnnotation(tableName = "DW_DWCCXXB", pk = "id")
public class Dwccxxb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@FieldDesc("ID")
	private String id;
	@FieldDesc("单位ID")
	private String dwid;
	@FieldDesc("地址-仓储地址代码")
	private String dz_ccdzdm;
	@FieldDesc("地址-仓储地址行政区划代码")
	private String dz_ccdzxzqhdm;
	@FieldDesc("地址-仓储地址详址")
	private String dz_ccdzxz;
	@FieldDesc("仓储名称")
	private String ccmc;
	@FieldDesc("占地面积")
	private String zdmj;
	@FieldDesc("建筑面积")
	private String jzmj;
	@FieldDesc("是否独立仓储代码")
	private String sfdlccdm;
	@FieldDesc("起用时间")
	private String qysj;
	@FieldDesc("使用期限")
	private String ysqx;
	@FieldDesc("仓储物品")
	private String ccwp;
	@FieldDesc("仓储面积")
	private String ccmj;
	@FieldDesc("仓储容积")
	private String ccrj;
	@FieldDesc("仓储数量")
	@NumberFormat
	private Long ccsl;
	@FieldDesc("数量单位")
	private String sldw;
	@FieldDesc("消防设备情况")
	private String xfsbqk;
	@FieldDesc("值更人员信息")
	private String zgryxx;
	@FieldDesc("仓储值班室电话")
	private String cczbsdh;
	@FieldDesc("库管人员信息")
	private String kgryxx;
	@FieldDesc("仓储负责人ID")
	private String ccfzrid;
	@FieldDesc("仓储负责人常用证件代码")
	private String ccfzrcyzjdm;
	@FieldDesc("仓储负责人证件号码")
	private String ccfzrzjhm;
	@FieldDesc("仓储负责人")
	private String ccfzr;
	@FieldDesc("仓储负责人职务")
	private String ccfzrzw;
	@FieldDesc("仓储负责人联系电话")
	private String ccfzrlxdh;
	@FieldDesc("备注")
	private String bz;
	@FieldDesc("地址-仓储地址门楼牌代码")
	private String dz_ccdzmlpdm;
	@FieldDesc("地址-仓储地址门楼牌详址")
	private String dz_ccdzmlpxz;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDwid() {
		return dwid;
	}
	public void setDwid(String dwid) {
		this.dwid = dwid;
	}
	public String getDz_ccdzdm() {
		return dz_ccdzdm;
	}
	public void setDz_ccdzdm(String dz_ccdzdm) {
		this.dz_ccdzdm = dz_ccdzdm;
	}
	public String getDz_ccdzxzqhdm() {
		return dz_ccdzxzqhdm;
	}
	public void setDz_ccdzxzqhdm(String dz_ccdzxzqhdm) {
		this.dz_ccdzxzqhdm = dz_ccdzxzqhdm;
	}
	public String getDz_ccdzxz() {
		return dz_ccdzxz;
	}
	public void setDz_ccdzxz(String dz_ccdzxz) {
		this.dz_ccdzxz = dz_ccdzxz;
	}
	public String getCcmc() {
		return ccmc;
	}
	public void setCcmc(String ccmc) {
		this.ccmc = ccmc;
	}
	
	public String getSfdlccdm() {
		return sfdlccdm;
	}
	public void setSfdlccdm(String sfdlccdm) {
		this.sfdlccdm = sfdlccdm;
	}
	public String getQysj() {
		return qysj;
	}
	public void setQysj(String qysj) {
		this.qysj = qysj;
	}
	public String getYsqx() {
		return ysqx;
	}
	public void setYsqx(String ysqx) {
		this.ysqx = ysqx;
	}
	public String getCcwp() {
		return ccwp;
	}
	public void setCcwp(String ccwp) {
		this.ccwp = ccwp;
	}
	public String getZdmj() {
		return zdmj;
	}
	public void setZdmj(String zdmj) {
		this.zdmj = zdmj;
	}
	public String getJzmj() {
		return jzmj;
	}
	public void setJzmj(String jzmj) {
		this.jzmj = jzmj;
	}
	public String getCcmj() {
		return ccmj;
	}
	public void setCcmj(String ccmj) {
		this.ccmj = ccmj;
	}
	public String getCcrj() {
		return ccrj;
	}
	public void setCcrj(String ccrj) {
		this.ccrj = ccrj;
	}
	public Long getCcsl() {
		return ccsl;
	}
	public void setCcsl(Long ccsl) {
		this.ccsl = ccsl;
	}
	public String getSldw() {
		return sldw;
	}
	public void setSldw(String sldw) {
		this.sldw = sldw;
	}
	public String getXfsbqk() {
		return xfsbqk;
	}
	public void setXfsbqk(String xfsbqk) {
		this.xfsbqk = xfsbqk;
	}
	public String getZgryxx() {
		return zgryxx;
	}
	public void setZgryxx(String zgryxx) {
		this.zgryxx = zgryxx;
	}
	public String getCczbsdh() {
		return cczbsdh;
	}
	public void setCczbsdh(String cczbsdh) {
		this.cczbsdh = cczbsdh;
	}
	public String getKgryxx() {
		return kgryxx;
	}
	public void setKgryxx(String kgryxx) {
		this.kgryxx = kgryxx;
	}

	public String getCcfzrid() {
		return ccfzrid;
	}
	public void setCcfzrid(String ccfzrid) {
		this.ccfzrid = ccfzrid;
	}
	public String getCcfzrcyzjdm() {
		return ccfzrcyzjdm;
	}
	public void setCcfzrcyzjdm(String ccfzrcyzjdm) {
		this.ccfzrcyzjdm = ccfzrcyzjdm;
	}
	
	public String getCcfzrzjhm() {
		return ccfzrzjhm;
	}
	public void setCcfzrzjhm(String ccfzrzjhm) {
		this.ccfzrzjhm = ccfzrzjhm;
	}
	
	public String getCcfzr() {
		return ccfzr;
	}
	public void setCcfzr(String ccfzr) {
		this.ccfzr = ccfzr;
	}
	
	public String getCcfzrzw() {
		return ccfzrzw;
	}
	public void setCcfzrzw(String ccfzrzw) {
		this.ccfzrzw = ccfzrzw;
	}
	public String getCcfzrlxdh() {
		return ccfzrlxdh;
	}
	public void setCcfzrlxdh(String ccfzrlxdh) {
		this.ccfzrlxdh = ccfzrlxdh;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getDz_ccdzmlpdm() {
		return dz_ccdzmlpdm;
	}
	public void setDz_ccdzmlpdm(String dz_ccdzmlpdm) {
		this.dz_ccdzmlpdm = dz_ccdzmlpdm;
	}
	public String getDz_ccdzmlpxz() {
		return dz_ccdzmlpxz;
	}
	public void setDz_ccdzmlpxz(String dz_ccdzmlpxz) {
		this.dz_ccdzmlpxz = dz_ccdzmlpxz;
	}

}
