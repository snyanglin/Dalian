package com.founder.zdrygl.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.founder.framework.base.service.BaseService;
import com.founder.zdrygl.bean.Zdrylxylbdyb;
import com.founder.zdrygl.dao.ZdrylxylbdybDao;
import com.founder.zdrygl.service.ZdrylxylbdybService;
import com.founder.zdrygl.until.ZdryUntil;

/**
 * 
 * 类描述<br>
 * @author zhangxijiu@founder.com.cn
 * @version 2015-2-2
 * 
 */
@Service("zdrylxylbdybService")
public class ZdrylxylbdybServiceImpl extends BaseService implements ZdrylxylbdybService{
	@Resource(name = "zdrylxylbdybDao")
	private ZdrylxylbdybDao zdrylxylbdybDao;
	
	
	
	@Resource(name = "ZdryUntil")
	private ZdryUntil zdryUntil;
	
	
	/**
	 * 
	 * @Title: getTopList
	 * @Description: 查询当前区域下的一级类别列表
	 * @param @return    设定文件
	 * @return List    返回类型
	 * @throws
	 */
	@Override
	public List getTopList() {		
		String  address =zdryUntil.querySYSConfig();
		return zdrylxylbdybDao.queryListByQydm(address);		
	}

	/**
	 * 
	 * @Title: getChildList
	 * @Description: 查询当前区域下的子类别列表
	 * @param @param lbdm_p
	 * @param @return    设定文件
	 * @return List    返回类型
	 * @throws
	 */
	@Override
	public List getChildList(String lbdm_p) {
		String  address =zdryUntil.querySYSConfig();		
		return zdrylxylbdybDao.queryChildByQydm(address,lbdm_p);		
	}
	
	@Override
	public Zdrylxylbdyb query(Zdrylxylbdyb entity){
		entity.setQydm(zdryUntil.querySYSConfig());
		return zdrylxylbdybDao.query(entity);
	}
}

