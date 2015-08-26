/**********************************************************************   
 * <p>文件名：DwxyaqService.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author wu_chunhui@founder.com.cn 
 * @date 2014-12-4 下午02:55:35 
 * @history
 * @department：研发部
 *
*/
package com.founder.sydw.service;

import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.sydw.bean.DwjbxxbBay;

/******************************************************************************
 * @Package:      [com.founder.sydw.service.DwxyaqService.java]  
 * @ClassName:    [DwxyaqService]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [wu_chunhui@founder.com.cn]  
 * @CreateDate:   [2014-12-4 下午02:55:35]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2014-12-4 下午02:55:35，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@TypeAnnotation("校园安全")
public interface DwxyaqBayService {
	
	
	
	public void savemessage(DwjbxxbBay entity, SessionBean sessionBean);
	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	
	public void save(DwjbxxbBay entity, SessionBean sessionBean);
	/**
	 * 修改<br>
	 * 
	 * @param entity
	 */
	
	public void update(DwjbxxbBay entity, SessionBean sessionBean);	
	/**
	 * 查询单条<br>
	 * 
	 * @param entity
	 * @return
	 */
	public DwjbxxbBay query(String id);
	
	public DwjbxxbBay getBayxx(String zjhm);
	
	public EasyUIPage baryxxb_query_all(EasyUIPage page, String condition, String dwid);
	
	public long baryxxb_query_all_count(String condition, String dwid);
}
