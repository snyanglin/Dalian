/**********************************************************************   
 * <p>文件名：DxqzxhdSplZbAbzlxqxxb.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author wu.w@founder.com.cn 
 * @date 2015-5-20 上午10:32:54 
 * @history
 * @department：研发部
 *
*/
package com.founder.zafffwqz.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;

/******************************************************************************
 * @Package:      [com.founder.zafffwqz.bean.DxqzxhdSplZbAbzlxqxxb.java]  
 * @ClassName:    [DxqzxhdSplZbAbzlxqxxb]   
 * @Description:  [大型群众性活动审批类-子表-安保责任单位-安保种类详情信息表]   
 * @Author:       [wu.w@founder.com.cn]  
 * @CreateDate:   [2015-5-20 上午10:32:54]   
 * @UpdateUser:   [way(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-20 上午10:32:54，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 * @review      : tian_chengwei@founder.com.cn
 * @reviewDate  : 20150604
 */
@DBInfoAnnotation(tableName = "DXQZXHDSPL_ZB_ABZRDW_ABXQXXB", pk = "hdid")
public class DxqzxhdSplZbAbzlxqxxb implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@FieldDesc("活动ID")
	private String hdid;
	@FieldDesc("安保种类代码")
	private String abzldm;
	@FieldDesc("安保种类名称")
	private String abzltxt;
	@FieldDesc("安保种类数量")
	private Long abzlnum;
	public String getHdid() {
		return hdid;
	}
	public void setHdid(String hdid) {
		this.hdid = hdid;
	}
	public String getAbzldm() {
		return abzldm;
	}
	public void setAbzldm(String abzldm) {
		this.abzldm = abzldm;
	}
	public String getAbzltxt() {
		return abzltxt;
	}
	public void setAbzltxt(String abzltxt) {
		this.abzltxt = abzltxt;
	}
	public Long getAbzlnum() {
		return abzlnum;
	}
	public void setAbzlnum(Long abzlnum) {
		this.abzlnum = abzlnum;
	}

}
