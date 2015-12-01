package com.founder.zdry.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.UUID;
import com.founder.zdry.bean.ZdryJkbjllxxb;
import com.founder.zdry.dao.ZdryJkbjllxxbDao;
import com.founder.zdry.service.ZdryJkbjllxxbService;

/******************************************************************************
 * @Package: [com.founder.zdry.service.ZdryJkbjllxxbServiceImpl.java]
 * @ClassName: [ZdryJkbjllxxbServiceImpl]
 * @Description: [重点人员补充信息－监控帮教力量]
 * @Author: [hongguanjun]
 * @CreateDate: [2015-3-12 上午10:35:29]
 * @UpdateUser: [hongguanjun(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-3-12 上午10:35:29，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */

@Service("zdryJkbjllxxbService")
@Transactional
public class ZdryJkbjllxxbServiceImpl implements ZdryJkbjllxxbService {

	@Resource(name = "zdryJkbjllxxbDao")
	private ZdryJkbjllxxbDao zdryJkbjllxxbDao;

	/**
	 * 查询列表<br>
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	public EasyUIPage queryList(EasyUIPage page, ZdryJkbjllxxb entity) {
		return zdryJkbjllxxbDao.queryList(page, entity);
	}

	/**
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return 设定文件
	 * @return ZdryJkbjllxxb 返回类型
	 * @throws
	 */
	public ZdryJkbjllxxb queryById(String id) {
		return zdryJkbjllxxbDao.queryById(id);
	}

	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	public void save(ZdryJkbjllxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create()); // 生成主键
		BaseService.setSaveProperties(entity, sessionBean);
		zdryJkbjllxxbDao.save(entity, sessionBean);
	}

	/**
	 * 更新<br>
	 * 
	 * @param entity
	 */
	public void update(ZdryJkbjllxxb entity, SessionBean sessionBean) {
		BaseService.setUpdateProperties(entity, sessionBean);
		zdryJkbjllxxbDao.update(entity, sessionBean);
	}

	/**
	 * 删除<br>
	 * 
	 * @param entity
	 */
	public void delete(ZdryJkbjllxxb entity, SessionBean sessionBean) {
		BaseService.setCrossoutProperties(entity, sessionBean);
		zdryJkbjllxxbDao.delete(entity, sessionBean);
	}

	/**
	 * 删除批量<br>
	 * 
	 * @param entity
	 */
	public void deletePatch(ZdryJkbjllxxb[] entityArray, SessionBean sessionBean) {
		for (int i = 0; i < entityArray.length; i++) {
			BaseService.setCrossoutProperties(entityArray[i], sessionBean);
			zdryJkbjllxxbDao.delete(entityArray[i], sessionBean);
		}
	}

	/**
	 * @Title: queryBjryIsExist
	 * @Description: TODO(帮教人员是否存在，对于同一个重点人员)
	 * @param @param entity
	 * @param @return 设定文件
	 * @return ZdryJkbjllxxb 返回类型
	 * @throws
	 */
	public boolean existBjry(ZdryJkbjllxxb entity) {
		return zdryJkbjllxxbDao.existBjry(entity);
	}
}
