package com.founder.utils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * @类名: DateTimeUtils 
 * @描述: 时间DateTime公共类(lib包里DateTimeHelper类，不满足需求)
 * @作者: zhang_guoliang@founder.com 
 * @日期: 2015-5-13 下午4:33:11 
 */
public class DateTimeUtils {
	/**
	 * @Title: main 
	 * @描述: 测试输出时间
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-5-13 下午6:13:11 
	 * @返回值: void    返回类型 
	 * @throws
	 */
	public static void main(String[] args) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("当天0点时间："+formatter.format(getTimesmorning()));
		System.out.println("当天24点时间："+formatter.format(getTimesnight()));
		System.out.println("获得本周一0点时间："+formatter.format(getTimesWeekmorning()));
		System.out.println("获取本周日24点时间："+formatter.format(getTimesWeeknight()));
		System.out.println("获得本月第一天0点时间："+formatter.format(getTimesMonthmorning()));
		System.out.println("获得本月最后一天24点时间："+formatter.format(getTimesMonthnight()));
		System.out.println("获得本季度初："+formatter.format(getTimesQuartermorning()));
		System.out.println("获得本季度末："+formatter.format(getTimesQuarternight()));
		System.out.println("获得本年第一天："+formatter.format(getTimesYearmorning()));
		System.out.println("获得本年最后一天："+formatter.format(getTimesYearnight()));
	}
    /**
     * @Title: getTimesmorning 
     * @描述: 获得当天0点时间
     * @作者: zhang_guoliang@founder.com 
     * @参数: 传入参数定义 
     * @日期： 2015-5-13 下午5:04:03 
     * @返回值: Date    返回类型 
     * @throws
     */
	public static Date getTimesmorning(){
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
	/**
	 * @Title: getTimesnight 
	 * @描述: 获得当天24点时间
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-5-13 下午6:10:50 
	 * @返回值: Date    返回类型 
	 * @throws
	 */
	public static Date getTimesnight(){
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 24);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
	/**
	 * @Title: getTimesWeekmorning 
	 * @描述: 获得本周一0点时间
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-5-14 上午8:58:22 
	 * @返回值: Date    返回类型 
	 * @throws
	 */
	public static Date getTimesWeekmorning(){
		Calendar cal = Calendar.getInstance();
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY),cal.get(Calendar.DAY_OF_MONTH),0,0,0);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return cal.getTime();
	}
	/**
	 * @Title: getTimesWeeknight 
	 * @描述: 获得本周日24点时间
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-5-14 上午9:21:30 
	 * @返回值: Date    返回类型 
	 * @throws
	 */
	public static Date getTimesWeeknight(){
		Calendar cal = Calendar.getInstance();
		cal.setTime(getTimesWeekmorning());
		cal.add(Calendar.DAY_OF_WEEK, 7);
		return cal.getTime();
	}
	/**
	 * @Title: getTimesMonthmorning 
	 * @描述: 获得本月第一天0点时间 
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-5-14 上午9:23:59 
	 * @返回值: Date    返回类型 
	 * @throws
	 */
	public static Date getTimesMonthmorning(){
		Calendar cal = Calendar.getInstance();
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY),cal.get(Calendar.DAY_OF_MONTH),0,0,0);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
		return cal.getTime();
	}
	/**
	 * @Title: getTimesMonthnight 
	 * @描述: 获得本月最后一天24点时间 
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-5-14 上午10:14:03 
	 * @返回值: Date    返回类型 
	 * @throws
	 */
	public static Date getTimesMonthnight(){
		Calendar cal = Calendar.getInstance();
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY),cal.get(Calendar.DAY_OF_MONTH),0,0,0);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		cal.set(Calendar.HOUR_OF_DAY, 24);
		return cal.getTime();
	}
	/**
	 * @Title: getTimesQuartermorning 
	 * @描述: 获得季度初
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-5-14 上午10:19:14 
	 * @返回值: Date    返回类型 
	 * @throws
	 */
	public static Date getTimesQuartermorning(){
		Calendar cal = Calendar.getInstance();
		int month = cal.get(Calendar.MONTH);
		if(month>=Calendar.JANUARY && month<=Calendar.MARCH){
			cal.set(Calendar.MONTH, Calendar.JANUARY);
		}
		if(month>=Calendar.APRIL && month<=Calendar.JUNE){
			cal.set(Calendar.MONTH, Calendar.APRIL);
		}
		if(month>=Calendar.JUNE && month<=Calendar.AUGUST){
			cal.set(Calendar.MONTH, Calendar.JULY);
		}
		if(month>=Calendar.OCTOBER && month<=Calendar.DECEMBER){
			cal.set(Calendar.MONTH, Calendar.OCTOBER);
		}
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY),cal.get(Calendar.DAY_OF_MONTH),0,0,0);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
		return cal.getTime();
	}
	/**
	 * @Title: getTimesQuarternight 
	 * @描述: 获得季度末
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-5-14 上午10:47:41 
	 * @返回值: Date    返回类型 
	 * @throws
	 */
	public static Date getTimesQuarternight(){
		Calendar cal = Calendar.getInstance();
		int month = cal.get(Calendar.MONTH);
		if(month>=Calendar.JANUARY && month<=Calendar.MARCH){
			cal.set(Calendar.MONTH, Calendar.MARCH);
		}
		if(month>=Calendar.APRIL && month<=Calendar.JUNE){
			cal.set(Calendar.MONTH, Calendar.JUNE);
		}
		if(month>=Calendar.JUNE && month<=Calendar.AUGUST){
			cal.set(Calendar.MONTH, Calendar.AUGUST);
		}
		if(month>=Calendar.OCTOBER && month<=Calendar.DECEMBER){
			cal.set(Calendar.MONTH, Calendar.DECEMBER);
		}
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY),cal.get(Calendar.DAY_OF_MONTH),0,0,0);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		return cal.getTime();
	}
	/**
	 * @Title: getTimesYearmorning 
	 * @描述: 获得本年第一天
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-5-14 下午2:19:30 
	 * @返回值: Date    返回类型 
	 * @throws
	 */
	public static Date getTimesYearmorning(){
		Calendar cal = Calendar.getInstance();
		int currenYear = cal.get(Calendar.YEAR);
		return getCurrYearFirst(currenYear);
	}
	/**
	 * @Title: getCurrYearFirst 
	 * @描述: 计算本年第一天
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-5-14 下午2:28:53 
	 * @返回值: Date    返回类型 
	 * @throws
	 */
	public static Date getCurrYearFirst(int year){
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(Calendar.YEAR, year);
		return cal.getTime();
	}
	/**
	 * @Title: getTimesYearnight 
	 * @描述: 获得本年最后一天
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-5-14 下午2:19:09 
	 * @返回值: Date    返回类型 
	 * @throws
	 */
	public static Date getTimesYearnight(){
		Calendar cal = Calendar.getInstance();
		int currenYear = cal.get(Calendar.YEAR);
		return getCurrYearLast(currenYear);
	}
	/**
	 * @Title: getCurrYearLast 
	 * @描述: 计算本年最后一天
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-5-14 下午2:28:27 
	 * @返回值: Date    返回类型 
	 * @throws
	 */
	public static Date getCurrYearLast(int year){
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(Calendar.YEAR, year);
		cal.roll(Calendar.DAY_OF_YEAR, -1);
		return cal.getTime();
	}
}