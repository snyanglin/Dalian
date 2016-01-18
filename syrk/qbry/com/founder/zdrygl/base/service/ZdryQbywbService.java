package com.founder.zdrygl.base.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.UUID;
import com.founder.zdrygl.base.dao.ZdryQbywbDao;
import com.founder.zdrygl.base.model.ZdryQbywb;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.base.service.ZdryQbywbService.java]  
 * @ClassName:    [ZdryQbywbService]   
 * @Description:  [情报人员业务操作服务类]   
 * @Author:       [zhang.hai@founder.com.cn]  
 * @CreateDate:   [2015年12月25日 上午10:58:23]   
 * @UpdateUser:   [ZhangHai(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年12月25日 上午10:58:23，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Service("zdryQbywbService")
public class ZdryQbywbService {
	
	@Autowired
	private ZdryQbywbDao zdryQbywbDao;
	
	/**
	 * 
	 * @Title: insert
	 * @Description: TODO(添加业务操作记录)
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throw
	 */
	public void insert(ZdryQbywb entity,SessionBean sessionBean){
		entity.setId(UUID.create());
		BaseService.setSaveProperties(entity, sessionBean);
		zdryQbywbDao.save(entity);
	}
	
	/**
	 * 
	 * @Title: queryListByZjhm
	 * @Description: TODO(根据证件号码查询记录列表，按时间倒序排列)
	 * @param @param zjhm
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throw
	 */
	public EasyUIPage queryListByZjhm(String zjhm,EasyUIPage page,ZdryQbywb entity) {
		return zdryQbywbDao.queryListByZjhm(zjhm,page,entity);
	}
}
