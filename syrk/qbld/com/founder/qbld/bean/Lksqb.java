package com.founder.qbld.bean;

import java.io.Serializable;
import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.bean.Lksqb.java]  
 * @ClassName:    [Lksqb]   
 * @Description:  [临控申请表]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-5-14 上午9:42:39]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-14 上午9:42:39，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "QBLD_LK_LKSQB", pk = "lkzlbh")
public class Lksqb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	private String bkqssjB;
	private String bkqssjE;
	
	public String getBkqssjB() {
		return bkqssjB;
	}
	public void setBkqssjB(String bkqssjB) {
		this.bkqssjB = bkqssjB;
	}
	public String getBkqssjE() {
		return bkqssjE;
	}
	public void setBkqssjE(String bkqssjE) {
		this.bkqssjE = bkqssjE;
	}
	@FieldDesc("服务方ID+16位序号，由服务方产生")
	private String xxbkzxbh;
	@FieldDesc("被布控人证件种类，采用GA/Z 02 D2008")
	private String bbkrzjlx;
	@FieldDesc("被布控人证件号码，证件种类为公民身份证时，可填15或18位身份证号，采用GA/Z 02 D1000")
	private String bbkrzjhm;
	@FieldDesc("被布控人姓名，采用GA/Z 02 D1001，不少于2个汉字，少数民族姓名间隔符用'?' (GB 13000编码为00B7)表示，未编码冷僻字用'?'(GB 13000编码为2580)表示")
	private String bbkrxm;
	@FieldDesc("被布控人性别，采用GA/Z 02 D1006")
	private String bbkrxb;
	@FieldDesc("被布控人出生日期，格式为YYYYMMDD")
	private String bbkrcsrq;
	@FieldDesc("采用格式YYYYMMDDhhmmss，24小时格式")
	private String bkqssj;
	@FieldDesc("采用格式YYYYMMDDhhmmss，24小时格式")
	private String bkjzsj;
	@FieldDesc("备注")
	private String bz;
	@FieldDesc("申请人身份号码采用GA/Z 02 D1000")
	private String sqrsfhm;
	@FieldDesc("申请人姓名")
	private String sqrxm;
	@FieldDesc("固定电话号码及移动电话号码，号码间以”;”间隔")
	private String sqrlxhm;
	@FieldDesc("申请布控的责任单位，采用GA/Z 02 D3006")
	private String sqdw;
	@FieldDesc("采用GA/Z 02 D3000")
	private String sqdwjgdm;
	@FieldDesc("参见字典表：QB_LDFW_ZD_BKZXZT")
	private String bkzxzt;
	@FieldDesc("对某个信息布控指令，在其提交发起时由请求方负责产生，用于验证后续针对该布控的撤控、续控、查询等操作的合法性，为12位字符串，应尽可能保证每次提交操作都产生不同的值。对该信息布控指令进行后续续控、撤控等操作时，均需提供当初提交发起时所产生的操作验证码。")
	private String czyzm;
	@FieldDesc("如果应用上需要实时接收布控结果，则必须指定布控结果接收服务ID；否则置空，信息布控服务将不主动推送布控结果")
	private String rcvserviceid;
	@FieldDesc("签收时间")
	private String bc_qssj;
	@FieldDesc("签收状态")
	private String bc_qszt;
	@FieldDesc("处置措施")
	private String bc_cccs;
	@FieldDesc("现住址")
	private String bc_xzz;
	@FieldDesc("户籍住址")
	private String bc_hjzz;
	@FieldDesc("体貌特征")
	private String bc_tmtz;
	@FieldDesc("管控类型")
	private String bc_gklx;
	@FieldDesc("反馈时间")
	private String bc_fksj;
	@FieldDesc("要求指令接收单位辖内实施布控的地域范围，地级市以上行政区划，采用GA/Z 02 D4001，可多值，以”,”间隔，最多7个")
	private String bkdyfw;
	@FieldDesc("身高")
	private String bc_sg;
	@FieldDesc("发布人联系电话")
	private String bc_fbrlxdh;
	@FieldDesc("发布单位")
	private String bc_fbdw;
	@FieldDesc("发布人身份证号")
	private String bc_fbrsfzh;
	@FieldDesc("发布人")
	private String bc_fbr;
	@FieldDesc("发布时间")
	private String bc_fbsj;
	@FieldDesc("采用GA XXX.2中的重点人员临控指令级别代码")
	private String lkzljb;
	@FieldDesc("发布单位编码")
	private String bc_fbdwbm;
	@FieldDesc("ID")
	private Long id;
	@FieldDesc("布控原因")
	private String bkyy;
	@FieldDesc("处置要求")
	private String czyq;
	@FieldDesc("执法依据")
	private String zfyj;
	@FieldDesc("申请时间")
	private String bc_sqsj;
	@FieldDesc("创建时间")
	private String cjsj;
	@FieldDesc("布控级别 1：部级  2：省级  3：市级")
	private String bc_bkjb;
	@FieldDesc("省级布控执行状态  ")
	private String bc_sjbkzxzt;
	@FieldDesc("是否删除 0：未删除 1：已删除")
	private String sfsc;
	@FieldDesc("申请人编码")
	private String sqrbm;
	@FieldDesc("审核状态（2：省厅审核；3：地市审核；）")
	private String shzt;
	@FieldDesc("是否上传省厅(0：未上传；1：已上传);WDT使用字段")
	private String sfscst;
	@FieldDesc("布控地（3：地市系统默认；2：省厅系统默认）")
	private String bkd;
	@FieldDesc("布控类型(1：公开；2：私密)")
	private String bklx;
	@FieldDesc("预警人DM(多条人员逗号分隔)")
	private String yjrdm;
	@FieldDesc("预警人名称(多条人员逗号分隔)")
	private String yjrmc;
	@FieldDesc("预警单位DM")
	private String yjdwdm;
	@FieldDesc("预警单位名称")
	private String yjdwmc;
	@FieldDesc("SJHM")
	private String sjhm;
	@FieldDesc("DRLKRY_ID")
	private String drlkry_id;
	@FieldDesc("DRLKRY_BH")
	private String drlkry_bh;
	@FieldDesc("布控天数")
	private String bkts;
	
	public String getXxbkzxbh() {
		return xxbkzxbh;
	}
	public void setXxbkzxbh(String xxbkzxbh) {
		this.xxbkzxbh = xxbkzxbh;
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
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getSqrsfhm() {
		return sqrsfhm;
	}
	public void setSqrsfhm(String sqrsfhm) {
		this.sqrsfhm = sqrsfhm;
	}
	public String getSqrxm() {
		return sqrxm;
	}
	public void setSqrxm(String sqrxm) {
		this.sqrxm = sqrxm;
	}
	public String getSqrlxhm() {
		return sqrlxhm;
	}
	public void setSqrlxhm(String sqrlxhm) {
		this.sqrlxhm = sqrlxhm;
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
	public String getBkzxzt() {
		return bkzxzt;
	}
	public void setBkzxzt(String bkzxzt) {
		this.bkzxzt = bkzxzt;
	}
	public String getCzyzm() {
		return czyzm;
	}
	public void setCzyzm(String czyzm) {
		this.czyzm = czyzm;
	}
	public String getRcvserviceid() {
		return rcvserviceid;
	}
	public void setRcvserviceid(String rcvserviceid) {
		this.rcvserviceid = rcvserviceid;
	}
	public String getBc_qssj() {
		return bc_qssj;
	}
	public void setBc_qssj(String bc_qssj) {
		this.bc_qssj = bc_qssj;
	}
	public String getBc_qszt() {
		return bc_qszt;
	}
	public void setBc_qszt(String bc_qszt) {
		this.bc_qszt = bc_qszt;
	}
	public String getBc_cccs() {
		return bc_cccs;
	}
	public void setBc_cccs(String bc_cccs) {
		this.bc_cccs = bc_cccs;
	}
	public String getBc_xzz() {
		return bc_xzz;
	}
	public void setBc_xzz(String bc_xzz) {
		this.bc_xzz = bc_xzz;
	}
	public String getBc_hjzz() {
		return bc_hjzz;
	}
	public void setBc_hjzz(String bc_hjzz) {
		this.bc_hjzz = bc_hjzz;
	}
	public String getBc_tmtz() {
		return bc_tmtz;
	}
	public void setBc_tmtz(String bc_tmtz) {
		this.bc_tmtz = bc_tmtz;
	}
	public String getBc_gklx() {
		return bc_gklx;
	}
	public void setBc_gklx(String bc_gklx) {
		this.bc_gklx = bc_gklx;
	}
	public String getBc_fksj() {
		return bc_fksj;
	}
	public void setBc_fksj(String bc_fksj) {
		this.bc_fksj = bc_fksj;
	}
	public String getBkdyfw() {
		return bkdyfw;
	}
	public void setBkdyfw(String bkdyfw) {
		this.bkdyfw = bkdyfw;
	}
	public String getBc_sg() {
		return bc_sg;
	}
	public void setBc_sg(String bc_sg) {
		this.bc_sg = bc_sg;
	}
	public String getBc_fbrlxdh() {
		return bc_fbrlxdh;
	}
	public void setBc_fbrlxdh(String bc_fbrlxdh) {
		this.bc_fbrlxdh = bc_fbrlxdh;
	}
	public String getBc_fbdw() {
		return bc_fbdw;
	}
	public void setBc_fbdw(String bc_fbdw) {
		this.bc_fbdw = bc_fbdw;
	}
	public String getBc_fbrsfzh() {
		return bc_fbrsfzh;
	}
	public void setBc_fbrsfzh(String bc_fbrsfzh) {
		this.bc_fbrsfzh = bc_fbrsfzh;
	}
	public String getBc_fbr() {
		return bc_fbr;
	}
	public void setBc_fbr(String bc_fbr) {
		this.bc_fbr = bc_fbr;
	}
	public String getBc_fbsj() {
		return bc_fbsj;
	}
	public void setBc_fbsj(String bc_fbsj) {
		this.bc_fbsj = bc_fbsj;
	}
	public String getLkzljb() {
		return lkzljb;
	}
	public void setLkzljb(String lkzljb) {
		this.lkzljb = lkzljb;
	}
	public String getBc_fbdwbm() {
		return bc_fbdwbm;
	}
	public void setBc_fbdwbm(String bc_fbdwbm) {
		this.bc_fbdwbm = bc_fbdwbm;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBkyy() {
		return bkyy;
	}
	public void setBkyy(String bkyy) {
		this.bkyy = bkyy;
	}
	public String getCzyq() {
		return czyq;
	}
	public void setCzyq(String czyq) {
		this.czyq = czyq;
	}
	public String getZfyj() {
		return zfyj;
	}
	public void setZfyj(String zfyj) {
		this.zfyj = zfyj;
	}
	public String getBc_sqsj() {
		return bc_sqsj;
	}
	public void setBc_sqsj(String bc_sqsj) {
		this.bc_sqsj = bc_sqsj;
	}
	public String getCjsj() {
		return cjsj;
	}
	public void setCjsj(String cjsj) {
		this.cjsj = cjsj;
	}
	public String getBc_bkjb() {
		return bc_bkjb;
	}
	public void setBc_bkjb(String bc_bkjb) {
		this.bc_bkjb = bc_bkjb;
	}
	public String getBc_sjbkzxzt() {
		return bc_sjbkzxzt;
	}
	public void setBc_sjbkzxzt(String bc_sjbkzxzt) {
		this.bc_sjbkzxzt = bc_sjbkzxzt;
	}
	public String getSfsc() {
		return sfsc;
	}
	public void setSfsc(String sfsc) {
		this.sfsc = sfsc;
	}
	public String getSqrbm() {
		return sqrbm;
	}
	public void setSqrbm(String sqrbm) {
		this.sqrbm = sqrbm;
	}
	public String getShzt() {
		return shzt;
	}
	public void setShzt(String shzt) {
		this.shzt = shzt;
	}
	public String getSfscst() {
		return sfscst;
	}
	public void setSfscst(String sfscst) {
		this.sfscst = sfscst;
	}
	public String getBkd() {
		return bkd;
	}
	public void setBkd(String bkd) {
		this.bkd = bkd;
	}
	public String getBklx() {
		return bklx;
	}
	public void setBklx(String bklx) {
		this.bklx = bklx;
	}
	public String getYjrdm() {
		return yjrdm;
	}
	public void setYjrdm(String yjrdm) {
		this.yjrdm = yjrdm;
	}
	public String getYjrmc() {
		return yjrmc;
	}
	public void setYjrmc(String yjrmc) {
		this.yjrmc = yjrmc;
	}
	public String getYjdwdm() {
		return yjdwdm;
	}
	public void setYjdwdm(String yjdwdm) {
		this.yjdwdm = yjdwdm;
	}
	public String getYjdwmc() {
		return yjdwmc;
	}
	public void setYjdwmc(String yjdwmc) {
		this.yjdwmc = yjdwmc;
	}
	public String getSjhm() {
		return sjhm;
	}
	public void setSjhm(String sjhm) {
		this.sjhm = sjhm;
	}
	public String getDrlkry_id() {
		return drlkry_id;
	}
	public void setDrlkry_id(String drlkry_id) {
		this.drlkry_id = drlkry_id;
	}
	public String getDrlkry_bh() {
		return drlkry_bh;
	}
	public void setDrlkry_bh(String drlkry_bh) {
		this.drlkry_bh = drlkry_bh;
	}
	public String getBkts() {
		return bkts;
	}
	public void setBkts(String bkts) {
		this.bkts = bkts;
	}

}
