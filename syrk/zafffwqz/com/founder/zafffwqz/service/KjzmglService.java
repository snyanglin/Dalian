/**********************************************************************   
 * <p>文件名：KjzmglService.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author wu.w@founder.com.cn 
 * @date 2015-5-12 下午1:44:52 
 * @history
 * @department：研发部
 *
*/
package com.founder.zafffwqz.service;

import java.util.Map;

import com.founder.zafffwqz.bean.KjzmglBean;

/******************************************************************************
 * @Package:      [com.founder.zafffwqz.service.KjzmglService.java]  
 * @ClassName:    [KjzmglService]   
 * @Description:  [开具证明服务类]   
 * @Author:       [wu.w@founder.com.cn]  
 * @CreateDate:   [2015-5-12 下午1:44:52]   
 * @UpdateUser:   [way(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-12 下午1:44:52，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 * @review      : tian_chengwei@founder.com.cn
 * @reviewDate  : 20150604 
 * @Version:      [v1.0] 
 */
public interface KjzmglService {
	/**
	 * 
	 * @Title: query
	 * @Description: 查询人员是否在对应资源库中有相关资料
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Map<String,String[]>    返回类型
	 * @throws
	 */
	public Map<String, String[]> query(KjzmglBean entity);
}
