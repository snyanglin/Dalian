package com.founder.zdrygl.bean;

import java.io.Serializable;
import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/***
 * ****************************************************************************
 * 
 * @Package: [cn.mos.zdry.bean.Psjdb.java]
 * @ClassName: [Psjdb]
 * @Description: [一句话描述该类的功能]
 * @Author: [wu_chunhui@founder.com.cn]
 * @CreateDate: [2015-3-11 下午6:19:11]
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-3-11 下午6:19:11，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@DBInfoAnnotation(tableName = "ZDRY_PSJDB", pk = "id")
public class ZdryPsjdb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@FieldDesc("评审鉴定ID")
	private String id;
	@FieldDesc("重点人员ID")
	private String zdryid;
	@FieldDesc("评议_时间")
	private String py_sj;
	@FieldDesc("评议地点")
	private String pydd;
	@FieldDesc("参加人员")
	private String cjry;
	@FieldDesc("内容纪要")
	private String nrjy;
	@FieldDesc("备注")
	private String bz;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getZdryid() {
		return zdryid;
	}

	public void setZdryid(String zdryid) {
		this.zdryid = zdryid;
	}

	public String getPy_sj() {
		return py_sj;
	}

	public void setPy_sj(String py_sj) {
		this.py_sj = py_sj;
	}

	public String getPydd() {
		return pydd;
	}

	public void setPydd(String pydd) {
		this.pydd = pydd;
	}

	public String getCjry() {
		return cjry;
	}

	public void setCjry(String cjry) {
		this.cjry = cjry;
	}

	public String getNrjy() {
		return nrjy;
	}

	public void setNrjy(String nrjy) {
		this.nrjy = nrjy;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

}
