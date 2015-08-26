package com.founder.sydw.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

@DBInfoAnnotation(tableName = "DW_JDHXPZZB", pk = "id")
public class Jdhxpzzxxb extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@FieldDesc("ID")
	private String id;
	@FieldDesc("单位ID")
	private String dwid;
	@FieldDesc("采集时间")
	private String xt_cjsj;
	@FieldDesc("录入时间")
	private String xt_lrsj;
	@FieldDesc("录入人姓名")
	private String xt_lrrxm;
	@FieldDesc("录入人ID")
	private String xt_lrrid;
	@FieldDesc("录入人部门")
	private String xt_lrrbm;
	@FieldDesc("录入人部门ID")
	private String xt_lrrbmid;
	@FieldDesc("录入IP")
	private String xt_lrip;
	@FieldDesc("最后修改时间")
	private String xt_zhxgsj;
	@FieldDesc("最后修改人姓名")
	private String xt_zhxgrxm;
	@FieldDesc("最后修改人ID")
	private String xt_zhxgrid;
	@FieldDesc("最后修改人部门")
	private String xt_zhxgrbm;
	@FieldDesc("最后修改人部门ID")
	private String xt_zhxgrbmid;
	@FieldDesc("最后修改IP")
	private String xt_zhxgip;
	@FieldDesc("注销标志")
	private String xt_zxbz;
	@FieldDesc("注销原因")
	private String xt_zxyy;
	@FieldDesc("安全责任人")
	private String anquanzerenren;
	@FieldDesc("安全责任人电话")
	private String anquanzerenren_dhhm;
	@FieldDesc("拥有从业人员数，数值1~N")
	private String congyerenshu;
	@FieldDesc("库房安防等级（字典值：一级、二级、三级和不存放）")
	private String anfangdengji;
	@FieldDesc("上级机关（公安）名称")
	private String shangjijiguan;
	@FieldDesc("组织机构代码证")
	private String jgdmz;
	@FieldDesc("组织机构代码证有效期")
	private String jgdmz_yxq;
	@FieldDesc("安监颁发证件号")
	private String ajz;
	@FieldDesc("安监颁发证件有效期")
	private String ajz_yxq;
	@FieldDesc("环保资质号")
	private String hbzz;
	@FieldDesc("环保资质有效期")
	private String hbzz_yxq;
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
	public String getXt_cjsj() {
		return xt_cjsj;
	}
	public void setXt_cjsj(String xt_cjsj) {
		this.xt_cjsj = xt_cjsj;
	}
	public String getXt_lrsj() {
		return xt_lrsj;
	}
	public void setXt_lrsj(String xt_lrsj) {
		this.xt_lrsj = xt_lrsj;
	}
	public String getXt_lrrxm() {
		return xt_lrrxm;
	}
	public void setXt_lrrxm(String xt_lrrxm) {
		this.xt_lrrxm = xt_lrrxm;
	}
	public String getXt_lrrid() {
		return xt_lrrid;
	}
	public void setXt_lrrid(String xt_lrrid) {
		this.xt_lrrid = xt_lrrid;
	}
	public String getXt_lrrbm() {
		return xt_lrrbm;
	}
	public void setXt_lrrbm(String xt_lrrbm) {
		this.xt_lrrbm = xt_lrrbm;
	}
	public String getXt_lrrbmid() {
		return xt_lrrbmid;
	}
	public void setXt_lrrbmid(String xt_lrrbmid) {
		this.xt_lrrbmid = xt_lrrbmid;
	}
	public String getXt_lrip() {
		return xt_lrip;
	}
	public void setXt_lrip(String xt_lrip) {
		this.xt_lrip = xt_lrip;
	}
	public String getXt_zhxgsj() {
		return xt_zhxgsj;
	}
	public void setXt_zhxgsj(String xt_zhxgsj) {
		this.xt_zhxgsj = xt_zhxgsj;
	}
	public String getXt_zhxgrxm() {
		return xt_zhxgrxm;
	}
	public void setXt_zhxgrxm(String xt_zhxgrxm) {
		this.xt_zhxgrxm = xt_zhxgrxm;
	}
	public String getXt_zhxgrid() {
		return xt_zhxgrid;
	}
	public void setXt_zhxgrid(String xt_zhxgrid) {
		this.xt_zhxgrid = xt_zhxgrid;
	}
	public String getXt_zhxgrbm() {
		return xt_zhxgrbm;
	}
	public void setXt_zhxgrbm(String xt_zhxgrbm) {
		this.xt_zhxgrbm = xt_zhxgrbm;
	}
	public String getXt_zhxgrbmid() {
		return xt_zhxgrbmid;
	}
	public void setXt_zhxgrbmid(String xt_zhxgrbmid) {
		this.xt_zhxgrbmid = xt_zhxgrbmid;
	}
	public String getXt_zhxgip() {
		return xt_zhxgip;
	}
	public void setXt_zhxgip(String xt_zhxgip) {
		this.xt_zhxgip = xt_zhxgip;
	}
	public String getXt_zxbz() {
		return xt_zxbz;
	}
	public void setXt_zxbz(String xt_zxbz) {
		this.xt_zxbz = xt_zxbz;
	}
	public String getXt_zxyy() {
		return xt_zxyy;
	}
	public void setXt_zxyy(String xt_zxyy) {
		this.xt_zxyy = xt_zxyy;
	}
	public String getAnquanzerenren() {
		return anquanzerenren;
	}
	public void setAnquanzerenren(String anquanzerenren) {
		this.anquanzerenren = anquanzerenren;
	}
	public String getAnquanzerenren_dhhm() {
		return anquanzerenren_dhhm;
	}
	public void setAnquanzerenren_dhhm(String anquanzerenren_dhhm) {
		this.anquanzerenren_dhhm = anquanzerenren_dhhm;
	}
	public String getCongyerenshu() {
		return congyerenshu;
	}
	public void setCongyerenshu(String congyerenshu) {
		this.congyerenshu = congyerenshu;
	}
	public String getAnfangdengji() {
		return anfangdengji;
	}
	public void setAnfangdengji(String anfangdengji) {
		this.anfangdengji = anfangdengji;
	}
	public String getShangjijiguan() {
		return shangjijiguan;
	}
	public void setShangjijiguan(String shangjijiguan) {
		this.shangjijiguan = shangjijiguan;
	}
	public String getJgdmz() {
		return jgdmz;
	}
	public void setJgdmz(String jgdmz) {
		this.jgdmz = jgdmz;
	}
	public String getJgdmz_yxq() {
		return jgdmz_yxq;
	}
	public void setJgdmz_yxq(String jgdmz_yxq) {
		this.jgdmz_yxq = jgdmz_yxq;
	}
	public String getAjz() {
		return ajz;
	}
	public void setAjz(String ajz) {
		this.ajz = ajz;
	}
	public String getAjz_yxq() {
		return ajz_yxq;
	}
	public void setAjz_yxq(String ajz_yxq) {
		this.ajz_yxq = ajz_yxq;
	}
	public String getHbzz() {
		return hbzz;
	}
	public void setHbzz(String hbzz) {
		this.hbzz = hbzz;
	}
	public String getHbzz_yxq() {
		return hbzz_yxq;
	}
	public void setHbzz_yxq(String hbzz_yxq) {
		this.hbzz_yxq = hbzz_yxq;
	}
}
