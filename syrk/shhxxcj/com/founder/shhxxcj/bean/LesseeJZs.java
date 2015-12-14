package com.founder.shhxxcj.bean;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;

@DBInfoAnnotation(tableName = "LesseeZZs", pk = "id")
public class LesseeJZs {
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
	@FieldDesc("房屋所属派出所")
	private String fwszdpcscode;
	@FieldDesc("房屋所属分局")
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
	@FieldDesc("户籍地址补充说明")
	private String hjdzbcsm;
	@FieldDesc("寄住类别")
	private String jzlb;
	@FieldDesc("寄住原因")
	private String jzyy;
	@FieldDesc("寄住日期")
	private String jzrq;
	@FieldDesc("寄住省市县")
	private String jzssx;
	@FieldDesc("停租时间")
	private String czrtzsj;
	@FieldDesc("备注")
	private String bz;
	@FieldDesc("核实状态0未核实 1已核实")
	private String hszt;
	@FieldDesc("实有人口ID")
	private String syrkid;
	

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
	public String getHjdzbcsm() {
		return hjdzbcsm;
	}
	public void setHjdzbcsm(String hjdzbcsm) {
		this.hjdzbcsm = hjdzbcsm;
	}
	public String getJzlb() {
		return jzlb;
	}
	public void setJzlb(String jzlb) {
		this.jzlb = jzlb;
	}
	public String getJzyy() {
		return jzyy;
	}
	public void setJzyy(String jzyy) {
		this.jzyy = jzyy;
	}
	public String getJzrq() {
		return jzrq;
	}
	public void setJzrq(String jzrq) {
		this.jzrq = jzrq;
	}
	public String getJzssx() {
		return jzssx;
	}
	public void setJzssx(String jzssx) {
		this.jzssx = jzssx;
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

	
	
	
}
