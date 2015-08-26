package com.founder.spsxt.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

@DBInfoAnnotation(tableName = "JF_SPDWJBXX", pk = "id")
public class Spjsdw extends BaseEntity implements Serializable {
	
	@FieldDesc("单位ID")private String id ;//主键
	@FieldDesc("单位编码")private String dwbm ;//单位编码
	@FieldDesc("单位名称")private String dwmc ;//单位名称
	@FieldDesc("单位拼音")private String dwpy ;//单位拼音	
	
	@FieldDesc("建设类别")private String jslb ;//建设类别(大类)
	@FieldDesc("单位类型")private String dwlx ;//单位类型(小类)
	/*
	 * 因为单位与标准地址之间是一对一关系，且单位包含了业主信息，故取消下列字段
	@FieldDesc("业主姓名")private String yzxm ;//业主姓名
	@FieldDesc("业主座机")private String yzzj ;//业主座机
	@FieldDesc("业主手机")private String yzphone ;//业主手机
	@FieldDesc("业主身份证号")private String yzsfzh ;//业主身份证号
	*/


	//private String  sfgazj;//是否公安自建（是：1；否：0）
	
	//@FieldDesc("单位地址")private String dwdz ;//单位地址(dz_dwdzxz+附加说明)
	//@FieldDesc("单位类型")private String dwlx ;//单位类型

	//@FieldDesc("地址_单位地址代码")private String dz_dwdzdm ;//地址_单位地址代码
	//@FieldDesc("地址_单位地址详址")private String dz_dwdzxz ;//地址_单位地址详址
	//@FieldDesc("地址—单位门楼牌代码")private String dz_dwmlpdm ;//地址—单位门楼牌代码
	//@FieldDesc("地址—单位门楼牌详址")private String dz_dwmlpxz ;//地址—单位门楼牌详址
	
	
	
	//@FieldDesc("应用属性")private String yysx ;//应用属性 已移至视频摄像头表中

	/*
	@FieldDesc("录入IP")private String xt_lrip ;//录入IP
	@FieldDesc("录入人ID")private String xt_lrrid ;//录入人ID
	@FieldDesc("录入人姓名")private String xt_lrrxm ;//录入人姓名
	@FieldDesc("录入人部门")private String xt_lrrbm ;//录入人部门
	@FieldDesc("录入人部门ID")private String xt_lrrbmid ;//录入人部门ID
	@FieldDesc("录入时间")private String xt_lrsj ;//录入时间
	@FieldDesc("最后修改IP")private String xt_zhxgip ;//最后修改IP
	@FieldDesc("最后修改人ID")private String xt_zhxgrid ;//最后修改人ID!!
	@FieldDesc("最后修改人姓名")private String xt_zhxgrxm ;//最后修改人姓名
	@FieldDesc("最后修改人部门")private String xt_zhxgrbm ;//最后修改人部门
	@FieldDesc("最后修改人部门ID")private String xt_zhxgrbmid ;//最后修改人部门ID!!
	@FieldDesc("最后修改时间")private String xt_zhxgsj ;//最后修改时间
	@FieldDesc("注销原因")private String xt_zxyy ;//注销原因
	@FieldDesc("注销标志")private String xt_zxbz ;//注销标志
	@FieldDesc("采集时间")private String xt_cjsj ;//采集时间
	*/
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDwbm() {
		return dwbm;
	}
	public void setDwbm(String dwbm) {
		this.dwbm = dwbm;
	}
	public String getDwmc() {
		return dwmc;
	}
	public void setDwmc(String dwmc) {
		this.dwmc = dwmc;
	}
	public String getDwpy() {
		return dwpy;
	}
	public void setDwpy(String dwpy) {
		this.dwpy = dwpy;
	}
	public String getJslb() {
		return jslb;
	}
	public void setJslb(String jslb) {
		this.jslb = jslb;
	}
	public String getDwlx() {
		return dwlx;
	}
	public void setDwlx(String dwlx) {
		this.dwlx = dwlx;
	}

}
