/**********************************************************************   
 * <p>文件名：AqffXcAqjyServiceImpl.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author wu.w@founder.com.cn 
 * @date 2015-5-25 上午9:52:20 
 * @history
 * @department：研发部
 *
*/
package com.founder.aqff.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.aqff.bean.AqffXcXcjyxxb;
import com.founder.aqff.dao.AqffXcXcjyDao;
import com.founder.aqff.service.AqffXcXcjyService;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.UUID;

/******************************************************************************
 * @Package:      [com.founder.aqff.service.impl.AqffXcAqjyServiceImpl.java]  
 * @ClassName:    [AqffXcAqjyServiceImpl]   
 * @Description:  [宣传教育服务实现类]   
 * @Author:       [wu.w@founder.com.cn]  
 * @CreateDate:   [2015-5-25 上午9:52:20]   
 * @UpdateUser:   [way(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-25 上午9:52:20，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 * @review      : tian_chengwei@founder.com.cn
 * @reviewDate  : 20150604
 */
@Service("aqffxcjyService")
@Transactional
public class AqffXcXcjyServiceImpl extends BaseService implements AqffXcXcjyService{
	@Resource(name = "aqffxcjyDao")
	private AqffXcXcjyDao xcjyDao;
	
	/*
	 * (非 Javadoc)
	 * <p>Title: query</p>
	 * <p>Description: </p>
	 * @param page
	 * @param entity
	 * @return
	 * @see com.founder.aqff.service.AqffXcXcjyService#query(com.founder.framework.utils.EasyUIPage, com.founder.aqff.bean.AqffXcXcjyxxb)
	 */
	@Override
	public EasyUIPage query(EasyUIPage page, AqffXcXcjyxxb entity) {
		return xcjyDao.query(page, entity);
	}

	/*
	 * (非 Javadoc)
	 * <p>Title: save</p>
	 * <p>Description: </p>
	 * @param entity
	 * @param sessionBean
	 * @see com.founder.aqff.service.AqffXcXcjyService#save(com.founder.aqff.bean.AqffXcXcjyxxb, com.founder.framework.base.entity.SessionBean)
	 */
	@Override
	public void saveXcjy(AqffXcXcjyxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		setSaveProperties(entity, sessionBean);
		xcjyDao.saveXcjy(entity);
	}
	
	/*
	 * (非 Javadoc)
	 * <p>Title: modify</p>
	 * <p>Description: </p>
	 * @param entity
	 * @param sessionBean
	 * @see com.founder.aqff.service.AqffXcXcjyService#modify(com.founder.aqff.bean.AqffXcXcjyxxb, com.founder.framework.base.entity.SessionBean)
	 */
	@Override
	public void updateXcjy(AqffXcXcjyxxb entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		xcjyDao.updateXcjy(entity);
	}

	/*
	 * (非 Javadoc)
	 * <p>Title: delete</p>
	 * <p>Description: </p>
	 * @param id
	 * @param sessionBean
	 * @see com.founder.aqff.service.AqffXcXcjyService#delete(java.lang.String, com.founder.framework.base.entity.SessionBean)
	 */
	@Override
	public void deleteXcjy(String id, SessionBean sessionBean) {
		AqffXcXcjyxxb entity =new AqffXcXcjyxxb();
		entity.setId(id);
		setUpdateProperties(entity, sessionBean);
		xcjyDao.deleteXcjy(entity);
	}

}
