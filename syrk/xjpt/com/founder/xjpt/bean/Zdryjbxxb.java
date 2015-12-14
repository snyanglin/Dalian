package com.founder.xjpt.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/***
 * ****************************************************************************
 * 
 * @Package: [com.founder.xjpt.bean.Zdryjbxxb.java]
 * @ClassName: [Zdryjbxxb]
 * @Description: [重构后重点人员基本信息]
 * @Author: [wu_chunhui@founder.com.cn]
 * @CreateDate: [2015-1-21 上午10:48:11]
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-1-24 上午10:48:11，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [修改重点人员表结构]
 * @Version: [v1.0]
 */
@DBInfoAnnotation(tableName = "RK_ZDRYJBXXBS", pk = "id")
public class Zdryjbxxb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@FieldDesc("重点人员ID")
	private String id;
	@FieldDesc("实有人口ID")
	private String syrkid;
	@FieldDesc("公民身份号码")
	private String gmsfhm;
	@FieldDesc("姓名")
	private String xm;
	@FieldDesc("性别代码")
	private String xbdm;
	@FieldDesc("民族代码")
	private String mzdm;
	@FieldDesc("出生日期")
	private String csrq;
	@FieldDesc("地址-户籍地址省市县代码")
	private String dz_hjdzssxdm;
	@FieldDesc("地址-户籍地址门楼牌代码")
	private String dz_hjdzmlpdm;
	@FieldDesc("地址-户籍地址门楼牌详址")
	private String dz_hjdzmlpxz;
	@FieldDesc("地址-户籍地址代码")
	private String dz_hjdzdm;
	@FieldDesc("地址-户籍地址详址")
	private String dz_hjdzxz;
	@FieldDesc("地址-居住地址省市县代码")
	private String dz_jzdzssxdm;
	@FieldDesc("地址-居住地址门楼牌代码")
	private String dz_jzdzmlpdm;
	@FieldDesc("地址-居住地址门楼牌详址")
	private String dz_jzdzmlpxz;
	@FieldDesc("地址-居住地址代码")
	private String dz_jzdzdm;
	@FieldDesc("地址-居住地址详址")
	private String dz_jzdzxz;
	@FieldDesc("涉案人员专长代码")
	private String saryzcdm;
	@FieldDesc("汉语口音代码")
	private String hykydm;
	@FieldDesc("本人笔迹采集代码")
	private String brbjcjdm;
	@FieldDesc("指纹采集代码")
	private String zwcjdm;
	@FieldDesc("经常活动地区")
	private String jchddq;
	@FieldDesc("信息采集依据代码")
	private String xxcjyjdm;
	@FieldDesc("主要问题及现实表现")
	private String zywtjxsbx;
	@FieldDesc("档案编号")
	private String dabh;
	@FieldDesc("所属派出所")
	private String sspcs;
	// 地图查询使用字段
	private String zbz;
	// 空间查询缓冲区半径
	private String mapRadius;
	// 查询需要的参数,在实际数据库中没有
	private String condition;
	private String type;
	private String gxpcsdm;
	private String gxzrqdm;
	private String gxfxjdm;
	private String syrkgllbdm;
	private String zdrylxdm;
	private String zbx;
	private String zby;
	private String zdrylbdm;
	private String jzdzdm;
	private String ryid;
	

	
	
	

	/**
	 * @return the sspcs
	 */
	public String getSspcs() {
		return sspcs;
	}

	/**
	 * @param sspcs the sspcs to set
	 */
	public void setSspcs(String sspcs) {
		this.sspcs = sspcs;
	}

	/**
	 * @return the ryid
	 */
	public String getRyid() {
		return ryid;
	}

	/**
	 * @param ryid the ryid to set
	 */
	public void setRyid(String ryid) {
		this.ryid = ryid;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the syrkid
	 */
	public String getSyrkid() {
		return syrkid;
	}

	/**
	 * @param syrkid
	 *            the syrkid to set
	 */
	public void setSyrkid(String syrkid) {
		this.syrkid = syrkid;
	}

	/**
	 * @return the gmsfhm
	 */
	public String getGmsfhm() {
		return gmsfhm;
	}

	/**
	 * @param gmsfhm
	 *            the gmsfhm to set
	 */
	public void setGmsfhm(String gmsfhm) {
		this.gmsfhm = gmsfhm;
	}

	/**
	 * @return the xm
	 */
	public String getXm() {
		return xm;
	}

	/**
	 * @param xm
	 *            the xm to set
	 */
	public void setXm(String xm) {
		this.xm = xm;
	}

	/**
	 * @return the xbdm
	 */
	public String getXbdm() {
		return xbdm;
	}

	/**
	 * @param xbdm
	 *            the xbdm to set
	 */
	public void setXbdm(String xbdm) {
		this.xbdm = xbdm;
	}

	/**
	 * @return the mzdm
	 */
	public String getMzdm() {
		return mzdm;
	}

	/**
	 * @param mzdm
	 *            the mzdm to set
	 */
	public void setMzdm(String mzdm) {
		this.mzdm = mzdm;
	}

	/**
	 * @return the csrq
	 */
	public String getCsrq() {
		return csrq;
	}

	/**
	 * @param csrq
	 *            the csrq to set
	 */
	public void setCsrq(String csrq) {
		this.csrq = csrq;
	}

	/**
	 * @return the dz_hjdzssxdm
	 */
	public String getDz_hjdzssxdm() {
		return dz_hjdzssxdm;
	}

	/**
	 * @param dzHjdzssxdm
	 *            the dz_hjdzssxdm to set
	 */
	public void setDz_hjdzssxdm(String dzHjdzssxdm) {
		dz_hjdzssxdm = dzHjdzssxdm;
	}

	/**
	 * @return the dz_hjdzmlpdm
	 */
	public String getDz_hjdzmlpdm() {
		return dz_hjdzmlpdm;
	}

	/**
	 * @param dzHjdzmlpdm
	 *            the dz_hjdzmlpdm to set
	 */
	public void setDz_hjdzmlpdm(String dzHjdzmlpdm) {
		dz_hjdzmlpdm = dzHjdzmlpdm;
	}

	/**
	 * @return the dz_hjdzmlpxz
	 */
	public String getDz_hjdzmlpxz() {
		return dz_hjdzmlpxz;
	}

	/**
	 * @param dzHjdzmlpxz
	 *            the dz_hjdzmlpxz to set
	 */
	public void setDz_hjdzmlpxz(String dzHjdzmlpxz) {
		dz_hjdzmlpxz = dzHjdzmlpxz;
	}

	/**
	 * @return the dz_hjdzdm
	 */
	public String getDz_hjdzdm() {
		return dz_hjdzdm;
	}

	/**
	 * @param dzHjdzdm
	 *            the dz_hjdzdm to set
	 */
	public void setDz_hjdzdm(String dzHjdzdm) {
		dz_hjdzdm = dzHjdzdm;
	}

	/**
	 * @return the dz_hjdzxz
	 */
	public String getDz_hjdzxz() {
		return dz_hjdzxz;
	}

	/**
	 * @param dzHjdzxz
	 *            the dz_hjdzxz to set
	 */
	public void setDz_hjdzxz(String dzHjdzxz) {
		dz_hjdzxz = dzHjdzxz;
	}

	/**
	 * @return the dz_jzdzssxdm
	 */
	public String getDz_jzdzssxdm() {
		return dz_jzdzssxdm;
	}

	/**
	 * @param dzJzdzssxdm
	 *            the dz_jzdzssxdm to set
	 */
	public void setDz_jzdzssxdm(String dzJzdzssxdm) {
		dz_jzdzssxdm = dzJzdzssxdm;
	}

	/**
	 * @return the dz_jzdzmlpdm
	 */
	public String getDz_jzdzmlpdm() {
		return dz_jzdzmlpdm;
	}

	/**
	 * @param dzJzdzmlpdm
	 *            the dz_jzdzmlpdm to set
	 */
	public void setDz_jzdzmlpdm(String dzJzdzmlpdm) {
		dz_jzdzmlpdm = dzJzdzmlpdm;
	}

	/**
	 * @return the dz_jzdzmlpxz
	 */
	public String getDz_jzdzmlpxz() {
		return dz_jzdzmlpxz;
	}

	/**
	 * @param dzJzdzmlpxz
	 *            the dz_jzdzmlpxz to set
	 */
	public void setDz_jzdzmlpxz(String dzJzdzmlpxz) {
		dz_jzdzmlpxz = dzJzdzmlpxz;
	}

	/**
	 * @return the dz_jzdzdm
	 */
	public String getDz_jzdzdm() {
		return dz_jzdzdm;
	}

	/**
	 * @param dzJzdzdm
	 *            the dz_jzdzdm to set
	 */
	public void setDz_jzdzdm(String dzJzdzdm) {
		dz_jzdzdm = dzJzdzdm;
	}

	/**
	 * @return the dz_jzdzxz
	 */
	public String getDz_jzdzxz() {
		return dz_jzdzxz;
	}

	/**
	 * @param dzJzdzxz
	 *            the dz_jzdzxz to set
	 */
	public void setDz_jzdzxz(String dzJzdzxz) {
		dz_jzdzxz = dzJzdzxz;
	}

	/**
	 * @return the saryzcdm
	 */
	public String getSaryzcdm() {
		return saryzcdm;
	}

	/**
	 * @param saryzcdm
	 *            the saryzcdm to set
	 */
	public void setSaryzcdm(String saryzcdm) {
		this.saryzcdm = saryzcdm;
	}

	/**
	 * @return the hykydm
	 */
	public String getHykydm() {
		return hykydm;
	}

	/**
	 * @param hykydm
	 *            the hykydm to set
	 */
	public void setHykydm(String hykydm) {
		this.hykydm = hykydm;
	}

	/**
	 * @return the brbjcjdm
	 */
	public String getBrbjcjdm() {
		return brbjcjdm;
	}

	/**
	 * @param brbjcjdm
	 *            the brbjcjdm to set
	 */
	public void setBrbjcjdm(String brbjcjdm) {
		this.brbjcjdm = brbjcjdm;
	}

	/**
	 * @return the zwcjdm
	 */
	public String getZwcjdm() {
		return zwcjdm;
	}

	/**
	 * @param zwcjdm
	 *            the zwcjdm to set
	 */
	public void setZwcjdm(String zwcjdm) {
		this.zwcjdm = zwcjdm;
	}

	/**
	 * @return the jchddq
	 */
	public String getJchddq() {
		return jchddq;
	}

	/**
	 * @param jchddq
	 *            the jchddq to set
	 */
	public void setJchddq(String jchddq) {
		this.jchddq = jchddq;
	}

	/**
	 * @return the xxcjyjdm
	 */
	public String getXxcjyjdm() {
		return xxcjyjdm;
	}

	/**
	 * @param xxcjyjdm
	 *            the xxcjyjdm to set
	 */
	public void setXxcjyjdm(String xxcjyjdm) {
		this.xxcjyjdm = xxcjyjdm;
	}

	/**
	 * @return the zywtjxsbx
	 */
	public String getZywtjxsbx() {
		return zywtjxsbx;
	}

	/**
	 * @param zywtjxsbx
	 *            the zywtjxsbx to set
	 */
	public void setZywtjxsbx(String zywtjxsbx) {
		this.zywtjxsbx = zywtjxsbx;
	}

	/**
	 * @return the dabh
	 */
	public String getDabh() {
		return dabh;
	}

	/**
	 * @param dabh
	 *            the dabh to set
	 */
	public void setDabh(String dabh) {
		this.dabh = dabh;
	}

	/**
	 * @return the zbz
	 */
	public String getZbz() {
		return zbz;
	}

	/**
	 * @param zbz
	 *            the zbz to set
	 */
	public void setZbz(String zbz) {
		this.zbz = zbz;
	}

	/**
	 * @return the mapRadius
	 */
	public String getMapRadius() {
		return mapRadius;
	}

	/**
	 * @param mapRadius
	 *            the mapRadius to set
	 */
	public void setMapRadius(String mapRadius) {
		this.mapRadius = mapRadius;
	}

	/**
	 * @return the condition
	 */
	public String getCondition() {
		return condition;
	}

	/**
	 * @param condition
	 *            the condition to set
	 */
	public void setCondition(String condition) {
		this.condition = condition;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the gxpcsdm
	 */
	public String getGxpcsdm() {
		return gxpcsdm;
	}

	/**
	 * @param gxpcsdm
	 *            the gxpcsdm to set
	 */
	public void setGxpcsdm(String gxpcsdm) {
		this.gxpcsdm = gxpcsdm;
	}

	/**
	 * @return the gxzrqdm
	 */
	public String getGxzrqdm() {
		return gxzrqdm;
	}

	/**
	 * @param gxzrqdm
	 *            the gxzrqdm to set
	 */
	public void setGxzrqdm(String gxzrqdm) {
		this.gxzrqdm = gxzrqdm;
	}

	/**
	 * @return the gxfxjdm
	 */
	public String getGxfxjdm() {
		return gxfxjdm;
	}

	/**
	 * @param gxfxjdm
	 *            the gxfxjdm to set
	 */
	public void setGxfxjdm(String gxfxjdm) {
		this.gxfxjdm = gxfxjdm;
	}

	/**
	 * @return the syrkgllbdm
	 */
	public String getSyrkgllbdm() {
		return syrkgllbdm;
	}

	/**
	 * @param syrkgllbdm
	 *            the syrkgllbdm to set
	 */
	public void setSyrkgllbdm(String syrkgllbdm) {
		this.syrkgllbdm = syrkgllbdm;
	}

	/**
	 * @return the zdrylxdm
	 */
	public String getZdrylxdm() {
		return zdrylxdm;
	}

	/**
	 * @param zdrylxdm
	 *            the zdrylxdm to set
	 */
	public void setZdrylxdm(String zdrylxdm) {
		this.zdrylxdm = zdrylxdm;
	}

	/**
	 * @return the zbx
	 */
	public String getZbx() {
		return zbx;
	}

	/**
	 * @param zbx
	 *            the zbx to set
	 */
	public void setZbx(String zbx) {
		this.zbx = zbx;
	}

	/**
	 * @return the zby
	 */
	public String getZby() {
		return zby;
	}

	/**
	 * @param zby
	 *            the zby to set
	 */
	public void setZby(String zby) {
		this.zby = zby;
	}

	/**
	 * @return the zdrylbdm
	 */
	public String getZdrylbdm() {
		return zdrylbdm;
	}

	/**
	 * @param zdrylbdm
	 *            the zdrylbdm to set
	 */
	public void setZdrylbdm(String zdrylbdm) {
		this.zdrylbdm = zdrylbdm;
	}

	/**
	 * @return the jzdzdm
	 */
	public String getJzdzdm() {
		return jzdzdm;
	}

	/**
	 * @param jzdzdm
	 *            the jzdzdm to set
	 */
	public void setJzdzdm(String jzdzdm) {
		this.jzdzdm = jzdzdm;
	}

}
