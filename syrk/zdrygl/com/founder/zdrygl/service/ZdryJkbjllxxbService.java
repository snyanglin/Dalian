package com.founder.zdrygl.service;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zdrygl.bean.ZdryJkbjllxxb;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.service.ZdryJkbjllxxbService.java]  
 * @ClassName:    [ZdryJkbjllxxbService]   
 * @Description:  [监控帮教力量 服务类]   
 * @Author:       [zhang.hai@founder.com.cn]  
 * @CreateDate:   [2015年9月6日 下午3:29:01]   
 * @UpdateUser:   [ZhangHai(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年9月6日 下午3:29:01，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@TypeAnnotation("重点人员补充信息－监控帮教力量")
public interface ZdryJkbjllxxbService {

	/**
	 * 查询列表<br>
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	//public EasyUIPage queryList(EasyUIPage page, ZdryJkbjllxxb entity);

	/**
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return 设定文件
	 * @return ZdryJkbjllxxb 返回类型
	 * @throws
	 */
	public ZdryJkbjllxxb queryById(String id);

	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void save(ZdryJkbjllxxb entity, SessionBean sessionBean);

	/**
	 * 更新<br>
	 * 
	 * @param entity
	 */
	@MethodAnnotation(value = "更新", type = logType.update)
	public void update(ZdryJkbjllxxb entity, SessionBean sessionBean);

	/**
	 * 删除<br>
	 * 
	 * @param entity
	 */
	//@MethodAnnotation(value = "注销", type = logType.delete)
	//public void delete(ZdryJkbjllxxb entity, SessionBean sessionBean);

	/**
	 * 删除批量<br>
	 * 
	 * @param entity
	 */
	////@MethodAnnotation(value = "注销批量", type = logType.delete)
	//public void deletePatch(ZdryJkbjllxxb[] entityArray, SessionBean sessionBean);

	/**
	 * @Title: queryBjryIsExist
	 * @Description: TODO(帮教人员是否存在，对于同一个重点人员)
	 * @param @param entity
	 * @param @return 设定文件
	 * @return ZdryJkbjllxxb 返回类型
	 * @throws
	 */
	//public boolean existBjry(ZdryJkbjllxxb entity);
	
	public void saveFirst(String zdryId);
}
