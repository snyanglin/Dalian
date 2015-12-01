package com.founder.spsxt.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;

import com.founder.spsxt.bean.Spjsdw;
import com.founder.spsxt.dao.SpjkxtDao;
import com.founder.spsxt.dao.SpjsdwDao;
import com.founder.spsxt.dao.SpsxtDao;
import com.founder.spsxt.service.SpjsdwService;



@Service("spjsdwService")
@Transactional
public class SpjsdwServiceImpl extends BaseService implements SpjsdwService {

	@Resource(name = "spjsdwDao")
	private SpjsdwDao spjsdwDao;
	@Resource(name = "spjkxtDao")
	private SpjkxtDao spjkxtDao;

	@Resource(name = "spsxtDao")
	private SpsxtDao spsxtDao;

	//根据主键查询
	@Override
	public Spjsdw querySpjsdwByDwbm(String dwbm) {
		// TODO Auto-generated method stub
		return spjsdwDao.querySpjsdwByDwbm(dwbm);
		
	}
	//根据派出所编码和民警警号查询
	@Override
	public List queryByPcsPoliceId(String pcsbm,String policeId){
		Map<String,String> paramMap=new HashMap<String,String>();
		
		paramMap.put("pcsbm", pcsbm);
		paramMap.put("policeId", policeId);
		return spjsdwDao.queryByPcsPoliceId(paramMap);
	}
	
	@Override
	public List getGazjByDw(String dwbm){
		Map<String,String> paramMap=new HashMap<String,String>();
		paramMap.put("dwbm", dwbm);
		return spjsdwDao.getGazjByDw(paramMap);
	}
	
	//分页查询
	@Override
	public EasyUIPage queryList(EasyUIPage page, Map map) {
		// TODO Auto-generated method stub
		return spjsdwDao.queryList(page, map);
	}
	//新增建设单位
	@Override
	public void insertSpjsdw(Spjsdw entity, SessionBean sessionBean) {
		// TODO Auto-generated method stub
		setSaveProperties(entity, sessionBean);//设置父类共同项
		spjsdwDao.insertSpjsdw(entity);		
	}
	//修改建设单位
	@Override
	public void updateSpjsdw(Spjsdw entity, SessionBean sessionBean) {
		// TODO Auto-generated method stub
		setUpdateProperties(entity, sessionBean);//设置父类共同项
		spjsdwDao.updateSpjsdw(entity);
		
	}
	//删除视频建设单位,视频监控系统，视频摄像头(级联删除)
	@Override
	public String deleteSpjsdwByDwbm(String dwbm) {
		// TODO Auto-generated method stub
		//根据视频建设单位id删除摄像头(级联删除)
		int affectedRow1=spsxtDao.deleteSxtBySpdwId(dwbm);		
		//视频监控系统
		int affectedRow2=spjkxtDao.deleteSpjkxtByDwbm(dwbm);
		//视频建设单位
		int affectedRow3=spjsdwDao.deleteSpjsdwByDwbm(dwbm);
		return affectedRow1+"/"+affectedRow2+"/"+affectedRow3;
	}
	//通用分页查询
	@Override
	public EasyUIPage queryListByBmid(EasyUIPage page, Map map) {
		// TODO Auto-generated method stub
		return spjsdwDao.queryListByBmid(page, map);
	}
	@Override
	public List queryByBmid(Map paramMap) {
		// TODO Auto-generated method stub
		return spjsdwDao.queryByBmid(paramMap);
	}

	@Override	
	public Integer checkSameName(Map map){
		return spjsdwDao.checkSameName(map);		
	}
	@Override
	public List getDepartmentBasicInfoByPy(String pcsbm,String policeId,String py) {
		// TODO Auto-generated method stub
		Map<String,String> paramMap=new HashMap<String,String>();
		paramMap.put("pcsbm",pcsbm);
		paramMap.put("policeId",policeId);
		paramMap.put("py",py);
		
		return spjsdwDao.getDepartmentBasicInfoByPy(paramMap);
	}
	@Override
	public List getDepartmentInfoByDwId(String dwId) {
		// TODO Auto-generated method stub
		return spjsdwDao.getDepartmentInfoByDwId(dwId);
	}
	@Override
	public Integer isUniqueForSpjsdw(String dwbm) {
		// TODO Auto-generated method stub
		return spjsdwDao.isUniqueForSpjsdw(dwbm);
	}
}
