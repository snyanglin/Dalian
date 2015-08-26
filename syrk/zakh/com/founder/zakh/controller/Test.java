package com.founder.zakh.controller;

import com.founder.zakh.tools.Dateutil;

public class Test {

	/**
	 * @Title: main
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param args    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public static void main(String[] args) {
		   Dateutil dt=new Dateutil();
		   int maxWeek=dt.getMaxWeekNumOfYear(2015);

		   System.out.println(dt.getLastDayOfWeek(2015, maxWeek));
		   System.out.println( dt.getFirstDayOfWeek(2015, maxWeek));

	}

}
