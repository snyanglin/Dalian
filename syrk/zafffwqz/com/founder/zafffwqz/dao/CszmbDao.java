package com.founder.zafffwqz.dao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.zafffwqz.bean.Cszmb;

@Repository("cszmbDao")
public class CszmbDao extends BaseDaoImpl {
	
	public Cszmb queryCszmb(Cszmb entity){
		return (Cszmb) super.queryForObject("Cszmb.queryCszmb", entity);
		
	}
	
	public void saveCszmb(Cszmb entity){
		super.insert("Cszmb.insertCszmb", entity);
		
	}
	public void updateCszmb(Cszmb entity){
		super.update("Cszmb.updateCszmb", entity);
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
		page.setTotal((Integer) queryForObject("Cszmb.queryCszmbCount", map));
		page.setRows(queryForList("Cszmb.queryList", map));
		return page;
	}
	public void delete(Cszmb entity) {
		super.update("Cszmb.delete", entity);
	}
	
	public List<Cszmb> queryRyCs(String zjhm) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("zjhm", zjhm);
		return queryForList("Cszmb.queryRyCszmbByZjhm", map);
	}
}
