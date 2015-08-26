package com.founder.ldym.pojo;

import java.util.List;

/**
 * 
 * <p>标题：EasyUI grid返回数据封装</p>
 * <p>描述：</p>
 * <p>Copyright：Copyright(c) 2014 founder</p>
 * <p>日期：2014-6-9</p>
 * @author	gb
 * @param <T>
 */
public class GridResult<T> {
	
	private long total;
	
	private List<T> rows;

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}
}
