package com.founder.syfw.service;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.syfw.vo.SyfwListVo;
@TypeAnnotation("实有房屋")
public interface SyfwQueryService {

	/**
	 * 删除人员居住地址子表信息
	 * @return
	 */
	@MethodAnnotation(value="注销",type = logType.delete)
	public void delete(SyfwListVo entity, SessionBean sessionBean);
	/**
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	public EasyUIPage queryFw(EasyUIPage page, SyfwListVo entity);
	
	
	public long queryCountFw(SyfwListVo entity);
	
	/**
	 * 
	 * @Title: querySyfw
	 * @Description: TODO(房屋查询列表)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage querySyfw( SyfwListVo entity ,EasyUIPage page);
	public long querySyfwCount(SyfwListVo entity);
}
