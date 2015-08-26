package com.founder.spsxt.dao;

import java.util.List;


import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;


@Repository("spsxtDictionaryDao")
public class SpsxtDictionaryDao extends BaseDaoImpl {

	//查询全部字典列表(简单字典)
	public List querySpsxtDictionary(){
		return super.queryForList("SpsxtDictionary.querySpsxtDictionary");
		
	}	

	//获得组织机构Tree
	public List getQueryOrgnaizationTree(){
		return super.queryForList("SpsxtDictionary.queryOrgnaizationTree");
	}

	//行业类别树
	public List getQueryIndustryTree(){
		return super.queryForList("SpsxtDictionary.queryIndustryTree");
	}	
	
	//分辨率树
	public List getQueryResolutionTree(){
		return super.queryForList("SpsxtDictionary.queryResolutionTree");
	}
	
	//是否夜视树
	public List getQuerySightTree(){
		return super.queryForList("SpsxtDictionary.querySightTree");
	}	
	//属性tree
	public List getQueryPropertyTree(){
		return super.queryForList("SpsxtDictionary.queryPropertyTree");
	}
	//为在客户端翻译代码
	public List getQueryForTranslation(){
		return super.queryForList("SpsxtDictionary.queryForTranslation");
	}
}
