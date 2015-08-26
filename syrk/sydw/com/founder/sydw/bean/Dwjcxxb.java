package com.founder.sydw.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;
@DBInfoAnnotation(tableName = "DW_DWJCXXB", pk = "id")
public class Dwjcxxb extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@FieldDesc("ID")
	private String id;
	@FieldDesc("单位ID")
	private String dwid;
	@FieldDesc("检查时间")
	private String jcsj;
	@FieldDesc("检查时间（至）")
	private String jcsjz;
	@FieldDesc("检查单位ID")
	private String jcdwid;
	@FieldDesc("检查单位")
	private String jcdw;
	@FieldDesc("检查结果")
	private String jcjg;
	@FieldDesc("整改通知书或裁决书号")
	private String zgtzshcjsh;
	@FieldDesc("整改通知书名称")
	private String zgtzsmc;
	@FieldDesc("整改或处罚意见")
	private String zghcfyj;
	@FieldDesc("单位负责人")
	private String dwfzr;
	@FieldDesc("单位负责人联系电话")
	private String dwfzrlxdh;
	@FieldDesc("检查人员")
	private String jcry;
	@FieldDesc("现场负责人")
	private String xcfzr;
	@FieldDesc("现场负责人联系电话")
	private String xcfzrlxdh;
	@FieldDesc("参检人数")
	private String cjrs;
	@FieldDesc("检查项明细")
	private String jcxmx;
	@FieldDesc("其他违规情况和安全隐患")
	private String qtwgqkhaqyh;
	@FieldDesc("单位名称")
	private String dwmc;
	@FieldDesc("单位类别代码")
	private String dwlbdm;
	@FieldDesc("业务类别代码")
	private String ywlbdm;
	@FieldDesc("备注")
	private String bz;
	@FieldDesc("url")
	private String url;
	@FieldDesc("经营类型")
	private String jjlxdm;
	@FieldDesc("使用的建筑面积")
	private String sydjzmj;
	@FieldDesc("使用的建筑具体层数")
	private String sydjzjtcs;
	@FieldDesc("所在建筑高度")
	private String szjzgd;
	@FieldDesc("地址-单位地址代码")
	private String dz_dwdzdm;
	@FieldDesc("地址-单位地址省市县代码")
	private String dz_dwdzssxdm;
	@FieldDesc("地址-单位地址详址")
	private String dz_dwdzxz;
	@FieldDesc("地址-单位地址门楼牌代码")
	private String dz_dwdzmlpdm;
	@FieldDesc("地址-单位地址门楼牌详址")
	private String dz_dwdzmlpxz;
	@FieldDesc("状态")
	private String zt;
	@FieldDesc("被检查人签名")
	private String bjcryxm;
	@FieldDesc("被检查人联系电话")
	private String bjcrylxdh;
	@FieldDesc("被检查单位法定代表人姓名")
	private String fddbrxm;
	@FieldDesc("被检查单位法定代表人联系电话")
	private String fddbrlxdh;
	@FieldDesc("任务ID")
	private String rwid;
	@FieldDesc("管理部门ID")
	private String glbmid;
	@FieldDesc("管理派出所ID")
	private String glpcsid;
	@FieldDesc("管理分县局ID")
	private String glfxjid;
	private List<Dwjctype> list = new ArrayList<Dwjctype>();
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
	public String getJcsj() {
		return jcsj;
	}
	public void setJcsj(String jcsj) {
		this.jcsj = jcsj;
	}
	public String getJcdwid() {
		return jcdwid;
	}
	public void setJcdwid(String jcdwid) {
		this.jcdwid = jcdwid;
	}
	public String getJcdw() {
		return jcdw;
	}
	public void setJcdw(String jcdw) {
		this.jcdw = jcdw;
	}
	public String getJcjg() {
		return jcjg;
	}
	public void setJcjg(String jcjg) {
		this.jcjg = jcjg;
	}
	public String getZgtzshcjsh() {
		return zgtzshcjsh;
	}
	public void setZgtzshcjsh(String zgtzshcjsh) {
		this.zgtzshcjsh = zgtzshcjsh;
	}
	public String getZgtzsmc() {
		return zgtzsmc;
	}
	public void setZgtzsmc(String zgtzsmc) {
		this.zgtzsmc = zgtzsmc;
	}
	
	public String getZghcfyj() {
		return zghcfyj;
	}
	public void setZghcfyj(String zghcfyj) {
		this.zghcfyj = zghcfyj;
	}
	public String getDwfzr() {
		return dwfzr;
	}
	public void setDwfzr(String dwfzr) {
		this.dwfzr = dwfzr;
	}
	public String getJcry() {
		return jcry;
	}
	public void setJcry(String jcry) {
		this.jcry = jcry;
	}
	public String getXcfzr() {
		return xcfzr;
	}
	public void setXcfzr(String xcfzr) {
		this.xcfzr = xcfzr;
	}
	public List<Dwjctype> getList() {
		return list;
	}
	public void setList(List<Dwjctype> list) {
		this.list = list;
	}
	public String getJcxmx() {
		return jcxmx;
	}
	public void setJcxmx(String jcxmx) {
		this.jcxmx = jcxmx;
	}
	public String getDwfzrlxdh() {
		return dwfzrlxdh;
	}
	public void setDwfzrlxdh(String dwfzrlxdh) {
		this.dwfzrlxdh = dwfzrlxdh;
	}
	public String getXcfzrlxdh() {
		return xcfzrlxdh;
	}
	public void setXcfzrlxdh(String xcfzrlxdh) {
		this.xcfzrlxdh = xcfzrlxdh;
	}
	public String getCjrs() {
		return cjrs;
	}
	public void setCjrs(String cjrs) {
		this.cjrs = cjrs;
	}
	public String getQtwgqkhaqyh() {
		return qtwgqkhaqyh;
	}
	public void setQtwgqkhaqyh(String qtwgqkhaqyh) {
		this.qtwgqkhaqyh = qtwgqkhaqyh;
	}
	public String getDwmc() {
		return dwmc;
	}
	public void setDwmc(String dwmc) {
		this.dwmc = dwmc;
	}
	public String getJcsjz() {
		return jcsjz;
	}
	public void setJcsjz(String jcsjz) {
		this.jcsjz = jcsjz;
	}
	public String getDwlbdm() {
		return dwlbdm;
	}
	public void setDwlbdm(String dwlbdm) {
		this.dwlbdm = dwlbdm;
	}
	public String getYwlbdm() {
		return ywlbdm;
	}
	public void setYwlbdm(String ywlbdm) {
		this.ywlbdm = ywlbdm;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getJjlxdm() {
		return jjlxdm;
	}
	public void setJjlxdm(String jjlxdm) {
		this.jjlxdm = jjlxdm;
	}
	public String getSydjzmj() {
		return sydjzmj;
	}
	public void setSydjzmj(String sydjzmj) {
		this.sydjzmj = sydjzmj;
	}
	public String getSydjzjtcs() {
		return sydjzjtcs;
	}
	public void setSydjzjtcs(String sydjzjtcs) {
		this.sydjzjtcs = sydjzjtcs;
	}
	public String getSzjzgd() {
		return szjzgd;
	}
	public void setSzjzgd(String szjzgd) {
		this.szjzgd = szjzgd;
	}
	public String getDz_dwdzdm() {
		return dz_dwdzdm;
	}
	public void setDz_dwdzdm(String dz_dwdzdm) {
		this.dz_dwdzdm = dz_dwdzdm;
	}
	public String getDz_dwdzssxdm() {
		return dz_dwdzssxdm;
	}
	public void setDz_dwdzssxdm(String dz_dwdzssxdm) {
		this.dz_dwdzssxdm = dz_dwdzssxdm;
	}
	public String getDz_dwdzxz() {
		return dz_dwdzxz;
	}
	public void setDz_dwdzxz(String dz_dwdzxz) {
		this.dz_dwdzxz = dz_dwdzxz;
	}
	public String getDz_dwdzmlpdm() {
		return dz_dwdzmlpdm;
	}
	public void setDz_dwdzmlpdm(String dz_dwdzmlpdm) {
		this.dz_dwdzmlpdm = dz_dwdzmlpdm;
	}
	public String getDz_dwdzmlpxz() {
		return dz_dwdzmlpxz;
	}
	public void setDz_dwdzmlpxz(String dz_dwdzmlpxz) {
		this.dz_dwdzmlpxz = dz_dwdzmlpxz;
	}
	public String getZt() {
		return zt;
	}
	public void setZt(String zt) {
		this.zt = zt;
	}
	public String getBjcryxm() {
		return bjcryxm;
	}
	public void setBjcryxm(String bjcryxm) {
		this.bjcryxm = bjcryxm;
	}
	public String getBjcrylxdh() {
		return bjcrylxdh;
	}
	public void setBjcrylxdh(String bjcrylxdh) {
		this.bjcrylxdh = bjcrylxdh;
	}
	public String getFddbrxm() {
		return fddbrxm;
	}
	public void setFddbrxm(String fddbrxm) {
		this.fddbrxm = fddbrxm;
	}
	public String getFddbrlxdh() {
		return fddbrlxdh;
	}
	public void setFddbrlxdh(String fddbrlxdh) {
		this.fddbrlxdh = fddbrlxdh;
	}
	public String getRwid() {
		return rwid;
	}
	public void setRwid(String rwid) {
		this.rwid = rwid;
	}
	public String getGlbmid() {
		return glbmid;
	}
	public void setGlbmid(String glbmid) {
		this.glbmid = glbmid;
	}
	public String getGlpcsid() {
		return glpcsid;
	}
	public void setGlpcsid(String glpcsid) {
		this.glpcsid = glpcsid;
	}
	public String getGlfxjid() {
		return glfxjid;
	}
	public void setGlfxjid(String glfxjid) {
		this.glfxjid = glfxjid;
	}
}
