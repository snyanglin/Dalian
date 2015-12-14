package com.founder.sydw_dl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.UUID;
import com.founder.sydw_dl.bean.XyaqxxbXc;
import com.founder.sydw_dl.dao.XyaqxxbXcDao;
import com.founder.sydw_dl.service.XyaqxxbXcService;

@Service("xyaqxxbXcService")
@Transactional
public class XyaqxxbXcServiceImpl extends BaseService implements XyaqxxbXcService {
	
	@Resource(name = "xyaqxxbXcDao")
	private XyaqxxbXcDao xyaqxxbXcDao;

	@Override
	public XyaqxxbXc queryXyaqxxbXc(XyaqxxbXc entity) {
		return xyaqxxbXcDao.queryXyaqxxbXcById(entity);
	}

	@Override
	public void saveXyaqxxbXc(XyaqxxbXc entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		setSaveProperties(entity, sessionBean);
		xyaqxxbXcDao.insertXyaqxxbXc(entity);
	}

	@Override
	public int update(XyaqxxbXc entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		return xyaqxxbXcDao.updateXyaqxxbXc(entity);
	}

}
