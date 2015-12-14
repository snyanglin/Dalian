package com.founder.ywxt.service;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.syrkgl.bean.SyrkSyrkxxzb;
import com.founder.syrkgl.vo.SyrkAddVO;
import com.founder.ywxt.bean.Ywxtsfqypzb;


/******************************************************************************
 * @Package:      [com.founder.ywxt.service.YwxtsfqypzService.java]  
 * @ClassName:    [YwxtsfqypzService]   
 * @Description:  [业务协同是否启用配置service]   
 * @Author:       [cong_rihong@founder.com.cn]  
 * @CreateDate:   [2015-11-5 下午3:37:11]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-11-5 下午3:37:11，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
public interface YwxtsfqypzService {

	/**
	 * 根据协同类型查询
	 * @Title: queryByYwxtlx
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param ywxtlx
	 * @param @return    设定文件
	 * @return Ywxtsfqypzb    返回类型
	 * @throws
	 */
	public Ywxtsfqypzb queryByYwxtlx(String ywxtlx);
	
	/**
	 * 根据id查询
	 * @Title: queryById
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param id
	 * @param @return    设定文件
	 * @return Ywxtsfqypzb    返回类型
	 * @throws
	 */
	public Ywxtsfqypzb queryById(String id);
	
	/**
	 * 查询列表
	 * @Title: queryList
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param entity
	 * @param @param page
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryList(Ywxtsfqypzb entity, EasyUIPage page);
	
	/**
	 * 新增
	 * @Title: save
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void save(Ywxtsfqypzb entity, SessionBean sessionBean);

	/**
	 * 保存
	 * @Title: update
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void update(Ywxtsfqypzb entity, SessionBean sessionBean);
	
	/**
	 * 注销
	 * @Title: delete
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void delete(Ywxtsfqypzb entity, SessionBean sessionBean);

}
