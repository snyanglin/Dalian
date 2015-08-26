package com.founder.syfw.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

@DBInfoAnnotation(tableName = "SYFW_CZFWXXB", pk = "id")
public class Czfwxxb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@FieldDesc("出租房屋ID")
	private String id;
	@FieldDesc("房屋ID")
	private String fwid;
	@FieldDesc("治安责任人_姓名")
	private String zazrr_xm;
	@FieldDesc("治安责任人_ID")
	private String zazrr_id;
	@FieldDesc("责任书_签订_日期")
	private String zrs_qd_rq;
	@FieldDesc("出租_面积（平方米）")
	private Double cz_mjpfm;
	@FieldDesc("出租_房间数")
	private Long cz_fjs;
	@FieldDesc("出租_日期")
	private String cz_rq;
	@FieldDesc("租金(元/月)")
	private Double zj;
	@FieldDesc("备注")
	private String bz;
	@FieldDesc("出租人_人员ID")
	private String czur_ryid;
	@FieldDesc("出租人_姓名")
	private String czur_xm;
	@FieldDesc("出租人_证件种类")
	private String czur_cyzjdm;
	@FieldDesc("出租人_证件号码")
	private String czur_zjhm;
	@FieldDesc("出租人_外文姓")
	private String czur_wwx;
	@FieldDesc("出租人_外文名")
	private String czur_wwm;
	@FieldDesc("出租人_联系电话")
	private String czur_lxdh;
	@FieldDesc("出租人_与房主关系_人员关系代码")
	private String czur_yfzgx_rygxdm;
	@FieldDesc("房屋等级代码")
	private String fwdjdm;
	

	/**承租人数，根据承租人表统计*/
	private String czrs;
	
	public String getCzrs() {
		return czrs;
	}

	public void setCzrs(String czrs) {
		this.czrs = czrs;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFwid() {
		return fwid;
	}

	public void setFwid(String fwid) {
		this.fwid = fwid;
	}

	public String getZazrr_xm() {
		return zazrr_xm;
	}

	public void setZazrr_xm(String zazrr_xm) {
		this.zazrr_xm = zazrr_xm;
	}

	public String getZazrr_id() {
		return zazrr_id;
	}

	public void setZazrr_id(String zazrr_id) {
		this.zazrr_id = zazrr_id;
	}

	public String getZrs_qd_rq() {
		return zrs_qd_rq;
	}

	public void setZrs_qd_rq(String zrs_qd_rq) {
		this.zrs_qd_rq = zrs_qd_rq;
	}
    

	public Double getCz_mjpfm() {
		return cz_mjpfm;
	}

	public void setCz_mjpfm(Double cz_mjpfm) {
		this.cz_mjpfm = cz_mjpfm;
	}

	public Long getCz_fjs() {
		return cz_fjs;
	}

	public void setCz_fjs(Long cz_fjs) {
		this.cz_fjs = cz_fjs;
	}

	public String getCz_rq() {
		return cz_rq;
	}

	public void setCz_rq(String cz_rq) {
		this.cz_rq = cz_rq;
	}

	public Double getZj() {
		return zj;
	}

	public void setZj(Double zj) {
		this.zj = zj;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public String getCzur_ryid() {
		return czur_ryid;
	}

	public void setCzur_ryid(String czur_ryid) {
		this.czur_ryid = czur_ryid;
	}

	public String getCzur_xm() {
		return czur_xm;
	}

	public void setCzur_xm(String czur_xm) {
		this.czur_xm = czur_xm;
	}

	public String getCzur_cyzjdm() {
		return czur_cyzjdm;
	}

	public void setCzur_cyzjdm(String czur_cyzjdm) {
		this.czur_cyzjdm = czur_cyzjdm;
	}

	public String getCzur_zjhm() {
		return czur_zjhm;
	}

	public void setCzur_zjhm(String czur_zjhm) {
		this.czur_zjhm = czur_zjhm;
	}

	public String getCzur_wwx() {
		return czur_wwx;
	}

	public void setCzur_wwx(String czur_wwx) {
		this.czur_wwx = czur_wwx;
	}

	public String getCzur_wwm() {
		return czur_wwm;
	}

	public void setCzur_wwm(String czur_wwm) {
		this.czur_wwm = czur_wwm;
	}

	public String getCzur_lxdh() {
		return czur_lxdh;
	}

	public void setCzur_lxdh(String czur_lxdh) {
		this.czur_lxdh = czur_lxdh;
	}

	public String getCzur_yfzgx_rygxdm() {
		return czur_yfzgx_rygxdm;
	}

	public void setCzur_yfzgx_rygxdm(String czur_yfzgx_rygxdm) {
		this.czur_yfzgx_rygxdm = czur_yfzgx_rygxdm;
	}

	public String getFwdjdm() {
		return fwdjdm;
	}

	public void setFwdjdm(String fwdjdm) {
		this.fwdjdm = fwdjdm;
	}
	
}
