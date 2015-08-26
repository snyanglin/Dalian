package com.founder.syrkgl.service;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.syrkgl.bean.RyJwryrczfb;
/**
 * @类名: RyJwryrczfService 
 * @描述: 境外人员日常走访 
 * @作者: zhang_guoliang@founder.com 
 * @日期: 2015-6-26 上午9:27:15 
 */
@TypeAnnotation("境外人员日常走访")
public interface RyJwryrczfbService {
	/**
	 * @Title: queryJwryRczf 
	 * @描述: 境外人员核实下发列表
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-6-15 下午5:30:09 
	 * @返回值: EasyUIPage    返回类型 
	 * @throws
	 */
	public EasyUIPage queryJwryRczf(EasyUIPage page,RyJwryrczfb entity);
	/**
	 * @Title: update 
	 * @描述: 境外人员日常走访更新
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-6-18 下午4:29:44 
	 * @返回值: void    返回类型 
	 * @throws
	 */
	public void update(RyJwryrczfb entity,SessionBean sessionBean);
}
