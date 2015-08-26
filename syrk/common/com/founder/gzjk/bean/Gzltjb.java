package com.founder.gzjk.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

@DBInfoAnnotation(tableName = "KHTJ_GZLTJB", pk = "id")
public class Gzltjb extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@FieldDesc("ID")
	private String id;
	@FieldDesc("人户一致新增数量")
	private Long rhyz_add;
	@FieldDesc("人户一致修改数量")
	private Long rhyz_update;
	@FieldDesc("人户一致注销数量")
	private Long rhyz_delete;
	@FieldDesc("人户分离新增数量")
	private Long rhfl_add;
	@FieldDesc("人户分离修改数量")
	private Long rhfl_update;
	@FieldDesc("人户分离注销数量")
	private Long rhfl_delete;
	@FieldDesc("寄住人口新增数量")
	private Long jzrk_add;
	@FieldDesc("寄住人口修改数量")
	private Long jzrk_update;
	@FieldDesc("寄住人口注销数量")
	private Long jzrk_delete;
	@FieldDesc("流动人口新增数量")
	private Long ldrk_add;
	@FieldDesc("流动人口修改数量")
	private Long ldrk_update;
	@FieldDesc("流动人口注销数量")
	private Long ldrk_delete;
	@FieldDesc("未落户人员新增数量")
	private Long wlhry_add;
	@FieldDesc("未落户人员修改数量")
	private Long wlhry_update;
	@FieldDesc("未落户人员注销数量")
	private Long wlhry_delete;
	@FieldDesc("境外人员新增数量")
	private Long jwry_add;
	@FieldDesc("境外人员修改数量")
	private Long jwry_update;
	@FieldDesc("境外人员注销数量")
	private Long jwry_delete;
	@FieldDesc("单位基本信息新增数量")
	private Long dw_add;
	@FieldDesc("单位基本信息修改数量")
	private Long dw_update;
	@FieldDesc("单位基本信息注销数量")
	private Long dw_delete;
	@FieldDesc("从业人员新增数量")
	private Long cyry_add;
	@FieldDesc("从业人员修改数量")
	private Long cyry_update;
	@FieldDesc("从业人员注销数量")
	private Long cyry_delete;
	@FieldDesc("出租房屋新增数量")
	private Long czfw_add;
	@FieldDesc("出租房屋修改数量")
	private Long czfw_update;
	@FieldDesc("出租房屋注销数量")
	private Long czfw_delete;
	@FieldDesc("承租人新增数量")
	private Long czr_add;
	@FieldDesc("承租人修改数量")
	private Long czr_update;
	@FieldDesc("承租人注销数量")
	private Long czr_delete;
	@FieldDesc("统计日期")
	private String tjrq;
	@FieldDesc("管辖分局代码")
	private String gxfjdm;
	@FieldDesc("管辖分局名称")
	private String gxfjname;
	@FieldDesc("管辖派出所代码")
	private String gxpcsdm;
	@FieldDesc("管辖派出所名称")
	private String gxpcsname;
	@FieldDesc("管辖责任区代码")
	private String gxzrqdm;
	@FieldDesc("管辖责任区名称")
	private String gxzrqname;
	@FieldDesc("备注")
	private String bz;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Long getRhyz_add() {
		return rhyz_add;
	}
	public void setRhyz_add(Long rhyz_add) {
		this.rhyz_add = rhyz_add;
	}
	public Long getRhyz_update() {
		return rhyz_update;
	}
	public void setRhyz_update(Long rhyz_update) {
		this.rhyz_update = rhyz_update;
	}
	public Long getRhyz_delete() {
		return rhyz_delete;
	}
	public void setRhyz_delete(Long rhyz_delete) {
		this.rhyz_delete = rhyz_delete;
	}
	public Long getRhfl_add() {
		return rhfl_add;
	}
	public void setRhfl_add(Long rhfl_add) {
		this.rhfl_add = rhfl_add;
	}
	public Long getRhfl_update() {
		return rhfl_update;
	}
	public void setRhfl_update(Long rhfl_update) {
		this.rhfl_update = rhfl_update;
	}
	public Long getRhfl_delete() {
		return rhfl_delete;
	}
	public void setRhfl_delete(Long rhfl_delete) {
		this.rhfl_delete = rhfl_delete;
	}
	public Long getJzrk_add() {
		return jzrk_add;
	}
	public void setJzrk_add(Long jzrk_add) {
		this.jzrk_add = jzrk_add;
	}
	public Long getJzrk_update() {
		return jzrk_update;
	}
	public void setJzrk_update(Long jzrk_update) {
		this.jzrk_update = jzrk_update;
	}
	public Long getJzrk_delete() {
		return jzrk_delete;
	}
	public void setJzrk_delete(Long jzrk_delete) {
		this.jzrk_delete = jzrk_delete;
	}
	public Long getLdrk_add() {
		return ldrk_add;
	}
	public void setLdrk_add(Long ldrk_add) {
		this.ldrk_add = ldrk_add;
	}
	public Long getLdrk_update() {
		return ldrk_update;
	}
	public void setLdrk_update(Long ldrk_update) {
		this.ldrk_update = ldrk_update;
	}
	public Long getLdrk_delete() {
		return ldrk_delete;
	}
	public void setLdrk_delete(Long ldrk_delete) {
		this.ldrk_delete = ldrk_delete;
	}
	public Long getWlhry_add() {
		return wlhry_add;
	}
	public void setWlhry_add(Long wlhry_add) {
		this.wlhry_add = wlhry_add;
	}
	public Long getWlhry_update() {
		return wlhry_update;
	}
	public void setWlhry_update(Long wlhry_update) {
		this.wlhry_update = wlhry_update;
	}
	public Long getWlhry_delete() {
		return wlhry_delete;
	}
	public void setWlhry_delete(Long wlhry_delete) {
		this.wlhry_delete = wlhry_delete;
	}
	public Long getJwry_add() {
		return jwry_add;
	}
	public void setJwry_add(Long jwry_add) {
		this.jwry_add = jwry_add;
	}
	public Long getJwry_update() {
		return jwry_update;
	}
	public void setJwry_update(Long jwry_update) {
		this.jwry_update = jwry_update;
	}
	public Long getJwry_delete() {
		return jwry_delete;
	}
	public void setJwry_delete(Long jwry_delete) {
		this.jwry_delete = jwry_delete;
	}
	public Long getDw_add() {
		return dw_add;
	}
	public void setDw_add(Long dw_add) {
		this.dw_add = dw_add;
	}
	public Long getDw_update() {
		return dw_update;
	}
	public void setDw_update(Long dw_update) {
		this.dw_update = dw_update;
	}
	public Long getDw_delete() {
		return dw_delete;
	}
	public void setDw_delete(Long dw_delete) {
		this.dw_delete = dw_delete;
	}
	public Long getCyry_add() {
		return cyry_add;
	}
	public void setCyry_add(Long cyry_add) {
		this.cyry_add = cyry_add;
	}
	public Long getCyry_update() {
		return cyry_update;
	}
	public void setCyry_update(Long cyry_update) {
		this.cyry_update = cyry_update;
	}
	public Long getCyry_delete() {
		return cyry_delete;
	}
	public void setCyry_delete(Long cyry_delete) {
		this.cyry_delete = cyry_delete;
	}
	public Long getCzfw_add() {
		return czfw_add;
	}
	public void setCzfw_add(Long czfw_add) {
		this.czfw_add = czfw_add;
	}
	public Long getCzfw_update() {
		return czfw_update;
	}
	public void setCzfw_update(Long czfw_update) {
		this.czfw_update = czfw_update;
	}
	public Long getCzfw_delete() {
		return czfw_delete;
	}
	public void setCzfw_delete(Long czfw_delete) {
		this.czfw_delete = czfw_delete;
	}

	public Long getCzr_add() {
		return czr_add;
	}
	public void setCzr_add(Long czr_add) {
		this.czr_add = czr_add;
	}
	public Long getCzr_update() {
		return czr_update;
	}
	public void setCzr_update(Long czr_update) {
		this.czr_update = czr_update;
	}
	public Long getCzr_delete() {
		return czr_delete;
	}
	public void setCzr_delete(Long czr_delete) {
		this.czr_delete = czr_delete;
	}
	public String getTjrq() {
		return tjrq;
	}
	public void setTjrq(String tjrq) {
		this.tjrq = tjrq;
	}
	public String getGxfjdm() {
		return gxfjdm;
	}
	public void setGxfjdm(String gxfjdm) {
		this.gxfjdm = gxfjdm;
	}
	public String getGxpcsdm() {
		return gxpcsdm;
	}
	public void setGxpcsdm(String gxpcsdm) {
		this.gxpcsdm = gxpcsdm;
	}
	public String getGxzrqdm() {
		return gxzrqdm;
	}
	public void setGxzrqdm(String gxzrqdm) {
		this.gxzrqdm = gxzrqdm;
	}
	
	public String getGxfjname() {
		return gxfjname;
	}
	public void setGxfjname(String gxfjname) {
		this.gxfjname = gxfjname;
	}
	public String getGxpcsname() {
		return gxpcsname;
	}
	public void setGxpcsname(String gxpcsname) {
		this.gxpcsname = gxpcsname;
	}
	public String getGxzrqname() {
		return gxzrqname;
	}
	public void setGxzrqname(String gxzrqname) {
		this.gxzrqname = gxzrqname;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}

	
}
