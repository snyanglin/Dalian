package com.founder.zdry.service;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zdry.bean.ZdryDtgljsxxb;

/******************************************************************************
 * @Package: [com.founder.zdry.service.ZdryDtgljsxxbService.java]
 * @ClassName: [ZdryDtgljsxxbService]
 * @Description: [重点人员补充信息－动态管理纪实]
 * @Author: [hongguanjun]
 * @CreateDate: [2015-3-12 上午10:35:29]
 * @UpdateUser: [hongguanjun(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-3-12 上午10:35:29，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@TypeAnnotation("重点人员补充信息－动态管理纪实")
public interface ZdryDtgljsxxbService {

	/**
	 * 查询列表<br>
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	public EasyUIPage queryList(EasyUIPage page, ZdryDtgljsxxb entity);

	/**
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return 设定文件
	 * @return ZdryDtgljsxxb 返回类型
	 * @throws
	 */
	public ZdryDtgljsxxb queryById(String id);

	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void save(ZdryDtgljsxxb entity, SessionBean sessionBean);

	/**
	 * 自动新增<br>
	 * 
	 * @param entity
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void autoSave(ZdryDtgljsxxb entity, SessionBean sessionBean);

	/**
	 * 更新<br>
	 * 
	 * @param entity
	 */
	@MethodAnnotation(value = "更新", type = logType.update)
	public void update(ZdryDtgljsxxb entity, SessionBean sessionBean);

	/**
	 * 删除<br>
	 * 
	 * @param entity
	 */
	@MethodAnnotation(value = "注销", type = logType.delete)
	public void delete(ZdryDtgljsxxb entity, SessionBean sessionBean);

	/**
	 * 删除批量<br>
	 * 
	 * @param entity
	 */
	@MethodAnnotation(value = "注销批量", type = logType.delete)
	public void deletePatch(ZdryDtgljsxxb[] entityArray, SessionBean sessionBean);

	/**
	 * @Title: sendMessage
	 * @Description: TODO(发送动态管理纪实（所长或上级）)
	 * @param @param entity
	 * @param @param sessionBean 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void sendMessage(ZdryDtgljsxxb entity, SessionBean sessionBean);

	/**
	 * @Title: getJsmbListJson
	 * @Description: TODO(取得纪实模板combobox的json格式字符串)
	 * @param @param zdrygllxdm
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public String getJsmbListJson(String zdrygllxdm);

}
