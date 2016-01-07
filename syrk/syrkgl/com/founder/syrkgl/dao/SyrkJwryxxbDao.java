package com.founder.syrkgl.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.syrkgl.bean.SyrkCzrkxxb;
import com.founder.syrkgl.bean.SyrkJwryxxb;
/**
 * ****************************************************************************
 * @Package:      [com.founder.syrkgl.dao.SyrkJwryxxbDao.java]  
 * @ClassName:    [SyrkJwryxxbDao]   
 * @Description:  [境外人员DAO]   
 * @Author:       [weiwen]  
 * @CreateDate:   [2015-4-3 下午5:39:44]   
 * @UpdateUser:   [weiwen]   
 * @UpdateDate:   [2015-4-3 下午5:39:44，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("syrkJwryxxbDao")
public class SyrkJwryxxbDao extends BaseDaoImpl {

	public void insert(SyrkJwryxxb entity) {
		insert("SyrkJwryxxb.save", entity);
	}

	public void update(SyrkJwryxxb entity) {
		update("SyrkJwryxxb.update", entity);
	}

	public void delete(SyrkJwryxxb entity) {
		update("SyrkJwryxxb.delete", entity);
	}

	public SyrkJwryxxb queryById(String id) {
		return (SyrkJwryxxb) queryForObject("SyrkJwryxxb.queryById", id);
	}
	
	public SyrkJwryxxb queryByIdWithOutZxbz(String id) {
		return (SyrkJwryxxb) queryForObject("SyrkJwryxxb.queryByIdWithOutZxbz", id);
	}

	/***
	 * 
	 * @Title: queryRyByLxdh
	 * @Description: TODO(根据联系方式查询人员)
	 * @param @param lxdh
	 * @param @return    设定文件
	 * @return List<SyrkCzrkxxb>    返回类型
	 * @throws
	 */
	public List<SyrkJwryxxb> queryRyByLxdh(String lxdh){
		Map<String,String> map =new  HashMap<String,String>();
		map.put("lxdh", lxdh);
		return queryForList("SyrkJwryxxb.queryByLxdh", map);
	}
}
