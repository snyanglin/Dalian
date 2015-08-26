package com.founder.service.contextsearch.address.service;

import java.util.List;

import com.founder.service.contextsearch.address.bean.DzContextCombo;
import com.founder.service.contextsearch.address.bean.DzContextCondition;

public interface DzContextSearchService {

	/**
	 * 地址全文检索（门楼牌号）<br>
	 * 
	 * @return
	 */
	public List<DzContextCombo> searchAddressMlph(DzContextCondition condition);

	/**
	 * 地址全文检索（门楼牌号详址）<br>
	 * 
	 * @return
	 */
	public List<DzContextCombo> searchAddressMlphXz(DzContextCondition condition);

}
