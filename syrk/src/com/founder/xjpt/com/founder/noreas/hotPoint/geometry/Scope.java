package com.founder.xjpt.com.founder.noreas.hotPoint.geometry;

public abstract interface Scope extends Cloneable {
	public abstract LonLat getCenter();

	public abstract boolean contain(LonLat paramLonLat);

	public abstract void setCenter(LonLat paramLonLat);

	public abstract Scope clone();
}
