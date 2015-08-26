package com.founder.qbld.bean;

import java.io.Serializable;
import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.bean.Ckyjzlb.java]  
 * @ClassName:    [Ckyjzlb]   
 * @Description:  [指令预警信息表]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-6-8 上午9:38:48]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-8 上午9:38:48，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "QBLD_CK_ZLXXB", pk = "yjzlbh")
public class Ckyjzlb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private String fbsjB;
	private String fbsjE;
	//返回签收信息
	private String qsdw_mc;
	private String qsrxm;
	private String qsrq;
	//实有人口基本信息
	private String mzdm;
	private String xbdm;
	private String jgssxdm;
	private String hjd_dzxz;
	private String jzd_dzxz;
	private String gxfjdm;
	private String gxpcsdm;
	private String gxzrqdm;
		
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
	public String getQsrq() {
		return qsrq;
	}
	public void setQsrq(String qsrq) {
		this.qsrq = qsrq;
	}
	public String getQsdw_mc() {
		return qsdw_mc;
	}
	public void setQsdw_mc(String qsdw_mc) {
		this.qsdw_mc = qsdw_mc;
	}
	public String getQsrxm() {
		return qsrxm;
	}
	public void setQsrxm(String qsrxm) {
		this.qsrxm = qsrxm;
	}

	@FieldDesc("情报平台 序号(GUID)")
	private String id;
	@FieldDesc("预警指令编号")
	private String yjzlbh;
	@FieldDesc("预警信息编号(逗号隔开)")
	private String yjxxbh;
	@FieldDesc("预警指令标题")
	private String zlbt;
	@FieldDesc("研判意见")
	private String ypyj;
	@FieldDesc("指令级别")
	private String zljb;
	@FieldDesc("下发接受单位（多个单位逗号隔开，并且去双位0）")
	private String xfjsdw;
	@FieldDesc("指令发布人姓名")
	private String zlfbrxm;
	@FieldDesc("指令发布单位名称")
	private String zlfbdw_mc;
	@FieldDesc("指令发布单位代码")
	private String zlfbdw_dm;
	@FieldDesc("指令发布时间")
	private String fbsj;
	@FieldDesc("是否签收(0：否 1：是)")
	private String sfqs;
	@FieldDesc("签收时间")
	private String qssj;
	@FieldDesc("是否反馈(0：否，2：已反馈)")
	private String sffk;
	@FieldDesc("反馈时间")
	private String fksj;
	@FieldDesc("签收时限")
	private String qssx;
	@FieldDesc("反馈时限")
	private String fksx;
	@FieldDesc("下发区域(0：不下发 不等于0 下发)")
	private String xfqy;
	@FieldDesc("下发状态(0:未下发,1:已下发,2:下发中)")
	private String b_xfzt;
	@FieldDesc("依据预警信息编号,可多值，用半角逗号隔开，最多10个值。")
	private String yjyjxxbh;
	@FieldDesc("依据处置反馈信息编号,可多值，用半角逗号隔开，最多10个值。")
	private String yjczfkxxbh;
	@FieldDesc("wdt是否上报（0:未发送,1:已发送,2:发送中,3:无法发送,4:发送失败）")
	private String b_sfsb;
	@FieldDesc("上级预警指令编号")
	private String sj_yjzlbh;
	@FieldDesc("根预警指令编号")
	private String root_yjzlbh;
	@FieldDesc("审核状态 1：未提交，2：审核中，3：审核未通过，4：审核通过")
	private String shzt;
	@FieldDesc("下发警种")
	private String xfjz;
	@FieldDesc("是否允许反馈（0：允许，1不允许)")
	private String sfyxfk;
	@FieldDesc("研判时间")
	private String ypsj;
	@FieldDesc("研判时限")
	private String ypsx;
	@FieldDesc("是否研判（0：否，1：是）")
	private String sfyp;
	@FieldDesc("是否发送至警综(0:未发送,1:已发送,2:发送失败)")
	private String sendtojz;
	@FieldDesc("当前状态")
	private String qsfkzt;
	@FieldDesc("是否特殊指标（0：否，1：是）")
	private String sftszb;
	@FieldDesc("特殊指标模型")
	private String tszbmx;
	@FieldDesc("研判结论")
	private String ypjl;
	@FieldDesc("查控要求")
	private String ckyq;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getYjzlbh() {
		return yjzlbh;
	}
	public void setYjzlbh(String yjzlbh) {
		this.yjzlbh = yjzlbh;
	}
	public String getYjxxbh() {
		return yjxxbh;
	}
	public void setYjxxbh(String yjxxbh) {
		this.yjxxbh = yjxxbh;
	}
	public String getZlbt() {
		return zlbt;
	}
	public void setZlbt(String zlbt) {
		this.zlbt = zlbt;
	}
	public String getYpyj() {
		return ypyj;
	}
	public void setYpyj(String ypyj) {
		this.ypyj = ypyj;
	}
	public String getZljb() {
		return zljb;
	}
	public void setZljb(String zljb) {
		this.zljb = zljb;
	}
	public String getXfjsdw() {
		return xfjsdw;
	}
	public void setXfjsdw(String xfjsdw) {
		this.xfjsdw = xfjsdw;
	}
	public String getZlfbrxm() {
		return zlfbrxm;
	}
	public void setZlfbrxm(String zlfbrxm) {
		this.zlfbrxm = zlfbrxm;
	}
	public String getZlfbdw_mc() {
		return zlfbdw_mc;
	}
	public void setZlfbdw_mc(String zlfbdw_mc) {
		this.zlfbdw_mc = zlfbdw_mc;
	}
	public String getZlfbdw_dm() {
		return zlfbdw_dm;
	}
	public void setZlfbdw_dm(String zlfbdw_dm) {
		this.zlfbdw_dm = zlfbdw_dm;
	}
	public String getFbsj() {
		return fbsj;
	}
	public void setFbsj(String fbsj) {
		this.fbsj = fbsj;
	}
	public String getSfqs() {
		return sfqs;
	}
	public void setSfqs(String sfqs) {
		this.sfqs = sfqs;
	}
	public String getQssj() {
		return qssj;
	}
	public void setQssj(String qssj) {
		this.qssj = qssj;
	}
	public String getSffk() {
		return sffk;
	}
	public void setSffk(String sffk) {
		this.sffk = sffk;
	}
	public String getFksj() {
		return fksj;
	}
	public void setFksj(String fksj) {
		this.fksj = fksj;
	}
	public String getQssx() {
		return qssx;
	}
	public void setQssx(String qssx) {
		this.qssx = qssx;
	}
	public String getFksx() {
		return fksx;
	}
	public void setFksx(String fksx) {
		this.fksx = fksx;
	}
	public String getXfqy() {
		return xfqy;
	}
	public void setXfqy(String xfqy) {
		this.xfqy = xfqy;
	}
	public String getYjyjxxbh() {
		return yjyjxxbh;
	}
	public void setYjyjxxbh(String yjyjxxbh) {
		this.yjyjxxbh = yjyjxxbh;
	}
	public String getYjczfkxxbh() {
		return yjczfkxxbh;
	}
	public void setYjczfkxxbh(String yjczfkxxbh) {
		this.yjczfkxxbh = yjczfkxxbh;
	}
	public String getShzt() {
		return shzt;
	}
	public void setShzt(String shzt) {
		this.shzt = shzt;
	}
	public String getXfjz() {
		return xfjz;
	}
	public void setXfjz(String xfjz) {
		this.xfjz = xfjz;
	}
	public String getSfyxfk() {
		return sfyxfk;
	}
	public void setSfyxfk(String sfyxfk) {
		this.sfyxfk = sfyxfk;
	}
	public String getYpsj() {
		return ypsj;
	}
	public void setYpsj(String ypsj) {
		this.ypsj = ypsj;
	}
	public String getYpsx() {
		return ypsx;
	}
	public void setYpsx(String ypsx) {
		this.ypsx = ypsx;
	}
	public String getSfyp() {
		return sfyp;
	}
	public void setSfyp(String sfyp) {
		this.sfyp = sfyp;
	}
	public String getSendtojz() {
		return sendtojz;
	}
	public void setSendtojz(String sendtojz) {
		this.sendtojz = sendtojz;
	}
	public String getFbsjB() {
		return fbsjB;
	}
	public void setFbsjB(String fbsjB) {
		this.fbsjB = fbsjB;
	}
	public String getFbsjE() {
		return fbsjE;
	}
	public void setFbsjE(String fbsjE) {
		this.fbsjE = fbsjE;
	}
	public String getQsfkzt() {
		return qsfkzt;
	}
	public void setQsfkzt(String qsfkzt) {
		this.qsfkzt = qsfkzt;
	}
	public String getB_xfzt() {
		return b_xfzt;
	}
	public void setB_xfzt(String b_xfzt) {
		this.b_xfzt = b_xfzt;
	}
	public String getB_sfsb() {
		return b_sfsb;
	}
	public void setB_sfsb(String b_sfsb) {
		this.b_sfsb = b_sfsb;
	}
	public String getSj_yjzlbh() {
		return sj_yjzlbh;
	}
	public void setSj_yjzlbh(String sj_yjzlbh) {
		this.sj_yjzlbh = sj_yjzlbh;
	}
	public String getRoot_yjzlbh() {
		return root_yjzlbh;
	}
	public void setRoot_yjzlbh(String root_yjzlbh) {
		this.root_yjzlbh = root_yjzlbh;
	}
	public String getSftszb() {
		return sftszb;
	}
	public void setSftszb(String sftszb) {
		this.sftszb = sftszb;
	}
	public String getTszbmx() {
		return tszbmx;
	}
	public void setTszbmx(String tszbmx) {
		this.tszbmx = tszbmx;
	}
	public String getYpjl() {
		return ypjl;
	}
	public void setYpjl(String ypjl) {
		this.ypjl = ypjl;
	}
	public String getCkyq() {
		return ckyq;
	}
	public void setCkyq(String ckyq) {
		this.ckyq = ckyq;
	}
	
}
