package com.founder.zdry.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.UUID;
import com.founder.zdry.bean.ZdryZagltdxxb;
import com.founder.zdry.dao.ZdryZagltdxxbDao;
import com.founder.zdry.service.ZdryZagltdxxbService;

/******************************************************************************
 * @Package: [com.founder.zdry.service.ZdryZagltdxxbServiceImpl.java]
 * @ClassName: [ZdryZagltdxxbServiceImpl]
 * @Description: [重点人员补充信息－作案规律特点]
 * @Author: [hongguanjun]
 * @CreateDate: [2015-3-12 上午10:35:29]
 * @UpdateUser: [hongguanjun(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-3-12 上午10:35:29，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */

@Service("zdryZagltdxxbService")
@Transactional
public class ZdryZagltdxxbServiceImpl implements ZdryZagltdxxbService {

	@Resource(name = "zdryZagltdxxbDao")
	private ZdryZagltdxxbDao zdryZagltdxxbDao;

	/**
	 * 查询列表<br>
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	public EasyUIPage queryList(EasyUIPage page, ZdryZagltdxxb entity) {
		return zdryZagltdxxbDao.queryList(page, entity);
	}

	/**
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return 设定文件
	 * @return ZdryZagltdxxb 返回类型
	 * @throws
	 */
	public ZdryZagltdxxb queryById(String id) {
		return zdryZagltdxxbDao.queryById(id);
	}

	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	public void save(ZdryZagltdxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create()); // 生成主键
		BaseService.setSaveProperties(entity, sessionBean);
		zdryZagltdxxbDao.save(entity, sessionBean);
	}

	/**
	 * 更新<br>
	 * 
	 * @param entity
	 */
	public void update(ZdryZagltdxxb entity, SessionBean sessionBean) {
		BaseService.setUpdateProperties(entity, sessionBean);
		zdryZagltdxxbDao.update(entity, sessionBean);
	}

	/**
	 * 删除<br>
	 * 
	 * @param entity
	 */
	public void delete(ZdryZagltdxxb entity, SessionBean sessionBean) {
		BaseService.setCrossoutProperties(entity, sessionBean);
		zdryZagltdxxbDao.delete(entity, sessionBean);
	}

	/**
	 * 删除批量<br>
	 * 
	 * @param entity
	 */
	public void deletePatch(ZdryZagltdxxb[] entityArray, SessionBean sessionBean) {
		for (int i = 0; i < entityArray.length; i++) {
			BaseService.setCrossoutProperties(entityArray[i], sessionBean);
			zdryZagltdxxbDao.delete(entityArray[i], sessionBean);
		}
	}

}
