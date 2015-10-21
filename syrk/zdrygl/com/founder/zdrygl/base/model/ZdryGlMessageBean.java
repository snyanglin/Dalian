package com.founder.zdrygl.base.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZdryGlMessageBean implements Serializable {

	private static final long serialVersionUID = -4936615988429419460L;

	//是否发送消息的标识符：默认为false
	private boolean sendAble = false;
	
	//系统中定义的消息类型：LGSQ[列管申请];LGSPJG[列管审批结果]...
	private String xxlx;
	
	/**
	 * 参数集
	 */
	private Map<String, String> paraMap = new HashMap<String, String>();
	
	/**
	 * 结果集
	 */
	private Map<String, Object> resultMap = new HashMap<String, Object>();

	/**
	 * 创建新的字符串list
	 * @return
	 */
	public List<String> createNewStringList(){
		return new ArrayList<String>();
	}
	
	public boolean isSendAble() {
		return sendAble;
	}

	public void setSendAble(boolean sendAble) {
		this.sendAble = sendAble;
	}

	public String getXxlx() {
		return xxlx;
	}

	public void setXxlx(String xxlx) {
		this.xxlx = xxlx;
	}

	public Map<String, String> getParaMap() {
		return paraMap;
	}

	public void setParaMap(Map<String, String> paraMap) {
		this.paraMap = paraMap;
	}

	public Map<String, Object> getResultMap() {
		return resultMap;
	}

	public void setResultMap(Map<String, Object> resultMap) {
		this.resultMap = resultMap;
	}
	
	public void addResultMapValue(String key,Object value) {
		this.resultMap.put(key, value);
	}
	
	public List<String> getNewEmptyStringList(){
		return new ArrayList<String>();
	}
	
}
