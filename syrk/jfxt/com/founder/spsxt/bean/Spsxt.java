package com.founder.spsxt.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

@DBInfoAnnotation(tableName = "JF_SPTJBXX")
public class Spsxt extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@FieldDesc("ID")
	private String id;
	@FieldDesc("条码")
	private String tm;
	@FieldDesc("摄像头编号")
	private String sxtbh;
	@FieldDesc("固定可动")
	private String sb_gd;
	@FieldDesc("摄像头所属监控系统") 
	private String jkxt;
	@FieldDesc("纬度") 
	private String wd;
	@FieldDesc("安装部位")  
	private String azbw;
	@FieldDesc("朝向") 
	private String cx;
	@FieldDesc("经度")                    
	private String jd;
	@FieldDesc("点位名称")
	private String dwmc;
	@FieldDesc("点位俗称")                
	private String dwsc;
	@FieldDesc("点位高度")                
	private String dwgd;
	@FieldDesc("关联点位数量")            
	private String gldw;
	@FieldDesc("点位监控角度")            
	private String jkjd;
	@FieldDesc("高清标清")    
	private String sb_gqbq;
	@FieldDesc("高清属性") 
	private String sbgqsx;
	@FieldDesc("枪机球机")    
	private String sb_qjqj;
	@FieldDesc("室内室外")    
	private String sb_snsw;
	@FieldDesc("夜视非夜视")  
	private String sb_ys;
	@FieldDesc("夜视属性") 
	private String sbyssx;
	@FieldDesc("设备类型")    
	private String sblx;
	@FieldDesc("摄像头所属的地理区域")   
	private String dlqy;
	@FieldDesc("摄像头应用属性")  
	private String yysx;
	private String yysx_xs;//应用属性显示
	private String jtbs;//镜头变焦倍数
	
	@FieldDesc("建设单位编码") 
	private String dwbm;
	private String  ssjgdm;//所属机构代码
	
	private String sxtbs;//摄像头标识--分局+派出所+社区+序号
	private String sxtgldw;//摄像头管理单位  
	private String pic_location;//照片路径
	private String sszrq;//所属责任区
	
	private String sfrw;//是否接入公安网--0: 接入公安网； 1: 未接入
	private String azbw_rw;//安装部位，接入公安网的保存标准地址+自定义
	private String azbw_rw_dzdm;//接入公安网的保存标准地址代码
	private String azbw_rw_dzxz;//接入公安网的保存标准地址详址
	private String azbw_rw_mlpdm;//接入公安网的保存标准地址门楼牌代码
	private String azbw_rw_mlpxz;//接入公安网的保存标准地址门楼牌详址
	
	private String sfgazj;//是否公安自建(是：1；否：0)
	
	private String xtidbm;//公安自建--系统ID编码
	private String sxtip;//公安自建--摄像头IP地址
	
	
	private String fjNumber;//分局内摄像头编码2014.12.31.
	
	public String getSxtbs() {
		return sxtbs;
	}
	public void setSxtbs(String sxtbs) {
		this.sxtbs = sxtbs;
	}
	public String getSxtgldw() {
		return sxtgldw;
	}
	public void setSxtgldw(String sxtgldw) {
		this.sxtgldw = sxtgldw;
	}
	public String getPic_location() {
		return pic_location;
	}
	public void setPic_location(String pic_location) {
		this.pic_location = pic_location;
	}
	public String getSszrq() {
		return sszrq;
	}
	public void setSszrq(String sszrq) {
		this.sszrq = sszrq;
	}
	public String getYysx_xs() {
		return yysx_xs;
	}
	public void setYysx_xs(String yysx_xs) {
		this.yysx_xs = yysx_xs;
	}
	public String getJtbs() {
		return jtbs;
	}
	public void setJtbs(String jtbs) {
		this.jtbs = jtbs;
	}
	public String getSsjgdm() {
		return ssjgdm;
	}
	public void setSsjgdm(String ssjgdm) {
		this.ssjgdm = ssjgdm;
	}
	public String getDwbm() {
		return dwbm;
	}
	public void setDwbm(String dwbm) {
		this.dwbm = dwbm;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getSxtbh() {
		return sxtbh;
	}
	public void setSxtbh(String sxtbh) {
		this.sxtbh = sxtbh;
	}
	public String getSb_gd() {
		return sb_gd;
	}
	public void setSb_gd(String sb_gd) {
		this.sb_gd = sb_gd;
	}
	public String getJkxt() {
		return jkxt;
	}
	public void setJkxt(String jkxt) {
		this.jkxt = jkxt;
	}
	public String getWd() {
		return wd;
	}
	public void setWd(String wd) {
		this.wd = wd;
	}
	public String getAzbw() {
		return azbw;
	}
	public void setAzbw(String azbw) {
		this.azbw = azbw;
	}
	public String getCx() {
		return cx;
	}
	public void setCx(String cx) {
		this.cx = cx;
	}
	public String getJd() {
		return jd;
	}
	public void setJd(String jd) {
		this.jd = jd;
	}
	public String getDwmc() {
		return dwmc;
	}
	public void setDwmc(String dwmc) {
		this.dwmc = dwmc;
	}
	public String getDwsc() {
		return dwsc;
	}
	public void setDwsc(String dwsc) {
		this.dwsc = dwsc;
	}
	public String getDwgd() {
		return dwgd;
	}
	public void setDwgd(String dwgd) {
		this.dwgd = dwgd;
	}
	public String getGldw() {
		return gldw;
	}
	public void setGldw(String gldw) {
		this.gldw = gldw;
	}
	public String getJkjd() {
		return jkjd;
	}
	public void setJkjd(String jkjd) {
		this.jkjd = jkjd;
	}
	public String getSb_gqbq() {
		return sb_gqbq;
	}
	public void setSb_gqbq(String sb_gqbq) {
		this.sb_gqbq = sb_gqbq;
	}
	public String getSb_qjqj() {
		return sb_qjqj;
	}
	public void setSb_qjqj(String sb_qjqj) {
		this.sb_qjqj = sb_qjqj;
	}
	public String getSb_snsw() {
		return sb_snsw;
	}
	public void setSb_snsw(String sb_snsw) {
		this.sb_snsw = sb_snsw;
	}
	public String getSb_ys() {
		return sb_ys;
	}
	public void setSb_ys(String sb_ys) {
		this.sb_ys = sb_ys;
	}
	public String getSblx() {
		return sblx;
	}
	public void setSblx(String sblx) {
		this.sblx = sblx;
	}
	public String getDlqy() {
		return dlqy;
	}
	public void setDlqy(String dlqy) {
		this.dlqy = dlqy;
	}
	public String getSbgqsx() {
		return sbgqsx;
	}
	public void setSbgqsx(String sbgqsx) {
		this.sbgqsx = sbgqsx;
	}
	public String getSbyssx() {
		return sbyssx;
	}
	public void setSbyssx(String sbyssx) {
		this.sbyssx = sbyssx;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTm() {
		return tm;
	}
	public void setTm(String tm) {
		this.tm = tm;
	}
	public String getYysx() {
		return yysx;
	}
	public void setYysx(String yysx) {
		this.yysx = yysx;
	}
	public String getSfrw() {
		return sfrw;
	}
	public void setSfrw(String sfrw) {
		this.sfrw = sfrw;
	}
	public String getAzbw_rw() {
		return azbw_rw;
	}
	public void setAzbw_rw(String azbw_rw) {
		this.azbw_rw = azbw_rw;
	}
	public String getAzbw_rw_dzdm() {
		return azbw_rw_dzdm;
	}
	public void setAzbw_rw_dzdm(String azbw_rw_dzdm) {
		this.azbw_rw_dzdm = azbw_rw_dzdm;
	}
	public String getAzbw_rw_dzxz() {
		return azbw_rw_dzxz;
	}
	public void setAzbw_rw_dzxz(String azbw_rw_dzxz) {
		this.azbw_rw_dzxz = azbw_rw_dzxz;
	}
	public String getAzbw_rw_mlpdm() {
		return azbw_rw_mlpdm;
	}
	public void setAzbw_rw_mlpdm(String azbw_rw_mlpdm) {
		this.azbw_rw_mlpdm = azbw_rw_mlpdm;
	}
	public String getAzbw_rw_mlpxz() {
		return azbw_rw_mlpxz;
	}
	public void setAzbw_rw_mlpxz(String azbw_rw_mlpxz) {
		this.azbw_rw_mlpxz = azbw_rw_mlpxz;
	}
	
	public String getXtidbm() {
		return xtidbm;
	}
	public void setXtidbm(String xtidbm) {
		this.xtidbm = xtidbm;
	}
	public String getSxtip() {
		return sxtip;
	}
	public void setSxtip(String sxtip) {
		this.sxtip = sxtip;
	}
	public String getSfgazj() {
		return sfgazj;
	}
	public void setSfgazj(String sfgazj) {
		this.sfgazj = sfgazj;
	}
	//分局内摄像头编码
	public String getFjNumber() {
		return fjNumber;
	}
	public void setFjNumber(String fjNumber) {
		this.fjNumber = fjNumber;
	}
	
}