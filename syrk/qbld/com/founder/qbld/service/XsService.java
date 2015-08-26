package com.founder.qbld.service;

import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.utils.EasyUIPage;
import com.founder.qbld.bean.Xscjb;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.service.XsService.java]  
 * @ClassName:    [XsService]   
 * @Description:  [线索采集服务接口]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-5-4 上午11:28:09]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-4 上午11:28:09，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@TypeAnnotation("线索采集表")
public interface XsService {

	/**
	 * @Title: queryXsList
	 * @Description: TODO(线索列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryXsList(EasyUIPage page, Xscjb entity);
	
	/**
	 * @Title: queryLkyjzl
	 * @Description: TODO(根据id获取线索信息详情)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Lkyjzlb    返回类型
	 * @throws
	 */
	public Xscjb queryXs(Xscjb entity);
	
	/**
	 * @Title: saveXscjb
	 * @Description: TODO(保存线索采集表)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveXscjb(Xscjb entity);
	
	
}
