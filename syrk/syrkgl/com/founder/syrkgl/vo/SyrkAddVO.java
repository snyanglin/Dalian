package com.founder.syrkgl.vo;

import com.founder.syrkgl.bean.RyRyjbxxb;
import com.founder.syrkgl.bean.SyrkCzrkxxb;
import com.founder.syrkgl.bean.SyrkJwryxxb;
import com.founder.syrkgl.bean.SyrkJzrkxxb;
import com.founder.syrkgl.bean.SyrkLdrkxxb;
import com.founder.syrkgl.bean.SyrkWlhryxxb;

/******************************************************************************
 * @Package: [com.founder.syrkgl.vo.SyrkAddVO.java]
 * @ClassName: [SyrkEditSaveVO]
 * @Description: [实有人口新增提交对象]
 * @Author: [hongguanjun]
 * @CreateDate: [2015-4-3 下午3:13:17]
 * @UpdateUser: [hongguanjun(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-4-3 下午3:13:17，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
public class SyrkAddVO {

	private RyRyjbxxb jbxx;

	private SyrkCzrkxxb czrk;

	private SyrkJzrkxxb jzrk;

	private SyrkLdrkxxb ldrk;

	private SyrkJwryxxb jwry;

	private SyrkWlhryxxb wlrk;

	private String syrkywlxdm;
	
	private String qwd_zrqdm;//用于数据注销时，发消息提醒。去往地_责任区代码
	
	private String qcyxm;//用于数据注销时，发消息提醒。迁出人姓名

	private String gzdw;
	
	private String gzdwid;
	
	
	
	public String getGzdw() {
		return gzdw;
	}

	public void setGzdw(String gzdw) {
		this.gzdw = gzdw;
	}

	public String getGzdwid() {
		return gzdwid;
	}

	public void setGzdwid(String gzdwid) {
		this.gzdwid = gzdwid;
	}

	public String getQcyxm() {
		return qcyxm;
	}

	public void setQcyxm(String qcyxm) {
		this.qcyxm = qcyxm;
	}

	public String getQwd_zrqdm() {
		return qwd_zrqdm;
	}

	public void setQwd_zrqdm(String qwd_zrqdm) {
		this.qwd_zrqdm = qwd_zrqdm;
	}

	public RyRyjbxxb getJbxx() {
		return jbxx;
	}

	public void setJbxx(RyRyjbxxb jbxx) {
		this.jbxx = jbxx;
	}

	public SyrkCzrkxxb getCzrk() {
		return czrk;
	}

	public void setCzrk(SyrkCzrkxxb czrk) {
		this.czrk = czrk;
	}

	public SyrkJzrkxxb getJzrk() {
		return jzrk;
	}

	public void setJzrk(SyrkJzrkxxb jzrk) {
		this.jzrk = jzrk;
	}

	public SyrkLdrkxxb getLdrk() {
		return ldrk;
	}

	public void setLdrk(SyrkLdrkxxb ldrk) {
		this.ldrk = ldrk;
	}

	public SyrkJwryxxb getJwry() {
		return jwry;
	}

	public void setJwry(SyrkJwryxxb jwry) {
		this.jwry = jwry;
	}

	public SyrkWlhryxxb getWlrk() {
		return wlrk;
	}

	public void setWlrk(SyrkWlhryxxb wlrk) {
		this.wlrk = wlrk;
	}

	public String getSyrkywlxdm() {
		return syrkywlxdm;
	}

	public void setSyrkywlxdm(String syrkywlxdm) {
		this.syrkywlxdm = syrkywlxdm;
	}

}
