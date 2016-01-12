package com.founder.zdrygl.base.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zdrygl.base.model.ZdryDtjsSwxxb;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.dao.RyxsDao.java]  
 * @ClassName:    [RyxsDao]   
 * @Description:  [動態紀實 涉稳信息]   
 * @Author:       [cong_rihong@founder.com.cn]  
 * @CreateDate:   [2015-12-8 上午9:30:05]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-12-8 上午9:30:05，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("zdryDtjsSwxxbDao")
public class ZdryDtjsSwxxbDao extends BaseDaoImpl {

	
	public void save(ZdryDtjsSwxxb entity) {
		insert("ZdryDtjsSwxxb.save", entity); 
	
	}
	
	public String update(ZdryDtjsSwxxb entity) {
		update("ZdryDtjsSwxxb.update", entity); 
		return entity.getId();
	}
	
	public ZdryDtjsSwxxb querById(String id){
		return (ZdryDtjsSwxxb)queryForObject("ZdryDtjsSwxxb.queryById", id);
	}
	

	
	public void delete(ZdryDtjsSwxxb entity){
		update("ZdryDtjsSwxxb.delete", entity); 

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
		return queryForList("ZdryDtjsSwxxb.queryByZdryZjhm", map);
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
		Integer count = (Integer) queryForObject("ZdryDtjsSwxxb.queryCountByZdryZjhm", map);
		return count.longValue();
	}	
	
}
