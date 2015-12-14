package com.founder.gzjk.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.gzjk.bean.Gzltjb;
import com.founder.gzjk.vo.GzltjVo;
@Repository("gzltjbDao")
public class GzltjbDao extends BaseDaoImpl {
 
	
	
	public void save(Gzltjb entity){
		insert("gzltjb.save", entity);
	}
	/**
	 * 常住人口（人户一致/人户分离）工作量统计
	 * @param map
	 * @return
	 */
	public List<GzltjVo>  czrkTj(Map<String,String> map){
		return queryForList("gzltjb.queryCzrkGzltj", map);
	}
	/**
	 * 非常住人口 工作量统计
	 * @return
	 */
	public List<GzltjVo>  syrkTj(Map<String,String> map){
		return queryForList("gzltjb.querySyrkGzltj", map);
	}

	/**
	 * 出租房屋工作量统计
	 * @return
	 */
	public  List<GzltjVo>  czfwTj(Map<String,String> map){
		return queryForList("gzltjb.queryCzfwGzltj", map);

	}
	/**
	 * 承租人工作量统计
	 * @return
	 */
	public  List<GzltjVo>  czrTj(Map<String,String> map){
		return queryForList("gzltjb.queryCzrGzltj", map);

	}
	/**
	 * 单位基本信息工作量统计
	 * @return
	 */
	public  List<GzltjVo>  sydwTj(Map<String,String> map){
		return queryForList("gzltjb.queryDwGzltj", map);

	}	
	/**
	 * 从业人员工作量统计
	 * @return
	 */
	public  List<GzltjVo>  cyryTj(Map<String,String> map){
		return queryForList("gzltjb.queryDwCyryGzltj", map);

	}
	
	public long queryCount(Map<String,String> map){
		return (Long)queryForObject("gzltjb.queryCount",map);
	}
	
	public  List<Gzltjb>  queryGzltj(Map<String,String> map){
		return queryForList("gzltjb.queryGzltj", map);

	}
	
	public Gzltjb queryGzltjForKh(Map<String,String> map){
		return (Gzltjb)queryForObject("gzltjb.queryGzltjForKh", map);
	}
	
	
	
	/**
	 * 常住人口（人户一致/人户分离）工作量统计
	 * @param map
	 * @return
	 */
	public GzltjVo  czrkTjByZrq(Map<String,String> map){
		return (GzltjVo) queryForObject("gzltjbBcZrq.queryCzrkGzltj", map);
	}
	/**
	 * 非常住人口 工作量统计
	 * @return
	 */
	public GzltjVo syrkTjByZrq(Map<String,String> map){
		return (GzltjVo) queryForObject("gzltjbBcZrq.querySyrkGzltj", map);
	}

	/**
	 * 出租房屋工作量统计
	 * @return
	 */
	public GzltjVo czfwTjByZrq(Map<String,String> map){
		return (GzltjVo) queryForObject("gzltjbBcZrq.queryCzfwGzltj", map);

	}
	/**
	 * 承租人工作量统计
	 * @return
	 */
	public  GzltjVo czrTjByZrq(Map<String,String> map){
		return (GzltjVo) queryForObject("gzltjbBcZrq.queryCzrGzltj", map);

	}
	/**
	 * 单位基本信息工作量统计
	 * @return
	 */
	public  GzltjVo  sydwTjByZrq(Map<String,String> map){
		return (GzltjVo) queryForObject("gzltjbBcZrq.queryDwGzltj", map);

	}	
	/**
	 * 从业人员工作量统计
	 * @return
	 */
	public GzltjVo cyryTjByZrq(Map<String,String> map){
		return (GzltjVo) queryForObject("gzltjbBcZrq.queryDwCyryGzltj", map);

	}
}
