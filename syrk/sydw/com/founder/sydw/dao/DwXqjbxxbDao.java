package com.founder.sydw.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.sydw.bean.Dwjbxxb;
import com.founder.sydw.bean.Dwxqxxb;

@Repository("dwXqjbxxbdao")
public class DwXqjbxxbDao extends BaseDaoImpl{
	
	public EasyUIPage queryDwXq(EasyUIPage page, Dwxqxxb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			order = "asc";
		}
		map.put("sort", StringUtils.nullToStr(sort));
		map.put("order", StringUtils.nullToStr(order));
		map.put("dwxqxxb", entity);
		List<?> list = queryForList("dwxqquery.queryDwxq", map);
		if (page.getBegin() == 0) {
			if (list != null && list.size() > 0) {
				page.setTotal(list.size());
			} else {
				page.setTotal(0);
			}
		} else {
			if (page.getTotal() == 0) {
				if (list != null && list.size() > 0) {
					page.setTotal(list.size());
				}
			}
		}
		page.setRows(list);
		return page;
	}
	
	public long queryCountDwXq(Dwxqxxb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("dwxqxxb", entity);
		Integer count = (Integer) queryForObject("dwxqquery.queryDwxqCount",map);
		return count.longValue();
	}
	
	public Dwxqxxb queryEntityById(String id) {
		Dwxqxxb returnValue = null;
		List<?> list = queryForList("dwxqquery.dwxqqueryById", id);
		if (list != null && list.size() > 0) {
			returnValue = (Dwxqxxb) list.get(0);
		}
		return returnValue;
	}
	
	public void dwxqsave(Dwxqxxb entity) {
		super.insert("dwxqquery.dwxqxxinsert", entity);
	}
	
	public void dwxqupdate(Dwxqxxb entity) {
		super.update("dwxqquery.dwxqxxupdate", entity);
	}
	
	public int dwxqzx(Dwxqxxb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("dwxqxxb", entity);
		return update("dwxqquery.updateXqById", map);
	}
}
