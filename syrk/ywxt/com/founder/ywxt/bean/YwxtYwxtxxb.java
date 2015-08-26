package com.founder.ywxt.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/***
 * ****************************************************************************
 * 
 * @Package: [com.founder.ywxt.bean.YwxtYwxtxxb.java]
 * @ClassName: [YwxtYwxtxxb]
 * @Description: [业务协同信息表]
 * @Author: [wu_chunhui@founder.com.cn]
 * @CreateDate: [2015-5-29 上午10:40:25]
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-5-29 上午10:40:25，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@DBInfoAnnotation(tableName = "YWXT_YWXTXXB", pk = "id")
public class YwxtYwxtxxb extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@FieldDesc("ID")
	private String id;
	@FieldDesc("业务内容")
	private String ywnr;
	@FieldDesc("业务类型")
	private String ywlx;
	@FieldDesc("数据JSON")
	private String datajson;
	@FieldDesc("备注")
	private String bz;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getYwnr() {
		return ywnr;
	}

	public void setYwnr(String ywnr) {
		this.ywnr = ywnr;
	}

	public String getYwlx() {
		return ywlx;
	}

	public void setYwlx(String ywlx) {
		this.ywlx = ywlx;
	}

	public String getDatajson() {
		return datajson;
	}

	public void setDatajson(String datajson) {
		this.datajson = datajson;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

}
