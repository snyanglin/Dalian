package com.founder.shhxxcj.bean;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;

@DBInfoAnnotation(tableName = "LesseeZZs", pk = "id")
public class LesseeZZs {
	
	@FieldDesc("编号")
	private String id;
	@FieldDesc("所属房屋编号")
	private String houseid;
	@FieldDesc("所属企业编号")
	private String enterpriseid;
	@FieldDesc("创建时间")
	private String createdate;
	@FieldDesc("录入单位所属派出所")
	private String pcscode;
	@FieldDesc("录入单位所属分局")
	private String fenjucode;
	@FieldDesc("房屋所在地派出所")
	private String fwszdpcscode;
	@FieldDesc("房屋所在地分局")
	private String fwszdfenjucode;
	@FieldDesc("企业名称")
	private String entname;
	@FieldDesc("最后修改时间")
	private String lastchangedate;
	@FieldDesc("录入警综时间")
	private String accessdate;
	@FieldDesc("承租人类别")
	private String czrlb;
	@FieldDesc("户籍地址")
	private String czrhjdz;
	@FieldDesc("证件类别")
	private String czrzjlb;
	@FieldDesc("证件号码")
	private String czrzjhm;
	@FieldDesc("身份证号码")
	private String czrsfzhm;
	@FieldDesc("国籍")
	private String czrgj;
	@FieldDesc("英文姓名")
	private String czrywm;
	@FieldDesc("中文姓名")
	private String czrzwxm;
	@FieldDesc("性别")
	private String czrxb;
	@FieldDesc("出生日期")
	private String czrcsrq;
	@FieldDesc("民族")
	private String czrmz;
	@FieldDesc("联系电话")
	private String czrlxdh;
	@FieldDesc("与房主关系")
	private String czryfzgx;
	@FieldDesc("承租情况")
	private String czrczqk;
	@FieldDesc("起租时间")
	private String czrqzsj;
	@FieldDesc("户口类别")
	private String hklb;
	@FieldDesc("来自地区")
	private String lzdq;
	@FieldDesc("文化程度")
	private String whcd;
	@FieldDesc("婚姻状况")
	private String hyzk;
	@FieldDesc("职业类别")
	private String zylb;
	@FieldDesc("来本地日期")
	private String lbdrq;
	@FieldDesc("暂住事由")
	private String zzsy;
	@FieldDesc("政治面貌")
	private String zzmm;
	@FieldDesc("暂住处所")
	private String zzcs;
	@FieldDesc("服务处所")
	private String fwcs;
	@FieldDesc("人员等级")
	private String rydj;
	@FieldDesc("从事职业")
	private String cszy;
	@FieldDesc("停租时间")
	private String czrtzsj;
	@FieldDesc("备注")
	private String bz;
	@FieldDesc("核实状态0未核实1已核实")
	private String hszt;
	@FieldDesc("实有人口ID")
	private String syrkid;
	//暂住或寄住 zz  jz
	private String type;
	
	private String ryid;
	
	
	
	public String getRyid() {
		return ryid;
	}
	public void setRyid(String ryid) {
		this.ryid = ryid;
	}
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getHszt() {
		return hszt;
	}
	public void setHszt(String hszt) {
		this.hszt = hszt;
	}
	public String getSyrkid() {
		return syrkid;
	}
	public void setSyrkid(String syrkid) {
		this.syrkid = syrkid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHouseid() {
		return houseid;
	}
	public void setHouseid(String houseid) {
		this.houseid = houseid;
	}
	public String getEnterpriseid() {
		return enterpriseid;
	}
	public void setEnterpriseid(String enterpriseid) {
		this.enterpriseid = enterpriseid;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	public String getPcscode() {
		return pcscode;
	}
	public void setPcscode(String pcscode) {
		this.pcscode = pcscode;
	}
	public String getFenjucode() {
		return fenjucode;
	}
	public void setFenjucode(String fenjucode) {
		this.fenjucode = fenjucode;
	}
	public String getFwszdpcscode() {
		return fwszdpcscode;
	}
	public void setFwszdpcscode(String fwszdpcscode) {
		this.fwszdpcscode = fwszdpcscode;
	}
	public String getFwszdfenjucode() {
		return fwszdfenjucode;
	}
	public void setFwszdfenjucode(String fwszdfenjucode) {
		this.fwszdfenjucode = fwszdfenjucode;
	}
	public String getEntname() {
		return entname;
	}
	public void setEntname(String entname) {
		this.entname = entname;
	}
	public String getLastchangedate() {
		return lastchangedate;
	}
	public void setLastchangedate(String lastchangedate) {
		this.lastchangedate = lastchangedate;
	}
	public String getAccessdate() {
		return accessdate;
	}
	public void setAccessdate(String accessdate) {
		this.accessdate = accessdate;
	}
	public String getCzrlb() {
		return czrlb;
	}
	public void setCzrlb(String czrlb) {
		this.czrlb = czrlb;
	}
	public String getCzrhjdz() {
		return czrhjdz;
	}
	public void setCzrhjdz(String czrhjdz) {
		this.czrhjdz = czrhjdz;
	}
	public String getCzrzjlb() {
		return czrzjlb;
	}
	public void setCzrzjlb(String czrzjlb) {
		this.czrzjlb = czrzjlb;
	}
	public String getCzrzjhm() {
		return czrzjhm;
	}
	public void setCzrzjhm(String czrzjhm) {
		this.czrzjhm = czrzjhm;
	}
	public String getCzrsfzhm() {
		return czrsfzhm;
	}
	public void setCzrsfzhm(String czrsfzhm) {
		this.czrsfzhm = czrsfzhm;
	}
	public String getCzrgj() {
		return czrgj;
	}
	public void setCzrgj(String czrgj) {
		this.czrgj = czrgj;
	}
	public String getCzrywm() {
		return czrywm;
	}
	public void setCzrywm(String czrywm) {
		this.czrywm = czrywm;
	}
	public String getCzrzwxm() {
		return czrzwxm;
	}
	public void setCzrzwxm(String czrzwxm) {
		this.czrzwxm = czrzwxm;
	}
	public String getCzrxb() {
		return czrxb;
	}
	public void setCzrxb(String czrxb) {
		this.czrxb = czrxb;
	}
	public String getCzrcsrq() {
		return czrcsrq;
	}
	public void setCzrcsrq(String czrcsrq) {
		this.czrcsrq = czrcsrq;
	}
	public String getCzrmz() {
		return czrmz;
	}
	public void setCzrmz(String czrmz) {
		this.czrmz = czrmz;
	}
	public String getCzrlxdh() {
		return czrlxdh;
	}
	public void setCzrlxdh(String czrlxdh) {
		this.czrlxdh = czrlxdh;
	}
	public String getCzryfzgx() {
		return czryfzgx;
	}
	public void setCzryfzgx(String czryfzgx) {
		this.czryfzgx = czryfzgx;
	}
	public String getCzrczqk() {
		return czrczqk;
	}
	public void setCzrczqk(String czrczqk) {
		this.czrczqk = czrczqk;
	}
	public String getCzrqzsj() {
		return czrqzsj;
	}
	public void setCzrqzsj(String czrqzsj) {
		this.czrqzsj = czrqzsj;
	}
	public String getHklb() {
		return hklb;
	}
	public void setHklb(String hklb) {
		this.hklb = hklb;
	}
	public String getLzdq() {
		return lzdq;
	}
	public void setLzdq(String lzdq) {
		this.lzdq = lzdq;
	}
	public String getWhcd() {
		return whcd;
	}
	public void setWhcd(String whcd) {
		this.whcd = whcd;
	}
	public String getHyzk() {
		return hyzk;
	}
	public void setHyzk(String hyzk) {
		this.hyzk = hyzk;
	}
	public String getZylb() {
		return zylb;
	}
	public void setZylb(String zylb) {
		this.zylb = zylb;
	}
	public String getLbdrq() {
		return lbdrq;
	}
	public void setLbdrq(String lbdrq) {
		this.lbdrq = lbdrq;
	}
	public String getZzsy() {
		return zzsy;
	}
	public void setZzsy(String zzsy) {
		this.zzsy = zzsy;
	}
	public String getZzmm() {
		return zzmm;
	}
	public void setZzmm(String zzmm) {
		this.zzmm = zzmm;
	}
	public String getZzcs() {
		return zzcs;
	}
	public void setZzcs(String zzcs) {
		this.zzcs = zzcs;
	}
	public String getFwcs() {
		return fwcs;
	}
	public void setFwcs(String fwcs) {
		this.fwcs = fwcs;
	}
	public String getRydj() {
		return rydj;
	}
	public void setRydj(String rydj) {
		this.rydj = rydj;
	}
	public String getCszy() {
		return cszy;
	}
	public void setCszy(String cszy) {
		this.cszy = cszy;
	}
	public String getCzrtzsj() {
		return czrtzsj;
	}
	public void setCzrtzsj(String czrtzsj) {
		this.czrtzsj = czrtzsj;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}

	
}
