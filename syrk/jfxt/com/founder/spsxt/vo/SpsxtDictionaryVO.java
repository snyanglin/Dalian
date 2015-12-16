package com.founder.spsxt.vo;

import java.io.Serializable;




public class SpsxtDictionaryVO  implements Serializable  {	
	private String id ;//
	private String text ;//
	private String py ;//
	public SpsxtDictionaryVO(String dm,String dmyy,String pym){
		this.id=dm;
		this.text=dmyy;
		this.py=pym;
	}	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getPy() {
		return py;
	}
	public void setPy(String py) {
		this.py = py;
	}




}
