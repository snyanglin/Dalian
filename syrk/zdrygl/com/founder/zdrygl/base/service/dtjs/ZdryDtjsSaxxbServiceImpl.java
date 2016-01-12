package com.founder.zdrygl.base.service.dtjs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zdrygl.base.dao.ZdryDtjsSaxxbDao;
import com.founder.zdrygl.base.model.ZdryDtjsSaxxb;
import com.founder.zdrygl.base.service.ZdryDtjsSaxxbService;

@Service
public class ZdryDtjsSaxxbServiceImpl  extends BaseService  implements ZdryDtjsSaxxbService {

	@Resource
	private ZdryDtjsSaxxbDao zdryDtjsSaxxbDao;

	@Override
	public EasyUIPage queryList(EasyUIPage page, ZdryDtjsSaxxb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());

		map.put("entity", entity);
		List<?> list = zdryDtjsSaxxbDao.queryList(page, map);
		int count = (int) zdryDtjsSaxxbDao.queryCount(map);
		page.setTotal(count);
		page.setRows(list);	
		return page;
	}
	
	
	

}
