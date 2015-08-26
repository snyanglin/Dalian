package com.founder.zafffwqz.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.zafffwqz.bean.Gzjzqkzb;

@Repository("gzjzqkzbDao")
public class GzjzqkzbDao extends BaseDaoImpl {
	
	public Gzjzqkzb queryGzjzqkzb(Gzjzqkzb entity){
		return (Gzjzqkzb) super.queryForObject("Gzjzqkzb.queryGzjzqkzb", entity);
		
	}
	
	public void saveGzjzqkzb(Gzjzqkzb entity){
		super.insert("Gzjzqkzb.insertGzjzqkzb", entity);	
	}
	
	public void updateGzjzqkzb(Gzjzqkzb entity){
		super.update("Gzjzqkzb.updateGzjzqkzb", entity);
	}
	
	
	public void delete(Gzjzqkzb entity) {
		super.update("Gzjzqkzb.delete", entity);
	}
	public EasyUIPage queryList(EasyUIPage page, Map map){
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "id";
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		page.setTotal((Integer) queryForObject("Gzjzqkzb.queryGzjzqkzbCount", map));
		page.setRows(queryForList("Gzjzqkzb.queryList", map));
		return page;
	}
}
