package com.founder.drools.base.zdry.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 重点人员管理
 * @author cmd
 *
 */
public class ZdryLcgGllxBean implements Serializable{

	private static final long serialVersionUID = 2850275916510459246L;

	/** 重点人员管理类型代码 */
	private String zdryGllxdm;
	
	/** 
	 * 可同时列管类型<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;map[text,value]
	 * <ul>
	 * 	<li>text:管理类型名称</li>
	 * 	<li>value:管理类型代码</li>
	 * </ul>
	 */
	private List<Map<String,String>> tslglx = new ArrayList<Map<String,String>>();
	
	/** 
	 * 撤管后可转类型<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;map[text,value]
	 * <ul>
	 * 	<li>text:管理类型名称</li>
	 * 	<li>value:管理类型代码</li>
	 * </ul>
	 */
	private List<Map<String,String>> cgkzlx = new ArrayList<Map<String,String>>();
	
	/**
	 * 添加 可同时列管类型
	 * @param id 管理类型名称
	 * @param text 管理类型代码
	 * @param py 拼音
	 */
	public void addTslglx(String id,String text,String py){
		Map<String,String> map = new HashMap<String,String>();
		map.put("id", id);
		map.put("text", text);
		map.put("py", py);
		this.tslglx.add(map);
	}
	
	/**
	 * 添加 撤管后可转类型
	 * @param id 管理类型名称
	 * @param text 管理类型代码
	 * @param py 拼音
	 */
	public void addCglx(String id,String text,String py){
		Map<String,String> map = new HashMap<String,String>();
		map.put("id", id);
		map.put("text", text);
		map.put("py", py);
		this.cgkzlx.add(map);
	}

	public String getZdryGllxdm() {
		return zdryGllxdm;
	}

	public void setZdryGllxdm(String zdryGllxdm) {
		this.zdryGllxdm = zdryGllxdm;
	}

	public List<Map<String, String>> getTslglx() {
		return tslglx;
	}

	public void setTslglx(List<Map<String, String>> tslglx) {
		this.tslglx = tslglx;
	}

	public List<Map<String, String>> getCgkzlx() {
		return cgkzlx;
	}

	public void setCgkzlx(List<Map<String, String>> cgkzlx) {
		this.cgkzlx = cgkzlx;
	}
	
}
