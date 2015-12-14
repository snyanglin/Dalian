package com.founder.yjjb.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.yjjb.bean.Jbjlxxb;

/**
 * 线索征集信息表</br>
 * 增删改查等基本操作
 * @author chenwenlong
 * @since 2014-11-27
 */
@Repository("jbjlxxbDao")
public class JbjlxxbDao extends BaseDaoImpl  {
	/**
	 * 查询
	 * @param page
	 * @param entity
	 * @return
	 * @since 2014-11-27
	 */
	public EasyUIPage queryList(EasyUIPage page, Jbjlxxb entity) {
		
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
		map.put("jbjlxxb", entity);
		
		page.setTotal((Integer) queryForObject("jbjlxxb.queryCount", map));
		page.setRows(queryForList("jbjlxxb.queryList", map));
		return page;
	}

	/**
	 * 查询
	 * @param entity
	 * @return
	 * @since 2014-11-27
	 */
	public Jbjlxxb queryList(Jbjlxxb entity){
		
		return (Jbjlxxb)super.queryForObject("jbjlxxb.queryById", entity);
	}
	
	/**
	 * 查询
	 * @param entity
	 * @return
	 * @since 2014-11-27
	 */
	public Jbjlxxb queryById(Jbjlxxb entity){
		
		return (Jbjlxxb)super.queryForObject("jbjlxxb.queryById", entity);
	}
	
	/**
	 * 新增<br>
	 * @param entity
	 * @return
	 * @since 2014-11-28
	 */
	public void save(Jbjlxxb entity, SessionBean sessionBean) {
		
		insert("jbjlxxb.save", entity);
	}
	
	/**
	 * 删除<br>
	 * @param entity
	 * @return
	 * @since 2014-11-28
	 */
	public void delete(Jbjlxxb entity, SessionBean sessionBean) {
		
		update("jbjlxxb.delete", entity);
	}
	
	/**
	 * 更新<br>
	 * @param entity
	 * @return
	 * @since 2014-11-17
	 */
	public void update(Jbjlxxb entity, SessionBean sessionBean) {
		
		update("jbjlxxb.update", entity);
	}

	/**
	 * @Title: queryId
	 * @Description: 根据案件编号和线索id查询
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Jbjlxxb    返回类型
	 * @throws
	 */
	public Jbjlxxb queryId(Jbjlxxb entity) {
		return (Jbjlxxb)super.queryForObject("jbjlxxb.queryId", entity);
	}

	/**
	 * @Title: queryByXsbhAjbh
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return List<Jbjlxxb>    返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<Jbjlxxb> queryByXsbhAjbh(Jbjlxxb entity) {
		return queryForList("jbjlxxb.queryByXsbhAjbh", entity);
	}
}
