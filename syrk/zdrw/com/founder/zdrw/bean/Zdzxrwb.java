package com.founder.zdrw.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.base.entity.BaseEntity;

/**
 * 自动执行任务表
 * @author 李承龙
 *
 */
@DBInfoAnnotation(tableName = "JOB_ZDZXRWB", pk = "id")
public class Zdzxrwb extends BaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String id;				//自动执行任务ID
	private String rwmc;			//任务名称
	private String rwsm;			//任务说明
	private String rwzxff;			//任务执行方法
	private String rwkssj;			//任务开始时间
	private String rwjssj;			//任务结束时间
	private String jglx;			//间隔类型
	private String zxyr;			//执行月日
	private String zxjdy;			//执行季度月
	private String zxr;				//执行日
	private String zxz;				//执行周
	private String zxsj;			//执行时间
	private String zxjg;			//执行间隔
	private String jgdw;			//间隔单位
	private String sczxsj;			//首次执行时间
	private String sfjytg;			//是否校验通过
	private String rwzt;			//任务状态
	private String bz;				//备注
	private String thread;			//线程的
	private String xt_cjsj;			//采集时间
	private String xt_lrsj;			//录入时间
	private String xt_lrrxm;		//录入人姓名
	private String xt_lrrid;		//录入人ID
	private String xt_lrrbm;		//录入人部门
	private String xt_lrrbmid;		//录入人部门ID
	private String xt_lrip;			//录入IP
	private String xt_zhxgsj;		//最后修改时间
	private String xt_zhxgrxm;		//最后修改人姓名
	private String xt_zhxgrid;		//最后修改人ID
	private String xt_zhxgrbm;		//最后修改人部门
	private String xt_zhxgrbmid;	//最后修改人部门ID
	private String xt_zhxgip;		//最后修改IP
	private String xt_zxbz;			//注销标志
	private String xt_zxyy;			//注销原因
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRwmc() {
		return rwmc;
	}
	public void setRwmc(String rwmc) {
		this.rwmc = rwmc;
	}
	public String getRwsm() {
		return rwsm;
	}
	public void setRwsm(String rwsm) {
		this.rwsm = rwsm;
	}
	public String getRwzxff() {
		return rwzxff;
	}
	public void setRwzxff(String rwzxff) {
		this.rwzxff = rwzxff;
	}
	public String getRwkssj() {
		return rwkssj;
	}
	public void setRwkssj(String rwkssj) {
		this.rwkssj = rwkssj;
	}
	public String getRwjssj() {
		return rwjssj;
	}
	public void setRwjssj(String rwjssj) {
		this.rwjssj = rwjssj;
	}
	public String getJglx() {
		return jglx;
	}
	public void setJglx(String jglx) {
		this.jglx = jglx;
	}
	public String getZxyr() {
		return zxyr;
	}
	public void setZxyr(String zxyr) {
		this.zxyr = zxyr;
	}
	public String getZxjdy() {
		return zxjdy;
	}
	public void setZxjdy(String zxjdy) {
		this.zxjdy = zxjdy;
	}
	public String getZxr() {
		return zxr;
	}
	public void setZxr(String zxr) {
		this.zxr = zxr;
	}
	public String getZxz() {
		return zxz;
	}
	public void setZxz(String zxz) {
		this.zxz = zxz;
	}
	public String getZxsj() {
		return zxsj;
	}
	public void setZxsj(String zxsj) {
		this.zxsj = zxsj;
	}
	public String getZxjg() {
		return zxjg;
	}
	public void setZxjg(String zxjg) {
		this.zxjg = zxjg;
	}
	public String getJgdw() {
		return jgdw;
	}
	public void setJgdw(String jgdw) {
		this.jgdw = jgdw;
	}
	public String getSczxsj() {
		return sczxsj;
	}
	public void setSczxsj(String sczxsj) {
		this.sczxsj = sczxsj;
	}
	public String getSfjytg() {
		return sfjytg;
	}
	public void setSfjytg(String sfjytg) {
		this.sfjytg = sfjytg;
	}
	public String getRwzt() {
		return rwzt;
	}
	public void setRwzt(String rwzt) {
		this.rwzt = rwzt;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getThread() {
		return thread;
	}
	public void setThread(String thread) {
		this.thread = thread;
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
