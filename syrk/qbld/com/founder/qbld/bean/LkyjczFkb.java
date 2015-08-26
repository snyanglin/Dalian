package com.founder.qbld.bean;

import java.io.Serializable;
import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.bean.Lkyjczfkb.java]  
 * @ClassName:    [Lkyjczfkb]   
 * @Description:  [临控处置反馈表]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-4-24 上午10:23:35]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-24 上午10:23:35，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "QBLD_LK_YJCZFKB", pk = "lkzllx")
public class LkyjczFkb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@FieldDesc("情报联动唯一编号")
	private String ldxxbh;
	@FieldDesc("采用GA XXX.2中的重点人员临控指令类型代码")
	private String lkzllx;
	@FieldDesc("所签收反馈的重点人员临控指令编号，采用GA XXX.2中的重点人员临控指令编号编码方法")
	private String lkzlbh;
	@FieldDesc("反馈时间,采用格式YYYYMMDDhhmmss，24小时格式")
	private String fksj;
	@FieldDesc("反馈人身份证号,采用GA/Z 02 D1000")
	private String fkrsfzh;
	@FieldDesc("反馈人姓名")
	private String fkrxm;
	@FieldDesc("馈单位,采用GA/Z 02 D3006")
	private String fkdw;
	@FieldDesc("反馈单位机构代码,采用GA/Z 02 D3000")
	private String fkdwjgdm;
	@FieldDesc("采用GA XXX.2中的重点人员目标发现状态代码")
	private String mbfxzt;
	@FieldDesc("发现目标活动信息所属的信息分类，采用GA XXX.2中的动态实名信息类别代码")
	private String fxmbhdlb;
	@FieldDesc("活动发现时间,采用格式YYYYMMDDhhmmss，24小时格式")
	private String hdfxsj;
	@FieldDesc("活动发现地点区划,采用GA/Z 02 D4001")
	private String hdfxddqh;
	@FieldDesc("活动发现地点详址")
	private String hdfxddxz;
	@FieldDesc("活动发现地点所属社会场所")
	private String hdfxddssshcs;
	@FieldDesc("活动发现地点所属社会场所代码")
	private String hdfxddssshcsdm;
	@FieldDesc("活动相关信息")
	private String fxhdxgxx;
	@FieldDesc("发现目标责任民警身份证号,采用GA/Z 02 D1000")
	private String fxmbzrmjsfzh;
	@FieldDesc("发现目标责任民警姓名")
	private String fxmbzrmjxm;
	@FieldDesc("发现目标责任单位,采用GA/Z 02 D3006")
	private String fxmbzrdw;
	@FieldDesc("发现目标责任单位机构代码,采用GA/Z 02 D3000")
	private String fxmbzrdwjgdm;
	@FieldDesc("采取处置措施")
	private String cqczcs;
	@FieldDesc("处置时间用格式YYYYMMDDhhmmss，24小时格式")
	private String czsj;
	@FieldDesc("所在的行政区划，采用GA/Z 02 D4001")
	private String czddqh;
	@FieldDesc("处置地点详址")
	private String czddxz;
	@FieldDesc("处置责任民警身份证号,采用GA/Z 02 D1000")
	private String czzrmjsfzh;
	@FieldDesc("处置责任民警姓名")
	private String czzrmjxm;
	@FieldDesc("处置责任单位采用GA/Z 02 D3006")
	private String czzrdw;
	@FieldDesc("处置责任单位机构代码,采用GA/Z 02 D3000")
	private String czzrdwjgdm;
	@FieldDesc("处置经过描述")
	private String czjgms;
	@FieldDesc("采用GA XXX.2中的重点人员预警处置结果类型代码")
	private String czjg;
	@FieldDesc("处置反馈信息编号")
	private String czfkxxbh;
	@FieldDesc("处置措施细类 采用GA XXX.2中的“重点人员处置措施细类代码”")
	private String czcsxl;
	@FieldDesc("接口发送状态， ‘0’发送成功；‘1’发送失败")
	private String fszt;
	@FieldDesc("接口调用状态码")
	private String code;
	
	public String getFszt() {
		return fszt;
	}
	public void setFszt(String fszt) {
		this.fszt = fszt;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCzcsxl() {
		return czcsxl;
	}
	public void setCzcsxl(String czcsxl) {
		this.czcsxl = czcsxl;
	}
	public String getCzfkxxbh() {
		return czfkxxbh;
	}
	public void setCzfkxxbh(String czfkxxbh) {
		this.czfkxxbh = czfkxxbh;
	}
	public String getLdxxbh() {
		return ldxxbh;
	}
	public void setLdxxbh(String ldxxbh) {
		this.ldxxbh = ldxxbh;
	}
	public String getLkzllx() {
		return lkzllx;
	}
	public void setLkzllx(String lkzllx) {
		this.lkzllx = lkzllx;
	}
	public String getLkzlbh() {
		return lkzlbh;
	}
	public void setLkzlbh(String lkzlbh) {
		this.lkzlbh = lkzlbh;
	}
	public String getFksj() {
		return fksj;
	}
	public void setFksj(String fksj) {
		this.fksj = fksj;
	}
	public String getFkrsfzh() {
		return fkrsfzh;
	}
	public void setFkrsfzh(String fkrsfzh) {
		this.fkrsfzh = fkrsfzh;
	}
	public String getFkrxm() {
		return fkrxm;
	}
	public void setFkrxm(String fkrxm) {
		this.fkrxm = fkrxm;
	}
	public String getFkdw() {
		return fkdw;
	}
	public void setFkdw(String fkdw) {
		this.fkdw = fkdw;
	}
	public String getFkdwjgdm() {
		return fkdwjgdm;
	}
	public void setFkdwjgdm(String fkdwjgdm) {
		this.fkdwjgdm = fkdwjgdm;
	}
	public String getMbfxzt() {
		return mbfxzt;
	}
	public void setMbfxzt(String mbfxzt) {
		this.mbfxzt = mbfxzt;
	}
	public String getFxmbhdlb() {
		return fxmbhdlb;
	}
	public void setFxmbhdlb(String fxmbhdlb) {
		this.fxmbhdlb = fxmbhdlb;
	}
	public String getHdfxsj() {
		return hdfxsj;
	}
	public void setHdfxsj(String hdfxsj) {
		this.hdfxsj = hdfxsj;
	}
	public String getHdfxddqh() {
		return hdfxddqh;
	}
	public void setHdfxddqh(String hdfxddqh) {
		this.hdfxddqh = hdfxddqh;
	}
	public String getHdfxddxz() {
		return hdfxddxz;
	}
	public void setHdfxddxz(String hdfxddxz) {
		this.hdfxddxz = hdfxddxz;
	}
	public String getHdfxddssshcs() {
		return hdfxddssshcs;
	}
	public void setHdfxddssshcs(String hdfxddssshcs) {
		this.hdfxddssshcs = hdfxddssshcs;
	}
	public String getHdfxddssshcsdm() {
		return hdfxddssshcsdm;
	}
	public void setHdfxddssshcsdm(String hdfxddssshcsdm) {
		this.hdfxddssshcsdm = hdfxddssshcsdm;
	}
	public String getFxhdxgxx() {
		return fxhdxgxx;
	}
	public void setFxhdxgxx(String fxhdxgxx) {
		this.fxhdxgxx = fxhdxgxx;
	}
	public String getFxmbzrmjsfzh() {
		return fxmbzrmjsfzh;
	}
	public void setFxmbzrmjsfzh(String fxmbzrmjsfzh) {
		this.fxmbzrmjsfzh = fxmbzrmjsfzh;
	}
	public String getFxmbzrmjxm() {
		return fxmbzrmjxm;
	}
	public void setFxmbzrmjxm(String fxmbzrmjxm) {
		this.fxmbzrmjxm = fxmbzrmjxm;
	}
	public String getFxmbzrdw() {
		return fxmbzrdw;
	}
	public void setFxmbzrdw(String fxmbzrdw) {
		this.fxmbzrdw = fxmbzrdw;
	}
	public String getFxmbzrdwjgdm() {
		return fxmbzrdwjgdm;
	}
	public void setFxmbzrdwjgdm(String fxmbzrdwjgdm) {
		this.fxmbzrdwjgdm = fxmbzrdwjgdm;
	}
	public String getCqczcs() {
		return cqczcs;
	}
	public void setCqczcs(String cqczcs) {
		this.cqczcs = cqczcs;
	}
	public String getCzsj() {
		return czsj;
	}
	public void setCzsj(String czsj) {
		this.czsj = czsj;
	}
	public String getCzddqh() {
		return czddqh;
	}
	public void setCzddqh(String czddqh) {
		this.czddqh = czddqh;
	}
	public String getCzddxz() {
		return czddxz;
	}
	public void setCzddxz(String czddxz) {
		this.czddxz = czddxz;
	}
	public String getCzzrmjsfzh() {
		return czzrmjsfzh;
	}
	public void setCzzrmjsfzh(String czzrmjsfzh) {
		this.czzrmjsfzh = czzrmjsfzh;
	}
	public String getCzzrmjxm() {
		return czzrmjxm;
	}
	public void setCzzrmjxm(String czzrmjxm) {
		this.czzrmjxm = czzrmjxm;
	}
	public String getCzzrdw() {
		return czzrdw;
	}
	public void setCzzrdw(String czzrdw) {
		this.czzrdw = czzrdw;
	}
	public String getCzzrdwjgdm() {
		return czzrdwjgdm;
	}
	public void setCzzrdwjgdm(String czzrdwjgdm) {
		this.czzrdwjgdm = czzrdwjgdm;
	}
	public String getCzjgms() {
		return czjgms;
	}
	public void setCzjgms(String czjgms) {
		this.czjgms = czjgms;
	}
	public String getCzjg() {
		return czjg;
	}
	public void setCzjg(String czjg) {
		this.czjg = czjg;
	}

}
