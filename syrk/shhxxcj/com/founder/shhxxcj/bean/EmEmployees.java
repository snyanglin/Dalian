package com.founder.shhxxcj.bean;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;


/******************************************************************************
 * @Package:      [com.founder.shhxxcj.bean.EmEnterprises.java]  
 * @ClassName:    [EmEnterprises]   
 * @Description:  [用工单位从业人员信息表]   
 * @Author:       [cong_rihong@founder.com.cn]  
 * @CreateDate:   [2015-11-20 下午12:28:57]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-11-20 下午12:28:57，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@DBInfoAnnotation(tableName = "EmEmployees", pk = "id")
public class EmEmployees {
	
	@FieldDesc("编号")
	private String id;
	@FieldDesc("姓名")
	private String xm;
	@FieldDesc("证件类别")
	private String zjlb;
	@FieldDesc("证件号码")
	private String zjhm;
	@FieldDesc("性别")
	private String xb;
	@FieldDesc("民族")
	private String mz;
	@FieldDesc("出生日期")
	private String csrq;
	@FieldDesc("有效日期")
	private String yxrq;
	@FieldDesc("签发机构")
	private String qfjg;
	@FieldDesc("家庭住址")
	private String hjdz;
	@FieldDesc("户口本地址")
	private String hkdz;
	@FieldDesc("暂住地址")
	private String xzdz;
	@FieldDesc("企业名称")
	private String entname;
	@FieldDesc("联系电话")
	private String lxdh;
	@FieldDesc("在职时间")
	private String zzsj;
	@FieldDesc("离职时间")
	private String lzsj;
	@FieldDesc("所属单位编号")
	private String enterpriseid;
	@FieldDesc("所属派出所")
	private String pcscode;
	@FieldDesc("所属分局")
	private String fenjucode;
	@FieldDesc("创建时间")
	private String createdate;
	@FieldDesc("在职还是离职")
	private Long status;
	@FieldDesc("暂住还是寄住")
	private String emtype;
	@FieldDesc("员工号")
	private String ygh;
	@FieldDesc("单位类别")
	private String dwlb;
	@FieldDesc("从业人员id")
	private String cyryid;
	@FieldDesc("核实状态（0未核实 1已核实）")
	private String hszt;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getXm() {
		return xm;
	}
	public void setXm(String xm) {
		this.xm = xm;
	}
	public String getZjlb() {
		return zjlb;
	}
	public void setZjlb(String zjlb) {
		this.zjlb = zjlb;
	}
	public String getZjhm() {
		return zjhm;
	}
	public void setZjhm(String zjhm) {
		this.zjhm = zjhm;
	}
	public String getXb() {
		return xb;
	}
	public void setXb(String xb) {
		this.xb = xb;
	}
	public String getMz() {
		return mz;
	}
	public void setMz(String mz) {
		this.mz = mz;
	}
	public String getCsrq() {
		return csrq;
	}
	public void setCsrq(String csrq) {
		this.csrq = csrq;
	}
	public String getYxrq() {
		return yxrq;
	}
	public void setYxrq(String yxrq) {
		this.yxrq = yxrq;
	}
	public String getQfjg() {
		return qfjg;
	}
	public void setQfjg(String qfjg) {
		this.qfjg = qfjg;
	}
	public String getHjdz() {
		return hjdz;
	}
	public void setHjdz(String hjdz) {
		this.hjdz = hjdz;
	}
	public String getHkdz() {
		return hkdz;
	}
	public void setHkdz(String hkdz) {
		this.hkdz = hkdz;
	}
	public String getXzdz() {
		return xzdz;
	}
	public void setXzdz(String xzdz) {
		this.xzdz = xzdz;
	}
	public String getEntname() {
		return entname;
	}
	public void setEntname(String entname) {
		this.entname = entname;
	}
	public String getLxdh() {
		return lxdh;
	}
	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}
	public String getZzsj() {
		return zzsj;
	}
	public void setZzsj(String zzsj) {
		this.zzsj = zzsj;
	}
	public String getLzsj() {
		return lzsj;
	}
	public void setLzsj(String lzsj) {
		this.lzsj = lzsj;
	}
	public String getEnterpriseid() {
		return enterpriseid;
	}
	public void setEnterpriseid(String enterpriseid) {
		this.enterpriseid = enterpriseid;
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
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	public Long getStatus() {
		return status;
	}
	public void setStatus(Long status) {
		this.status = status;
	}
	public String getEmtype() {
		return emtype;
	}
	public void setEmtype(String emtype) {
		this.emtype = emtype;
	}
	public String getYgh() {
		return ygh;
	}
	public void setYgh(String ygh) {
		this.ygh = ygh;
	}
	public String getDwlb() {
		return dwlb;
	}
	public void setDwlb(String dwlb) {
		this.dwlb = dwlb;
	}
	public String getCyryid() {
		return cyryid;
	}
	public void setCyryid(String cyryid) {
		this.cyryid = cyryid;
	}
	public String getHszt() {
		return hszt;
	}
	public void setHszt(String hszt) {
		this.hszt = hszt;
	}

	
}
