package com.founder.sydw.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

@DBInfoAnnotation(tableName = "DW_XYAQXXB_XC", pk = "id")
public class XyaqxxbXc extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@FieldDesc("校车ID")
	private String id;
	@FieldDesc("校园ID")
	private String xyid;
	@FieldDesc("车辆ID")
	private String clid;
	@FieldDesc("校车机动车号牌号码")
	private String xcjdchphm;
	@FieldDesc("自有或租赁")
	private String zyhzl;
	@FieldDesc("租赁单位名称")
	private String zldwmc;
	@FieldDesc("租赁单位ID")
	private String zldwid;
	@FieldDesc("租赁单位法人代表姓名")
	private String zldwfrdbxm;
	@FieldDesc("租赁单位联系电话")
	private String zldwlxdh;
	@FieldDesc("核定载人数")
	private Long hdzrs;
	@FieldDesc("注册日期")
	private String zcrq;
	@FieldDesc("专用标志编号")
	private String zybzbh;
	@FieldDesc("检验有效期")
	private String jyyxq;
	@FieldDesc("人员ID")
	private String ryid;
	@FieldDesc("驾驶人证件种类代码")
	private String jsrzjlxdm;
	@FieldDesc("驾驶人证件号码")
	private String jsrzjhm;
	@FieldDesc("驾驶人姓名")
	private String jsrxm;
	@FieldDesc("驾驶人联系电话")
	private String jsrlxdh;
	@FieldDesc("采集时间")
	private String xt_cjsj;
	@FieldDesc("录入时间")
	private String xt_lrsj;
	@FieldDesc("录入人姓名")
	private String xt_lrrxm;
	@FieldDesc("录入人ID")
	private String xt_lrrid;
	@FieldDesc("录入人部门")
	private String xt_lrrbm;
	@FieldDesc("录入人部门ID")
	private String xt_lrrbmid;
	@FieldDesc("录入IP")
	private String xt_lrip;
	@FieldDesc("最后修改时间")
	private String xt_zhxgsj;
	@FieldDesc("最后修改人姓名")
	private String xt_zhxgrxm;
	@FieldDesc("最后修改人ID")
	private String xt_zhxgrid;
	@FieldDesc("最后修改人部门")
	private String xt_zhxgrbm;
	@FieldDesc("最后修改人部门ID")
	private String xt_zhxgrbmid;
	@FieldDesc("最后修改IP")
	private String xt_zhxgip;
	@FieldDesc("注销标志")
	private String xt_zxbz;
	@FieldDesc("注销原因")
	private String xt_zxyy;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getXyid() {
		return xyid;
	}
	public void setXyid(String xyid) {
		this.xyid = xyid;
	}
	public String getClid() {
		return clid;
	}
	public void setClid(String clid) {
		this.clid = clid;
	}
	public String getXcjdchphm() {
		return xcjdchphm;
	}
	public void setXcjdchphm(String xcjdchphm) {
		this.xcjdchphm = xcjdchphm;
	}
	public String getZyhzl() {
		return zyhzl;
	}
	public void setZyhzl(String zyhzl) {
		this.zyhzl = zyhzl;
	}
	public String getZldwmc() {
		return zldwmc;
	}
	public void setZldwmc(String zldwmc) {
		this.zldwmc = zldwmc;
	}
	public String getZldwid() {
		return zldwid;
	}
	public void setZldwid(String zldwid) {
		this.zldwid = zldwid;
	}
	public String getZldwfrdbxm() {
		return zldwfrdbxm;
	}
	public void setZldwfrdbxm(String zldwfrdbxm) {
		this.zldwfrdbxm = zldwfrdbxm;
	}
	public String getZldwlxdh() {
		return zldwlxdh;
	}
	public void setZldwlxdh(String zldwlxdh) {
		this.zldwlxdh = zldwlxdh;
	}
	public Long getHdzrs() {
		return hdzrs;
	}
	public void setHdzrs(Long hdzrs) {
		this.hdzrs = hdzrs;
	}
	public String getZcrq() {
		return zcrq;
	}
	public void setZcrq(String zcrq) {
		this.zcrq = zcrq;
	}
	public String getZybzbh() {
		return zybzbh;
	}
	public void setZybzbh(String zybzbh) {
		this.zybzbh = zybzbh;
	}
	public String getJyyxq() {
		return jyyxq;
	}
	public void setJyyxq(String jyyxq) {
		this.jyyxq = jyyxq;
	}
	public String getRyid() {
		return ryid;
	}
	public void setRyid(String ryid) {
		this.ryid = ryid;
	}
	public String getJsrzjlxdm() {
		return jsrzjlxdm;
	}
	public void setJsrzjlxdm(String jsrzjlxdm) {
		this.jsrzjlxdm = jsrzjlxdm;
	}
	public String getJsrzjhm() {
		return jsrzjhm;
	}
	public void setJsrzjhm(String jsrzjhm) {
		this.jsrzjhm = jsrzjhm;
	}
	public String getJsrxm() {
		return jsrxm;
	}
	public void setJsrxm(String jsrxm) {
		this.jsrxm = jsrxm;
	}
	public String getJsrlxdh() {
		return jsrlxdh;
	}
	public void setJsrlxdh(String jsrlxdh) {
		this.jsrlxdh = jsrlxdh;
	}
	public String getXt_cjsj() {
		return xt_cjsj;
	}
	public void setXt_cjsj(String xt_cjsj) {
		this.xt_cjsj = xt_cjsj;
	}
	public String getXt_lrsj() {
		return xt_lrsj;
	}
	public void setXt_lrsj(String xt_lrsj) {
		this.xt_lrsj = xt_lrsj;
	}
	public String getXt_lrrxm() {
		return xt_lrrxm;
	}
	public void setXt_lrrxm(String xt_lrrxm) {
		this.xt_lrrxm = xt_lrrxm;
	}
	public String getXt_lrrid() {
		return xt_lrrid;
	}
	public void setXt_lrrid(String xt_lrrid) {
		this.xt_lrrid = xt_lrrid;
	}
	public String getXt_lrrbm() {
		return xt_lrrbm;
	}
	public void setXt_lrrbm(String xt_lrrbm) {
		this.xt_lrrbm = xt_lrrbm;
	}
	public String getXt_lrrbmid() {
		return xt_lrrbmid;
	}
	public void setXt_lrrbmid(String xt_lrrbmid) {
		this.xt_lrrbmid = xt_lrrbmid;
	}
	public String getXt_lrip() {
		return xt_lrip;
	}
	public void setXt_lrip(String xt_lrip) {
		this.xt_lrip = xt_lrip;
	}
	public String getXt_zhxgsj() {
		return xt_zhxgsj;
	}
	public void setXt_zhxgsj(String xt_zhxgsj) {
		this.xt_zhxgsj = xt_zhxgsj;
	}
	public String getXt_zhxgrxm() {
		return xt_zhxgrxm;
	}
	public void setXt_zhxgrxm(String xt_zhxgrxm) {
		this.xt_zhxgrxm = xt_zhxgrxm;
	}
	public String getXt_zhxgrid() {
		return xt_zhxgrid;
	}
	public void setXt_zhxgrid(String xt_zhxgrid) {
		this.xt_zhxgrid = xt_zhxgrid;
	}
	public String getXt_zhxgrbm() {
		return xt_zhxgrbm;
	}
	public void setXt_zhxgrbm(String xt_zhxgrbm) {
		this.xt_zhxgrbm = xt_zhxgrbm;
	}
	public String getXt_zhxgrbmid() {
		return xt_zhxgrbmid;
	}
	public void setXt_zhxgrbmid(String xt_zhxgrbmid) {
		this.xt_zhxgrbmid = xt_zhxgrbmid;
	}
	public String getXt_zhxgip() {
		return xt_zhxgip;
	}
	public void setXt_zhxgip(String xt_zhxgip) {
		this.xt_zhxgip = xt_zhxgip;
	}
	public String getXt_zxbz() {
		return xt_zxbz;
	}
	public void setXt_zxbz(String xt_zxbz) {
		this.xt_zxbz = xt_zxbz;
	}
	public String getXt_zxyy() {
		return xt_zxyy;
	}
	public void setXt_zxyy(String xt_zxyy) {
		this.xt_zxyy = xt_zxyy;
	}

}
