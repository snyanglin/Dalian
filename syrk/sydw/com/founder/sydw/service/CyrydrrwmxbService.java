/**********************************************************************   
 * <p>文件名：CyrydrrwmxbService.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author wu_chunhui@founder.com.cn 
 * @date 2014-12-3 上午09:33:29 
 * @history
 * @department：研发部
 *
*/
package com.founder.sydw.service;

import java.util.List;
import java.util.Map;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.sydw.bean.Cyrydrrwmxb;

/******************************************************************************
 * @Package:      [com.founder.sydw.service.CyrydrrwmxbService.java]  
 * @ClassName:    [CyrydrrwmxbService]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [wu_chunhui@founder.com.cn]  
 * @CreateDate:   [2014-12-3 上午09:33:29]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2014-12-3 上午09:33:29，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@TypeAnnotation("从业人员导入任务反馈明细")
public interface CyrydrrwmxbService {

	public EasyUIPage queryByRwId(SessionBean sessionBean,String rwid,EasyUIPage page);
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void saveEntity(Cyrydrrwmxb entity,SessionBean sessionBean);
	/**
	 * @Title: cyrydrrwmxb_query_all_export
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param rwid
	 * @param @return    设定文件
	 * @return List<Map<String,String>>    返回类型
	 * @throws
	 */
	List<Map<String, String>> cyrydrrwmxb_query_all_export(String rwid);
}
