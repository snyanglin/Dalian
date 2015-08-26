/**********************************************************************   
 * <p>文件名：KjzmglBean.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author wu.w@founder.com.cn 
 * @date 2015-6-1 下午2:01:41 
 * @history
 * @department：研发部
 *
*/
package com.founder.zafffwqz.bean;

import java.io.Serializable;

/******************************************************************************
 * @Package:      [com.founder.zafffwqz.bean.KjzmglBean.java]  
 * @ClassName:    [KjzmglBean]   
 * @Description:  [查询服务类]   
 * @Author:       [wu.w@founder.com.cn]  
 * @CreateDate:   [2015-6-1 下午2:01:41]   
 * @UpdateUser:   [way(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-1 下午2:01:41，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @review      : tian_chengwei@founder.com.cn
 * @reviewDate  : 20150604 
 * @Version:      [v1.0] 
 */

public class KjzmglBean implements Serializable{
	/**
	 * @Fields serialVersionUID : 
	 */
	private static final long serialVersionUID = 1L;
	private String sfz;
	/* format:1#2#3  1全国违法犯罪人员库 2吸毒人员库 3重点人员库 4全国在逃人员库*/
	private String zyks;
	public String getSfz() {
		return sfz;
	}
	public void setSfz(String sfz) {
		this.sfz = sfz;
	}
	public String getZyks() {
		return zyks;
	}
	public void setZyks(String zyks) {
		this.zyks = zyks;
	}
}
