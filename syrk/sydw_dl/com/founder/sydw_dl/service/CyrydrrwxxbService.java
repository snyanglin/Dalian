/**********************************************************************   
 * <p>文件名：CyrydrrwxxbService.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author wu_chunhui@founder.com.cn 
 * @date 2014-11-26 下午3:52:11 
 * @history
 * @department：研发部
 *
*/
package com.founder.sydw_dl.service;

import java.io.InputStream;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.sydw_dl.bean.Cyrydrrwxxb;

/******************************************************************************
 * @Package:      [com.founder.sydw_dl.service.CyrydrrwxxbService.java]  
 * @ClassName:    [CyrydrrwxxbService]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [wu_chunhui@founder.com.cn]  
 * @CreateDate:   [2014-11-26 下午3:52:11]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2014-11-26 下午3:52:11，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@TypeAnnotation("从业人员导入任务")
public interface CyrydrrwxxbService {
	
	public EasyUIPage queryByDwId(SessionBean sessionBean,String dwid,EasyUIPage page);
	
	public Cyrydrrwxxb queryByRwid(String rwid);
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void saveEntity(Cyrydrrwxxb entity,SessionBean sessionBean);
	@MethodAnnotation(value = "修改", type = logType.update)
	public void updateEntity(Cyrydrrwxxb entity,SessionBean sessionBean);
	
	public void importToCyry(InputStream in,SessionBean sessionBean,String rwid,String fileType);
	
	

}
