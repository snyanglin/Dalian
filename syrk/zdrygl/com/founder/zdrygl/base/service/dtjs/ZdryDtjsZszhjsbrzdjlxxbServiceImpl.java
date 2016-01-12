package com.founder.zdrygl.base.service.dtjs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.UUID;
import com.founder.zdrygl.base.dao.ZdryDtjsZszhjsbrzdjlxxbDao;
import com.founder.zdrygl.base.model.ZdryDtjsZszhjsbrZdjlxxb;
import com.founder.zdrygl.base.service.ZdryDtjsZszhjsbrzdjlxxbService;

@Service
@Transactional
public class ZdryDtjsZszhjsbrzdjlxxbServiceImpl extends BaseService implements ZdryDtjsZszhjsbrzdjlxxbService {

	@Resource
	private ZdryDtjsZszhjsbrzdjlxxbDao zdryDtjsZszhjsbrzdjlxxbDao;
	
	@Override
	public EasyUIPage queryList(EasyUIPage page, ZdryDtjsZszhjsbrZdjlxxb entity) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());

		map.put("entity", entity);
		List<?> list = zdryDtjsZszhjsbrzdjlxxbDao.queryList(page, map);
		int count = (int) zdryDtjsZszhjsbrzdjlxxbDao.queryCount(map);
		page.setTotal(count);
		page.setRows(list);	
		return page;
	
	}

	@Override
	public String save(ZdryDtjsZszhjsbrZdjlxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		BaseService.setSaveProperties(entity, sessionBean);
		zdryDtjsZszhjsbrzdjlxxbDao.save(entity);
		return entity.getId();
	}

	@Override
	public ZdryDtjsZszhjsbrZdjlxxb queryById(String id) {
		
		return this.zdryDtjsZszhjsbrzdjlxxbDao.querById(id);
	}

	@Override
	public void delete(ZdryDtjsZszhjsbrZdjlxxb entity, SessionBean sessionBean) {
		setCrossoutProperties(entity, sessionBean);
		zdryDtjsZszhjsbrzdjlxxbDao.delete(entity);
	}

	@Override
	public String update(ZdryDtjsZszhjsbrZdjlxxb entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		zdryDtjsZszhjsbrzdjlxxbDao.update(entity);
		return entity.getId();
	}

}
