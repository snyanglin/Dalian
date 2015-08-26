package com.founder.yjjb.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.yjjb.bean.Jlxxb;

/**
 * 奖励信息表</br>
 * 增删改查等基本操作
 * @author dangkp
 * @since 2014-12-04
 */
@Repository("jlxxbDao")
public class JlxxbDao extends BaseDaoImpl  {
	/**
	 * 查询
	 * @param page
	 * @param entity
	 * @return
	 * @since 2014-12-04
	 */
	public EasyUIPage queryList(EasyUIPage page, Jlxxb entity) {
		
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
		map.put("jlxxb", entity);
		
		page.setTotal((Integer) queryForObject("jlxxb.queryCount", map));
		page.setRows(queryForList("jlxxb.queryList", map));
		return page;
	}

	/**
	 * 查询
	 * @param entity
	 * @return
	 * @since 2014-12-04
	 */
	public Jlxxb queryList(Jlxxb entity){
		
		return (Jlxxb)super.queryForObject("jlxxb.queryById", entity);
	}
	
	/**
	 * 查询
	 * @param entity
	 * @return
	 * @since 2014-12-04
	 */
	public Jlxxb queryById(Jlxxb entity){
		
		return (Jlxxb)super.queryForObject("jlxxb.queryById", entity);
	}
	
	/**
	 * 新增<br>
	 * @param entity
	 * @return
	 * @since 2014-12-04
	 */
	public void save(Jlxxb entity, SessionBean sessionBean) {
		
		insert("jlxxb.save", entity);
	}
	
	/**
	 * 删除<br>
	 * @param entity
	 * @return
	 * @since 2014-12-04
	 */
	public void delete(Jlxxb entity, SessionBean sessionBean) {
		
		update("jlxxb.delete", entity);
	}
	
	/**
	 * 更新<br>
	 * @param entity
	 * @return
	 * @since 2014-11-17
	 */
	public void update(Jlxxb entity, SessionBean sessionBean) {
		
		update("jlxxb.update", entity);
	}
}
