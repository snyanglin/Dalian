package com.founder.qbld.service;

import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.utils.EasyUIPage;
import com.founder.qbld.bean.Ryxsb;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.service.RyxsService.java]  
 * @ClassName:    [RyxsService]   
 * @Description:  [人员写实接口]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-5-5 上午9:23:48]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-5 上午9:23:48，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@TypeAnnotation("人员写实表")
public interface RyxsService {

	/**
	 * @Title: queryRyxsList
	 * @Description: TODO(人员写实列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryRyxsList(EasyUIPage page, Ryxsb entity);
	
	/**
	 * @Title: queryRyxs
	 * @Description: TODO(根据id获取人员写实详情)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Ryxsb    返回类型
	 * @throws
	 */
	public Ryxsb queryRyxs(Ryxsb entity);
	
	/**
	 * @Title: saveRyxsb
	 * @Description: TODO(人员写实表)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveRyxsb(Ryxsb entity);
	
	
}
