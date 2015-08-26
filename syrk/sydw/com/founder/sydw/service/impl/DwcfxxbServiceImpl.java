package com.founder.sydw.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.UUID;
import com.founder.sydw.bean.Dwcfxxb;
import com.founder.sydw.dao.DwcfxxbDao;
import com.founder.sydw.service.DwcfxxbService;
/**
 * ****************************************************************************
 * @Package:      [com.founder.sydw.service.impl.DwcfxxbServiceImpl.java]  
 * @ClassName:    [DwcfxxbServiceImpl]   
 * @Description:  [单位处罚业务实现]   
 * @Author:       [yu_guangli@founder.com.cn]  
 * @UpdateUser:   [yuguangli(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-11 上午9:46:01，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [增加分页 查询功能queryList]  
 * @Version:      [v1.0]
 */
@Service("dwcfxxbService")
@Transactional
public class DwcfxxbServiceImpl extends BaseService implements DwcfxxbService {
	@Resource(name = "dwcfxxbDao")
	private DwcfxxbDao dwcfxxbDao;

	@Override
	public void save(Dwcfxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		BaseService.setSaveProperties(entity, sessionBean);
		dwcfxxbDao.save(entity);
		//updateJbdwJGJB(entity, sessionBean);
	}

	@Override
	public Dwcfxxb queryEntityById(Dwcfxxb entity) {
		return dwcfxxbDao.queryEntityById(entity);
	}

	@Override
	public void update(Dwcfxxb entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		dwcfxxbDao.update(entity);
	}

	@Override
	public EasyUIPage queryList(EasyUIPage page, Dwcfxxb entity) {
		return dwcfxxbDao.queryList(page, entity);
	}

	@Override
	public List<Dwcfxxb> dwcfxxb_query(Map<String, Object> map) {
		return dwcfxxbDao.dwcfxxb_query(map);
	}

}
