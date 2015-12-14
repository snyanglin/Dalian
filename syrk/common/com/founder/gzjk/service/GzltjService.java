package com.founder.gzjk.service;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;

import com.founder.gzjk.bean.Gzltjb;

public interface GzltjService {

	
	/**
	 * 查询工作量统计数据
	 * @param map
	 * @return
	 */
	public List<Gzltjb>  queryGzltj(Map<String,String> map);
	
	/**
	 * 补充工作量统计数据
	 * @param startDate
	 * @param endDate
	 */
	public void bcgzltjsj(String startDate, String endDate);
	
	
	/**
	 * 补充某个责任区的工作量统计
	 * @Title: bcgzltjsjByZrq
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param startDate
	 * @param @param endDate
	 * @param @param zrqCode    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void bcgzltjsjByZrq(String startDate, String endDate,String zrqCode);
	
	public void exportGzltjb(String level, List<Gzltjb>  list, ServletOutputStream outputStream);
}
