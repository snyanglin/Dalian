package com.founder.sydw_dl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.UUID;
import com.founder.sydw_dl.bean.XyaqxxbHxd;
import com.founder.sydw_dl.dao.XyaqxxbHxdDao;
import com.founder.sydw_dl.service.XyaqxxbHxdService;

@Service("xyaqxxbHxdService")
@Transactional
public class XyaqxxbHxdServiceImpl extends BaseService implements XyaqxxbHxdService {
	
	@Resource(name = "xyaqxxbHxdDao")
	private XyaqxxbHxdDao xyaqxxbHxdDao;

	@Override
	public XyaqxxbHxd queryXyaqxxbHxd(XyaqxxbHxd entity) {
		return xyaqxxbHxdDao.queryXyaqxxbHxdById(entity);
	}

	@Override
	public void saveXyaqxxbHxd(XyaqxxbHxd entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		setSaveProperties(entity, sessionBean);
		xyaqxxbHxdDao.insertXyaqxxbHxd(entity);
	}

	@Override
	public int update(XyaqxxbHxd entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		return xyaqxxbHxdDao.updateXyaqxxbHxd(entity);
	}

}
