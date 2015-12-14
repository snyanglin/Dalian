package com.founder.yjjb.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.ComboBox;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.yjjb.bean.Xszjxxb;

/**
 * 线索征集信息表</br>
 * 增删改查等基本操作
 * @author chenwenlong
 * @since 2014-11-27
 */
@Repository("xszjxxbDao")
public class XszjxxbDao extends BaseDaoImpl  {
	/**
	 * 查询
	 * @param page
	 * @param entity
	 * @return
	 * @since 2014-11-27
	 */
	public EasyUIPage queryList(EasyUIPage page, Xszjxxb entity) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder(); 
		if (!"YJJB_XSZJXXB.xt_lrsj".equals(sort.trim())) { // 默认排序
			
			sort = "YJJB_XSZJXXB.xt_lrsj";
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("xszjxxb", entity);
		page.setTotal((Integer) queryForObject("xszjxxb.queryCount", map));
		page.setRows(queryForList("xszjxxb.queryList", map));
		return page;
	}

	/**
	 * 查询
	 * @param entity
	 * @return
	 * @since 2014-11-27
	 */
	public Xszjxxb queryList(Xszjxxb entity){
		return (Xszjxxb)super.queryForObject("xszjxxb.queryById", entity);
	}
	
	/**
	 * 查询
	 * @param entity
	 * @return
	 * @since 2014-11-27
	 */
	public Xszjxxb queryById(Xszjxxb entity){
		
		return (Xszjxxb)super.queryForObject("xszjxxb.queryById", entity);
	}
	
	/**
	 * 新增<br>
	 * @param entity
	 * @return
	 * @since 2014-11-28
	 */
	public void save(Xszjxxb entity, SessionBean sessionBean) {
		
		insert("xszjxxb.save", entity);
	}
	
	/**
	 * 设置线索征集信息被同意或拒绝<br>
	 * @param entity
	 * @return
	 * @since 2014-11-28
	 */
	public void update(Xszjxxb entity, SessionBean sessionBean) {
		
		update("xszjxxb.update", entity);
	}
}
