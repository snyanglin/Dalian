package com.founder.sydw.service.impl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.UUID;
import com.founder.sydw.bean.Jdcxlxxb;
import com.founder.sydw.dao.JdcxlxxbDao;
import com.founder.sydw.service.JdcxlxxbService;

@Service("jdcxlxxbService")
@Transactional
public class JdcxlxxbServiceImple extends BaseService implements
		JdcxlxxbService {
	@Resource(name = "jdcxlxxbDao")
	private JdcxlxxbDao jdcxlxxbDao;

	@Override
	public Jdcxlxxb queryjdcxlxxbByRyid(Jdcxlxxb entity) {
		return jdcxlxxbDao.queryjdcxlxxbByRyid(entity);
	}

	@Override
	public void saveJdcxlxxb(Jdcxlxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		setSaveProperties(entity,sessionBean);
		jdcxlxxbDao.saveJdcxlxxb(entity);
	}

	@Override
	public void updateJdcxlxxb(Jdcxlxxb entity, SessionBean sessionBean) {
		setUpdateProperties(entity,sessionBean);
		jdcxlxxbDao.updateJdcxlxxb(entity);
	}
	

}
