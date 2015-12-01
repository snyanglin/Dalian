package com.founder.zdry.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * ****************************************************************************
 * @Package:      [com.founder.zdry.vo.ZdryxxzsVO.java]  
 * @ClassName:    [ZdryxxzsVO]   
 * @Description:  [重点人员编辑页面 展示VO]   
 * @Author:       [weiwen]  
 * @CreateDate:   [2015-3-13 下午6:04:16]   
 * @UpdateUser:   [weiwen]   
 * @UpdateDate:   [2015-3-13 下午6:04:16，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
public class ZdryxxzsVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -941041409572955307L;
	private String xxbh;//信息编号
	private String xxdxlxdm;//信息大类小类
	private String xxbtmc;//标题
	private String gnlxdm;//功能类型
	private String xxurl;//URL
	private String cshzk;//初始化状态 1打开 2关闭
	private String xxzsjlzds;//最大显示条数
	private Integer px;//顺序号
	private String icon;//大类图标样式
	private String sfdt;//是否多条 , 1是单, 2 是多
	private String isEdit;//是否可以编辑1为可以编辑
	private String zdryId;//重点
	private String zdrylxdm;//大类
	private String zdrylbdm;//小类,如果多条用逗号
	
	private String gxzrq;//管辖责任区代码
	
	
	
	
	
	/**
	 * @return the zdrylxdm
	 */
	public String getZdrylxdm() {
		return zdrylxdm;
	}
	/**
	 * @param zdrylxdm the zdrylxdm to set
	 */
	public void setZdrylxdm(String zdrylxdm) {
		this.zdrylxdm = zdrylxdm;
	}
	/**
	 * @return the zdrylbdm
	 */
	public String getZdrylbdm() {
		return zdrylbdm;
	}
	/**
	 * @param zdrylbdm the zdrylbdm to set
	 */
	public void setZdrylbdm(String zdrylbdm) {
		this.zdrylbdm = zdrylbdm;
	}
	private List<ZdryxxzsVO> list = new ArrayList<ZdryxxzsVO>();
	
	
	
	
	/**
	 * @return the gxzrq
	 */
	public String getGxzrq() {
		return gxzrq;
	}
	/**
	 * @param gxzrq the gxzrq to set
	 */
	public void setGxzrq(String gxzrq) {
		this.gxzrq = gxzrq;
	}
	/**
	 * @return the isEdit
	 */
	public String getIsEdit() {
		return isEdit;
	}
	/**
	 * @param isEdit the isEdit to set
	 */
	public void setIsEdit(String isEdit) {
		this.isEdit = isEdit;
	}
	/**
	 * @return the zdryId
	 */
	public String getZdryId() {
		return zdryId;
	}
	/**
	 * @param zdryId the zdryId to set
	 */
	public void setZdryId(String zdryId) {
		this.zdryId = zdryId;
	}
	public String getXxbh() {
		return xxbh;
	}
	public void setXxbh(String xxbh) {
		this.xxbh = xxbh;
	}
	public String getXxdxlxdm() {
		return xxdxlxdm;
	}
	public void setXxdxlxdm(String xxdxlxdm) {
		this.xxdxlxdm = xxdxlxdm;
	}
	public String getXxbtmc() {
		return xxbtmc;
	}
	public void setXxbtmc(String xxbtmc) {
		this.xxbtmc = xxbtmc;
	}
	public String getGnlxdm() {
		return gnlxdm;
	}
	public void setGnlxdm(String gnlxdm) {
		this.gnlxdm = gnlxdm;
	}
	public String getXxurl() {
		return xxurl;
	}
	public void setXxurl(String xxurl) {
		this.xxurl = xxurl;
	}
	public String getCshzk() {
		return cshzk;
	}
	public void setCshzk(String cshzk) {
		this.cshzk = cshzk;
	}
	public String getXxzsjlzds() {
		return xxzsjlzds;
	}
	public void setXxzsjlzds(String xxzsjlzds) {
		this.xxzsjlzds = xxzsjlzds;
	}
	public Integer getPx() {
		return px;
	}
	public void setPx(Integer px) {
		this.px = px;
	}
	public List<ZdryxxzsVO> getList() {
		return list;
	}
	public void setList(List<ZdryxxzsVO> list) {
		this.list = list;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getSfdt() {
		return sfdt;
	}
	public void setSfdt(String sfdt) {
		this.sfdt = sfdt;
	}
	
}
