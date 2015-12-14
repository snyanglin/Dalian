package com.founder.spsxt.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.UUID;
import com.founder.spsxt.bean.Spdlqy;
import com.founder.spsxt.dao.SpdlqyDao;
import com.founder.spsxt.service.SpdlqyService;
import com.founder.tzgg.bean.Sys_Tzggb;



@Service("spdlqyService")
@Transactional
public class SpdlqyServiceImpl extends BaseService implements SpdlqyService {

	@Resource(name = "spdlqyDao")
	private SpdlqyDao spdlqyDao;


	@Override
	public Spdlqy querySpdlqy() {
		// TODO Auto-generated method stub
		return spdlqyDao.querySpdlqy();
	}
	
	@Override
	public EasyUIPage queryList(EasyUIPage page,Map map) {
		return spdlqyDao.queryList(page, map);
	}

	@Override	
	public Spdlqy queryById(String id){
		return spdlqyDao.queryById(id);
	}
	
	@Override
	public void save(Spdlqy entity, SessionBean sessionBean) {
		// TODO Auto-generated method stub
		BaseService.setSaveProperties(entity, sessionBean);		
		spdlqyDao.save(entity);
	}

	@Override
	public void update(Spdlqy entity, SessionBean sessionBean) {
		// TODO Auto-generated method stub
		setUpdateProperties(entity, sessionBean);
		
		spdlqyDao.update(entity);
	}
	@Override
	public String getParentCode(String policecode){
		return spdlqyDao.getParentCode(policecode);
	}
	@Override
	public String getCode(String policecode){
		return spdlqyDao.getCode(policecode);
	}
	@Override
	public Integer checkSameName(Map map){
		return spdlqyDao.checkSameName(map);		
	}
}
