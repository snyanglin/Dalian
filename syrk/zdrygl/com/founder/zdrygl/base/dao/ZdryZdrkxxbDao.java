package com.founder.zdrygl.base.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.zdrygl.base.model.ZdryZdrkxxb;
/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.dao.ZdryZdrkDao.java]  
 * @ClassName:    [ZdryZdrkDao]   
 * @Description:  [重点人口信息表数据库操作类]   
 * @Author:       [weiwen]  
 * @CreateDate:   [2015-3-12 下午4:02:08]   
 * @UpdateUser:   [weiwen]   
 * @UpdateDate:   [2015-3-12 下午4:02:08，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("ZdryZdrkDao")
public class ZdryZdrkxxbDao extends BaseDaoImpl {

	public void insert(ZdryZdrkxxb	entity){		
		insert("ZdryZdrkxxb.save", entity);
	}
	
	public void update(ZdryZdrkxxb	entity){			
		update("ZdryZdrkxxb.update", entity);
	}
	
	public void delete(ZdryZdrkxxb	entity){			
		update("ZdryZdrkxxb.delete", entity);
	}
	
	public ZdryZdrkxxb queryById(String id){
		return (ZdryZdrkxxb) queryForObject("ZdryZdrkxxb.queryById", id);
	}

	public ZdryZdrkxxb queryByMap(Map map) {		
		return (ZdryZdrkxxb) queryForObject("ZdryZdrkxxb.queryByMap", map);
	}
}
