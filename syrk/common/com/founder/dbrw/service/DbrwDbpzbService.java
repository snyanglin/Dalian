package com.founder.dbrw.service;

import java.util.List;

import com.founder.dbrw.bean.DbrwDbpzb;
import com.founder.framework.annotation.TypeAnnotation;

@TypeAnnotation("督办任务－督办配置表管理")
public interface DbrwDbpzbService {

	/**
	 * 查询单条<br>
	 * 
	 * @param id
	 * @return DbrwDbpzb
	 */
	public DbrwDbpzb query(String id);

	/**
	 * 根据 dbmxbh 查询单条<br>
	 * 
	 * @param rolename
	 * @return DbrwDbpzb
	 */
	public DbrwDbpzb queryByDbmxbh(String dbmxbh);

	/**
	 * 查询所有<br>
	 * 
	 * @return List<DbrwDbpzb>
	 */
	public List<DbrwDbpzb> queryAll();

}
