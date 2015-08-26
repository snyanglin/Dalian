/**********************************************************************   
 * <p>文件名：cyrydrrwmxbDao.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author wu_chunhui@founder.com.cn 
 * @date 2014-12-2 下午05:27:50 
 * @history
 * @department：研发部
 *
*/
package com.founder.sydw.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.sydw.bean.Cyrydrrwmxb;

/******************************************************************************
 * @Package:      [com.founder.sydw.dao.cyrydrrwmxbDao.java]  
 * @ClassName:    [cyrydrrwmxbDao]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [wu_chunhui@founder.com.cn]  
 * @CreateDate:   [2014-12-2 下午05:27:50]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2014-12-2 下午05:27:50，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@Repository("cyrydrrwmxbDao")
public class CyrydrrwmxbDao extends BaseDaoImpl {
	/***
	 * 
	 * @Title: query
	 * @Description: TODO(根据单位ID和人员ID查询已有任务)
	 * @param @param map
	 * @param @return    设定文件
	 * @return List<cyrydrrwmxb>    返回类型
	 * @throws
	 */
	public EasyUIPage query(EasyUIPage page,Map map) {
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (!StringUtils.isBlank(sort)) { // 默认排序
			map.put("sort", sort);
			map.put("order", order);
		}else{
			map.put("sort", "xt_lrsj");
			map.put("order", "desc");
		}
		page.setTotal((Integer) queryForObject("Cyrydrrwmxb.cyrydrrwmxb_queryCount", map));
		page.setRows(queryForList("Cyrydrrwmxb.cyrydrrwmxb_query", map));
		return page;
	}
	
	
	public void saveEntity (Cyrydrrwmxb entity){
		super.insert("Cyrydrrwmxb.cyrydrrwmxb_insert", entity);
	}
	
	@SuppressWarnings("unchecked")
	public List<Map<String, String>> cyrydrrwmxb_query_all_export(String rwid) {
		 List<Map<String, String>> list = queryForList("Cyrydrrwmxb.cyryxxb_query_all_export", rwid);
		 return list;
	}
}
