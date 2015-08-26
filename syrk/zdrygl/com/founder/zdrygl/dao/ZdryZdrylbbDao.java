package com.founder.zdrygl.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.zdrygl.bean.ZdryZdrylbb;
/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.dao.ZdryZdrylbbDao.java]  
 * @ClassName:    [ZdryZdrylbbDao]   
 * @Description:  [重点人口信息表数据操作类]   
 * @Author:       [weiwen]  
 * @CreateDate:   [2015-3-12 下午4:28:00]   
 * @UpdateUser:   [weiwen]   
 * @UpdateDate:   [2015-3-12 下午4:28:00，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("zdryZdrylbbDao")
public class ZdryZdrylbbDao extends BaseDaoImpl {

	public void insert(ZdryZdrylbb entity){
		insert("ZdryZdrylbb.save", entity);
	}
	
	public void update(ZdryZdrylbb entity){
		update("ZdryZdrylbb.update", entity);
	}
	
	public void delete(ZdryZdrylbb entity){
		update("ZdryZdrylbb.delete", entity);
	}
	
	public ZdryZdrylbb queryById(String id){
		return (ZdryZdrylbb) queryForObject("ZdryZdrylbb.queryById", id);
	}
	
	public List<ZdryZdrylbb> queryByZdryid(String id){
		return queryForList("ZdryZdrylbb.queryByZdryid", id);
	}
	
	public ZdryZdrylbb queryByZdrylbdm(String id){
		return (ZdryZdrylbb) queryForObject("ZdryZdrylbb.queryByZdrylbdm", id);
	}
	
	
	/**
	 * 
	 * @Title: queryViewList
	 * @Description: TODO(根据条件和数据，返回对应结果集)
	 * @param @param map
	 * @param @return    设定文件
	 * @return List<ZdryZdrylbb>    返回类型
	 * @throws
	 */
	public List<ZdryZdrylbb> queryViewList(Map map){
		
		return queryForList("ZdryZdrylbb.queryViewList", map);
	}
	
	
	/**
	 * 
	 * @Title: queryList
	 * @Description: TODO(分页查询)
	 * @param @param entity
	 * @param @param page
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryList(ZdryZdrylbb entity, EasyUIPage page){
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
		map.put("zdryZdrylbb", entity);
		List<?> list = queryForList("ZdryZdrylbb.queryList", map);
		if (page.getBegin() == 0) {
			if (list != null && list.size() > 0) {
				page.setTotal(list.size());
			} else {
				page.setTotal(0);
			}
		} else {
			if (page.getTotal() == 0) {
				if (list != null && list.size() > 0) {
					page.setTotal(list.size());
				}
			}
		}
		page.setRows(list);
		return page;
	}
	
	/**
	 * 
	 * @Title: queryCount
	 * @Description: TODO(查询列表)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public long queryCount(ZdryZdrylbb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("zdryZdrylbb", entity);
		Integer count = (Integer) queryForObject("ZdryZdrylbb.queryCount",
				map);
		return count.longValue();
	}
	
	
	public void deleteByZdryid(ZdryZdrylbb  entity){
		update("ZdryZdrylbb.deleteByZdryid",  entity);
	}
}
