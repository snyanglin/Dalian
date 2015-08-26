/**********************************************************************   
 * <p>文件名：Address.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author wu_chunhui@founder.com.cn 
 * @date 2014-12-2 下午04:02:57 
 * @history
 * @department：研发部
 *
*/
package com.founder.sydw.bean;

import java.io.Serializable;

/******************************************************************************
 * @Package:      [com.founder.sydw.bean.Address.java]  
 * @ClassName:    [Address]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [wu_chunhui@founder.com.cn]  
 * @CreateDate:   [2014-12-2 下午04:02:57]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2014-12-2 下午04:02:57，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */

public class Address implements Serializable{
	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;
	String id;
	String address;
	String stdFormAddrElemString;
	String stdFormAddrElemTypeString;
	double x;
	double y;
	float score;
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the stdFormAddrElemString
	 */
	public String getStdFormAddrElemString() {
		return stdFormAddrElemString;
	}
	/**
	 * @param stdFormAddrElemString the stdFormAddrElemString to set
	 */
	public void setStdFormAddrElemString(String stdFormAddrElemString) {
		this.stdFormAddrElemString = stdFormAddrElemString;
	}
	/**
	 * @return the stdFormAddrElemTypeString
	 */
	public String getStdFormAddrElemTypeString() {
		return stdFormAddrElemTypeString;
	}
	/**
	 * @param stdFormAddrElemTypeString the stdFormAddrElemTypeString to set
	 */
	public void setStdFormAddrElemTypeString(String stdFormAddrElemTypeString) {
		this.stdFormAddrElemTypeString = stdFormAddrElemTypeString;
	}
	/**
	 * @return the x
	 */
	public double getX() {
		return x;
	}
	/**
	 * @param x the x to set
	 */
	public void setX(double x) {
		this.x = x;
	}
	/**
	 * @return the y
	 */
	public double getY() {
		return y;
	}
	/**
	 * @param y the y to set
	 */
	public void setY(double y) {
		this.y = y;
	}
	/**
	 * @return the score
	 */
	public float getScore() {
		return score;
	}
	/**
	 * @param score the score to set
	 */
	public void setScore(float score) {
		this.score = score;
	}
	
}
