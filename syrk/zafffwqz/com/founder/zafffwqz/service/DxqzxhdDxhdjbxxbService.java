package com.founder.zafffwqz.service;

import java.util.Map;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zafffwqz.bean.DxqzxhdDxhdjbxxb;


/******************************************************************************
 * @Package:      [com.founder.zafffwqz.service.DxqzxhdDxhdjbxxbService.java]  
 * @ClassName:    [DxqzxhdDxhdjbxxbService]   
 * @Description:  [大型群众性活动管理-大型活动基本信息表]   
 * @Author:       [xuhaibo@founder.com.cn]  
 * @CreateDate:   [2015-5-14 中午12:50:47]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-14 中午12:50:47，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@TypeAnnotation("大型群众性活动管理-大型活动基本信息表")
public interface DxqzxhdDxhdjbxxbService {

	/**
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return 设定文件
	 * @return DxqzxhdDxhdjbxxb 返回类型
	 * @throws
	 */
	public DxqzxhdDxhdjbxxb queryById(String id);

	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void save(DxqzxhdDxhdjbxxb entity, SessionBean sessionBean);

	/**
	 * 更新<br>
	 * 
	 * @param entity
	 */
	@MethodAnnotation(value = "更新", type = logType.update)
	public void update(DxqzxhdDxhdjbxxb entity, SessionBean sessionBean);

	/**
	 * 删除<br>
	 * 
	 * @param entity
	 */
	@MethodAnnotation(value = "删除", type = logType.delete)
	public void delete(DxqzxhdDxhdjbxxb entity, SessionBean sessionBean);

	/**
	 * 查询列表<br>
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	@MethodAnnotation(value = "查询")
	public EasyUIPage queryList(EasyUIPage page,Map map);

}
