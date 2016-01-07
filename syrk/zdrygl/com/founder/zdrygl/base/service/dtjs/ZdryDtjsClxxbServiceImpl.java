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
import com.founder.zdrygl.base.dao.ZdryDtjsClxxbDao;
import com.founder.zdrygl.base.model.ZdryDtjsClxxb;
import com.founder.zdrygl.base.service.ZdryDtjsClxxbService;

@Service
@Transactional
public class ZdryDtjsClxxbServiceImpl extends BaseService implements ZdryDtjsClxxbService {

	@Resource
	private ZdryDtjsClxxbDao zdryDtjsClxxbDao;
	
	@Override
	public EasyUIPage queryList(EasyUIPage page, ZdryDtjsClxxb entity) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());

		map.put("entity", entity);
		List<?> list = zdryDtjsClxxbDao.queryList(page, map);
		int count = (int) zdryDtjsClxxbDao.queryCount(map);
		page.setTotal(count);
		page.setRows(list);	
		return page;
	
	}

	@Override
	public String save(ZdryDtjsClxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		BaseService.setSaveProperties(entity, sessionBean);
		zdryDtjsClxxbDao.save(entity);
		return entity.getId();
	}

	@Override
	public ZdryDtjsClxxb queryById(String id) {
		
		return this.zdryDtjsClxxbDao.querById(id);
	}

	@Override
	public void delete(ZdryDtjsClxxb entity, SessionBean sessionBean) {
		setCrossoutProperties(entity, sessionBean);
		zdryDtjsClxxbDao.delete(entity);
	}

	@Override
	public String update(ZdryDtjsClxxb entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		zdryDtjsClxxbDao.update(entity);
		return entity.getId();
	}

}
