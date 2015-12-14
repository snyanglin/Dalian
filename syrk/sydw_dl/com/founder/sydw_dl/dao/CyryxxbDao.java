package com.founder.sydw_dl.dao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.sydw_dl.bean.Cyryxxb;

@Repository("cyryxxbDao")
public class CyryxxbDao extends BaseDaoImpl {
	
	public Cyryxxb queryById(String id) {
		Cyryxxb returnValue = null;
		List<?> list = queryForList("Cyryxxb.queryById", id);
		if (list != null && list.size() > 0) {
			returnValue = (Cyryxxb) list.get(0);
		}
		return returnValue;
	}
	
	public void insert(Cyryxxb entity) {
		super.insert("Cyryxxb.insert", entity);
	}
	
	public void update(Cyryxxb entity) {
		super.update("Cyryxxb.update", entity);
	}
	
	public Cyryxxb queryByZjlx(Cyryxxb entity) {
		Cyryxxb returnValue = null;
		List<?> list = queryForList("Cyryxxb.queryByZjlx", entity);
		if (list != null && list.size() > 0) {
			returnValue = (Cyryxxb) list.get(0);
		}
		return returnValue;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cyryxxb> cyryxxb_query(Map<String, Object> map) {
		 List<Cyryxxb> list = queryForList("Cyryxxb.cyryxxb_query", map);
		 return list;
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
		page.setTotal((Integer) queryForObject("Cyryxxb.cyryPaginationCount", map));
		page.setRows(queryForList("Cyryxxb.cyryPagination", map));
		return page;
	}

	public void delete(Cyryxxb entity) {
		update("Cyryxxb.delete", entity);
	}
	
	public void deleteByRyidAndDwid(Cyryxxb entity) {
		update("Cyryxxb.deleteByRyidAndDwid", entity);
	}
	
	@SuppressWarnings("unchecked")
	public List<Cyryxxb> cyryxxb_query_new(String dwid) {
		 List<Cyryxxb> list = queryForList("Cyryxxb.cyryxxb_query_new", dwid);
		 return list;
	}
	
	public List<Cyryxxb> queryByDwid(String dwid) {
		 List<Cyryxxb> list = queryForList("Cyryxxb.queryByDwid", dwid);
		 return list;
	}
	public EasyUIPage cyryxxb_query_all(EasyUIPage page, String condition, String dwid) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		if(!StringUtils.isBlank(condition)){
			map.put("condition", condition);
		}
		map.put("dwid", dwid);
		// 后期修改增加延时加载
		List<?> list = queryForList("Cyryxxb.cyryxxb_query_all", map);
//		if (page.getBegin() == 0) {
//			if (list != null && list.size() > 0) {
//				page.setTotal(list.size());
//			} else {
//				page.setTotal(0);
//			}
//		} else {
//			if (page.getTotal() == 0) {
//				if (list != null && list.size() > 0) {
//					page.setTotal(list.size());
//				}
//			}
//		}
		page.setTotal((int)cyryxxb_query_all_count(condition, dwid));
		page.setRows(list);
		return page;
	}
	
	public long cyryxxb_query_all_count(String condition, String dwid){
		Map<String, Object> map = new HashMap<String, Object>();
		if(!StringUtils.isBlank(condition)){
			map.put("condition", condition);
		}
		map.put("dwid", dwid);
		return (Integer) queryForObject("Cyryxxb.cyryxxb_query_all_count", map);
	}
	
	@SuppressWarnings("unchecked")
	public List<Map<String, String>> cyryxxb_query_all_export(String dwid) {
		 List<Map<String, String>> list = queryForList("Cyryxxb.cyryxxb_query_all_export", dwid);
		 return list;
	}
	
	
	/**
	 * 根据人员ID 和 住址DM 取重点人员类别与所属类别表的ID
	 * 
	 * @param ryid
	 * @param jzdzdm
	 * @return
	 */
	public Map<String, String> queryZdrylb(String ryid, String jzdzdm) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("ryid", ryid);
		map.put("jzdzdm", jzdzdm);
		List list = queryForList("Cyryxxb.queryZdrylb", map);
		if (null != list && list.size() > 0) {
			map = (Map) list.get(0);
		}
		return map;
	}
	
	/**
	 * 根据人员ID 和 住址DM 取人员类别与所属类别表的ID
	 * 
	 * @param ryid
	 * @param jzdzdm
	 * @return
	 */
	public Map<String, String> queryRylb(String ryid, String jzdzdm) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("ryid", ryid);
		map.put("jzdzdm", jzdzdm);
		List list = queryForList("Cyryxxb.queryRylb", map);
		if (null != list && list.size() > 0) {
			map = (Map) list.get(0);
		}
		return map;
	}
}
