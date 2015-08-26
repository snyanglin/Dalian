package com.founder.zdrygl.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.zdrygl.bean.ZdryJgdxxxb;
import com.founder.framework.base.dao.BaseDaoImpl;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.dao.ZdryJgdxxxbDao.java]  
 * @ClassName:    [ZdryJgdxxxbDao]   
 * @Description:  [监管对象信息表数据库操作类]   
 * @Author:       [weiwen]  
 * @CreateDate:   [2015-3-12 下午4:03:12]   
 * @UpdateUser:   [weiwen]   
 * @UpdateDate:   [2015-3-12 下午4:03:12，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("zdryJgdxxxbDao")
public class ZdryJgdxxxbDao extends BaseDaoImpl {
	
	public void insert(ZdryJgdxxxb	entity){		
		insert("ZdryJgdxxxb.save", entity);
	}
	
	public void update(ZdryJgdxxxb	entity){		
		update("ZdryJgdxxxb.update", entity);
	}
	
	public void delete(ZdryJgdxxxb	entity){			
		update("ZdryJgdxxxb.delete", entity);
	}
	
	public ZdryJgdxxxb queryById(String id){
		return (ZdryJgdxxxb) queryForObject("ZdryJgdxxxb.queryById", id);
	}

	public ZdryJgdxxxb queryByMap(Map map) {
		return (ZdryJgdxxxb) queryForObject("ZdryJgdxxxb.queryByMap", map);
	}
}
