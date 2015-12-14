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
	
	
	/**
	 * 
	 * @Title: searchAddressMlph
	 * @Description: TODO(搜索内保单位下的单位的地址门楼牌)
	 * @param @param nbdwOrgcode
	 * @param @param searchKey
	 * @param @return    设定文件
	 * @return List<DzContextCombo>    返回类型
	 * @throws
	 */
	public List<DzContextCombo> searchNbAddressMlph(String nbdwOrgcode,String searchKey);

	
	/**
	 * 
	 * @Title: searchAddressMlphXz
	 * @Description: TODO(搜索内保单位下的单位的地址门楼牌详址)
	 * @param @param nbdwOrgcode
	 * @param @param searchKey
	 * @param @return    设定文件
	 * @return List<DzContextCombo>    返回类型
	 * @throws
	 */
	public List<DzContextCombo> searchNbAddressMlphXz(String nbdwOrgcode,String id,String searchKey);


}
