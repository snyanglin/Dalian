package com.founder.zdrygl.bean;

import java.io.Serializable;
import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

@DBInfoAnnotation(tableName = "ZDRY_JKBJLLXXB", pk = "id")
public class ZdryJkbjllxxb extends BaseEntity implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;
	@FieldDesc("监控帮教力量ID")
	private String id;
	@FieldDesc("重点人员ID")
	private String zdryid;
	@FieldDesc("监控帮教人员_公民身份号码")
	private String jkbjry_gmsfhm;
	@FieldDesc("监控帮教人员_姓名")
	private String jkbjry_xm;
	@FieldDesc("监控帮教人员_性别代码")
	private String jkbjry_xbdm;
	@FieldDesc("监控帮教人员_民族代码")
	private String jkbjry_mzdm;
	@FieldDesc("地址-监控帮教人员-现居住地址省市县代码")
	private String dz_jkbjry_xjzdzssxdm;
	@FieldDesc("地址-监控帮教人员-现居住地门楼牌代码")
	private String dz_jkbjry_xjzdmlpdm;
	@FieldDesc("地址-监控帮教人员-现居住地门楼牌详址")
	private String dz_jkbjry_xjzdmlpxz;
	@FieldDesc("地址-监控帮教人员-现居住地址代码")
	private String dz_jkbjry_xjzdzdm;
	@FieldDesc("地址-监控帮教人员-现居住地址详址")
	private String dz_jkbjry_xjzdzxz;
	@FieldDesc("监控帮教人员_联系电话")
	private String jkbjry_lxdh;
	@FieldDesc("监控帮教人员_政治面貌代码")
	private String jkbjry_zzmmdm;
	@FieldDesc("监控帮教人员工_作单位ID")
	private String jkbjry_gzdwid;
	@FieldDesc("监控帮教人员_工作单位名称")
	private String jkbjry_gzdwmc;
	@FieldDesc("监控帮教人员_职务名称")
	private String jkbjry_zwmc;
	@FieldDesc("监控帮教人员_与被帮教人_人员关系")
	private String jkbjry_ybbjr_rygx;
	@FieldDesc("监控帮教类型代码")
	private String jkbjlxdm;
	@FieldDesc("备注")
	private String bz;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getZdryid() {
		return zdryid;
	}

	public void setZdryid(String zdryid) {
		this.zdryid = zdryid;
	}

	public String getJkbjry_gmsfhm() {
		return jkbjry_gmsfhm;
	}

	public void setJkbjry_gmsfhm(String jkbjry_gmsfhm) {
		this.jkbjry_gmsfhm = jkbjry_gmsfhm;
	}

	public String getJkbjry_xm() {
		return jkbjry_xm;
	}

	public void setJkbjry_xm(String jkbjry_xm) {
		this.jkbjry_xm = jkbjry_xm;
	}

	public String getJkbjry_xbdm() {
		return jkbjry_xbdm;
	}

	public void setJkbjry_xbdm(String jkbjry_xbdm) {
		this.jkbjry_xbdm = jkbjry_xbdm;
	}

	public String getJkbjry_mzdm() {
		return jkbjry_mzdm;
	}

	public void setJkbjry_mzdm(String jkbjry_mzdm) {
		this.jkbjry_mzdm = jkbjry_mzdm;
	}

	public String getDz_jkbjry_xjzdzssxdm() {
		return dz_jkbjry_xjzdzssxdm;
	}

	public void setDz_jkbjry_xjzdzssxdm(String dz_jkbjry_xjzdzssxdm) {
		this.dz_jkbjry_xjzdzssxdm = dz_jkbjry_xjzdzssxdm;
	}

	public String getDz_jkbjry_xjzdmlpdm() {
		return dz_jkbjry_xjzdmlpdm;
	}

	public void setDz_jkbjry_xjzdmlpdm(String dz_jkbjry_xjzdmlpdm) {
		this.dz_jkbjry_xjzdmlpdm = dz_jkbjry_xjzdmlpdm;
	}

	public String getDz_jkbjry_xjzdmlpxz() {
		return dz_jkbjry_xjzdmlpxz;
	}

	public void setDz_jkbjry_xjzdmlpxz(String dz_jkbjry_xjzdmlpxz) {
		this.dz_jkbjry_xjzdmlpxz = dz_jkbjry_xjzdmlpxz;
	}

	public String getDz_jkbjry_xjzdzdm() {
		return dz_jkbjry_xjzdzdm;
	}

	public void setDz_jkbjry_xjzdzdm(String dz_jkbjry_xjzdzdm) {
		this.dz_jkbjry_xjzdzdm = dz_jkbjry_xjzdzdm;
	}

	public String getDz_jkbjry_xjzdzxz() {
		return dz_jkbjry_xjzdzxz;
	}

	public void setDz_jkbjry_xjzdzxz(String dz_jkbjry_xjzdzxz) {
		this.dz_jkbjry_xjzdzxz = dz_jkbjry_xjzdzxz;
	}

	public String getJkbjry_lxdh() {
		return jkbjry_lxdh;
	}

	public void setJkbjry_lxdh(String jkbjry_lxdh) {
		this.jkbjry_lxdh = jkbjry_lxdh;
	}

	public String getJkbjry_zzmmdm() {
		return jkbjry_zzmmdm;
	}

	public void setJkbjry_zzmmdm(String jkbjry_zzmmdm) {
		this.jkbjry_zzmmdm = jkbjry_zzmmdm;
	}

	public String getJkbjry_gzdwid() {
		return jkbjry_gzdwid;
	}

	public void setJkbjry_gzdwid(String jkbjry_gzdwid) {
		this.jkbjry_gzdwid = jkbjry_gzdwid;
	}

	public String getJkbjry_gzdwmc() {
		return jkbjry_gzdwmc;
	}

	public void setJkbjry_gzdwmc(String jkbjry_gzdwmc) {
		this.jkbjry_gzdwmc = jkbjry_gzdwmc;
	}

	public String getJkbjry_zwmc() {
		return jkbjry_zwmc;
	}

	public void setJkbjry_zwmc(String jkbjry_zwmc) {
		this.jkbjry_zwmc = jkbjry_zwmc;
	}

	public String getJkbjry_ybbjr_rygx() {
		return jkbjry_ybbjr_rygx;
	}

	public void setJkbjry_ybbjr_rygx(String jkbjry_ybbjr_rygx) {
		this.jkbjry_ybbjr_rygx = jkbjry_ybbjr_rygx;
	}

	public String getJkbjlxdm() {
		return jkbjlxdm;
	}

	public void setJkbjlxdm(String jkbjlxdm) {
		this.jkbjlxdm = jkbjlxdm;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

}
