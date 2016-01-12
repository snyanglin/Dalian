package com.founder.zdrygl.base.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.zdrygl.base.model.ZdryQbxxb;


/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.base.dao.ZdryQbxxbDao.java]  
 * @ClassName:    [ZdryQbxxbDao]   
 * @Description:  [情报重点人员DAO]   
 * @Author:       [zhang.hai@founder.com.cn]  
 * @CreateDate:   [2015年12月25日 上午10:17:14]   
 * @UpdateUser:   [ZhangHai(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年12月25日 上午10:17:14，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("zdryQbxxbDao")
public class ZdryQbxxbDao extends BaseDaoImpl {

	public void save(ZdryQbxxb entity) {
		insert("ZdryQbxxb.save", entity);
	}
	
	public void update(ZdryQbxxb entity) {
		update("ZdryQbxxb.update", entity);
	}

	/**
	 * 
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return    设定文件
	 * @return ZdryQbxxb    返回类型
	 * @throw
	 */
	public ZdryQbxxb queryById(String id) {
		if (StringUtils.isBlank(id)) {
			return null;
		} else {
			ZdryQbxxb entity=new ZdryQbxxb();
			entity.setId(id);
			return (ZdryQbxxb) queryForObject("ZdryQbxxb.queryByEntity", entity);
		}
	}
	
	/**
	 * 
	 * @Title: queryList
	 * @Description: 查询情报重点人员列表
	 * @param @param entity
	 * @param @param page
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryList(ZdryQbxxb entity, EasyUIPage page) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		
		
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) {
			sort = "id";
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("entity", entity);
		
		
		page.setTotal((Integer)queryForObject("ZdryQbxxb.queryCount", map)==null?0:(Integer)queryForObject("ZdryQbxxb.queryCount", map));
		page.setRows(queryForList("ZdryQbxxb.query", map));
		return page;
	}
	
	
	/**
	 * 
	 * @Title: queryViewByMap
	 * @Description: TODO(重点人员详情页面展示用)
	 * @param @param map
	 * @param @return    设定文件
	 * @return ZdryQbxxb    返回类型
	 * @throw
	 */
	public ZdryQbxxb queryViewByMap(Map<String, Object> map) {
		return (ZdryQbxxb)queryForObject("ZdryQbxxb.queryViewByMap", map);
	}
	/**
	 * 
	 * @Title: queryByGmsfhm
	 * @Description: TODO(通过省份证验证是否已存在情报人员)
	 * @param @param gmsfhm
	 * @param @return    设定文件
	 * @return ZdryQbxxb    返回类型
	 * @throws
	 */
	public ZdryQbxxb queryByGmsfhm(String gmsfhm){		
		ZdryQbxxb entity=new ZdryQbxxb();
	    entity.setGmsfhm(gmsfhm);
		return (ZdryQbxxb) queryForObject("ZdryQbxxb.queryByEntity", entity);		
	}
	
}
