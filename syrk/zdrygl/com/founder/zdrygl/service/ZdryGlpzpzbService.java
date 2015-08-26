/**********************************************************************   
 * <p>文件名：ZdryGlpzpzbService.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk_syrk
 * @author xu_wenjun@founder.com.cn 
 * @date 2015-3-12 下午2:44:47 
 * @history
 * @department：研发部
 *
*/
package com.founder.zdrygl.service;

import java.util.List;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zdrygl.bean.ZdryGlpzpzb;

/******************************************************************************
 * @Package:      [com.founder.zdrygl.service.ZdryGlpzpzbService.java]  
 * @ClassName:    [ZdryGlpzpzbService]   
 * @Description:  [重点人员管理配置表]   
 * @Author:       [xu_wenjun@founder.com.cn]  
 * @CreateDate:   [2015-3-12 下午2:44:47]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-3-12 下午2:44:47，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */

public interface ZdryGlpzpzbService {
	
	/**
	 * 
	 * @Title: insert
	 * @Description: 保存
	 * @param @param entity    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void insert(ZdryGlpzpzb entity, SessionBean sessionBean);
	
	/**
	 * 
	 * @Title: queryById
	 * @Description: 查询[根据主键]
	 * @param @param id    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public ZdryGlpzpzb queryById(String id);
	
	/**
	 * 
	 * @Title: update
	 * @Description: 修改
	 * @param @param entity
	 * @param @return    设定文件
	 * @return int    返回类型
	 * @throws
	 */
	public int update(ZdryGlpzpzb entity, SessionBean sessionBean);
	
	/**
	 * 
	 * @Title: delete
	 * @Description: 注销
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void delete(ZdryGlpzpzb entity, SessionBean sessionBean);
	
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
	public EasyUIPage queryList(EasyUIPage page, ZdryGlpzpzb entity);
	
	/**
	 * 
	 * @Title: getKlglx
	 * @Description: 查询【列管】可选类型
	 * @param @param zdryzbId  重点人员总表id
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String getKlglx(String zdryzbId);
	
	/**
	 * 
	 * @Title: getKcglx
	 * @Description: 查询【撤管】可选类型(针对某一重点人员管理类型)
	 * @param @param zdrygllxdm  重点人员管理类型代码
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String getKcglx(String zdrygllxdm);
	
	/**
	 * 
	 * @Title: queryByZdrygllxdm
	 * @Description: 根据【重点人员管理类型代码】查询单条记录
	 * @param @param zdrygllxdm
	 * @param @return    设定文件
	 * @return ZdryGlpzpzb    返回类型
	 * @throws
	 */
	public ZdryGlpzpzb queryByZdrygllxdm(String zdrygllxdm);
	
	/**
	 * 
	 * @Title: queryByDtjszqdmNotNull
	 * @Description: 查询【动态纪实周期】不为空的记录
	 * @param @return    设定文件
	 * @return List<ZdryGlpzpzb>    返回类型
	 * @throws
	 */
	public List<ZdryGlpzpzb> queryByDtjszqdmNotNull();

}
