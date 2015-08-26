package com.founder.zafffwqz.service.impl;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.UUID;
import com.founder.zafffwqz.bean.Gzjsdmtxxb;
import com.founder.zafffwqz.bean.Gzjsxxb;
import com.founder.zafffwqz.dao.GzjsxxbDao;
import com.founder.zafffwqz.service.GzjsxxbService;

@Service("gzjsxxbService")
@Transactional
public class GzjsxxbServiceImpl extends BaseService implements GzjsxxbService {
	
	@Resource(name = "gzjsxxbDao")
	private GzjsxxbDao gzjsxxbDao;
	
	@Override
	public Gzjsxxb queryGzjsxxb(Gzjsxxb entity) {
		return gzjsxxbDao.queryGzjsxxb(entity);
	}

	@Override
	public void saveGzjsxxb(Gzjsxxb entity, SessionBean sessionBean) {
		setSaveProperties(entity, sessionBean);
		List<Map<String, Object>> list = gzjsxxbDao.querySqidSqjwsid(sessionBean.getUserOrgCode());
		if(list.size() > 0){
			entity.setSqid(list.get(0).get("SQID") == null ? "000" : list.get(0).get("SQID").toString());
			entity.setSqjwsid(list.get(0).get("SQJWSID") == null ? "000" : list.get(0).get("SQJWSID").toString());
		}
		gzjsxxbDao.saveGzjsxxb(entity);
		
	}

	@Override
	public void updateGzjsxxb(Gzjsxxb entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		gzjsxxbDao.updateGzjsxxb(entity);
		
	}

	@Override
	public void delete(Gzjsxxb entity, SessionBean sessionBean) {
		setCrossoutProperties(entity, sessionBean);
		gzjsxxbDao.delete(entity);
		
	}

	@Override
	public EasyUIPage queryList(EasyUIPage page, Map map) {
		return gzjsxxbDao.queryList(page, map);
	}

	@Override
	public void deleteGzjsdmtxxb(String gzjsid) {
		gzjsxxbDao.deleteGzjsdmtxxb(gzjsid);
	}

	@Override
	public void insertGzjsdmtxxb(Gzjsdmtxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		setSaveProperties(entity, sessionBean);
		gzjsxxbDao.insertGzjsdmtxxb(entity);
	}
	
	public List<Gzjsdmtxxb> queryGzjsdmtxxb(String gzjsid){
		return gzjsxxbDao.queryGzjsdmtxxb(gzjsid);
	}

}
