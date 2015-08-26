package com.founder.ywxt.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/***
 * ****************************************************************************
 * 
 * @Package: [com.founder.ywxt.bean.YwxtYwxtCdxxb.java]
 * @ClassName: [YwxtYwxtCdxxb]
 * @Description: [协同业务裁定表]
 * @Author: [wu_chunhui@founder.com.cn]
 * @CreateDate: [2015-5-29 上午10:47:20]
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-5-29 上午10:47:20，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@DBInfoAnnotation(tableName = "YWXT_YWXTCDXXB", pk = "id")
public class YwxtYwxtCdxxb extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@FieldDesc("ID")
	private String id;
	@FieldDesc("审批部门ID")
	private String spbmid;
	@FieldDesc("审批人ID")
	private String sprid;
	@FieldDesc("审批人")
	private String spr;
	@FieldDesc("审批结果")
	private String spjg;
	@FieldDesc("协同人员表ID")
	private String xtryid;
	@FieldDesc("备注")
	private String bz;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSpbmid() {
		return spbmid;
	}

	public void setSpbmid(String spbmid) {
		this.spbmid = spbmid;
	}

	public String getSprid() {
		return sprid;
	}

	public void setSprid(String sprid) {
		this.sprid = sprid;
	}

	public String getSpr() {
		return spr;
	}

	public void setSpr(String spr) {
		this.spr = spr;
	}

	public String getSpjg() {
		return spjg;
	}

	public void setSpjg(String spjg) {
		this.spjg = spjg;
	}

	public String getXtryid() {
		return xtryid;
	}

	public void setXtryid(String xtryid) {
		this.xtryid = xtryid;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

}
