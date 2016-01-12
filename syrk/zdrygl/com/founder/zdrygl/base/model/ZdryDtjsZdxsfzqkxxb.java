package com.founder.zdrygl.base.model;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.bean.ZdryDtjsZdxsfzqkxxb.java]  
 * @ClassName:    [ZdryDtjsZdxsfzqkxxb]   
 * @Description:  [重点人员 动态记实 重大刑事犯罪前科 属性表]   
 * @Author:       [cong_rihong@founder.com.cn]  
 * @CreateDate:   [2015年12月10日 下午7:20:24]   
 * @UpdateUser:   [cong_rihong(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年12月10日 下午7:20:24，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@DBInfoAnnotation(tableName = "ZDRY_DTJS_ZDXSFZQKXXB", pk = "id")
public class ZdryDtjsZdxsfzqkxxb extends BaseEntity implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2182933894699278318L;
	@FieldDesc("id")
	private String id;
	@FieldDesc("所属类别")
	private String sslb;
	@FieldDesc("所示类别细类")
	private String sslbxl;
	@FieldDesc("作案手段")
	private String zasd;
	@FieldDesc("作案工具")
	private String zagj;
	@FieldDesc("作案工具来源")
	private String zagjly;
	@FieldDesc("作案特点")
	private String zatd;
	@FieldDesc("选择对象")
	private String xzdx;
	@FieldDesc("选择物品")
	private String xzwp;
	@FieldDesc("选择处所")
	private String xzcs;
	@FieldDesc("是否踩点")
	private String sfcd;
	@FieldDesc("选择时机")
	private String xzsj;
	@FieldDesc("销赃方式？？？？？？")
	private String xzfs;
	@FieldDesc("销赃地区")
	private String xzdq;
	@FieldDesc("管控注意事项")
	private String gkzysx;
	@FieldDesc("是否团伙作案")
	private String sfthza;
	@FieldDesc("结伙方式")
	private String jhfs;
	@FieldDesc("作案地逗留方式")
	private String zaddlfs;
	@FieldDesc("异地逗留方式")
	private String yddlfs;
	@FieldDesc("案前联系方式")
	private String aqlxfs;
	@FieldDesc("案前其他联系方式")
	private String aqqtlxfs;
	@FieldDesc("案中联系方式")
	private String azlxfs;
	@FieldDesc("案中其他联系方式")
	private String azqtlxfs;
	@FieldDesc("案后联系方式")
	private String ahlxfs;
	@FieldDesc("案后其他联系方式")
	private String ahqtlxfs;
	@FieldDesc("销赃渠道")
	private String xzqd;
	@FieldDesc("销赃方法？？？？？？？？")
	private String xzff;
	@FieldDesc("重点人证件号码")
	private String zdryzjhm;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
