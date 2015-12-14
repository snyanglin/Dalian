package com.founder.zafffwqz.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.zafffwqz.bean.Kgzmb;

@Repository("kgzmbDao")
public class KgzmbDao extends BaseDaoImpl {
	public Kgzmb queryKgzmb(Kgzmb entity){
		return (Kgzmb) super.queryForObject("Kgzmb.queryKgzmb", entity);
		
	}
	
	public void saveKgzmb(Kgzmb entity){
		super.insert("Kgzmb.insertKgzmb", entity);	
	}
	
	public void updateKgzmb(Kgzmb entity){
		super.update("Kgzmb.updateKgzmb", entity);
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
		page.setTotal((Integer) queryForObject("Kgzmb.queryKgzmbCount", map));
		page.setRows(queryForList("Kgzmb.queryList", map));
		return page;
	}
	public void delete(Kgzmb entity) {
		super.update("Kgzmb.delete", entity);
	}
}
