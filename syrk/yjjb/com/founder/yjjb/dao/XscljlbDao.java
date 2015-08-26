package com.founder.yjjb.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.yjjb.bean.Xscljlb;

/**
 * 线索基本信息表</br>
 * 增删改查等基本操作
 * @author Administrator
 * @since 2014-11-17
 */
@Repository("xscljlbDao")
public class XscljlbDao extends BaseDaoImpl {

	/**
	 * 查询
	 * @param page
	 * @param entity
	 * @return
	 * @since 2014-11-17
	 */
	public EasyUIPage queryList(EasyUIPage page, Xscljlb entity) {
		
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
		map.put("xscljlb", entity);
		
		page.setTotal((Integer) queryForObject("xscljlb.queryCount", map));
		page.setRows(queryForList("xscljlb.queryList", map));
		return page;
	}

	/**
	 * 查询
	 * @param entity
	 * @return
	 * @since 2014-11-17
	 */
	public Xscljlb queryList(Xscljlb entity){
		
		return (Xscljlb)super.queryForObject("xscljlb.queryById", entity);
	}
	
	/**
	 * 查询
	 * @param entity
	 * @return
	 * @since 2014-11-17
	 */
	public Xscljlb queryById(Xscljlb entity){
		
		return (Xscljlb)super.queryForObject("xscljlb.queryById", entity);
	}
	
	/**
	 * 新增<br>
	 * @param entity
	 * @return
	 * @since 2014-11-17
	 */
	public void save(Xscljlb entity, SessionBean sessionBean) {
		
		insert("xscljlb.save", entity);
	}
	
	/**
	 * 更新<br>
	 * @param entity
	 * @return
	 * @since 2014-11-17
	 */
	public void update(Xscljlb entity, SessionBean sessionBean) {
		
		update("xscljlb.update", entity);
	}

	/**
	 * 删除<br>
	 * @param entity
	 * @return
	 * @since 2014-11-17
	 */
	public void delete(Xscljlb entity, SessionBean sessionBean) {
		
		update("xscljlb.delete", entity);
	}

	/**
	 * @Title: queryListByXsbh
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Object    返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<Xscljlb> queryListByXsbh(Xscljlb entity) {
		return queryForList("xscljlb.queryListByXsbh", entity);
	}
	
}
