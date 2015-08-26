package com.founder.sydw.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.UUID;
import com.founder.sydw.bean.Dwzjb;
import com.founder.sydw.dao.DwzjxxzbDao;
import com.founder.sydw.service.DwzjxxzbService;

@Service("dwzjxxzbService")
@Transactional
public class DwzjxxzbServiceImpl extends BaseService implements DwzjxxzbService {
		
	@Resource(name = "dwzjxxzbDao")
	private DwzjxxzbDao dwzjxxzbDao;

	@Override
	public void saveZjxx(Dwzjb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		setSaveProperties(entity, sessionBean);
		dwzjxxzbDao.saveZjxx(entity);
	}

	@Override
	public void updateZjxx(Dwzjb entity, SessionBean sessionBean) {
		setUpdateProperties(entity,sessionBean);
		dwzjxxzbDao.updateZjxx(entity);
		
	}

	@Override
	public Dwzjb queryZjxx(Dwzjb entity) {
		return dwzjxxzbDao.queryZjxx(entity);
	}

	@Override
	public List<Dwzjb> queryDwzjxx(String zjzldm, String zjbh) {
		return dwzjxxzbDao.queryDwzjxx(zjzldm,zjbh);
	}

}
