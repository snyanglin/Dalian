package com.founder.zafffwqz.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;


/******************************************************************************
 * @Package:      [com.founder.zafffwqz.bean.Gzjzqkzb.java]  
 * @ClassName:    [Gzjzqkzb]   
 * @Description:  [矛盾-跟踪进度实体类]   
 * @Author:       [tian_chengwei@founder.com.cn]  
 * @CreateDate:   [2015-6-2 下午11:50:31]   
 * @UpdateUser:   [lk(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-2 下午11:50:31，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 * 
 * @review      :wu.w@founder.com.cn
 * @reviewDate  : 20150604
 */
@DBInfoAnnotation(tableName = "FWQZ_MD_GZJZQKZB" , pk = "id")
public class Gzjzqkzb extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@FieldDesc("跟踪进展情况子表ID")
	private String id;
	@FieldDesc("矛盾纠纷信息ID")
	private String mdjfxxid;
	@FieldDesc("跟踪进展人")
	private String gzjzr;
	@FieldDesc("跟踪进展人ID")
	private String gzjzrid;
	@FieldDesc("跟踪进展时间")
	private String gzjzsj;
	@FieldDesc("进展情况描述")
	private String jzqkms;
	@FieldDesc("调解结果代码")
	private String tjjgdm;
	@FieldDesc("备注")
	private String bz;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMdjfxxid() {
		return mdjfxxid;
	}
	public void setMdjfxxid(String mdjfxxid) {
		this.mdjfxxid = mdjfxxid;
	}
	public String getGzjzr() {
		return gzjzr;
	}
	public void setGzjzr(String gzjzr) {
		this.gzjzr = gzjzr;
	}
	public String getGzjzrid() {
		return gzjzrid;
	}
	public void setGzjzrid(String gzjzrid) {
		this.gzjzrid = gzjzrid;
	}
	public String getGzjzsj() {
		return gzjzsj;
	}
	public void setGzjzsj(String gzjzsj) {
		this.gzjzsj = gzjzsj;
	}
	public String getJzqkms() {
		return jzqkms;
	}
	public void setJzqkms(String jzqkms) {
		this.jzqkms = jzqkms;
	}
	public String getTjjgdm() {
		return tjjgdm;
	}
	public void setTjjgdm(String tjjgdm) {
		this.tjjgdm = tjjgdm;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	
	
	
	

}
