package com.founder.yjjb.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.yjjb.bean.Xszcspb;

/**
 * 线索递转审批表</br>
 * 增删改查等基本操作
 * @author Administrator
 * @since 2014-11-24
 */
@Repository("xszcspbDao")
public class XszcspbDao extends BaseDaoImpl {

	/**
	 * 查询
	 * @param page
	 * @param entity
	 * @return
	 * @since 2014-11-19
	 */
	public EasyUIPage queryList(EasyUIPage page, Xszcspb entity) {
		
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
		map.put("xszcspb", entity);
		
		page.setTotal((Integer) queryForObject("xszcspb.queryCount", map));
		page.setRows(queryForList("xszcspb.queryList", map));
		return page;
	}

	/**
	 * 查询
	 * @param entity
	 * @return
	 * @since 2014-11-19
	 */
	public Xszcspb queryList(Xszcspb entity){
		
		return (Xszcspb)super.queryForObject("xszcspb.queryById", entity);
	}
	
	/**
	 * 查询
	 * @param entity
	 * @return
	 * @since 2014-11-19
	 */
	public Xszcspb queryById(Xszcspb entity){
		
		return (Xszcspb)super.queryForObject("xszcspb.queryById", entity);
	}
	
	/**
	 * 新增<br>
	 * @param entity
	 * @return
	 * @since 2014-11-19
	 */
	public void save(Xszcspb entity, SessionBean sessionBean) {
		
		insert("xszcspb.save", entity);
	}
	
	/**
	 * 更新<br>
	 * @param entity
	 * @return
	 * @since 2014-11-19
	 */
	public void update(Xszcspb entity, SessionBean sessionBean) {
		
		update("xszcspb.update", entity);
	}

	/**
	 * 删除<br>
	 * @param entity
	 * @return
	 * @since 2014-11-19
	 */
	public void delete(Xszcspb entity, SessionBean sessionBean) {
		
		update("xszcspb.delete", entity);
	}

	@SuppressWarnings("unchecked")
	public  List<Xszcspb> queryListBySqid(String sqid) {
		List<Xszcspb> list = queryForList("xszcspb.queryListBySqid", sqid);
		return list;
	}
}
