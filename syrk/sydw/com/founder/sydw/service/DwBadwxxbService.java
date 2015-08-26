/**********************************************************************   
 * <p>文件名：DwBadwxxbService.java </p>
 * <p>文件描述：保安单位信息
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
import com.founder.sydw.bean.Dwbadwxxb;

@TypeAnnotation("保安单位信息表")
public interface DwBadwxxbService {
	/**
	 * @Title: queryBadwxxbByid 
	 * @描述: 查询单条 保安单位信息
	 * @作者: yu_guangli@founder.com 
	 * @参数: 传入参数定义 
	 * @日期：  2015-6-6 下午1:28:39 
	 * @返回值: Dwbadwxxb    返回类型 
	 */
	public Dwbadwxxb queryBadwxxbByid(Dwbadwxxb entity);

	/**
	 * @Title: saveBadwxxb 
	 * @描述: 保存保安单位信息
	 * @作者: yu_guangli@founder.com 
	 * @参数: 传入参数定义 
	 * @日期：  2015-6-6 下午1:28:39 
	 * @返回值: void    返回类型 
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void saveBadwxxb(Dwbadwxxb entity, SessionBean sessionBean);

	/**
	 * @Title: updateBadwxxb 
	 * @描述: 修改保安单位信息
	 * @作者: yu_guangli@founder.com 
	 * @参数: 传入参数定义 
	 * @日期：  2015-6-6 下午1:28:39 
	 * @返回值: void    返回类型 
	 */
	@MethodAnnotation(value = "修改", type = logType.update)
	public void updateBadwxxb(Dwbadwxxb entity, SessionBean sessionBean);

}
