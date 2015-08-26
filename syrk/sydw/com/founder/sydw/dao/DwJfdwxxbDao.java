/**********************************************************************   
 * <p>文件名：DwJfdwxxbDao.java </p>
 * <p>文件描述：技防单位信息
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
import com.founder.sydw.bean.Dwjfdwxxb;
@Repository("dwJfdwxxbDao")
public class DwJfdwxxbDao extends BaseDaoImpl {
	/**
	 * @Title: queryJfdwxxbByid 
	 * @描述: 查询技防单位信息
	 * @作者: yu_guangli@founder.com 
	 * @参数: 传入参数定义 
	 * @日期：  2015-6-6 下午1:28:39 
	 * @返回值: Dwjfdwxxb    返回类型 
	 */
	public Dwjfdwxxb queryJfdwxxbByid(Dwjfdwxxb entity) {
		Dwjfdwxxb returnValue = null;
		List<?> list = queryForList("Dwjfdwxxb.query", entity);
		if (list != null && list.size() > 0) {
			returnValue = (Dwjfdwxxb) list.get(0);
		}
		return returnValue;
	}
	/**
	 * @Title: saveJfdwxxb 
	 * @描述: 保存技防单位信息
	 * @作者: yu_guangli@founder.com 
	 * @参数: 传入参数定义 
	 * @日期：  2015-6-6 下午1:28:39 
	 * @返回值: void    返回类型 
	 */
	public void saveJfdwxxb(Dwjfdwxxb entity) {
		super.insert("Dwjfdwxxb.insertJfdwxxb", entity);
	}
	/**
	 * @Title: updateJfdwxxb 
	 * @描述: 修改技防单位信息
	 * @作者: yu_guangli@founder.com 
	 * @参数: 传入参数定义 
	 * @日期：  2015-6-6 下午1:28:39 
	 * @返回值: void    返回类型 
	 */
	public void updateJfdwxxb(Dwjfdwxxb entity) {
		super.update("Dwjfdwxxb.updateJfdwxxb", entity);
	}
	/**
	 * @Title: jfdwxxb_query 
	 * @描述: 查询技防单位信息
	 * @作者: yu_guangli@founder.com 
	 * @参数: 传入参数定义 
	 * @日期：  2015-6-6 下午1:28:39 
	 * @返回值: Dwjfdwxxb    返回类型 
	 */
	public Dwjfdwxxb jfdwxxb_query(Map<String, Object> map) {
		return  (Dwjfdwxxb)queryForObject("Dwjfdwxxb.jfdwxxb_query", map);
	}


}
