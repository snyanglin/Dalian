package com.founder.zafffwqz.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * 治安防范展示信息配置VO
 * @author Administrator
 *
 */
public class ZaffxxzsVO implements Serializable{
	
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
	
	private List<ZaffxxzsVO> list = new ArrayList<ZaffxxzsVO>();
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
	public List<ZaffxxzsVO> getList() {
		return list;
	}
	public void setList(List<ZaffxxzsVO> list) {
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
