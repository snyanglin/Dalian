/**********************************************************************   
 * <p>文件名：DwbaycyqkxxbDao.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author liang_lihe@founder.com.cn 
 * @date 2015-7-9 上午9:11:36 
 * @history
 * @department：研发部
 *
*/
package com.founder.sydw.dao;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.sydw.bean.Dwbacyqkxxb;
import com.founder.sydw.bean.DwjbxxbBay;

/******************************************************************************
 * @Package:      [com.founder.sydw.dao.DwbaycyqkxxbDao.java]  
 * @ClassName:    [DwbaycyqkxxbDao]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [liang_lihe@founder.com.cn]  
 * @CreateDate:   [2015-7-9 上午9:11:36]   
 * @UpdateUser:   [lk(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-7-9 上午9:11:36，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@Repository("dwbaycyqkxxbdao")
public class DwbaycyqkxxbDao extends BaseDaoImpl{
	
	public Dwbacyqkxxb queryEntityById(String id) {
		return (Dwbacyqkxxb)queryForObject("Dwbacyqkxxb.dwbacyqkxxb_queryById", id);
	}
	
	public void saveEntity(Dwbacyqkxxb entity) {
		super.insert("Dwbacyqkxxb.dwbacyqkxxb_insert", entity);
	}
	
	public void updateEntity(Dwbacyqkxxb entity) {
		super.update("Dwbacyqkxxb.dwbacyqkxxb_update", entity);
	}

}
