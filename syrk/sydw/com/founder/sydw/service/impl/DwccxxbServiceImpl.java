package com.founder.sydw.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.StringUtils;
import com.founder.framework.utils.UUID;
import com.founder.sydw.bean.Dwccxxb;
import com.founder.sydw.dao.DwccxxbDao;
import com.founder.sydw.dao.DwjbxxbDao;
import com.founder.sydw.service.DwccxxbService;
import com.founder.syrkgl.bean.RyRyjbxxb;
import com.founder.syrkgl.dao.RyRyjbxxbDao;
@Service("dwccxxbService")
@Transactional
public class DwccxxbServiceImpl extends BaseService implements DwccxxbService {
	@Resource(name = "dwccxxbDao")
	private DwccxxbDao dwccxxbDao;
	
	@Resource(name = "dwjbxxbDao")
	private DwjbxxbDao dwjbxxbDao;
	
	@Resource(name = "ryRyjbxxbDao")
	private RyRyjbxxbDao ryRyjbxxbDao;
	@Override
	public Dwccxxb queryEntityById(Dwccxxb entity) {
		return dwccxxbDao.queryEntityById(entity);
	}
	@Override
	public void saveEntity(Dwccxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		setSaveProperties(entity,sessionBean);
		dwccxxbDao.saveEntity(entity);
		if(StringUtils.isBlank(entity.getCcfzrid())){
			if(!StringUtils.isBlank(entity.getCcfzr())&& !StringUtils.isBlank(entity.getCcfzrzjhm())){
				RyRyjbxxb ryjbxx = new RyRyjbxxb();
				ryjbxx.setId(UUID.create());
				ryjbxx.setXm(entity.getCcfzr());
				ryjbxx.setZjhm(entity.getCcfzrzjhm());
				ryjbxx.setCyzjdm(entity.getCcfzrcyzjdm());
				setSaveProperties(ryjbxx,sessionBean);
				ryRyjbxxbDao.save(ryjbxx,null);
			}
		}
	}
	@Override
	public void updateEntity(Dwccxxb entity, SessionBean sessionBean) {
		setUpdateProperties(entity,sessionBean);
		dwccxxbDao.updateEntity(entity);
	}
	@Override
	public boolean queryLxfsValid(String lxdh, String dwid) {
		return dwjbxxbDao.queryLxfsValid(lxdh, dwid);
	}
	
}
