package com.founder.syrkgl.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.syrkgl.bean.SyrkCzrkxxb;
import com.founder.syrkgl.bean.SyrkJwryxxb;
import com.founder.syrkgl.bean.SyrkJzrkxxb;
/**
 * ****************************************************************************
 * @Package:      [com.founder.syrkgl.dao.SyrkJzrkxxbDao.java]  
 * @ClassName:    [SyrkJzrkxxbDao]   
 * @Description:  [寄住人口DAO]   
 * @Author:       [weiwen]   
 * @CreateDate:   [2015-4-5 下午11:13:41]   
 * @UpdateUser:   [weiwen(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-5 下午11:13:41，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("syrkJzrkxxbDao")
public class SyrkJzrkxxbDao extends BaseDaoImpl {

	public void insert(SyrkJzrkxxb entity) {
		entity.setXmhyjp(queryPy(entity.getXm()));
		entity.setXmhypy(queryPyqp(entity.getXm()));
		insert("SyrkJzrkxxb.save", entity);
	}

	public void update(SyrkJzrkxxb entity) {
		update("SyrkJzrkxxb.update", entity);
	}

	public void delete(SyrkJzrkxxb entity) {
		update("SyrkJzrkxxb.delete", entity);
	}

	public SyrkJzrkxxb queryById(String id) {
		return (SyrkJzrkxxb) queryForObject("SyrkJzrkxxb.queryById", id);
	}
	
	public SyrkJzrkxxb queryByIdWithOutZxbz(String id) {
		return (SyrkJzrkxxb) queryForObject("SyrkJzrkxxb.queryByIdWithOutZxbz", id);
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
	public List<SyrkJzrkxxb> queryRyByLxdh(String lxdh,String ryid){
		Map<String,String> map =new  HashMap<String,String>();
		map.put("lxdh", lxdh);
		map.put("ryid", ryid);
		return queryForList("SyrkJzrkxxb.queryByLxdh", map);
	}
}
