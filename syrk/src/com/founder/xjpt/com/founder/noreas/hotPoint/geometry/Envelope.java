package com.founder.xjpt.com.founder.noreas.hotPoint.geometry;

public class Envelope implements Scope {
	private double minX;
	private double maxX;
	private double minY;
	private double maxY;

	public Envelope() {
	}

	public Envelope(double minX, double maxX, double minY, double maxY) {
		this.minX = minX;
		this.maxX = maxX;
		this.minY = minY;
		this.maxY = maxY;
	}

	public double getMinX() {
		return this.minX;
	}

	public void setMinX(double minX) {
		this.minX = minX;
	}

	public double getMaxX() {
		return this.maxX;
	}

	public void setMaxX(double maxX) {
		this.maxX = maxX;
	}

	public double getMinY() {
		return this.minY;
	}

	public void setMinY(double minY) {
		this.minY = minY;
	}

	public double getMaxY() {
		return this.maxY;
	}

	public void setMaxY(double maxY) {
		this.maxY = maxY;
	}

	public boolean contain(LonLat lonlat) {
		return (lonlat.getX() > this.minX) && (lonlat.getX() < this.maxX)
				&& (lonlat.getY() > this.minY) && (lonlat.getY() < this.maxY);
	}

	public LonLat getCenter() {
		return new LonLat((this.maxX + this.minX) / 2.0D,
				(this.maxY + this.minY) / 2.0D);
	}

	public String toString() {
		return "[" + this.minX + "," + this.maxX + "," + this.minY + ","
				+ this.maxY + "]";
	}

	public double getWidth() {
		return this.maxX - this.minX;
	}

	public double getHeight() {
		return this.maxY - this.minY;
	}

	public void setCenter(LonLat lonlat) {
		double oldX = (this.minX + this.maxX) / 2.0D;
		double oldY = (this.minY + this.maxY) / 2.0D;
		double x = lonlat.getX() - oldX;
		double y = lonlat.getY() - oldY;
		this.minX += x;
		this.maxX += x;
		this.minY += y;
		this.maxY += y;
	}

	public Envelope clone() {
		return new Envelope(this.minX, this.maxX, this.minY, this.maxY);
	}
}
