package com.founder.zdry.service;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zdry.bean.ZdryJgdxqxjdjb;

/******************************************************************************
 * @Package: [com.founder.zdry.service.ZdryJgdxqxjdjbService.java]
 * @ClassName: [ZdryJgdxqxjdjbService]
 * @Description: [重点人员补充信息－监管对象请销假]
 * @Author: [hongguanjun]
 * @CreateDate: [2015-3-12 上午10:35:29]
 * @UpdateUser: [hongguanjun(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-3-12 上午10:35:29，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@TypeAnnotation("重点人员补充信息－监管对象请销假")
public interface ZdryJgdxqxjdjbService {

	/**
	 * 查询列表<br>
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	public EasyUIPage queryList(EasyUIPage page, ZdryJgdxqxjdjb entity);

	/**
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return 设定文件
	 * @return ZdryJgdxqxjdjb 返回类型
	 * @throws
	 */
	public ZdryJgdxqxjdjb queryById(String id);

	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void save(ZdryJgdxqxjdjb entity, SessionBean sessionBean);

	/**
	 * 更新<br>
	 * 
	 * @param entity
	 */
	@MethodAnnotation(value = "更新", type = logType.update)
	public void update(ZdryJgdxqxjdjb entity, SessionBean sessionBean);

	/**
	 * 更新审批<br>
	 * 
	 * @param entity
	 */
	@MethodAnnotation(value = "更新审批", type = logType.update)
	public void updateSp(ZdryJgdxqxjdjb entity, SessionBean sessionBean);

	/**
	 * 删除<br>
	 * 
	 * @param entity
	 */
	@MethodAnnotation(value = "注销", type = logType.delete)
	public void delete(ZdryJgdxqxjdjb entity, SessionBean sessionBean);

	/**
	 * 删除批量<br>
	 * 
	 * @param entity
	 */
	@MethodAnnotation(value = "注销批量", type = logType.delete)
	public void deletePatch(ZdryJgdxqxjdjb[] entityArray,
			SessionBean sessionBean);

	/**
	 * @Title: sendMessage
	 * @Description: TODO(发送监管对象请假申请（所长）)
	 * @param @param entity
	 * @param @param sessionBean 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void sendQjMessage(ZdryJgdxqxjdjb entity, SessionBean sessionBean);

	/**
	 * @Title: sendMessage
	 * @Description: TODO(发送审批结果消息（民警）)
	 * @param @param entity
	 * @param @param sessionBean 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void sendQjspMessage(ZdryJgdxqxjdjb entity, SessionBean sessionBean);

	/**
	 * @Title: sendMessage
	 * @Description: TODO(发送监管对象销假消息（所长）)
	 * @param @param entity
	 * @param @param sessionBean 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void sendXjMessage(ZdryJgdxqxjdjb entity, SessionBean sessionBean);

}
