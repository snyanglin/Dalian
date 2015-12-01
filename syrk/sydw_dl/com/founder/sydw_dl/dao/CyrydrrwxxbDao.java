/**********************************************************************   
 * <p>文件名：CyrydrrwxxbDao.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author wu_chunhui@founder.com.cn 
 * @date 2014-11-26 下午3:38:01 
 * @history
 * @department：研发部
 *
*/
package com.founder.sydw_dl.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.sydw_dl.bean.Cyrydrrwxxb;

/******************************************************************************
 * @Package:      [com.founder.sydw_dl.dao.CyrydrrwxxbDao.java]  
 * @ClassName:    [CyrydrrwxxbDao]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [wu_chunhui@founder.com.cn]  
 * @CreateDate:   [2014-11-26 下午3:38:01]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2014-11-26 下午3:38:01，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@Repository("cyrydrrwxxbDao")
public class CyrydrrwxxbDao extends BaseDaoImpl {
	
	/***
	 * 
	 * @Title: query
	 * @Description: TODO(根据单位ID和人员ID查询已有任务)
	 * @param @param map
	 * @param @return    设定文件
	 * @return List<Cyrydrrwxxb>    返回类型
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
		page.setTotal((Integer) queryForObject("Cyrydrrwxxb.cyrydrrwxxb_queryCount", map));
		page.setRows(queryForList("Cyrydrrwxxb.cyrydrrwxxb_query", map));
		return page;
	}
	
	
	public void saveEntity (Cyrydrrwxxb entity){
		super.insert("Cyrydrrwxxb.cyrydrrwxxb_insert", entity);
	}
	
	public void updateEntity (Cyrydrrwxxb entity){
		super.update("Cyrydrrwxxb.cyrydrrwxxb_update", entity);
	}
	
	
	public Cyrydrrwxxb queryByRwid (String rwid){
		return (Cyrydrrwxxb) super.queryForObject("Cyrydrrwxxb.queryByRwid", rwid);
	}
	
}
