package com.founder.zafffwqz.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.zafffwqz.bean.Qtcwb;


@Repository("qtcwbDao")
public class QtcwbDao extends BaseDaoImpl {
	
	public Qtcwb queryQtcwb(Qtcwb entity){
		return (Qtcwb) super.queryForObject("Qtcwb.queryQtcwb", entity);
		
	}
	
	public void saveQtcwb(Qtcwb entity){
		super.insert("Qtcwb.insertQtcwb", entity);	
	}
	
	public void updateQtcwb(Qtcwb entity){
		super.update("Qtcwb.updateQtcwb", entity);
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
		page.setTotal((Integer) queryForObject("Qtcwb.queryQtcwbCount", map));
		page.setRows(queryForList("Qtcwb.queryList", map));
		return page;
	}
	public void delete(Qtcwb entity) {
		super.update("Qtcwb.delete", entity);
	}
}
