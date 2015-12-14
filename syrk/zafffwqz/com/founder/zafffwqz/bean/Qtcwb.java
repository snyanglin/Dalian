package com.founder.zafffwqz.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

@DBInfoAnnotation(tableName = "FWQZ_QTCWB", pk = "id")
public class Qtcwb  extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@FieldDesc("其它宠物ID")
	private String id;
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
	@FieldDesc("民族")
	private String mzdm;
	@FieldDesc("地址-居住地址代码")
	private String dz_jzdzdm;
	@FieldDesc("地址-居住地址省市县代码")
	private String dz_jzdzssxdm;
	@FieldDesc("地址-居住地址门楼牌代码")
	private String dz_jzdzmlpdm;
	@FieldDesc("地址-居住地址门楼牌详址")
	private String dz_jzdzmlpxz;
	@FieldDesc("地址-居住地址详址")
	private String dz_jzdzxz;
	@FieldDesc("联系电话")
	private String lxdh;
	@FieldDesc("是否单独居住代码")
	private String sfddjzdm;
	@FieldDesc("养宠物用途代码")
	private String ycwytdm;
	@FieldDesc("完全行为能力（字典项）")
	private String wqxwnldm;
	@FieldDesc("宠物型")
	private String cwx;
	@FieldDesc("宠物种")
	private String cwz;
	@FieldDesc("宠物龄(月)")
	private Long cwn;
	@FieldDesc("体重（公斤）")
	private Long tz;
	@FieldDesc("体高（厘米）")
	private Long tg;
	@FieldDesc("毛色（字典项）")
	private String msdm;
	@FieldDesc("雌雄（字典项）")
	private String cxdm;
	@FieldDesc("有无血统证代码（字典项）")
	private String ywxtzdm;
	@FieldDesc("发证机构")
	private String fzjg;
	@FieldDesc("血统证编号")
	private String xtzbh;
	@FieldDesc("防疫证号码")
	private String fyzhm;
	@FieldDesc("防疫部门")
	private String fybm;
	@FieldDesc("防疫有效截止日期")
	private String fyyxqzrq;
	@FieldDesc("养宠物许可证号码")
	private String ycwxkzhm;
	@FieldDesc("发证日期")
	private String fzrq;
	@FieldDesc("养宠物许可证有效截止日期")
	private String ycwxkzyxqzrq;
	@FieldDesc("领取人")
	private String lqr;
	@FieldDesc("承办人意见")
	private String cbryj;
	@FieldDesc("承办人")
	private String cbr;
	@FieldDesc("承办人ID")
	private String cbrid;
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
	public String getMzdm() {
		return mzdm;
	}
	public void setMzdm(String mzdm) {
		this.mzdm = mzdm;
	}
	public String getDz_jzdzdm() {
		return dz_jzdzdm;
	}
	public void setDz_jzdzdm(String dz_jzdzdm) {
		this.dz_jzdzdm = dz_jzdzdm;
	}
	public String getDz_jzdzssxdm() {
		return dz_jzdzssxdm;
	}
	public void setDz_jzdzssxdm(String dz_jzdzssxdm) {
		this.dz_jzdzssxdm = dz_jzdzssxdm;
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
	public String getDz_jzdzxz() {
		return dz_jzdzxz;
	}
	public void setDz_jzdzxz(String dz_jzdzxz) {
		this.dz_jzdzxz = dz_jzdzxz;
	}
	public String getLxdh() {
		return lxdh;
	}
	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}
	public String getSfddjzdm() {
		return sfddjzdm;
	}
	public void setSfddjzdm(String sfddjzdm) {
		this.sfddjzdm = sfddjzdm;
	}
	public String getYcwytdm() {
		return ycwytdm;
	}
	public void setYcwytdm(String ycwytdm) {
		this.ycwytdm = ycwytdm;
	}
	public String getWqxwnldm() {
		return wqxwnldm;
	}
	public void setWqxwnldm(String wqxwnldm) {
		this.wqxwnldm = wqxwnldm;
	}
	public String getCwx() {
		return cwx;
	}
	public void setCwx(String cwx) {
		this.cwx = cwx;
	}
	public String getCwz() {
		return cwz;
	}
	public void setCwz(String cwz) {
		this.cwz = cwz;
	}
	public Long getCwn() {
		return cwn;
	}
	public void setCwn(Long cwn) {
		this.cwn = cwn;
	}
	public Long getTz() {
		return tz;
	}
	public void setTz(Long tz) {
		this.tz = tz;
	}
	public Long getTg() {
		return tg;
	}
	public void setTg(Long tg) {
		this.tg = tg;
	}
	public String getMsdm() {
		return msdm;
	}
	public void setMsdm(String msdm) {
		this.msdm = msdm;
	}
	public String getCxdm() {
		return cxdm;
	}
	public void setCxdm(String cxdm) {
		this.cxdm = cxdm;
	}
	public String getYwxtzdm() {
		return ywxtzdm;
	}
	public void setYwxtzdm(String ywxtzdm) {
		this.ywxtzdm = ywxtzdm;
	}
	public String getFzjg() {
		return fzjg;
	}
	public void setFzjg(String fzjg) {
		this.fzjg = fzjg;
	}
	public String getXtzbh() {
		return xtzbh;
	}
	public void setXtzbh(String xtzbh) {
		this.xtzbh = xtzbh;
	}
	public String getFyzhm() {
		return fyzhm;
	}
	public void setFyzhm(String fyzhm) {
		this.fyzhm = fyzhm;
	}
	public String getFybm() {
		return fybm;
	}
	public void setFybm(String fybm) {
		this.fybm = fybm;
	}
	public String getFyyxqzrq() {
		return fyyxqzrq;
	}
	public void setFyyxqzrq(String fyyxqzrq) {
		this.fyyxqzrq = fyyxqzrq;
	}
	public String getYcwxkzhm() {
		return ycwxkzhm;
	}
	public void setYcwxkzhm(String ycwxkzhm) {
		this.ycwxkzhm = ycwxkzhm;
	}
	public String getFzrq() {
		return fzrq;
	}
	public void setFzrq(String fzrq) {
		this.fzrq = fzrq;
	}
	public String getYcwxkzyxqzrq() {
		return ycwxkzyxqzrq;
	}
	public void setYcwxkzyxqzrq(String ycwxkzyxqzrq) {
		this.ycwxkzyxqzrq = ycwxkzyxqzrq;
	}
	public String getLqr() {
		return lqr;
	}
	public void setLqr(String lqr) {
		this.lqr = lqr;
	}
	public String getCbryj() {
		return cbryj;
	}
	public void setCbryj(String cbryj) {
		this.cbryj = cbryj;
	}
	public String getCbr() {
		return cbr;
	}
	public void setCbr(String cbr) {
		this.cbr = cbr;
	}
	public String getCbrid() {
		return cbrid;
	}
	public void setCbrid(String cbrid) {
		this.cbrid = cbrid;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	
}
