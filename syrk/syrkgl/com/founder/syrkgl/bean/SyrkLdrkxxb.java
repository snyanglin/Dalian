package com.founder.syrkgl.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/******************************************************************************
 * @Package: [com.founder.syrkgl.bean.SyrkLdrkxxb.java]
 * @ClassName: [SyrkLdrkxxb]
 * @Description: [流动人口信息表]
 * @Author: [hongguanjun]
 * @CreateDate: [2015-4-2 下午3:06:55]
 * @UpdateUser: [hongguanjun(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-4-2 下午3:06:55，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@DBInfoAnnotation(tableName = "SYRK_LDRKXXB", pk = "id")
public class SyrkLdrkxxb extends BaseEntity implements Serializable {

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
	@FieldDesc("暂（居）住事由")
	private String zjzsydm;
	@FieldDesc("暂（居）住处所")
	private String zjzcsfldm;
	@FieldDesc("户口所在地类型")
	private String hkszdlxdm;
	@FieldDesc("来本市情况_迁（流）入日期")
	private String lbsqk_qlrrq;
	@FieldDesc("来本市情况_迁移（流动）原因")
	private String lbsqk_qyldyydm;
	@FieldDesc("来自地_国家（地区）")
	private String lzd_gjhdqdm;
	@FieldDesc("来自地_行政区划代码")
	private String lzd_xzqhdm;
	@FieldDesc("来自地_门楼牌代码")
	private String lzd_mlpdm;
	@FieldDesc("来自地_门楼牌详址")
	private String lzd_mlpxz;
	@FieldDesc("来自地_地址ID")
	private String lzd_dzid;
	@FieldDesc("来自地_地址详址")
	private String lzd_dzxz;
	@FieldDesc("区域范围")
	private String qyfwdm;
	@FieldDesc("工作单位ID")
	private String gzdwid;
	@FieldDesc("工作单位")
	private String gzdw;
	@FieldDesc("职业类别代码")
	private String zylbdm;
	@FieldDesc("职业")
	private String zy;
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

	public String getZjzsydm() {
		return zjzsydm;
	}

	public void setZjzsydm(String zjzsydm) {
		this.zjzsydm = zjzsydm;
	}

	public String getZjzcsfldm() {
		return zjzcsfldm;
	}

	public void setZjzcsfldm(String zjzcsfldm) {
		this.zjzcsfldm = zjzcsfldm;
	}

	public String getHkszdlxdm() {
		return hkszdlxdm;
	}

	public void setHkszdlxdm(String hkszdlxdm) {
		this.hkszdlxdm = hkszdlxdm;
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

	public String getLzd_gjhdqdm() {
		return lzd_gjhdqdm;
	}

	public void setLzd_gjhdqdm(String lzd_gjhdqdm) {
		this.lzd_gjhdqdm = lzd_gjhdqdm;
	}

	public String getLzd_xzqhdm() {
		return lzd_xzqhdm;
	}

	public void setLzd_xzqhdm(String lzd_xzqhdm) {
		this.lzd_xzqhdm = lzd_xzqhdm;
	}

	public String getLzd_mlpdm() {
		return lzd_mlpdm;
	}

	public void setLzd_mlpdm(String lzd_mlpdm) {
		this.lzd_mlpdm = lzd_mlpdm;
	}

	public String getLzd_mlpxz() {
		return lzd_mlpxz;
	}

	public void setLzd_mlpxz(String lzd_mlpxz) {
		this.lzd_mlpxz = lzd_mlpxz;
	}

	public String getLzd_dzid() {
		return lzd_dzid;
	}

	public void setLzd_dzid(String lzd_dzid) {
		this.lzd_dzid = lzd_dzid;
	}

	public String getLzd_dzxz() {
		return lzd_dzxz;
	}

	public void setLzd_dzxz(String lzd_dzxz) {
		this.lzd_dzxz = lzd_dzxz;
	}

	public String getQyfwdm() {
		return qyfwdm;
	}

	public void setQyfwdm(String qyfwdm) {
		this.qyfwdm = qyfwdm;
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

}
