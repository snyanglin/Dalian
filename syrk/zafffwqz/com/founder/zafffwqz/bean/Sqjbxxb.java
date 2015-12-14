package com.founder.zafffwqz.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

@DBInfoAnnotation(tableName = "ZAFF_SQJBXXB", pk = "id")
public class Sqjbxxb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@FieldDesc("社区ID")
	private String id;
	@FieldDesc("社区名称")
	private String sqmc;
	@FieldDesc("办公室电话")
	private String bgsdh;
	
	@FieldDesc("社区地址代码")
	private String dz_sqdzdm;
	@FieldDesc("社区地址省市县代码")
	private String dz_sqdzssxdm;
	@FieldDesc("社区地址详址")
	private String dz_sqdzxz;
	
	@FieldDesc("社区负责人常用证件代码")
	private String sqfzrcyzjdm;
	@FieldDesc("社区负责人证件号码")
	private String sqfzrzjhm;
	@FieldDesc("社区负责人姓名")
	private String sqfzrxm;
	@FieldDesc("社区负责人联系电话")
	private String sqfzrlxdh;
	@FieldDesc("备注")
	private String bz;
	@FieldDesc("社区警务室ID")
	private String sqjwsid;
	
	@FieldDesc("社区地址门楼牌代码")
	private String dz_sqdzmlpdm;
	@FieldDesc("社区地址门楼牌详址详址")
	private String dz_sqdzmlpxz;

	public String getSqjwsid() {
		return sqjwsid;
	}

	public void setSqjwsid(String sqjwsid) {
		this.sqjwsid = sqjwsid;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSqmc() {
		return sqmc;
	}

	public void setSqmc(String sqmc) {
		this.sqmc = sqmc;
	}

	public String getBgsdh() {
		return bgsdh;
	}

	public void setBgsdh(String bgsdh) {
		this.bgsdh = bgsdh;
	}

	public String getSqfzrcyzjdm() {
		return sqfzrcyzjdm;
	}

	public void setSqfzrcyzjdm(String sqfzrcyzjdm) {
		this.sqfzrcyzjdm = sqfzrcyzjdm;
	}

	public String getSqfzrzjhm() {
		return sqfzrzjhm;
	}

	public void setSqfzrzjhm(String sqfzrzjhm) {
		this.sqfzrzjhm = sqfzrzjhm;
	}

	public String getSqfzrxm() {
		return sqfzrxm;
	}

	public void setSqfzrxm(String sqfzrxm) {
		this.sqfzrxm = sqfzrxm;
	}

	public String getSqfzrlxdh() {
		return sqfzrlxdh;
	}

	public void setSqfzrlxdh(String sqfzrlxdh) {
		this.sqfzrlxdh = sqfzrlxdh;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public String getDz_sqdzdm() {
		return dz_sqdzdm;
	}

	public void setDz_sqdzdm(String dz_sqdzdm) {
		this.dz_sqdzdm = dz_sqdzdm;
	}

	public String getDz_sqdzssxdm() {
		return dz_sqdzssxdm;
	}

	public void setDz_sqdzssxdm(String dz_sqdzssxdm) {
		this.dz_sqdzssxdm = dz_sqdzssxdm;
	}

	public String getDz_sqdzxz() {
		return dz_sqdzxz;
	}

	public void setDz_sqdzxz(String dz_sqdzxz) {
		this.dz_sqdzxz = dz_sqdzxz;
	}

	public String getDz_sqdzmlpdm() {
		return dz_sqdzmlpdm;
	}

	public void setDz_sqdzmlpdm(String dz_sqdzmlpdm) {
		this.dz_sqdzmlpdm = dz_sqdzmlpdm;
	}

	public String getDz_sqdzmlpxz() {
		return dz_sqdzmlpxz;
	}

	public void setDz_sqdzmlpxz(String dz_sqdzmlpxz) {
		this.dz_sqdzmlpxz = dz_sqdzmlpxz;
	}

	
}
