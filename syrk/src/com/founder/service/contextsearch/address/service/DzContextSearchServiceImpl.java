package com.founder.service.contextsearch.address.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.utils.StringUtils;
import com.founder.service.contextsearch.address.bean.DzContextCombo;
import com.founder.service.contextsearch.address.bean.DzContextCondition;
import com.founder.service.contextsearch.address.dao.DzContextSearchDao;

@Service("dzContextSearchService")
@TypeAnnotation("地址全文检索")
@Transactional
public class DzContextSearchServiceImpl implements DzContextSearchService {

	@Resource(name = "dzContextSearchDao")
	private DzContextSearchDao dzContextSearchDao;

	/**
	 * 地址全文检索（门楼牌）<br>
	 * 
	 * @return
	 */
	public List<DzContextCombo> searchAddressMlph(DzContextCondition condition) {
		return dzContextSearchDao.searchAddressMlph(condition);
	}

	/**
	 * 地址全文检索（门楼牌号详址）<br>
	 * 
	 * @return
	 */
	public List<DzContextCombo> searchAddressMlphXz(DzContextCondition condition) {
		return dzContextSearchDao.searchAddressMlphXz(condition);
	}

}
