/**********************************************************************   
 * <p>文件名：DwJfdwxxbService.java </p>
 * <p>文件描述：技防单位信息
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
import com.founder.sydw.bean.Dwjfdwxxb;

@TypeAnnotation("技防单位信息表")
public interface DwJfdwxxbService {
	/**
	 * @Title: queryJfdwxxbByid 
	 * @描述: 查询技防单位信息
	 * @作者: yu_guangli@founder.com 
	 * @参数: 传入参数定义 
	 * @日期：  2015-6-6 下午1:28:39 
	 * @返回值: Dwjfdwxxb    返回类型 
	 */
	public Dwjfdwxxb queryJfdwxxbByid(Dwjfdwxxb entity);

	/**
	 * @Title: saveJfdwxxb 
	 * @描述: 保存技防单位信息
	 * @作者: yu_guangli@founder.com 
	 * @参数: 传入参数定义 
	 * @日期：  2015-6-6 下午1:28:39 
	 * @返回值: void    返回类型 
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void saveJfdwxxb(Dwjfdwxxb entity, SessionBean sessionBean);

	/**
	 * @Title: updateJfdwxxb 
	 * @描述: 修改技防单位信息
	 * @作者: yu_guangli@founder.com 
	 * @参数: 传入参数定义 
	 * @日期：  2015-6-6 下午1:28:39 
	 * @返回值: void    返回类型 
	 */
	@MethodAnnotation(value = "修改", type = logType.update)
	public void updateJfdwxxb(Dwjfdwxxb entity, SessionBean sessionBean);

}
