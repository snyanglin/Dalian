package com.founder.zdry.dao;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.zdry.bean.ZdryFzcsfryxxb;
/**
 * ****************************************************************************
 * @Package:      [com.founder.zdry.dao.ZdryFzcsfryxxbDao.java]  
 * @ClassName:    [ZdryFzcsfryxxbDao]   
 * @Description:  [非正常上访人员信息表数据操作类]   
 * @Author:       [weiwen]  
 * @CreateDate:   [2015-3-12 下午4:28:00]   
 * @UpdateUser:   [weiwen]   
 * @UpdateDate:   [2015-3-12 下午4:28:00，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("zdryFzcsfryxxbDao")
public class ZdryFzcsfryxxbDao extends BaseDaoImpl {

	public void insert(ZdryFzcsfryxxb entity){
		insert("ZdryFzcsfryxxb.save", entity);
	}
	
	public void update(ZdryFzcsfryxxb entity){
		update("ZdryFzcsfryxxb.update", entity);
	}
	
	public void delete(ZdryFzcsfryxxb entity){
		update("ZdryFzcsfryxxb.delete", entity);
	}
	
	public ZdryFzcsfryxxb queryById(String id){
		return (ZdryFzcsfryxxb) queryForObject("ZdryFzcsfryxxb.queryById", id);
	}

	public ZdryFzcsfryxxb queryZsxxById(String id) {
		return (ZdryFzcsfryxxb) queryForObject("ZdryFzcsfryxxb.queryZsxxById", id);
	}
}
