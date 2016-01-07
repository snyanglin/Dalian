package com.founder.zdrygl.base.service;

import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zdrygl.base.model.ZdryDtjsZtxxb;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.service.ZdryService.java]  
 * @ClassName:    [ZdryService]   
 * @Description:  [動態紀實 在逃信息接口]   
 * @Author:       [cong_rihong@founder.com.cn]  
 * @CreateDate:   [2015-12-7 上午9:44:29]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-12-7 上午9:44:29，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@TypeAnnotation("動態紀實在逃信息接口服務")
public interface ZdryDtjsZtxxbService {


	
	
	public EasyUIPage queryList(EasyUIPage page, ZdryDtjsZtxxb entity);	


}
