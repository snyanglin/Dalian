package com.founder.syrkgl.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/******************************************************************************
 * @Package: [com.founder.syrkgl.bean.RyRyjbxxb.java]
 * @ClassName: [RyRyjbxxb]
 * @Description: [人员基本信息表]
 * @Author: [hongguanjun]
 * @CreateDate: [2015-4-2 下午3:04:36]
 * @UpdateUser: [hongguanjun(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-4-2 下午3:04:36，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@DBInfoAnnotation(tableName = "RY_RYJBXXB", pk = "id")
public class RyRyjbxxb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@FieldDesc("人员ID")
	private String id;
	@FieldDesc("实有人口标识")
	private String syrkbz;
	@FieldDesc("证件种类")
	private String cyzjdm;
	@FieldDesc("证件号码")
	private String zjhm;
	@FieldDesc("外文姓")
	private String wwx;
	@FieldDesc("外文名")
	private String wwm;
	@FieldDesc("姓名")
	private String xm;
	@FieldDesc("曾用名")
	private String cym;
	@FieldDesc("性别代码")
	private String xbdm;
	@FieldDesc("民族代码")
	private String mzdm;
	@FieldDesc("出生日期")
	private String csrq;
	@FieldDesc("出生地国家和地区代码")
	private String csdgjhdqdm;
	@FieldDesc("出生地省市县代码")
	private String csdssxdm;
	@FieldDesc("国籍代码")
	private String gjdm;
	@FieldDesc("籍贯国家/地区代码")
	private String jggjdqdm;
	@FieldDesc("籍贯省市县代码")
	private String jgssxdm;
	@FieldDesc("户籍地_行政区划代码")
	private String hjd_xzqhdm;
	@FieldDesc("户籍地_门楼牌代码")
	private String hjd_mlpdm;
	@FieldDesc("户籍地_门楼牌详址")
	private String hjd_mlpxz;
	@FieldDesc("户籍地_地址ID")
	private String hjd_dzid;
	@FieldDesc("户籍地_地址详址")
	private String hjd_dzxz;
	@FieldDesc("户籍地_地址描述")
	private String hjd_dzms;
	@FieldDesc("户籍地_派出所代码")
	private String hjd_pcsdm;
	@FieldDesc("居住地_行政区划代码")
	private String jzd_xzqhdm;
	@FieldDesc("居住地_门楼牌代码")
	private String jzd_mlpdm;
	@FieldDesc("居住地_门楼牌详址")
	private String jzd_mlpxz;
	@FieldDesc("居住地_地址ID")
	private String jzd_dzid;
	@FieldDesc("居住地_地址详址")
	private String jzd_dzxz;
	@FieldDesc("学历代码")
	private String xldm;
	@FieldDesc("婚姻状况代码")
	private String hyzkdm;
	@FieldDesc("政治面貌代码")
	private String zzmmdm;
	@FieldDesc("宗教信仰代码")
	private String zjxydm;
	@FieldDesc("兵役状况代码")
	private String byzkdm;
	@FieldDesc("血型代码")
	private String xxdm;
	@FieldDesc("职业")
	private String zy;
	@FieldDesc("职业类别代码")
	private String zylbdm;
	@FieldDesc("DNA编号")
	private String dnabh;
	@FieldDesc("指纹编号")
	private String zwbh;
	@FieldDesc("备注")
	private String bz;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSyrkbz() {
		return syrkbz;
	}

	public void setSyrkbz(String syrkbz) {
		this.syrkbz = syrkbz;
	}

	public String getCyzjdm() {
		return cyzjdm;
	}

	public void setCyzjdm(String cyzjdm) {
		this.cyzjdm = cyzjdm;
	}

	public String getZjhm() {
		return zjhm;
	}

	public void setZjhm(String zjhm) {
		this.zjhm = zjhm;
	}

	public String getWwx() {
		return wwx;
	}

	public void setWwx(String wwx) {
		this.wwx = wwx;
	}

	public String getWwm() {
		return wwm;
	}

	public void setWwm(String wwm) {
		this.wwm = wwm;
	}

	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public String getCym() {
		return cym;
	}

	public void setCym(String cym) {
		this.cym = cym;
	}

	public String getXbdm() {
		return xbdm;
	}

	public void setXbdm(String xbdm) {
		this.xbdm = xbdm;
	}

	public String getMzdm() {
		return mzdm;
	}

	public void setMzdm(String mzdm) {
		this.mzdm = mzdm;
	}

	public String getCsrq() {
		return csrq;
	}

	public void setCsrq(String csrq) {
		this.csrq = csrq;
	}

	public String getCsdgjhdqdm() {
		return csdgjhdqdm;
	}

	public void setCsdgjhdqdm(String csdgjhdqdm) {
		this.csdgjhdqdm = csdgjhdqdm;
	}

	public String getCsdssxdm() {
		return csdssxdm;
	}

	public void setCsdssxdm(String csdssxdm) {
		this.csdssxdm = csdssxdm;
	}

	public String getGjdm() {
		return gjdm;
	}

	public void setGjdm(String gjdm) {
		this.gjdm = gjdm;
	}

	public String getJggjdqdm() {
		return jggjdqdm;
	}

	public void setJggjdqdm(String jggjdqdm) {
		this.jggjdqdm = jggjdqdm;
	}

	public String getJgssxdm() {
		return jgssxdm;
	}

	public void setJgssxdm(String jgssxdm) {
		this.jgssxdm = jgssxdm;
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

	public String getHjd_dzms() {
		return hjd_dzms;
	}

	public void setHjd_dzms(String hjd_dzms) {
		this.hjd_dzms = hjd_dzms;
	}

	public String getHjd_pcsdm() {
		return hjd_pcsdm;
	}

	public void setHjd_pcsdm(String hjd_pcsdm) {
		this.hjd_pcsdm = hjd_pcsdm;
	}

	public String getXldm() {
		return xldm;
	}

	public void setXldm(String xldm) {
		this.xldm = xldm;
	}

	public String getHyzkdm() {
		return hyzkdm;
	}

	public void setHyzkdm(String hyzkdm) {
		this.hyzkdm = hyzkdm;
	}

	public String getZzmmdm() {
		return zzmmdm;
	}

	public void setZzmmdm(String zzmmdm) {
		this.zzmmdm = zzmmdm;
	}

	public String getZjxydm() {
		return zjxydm;
	}

	public void setZjxydm(String zjxydm) {
		this.zjxydm = zjxydm;
	}

	public String getByzkdm() {
		return byzkdm;
	}

	public void setByzkdm(String byzkdm) {
		this.byzkdm = byzkdm;
	}

	public String getXxdm() {
		return xxdm;
	}

	public void setXxdm(String xxdm) {
		this.xxdm = xxdm;
	}

	public String getZy() {
		return zy;
	}

	public void setZy(String zy) {
		this.zy = zy;
	}

	public String getZylbdm() {
		return zylbdm;
	}

	public void setZylbdm(String zylbdm) {
		this.zylbdm = zylbdm;
	}

	public String getDnabh() {
		return dnabh;
	}

	public void setDnabh(String dnabh) {
		this.dnabh = dnabh;
	}

	public String getZwbh() {
		return zwbh;
	}

	public void setZwbh(String zwbh) {
		this.zwbh = zwbh;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	/**
	 * @Fields lxdh : TODO(联系电话)
	 */
	private String lxdh;

	public String getLxdh() {
		return lxdh;
	}

	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
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

}
