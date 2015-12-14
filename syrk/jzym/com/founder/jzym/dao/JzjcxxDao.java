package com.founder.jzym.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.xjpt.vo.ZzjgVo;
import com.founder.jzym.bean.Ryjzdzzb;
import com.founder.xjpt.bean.Zdryjbxxb;

@Repository("jzjcxxDao")
public class JzjcxxDao extends BaseDaoImpl {

	/**
	 * @Title: queryJcxx
	 * @描述: 查询基础信息
	 * @参数: 传入参数定义
	 * @日期： 2014-10-25 下午4:45:50
	 * @返回值: List<ZzjgVo> 返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<ZzjgVo> queryJcxx(Map<String, Object> params) {
		return queryForList("Jzjcxx.queryJcxx", params);
	}

	/**
	 * @Title: querySyrkList
	 * @描述: 查询基础信息
	 * @参数: 传入参数定义
	 * @日期： 2014-10-25 下午4:45:50
	 * @返回值: EasyUIPage 返回类型
	 * @throws
	 */
	public EasyUIPage querySyrkList(EasyUIPage page, Ryjzdzzb entity, Long count) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "orgcode,userid";
			order = "asc";
		}
		if ("orgname".equals(sort)) {
			sort = "orgcode";
		}
		map.put("sort", sort);
		map.put("order", order);
		entity.setXm(StringUtils.getSqlExpression(entity.getXm()));
		entity.setZjhm(StringUtils.getSqlExpression(entity.getZjhm()));
		entity.setDz_jzdzxz(StringUtils.getSqlExpression(entity.getDz_jzdzxz()));
		map.put("ryjzdzzb", entity);
		page.setTotal((Integer) count.intValue());
		page.setRows(queryForList("Jzjcxx.querySyrkList", map));
		return page;
	}

	/**
	 * @Title: queryZdryList
	 * @描述: 查询基础信息
	 * @参数: 传入参数定义
	 * @日期： 2014-10-25 下午4:45:50
	 * @返回值: EasyUIPage 返回类型
	 * @throws
	 */
	public EasyUIPage queryZdryList(EasyUIPage page, Zdryjbxxb entity, Long count) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "orgcode,userid";
			order = "asc";
		}
		if ("orgname".equals(sort)) {
			sort = "orgcode";
		}
		map.put("sort", sort);
		map.put("order", order);
		entity.setXm(StringUtils.getSqlExpression(entity.getXm()));
		entity.setGmsfhm(StringUtils.getSqlExpression(entity.getGmsfhm()));
		entity.setDz_jzdzxz(StringUtils.getSqlExpression(entity.getDz_jzdzxz()));
		map.put("zdryjbxxb", entity);
		page.setTotal((Integer) count.intValue());
		page.setRows(queryForList("Jzjcxx.queryZdryList", map));
		return page;
	}
	
}