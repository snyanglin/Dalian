package com.founder.zafffwqz.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.UUID;
import com.founder.zafffwqz.bean.Dsrxxzb;
import com.founder.zafffwqz.bean.DxqzxhdCbfxxb;
import com.founder.zafffwqz.bean.DxqzxhdFspxxb;
import com.founder.zafffwqz.dao.DxqzxhdCbfxxbDao;
import com.founder.zafffwqz.dao.DxqzxhdfsplDao;
import com.founder.zafffwqz.service.DxqzxhdCbfxxbService;
import com.founder.zafffwqz.service.DxqzxhdfsplService;


/******************************************************************************
 * @Package:      [com.founder.zafffwqz.service.impl.DxqzxhdfsplServiceImpl.java]  
 * @ClassName:    [DxqzxhdfsplServiceImpl]   
 * @Description:  [大型社会活动信息-非审批ServiceImpl]   
 * @Author:       [xu_haibo@founder.com.cn]  
 * @CreateDate:   [2015-5-21 上午9:36:19]   
 * @UpdateUser:   [haibo(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-21 上午9:36:19，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@Service("DxqzxhdfsplService")
@Transactional
public class DxqzxhdfsplServiceImpl implements DxqzxhdfsplService {

	@Resource(name = "dxqzxhdfsplDao")
	private DxqzxhdfsplDao dxqzxhdfsplDao;

	/**
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return 设定文件
	 * @return DxqzxhdCbfxxb 返回类型
	 * @throws
	 */
	public DxqzxhdFspxxb queryById(String id) {
		return dxqzxhdfsplDao.queryById(id);
	}

	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	public void save(DxqzxhdFspxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create()); // 生成主键
		BaseService.setSaveProperties(entity, sessionBean);
		dxqzxhdfsplDao.save(entity, sessionBean);
	}

	/**
	 * 更新<br>
	 * 
	 * @param entity
	 */
	public void modifyFsp(DxqzxhdFspxxb entity, SessionBean sessionBean) {
		BaseService.setUpdateProperties(entity, sessionBean);
		dxqzxhdfsplDao.modifyFsp(entity, sessionBean);
	}

	/**
	 * 删除<br>
	 * 
	 * @param entity
	 */
	public void delete(DxqzxhdFspxxb entity, SessionBean sessionBean) {
		BaseService.setCrossoutProperties(entity, sessionBean);
		dxqzxhdfsplDao.delete(entity, sessionBean);
	}
	
	/**
	 * 查询<br>
	 * 
	 * @param entity
	 */
	@Override
	public DxqzxhdFspxxb queryDxqzxhdFspxxb(DxqzxhdFspxxb entity) {
		return dxqzxhdfsplDao.queryDxqzxhdFspxxb(entity);
	}

	/**
	 * 分页查询<br>
	 * 
	 * @param entity
	 */
	@Override
	public EasyUIPage queryList(EasyUIPage page, Map map) {
		return dxqzxhdfsplDao.queryList(page, map);
	}
}
