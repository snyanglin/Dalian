/**********************************************************************   
 * <p>文件名：SerialNumberService.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author wu_chunhui@founder.com.cn 
 * @date 2014-12-18 上午11:30:24 
 * @history
 * @department：研发部
 *
*/
package com.founder.service.serialNumberService.service;

import com.founder.framework.base.entity.SessionBean;

/******************************************************************************
 * @Package:      [com.founder.service.serialNumberService.service.SerialNumberService.java]  
 * @ClassName:    [SerialNumberService]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [wu_chunhui@founder.com.cn]  
 * @CreateDate:   [2014-12-18 上午11:30:24]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2014-12-18 上午11:30:24，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */

public interface SerialNumberService {
	public void creatSequence(String sequenceName);
	public String getDwbh(SessionBean sessionBean);
}
