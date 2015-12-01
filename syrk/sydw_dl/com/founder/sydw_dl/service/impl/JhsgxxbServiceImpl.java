package com.founder.sydw_dl.service.impl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.UUID;
import com.founder.sydw_dl.bean.Jhsgxxb;
import com.founder.sydw_dl.dao.JhsgxxbDao;
import com.founder.sydw_dl.service.JhsgxxbService;

@Service("jhsgxxbService")
@Transactional
public class JhsgxxbServiceImpl extends BaseService implements JhsgxxbService {
	@Resource(name = "jhsgxxbDao")
	private JhsgxxbDao jhsgxxbDao;


	@Override
	public Jhsgxxb queryJhsgxxbByRyid(Jhsgxxb entity) {
		return jhsgxxbDao.queryJhsgxxbByRyid(entity);
	}

	@Override
	public void saveJhsgxxb(Jhsgxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		setSaveProperties(entity,sessionBean);
		jhsgxxbDao.saveJhsgxxb(entity);
		
	}

	@Override
	public void updateJhsgxxb(Jhsgxxb entity, SessionBean sessionBean) {
		setUpdateProperties(entity,sessionBean);
		jhsgxxbDao.updateJhsgxxb(entity);
		
	}
	

	
}
