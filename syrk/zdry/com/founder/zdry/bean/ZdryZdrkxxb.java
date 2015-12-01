package com.founder.zdry.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;
/***
 * ****************************************************************************
 * @Package:      [com.founder.zdry.bean.Zdrkxxb.java]  
 * @ClassName:    [Zdrkxxb]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [wu_chunhui@founder.com.cn]  
 * @CreateDate:   [2015-3-11 下午5:53:33]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-3-11 下午5:53:33，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "ZDRY_ZDRKXXB", pk = "id")
public class ZdryZdrkxxb extends BaseEntity implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;
	@FieldDesc("重点人员ID")private String id;
	@FieldDesc("管理方法代码")private String glffdm;
	@FieldDesc("列管来源代码")private String lglydm;
	@FieldDesc("纳入工作依据")private String nrgzyj;
	@FieldDesc("备注")private String bz;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGlffdm() {
		return glffdm;
	}
	public void setGlffdm(String glffdm) {
		this.glffdm = glffdm;
	}
	public String getLglydm() {
		return lglydm;
	}
	public void setLglydm(String lglydm) {
		this.lglydm = lglydm;
	}
	public String getNrgzyj() {
		return nrgzyj;
	}
	public void setNrgzyj(String nrgzyj) {
		this.nrgzyj = nrgzyj;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}

}
