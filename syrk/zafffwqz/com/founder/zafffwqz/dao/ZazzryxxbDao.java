package com.founder.zafffwqz.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.zafffwqz.bean.Zazzryxxb;

@Repository("zazzryxxbDao")
public class ZazzryxxbDao extends BaseDaoImpl{
	
	public Zazzryxxb queryZazzryxxb(Zazzryxxb entity){
		if (entity.getZjhm()!=null && entity.getCyzjdm()!=null) {
			return (Zazzryxxb) super.queryForObject("Zazzryxxb.getZazzryxxb", entity);
		}else{
		return (Zazzryxxb) super.queryForObject("Zazzryxxb.queryZazzryxxb", entity);}
	} 
	
	public void saveZazzryxxb(Zazzryxxb entity){
		super.insert("Zazzryxxb.insertZazzryxxb", entity);
	}
	
	public void updateZazzryxxb(Zazzryxxb entity){
		super.update("Zazzryxxb.updateZazzryxxb", entity);
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
		page.setTotal((Integer) queryForObject("Zazzryxxb.queryZazzryxxbCount", map));
		page.setRows(queryForList("Zazzryxxb.queryList", map));
		return page;
	}
	
	public void deleteZazzryxxb(Zazzryxxb entity) {
		super.update("Zazzryxxb.deleteZazzryxxb", entity);
	}
}
