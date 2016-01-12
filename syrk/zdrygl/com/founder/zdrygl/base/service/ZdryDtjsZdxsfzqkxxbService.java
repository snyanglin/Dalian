package com.founder.zdrygl.base.service;

import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zdrygl.base.model.ZdryDtjsZdxsfzqkxxb;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.service.ZdryService.java]  
 * @ClassName:    [ZdryService]   
 * @Description:  [重点人员上访信息]   
 * @Author:       [cong_rihong@founder.com.cn]  
 * @CreateDate:   [2015-12-9 上午9:44:29]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-12-9 上午9:44:29，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@TypeAnnotation("动态纪实上访信息服务")
public interface ZdryDtjsZdxsfzqkxxbService {


	/**
	 * @Title: queryList
	 * @Description: TODO(信息查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryList(EasyUIPage page, ZdryDtjsZdxsfzqkxxb entity);	
	
	/**
	 * @Title: save
	 * @Description: TODO(重大刑事犯罪前科)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String save(ZdryDtjsZdxsfzqkxxb entity,SessionBean sessionBean);
	
	
	public ZdryDtjsZdxsfzqkxxb queryById(String id);
	
	
	public void delete(ZdryDtjsZdxsfzqkxxb entity,SessionBean sessionBean);

	
	public String update(ZdryDtjsZdxsfzqkxxb entity,SessionBean sessionBean);



	

}
