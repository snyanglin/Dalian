package com.founder.gis.vo;
import java.io.Serializable;
import com.founder.framework.base.entity.BaseEntity;
/**
 * @类名: GisVo 
 * @描述: 地图应用【公共组件】VO 
 * @作者: zhang_guoliang@founder.com 
 * @日期: 2015-3-11 下午6:33:24 
 */
public class GisVo extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 6458346650098524239L;
	private String zrqdm;
	private String zrqmc;
	private String pcsdm;
	private String pcsmc;
	private String zbx;
	private String zby;
	private String tableName;
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getZrqdm() {
		return zrqdm;
	}
	public void setZrqdm(String zrqdm) {
		this.zrqdm = zrqdm;
	}
	public String getZrqmc() {
		return zrqmc;
	}
	public void setZrqmc(String zrqmc) {
		this.zrqmc = zrqmc;
	}
	public String getPcsdm() {
		return pcsdm;
	}
	public void setPcsdm(String pcsdm) {
		this.pcsdm = pcsdm;
	}
	public String getPcsmc() {
		return pcsmc;
	}
	public void setPcsmc(String pcsmc) {
		this.pcsmc = pcsmc;
	}
	public String getZbx() {
		return zbx;
	}
	public void setZbx(String zbx) {
		this.zbx = zbx;
	}
	public String getZby() {
		return zby;
	}
	public void setZby(String zby) {
		this.zby = zby;
	}
}