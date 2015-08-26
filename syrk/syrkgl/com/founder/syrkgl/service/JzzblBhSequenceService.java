package com.founder.syrkgl.service;

import com.founder.framework.base.entity.SessionBean;

public interface JzzblBhSequenceService {

	/**
	 * 
	 * @param sessionBean
	 * @param code 编号（不含流水号的部分）
	 * <br> 如查询居住编号：code = 组织机构编号12位 + 位年份4位
	 * <br> 如查询打印编号: code = 分局2位 + 位派出所2位 
	 * @return
	 */
	public Long getBhSequence(SessionBean sessionBean,String code);
	
}
