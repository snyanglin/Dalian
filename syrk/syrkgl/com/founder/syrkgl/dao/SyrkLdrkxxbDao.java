package com.founder.syrkgl.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.syrkgl.bean.SyrkLdrkxxb;

/**
 * ****************************************************************************
 * @Package:      [com.founder.syrkgl.dao.SyrkLdrkxxbDao.java]  
 * @ClassName:    [SyrkLdrkxxbDao]   
 * @Description:  [流动人口DAO]   
 * @Author:       [weiwen]  
 * @CreateDate:   [2015-4-9 上午10:25:18]   
 * @UpdateUser:   [weiwen]   
 * @UpdateDate:   [2015-4-9 上午10:25:18，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("syrkLdrkxxbDao")
public class SyrkLdrkxxbDao extends BaseDaoImpl {

	public void insert(SyrkLdrkxxb entity) {
		entity.setXmhyjp(queryPy(entity.getXm()));
		entity.setXmhypy(queryPyqp(entity.getXm()));
		insert("SyrkLdrkxxb.save", entity);
	}

	public void update(SyrkLdrkxxb entity) {
		update("SyrkLdrkxxb.update", entity);
	}

	public void delete(SyrkLdrkxxb entity) {
		update("SyrkLdrkxxb.delete", entity);
	}

	public SyrkLdrkxxb queryById(String id) {
		return (SyrkLdrkxxb) queryForObject("SyrkLdrkxxb.queryById", id);
	}
	
	public SyrkLdrkxxb queryByIdWithOutZxbz(String id) {
		return (SyrkLdrkxxb) queryForObject("SyrkLdrkxxb.queryByIdWithOutZxbz", id);
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
	public List<SyrkLdrkxxb> queryRyByLxdh(String lxdh){
		Map<String,String> map =new  HashMap<String,String>();
		map.put("lxdh", lxdh);
		List lis = queryForList("SyrkLdrkxxb.queryByLxdh", map);
		return lis;
	}
}
