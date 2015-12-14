package com.founder.yjjb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.yjjb.bean.Xsdzspb;
import com.founder.yjjb.dao.XsdzspbDao;
import com.founder.yjjb.service.XsdzspbService;

@Service("xsdzspbService")
@Transactional
public class XsdzspbServiceImpl extends BaseService implements XsdzspbService {

	@Resource(name = "xsdzspbDao")
	private XsdzspbDao xsdzspbDao;
	
	/**
	 * 查询</br>
	 */
	public EasyUIPage queryList(EasyUIPage page,Xsdzspb entity) {
		
		return xsdzspbDao.queryList(page, entity);
	}

	/**
	 * 查询</br>
	 */
	public Xsdzspb queryById(Xsdzspb entity) {
		
		return xsdzspbDao.queryById(entity);
	}

	/**
	 * 新增</br>
	 */
	public void save(Xsdzspb entity, SessionBean sessionBean) {
		
//		entity.setId(UUID.create());
		setSaveProperties(entity, sessionBean);
		xsdzspbDao.save(entity, sessionBean);
	}

	/**
	 * 修改</br>
	 */
	public void update(Xsdzspb entity, SessionBean sessionBean) {
		
		setUpdateProperties(entity, sessionBean);
		xsdzspbDao.update(entity, sessionBean);
	}

	/**
	 * 删除</br>
	 */
	public void delete(Xsdzspb entity, SessionBean sessionBean) {
		
		setCrossoutProperties(entity, sessionBean);
		xsdzspbDao.delete(entity, sessionBean);
	}

	public List<Xsdzspb> queryListByXsId(String xsid) {

		return xsdzspbDao.queryListByXsId(xsid);
	}
}
