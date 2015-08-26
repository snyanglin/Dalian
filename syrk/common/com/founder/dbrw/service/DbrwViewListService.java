package com.founder.dbrw.service;

import java.util.Map;

import com.founder.dbrw.bean.DbrwDbrwb;
import com.founder.dbrw.bean.DbrwDbrwsjmxb;
import com.founder.dbrw.bean.RuleYwxtgzrwlsjlb;
import com.founder.framework.message.bean.SysMessage;
import com.founder.framework.utils.EasyUIPage;

public interface DbrwViewListService {

	/**
	 * 
	 * @Title: getRwById
	 * @Description: TODO(根据ID查询任务)
	 * @param @param id
	 * @param @return 设定文件
	 * @return DbrwDbrwb 返回类型
	 * @throws
	 */
	public DbrwDbrwb getRwById(String id);

	/**
	 * 
	 * @Title: list
	 * @Description: TODO(根据条件查询任务集合:查询条件-派出所代码，分局代码，注销)
	 * @param @param page
	 * @param @param rwb
	 * @param @return 设定文件
	 * @return EasyUIPage 返回类型
	 * @throws
	 */
	public EasyUIPage list(EasyUIPage page, DbrwDbrwb rwb);

	/**
	 * 
	 * @Title: list
	 * @Description: TODO(根据条件查询任务集合，把任务ID放到集合第一条:查询条件-派出所代码，分局代码，注销)
	 * @param @param page
	 * @param @param rwb
	 * @param @param id
	 * @param @return 设定文件
	 * @return EasyUIPage 返回类型
	 * @throws
	 */
	public EasyUIPage list(EasyUIPage page, DbrwDbrwb rwb, String id);

	/**
	 * @param string
	 * 
	 * @Title: rwmxlist
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param page
	 * @param @param rwid
	 * @param @return 设定文件
	 * @return EasyUIPage 返回类型
	 * @throws
	 */
	public EasyUIPage rwmxlist(EasyUIPage page, DbrwDbrwsjmxb entity);

	public Map<String, Object> gzdxChart(String zzjgdm);

	/**
	 * sny
	 * 
	 * @Title: listDb
	 * @Description: TODO(更多督办功能新增查询)
	 * @param @param page
	 * @param @param rwb
	 * @param @return 设定文件
	 * @return EasyUIPage 返回类型
	 * @throws
	 */
	public EasyUIPage listDb(EasyUIPage page, DbrwDbrwb rwb);

	/**
	 * sny
	 * 
	 * @Title: listDbTotal
	 * @Description: TODO(更多督办功能总条数)
	 * @param @param entity
	 * @param @return 设定文件
	 * @return long 返回类型
	 * @throws
	 */
	public long listDbTotal(DbrwDbrwb entity);
	
	/**
	 * sny
	 * 
	 * @Title: listDb
	 * @Description: TODO(更多督办功能新增查询)
	 * @param @param page
	 * @param @param rwb
	 * @param @return 设定文件
	 * @return EasyUIPage 返回类型
	 * @throws
	 */
	public EasyUIPage listXt(EasyUIPage page, RuleYwxtgzrwlsjlb rwb);

	/**
	 * sny
	 * 
	 * @Title: listDbTotal
	 * @Description: TODO(更多督办功能总条数)
	 * @param @param entity
	 * @param @return 设定文件
	 * @return long 返回类型
	 * @throws
	 */
	public long listXtTotal(RuleYwxtgzrwlsjlb entity);

	/**
	 * 
	 * @Title: getRwById
	 * @Description: TODO(根据ID查询任务)
	 * @param @param id
	 * @param @return 设定文件
	 * @return DbrwDbrwb 返回类型
	 * @throws
	 */
	public RuleYwxtgzrwlsjlb getXtById(String id);
	
	/**
	 * sny
	 * 
	 * @Title: listDb
	 * @Description: TODO(更多督办功能新增查询)
	 * @param @param page
	 * @param @param rwb
	 * @param @return 设定文件
	 * @return EasyUIPage 返回类型
	 * @throws
	 */
	public EasyUIPage listMsg(EasyUIPage page, SysMessage rwb);

	/**
	 * sny
	 * 
	 * @Title: listDbTotal
	 * @Description: TODO(更多督办功能总条数)
	 * @param @param entity
	 * @param @return 设定文件
	 * @return long 返回类型
	 * @throws
	 */
	public long listMsgTotal(SysMessage entity);
	
	/**
	 * 
	 * @Title: getRwById
	 * @Description: TODO(根据ID查询任务)
	 * @param @param id
	 * @param @return 设定文件
	 * @return DbrwDbrwb 返回类型
	 * @throws
	 */
	public String backMsg(String id);
	
	
	
	
	
	
}
