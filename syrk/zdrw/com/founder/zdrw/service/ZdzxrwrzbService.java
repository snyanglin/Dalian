package com.founder.zdrw.service;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zdrw.bean.Zdzxrwrzb;

@TypeAnnotation("自动执行任务日志")
public interface ZdzxrwrzbService {
	/**
	 * 查询列表<br>
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	@MethodAnnotation(value = "查询")
	public EasyUIPage queryList(EasyUIPage page,Zdzxrwrzb entity);
}
