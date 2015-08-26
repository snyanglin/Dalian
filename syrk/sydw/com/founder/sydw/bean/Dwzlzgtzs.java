package com.founder.sydw.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;
/**
 * ****************************************************************************
 * @Package:      [com.founder.sydw.bean.Dwzlzgtzs.java]  
 * @ClassName:    [Dwzlzgtzs]   
 * @Description:  单位责令整改通知书
 * @Author:       [yu_guangli@founder.com.cn]  
 * @CreateDate:   [2015-6-24 下午1:28:12]   
 * @UpdateUser:   [yuguangli(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-24 下午1:28:12，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "DW_ZLZGTZS", pk = "id")
public class Dwzlzgtzs extends BaseEntity implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;
	@FieldDesc("主键")
	private String id;
	@FieldDesc("检查ID")
	private String jcid;
	@FieldDesc("单位ID")
	private String dwid;
	@FieldDesc("编号")
	private String bh;
	@FieldDesc("序号")
	private String xh;
	@FieldDesc("组织结构名称")
	private String zzjgmc;
	@FieldDesc("检查日期")
	private String jcrq;
	@FieldDesc("整改内容")
	private String zgnr;
	@FieldDesc("责令立即整改项")
	private String zlljzgx;
	@FieldDesc("责令立即整改项_小项")
	private String zlljzgx_xx;
	@FieldDesc("整改项")
	private String zgx;
	@FieldDesc("整改项_小项")
	private String zgx_xx;
	@FieldDesc("整改项整改日期")
	private String zgxzgrq;
	@FieldDesc("火灾隐患整改日期")
	private String hzyhzgrq;
	@FieldDesc("火灾隐患")
	private String hzyh;
	@FieldDesc("单位负责人签名")
	private String dwfzrqm;
	@FieldDesc("单位负责人签名日期")
	private String dwfzrqmrq;
	@FieldDesc("消防监督检查人员签名")
	private String jcryqm;
	@FieldDesc("消防监督检查人员签名日期")
	private String jcryqmrq;
	@FieldDesc("单位名称")
	private String dwmc;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getJcid() {
		return jcid;
	}
	public void setJcid(String jcid) {
		this.jcid = jcid;
	}
	public String getDwid() {
		return dwid;
	}
	public void setDwid(String dwid) {
		this.dwid = dwid;
	}
	public String getBh() {
		return bh;
	}
	public void setBh(String bh) {
		this.bh = bh;
	}
	public String getXh() {
		return xh;
	}
	public void setXh(String xh) {
		this.xh = xh;
	}
	public String getZzjgmc() {
		return zzjgmc;
	}
	public void setZzjgmc(String zzjgmc) {
		this.zzjgmc = zzjgmc;
	}
	public String getJcrq() {
		return jcrq;
	}
	public void setJcrq(String jcrq) {
		this.jcrq = jcrq;
	}
	public String getZgnr() {
		return zgnr;
	}
	public void setZgnr(String zgnr) {
		this.zgnr = zgnr;
	}
	public String getZlljzgx() {
		return zlljzgx;
	}
	public void setZlljzgx(String zlljzgx) {
		this.zlljzgx = zlljzgx;
	}
	public String getZgx() {
		return zgx;
	}
	public void setZgx(String zgx) {
		this.zgx = zgx;
	}
	public String getZgxzgrq() {
		return zgxzgrq;
	}
	public void setZgxzgrq(String zgxzgrq) {
		this.zgxzgrq = zgxzgrq;
	}
	public String getHzyhzgrq() {
		return hzyhzgrq;
	}
	public void setHzyhzgrq(String hzyhzgrq) {
		this.hzyhzgrq = hzyhzgrq;
	}
	public String getHzyh() {
		return hzyh;
	}
	public void setHzyh(String hzyh) {
		this.hzyh = hzyh;
	}
	public String getDwfzrqm() {
		return dwfzrqm;
	}
	public void setDwfzrqm(String dwfzrqm) {
		this.dwfzrqm = dwfzrqm;
	}
	public String getDwfzrqmrq() {
		return dwfzrqmrq;
	}
	public void setDwfzrqmrq(String dwfzrqmrq) {
		this.dwfzrqmrq = dwfzrqmrq;
	}
	public String getJcryqm() {
		return jcryqm;
	}
	public void setJcryqm(String jcryqm) {
		this.jcryqm = jcryqm;
	}
	public String getJcryqmrq() {
		return jcryqmrq;
	}
	public void setJcryqmrq(String jcryqmrq) {
		this.jcryqmrq = jcryqmrq;
	}
	public String getZlljzgx_xx() {
		return zlljzgx_xx;
	}
	public void setZlljzgx_xx(String zlljzgx_xx) {
		this.zlljzgx_xx = zlljzgx_xx;
	}
	public String getZgx_xx() {
		return zgx_xx;
	}
	public void setZgx_xx(String zgx_xx) {
		this.zgx_xx = zgx_xx;
	}
	public String getDwmc() {
		return dwmc;
	}
	public void setDwmc(String dwmc) {
		this.dwmc = dwmc;
	}
}
