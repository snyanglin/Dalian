package com.founder.zdrygl.base.dao;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.zdrygl.base.model.ZdryNrsxdxxxb;
/**
 * ****************************************************************************
 * @Package:      [cn.mos.zdry.dao.ZdryFzcsfryxxbDao.java]  
 * @ClassName:    [ZdryFzcsfryxxbDao]   
 * @Description:  [非正常上访人员信息表数据操作类]   
 * @Author:       [weiwen]  
 * @CreateDate:   [2015-3-12 下午4:28:00]   
 * @UpdateUser:   [weiwen]   
 * @UpdateDate:   [2015-3-12 下午4:28:00，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("zdryNrsxdxxxbDao")
public class ZdryNrsxdxxxbDao extends BaseDaoImpl {

	public void insert(ZdryNrsxdxxxb entity){
		insert("ZdryNrsxdxxxb.save", entity);
	}
	
	public void update(ZdryNrsxdxxxb entity){
		update("ZdryNrsxdxxxb.update", entity);
	}
	
	public void delete(ZdryNrsxdxxxb entity){
		update("ZdryNrsxdxxxb.delete", entity);
	}
	
	public ZdryNrsxdxxxb queryById(String id){
		return (ZdryNrsxdxxxb) queryForObject("ZdryNrsxdxxxb.queryById", id);
	}

	public ZdryNrsxdxxxb queryZsxxById(String id) {
		return (ZdryNrsxdxxxb) queryForObject("ZdryNrsxdxxxb.queryZsxxById", id);
	}
}
