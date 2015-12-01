package com.founder.ywxt.bean;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;



/******************************************************************************
 * @Package:      [com.founder.ywxt.bean.Ywxtsfqypzb.java]  
 * @ClassName:    [Ywxtsfqypzb]   
 * @Description:  [业务协同是否启用配置表]   
 * @Author:       [cong_rihong@founder.com.cn]  
 * @CreateDate:   [2015-11-5 下午3:28:10]   
 * @UpdateUser:   [cong_rihong(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-11-5 下午3:28:10，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@DBInfoAnnotation(tableName = "SYS_YWXTSFQYPZB", pk = "id")
public class Ywxtsfqypzb extends BaseEntity {
	@FieldDesc("ID")
	private String id;
	@FieldDesc("业务协同类型")
	private String ywxtlx;
	@FieldDesc("是否启用")
	private String sfqy;
	@FieldDesc("备注")
	private String bz;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getYwxtlx() {
		return ywxtlx;
	}
	public void setYwxtlx(String ywxtlx) {
		this.ywxtlx = ywxtlx;
	}
	public String getSfqy() {
		return sfqy;
	}
	public void setSfqy(String sfqy) {
		this.sfqy = sfqy;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}

	
	
}
