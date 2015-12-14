package com.founder.gzjk.vo;

public class CountBean {
	
	private String orgcode;
	
	private  int editCount = 0;
	
	private  int addCount = 0;
	
	private  int CancellCont = 0;
	
	private  int Count = 0;
	
	private String ywlx;
	
	private String ywms;
	
	private String dwdm;
	

	public int getEditCount() {
		return editCount;
	}

	public void setEditCount(int editCount) {
		this.editCount = editCount;
	}

	public int getAddCount() {
		return addCount;
	}

	public void setAddCount(int addCount) {
		this.addCount = addCount;
	}

	public int getCancellCont() {
		return CancellCont;
	}

	public void setCancellCont(int cancellCont) {
		CancellCont = cancellCont;
	}

	public int getCount() {
		return Count;
	}

	public void setCount(int count) {
		Count = count;
	}

	public String getYwlx() {
		return ywlx;
	}

	public void setYwlx(String ywlx) {
		this.ywlx = ywlx;
	}

	public String getYwms() {
		return ywms;
	}

	public void setYwms(String ywms) {
		this.ywms = ywms;
	}

	public String getDwdm() {
		return dwdm;
	}

	public void setDwdm(String dwdm) {
		this.dwdm = dwdm;
	}

	public String getOrgcode() {
		return orgcode;
	}

	public void setOrgcode(String orgcode) {
		this.orgcode = orgcode;
	}
	
	
	
	
}
