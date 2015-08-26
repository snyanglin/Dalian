package com.founder.jcj.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;
@DBInfoAnnotation(tableName = "JCJ_FKXXB", pk = "id")
public class JcjFkxxb extends BaseEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@FieldDesc("反馈ID")private String id;
	@FieldDesc("行政区划代码")private String xzqhdm;
	@FieldDesc("反馈单编号")private String fkdbh;
	@FieldDesc("接警编号")private String jjbh;
	@FieldDesc("处警单编号")private String cjdbh;
	@FieldDesc("反馈录音号")private String fklyh;
	@FieldDesc("反馈单位代码")private String fkdwdm;
	@FieldDesc("反馈警员编号")private String fkjybh;
	@FieldDesc("反馈警员_姓名")private String fkjy_xm;
	@FieldDesc("警情类别代码")private String jqlbdm;
	@FieldDesc("警情类型代码")private String jqlxdm;
	@FieldDesc("警情细类代码")private String jqxldm;
	@FieldDesc("警情发生_时间")private String jqfs_sj;
	@FieldDesc("警情结束_时间")private String jqjs_sj;
	@FieldDesc("警情等级代码")private String jqdjdm;
	@FieldDesc("火灾等级代码")private String hzdjdm;
	@FieldDesc("到达现场_时间")private String ddxc_sj;
	@FieldDesc("处理完毕_时间")private String clwb_sj;
	@FieldDesc("出警情况")private String cjqk;
	@FieldDesc("处理结果代码")private String cljgdm;
	@FieldDesc("处理结果")private String cljg;
	@FieldDesc("出动车辆情况")private String cdclqk;
	@FieldDesc("出动人员情况")private String cdryqk;
	@FieldDesc("抓获_人数")private Long zh_rs=(long) 0;
	@FieldDesc("涉案_人数")private Long sa_rs=(long) 0;
	@FieldDesc("救助_人数")private Long jz_rs=(long) 0;
	@FieldDesc("救助人数说明")private String jzrssm;
	@FieldDesc("解救_人数")private Long jj_rs=(long) 0;
	@FieldDesc("解救人数说明")private String jjrssm;
	@FieldDesc("逃跑_人数")private Long jj_rf=(long) 0;
	@FieldDesc("受伤_人数")private Long ss_rs=(long) 0;
	@FieldDesc("受伤人数说明")private String ssrssm;
	@FieldDesc("死亡_人数")private Long sw_rs=(long) 0;
	@FieldDesc("死亡人数说明")private String swrssm;
	@FieldDesc("待救援_人数")private Long djy_rs=(long) 0;
	@FieldDesc("出警人员受伤_人数")private Long cjryss_rs=(long) 0;
	@FieldDesc("出警人员死亡_人数")private Long cjrysw_rs=(long) 0;
	@FieldDesc("经济损失")private String jjssqk;
	@FieldDesc("挽回经济损失")private String whjjssqk;
	@FieldDesc("是否破获刑事案件")private String sfphxsaj;
	@FieldDesc("是否查处治安案件")private String sfcczaaj;
	@FieldDesc("是否解决纠纷")private String sfjjjf;
	@FieldDesc("留置审查_人数")private Long lzsc_rs=(long) 0;
	@FieldDesc("警情_处理结果")private String jqcl_jg;
	@FieldDesc("天气代码")private String tqdm;
	@FieldDesc("损失情况描述")private String ssqkms;
	@FieldDesc("反馈_时间")private String fk_sj;
	@FieldDesc("火灾原因代码")private String hzyydm;
	@FieldDesc("灾害事故类型代码")private String zhsglxdm;
	@FieldDesc("起火物代码")private String qhwdm;
	@FieldDesc("起火建筑结构代码")private String qhjzjgdm;
	@FieldDesc("火灾场所代码")private String hzcsdm;
	@FieldDesc("第一出动_时间")private String dycd_sj;
	@FieldDesc("第一到场_时间")private String dydc_sj;
	@FieldDesc("火场扑灭_时间")private String hcpm_sj;
	@FieldDesc("撤离_时间")private String cl_sj;
	@FieldDesc("现场总指挥")private String xczzh;
	@FieldDesc("出动水枪数")private Long cdsqs=(long) 0;
	@FieldDesc("是否重点单位")private String sfzddw;
	@FieldDesc("重点_单位名称")private String zd_dwmc;
	@FieldDesc("下落不明_人数")private Long xlbm_rs=(long) 0;
	@FieldDesc("道路交通事故形态代码")private String dljtsgxtdm;
	@FieldDesc("是否装载危险品")private String sfwhp;
	@FieldDesc("交通事故初查原因代码")private String sgccyydm;
	@FieldDesc("能见度代码")private String njddm;
	@FieldDesc("道路路面状况代码")private String dllmzkdm;
	@FieldDesc("损坏机动车数")private Long shjdcs=(long) 0;
	@FieldDesc("损坏非机动车数")private Long shfjdcs=(long) 0;
	@FieldDesc("道路类型代码")private String dllxdm;
	@FieldDesc("警情状态代码")private String jqztdm;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getXzqhdm() {
		return xzqhdm;
	}
	public void setXzqhdm(String xzqhdm) {
		this.xzqhdm = xzqhdm;
	}
	public String getFkdbh() {
		return fkdbh;
	}
	public void setFkdbh(String fkdbh) {
		this.fkdbh = fkdbh;
	}
	public String getJjbh() {
		return jjbh;
	}
	public void setJjbh(String jjbh) {
		this.jjbh = jjbh;
	}
	public String getCjdbh() {
		return cjdbh;
	}
	public void setCjdbh(String cjdbh) {
		this.cjdbh = cjdbh;
	}
	public String getFklyh() {
		return fklyh;
	}
	public void setFklyh(String fklyh) {
		this.fklyh = fklyh;
	}
	public String getFkdwdm() {
		return fkdwdm;
	}
	public void setFkdwdm(String fkdwdm) {
		this.fkdwdm = fkdwdm;
	}
	public String getFkjybh() {
		return fkjybh;
	}
	public void setFkjybh(String fkjybh) {
		this.fkjybh = fkjybh;
	}
	public String getFkjy_xm() {
		return fkjy_xm;
	}
	public void setFkjy_xm(String fkjy_xm) {
		this.fkjy_xm = fkjy_xm;
	}
	public String getJqlbdm() {
		return jqlbdm;
	}
	public void setJqlbdm(String jqlbdm) {
		this.jqlbdm = jqlbdm;
	}
	public String getJqlxdm() {
		return jqlxdm;
	}
	public void setJqlxdm(String jqlxdm) {
		this.jqlxdm = jqlxdm;
	}
	public String getJqxldm() {
		return jqxldm;
	}
	public void setJqxldm(String jqxldm) {
		this.jqxldm = jqxldm;
	}
	public String getJqfs_sj() {
		return jqfs_sj;
	}
	public void setJqfs_sj(String jqfs_sj) {
		this.jqfs_sj = jqfs_sj;
	}
	public String getJqjs_sj() {
		return jqjs_sj;
	}
	public void setJqjs_sj(String jqjs_sj) {
		this.jqjs_sj = jqjs_sj;
	}
	public String getJqdjdm() {
		return jqdjdm;
	}
	public void setJqdjdm(String jqdjdm) {
		this.jqdjdm = jqdjdm;
	}
	public String getHzdjdm() {
		return hzdjdm;
	}
	public void setHzdjdm(String hzdjdm) {
		this.hzdjdm = hzdjdm;
	}
	public String getDdxc_sj() {
		return ddxc_sj;
	}
	public void setDdxc_sj(String ddxc_sj) {
		this.ddxc_sj = ddxc_sj;
	}
	public String getClwb_sj() {
		return clwb_sj;
	}
	public void setClwb_sj(String clwb_sj) {
		this.clwb_sj = clwb_sj;
	}
	public String getCjqk() {
		return cjqk;
	}
	public void setCjqk(String cjqk) {
		this.cjqk = cjqk;
	}
	public String getCljgdm() {
		return cljgdm;
	}
	public void setCljgdm(String cljgdm) {
		this.cljgdm = cljgdm;
	}
	public String getCljg() {
		return cljg;
	}
	public void setCljg(String cljg) {
		this.cljg = cljg;
	}
	public String getCdclqk() {
		return cdclqk;
	}
	public void setCdclqk(String cdclqk) {
		this.cdclqk = cdclqk;
	}
	public String getCdryqk() {
		return cdryqk;
	}
	public void setCdryqk(String cdryqk) {
		this.cdryqk = cdryqk;
	}
	public Long getZh_rs() {
		return zh_rs;
	}
	public void setZh_rs(Long zh_rs) {
		this.zh_rs = zh_rs;
	}
	public Long getSa_rs() {
		return sa_rs;
	}
	public void setSa_rs(Long sa_rs) {
		this.sa_rs = sa_rs;
	}
	public Long getJz_rs() {
		return jz_rs;
	}
	public void setJz_rs(Long jz_rs) {
		this.jz_rs = jz_rs;
	}
	public String getJzrssm() {
		return jzrssm;
	}
	public void setJzrssm(String jzrssm) {
		this.jzrssm = jzrssm;
	}
	public Long getJj_rs() {
		return jj_rs;
	}
	public void setJj_rs(Long jj_rs) {
		this.jj_rs = jj_rs;
	}
	public String getJjrssm() {
		return jjrssm;
	}
	public void setJjrssm(String jjrssm) {
		this.jjrssm = jjrssm;
	}
	public Long getJj_rf() {
		return jj_rf;
	}
	public void setJj_rf(Long jj_rf) {
		this.jj_rf = jj_rf;
	}
	public Long getSs_rs() {
		return ss_rs;
	}
	public void setSs_rs(Long ss_rs) {
		this.ss_rs = ss_rs;
	}
	public String getSsrssm() {
		return ssrssm;
	}
	public void setSsrssm(String ssrssm) {
		this.ssrssm = ssrssm;
	}
	public Long getSw_rs() {
		return sw_rs;
	}
	public void setSw_rs(Long sw_rs) {
		this.sw_rs = sw_rs;
	}
	public String getSwrssm() {
		return swrssm;
	}
	public void setSwrssm(String swrssm) {
		this.swrssm = swrssm;
	}
	public Long getDjy_rs() {
		return djy_rs;
	}
	public void setDjy_rs(Long djy_rs) {
		this.djy_rs = djy_rs;
	}
	public Long getCjryss_rs() {
		return cjryss_rs;
	}
	public void setCjryss_rs(Long cjryss_rs) {
		this.cjryss_rs = cjryss_rs;
	}
	public Long getCjrysw_rs() {
		return cjrysw_rs;
	}
	public void setCjrysw_rs(Long cjrysw_rs) {
		this.cjrysw_rs = cjrysw_rs;
	}
	public String getJjssqk() {
		return jjssqk;
	}
	public void setJjssqk(String jjssqk) {
		this.jjssqk = jjssqk;
	}
	public String getWhjjssqk() {
		return whjjssqk;
	}
	public void setWhjjssqk(String whjjssqk) {
		this.whjjssqk = whjjssqk;
	}
	public String getSfphxsaj() {
		return sfphxsaj;
	}
	public void setSfphxsaj(String sfphxsaj) {
		this.sfphxsaj = sfphxsaj;
	}
	public String getSfcczaaj() {
		return sfcczaaj;
	}
	public void setSfcczaaj(String sfcczaaj) {
		this.sfcczaaj = sfcczaaj;
	}
	public String getSfjjjf() {
		return sfjjjf;
	}
	public void setSfjjjf(String sfjjjf) {
		this.sfjjjf = sfjjjf;
	}
	public Long getLzsc_rs() {
		return lzsc_rs;
	}
	public void setLzsc_rs(Long lzsc_rs) {
		this.lzsc_rs = lzsc_rs;
	}
	public String getJqcl_jg() {
		return jqcl_jg;
	}
	public void setJqcl_jg(String jqcl_jg) {
		this.jqcl_jg = jqcl_jg;
	}
	public String getTqdm() {
		return tqdm;
	}
	public void setTqdm(String tqdm) {
		this.tqdm = tqdm;
	}
	public String getSsqkms() {
		return ssqkms;
	}
	public void setSsqkms(String ssqkms) {
		this.ssqkms = ssqkms;
	}
	public String getFk_sj() {
		return fk_sj;
	}
	public void setFk_sj(String fk_sj) {
		this.fk_sj = fk_sj;
	}
	public String getHzyydm() {
		return hzyydm;
	}
	public void setHzyydm(String hzyydm) {
		this.hzyydm = hzyydm;
	}
	public String getZhsglxdm() {
		return zhsglxdm;
	}
	public void setZhsglxdm(String zhsglxdm) {
		this.zhsglxdm = zhsglxdm;
	}
	public String getQhwdm() {
		return qhwdm;
	}
	public void setQhwdm(String qhwdm) {
		this.qhwdm = qhwdm;
	}
	public String getQhjzjgdm() {
		return qhjzjgdm;
	}
	public void setQhjzjgdm(String qhjzjgdm) {
		this.qhjzjgdm = qhjzjgdm;
	}
	public String getHzcsdm() {
		return hzcsdm;
	}
	public void setHzcsdm(String hzcsdm) {
		this.hzcsdm = hzcsdm;
	}
	public String getDycd_sj() {
		return dycd_sj;
	}
	public void setDycd_sj(String dycd_sj) {
		this.dycd_sj = dycd_sj;
	}
	public String getDydc_sj() {
		return dydc_sj;
	}
	public void setDydc_sj(String dydc_sj) {
		this.dydc_sj = dydc_sj;
	}
	public String getHcpm_sj() {
		return hcpm_sj;
	}
	public void setHcpm_sj(String hcpm_sj) {
		this.hcpm_sj = hcpm_sj;
	}
	public String getCl_sj() {
		return cl_sj;
	}
	public void setCl_sj(String cl_sj) {
		this.cl_sj = cl_sj;
	}
	public String getXczzh() {
		return xczzh;
	}
	public void setXczzh(String xczzh) {
		this.xczzh = xczzh;
	}
	public Long getCdsqs() {
		return cdsqs;
	}
	public void setCdsqs(Long cdsqs) {
		this.cdsqs = cdsqs;
	}
	public String getSfzddw() {
		return sfzddw;
	}
	public void setSfzddw(String sfzddw) {
		this.sfzddw = sfzddw;
	}
	public String getZd_dwmc() {
		return zd_dwmc;
	}
	public void setZd_dwmc(String zd_dwmc) {
		this.zd_dwmc = zd_dwmc;
	}
	public Long getXlbm_rs() {
		return xlbm_rs;
	}
	public void setXlbm_rs(Long xlbm_rs) {
		this.xlbm_rs = xlbm_rs;
	}
	public String getDljtsgxtdm() {
		return dljtsgxtdm;
	}
	public void setDljtsgxtdm(String dljtsgxtdm) {
		this.dljtsgxtdm = dljtsgxtdm;
	}
	public String getSfwhp() {
		return sfwhp;
	}
	public void setSfwhp(String sfwhp) {
		this.sfwhp = sfwhp;
	}
	public String getSgccyydm() {
		return sgccyydm;
	}
	public void setSgccyydm(String sgccyydm) {
		this.sgccyydm = sgccyydm;
	}
	public String getNjddm() {
		return njddm;
	}
	public void setNjddm(String njddm) {
		this.njddm = njddm;
	}
	public String getDllmzkdm() {
		return dllmzkdm;
	}
	public void setDllmzkdm(String dllmzkdm) {
		this.dllmzkdm = dllmzkdm;
	}
	public Long getShjdcs() {
		return shjdcs;
	}
	public void setShjdcs(Long shjdcs) {
		this.shjdcs = shjdcs;
	}
	public Long getShfjdcs() {
		return shfjdcs;
	}
	public void setShfjdcs(Long shfjdcs) {
		this.shfjdcs = shfjdcs;
	}
	public String getDllxdm() {
		return dllxdm;
	}
	public void setDllxdm(String dllxdm) {
		this.dllxdm = dllxdm;
	}
	public String getJqztdm() {
		return jqztdm;
	}
	public void setJqztdm(String jqztdm) {
		this.jqztdm = jqztdm;
	}
	
	
	
	
	
	
}