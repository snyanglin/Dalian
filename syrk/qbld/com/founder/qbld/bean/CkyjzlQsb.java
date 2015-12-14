package com.founder.qbld.bean;

import java.io.Serializable;
import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.bean.CkyjzlQsb.java]  
 * @ClassName:    [CkyjzlQsb]   
 * @Description:  [预警指令签收表]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-6-8 上午9:40:37]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-8 上午9:40:37，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "QBLD_CK_ZLQSB", pk = "yjzlbh")
public class CkyjzlQsb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@FieldDesc("情报平台序号(GUID)")
	private String id;
	@FieldDesc("预警指令编号")
	private String yjzlbh;
	@FieldDesc("签收时间")
	private String qssj;
	@FieldDesc("签收人身份证号")
	private String qsrsfzh;
	@FieldDesc("签收人姓名")
	private String qsrxm;
	@FieldDesc("签收单位名称")
	private String qsdw_mc;
	@FieldDesc("签收单位代码")
	private String qsdw_dm;
	@FieldDesc("是否上报省厅(0：否 1：是)")
	private String sfsbst;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getYjzlbh() {
		return yjzlbh;
	}
	public void setYjzlbh(String yjzlbh) {
		this.yjzlbh = yjzlbh;
	}
	public String getQssj() {
		return qssj;
	}
	public void setQssj(String qssj) {
		this.qssj = qssj;
	}
	public String getQsrsfzh() {
		return qsrsfzh;
	}
	public void setQsrsfzh(String qsrsfzh) {
		this.qsrsfzh = qsrsfzh;
	}
	public String getQsrxm() {
		return qsrxm;
	}
	public void setQsrxm(String qsrxm) {
		this.qsrxm = qsrxm;
	}
	public String getQsdw_mc() {
		return qsdw_mc;
	}
	public void setQsdw_mc(String qsdw_mc) {
		this.qsdw_mc = qsdw_mc;
	}
	public String getQsdw_dm() {
		return qsdw_dm;
	}
	public void setQsdw_dm(String qsdw_dm) {
		this.qsdw_dm = qsdw_dm;
	}
	public String getSfsbst() {
		return sfsbst;
	}
	public void setSfsbst(String sfsbst) {
		this.sfsbst = sfsbst;
	}
	
}
