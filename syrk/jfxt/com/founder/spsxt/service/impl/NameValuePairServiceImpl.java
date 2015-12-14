package com.founder.spsxt.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.service.BaseService;


import com.founder.spsxt.dao.NameValuePairDao;
import com.founder.spsxt.service.NameValuePairService;





@Service("nameValuePairService")
@Transactional
public class NameValuePairServiceImpl extends BaseService implements NameValuePairService {

	
	@Resource(name = "nameValuePairDao")
	private NameValuePairDao nameValuePairDao;

	@Override
	public List getOrgCodeNameByCondition(Map paramMap) {
		// TODO Auto-generated method stub
		return nameValuePairDao.getOrgCodeNameByCondition(paramMap);
	}

	@Override
	public List getSpdwIdNameByCondition(Map paramMap) {
		// TODO Auto-generated method stub
		return nameValuePairDao.getSpdwIdNameByCondition(paramMap);
	}

	//通用方法
	@Override
	public List getNameValueByCondition(Map paramMap) {
		// TODO Auto-generated method stub
		return nameValuePairDao.getNameValueByCondition(paramMap);
	}

	//根据机构代码查找其所在的2级部门(大连市公安局为第1级),返回值为空，说明本级为大连市公安局，否则为orgCode所在的2级部门
	@Override
	public String get2LevelDepartByOrgCode(String orgCode) {
		// TODO Auto-generated method stub
		//原始值,形如：_210200000000_210200200000_210200200600_
		String parentTreePath=(String)nameValuePairDao.getParentTreePathByOrgCode(orgCode);
		String twoLevelDepartment=null;
		if(parentTreePath!=null && parentTreePath.trim().length()>0 ){
			parentTreePath=parentTreePath.trim().substring(1,parentTreePath.length()-1);
			String[] departmentArray=parentTreePath.split("_");
			if(departmentArray.length==1){
				twoLevelDepartment=orgCode;//自身就是2级部门
			}
			else{
				twoLevelDepartment=departmentArray[1];//第二个元素是2级部门
			}
			
		}
		return twoLevelDepartment;
	}

	//根据2级机构获得平台名称
	public List getPlatformByOrgCode(String ssOrgCode){
		return nameValuePairDao.getPlatformByOrgCode(ssOrgCode);
	}

	@Override
	public String getBjzbzByOrgCode(String ssOrgCode) {
		// TODO Auto-generated method stub
		return nameValuePairDao.getBjzbzByOrgCode(ssOrgCode);
	}

	@Override
	public List getSxtStatistic(Map paramMap) {
		// TODO Auto-generated method stub
		return nameValuePairDao.getSxtStatistic(paramMap);
	}
	//根据机构代码获得计数值作为当前摄像头的编号	
	public int getCurrentCounterValue(String orgCode){
		return nameValuePairDao.getCurrentCounterValue(orgCode);
	}
}
