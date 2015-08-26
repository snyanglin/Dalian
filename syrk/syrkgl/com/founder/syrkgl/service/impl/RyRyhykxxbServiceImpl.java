package com.founder.syrkgl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.UUID;
import com.founder.syrkgl.bean.RyRyhykxxb;
import com.founder.syrkgl.dao.RyRyhykxxbDao;
import com.founder.syrkgl.service.RyRyhykxxbService;

/******************************************************************************
 * @Package:      [com.founder.syrkgl.service.impl.RyRyhykxxbServiceImpl.java]  
 * @ClassName:    [RyRyhykxxbServiceImpl]   
 * @Description:  [实有人口附加信息-人员会员卡信息表]   
 * @Author:       [congrihong@founder.com.cn]  
 * @CreateDate:   [2015-4-8 下午4:53:58]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-8 下午4:53:58，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@Service("ryRyhykxxbService")
@Transactional
public class RyRyhykxxbServiceImpl implements RyRyhykxxbService {

	@Resource(name = "ryRyhykxxbDao")
	private RyRyhykxxbDao ryRyhykxxbDao;

	/**
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return 设定文件
	 * @return Rybmchxxb 返回类型
	 * @throws
	 */
	public RyRyhykxxb queryById(String id) {
		return ryRyhykxxbDao.queryById(id);
	}

	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	public void save(RyRyhykxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create()); // 生成主键
		BaseService.setSaveProperties(entity, sessionBean);
		ryRyhykxxbDao.save(entity, sessionBean);
	}

	/**
	 * 更新<br>
	 * 
	 * @param entity
	 */
	public void update(RyRyhykxxb entity, SessionBean sessionBean) {
		BaseService.setUpdateProperties(entity, sessionBean);
		ryRyhykxxbDao.update(entity, sessionBean);
	}

	/**
	 * 删除<br>
	 * 
	 * @param entity
	 */
	public void delete(RyRyhykxxb entity, SessionBean sessionBean) {
		BaseService.setCrossoutProperties(entity, sessionBean);
		ryRyhykxxbDao.delete(entity, sessionBean);
	}


}
