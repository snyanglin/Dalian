package com.founder.sydw.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;
/**
 * ****************************************************************************
 * @Package:      [com.founder.sydw.bean.Xfdwcccsxxb.java]  
 * @ClassName:    [Xfdwcccsxxb]   
 * @Description:  消防单位抽查参数信息表 
 * @Author:       [yu_guangli@founder.com.cn]  
 * @CreateDate:   [2015-7-6 下午4:31:51]   
 * @UpdateUser:   [yuguangli(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-7-6 下午4:31:51，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "DW_XFDWCCCSXXB", pk = "id", logQueryField = "id")
public class Xfdwcccsxxb extends BaseEntity implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;
	@FieldDesc("主键")
	private String id;
	@FieldDesc("专职监督 检查人员数")
	private String zzjcrs;
	@FieldDesc("兼职监督 检查人员数")
	private String jzjcrs;
	@FieldDesc("重点 点位占抽查单位的百分比")
	private String zddwzccdwdbfb;
	@FieldDesc("总数")
	private String zs;
	@FieldDesc("重点单位 数")
	private String zddws;
	@FieldDesc("非重点单位 数")
	private String fzddws;
	@FieldDesc("年份")
	private String nf;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getZzjcrs() {
		return zzjcrs;
	}
	public void setZzjcrs(String zzjcrs) {
		this.zzjcrs = zzjcrs;
	}
	public String getJzjcrs() {
		return jzjcrs;
	}
	public void setJzjcrs(String jzjcrs) {
		this.jzjcrs = jzjcrs;
	}
	public String getZddwzccdwdbfb() {
		return zddwzccdwdbfb;
	}
	public void setZddwzccdwdbfb(String zddwzccdwdbfb) {
		this.zddwzccdwdbfb = zddwzccdwdbfb;
	}
	public String getZs() {
		return zs;
	}
	public void setZs(String zs) {
		this.zs = zs;
	}
	public String getZddws() {
		return zddws;
	}
	public void setZddws(String zddws) {
		this.zddws = zddws;
	}
	public String getFzddws() {
		return fzddws;
	}
	public void setFzddws(String fzddws) {
		this.fzddws = fzddws;
	}
	public String getNf() {
		return nf;
	}
	public void setNf(String nf) {
		this.nf = nf;
	}
}
