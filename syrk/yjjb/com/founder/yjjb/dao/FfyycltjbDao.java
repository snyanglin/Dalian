package com.founder.yjjb.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.yjjb.bean.Ffyycltjb;

/**
 * 非法营运车辆统计表</br>
 * 增删改查等基本操作
 * @author Administrator
 * @since 2014-12-19
 */
@Repository("ffyycltjbDao")
public class FfyycltjbDao extends BaseDaoImpl {

	/**
	 * 查询
	 * @param page
	 * @param entity
	 * @return
	 * @since 2014-12-19
	 */
	public EasyUIPage queryList(EasyUIPage page, Ffyycltjb entity) {
		
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
		map.put("ffyycltjb", entity);
		
		page.setTotal((Integer) queryForObject("ffyycltjb.queryCount", map));
		page.setRows(queryForList("ffyycltjb.queryList", map));
		return page;
	}

	/**
	 * 查询
	 * @param entity
	 * @return
	 * @since 2014-12-19
	 */
	public Ffyycltjb queryList(Ffyycltjb entity){
		
		return (Ffyycltjb)super.queryForObject("ffyycltjb.queryById", entity);
	}
	
	/**
	 * 查询
	 * @param entity
	 * @return
	 * @since 2014-12-19
	 */
	public Ffyycltjb queryById(Ffyycltjb entity){
		
		return (Ffyycltjb)super.queryForObject("ffyycltjb.queryById", entity);
	}
	
	/**
	 * 新增<br>
	 * @param entity
	 * @return
	 * @since 2014-12-19
	 */
	public void save(Ffyycltjb entity, SessionBean sessionBean) {
		
		insert("ffyycltjb.save", entity);
	}
	
	/**
	 * 更新<br>
	 * @param entity
	 * @return
	 * @since 2014-12-19
	 */
	public void update(Ffyycltjb entity, SessionBean sessionBean) {
		
		update("ffyycltjb.update", entity);
	}

	/**
	 * 删除<br>
	 * @param entity
	 * @return
	 * @since 2014-12-19
	 */
	public void delete(Ffyycltjb entity, SessionBean sessionBean) {
		
		update("ffyycltjb.delete", entity);
	}
}
