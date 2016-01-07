package com.founder.zdrygl.base.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zdrygl.base.model.ZdryDtjsZdxsfzqkxxb;

/**
 * ****************************************************************************
 * @Package:      [com.founder.dao.ZdryDtjsZdxsfzqkxxbDao.java]  
 * @ClassName:    [RyxsDao]   
 * @Description:  [動態紀實 重大刑事犯罪前科信息]   
 * @Author:       [cong_rihong@founder.com.cn]  
 * @CreateDate:   [2015-12-10 上午9:30:05]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-12-10 上午9:30:05，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("zdryDtjsZdxsfzqkxxbDao") 
public class ZdryDtjsZdxsfzqkxxbDao extends BaseDaoImpl {

	
	public void save(ZdryDtjsZdxsfzqkxxb entity) {
		insert("ZdryDtjsZdxsfzqkxxb.save", entity); 
	
	}
	
	public String update(ZdryDtjsZdxsfzqkxxb entity) {
		update("ZdryDtjsZdxsfzqkxxb.update", entity); 
		return entity.getId();
	}
	
	public ZdryDtjsZdxsfzqkxxb querById(String id){
		return (ZdryDtjsZdxsfzqkxxb)queryForObject("ZdryDtjsZdxsfzqkxxb.queryById", id);
	}
	

	
	public void delete(ZdryDtjsZdxsfzqkxxb entity){
		update("ZdryDtjsZdxsfzqkxxb.delete", entity); 

	}
	

	/**
	 * @Title: queryList
	 * @Description: TODO(人员写实列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public List<?> queryList(EasyUIPage page, Map<String, Object> map) {
		return queryForList("ZdryDtjsZdxsfzqkxxb.queryByZdryZjhm", map);
	}

	

	public long queryCount(Map<String, Object> map) {
		Integer count = (Integer) queryForObject("ZdryDtjsZdxsfzqkxxb.queryCountByZdryZjhm", map);
		return count.longValue();
	}	
	
}
