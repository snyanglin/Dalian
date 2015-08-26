package com.founder.sydw.service.impl;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.UUID;
import com.founder.sydw.bean.Jdhxpzzxxb;
import com.founder.sydw.dao.JdhxpzzxxbDao;
import com.founder.sydw.service.JdhxpzzxxbService;
@Service("jdhxpzzxxbService")
@Transactional
public class JdhxpzzxxbServiceImpl extends BaseService implements JdhxpzzxxbService {
	@Resource(name = "jdhxpzzxxbDao")
	private JdhxpzzxxbDao jdhxpzzxxbDao;
	@Override
	public Jdhxpzzxxb queryjdhxpzzxxbByRyid(Jdhxpzzxxb entity) {
		return jdhxpzzxxbDao.queryjdhxpzzxxbByRyid(entity);
	}
	@Override
	public void saveJdhxpzzxxb(Jdhxpzzxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		setSaveProperties(entity,sessionBean);
		jdhxpzzxxbDao.saveJdhxpzzxxb(entity);
	}
	@Override
	public void updateJdhxpzzxxb(Jdhxpzzxxb entity, SessionBean sessionBean) {
		setUpdateProperties(entity,sessionBean);
		jdhxpzzxxbDao.updateLxfs(entity);
	}
	

}
