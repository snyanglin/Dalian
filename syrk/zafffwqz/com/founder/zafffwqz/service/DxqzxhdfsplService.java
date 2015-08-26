package com.founder.zafffwqz.service;

import java.util.Map;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zafffwqz.bean.Dsrxxzb;
import com.founder.zafffwqz.bean.DxqzxhdFspxxb;



/******************************************************************************
 * @Package:      [com.founder.zafffwqz.service.DxqzxhdfsplService.java]  
 * @ClassName:    [DxqzxhdfsplService]   
 * @Description:  [大型社会活动信息-非审批service]   
 * @Author:       [xu_haibo@founder.com.cn]  
 * @CreateDate:   [2015-5-21 上午9:33:27]   
 * @UpdateUser:   [haibo(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-21 上午9:33:27，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@TypeAnnotation("大型社会活动信息-非审批service")
public interface DxqzxhdfsplService {

	/**
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return 设定文件
	 * @return DxqzxhdCbfxxb 返回类型
	 * @throws
	 */
	public DxqzxhdFspxxb queryById(String id);
	
/**
 * 
 * @Title: queryDxqzxhdFspxxb
 * @Description: TODO(查询)
 * @param @param entity
 * @param @return    设定文件
 * @return DxqzxhdFspxxb    返回类型
 * @throws
 */
	@MethodAnnotation(value = "大型活动信息", type = logType.query)
	public DxqzxhdFspxxb queryDxqzxhdFspxxb(DxqzxhdFspxxb entity);
	
/**
 * 
 * @Title: save
 * @Description: TODO(新增)
 * @param @param entity
 * @param @param sessionBean    设定文件
 * @return void    返回类型
 * @throws
 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void save(DxqzxhdFspxxb entity, SessionBean sessionBean);

/**
 * 
 * @Title: update
 * @Description: TODO(更新)
 * @param @param entity
 * @param @param sessionBean    设定文件
 * @return void    返回类型
 * @throws
 */
	@MethodAnnotation(value = "更新", type = logType.update)
	public void modifyFsp(DxqzxhdFspxxb entity, SessionBean sessionBean);

/**
 * 
 * @Title: delete
 * @Description: TODO(删除)
 * @param @param entity
 * @param @param sessionBean    设定文件
 * @return void    返回类型
 * @throws
 */
	@MethodAnnotation(value = "删除", type = logType.delete)
	public void delete(DxqzxhdFspxxb entity, SessionBean sessionBean);

/**
 * 
 * @Title: queryList
 * @Description: TODO(查询列表)
 * @param @param page
 * @param @param map
 * @param @return    设定文件
 * @return EasyUIPage    返回类型
 * @throws
 */
	@MethodAnnotation(value = "查询")
	public EasyUIPage queryList(EasyUIPage page,Map map);

}
