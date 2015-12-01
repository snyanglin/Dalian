/**********************************************************************   
 * <p>文件名：ZdryJsmbpzbService.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk_syrk
 * @author xu_wenjun@founder.com.cn 
 * @date 2015-3-13 上午8:58:55 
 * @history
 * @department：研发部
 *
*/
package com.founder.zdry.service;

import java.util.List;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zdry.bean.ZdryJsmbpzb;

/******************************************************************************
 * @Package:      [com.founder.zdry.service.ZdryJsmbpzbService.java]  
 * @ClassName:    [ZdryJsmbpzbService]   
 * @Description:  [重点人员纪实模板配置表]   
 * @Author:       [xu_wenjun@founder.com.cn]  
 * @CreateDate:   [2015-3-13 上午8:58:55]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-3-13 上午8:58:55，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */

public interface ZdryJsmbpzbService {
	
	/**
	 * 
	 * @Title: insert
	 * @Description: 保存
	 * @param @param entity    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void insert(ZdryJsmbpzb entity, SessionBean sessionBean);
	
	/**
	 * 
	 * @Title: queryById
	 * @Description: 查询[根据主键]
	 * @param @param id
	 * @param @return    设定文件
	 * @return ZdryJsmbpzb    返回类型
	 * @throws
	 */
	public ZdryJsmbpzb queryById(String id);
	
	/**
	 * 
	 * @Title: update
	 * @Description: 修改
	 * @param @param entity
	 * @param @return    设定文件
	 * @return int    返回类型
	 * @throws
	 */
	public int update(ZdryJsmbpzb entity, SessionBean sessionBean);
	
	/**
	 * 
	 * @Title: delete
	 * @Description: 注销
	 * @param @param id
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void delete(ZdryJsmbpzb entity, SessionBean sessionBean);
	
	/**
	 * 
	 * @Title: setDefault
	 * @Description: 设置【默认】
	 * 1.将该类型其他模板设为【非默认】
	 * 2.将该类型该模板设为【默认】
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void setDefault(ZdryJsmbpzb entity, SessionBean sessionBean);
	
	/**
	 * 
	 * @Title: queryList
	 * @Description: 查询列表
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryList(EasyUIPage page, ZdryJsmbpzb entity);
	
	/**
	 * 
	 * @Title: queryForList
	 * @Description: 根据条件查询
	 * @param @param entity
	 * @param @return    设定文件
	 * @return List<ZdryJsmbpzb>    返回类型
	 * @throws
	 */
	public List<ZdryJsmbpzb> queryForList(String zdrygllxdm);
	
	/**
	 * 
	 * @Title: queryDefault
	 * @Description: 查询【默认】(一个类型:单条)
	 * @param @param zdrygllxdm
	 * @param @return    设定文件
	 * @return ZdryJsmbpzb    返回类型
	 * @throws
	 */
	public ZdryJsmbpzb queryDefault(String zdrygllxdm);
	
	/**
	 * 
	 * @Title: queryDefaultList
	 * @Description: 查询【默认】(全部类型:多条)
	 * @param @param zdrygllxdm
	 * @param @return    设定文件
	 * @return List<ZdryJsmbpzb>    返回类型
	 * @throws
	 */
	public List<ZdryJsmbpzb> queryDefaultList();

}
