package com.founder.syrkgl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.UUID;
import com.founder.syrkgl.bean.RyRytmtzxxb;
import com.founder.syrkgl.dao.RyRytmtzxxbDao;
import com.founder.syrkgl.service.RyRytmtzxxbService;

/**
 * ****************************************************************************
 * @Package:      [com.founder.syrkgl.service.impl.RyRytmtzxxbServiceImpl.java]  
 * @ClassName:    [RyRytmtzxxbServiceImpl]   
 * @Description:  [实有人口附加信息-人员体貌特征信息表]   
 * @Author:       [xu_wenjun@founder.com.cn]  
 * @CreateDate:   [2015-4-12 下午4:33:08]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-12 下午4:33:08，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Service("ryRytmtzxxbService")
@Transactional
public class RyRytmtzxxbServiceImpl implements RyRytmtzxxbService {

	@Resource(name = "ryRytmtzxxbDao")
	private RyRytmtzxxbDao ryRytmtzxxbDao;

	/**
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return 设定文件
	 * @return RyRytmtzxxb 返回类型
	 * @throws
	 */
	public RyRytmtzxxb queryById(String id) {
		return ryRytmtzxxbDao.queryById(id);
	}

	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	public void save(RyRytmtzxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create()); // 生成主键
		BaseService.setSaveProperties(entity, sessionBean);
		ryRytmtzxxbDao.save(entity, sessionBean);
	}

	/**
	 * 更新<br>
	 * 
	 * @param entity
	 */
	public void update(RyRytmtzxxb entity, SessionBean sessionBean) {
		BaseService.setUpdateProperties(entity, sessionBean);
		ryRytmtzxxbDao.update(entity, sessionBean);
	}

	/**
	 * 删除<br>
	 * 
	 * @param entity
	 */
	public void delete(RyRytmtzxxb entity, SessionBean sessionBean) {
		BaseService.setCrossoutProperties(entity, sessionBean);
		ryRytmtzxxbDao.delete(entity, sessionBean);
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
	public Integer queryCount(RyRytmtzxxb entity) {
		return ryRytmtzxxbDao.queryCount(entity);
	}

}
