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
import com.founder.zdrygl.base.dao.ZdryDtjsSdzdxxbDao;
import com.founder.zdrygl.base.model.ZdryDtjsSdzdxxb;
import com.founder.zdrygl.base.service.ZdryDtjsSdzdxxbService;

@Service
@Transactional
public class ZdryDtjsSdzdxxbServiceImpl extends BaseService implements ZdryDtjsSdzdxxbService {

	@Resource
	private ZdryDtjsSdzdxxbDao zdryDtjsSdzdxxbDao;
	
	@Override
	public EasyUIPage queryList(EasyUIPage page, ZdryDtjsSdzdxxb entity) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());

		map.put("entity", entity);
		List<?> list = zdryDtjsSdzdxxbDao.queryList(page, map);
		int count = (int) zdryDtjsSdzdxxbDao.queryCount(map);
		page.setTotal(count);
		page.setRows(list);	
		return page;
	
	}

	@Override
	public String save(ZdryDtjsSdzdxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		BaseService.setSaveProperties(entity, sessionBean);
		zdryDtjsSdzdxxbDao.save(entity);
		return entity.getId();
	}

	@Override
	public ZdryDtjsSdzdxxb queryById(String id) {
		
		return this.zdryDtjsSdzdxxbDao.querById(id);
	}

	@Override
	public void delete(ZdryDtjsSdzdxxb entity, SessionBean sessionBean) {
		setCrossoutProperties(entity, sessionBean);
		zdryDtjsSdzdxxbDao.delete(entity);
	}

	@Override
	public String update(ZdryDtjsSdzdxxb entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		zdryDtjsSdzdxxbDao.update(entity);
		return entity.getId();
	}

}
