/**********************************************************************   
 * <p>文件名：DwhbxxbDao.java </p>
 * <p>文件描述：环保单位信息
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
import com.founder.sydw.bean.Dwhbxxb;
@Repository("dwhbxxbDao")
public class DwhbxxbDao extends BaseDaoImpl {
	/**
	 * @Title: queryDwhbxxbByid 
	 * @描述: 查询单条 环保单位信息
	 * @作者: yu_guangli@founder.com 
	 * @参数: 传入参数定义 
	 * @日期：  2015-6-6 下午1:28:39 
	 * @返回值: Dwhbxxb    返回类型 
	 */
	public Dwhbxxb queryDwhbxxbByid(Dwhbxxb entity) {
		Dwhbxxb returnValue = null;
		List<?> list = queryForList("Dwhbxxb.query", entity);
		if (list != null && list.size() > 0) {
			returnValue = (Dwhbxxb) list.get(0);
		}
		return returnValue;
	}
	/**
	 * @Title: saveDwhbxxb 
	 * @描述: 保存 环保单位信息
	 * @作者: yu_guangli@founder.com 
	 * @参数: 传入参数定义 
	 * @日期：  2015-6-6 下午1:28:39 
	 * @返回值: void    返回类型 
	 */
	public void saveDwhbxxb(Dwhbxxb entity) {
		super.insert("Dwhbxxb.insertDwhbxxb", entity);
	}
	/**
	 * @Title: updateDwhbxxb 
	 * @描述: 修改环保单位信息
	 * @作者: yu_guangli@founder.com 
	 * @参数: 传入参数定义 
	 * @日期：  2015-6-6 下午1:28:39 
	 * @返回值: void    返回类型 
	 */
	public void updateDwhbxxb(Dwhbxxb entity) {
		super.update("Dwhbxxb.updateDwhbxxb", entity);
	}
	/**
	 * @Title: dwhbxxb_query 
	 * @描述: 查询单条 环保单位信息
	 * @作者: yu_guangli@founder.com 
	 * @参数: 传入参数定义 
	 * @日期：  2015-6-6 下午1:28:39 
	 * @返回值: Dwhbxxb    返回类型 
	 */
	public Dwhbxxb dwhbxxb_query(Map<String, Object> map) {
		return  (Dwhbxxb)queryForObject("Dwhbxxb.dwhbxxb_query", map);
	}


}
