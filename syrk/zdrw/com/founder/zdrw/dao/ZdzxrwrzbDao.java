package com.founder.zdrw.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.zdrw.bean.Zdzxrwrzb;

@Repository("zdzxrwrzbDao")
public class ZdzxrwrzbDao extends BaseDaoImpl{
	public EasyUIPage queryList(EasyUIPage page, Zdzxrwrzb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "xt_lrsj";
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("zdzxrwb", entity);
		page.setTotal((Integer) queryForObject("zdzxrwrzb.queryCount", map));
		page.setRows(queryForList("zdzxrwrzb.queryList", map));
		return page;
	}
}
