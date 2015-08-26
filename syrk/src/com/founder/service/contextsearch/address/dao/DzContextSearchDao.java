package com.founder.service.contextsearch.address.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.config.SystemConfig;
import com.founder.framework.utils.ContextSearchUtils;
import com.founder.framework.utils.StringUtils;
import com.founder.service.contextsearch.address.bean.DzContextCombo;
import com.founder.service.contextsearch.address.bean.DzContextCondition;

@Repository("dzContextSearchDao")
public class DzContextSearchDao extends BaseDaoImpl {

	/**
	 * 取得截取后的地址检索关键词<br>
	 * 
	 * @param searchKey
	 * @return
	 */
	private String getCutSearchKey(String searchKey) {
		String returnValue = "";
		if (!StringUtils.isBlank(searchKey)) {
			String addressPrefix = SystemConfig.getString("addressPrefix");
			if (!StringUtils.isBlank(addressPrefix)) { // 去掉省市的地址前辍
				String[] addressPrefixArray = addressPrefix.split(",");
				for (int i = 0; i < addressPrefixArray.length; i++) {
					searchKey = searchKey.replaceAll(addressPrefixArray[i], "");
				}
			}
			String subXzqhName = SystemConfig.getString("subXzqhName");
			if (!StringUtils.isBlank(subXzqhName)) { // 去掉行政区划名称的地址前辍
				String[] subXzqhNameArray = subXzqhName.split(",");
				for (int i = 0; i < subXzqhNameArray.length; i++) {
					searchKey = searchKey.replaceAll(subXzqhNameArray[i], "");
				}
			}
			returnValue = searchKey;
		}
		return returnValue;
	}

	/**
	 * 取得地址全文检索的查询表达式<br>
	 * 
	 * @param searchString
	 *            需要转换的字符串
	 * @return String
	 */
	private String getQueryExpression(DzContextCondition condition) {
		String returnValue = "";
		String searchKey = condition.getSearchKey();
		searchKey = ContextSearchUtils.getRemoveSpecialString(searchKey);
		if (!StringUtils.isBlank(searchKey)) {
			String contextField = "";
			searchKey = searchKey.toUpperCase();
			searchKey = searchKey.replaceAll("'", "");
			searchKey = searchKey.replaceAll(" ", "");
			char firstChar = searchKey.charAt(0);
			if ((firstChar >= 'A' && firstChar <= 'Z')
					|| (firstChar >= '0' && firstChar <= '9')
					|| firstChar == '-') {
				contextField = "DZMCPYPWD";
			} else {
				contextField = "DZMCPWD";
			}
			String innerCondition = ""; // 全文内部条件（根据索引是否在内部注入条件）
			if (!StringUtils.isBlank(condition.getPcsdm())) {
				innerCondition = "PCSDM=''" + condition.getPcsdm() + "''";
			} else if (!StringUtils.isBlank(condition.getZrqdm())) {
				innerCondition = "ZRQDM=''" + condition.getZrqdm() + "''";
			} else if (!StringUtils.isBlank(condition.getFxjdm())) {
				innerCondition = "FXJDM=''" + condition.getFxjdm() + "''";
			}
			if ("".equals(innerCondition)) {
				innerCondition = "null";
			} else {
				innerCondition = "'" + innerCondition + "'";
			}
			searchKey = ContextSearchUtils.getPasswordString(searchKey);
			if (searchKey.length() >= 80) { // 最多80个汉字
				searchKey = searchKey.substring(0, 80);
			}
			returnValue = "catsearch(" + contextField + ",'" + searchKey + "',"
					+ innerCondition + ") > 0";
		}
		return returnValue;
	}

	/**
	 * 地址全文检索（门楼牌号）<br>
	 * 
	 * @return
	 */
	public List<DzContextCombo> searchAddressMlph(DzContextCondition condition) {
		List<DzContextCombo> list = new ArrayList<DzContextCombo>();
		String searchKey = condition.getSearchKey();
		condition.setSearchKey(getCutSearchKey(searchKey));
		String queryExpression = getQueryExpression(condition);
		if (!StringUtils.isBlank(queryExpression)) {
			condition.setQueryExpression(queryExpression);
			list = queryForList("DzContextSearch.searchAddressMlph", condition);
		}
		return list;
	}

	/**
	 * 地址全文检索（门楼牌号详址）<br>
	 * 
	 * @return
	 */
	public List<DzContextCombo> searchAddressMlphXz(DzContextCondition condition) {
		List<DzContextCombo> list = new ArrayList<DzContextCombo>();
		if (!StringUtils.isBlank(condition.getId())) {
			String searchKey = condition.getSearchKey();
			condition.setSearchKey(getCutSearchKey(searchKey));
			list = queryForList("DzContextSearch.searchAddressMlphXz",
					condition);
		}
		return list;
	}

}
