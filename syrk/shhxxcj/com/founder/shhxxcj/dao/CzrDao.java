package com.founder.shhxxcj.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.shhxxcj.bean.LesseeJZs;
import com.founder.shhxxcj.bean.LesseeZZs;

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
@Repository("czrDao")
public class CzrDao extends BaseDaoImpl {
	
	
	public void updateLesseeZZs(LesseeZZs entity) {
		update("LesseeZZs.updateLesseeZZs", entity);
	}
	public void updateLesseeJZs(LesseeJZs entity) {
		update("LesseeZZs.updateLesseeJZs", entity);
	}

	public EasyUIPage queryList(LesseeZZs entity, EasyUIPage page) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());

		map.put("entity", entity);

		page.setRows(queryForList("LesseeZZs.queryList", map));
		page.setTotal((Integer) queryForObject("LesseeZZs.queryCount", map));
		return page;
	}
	
	
	public LesseeZZs queryLesseeZZsById(String id){
		return (LesseeZZs)queryForObject("LesseeZZs.queryZZById", id);
	}
	
	public LesseeJZs queryLesseeJZsById(String id){
		return (LesseeJZs)queryForObject("LesseeZZs.queryJZById", id);
	}
	
}
