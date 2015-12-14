package com.founder.syrkgl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.UUID;
import com.founder.syrkgl.bean.RyRytbtsbjxxb;
import com.founder.syrkgl.dao.RyRytbtsbjxxbDao;
import com.founder.syrkgl.service.RyRytbtsbjxxbService;

/**
 * ****************************************************************************
 * @Package:      [com.founder.syrkgl.service.impl.RyRytbtsbjxxbServiceImpl.java]  
 * @ClassName:    [RyRytbtsbjxxbServiceImpl]   
 * @Description:  [实有人口附加信息-人员体表特殊标记信息表]   
 * @Author:       [xu_wenjun@founder.com.cn]  
 * @CreateDate:   [2015-4-12 下午11:28:42]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-12 下午11:28:42，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Service("ryRytbtsbjxxbService")
@Transactional
public class RyRytbtsbjxxbServiceImpl implements RyRytbtsbjxxbService {

	@Resource(name = "ryRytbtsbjxxbDao")
	private RyRytbtsbjxxbDao ryRytbtsbjxxbDao;

	/**
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return 设定文件
	 * @return RyRytbtsbjxxb 返回类型
	 * @throws
	 */
	public RyRytbtsbjxxb queryById(String id) {
		return ryRytbtsbjxxbDao.queryById(id);
	}

	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	public void save(RyRytbtsbjxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create()); // 生成主键
		BaseService.setSaveProperties(entity, sessionBean);
		ryRytbtsbjxxbDao.save(entity, sessionBean);
	}

	/**
	 * 更新<br>
	 * 
	 * @param entity
	 */
	public void update(RyRytbtsbjxxb entity, SessionBean sessionBean) {
		BaseService.setUpdateProperties(entity, sessionBean);
		ryRytbtsbjxxbDao.update(entity, sessionBean);
	}

	/**
	 * 删除<br>
	 * 
	 * @param entity
	 */
	public void delete(RyRytbtsbjxxb entity, SessionBean sessionBean) {
		BaseService.setCrossoutProperties(entity, sessionBean);
		ryRytbtsbjxxbDao.delete(entity, sessionBean);
	}

	/**
	 * @Title: queryCount
	 * @Description: TODO(根据条件查询记录数)
	 * @param @param entity
	 * @param @return 设定文件
	 * @return Integer 返回类型
	 * @throws
	 */
	@Override
	public Integer queryCount(RyRytbtsbjxxb entity) {
		return ryRytbtsbjxxbDao.queryCount(entity);
	}

}
