package com.founder.zdrygl.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;

@DBInfoAnnotation(tableName = "ZDRY_ZSZHJSBRXXB", pk = "id")
public class ZdryZszhjsbrxxb extends ZdryZdryzb implements Serializable {

	private static final long serialVersionUID = 1L;
	@FieldDesc("重点人员ID")
	private String id;
	@FieldDesc("精神病类别代码")
	private String jsblbdm;
	@FieldDesc("是否已肇事滋事代码")
	private String sfyzszsdm;
	@FieldDesc("精神病成因")
	private String jsbcy;
	@FieldDesc("是否持精神类残疾证代码")
	private String sfcjslcjzdm;
	@FieldDesc("鉴定机构")
	private String jdjg;
	@FieldDesc("证件取得时间")
	private String zjqdsj;
	@FieldDesc("简要案情")
	private String jyaq;
	@FieldDesc("备注")
	private String bz;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getJsblbdm() {
		return jsblbdm;
	}

	public void setJsblbdm(String jsblbdm) {
		this.jsblbdm = jsblbdm;
	}

	public String getSfyzszsdm() {
		return sfyzszsdm;
	}

	public void setSfyzszsdm(String sfyzszsdm) {
		this.sfyzszsdm = sfyzszsdm;
	}

	public String getJsbcy() {
		return jsbcy;
	}

	public void setJsbcy(String jsbcy) {
		this.jsbcy = jsbcy;
	}

	public String getSfcjslcjzdm() {
		return sfcjslcjzdm;
	}

	public void setSfcjslcjzdm(String sfcjslcjzdm) {
		this.sfcjslcjzdm = sfcjslcjzdm;
	}

	public String getJdjg() {
		return jdjg;
	}

	public void setJdjg(String jdjg) {
		this.jdjg = jdjg;
	}

	public String getZjqdsj() {
		return zjqdsj;
	}

	public void setZjqdsj(String zjqdsj) {
		this.zjqdsj = zjqdsj;
	}

	public String getJyaq() {
		return jyaq;
	}

	public void setJyaq(String jyaq) {
		this.jyaq = jyaq;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

}
