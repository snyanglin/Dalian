package com.founder.zdry.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/***
 * ****************************************************************************
 * 
 * @Package: [com.founder.zdry.bean.Zagltdxxb.java]
 * @ClassName: [Zagltdxxb]
 * @Description: [重点人员补充信息－作案规律特点]
 * @Author: [wu_chunhui@founder.com.cn]
 * @CreateDate: [2015-3-11 下午6:11:40]
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-3-11 下午6:11:40，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@DBInfoAnnotation(tableName = "ZDRY_ZAGLTDXXB", pk = "id")
public class ZdryZagltdxxb extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@FieldDesc("作案规律特点ID")
	private String id;
	@FieldDesc("重点人员ID")
	private String zdryid;
	@FieldDesc("案件类别代码")
	private String ajlbdm;
	@FieldDesc("选择对象代码")
	private String xzdxdm;
	@FieldDesc("选择物品代码")
	private String xzwpdm;
	@FieldDesc("作案手段代码")
	private String zasddm;
	@FieldDesc("作案工具代码")
	private String zagjdm;
	@FieldDesc("销赃方式代码")
	private String xyrxzfsdm;
	@FieldDesc("作案特点代码")
	private String zatddm;
	@FieldDesc("选择时机代码")
	private String xzsjdm;
	@FieldDesc("选择处所代码")
	private String xzcsdm;
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

	public String getAjlbdm() {
		return ajlbdm;
	}

	public void setAjlbdm(String ajlbdm) {
		this.ajlbdm = ajlbdm;
	}

	public String getXzdxdm() {
		return xzdxdm;
	}

	public void setXzdxdm(String xzdxdm) {
		this.xzdxdm = xzdxdm;
	}

	public String getXzwpdm() {
		return xzwpdm;
	}

	public void setXzwpdm(String xzwpdm) {
		this.xzwpdm = xzwpdm;
	}

	public String getZasddm() {
		return zasddm;
	}

	public void setZasddm(String zasddm) {
		this.zasddm = zasddm;
	}

	public String getZagjdm() {
		return zagjdm;
	}

	public void setZagjdm(String zagjdm) {
		this.zagjdm = zagjdm;
	}

	public String getXyrxzfsdm() {
		return xyrxzfsdm;
	}

	public void setXyrxzfsdm(String xyrxzfsdm) {
		this.xyrxzfsdm = xyrxzfsdm;
	}

	public String getZatddm() {
		return zatddm;
	}

	public void setZatddm(String zatddm) {
		this.zatddm = zatddm;
	}

	public String getXzsjdm() {
		return xzsjdm;
	}

	public void setXzsjdm(String xzsjdm) {
		this.xzsjdm = xzsjdm;
	}

	public String getXzcsdm() {
		return xzcsdm;
	}

	public void setXzcsdm(String xzcsdm) {
		this.xzcsdm = xzcsdm;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

}
