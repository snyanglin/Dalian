package com.founder.zdrygl.base.service;

import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zdrygl.base.model.ZdryDtjsClxxb;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.service.ZdryDtjsClxxbService.java]  
 * @ClassName:    [ZdryService]   
 * @Description:  [重点人员上访信息]   
 * @Author:       [cong_rihong@founder.com.cn]  
 * @CreateDate:   [2015-12-14 上午9:44:29]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-12-14 上午9:44:29，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@TypeAnnotation("动态纪实车辆信息服务")
public interface ZdryDtjsClxxbService {


	/**
	 * @Title: queryList
	 * @Description: TODO(涉稳信息查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryList(EasyUIPage page, ZdryDtjsClxxb entity);	
	

	public String save(ZdryDtjsClxxb entity,SessionBean sessionBean);
	
	
	public ZdryDtjsClxxb queryById(String id);
	
	
	public void delete(ZdryDtjsClxxb entity,SessionBean sessionBean);

	
	public String update(ZdryDtjsClxxb entity,SessionBean sessionBean);



	

}
