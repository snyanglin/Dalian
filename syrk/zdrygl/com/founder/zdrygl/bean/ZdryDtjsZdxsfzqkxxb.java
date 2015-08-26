package com.founder.zdrygl.bean;

import java.io.Serializable;
import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.bean.ZdryDtjsZdxsfzqkxxb.java]  
 * @ClassName:    [ZdryDtjsZdxsfzqkxxb]   
 * @Description:  [重点人员 动态记实 重大刑事犯罪前科 属性表]   
 * @Author:       [zhang.hai@founder.com.cn]  
 * @CreateDate:   [2015年8月13日 下午7:20:24]   
 * @UpdateUser:   [ZhangHai(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年8月13日 下午7:20:24，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "ZDRY_DTJS_ZDXSFZQKXXB", pk = "id")
public class ZdryDtjsZdxsfzqkxxb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@FieldDesc("ID")
	private String id;
	@FieldDesc("XSXXBH")
	private String xsxxbh;
	@FieldDesc("SSLB")
	private String sslb;
	@FieldDesc("SSLBXL")
	private String sslbxl;
	@FieldDesc("ZASD")
	private String zasd;
	@FieldDesc("ZAGJ")
	private String zagj;
	@FieldDesc("ZAGJLY")
	private String zagjly;
	@FieldDesc("ZATD")
	private String zatd;
	@FieldDesc("XZDX")
	private String xzdx;
	@FieldDesc("XZWP")
	private String xzwp;
	@FieldDesc("XZCS")
	private String xzcs;
	@FieldDesc("SFCD")
	private String sfcd;
	@FieldDesc("XZSJ")
	private String xzsj;
	@FieldDesc("XZFS")
	private String xzfs;
	@FieldDesc("XZDQ")
	private String xzdq;
	@FieldDesc("GKZYSX")
	private String gkzysx;
	@FieldDesc("SFTHZA")
	private String sfthza;
	@FieldDesc("JHFS")
	private String jhfs;
	@FieldDesc("ZADDLFS")
	private String zaddlfs;
	@FieldDesc("YDDLFS")
	private String yddlfs;
	@FieldDesc("AQLXFS")
	private String aqlxfs;
	@FieldDesc("AQQTLXFS")
	private String aqqtlxfs;
	@FieldDesc("AZLXFS")
	private String azlxfs;
	@FieldDesc("AZQTLXFS")
	private String azqtlxfs;
	@FieldDesc("AHLXFS")
	private String ahlxfs;
	@FieldDesc("AHQTLXFS")
	private String ahqtlxfs;
	@FieldDesc("TJSJ")
	private String tjsj;
	@FieldDesc("XGSJ")
	private String xgsj;
	@FieldDesc("XZQD")
	private String xzqd;
	@FieldDesc("XZFF")
	private String xzff;
	@FieldDesc("ZDRYZJHM")
	private String zdryzjhm;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getXsxxbh() {
		return xsxxbh;
	}
	public void setXsxxbh(String xsxxbh) {
		this.xsxxbh = xsxxbh;
	}
	public String getSslb() {
		return sslb;
	}
	public void setSslb(String sslb) {
		this.sslb = sslb;
	}
	public String getSslbxl() {
		return sslbxl;
	}
	public void setSslbxl(String sslbxl) {
		this.sslbxl = sslbxl;
	}
	public String getZasd() {
		return zasd;
	}
	public void setZasd(String zasd) {
		this.zasd = zasd;
	}
	public String getZagj() {
		return zagj;
	}
	public void setZagj(String zagj) {
		this.zagj = zagj;
	}
	public String getZagjly() {
		return zagjly;
	}
	public void setZagjly(String zagjly) {
		this.zagjly = zagjly;
	}
	public String getZatd() {
		return zatd;
	}
	public void setZatd(String zatd) {
		this.zatd = zatd;
	}
	public String getXzdx() {
		return xzdx;
	}
	public void setXzdx(String xzdx) {
		this.xzdx = xzdx;
	}
	public String getXzwp() {
		return xzwp;
	}
	public void setXzwp(String xzwp) {
		this.xzwp = xzwp;
	}
	public String getXzcs() {
		return xzcs;
	}
	public void setXzcs(String xzcs) {
		this.xzcs = xzcs;
	}
	public String getSfcd() {
		return sfcd;
	}
	public void setSfcd(String sfcd) {
		this.sfcd = sfcd;
	}
	public String getXzsj() {
		return xzsj;
	}
	public void setXzsj(String xzsj) {
		this.xzsj = xzsj;
	}
	public String getXzfs() {
		return xzfs;
	}
	public void setXzfs(String xzfs) {
		this.xzfs = xzfs;
	}
	public String getXzdq() {
		return xzdq;
	}
	public void setXzdq(String xzdq) {
		this.xzdq = xzdq;
	}
	public String getGkzysx() {
		return gkzysx;
	}
	public void setGkzysx(String gkzysx) {
		this.gkzysx = gkzysx;
	}
	public String getSfthza() {
		return sfthza;
	}
	public void setSfthza(String sfthza) {
		this.sfthza = sfthza;
	}
	public String getJhfs() {
		return jhfs;
	}
	public void setJhfs(String jhfs) {
		this.jhfs = jhfs;
	}
	public String getZaddlfs() {
		return zaddlfs;
	}
	public void setZaddlfs(String zaddlfs) {
		this.zaddlfs = zaddlfs;
	}
	public String getYddlfs() {
		return yddlfs;
	}
	public void setYddlfs(String yddlfs) {
		this.yddlfs = yddlfs;
	}
	public String getAqlxfs() {
		return aqlxfs;
	}
	public void setAqlxfs(String aqlxfs) {
		this.aqlxfs = aqlxfs;
	}
	public String getAqqtlxfs() {
		return aqqtlxfs;
	}
	public void setAqqtlxfs(String aqqtlxfs) {
		this.aqqtlxfs = aqqtlxfs;
	}
	public String getAzlxfs() {
		return azlxfs;
	}
	public void setAzlxfs(String azlxfs) {
		this.azlxfs = azlxfs;
	}
	public String getAzqtlxfs() {
		return azqtlxfs;
	}
	public void setAzqtlxfs(String azqtlxfs) {
		this.azqtlxfs = azqtlxfs;
	}
	public String getAhlxfs() {
		return ahlxfs;
	}
	public void setAhlxfs(String ahlxfs) {
		this.ahlxfs = ahlxfs;
	}
	public String getAhqtlxfs() {
		return ahqtlxfs;
	}
	public void setAhqtlxfs(String ahqtlxfs) {
		this.ahqtlxfs = ahqtlxfs;
	}
	public String getTjsj() {
		return tjsj;
	}
	public void setTjsj(String tjsj) {
		this.tjsj = tjsj;
	}
	public String getXgsj() {
		return xgsj;
	}
	public void setXgsj(String xgsj) {
		this.xgsj = xgsj;
	}
	public String getXzqd() {
		return xzqd;
	}
	public void setXzqd(String xzqd) {
		this.xzqd = xzqd;
	}
	public String getXzff() {
		return xzff;
	}
	public void setXzff(String xzff) {
		this.xzff = xzff;
	}
	public String getZdryzjhm() {
		return zdryzjhm;
	}
	public void setZdryzjhm(String zdryzjhm) {
		this.zdryzjhm = zdryzjhm;
	}

}
