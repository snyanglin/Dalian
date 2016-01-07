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
import com.founder.zdrygl.base.dao.ZdryDtjsSdfdxxbDao;
import com.founder.zdrygl.base.model.ZdryDtjsSdfdxxb;
import com.founder.zdrygl.base.service.ZdryDtjsSdfdxxbService;

@Service
@Transactional
public class ZdryDtjsSdfdxxbServiceImpl extends BaseService implements ZdryDtjsSdfdxxbService {

	@Resource
	private ZdryDtjsSdfdxxbDao zdryDtjsSdfdxxbDao;
	
	@Override
	public EasyUIPage queryList(EasyUIPage page, ZdryDtjsSdfdxxb entity) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());

		map.put("entity", entity);
		List<?> list = zdryDtjsSdfdxxbDao.queryList(page, map);
		int count = (int) zdryDtjsSdfdxxbDao.queryCount(map);
		page.setTotal(count);
		page.setRows(list);	
		return page;
	
	}

	@Override
	public String save(ZdryDtjsSdfdxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		BaseService.setSaveProperties(entity, sessionBean);
		zdryDtjsSdfdxxbDao.save(entity);
		return entity.getId();
	}

	@Override
	public ZdryDtjsSdfdxxb queryById(String id) {
		
		return this.zdryDtjsSdfdxxbDao.querById(id);
	}

	@Override
	public void delete(ZdryDtjsSdfdxxb entity, SessionBean sessionBean) {
		setCrossoutProperties(entity, sessionBean);
		zdryDtjsSdfdxxbDao.delete(entity);
	}

	@Override
	public String update(ZdryDtjsSdfdxxb entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		zdryDtjsSdfdxxbDao.update(entity);
		return entity.getId();
	}

}
