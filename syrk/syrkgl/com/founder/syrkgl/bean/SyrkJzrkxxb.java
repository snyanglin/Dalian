package com.founder.syrkgl.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/******************************************************************************
 * @Package: [com.founder.syrkgl.bean.SyrkJzrkxxb.java]
 * @ClassName: [SyrkJzrkxxb]
 * @Description: [寄住人口信息表]
 * @Author: [hongguanjun]
 * @CreateDate: [2015-4-2 下午3:05:59]
 * @UpdateUser: [hongguanjun(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-4-2 下午3:05:59，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@DBInfoAnnotation(tableName = "SYRK_JZRKXXB", pk = "id")
public class SyrkJzrkxxb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@FieldDesc("实有人口ID")
	private String id;
	@FieldDesc("人员ID")
	private String ryid;
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
	@FieldDesc("联系电话")
	private String lxdh;
	@FieldDesc("寄住类别代码")
	private String jzlbdm;
	@FieldDesc("寄住原因代码")
	private String jzyydm;
	@FieldDesc("寄住_开始日期")
	private String jz_ksrq01;
	@FieldDesc("预计_离开时间")
	private String yj_lksj;
	@FieldDesc("实际_离开时间")
	private String sj_lksj;
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

	public String getLxdh() {
		return lxdh;
	}

	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}

	public String getJzlbdm() {
		return jzlbdm;
	}

	public void setJzlbdm(String jzlbdm) {
		this.jzlbdm = jzlbdm;
	}

	public String getJzyydm() {
		return jzyydm;
	}

	public void setJzyydm(String jzyydm) {
		this.jzyydm = jzyydm;
	}

	public String getJz_ksrq01() {
		return jz_ksrq01;
	}

	public void setJz_ksrq01(String jz_ksrq01) {
		this.jz_ksrq01 = jz_ksrq01;
	}

	public String getYj_lksj() {
		return yj_lksj;
	}

	public void setYj_lksj(String yj_lksj) {
		this.yj_lksj = yj_lksj;
	}

	public String getSj_lksj() {
		return sj_lksj;
	}

	public void setSj_lksj(String sj_lksj) {
		this.sj_lksj = sj_lksj;
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

	public String getHjd_dzms() {
		return hjd_dzms;
	}

	public void setHjd_dzms(String hjd_dzms) {
		this.hjd_dzms = hjd_dzms;
	}

}
