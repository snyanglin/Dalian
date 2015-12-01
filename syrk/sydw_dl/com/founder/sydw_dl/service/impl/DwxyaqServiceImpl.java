/**********************************************************************   
 * <p>文件名：DwxyaqServiceImpl.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author wu_chunhui@founder.com.cn 
 * @date 2014-12-4 下午03:01:24 
 * @history
 * @department：研发部
 *
*/
package com.founder.sydw_dl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.UUID;
import com.founder.sydw_dl.bean.Dwjcxxb;
import com.founder.sydw_dl.bean.Dwxyaqxxb;
import com.founder.sydw_dl.dao.DwxyaqDao;
import com.founder.sydw_dl.service.DwxyaqService;

/******************************************************************************
 * @Package:      [com.founder.sydw_dl.service.impl.DwxyaqServiceImpl.java]  
 * @ClassName:    [DwxyaqServiceImpl]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [wu_chunhui@founder.com.cn]  
 * @CreateDate:   [2014-12-4 下午03:01:24]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2014-12-4 下午03:01:24，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@Service("dwxyaqService")
@Transactional
public class DwxyaqServiceImpl extends BaseService implements DwxyaqService {
	@Resource(name = "dwxyaqdao")
	private DwxyaqDao dwxyaqDao;
	/* (非 Javadoc)
	 * <p>Title: query</p>
	 * <p>Description: </p>
	 * @param id
	 * @return
	 * @see com.founder.sydw_dl.service.DwxyaqService#query(java.lang.String)
	 */
	@Override
	public Dwxyaqxxb query(String id) {
		return dwxyaqDao.queryEntityById(id);
	}

	/* (非 Javadoc)
	 * <p>Title: save</p>
	 * <p>Description: </p>
	 * @param entity
	 * @param sessionBean
	 * @see com.founder.sydw_dl.service.DwxyaqService#save(com.founder.sydw_dl.bean.Dwxyaqxxb, com.founder.framework.base.entity.SessionBean)
	 */
	@Override
	public void save(Dwxyaqxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		setSaveProperties(entity,sessionBean);
		dwxyaqDao.saveEntity(entity);

	}

	/* (非 Javadoc)
	 * <p>Title: update</p>
	 * <p>Description: </p>
	 * @param entity
	 * @param sessionBean
	 * @see com.founder.sydw_dl.service.DwxyaqService#update(com.founder.sydw_dl.bean.Dwxyaqxxb, com.founder.framework.base.entity.SessionBean)
	 */
	@Override
	public void update(Dwxyaqxxb entity, SessionBean sessionBean) {
		setUpdateProperties(entity,sessionBean);
		dwxyaqDao.updateEntity(entity);

	}

	/* (非 Javadoc)
	 * <p>Title: queryByDwid</p>
	 * <p>Description: </p>
	 * @param dwid
	 * @return
	 * @see com.founder.sydw_dl.service.DwxyaqService#queryByDwid(java.lang.String)
	 */
	@Override
	public Dwxyaqxxb queryByDwid(String dwid) {
		
		return dwxyaqDao.queryEntityByDwid(dwid);
	}

}
