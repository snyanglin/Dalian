/**********************************************************************   
 * <p>文件名：ZakhZzjgService.java </p>
 * <p>文件描述：治安考核-基本信息采集服务类接口
 * @project_name：syrk
 * @author liu_shuai@founder.com.cn 
 * @date 2015-4-17 上午8:50:31 
 * @history
 * @department：研发部
 *
*/
package com.founder.zakh.service;

import java.util.List;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.zakh.bean.ZakhZzjgBean;


/******************************************************************************
 * @Package:      [com.founder.zakh.service.ZakhZzjgService.java]  
 * @ClassName:    [ZakhZzjgService]   
 * @Description:  [治安考核-组织机构服务类]   
 * @Author:       [liu_shuai@founder.com.cn]  
 * @CreateDate:   [2015-4-17 上午8:54:11]   
 * @UpdateUser:   [Way(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-17 上午8:54:11，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */

public interface ZakhZzjgService {
	
	@MethodAnnotation(value = "查询分局", type = logType.query)
	public List<ZakhZzjgBean> getFjZzjg();

	@MethodAnnotation(value = "查询分局下市局", type = logType.query)
	public List<ZakhZzjgBean> getPcsZzjg(String orgcode);

	@MethodAnnotation(value = "查询市局下社区", type = logType.query)
	public List<ZakhZzjgBean> getSqZzjg(String orgcode);

}
