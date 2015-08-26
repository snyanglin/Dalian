/**********************************************************************   
 * <p>文件名：DwBadwxxbDao.java </p>
 * <p>文件描述：保安单位信息
 * @project_name：sydw
 * @author yu_guangli@founder.com
 * @date 2015-06-6
 * @history
 * @department：研发部
 *
*/
package com.founder.sydw.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.sydw.bean.Dwbadwxxb;
import com.founder.sydw.bean.Dwhbxxb;
@Repository("dwBadwxxbDao")
public class DwBadwxxbDao extends BaseDaoImpl {
	/**
	 * @Title: queryBadwxxbByid 
	 * @描述: 查询单条 保安单位信息
	 * @作者: yu_guangli@founder.com 
	 * @参数: 传入参数定义 
	 * @日期：  2015-6-6 下午1:28:39 
	 * @返回值: Dwbadwxxb    返回类型 
	 */
	public Dwbadwxxb queryBadwxxbByid(Dwbadwxxb entity) {
		Dwbadwxxb returnValue = null;
		List<?> list = queryForList("Dwbadwxxb.query", entity);
		if (list != null && list.size() > 0) {
			returnValue = (Dwbadwxxb) list.get(0);
		}
		return returnValue;
	}

	/**
	 * @Title: saveBadwxxb 
	 * @描述: 保存保安单位信息
	 * @作者: yu_guangli@founder.com 
	 * @参数: 传入参数定义 
	 * @日期：  2015-6-6 下午1:28:39 
	 * @返回值: void    返回类型 
	 */
	public void saveBadwxxb(Dwbadwxxb entity) {
		super.insert("Dwbadwxxb.insertBadwxxb", entity);
	}

	/**
	 * @Title: updateBadwxxb 
	 * @描述: 修改保安单位信息
	 * @作者: yu_guangli@founder.com 
	 * @参数: 传入参数定义 
	 * @日期：  2015-6-6 下午1:28:39 
	 * @返回值: void    返回类型 
	 */
	public void updateBadwxxb(Dwbadwxxb entity) {
		super.update("Dwbadwxxb.updateBadwxxb", entity);
	}
	
	/**
	 * @Title: badwxxb_query 
	 * @描述: 查询单条 保安单位信息
	 * @作者: yu_guangli@founder.com 
	 * @参数: 传入参数定义 
	 * @日期：  2015-6-6 下午1:28:39 
	 * @返回值: Dwbadwxxb    返回类型 
	 */
	public Dwbadwxxb badwxxb_query(Map<String, Object> map) {
		return  (Dwbadwxxb)queryForObject("Dwbadwxxb.badwxxb_query", map);
	}


}
