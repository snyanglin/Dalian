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
import com.founder.zdrygl.base.dao.ZdryDtjsZdxsfzqkxxbDao;
import com.founder.zdrygl.base.model.ZdryDtjsZdxsfzqkxxb;
import com.founder.zdrygl.base.service.ZdryDtjsZdxsfzqkxxbService;

@Service
@Transactional
public class ZdryDtjsZdxsfzqkxxbServiceImpl extends BaseService implements ZdryDtjsZdxsfzqkxxbService {

	@Resource
	private ZdryDtjsZdxsfzqkxxbDao zdryDtjsZdxsfzqkxxbDao;
	
	@Override
	public EasyUIPage queryList(EasyUIPage page, ZdryDtjsZdxsfzqkxxb entity) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());

		map.put("entity", entity);
		List<?> list = zdryDtjsZdxsfzqkxxbDao.queryList(page, map);
		int count = (int) zdryDtjsZdxsfzqkxxbDao.queryCount(map);
		page.setTotal(count);
		page.setRows(list);	
		return page;
	
	}

	@Override
	public String save(ZdryDtjsZdxsfzqkxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		BaseService.setSaveProperties(entity, sessionBean);
		zdryDtjsZdxsfzqkxxbDao.save(entity);
		return entity.getId();
	}

	@Override
	public ZdryDtjsZdxsfzqkxxb queryById(String id) {
		
		return this.zdryDtjsZdxsfzqkxxbDao.querById(id);
	}

	@Override
	public void delete(ZdryDtjsZdxsfzqkxxb entity, SessionBean sessionBean) {
		setCrossoutProperties(entity, sessionBean);
		this.zdryDtjsZdxsfzqkxxbDao.delete(entity);
	}

	@Override
	public String update(ZdryDtjsZdxsfzqkxxb entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		zdryDtjsZdxsfzqkxxbDao.update(entity);
		return entity.getId();
	}

}
