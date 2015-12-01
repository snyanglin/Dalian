package com.founder.ywxt.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.UUID;
import com.founder.ywxt.bean.Ywxtsfqypzb;
import com.founder.ywxt.dao.YwxtsfqypzbDao;
import com.founder.ywxt.service.YwxtsfqypzService;

/******************************************************************************
 * @Package:      [com.founder.ywxt.service.YwxtsfqypzService.java]  
 * @ClassName:    [YwxtsfqypzService]   
 * @Description:  [业务协同是否启用配置service]   
 * @Author:       [cong_rihong@founder.com.cn]  
 * @CreateDate:   [2015-11-5 下午3:37:11]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-11-5 下午3:37:11，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@Service
@Transactional
public class YwxtsfqypzbServiceImpl  extends BaseService implements YwxtsfqypzService {

	@Resource
	private YwxtsfqypzbDao ywxtsfqypzbDao;
	
	@Override
	public Ywxtsfqypzb queryByYwxtlx(String ywxtlx) {
		return ywxtsfqypzbDao.queryByYwxtlx(ywxtlx);
	}

	@Override
	public Ywxtsfqypzb queryById(String id) {
		
		return ywxtsfqypzbDao.queryById(id);
	}

	@Override
	public EasyUIPage queryList(Ywxtsfqypzb entity, EasyUIPage page) {
		
		return ywxtsfqypzbDao.queryList(entity, page);
	}

	@Override
	public void save(Ywxtsfqypzb entity, SessionBean sessionBean) {

		setSaveProperties(entity, sessionBean);
		entity.setId(UUID.create());
		ywxtsfqypzbDao.save(entity, sessionBean);
	}

	@Override
	public void update(Ywxtsfqypzb entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		ywxtsfqypzbDao.update(entity, sessionBean);

		
	}

	@Override
	public void delete(Ywxtsfqypzb entity, SessionBean sessionBean) {
		setCrossoutProperties(entity, sessionBean);
		ywxtsfqypzbDao.delete(entity, sessionBean);
	}

}
