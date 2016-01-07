package com.founder.zdrygl.base.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zdrygl.base.model.ZdryDtjsZszhjsbrZszhjlxxb;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.dao.ZdryDtjsZszhjsbrZszhjlxxbDao.java]  
 * @ClassName:    [ZdryDtjsZszhjsbrZszhjlxxbDao]   
 * @Description:  [动态纪实 肇事肇祸精神病肇事肇祸记录信息]   
 * @Author:       [cong_rihong@founder.com.cn]  
 * @CreateDate:   [2015-12-15 上午9:30:05]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-12-15 上午9:30:05，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("zdryDtjsZszhjsbrZszhjlxxbDao") 
public class ZdryDtjsZszhjsbrZszhjlxxbDao extends BaseDaoImpl {

	
	public void save(ZdryDtjsZszhjsbrZszhjlxxb entity) {
		insert("ZdryDtjsZszhjsbrZszhjlxxb.save", entity); 
	
	}
	
	public String update(ZdryDtjsZszhjsbrZszhjlxxb entity) {
		update("ZdryDtjsZszhjsbrZszhjlxxb.update", entity); 
		return entity.getId();
	}
	
	public ZdryDtjsZszhjsbrZszhjlxxb querById(String id){
		return (ZdryDtjsZszhjsbrZszhjlxxb)queryForObject("ZdryDtjsZszhjsbrZszhjlxxb.queryById", id);
	}
	

	
	public void delete(ZdryDtjsZszhjsbrZszhjlxxb entity){
		update("ZdryDtjsZszhjsbrZszhjlxxb.delete", entity); 

	}
	


	public List<?> queryList(EasyUIPage page, Map<String, Object> map) {
		return queryForList("ZdryDtjsZszhjsbrZszhjlxxb.queryByZdryZjhm", map);
	}

	

	public long queryCount(Map<String, Object> map) {
		Integer count = (Integer) queryForObject("ZdryDtjsZszhjsbrZszhjlxxb.queryCountByZdryZjhm", map);
		return count.longValue();
	}	
	
}
