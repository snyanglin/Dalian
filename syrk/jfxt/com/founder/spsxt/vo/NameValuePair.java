package com.founder.spsxt.vo;

//名值对。为根据条件(如拼音)进行快速过滤
public class NameValuePair implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String id;//id（数字）ֵ
	private String name;//名称ֵ
	
	public NameValuePair(){}//默认构造函数
	public NameValuePair(String name,String id){
		this.name=name;
		this.id=id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	
}
