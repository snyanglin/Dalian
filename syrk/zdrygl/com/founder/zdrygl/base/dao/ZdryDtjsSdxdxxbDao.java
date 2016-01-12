package com.founder.zdrygl.base.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zdrygl.base.model.ZdryDtjsSdxdxxb;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.dao.ZdryDtjsSdxdxxb.java]  
 * @ClassName:    [ZdryDtjsSdxdxxb]   
 * @Description:  [动态纪实 涉毒吸毒信息]   
 * @Author:       [cong_rihong@founder.com.cn]  
 * @CreateDate:   [2015-12-15 上午9:30:05]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-12-15 上午9:30:05，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("zdryDtjsSdxdxxbDao") 
public class ZdryDtjsSdxdxxbDao extends BaseDaoImpl {

	
	public void save(ZdryDtjsSdxdxxb entity) {
		insert("ZdryDtjsSdxdxxb.save", entity); 
	
	}
	
	public String update(ZdryDtjsSdxdxxb entity) {
		update("ZdryDtjsSdxdxxb.update", entity); 
		return entity.getId();
	}
	
	public ZdryDtjsSdxdxxb querById(String id){
		return (ZdryDtjsSdxdxxb)queryForObject("ZdryDtjsSdxdxxb.queryById", id);
	}
	

	
	public void delete(ZdryDtjsSdxdxxb entity){
		update("ZdryDtjsSdxdxxb.delete", entity); 

	}
	


	public List<?> queryList(EasyUIPage page, Map<String, Object> map) {
		return queryForList("ZdryDtjsSdxdxxb.queryByZdryZjhm", map);
	}

	
	/**
	 * @Title: queryCount
	 * @Description: TODO(人员写实条数查询)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return long    返回类型
	 * @throws
	 */
	public long queryCount(Map<String, Object> map) {
		Integer count = (Integer) queryForObject("ZdryDtjsSdxdxxb.queryCountByZdryZjhm", map);
		return count.longValue();
	}	
	
}
