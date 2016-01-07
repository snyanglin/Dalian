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
import com.founder.zdrygl.base.dao.ZdryDtjsSfxxbDao;
import com.founder.zdrygl.base.model.ZdryDtjsSfxxb;
import com.founder.zdrygl.base.service.ZdryDtjsSfxxbService;

@Service
@Transactional
public class ZdryDtjsSfxxbServiceImpl extends BaseService implements ZdryDtjsSfxxbService {

	@Resource
	private ZdryDtjsSfxxbDao zdryDtjsSfxxbDao;
	
	@Override
	public EasyUIPage queryList(EasyUIPage page, ZdryDtjsSfxxb entity) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());

		map.put("entity", entity);
		List<?> list = zdryDtjsSfxxbDao.queryList(page, map);
		int count = (int) zdryDtjsSfxxbDao.queryCount(map);
		page.setTotal(count);
		page.setRows(list);	
		return page;
	
	}

	@Override
	public String save(ZdryDtjsSfxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		BaseService.setSaveProperties(entity, sessionBean);
		zdryDtjsSfxxbDao.save(entity);
		return entity.getId();
	}

	@Override
	public ZdryDtjsSfxxb queryById(String id) {
		
		return zdryDtjsSfxxbDao.querById(id);
	}

	@Override
	public void delete(ZdryDtjsSfxxb entity, SessionBean sessionBean) {
		setCrossoutProperties(entity, sessionBean);
		zdryDtjsSfxxbDao.delete(entity);
	}

	@Override
	public String update(ZdryDtjsSfxxb entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		zdryDtjsSfxxbDao.update(entity);
		return entity.getId();
	}

}
