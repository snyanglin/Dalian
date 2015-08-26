package com.founder.syrkgl.dao;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.syrkgl.bean.RyJwryrczfb;
/**
 * @类名: RyJwryrczfbDao 
 * @描述: 境外人员办证信息核实
 * @作者: zhang_guoliang@founder.com 
 * @日期: 2015-6-17 下午2:20:21 
 */
@Repository("ryJwryrczfbDao")
public class RyJwryrczfbDao extends BaseDaoImpl{
	/**
	 * @Title: queryJwryRczf 
	 * @描述: 境外人员核实下发列表
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-6-26 上午9:44:14 
	 * @返回值: EasyUIPage    返回类型 
	 * @throws
	 */
	public EasyUIPage queryJwryRczf(EasyUIPage page,RyJwryrczfb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		map.put("entity", entity);
		page.setRows(queryForList("RyJwryrczfb.queryJwryrczfList", map));
		page.setTotal((Integer) queryForObject("RyJwryrczfb.queryJwryrczfCount", map));
		return page;
	}
	/**
	 * @Title: update 
	 * @描述: 境外人员日常走访更新
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-6-18 下午4:33:27 
	 * @返回值: void    返回类型 
	 * @throws
	 */
	public void update(RyJwryrczfb entity){
		update("RyJwryrczfb.update", entity);
	}
}