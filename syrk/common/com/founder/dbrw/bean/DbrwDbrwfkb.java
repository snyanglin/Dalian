package com.founder.dbrw.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

@DBInfoAnnotation(tableName = "DBRW_DBRWFKB", pk = "id")
public class DbrwDbrwfkb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@FieldDesc("督办任务反馈ID")private String id;
	@FieldDesc("督办任务ID")private String dbrwid;
	@FieldDesc("反馈部门代码")private String fkbmdm;
	@FieldDesc("反馈部门名称")private String fkbmmc;
	@FieldDesc("督办反馈内容")private String dbfknr;
	@FieldDesc("任务总数量")private Long rwzsl;
	@FieldDesc("完成任务总数量")private Long wcrwzsl;
	@FieldDesc("自动核实数量")private Long zdhssl;
	@FieldDesc("手动核实数量")private Long sdhssl;
	@FieldDesc("新增业务数据量")private Long xzywsjl;
	@FieldDesc("注销业务数据量")private Long zxywsjl;
	@FieldDesc("反馈时间")private String fksj;
	@FieldDesc("备注")private String bz;
	@FieldDesc("采集时间")private String xt_cjsj;
	@FieldDesc("录入时间")private String xt_lrsj;
	@FieldDesc("录入人姓名")private String xt_lrrxm;
	@FieldDesc("录入人ID")private String xt_lrrid;
	@FieldDesc("录入人部门")private String xt_lrrbm;
	@FieldDesc("录入人部门ID")private String xt_lrrbmid;
	@FieldDesc("录入IP")private String xt_lrip;
	@FieldDesc("最后修改时间")private String xt_zhxgsj;
	@FieldDesc("最后修改人姓名")private String xt_zhxgrxm;
	@FieldDesc("最后修改人ID")private String xt_zhxgrid;
	@FieldDesc("最后修改人部门")private String xt_zhxgrbm;
	@FieldDesc("最后修改人部门ID")private String xt_zhxgrbmid;
	@FieldDesc("最后修改IP")private String xt_zhxgip;
	@FieldDesc("注销标志")private String xt_zxbz;
	@FieldDesc("注销原因")private String xt_zxyy;
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDbrwid() {
		return dbrwid;
	}
	public void setDbrwid(String dbrwid) {
		this.dbrwid = dbrwid;
	}
	public String getFkbmdm() {
		return fkbmdm;
	}
	public void setFkbmdm(String fkbmdm) {
		this.fkbmdm = fkbmdm;
	}
	public String getFkbmmc() {
		return fkbmmc;
	}
	public void setFkbmmc(String fkbmmc) {
		this.fkbmmc = fkbmmc;
	}
	public String getDbfknr() {
		return dbfknr;
	}
	public void setDbfknr(String dbfknr) {
		this.dbfknr = dbfknr;
	}
	public Long getRwzsl() {
		return rwzsl;
	}
	public void setRwzsl(Long rwzsl) {
		this.rwzsl = rwzsl;
	}
	public Long getWcrwzsl() {
		return wcrwzsl;
	}
	public void setWcrwzsl(Long wcrwzsl) {
		this.wcrwzsl = wcrwzsl;
	}
	public Long getZdhssl() {
		return zdhssl;
	}
	public void setZdhssl(Long zdhssl) {
		this.zdhssl = zdhssl;
	}
	public Long getSdhssl() {
		return sdhssl;
	}
	public void setSdhssl(Long sdhssl) {
		this.sdhssl = sdhssl;
	}
	public Long getXzywsjl() {
		return xzywsjl;
	}
	public void setXzywsjl(Long xzywsjl) {
		this.xzywsjl = xzywsjl;
	}
	public Long getZxywsjl() {
		return zxywsjl;
	}
	public void setZxywsjl(Long zxywsjl) {
		this.zxywsjl = zxywsjl;
	}
	public String getFksj() {
		return fksj;
	}
	public void setFksj(String fksj) {
		this.fksj = fksj;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
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
}
