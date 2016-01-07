package com.founder.zdrygl.base.model;

import java.io.Serializable;
import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;


/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.bean.ZdryDtjsSdxdxxb.java]  
 * @ClassName:    [ZdryDtjsSdxdxxb]   
 * @Description:  [重点人员 动态记实 涉毒-吸毒 属性 表]   
 * @Author:       [cong_rihong@founder.com.cn]  
 * @CreateDate:   [2015年12月15日 下午7:00:19]   
 * @UpdateUser:   [cong_rihong(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年12月15日 下午7:00:19，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "ZDRY_DTJS_SDXDXXB", pk = "id")
public class ZdryDtjsSdxdxxb extends BaseEntity implements Serializable {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 2414014308174828041L;
		@FieldDesc("id")
	    private String id;
		@FieldDesc("毒品种类")
		private String dpzl;
		@FieldDesc("毒品来源")
		private String dply;
		@FieldDesc("毒资来源")
		private String dzly;
		@FieldDesc("是否复吸")
		private String sffx;
		@FieldDesc("吸食次数")
		private Long xscs;
		@FieldDesc("戒断时间")
		private String jdsj;
		@FieldDesc("吸食原因")
		private String xsyy;
		@FieldDesc("人员现状")
		private String ryxz;
		@FieldDesc("危害后果")
		private String whhg;
		@FieldDesc("写实信息编号")
		private String xsbh;
		@FieldDesc("毒品种类其他")
		private String dpzlqt;
		@FieldDesc("毒品来源其他")
		private String dplyqt;
		@FieldDesc("毒资来源其他")
		private String dzlyqt;
		@FieldDesc("是否戒断")
		private String sfjd;
		@FieldDesc("重点人员身份证号")
		private String zdryzjhm;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getDpzl() {
			return dpzl;
		}
		public void setDpzl(String dpzl) {
			this.dpzl = dpzl;
		}
		public String getDply() {
			return dply;
		}
		public void setDply(String dply) {
			this.dply = dply;
		}
		public String getDzly() {
			return dzly;
		}
		public void setDzly(String dzly) {
			this.dzly = dzly;
		}
		public String getSffx() {
			return sffx;
		}
		public void setSffx(String sffx) {
			this.sffx = sffx;
		}
		public Long getXscs() {
			return xscs;
		}
		public void setXscs(Long xscs) {
			this.xscs = xscs;
		}
		public String getJdsj() {
			return jdsj;
		}
		public void setJdsj(String jdsj) {
			this.jdsj = jdsj;
		}
		public String getXsyy() {
			return xsyy;
		}
		public void setXsyy(String xsyy) {
			this.xsyy = xsyy;
		}
		public String getRyxz() {
			return ryxz;
		}
		public void setRyxz(String ryxz) {
			this.ryxz = ryxz;
		}
		public String getWhhg() {
			return whhg;
		}
		public void setWhhg(String whhg) {
			this.whhg = whhg;
		}
		public String getXsbh() {
			return xsbh;
		}
		public void setXsbh(String xsbh) {
			this.xsbh = xsbh;
		}
		public String getDpzlqt() {
			return dpzlqt;
		}
		public void setDpzlqt(String dpzlqt) {
			this.dpzlqt = dpzlqt;
		}
		public String getDplyqt() {
			return dplyqt;
		}
		public void setDplyqt(String dplyqt) {
			this.dplyqt = dplyqt;
		}
		public String getDzlyqt() {
			return dzlyqt;
		}
		public void setDzlyqt(String dzlyqt) {
			this.dzlyqt = dzlyqt;
		}
		public String getSfjd() {
			return sfjd;
		}
		public void setSfjd(String sfjd) {
			this.sfjd = sfjd;
		}
		public String getZdryzjhm() {
			return zdryzjhm;
		}
		public void setZdryzjhm(String zdryzjhm) {
			this.zdryzjhm = zdryzjhm;
		}
		

}
