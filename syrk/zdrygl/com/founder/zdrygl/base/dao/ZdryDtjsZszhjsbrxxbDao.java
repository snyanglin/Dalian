package com.founder.zdrygl.base.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zdrygl.base.model.ZdryDtjsZszhjsbrxxb;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.dao.ZdryDtjsZszhjsbrxxbDao.java]  
 * @ClassName:    [ZdryDtjsZszhjsbrxxbDao]   
 * @Description:  [动态纪实肇事肇祸精神病人信息]   
 * @Author:       [cong_rihong@founder.com.cn]  
 * @CreateDate:   [2015-12-15 上午9:30:05]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-12-15 上午9:30:05，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("zdryDtjsZszhjsbrxxbDao") 
public class ZdryDtjsZszhjsbrxxbDao extends BaseDaoImpl {

	
	public void save(ZdryDtjsZszhjsbrxxb entity) {
		insert("ZdryDtjsZszhjsbrxxb.save", entity); 
	
	}
	
	public String update(ZdryDtjsZszhjsbrxxb entity) {
		update("ZdryDtjsZszhjsbrxxb.update", entity); 
		return entity.getId();
	}
	
	public ZdryDtjsZszhjsbrxxb querById(String id){
		return (ZdryDtjsZszhjsbrxxb)queryForObject("ZdryDtjsZszhjsbrxxb.queryById", id);
	}
	

	
	public void delete(ZdryDtjsZszhjsbrxxb entity){
		update("ZdryDtjsZszhjsbrxxb.delete", entity); 

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
		return queryForList("ZdryDtjsZszhjsbrxxb.queryByZdryZjhm", map);
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
		Integer count = (Integer) queryForObject("ZdryDtjsZszhjsbrxxb.queryCountByZdryZjhm", map);
		return count.longValue();
	}	
	
}
