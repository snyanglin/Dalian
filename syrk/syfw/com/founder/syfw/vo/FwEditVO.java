package com.founder.syfw.vo;

import com.founder.syfw.bean.Czfwxxb;
import com.founder.syfw.bean.Fwjbxxb;

public class FwEditVO {
	
	private Fwjbxxb fwjbxxb = new Fwjbxxb();;
	
	private Czfwxxb czfwxxb = new Czfwxxb();
	
	private String housesId;
	
	
	

	public String getHousesId() {
		return housesId;
	}

	public void setHousesId(String housesId) {
		this.housesId = housesId;
	}

	public Fwjbxxb getFwjbxxb() {
		return fwjbxxb;
	}

	public void setFwjbxxb(Fwjbxxb fwjbxxb) {
		this.fwjbxxb = fwjbxxb;
	}

	public Czfwxxb getCzfwxxb() {
		return czfwxxb;
	}

	public void setCzfwxxb(Czfwxxb czfwxxb) {
		this.czfwxxb = czfwxxb;
	}
	
	

}
