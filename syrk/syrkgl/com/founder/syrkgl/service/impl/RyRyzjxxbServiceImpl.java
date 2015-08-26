package com.founder.syrkgl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.UUID;
import com.founder.syrkgl.bean.RyRyzjxxb;
import com.founder.syrkgl.dao.RyRyzjxxbDao;
import com.founder.syrkgl.service.RyRyzjxxbService;

/**
 * ****************************************************************************
 * @Package:      [com.founder.syrkgl.service.impl.RyRyzjxxbServiceImpl.java]  
 * @ClassName:    [RyRyzjxxbServiceImpl]   
 * @Description:  [实有人口附加信息-人员证件信息表]   
 * @Author:       [xu_wenjun@founder.com.cn]  
 * @CreateDate:   [2015-4-3 下午3:33:09]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-3 下午3:33:09，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Service("ryRyzjxxbService")
@Transactional
public class RyRyzjxxbServiceImpl implements RyRyzjxxbService {

	@Resource(name = "ryRyzjxxbDao")
	private RyRyzjxxbDao ryRyzjxxbDao;

	/**
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return 设定文件
	 * @return RyRyzjxxb 返回类型
	 * @throws
	 */
	public RyRyzjxxb queryById(String id) {
		return ryRyzjxxbDao.queryById(id);
	}

	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	public void save(RyRyzjxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create()); // 生成主键
		BaseService.setSaveProperties(entity, sessionBean);
		if(queryCount(entity) == 0){
			ryRyzjxxbDao.save(entity, sessionBean);
		}
	}

	/**
	 * 更新<br>
	 * 
	 * @param entity
	 */
	public void update(RyRyzjxxb entity, SessionBean sessionBean) {
		BaseService.setUpdateProperties(entity, sessionBean);
		ryRyzjxxbDao.update(entity, sessionBean);
	}

	/**
	 * 删除<br>
	 * 
	 * @param entity
	 */
	public void delete(RyRyzjxxb entity, SessionBean sessionBean) {
		BaseService.setCrossoutProperties(entity, sessionBean);
		ryRyzjxxbDao.delete(entity, sessionBean);
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
	public Integer queryCount(RyRyzjxxb entity) {
		return ryRyzjxxbDao.queryCount(entity);
	}

}
