package com.founder.service.activitytrace.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.StringUtils;
import com.founder.service.activitytrace.bean.RkRyhdgjb;

@Repository("rkRyhdgjbDao")
public class RkRyhdgjbDao extends BaseDaoImpl {

	/**
	 * 查询人员轨迹（返回最新10条数据）<br>
	 * 
	 * @return
	 */
	public List<RkRyhdgjb> queryRkRyhdgjb(String zjhm) {
		List<RkRyhdgjb> list = null;
		if (!StringUtils.isBlank(zjhm)) {
			list = queryForList("activitytrace.queryRkRyhdgjb", zjhm);
		}
		return list;
	}

	/**
	 * 查询人员轨迹（返回所有数据）<br>
	 * 
	 * @return
	 */
	public List<RkRyhdgjb> queryRkRyhdgjbAll(String zjhm) {
		List<RkRyhdgjb> list = null;
		if (!StringUtils.isBlank(zjhm)) {
			list = queryForList("activitytrace.queryRkRyhdgjb", zjhm);
		}
		return list;
	}

}
