package com.founder.zdrygl.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

@DBInfoAnnotation(tableName = "ZDRY_SGAFZDRYXXB", pk = "id")
public class ZdrySgafzdryxxb extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@FieldDesc("主键")
	private String id;
	@FieldDesc("批次")
	private String pc;
	@FieldDesc("姓名")
	private String xm;
	@FieldDesc("性别代码")
	private String xbdm;
	@FieldDesc("公民身份号码")
	private String gmsfhm;
	@FieldDesc("是否公安内部访代码")
	private String sfganbfdm;
	@FieldDesc("户籍地-行政区划代码")
	private String hjd_xzqhdm;
	@FieldDesc("户籍地-门楼牌代码")
	private String hjd_mlpdm;
	@FieldDesc("户籍地-门楼牌详址")
	private String hjd_mlpxz;
	@FieldDesc("户籍地-地址ID")
	private String hjd_dzid;
	@FieldDesc("户籍地-地址详址")
	private String hjd_dzxz;
	@FieldDesc("居住地-行政区划代码")
	private String jzd_xzqhdm;
	@FieldDesc("居住地-门楼牌代码")
	private String jzd_mlpdm;
	@FieldDesc("居住地-门楼牌详址")
	private String jzd_mlpxz;
	@FieldDesc("居住地-地址ID")
	private String jzd_dzid;
	@FieldDesc("居住地-地址详址")
	private String jzd_dzxz;
	@FieldDesc("居住地-坐标X")
	private String jzd_zbx;
	@FieldDesc("居住地-坐标Y")
	private String jzd_zby;
	@FieldDesc("信访诉求及滋事情况")
	private String xfsqjzsqk;
	@FieldDesc("所属市局")
	private String sssj;
	@FieldDesc("市局责任领导")
	private String sjzrld;
	@FieldDesc("市局责任单位")
	private String sjzrdw;
	@FieldDesc("市局责任单位领导")
	private String sjzrdwld;
	@FieldDesc("所属分局")
	private String ssfj;
	@FieldDesc("分局责任领导")
	private String fjzrld;
	@FieldDesc("分局责任单位")
	private String fjzrdw;
	@FieldDesc("分局责任单位领导")
	private String fjzrdwld;
	@FieldDesc("所属派出所")
	private String sspcs;
	@FieldDesc("派出所责任领导")
	private String pcszrld;
	@FieldDesc("所属责任区")
	private String sszrq;
	@FieldDesc("责任区民警")
	private String zrqmj;
	@FieldDesc("民警联系电话")
	private String mjlxdh;
	@FieldDesc("是否协控")
	private String sfxk;
	@FieldDesc("申请协控单位")
	private String sqxkdw;
	@FieldDesc("申请协控单位名称")
	private String sqxkdwmc;
	@FieldDesc("案件管辖单位")
	private String ajgxdw;
	@FieldDesc("管辖单位联系人")
	private String gxdwlxr;
	@FieldDesc("管辖单位联系电话")
	private String gxdwlxdh;
	
	//模糊查询的条件
	private String condition;
	//状态查询条件
	private String searchStatus;
	//为了配置编辑页面展示类型名称
	private String zdrygllxmc;
	//添加小类名字
	private String zdrygllbmc;
	
	public String getZdrygllxmc() {
		return zdrygllxmc;
	}
	public void setZdrygllxmc(String zdrygllxmc) {
		this.zdrygllxmc = zdrygllxmc;
	}
	
	public String getZdrygllbmc() {
		return zdrygllbmc;
	}
	public void setZdrygllbmc(String zdrygllbmc) {
		this.zdrygllbmc = zdrygllbmc;
	}
	public String getSearchStatus() {
		return searchStatus;
	}
	public void setSearchStatus(String searchStatus) {
		this.searchStatus = searchStatus;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPc() {
		return pc;
	}
	public void setPc(String pc) {
		this.pc = pc;
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
	public String getGmsfhm() {
		return gmsfhm;
	}
	public void setGmsfhm(String gmsfhm) {
		this.gmsfhm = gmsfhm;
	}
	public String getSfganbfdm() {
		return sfganbfdm;
	}
	public void setSfganbfdm(String sfganbfdm) {
		this.sfganbfdm = sfganbfdm;
	}
	public String getHjd_xzqhdm() {
		return hjd_xzqhdm;
	}
	public void setHjd_xzqhdm(String hjd_xzqhdm) {
		this.hjd_xzqhdm = hjd_xzqhdm;
	}
	public String getHjd_mlpdm() {
		return hjd_mlpdm;
	}
	public void setHjd_mlpdm(String hjd_mlpdm) {
		this.hjd_mlpdm = hjd_mlpdm;
	}
	public String getHjd_mlpxz() {
		return hjd_mlpxz;
	}
	public void setHjd_mlpxz(String hjd_mlpxz) {
		this.hjd_mlpxz = hjd_mlpxz;
	}
	public String getHjd_dzid() {
		return hjd_dzid;
	}
	public void setHjd_dzid(String hjd_dzid) {
		this.hjd_dzid = hjd_dzid;
	}
	public String getHjd_dzxz() {
		return hjd_dzxz;
	}
	public void setHjd_dzxz(String hjd_dzxz) {
		this.hjd_dzxz = hjd_dzxz;
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
	public String getJzd_zbx() {
		return jzd_zbx;
	}
	public void setJzd_zbx(String jzd_zbx) {
		this.jzd_zbx = jzd_zbx;
	}
	public String getJzd_zby() {
		return jzd_zby;
	}
	public void setJzd_zby(String jzd_zby) {
		this.jzd_zby = jzd_zby;
	}
	public String getXfsqjzsqk() {
		return xfsqjzsqk;
	}
	public void setXfsqjzsqk(String xfsqjzsqk) {
		this.xfsqjzsqk = xfsqjzsqk;
	}
	public String getSssj() {
		return sssj;
	}
	public void setSssj(String sssj) {
		this.sssj = sssj;
	}
	public String getSjzrld() {
		return sjzrld;
	}
	public void setSjzrld(String sjzrld) {
		this.sjzrld = sjzrld;
	}
	public String getSjzrdw() {
		return sjzrdw;
	}
	public void setSjzrdw(String sjzrdw) {
		this.sjzrdw = sjzrdw;
	}
	public String getSjzrdwld() {
		return sjzrdwld;
	}
	public void setSjzrdwld(String sjzrdwld) {
		this.sjzrdwld = sjzrdwld;
	}
	public String getSsfj() {
		return ssfj;
	}
	public void setSsfj(String ssfj) {
		this.ssfj = ssfj;
	}
	public String getFjzrld() {
		return fjzrld;
	}
	public void setFjzrld(String fjzrld) {
		this.fjzrld = fjzrld;
	}
	public String getFjzrdw() {
		return fjzrdw;
	}
	public void setFjzrdw(String fjzrdw) {
		this.fjzrdw = fjzrdw;
	}
	public String getFjzrdwld() {
		return fjzrdwld;
	}
	public void setFjzrdwld(String fjzrdwld) {
		this.fjzrdwld = fjzrdwld;
	}
	public String getSspcs() {
		return sspcs;
	}
	public void setSspcs(String sspcs) {
		this.sspcs = sspcs;
	}
	public String getPcszrld() {
		return pcszrld;
	}
	public void setPcszrld(String pcszrld) {
		this.pcszrld = pcszrld;
	}
	public String getSszrq() {
		return sszrq;
	}
	public void setSszrq(String sszrq) {
		this.sszrq = sszrq;
	}
	public String getZrqmj() {
		return zrqmj;
	}
	public void setZrqmj(String zrqmj) {
		this.zrqmj = zrqmj;
	}
	public String getMjlxdh() {
		return mjlxdh;
	}
	public void setMjlxdh(String mjlxdh) {
		this.mjlxdh = mjlxdh;
	}
	public String getSfxk() {
		return sfxk;
	}
	public void setSfxk(String sfxk) {
		this.sfxk = sfxk;
	}
	public String getSqxkdw() {
		return sqxkdw;
	}
	public void setSqxkdw(String sqxkdw) {
		this.sqxkdw = sqxkdw;
	}	
	public String getSqxkdwmc() {
		return sqxkdwmc;
	}
	public void setSqxkdwmc(String sqxkdwmc) {
		this.sqxkdwmc = sqxkdwmc;
	}
	public String getAjgxdw() {
		return ajgxdw;
	}
	public void setAjgxdw(String ajgxdw) {
		this.ajgxdw = ajgxdw;
	}
	public String getGxdwlxr() {
		return gxdwlxr;
	}
	public void setGxdwlxr(String gxdwlxr) {
		this.gxdwlxr = gxdwlxr;
	}
	public String getGxdwlxdh() {
		return gxdwlxdh;
	}
	public void setGxdwlxdh(String gxdwlxdh) {
		this.gxdwlxdh = gxdwlxdh;
	}

}
