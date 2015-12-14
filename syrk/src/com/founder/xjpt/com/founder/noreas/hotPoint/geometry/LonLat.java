package com.founder.xjpt.com.founder.noreas.hotPoint.geometry;

public class LonLat {
	private double x;
	private double y;

	public LonLat() {
	}

	public LonLat(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return this.x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return this.y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public String toString() {
		return "POINT(" + this.x + " " + this.y + ")";
	}
}
