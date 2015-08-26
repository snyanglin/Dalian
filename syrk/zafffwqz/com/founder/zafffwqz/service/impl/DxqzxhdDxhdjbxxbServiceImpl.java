package com.founder.zafffwqz.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.UUID;
import com.founder.zafffwqz.bean.DxqzxhdDxhdjbxxb;
import com.founder.zafffwqz.dao.DxqzxhdDxhdjbxxbDao;
import com.founder.zafffwqz.service.DxqzxhdDxhdjbxxbService;

/******************************************************************************
 * @Package:      [com.founder.zafffwqz.service.impl.DxqzxhdDxhdjbxxbServiceImpl.java]  
 * @ClassName:    [DxqzxhdDxhdjbxxbServiceImpl]   
 * @Description:  [大型群众性活动管理-大型活动基本信息表]   
 * @Author:       [xuhaibo@founder.com.cn]  
 * @CreateDate:   [2015-5-14 中午12:50:47]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-14 中午12:50:47，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@Service("DxqzxhdDxhdjbxxbService")
@Transactional
public class DxqzxhdDxhdjbxxbServiceImpl implements DxqzxhdDxhdjbxxbService {

	@Resource(name = "dxqzxhdDxhdjbxxbDao")
	private DxqzxhdDxhdjbxxbDao dxqzxhdDxhdjbxxbDao;

	/**
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return 设定文件
	 * @return DxqzxhdDxhdjbxxb 返回类型
	 * @throws
	 */
	public DxqzxhdDxhdjbxxb queryById(String id) {
		return dxqzxhdDxhdjbxxbDao.queryById(id);
	}

	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	public void save(DxqzxhdDxhdjbxxb entity, SessionBean sessionBean) {
		entity.setHdid(UUID.create()); // 生成主键
		BaseService.setSaveProperties(entity, sessionBean);
		dxqzxhdDxhdjbxxbDao.save(entity, sessionBean);
	}

	/**
	 * 更新<br>
	 * 
	 * @param entity
	 */
	public void update(DxqzxhdDxhdjbxxb entity, SessionBean sessionBean) {
		BaseService.setUpdateProperties(entity, sessionBean);
		dxqzxhdDxhdjbxxbDao.update(entity, sessionBean);
	}

	/**
	 * 删除<br>
	 * 
	 * @param entity
	 */
	public void delete(DxqzxhdDxhdjbxxb entity, SessionBean sessionBean) {
		BaseService.setCrossoutProperties(entity, sessionBean);
		dxqzxhdDxhdjbxxbDao.delete(entity, sessionBean);
	}

	/**
	 * 查询列表<br>
	 * 
	 * @param entity
	 */
	@Override
	public EasyUIPage queryList(EasyUIPage page, Map map) {
		return dxqzxhdDxhdjbxxbDao.queryList(page, map);
	}
}
