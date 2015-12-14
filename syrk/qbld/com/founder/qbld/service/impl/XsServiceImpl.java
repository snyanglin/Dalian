package com.founder.qbld.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.framework.utils.UUID;
import com.founder.qbld.bean.Xscjb;
import com.founder.qbld.dao.XsDao;
import com.founder.qbld.service.XsService;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.service.impl.LkyjzlServiceImpl.java]  
 * @ClassName:    [LkyjzlServiceImpl]   
 * @Description:  [临控预警指令服务实现类]   
 * @Author:       [yu_sun@founder.com.cn]  
 * @CreateDate:   [2015-4-22 上午9:29:54]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-22 上午9:29:54，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Service("xsService")
@Transactional
public class XsServiceImpl extends BaseService implements XsService {
	
	@Resource(name = "xsDao")
	private XsDao xsDao;

	@Override
	public EasyUIPage queryXsList(EasyUIPage page, Xscjb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());
		String sort = page.getSort();
		String order = page.getOrder();
		if (StringUtils.isBlank(sort)) { // 默认排序
			sort = "bssj";
			order = "desc";
		}
		map.put("sort", sort);
		map.put("order", order);
		map.put("xscjb", entity);
		List<?> list = xsDao.queryXsList(page, map);
		int count = (int) xsDao.queryXsCount(map);
		page.setTotal(count);
		page.setRows(list);	
		return page;
	}

	@Override
	public Xscjb queryXs(Xscjb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("xscjb", entity);
		return xsDao.queryXs(map);
	}

	@Override
	public String saveXscjb(Xscjb entity) {
		entity.setJlid(UUID.create());
		return xsDao.saveXscjb(entity);
	}
	
}
