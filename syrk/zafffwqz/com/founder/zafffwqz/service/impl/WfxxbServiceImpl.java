package com.founder.zafffwqz.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.UUID;
import com.founder.service.contextsearch.department.bean.DwContextCombo;
import com.founder.service.contextsearch.department.bean.DwContextCondition;
import com.founder.zafffwqz.bean.ZaffWfxx;
import com.founder.zafffwqz.dao.WfxxDao;
import com.founder.zafffwqz.dao.WfxxbDao;
import com.founder.zafffwqz.service.WfxxbService;

/******************************************************************************
 * @Package:      [com.founder.zafffwqz.service.impl.WfxxbServiceImpl.java]  
 * @ClassName:    [WfxxbServiceImpl]   
 * @Description:  [物防信息服务层：处理属性表和空间表操作]   
 * @Author:       [tian_chengwei@founder.com.cn]  
 * @CreateDate:   [2015-5-26 下午4:42:10]   
 * @UpdateUser:   [lk(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-26 下午4:42:10，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 * 
 *  * @review      : wu.w@founder.com.cn
 * @reviewDate  : 20150604
 */
@Service("wfxxbService")
@Transactional
public class WfxxbServiceImpl extends BaseService implements WfxxbService {
    //属性表DAO
	@Resource(name = "wfxxbDao")
	private WfxxbDao wfxxbDao;
	//空间表操作DAO
	@Resource(name = "wfxxDao")
	private WfxxDao wfxxDao;
	
	/**
	 * 
	 * @Title: queryWfxxb
	 * @Description: TODO(属性表查询)
	 * @param  entity    设定文件
	 * @return  ZaffWfxx 返回类型
	 * @throws
	 */
	@Override
	public ZaffWfxx queryWfxxb(ZaffWfxx entity) {
		return wfxxbDao.queryWfxxbById(entity);
	}
	/**
	 * 
	 * @Title: saveWfxxb
	 * @Description: TODO(同时插入空间表和属性表操作)
	 * @param  entity    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	@Override
	public void saveWfxxb(ZaffWfxx entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		setSaveProperties(entity, sessionBean);
//		wfxxDao.insertWfPt(entity);
		wfxxbDao.insertWfxxb(entity);
	}
	
	/**
	 * 
	 * @Title: updateWfxxb
	 * @Description: TODO(同时修改空间表和属性表操作)
	 * @param  entity    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	@Override
	public int updateWfxxb(ZaffWfxx entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
//		wfxxDao.updateWfPt(entity);
		return wfxxbDao.updateWfxxb(entity);
	}
	
	public List<DwContextCombo> searchXqContext(DwContextCondition condition) {
		return wfxxbDao.searchXqContext(condition);
	}

}
