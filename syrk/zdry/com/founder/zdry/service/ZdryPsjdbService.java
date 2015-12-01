package com.founder.zdry.service;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zdry.bean.ZdryPsjdb;

/******************************************************************************
 * @Package: [com.founder.zdry.service.ZdryPsjdbService.java]
 * @ClassName: [ZdryPsjdbService]
 * @Description: [重点人员补充信息－评审鉴定]
 * @Author: [hongguanjun]
 * @CreateDate: [2015-3-12 上午10:35:29]
 * @UpdateUser: [hongguanjun(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-3-12 上午10:35:29，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@TypeAnnotation("重点人员补充信息－评审鉴定")
public interface ZdryPsjdbService {

	/**
	 * 查询列表<br>
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	public EasyUIPage queryList(EasyUIPage page, ZdryPsjdb entity);

	/**
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return 设定文件
	 * @return ZdryPsjdb 返回类型
	 * @throws
	 */
	public ZdryPsjdb queryById(String id);

	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void save(ZdryPsjdb entity, SessionBean sessionBean);

	/**
	 * 更新<br>
	 * 
	 * @param entity
	 */
	@MethodAnnotation(value = "更新", type = logType.update)
	public void update(ZdryPsjdb entity, SessionBean sessionBean);

	/**
	 * 删除<br>
	 * 
	 * @param entity
	 */
	@MethodAnnotation(value = "注销", type = logType.delete)
	public void delete(ZdryPsjdb entity, SessionBean sessionBean);

	/**
	 * 删除批量<br>
	 * 
	 * @param entity
	 */
	@MethodAnnotation(value = "注销批量", type = logType.delete)
	public void deletePatch(ZdryPsjdb[] entityArray, SessionBean sessionBean);

	/**
	 * @Title: sendMessage
	 * @Description: TODO(发送考察（所长或上级）)
	 * @param @param entity
	 * @param @param sessionBean 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void sendMessage(ZdryPsjdb entity, SessionBean sessionBean);

}
