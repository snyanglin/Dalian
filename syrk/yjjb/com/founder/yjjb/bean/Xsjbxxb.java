package com.founder.yjjb.bean;

import java.util.List;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/**
 * 线索举报信息表</br>
 * 存放线索的基本信息
 * @author dangkp
 * @since 2014-11-17
 * @version 1.0
 */
@DBInfoAnnotation(tableName = "YJJB_XSJBXXB", pk = "id")
public class Xsjbxxb extends BaseEntity  {
	
	@FieldDesc("主键:XS+组织机构代码12位+年月日8位+5位序号）") 
	private String id;

	@FieldDesc("线索地址代码") 
	private String xsdzdm;

	@FieldDesc("对线索地址的详细描述") 
	private String xsdzms;

	@FieldDesc("线索地址坐标X") 
	private String xsdzzbx;

	@FieldDesc("线索地址坐标Y") 
	private String xsdzzby;

	@FieldDesc("接报时间") 
	private String jbsj;

	@FieldDesc("初步查询线索的时间") 
	private String ccsj;

	@FieldDesc("再次查询线索的时间") 
	private String fcsj;
	
	@FieldDesc("有效线索的归属人") 
	private String slrbh;

	@FieldDesc("有效线索的归属受理分站") 
	private String slfzdm;

	@FieldDesc("有效线索的归属受理站") 
	private String slzdm;

	@FieldDesc("有效线索的归属受理中心") 
	private String slzxdm;

	@FieldDesc("线索地址代码") 
	private String sldzdm;

	@FieldDesc("对线索地址的详细描述") 
	private String sldzms;

	@FieldDesc("线索地址坐标X") 
	private String sldzzbx;

	@FieldDesc("线索地址坐标Y") 
	private String sldzzby;

	@FieldDesc("状态：00-待初查10-待复查20-递转中30-仲裁中40-使用中50-已废弃60-已处理") 
	private String xszt;

	@FieldDesc("结果：00-待处理10-已采用正在调查中20-已采用并立案侦查30-经查无作用40-经查非本站管辖范围50-管辖单位有争议申请上级仲裁") 
	private String ccjg;

	@FieldDesc("结果：00-待处理10-已采用正在调查中20-已采用并立案侦查30-经查无作用40-经查非本站管辖范围50-管辖单位有争议申请上级仲裁") 
	private String fcjg;

	@FieldDesc("举报线索的详细信息") 
	private String jbnr;

	@FieldDesc("盗窃、交通肇事、贩毒等") 
	private String jbxxxz;

	@FieldDesc("举报人姓名") 
	private String jbrxm;

	@FieldDesc("举报人身份证号") 
	private String jbrsfzh;

	@FieldDesc("举报人现居住地址") 
	private String jbrxjzdz;

	@FieldDesc("户籍地址") 
	private String hjdz;

	@FieldDesc("性别") 
	private String jbrxb;

	@FieldDesc("出生日期") 
	private String jbrsr;

	@FieldDesc("举报人单位代码")
	private String jbrdwdm;
	
	@FieldDesc("举报人单位") 
	private String jbrdw;

	@FieldDesc("举报人手机号") 
	private String jbrmobile;
	
	@FieldDesc("举报人联系方式") 
	private String jbrlxfs;

	private List<String> jbrlxfsList;
	
	@FieldDesc("车牌") 
	private String czzcp;

	@FieldDesc("从业资格证") 
	private String cyzgz;

	@FieldDesc("线索类型：0-有奖举报 1-关联警情") 
	private String xslx;

	@FieldDesc("线索来源：0-自行录入 1-110递转 2-其他受理站递转") 
	private String xsly;

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

	@FieldDesc("线索地址详址") 
	private String xsdzxz;

	@FieldDesc("线索地址门楼牌代码") 
	private String xsdzmlpdm;

	@FieldDesc("线索地址门楼牌详址") 
	private String xsdzmlpxz;

	@FieldDesc("线索地址省市县代码") 
	private String xsdzssxdm;

	@FieldDesc("受理地址详址（递转用）") 
	private String sldzxz;

	@FieldDesc("受理地址门楼牌代码（递转用）") 
	private String sldzmlpdm;

	@FieldDesc("受理地址门楼牌详址（递转用）") 
	private String sldzmlpxz;

	@FieldDesc("受理地址省市县代码（递转用）") 
	private String sldzssxdm;

	@FieldDesc("添加原因") 
	private String ccbz;

	@FieldDesc("添加原因") 
	private String fcbz;

	@FieldDesc("递转标志") 
	private String dzbz;
	
	@FieldDesc("仲裁标志") 
	private String zcbz;
	
	//查询用
	@FieldDesc("接报开始时间")
	private String starttime;
	
	@FieldDesc("接报结束时间")
	private String endtime;
	
	@FieldDesc("角色表id")
	private String jsId;
	
	@FieldDesc("角色表rolename")
	private String jsRolename;
	
	@FieldDesc("角色表Roledesc")
	private String jsRoledesc;
	
	@FieldDesc("角色表Bz")
	private String jsBz;
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getXsdzdm() {
		return xsdzdm;
	}

	public void setXsdzdm(String xsdzdm) {
		this.xsdzdm = xsdzdm;
	}

	public String getXsdzms() {
		return xsdzms;
	}

	public void setXsdzms(String xsdzms) {
		this.xsdzms = xsdzms;
	}

	public String getXsdzzbx() {
		return xsdzzbx;
	}

	public void setXsdzzbx(String xsdzzbx) {
		this.xsdzzbx = xsdzzbx;
	}

	public String getXsdzzby() {
		return xsdzzby;
	}

	public void setXsdzzby(String xsdzzby) {
		this.xsdzzby = xsdzzby;
	}

	public String getJbsj() {
		return jbsj;
	}

	public void setJbsj(String jbsj) {
		this.jbsj = jbsj;
	}

	public String getCcsj() {
		return ccsj;
	}

	public void setCcsj(String ccsj) {
		this.ccsj = ccsj;
	}

	public String getSlrbh() {
		return slrbh;
	}

	public void setSlrbh(String slrbh) {
		this.slrbh = slrbh;
	}

	public String getSlfzdm() {
		return slfzdm;
	}

	public void setSlfzdm(String slfzdm) {
		this.slfzdm = slfzdm;
	}

	public String getSlzdm() {
		return slzdm;
	}

	public void setSlzdm(String slzdm) {
		this.slzdm = slzdm;
	}

	public String getSlzxdm() {
		return slzxdm;
	}

	public void setSlzxdm(String slzxdm) {
		this.slzxdm = slzxdm;
	}

	public String getSldzdm() {
		return sldzdm;
	}

	public void setSldzdm(String sldzdm) {
		this.sldzdm = sldzdm;
	}

	public String getSldzms() {
		return sldzms;
	}

	public void setSldzms(String sldzms) {
		this.sldzms = sldzms;
	}

	public String getSldzzbx() {
		return sldzzbx;
	}

	public void setSldzzbx(String sldzzbx) {
		this.sldzzbx = sldzzbx;
	}

	public String getSldzzby() {
		return sldzzby;
	}

	public void setSldzzby(String sldzzby) {
		this.sldzzby = sldzzby;
	}

	public String getXszt() {
		return xszt;
	}

	public void setXszt(String xszt) {
		this.xszt = xszt;
	}

	public String getCcjg() {
		return ccjg;
	}

	public void setCcjg(String ccjg) {
		this.ccjg = ccjg;
	}

	public String getFcjg() {
		return fcjg;
	}

	public void setFcjg(String fcjg) {
		this.fcjg = fcjg;
	}

	public String getJbnr() {
		return jbnr;
	}

	public void setJbnr(String jbnr) {
		this.jbnr = jbnr;
	}

	public String getJbxxxz() {
		return jbxxxz;
	}

	public void setJbxxxz(String jbxxxz) {
		this.jbxxxz = jbxxxz;
	}

	public String getJbrxm() {
		return jbrxm;
	}

	public void setJbrxm(String jbrxm) {
		this.jbrxm = jbrxm;
	}

	public String getJbrsfzh() {
		return jbrsfzh;
	}

	public void setJbrsfzh(String jbrsfzh) {
		this.jbrsfzh = jbrsfzh;
	}

	public String getJbrxjzdz() {
		return jbrxjzdz;
	}

	public void setJbrxjzdz(String jbrxjzdz) {
		this.jbrxjzdz = jbrxjzdz;
	}

	public String getHjdz() {
		return hjdz;
	}

	public void setHjdz(String hjdz) {
		this.hjdz = hjdz;
	}

	public String getJbrxb() {
		return jbrxb;
	}

	public void setJbrxb(String jbrxb) {
		this.jbrxb = jbrxb;
	}


	public String getJbrdw() {
		return jbrdw;
	}

	public void setJbrdw(String jbrdw) {
		this.jbrdw = jbrdw;
	}

	public String getJbrlxfs() {
		return jbrlxfs;
	}

	public void setJbrlxfs(String jbrlxfs) {
		this.jbrlxfs = jbrlxfs;
	}

	public String getCzzcp() {
		return czzcp;
	}

	public void setCzzcp(String czzcp) {
		this.czzcp = czzcp;
	}

	public String getCyzgz() {
		return cyzgz;
	}

	public void setCyzgz(String cyzgz) {
		this.cyzgz = cyzgz;
	}

	public String getXslx() {
		return xslx;
	}

	public void setXslx(String xslx) {
		this.xslx = xslx;
	}

	public String getXsly() {
		return xsly;
	}

	public void setXsly(String xsly) {
		this.xsly = xsly;
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

	public String getXsdzxz() {
		return xsdzxz;
	}

	public void setXsdzxz(String xsdzxz) {
		this.xsdzxz = xsdzxz;
	}

	public String getXsdzmlpdm() {
		return xsdzmlpdm;
	}

	public void setXsdzmlpdm(String xsdzmlpdm) {
		this.xsdzmlpdm = xsdzmlpdm;
	}

	public String getXsdzmlpxz() {
		return xsdzmlpxz;
	}

	public void setXsdzmlpxz(String xsdzmlpxz) {
		this.xsdzmlpxz = xsdzmlpxz;
	}

	public String getXsdzssxdm() {
		return xsdzssxdm;
	}

	public void setXsdzssxdm(String xsdzssxdm) {
		this.xsdzssxdm = xsdzssxdm;
	}

	public String getSldzxz() {
		return sldzxz;
	}

	public void setSldzxz(String sldzxz) {
		this.sldzxz = sldzxz;
	}

	public String getSldzmlpdm() {
		return sldzmlpdm;
	}

	public void setSldzmlpdm(String sldzmlpdm) {
		this.sldzmlpdm = sldzmlpdm;
	}

	public String getSldzmlpxz() {
		return sldzmlpxz;
	}

	public void setSldzmlpxz(String sldzmlpxz) {
		this.sldzmlpxz = sldzmlpxz;
	}

	public String getSldzssxdm() {
		return sldzssxdm;
	}

	public void setSldzssxdm(String sldzssxdm) {
		this.sldzssxdm = sldzssxdm;
	}

	public String getCcbz() {
		return ccbz;
	}

	public void setCcbz(String ccbz) {
		this.ccbz = ccbz;
	}

	public String getFcbz() {
		return fcbz;
	}

	public void setFcbz(String fcbz) {
		this.fcbz = fcbz;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getJbrsr() {
		return jbrsr;
	}

	public void setJbrsr(String jbrsr) {
		this.jbrsr = jbrsr;
	}

	public String getJbrdwdm() {
		return jbrdwdm;
	}

	public void setJbrdwdm(String jbrdwdm) {
		this.jbrdwdm = jbrdwdm;
	}

	public String getDzbz() {
		return dzbz;
	}

	public void setDzbz(String dzbz) {
		this.dzbz = dzbz;
	}

	public String getZcbz() {
		return zcbz;
	}

	public void setZcbz(String zcbz) {
		this.zcbz = zcbz;
	}

	public String getFcsj() {
		return fcsj;
	}

	public void setFcsj(String fcsj) {
		this.fcsj = fcsj;
	}

	public String getJbrmobile() {
		return jbrmobile;
	}

	public void setJbrmobile(String jbrmobile) {
		this.jbrmobile = jbrmobile;
	}

	public List<String> getJbrlxfsList() {
		return jbrlxfsList;
	}

	public void setJbrlxfsList(List<String> jbrlxfsList) {
		this.jbrlxfsList = jbrlxfsList;
	}

	/**
	 * @return the jsId
	 */
	public String getJsId() {
		return jsId;
	}

	/**
	 * @param jsId the jsId to set
	 */
	public void setJsId(String jsId) {
		this.jsId = jsId;
	}

	/**
	 * @return the jsRolename
	 */
	public String getJsRolename() {
		return jsRolename;
	}

	/**
	 * @param jsRolename the jsRolename to set
	 */
	public void setJsRolename(String jsRolename) {
		this.jsRolename = jsRolename;
	}

	/**
	 * @return the jsRoledesc
	 */
	public String getJsRoledesc() {
		return jsRoledesc;
	}

	/**
	 * @param jsRoledesc the jsRoledesc to set
	 */
	public void setJsRoledesc(String jsRoledesc) {
		this.jsRoledesc = jsRoledesc;
	}

	/**
	 * @return the jsBz
	 */
	public String getJsBz() {
		return jsBz;
	}

	/**
	 * @param jsBz the jsBz to set
	 */
	public void setJsBz(String jsBz) {
		this.jsBz = jsBz;
	}
	
}