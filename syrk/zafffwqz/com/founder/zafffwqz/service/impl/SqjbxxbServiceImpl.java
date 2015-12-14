package com.founder.zafffwqz.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.StringUtils;
import com.founder.framework.utils.UUID;
import com.founder.sydw_dl.dao.DwjbxxbDao;
import com.founder.zafffwqz.bean.Sqjbxxb;
import com.founder.zafffwqz.dao.SqjbxxbDao;
import com.founder.zafffwqz.service.SqjbxxbService;

@Service("sqjbxxbService")
@Transactional
public class SqjbxxbServiceImpl extends BaseService implements SqjbxxbService {
	
	@Resource(name = "sqjbxxbDao")
	private SqjbxxbDao sqjbxxbDao;
	
	@Resource(name = "dwjbxxbDao")
	private DwjbxxbDao dwjbxxbDao;
	
	@Override
	public Sqjbxxb querySqjbxxb(Sqjbxxb entity) {
		return sqjbxxbDao.querySqjbxxbById(entity);
	}

	@Override
	public void saveSqjbxxb(Sqjbxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		setSaveProperties(entity, sessionBean);
		sqjbxxbDao.insertSqjbxxb(entity);
	}
	
	@Override
	public int updateSqjbxxb(Sqjbxxb entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		return sqjbxxbDao.updateSqjbxxb(entity);
		
	}

	@Override
	public Sqjbxxb querrBySqjwsid(String sqjwsid) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("jwsid", sqjwsid);
		return sqjbxxbDao.sqjbxxb_query(map);
	}

}
