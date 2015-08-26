package com.founder.ldym.pojo;

import java.io.Serializable;

/**
 * 
 * <p>标题：EasyUI Grid数据封装</p>
 * <p>描述：</p>
 * <p>Copyright：Copyright(c) 2014 founder</p>
 * <p>日期：2014-6-9</p>
 * @author	gb
 */
@SuppressWarnings("unused")
public class GridPage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 当前页码
	 */
	private int page;
	/**
	 * 每页显示页数
	 */
	private int rows;
	/**
	 * 开始行号
	 */
	private int startRownum;
	/**
	 * 结束行号
	 */
	private int endRownum;
	/**
	 * 总数
	 */
	private int total;
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getStartRownum() {
		return (page-1) * rows;
	}
	public void setStartRownum(int startRownum) {
		this.startRownum = startRownum;
	}
	public int getEndRownum() {
		return page * rows;
	}
	public void setEndRownum(int endRownum) {
		this.endRownum = endRownum;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}

}
