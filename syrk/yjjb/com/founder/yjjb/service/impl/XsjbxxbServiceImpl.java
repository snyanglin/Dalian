package com.founder.yjjb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.organization.role.bean.OrgRole;
import com.founder.framework.organization.user.bean.OrgUser;
import com.founder.framework.utils.EasyUIPage;
import com.founder.yjjb.bean.Xsjbxxb;
import com.founder.yjjb.dao.XsjbxxbDao;
import com.founder.yjjb.service.XsjbxxbService;

@Service("xsjbxxbService")
@Transactional
public class XsjbxxbServiceImpl extends BaseService implements XsjbxxbService {

	@Resource(name = "xsjbxxbDao")
	private XsjbxxbDao xsjbxxbDao;
	
	/**
	 * 查询</br>
	 */
	public EasyUIPage queryList(EasyUIPage page,Xsjbxxb entity) {
		
		return xsjbxxbDao.queryList(page, entity);
	}

	/**
	 * 查询</br>
	 */
	public Xsjbxxb queryById(Xsjbxxb entity) {
		
		return xsjbxxbDao.queryById(entity);
	}

	/**
	 * 新增</br>
	 */
	public void save(Xsjbxxb entity, SessionBean sessionBean) {
		
		setSaveProperties(entity, sessionBean);
		xsjbxxbDao.save(entity, sessionBean);
	}

	/**
	 * 修改</br>
	 */
	public void update(Xsjbxxb entity, SessionBean sessionBean) {
		
		setUpdateProperties(entity, sessionBean);
		xsjbxxbDao.update(entity, sessionBean);
	}

	/**
	 * 删除</br>
	 */
	public void delete(Xsjbxxb entity, SessionBean sessionBean) {
		
		setCrossoutProperties(entity, sessionBean);
		xsjbxxbDao.delete(entity, sessionBean);
	}

	/**
	 * 初查状态的数据</br>
	 */
	public List<Xsjbxxb> queryCCById() {

		return xsjbxxbDao.queryCCById();
	}

	/**
	 * 复查状态的数据</br>
	 */
	public List<Xsjbxxb> queryFCById() {
		
		return xsjbxxbDao.queryFCById();
	}
	
	/**
	 * 查询所有线索</br>
	 */
	public EasyUIPage queryAllList(EasyUIPage page,Xsjbxxb entity) {
		
		return xsjbxxbDao.queryAllList(page, entity);
	}

	/* (非 Javadoc)
	 * <p>Title: queryUserAssignRole</p>
	 * <p>Description: </p>
	 * @param paramString
	 * @return
	 * @see com.founder.yjjb.service.XsjbxxbService#queryUserAssignRole(java.lang.String)
	 */

	public List<Xsjbxxb> queryUserAssignRole(SessionBean sessionBean)
	  {
		return xsjbxxbDao.queryUserAssignRole(sessionBean);
	  }

}
