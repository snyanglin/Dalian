package com.founder.qbld.service;

import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.utils.EasyUIPage;
import com.founder.qbld.bean.WsRecord;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.service.WsService.java]  
 * @ClassName:    [WsService]   
 * @Description:  [ws记录表服务]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-7-20 上午9:36:09]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-7-20 上午9:36:09，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@TypeAnnotation("ws记录表服务")
public interface WsService {

	/**
	 * @Title: queryWsList
	 * @Description: TODO(ws记录表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryWsList(EasyUIPage page, WsRecord entity);
	
	/**
	 * @Title: queryWsListCount
	 * @Description: TODO(ws记录表总数查询)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return long    返回类型
	 * @throws
	 */
	public long queryWsListCount(WsRecord entity);
	
	
}
