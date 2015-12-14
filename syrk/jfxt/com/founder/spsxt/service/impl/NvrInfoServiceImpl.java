package com.founder.spsxt.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.spsxt.bean.NvrInfo;
import com.founder.spsxt.dao.NvrInfoDao;
import com.founder.spsxt.dao.SpsxtDao;
import com.founder.spsxt.service.NvrInfoService;




@Service("nvrInfoService")
@Transactional
public class NvrInfoServiceImpl extends BaseService implements NvrInfoService {

	
	@Resource(name = "nvrInfoDao")
	private NvrInfoDao nvrInfoDao;

	//摄像头
	@Resource(name="spsxtDao")
	private SpsxtDao spsxtDao;
	
	@Override
	public void insertNvrInfo(NvrInfo entity, SessionBean sessionBean) {
		// TODO Auto-generated method stub
		setSaveProperties(entity, sessionBean);//用sessionBean为BaseEntity赋值
		nvrInfoDao.insertNvrInfo(entity);		
	}

	@Override
	public void updateNvrInfo(NvrInfo entity, SessionBean sessionBean) {
		// TODO Auto-generated method stub
		setUpdateProperties(entity, sessionBean);
		nvrInfoDao.updateNvrInfo(entity);
		
	}

	@Override
	public NvrInfo queryNvrInfoById(String id) {
		// TODO Auto-generated method stub
		return nvrInfoDao.queryNvrInfoById(id);
	}

	//删除NVR极其关联的摄像头(顺序不能颠倒!)
	@Override
	public String deleteNvrInfoById(String id) {
		// TODO Auto-generated method stub
		int affectedRow1=spsxtDao.deleteSxtByNvrId(id);//根据NVRID删除摄像头
		int affectedRow2=nvrInfoDao.deleteNvrInfoById(id);//删除NVR		
		return affectedRow1+"/"+affectedRow2;
	}

	@Override
	public EasyUIPage pageQueryByCondition(EasyUIPage page, Map map) {
		// TODO Auto-generated method stub
		return nvrInfoDao.pageListByCondition(page, map);
	}
	@Override	
	public List getNVRByPt(String dwbm){
		return nvrInfoDao.getNVRByPt(dwbm);
	}
	@Override
	public int isUniqueForPlatformName(Map paramMap) {
		// TODO Auto-generated method stub
		return nvrInfoDao.isUniqueForPlatformName(paramMap);
	}
}
