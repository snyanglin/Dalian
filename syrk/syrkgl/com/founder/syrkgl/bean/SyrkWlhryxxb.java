package com.founder.syrkgl.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/******************************************************************************
 * @Package: [com.founder.syrkgl.bean.SyrkWlhryxxb.java]
 * @ClassName: [SyrkWlhryxxb]
 * @Description: [未落户人员信息表]
 * @Author: [hongguanjun]
 * @CreateDate: [2015-4-2 下午3:11:00]
 * @UpdateUser: [hongguanjun(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-4-2 下午3:11:00，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@DBInfoAnnotation(tableName = "SYRK_WLHRYXXB", pk = "id")
public class SyrkWlhryxxb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@FieldDesc("实有人口ID")
	private String id;
	@FieldDesc("人员ID")
	private String ryid;
	@FieldDesc("证件种类")
	private String cyzjdm;
	@FieldDesc("证件号码")
	private String zjhm;
	@FieldDesc("姓名")
	private String xm;
	@FieldDesc("姓名汉语拼音")
	private String xmhypy;
	@FieldDesc("姓名汉语简拼")
	private String xmhyjp;
	@FieldDesc("曾用名")
	private String cym;
	@FieldDesc("性别代码")
	private String xbdm;
	@FieldDesc("民族代码")
	private String mzdm;
	@FieldDesc("出生日期")
	private String csrq;
	@FieldDesc("联系电话")
	private String lxdh;
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
	@FieldDesc("其它_常用证件代码")
	private String qtcyzjdm;
	@FieldDesc("其它_证件号码")
	private String qtzjhm;
	@FieldDesc("出生地国家和地区代码")
	private String csdgjhdqdm;
	@FieldDesc("出生地省市县代码")
	private String csdssxdm;
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
	@FieldDesc("居住地_坐标X")
	private String jzd_zbx;
	@FieldDesc("居住地_坐标Y")
	private String jzd_zby;
	@FieldDesc("未落户原因代码")
	private String wlhyydm;
	@FieldDesc("暂（居）住处所")
	private String zjzcsfldm;
	@FieldDesc("工作单位id")
	private String gzdwid;
	@FieldDesc("工作单位")
	private String gzdw;
	@FieldDesc("职业类别代码")
	private String zylbdm;
	@FieldDesc("职业")
	private String zy;
	@FieldDesc("房屋承租情况代码")
	private String fwczqkdm;
	@FieldDesc("与房主关系_人员关系")
	private String chzr_yfzgx_rygxdm;
	@FieldDesc("房主_人员ID")
	private String fz_ryid;
	@FieldDesc("房主_证件种类")
	private String fz_cyzjdm;
	@FieldDesc("房主_证件号码")
	private String fz_zjhm;
	@FieldDesc("房主_姓名")
	private String fz_xm;
	@FieldDesc("房主_外文姓")
	private String fz_wwx;
	@FieldDesc("房主_外文名")
	private String fz_wwm;
	@FieldDesc("房主_联系电话")
	private String fz_lxdh;
	@FieldDesc("房主_居住地_行政区划代码")
	private String fz_jzd_xzqhdm;
	@FieldDesc("房主_居住地_门楼牌代码")
	private String fz_jzd_mlpdm;
	@FieldDesc("房主_居住地_门楼牌详址")
	private String fz_jzd_mlpxz;
	@FieldDesc("房主_居住地_地址ID")
	private String fz_jzd_dzid;
	@FieldDesc("房主_居住地_地址详址")
	private String fz_jzd_dzxz;
	@FieldDesc("备注")
	private String bz;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRyid() {
		return ryid;
	}

	public void setRyid(String ryid) {
		this.ryid = ryid;
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

	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public String getXmhypy() {
		return xmhypy;
	}

	public void setXmhypy(String xmhypy) {
		this.xmhypy = xmhypy;
	}

	public String getXmhyjp() {
		return xmhyjp;
	}

	public void setXmhyjp(String xmhyjp) {
		this.xmhyjp = xmhyjp;
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

	public String getLxdh() {
		return lxdh;
	}

	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
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

	public String getQtcyzjdm() {
		return qtcyzjdm;
	}

	public void setQtcyzjdm(String qtcyzjdm) {
		this.qtcyzjdm = qtcyzjdm;
	}

	public String getQtzjhm() {
		return qtzjhm;
	}

	public void setQtzjhm(String qtzjhm) {
		this.qtzjhm = qtzjhm;
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

	public String getJzd_zbx() {
		return jzd_zbx;
	}

	public void setJzd_zbx(String jzd_zbx) {
		this.jzd_zbx = jzd_zbx;
	}

	public String getJzd_zby() {
		return jzd_zby;
	}

	public void setJzd_zby(String jzd_zby) {
		this.jzd_zby = jzd_zby;
	}

	public String getWlhyydm() {
		return wlhyydm;
	}

	public void setWlhyydm(String wlhyydm) {
		this.wlhyydm = wlhyydm;
	}

	public String getZjzcsfldm() {
		return zjzcsfldm;
	}

	public void setZjzcsfldm(String zjzcsfldm) {
		this.zjzcsfldm = zjzcsfldm;
	}

	public String getFwczqkdm() {
		return fwczqkdm;
	}

	public void setFwczqkdm(String fwczqkdm) {
		this.fwczqkdm = fwczqkdm;
	}

	public String getChzr_yfzgx_rygxdm() {
		return chzr_yfzgx_rygxdm;
	}

	public void setChzr_yfzgx_rygxdm(String chzr_yfzgx_rygxdm) {
		this.chzr_yfzgx_rygxdm = chzr_yfzgx_rygxdm;
	}

	public String getFz_ryid() {
		return fz_ryid;
	}

	public void setFz_ryid(String fz_ryid) {
		this.fz_ryid = fz_ryid;
	}

	public String getFz_cyzjdm() {
		return fz_cyzjdm;
	}

	public void setFz_cyzjdm(String fz_cyzjdm) {
		this.fz_cyzjdm = fz_cyzjdm;
	}

	public String getFz_zjhm() {
		return fz_zjhm;
	}

	public void setFz_zjhm(String fz_zjhm) {
		this.fz_zjhm = fz_zjhm;
	}

	public String getFz_xm() {
		return fz_xm;
	}

	public void setFz_xm(String fz_xm) {
		this.fz_xm = fz_xm;
	}

	public String getFz_wwx() {
		return fz_wwx;
	}

	public void setFz_wwx(String fz_wwx) {
		this.fz_wwx = fz_wwx;
	}

	public String getFz_wwm() {
		return fz_wwm;
	}

	public void setFz_wwm(String fz_wwm) {
		this.fz_wwm = fz_wwm;
	}

	public String getFz_lxdh() {
		return fz_lxdh;
	}

	public void setFz_lxdh(String fz_lxdh) {
		this.fz_lxdh = fz_lxdh;
	}

	public String getFz_jzd_xzqhdm() {
		return fz_jzd_xzqhdm;
	}

	public void setFz_jzd_xzqhdm(String fz_jzd_xzqhdm) {
		this.fz_jzd_xzqhdm = fz_jzd_xzqhdm;
	}

	public String getFz_jzd_mlpdm() {
		return fz_jzd_mlpdm;
	}

	public void setFz_jzd_mlpdm(String fz_jzd_mlpdm) {
		this.fz_jzd_mlpdm = fz_jzd_mlpdm;
	}

	public String getFz_jzd_mlpxz() {
		return fz_jzd_mlpxz;
	}

	public void setFz_jzd_mlpxz(String fz_jzd_mlpxz) {
		this.fz_jzd_mlpxz = fz_jzd_mlpxz;
	}

	public String getFz_jzd_dzid() {
		return fz_jzd_dzid;
	}

	public void setFz_jzd_dzid(String fz_jzd_dzid) {
		this.fz_jzd_dzid = fz_jzd_dzid;
	}

	public String getFz_jzd_dzxz() {
		return fz_jzd_dzxz;
	}

	public void setFz_jzd_dzxz(String fz_jzd_dzxz) {
		this.fz_jzd_dzxz = fz_jzd_dzxz;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public String getGzdwid() {
		return gzdwid;
	}

	public void setGzdwid(String gzdwid) {
		this.gzdwid = gzdwid;
	}

	public String getGzdw() {
		return gzdw;
	}

	public void setGzdw(String gzdw) {
		this.gzdw = gzdw;
	}

	public String getZylbdm() {
		return zylbdm;
	}

	public void setZylbdm(String zylbdm) {
		this.zylbdm = zylbdm;
	}

	public String getZy() {
		return zy;
	}

	public void setZy(String zy) {
		this.zy = zy;
	}

}
