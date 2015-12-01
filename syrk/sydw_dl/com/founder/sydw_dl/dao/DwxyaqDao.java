/**********************************************************************   
 * <p>文件名：DwxyaqDao.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author wu_chunhui@founder.com.cn 
 * @date 2014-12-4 下午02:45:42 
 * @history
 * @department：研发部
 *
*/
package com.founder.sydw_dl.dao;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.sydw_dl.bean.Dwxyaqxxb;

/******************************************************************************
 * @Package:      [com.founder.sydw_dl.dao.DwxyaqDao.java]  
 * @ClassName:    [DwxyaqDao]   
 * @Description:  [校园安全Dao]   
 * @Author:       [wu_chunhui@founder.com.cn]  
 * @CreateDate:   [2014-12-4 下午02:45:42]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2014-12-4 下午02:45:42，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@Repository("dwxyaqdao")
public class DwxyaqDao extends BaseDaoImpl {
	
	public Dwxyaqxxb queryEntityById(String id) {
		return (Dwxyaqxxb)queryForObject("Dwxyaqxxb.dwxyaqxxb_queryById", id);
	}

	public void saveEntity(Dwxyaqxxb entity) {
		super.insert("Dwxyaqxxb.dwxyaqxxb_insert", entity);
	}

	public void updateEntity(Dwxyaqxxb entity) {
		super.update("Dwxyaqxxb.dwxyaqxxb_update", entity);
	}
	
	public Dwxyaqxxb queryEntityByDwid(String dwid) {
		return (Dwxyaqxxb)queryForObject("Dwxyaqxxb.dwxyaqxxb_queryByDwid", dwid);
	}
	


}
