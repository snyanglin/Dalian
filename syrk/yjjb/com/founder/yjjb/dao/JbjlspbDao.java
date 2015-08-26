package com.founder.yjjb.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.yjjb.bean.Jbjlspb;
import com.founder.yjjb.bean.Xszcspb;

/**
 * 举报奖励审批表</br>
 * 增删改查等基本操作
 * @author dangkp
 * @since 2014-12-04
 */
@Repository("jbjlspbDao")
public class JbjlspbDao extends BaseDaoImpl  {
	/**
	 * 查询
	 * @param page
	 * @param entity
	 * @return
	 * @since 2014-12-04
	 */
	public EasyUIPage queryList(EasyUIPage page, Jbjlspb entity) {
		
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
		map.put("jbjlspb", entity);
		
		
		page.setTotal((Integer) queryForObject("jbjlspb.queryCount", map));
		page.setRows(queryForList("jbjlspb.queryList", map));
		return page;
	}

	/**
	 * 查询
	 * @param entity
	 * @return
	 * @since 2014-12-04
	 */
	public Jbjlspb queryList(Jbjlspb entity){
		
		return (Jbjlspb)super.queryForObject("jbjlspb.queryById", entity);
	}
	
	/**
	 * 查询
	 * @param entity
	 * @return
	 * @since 2014-12-04
	 */
	public Jbjlspb queryById(Jbjlspb entity){
		
		return (Jbjlspb)super.queryForObject("jbjlspb.queryById", entity);
	}
	
	/**
	 * 新增<br>
	 * @param entity
	 * @return
	 * @since 2014-12-04
	 */
	public void save(Jbjlspb entity, SessionBean sessionBean) {
		
		insert("jbjlspb.save", entity);
	}
	
	/**
	 * 删除<br>
	 * @param entity
	 * @return
	 * @since 2014-12-04
	 */
	public void delete(Jbjlspb entity, SessionBean sessionBean) {
		
		update("jbjlspb.delete", entity);
	}
	
	/**
	 * 更新<br>
	 * @param entity
	 * @return
	 * @since 2014-11-17
	 */
	public void update(Jbjlspb entity, SessionBean sessionBean) {
		
		update("jbjlspb.update", entity);
	}

	/**
	 * @Title: queryBySqbh
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return List<Jbjlspb>    返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public List<Jbjlspb> queryBySqbh(Jbjlspb entity) {
		List<Jbjlspb> list = queryForList("jbjlspb.queryBySqbh", entity);
		return list;
	}
}
