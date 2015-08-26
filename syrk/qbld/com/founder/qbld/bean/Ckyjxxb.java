package com.founder.qbld.bean;

import java.io.Serializable;
import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.bean.Ckyjxxb.java]  
 * @ClassName:    [Ckyjxxb]   
 * @Description:  [常控预警信息表]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-4-13 上午9:59:20]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-13 上午9:59:20，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "QBLD_CK_YJXXB", pk = "yjxxbh")
public class Ckyjxxb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String dzms_zbx;
	private String dzms_zby;
	
	public String getDzms_zbx() {
		return dzms_zbx;
	}
	public void setDzms_zbx(String dzms_zbx) {
		this.dzms_zbx = dzms_zbx;
	}
	public String getDzms_zby() {
		return dzms_zby;
	}
	public void setDzms_zby(String dzms_zby) {
		this.dzms_zby = dzms_zby;
	}
	//数据来源
	private String sjly;
	//列管单位
	private String lgdw;
	
	public String getSjly() {
		return sjly;
	}
	public void setSjly(String sjly) {
		this.sjly = sjly;
	}
	public String getLgdw() {
		return lgdw;
	}
	public void setLgdw(String lgdw) {
		this.lgdw = lgdw;
	}
	//查询条件
	private String yjfbsjB;
	private String yjfbsjE;
	//返回签收信息
	private String qsdw;
	private String qsrxm;
	private String qssj;
	//实有人口基本信息
	private String mzdm;
	private String xbdm;
	private String jgssxdm;
	private String hjd_dzxz;
	private String jzd_dzxz;
	private String gxfjdm;
	private String gxpcsdm;
	private String gxzrqdm;
	@FieldDesc("照片")
	private byte[] zp;
	@FieldDesc("照片缩略图")
	private byte[] zpslt;
	//重点人员列管单位
	private String zdlgbmmc;
	//公安部重点人员有效性信息
	private String yxx;
	
	@FieldDesc("情报联动唯一编号")
	private String ldxxbh;
	@FieldDesc("预警信息编号")
	private String yjxxbh;
	@FieldDesc("发文字号")
	private String fwzh;
	@FieldDesc("预警接收单位,采用GA/Z 02 D3000")
	private String yjjsdw;
	@FieldDesc("预警接收地类型,预警情报信息接收地的类别，采用GA xxx.2中的“重点人员常控预警情报信息接收地类型代码”")
	private String yjjsdlx;
	@FieldDesc("预警级别 采用GA xxx.2中的重点人员预警级别代码")
	private String yjjb;
	@FieldDesc("签收时限 采用格式YYYYMMDDhhmmss，24小时格式")
	private String qssx;
	@FieldDesc("首次处置反馈时限,采用格式YYYYMMDDhhmmss，24小时格式")
	private String scczfksx;
	@FieldDesc("预警发布时间,采用格式YYYYMMDDhhmmss，24小时格式")
	private String yjfbsj;
	@FieldDesc("发布人姓名,签发预警信息的民警姓名，当按规则进行自动预警发布时为空")
	private String fbrxm;
	@FieldDesc("发布预警信息的公安机关，采用GA/Z 02 D3006")
	private String fbdw;
	@FieldDesc("发布单位机构代码 采发布单位机构代码,用GA/Z 02 D3000")
	private String fbdwjgdm;
	@FieldDesc("重点人员的唯一编号标识，采用GA xxx.2中的重点人员编号编码方法")
	private String zdrybh;
	@FieldDesc("重点人员类别标记 标记该人员当前所属的重点人员类别，可同时属于多个类别；其值参照采用GA xxx.2中的重点人员类别标记")
	private String zdrylbbj;
	@FieldDesc("重点人员细类 表示该人员当前所属的重点人员类别细类，采用GA xxx.2中的“重点人员细类代码”；可多值，以,间隔，最多表示最新的十种")
	private String zdryxl;
	@FieldDesc("重点人员姓名 采用GA/Z 02 D1001，不少于2个汉字，少数民族姓名间隔符用?")
	private String zdryxm;
	@FieldDesc("重点人员外文姓名 重点人员外文姓名")
	private String zdrywwxm;
	@FieldDesc("公民身份号码 填15或18位证号，采用GA/Z 02 D1000")
	private String sfzh;
	@FieldDesc("护照等主要有效身份证明证件号码")
	private String qtzjhm;
	@FieldDesc("动态信息类别 人员实名动态活动信息分类，采用GA XXX.2中的“动态实名信息类别代码”")
	private String dtxxlb;
	@FieldDesc("活动发生时间 活动发生时间,格式YYYYMMDDhhmmss，24小时格式")
	private String hdfssj;
	@FieldDesc("省市县(区) 活动发生地点区划,采用GA/Z 02 D4001")
	private String hdfsddqh;
	@FieldDesc("活动发生地点的详细地址")
	private String hdfsddxz;
	@FieldDesc("活动发生地点所处的社会场所")
	private String hdfsddssshcs;
	@FieldDesc("活动发生地点所属社会场所代码")
	private String hdfsddssshcsdm;
	@FieldDesc("活动发生地点所属的辖区公安机关，采用GA/Z 02 D3006")
	private String hdfsddssgajg;
	@FieldDesc("活动发生地点所属公安机关机构代码,采用GA/Z 02 D3000")
	private String hdfsddssgajgjgdm;
	@FieldDesc("活动发生时该人所持身份证明证件号码")
	private String djzjhm;
	@FieldDesc("活动发生时该人所持身份证明证件上的中文姓名")
	private String djxm;
	@FieldDesc("活动发生时该人所持身份证明证件上的性别，采用GA/Z 02 D1006")
	private String djxb;
	@FieldDesc("活动发生时该人所持身份证明证件上的出生日期，采用GA/Z 02 D1007，格式：YYYYMMDD")
	private String djcsrq;
	@FieldDesc("活动相关信息 业务活动的相关情况信息")
	private String hdxgxx;
	@FieldDesc("提供动态信息的公安机关单位，采用GA/Z 02 D3006")
	private String dtxxtgdw;
	@FieldDesc("动态信息提供单位机构代码,采用GA/Z 02 D3000")
	private String dtxxtgdwjgdm;
	@FieldDesc("信息比对时间，格式YYYYMMDDhhmmss，24小时格式")
	private String xxbdsj;
	@FieldDesc("执行信息比对处理的分（县）局以上公安机关，采用GA/Z 02 D3006")
	private String xxbddw;
	@FieldDesc("执行信息比对处理的分（县）局以上公安机关机构代码，采用GA/Z 02 D3000")
	private String xxbddwjgdm;
	@FieldDesc("发现重点人员动态活动轨迹信息的唯一编号标识，采用GA xxx.2中的重点人员动态轨迹信息编号编码方法")
	private String dtgjxxbh;
	@FieldDesc("备注")
	private String bz;
	@FieldDesc("积分信息,根据人员类别及积分模型进行计算得出的积分信息；具体内容格式见附录A")
	private String jfxx;
	@FieldDesc("签收反馈状态，1已签收，2已反馈")
	private String qsfkzt;
	@FieldDesc("入库时间")
	private String rksj;
	@FieldDesc("修改时间")
	private String xgsj;
	
	public byte[] getZp() {
		return zp;
	}
	public void setZp(byte[] zp) {
		this.zp = zp;
	}
	public byte[] getZpslt() {
		return zpslt;
	}
	public void setZpslt(byte[] zpslt) {
		this.zpslt = zpslt;
	}
	public String getYxx() {
		return yxx;
	}
	public void setYxx(String yxx) {
		this.yxx = yxx;
	}
	public String getYjfbsjB() {
		return yjfbsjB;
	}
	public void setYjfbsjB(String yjfbsjB) {
		this.yjfbsjB = yjfbsjB;
	}
	public String getYjfbsjE() {
		return yjfbsjE;
	}
	public void setYjfbsjE(String yjfbsjE) {
		this.yjfbsjE = yjfbsjE;
	}
	public String getQssj() {
		return qssj;
	}
	public void setQssj(String qssj) {
		this.qssj = qssj;
	}
	public String getQsdw() {
		return qsdw;
	}
	public void setQsdw(String qsdw) {
		this.qsdw = qsdw;
	}
	public String getQsrxm() {
		return qsrxm;
	}
	public void setQsrxm(String qsrxm) {
		this.qsrxm = qsrxm;
	}
	public String getLdxxbh() {
		return ldxxbh;
	}
	public void setLdxxbh(String ldxxbh) {
		this.ldxxbh = ldxxbh;
	}
	public String getYjxxbh() {
		return yjxxbh;
	}
	public void setYjxxbh(String yjxxbh) {
		this.yjxxbh = yjxxbh;
	}
	public String getFwzh() {
		return fwzh;
	}
	public void setFwzh(String fwzh) {
		this.fwzh = fwzh;
	}
	public String getYjjsdw() {
		return yjjsdw;
	}
	public void setYjjsdw(String yjjsdw) {
		this.yjjsdw = yjjsdw;
	}
	public String getYjjsdlx() {
		return yjjsdlx;
	}
	public void setYjjsdlx(String yjjsdlx) {
		this.yjjsdlx = yjjsdlx;
	}
	public String getYjjb() {
		return yjjb;
	}
	public void setYjjb(String yjjb) {
		this.yjjb = yjjb;
	}
	public String getQssx() {
		return qssx;
	}
	public void setQssx(String qssx) {
		this.qssx = qssx;
	}
	public String getScczfksx() {
		return scczfksx;
	}
	public void setScczfksx(String scczfksx) {
		this.scczfksx = scczfksx;
	}
	public String getYjfbsj() {
		return yjfbsj;
	}
	public void setYjfbsj(String yjfbsj) {
		this.yjfbsj = yjfbsj;
	}
	public String getFbrxm() {
		return fbrxm;
	}
	public void setFbrxm(String fbrxm) {
		this.fbrxm = fbrxm;
	}
	public String getFbdw() {
		return fbdw;
	}
	public void setFbdw(String fbdw) {
		this.fbdw = fbdw;
	}
	public String getFbdwjgdm() {
		return fbdwjgdm;
	}
	public void setFbdwjgdm(String fbdwjgdm) {
		this.fbdwjgdm = fbdwjgdm;
	}
	public String getZdrybh() {
		return zdrybh;
	}
	public void setZdrybh(String zdrybh) {
		this.zdrybh = zdrybh;
	}
	public String getZdrylbbj() {
		return zdrylbbj;
	}
	public void setZdrylbbj(String zdrylbbj) {
		this.zdrylbbj = zdrylbbj;
	}
	public String getZdryxl() {
		return zdryxl;
	}
	public void setZdryxl(String zdryxl) {
		this.zdryxl = zdryxl;
	}
	public String getZdryxm() {
		return zdryxm;
	}
	public void setZdryxm(String zdryxm) {
		this.zdryxm = zdryxm;
	}
	public String getZdrywwxm() {
		return zdrywwxm;
	}
	public void setZdrywwxm(String zdrywwxm) {
		this.zdrywwxm = zdrywwxm;
	}
	public String getSfzh() {
		return sfzh;
	}
	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}
	public String getQtzjhm() {
		return qtzjhm;
	}
	public void setQtzjhm(String qtzjhm) {
		this.qtzjhm = qtzjhm;
	}
	public String getDtxxlb() {
		return dtxxlb;
	}
	public void setDtxxlb(String dtxxlb) {
		this.dtxxlb = dtxxlb;
	}
	public String getHdfssj() {
		return hdfssj;
	}
	public void setHdfssj(String hdfssj) {
		this.hdfssj = hdfssj;
	}
	public String getHdfsddqh() {
		return hdfsddqh;
	}
	public void setHdfsddqh(String hdfsddqh) {
		this.hdfsddqh = hdfsddqh;
	}
	public String getHdfsddxz() {
		return hdfsddxz;
	}
	public void setHdfsddxz(String hdfsddxz) {
		this.hdfsddxz = hdfsddxz;
	}
	public String getHdfsddssshcs() {
		return hdfsddssshcs;
	}
	public void setHdfsddssshcs(String hdfsddssshcs) {
		this.hdfsddssshcs = hdfsddssshcs;
	}
	public String getHdfsddssshcsdm() {
		return hdfsddssshcsdm;
	}
	public void setHdfsddssshcsdm(String hdfsddssshcsdm) {
		this.hdfsddssshcsdm = hdfsddssshcsdm;
	}
	public String getHdfsddssgajg() {
		return hdfsddssgajg;
	}
	public void setHdfsddssgajg(String hdfsddssgajg) {
		this.hdfsddssgajg = hdfsddssgajg;
	}
	public String getHdfsddssgajgjgdm() {
		return hdfsddssgajgjgdm;
	}
	public void setHdfsddssgajgjgdm(String hdfsddssgajgjgdm) {
		this.hdfsddssgajgjgdm = hdfsddssgajgjgdm;
	}
	public String getDjzjhm() {
		return djzjhm;
	}
	public void setDjzjhm(String djzjhm) {
		this.djzjhm = djzjhm;
	}
	public String getDjxm() {
		return djxm;
	}
	public void setDjxm(String djxm) {
		this.djxm = djxm;
	}
	public String getDjxb() {
		return djxb;
	}
	public void setDjxb(String djxb) {
		this.djxb = djxb;
	}
	public String getDjcsrq() {
		return djcsrq;
	}
	public void setDjcsrq(String djcsrq) {
		this.djcsrq = djcsrq;
	}
	public String getHdxgxx() {
		return hdxgxx;
	}
	public void setHdxgxx(String hdxgxx) {
		this.hdxgxx = hdxgxx;
	}
	public String getDtxxtgdw() {
		return dtxxtgdw;
	}
	public void setDtxxtgdw(String dtxxtgdw) {
		this.dtxxtgdw = dtxxtgdw;
	}
	public String getDtxxtgdwjgdm() {
		return dtxxtgdwjgdm;
	}
	public void setDtxxtgdwjgdm(String dtxxtgdwjgdm) {
		this.dtxxtgdwjgdm = dtxxtgdwjgdm;
	}
	public String getXxbdsj() {
		return xxbdsj;
	}
	public void setXxbdsj(String xxbdsj) {
		this.xxbdsj = xxbdsj;
	}
	public String getXxbddw() {
		return xxbddw;
	}
	public void setXxbddw(String xxbddw) {
		this.xxbddw = xxbddw;
	}
	public String getXxbddwjgdm() {
		return xxbddwjgdm;
	}
	public void setXxbddwjgdm(String xxbddwjgdm) {
		this.xxbddwjgdm = xxbddwjgdm;
	}
	public String getDtgjxxbh() {
		return dtgjxxbh;
	}
	public void setDtgjxxbh(String dtgjxxbh) {
		this.dtgjxxbh = dtgjxxbh;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getJfxx() {
		return jfxx;
	}
	public void setJfxx(String jfxx) {
		this.jfxx = jfxx;
	}
	public String getQsfkzt() {
		return qsfkzt;
	}
	public void setQsfkzt(String qsfkzt) {
		this.qsfkzt = qsfkzt;
	}
	public String getRksj() {
		return rksj;
	}
	public void setRksj(String rksj) {
		this.rksj = rksj;
	}
	public String getXgsj() {
		return xgsj;
	}
	public void setXgsj(String xgsj) {
		this.xgsj = xgsj;
	}
	public String getZdlgbmmc() {
		return zdlgbmmc;
	}
	public void setZdlgbmmc(String zdlgbmmc) {
		this.zdlgbmmc = zdlgbmmc;
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
	public String getJgssxdm() {
		return jgssxdm;
	}
	public void setJgssxdm(String jgssxdm) {
		this.jgssxdm = jgssxdm;
	}
	public String getHjd_dzxz() {
		return hjd_dzxz;
	}
	public void setHjd_dzxz(String hjd_dzxz) {
		this.hjd_dzxz = hjd_dzxz;
	}
	public String getJzd_dzxz() {
		return jzd_dzxz;
	}
	public void setJzd_dzxz(String jzd_dzxz) {
		this.jzd_dzxz = jzd_dzxz;
	}
	public String getGxfjdm() {
		return gxfjdm;
	}
	public void setGxfjdm(String gxfjdm) {
		this.gxfjdm = gxfjdm;
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
}
