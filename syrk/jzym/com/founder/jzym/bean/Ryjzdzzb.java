package com.founder.jzym.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

@DBInfoAnnotation(tableName = "RK_RYJZDZZB", pk = "id")
public class Ryjzdzzb extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@FieldDesc("人员居住地址ID")
	private String id;
	@FieldDesc("人员分类ID")
	private String ryflid;
	@FieldDesc("人员ID")
	private String ryid;
	@FieldDesc("实有人口管理类别代码")
	private String syrkgllbdm;
	@FieldDesc("地址-居住地址代码")
	private String dz_jzdzdm;
	@FieldDesc("地址-居住地址省市县代码")
	private String dz_jzdzssxdm;
	@FieldDesc("地址-居住地址详址")
	private String dz_jzdzxz;
	@FieldDesc("居住规律")
	private String jzgn;
	@FieldDesc("管辖分县局代码")
	private String gxfxjdm;
	@FieldDesc("管辖派出所代码")
	private String gxpcsdm;
	@FieldDesc("管辖责任区代码")
	private String gxzrqdm;
	@FieldDesc("居住开始时间")
	private String jzkssj;
	@FieldDesc("拟居住离开时间")
	private String njzlksj;
	@FieldDesc("实际居住结束时间")
	private String sjjzjssj;
	@FieldDesc("居住状态代码")
	private String jzztdm;
	@FieldDesc("去向类型代码")
	private String qxlxdm;
	@FieldDesc("地址_去向地址代码")
	private String dz_qxdzdm;
	@FieldDesc("地址_去向地址国家地区及行政区划代码")
	private String dz_qxdzgjdqjxzqhdm;
	@FieldDesc("地址_去向地址详址")
	private String dz_qxdzxz;
	@FieldDesc("备注")
	private String bz;
	@FieldDesc("地址-居住地址描述")
	private String dz_jzdzms;
	@FieldDesc("地址-户籍地址描述")
	private String dz_hjdzms;
	@FieldDesc("地址-居住地门楼牌代码")
	private String dz_jzdmlpdm;
	@FieldDesc("地址-居住地门楼牌详址")
	private String dz_jzdmlpxz;
	@FieldDesc("地址_去向地址门楼牌代码")
	private String dz_qxdzmlpdm;
	@FieldDesc("地址_去向地址门楼牌详址")
	private String dz_qxdzmlpxz;
	
	private String isNullValue;//临时值
	
	
	
	public String getIsNullValue() {
		return isNullValue;
	}
	public void setIsNullValue(String isNullValue) {
		this.isNullValue = isNullValue;
	}
	/**
	 * 获取传入的坐标值
	 */
	private String zbz;
	// 判断按照那种查询类型
	private String type;
	private int srid;
	private String zbx;
	private String zby;
	// 空间查询缓冲区半径
	private String mapRadius;
	/**
	 * 人员的相关字段
	 * 
	 * @return
	 */
	private String cyzjdm;// 曾用证件代码
	private String xm;// 姓名
	private String zjhm;
	private String gmsfhm;
	private String mzdm;
	private String xbdm;
	private String sl;
	private String jzwid;
	private String dz_hjdzdm;
	private String dz_hjdzxz;
	private String bzdzid;
	private String hjdzms;
	private String jzdzms;
    private String csrq;
    private String cym;
    private String xldm;
    private String hyzkdm;
    private String byzkdm;
    private String xxdm;
    private String fwcs;
    private String zy;
    private String zw;
    private String byyx;
    private String byzy;
    private String lxdh;
    private String cxfs;
    //全文检索字段
    private String condition;
    
	public String getLxdh() {
		return lxdh;
	}
	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}
	public String getCxfs() {
		return cxfs;
	}
	public void setCxfs(String cxfs) {
		this.cxfs = cxfs;
	}
	public String getByyx() {
		return byyx;
	}
	public void setByyx(String byyx) {
		this.byyx = byyx;
	}
	public String getByzy() {
		return byzy;
	}

	public void setByzy(String byzy) {
		this.byzy = byzy;
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

	public String getFwcs() {
		return fwcs;
	}

	public void setFwcs(String fwcs) {
		this.fwcs = fwcs;
	}

	public String getZy() {
		return zy;
	}

	public void setZy(String zy) {
		this.zy = zy;
	}

	public String getZw() {
		return zw;
	}

	public void setZw(String zw) {
		this.zw = zw;
	}

	public String getCym() {
		return cym;
	}

	public void setCym(String cym) {
		this.cym = cym;
	}

	public String getCsrq() {
		return csrq;
	}

	public void setCsrq(String csrq) {
		this.csrq = csrq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRyflid() {
		return ryflid;
	}

	public void setRyflid(String ryflid) {
		this.ryflid = ryflid;
	}

	public String getRyid() {
		return ryid;
	}

	public void setRyid(String ryid) {
		this.ryid = ryid;
	}

	public String getSyrkgllbdm() {
		return syrkgllbdm;
	}

	public void setSyrkgllbdm(String syrkgllbdm) {
		this.syrkgllbdm = syrkgllbdm;
	}

	public String getDz_jzdzdm() {
		return dz_jzdzdm;
	}

	public void setDz_jzdzdm(String dzJzdzdm) {
		dz_jzdzdm = dzJzdzdm;
	}

	public String getDz_jzdzssxdm() {
		return dz_jzdzssxdm;
	}

	public void setDz_jzdzssxdm(String dzJzdzssxdm) {
		dz_jzdzssxdm = dzJzdzssxdm;
	}

	public String getDz_jzdzxz() {
		return dz_jzdzxz;
	}

	public void setDz_jzdzxz(String dzJzdzxz) {
		dz_jzdzxz = dzJzdzxz;
	}

	public String getJzgn() {
		return jzgn;
	}

	public void setJzgn(String jzgn) {
		this.jzgn = jzgn;
	}

	public String getGxfxjdm() {
		return gxfxjdm;
	}

	public void setGxfxjdm(String gxfxjdm) {
		this.gxfxjdm = gxfxjdm;
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

	public String getJzkssj() {
		return jzkssj;
	}

	public void setJzkssj(String jzkssj) {
		this.jzkssj = jzkssj;
	}

	public String getNjzlksj() {
		return njzlksj;
	}

	public void setNjzlksj(String njzlksj) {
		this.njzlksj = njzlksj;
	}

	public String getSjjzjssj() {
		return sjjzjssj;
	}

	public void setSjjzjssj(String sjjzjssj) {
		this.sjjzjssj = sjjzjssj;
	}

	public String getJzztdm() {
		return jzztdm;
	}

	public void setJzztdm(String jzztdm) {
		this.jzztdm = jzztdm;
	}

	public String getQxlxdm() {
		return qxlxdm;
	}

	public void setQxlxdm(String qxlxdm) {
		this.qxlxdm = qxlxdm;
	}

	public String getDz_qxdzdm() {
		return dz_qxdzdm;
	}

	public void setDz_qxdzdm(String dzQxdzdm) {
		dz_qxdzdm = dzQxdzdm;
	}

	public String getDz_qxdzgjdqjxzqhdm() {
		return dz_qxdzgjdqjxzqhdm;
	}

	public void setDz_qxdzgjdqjxzqhdm(String dzQxdzgjdqjxzqhdm) {
		dz_qxdzgjdqjxzqhdm = dzQxdzgjdqjxzqhdm;
	}

	public String getDz_qxdzxz() {
		return dz_qxdzxz;
	}

	public void setDz_qxdzxz(String dzQxdzxz) {
		dz_qxdzxz = dzQxdzxz;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public String getDz_jzdzms() {
		return dz_jzdzms;
	}

	public void setDz_jzdzms(String dzJzdzms) {
		dz_jzdzms = dzJzdzms;
	}

	public String getDz_jzdmlpdm() {
		return dz_jzdmlpdm;
	}

	public void setDz_jzdmlpdm(String dzJzdmlpdm) {
		dz_jzdmlpdm = dzJzdmlpdm;
	}

	public String getDz_jzdmlpxz() {
		return dz_jzdmlpxz;
	}

	public void setDz_jzdmlpxz(String dzJzdmlpxz) {
		dz_jzdmlpxz = dzJzdmlpxz;
	}

	public String getDz_qxdzmlpdm() {
		return dz_qxdzmlpdm;
	}

	public void setDz_qxdzmlpdm(String dzQxdzmlpdm) {
		dz_qxdzmlpdm = dzQxdzmlpdm;
	}

	public String getDz_qxdzmlpxz() {
		return dz_qxdzmlpxz;
	}

	public void setDz_qxdzmlpxz(String dzQxdzmlpxz) {
		dz_qxdzmlpxz = dzQxdzmlpxz;
	}

	public String getZbz() {
		return zbz;
	}

	public void setZbz(String zbz) {
		this.zbz = zbz;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getSrid() {
		return srid;
	}

	public void setSrid(int srid) {
		this.srid = srid;
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

	public String getMapRadius() {
		return mapRadius;
	}

	public void setMapRadius(String mapRadius) {
		this.mapRadius = mapRadius;
	}

	public String getCyzjdm() {
		return cyzjdm;
	}

	public void setCyzjdm(String cyzjdm) {
		this.cyzjdm = cyzjdm;
	}

	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public String getZjhm() {
		return zjhm;
	}

	public void setZjhm(String zjhm) {
		this.zjhm = zjhm;
	}

	public String getGmsfhm() {
		return gmsfhm;
	}

	public void setGmsfhm(String gmsfhm) {
		this.gmsfhm = gmsfhm;
	}

	public String getMzdm() {
		return mzdm;
	}

	public void setMzdm(String mzdm) {
		this.mzdm = mzdm;
	}

	public String getXbdm() {
		return xbdm;
	}

	public void setXbdm(String xbdm) {
		this.xbdm = xbdm;
	}

	public String getSl() {
		return sl;
	}

	public void setSl(String sl) {
		this.sl = sl;
	}

	public String getJzwid() {
		return jzwid;
	}

	public void setJzwid(String jzwid) {
		this.jzwid = jzwid;
	}

	public String getDz_hjdzdm() {
		return dz_hjdzdm;
	}

	public void setDz_hjdzdm(String dzHjdzdm) {
		dz_hjdzdm = dzHjdzdm;
	}

	public String getDz_hjdzxz() {
		return dz_hjdzxz;
	}

	public void setDz_hjdzxz(String dzHjdzxz) {
		dz_hjdzxz = dzHjdzxz;
	}

	public String getBzdzid() {
		return bzdzid;
	}

	public void setBzdzid(String bzdzid) {
		this.bzdzid = bzdzid;
	}

	public String getHjdzms() {
		return hjdzms;
	}

	public void setHjdzms(String hjdzms) {
		this.hjdzms = hjdzms;
	}

	public String getJzdzms() {
		return jzdzms;
	}

	public void setJzdzms(String jzdzms) {
		this.jzdzms = jzdzms;
	}

	public String getDz_hjdzms() {
		return dz_hjdzms;
	}

	public void setDz_hjdzms(String dz_hjdzms) {
		this.dz_hjdzms = dz_hjdzms;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}

}
