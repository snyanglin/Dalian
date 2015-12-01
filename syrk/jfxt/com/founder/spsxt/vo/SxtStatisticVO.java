package com.founder.spsxt.vo;

public class SxtStatisticVO {
	private String name;//名称
	private int noCoordinate;//没有坐标的摄像头数
	private int hasCoordinate;//有坐标的摄像头数
	private int total;//摄像头总数
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNoCoordinate() {
		return noCoordinate;
	}
	public void setNoCoordinate(int noCoordinate) {
		this.noCoordinate = noCoordinate;
	}
	public int getHasCoordinate() {
		return hasCoordinate;
	}
	public void setHasCoordinate(int hasCoordinate) {
		this.hasCoordinate = hasCoordinate;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
}
