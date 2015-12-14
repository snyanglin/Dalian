package com.founder.ldym.service;

import java.util.List;
import java.util.Map;

import com.founder.ldym.vo.XqgkDataCountVo;
import com.founder.sydw_dl.bean.Dwjbxxb;

public interface LdymXqgkService {

	
	
	public XqgkDataCountVo getDataNum(String orgCode);
	
	
	public List<Dwjbxxb> queryDwjbxxb(Map<String,String> map);
}
