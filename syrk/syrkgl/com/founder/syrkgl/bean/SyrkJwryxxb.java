package com.founder.syrkgl.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/******************************************************************************
 * @Package: [com.founder.syrkgl.bean.SyrkJwryxxb.java]
 * @ClassName: [SyrkJwryxxb]
 * @Description: [境外人员信息表]
 * @Author: [hongguanjun]
 * @CreateDate: [2015-4-2 下午3:08:55]
 * @UpdateUser: [hongguanjun(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-4-2 下午3:08:55，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@DBInfoAnnotation(tableName = "SYRK_JWRYXXB", pk = "id")
public class SyrkJwryxxb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@FieldDesc("实有人口ID")
	private String id;
	@FieldDesc("人员ID")
	private String ryid;
	@FieldDesc("证件种类")
	private String cyzjdm;
	@FieldDesc("证件号码")
	private String zjhm;
	@FieldDesc("外文姓")
	private String wwx;
	@FieldDesc("外文名")
	private String wwm;
	@FieldDesc("中文姓名")
	private String xm;
	@FieldDesc("中文姓名汉语拼音")
	private String zwxmhypy;
	@FieldDesc("中文姓名汉语简拼")
	private String zwxmhyjp;
	@FieldDesc("国籍代码")
	private String gjdm;
	@FieldDesc("性别代码")
	private String xbdm;
	@FieldDesc("出生日期")
	private String csrq;
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
	@FieldDesc("签证（居留许可）种类")
	private String qzjlxkzldm;
	@FieldDesc("签证（居留许可）号")
	private String qzjlxkh;
	@FieldDesc("证件_截止日期")
	private String zj_jzrq;
	@FieldDesc("签证（居留许可）签发机关")
	private String qzjlxkqfjgmc;
	@FieldDesc("签证（居留许可）_截止日期")
	private String qzjlxk_jzrq;
	@FieldDesc("签证停（居）留_截止日期")
	private String qztjl_jzrq;
	@FieldDesc("联系电话")
	private String lxdh;
	@FieldDesc("暂（居）住事由")
	private String zjzsydm;
	@FieldDesc("暂（居）住处所")
	private String zjzcsfldm;
	@FieldDesc("住宿日期")
	private String zsrq;
	@FieldDesc("常住标识")
	private String jwryczbs;
	@FieldDesc("入境口岸")
	private String rjkadm;
	@FieldDesc("入境日期")
	private String rjrq;
	@FieldDesc("拟离开日期")
	private String nlkrq;
	@FieldDesc("来自国家（地区）")
	private String lzgjdqdm;
	@FieldDesc("外国人居留事由代码")
	private String wgrjlsydm;
	@FieldDesc("境外人员入境事由代码")
	private String jwryrjsydm;
	@FieldDesc("境外人员入境登记身份代码")
	private String jwryrjdjsfdm;
	@FieldDesc("工作许可登记")
	private String gzxkdj;
	@FieldDesc("工作单位_单位ID")
	private String gzdw_dwid;
	@FieldDesc("工作单位_单位名称")
	private String gzdw_dwmc;
	@FieldDesc("工作单位_联系电话")
	private String gzdw_lxdh;
	@FieldDesc("留宿单位_单位ID")
	private String lsdw_dwid;
	@FieldDesc("留宿单位_单位名称")
	private String lsdw_dwmc;
	@FieldDesc("留宿单位_联系电话")
	private String lsdw_lxdh;
	@FieldDesc("接待单位_单位ID")
	private String jddw_dwid;
	@FieldDesc("接待单位_单位名称")
	private String jddw_dwmc;
	@FieldDesc("接待单位_联系电话")
	private String jddw_lxdh;
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
	@FieldDesc("是否非法入境代码")
	private String sfffrjdm;
	@FieldDesc("是否非法居留代码")
	private String sfffjldm;
	@FieldDesc("是否非法就业")
	private String sfffjy;
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

	public String getZwxmhypy() {
		return zwxmhypy;
	}

	public void setZwxmhypy(String zwxmhypy) {
		this.zwxmhypy = zwxmhypy;
	}

	public String getZwxmhyjp() {
		return zwxmhyjp;
	}

	public void setZwxmhyjp(String zwxmhyjp) {
		this.zwxmhyjp = zwxmhyjp;
	}

	public String getGjdm() {
		return gjdm;
	}

	public void setGjdm(String gjdm) {
		this.gjdm = gjdm;
	}

	public String getXbdm() {
		return xbdm;
	}

	public void setXbdm(String xbdm) {
		this.xbdm = xbdm;
	}

	public String getCsrq() {
		return csrq;
	}

	public void setCsrq(String csrq) {
		this.csrq = csrq;
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

	public String getQzjlxkzldm() {
		return qzjlxkzldm;
	}

	public void setQzjlxkzldm(String qzjlxkzldm) {
		this.qzjlxkzldm = qzjlxkzldm;
	}

	public String getQzjlxkh() {
		return qzjlxkh;
	}

	public void setQzjlxkh(String qzjlxkh) {
		this.qzjlxkh = qzjlxkh;
	}

	public String getZj_jzrq() {
		return zj_jzrq;
	}

	public void setZj_jzrq(String zj_jzrq) {
		this.zj_jzrq = zj_jzrq;
	}

	public String getQzjlxkqfjgmc() {
		return qzjlxkqfjgmc;
	}

	public void setQzjlxkqfjgmc(String qzjlxkqfjgmc) {
		this.qzjlxkqfjgmc = qzjlxkqfjgmc;
	}

	public String getQzjlxk_jzrq() {
		return qzjlxk_jzrq;
	}

	public void setQzjlxk_jzrq(String qzjlxk_jzrq) {
		this.qzjlxk_jzrq = qzjlxk_jzrq;
	}

	public String getQztjl_jzrq() {
		return qztjl_jzrq;
	}

	public void setQztjl_jzrq(String qztjl_jzrq) {
		this.qztjl_jzrq = qztjl_jzrq;
	}

	public String getLxdh() {
		return lxdh;
	}

	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
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

	public String getZsrq() {
		return zsrq;
	}

	public void setZsrq(String zsrq) {
		this.zsrq = zsrq;
	}

	public String getJwryczbs() {
		return jwryczbs;
	}

	public void setJwryczbs(String jwryczbs) {
		this.jwryczbs = jwryczbs;
	}

	public String getRjkadm() {
		return rjkadm;
	}

	public void setRjkadm(String rjkadm) {
		this.rjkadm = rjkadm;
	}

	public String getRjrq() {
		return rjrq;
	}

	public void setRjrq(String rjrq) {
		this.rjrq = rjrq;
	}

	public String getNlkrq() {
		return nlkrq;
	}

	public void setNlkrq(String nlkrq) {
		this.nlkrq = nlkrq;
	}

	public String getLzgjdqdm() {
		return lzgjdqdm;
	}

	public void setLzgjdqdm(String lzgjdqdm) {
		this.lzgjdqdm = lzgjdqdm;
	}

	public String getWgrjlsydm() {
		return wgrjlsydm;
	}

	public void setWgrjlsydm(String wgrjlsydm) {
		this.wgrjlsydm = wgrjlsydm;
	}

	public String getJwryrjsydm() {
		return jwryrjsydm;
	}

	public void setJwryrjsydm(String jwryrjsydm) {
		this.jwryrjsydm = jwryrjsydm;
	}

	public String getJwryrjdjsfdm() {
		return jwryrjdjsfdm;
	}

	public void setJwryrjdjsfdm(String jwryrjdjsfdm) {
		this.jwryrjdjsfdm = jwryrjdjsfdm;
	}

	public String getGzxkdj() {
		return gzxkdj;
	}

	public void setGzxkdj(String gzxkdj) {
		this.gzxkdj = gzxkdj;
	}

	public String getGzdw_dwid() {
		return gzdw_dwid;
	}

	public void setGzdw_dwid(String gzdw_dwid) {
		this.gzdw_dwid = gzdw_dwid;
	}

	public String getGzdw_dwmc() {
		return gzdw_dwmc;
	}

	public void setGzdw_dwmc(String gzdw_dwmc) {
		this.gzdw_dwmc = gzdw_dwmc;
	}

	public String getGzdw_lxdh() {
		return gzdw_lxdh;
	}

	public void setGzdw_lxdh(String gzdw_lxdh) {
		this.gzdw_lxdh = gzdw_lxdh;
	}

	public String getLsdw_dwid() {
		return lsdw_dwid;
	}

	public void setLsdw_dwid(String lsdw_dwid) {
		this.lsdw_dwid = lsdw_dwid;
	}

	public String getLsdw_dwmc() {
		return lsdw_dwmc;
	}

	public void setLsdw_dwmc(String lsdw_dwmc) {
		this.lsdw_dwmc = lsdw_dwmc;
	}

	public String getLsdw_lxdh() {
		return lsdw_lxdh;
	}

	public void setLsdw_lxdh(String lsdw_lxdh) {
		this.lsdw_lxdh = lsdw_lxdh;
	}

	public String getJddw_dwid() {
		return jddw_dwid;
	}

	public void setJddw_dwid(String jddw_dwid) {
		this.jddw_dwid = jddw_dwid;
	}

	public String getJddw_dwmc() {
		return jddw_dwmc;
	}

	public void setJddw_dwmc(String jddw_dwmc) {
		this.jddw_dwmc = jddw_dwmc;
	}

	public String getJddw_lxdh() {
		return jddw_lxdh;
	}

	public void setJddw_lxdh(String jddw_lxdh) {
		this.jddw_lxdh = jddw_lxdh;
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

	public String getSfffrjdm() {
		return sfffrjdm;
	}

	public void setSfffrjdm(String sfffrjdm) {
		this.sfffrjdm = sfffrjdm;
	}

	public String getSfffjldm() {
		return sfffjldm;
	}

	public void setSfffjldm(String sfffjldm) {
		this.sfffjldm = sfffjldm;
	}

	public String getSfffjy() {
		return sfffjy;
	}

	public void setSfffjy(String sfffjy) {
		this.sfffjy = sfffjy;
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
