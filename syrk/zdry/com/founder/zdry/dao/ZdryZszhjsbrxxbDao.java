package com.founder.zdry.dao;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.zdry.bean.ZdryZszhjsbrxxb;
/**
 * ****************************************************************************
 * @Package:      [com.founder.zdry.dao.ZdryZszhjsbrxxbDao.java]  
 * @ClassName:    [ZdryZszhjsbrxxbDao]   
 * @Description:  [肇事肇祸精神病人信息表数据操作类]   
 * @Author:       [weiwen]  
 * @CreateDate:   [2015-3-12 下午4:28:00]   
 * @UpdateUser:   [weiwen]   
 * @UpdateDate:   [2015-3-12 下午4:28:00，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("zdryZszhjsbrxxbDao")
public class ZdryZszhjsbrxxbDao extends BaseDaoImpl {

	public void insert(ZdryZszhjsbrxxb entity){
		insert("ZdryZszhjsbrxxb.save", entity);
	}
	
	public void update(ZdryZszhjsbrxxb entity){
		update("ZdryZszhjsbrxxb.update", entity);
	}
	
	public void delete(ZdryZszhjsbrxxb entity){
		update("ZdryZszhjsbrxxb.delete", entity);
	}
	
	public ZdryZszhjsbrxxb queryById(String id){
		return (ZdryZszhjsbrxxb) queryForObject("ZdryZszhjsbrxxb.queryById", id);
	}

	public ZdryZszhjsbrxxb queryZsxxById(String id) {
		return (ZdryZszhjsbrxxb) queryForObject("ZdryZszhjsbrxxb.queryZsxxById", id);
	}
}
