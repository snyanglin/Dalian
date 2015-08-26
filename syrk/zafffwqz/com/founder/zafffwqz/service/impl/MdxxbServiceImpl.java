package com.founder.zafffwqz.service.impl;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.UUID;
import com.founder.zafffwqz.bean.Mdxxb;
import com.founder.zafffwqz.dao.MdxxbDao;
import com.founder.zafffwqz.service.MdxxbService;

@Service("mdxxbService")
@Transactional
public class MdxxbServiceImpl extends BaseService implements MdxxbService {
	
	@Resource(name = "mdxxbDao")
	private MdxxbDao mdxxbDao;
	
	@Override
	public void delete(Mdxxb entity, SessionBean sessionBean) {
		setCrossoutProperties(entity, sessionBean);
		mdxxbDao.delete(entity);
		
	}

	@Override
	public EasyUIPage queryList(EasyUIPage page, Map map) {
		return mdxxbDao.queryList(page, map);
	}

	@Override
	public Mdxxb queryMdxxb(Mdxxb entity) {
		return mdxxbDao.queryMdxxb(entity);
	}

	@Override
	public void saveMdxxb(Mdxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		setSaveProperties(entity, sessionBean);
		mdxxbDao.saveMdxxb(entity);
		
	}

	@Override
	public void updateMdxxb(Mdxxb entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		mdxxbDao.updateMdxxb(entity);
	}

}
