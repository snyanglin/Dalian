package com.founder.zdrygl.base.model;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.zdrygl.core.model.Zdry;

@DBInfoAnnotation(tableName = "ZDRY_ZSZHJSBRXXB", pk = "id")
public class ZdryZszhjsbrxxb extends ZdryZb implements Serializable ,Zdry{

	private static final long serialVersionUID = 6043257593390548847L;
	
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
	@FieldDesc("危险性评估登记") 
	private String wxxpgdj;
	@FieldDesc("肇事时间") 
	private String zssj;
	@FieldDesc("肇事地点") 
	private String zsdd;
	@FieldDesc("记录人") 
	private String jlr;

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

	public String getWxxpgdj() {
		return wxxpgdj;
	}

	public void setWxxpgdj(String wxxpgdj) {
		this.wxxpgdj = wxxpgdj;
	}

	public String getZssj() {
		return zssj;
	}

	public void setZssj(String zssj) {
		this.zssj = zssj;
	}

	public String getZsdd() {
		return zsdd;
	}

	public void setZsdd(String zsdd) {
		this.zsdd = zsdd;
	}

	public String getJlr() {
		return jlr;
	}

	public void setJlr(String jlr) {
		this.jlr = jlr;
	}

	
}
