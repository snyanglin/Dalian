package com.founder.zdrygl.base.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zdrygl.base.model.ZdryDtjsClxxb;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.dao.ZdryDtjsClxxbDao.java]  
 * @ClassName:    [ZdryDtjsClxxbDao]   
 * @Description:  [动态纪实 车辆信息]   
 * @Author:       [cong_rihong@founder.com.cn]  
 * @CreateDate:   [2015-12-14 上午9:30:05]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-12-14 上午9:30:05，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("zdryDtjsClxxbDao") 
public class ZdryDtjsClxxbDao extends BaseDaoImpl {

	
	public void save(ZdryDtjsClxxb entity) {
		insert("ZdryDtjsClxxb.save", entity); 
	
	}
	
	public String update(ZdryDtjsClxxb entity) {
		update("ZdryDtjsClxxb.update", entity); 
		return entity.getId();
	}
	
	public ZdryDtjsClxxb querById(String id){
		return (ZdryDtjsClxxb)queryForObject("ZdryDtjsClxxb.queryById", id);
	}
	

	
	public void delete(ZdryDtjsClxxb entity){
		update("ZdryDtjsClxxb.delete", entity); 

	}
	

	/**
	 * @Title: queryList
	 * @Description: TODO(车辆列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public List<?> queryList(EasyUIPage page, Map<String, Object> map) {
		return queryForList("ZdryDtjsClxxb.queryByZdryZjhm", map);
	}

	
	/**
	 * @Title: queryCount
	 * @Description: TODO(车辆条数查询)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return long    返回类型
	 * @throws
	 */
	public long queryCount(Map<String, Object> map) {
		Integer count = (Integer) queryForObject("ZdryDtjsClxxb.queryCountByZdryZjhm", map);
		return count.longValue();
	}	
	
}
