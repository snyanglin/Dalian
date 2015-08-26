package com.founder.zafffwqz.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

@DBInfoAnnotation(tableName = "ZAFF_BAZZB", pk = "id")
public class Bazzb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@FieldDesc("保安组织ID")
	private String id;
	@FieldDesc("社区ID")
	private String sqid;
	@FieldDesc("社区警务室ID")
	private String sqjwsid;
	@FieldDesc("负责人常用证件代码")
	private String fzrcyzjdm;
	@FieldDesc("负责人证件号码")
	private String fzrzjhm;
	@FieldDesc("负责人姓名")
	private String fzrxm;
	@FieldDesc("负责人联系方式")
	private String fzrlxfs;
	@FieldDesc("组织名称")
	private String zzmc;
	@FieldDesc("组织类别  默认为“保安组织”")
	private String zzlb;
	@FieldDesc("组织形式代码")
	private String zzxsdm;
	@FieldDesc("责任范围")
	private String zrfw;
	@FieldDesc("装备配备情况")
	private String zbpbqk;
	@FieldDesc("保安组织地址代码")
	private String bazzdzdm;
	@FieldDesc("保安组织地址省市县代码")
	private String bazzdzssxdm;
	@FieldDesc("保安组织地址详址")
	private String bazzdzdzxz;
	@FieldDesc("保安组织地址门楼牌代码")
	private String bazzdzmlpdm;
	@FieldDesc("保安组织地址门楼牌详址")
	private String bazzdzdzmlpxz;
	@FieldDesc("地域类别代码")
	private String dylbdm;
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
	@FieldDesc("所属单位")
	private String ssdw;
	@FieldDesc("备注")
	private String bz;
	@FieldDesc("人员ID")
	private String ryid;
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
	public String getFzrzjhm() {
		return fzrzjhm;
	}
	public void setFzrzjhm(String fzrzjhm) {
		this.fzrzjhm = fzrzjhm;
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
	public String getZbpbqk() {
		return zbpbqk;
	}
	public void setZbpbqk(String zbpbqk) {
		this.zbpbqk = zbpbqk;
	}
	public String getBazzdzdm() {
		return bazzdzdm;
	}
	public void setBazzdzdm(String bazzdzdm) {
		this.bazzdzdm = bazzdzdm;
	}
	public String getBazzdzssxdm() {
		return bazzdzssxdm;
	}
	public void setBazzdzssxdm(String bazzdzssxdm) {
		this.bazzdzssxdm = bazzdzssxdm;
	}
	public String getBazzdzdzxz() {
		return bazzdzdzxz;
	}
	public void setBazzdzdzxz(String bazzdzdzxz) {
		this.bazzdzdzxz = bazzdzdzxz;
	}
	public String getBazzdzmlpdm() {
		return bazzdzmlpdm;
	}
	public void setBazzdzmlpdm(String bazzdzmlpdm) {
		this.bazzdzmlpdm = bazzdzmlpdm;
	}
	public String getBazzdzdzmlpxz() {
		return bazzdzdzmlpxz;
	}
	public void setBazzdzdzmlpxz(String bazzdzdzmlpxz) {
		this.bazzdzdzmlpxz = bazzdzdzmlpxz;
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
	public String getSsdw() {
		return ssdw;
	}
	public void setSsdw(String ssdw) {
		this.ssdw = ssdw;
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
	
}
