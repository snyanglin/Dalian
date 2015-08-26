package com.founder.sydw.bean;

import java.io.Serializable;
import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/******************************************************************************
 * @Package:      [com.founder.sydw.bean.DwOwnZjbxBean.java]  
 * @ClassName:    [DwOwnZjbxBean]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [star]  
 * @CreateDate:   [2015-6-5 下午1:55:53]   
 * @UpdateUser:   [star(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-5 下午1:55:53，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@DBInfoAnnotation(tableName = "DW_DWZJBXXXB", pk = "id")
public class DwOwnZjbxBean extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 时间：2015，5.13
	 * 人：star
	 * 内容：证券/保险业单位的行业特殊信息
	 */
	@FieldDesc("id")
	private String id;
	@FieldDesc("单位ID")
	private String dwid;
	@FieldDesc("重要部位数")
	private String zybws;
	@FieldDesc("在册职工数")
	private String zczgs;
	@FieldDesc("是否平安单位")
	private String sfpadw;
	@FieldDesc("备注")
	private String bz;
	@FieldDesc("所属监管机构")
	private String ssjgjg;
	@FieldDesc("主管保卫负责人姓名")
	private String zgbwfzrxm;
	@FieldDesc("主管保卫负责人身份证号")
	private String zgbwfzrsfzh;
	@FieldDesc("主管保卫负责人职务")
	private String zgbwfzrzw;
	@FieldDesc("主管保卫负责人联系方式")
	private String zgbwfzrlxfs;
	@FieldDesc("保卫机构负责人姓名")
	private String bwjgfzrxm;
	@FieldDesc("保卫机构负责人身份证号")
	private String bwjgfzrsfzh;
	@FieldDesc("保卫组织名称")
	private String bwzzmc;
	@FieldDesc("是否独立保卫机构")
	private String sfdlbwjg;
	@FieldDesc("是否治安保卫重点单位")
	private String sfzabwzddw;
	@FieldDesc("治安保卫重点单位级别")
	private String zabwzddwjb;
	@FieldDesc("人防情况")
	private String rfqk;
	@FieldDesc("物防情况")
	private String wfqk;
	@FieldDesc("技防情况")
	private String jfqk;
	@FieldDesc("所在地派出所")
	private String szdpcs;
	@FieldDesc("是否注销")
	private String sfzx;
	@FieldDesc("注销日期")
	private String zxrq;
	@FieldDesc("注销原因")
	private String zxyy;
	@FieldDesc("是否建立警务工作室")
	private String sfjljwgzs;
	@FieldDesc("采集时间")
	private String xt_cjsj;
	@FieldDesc("录入时间")
	private String xt_lrsj;
	@FieldDesc("录入人姓名")
	private String xt_lrrxm;
	@FieldDesc("录入人ID")
	private String xt_lrrid;
	@FieldDesc("录入人部门")
	private String xt_lrrbm;
	@FieldDesc("录入人部门ID")
	private String xt_lrrbmid;
	@FieldDesc("录入IP")
	private String xt_lrip;
	@FieldDesc("最后修改时间")
	private String xt_zhxgsj;
	@FieldDesc("最后修改人姓名")
	private String xt_zhxgrxm;
	@FieldDesc("最后修改人ID")
	private String xt_zhxgrid;
	@FieldDesc("最后修改人部门")
	private String xt_zhxgrbm;
	@FieldDesc("最后修改人部门ID")
	private String xt_zhxgrbmid;
	@FieldDesc("最后修改IP")
	private String xt_zhxgip;
	@FieldDesc("注销标志")
	private String xt_zxbz;
	@FieldDesc("注销原因")
	private String xt_zxyy;
	@FieldDesc("固定资产")
	private String gdzc;
	@FieldDesc("负责指导监督公安内保部门")
	private String fzzdjdganbbm;
	@FieldDesc("负责指导监督公安内保部门责任民警")
	private String fzzdjdganbbmzrmj;
	@FieldDesc("负责指导监督公安内保部门联系方式")
	private String fzzdjdganbbmlxfs;
	@FieldDesc("部位编号")
	private String bwbh;
	@FieldDesc("部位名称")
	private String bwmc;
	@FieldDesc("部位位置")
	private String bwwz;
	@FieldDesc("部位负责人")
	private String bwfzr;
	@FieldDesc("部位负责人身份证号")
	private String bwfzrsfzh;
	@FieldDesc("部位负责人职务")
	private String bwfzrzw;
	@FieldDesc("部位负责人联系方式")
	private String bwfzrlxfs;
	@FieldDesc("部位值班电话")
	private String bwzbdh;
	@FieldDesc("物防设施情况")
	private String wfssqk;
	@FieldDesc("技防设施情况")
	private String jfssqk;
	@FieldDesc("部位确定时间")
	private String bwqdsj;
	@FieldDesc("部位确定理由依据")
	private String bwqdlyyj;
	public String getFzzdjdganbbm() {
		return fzzdjdganbbm;
	}
	public void setFzzdjdganbbm(String fzzdjdganbbm) {
		this.fzzdjdganbbm = fzzdjdganbbm;
	}
	public String getFzzdjdganbbmzrmj() {
		return fzzdjdganbbmzrmj;
	}
	public void setFzzdjdganbbmzrmj(String fzzdjdganbbmzrmj) {
		this.fzzdjdganbbmzrmj = fzzdjdganbbmzrmj;
	}
	public String getFzzdjdganbbmlxfs() {
		return fzzdjdganbbmlxfs;
	}
	public void setFzzdjdganbbmlxfs(String fzzdjdganbbmlxfs) {
		this.fzzdjdganbbmlxfs = fzzdjdganbbmlxfs;
	}
	public String getGdzc() {
		return gdzc;
	}
	public void setGdzc(String gdzc) {
		this.gdzc = gdzc;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDwid() {
		return dwid;
	}
	public void setDwid(String dwid) {
		this.dwid = dwid;
	}
	public String getZybws() {
		return zybws;
	}
	public void setZybws(String zybws) {
		this.zybws = zybws;
	}
	public String getZczgs() {
		return zczgs;
	}
	public void setZczgs(String zczgs) {
		this.zczgs = zczgs;
	}
	public String getSfpadw() {
		return sfpadw;
	}
	public void setSfpadw(String sfpadw) {
		this.sfpadw = sfpadw;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getSsjgjg() {
		return ssjgjg;
	}
	public void setSsjgjg(String ssjgjg) {
		this.ssjgjg = ssjgjg;
	}
	public String getZgbwfzrxm() {
		return zgbwfzrxm;
	}
	public void setZgbwfzrxm(String zgbwfzrxm) {
		this.zgbwfzrxm = zgbwfzrxm;
	}
	public String getZgbwfzrsfzh() {
		return zgbwfzrsfzh;
	}
	public void setZgbwfzrsfzh(String zgbwfzrsfzh) {
		this.zgbwfzrsfzh = zgbwfzrsfzh;
	}
	public String getZgbwfzrzw() {
		return zgbwfzrzw;
	}
	public void setZgbwfzrzw(String zgbwfzrzw) {
		this.zgbwfzrzw = zgbwfzrzw;
	}
	public String getZgbwfzrlxfs() {
		return zgbwfzrlxfs;
	}
	public void setZgbwfzrlxfs(String zgbwfzrlxfs) {
		this.zgbwfzrlxfs = zgbwfzrlxfs;
	}
	public String getBwjgfzrxm() {
		return bwjgfzrxm;
	}
	public void setBwjgfzrxm(String bwjgfzrxm) {
		this.bwjgfzrxm = bwjgfzrxm;
	}
	public String getBwjgfzrsfzh() {
		return bwjgfzrsfzh;
	}
	public void setBwjgfzrsfzh(String bwjgfzrsfzh) {
		this.bwjgfzrsfzh = bwjgfzrsfzh;
	}
	public String getBwzzmc() {
		return bwzzmc;
	}
	public void setBwzzmc(String bwzzmc) {
		this.bwzzmc = bwzzmc;
	}
	public String getSfdlbwjg() {
		return sfdlbwjg;
	}
	public void setSfdlbwjg(String sfdlbwjg) {
		this.sfdlbwjg = sfdlbwjg;
	}
	public String getSfzabwzddw() {
		return sfzabwzddw;
	}
	public void setSfzabwzddw(String sfzabwzddw) {
		this.sfzabwzddw = sfzabwzddw;
	}
	public String getZabwzddwjb() {
		return zabwzddwjb;
	}
	public void setZabwzddwjb(String zabwzddwjb) {
		this.zabwzddwjb = zabwzddwjb;
	}
	public String getRfqk() {
		return rfqk;
	}
	public void setRfqk(String rfqk) {
		this.rfqk = rfqk;
	}
	public String getWfqk() {
		return wfqk;
	}
	public void setWfqk(String wfqk) {
		this.wfqk = wfqk;
	}
	public String getJfqk() {
		return jfqk;
	}
	public void setJfqk(String jfqk) {
		this.jfqk = jfqk;
	}
	public String getSzdpcs() {
		return szdpcs;
	}
	public void setSzdpcs(String szdpcs) {
		this.szdpcs = szdpcs;
	}
	public String getSfzx() {
		return sfzx;
	}
	public void setSfzx(String sfzx) {
		this.sfzx = sfzx;
	}
	public String getZxrq() {
		return zxrq;
	}
	public void setZxrq(String zxrq) {
		this.zxrq = zxrq;
	}
	public String getZxyy() {
		return zxyy;
	}
	public void setZxyy(String zxyy) {
		this.zxyy = zxyy;
	}
	public String getSfjljwgzs() {
		return sfjljwgzs;
	}
	public void setSfjljwgzs(String sfjljwgzs) {
		this.sfjljwgzs = sfjljwgzs;
	}
	public String getXt_cjsj() {
		return xt_cjsj;
	}
	public void setXt_cjsj(String xt_cjsj) {
		this.xt_cjsj = xt_cjsj;
	}
	public String getXt_lrsj() {
		return xt_lrsj;
	}
	public void setXt_lrsj(String xt_lrsj) {
		this.xt_lrsj = xt_lrsj;
	}
	public String getXt_lrrxm() {
		return xt_lrrxm;
	}
	public void setXt_lrrxm(String xt_lrrxm) {
		this.xt_lrrxm = xt_lrrxm;
	}
	public String getXt_lrrid() {
		return xt_lrrid;
	}
	public void setXt_lrrid(String xt_lrrid) {
		this.xt_lrrid = xt_lrrid;
	}
	public String getXt_lrrbm() {
		return xt_lrrbm;
	}
	public void setXt_lrrbm(String xt_lrrbm) {
		this.xt_lrrbm = xt_lrrbm;
	}
	public String getXt_lrrbmid() {
		return xt_lrrbmid;
	}
	public void setXt_lrrbmid(String xt_lrrbmid) {
		this.xt_lrrbmid = xt_lrrbmid;
	}
	public String getXt_lrip() {
		return xt_lrip;
	}
	public void setXt_lrip(String xt_lrip) {
		this.xt_lrip = xt_lrip;
	}
	public String getXt_zhxgsj() {
		return xt_zhxgsj;
	}
	public void setXt_zhxgsj(String xt_zhxgsj) {
		this.xt_zhxgsj = xt_zhxgsj;
	}
	public String getXt_zhxgrxm() {
		return xt_zhxgrxm;
	}
	public void setXt_zhxgrxm(String xt_zhxgrxm) {
		this.xt_zhxgrxm = xt_zhxgrxm;
	}
	public String getXt_zhxgrid() {
		return xt_zhxgrid;
	}
	public void setXt_zhxgrid(String xt_zhxgrid) {
		this.xt_zhxgrid = xt_zhxgrid;
	}
	public String getXt_zhxgrbm() {
		return xt_zhxgrbm;
	}
	public void setXt_zhxgrbm(String xt_zhxgrbm) {
		this.xt_zhxgrbm = xt_zhxgrbm;
	}
	public String getXt_zhxgrbmid() {
		return xt_zhxgrbmid;
	}
	public void setXt_zhxgrbmid(String xt_zhxgrbmid) {
		this.xt_zhxgrbmid = xt_zhxgrbmid;
	}
	public String getXt_zhxgip() {
		return xt_zhxgip;
	}
	public void setXt_zhxgip(String xt_zhxgip) {
		this.xt_zhxgip = xt_zhxgip;
	}
	public String getXt_zxbz() {
		return xt_zxbz;
	}
	public void setXt_zxbz(String xt_zxbz) {
		this.xt_zxbz = xt_zxbz;
	}
	public String getXt_zxyy() {
		return xt_zxyy;
	}
	public void setXt_zxyy(String xt_zxyy) {
		this.xt_zxyy = xt_zxyy;
	}
	public String getBwbh() {
		return bwbh;
	}
	public void setBwbh(String bwbh) {
		this.bwbh = bwbh;
	}
	public String getBwmc() {
		return bwmc;
	}
	public void setBwmc(String bwmc) {
		this.bwmc = bwmc;
	}
	public String getBwwz() {
		return bwwz;
	}
	public void setBwwz(String bwwz) {
		this.bwwz = bwwz;
	}
	public String getBwfzr() {
		return bwfzr;
	}
	public void setBwfzr(String bwfzr) {
		this.bwfzr = bwfzr;
	}
	public String getBwfzrsfzh() {
		return bwfzrsfzh;
	}
	public void setBwfzrsfzh(String bwfzrsfzh) {
		this.bwfzrsfzh = bwfzrsfzh;
	}
	public String getBwfzrzw() {
		return bwfzrzw;
	}
	public void setBwfzrzw(String bwfzrzw) {
		this.bwfzrzw = bwfzrzw;
	}
	public String getBwfzrlxfs() {
		return bwfzrlxfs;
	}
	public void setBwfzrlxfs(String bwfzrlxfs) {
		this.bwfzrlxfs = bwfzrlxfs;
	}
	public String getBwzbdh() {
		return bwzbdh;
	}
	public void setBwzbdh(String bwzbdh) {
		this.bwzbdh = bwzbdh;
	}
	public String getWfssqk() {
		return wfssqk;
	}
	public void setWfssqk(String wfssqk) {
		this.wfssqk = wfssqk;
	}
	public String getJfssqk() {
		return jfssqk;
	}
	public void setJfssqk(String jfssqk) {
		this.jfssqk = jfssqk;
	}
	public String getBwqdsj() {
		return bwqdsj;
	}
	public void setBwqdsj(String bwqdsj) {
		this.bwqdsj = bwqdsj;
	}
	public String getBwqdlyyj() {
		return bwqdlyyj;
	}
	public void setBwqdlyyj(String bwqdlyyj) {
		this.bwqdlyyj = bwqdlyyj;
	}
}