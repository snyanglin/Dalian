package com.founder.yjjb.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.yjjb.bean.Ajxxb;

/**
 * 案件信息表</br>
 * 增删改查等基本操作
 * @author Administrator
 * @since 2014-11-17
 */
@Repository("ajxxbDao")
public class AjxxbDao extends BaseDaoImpl {
	
	/**
	 * 查询
	 * @param page
	 * @param entity
	 * @return
	 * @since 2014-11-17
	 */
	public EasyUIPage queryList(EasyUIPage page, Ajxxb entity) {
		
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
		map.put("xsajxxb", entity);
		
		page.setTotal((Integer) queryForObject("xsajxxb.queryCount", map));
		page.setRows(queryForList("xsajxxb.queryList", map));
		return page;
	}

	/**
	 * 查询
	 * @param entity
	 * @return
	 * @since 2014-11-17
	 */
	public Ajxxb queryList(Ajxxb entity){
		
		return (Ajxxb)super.queryForObject("xsajxxb.queryById", entity);
	}

	/**
	 * 查询
	 * @param entity
	 * @return
	 * @since 2014-11-17
	 */
	public Ajxxb queryById(Ajxxb entity){
		
		return (Ajxxb)super.queryForObject("xsajxxb.queryById", entity);
	}
	
	/**
	 * 新增<br>
	 * @param entity
	 * @return
	 * @since 2014-11-17
	 */
	public void save(Ajxxb entity, SessionBean sessionBean) {
		
		insert("xsajxxb.save", entity);
	}
	
	/**
	 * 更新<br>
	 * @param entity
	 * @return
	 * @since 2014-11-17
	 */
	public void update(Ajxxb entity, SessionBean sessionBean) {
		
		update("xsajxxb.update", entity);
	}

	/**
	 * 删除<br>
	 * @param entity
	 * @return
	 * @since 2014-11-17
	 */
	public void delete(Ajxxb entity, SessionBean sessionBean) {
		
		update("xsajxxb.delete", entity);
	}
	
	/**
	 * 查询
	 * @param entity
	 * @return
	 * @since 2014-11-17
	 */
	public Ajxxb queryByAjbh(Ajxxb entity){
		
		return (Ajxxb)super.queryForObject("xsajxxb.queryByAjbh", entity);
	}

	/**
	 * 查询
	 * @param entity
	 * @return
	 * @since 2014-11-17
	 */
	public Ajxxb queryAllAjxxByAjbh(Ajxxb entity){
		
		return (Ajxxb)super.queryForObject("xsajxxb.queryAllAjxxByAjbh", entity);
	}
	
	/**
	 * 通过案件编号查询有多少条该编号的数据，如果未0范围true，否则返回false
	 * @param String
	 * @return boolean
	 * @since 2014-11-17
	 */
	public int ifExistAjNum(String ajbh) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ajbh", ajbh);
		int resultNum = (Integer)super.queryForObject("xsajxxb.ifExistAjNum", map);
		return resultNum;
	}

	/**
	 * @Title: queryByAjbhLjz
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Ajxxb    返回类型
	 * @throws
	 */
	public Ajxxb queryByAjbhLjz(Ajxxb entity) {
		return (Ajxxb)super.queryForObject("xsajxxb.queryByAjbhLjz", entity);
	}
}
