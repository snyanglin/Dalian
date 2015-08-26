/**********************************************************************   
 * <p>文件名：DwbaycyqkxxbService.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author liang_lihe@founder.com.cn 
 * @date 2015-7-9 上午8:58:01 
 * @history
 * @department：研发部
 *
*/
package com.founder.sydw.service;

import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.sydw.bean.Dwbacyqkxxb;
import com.founder.sydw.bean.DwjbxxbBay;

/******************************************************************************
 * @Package:      [com.founder.sydw.service.DwbaycyqkxxbService.java]  
 * @ClassName:    [DwbaycyqkxxbService]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [liang_lihe@founder.com.cn]  
 * @CreateDate:   [2015-7-9 上午8:58:01]   
 * @UpdateUser:   [lk(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-7-9 上午8:58:01，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@TypeAnnotation("保安员从业情况")
public interface DwbaycyqkxxbService {
	
	/**
	 * 
	 * @Title: query
	 * @Description: 查询单条记录
	 * @param id
	 * @return
	 * @return Dwbacyqkxxb返回类型
	 * @throws
	 */
	public Dwbacyqkxxb query(String id);
	
	/**
	 * 
	 * @Title: save
	 * @Description: 增加保安员从业情况信息
	 * @param entity
	 * @param sessionBean
	 * @return void返回类型
	 * @throws
	 */
	public void save(Dwbacyqkxxb entity, SessionBean sessionBean);
	
	
	/**
	 * 
	 * @Title: update
	 * @Description: 修改保安员从业情况信息
	 * @param entity
	 * @param sessionBean
	 * @return void返回类型
	 * @throws
	 */
	public void update(Dwbacyqkxxb entity, SessionBean sessionBean);	

}
