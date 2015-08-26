package com.founder.sydw.dao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.sydw.bean.Dwcfxxb;
import com.founder.sydw.bean.Dwjcxxb;
/**
 * ****************************************************************************
 * @Package:      [com.founder.sydw.dao.DwcfxxbDao.java]  
 * @ClassName:    [DwcfxxbDao]   
 * @Description:  [单位处罚 信息Dao]   
 * @Author:       [yu_guangli@founder.com.cn]  
 * @UpdateUser:   [yuguangli(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-11 上午9:23:49，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [删除多余的方法updateDwjgjb、queryCountByDwId（更新单位监管级别、查询条数）实际没用updateDwjgjb还报错、queryCountByDwId，增加分页查询方法queryList]  
 * @Version:      [v1.0]
 */
@Repository("dwcfxxbDao")
public class DwcfxxbDao extends BaseDaoImpl {

	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	public void save(Dwcfxxb entity) {
		insert("Dwcfxx.insertDwcf", entity);
	}
	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	public void update(Dwcfxxb entity) {
		update("Dwcfxx.updateDwcf", entity);
	}
	
	/**
	 * 查询单条<br>
	 * 
	 * @param entity
	 * @return
	 */
	public Dwcfxxb queryEntityById(Dwcfxxb entity) {
		return (Dwcfxxb)queryForObject("Dwcfxx.queryDwcf", entity);
	}
	
	/**
	 * 
	 * @Title: queryList
	 * @Description: 增加分页查询方法
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryList(EasyUIPage page, Dwcfxxb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "id";
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("dwcfxx", entity);
		page.setTotal((Integer) queryForObject("Dwcfxx.queryCountList", map));
		page.setRows(queryForList("Dwcfxx.queryList", map));
		return page;
	}
	

	/**
	 * 单位处罚信息
	 * @param map
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Dwcfxxb> dwcfxxb_query(Map<String, Object> map) {
		return queryForList("Dwcfxx.dwcfxxb_query", map);
	}
}
