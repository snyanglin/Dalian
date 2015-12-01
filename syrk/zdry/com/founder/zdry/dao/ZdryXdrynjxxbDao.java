package com.founder.zdry.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.zdry.bean.ZdryXdrynjxxb;
/**
 * ****************************************************************************
 * @Package:      [com.founder.zdry.dao.ZdryXdrynjxxbDao.java]  
 * @ClassName:    [ZdryXdrynjxxbDao]   
 * @Description:  [重点人员总表数据操作类]   
 * @Author:       [weiwen]  
 * @CreateDate:   [2015-3-12 下午4:28:00]   
 * @UpdateUser:   [weiwen]   
 * @UpdateDate:   [2015-3-12 下午4:28:00，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("zdryXdrynjxxbDao")
public class ZdryXdrynjxxbDao extends BaseDaoImpl {

	public List<ZdryXdrynjxxb> queryList(String zdryid){
		return (List<ZdryXdrynjxxb>)queryForList("ZdryXdrynjxxb.queryList",zdryid);
	}
	
	public ZdryXdrynjxxb queryByZdryid(String ryid) {
		return (ZdryXdrynjxxb)queryForObject("ZdryXdrynjxxb.queryByZdryid", ryid);
	}
	
	public ZdryXdrynjxxb queryById(String id){
		return (ZdryXdrynjxxb)queryForObject("ZdryXdrynjxxb.queryById", id);
	}
	
	public void save(ZdryXdrynjxxb entity){
		insert("ZdryXdrynjxxb.save", entity);
	}
	
	public void update(ZdryXdrynjxxb entity){
		update("ZdryXdrynjxxb.update", entity);
	}
	
	public void delete(ZdryXdrynjxxb entity){
		update("ZdryXdrynjxxb.delete", entity);
	}
	
}
