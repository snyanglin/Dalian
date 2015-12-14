package com.founder.zafffwqz.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.zafffwqz.bean.Kthb;
import com.founder.zafffwqz.bean.Slzxqzb;
import com.founder.zafffwqz.bean.Tsqtghb;
import com.founder.zafffwqz.bean.Zaffxcb;
@Repository("fwqzDao")
public class FwqzDao extends BaseDaoImpl {

	/**
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	public EasyUIPage querySlzxqz(EasyUIPage page, Slzxqzb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
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
		map.put("slzxqz", entity);
		page.setTotal((Integer) queryForObject("fwqz.queryCountSlzxqz", map));
		page.setRows(queryForList("fwqz.querySlzxqz", map));
		return page;
	}
	
	public EasyUIPage queryKthb(EasyUIPage page, Kthb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
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
		map.put("kthb", entity);
		page.setTotal((Integer) queryForObject("fwqz.queryCountKthb", map));
		page.setRows(queryForList("fwqz.queryKthb", map));
		return page;
	}
	
	public EasyUIPage queryZaffxcb(EasyUIPage page, Zaffxcb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
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
		map.put("zaffxcb", entity);
		page.setTotal((Integer) queryForObject("fwqz.queryCountZaffxcb", map));
		page.setRows(queryForList("fwqz.queryZaffxcb", map));
		return page;
	}	
	
	public EasyUIPage queryTsqtghb(EasyUIPage page, Tsqtghb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
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
		map.put("tsqtghb", entity);
		page.setTotal((Integer) queryForObject("fwqz.queryCountTsqtghb", map));
		page.setRows(queryForList("fwqz.queryTsqtghb", map));
		return page;
	}	
	
	public void saveSlzxqzb(Slzxqzb entity){
		super.insert("fwqz.saveSlzxqz", entity);	
	}
	public void updateSlzxqzb(Slzxqzb entity){
		update("fwqz.updateSlzxqz", entity);
	}
	public void deleteSlzxqzb(Slzxqzb entity) {
		update("fwqz.deleteSlzxqz", entity);
	}
	public Slzxqzb querySlzxqzbById(Slzxqzb entity) {
		return (Slzxqzb) super.queryForObject("fwqz.querySlzxqzById", entity);
	}
	
	
	public void saveKthb(Kthb entity){
		super.insert("fwqz.saveKthb", entity);	
	}
	public void updateKthb(Kthb entity){
		update("fwqz.updateKthb", entity);
	}
	public void deleteKthb(Kthb entity) {
		update("fwqz.deleteKthb", entity);
	}
	public Kthb queryKthbById(Kthb entity) {
		return (Kthb) super.queryForObject("fwqz.queryKthbById", entity);
	}
	
	
	public void saveZaffxcb(Zaffxcb entity){
		super.insert("fwqz.saveZaffxcb", entity);	
	}
	public void updateZaffxcb(Zaffxcb entity){
		update("fwqz.updateZaffxcb", entity);
	}
	public void deleteZaffxcb(Zaffxcb entity) {
		update("fwqz.deleteZaffxcb", entity);
	}
	public Zaffxcb queryZaffxcbById(Zaffxcb entity) {
		return (Zaffxcb) super.queryForObject("fwqz.queryZaffxcbById", entity);
	}
	
	
	public void saveTsqtghb(Tsqtghb entity){
		super.insert("fwqz.saveTsqtghb", entity);	
	}
	public void updateTsqtghb(Tsqtghb entity){
		update("fwqz.updateTsqtghb", entity);
	}
	public void deleteTsqtghb(Tsqtghb entity) {
		update("fwqz.deleteTsqtghb", entity);
	}
	public Tsqtghb queryTsqtghbById(Tsqtghb entity) {
		return (Tsqtghb) super.queryForObject("fwqz.queryTsqtghbById", entity);
	}
}
