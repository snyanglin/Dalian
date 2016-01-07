package com.founder.zdrygl.base.service.dtjs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zdrygl.base.dao.ZdryDtjsZtxxbDao;
import com.founder.zdrygl.base.model.ZdryDtjsZtxxb;
import com.founder.zdrygl.base.service.ZdryDtjsZtxxbService;

@Service
public class ZdryDtjsZtxxbServiceImpl  extends BaseService  implements ZdryDtjsZtxxbService {

	@Resource
	private ZdryDtjsZtxxbDao zdryDtjsZtxxbDao;

	@Override
	public EasyUIPage queryList(EasyUIPage page, ZdryDtjsZtxxb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());

		map.put("entity", entity);
		List<?> list = zdryDtjsZtxxbDao.queryList(page, map);
		int count = (int) zdryDtjsZtxxbDao.queryCount(map);
		page.setTotal(count);
		page.setRows(list);	
		return page;
	}
	
	
	

}
