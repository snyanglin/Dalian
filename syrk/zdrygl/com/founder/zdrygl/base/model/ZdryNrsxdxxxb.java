package com.founder.zdrygl.base.model;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;
import com.founder.zdrygl.core.model.Zdry;


/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.base.model.ZdryNrsxdxxxb.java]  
 * @ClassName:    [ZdryNrsxdxxxb]   
 * @Description:  [重点人员 纳入视线对象]   
 * @Author:       [zhang.hai@founder.com.cn]  
 * @CreateDate:   [2015年12月9日 下午4:26:55]   
 * @UpdateUser:   [ZhangHai(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年12月9日 下午4:26:55，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "ZDRY_NRSXDXXXB", pk = "id")
public class ZdryNrsxdxxxb extends BaseEntity implements Serializable ,Zdry{

	private static final long serialVersionUID = 7737212711271365292L;
	
	@FieldDesc("重点人员ID") private String id;
	@FieldDesc("主要问题及现实表现") private String zywtjxsbx;
	@FieldDesc("备注") private String bz;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getZywtjxsbx() {
		return zywtjxsbx;
	}
	public void setZywtjxsbx(String zywtjxsbx) {
		this.zywtjxsbx = zywtjxsbx;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	
}
