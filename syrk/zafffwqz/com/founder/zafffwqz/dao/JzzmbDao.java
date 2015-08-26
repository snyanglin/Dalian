package com.founder.zafffwqz.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.zafffwqz.bean.Jzzmb;

@Repository("jzzmbDao")
public class JzzmbDao extends BaseDaoImpl {
	
	public Jzzmb queryJzzmb(Jzzmb entity){
		return (Jzzmb) super.queryForObject("Jzzmb.queryJzzmb", entity);
		
	}
	
	public void saveJzzmb(Jzzmb entity){
		super.insert("Jzzmb.insertJzzmb", entity);	
	}
	
	public void updateJzzmb(Jzzmb entity){
		super.update("Jzzmb.updateJzzmb", entity);
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
		page.setTotal((Integer) queryForObject("Jzzmb.queryJzzmbCount", map));
		page.setRows(queryForList("Jzzmb.queryList", map));
		return page;
	}
	public void delete(Jzzmb entity) {
		super.update("Jzzmb.delete", entity);
	}
}
