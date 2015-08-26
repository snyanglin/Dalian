package com.founder.ggfw.service;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.message.bean.SysMessage;

@TypeAnnotation("业务协同规则任务表")
public interface YwxtgzrwbService {

	/**
	 * 根据id获取待处理的协同任务
	 * @param id
	 * @return
	 */
	@MethodAnnotation(value = "查询业务协同规则任务表", type = logType.query)
	public SysMessage queryYwxtgzrwbById(String id);
	
}
