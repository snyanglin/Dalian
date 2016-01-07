package com.founder.zdrygl.base.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zdrygl.base.model.ZdryDtjsSfxxb;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.dao.ZdryDtjsSfxxbDao.java]  
 * @ClassName:    [ZdryDtjsSfxxbDao]   
 * @Description:  [动态纪实 上访信息]   
 * @Author:       [cong_rihong@founder.com.cn]  
 * @CreateDate:   [2015-12-9 上午9:30:05]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-12-9 上午9:30:05，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("zdryDtjsSfxxbDao") 
public class ZdryDtjsSfxxbDao extends BaseDaoImpl {

	
	public void save(ZdryDtjsSfxxb entity) {
		insert("ZdryDtjsSfxxb.save", entity); 
	
	}
	
	public String update(ZdryDtjsSfxxb entity) {
		update("ZdryDtjsSfxxb.update", entity); 
		return entity.getId();
	}
	
	public ZdryDtjsSfxxb querById(String id){
		return (ZdryDtjsSfxxb)queryForObject("ZdryDtjsSfxxb.queryById", id);
	}
	

	
	public void delete(ZdryDtjsSfxxb entity){
		update("ZdryDtjsSfxxb.delete", entity); 

	}
	


	public List<?> queryList(EasyUIPage page, Map<String, Object> map) {
		return queryForList("ZdryDtjsSfxxb.queryByZdryZjhm", map);
	}

	

	public long queryCount(Map<String, Object> map) {
		Integer count = (Integer) queryForObject("ZdryDtjsSfxxb.queryCountByZdryZjhm", map);
		return count.longValue();
	}	
	
}
