package com.founder.zdrygl.base.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.founder.framework.base.service.BaseService;
import com.founder.zdrygl.base.dao.ZdrylxylbdybDao;
import com.founder.zdrygl.base.model.Zdrylxylbdyb;
import com.founder.zdrygl.core.inteface.ZdrylxylbdybService;
import com.founder.zdrygl.until.ZdryUntil;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.base.service.ZdrylxylbdybService.java]  
 * @ClassName:    [ZdrylxylbdybService]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [huang_jifei@founder.com.cn]  
 * @CreateDate:   [2015年10月9日 下午1:57:20]   
 * @UpdateUser:   [huangjifei(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年10月9日 下午1:57:20，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Service("zdrylxylbdybService")
public class ZdrylxylbdybServiceImpl  extends BaseService implements ZdrylxylbdybService{
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

