package com.founder.zafffwqz.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.zafffwqz.bean.Dsrxxzb;

@Repository("dsrxxzbDao")
public class DsrxxzbDao extends BaseDaoImpl {
	

	public Dsrxxzb queryDsrxxzb(Dsrxxzb entity){
		return (Dsrxxzb) super.queryForObject("Dsrxxzb.queryDsrxxzb", entity);
		
	}
	
	public void saveDsrxxzb(Dsrxxzb entity){
		super.insert("Dsrxxzb.insertDsrxxzb", entity);	
	}
	
	public void updateDsrxxzb(Dsrxxzb entity){
		super.update("Dsrxxzb.updateDsrxxzb", entity);
	}
	
	
	public void delete(Dsrxxzb entity) {
		super.update("Dsrxxzb.delete", entity);
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
		page.setTotal((Integer) queryForObject("Dsrxxzb.queryDsrxxzbCount", map));
		page.setRows(queryForList("Dsrxxzb.queryList", map));
		return page;
	}
}
