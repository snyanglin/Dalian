package com.founder.sydw_dl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.StringUtils;
import com.founder.framework.utils.UUID;
import com.founder.sydw_dl.bean.Dwcfxxb;
import com.founder.sydw_dl.bean.Dwjbxxb;
import com.founder.sydw_dl.dao.DwcfxxbDao;
import com.founder.sydw_dl.service.DwcfxxbService;

@Service("dwcfxxbService")
@Transactional
public class DwcfxxbServiceImpl extends BaseService implements DwcfxxbService {
	@Resource(name = "dwcfxxbDao")
	private DwcfxxbDao dwcfxxbDao;
	
	@Override
	public void save(Dwcfxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		BaseService.setSaveProperties(entity, sessionBean);
		dwcfxxbDao.save(entity);
		//updateJbdwJGJB(entity, sessionBean);
	}

	@Override
	public Dwcfxxb queryEntityById(Dwcfxxb entity) {
		return dwcfxxbDao.queryEntityById(entity);
	}

	@Override
	public void update(Dwcfxxb entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		dwcfxxbDao.update(entity);
		updateJbdwJGJB(entity, sessionBean);
	}

	public void updateJbdwJGJB(Dwcfxxb entity, SessionBean sessionBean) {
		if (!StringUtils.isBlank(entity.getDwid())) {
			Long cfCount = dwcfxxbDao.queryCountByDwId(entity);
			Dwjbxxb dwjbxxb = new Dwjbxxb();
			dwjbxxb.setId(entity.getDwid());
			setUpdateProperties(dwjbxxb, sessionBean);
			if (cfCount > 0) {
				/*if(!StringUtils.isBlank(dwjbxxb.getDwmc())){
					dwjbxxb.setDwqcjm(ContextSearchUtils.getPasswordString(dwjbxxb.getDwmc()));
					dwjbxxb.setDwqcpyjm(ContextSearchUtils.getPasswordString(dwcfxxbDao.queryPyqp(dwjbxxb.getDwmc())));
				}*/
//				dwcfxxbDao.updateDwjgjb(dwjbxxb);
//				applicationContext.publishEvent(new SydwModifyEvent(new EventObject(dwjbxxb.getId(), "update")));
			}
		}
	}

}
