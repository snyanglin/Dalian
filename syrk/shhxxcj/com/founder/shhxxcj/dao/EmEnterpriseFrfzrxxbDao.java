package com.founder.shhxxcj.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.shhxxcj.bean.EmEnterpriseFrfzrxxb;
import com.founder.shhxxcj.bean.LesseeJZs;
import com.founder.shhxxcj.bean.LesseeZZs;


/******************************************************************************
 * @Package:      [com.founder.shhxxcj.dao.EmEnterpriseFrfzrxxbDao.java]  
 * @ClassName:    [EmEnterpriseFrfzrxxbDao]   
 * @Description:  [企业法人负责人dao]   
 * @Author:       [cong_rihong@founder.com.cn]  
 * @CreateDate:   [2015-11-23 下午3:53:43]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-11-23 下午3:53:43，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@Repository("emEnterpriseFrfzrxxbDao")
public class EmEnterpriseFrfzrxxbDao extends BaseDaoImpl {
	
	


	public EasyUIPage queryList(EmEnterpriseFrfzrxxb entity, EasyUIPage page) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());

		map.put("entity", entity);

		page.setRows(queryForList("EmEnterpriseFrfzrxxb.queryList", map));
		page.setTotal((Integer) queryForObject("EmEnterpriseFrfzrxxb.queryCount", map));
		return page;
	}
	
	

	
}
