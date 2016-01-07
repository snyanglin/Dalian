package com.founder.zdrygl.base.service;

import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zdrygl.base.model.ZdryDtjsXsxxb;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.service.ZdryService.java]  
 * @ClassName:    [ZdryService]   
 * @Description:  [重点人员表相关服务接口]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-5-14 上午9:44:29]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-14 上午9:44:29，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@TypeAnnotation("重点人员动态记实服务")
public interface ZdryDtjsService {


	/**
	 * @Title: queryRyxsList
	 * @Description: TODO(人员写实列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryRyxsList(EasyUIPage page, ZdryDtjsXsxxb entity);	
	
	/**
	 * @Title: saveRyxsb
	 * @Description: TODO(人员写实表)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String saveDtjs(ZdryDtjsXsxxb entity,SessionBean sessionBean);
	
	
	public ZdryDtjsXsxxb queryXsjbxxById(String xsid);
	
	
	public void deleteDtjsXsjbxx(ZdryDtjsXsxxb entity,SessionBean sessionBean);

	
	public String updateDtjs(ZdryDtjsXsxxb entity,SessionBean sessionBean);



	

}
