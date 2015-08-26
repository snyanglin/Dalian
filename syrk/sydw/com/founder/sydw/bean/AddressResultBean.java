/**********************************************************************   
 * <p>文件名：AddressResultBean.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author wu_chunhui@founder.com.cn 
 * @date 2014-12-2 下午02:33:54 
 * @history
 * @department：研发部
 *
*/
package com.founder.sydw.bean;

import java.io.Serializable;
import java.util.List;



/******************************************************************************
 * @Package:      [com.founder.sydw.bean.AddressResultBean.java]  
 * @ClassName:    [AddressResultBean]   
 * @Description:  [地址匹配接口使用未继承基础类]   
 * @Author:       [wu_chunhui@founder.com.cn]  
 * @CreateDate:   [2014-12-2 下午02:33:54]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2014-12-2 下午02:33:54，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */

public class AddressResultBean implements Serializable {
	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;
	Boolean success;
	List<Address> content;
	/**
	 * @return the success
	 */
	public Boolean getSuccess() {
		return success;
	}
	/**
	 * @param success the success to set
	 */
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	/**
	 * @return the content
	 */
	public List<Address> getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(List<Address> content) {
		this.content = content;
	}

	
	

}



