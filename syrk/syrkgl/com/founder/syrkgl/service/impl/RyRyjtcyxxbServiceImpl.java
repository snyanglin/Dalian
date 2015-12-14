package com.founder.syrkgl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.UUID;
import com.founder.syrkgl.bean.RyRyjtcyxxb;
import com.founder.syrkgl.dao.RyRyjtcyxxbDao;
import com.founder.syrkgl.service.RyRyjtcyxxbService;

/**
 * ****************************************************************************
 * @Package:      [com.founder.syrkgl.service.impl.RyRyjtcyxxbServiceImpl.java]  
 * @ClassName:    [RyRyjtcyxxbServiceImpl]   
 * @Description:  [实有人口附加信息-人员家庭成员信息表]   
 * @Author:       [xu_wenjun@founder.com.cn]  
 * @CreateDate:   [2015-4-10 上午9:44:55]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-10 上午9:44:55，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Service("ryRyjtcyxxbService")
@Transactional
public class RyRyjtcyxxbServiceImpl implements RyRyjtcyxxbService {

	@Resource(name = "ryRyjtcyxxbDao")
	private RyRyjtcyxxbDao ryRyjtcyxxbDao;

	/**
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return 设定文件
	 * @return RyRyjtcyxxb 返回类型
	 * @throws
	 */
	public RyRyjtcyxxb queryById(String id) {
		return ryRyjtcyxxbDao.queryById(id);
	}

	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	public void save(RyRyjtcyxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create()); // 生成主键
		BaseService.setSaveProperties(entity, sessionBean);
		ryRyjtcyxxbDao.save(entity, sessionBean);
	}

	/**
	 * 更新<br>
	 * 
	 * @param entity
	 */
	public void update(RyRyjtcyxxb entity, SessionBean sessionBean) {
		BaseService.setUpdateProperties(entity, sessionBean);
		ryRyjtcyxxbDao.update(entity, sessionBean);
	}

	/**
	 * 删除<br>
	 * 
	 * @param entity
	 */
	public void delete(RyRyjtcyxxb entity, SessionBean sessionBean) {
		BaseService.setCrossoutProperties(entity, sessionBean);
		ryRyjtcyxxbDao.delete(entity, sessionBean);
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
	public Integer queryCount(RyRyjtcyxxb entity) {
		return ryRyjtcyxxbDao.queryCount(entity);
	}

}
