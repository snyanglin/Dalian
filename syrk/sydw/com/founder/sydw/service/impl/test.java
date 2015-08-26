package com.founder.sydw.service.impl;

import java.math.BigDecimal;

public class test {

	/**
	 * @Title: main
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param args    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer zs = 50;
		double d = Double.parseDouble("9");
		double c = (zs*9.0)/100;
		int i = (int)Math.rint(c);
		BigDecimal dd = new BigDecimal(c).setScale(0, BigDecimal.ROUND_HALF_UP);
		
		System.out.println(dd.toString());;
		System.out.println((zs*90.0)/100);;
	}

}
