package com.founder.qbld.bean;

import java.io.Serializable;
import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.bean.Lkyjzlb.java]  
 * @ClassName:    [Lkyjzlb]   
 * @Description:  [临控预警指令表]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-4-27 下午1:43:03]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-27 下午1:43:03，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "QBLD_LK_ZLXXB", pk = "lkzlbh")
public class Lkyjzlb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

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
		
	@FieldDesc("情报联动唯一编号")
	private String ldxxbh;
	@FieldDesc("临控指令编号")
	private String lkzlbh;
	@FieldDesc("发文字号")
	private String fwzh;
	@FieldDesc("临控指令类型")
	private String lkzllx;
	@FieldDesc("临控指令级别")
	private String lkzljb;
	@FieldDesc("指令接收单位")
	private String zljsdw;
	@FieldDesc("申请人身份证号")
	private String sqrsfzh;
	@FieldDesc("申请人姓名")
	private String sqrxm;
	@FieldDesc("申请人联系电话")
	private String sqrlxdh;
	@FieldDesc("申请单位")
	private String sqdw;
	@FieldDesc("申请单位机构代码")
	private String sqdwjgdm;
	@FieldDesc("指令发布时间")
	private String zlfbsj;
	@FieldDesc("发布人姓名")
	private String fbrxm;
	@FieldDesc("发布责任单位")
	private String fbzrdw;
	@FieldDesc("发布责任单位机构代码")
	private String fbzrdwjgdm;
	@FieldDesc("原临控指令编号")
	private String ylkzlbh;
	@FieldDesc("布控撤控事由")
	private String bxcksy;
	@FieldDesc("布控地域范围")
	private String bkdyfw;
	@FieldDesc("布控天数")
	private Long bkts;
	@FieldDesc("布控起始时间")
	private String bkqssj;
	@FieldDesc("布控截止时间")
	private String bkjzsj;
	@FieldDesc("被布控人证件类型")
	private String bbkrzjlx;
	@FieldDesc("被布控人证件号码")
	private String bbkrzjhm;
	@FieldDesc("被布控人姓名")
	private String bbkrxm;
	@FieldDesc("被布控人性别")
	private String bbkrxb;
	@FieldDesc("被布控人出生日期")
	private String bbkrcsrq;
	@FieldDesc("被布控人其他特征信息")
	private String bbkrqttzxx;
	@FieldDesc("签收时限")
	private String qssx;
	@FieldDesc("首次处置反馈时限")
	private String scczfksx;
	@FieldDesc("处置措施")
	private String czcsyq;
	@FieldDesc("执法依据")
	private String zfyj;
	@FieldDesc("备注")
	private String bz;
	@FieldDesc("签收反馈状态")
	private String qsfkzt;
	
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
	public String getZljsdw() {
		return zljsdw;
	}
	public void setZljsdw(String zljsdw) {
		this.zljsdw = zljsdw;
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
	public String getYlkzlbh() {
		return ylkzlbh;
	}
	public void setYlkzlbh(String ylkzlbh) {
		this.ylkzlbh = ylkzlbh;
	}
	public String getBxcksy() {
		return bxcksy;
	}
	public void setBxcksy(String bxcksy) {
		this.bxcksy = bxcksy;
	}
	public String getBkdyfw() {
		return bkdyfw;
	}
	public void setBkdyfw(String bkdyfw) {
		this.bkdyfw = bkdyfw;
	}
	public Long getBkts() {
		return bkts;
	}
	public void setBkts(Long bkts) {
		this.bkts = bkts;
	}
	public String getBkqssj() {
		return bkqssj;
	}
	public void setBkqssj(String bkqssj) {
		this.bkqssj = bkqssj;
	}
	public String getBkjzsj() {
		return bkjzsj;
	}
	public void setBkjzsj(String bkjzsj) {
		this.bkjzsj = bkjzsj;
	}
	public String getBbkrzjlx() {
		return bbkrzjlx;
	}
	public void setBbkrzjlx(String bbkrzjlx) {
		this.bbkrzjlx = bbkrzjlx;
	}
	public String getBbkrzjhm() {
		return bbkrzjhm;
	}
	public void setBbkrzjhm(String bbkrzjhm) {
		this.bbkrzjhm = bbkrzjhm;
	}
	public String getBbkrxm() {
		return bbkrxm;
	}
	public void setBbkrxm(String bbkrxm) {
		this.bbkrxm = bbkrxm;
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
	public String getBbkrqttzxx() {
		return bbkrqttzxx;
	}
	public void setBbkrqttzxx(String bbkrqttzxx) {
		this.bbkrqttzxx = bbkrqttzxx;
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
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getQsfkzt() {
		return qsfkzt;
	}
	public void setQsfkzt(String qsfkzt) {
		this.qsfkzt = qsfkzt;
	}

	
	
}
