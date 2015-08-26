package com.founder.sydw.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/******************************************************************************
 * @Package:      [com.founder.sydw.bean.DwOwnXFBean.java]  
 * @ClassName:    [DwOwnXFBean]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [star]  
 * @CreateDate:   [2015-6-5 下午1:54:05]   
 * @UpdateUser:   [star(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-5 下午1:54:05，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@DBInfoAnnotation(tableName = "DW_DWXFXXB", pk = "id")
public class DwOwnXFBean extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 时间：2015，5.19
	 * 人：star
	 * 内容：三级消防信息
	 */
	@FieldDesc("id")
	private String id;
	@FieldDesc("单位ID")
	private String dwid;
	@FieldDesc("监管单位类别")
	private String jgdwlb;
	@FieldDesc("消防管辖")
	private String xfgx;
	@FieldDesc("单位使用名称")
	private String dwsymc;
	@FieldDesc("建筑管理单位")
	private String jzgldw;
	@FieldDesc("上级单位")
	private String sjdw;
	@FieldDesc("行政区域")
	private String xzqy;
	@FieldDesc("分管级别")
	private String fgjb;
	@FieldDesc("火灾危险性")
	private String hzwxx;
	@FieldDesc("消防安全管理人姓名")
	private String xfaqglrxm;
	@FieldDesc("消防安全管理人身份证号")
	private String xfaqglrsfzh;
	@FieldDesc("消防安全管理人联系方式")
	private String xfaqglrlxfs;
	@FieldDesc("消防安全责任人姓名")
	private String xfaqzrrxm;
	@FieldDesc("消防安全责任人身份证号")
	private String xfaqzrrsfzh;
	@FieldDesc("消防安全责任人联系方式")
	private String xfaqzrrlxfs;
	@FieldDesc("固定资产(万元)")
	private String gdzc;
	@FieldDesc("在册职工数")
	private String zczgs;
	@FieldDesc("占地面积(平方米)")
	private String zdmj;
	@FieldDesc("建筑面积(平方米)")
	private String jzmj;
	@FieldDesc("地理情况")
	private String dlqk;
	@FieldDesc("自动消防情况")
	private String zdxfqk;
	@FieldDesc("地理坐标X")
	private String dlzbx;
	@FieldDesc("地理坐标Y")
	private String dlzby;
	@FieldDesc("备注")
	private String bz;
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
	@FieldDesc("消防重点单位组织机构名称集合")
	private String zddwzzjgdm;	
	@FieldDesc("标识符")
	private String bsf;
	@FieldDesc("重点单位认定时间")
	private String zddwrdsj;


	public String getBsf() {
		return bsf;
	}

	public void setBsf(String bsf) {
		this.bsf = bsf;
	}
	public String getZddwzzjgdm() {
		return zddwzzjgdm;
	}

	public void setZddwzzjgdm(String zddwzzjgdm) {
		this.zddwzzjgdm = zddwzzjgdm;
	}

	public String getZddwzzjgname() {
		return zddwzzjgname;
	}

	public void setZddwzzjgname(String zddwzzjgname) {
		this.zddwzzjgname = zddwzzjgname;
	}

	private String zddwzzjgname;


	public String getZddwrdsj() {
		return zddwrdsj;
	}

	public void setZddwrdsj(String zddwrdsj) {
		this.zddwrdsj = zddwrdsj;
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

	public String getJgdwlb() {
		return jgdwlb;
	}

	public void setJgdwlb(String jgdwlb) {
		this.jgdwlb = jgdwlb;
	}

	public String getXfgx() {
		return xfgx;
	}

	public void setXfgx(String xfgx) {
		this.xfgx = xfgx;
	}

	public String getDwsymc() {
		return dwsymc;
	}

	public void setDwsymc(String dwsymc) {
		this.dwsymc = dwsymc;
	}

	public String getJzgldw() {
		return jzgldw;
	}

	public void setJzgldw(String jzgldw) {
		this.jzgldw = jzgldw;
	}

	public String getSjdw() {
		return sjdw;
	}

	public void setSjdw(String sjdw) {
		this.sjdw = sjdw;
	}

	public String getXzqy() {
		return xzqy;
	}

	public void setXzqy(String xzqy) {
		this.xzqy = xzqy;
	}

	public String getFgjb() {
		return fgjb;
	}

	public void setFgjb(String fgjb) {
		this.fgjb = fgjb;
	}

	public String getHzwxx() {
		return hzwxx;
	}

	public void setHzwxx(String hzwxx) {
		this.hzwxx = hzwxx;
	}

	public String getXfaqglrxm() {
		return xfaqglrxm;
	}

	public void setXfaqglrxm(String xfaqglrxm) {
		this.xfaqglrxm = xfaqglrxm;
	}

	public String getXfaqglrsfzh() {
		return xfaqglrsfzh;
	}

	public void setXfaqglrsfzh(String xfaqglrsfzh) {
		this.xfaqglrsfzh = xfaqglrsfzh;
	}

	public String getXfaqglrlxfs() {
		return xfaqglrlxfs;
	}

	public void setXfaqglrlxfs(String xfaqglrlxfs) {
		this.xfaqglrlxfs = xfaqglrlxfs;
	}

	public String getXfaqzrrxm() {
		return xfaqzrrxm;
	}

	public void setXfaqzrrxm(String xfaqzrrxm) {
		this.xfaqzrrxm = xfaqzrrxm;
	}

	public String getXfaqzrrsfzh() {
		return xfaqzrrsfzh;
	}

	public void setXfaqzrrsfzh(String xfaqzrrsfzh) {
		this.xfaqzrrsfzh = xfaqzrrsfzh;
	}

	public String getXfaqzrrlxfs() {
		return xfaqzrrlxfs;
	}

	public void setXfaqzrrlxfs(String xfaqzrrlxfs) {
		this.xfaqzrrlxfs = xfaqzrrlxfs;
	}

	public String getGdzc() {
		return gdzc;
	}

	public void setGdzc(String gdzc) {
		this.gdzc = gdzc;
	}

	public String getZczgs() {
		return zczgs;
	}

	public void setZczgs(String zczgs) {
		this.zczgs = zczgs;
	}

	public String getZdmj() {
		return zdmj;
	}

	public void setZdmj(String zdmj) {
		this.zdmj = zdmj;
	}

	public String getJzmj() {
		return jzmj;
	}

	public void setJzmj(String jzmj) {
		this.jzmj = jzmj;
	}

	public String getDlqk() {
		return dlqk;
	}

	public void setDlqk(String dlqk) {
		this.dlqk = dlqk;
	}

	public String getZdxfqk() {
		return zdxfqk;
	}

	public void setZdxfqk(String zdxfqk) {
		this.zdxfqk = zdxfqk;
	}

	public String getDlzbx() {
		return dlzbx;
	}

	public void setDlzbx(String dlzbx) {
		this.dlzbx = dlzbx;
	}

	public String getDlzby() {
		return dlzby;
	}

	public void setDlzby(String dlzby) {
		this.dlzby = dlzby;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
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

}