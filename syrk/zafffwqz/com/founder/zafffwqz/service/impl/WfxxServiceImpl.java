package com.founder.zafffwqz.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zafffwqz.bean.ZaffWfxx;
import com.founder.zafffwqz.dao.WfxxDao;
import com.founder.zafffwqz.service.WfxxService;
/******************************************************************************
 * @Package:      [com.founder.zafffwqz.service.impl.WfxxServiceImpl.java]  
 * @ClassName:    [WfxxServiceImpl]   
 * @Description:  [物防信息服务层：主要处理空间表操作]   
 * @Author:       [tian_chengwei@founder.com.cn]  
 * @CreateDate:   [2015-5-26 下午4:44:01]   
 * @UpdateUser:   [lk(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-26 下午4:44:01，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 * 
 *  * @review      : wu.w@founder.com.cn
 * @reviewDate  : 20150604
 */
@Service("wfxxService")
@Transactional
public class WfxxServiceImpl extends BaseService implements WfxxService {
	
	@Resource(name = "wfxxDao")
	private WfxxDao wfxxDao;
	/**
	 * 
	 * @Title: queryWf
	 * @Description: TODO(分页查询属性表操作)
	 * @param @param entity    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	@Override
	public EasyUIPage queryWf(EasyUIPage page, ZaffWfxx entity) {
		return wfxxDao.queryWf(page, entity);
	}
	/**
	 * 
	 * @Title: delete
	 * @Description: TODO(删除操作)
	 * @param @param entity    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	@Override
	public void delete(ZaffWfxx entity,SessionBean sessionBean) {
		setCrossoutProperties(entity, sessionBean);
		wfxxDao.deleteSx(entity);
		//wfxxDao.deleteKj(entity);
	}
	/**
	 * 
	 * @Title: updateWf
	 * @Description: TODO(同时更新属性表和空间表操作)
	 * @param  entity    设定文件
	 * @return void    返回类型
	 * @throws
	 */

	@Override
	public void updateWf(ZaffWfxx entity,SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		wfxxDao.updateWfPt(entity);
		wfxxDao.updateWf(entity);
	}
	/**
	 * 
	 * @Title: queryWfxxOnPT
	 * @Description: TODO(属性表和空间表查询操作)
	 * @param  entity    设定文件
	 * @param  page     设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */

	@Override
	public EasyUIPage queryWfxxOnPT(EasyUIPage page, ZaffWfxx entity) {
		return wfxxDao.queryWfxxOnPT(page, entity);
	}

}
