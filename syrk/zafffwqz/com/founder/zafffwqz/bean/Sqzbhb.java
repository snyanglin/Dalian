package com.founder.zafffwqz.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

@DBInfoAnnotation(tableName = "ZAFF_SQZBHB", pk = "id")
public class Sqzbhb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@FieldDesc("社区治保会ID")
	private String id;
	@FieldDesc("社区ID")
	private String sqid;
	@FieldDesc("社区警务室ID")
	private String sqjwsid;
	
	@FieldDesc("负责人常用证件代码")
	private String fzrcyzjdm;

	
	
	@FieldDesc("负责人姓名")
	private String fzrxm;
	@FieldDesc("负责人联系方式")
	private String fzrlxfs;
	@FieldDesc("组织名称")
	private String zzmc;
	@FieldDesc("组织类别 默认 ‘治保组织’   只读")
	private String zzlb;
	@FieldDesc("组织形式代码")
	private String zzxsdm;
	@FieldDesc("责任范围")
	private String zrfw;
	@FieldDesc("装备配置情况")
	private String zbpzqk;
	@FieldDesc("治保会地址代码")
	private String zbhdzdm;
	@FieldDesc("治保会地址省市县代码")
	private String zbhdzssxdm;
	@FieldDesc("治保会地址详址")
	private String zbhdzxz;
	@FieldDesc("治保会地址门楼牌代码")
	private String zbhdzmlpdm;
	@FieldDesc("治保会地址门楼牌详址")
	private String zbhdzmlpxz;
	@FieldDesc("地域类别代码")
	private String dzlbdm;
	@FieldDesc("隶属关系代码")
	private String lsgxdm;
	@FieldDesc("经费来源")
	private String jfly;
	@FieldDesc("作用情况")
	private String zyqk;
	@FieldDesc("是否治安承包代码")
	private String sfzacbdm;
	@FieldDesc("组建日期")
	private String zjrq;
	@FieldDesc("组织联系方式")
	private String zzlxfs;
	@FieldDesc("组织传真号码")
	private String zzczhm;
	@FieldDesc("备注")
	private String bz;
	@FieldDesc("人员ID")
	private String ryid;
	
	//修改添加
	@FieldDesc("负责人证件号码")
	private String fzrzjhm;
	private String zw;
	@FieldDesc("分管工作描述")
	private String fggzms;
	@FieldDesc("治保会地址代码")
	private String dz_zbhdzdm;
	@FieldDesc("治保会地址省市县代码")
	private String dz_zbhdzssxdm;
	@FieldDesc("治保会地址详址")
	private String dz_zbhdzxz;
	@FieldDesc("治保会地址门楼牌代码")
	private String dz_zbhdzmlpdm;
	@FieldDesc("治保会地址门楼牌详址")
	private String dz_zbhdzmlpxz;	
	@FieldDesc("地域类别代码")
	private String dylbdm;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSqid() {
		return sqid;
	}
	public void setSqid(String sqid) {
		this.sqid = sqid;
	}
	public String getSqjwsid() {
		return sqjwsid;
	}
	public void setSqjwsid(String sqjwsid) {
		this.sqjwsid = sqjwsid;
	}
	public String getFzrcyzjdm() {
		return fzrcyzjdm;
	}
	public void setFzrcyzjdm(String fzrcyzjdm) {
		this.fzrcyzjdm = fzrcyzjdm;
	}
	public String getFzrxm() {
		return fzrxm;
	}
	public void setFzrxm(String fzrxm) {
		this.fzrxm = fzrxm;
	}
	public String getFzrlxfs() {
		return fzrlxfs;
	}
	public void setFzrlxfs(String fzrlxfs) {
		this.fzrlxfs = fzrlxfs;
	}
	public String getZzmc() {
		return zzmc;
	}
	public void setZzmc(String zzmc) {
		this.zzmc = zzmc;
	}
	public String getZzlb() {
		return zzlb;
	}
	public void setZzlb(String zzlb) {
		this.zzlb = zzlb;
	}
	public String getZzxsdm() {
		return zzxsdm;
	}
	public void setZzxsdm(String zzxsdm) {
		this.zzxsdm = zzxsdm;
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
	public String getZbhdzdm() {
		return zbhdzdm;
	}
	public void setZbhdzdm(String zbhdzdm) {
		this.zbhdzdm = zbhdzdm;
	}
	public String getZbhdzssxdm() {
		return zbhdzssxdm;
	}
	public void setZbhdzssxdm(String zbhdzssxdm) {
		this.zbhdzssxdm = zbhdzssxdm;
	}
	public String getZbhdzxz() {
		return zbhdzxz;
	}
	public void setZbhdzxz(String zbhdzxz) {
		this.zbhdzxz = zbhdzxz;
	}
	public String getZbhdzmlpdm() {
		return zbhdzmlpdm;
	}
	public void setZbhdzmlpdm(String zbhdzmlpdm) {
		this.zbhdzmlpdm = zbhdzmlpdm;
	}
	public String getZbhdzmlpxz() {
		return zbhdzmlpxz;
	}
	public void setZbhdzmlpxz(String zbhdzmlpxz) {
		this.zbhdzmlpxz = zbhdzmlpxz;
	}
	public String getDzlbdm() {
		return dzlbdm;
	}
	public void setDzlbdm(String dzlbdm) {
		this.dzlbdm = dzlbdm;
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
	public String getZzlxfs() {
		return zzlxfs;
	}
	public void setZzlxfs(String zzlxfs) {
		this.zzlxfs = zzlxfs;
	}
	public String getZzczhm() {
		return zzczhm;
	}
	public void setZzczhm(String zzczhm) {
		this.zzczhm = zzczhm;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getRyid() {
		return ryid;
	}
	public void setRyid(String ryid) {
		this.ryid = ryid;
	}
	public String getFzrzjhm() {
		return fzrzjhm;
	}
	public void setFzrzjhm(String fzrzjhm) {
		this.fzrzjhm = fzrzjhm;
	}
	public String getZw() {
		return zw;
	}
	public void setZw(String zw) {
		this.zw = zw;
	}
	public String getFggzms() {
		return fggzms;
	}
	public void setFggzms(String fggzms) {
		this.fggzms = fggzms;
	}
	public String getDz_zbhdzdm() {
		return dz_zbhdzdm;
	}
	public void setDz_zbhdzdm(String dz_zbhdzdm) {
		this.dz_zbhdzdm = dz_zbhdzdm;
	}
	public String getDz_zbhdzssxdm() {
		return dz_zbhdzssxdm;
	}
	public void setDz_zbhdzssxdm(String dz_zbhdzssxdm) {
		this.dz_zbhdzssxdm = dz_zbhdzssxdm;
	}
	public String getDz_zbhdzxz() {
		return dz_zbhdzxz;
	}
	public void setDz_zbhdzxz(String dz_zbhdzxz) {
		this.dz_zbhdzxz = dz_zbhdzxz;
	}
	public String getDz_zbhdzmlpdm() {
		return dz_zbhdzmlpdm;
	}
	public void setDz_zbhdzmlpdm(String dz_zbhdzmlpdm) {
		this.dz_zbhdzmlpdm = dz_zbhdzmlpdm;
	}
	public String getDz_zbhdzmlpxz() {
		return dz_zbhdzmlpxz;
	}
	public void setDz_zbhdzmlpxz(String dz_zbhdzmlpxz) {
		this.dz_zbhdzmlpxz = dz_zbhdzmlpxz;
	}
	public String getDylbdm() {
		return dylbdm;
	}
	public void setDylbdm(String dylbdm) {
		this.dylbdm = dylbdm;
	}
	
	
	
}
