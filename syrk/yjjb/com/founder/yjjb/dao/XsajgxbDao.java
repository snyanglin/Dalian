package com.founder.yjjb.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.yjjb.bean.Xsajgxb;
import com.founder.yjjb.bean.Xscljlb;

/**
 * 案件信息表</br>
 * 增删改查等基本操作
 * @author Administrator
 * @since 2014-11-17
 */
@Repository("xsajgxbDao")
public class XsajgxbDao extends BaseDaoImpl {
	
	/**
	 * 查询
	 * @param page
	 * @param entity
	 * @return
	 * @since 2014-11-17
	 */
	public EasyUIPage queryList(EasyUIPage page, Xsajgxb entity) {
		
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
		map.put("xsajgxb", entity);
		
		page.setTotal((Integer) queryForObject("xsajgxb.queryCount", map));
		page.setRows(queryForList("xsajgxb.queryList", map));
		return page;
	}

	/**
	 * 查询
	 * @param entity
	 * @return
	 * @since 2014-11-17
	 */
	public Xsajgxb queryList(Xsajgxb entity){
		
		return (Xsajgxb)super.queryForObject("xsajgxb.queryById", entity);
	}

	/**
	 * 查询
	 * @param entity
	 * @return
	 * @since 2014-11-17
	 */
	public Xsajgxb queryById(Xsajgxb entity){
		
		return (Xsajgxb)super.queryForObject("xsajgxb.queryById", entity);
	}
	
	/**
	 * 新增<br>
	 * @param entity
	 * @return
	 * @since 2014-11-17
	 */
	public void save(Xsajgxb entity, SessionBean sessionBean) {
		
		insert("xsajgxb.save", entity);
	}
	
	/**
	 * 更新<br>
	 * @param entity
	 * @return
	 * @since 2014-11-17
	 */
	public void update(Xsajgxb entity, SessionBean sessionBean) {
		
		update("xsajgxb.update", entity);
	}

	/**
	 * 删除<br>
	 * @param entity
	 * @return
	 * @since 2014-11-17
	 */
	public void delete(Xsajgxb entity, SessionBean sessionBean) {
		
		update("xsajgxb.delete", entity);
	}
	
	/**
	 * 设置sfffjl
	 */
	public void updateSfffjl(Xsajgxb entity, SessionBean sessionBean) {
		
		update("xsajgxb.updateSfffjl", entity);
	}
	
	
	/**
	 * 查询
	 * @param page
	 * @param entity
	 * @return
	 * @since 2014-11-17
	 */
	public EasyUIPage queryByXsId(EasyUIPage page, String xsId) {
		
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
		map.put("xsbh", xsId);
		
		page.setTotal((Integer) queryForObject("xsajgxb.queryCountByXsId", map));
		page.setRows(queryForList("xsajgxb.queryByXsId", map));
		return page;
	}
	
	/**
	 * 判断是否存在案件
	 * @param xsbh
	 * @return
	 */
	public int ifExistAj(String xsbh) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("xsbh", xsbh);
		return (Integer) queryForObject("xsajgxb.ifExistAj", map);
	}

	/**
	 * @Title: queryByXsidAjid
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Xsajgxb    返回类型
	 * @throws
	 */
	public Xsajgxb queryByXsidAjid(Xsajgxb entity) {
		return (Xsajgxb)super.queryForObject("xsajgxb.queryByXsidAjid", entity);
	}
	
	/**
	 * @Title: queryListByXsbh
	 * @Description: 线索对应的所有的案件编号</br>
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Object    返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<Xsajgxb> queryAJListByXsbh(String xsbh) {
		return queryForList("xsajgxb.queryAJListByXsbh", xsbh);
	}
}
