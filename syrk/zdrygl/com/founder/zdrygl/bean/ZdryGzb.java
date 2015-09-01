package com.founder.zdrygl.bean;

import java.io.Serializable;

import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;
/***
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.bean.ZdryGzb.java]  
 * @ClassName:    [ZdryGzb]   
 * @Description:  [重点人员规则表]   
 * @Author:       [wu_chunhui@founder.com.cn]  
 * @CreateDate:   [2015年7月24日 上午11:02:10]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年7月24日 上午11:02:10，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
public class ZdryGzb extends BaseEntity implements Serializable{
	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;
	@FieldDesc("ID")private String id;
	@FieldDesc("重点人员类型")private String zdrylx;
	@FieldDesc("同时可列管类型")private String tslglx;
	@FieldDesc("可撤管类型")private String cglx;
	@FieldDesc("是否双列管:0是")private String sfslg;
	@FieldDesc("ZGBM")private String zgbm;
	@FieldDesc("备注")private String bz;
	@FieldDesc("区域代码")private String qydm;
	@FieldDesc("是否可转类:0 可以")private String sfkzl;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getZdrylx() {
		return zdrylx;
	}
	public void setZdrylx(String zdrylx) {
		this.zdrylx = zdrylx;
	}
	public String getTslglx() {
		return tslglx;
	}
	public void setTslglx(String tslglx) {
		this.tslglx = tslglx;
	}
	public String getCglx() {
		return cglx;
	}
	public void setCglx(String cglx) {
		this.cglx = cglx;
	}
	public String getZgbm() {
		return zgbm;
	}
	public void setZgbm(String zgbm) {
		this.zgbm = zgbm;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getQydm() {
		return qydm;
	}
	public void setQydm(String qydm) {
		this.qydm = qydm;
	}
	public String getSfkzl() {
		return sfkzl;
	}
	public void setSfkzl(String sfkzl) {
		this.sfkzl = sfkzl;
	}
	public String getSfslg() {
		return sfslg;
	}
	public void setSfslg(String sfslg) {
		this.sfslg = sfslg;
	}
	
	
	

}
