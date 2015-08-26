package com.founder.zdrw.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.zdrw.bean.Zdzxrwb;

@Repository("zdzxrwbDao")
public class ZdzxrwbDao extends BaseDaoImpl{
	
	/**
	 * 查询
	 * @param page
	 * @param entity
	 * @return
	 */
	public EasyUIPage queryList(EasyUIPage page, Zdzxrwb entity) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "xt_lrsj";
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("zdzxrwb", entity);
		
		page.setTotal((Integer) queryForObject("zdzxrwb.queryCount", map));
		page.setRows(queryForList("zdzxrwb.queryList", map));
		return page;
	}
	
	public Zdzxrwb queryZdzxrwbById(Zdzxrwb entity) {
		return (Zdzxrwb) super.queryForObject("zdzxrwb.queryList", entity);
	}
	
	/**
	 * 增加
	 * 
	 * @param entity
	 */
	public void insertZdzxrwb(Zdzxrwb entity) {
		super.insertForObject("zdzxrwb.save", entity);
	}
	
	/**
	 * 更新
	 * @param entity
	 * @return
	 */
	public int updateZdzxrwb(Zdzxrwb entity) {
		return super.update("zdzxrwb.update", entity);
	}
	
	/**
	 * 注销
	 * @param entity
	 * @return
	 */
	public int deleteZdzxrwb(Zdzxrwb entity) {
		return super.update("zdzxrwb.delete", entity);
	}
}
