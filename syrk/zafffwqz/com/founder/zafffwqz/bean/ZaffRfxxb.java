package com.founder.zafffwqz.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;
@DBInfoAnnotation(tableName = "ZAFF_RFXXB", pk = "id")
public class ZaffRfxxb extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@FieldDesc("人防ID")
	private String id;
	@FieldDesc("实有单位ID")
	private String sydwid;
	@FieldDesc("社区警务室ID")
	private String sqjwsid;
	@FieldDesc("防范组织形式代码")
	private String ffzzxsdm;
	@FieldDesc("防范负责人常用证件代码")
	private String ffzrrcyzjdm;
	@FieldDesc("防范负责人证件号码")
	private String ffzrrzjhm;
	@FieldDesc("防范负责人姓名")
	private String ffzrrxm;
	@FieldDesc("防范负责人联系电话")
	private String ffzrrlxdh;
	@FieldDesc("防范负责人传真号码")
	private String ffzrrczhm;
	@FieldDesc("地址_防范负责人居住地址代码")
	private String dz_ffzrrjzdzdm;
	@FieldDesc("地址_防范负责人居住地址省市县代码")
	private String dz_ffzrrjzdzssxdm;
	@FieldDesc("地址_防范负责人居住地址详址")
	private String dz_ffzrrjzdzxz;
	@FieldDesc("地址_防范负责人居住地址门楼牌代码")
	private String dz_ffzrrjzdzmlpdm;
	@FieldDesc("地址_防范负责人居住地址门楼牌详址")
	private String dz_ffzrrjzdzmlpxz;
	@FieldDesc("地址_防范负责人所属单位地址代码")
	private String dz_ffzrrssdwdzdm;
	@FieldDesc("地址_防范负责人所属单位地址省市县代码")
	private String dz_ffzrrssdwdzssxdm;
	@FieldDesc("地址_防范负责人所属单位地址详址")
	private String dz_ffzrrssdwdzxz;
	@FieldDesc("地址_防范负责人所属单位地址门楼牌代码")
	private String dz_ffzrrssdwdzmlpdm;
	@FieldDesc("地址_防范负责人所属单位地址门楼牌详址")
	private String dz_ffzrrssdwdzmlpxz;
	@FieldDesc("防范组织ID")
	private String ffzzid;
	@FieldDesc("防范组织名称")
	private String ffzzmc;
	@FieldDesc("防范组织类别")
	private String ffzzlb;
	@FieldDesc("防范组织联系电话")
	private String ffzzlxdh;
	@FieldDesc("防范组织传真号码")
	private String ffzzczhm;
	@FieldDesc("是否定时巡逻代码")
	private String sfdsxldm;
	@FieldDesc("防范方式代码")
	private String fffsdm;
	@FieldDesc("防范部位")
	private String ffbw;
	@FieldDesc("携带设备")
	private String xdsb;
	@FieldDesc("巡逻类型代码")
	private String xllxdm;
	@FieldDesc("巡逻路线")
	private String xllx;
	@FieldDesc("是否治安承包代码")
	private String sfzacbdm;
	@FieldDesc("组建日期")
	private String zjrq;
	@FieldDesc("责任范围")
	private String zrfw;
	@FieldDesc("装备配置情况")
	private String zbpzqk;
	@FieldDesc("地域类别代码")
	private String dylbdm;
	@FieldDesc("隶属关系代码")
	private String lsgxdm;
	@FieldDesc("经费来源")
	private String jfly;
	@FieldDesc("作用情况")
	private String zyqk;
	@FieldDesc("备注")
	private String bz;
	@FieldDesc("防范负责人所属单位ＩＤ")
	private String fffzrssdwid;
	@FieldDesc("地址_防范组织地址代码")
	private String dz_ffzzdzdm;
	@FieldDesc("地址_防范组织地址省市县代码")
	private String dz_ffzzdzssxdm;
	@FieldDesc("地址_防范组织地址详址")
	private String dz_ffzzdzxz;
	@FieldDesc("地址_防范组织地址门楼牌代码")
	private String dz_ffzzdzmlpdm;
	@FieldDesc("地址_防范组织地址门楼牌详址")
	private String dz_ffzzdzmlpxz;
	@FieldDesc("防范负责人ID")
	private String fffzrid;
	@FieldDesc("防范负责人所属单位名称")
	private String fffzrssdwmc;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFfzzxsdm() {
		return ffzzxsdm;
	}
	public void setFfzzxsdm(String ffzzxsdm) {
		this.ffzzxsdm = ffzzxsdm;
	}
	public String getFfzrrcyzjdm() {
		return ffzrrcyzjdm;
	}
	public void setFfzrrcyzjdm(String ffzrrcyzjdm) {
		this.ffzrrcyzjdm = ffzrrcyzjdm;
	}
	public String getFfzrrzjhm() {
		return ffzrrzjhm;
	}
	public void setFfzrrzjhm(String ffzrrzjhm) {
		this.ffzrrzjhm = ffzrrzjhm;
	}
	public String getFfzrrxm() {
		return ffzrrxm;
	}
	public void setFfzrrxm(String ffzrrxm) {
		this.ffzrrxm = ffzrrxm;
	}
	public String getFfzrrlxdh() {
		return ffzrrlxdh;
	}
	public void setFfzrrlxdh(String ffzrrlxdh) {
		this.ffzrrlxdh = ffzrrlxdh;
	}
	public String getFfzrrczhm() {
		return ffzrrczhm;
	}
	public void setFfzrrczhm(String ffzrrczhm) {
		this.ffzrrczhm = ffzrrczhm;
	}
	public String getDz_ffzrrjzdzdm() {
		return dz_ffzrrjzdzdm;
	}
	public void setDz_ffzrrjzdzdm(String dz_ffzrrjzdzdm) {
		this.dz_ffzrrjzdzdm = dz_ffzrrjzdzdm;
	}
	public String getDz_ffzrrjzdzssxdm() {
		return dz_ffzrrjzdzssxdm;
	}
	public void setDz_ffzrrjzdzssxdm(String dz_ffzrrjzdzssxdm) {
		this.dz_ffzrrjzdzssxdm = dz_ffzrrjzdzssxdm;
	}
	public String getDz_ffzrrjzdzxz() {
		return dz_ffzrrjzdzxz;
	}
	public void setDz_ffzrrjzdzxz(String dz_ffzrrjzdzxz) {
		this.dz_ffzrrjzdzxz = dz_ffzrrjzdzxz;
	}
	public String getDz_ffzrrjzdzmlpdm() {
		return dz_ffzrrjzdzmlpdm;
	}
	public void setDz_ffzrrjzdzmlpdm(String dz_ffzrrjzdzmlpdm) {
		this.dz_ffzrrjzdzmlpdm = dz_ffzrrjzdzmlpdm;
	}
	public String getDz_ffzrrjzdzmlpxz() {
		return dz_ffzrrjzdzmlpxz;
	}
	public void setDz_ffzrrjzdzmlpxz(String dz_ffzrrjzdzmlpxz) {
		this.dz_ffzrrjzdzmlpxz = dz_ffzrrjzdzmlpxz;
	}
	public String getDz_ffzrrssdwdzdm() {
		return dz_ffzrrssdwdzdm;
	}
	public void setDz_ffzrrssdwdzdm(String dz_ffzrrssdwdzdm) {
		this.dz_ffzrrssdwdzdm = dz_ffzrrssdwdzdm;
	}
	public String getDz_ffzrrssdwdzssxdm() {
		return dz_ffzrrssdwdzssxdm;
	}
	public void setDz_ffzrrssdwdzssxdm(String dz_ffzrrssdwdzssxdm) {
		this.dz_ffzrrssdwdzssxdm = dz_ffzrrssdwdzssxdm;
	}
	public String getDz_ffzrrssdwdzxz() {
		return dz_ffzrrssdwdzxz;
	}
	public void setDz_ffzrrssdwdzxz(String dz_ffzrrssdwdzxz) {
		this.dz_ffzrrssdwdzxz = dz_ffzrrssdwdzxz;
	}
	public String getDz_ffzrrssdwdzmlpdm() {
		return dz_ffzrrssdwdzmlpdm;
	}
	public void setDz_ffzrrssdwdzmlpdm(String dz_ffzrrssdwdzmlpdm) {
		this.dz_ffzrrssdwdzmlpdm = dz_ffzrrssdwdzmlpdm;
	}
	public String getDz_ffzrrssdwdzmlpxz() {
		return dz_ffzrrssdwdzmlpxz;
	}
	public void setDz_ffzrrssdwdzmlpxz(String dz_ffzrrssdwdzmlpxz) {
		this.dz_ffzrrssdwdzmlpxz = dz_ffzrrssdwdzmlpxz;
	}
	public String getFfzzid() {
		return ffzzid;
	}
	public void setFfzzid(String ffzzid) {
		this.ffzzid = ffzzid;
	}
	public String getFfzzmc() {
		return ffzzmc;
	}
	public void setFfzzmc(String ffzzmc) {
		this.ffzzmc = ffzzmc;
	}
	public String getFfzzlb() {
		return ffzzlb;
	}
	public void setFfzzlb(String ffzzlb) {
		this.ffzzlb = ffzzlb;
	}
	public String getFfzzlxdh() {
		return ffzzlxdh;
	}
	public void setFfzzlxdh(String ffzzlxdh) {
		this.ffzzlxdh = ffzzlxdh;
	}
	public String getFfzzczhm() {
		return ffzzczhm;
	}
	public void setFfzzczhm(String ffzzczhm) {
		this.ffzzczhm = ffzzczhm;
	}
	public String getSfdsxldm() {
		return sfdsxldm;
	}
	public void setSfdsxldm(String sfdsxldm) {
		this.sfdsxldm = sfdsxldm;
	}
	public String getFffsdm() {
		return fffsdm;
	}
	public void setFffsdm(String fffsdm) {
		this.fffsdm = fffsdm;
	}
	public String getFfbw() {
		return ffbw;
	}
	public void setFfbw(String ffbw) {
		this.ffbw = ffbw;
	}
	public String getXdsb() {
		return xdsb;
	}
	public void setXdsb(String xdsb) {
		this.xdsb = xdsb;
	}
	public String getXllxdm() {
		return xllxdm;
	}
	public void setXllxdm(String xllxdm) {
		this.xllxdm = xllxdm;
	}
	public String getXllx() {
		return xllx;
	}
	public void setXllx(String xllx) {
		this.xllx = xllx;
	}
	public String getSfzacbdm() {
		return sfzacbdm;
	}
	public void setSfzacbdm(String sfzacbdm) {
		this.sfzacbdm = sfzacbdm;
	}
	public String getZjrq() {
		return zjrq;
	}
	public void setZjrq(String zjrq) {
		this.zjrq = zjrq;
	}
	public String getZrfw() {
		return zrfw;
	}
	public void setZrfw(String zrfw) {
		this.zrfw = zrfw;
	}
	public String getZbpzqk() {
		return zbpzqk;
	}
	public void setZbpzqk(String zbpzqk) {
		this.zbpzqk = zbpzqk;
	}
	public String getDylbdm() {
		return dylbdm;
	}
	public void setDylbdm(String dylbdm) {
		this.dylbdm = dylbdm;
	}
	public String getLsgxdm() {
		return lsgxdm;
	}
	public void setLsgxdm(String lsgxdm) {
		this.lsgxdm = lsgxdm;
	}
	public String getJfly() {
		return jfly;
	}
	public void setJfly(String jfly) {
		this.jfly = jfly;
	}
	public String getZyqk() {
		return zyqk;
	}
	public void setZyqk(String zyqk) {
		this.zyqk = zyqk;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getFffzrssdwid() {
		return fffzrssdwid;
	}
	public void setFffzrssdwid(String fffzrssdwid) {
		this.fffzrssdwid = fffzrssdwid;
	}
	public String getDz_ffzzdzdm() {
		return dz_ffzzdzdm;
	}
	public void setDz_ffzzdzdm(String dz_ffzzdzdm) {
		this.dz_ffzzdzdm = dz_ffzzdzdm;
	}
	public String getDz_ffzzdzssxdm() {
		return dz_ffzzdzssxdm;
	}
	public void setDz_ffzzdzssxdm(String dz_ffzzdzssxdm) {
		this.dz_ffzzdzssxdm = dz_ffzzdzssxdm;
	}
	public String getDz_ffzzdzxz() {
		return dz_ffzzdzxz;
	}
	public void setDz_ffzzdzxz(String dz_ffzzdzxz) {
		this.dz_ffzzdzxz = dz_ffzzdzxz;
	}
	public String getDz_ffzzdzmlpdm() {
		return dz_ffzzdzmlpdm;
	}
	public void setDz_ffzzdzmlpdm(String dz_ffzzdzmlpdm) {
		this.dz_ffzzdzmlpdm = dz_ffzzdzmlpdm;
	}
	public String getDz_ffzzdzmlpxz() {
		return dz_ffzzdzmlpxz;
	}
	public void setDz_ffzzdzmlpxz(String dz_ffzzdzmlpxz) {
		this.dz_ffzzdzmlpxz = dz_ffzzdzmlpxz;
	}
	public String getFffzrid() {
		return fffzrid;
	}
	public void setFffzrid(String fffzrid) {
		this.fffzrid = fffzrid;
	}
	public String getFffzrssdwmc() {
		return fffzrssdwmc;
	}
	public void setFffzrssdwmc(String fffzrssdwmc) {
		this.fffzrssdwmc = fffzrssdwmc;
	}
	public String getSydwid() {
		return sydwid;
	}
	public void setSydwid(String sydwid) {
		this.sydwid = sydwid;
	}
	public String getSqjwsid() {
		return sqjwsid;
	}
	public void setSqjwsid(String sqjwsid) {
		this.sqjwsid = sqjwsid;
	}
	
	
}
