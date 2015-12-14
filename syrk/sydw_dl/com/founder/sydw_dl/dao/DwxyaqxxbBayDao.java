/**********************************************************************   
 * <p>文件名：DwxyaqxxbBayBayDao.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author wu_chunhui@founder.com.cn 
 * @date 2014-12-5 下午12:15:25 
 * @history
 * @department：研发部
 *
*/
package com.founder.sydw_dl.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.sydw_dl.bean.DwxyaqxxbBay;
import com.founder.sydw_dl.bean.XyaqxxbHxd;

/******************************************************************************
 * @Package:      [com.founder.sydw_dl.dao.DwxyaqxxbBayBayDao.java]  
 * @ClassName:    [DwxyaqxxbBayBayDao]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [wu_chunhui@founder.com.cn]  
 * @CreateDate:   [2014-12-5 下午12:15:25]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2014-12-5 下午12:15:25，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@Repository("dwxyaqxxbBaydao")
public class DwxyaqxxbBayDao extends BaseDaoImpl {
	public DwxyaqxxbBay queryEntityById(String id) {
		return (DwxyaqxxbBay)queryForObject("DwxyaqxxbBay.dwxyaqxxbBay_queryById", id);
	}

	public void saveEntity(DwxyaqxxbBay entity) {
		super.insert("DwxyaqxxbBay.dwxyaqxxbBay_insert", entity);
	}

	public void updateEntity(DwxyaqxxbBay entity) {
		super.update("DwxyaqxxbBay.dwxyaqxxbBay_update", entity);
	}
	
	@SuppressWarnings("unchecked")
	public List<DwxyaqxxbBay> dwxyaqxxbBay(Map<String, Object> map) {
		return queryForList("DwxyaqxxbBay.dwxyaqxxbBay_query", map);
	}
}
