package com.founder.syrkgl.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.syrkgl.bean.SyrkWlhryxxb;
/**
 * ****************************************************************************
 * @Package:      [com.founder.syrkgl.dao.SyrkWlhryxxbDao.java]  
 * @ClassName:    [SyrkWlhryxxbDao]   
 * @Description:  [未落户人员DAO]   
 * @Author:       [weiwen]  
 * @CreateDate:   [2015-4-9 上午11:03:45]   
 * @UpdateUser:   [weiwen]   
 * @UpdateDate:   [2015-4-9 上午11:03:45，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("syrkWlhryxxbDao")
public class SyrkWlhryxxbDao extends BaseDaoImpl {

	public void insert(SyrkWlhryxxb entity) {
		entity.setXmhyjp(queryPy(entity.getXm()));
		entity.setXmhypy(queryPyqp(entity.getXm()));
		insert("SyrkWlhryxxb.save", entity);
	}

	public void update(SyrkWlhryxxb entity) {
		update("SyrkWlhryxxb.update", entity);
	}

	public void delete(SyrkWlhryxxb entity) {
		update("SyrkWlhryxxb.delete", entity);
	}

	public SyrkWlhryxxb queryById(String id) {
		return (SyrkWlhryxxb) queryForObject("SyrkWlhryxxb.queryById", id);
	}
	public SyrkWlhryxxb queryByIdWithOutZxbz(String id) {
		return (SyrkWlhryxxb) queryForObject("SyrkWlhryxxb.queryByIdWithOutZxbz", id);
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
	public List<SyrkWlhryxxb> queryRyByLxdh(String lxdh){
		Map<String,String> map =new  HashMap<String,String>();
		map.put("lxdh", lxdh);
		return queryForList("SyrkWlhryxxb.queryByLxdh", map);
	}
}
