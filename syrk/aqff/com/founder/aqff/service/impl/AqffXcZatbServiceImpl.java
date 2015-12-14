/**********************************************************************   
 * <p>文件名：AqffXcZatbServiceImpl.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author wu.w@founder.com.cn 
 * @date 2015-5-25 上午9:52:09 
 * @history
 * @department：研发部
 *
*/
package com.founder.aqff.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.aqff.bean.AqffXcZatbxxb;
import com.founder.aqff.dao.AqffXcZatbDao;
import com.founder.aqff.service.AqffXcZatbService;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.UUID;

/******************************************************************************
 * @Package:      [com.founder.aqff.service.impl.AqffXcZatbServiceImpl.java]  
 * @ClassName:    [AqffXcZatbServiceImpl]   
 * @Description:  [治安通报 service impl]   
 * @Author:       [wu.w@founder.com.cn]  
 * @CreateDate:   [2015-5-25 上午9:52:09]   
 * @UpdateUser:   [way(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-25 上午9:52:09，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 * @review      : tian_chengwei@founder.com.cn
 * @reviewDate  : 20150604
 */
@Service("aqffzatbService")
@Transactional
public class AqffXcZatbServiceImpl extends BaseService implements AqffXcZatbService{
	@Resource(name = "aqffzatbDao")
	private AqffXcZatbDao zatbDao;
	/*
	 * (非 Javadoc)
	 * <p>Title: query</p>
	 * <p>Description: </p>
	 * @param entity
	 * @param page
	 * @see com.founder.aqff.service.AqffXcZatbService#query(com.founder.aqff.bean.AqffXcZatbxxb, com.founder.framework.base.entity.SessionBean)
	 */
	@Override
	public EasyUIPage query(EasyUIPage page, AqffXcZatbxxb entity) {
		return zatbDao.query(page, entity);
	}

	/*
	 * (非 Javadoc)
	 * <p>Title: save</p>
	 * <p>Description: </p>
	 * @param entity
	 * @param sessionBean
	 * @see com.founder.aqff.service.AqffXcZatbService#save(com.founder.aqff.bean.AqffXcZatbxxb, com.founder.framework.base.entity.SessionBean)
	 */
	@Override
	public void saveZatb(AqffXcZatbxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		setSaveProperties(entity, sessionBean);
		zatbDao.saveZatb(entity);
	}

	/*
	 * (非 Javadoc)
	 * <p>Title: modify</p>
	 * <p>Description: </p>
	 * @param entity
	 * @param sessionBean
	 * @see com.founder.aqff.service.AqffXcZatbService#modify(com.founder.aqff.bean.AqffXcZatbxxb, com.founder.framework.base.entity.SessionBean)
	 */
	@Override
	public void updateZatb(AqffXcZatbxxb entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		zatbDao.updateZatb(entity);
	}

	/*
	 * (非 Javadoc)
	 * <p>Title: delete</p>
	 * <p>Description: </p>
	 * @param id
	 * @param sessionBean
	 * @see com.founder.aqff.service.AqffXcZatbService#delete(java.lang.String, com.founder.framework.base.entity.SessionBean)
	 */
	@Override
	public void deleteZatb(String id, SessionBean sessionBean) {
		AqffXcZatbxxb entity=new AqffXcZatbxxb();
		entity.setId(id);
		setUpdateProperties(entity, sessionBean);
		zatbDao.deleteZatb(entity);
	}

}
