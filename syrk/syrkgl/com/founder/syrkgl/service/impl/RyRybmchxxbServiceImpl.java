package com.founder.syrkgl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.UUID;
import com.founder.syrkgl.bean.RyRybmchxxb;
import com.founder.syrkgl.dao.RyRybmchxxbDao;
import com.founder.syrkgl.service.RyRybmchxxbService;

/**
 * ****************************************************************************
 * @Package:      [com.founder.syrkgl.service.impl.RyRybmchxxbServiceImpl.java]  
 * @ClassName:    [RyRybmchxxbServiceImpl]   
 * @Description:  [实有人口附加信息-人员别名绰号信息表]   
 * @Author:       [xu_wenjun@founder.com.cn]  
 * @CreateDate:   [2015-4-3 上午10:23:54]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-3 上午10:23:54，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Service("ryRybmchxxbService")
@Transactional
public class RyRybmchxxbServiceImpl implements RyRybmchxxbService {

	@Resource(name = "ryRybmchxxbDao")
	private RyRybmchxxbDao ryRybmchxxbDao;

	/**
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return 设定文件
	 * @return RyRybmchxxb 返回类型
	 * @throws
	 */
	public RyRybmchxxb queryById(String id) {
		return ryRybmchxxbDao.queryById(id);
	}

	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	public void save(RyRybmchxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create()); // 生成主键
		BaseService.setSaveProperties(entity, sessionBean);
		ryRybmchxxbDao.save(entity, sessionBean);
	}

	/**
	 * 更新<br>
	 * 
	 * @param entity
	 */
	public void update(RyRybmchxxb entity, SessionBean sessionBean) {
		BaseService.setUpdateProperties(entity, sessionBean);
		ryRybmchxxbDao.update(entity, sessionBean);
	}

	/**
	 * 删除<br>
	 * 
	 * @param entity
	 */
	public void delete(RyRybmchxxb entity, SessionBean sessionBean) {
		BaseService.setCrossoutProperties(entity, sessionBean);
		ryRybmchxxbDao.delete(entity, sessionBean);
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
	public Integer queryCount(RyRybmchxxb entity) {
		return ryRybmchxxbDao.queryCount(entity);
	}

}
