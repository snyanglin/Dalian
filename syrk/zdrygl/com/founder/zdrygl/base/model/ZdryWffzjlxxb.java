package com.founder.zdrygl.base.model;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;
/***
 * ****************************************************************************
 * @Package:      [com.founder.zdry.bean.Wffzjlxxb.java]  
 * @ClassName:    [Wffzjlxxb]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [wu_chunhui@founder.com.cn]  
 * @CreateDate:   [2015-3-11 下午6:12:53]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-3-11 下午6:12:53，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "ZDRY_WFFZJLXXB", pk = "id")
public class ZdryWffzjlxxb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@FieldDesc("违法犯罪记录ID")private String id;
	@FieldDesc("重点人员ID")private String zdryid;
	@FieldDesc("案件编号")private String ajbh;
	@FieldDesc("案件名称")private String ajmc;
	@FieldDesc("案件类型代码")private String ajlxdm;
	@FieldDesc("涉刑事_案件类别代码")private String sxs_ajlbdm;
	@FieldDesc("涉行政_案件类别代码")private String sxz_ajlbdm;
	@FieldDesc("人员涉案类型代码")private String rysalxdm;
	@FieldDesc("案发_日期")private String af_rq;
	@FieldDesc("案发地点_行政区划代码")private String afdd_xzqhdm;
	@FieldDesc("案发地点_街路巷/小区/村屯代码")private String afdd_jlxxqctdm;
	@FieldDesc("案发地点详址")private String afddxz;
	@FieldDesc("案发地点_中心点横坐标")private Long afddzbx;
	@FieldDesc("案发地点_中心点纵坐标")private Long afddzby;
	@FieldDesc("涉案情节及处理结果")private String saqjjcljg;
	@FieldDesc("处理日期")private String clrq;
	@FieldDesc("处理单位机构代码")private String cldwdm;
	@FieldDesc("处理_单位名称")private String cl_dwmc;
	@FieldDesc("办案民警")private String bamj;
	@FieldDesc("问题性质代码")private String wtxzdm;
	@FieldDesc("处罚_时间")private String cfsj;
	@FieldDesc("处罚机关")private String cfjg;
	@FieldDesc("处罚程度代码")private String cfcddm;
	@FieldDesc("执行机关")private String zxjg;
	@FieldDesc("执行地点")private String zxdd;
	@FieldDesc("执行_开始时间")private String zx_kssj;
	@FieldDesc("执行_结束时间")private String zx_jssj;
	@FieldDesc("备注")private String bz;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getZdryid() {
		return zdryid;
	}
	public void setZdryid(String zdryid) {
		this.zdryid = zdryid;
	}
	public String getAjbh() {
		return ajbh;
	}
	public void setAjbh(String ajbh) {
		this.ajbh = ajbh;
	}
	public String getAjmc() {
		return ajmc;
	}
	public void setAjmc(String ajmc) {
		this.ajmc = ajmc;
	}
	public String getAjlxdm() {
		return ajlxdm;
	}
	public void setAjlxdm(String ajlxdm) {
		this.ajlxdm = ajlxdm;
	}
	public String getSxs_ajlbdm() {
		return sxs_ajlbdm;
	}
	public void setSxs_ajlbdm(String sxs_ajlbdm) {
		this.sxs_ajlbdm = sxs_ajlbdm;
	}
	public String getSxz_ajlbdm() {
		return sxz_ajlbdm;
	}
	public void setSxz_ajlbdm(String sxz_ajlbdm) {
		this.sxz_ajlbdm = sxz_ajlbdm;
	}
	public String getRysalxdm() {
		return rysalxdm;
	}
	public void setRysalxdm(String rysalxdm) {
		this.rysalxdm = rysalxdm;
	}
	public String getAf_rq() {
		return af_rq;
	}
	public void setAf_rq(String af_rq) {
		this.af_rq = af_rq;
	}
	public String getAfdd_xzqhdm() {
		return afdd_xzqhdm;
	}
	public void setAfdd_xzqhdm(String afdd_xzqhdm) {
		this.afdd_xzqhdm = afdd_xzqhdm;
	}
	public String getAfdd_jlxxqctdm() {
		return afdd_jlxxqctdm;
	}
	public void setAfdd_jlxxqctdm(String afdd_jlxxqctdm) {
		this.afdd_jlxxqctdm = afdd_jlxxqctdm;
	}
	public String getAfddxz() {
		return afddxz;
	}
	public void setAfddxz(String afddxz) {
		this.afddxz = afddxz;
	}
	public Long getAfddzbx() {
		return afddzbx;
	}
	public void setAfddzbx(Long afddzbx) {
		this.afddzbx = afddzbx;
	}
	public Long getAfddzby() {
		return afddzby;
	}
	public void setAfddzby(Long afddzby) {
		this.afddzby = afddzby;
	}
	public String getSaqjjcljg() {
		return saqjjcljg;
	}
	public void setSaqjjcljg(String saqjjcljg) {
		this.saqjjcljg = saqjjcljg;
	}
	public String getClrq() {
		return clrq;
	}
	public void setClrq(String clrq) {
		this.clrq = clrq;
	}
	public String getCldwdm() {
		return cldwdm;
	}
	public void setCldwdm(String cldwdm) {
		this.cldwdm = cldwdm;
	}
	public String getCl_dwmc() {
		return cl_dwmc;
	}
	public void setCl_dwmc(String cl_dwmc) {
		this.cl_dwmc = cl_dwmc;
	}
	public String getBamj() {
		return bamj;
	}
	public void setBamj(String bamj) {
		this.bamj = bamj;
	}
	public String getWtxzdm() {
		return wtxzdm;
	}
	public void setWtxzdm(String wtxzdm) {
		this.wtxzdm = wtxzdm;
	}
	public String getCfsj() {
		return cfsj;
	}
	public void setCfsj(String cfsj) {
		this.cfsj = cfsj;
	}
	public String getCfjg() {
		return cfjg;
	}
	public void setCfjg(String cfjg) {
		this.cfjg = cfjg;
	}
	public String getCfcddm() {
		return cfcddm;
	}
	public void setCfcddm(String cfcddm) {
		this.cfcddm = cfcddm;
	}
	public String getZxjg() {
		return zxjg;
	}
	public void setZxjg(String zxjg) {
		this.zxjg = zxjg;
	}
	public String getZxdd() {
		return zxdd;
	}
	public void setZxdd(String zxdd) {
		this.zxdd = zxdd;
	}
	public String getZx_kssj() {
		return zx_kssj;
	}
	public void setZx_kssj(String zx_kssj) {
		this.zx_kssj = zx_kssj;
	}
	public String getZx_jssj() {
		return zx_jssj;
	}
	public void setZx_jssj(String zx_jssj) {
		this.zx_jssj = zx_jssj;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}

}
