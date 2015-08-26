package com.founder.syrkgl.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/******************************************************************************
 * @Package: [com.founder.syrkgl.bean.SyrkCzrkxxb.java]
 * @ClassName: [SyrkCzrkxxb]
 * @Description: [常住人口信息表]
 * @Author: [hongguanjun]
 * @CreateDate: [2015-4-2 下午3:04:18]
 * @UpdateUser: [hongguanjun(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-4-2 下午3:04:18，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@DBInfoAnnotation(tableName = "SYRK_CZRKXXB", pk = "id")
public class SyrkCzrkxxb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@FieldDesc("实有人口ID")
	private String id;
	@FieldDesc("人员ID")
	private String ryid;
	@FieldDesc("是否人户一致")
	private String sfrhyzdm;
	@FieldDesc("公民身份号码")
	private String gmsfhm;
	@FieldDesc("姓名")
	private String xm;
	@FieldDesc("姓名汉语拼音")
	private String xmhypy;
	@FieldDesc("姓名汉语简拼")
	private String xmhyjp;
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
	@FieldDesc("籍贯国家/地区代码")
	private String jggjdqdm;
	@FieldDesc("籍贯省市县代码")
	private String jgssxdm;
	@FieldDesc("户口性质分类代码")
	private String hkxzfldm;
	@FieldDesc("户号")
	private String hh;
	@FieldDesc("与户主关系代码")
	private String yhzgxdm;
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
	@FieldDesc("工作单位id")
	private String gzdwid;
	@FieldDesc("工作单位")
	private String gzdw;
	@FieldDesc("职业类别代码")
	private String zylbdm;
	@FieldDesc("职业")
	private String zy;
	@FieldDesc("联系电话")
	private String lxdh;
	@FieldDesc("来本市情况_迁（流）入日期")
	private String lbsqk_qlrrq;
	@FieldDesc("来本市情况_迁移（流动）原因")
	private String lbsqk_qyldyydm;
	@FieldDesc("来本市情况_来自地_国家")
	private String lbsqk_lzd_gjhdqdm;
	@FieldDesc("来本市情况_来自地_行政区划代码")
	private String lbsqk_lzd_xzqhdm;
	@FieldDesc("来本市情况_来自地_门楼牌代码")
	private String lbsqk_lzd_mlpdm;
	@FieldDesc("来本市情况_来自地_门楼牌详址")
	private String lbsqk_lzd_mlpxz;
	@FieldDesc("来本市情况_来自地_地址ID")
	private String lbsqk_lzd_dzid;
	@FieldDesc("来本市情况_来自地_地址详址")
	private String lbsqk_lzd_dzxz;
	@FieldDesc("离开本市情况_迁（流）出日期")
	private String lkbsqk_qlcrq;
	@FieldDesc("离开本市情况_迁移（流动）原因")
	private String lkbsqk_qyldyydm;
	@FieldDesc("去往地_国家和地区代码")
	private String qwd_gjhdqdm;
	@FieldDesc("去往地_行政区划代码")
	private String qwd_xzqhdm;
	@FieldDesc("去往地_门楼牌代码")
	private String qwd_mlpdm;
	@FieldDesc("去往地_门楼牌详址")
	private String qwd_mlpxz;
	@FieldDesc("去往地_地址ID")
	private String qwd_dzid;
	@FieldDesc("去往地_地址详址")
	private String qwd_dzxz;
	@FieldDesc("死亡日期")
	private String swrq;
	@FieldDesc("人口管理死亡原因代码")
	private String rkglswyydm;
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

	public String getSfrhyzdm() {
		return sfrhyzdm;
	}

	public void setSfrhyzdm(String sfrhyzdm) {
		this.sfrhyzdm = sfrhyzdm;
	}

	public String getGmsfhm() {
		return gmsfhm;
	}

	public void setGmsfhm(String gmsfhm) {
		this.gmsfhm = gmsfhm;
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

	public String getHkxzfldm() {
		return hkxzfldm;
	}

	public void setHkxzfldm(String hkxzfldm) {
		this.hkxzfldm = hkxzfldm;
	}

	public String getHh() {
		return hh;
	}

	public void setHh(String hh) {
		this.hh = hh;
	}

	public String getYhzgxdm() {
		return yhzgxdm;
	}

	public void setYhzgxdm(String yhzgxdm) {
		this.yhzgxdm = yhzgxdm;
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

	public String getLxdh() {
		return lxdh;
	}

	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}

	public String getLbsqk_qlrrq() {
		return lbsqk_qlrrq;
	}

	public void setLbsqk_qlrrq(String lbsqk_qlrrq) {
		this.lbsqk_qlrrq = lbsqk_qlrrq;
	}

	public String getLbsqk_qyldyydm() {
		return lbsqk_qyldyydm;
	}

	public void setLbsqk_qyldyydm(String lbsqk_qyldyydm) {
		this.lbsqk_qyldyydm = lbsqk_qyldyydm;
	}

	public String getLbsqk_lzd_gjhdqdm() {
		return lbsqk_lzd_gjhdqdm;
	}

	public void setLbsqk_lzd_gjhdqdm(String lbsqk_lzd_gjhdqdm) {
		this.lbsqk_lzd_gjhdqdm = lbsqk_lzd_gjhdqdm;
	}

	public String getLbsqk_lzd_xzqhdm() {
		return lbsqk_lzd_xzqhdm;
	}

	public void setLbsqk_lzd_xzqhdm(String lbsqk_lzd_xzqhdm) {
		this.lbsqk_lzd_xzqhdm = lbsqk_lzd_xzqhdm;
	}

	public String getLbsqk_lzd_mlpdm() {
		return lbsqk_lzd_mlpdm;
	}

	public void setLbsqk_lzd_mlpdm(String lbsqk_lzd_mlpdm) {
		this.lbsqk_lzd_mlpdm = lbsqk_lzd_mlpdm;
	}

	public String getLbsqk_lzd_mlpxz() {
		return lbsqk_lzd_mlpxz;
	}

	public void setLbsqk_lzd_mlpxz(String lbsqk_lzd_mlpxz) {
		this.lbsqk_lzd_mlpxz = lbsqk_lzd_mlpxz;
	}

	public String getLbsqk_lzd_dzid() {
		return lbsqk_lzd_dzid;
	}

	public void setLbsqk_lzd_dzid(String lbsqk_lzd_dzid) {
		this.lbsqk_lzd_dzid = lbsqk_lzd_dzid;
	}

	public String getLbsqk_lzd_dzxz() {
		return lbsqk_lzd_dzxz;
	}

	public void setLbsqk_lzd_dzxz(String lbsqk_lzd_dzxz) {
		this.lbsqk_lzd_dzxz = lbsqk_lzd_dzxz;
	}

	public String getLkbsqk_qlcrq() {
		return lkbsqk_qlcrq;
	}

	public void setLkbsqk_qlcrq(String lkbsqk_qlcrq) {
		this.lkbsqk_qlcrq = lkbsqk_qlcrq;
	}

	public String getLkbsqk_qyldyydm() {
		return lkbsqk_qyldyydm;
	}

	public void setLkbsqk_qyldyydm(String lkbsqk_qyldyydm) {
		this.lkbsqk_qyldyydm = lkbsqk_qyldyydm;
	}

	public String getQwd_gjhdqdm() {
		return qwd_gjhdqdm;
	}

	public void setQwd_gjhdqdm(String qwd_gjhdqdm) {
		this.qwd_gjhdqdm = qwd_gjhdqdm;
	}

	public String getQwd_xzqhdm() {
		return qwd_xzqhdm;
	}

	public void setQwd_xzqhdm(String qwd_xzqhdm) {
		this.qwd_xzqhdm = qwd_xzqhdm;
	}

	public String getQwd_mlpdm() {
		return qwd_mlpdm;
	}

	public void setQwd_mlpdm(String qwd_mlpdm) {
		this.qwd_mlpdm = qwd_mlpdm;
	}

	public String getQwd_mlpxz() {
		return qwd_mlpxz;
	}

	public void setQwd_mlpxz(String qwd_mlpxz) {
		this.qwd_mlpxz = qwd_mlpxz;
	}

	public String getQwd_dzid() {
		return qwd_dzid;
	}

	public void setQwd_dzid(String qwd_dzid) {
		this.qwd_dzid = qwd_dzid;
	}

	public String getQwd_dzxz() {
		return qwd_dzxz;
	}

	public void setQwd_dzxz(String qwd_dzxz) {
		this.qwd_dzxz = qwd_dzxz;
	}

	public String getSwrq() {
		return swrq;
	}

	public void setSwrq(String swrq) {
		this.swrq = swrq;
	}

	public String getRkglswyydm() {
		return rkglswyydm;
	}

	public void setRkglswyydm(String rkglswyydm) {
		this.rkglswyydm = rkglswyydm;
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
	
}
