package com.founder.zdrw.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zdrw.bean.Zdzxrwrzb;
import com.founder.zdrw.dao.ZdzxrwrzbDao;
import com.founder.zdrw.service.ZdzxrwrzbService;

@Service("zdzxrwrzbService")
@Transactional
public class ZdzxrwrzbServiceImpl extends BaseService implements ZdzxrwrzbService {
	
	@Resource(name = "zdzxrwrzbDao")
	private ZdzxrwrzbDao zdzxrwrzbDao;
	
	@Override
	public EasyUIPage queryList(EasyUIPage page, Zdzxrwrzb entity) {
		return zdzxrwrzbDao.queryList(page,entity);
	}

}
