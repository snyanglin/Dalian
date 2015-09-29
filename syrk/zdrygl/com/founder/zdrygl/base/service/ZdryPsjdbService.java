package com.founder.zdrygl.base.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.UUID;
import com.founder.zdrygl.base.dao.ZdryPsjdbDao;
import com.founder.zdrygl.base.model.ZdryPsjdb;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.base.service.ZdryPsjdbService.java]  
 * @ClassName:    [ZdryPsjdbService]   
 * @Description:  [评审鉴定 服务类]   
 * @Author:       [zhang.hai@founder.com.cn]  
 * @CreateDate:   [2015年9月29日 下午3:32:36]   
 * @UpdateUser:   [ZhangHai(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年9月29日 下午3:32:36，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Service("zdryPsjdbService")
@Transactional
public class ZdryPsjdbService extends BaseService {

	@Resource(name = "zdryPsjdbDao")
	private ZdryPsjdbDao zdryPsjdbDao;

	/**
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return 设定文件
	 * @return ZdryPsjdb 返回类型
	 * @throws
	 */	
	public ZdryPsjdb queryById(String id) {
		return zdryPsjdbDao.queryById(id);
	}

	public void save(ZdryPsjdb entity, SessionBean sessionBean) {
		entity.setId(UUID.create()); // 生成主键
		BaseService.setSaveProperties(entity, sessionBean);
		zdryPsjdbDao.save(entity, sessionBean);
		//sendMessage(entity, sessionBean);
	}
	
	public void update(ZdryPsjdb entity, SessionBean sessionBean) {
		BaseService.setUpdateProperties(entity, sessionBean);
		zdryPsjdbDao.update(entity, sessionBean);
	}

	
}
