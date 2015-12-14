package com.founder.ywxt.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/***
 * ****************************************************************************
 * 
 * @Package: [com.founder.ywxt.bean.Ywxtcyryxxb.java]
 * @ClassName: [Ywxtcyryxxb]
 * @Description: [业务协同参与人员]
 * @Author: [wu_chunhui@founder.com.cn]
 * @CreateDate: [2015-5-29 上午10:37:08]
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-5-29 上午10:37:08，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@DBInfoAnnotation(tableName = "YWXT_CYRYXXB", pk = "id")
public class YwxtcyryxxbStore extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@FieldDesc("ID")
	private String id;
	@FieldDesc("参与人ID")
	private String cyrid;
	@FieldDesc("参与人姓名")
	private String cyrxm;
	@FieldDesc("协同动作")
	private String xtdz;
	@FieldDesc("协同结果")
	private String xtjg;
	@FieldDesc("协同业务ID")
	private String xtywid;
	@FieldDesc("所属派出所")
	private String sspcs;
	@FieldDesc("所属责任区")
	private String sszrq;
	@FieldDesc("备注")
	private String bz;

	public String getSspcs() {
		return sspcs;
	}

	public void setSspcs(String sspcs) {
		this.sspcs = sspcs;
	}

	public String getSszrq() {
		return sszrq;
	}

	public void setSszrq(String sszrq) {
		this.sszrq = sszrq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCyrid() {
		return cyrid;
	}

	public void setCyrid(String cyrid) {
		this.cyrid = cyrid;
	}

	public String getCyrxm() {
		return cyrxm;
	}

	public void setCyrxm(String cyrxm) {
		this.cyrxm = cyrxm;
	}

	public String getXtdz() {
		return xtdz;
	}

	public void setXtdz(String xtdz) {
		this.xtdz = xtdz;
	}

	public String getXtjg() {
		return xtjg;
	}

	public void setXtjg(String xtjg) {
		this.xtjg = xtjg;
	}

	public String getXtywid() {
		return xtywid;
	}

	public void setXtywid(String xtywid) {
		this.xtywid = xtywid;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

}
