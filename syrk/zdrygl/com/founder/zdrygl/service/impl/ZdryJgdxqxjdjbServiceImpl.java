package com.founder.zdrygl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.message.bean.SysMessage;
import com.founder.framework.message.dao.SysMessageDao;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.UUID;
import com.founder.zdrygl.bean.ZdryJgdxqxjdjb;
import com.founder.zdrygl.bean.ZdryZdryzb;
import com.founder.zdrygl.dao.ZdryJgdxqxjdjbDao;
import com.founder.zdrygl.service.ZdryJgdxqxjdjbService;
import com.founder.zdrygl.service.ZdryZdryzbService;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.service.ZdryJgdxqxjdjbService.java]  
 * @ClassName:    [ZdryJgdxqxjdjbService]   
 * @Description:  [监管对象请销假服务类]   
 * @Author:       [zhang.hai@founder.com.cn]  
 * @CreateDate:   [2015年9月6日 下午3:28:12]   
 * @UpdateUser:   [ZhangHai(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年9月6日 下午3:28:12，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Service("zdryJgdxqxjdjbService")
@Transactional
public class ZdryJgdxqxjdjbServiceImpl implements ZdryJgdxqxjdjbService {

	@Resource(name = "zdryJgdxqxjdjbDao")
	private ZdryJgdxqxjdjbDao zdryJgdxqxjdjbDao;

	@Resource(name = "zdryZdryzbService")
	private ZdryZdryzbService zdryZdryzbService;


	/**
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return 设定文件
	 * @return ZdryJgdxqxjdjb 返回类型
	 * @throws
	 */
	@Override
	public ZdryJgdxqxjdjb queryById(String id) {
		return zdryJgdxqxjdjbDao.queryById(id);
	}

	/*
	 * 	 (非 Javadoc)
	 * <p>Title: save</p>
	 * <p>Description: 新增</p>
	 * @param entity
	 * @param sessionBean
	 * @see com.founder.zdrygl.service.ZdryJgdxqxjdjbService#save(com.founder.zdrygl.bean.ZdryJgdxqxjdjb, com.founder.framework.base.entity.SessionBean)
	 */
	@Override
	public void save(ZdryJgdxqxjdjb entity, SessionBean sessionBean) {
		entity.setId(UUID.create()); // 生成主键
		BaseService.setSaveProperties(entity, sessionBean);
		zdryJgdxqxjdjbDao.save(entity, sessionBean);
		//sendQjMessage(entity, sessionBean);
	}

	/*
	 * (非 Javadoc)
	 * <p>Title: update</p>
	 * <p>Description: 更新</p>
	 * @param entity
	 * @param sessionBean
	 * @see com.founder.zdrygl.service.ZdryJgdxqxjdjbService#update(com.founder.zdrygl.bean.ZdryJgdxqxjdjb, com.founder.framework.base.entity.SessionBean)
	 */
	@Override
	public void update(ZdryJgdxqxjdjb entity, SessionBean sessionBean) {
		BaseService.setUpdateProperties(entity, sessionBean);
		zdryJgdxqxjdjbDao.update(entity);
		//sendXjMessage(entity, sessionBean);
	}

	/*
	 * (非 Javadoc)
	 * <p>Title: sfnqj</p>
	 * <p>Description:查询是否可请假 </p>
	 * @param zdryId
	 * @return
	 * @see com.founder.zdrygl.service.ZdryJgdxqxjdjbService#sfnqj(java.lang.String)
	 */
	@Override
	public boolean sfnqj(String zdryId) {		
		if(zdryJgdxqxjdjbDao.queryWxjNum(zdryId)>0){
			return false;
		}
		return true;
	}
}
