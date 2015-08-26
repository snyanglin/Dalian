/**********************************************************************   
 * <p>文件名：DwhbxxbService.java </p>
 * <p>文件描述：单位环保行业信息
 * @project_name：sydw
 * @author yu_guangli@founder.com
 * @date 2015-06-6
 * @history
 * @department：研发部
 *
*/
package com.founder.sydw.service;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.base.entity.SessionBean;
import com.founder.sydw.bean.Dwhbxxb;

@TypeAnnotation("单位环保行业信息表")
public interface DwhbxxbService {
	/**
	 * @Title: queryDwhbxxbByid 
	 * @描述: 查询单条 环保单位信息
	 * @作者: yu_guangli@founder.com 
	 * @参数: 传入参数定义 
	 * @日期：  2015-6-6 下午1:28:39 
	 * @返回值: Dwhbxxb    返回类型 
	 */
	public Dwhbxxb queryDwhbxxbByid(Dwhbxxb entity);
	/**
	 * @Title: saveDwhbxxb 
	 * @描述: 保存 环保单位信息
	 * @作者: yu_guangli@founder.com 
	 * @参数: 传入参数定义 
	 * @日期：  2015-6-6 下午1:28:39 
	 * @返回值: void    返回类型 
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void saveDwhbxxb(Dwhbxxb entity, SessionBean sessionBean);
	/**
	 * @Title: updateDwhbxxb 
	 * @描述: 修改环保单位信息
	 * @作者: yu_guangli@founder.com 
	 * @参数: 传入参数定义 
	 * @日期：  2015-6-6 下午1:28:39 
	 * @返回值: void    返回类型 
	 */
	@MethodAnnotation(value = "修改", type = logType.update)
	public void updateDwhbxxb(Dwhbxxb entity, SessionBean sessionBean);

}
