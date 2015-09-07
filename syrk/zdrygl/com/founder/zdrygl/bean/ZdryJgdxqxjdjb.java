package com.founder.zdrygl.bean;

import java.io.Serializable;
import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/***
 * ****************************************************************************
 * 
 * @Package: [cn.mos.zdry.bean.Jgdxqxjdjb.java]
 * @ClassName: [Jgdxqxjdjb]
 * @Description: [一句话描述该类的功能]
 * @Author: [wu_chunhui@founder.com.cn]
 * @CreateDate: [2015-3-11 下午6:18:11]
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-3-11 下午6:18:11，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@DBInfoAnnotation(tableName = "ZDRY_JGDXQXJDJB", pk = "id")
public class ZdryJgdxqxjdjb extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@FieldDesc("请销假ID")
	private String id;
	@FieldDesc("重点人员ID")
	private String zdryid;
	@FieldDesc("请假原因")
	private String qjyy;
	@FieldDesc("请假_日期")
	private String qjrq;
	@FieldDesc("去往地行政区划代码")
	private String qwxzqhdm;
	@FieldDesc("去往地详址")
	private String qwxz;
	@FieldDesc("预计返回_日期")
	private String yjfh_rq;
	@FieldDesc("审批人_姓名")
	private String spr_xm;
	@FieldDesc("审批人_ID")
	private String spr_id;
	@FieldDesc("审批时间")
	private String spsj;
	@FieldDesc("审批结果")
	private String spjg;
	@FieldDesc("审批意见")
	private String spyj;
	@FieldDesc("实际返回_日期")
	private String sjfh_rq;
	@FieldDesc("销假_日期")
	private String xjrq;
	@FieldDesc("备注")
	private String bz;

	private Long messageid;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getZdryid() {
		return zdryid;
	}

	public void setZdryid(String zdryid) {
		this.zdryid = zdryid;
	}

	public String getQjyy() {
		return qjyy;
	}

	public void setQjyy(String qjyy) {
		this.qjyy = qjyy;
	}

	public String getQjrq() {
		return qjrq;
	}

	public void setQjrq(String qjrq) {
		this.qjrq = qjrq;
	}

	public String getQwxzqhdm() {
		return qwxzqhdm;
	}

	public void setQwxzqhdm(String qwxzqhdm) {
		this.qwxzqhdm = qwxzqhdm;
	}

	public String getQwxz() {
		return qwxz;
	}

	public void setQwxz(String qwxz) {
		this.qwxz = qwxz;
	}

	public String getYjfh_rq() {
		return yjfh_rq;
	}

	public void setYjfh_rq(String yjfh_rq) {
		this.yjfh_rq = yjfh_rq;
	}

	public String getSpr_xm() {
		return spr_xm;
	}

	public void setSpr_xm(String spr_xm) {
		this.spr_xm = spr_xm;
	}

	public String getSpr_id() {
		return spr_id;
	}

	public void setSpr_id(String spr_id) {
		this.spr_id = spr_id;
	}

	public String getSpsj() {
		return spsj;
	}

	public void setSpsj(String spsj) {
		this.spsj = spsj;
	}

	public String getSpjg() {
		return spjg;
	}

	public void setSpjg(String spjg) {
		this.spjg = spjg;
	}

	public String getSpyj() {
		return spyj;
	}

	public void setSpyj(String spyj) {
		this.spyj = spyj;
	}

	public String getSjfh_rq() {
		return sjfh_rq;
	}

	public void setSjfh_rq(String sjfh_rq) {
		this.sjfh_rq = sjfh_rq;
	}

	public String getXjrq() {
		return xjrq;
	}

	public void setXjrq(String xjrq) {
		this.xjrq = xjrq;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public Long getMessageid() {
		return messageid;
	}

	public void setMessageid(Long messageid) {
		this.messageid = messageid;
	}

}
