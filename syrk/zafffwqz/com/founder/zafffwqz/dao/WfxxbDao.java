package com.founder.zafffwqz.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.StringUtils;
import com.founder.service.contextsearch.department.bean.DwContextCombo;
import com.founder.service.contextsearch.department.bean.DwContextCondition;
import com.founder.zafffwqz.bean.ZaffWfxx;

/******************************************************************************
 * @Package:      [com.founder.zafffwqz.dao.WfxxbDao.java]  
 * @ClassName:    [WfxxbDao]   
 * @Description:  [物防DAO层：主要处理属性表操作]   
 * @Author:       [tian_chengwei@founder.com.cn]  
 * @CreateDate:   [2015-5-26 下午4:48:49]   
 * @UpdateUser:   [lk(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-26 下午4:48:49，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@Repository("wfxxbDao")
public class WfxxbDao extends BaseDaoImpl {
	/**
	 * 
	 * @Title: insertWfxxb
	 * @Description: TODO(插入操作)
	 * @param @param entity    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void insertWfxxb(ZaffWfxx entity){
		super.insertForObject("Wfxxb.save", entity);
	}
	/**
	 * 
	 * @Title: updateWfxxb
	 * @Description: TODO(修改操作)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return int    返回类型
	 * @throws
	 */
	public int updateWfxxb(ZaffWfxx entity){
		return super.update("Wfxxb.updateWfxxb", entity);
	}
	/**
	 * 
	 * @Title: queryWfxxbById
	 * @Description: TODO(根据ID值进行查询)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return ZaffWfxx    返回类型
	 * @throws
	 */
	public ZaffWfxx queryWfxxbById(ZaffWfxx entity) {
		return (ZaffWfxx) super.queryForObject("Wfxxb.queryById", entity);
	}
	
	
	public List<DwContextCombo> searchXqContext(DwContextCondition condition) {
		List<DwContextCombo> list = queryForList(
				"Wfxxb.searchXqContext", condition);
		return list;
	}

	
}
