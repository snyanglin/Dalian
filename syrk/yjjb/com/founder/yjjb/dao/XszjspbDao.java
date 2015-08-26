package com.founder.yjjb.dao;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.yjjb.bean.Xszjspb;

/**
 * 线索征集信息表</br>
 * 增删改查等基本操作
 * @author chenwenlong
 * @since 2014-12-2
 */
@Repository("xszjspbDao")
public class XszjspbDao extends BaseDaoImpl  {
	/**
	 * 查询
	 * @param page
	 * @param entity
	 * @return
	 * @since 2014-12-3
	 */
	public EasyUIPage queryList(EasyUIPage page, Xszjspb entity) {
		
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
		map.put("xszjspb", entity);
		
		page.setTotal((Integer) queryForObject("xszjspb.queryCount", map));
		page.setRows(queryForList("xszjspb.queryList", map));
		return page;
	}

	/**
	 * 查询
	 * @param entity
	 * @return
	 * @since 2014-12-3
	 */
	public Xszjspb queryList(Xszjspb entity){
		
		return (Xszjspb)super.queryForObject("xszjspb.queryById", entity);
	}
	
	/**
	 * 查询
	 * @param entity
	 * @return
	 * @since 2014-12-3
	 */
	public Xszjspb queryById(Xszjspb entity){
		
		return (Xszjspb)super.queryForObject("xszjspb.queryById", entity);
	}
	
	/**
	 * 查询
	 * @param entity
	 * @return
	 * @since 2014-12-3
	 */
	public List<Xszjspb> queryBySqbh(Xszjspb entity){
		
		return (List<Xszjspb>)super.queryForList("xszjspb.queryBySqbh", entity);
	}
	
	/**
	 * 同意或拒绝审批--新增审批记录<br>
	 * @param entity
	 * @return
	 * @since 2014-12-4
	 */
	public void save(Xszjspb entity, SessionBean sessionBean) {
		
		insert("xszjspb.save", entity);
	}
	
	/**
	 * 同意或拒绝审批--修改审批记录<br>
	 * @param entity
	 * @return
	 * @since 2014-12-4
	 */
	public void update(Xszjspb entity, SessionBean sessionBean) {
		
		update("xszjspb.update", entity);
	}
	
}
