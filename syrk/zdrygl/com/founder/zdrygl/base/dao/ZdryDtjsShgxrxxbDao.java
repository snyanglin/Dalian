package com.founder.zdrygl.base.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zdrygl.base.model.ZdryDtjsShgxrxxb;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.dao.RyxsDao.java]  
 * @ClassName:    [RyxsDao]   
 * @Description:  [動態紀實 社会关系人信息表]   
 * @Author:       [cong_rihong@founder.com.cn]  
 * @CreateDate:   [2015-12-11 上午9:30:05]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-12-11 上午9:30:05，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("zdryDtjsShgxrxxbDao")
public class ZdryDtjsShgxrxxbDao extends BaseDaoImpl {

	
	public void save(ZdryDtjsShgxrxxb entity) {
		insert("ZdryDtjsShgxrxxb.save", entity); 
	
	}
	
	public String update(ZdryDtjsShgxrxxb entity) {
		update("ZdryDtjsShgxrxxb.update", entity); 
		return entity.getId();
	}
	
	public ZdryDtjsShgxrxxb querById(String id){
		return (ZdryDtjsShgxrxxb)queryForObject("ZdryDtjsShgxrxxb.queryById", id);
	}
	

	
	public void delete(ZdryDtjsShgxrxxb entity){
		update("ZdryDtjsShgxrxxb.delete", entity); 

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
	public List<?> queryList(EasyUIPage page, Map<String, Object> map) {
		return queryForList("ZdryDtjsShgxrxxb.queryByZdryZjhm", map);
	}

	
	/**
	 * @Title: queryRyxsListCount
	 * @Description: TODO(人员写实条数查询)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return long    返回类型
	 * @throws
	 */
	public long queryCount(Map<String, Object> map) {
		Integer count = (Integer) queryForObject("ZdryDtjsShgxrxxb.queryCountByZdryZjhm", map);
		return count.longValue();
	}	
	
}
