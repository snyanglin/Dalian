package com.founder.zafffwqz.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/******************************************************************************
 * @Package:      [com.founder.zafffwqz.bean.ZaffWfxx.java]  
 * @ClassName:    [ZaffWfxx]   
 * @Description:  [物防信息实体类]   
 * @Author:       [tian_chengwei@founder.com.cn]  
 * @CreateDate:   [2015-6-2 下午11:49:46]   
 * @UpdateUser:   [lk(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-2 下午11:49:46，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 * 
 * @review      : wu.w@founder.com.cn
 * @reviewDate  : 20150604
 */
@DBInfoAnnotation(tableName = "ZAFF_WFXXB", pk = "id")
public class ZaffWfxx extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@FieldDesc("物防ID")
	private String id;
	@FieldDesc("管辖责任区代码")
	private String gxzrqdm;
	@FieldDesc("管辖派出所代码")
	private String gxpcsdm;
	@FieldDesc("管辖分县局代码")
	private String gxfxjdm;
	@FieldDesc("单位ID")
	private String dwid;
	@FieldDesc("物防种类")
	private String wfzl;
	@FieldDesc("数量")
	private Long sl;
	@FieldDesc("安装日期")
	private String azrq;
	@FieldDesc("描述")
	private String ms;
	@FieldDesc("地址-物防地址代码")
	private String dz_wfdzdm;
	@FieldDesc("地址-物防地址省市县代码")
	private String dz_wfdzssxdm;
	@FieldDesc("地址-物防地址详址")
	private String dz_wfdzxz;
	@FieldDesc("地址-物防地址门楼牌代码")
	private String dz_wfdzmlpdm;
	@FieldDesc("地址-物防地址门楼牌详址")
	private String dz_wfdzmlpxz;
	@FieldDesc("坐标X")
	private String zbx;
	@FieldDesc("坐标Y")
	private String zby;
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
	@FieldDesc("多条件搜索")
	private String condition;
	//空间属性
	@FieldDesc("半径")
	private String mapRadius;
	@FieldDesc("坐标值")
	private String zbz;
	@FieldDesc("查询类型")
	private String type;
	@FieldDesc("空间图层的srid")
	private int srid;
	private String gisUser;
	private static String gisTable = "ZAFF_WFKJXXB_PT";
	private Long objectid;
	private String wfid;
	@FieldDesc("小区ID")
	private String xqid;
	@FieldDesc("物防类型")
	private String wflx;
	
	
	public String getXqid() {
		return xqid;
	}

	public void setXqid(String xqid) {
		this.xqid = xqid;
	}

	public String getWflx() {
		return wflx;
	}

	public void setWflx(String wflx) {
		this.wflx = wflx;
	}

	public static String getGisTable() {
		return gisTable;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGxzrqdm() {
		return gxzrqdm;
	}

	public void setGxzrqdm(String gxzrqdm) {
		this.gxzrqdm = gxzrqdm;
	}

	public String getGxpcsdm() {
		return gxpcsdm;
	}

	public void setGxpcsdm(String gxpcsdm) {
		this.gxpcsdm = gxpcsdm;
	}

	public String getGxfxjdm() {
		return gxfxjdm;
	}

	public void setGxfxjdm(String gxfxjdm) {
		this.gxfxjdm = gxfxjdm;
	}

	public String getDwid() {
		return dwid;
	}

	public void setDwid(String dwid) {
		this.dwid = dwid;
	}

	public String getWfzl() {
		return wfzl;
	}

	public void setWfzl(String wfzl) {
		this.wfzl = wfzl;
	}

	public Long getSl() {
		return sl;
	}

	public void setSl(Long sl) {
		this.sl = sl;
	}

	public String getAzrq() {
		return azrq;
	}

	public void setAzrq(String azrq) {
		this.azrq = azrq;
	}

	public String getMs() {
		return ms;
	}

	public void setMs(String ms) {
		this.ms = ms;
	}

	public String getDz_wfdzdm() {
		return dz_wfdzdm;
	}

	public void setDz_wfdzdm(String dz_wfdzdm) {
		this.dz_wfdzdm = dz_wfdzdm;
	}

	public String getDz_wfdzssxdm() {
		return dz_wfdzssxdm;
	}

	public void setDz_wfdzssxdm(String dz_wfdzssxdm) {
		this.dz_wfdzssxdm = dz_wfdzssxdm;
	}

	public String getDz_wfdzxz() {
		return dz_wfdzxz;
	}

	public void setDz_wfdzxz(String dz_wfdzxz) {
		this.dz_wfdzxz = dz_wfdzxz;
	}

	public String getDz_wfdzmlpdm() {
		return dz_wfdzmlpdm;
	}

	public void setDz_wfdzmlpdm(String dz_wfdzmlpdm) {
		this.dz_wfdzmlpdm = dz_wfdzmlpdm;
	}

	public String getDz_wfdzmlpxz() {
		return dz_wfdzmlpxz;
	}

	public void setDz_wfdzmlpxz(String dz_wfdzmlpxz) {
		this.dz_wfdzmlpxz = dz_wfdzmlpxz;
	}

	public String getZbx() {
		return zbx;
	}

	public void setZbx(String zbx) {
		this.zbx = zbx;
	}

	public String getZby() {
		return zby;
	}

	public void setZby(String zby) {
		this.zby = zby;
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

	public String getMapRadius() {
		return mapRadius;
	}

	public void setMapRadius(String mapRadius) {
		this.mapRadius = mapRadius;
	}

	public String getZbz() {
		return zbz;
	}

	public void setZbz(String zbz) {
		this.zbz = zbz;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getSrid() {
		return srid;
	}

	public void setSrid(int srid) {
		this.srid = srid;
	}

	public String getGisUser() {
		return gisUser;
	}

	public void setGisUser(String gisUser) {
		this.gisUser = gisUser;
	}

	public Long getObjectid() {
		return objectid;
	}

	public void setObjectid(Long objectid) {
		this.objectid = objectid;
	}

	public String getWfid() {
		return wfid;
	}

	public void setWfid(String wfid) {
		this.wfid = wfid;
	}

}
