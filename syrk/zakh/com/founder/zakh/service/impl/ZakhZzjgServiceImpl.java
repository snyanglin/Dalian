package com.founder.zakh.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.service.BaseService;
import com.founder.zakh.bean.ZakhZzjgBean;
import com.founder.zakh.dao.ZakhZzgjDao;
import com.founder.zakh.service.ZakhZzjgService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
@Service("zakhZzjgService")
@Transactional
public class ZakhZzjgServiceImpl extends BaseService implements ZakhZzjgService {
	@Resource(name = "zakhZzgjDao")
	private ZakhZzgjDao zakhZzgjDao;
	
	
	@Override
	public List<ZakhZzjgBean> getFjZzjg() {
		// TODO Auto-generated method stub
		List<ZakhZzjgBean> zzjgList = zakhZzgjDao.query();
		return zzjgList;
	}
	@Override
	public List<ZakhZzjgBean> getPcsZzjg(String orgcode) {
		// TODO Auto-generated method stub
		//zakhZzjgBean.setOrgcode(orgcode);
		List<ZakhZzjgBean> zzjgList =zakhZzgjDao.pcsQuery(orgcode);
	
		return zzjgList;
	}


	@Override
	public List<ZakhZzjgBean> getSqZzjg(String orgcode) {
		// TODO Auto-generated method stub
		List<ZakhZzjgBean> zzjgList = zakhZzgjDao.xqQuery(orgcode);
		return zzjgList;
	}
	@Test
    public void test(){
		//getPcsZzjg("210202000000");
		//getFjZzjg();
		getSqZzjg("210202440000");
	}
}
