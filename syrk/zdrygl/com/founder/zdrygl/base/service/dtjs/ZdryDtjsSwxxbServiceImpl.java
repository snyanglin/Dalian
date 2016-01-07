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
import com.founder.zdrygl.base.dao.ZdryDtjsSwxxbDao;
import com.founder.zdrygl.base.model.ZdryDtjsSwxxb;
import com.founder.zdrygl.base.service.ZdryDtjsSwxxbService;

@Service
@Transactional
public class ZdryDtjsSwxxbServiceImpl extends BaseService implements ZdryDtjsSwxxbService {

	@Resource
	private ZdryDtjsSwxxbDao zdryDtjsSwxxbDao;
	
	@Override
	public EasyUIPage queryList(EasyUIPage page, ZdryDtjsSwxxb entity) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());

		map.put("entity", entity);
		List<?> list = zdryDtjsSwxxbDao.queryList(page, map);
		int count = (int) zdryDtjsSwxxbDao.queryCount(map);
		page.setTotal(count);
		page.setRows(list);	
		return page;
	
	}

	@Override
	public String save(ZdryDtjsSwxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		BaseService.setSaveProperties(entity, sessionBean);
		zdryDtjsSwxxbDao.save(entity);
		return entity.getId();
	}

	@Override
	public ZdryDtjsSwxxb queryById(String id) {
		
		return this.zdryDtjsSwxxbDao.querById(id);
	}

	@Override
	public void delete(ZdryDtjsSwxxb entity, SessionBean sessionBean) {
		setCrossoutProperties(entity, sessionBean);
		this.zdryDtjsSwxxbDao.delete(entity);
	}

	@Override
	public String update(ZdryDtjsSwxxb entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		zdryDtjsSwxxbDao.update(entity);
		return entity.getId();
	}

}
