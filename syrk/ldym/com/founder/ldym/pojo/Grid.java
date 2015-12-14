package com.founder.ldym.pojo;


/**
 * 
 * <p>标题：分页grid</p>
 * <p>描述：</p>
 * <p>Copyright：Copyright(c) 2014 founder</p>
 * <p>日期：2014-1-10</p>
 * @author	gb
 */
public class Grid {

	/**
	 * 每页显示条数
	 */
	private int rows = 10;

	/**
	 * 当前请求的页数
	 */
	private int page = 1;
	
	/**
	 * 排序字段
	 */
	private String sort = "";
	
	/**
	 * 排序方式 asc或者desc
	 */
	private String order = "";
	
	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}
}
