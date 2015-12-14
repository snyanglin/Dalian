package com.founder.xjpt.com.founder.noreas.hotPoint.hotspot;

public class DefaultEasing implements Easing {
	private int maxValue;
	@SuppressWarnings("unused")
	private int radius;
	private int NUM = 3;

	@SuppressWarnings("unused")
	private double a = 1.0D / (Math.sqrt(2.0D) * 3.141592653589793D);

	public DefaultEasing(int maxValue) {
		this.maxValue = maxValue;
	}

	public int calculate(double scale) {
		double x = scale * this.NUM;
		int value = (int) (Math.pow(2.718281828459045D, -0.5D
				* Math.pow(x, 2.0D)) * this.maxValue);
		return value;
	}
}
