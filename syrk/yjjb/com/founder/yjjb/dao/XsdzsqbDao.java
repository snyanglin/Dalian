package com.founder.yjjb.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.yjjb.bean.Xsdzsqb;

/**
 * 线索递转申请表</br>
 * 增删改查等基本操作
 * @author Administrator
 * @since 2014-11-19
 */
@Repository("xsdzsqbDao")
public class XsdzsqbDao extends BaseDaoImpl {

	/**
	 * 查询
	 * @param page
	 * @param entity
	 * @return
	 * @since 2014-11-19
	 */
	public EasyUIPage queryList(EasyUIPage page, Xsdzsqb entity) {
		
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
		map.put("xsdzsqb", entity);
		
		page.setTotal((Integer) queryForObject("xsdzsqb.queryCount", map));
		page.setRows(queryForList("xsdzsqb.queryList", map));
		return page;
	}

	/**
	 * 查询
	 * @param entity
	 * @return
	 * @since 2014-11-19
	 */
	public Xsdzsqb queryList(Xsdzsqb entity){
		
		return (Xsdzsqb)super.queryForObject("xsdzsqb.queryById", entity);
	}
	
	/**
	 * 查询
	 * @param entity
	 * @return
	 * @since 2014-11-19
	 */
	public Xsdzsqb queryById(Xsdzsqb entity){
		
		return (Xsdzsqb)super.queryForObject("xsdzsqb.queryById", entity);
	}
	
	/**
	 * 新增<br>
	 * @param entity
	 * @return
	 * @since 2014-11-19
	 */
	public void save(Xsdzsqb entity, SessionBean sessionBean) {
		
		insert("xsdzsqb.save", entity);
	}
	
	/**
	 * 更新<br>
	 * @param entity
	 * @return
	 * @since 2014-11-19
	 */
	public void update(Xsdzsqb entity, SessionBean sessionBean) {
		
		update("xsdzsqb.update", entity);
	}

	/**
	 * 删除<br>
	 * @param entity
	 * @return
	 * @since 2014-11-19
	 */
	public void delete(Xsdzsqb entity, SessionBean sessionBean) {
		
		update("xsdzsqb.delete", entity);
	}
}
