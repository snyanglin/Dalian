package com.founder.service.contextsearch.department.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.ContextSearchUtils;
import com.founder.framework.utils.StringUtils;
import com.founder.service.contextsearch.department.bean.DwContextCombo;
import com.founder.service.contextsearch.department.bean.DwContextCondition;

@Repository("dwContextSearchDao")
public class DwContextSearchDao extends BaseDaoImpl {

	/**
	 * 取得单位全文检索的查询表达式<br>
	 * 
	 * @param searchString
	 *            需要转换的字符串
	 * @return String
	 */
	private String getQueryExpression(DwContextCondition condition) {
		String returnValue = "";
		String searchKey = condition.getSearchKey();
		searchKey = ContextSearchUtils.getRemoveSpecialString(searchKey);
		if (!StringUtils.isBlank(searchKey)) {
			String contextField = "";
			searchKey = searchKey.toUpperCase();
			char firstChar = searchKey.charAt(0);
			if ((firstChar >= 'A' && firstChar <= 'Z')
					|| (firstChar >= '0' && firstChar <= '9')
					|| firstChar == '-') {
				contextField = "DWQCPYJM";
			} else {
				contextField = "DWQCJM";
			}
			String innerCondition = ""; // 全文内部条件（根据索引是否在内部注入条件）
			if (!StringUtils.isBlank(condition.getGlpcsid())) {
				innerCondition = "GLPCSID=''" + condition.getGlpcsid() + "''";
			} else if (!StringUtils.isBlank(condition.getGlfxjid())) {
				innerCondition = "GLFXJID=''" + condition.getGlfxjid() + "''";
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
	 * 单位全文检索<br>
	 * 
	 * @return
	 */
	public List<DwContextCombo> searchDepartment(DwContextCondition condition) {
		String queryExpression = getQueryExpression(condition);
		if (StringUtils.isBlank(queryExpression)) {
			condition.setXt_zxbz("0");
		} else {
			condition.setGlpcsid("");
			condition.setXt_zxbz("");
			condition.setQueryExpression(queryExpression);
		}
		List<DwContextCombo> list = queryForList(
				"DwContextSearch.searchDepartment", condition);
		return list;
	}

}
