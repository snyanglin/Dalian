package com.founder.service.contextsearch.department.service;

import java.util.List;

import com.founder.service.contextsearch.department.bean.DwContextCombo;
import com.founder.service.contextsearch.department.bean.DwContextCondition;

public interface DwContextSearchService {

	/**
	 * 单位全文检索<br>
	 * 
	 * @return
	 */
	public List<DwContextCombo> searchDepartment(DwContextCondition condition);

}
