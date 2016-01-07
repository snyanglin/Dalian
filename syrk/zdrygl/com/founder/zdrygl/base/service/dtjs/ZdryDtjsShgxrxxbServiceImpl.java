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
import com.founder.zdrygl.base.dao.ZdryDtjsShgxrxxbDao;
import com.founder.zdrygl.base.model.ZdryDtjsShgxrxxb;
import com.founder.zdrygl.base.service.ZdryDtjsShgxrxxbService;

@Service
@Transactional
public class ZdryDtjsShgxrxxbServiceImpl extends BaseService implements ZdryDtjsShgxrxxbService {

	@Resource
	private ZdryDtjsShgxrxxbDao zdryDtjsShgxrxxbDao;
	
	@Override
	public EasyUIPage queryList(EasyUIPage page, ZdryDtjsShgxrxxb entity) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());

		map.put("entity", entity);
		List<?> list = zdryDtjsShgxrxxbDao.queryList(page, map);
		int count = (int) zdryDtjsShgxrxxbDao.queryCount(map);
		page.setTotal(count);
		page.setRows(list);	
		return page;
	
	}

	@Override
	public String save(ZdryDtjsShgxrxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		BaseService.setSaveProperties(entity, sessionBean);
		zdryDtjsShgxrxxbDao.save(entity);
		return entity.getId();
	}

	@Override
	public ZdryDtjsShgxrxxb queryById(String id) {
		
		return this.zdryDtjsShgxrxxbDao.querById(id);
	}

	@Override
	public void delete(ZdryDtjsShgxrxxb entity, SessionBean sessionBean) {
		setCrossoutProperties(entity, sessionBean);
		zdryDtjsShgxrxxbDao.delete(entity);
	}

	@Override
	public String update(ZdryDtjsShgxrxxb entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		zdryDtjsShgxrxxbDao.update(entity);
		return entity.getId();
	}

}
