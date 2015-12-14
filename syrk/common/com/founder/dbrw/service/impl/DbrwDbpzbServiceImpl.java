package com.founder.dbrw.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.dbrw.bean.DbrwDbpzb;
import com.founder.dbrw.dao.DbrwDbpzbDao;
import com.founder.dbrw.service.DbrwDbpzbService;

@Service("dbrwDbpzbService")
@Transactional
public class DbrwDbpzbServiceImpl implements DbrwDbpzbService {

	@Resource(name = "dbrwDbpzbDao")
	private DbrwDbpzbDao dbrwDbpzbDao;

	/**
	 * 查询单条<br>
	 * 
	 * @param id
	 * @return DbrwDbpzb
	 */
	public DbrwDbpzb query(String id) {
		return dbrwDbpzbDao.query(id);
	}

	/**
	 * 根据 dbmxbh 查询单条<br>
	 * 
	 * @param rolename
	 * @return DbrwDbpzb
	 */
	public DbrwDbpzb queryByDbmxbh(String dbmxbh) {
		return dbrwDbpzbDao.queryByDbmxbh(dbmxbh);
	}

	/**
	 * 查询所有<br>
	 * 
	 * @return List<DbrwDbpzb>
	 */
	public List<DbrwDbpzb> queryAll() {
		return dbrwDbpzbDao.queryAll();
	}

}
