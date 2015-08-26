package com.founder.sydw.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.sydw.bean.Frfzrllrb;

@Repository("frfzrllrbDao")
public class FrfzrllrbDao extends BaseDaoImpl {

	public Frfzrllrb queryById(String id) {
		Frfzrllrb returnValue = null;
		List<?> list = queryForList("Frfzrllrb.queryById", id);
		if (list != null && list.size() > 0) {
			returnValue = (Frfzrllrb) list.get(0);
		}
		return returnValue;
	}
	
	public Frfzrllrb queryByDwidAndDwrylx(Frfzrllrb entity) {
		Frfzrllrb returnValue = null;
		List<?> list = queryForList("Frfzrllrb.queryByDwidAndDwrylx", entity);
		if (list != null && list.size() > 0) {
			returnValue = (Frfzrllrb) list.get(0);
		}
		return returnValue;
	}
	
	public void insert(Frfzrllrb entity) {
		super.insert("Frfzrllrb.insert", entity);
	}
	
	public void update(Frfzrllrb entity) {
		super.update("Frfzrllrb.update", entity);
	}
	
	public List<Frfzrllrb> dwfrfzrllyxxb_query(Map<String, Object> map) {
		return queryForList("Frfzrllrb.dwfrfzrllyxxb_query", map);
	}

	public EasyUIPage queryList(EasyUIPage page, String dwid) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		map.put("dwid", dwid);
		String sort = page.getSort();
		String order = page.getOrder();
		if (!StringUtils.isBlank(sort)) { // 默认排序
			map.put("sort", sort);
			map.put("order", order);
		}
		page.setTotal((Integer) queryForObject("Frfzrllrb.lxrPaginationCount", map));
		page.setRows(queryForList("Frfzrllrb.lxrPagination", map));
		return page;
	}

	public void delete(Frfzrllrb entity) {
		super.update("Frfzrllrb.delete", entity);
	}

	public Frfzrllrb queryFrByDwid(String dwid) {
		Frfzrllrb entity = new Frfzrllrb();
		entity.setDwid(dwid);
		entity.setDwrylxdm("20");
		List<Frfzrllrb> list = queryForList("Frfzrllrb.queryByDwidAndDwrylx", entity);
		return (list!=null && !list.isEmpty())?list.get(0):new Frfzrllrb();
	}
	
}
