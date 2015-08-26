/**********************************************************************   
 * <p>文件名：AqffXcZatbService.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author wu.w@founder.com.cn 
 * @date 2015-5-25 上午9:52:34 
 * @history
 * @department：研发部
 *
*/
package com.founder.aqff.service;

import com.founder.aqff.bean.AqffXcZatbxxb;
import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;

/******************************************************************************
 * @Package:      [com.founder.aqff.service.AqffXcZatbService.java]  
 * @ClassName:    [AqffXcZatbService]   
 * @Description:  [治安通报 service]   
 * @Author:       [wu.w@founder.com.cn]  
 * @CreateDate:   [2015-5-25 上午9:52:34]   
 * @UpdateUser:   [way(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-25 上午9:52:34，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 * @review      : tian_chengwei@founder.com.cn
 * @reviewDate  : 20150604
 */
@TypeAnnotation("安全防范-治安通报")
public interface AqffXcZatbService {
	/**
	 * @Title: query
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage query(EasyUIPage page,AqffXcZatbxxb entity);
	
	/**
	 * @Title: save
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "新增安全防范-治安通报", type = logType.insert)
	public void saveZatb(AqffXcZatbxxb entity, SessionBean sessionBean);
	
	/**
	 * @Title: modify
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "更改安全防范-治安通报", type = logType.update)
	public void updateZatb(AqffXcZatbxxb entity, SessionBean sessionBean);
	
	/**
	 * @Title: delete
	 * @param @param id
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "注销安全防范-治安通报", type = logType.delete)
	public void deleteZatb(String id, SessionBean sessionBean);
}
