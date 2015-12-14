package com.founder.yjjb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.yjjb.bean.Xsajgxb;
import com.founder.yjjb.dao.XsajgxbDao;
import com.founder.yjjb.service.XsajgxbService;

@Service("xsajgxbService")
@Transactional
public class XsajgxbServiceImpl extends BaseService implements XsajgxbService {

	@Resource(name = "xsajgxbDao")
	private XsajgxbDao xsajgxbDao;
	
	/**
	 * 查询</br>
	 */
	public EasyUIPage queryList(EasyUIPage page,Xsajgxb entity) {
		
		return xsajgxbDao.queryList(page, entity);
	}

	/**
	 * 查询</br>
	 */
	public Xsajgxb queryById(Xsajgxb entity) {
		
		return xsajgxbDao.queryById(entity);
	}
	
	/**
	 * 查询某线索下的案件</br>
	 */
	public EasyUIPage queryByXsId(EasyUIPage page,String xsId) {
		
		return xsajgxbDao.queryByXsId(page, xsId);
	}

	/**
	 * 新增</br>
	 */
	public void save(Xsajgxb entity, SessionBean sessionBean) {
		
		setSaveProperties(entity, sessionBean);
		xsajgxbDao.save(entity, sessionBean);
	}

	/**
	 * 修改</br>
	 */
	public void update(Xsajgxb entity, SessionBean sessionBean) {
		
		setUpdateProperties(entity, sessionBean);
		xsajgxbDao.update(entity, sessionBean);
	}

	/**
	 * 删除</br>
	 */
	public void delete(Xsajgxb entity, SessionBean sessionBean) {
		
		setCrossoutProperties(entity, sessionBean);
		xsajgxbDao.delete(entity, sessionBean);
	}
	
	/**
	 * 更新sfffjl
	 */
	public void updateSfffjl(Xsajgxb entity, SessionBean sessionBean) {
		
		setCrossoutProperties(entity, sessionBean);
		xsajgxbDao.updateSfffjl(entity, sessionBean);
	}

	/**
	 *  查询某线索关联的案件数量</br>
	 */
	public int ifExistAj(String xsbh) {
		
		return xsajgxbDao.ifExistAj(xsbh);
	}

	/* (非 Javadoc)
	 * <p>Title: queryByXsidAjid</p>
	 * <p>Description: </p>
	 * @param entityXsAj
	 * @return
	 * @see com.founder.yjjb.service.XsajgxbService#queryByXsidAjid(com.founder.yjjb.bean.Xsajgxb)
	 */
	public Xsajgxb queryByXsidAjid(Xsajgxb entity) {
		return xsajgxbDao.queryByXsidAjid(entity);
	}

	public List<Xsajgxb> queryAJListByXsbh(String xsbh) {
		
		return xsajgxbDao.queryAJListByXsbh(xsbh);
	}
}
