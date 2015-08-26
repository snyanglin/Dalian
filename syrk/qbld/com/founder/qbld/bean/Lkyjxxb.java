package com.founder.qbld.bean;

import java.io.Serializable;
import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.bean.Lkyjxxb.java]  
 * @ClassName:    [Lkyjxxb]   
 * @Description:  [临空预警信息表]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-4-22 上午9:47:19]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-22 上午9:47:19，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "QBLD_LK_YJXXB", pk = "lkzlbh")
public class Lkyjxxb extends BaseEntity implements Serializable {

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
	
	private String zlfbsjB;
	private String zlfbsjE;
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
	
	@FieldDesc("情报联动唯一编号")
	private String ldxxbh;
	@FieldDesc("临控指令编号")
	private String lkzlbh;
	@FieldDesc("发文字号")
	private String fwzh;
	@FieldDesc("指令接收单位,采用GA/Z 02 D3000")
	private String zljsdw;
	@FieldDesc("签收时限 采用格式YYYYMMDDhhmmss，24小时格式")
	private String qssx;
	@FieldDesc("首次处置反馈时限,采用格式YYYYMMDDhhmmss，24小时格式")
	private String scczfksx;
	@FieldDesc("指令发布时间,采用格式YYYYMMDDhhmmss，24小时格式")
	private String zlfbsj;
	@FieldDesc("发布人姓名,签发预警信息的民警姓名，当按规则进行自动预警发布时为空")
	private String fbrxm;
	@FieldDesc("发布指令信息的公安机关，采用GA/Z 02 D3006")
	private String fbzrdw;
	@FieldDesc("发布单位机构代码 采发布单位机构代码,用GA/Z 02 D3000")
	private String fbzrdwjgdm;
	@FieldDesc("被布控人姓名")
	private String bbkrxm;
	@FieldDesc("被布控人证件号码")
	private String bbkrzjhm;
	@FieldDesc("被布控人性别")
	private String bbkrxb;
	@FieldDesc("被布控人出什么日期，YYYMMDD")
	private String bbkrcsrq;
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
	@FieldDesc("活动发生地点所属的辖区公安机关机构代码")
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
	@FieldDesc("签收反馈状态，1已签收，2已反馈")
	private String qsfkzt;
	@FieldDesc("入库时间")
	private String rksj;
	@FieldDesc("修改时间")
	private String xgsj;
	@FieldDesc("临控指令类型")
	private String lkzllx;
	@FieldDesc("临控指令级别")
	private String lkzljb;
	@FieldDesc("申请人身份证好")
	private String sqrsfzh;
	@FieldDesc("申请人姓名")
	private String sqrxm;
	@FieldDesc("申请人联系电话")
	private String sqrlxdh;
	@FieldDesc("申请单位")
	private String sqdw;
	@FieldDesc("申请单位代码")
	private String sqdwjgdm;
	@FieldDesc("原临控指令编号")
	private String ylkzlbh;
	@FieldDesc("被布控人证件种类")
	private String bbkrzjlx;
	@FieldDesc("被布控人其他特征信息")
	private String bbkrqttzxx;
	@FieldDesc("登记证件种类")
	private String djzjlx;
	@FieldDesc("处置措施要求")
	private String czcsyq;
	@FieldDesc("执法依据")
	private String zfyj;
	
	public String getLdxxbh() {
		return ldxxbh;
	}
	public void setLdxxbh(String ldxxbh) {
		this.ldxxbh = ldxxbh;
	}
	public String getLkzlbh() {
		return lkzlbh;
	}
	public void setLkzlbh(String lkzlbh) {
		this.lkzlbh = lkzlbh;
	}
	public String getFwzh() {
		return fwzh;
	}
	public void setFwzh(String fwzh) {
		this.fwzh = fwzh;
	}
	public String getZljsdw() {
		return zljsdw;
	}
	public void setZljsdw(String zljsdw) {
		this.zljsdw = zljsdw;
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
	public String getZlfbsj() {
		return zlfbsj;
	}
	public void setZlfbsj(String zlfbsj) {
		this.zlfbsj = zlfbsj;
	}
	public String getFbrxm() {
		return fbrxm;
	}
	public void setFbrxm(String fbrxm) {
		this.fbrxm = fbrxm;
	}
	public String getFbzrdw() {
		return fbzrdw;
	}
	public void setFbzrdw(String fbzrdw) {
		this.fbzrdw = fbzrdw;
	}
	public String getFbzrdwjgdm() {
		return fbzrdwjgdm;
	}
	public void setFbzrdwjgdm(String fbzrdwjgdm) {
		this.fbzrdwjgdm = fbzrdwjgdm;
	}
	public String getBbkrxm() {
		return bbkrxm;
	}
	public void setBbkrxm(String bbkrxm) {
		this.bbkrxm = bbkrxm;
	}
	public String getBbkrzjhm() {
		return bbkrzjhm;
	}
	public void setBbkrzjhm(String bbkrzjhm) {
		this.bbkrzjhm = bbkrzjhm;
	}
	public String getBbkrxb() {
		return bbkrxb;
	}
	public void setBbkrxb(String bbkrxb) {
		this.bbkrxb = bbkrxb;
	}
	public String getBbkrcsrq() {
		return bbkrcsrq;
	}
	public void setBbkrcsrq(String bbkrcsrq) {
		this.bbkrcsrq = bbkrcsrq;
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
	public String getLkzllx() {
		return lkzllx;
	}
	public void setLkzllx(String lkzllx) {
		this.lkzllx = lkzllx;
	}
	public String getLkzljb() {
		return lkzljb;
	}
	public void setLkzljb(String lkzljb) {
		this.lkzljb = lkzljb;
	}
	public String getSqrsfzh() {
		return sqrsfzh;
	}
	public void setSqrsfzh(String sqrsfzh) {
		this.sqrsfzh = sqrsfzh;
	}
	public String getSqrxm() {
		return sqrxm;
	}
	public void setSqrxm(String sqrxm) {
		this.sqrxm = sqrxm;
	}
	public String getSqrlxdh() {
		return sqrlxdh;
	}
	public void setSqrlxdh(String sqrlxdh) {
		this.sqrlxdh = sqrlxdh;
	}
	public String getSqdw() {
		return sqdw;
	}
	public void setSqdw(String sqdw) {
		this.sqdw = sqdw;
	}
	public String getSqdwjgdm() {
		return sqdwjgdm;
	}
	public void setSqdwjgdm(String sqdwjgdm) {
		this.sqdwjgdm = sqdwjgdm;
	}
	public String getYlkzlbh() {
		return ylkzlbh;
	}
	public void setYlkzlbh(String ylkzlbh) {
		this.ylkzlbh = ylkzlbh;
	}
	public String getBbkrzjlx() {
		return bbkrzjlx;
	}
	public void setBbkrzjlx(String bbkrzjlx) {
		this.bbkrzjlx = bbkrzjlx;
	}
	public String getBbkrqttzxx() {
		return bbkrqttzxx;
	}
	public void setBbkrqttzxx(String bbkrqttzxx) {
		this.bbkrqttzxx = bbkrqttzxx;
	}
	public String getDjzjlx() {
		return djzjlx;
	}
	public void setDjzjlx(String djzjlx) {
		this.djzjlx = djzjlx;
	}
	public String getCzcsyq() {
		return czcsyq;
	}
	public void setCzcsyq(String czcsyq) {
		this.czcsyq = czcsyq;
	}
	public String getZfyj() {
		return zfyj;
	}
	public void setZfyj(String zfyj) {
		this.zfyj = zfyj;
	}
	public String getZlfbsjB() {
		return zlfbsjB;
	}
	public void setZlfbsjB(String zlfbsjB) {
		this.zlfbsjB = zlfbsjB;
	}
	public String getZlfbsjE() {
		return zlfbsjE;
	}
	public void setZlfbsjE(String zlfbsjE) {
		this.zlfbsjE = zlfbsjE;
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
}
