package com.founder.zdrygl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.message.dao.SysMessageDao;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.syrkgl.service.RyRyjbxxbService;
import com.founder.zdrygl.bean.ZdryShbzdryxxb;
import com.founder.zdrygl.dao.ZdryShbzdryxxbDao;
import com.founder.zdrygl.dao.ZdryZdryzbDao;
import com.founder.zdrygl.service.ZdryShbzdryxxbService;
/***
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.service.impl.ZdryShbzdryxxbServiceImpl.java]  
 * @ClassName:    [ZdryShbzdryxxbServiceImpl]   
 * @Description:  [涉环保重点人员service实现类]   
 * @Author:       [cong_rihong@founder.com.cn]  
 * @CreateDate:   [2015-6-15 上午10:53:03]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-15 上午10:53:03，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Service("zdryShbzdryxxbService")
@Transactional
public class ZdryShbzdryxxbServiceImpl extends BaseService implements ZdryShbzdryxxbService {
	@Resource(name="zdryShbzdryxxbDao")
	private ZdryShbzdryxxbDao zdryShbzdryxxbDao;
	@Resource
	private ZdryZdryzbDao zdryZdryzbDao;
	@Resource(name = "ryRyjbxxbService")
	private RyRyjbxxbService ryRyjbxxbService;
	@Resource(name = "sysMessageDao")
	private SysMessageDao sysMessageDao;
	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;
	

	@Override
	public void update(ZdryShbzdryxxb entity, SessionBean sessionBean) {
		super.setUpdateProperties(entity, sessionBean);

		this.zdryShbzdryxxbDao.update(entity);
	}

	@Override
	public ZdryShbzdryxxb queryById(String id) {
		return zdryShbzdryxxbDao.queryById(id);
	}

	@Override
	public EasyUIPage queryList(ZdryShbzdryxxb entity, EasyUIPage page,SessionBean sessionBean) {
		
		return zdryShbzdryxxbDao.queryList(entity, page,sessionBean);
	}
	
}
