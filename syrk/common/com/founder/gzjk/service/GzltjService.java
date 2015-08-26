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
	
	
	public void exportGzltjb(String level, List<Gzltjb>  list, ServletOutputStream outputStream);
}
