package com.founder.service.contextsearch.department.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.annotation.TypeAnnotation;
import com.founder.service.contextsearch.department.bean.DwContextCombo;
import com.founder.service.contextsearch.department.bean.DwContextCondition;
import com.founder.service.contextsearch.department.dao.DwContextSearchDao;

@Service("dwContextSearchService")
@TypeAnnotation("单位全文检索")
@Transactional
public class DwContextSearchServiceImpl implements DwContextSearchService {

	@Resource(name = "dwContextSearchDao")
	private DwContextSearchDao dwContextSearchDao;

	/**
	 * 单位全文检索<br>
	 * 
	 * @return
	 */
	public List<DwContextCombo> searchDepartment(DwContextCondition condition) {
		return dwContextSearchDao.searchDepartment(condition);
	}

}
