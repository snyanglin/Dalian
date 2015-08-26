package com.founder.service.activitytrace.service;

import java.util.List;

import com.founder.framework.annotation.TypeAnnotation;
import com.founder.service.activitytrace.bean.RkRyhdgjb;

@TypeAnnotation("查询人员轨迹")
public interface RkRyhdgjbService {

	/**
	 * 查询人员轨迹（返回最新10条数据）<br>
	 * 
	 * @return
	 */
	public List<RkRyhdgjb> queryRkRyhdgjb(String zjhm);

	/**
	 * 查询人员轨迹（返回所有数据）<br>
	 * 
	 * @return
	 */
	public List<RkRyhdgjb> queryRkRyhdgjbAll(String zjhm);

}
