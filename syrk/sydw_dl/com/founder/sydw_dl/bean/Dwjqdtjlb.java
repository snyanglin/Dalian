/**********************************************************************   
 * <p>文件名：Dwjqdtjlb.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author wu_chunhui@founder.com.cn 
 * @date 2014-11-24 下午3:56:14 
 * @history
 * @department：研发部
 *
*/
package com.founder.sydw_dl.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.base.entity.BaseEntity;

/******************************************************************************
 * @Package:      [com.founder.sydw_dl.bean.Dwjqdtjlb.java]  
 * @ClassName:    [Dwjqdtjlb]   
 * @Description:  [展示单位近期动态纪录bean]   
 * @Author:       [wu_chunhui@founder.com.cn]  
 * @CreateDate:   [2014-11-24 下午3:56:14]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2014-11-24 下午3:56:14，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@DBInfoAnnotation(tableName = "RK_DWJQDTJLB", pk = "id")
public class Dwjqdtjlb extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String dwid;
	private String jlsj;
	private String jlbt;
	private String jlsm;
	/**
	 * @return the dwid
	 */
	public String getDwid() {
		return dwid;
	}
	/**
	 * @param dwid the dwid to set
	 */
	public void setDwid(String dwid) {
		this.dwid = dwid;
	}
	/**
	 * @return the jlsj
	 */
	public String getJlsj() {
		return jlsj;
	}
	/**
	 * @param jlsj the jlsj to set
	 */
	public void setJlsj(String jlsj) {
		this.jlsj = jlsj;
	}
	/**
	 * @return the jlbt
	 */
	public String getJlbt() {
		return jlbt;
	}
	/**
	 * @param jlbt the jlbt to set
	 */
	public void setJlbt(String jlbt) {
		this.jlbt = jlbt;
	}
	/**
	 * @return the jlsm
	 */
	public String getJlsm() {
		return jlsm;
	}
	/**
	 * @param jlsm the jlsm to set
	 */
	public void setJlsm(String jlsm) {
		this.jlsm = jlsm;
	}
	
	
	
	
}
