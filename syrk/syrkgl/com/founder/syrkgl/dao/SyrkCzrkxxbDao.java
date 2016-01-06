package com.founder.syrkgl.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.syrkgl.bean.SyrkCzrkxxb;

/**
 * ****************************************************************************
 * @Package:      [com.founder.syrkgl.dao.SyrkCzrkxxbDao.java]  
 * @ClassName:    [SyrkCzrkxxbDao]   
 * @Description:  [常住人口DAO]   
 * @Author:       [weiwen]  
 * @CreateDate:   [2015-4-3 下午3:13:49]   
 * @UpdateUser:   [weiwen]   
 * @UpdateDate:   [2015-4-3 下午3:13:49，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("syrkCzrkxxbDao")
public class SyrkCzrkxxbDao extends BaseDaoImpl {

	public SyrkCzrkxxb queryById(String id) {
		return (SyrkCzrkxxb) queryForObject("SyrkCzrkxxb.queryById", id);
	}
	
	
	public SyrkCzrkxxb queryByIdWithOutZxbz(String id) {
		return (SyrkCzrkxxb) queryForObject("SyrkCzrkxxb.queryByIdWithOutZxbz", id);
	}

	public void insert(SyrkCzrkxxb entity) {
		entity.setXmhyjp(queryPy(entity.getXm()));
		entity.setXmhypy(queryPyqp(entity.getXm()));
		insert("SyrkCzrkxxb.save", entity);
	}

	public void update(SyrkCzrkxxb entity) {
		entity.setXmhyjp(queryPy(entity.getXm()));
		entity.setXmhypy(queryPyqp(entity.getXm()));
		update("SyrkCzrkxxb.update", entity);
	}

	public void delete(SyrkCzrkxxb entity) {
		update("SyrkCzrkxxb.delete", entity);
	}

	/***
	 * 
	 * @Title: queryCzrkByZjhmAndZjdm
	 * @Description: TODO( 根据证件信息查常住人口信息)
	 * @author wu_chunhui@founder.com
	 * @param @param map
	 * @param @return    设定文件
	 * @return SyrkSyrkxxzb    返回类型
	 * @throws
	 */
	public SyrkCzrkxxb queryCzrkByZjhmAndZjdm(Map<String,String> map){
		return (SyrkCzrkxxb) queryForObject("SyrkCzrkxxb.queryCzrkByZjhmAndZjdm", map);
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
	public List<SyrkCzrkxxb> queryRyByLxdh(String lxdh){
		Map<String,String> map =new  HashMap<String,String>();
		map.put("lxdh", lxdh);
		return queryForList("SyrkCzrkxxb.queryByLxdh", map);
	}
}
