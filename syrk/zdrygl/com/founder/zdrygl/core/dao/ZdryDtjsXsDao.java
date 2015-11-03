package com.founder.zdrygl.core.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zdrygl.base.model.ZdryDtjsClxxb;
import com.founder.zdrygl.base.model.ZdryDtjsGxbgxxb;
import com.founder.zdrygl.base.model.ZdryDtjsSaxxb;
import com.founder.zdrygl.base.model.ZdryDtjsShgxrxxb;
import com.founder.zdrygl.base.model.ZdryDtjsXsxxb;


/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.dao.RyxsDao.java]  
 * @ClassName:    [RyxsDao]   
 * @Description:  [人员写实dao]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-5-5 上午9:30:05]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-5 上午9:30:05，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("zdryDtjsXsDao")
public class ZdryDtjsXsDao extends BaseDaoImpl {

	/**
	 * @Title: saveXscjb
	 * @Description: TODO(保存人员写实表数据)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveRyxsb(ZdryDtjsXsxxb entity) {
		insert("ZdryDtjsXs.saveZdryDtjsXsxxb", entity); 
		return entity.getId();
	}
	
	public void updateGxdw(ZdryDtjsGxbgxxb entity) {
		update("ZdryDtjsXs.updateGxdw",entity);		
	}
	public String saveShgxr(ZdryDtjsShgxrxxb entity) {
		insert("ZdryDtjsXs.saveShgxrb", entity); 
		return entity.getObjectid();
	}
	public String saveSaxx(ZdryDtjsSaxxb entity) {
		insert("ZdryDtjsXs.saveSaxxb", entity); 
		return entity.getId();
	}
	public String saveClxx(ZdryDtjsClxxb entity) {
		insert("ZdryDtjsXs.saveClxxb", entity); 
		return entity.getId();
	}
	/**
	 * @Title: queryRyxsList
	 * @Description: TODO(人员写实列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public List<?> queryRyxsList(EasyUIPage page, Map<String, Object> map) {
		return queryForList("ZdryDtjsXs.queryRyxsList", map);
	}
	public List<?> queryGxbgList(EasyUIPage page, Map<String, Object> map) {
		return queryForList("ZdryDtjsXs.queryGxbgList", map);
	}
	public List<?> queryShgxrList(EasyUIPage page, Map<String, Object> map) {
		return queryForList("ZdryDtjsXs.queryShgxrList", map);
	}
	public List<?> querySaxxList(EasyUIPage page, Map<String, Object> map) {
		return queryForList("ZdryDtjsXs.querySaxxList", map);
	}
	public List<?> queryClxxList(EasyUIPage page, Map<String, Object> map) {
		return queryForList("ZdryDtjsXs.queryClxxList", map);
	}
	
	/**
	 * @Title: queryRyxsListCount
	 * @Description: TODO(人员写实条数查询)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return long    返回类型
	 * @throws
	 */
	public long queryRyxsListCount(Map<String, Object> map) {
		Integer count = (Integer) queryForObject("ZdryDtjsXs.queryRyxsListCount", map);
		return count.longValue();
	}	
	
	/**
	 * @Title: queryGxbgListCount
	 * @Description: TODO(重点人员管辖变更总数)
	 * @param @param map
	 * @param @return    设定文件
	 * @return long    返回类型
	 * @throws
	 */
	public long queryGxbgListCount(Map<String, Object> map) {
		Integer count = (Integer) queryForObject("ZdryDtjsXs.queryGxbgListCount", map);
		return count.longValue();
	}
	public long queryShgxrListCount(Map<String, Object> map) {
		Integer count = (Integer) queryForObject("ZdryDtjsXs.queryShgxrCount", map);
		return count.longValue();
	}
	public long querySaxxListCount(Map<String, Object> map) {
		Integer count = (Integer) queryForObject("ZdryDtjsXs.querySaxxCount", map);
		return count.longValue();
	}
	public long queryClxxListCount(Map<String, Object> map) {
		Integer count = (Integer) queryForObject("ZdryDtjsXs.queryClxxCount", map);
		return count.longValue();
	}
}
