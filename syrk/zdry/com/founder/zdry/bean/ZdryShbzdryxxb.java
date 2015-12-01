package com.founder.zdry.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;



/******************************************************************************
 * @Package:      [com.founder.zdry.bean.Zdry_Shbzdryxxb.java]  
 * @ClassName:    [ZdryShbzdryxxb]   
 * @Description:  [涉环保重点人员信息表]   
 * @Author:       [cong_rihong@founder.com.cn]  
 * @CreateDate:   [2015-6-12 下午3:12:18]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-12 下午3:12:18，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@DBInfoAnnotation(tableName = "ZDRY_SHBZDRYXXB", pk = "id")
public class ZdryShbzdryxxb extends BaseEntity  implements Serializable{

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;
	
	@FieldDesc("重点人员ID")
	private String id;
	@FieldDesc("是否死亡代码")
	private String sfswdm;
	@FieldDesc("案件类别代码")
	private String ajlbdm;
	@FieldDesc("作案特点代码")
	private String zatddm;
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


}
