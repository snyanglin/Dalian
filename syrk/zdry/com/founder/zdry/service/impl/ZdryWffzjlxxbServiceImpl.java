package com.founder.zdry.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.UUID;
import com.founder.zdry.bean.ZdryWffzjlxxb;
import com.founder.zdry.dao.ZdryWffzjlxxbDao;
import com.founder.zdry.service.ZdryWffzjlxxbService;

/******************************************************************************
 * @Package: [com.founder.zdry.service.ZdryWffzjlxxbServiceImpl.java]
 * @ClassName: [ZdryWffzjlxxbServiceImpl]
 * @Description: [重点人员补充信息－违法犯罪记录]
 * @Author: [hongguanjun]
 * @CreateDate: [2015-3-12 上午10:35:29]
 * @UpdateUser: [hongguanjun(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-3-12 上午10:35:29，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */

@Service("zdryWffzjlxxbService")
@Transactional
public class ZdryWffzjlxxbServiceImpl implements ZdryWffzjlxxbService {

	@Resource(name = "zdryWffzjlxxbDao")
	private ZdryWffzjlxxbDao zdryWffzjlxxbDao;

	/**
	 * 查询列表<br>
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	public EasyUIPage queryList(EasyUIPage page, ZdryWffzjlxxb entity) {
		return zdryWffzjlxxbDao.queryList(page, entity);
	}

	/**
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return 设定文件
	 * @return ZdryWffzjlxxb 返回类型
	 * @throws
	 */
	public ZdryWffzjlxxb queryById(String id) {
		return zdryWffzjlxxbDao.queryById(id);
	}

	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	public void save(ZdryWffzjlxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create()); // 生成主键
		BaseService.setSaveProperties(entity, sessionBean);
		zdryWffzjlxxbDao.save(entity, sessionBean);
	}

	/**
	 * 更新<br>
	 * 
	 * @param entity
	 */
	public void update(ZdryWffzjlxxb entity, SessionBean sessionBean) {
		BaseService.setUpdateProperties(entity, sessionBean);
		
		if("1".equals(entity.getAjlxdm())){
			entity.setSxs_ajlbdm("");
		}else if("2".equals(entity.getAjlxdm())){
			entity.setSxz_ajlbdm("");
		}
		zdryWffzjlxxbDao.update(entity, sessionBean);
	}

	/**
	 * 删除<br>
	 * 
	 * @param entity
	 */
	public void delete(ZdryWffzjlxxb entity, SessionBean sessionBean) {
		BaseService.setCrossoutProperties(entity, sessionBean);
		zdryWffzjlxxbDao.delete(entity, sessionBean);
	}

	/**
	 * 删除批量<br>
	 * 
	 * @param entity
	 */
	public void deletePatch(ZdryWffzjlxxb[] entityArray, SessionBean sessionBean) {
		for (int i = 0; i < entityArray.length; i++) {
			BaseService.setCrossoutProperties(entityArray[i], sessionBean);
			zdryWffzjlxxbDao.delete(entityArray[i], sessionBean);
		}
	}

}
