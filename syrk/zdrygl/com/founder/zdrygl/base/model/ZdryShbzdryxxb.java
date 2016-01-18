package com.founder.zdrygl.base.model;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;
import com.founder.zdrygl.core.model.Zdry;

import java.io.Serializable;


/***
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.bean.ZdryShbzdryxxb.java]  
 * @ClassName:    [ZdryShbzdryxxb]   
 * @Description:  [涉环保重点人员]   
 * @Author:       [wu_chunhui@founder.com.cn]  
 * @CreateDate:   [2015年8月3日 下午2:33:04]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年8月3日 下午2:33:04，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "ZDRY_SHBZDRYXXB", pk = "id")
public class ZdryShbzdryxxb extends BaseEntity  implements Serializable,Zdry {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7979172365659095058L;
	@FieldDesc("重点人员ID")
	private String id;
	@FieldDesc("证件种类")
	private String cyzjdm;
	@FieldDesc("证件号码")
	private String zjhm;	
	@FieldDesc("姓名")
	private String xm;
	@FieldDesc("性别代码")
	private String xbdm;
	@FieldDesc("出生日期")
	private String csrq;
	@FieldDesc("民族代码")
	private String mzdm;
	@FieldDesc("联系电话")
	private String lxdh;
	@FieldDesc("是否死亡代码")
	private String sfswdm;
	@FieldDesc("籍贯省市县代码")
	private String jgssxdm;
	@FieldDesc("户籍地所属市县(区)")
	private String hjdsssxdm;
	@FieldDesc("户籍地所属公安机关代码")
	private String hjd_ssxjgajgdm;
	@FieldDesc("户籍地所属派出所代码")
	private String hjd_sspcsdm;
	@FieldDesc("户籍地行政区划代码")
	private String hjd_xzqhdm;
	@FieldDesc("户籍地门楼牌代码")
	private String hjd_mlpdm;
	@FieldDesc("户籍地门楼牌详址")
	private String hjd_mlpxz;
	@FieldDesc("户籍地地址id")
	private String hjd_dzid;
	@FieldDesc("户籍地地址详址")
	private String hjd_dzxz;
	@FieldDesc("户籍地地址描述")
	private String hjd_dzms;
	@FieldDesc("户籍地社区")
	private String hjd_sq;
	@FieldDesc("所属分县局")
	private String ssfxjdm;
	@FieldDesc("所属派出所")
	private String sspcsdm;
	@FieldDesc("门楼牌详址")
	private String dz_jzd_mlpxz;
	@FieldDesc("门楼牌代码")
	private String dz_jzdzmlpdm;
	@FieldDesc("居住地址代码")
	private String dz_jzdzdm;
	@FieldDesc("居住地省市县代码")
	private String dz_jzdzssxdm;
	@FieldDesc("居住地址详址")
	private String dz_jzdzxz;
	@FieldDesc("居住地社区")
	private String jzd_sq;
	
	
	@FieldDesc("案件类别代码")
	private String ajlbdm;
	@FieldDesc("作案特点代码")
	private String zatddm;
	@FieldDesc("主要问题及现实表现")
	private String zywtjxsbx;	
	@FieldDesc("简要案情")
	private String jyaq;
	@FieldDesc("处罚结果")
	private String cfjg;
	@FieldDesc("经常活动地区")
	private String jchddq;
	@FieldDesc("简历")
	private String jl;
	@FieldDesc("指纹编号")
	private String zwbh;
	@FieldDesc("数据密级")
	private String sjmj;
	@FieldDesc("人口编码")
	private String rkbm;
	@FieldDesc("备注")
	private String bz;

 	private String ryid;
	
	private String qx;//view和edit

	
	public String getQx() {
		return qx;
	}
	public void setQx(String qx) {
		this.qx = qx;
	}
	public String getRyid() {
		return ryid;
	}
	public void setRyid(String ryid) {
		this.ryid = ryid;
	}	
	
	public String getZywtjxsbx() {
		return zywtjxsbx;
	}
	public void setZywtjxsbx(String zywtjxsbx) {
		this.zywtjxsbx = zywtjxsbx;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSfswdm() {
		return sfswdm;
	}
	public void setSfswdm(String sfswdm) {
		this.sfswdm = sfswdm;
	}
	public String getAjlbdm() {
		return ajlbdm;
	}
	public void setAjlbdm(String ajlbdm) {
		this.ajlbdm = ajlbdm;
	}
	public String getZatddm() {
		return zatddm;
	}
	public void setZatddm(String zatddm) {
		this.zatddm = zatddm;
	}
	public String getJyaq() {
		return jyaq;
	}
	public void setJyaq(String jyaq) {
		this.jyaq = jyaq;
	}
	public String getCfjg() {
		return cfjg;
	}
	public void setCfjg(String cfjg) {
		this.cfjg = cfjg;
	}
	public String getJchddq() {
		return jchddq;
	}
	public void setJchddq(String jchddq) {
		this.jchddq = jchddq;
	}
	public String getJl() {
		return jl;
	}
	public void setJl(String jl) {
		this.jl = jl;
	}
	public String getZwbh() {
		return zwbh;
	}
	public void setZwbh(String zwbh) {
		this.zwbh = zwbh;
	}
	public String getSjmj() {
		return sjmj;
	}
	public void setSjmj(String sjmj) {
		this.sjmj = sjmj;
	}
	public String getRkbm() {
		return rkbm;
	}
	public void setRkbm(String rkbm) {
		this.rkbm = rkbm;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getCyzjdm() {
		return cyzjdm;
	}
	public void setCyzjdm(String cyzjdm) {
		this.cyzjdm = cyzjdm;
	}
	public String getZjhm() {
		return zjhm;
	}
	public void setZjhm(String zjhm) {
		this.zjhm = zjhm;
	}
	public String getXm() {
		return xm;
	}
	public void setXm(String xm) {
		this.xm = xm;
	}
	public String getXbdm() {
		return xbdm;
	}
	public void setXbdm(String xbdm) {
		this.xbdm = xbdm;
	}
	public String getCsrq() {
		return csrq;
	}
	public void setCsrq(String csrq) {
		this.csrq = csrq;
	}
	public String getMzdm() {
		return mzdm;
	}
	public void setMzdm(String mzdm) {
		this.mzdm = mzdm;
	}
	public String getLxdh() {
		return lxdh;
	}
	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}
	public String getJgssxdm() {
		return jgssxdm;
	}
	public void setJgssxdm(String jgssxdm) {
		this.jgssxdm = jgssxdm;
	}
	public String getHjdsssxdm() {
		return hjdsssxdm;
	}
	public void setHjdsssxdm(String hjdsssxdm) {
		this.hjdsssxdm = hjdsssxdm;
	}
	public String getHjd_ssxjgajgdm() {
		return hjd_ssxjgajgdm;
	}
	public void setHjd_ssxjgajgdm(String hjd_ssxjgajgdm) {
		this.hjd_ssxjgajgdm = hjd_ssxjgajgdm;
	}
	public String getHjd_sspcsdm() {
		return hjd_sspcsdm;
	}
	public void setHjd_sspcsdm(String hjd_sspcsdm) {
		this.hjd_sspcsdm = hjd_sspcsdm;
	}
	public String getHjd_xzqhdm() {
		return hjd_xzqhdm;
	}
	public void setHjd_xzqhdm(String hjd_xzqhdm) {
		this.hjd_xzqhdm = hjd_xzqhdm;
	}
	public String getHjd_mlpdm() {
		return hjd_mlpdm;
	}
	public void setHjd_mlpdm(String hjd_mlpdm) {
		this.hjd_mlpdm = hjd_mlpdm;
	}
	public String getHjd_mlpxz() {
		return hjd_mlpxz;
	}
	public void setHjd_mlpxz(String hjd_mlpxz) {
		this.hjd_mlpxz = hjd_mlpxz;
	}
	public String getHjd_dzid() {
		return hjd_dzid;
	}
	public void setHjd_dzid(String hjd_dzid) {
		this.hjd_dzid = hjd_dzid;
	}
	public String getHjd_dzxz() {
		return hjd_dzxz;
	}
	public void setHjd_dzxz(String hjd_dzxz) {
		this.hjd_dzxz = hjd_dzxz;
	}
	public String getHjd_dzms() {
		return hjd_dzms;
	}
	public void setHjd_dzms(String hjd_dzms) {
		this.hjd_dzms = hjd_dzms;
	}
	public String getHjd_sq() {
		return hjd_sq;
	}
	public void setHjd_sq(String hjd_sq) {
		this.hjd_sq = hjd_sq;
	}
	public String getSsfxjdm() {
		return ssfxjdm;
	}
	public void setSsfxjdm(String ssfxjdm) {
		this.ssfxjdm = ssfxjdm;
	}
	public String getSspcsdm() {
		return sspcsdm;
	}
	public void setSspcsdm(String sspcsdm) {
		this.sspcsdm = sspcsdm;
	}
	public String getDz_jzd_mlpxz() {
		return dz_jzd_mlpxz;
	}
	public void setDz_jzd_mlpxz(String dz_jzd_mlpxz) {
		this.dz_jzd_mlpxz = dz_jzd_mlpxz;
	}
	public String getDz_jzdzmlpdm() {
		return dz_jzdzmlpdm;
	}
	public void setDz_jzdzmlpdm(String dz_jzdzmlpdm) {
		this.dz_jzdzmlpdm = dz_jzdzmlpdm;
	}
	public String getDz_jzdzdm() {
		return dz_jzdzdm;
	}
	public void setDz_jzdzdm(String dz_jzdzdm) {
		this.dz_jzdzdm = dz_jzdzdm;
	}
	public String getDz_jzdzssxdm() {
		return dz_jzdzssxdm;
	}
	public void setDz_jzdzssxdm(String dz_jzdzssxdm) {
		this.dz_jzdzssxdm = dz_jzdzssxdm;
	}
	public String getDz_jzdzxz() {
		return dz_jzdzxz;
	}
	public void setDz_jzdzxz(String dz_jzdzxz) {
		this.dz_jzdzxz = dz_jzdzxz;
	}
	public String getJzd_sq() {
		return jzd_sq;
	}
	public void setJzd_sq(String jzd_sq) {
		this.jzd_sq = jzd_sq;
	}


}
