package com.founder.zdrygl.base.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.zdrygl.base.model.ZdryQbywb;


/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.base.dao.ZdryQbywbDao.java]  
 * @ClassName:    [ZdryQbywbDao]   
 * @Description:  [情报重点人员业务表DAO]   
 * @Author:       [zhang.hai@founder.com.cn]  
 * @CreateDate:   [2015年12月25日 上午10:17:14]   
 * @UpdateUser:   [ZhangHai(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年12月25日 上午10:17:14，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("ZdryQbywbDao")
public class ZdryQbywbDao extends BaseDaoImpl {

	public void save(ZdryQbywb entity) {
		insert("ZdryQbywb.save", entity);
	}
	
	/**
	 * 
	 * @Title: queryListByZjhm
	 * @Description: TODO(根据证件号码查询记录列表，按时间倒序排列)
	 * @param @param zjhm
	 * @param @return    设定文件
	 * @return List<ZdryQbywb>    返回类型
	 * @throw
	 */
	public EasyUIPage queryListByZjhm(String zjhm,EasyUIPage page,ZdryQbywb entity) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("begin", page.getBegin());
			map.put("end", page.getEnd());
			
			String sort = page.getSort();
			String order = page.getOrder();
			if (StringUtils.isBlank(sort)) {
				sort = "XT_CJSJ";
				order = "DESC";
			}
			map.put("sort", sort);
			map.put("order", order);
			map.put("entity", entity);
			
			//增加身份证号码 key-value
			map.put("gmsfhm", zjhm);
			
			page.setRows(queryForList("ZdryQbywb.queryListByZjhm",map));
			page.setTotal((Integer) queryForObject("ZdryQbywb.queryListCountByZjhm", map));
			return page;
	}

}
