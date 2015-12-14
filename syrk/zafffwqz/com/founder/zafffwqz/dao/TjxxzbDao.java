package com.founder.zafffwqz.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.zafffwqz.bean.Tjxxzb;

@Repository("tjxxzbDao")
public class TjxxzbDao extends BaseDaoImpl {
	
	public Tjxxzb queryTjxxzb(Tjxxzb entity){
		return (Tjxxzb) super.queryForObject("Tjxxzb.queryTjxxzb", entity);
		
	}
	
	public void saveTjxxzb(Tjxxzb entity){
		super.insert("Tjxxzb.insertTjxxzb", entity);	
	}
	
	public void updateTjxxzb(Tjxxzb entity){
		super.update("Tjxxzb.updateTjxxzb", entity);
	}
	
	
	public void delete(Tjxxzb entity) {
		super.update("Tjxxzb.delete", entity);
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
		page.setTotal((Integer) queryForObject("Tjxxzb.queryTjxxzbCount", map));
		page.setRows(queryForList("Tjxxzb.queryList", map));
		return page;
	}
}
