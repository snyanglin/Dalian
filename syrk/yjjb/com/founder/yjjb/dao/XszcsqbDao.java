package com.founder.yjjb.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.yjjb.bean.Xszcsqb;

/**
 * 线索递转申请表</br>
 * 增删改查等基本操作
 * @author Administrator
 * @since 2014-11-19
 */
@Repository("xszcsqbDao")
public class XszcsqbDao extends BaseDaoImpl {

	/**
	 * 查询
	 * @param page
	 * @param entity
	 * @return
	 * @since 2014-11-19
	 */
	public EasyUIPage queryList(EasyUIPage page, Xszcsqb entity) {
		
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
		map.put("xszcsqb", entity);
		
		page.setTotal((Integer) queryForObject("xszcsqb.queryCount", map));
		page.setRows(queryForList("xszcsqb.queryList", map));
		return page;
	}

	/**
	 * 查询
	 * @param entity
	 * @return
	 * @since 2014-11-19
	 */
	public Xszcsqb queryList(Xszcsqb entity){
		
		return (Xszcsqb)super.queryForObject("xszcsqb.queryById", entity);
	}
	
	/**
	 * 查询
	 * @param entity
	 * @return
	 * @since 2014-11-19
	 */
	public Xszcsqb queryById(Xszcsqb entity){
		
		return (Xszcsqb)super.queryForObject("xszcsqb.queryById", entity);
	}
	
	/**
	 * 新增<br>
	 * @param entity
	 * @return
	 * @since 2014-11-19
	 */
	public void save(Xszcsqb entity, SessionBean sessionBean) {
		
		insert("xszcsqb.save", entity);
	}
	
	/**
	 * 更新<br>
	 * @param entity
	 * @return
	 * @since 2014-11-19
	 */
	public void update(Xszcsqb entity, SessionBean sessionBean) {
		
		update("xszcsqb.update", entity);
	}

	/**
	 * 删除<br>
	 * @param entity
	 * @return
	 * @since 2014-11-19
	 */
	public void delete(Xszcsqb entity, SessionBean sessionBean) {
		
		update("xszcsqb.delete", entity);
	}

	/**
	 * @Title: queryListByXsbh
	 * @Description: 通过线索id查询申请表的list内容
	 * @param @param entity
	 * @param @return    设定文件
	 * @return List<Xszcsqb>    返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<Xszcsqb> queryListByXsbh(Xszcsqb entity) {
		return queryForList("xszcsqb.queryListByXsbh", entity);
	}
}
