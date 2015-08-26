package com.founder.qbld.bean;

import java.io.Serializable;
import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.bean.CkyjzlczFkb.java]  
 * @ClassName:    [CkyjzlczFkb]   
 * @Description:  [预警指令反馈表]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-6-8 上午9:40:16]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-8 上午9:40:16，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "QBLD_CK_YJZLFKB", pk = "yjzlbh")
public class CkyjzlczFkb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@FieldDesc("预警指令编号")
	private String yjzlbh;
	@FieldDesc("反馈时间,采用格式YYYYMMDDhhmmss，24小时格式")
	private String fksj;
	@FieldDesc("反馈人身份证号,采用GA/Z 02 D1000")
	private String fkrsfzh;
	@FieldDesc("反馈人姓名")
	private String fkrxm;
	@FieldDesc("反馈单位,采用GA/Z 02 D3006")
	private String fkdw;
	@FieldDesc("反馈单位机构代码,采用GA/Z 02 D3000")
	private String fkdwjgdm;
	@FieldDesc("人员实名动态信息分类，采用GA XXX.2中的“动态实名信息类别代码”")
	private String dtxxlb;
	@FieldDesc("活动发生时间,采用格式YYYYMMDDhhmmss，24小时格式")
	private String hdfssj;
	@FieldDesc("活动发生地点区划,采用GA/Z 02 D4001")
	private String hdfsddqh;
	@FieldDesc("活动发生地点详址")
	private String hdfsddxz;
	@FieldDesc("活动发生地点所属的社会场所")
	private String hdfsddssshcs;
	@FieldDesc("活动发生地点所属社会场所代码")
	private String hdfsddssshcsdm;
	@FieldDesc("活动相关信息")
	private String fxhdxgxx;
	@FieldDesc("目标发现状态,采用GA XXX.2中的“重点人员目标发现状态代码”")
	private String mbfxzt;
	@FieldDesc("发现目标责任民警身份证号,采用GA/Z 02 D1000")
	private String fxmbzrmjsfzh;
	@FieldDesc("发现目标责任民警姓名")
	private String fxmbzrmjxm;
	@FieldDesc("活动发现地点的责任公安机关，采用GA/Z 02 D3006")
	private String fxmbzrdw;
	@FieldDesc("发现目标责任单位机构代码,采用GA/Z 02 D3000")
	private String fxmbzrdwjgdm;
	@FieldDesc("采用GA XXX.2中的重点人员预警处置措施类型代码")
	private String cqczcs;
	@FieldDesc("采用GA XXX.2中的重点人员管控措施代码")
	private String gkcs;
	@FieldDesc("处置时间,采用格式YYYYMMDDhhmmss，24小时格式")
	private String czsj;
	@FieldDesc("处置地点区划,所在的行政区划，采用GA/Z 02 D4001")
	private String czddqh;
	@FieldDesc("处置地点详址")
	private String czddxz;
	@FieldDesc("处置责任民警身份证号,采用GA/Z 02 D1000")
	private String czzrmjsfzh;
	@FieldDesc("处置责任民警姓名")
	private String czzrmjxm;
	@FieldDesc("处置责任单位,采用GA/Z 02 D3006")
	private String czzrdw;
	@FieldDesc("处置责任单位机构代码采用GA/Z 02 D3000")
	private String czzrdwjgdm;
	@FieldDesc("处置经过描述")
	private String czjgms;
	@FieldDesc("采用GA XXX.2中的重点人员预警处置结果类型代码")
	private String czjg;
	@FieldDesc("地市或省厅编码")
	private String ssdqid;
	@FieldDesc("是否已经上报公安部")
	private String sfsb;
	@FieldDesc("是否已经上报省厅")
	private String b_sfsbst;
	@FieldDesc("管控类型")
	private String b_gklx;
	@FieldDesc("重点人员级别1： 部、2：省、3：市")
	private String b_zdryjb;
	@FieldDesc("吸毒查获尿检信息")
	private String xdchnjxx;
	@FieldDesc("现场查获物品信息")
	private String xcchwpxx;
	@FieldDesc("立线侦查工作评估")
	private String lxzcgzpg;
	@FieldDesc("立线侦查工作评估依据")
	private String lxzcgzpgyj;
	@FieldDesc("目标从事职业类型")
	private String mbcszylx;
	@FieldDesc("处置处置反馈补充信息结果")
	private String czfkbcxx;
	@FieldDesc("抓捕细类")
	private String zbxl;
	@FieldDesc("经营细类")
	private String jyxl;
	@FieldDesc("预警产生原因")
	private String yjcsyy;
	@FieldDesc("未抓获原因")
	private String wzhyy;
	@FieldDesc("现场信息采集")
	private String xcxxcj;
	@FieldDesc("通信方式")
	private String txfs;
	@FieldDesc("随身物品")
	private String sswp;
	@FieldDesc("交通工具")
	private String jtgj;
	@FieldDesc("同行人员情况")
	private String txryqk;
	@FieldDesc("其他原因")
	private String qtyy;
	@FieldDesc("活动目的")
	private String hdmd;
	@FieldDesc("通信方式(判断)")
	private String txfs_sf;
	@FieldDesc("随身物品(判断)")
	private String sswp_sf;
	@FieldDesc("交通工具(判断)")
	private String jtgj_sf;
	@FieldDesc("同行人员(判断)")
	private String txryqk_sf;
	@FieldDesc("处置反馈信息编号")
	private String czfkxxbh;
	@FieldDesc("处置措施细类 采用GA XXX.2中的“重点人员处置措施细类代码”")
	private String czcsxl;
	@FieldDesc("接口发送状态， ‘0’发送成功；‘1’发送失败")
	private String fszt;
	@FieldDesc("接口调用状态码")
	private String code;
	
	public String getFszt() {
		return fszt;
	}
	public void setFszt(String fszt) {
		this.fszt = fszt;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}	
	public String getCzcsxl() {
		return czcsxl;
	}
	public void setCzcsxl(String czcsxl) {
		this.czcsxl = czcsxl;
	}
	public String getCzfkxxbh() {
		return czfkxxbh;
	}
	public void setCzfkxxbh(String czfkxxbh) {
		this.czfkxxbh = czfkxxbh;
	}
	public String getYjzlbh() {
		return yjzlbh;
	}
	public void setYjzlbh(String yjzlbh) {
		this.yjzlbh = yjzlbh;
	}
	public String getFksj() {
		return fksj;
	}
	public void setFksj(String fksj) {
		this.fksj = fksj;
	}
	public String getFkrsfzh() {
		return fkrsfzh;
	}
	public void setFkrsfzh(String fkrsfzh) {
		this.fkrsfzh = fkrsfzh;
	}
	public String getFkrxm() {
		return fkrxm;
	}
	public void setFkrxm(String fkrxm) {
		this.fkrxm = fkrxm;
	}
	public String getFkdw() {
		return fkdw;
	}
	public void setFkdw(String fkdw) {
		this.fkdw = fkdw;
	}
	public String getFkdwjgdm() {
		return fkdwjgdm;
	}
	public void setFkdwjgdm(String fkdwjgdm) {
		this.fkdwjgdm = fkdwjgdm;
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
	public String getFxhdxgxx() {
		return fxhdxgxx;
	}
	public void setFxhdxgxx(String fxhdxgxx) {
		this.fxhdxgxx = fxhdxgxx;
	}
	public String getMbfxzt() {
		return mbfxzt;
	}
	public void setMbfxzt(String mbfxzt) {
		this.mbfxzt = mbfxzt;
	}
	public String getFxmbzrmjsfzh() {
		return fxmbzrmjsfzh;
	}
	public void setFxmbzrmjsfzh(String fxmbzrmjsfzh) {
		this.fxmbzrmjsfzh = fxmbzrmjsfzh;
	}
	public String getFxmbzrmjxm() {
		return fxmbzrmjxm;
	}
	public void setFxmbzrmjxm(String fxmbzrmjxm) {
		this.fxmbzrmjxm = fxmbzrmjxm;
	}
	public String getFxmbzrdw() {
		return fxmbzrdw;
	}
	public void setFxmbzrdw(String fxmbzrdw) {
		this.fxmbzrdw = fxmbzrdw;
	}
	public String getFxmbzrdwjgdm() {
		return fxmbzrdwjgdm;
	}
	public void setFxmbzrdwjgdm(String fxmbzrdwjgdm) {
		this.fxmbzrdwjgdm = fxmbzrdwjgdm;
	}
	public String getCqczcs() {
		return cqczcs;
	}
	public void setCqczcs(String cqczcs) {
		this.cqczcs = cqczcs;
	}
	public String getGkcs() {
		return gkcs;
	}
	public void setGkcs(String gkcs) {
		this.gkcs = gkcs;
	}
	public String getCzsj() {
		return czsj;
	}
	public void setCzsj(String czsj) {
		this.czsj = czsj;
	}
	public String getCzddqh() {
		return czddqh;
	}
	public void setCzddqh(String czddqh) {
		this.czddqh = czddqh;
	}
	public String getCzddxz() {
		return czddxz;
	}
	public void setCzddxz(String czddxz) {
		this.czddxz = czddxz;
	}
	public String getCzzrmjsfzh() {
		return czzrmjsfzh;
	}
	public void setCzzrmjsfzh(String czzrmjsfzh) {
		this.czzrmjsfzh = czzrmjsfzh;
	}
	public String getCzzrmjxm() {
		return czzrmjxm;
	}
	public void setCzzrmjxm(String czzrmjxm) {
		this.czzrmjxm = czzrmjxm;
	}
	public String getCzzrdw() {
		return czzrdw;
	}
	public void setCzzrdw(String czzrdw) {
		this.czzrdw = czzrdw;
	}
	public String getCzzrdwjgdm() {
		return czzrdwjgdm;
	}
	public void setCzzrdwjgdm(String czzrdwjgdm) {
		this.czzrdwjgdm = czzrdwjgdm;
	}
	public String getCzjgms() {
		return czjgms;
	}
	public void setCzjgms(String czjgms) {
		this.czjgms = czjgms;
	}
	public String getCzjg() {
		return czjg;
	}
	public void setCzjg(String czjg) {
		this.czjg = czjg;
	}
	public String getSsdqid() {
		return ssdqid;
	}
	public void setSsdqid(String ssdqid) {
		this.ssdqid = ssdqid;
	}
	public String getSfsb() {
		return sfsb;
	}
	public void setSfsb(String sfsb) {
		this.sfsb = sfsb;
	}
	public String getB_sfsbst() {
		return b_sfsbst;
	}
	public void setB_sfsbst(String b_sfsbst) {
		this.b_sfsbst = b_sfsbst;
	}
	public String getB_gklx() {
		return b_gklx;
	}
	public void setB_gklx(String b_gklx) {
		this.b_gklx = b_gklx;
	}
	public String getB_zdryjb() {
		return b_zdryjb;
	}
	public void setB_zdryjb(String b_zdryjb) {
		this.b_zdryjb = b_zdryjb;
	}
	public String getXdchnjxx() {
		return xdchnjxx;
	}
	public void setXdchnjxx(String xdchnjxx) {
		this.xdchnjxx = xdchnjxx;
	}
	public String getXcchwpxx() {
		return xcchwpxx;
	}
	public void setXcchwpxx(String xcchwpxx) {
		this.xcchwpxx = xcchwpxx;
	}
	public String getLxzcgzpg() {
		return lxzcgzpg;
	}
	public void setLxzcgzpg(String lxzcgzpg) {
		this.lxzcgzpg = lxzcgzpg;
	}
	public String getLxzcgzpgyj() {
		return lxzcgzpgyj;
	}
	public void setLxzcgzpgyj(String lxzcgzpgyj) {
		this.lxzcgzpgyj = lxzcgzpgyj;
	}
	public String getMbcszylx() {
		return mbcszylx;
	}
	public void setMbcszylx(String mbcszylx) {
		this.mbcszylx = mbcszylx;
	}
	public String getCzfkbcxx() {
		return czfkbcxx;
	}
	public void setCzfkbcxx(String czfkbcxx) {
		this.czfkbcxx = czfkbcxx;
	}
	public String getZbxl() {
		return zbxl;
	}
	public void setZbxl(String zbxl) {
		this.zbxl = zbxl;
	}
	public String getJyxl() {
		return jyxl;
	}
	public void setJyxl(String jyxl) {
		this.jyxl = jyxl;
	}
	public String getYjcsyy() {
		return yjcsyy;
	}
	public void setYjcsyy(String yjcsyy) {
		this.yjcsyy = yjcsyy;
	}
	public String getWzhyy() {
		return wzhyy;
	}
	public void setWzhyy(String wzhyy) {
		this.wzhyy = wzhyy;
	}
	public String getXcxxcj() {
		return xcxxcj;
	}
	public void setXcxxcj(String xcxxcj) {
		this.xcxxcj = xcxxcj;
	}
	public String getTxfs() {
		return txfs;
	}
	public void setTxfs(String txfs) {
		this.txfs = txfs;
	}
	public String getSswp() {
		return sswp;
	}
	public void setSswp(String sswp) {
		this.sswp = sswp;
	}
	public String getJtgj() {
		return jtgj;
	}
	public void setJtgj(String jtgj) {
		this.jtgj = jtgj;
	}
	public String getTxryqk() {
		return txryqk;
	}
	public void setTxryqk(String txryqk) {
		this.txryqk = txryqk;
	}
	public String getQtyy() {
		return qtyy;
	}
	public void setQtyy(String qtyy) {
		this.qtyy = qtyy;
	}
	public String getHdmd() {
		return hdmd;
	}
	public void setHdmd(String hdmd) {
		this.hdmd = hdmd;
	}
	public String getTxfs_sf() {
		return txfs_sf;
	}
	public void setTxfs_sf(String txfs_sf) {
		this.txfs_sf = txfs_sf;
	}
	public String getSswp_sf() {
		return sswp_sf;
	}
	public void setSswp_sf(String sswp_sf) {
		this.sswp_sf = sswp_sf;
	}
	public String getJtgj_sf() {
		return jtgj_sf;
	}
	public void setJtgj_sf(String jtgj_sf) {
		this.jtgj_sf = jtgj_sf;
	}
	public String getTxryqk_sf() {
		return txryqk_sf;
	}
	public void setTxryqk_sf(String txryqk_sf) {
		this.txryqk_sf = txryqk_sf;
	}

}
