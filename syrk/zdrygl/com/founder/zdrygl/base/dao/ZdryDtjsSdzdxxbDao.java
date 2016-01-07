package com.founder.zdrygl.base.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zdrygl.base.model.ZdryDtjsSdzdxxb;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.dao.ZdryDtjsSdzdxxb.java]  
 * @ClassName:    [ZdryDtjsSdzdxxb]   
 * @Description:  [动态纪实 涉毒制毒信息]   
 * @Author:       [cong_rihong@founder.com.cn]  
 * @CreateDate:   [2015-12-15 上午9:30:05]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-12-15 上午9:30:05，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("zdryDtjsSdzdxxbDao") 
public class ZdryDtjsSdzdxxbDao extends BaseDaoImpl {

	
	public void save(ZdryDtjsSdzdxxb entity) {
		insert("ZdryDtjsSdzdxxb.save", entity); 
	
	}
	
	public String update(ZdryDtjsSdzdxxb entity) {
		update("ZdryDtjsSdzdxxb.update", entity); 
		return entity.getId();
	}
	
	public ZdryDtjsSdzdxxb querById(String id){
		return (ZdryDtjsSdzdxxb)queryForObject("ZdryDtjsSdzdxxb.queryById", id);
	}
	

	
	public void delete(ZdryDtjsSdzdxxb entity){
		update("ZdryDtjsSdzdxxb.delete", entity); 

	}
	

	
	public List<?> queryList(EasyUIPage page, Map<String, Object> map) {
		return queryForList("ZdryDtjsSdzdxxb.queryByZdryZjhm", map);
	}

	

	public long queryCount(Map<String, Object> map) {
		Integer count = (Integer) queryForObject("ZdryDtjsSdzdxxb.queryCountByZdryZjhm", map);
		return count.longValue();
	}	
	
}
