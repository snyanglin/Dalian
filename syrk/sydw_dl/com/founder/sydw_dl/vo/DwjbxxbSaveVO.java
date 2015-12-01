package com.founder.sydw_dl.vo;

import com.founder.sydw_dl.bean.Dwbmxxb;
import com.founder.sydw_dl.bean.Dwjbxxb;

public class DwjbxxbSaveVO {

	private Dwjbxxb dwjbxxb;
	
	

	private Dwbmxxb[]  dwbmxxbArray;
	
	private String enterpriseId;
	
	
	
	
	public String getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(String enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	public Dwbmxxb[] getDwbmxxbArray() {
		return dwbmxxbArray;
	}

	public void setDwbmxxbArray(Dwbmxxb[] dwbmxxbArray) {
		this.dwbmxxbArray = dwbmxxbArray;
	}

	public Dwjbxxb getDwjbxxb() {
		return dwjbxxb;
	}

	public void setDwjbxxb(Dwjbxxb dwjbxxb) {
		this.dwjbxxb = dwjbxxb;
	}


}
