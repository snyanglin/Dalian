package com.founder.service.attachment.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

@DBInfoAnnotation(tableName = "ZPFJ_FJXZJLB", pk = "id")
public class ZpfjFjxzjlb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@FieldDesc("ID")
	private String id;
	@FieldDesc("文件ID")
	private String wjid;
	@FieldDesc("下载时间")
	private String xzsj;
	@FieldDesc("下载人姓名")
	private String xzrrxm;
	@FieldDesc("下载人ID")
	private String xzrid;
	@FieldDesc("下载人部门")
	private String xzrbm;
	@FieldDesc("下载人部门ID")
	private String xzrbmid;
	@FieldDesc("下载IP")
	private String xzip;
	@FieldDesc("备注")
	private String bz;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWjid() {
		return wjid;
	}

	public void setWjid(String wjid) {
		this.wjid = wjid;
	}

	public String getXzsj() {
		return xzsj;
	}

	public void setXzsj(String xzsj) {
		this.xzsj = xzsj;
	}

	public String getXzrrxm() {
		return xzrrxm;
	}

	public void setXzrrxm(String xzrrxm) {
		this.xzrrxm = xzrrxm;
	}

	public String getXzrid() {
		return xzrid;
	}

	public void setXzrid(String xzrid) {
		this.xzrid = xzrid;
	}

	public String getXzrbm() {
		return xzrbm;
	}

	public void setXzrbm(String xzrbm) {
		this.xzrbm = xzrbm;
	}

	public String getXzrbmid() {
		return xzrbmid;
	}

	public void setXzrbmid(String xzrbmid) {
		this.xzrbmid = xzrbmid;
	}

	public String getXzip() {
		return xzip;
	}

	public void setXzip(String xzip) {
		this.xzip = xzip;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

}
