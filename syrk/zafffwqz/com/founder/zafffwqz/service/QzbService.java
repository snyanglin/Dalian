/**********************************************************************   
 * <p>文件名：QzbService.java </p>
 * <p>文件描述：犬只管理接口
 * @project_name：syrk
 * @author liu_shuai@founder.com.cn 
 * @date 2015-5-12 上午8:50:31 
 * @history
 * @department：研发部
 *
*/
package com.founder.zafffwqz.service;
/******************************************************************************
 * @Package:      [com.founder.zafffwqz.service.QzbService.java]  
 * @ClassName:    [QzbService]   
 * @Description:  [犬只管理接口服务类]   
 * @Author:       [liu_shuai@founder.com.cn]  
 * @CreateDate:   [2015-5-12 上午8:54:11]   
 * @UpdateUser:   [liushuai(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-12 上午8:54:11，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
import java.util.List;
import java.util.Map;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zafffwqz.bean.Qzb;
import com.founder.zafffwqz.bean.Qzgz;

@TypeAnnotation("犬只管理")
public interface QzbService {
	@MethodAnnotation(value = "犬只管理", type = logType.query)
	public Qzb queryQzb(Qzb entity);
	
	@MethodAnnotation(value = "新增犬只管理", type = logType.insert)
	public void saveQzb(Qzb entity, SessionBean sessionBean);
	
	@MethodAnnotation(value = "修改犬只管理", type = logType.update)
	public void updateQzb(Qzb entity, SessionBean sessionBean);
	
	@MethodAnnotation(value = "规则查询", type = logType.query)
	public List<Qzgz> queryGz(Map<String,Object> map);
	
	@SuppressWarnings("unchecked")
	@MethodAnnotation(value = "查询",type = logType.query)
	public EasyUIPage queryList(EasyUIPage page,Map map);
	
	@MethodAnnotation(value = "注销", type = logType.update)
	public void delete(Qzb entity, SessionBean sessionBean);
	

}
