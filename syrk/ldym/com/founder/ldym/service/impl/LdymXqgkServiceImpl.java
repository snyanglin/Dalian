package com.founder.ldym.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.ldym.dao.XqgkDao;
import com.founder.ldym.service.LdymXqgkService;
import com.founder.ldym.vo.XqgkDataCountVo;
import com.founder.sydw_dl.bean.Dwjbxxb;

@Service("ldymXqgkService")
@Transactional
public class LdymXqgkServiceImpl implements LdymXqgkService{

	@Resource(name="xqgkDao")
	private XqgkDao xqgkDao;
	
	@Override
	public XqgkDataCountVo getDataNum(String orgCode) {
		XqgkDataCountVo dataCountVo=xqgkDao.queryYxsjCount(orgCode);
		//如果是大连市公安局
		//if("210200000000".equals(orgCode)){
		dataCountVo.setSyrkTotal(String.valueOf(Long.valueOf(dataCountVo.getCzrkCount())+Long.valueOf(dataCountVo.getJzrkCount())+Long.valueOf(dataCountVo.getLdrkCount())+Long.valueOf(dataCountVo.getJwryCount())+Long.valueOf(dataCountVo.getWlhrkCount())));
		dataCountVo.setSydwTotal(String.valueOf(Long.valueOf(dataCountVo.getLdyCount())+Long.valueOf(dataCountVo.getTzhyCount())+Long.valueOf(dataCountVo.getYlcsCount())+Long.valueOf(dataCountVo.getQthyCount())));
		return dataCountVo;
	}

	@Override
	public List<Dwjbxxb> queryDwjbxxb(Map<String, String> map) {
		
		return null;
	}

}
