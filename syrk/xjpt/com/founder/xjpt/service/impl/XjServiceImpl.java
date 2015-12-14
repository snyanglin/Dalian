package com.founder.xjpt.service.impl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.xjpt.bean.Xj_ajxxb;
import com.founder.xjpt.bean.Xj_jqxxb;
import com.founder.xjpt.bean.Xj_sjxxb;
import com.founder.xjpt.bean.Zdryjbxxb;
import com.founder.xjpt.dao.XjDao;
import com.founder.xjpt.service.XjService;

@Service("xjService")
public class XjServiceImpl extends BaseService implements XjService {
	
	@Resource(name = "xjDao")
	private XjDao xjDao;

	@Override
	public EasyUIPage queryJq(EasyUIPage page, Xj_jqxxb entity) {
		return xjDao.queryJq(page, entity);
	}

	@Override
	public long queryCountJq(Xj_jqxxb entity) {
		return xjDao.queryCountJq(entity);
	}

	@Override
	public EasyUIPage queryAj(EasyUIPage page, Xj_ajxxb entity) {
		return xjDao.queryAj(page, entity);
	}

	@Override
	public long queryCountAj(Xj_ajxxb entity) {
		return xjDao.queryCountAj(entity);
	}

	@Override
	public EasyUIPage querySj(EasyUIPage page, Xj_sjxxb entity) {
		return xjDao.querySj(page, entity);
	}

	@Override
	public long queryCountSj(Xj_sjxxb entity) {
		return xjDao.queryCountSj(entity);
	}
	
	@Override
	public EasyUIPage queryZdryjbxxNoPt(EasyUIPage page, Zdryjbxxb entity) {
		return xjDao.queryZdryjbxxNoPt(page, entity);
	}
	@Override
	public long queryCountZdryjbxxNoPt(Zdryjbxxb entity) {
		return xjDao.queryCountZdryjbxxNoPt(entity);
	}
	
}
