/**********************************************************************   
 * <p>文件名：CyrydrrwmxbServiceImpl.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author wu_chunhui@founder.com.cn 
 * @date 2014-12-3 上午09:37:18 
 * @history
 * @department：研发部
 *
*/
package com.founder.sydw.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.UUID;
import com.founder.sydw.bean.Cyrydrrwmxb;
import com.founder.sydw.dao.CyrydrrwmxbDao;
import com.founder.sydw.service.CyrydrrwmxbService;

/******************************************************************************
 * @Package:      [com.founder.sydw.service.impl.CyrydrrwmxbServiceImpl.java]  
 * @ClassName:    [CyrydrrwmxbServiceImpl]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [wu_chunhui@founder.com.cn]  
 * @CreateDate:   [2014-12-3 上午09:37:18]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2014-12-3 上午09:37:18，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@Service("cyrydrrwmxbService")
@Transactional
public class CyrydrrwmxbServiceImpl  extends BaseService  implements CyrydrrwmxbService {

	@Resource(name = "cyrydrrwmxbDao")
	private CyrydrrwmxbDao cyrydrrwmxbDao;
	/* (非 Javadoc)
	 * <p>Title: queryByRwId</p>
	 * <p>Description: </p>
	 * @param sessionBean
	 * @param rwid
	 * @param page
	 * @return
	 * @see com.founder.sydw.service.CyrydrrwmxbService#queryByRwId(com.founder.framework.base.entity.SessionBean, java.lang.String, com.founder.framework.utils.EasyUIPage)
	 */
	@Override
	public EasyUIPage queryByRwId(SessionBean sessionBean, String rwid,
			EasyUIPage page) {
		Map map = new HashMap();
		map.put("lrrid", sessionBean.getUserId());
		map.put("drrwid", rwid);
		return cyrydrrwmxbDao.query(page, map);
	}

	/* (非 Javadoc)
	 * <p>Title: saveEntity</p>
	 * <p>Description: </p>
	 * @param entity
	 * @param sessionBean
	 * @see com.founder.sydw.service.CyrydrrwmxbService#saveEntity(com.founder.sydw.bean.Cyrydrrwmxb, com.founder.framework.base.entity.SessionBean)
	 */
	@Override
	public void saveEntity(Cyrydrrwmxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		BaseService.setSaveProperties(entity, sessionBean);
		cyrydrrwmxbDao.saveEntity(entity);

	}
	
	@Override
	public List<Map<String, String>> cyrydrrwmxb_query_all_export(String rwid) {
		return cyrydrrwmxbDao.cyrydrrwmxb_query_all_export(rwid);
	}


}
