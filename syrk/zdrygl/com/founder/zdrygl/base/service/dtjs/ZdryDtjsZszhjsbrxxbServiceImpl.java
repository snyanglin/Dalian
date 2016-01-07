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
import com.founder.zdrygl.base.dao.ZdryDtjsZszhjsbrxxbDao;
import com.founder.zdrygl.base.model.ZdryDtjsZszhjsbrxxb;
import com.founder.zdrygl.base.service.ZdryDtjsZszhjsbrxxbService;

@Service
@Transactional
public class ZdryDtjsZszhjsbrxxbServiceImpl extends BaseService implements ZdryDtjsZszhjsbrxxbService {

	@Resource
	private ZdryDtjsZszhjsbrxxbDao zdryDtjsZszhjsbrxxbDao;
	
	@Override
	public EasyUIPage queryList(EasyUIPage page, ZdryDtjsZszhjsbrxxb entity) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());

		map.put("entity", entity);
		List<?> list = zdryDtjsZszhjsbrxxbDao.queryList(page, map);
		int count = (int) zdryDtjsZszhjsbrxxbDao.queryCount(map);
		page.setTotal(count);
		page.setRows(list);	
		return page;
	
	}

	@Override
	public String save(ZdryDtjsZszhjsbrxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		BaseService.setSaveProperties(entity, sessionBean);
		zdryDtjsZszhjsbrxxbDao.save(entity);
		return entity.getId();
	}

	@Override
	public ZdryDtjsZszhjsbrxxb queryById(String id) {
		
		return this.zdryDtjsZszhjsbrxxbDao.querById(id);
	}

	@Override
	public void delete(ZdryDtjsZszhjsbrxxb entity, SessionBean sessionBean) {
		setCrossoutProperties(entity, sessionBean);
		zdryDtjsZszhjsbrxxbDao.delete(entity);
	}

	@Override
	public String update(ZdryDtjsZszhjsbrxxb entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		zdryDtjsZszhjsbrxxbDao.update(entity);
		return entity.getId();
	}

}
