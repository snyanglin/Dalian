package com.founder.zdrygl.base.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zdrygl.base.model.ZdryDtjsSdfdxxb;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.dao.ZdryDtjsSdfdxxb.java]  
 * @ClassName:    [ZdryDtjsSdfdxxb]   
 * @Description:  [动态纪实 涉毒贩毒信息]   
 * @Author:       [cong_rihong@founder.com.cn]  
 * @CreateDate:   [2015-12-15 上午9:30:05]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-12-15 上午9:30:05，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("zdryDtjsSdfdxxbDao") 
public class ZdryDtjsSdfdxxbDao extends BaseDaoImpl {

	
	public void save(ZdryDtjsSdfdxxb entity) {
		insert("ZdryDtjsSdfdxxb.save", entity); 
	
	}
	
	public String update(ZdryDtjsSdfdxxb entity) {
		update("ZdryDtjsSdfdxxb.update", entity); 
		return entity.getId();
	}
	
	public ZdryDtjsSdfdxxb querById(String id){
		return (ZdryDtjsSdfdxxb)queryForObject("ZdryDtjsSdfdxxb.queryById", id);
	}
	

	
	public void delete(ZdryDtjsSdfdxxb entity){
		update("ZdryDtjsSdfdxxb.delete", entity); 

	}
	

	
	public List<?> queryList(EasyUIPage page, Map<String, Object> map) {
		return queryForList("ZdryDtjsSdfdxxb.queryByZdryZjhm", map);
	}

	

	public long queryCount(Map<String, Object> map) {
		Integer count = (Integer) queryForObject("ZdryDtjsSdfdxxb.queryCountByZdryZjhm", map);
		return count.longValue();
	}	
	
}
