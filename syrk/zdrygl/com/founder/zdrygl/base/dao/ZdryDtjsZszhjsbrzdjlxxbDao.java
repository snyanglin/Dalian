package com.founder.zdrygl.base.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zdrygl.base.model.ZdryDtjsZszhjsbrZdjlxxb;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.dao.ZdryDtjsZszhjsbrzdjlxxbDao.java]  
 * @ClassName:    [ZdryDtjsZszhjsbrzdjlxxbDao]   
 * @Description:  [动态纪实 肇事肇祸精神病诊断记录信息]   
 * @Author:       [cong_rihong@founder.com.cn]  
 * @CreateDate:   [2015-12-15 上午9:30:05]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-12-15 上午9:30:05，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("zdryDtjsZszhjsbrzdjlxxbDao") 
public class ZdryDtjsZszhjsbrzdjlxxbDao extends BaseDaoImpl {

	
	public void save(ZdryDtjsZszhjsbrZdjlxxb entity) {
		insert("ZdryDtjsZszhjsbrZdjlxxb.save", entity); 
	
	}
	
	public String update(ZdryDtjsZszhjsbrZdjlxxb entity) {
		update("ZdryDtjsZszhjsbrZdjlxxb.update", entity); 
		return entity.getId();
	}
	
	public ZdryDtjsZszhjsbrZdjlxxb querById(String id){
		return (ZdryDtjsZszhjsbrZdjlxxb)queryForObject("ZdryDtjsZszhjsbrZdjlxxb.queryById", id);
	}
	

	
	public void delete(ZdryDtjsZszhjsbrZdjlxxb entity){
		update("ZdryDtjsZszhjsbrZdjlxxb.delete", entity); 

	}
	


	public List<?> queryList(EasyUIPage page, Map<String, Object> map) {
		return queryForList("ZdryDtjsZszhjsbrZdjlxxb.queryByZdryZjhm", map);
	}

	

	public long queryCount(Map<String, Object> map) {
		Integer count = (Integer) queryForObject("ZdryDtjsZszhjsbrZdjlxxb.queryCountByZdryZjhm", map);
		return count.longValue();
	}	
	
}
