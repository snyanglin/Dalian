package com.founder.zafffwqz.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.UUID;
import com.founder.zafffwqz.bean.DxqzxhdCbfxxb;
import com.founder.zafffwqz.dao.DxqzxhdCbfxxbDao;
import com.founder.zafffwqz.service.DxqzxhdCbfxxbService;

/******************************************************************************
 * @Package:      [com.founder.zafffwqz.service.impl.DxqzxhdCbfxxbServiceImpl.java]  
 * @ClassName:    [DxqzxhdCbfxxbServiceImpl]   
 * @Description:  [大型群众性活动管理-承办方信息表]   
 * @Author:       [xuhaibo@founder.com.cn]  
 * @CreateDate:   [2015-5-14 中午12:50:47]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-14 中午12:50:47，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@Service("DxqzxhdCbfxxbService")
@Transactional
public class DxqzxhdCbfxxbServiceImpl implements DxqzxhdCbfxxbService {

	@Resource(name = "dxqzxhdCbfxxbDao")
	private DxqzxhdCbfxxbDao dxqzxhdCbfxxbDao;

	/**
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return 设定文件
	 * @return DxqzxhdCbfxxb 返回类型
	 * @throws
	 */
	public DxqzxhdCbfxxb queryById(String id) {
		return dxqzxhdCbfxxbDao.queryById(id);
	}

	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	public void save(DxqzxhdCbfxxb entity, SessionBean sessionBean) {
		entity.setHdid(UUID.create()); // 生成主键
		BaseService.setSaveProperties(entity, sessionBean);
		dxqzxhdCbfxxbDao.save(entity, sessionBean);
	}

	/**
	 * 更新<br>
	 * 
	 * @param entity
	 */
	public void update(DxqzxhdCbfxxb entity, SessionBean sessionBean) {
		BaseService.setUpdateProperties(entity, sessionBean);
		dxqzxhdCbfxxbDao.update(entity, sessionBean);
	}

	/**
	 * 删除<br>
	 * 
	 * @param entity
	 */
	public void delete(DxqzxhdCbfxxb entity, SessionBean sessionBean) {
		BaseService.setCrossoutProperties(entity, sessionBean);
		dxqzxhdCbfxxbDao.delete(entity, sessionBean);
	}


}
