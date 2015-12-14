package com.founder.yjjb.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.yjjb.bean.Xsdzspb;

/**
 * 线索递转审批表</br>
 * 增删改查等基本操作
 * @author Administrator
 * @since 2014-11-24
 */
@Repository("xsdzspbDao")
public class XsdzspbDao extends BaseDaoImpl {

	/**
	 * 查询
	 * @param page
	 * @param entity
	 * @return
	 * @since 2014-11-19
	 */
	public EasyUIPage queryList(EasyUIPage page, Xsdzspb entity) {
		
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
		map.put("xsdzspb", entity);
		
		page.setTotal((Integer) queryForObject("xsdzspb.queryCount", map));
		page.setRows(queryForList("xsdzspb.queryList", map));
		return page;
	}

	/**
	 * 查询
	 * @param entity
	 * @return
	 * @since 2014-11-19
	 */
	public Xsdzspb queryList(Xsdzspb entity){
		
		return (Xsdzspb)super.queryForObject("xsdzspb.queryById", entity);
	}
	
	/**
	 * 查询
	 * @param entity
	 * @return
	 * @since 2014-11-19
	 */
	public Xsdzspb queryById(Xsdzspb entity){
		
		return (Xsdzspb)super.queryForObject("xsdzspb.queryById", entity);
	}
	
	/**
	 * 新增<br>
	 * @param entity
	 * @return
	 * @since 2014-11-19
	 */
	public void save(Xsdzspb entity, SessionBean sessionBean) {
		
		insert("xsdzspb.save", entity);
	}
	
	/**
	 * 更新<br>
	 * @param entity
	 * @return
	 * @since 2014-11-19
	 */
	public void update(Xsdzspb entity, SessionBean sessionBean) {
		
		update("xsdzspb.update", entity);
	}

	/**
	 * 删除<br>
	 * @param entity
	 * @return
	 * @since 2014-11-19
	 */
	public void delete(Xsdzspb entity, SessionBean sessionBean) {
		
		update("xsdzspb.delete", entity);
	}

	public List<Xsdzspb> queryListByXsId(String xsid) {

		return queryForList("xsdzspb.queryListByXsId", xsid);
	}
}
