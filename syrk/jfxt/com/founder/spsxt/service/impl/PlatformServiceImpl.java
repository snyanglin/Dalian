package com.founder.spsxt.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.spsxt.bean.Platform;
import com.founder.spsxt.dao.NvrInfoDao;
import com.founder.spsxt.dao.PlatformDao;
import com.founder.spsxt.dao.SpsxtDao;
import com.founder.spsxt.service.PlatformService;


@Service("platformService")
@Transactional
public class PlatformServiceImpl extends BaseService implements PlatformService {

	
	@Resource(name = "platformDao")
	private PlatformDao platformDao;

	@Resource(name = "nvrInfoDao")
	private NvrInfoDao nvrInfoDao;

	@Resource(name = "spsxtDao")
	private SpsxtDao spsxtDao;
		
	
	@Override
	public void insertPlatform(Platform entity, SessionBean sessionBean) {
		// TODO Auto-generated method stub
		setSaveProperties(entity, sessionBean);//用sessionBean为BaseEntity赋值
		platformDao.insertPlatform(entity);
	}

	@Override
	public void updatePlatform(Platform entity, SessionBean sessionBean) {
		// TODO Auto-generated method stub
		setUpdateProperties(entity, sessionBean);
		platformDao.updatePlatform(entity);
	}

	@Override
	public Platform queryPlatformById(String id) {
		// TODO Auto-generated method stub
		return platformDao.queryPlatformById(id);
	}

	@Override
	public String deletePlatformById(String id) {
		// TODO Auto-generated method stub
		//根据平台id删除公安自建摄像头
		int affectedRow1=spsxtDao.deleteSxtByPtId(id);
		//删除NVR
		int affectedRow2=nvrInfoDao.deleteNvrInfoByPtId(id);
		//删除平台
		int affectedRow3=platformDao.deletePlatformById(id);
		return affectedRow1+"/"+affectedRow2+"/"+affectedRow3;
	}

	@Override
	public EasyUIPage pageQueryByCondition(EasyUIPage page, Map map) {
		// TODO Auto-generated method stub
		return platformDao.pageListByCondition(page, map);
	}
	//获得平台名称和id(为NVR提供下拉列表内容)
	@Override
	public List getPlatformNameAndId(String ssOrgCode) {
		// TODO Auto-generated method stub
		return platformDao.getPlatformNameAndId(ssOrgCode);
	}
	@Override
	public int isUniqueForPlatformName(String ptmc) {
		// TODO Auto-generated method stub
		return platformDao.isUniqueForPlatformName(ptmc);
	}
}
