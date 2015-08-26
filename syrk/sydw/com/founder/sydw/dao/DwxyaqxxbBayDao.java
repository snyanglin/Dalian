/**********************************************************************   
 * <p>文件名：DwxyaqxxbBayBayDao.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author wu_chunhui@founder.com.cn 
 * @date 2014-12-5 下午12:15:25 
 * @history
 * @department：研发部
 *
*/
package com.founder.sydw.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.sydw.bean.DwjbxxbBay;
import com.founder.sydw.bean.XyaqxxbHxd;

/******************************************************************************
 * @Package:      [com.founder.sydw.dao.DwxyaqxxbBayBayDao.java]  
 * @ClassName:    [DwxyaqxxbBayBayDao]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [wu_chunhui@founder.com.cn]  
 * @CreateDate:   [2014-12-5 下午12:15:25]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2014-12-5 下午12:15:25，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@Repository("dwxyaqxxbBaydao")
public class DwxyaqxxbBayDao extends BaseDaoImpl {
	public DwjbxxbBay queryEntityById(String id) {
		return (DwjbxxbBay)queryForObject("DwxyaqxxbBay.dwxyaqxxbBay_queryById", id);
	}
	
	public DwjbxxbBay queryEntityByZjhm(String zjhm) {
		return (DwjbxxbBay)queryForObject("DwxyaqxxbBay.dwxyaqxxbBay_queryByZjhm", zjhm);
	}

	public void saveEntity(DwjbxxbBay entity) {
		super.insert("DwxyaqxxbBay.dwxyaqxxbBay_insert", entity);
	}

	public void updateEntity(DwjbxxbBay entity) {
		super.update("DwxyaqxxbBay.dwxyaqxxbBay_update", entity);
	}
	
	@SuppressWarnings("unchecked")
	public List<DwjbxxbBay> dwxyaqxxbBay(Map<String, Object> map) {
		return queryForList("DwxyaqxxbBay.dwxyaqxxbBay_query", map);
	}
	
	/**
	 *保安员
	 *time:2015-5-7 
	 *author：star
	 */
	public EasyUIPage bary_query_all(EasyUIPage page, String condition, String dwid) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			order = "asc";
		}
		map.put("sort", sort);
		map.put("order", order);
		if(!StringUtils.isBlank(condition)){
			map.put("condition", condition);
		}
		map.put("dwid", dwid);
		List<?> list = queryForList("DwxyaqxxbBay.bay_query_all", map);
		page.setTotal((int)bary_query_all_count(condition, dwid));
		page.setRows(list);
		return page;
	}
	
	public long bary_query_all_count(String condition, String dwid){
		Map<String, Object> map = new HashMap<String, Object>();
		if(!StringUtils.isBlank(condition)){
			map.put("condition", condition);
		}
		map.put("dwid", dwid);
		return (Integer) queryForObject("DwxyaqxxbBay.bay_query_all_count", map);
	}
}
