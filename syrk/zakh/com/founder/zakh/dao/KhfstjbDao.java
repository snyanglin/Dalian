package com.founder.zakh.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.zakh.bean.Khfstjb;


/******************************************************************************
 * @Package:      [com.founder.zakh.dao.KhfstjbDao.java]  
 * @ClassName:    [KhfstjbDao]   
 * @Description:  [考核统计表dao]   
 * @Author:       [cong_rihong@founder.com.cn]  
 * @CreateDate:   [2015-6-2 上午11:32:02]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-2 上午11:32:02，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@Repository("khfstjbDao")
public class KhfstjbDao extends BaseDaoImpl {
 
	
	
	public void save(Khfstjb entity){
		insert("Khfstjb.save", entity);
	}
	
	
	
	
	public  List<Khfstjb>  queryKhtjb(Map<String,String> map){
		return queryForList("Khfstjb.queryKhfstj", map);

	}
	
	public Khfstjb querySzkhtj(Map<String,String> map){
		return (Khfstjb)queryForObject("Khfstjb.querySzkhtj", map);
	}
	
}
