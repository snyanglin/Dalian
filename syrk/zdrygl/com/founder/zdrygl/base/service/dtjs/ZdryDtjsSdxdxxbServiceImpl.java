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
import com.founder.zdrygl.base.dao.ZdryDtjsSdxdxxbDao;
import com.founder.zdrygl.base.model.ZdryDtjsSdxdxxb;
import com.founder.zdrygl.base.service.ZdryDtjsSdxdxxbService;

@Service
@Transactional
public class ZdryDtjsSdxdxxbServiceImpl extends BaseService implements ZdryDtjsSdxdxxbService {

	@Resource
	private ZdryDtjsSdxdxxbDao zdryDtjsSdxdxxbDao;
	
	@Override
	public EasyUIPage queryList(EasyUIPage page, ZdryDtjsSdxdxxb entity) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());

		map.put("entity", entity);
		List<?> list = zdryDtjsSdxdxxbDao.queryList(page, map);
		int count = (int) zdryDtjsSdxdxxbDao.queryCount(map);
		page.setTotal(count);
		page.setRows(list);	
		return page;
	
	}

	@Override
	public String save(ZdryDtjsSdxdxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		BaseService.setSaveProperties(entity, sessionBean);
		zdryDtjsSdxdxxbDao.save(entity);
		return entity.getId();
	}

	@Override
	public ZdryDtjsSdxdxxb queryById(String id) {
		
		return this.zdryDtjsSdxdxxbDao.querById(id);
	}

	@Override
	public void delete(ZdryDtjsSdxdxxb entity, SessionBean sessionBean) {
		setCrossoutProperties(entity, sessionBean);
		zdryDtjsSdxdxxbDao.delete(entity);
	}

	@Override
	public String update(ZdryDtjsSdxdxxb entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		zdryDtjsSdxdxxbDao.update(entity);
		return entity.getId();
	}

}
