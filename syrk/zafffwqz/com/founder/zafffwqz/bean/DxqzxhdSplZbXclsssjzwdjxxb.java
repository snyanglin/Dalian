/**********************************************************************   
 * <p>文件名：DxqzxhdSplZbXclsssjzwdjxxb.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author wu.w@founder.com.cn 
 * @date 2015-5-15 下午2:29:48 
 * @history
 * @department：研发部
 *
*/
package com.founder.zafffwqz.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/******************************************************************************
 * @Package:      [com.founder.zafffwqz.bean.DxqzxhdSplZbXclsssjzwdjxxb.java]  
 * @ClassName:    [DxqzxhdSplZbXclsssjzwdjxxb]   
 * @Description:  [大型群众性活动审批类-子表-现场临时设施建筑物搭建信息表]   
 * @Author:       [wu.w@founder.com.cn]  
 * @CreateDate:   [2015-5-15 下午2:29:48]   
 * @UpdateUser:   [way(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-15 下午2:29:48，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 * @review      : tian_chengwei@founder.com.cn
 * @reviewDate  : 20150604
 */
@DBInfoAnnotation(tableName = "DXQZXHDSPL_ZB_XCLSSSJZWDJXXB", pk = "hdid")
public class DxqzxhdSplZbXclsssjzwdjxxb extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	@FieldDesc("活动ID")
	private String hdid;
	@FieldDesc("单位名称")
	private String dwmc;
	@FieldDesc("企业类型")
	private String qylx;
	@FieldDesc("企业注册号")
	private String qyzch;
	@FieldDesc("主要负责人")
	private String zyfzr;
	@FieldDesc("主要负责人职务")
	private String zyfzrzw;
	@FieldDesc("主要负责人联系电话")
	private String zyfzrlxdh;
	@FieldDesc("备注")
	private String bz;
	public String getHdid() {
		return hdid;
	}
	public void setHdid(String hdid) {
		this.hdid = hdid;
	}
	public String getDwmc() {
		return dwmc;
	}
	public void setDwmc(String dwmc) {
		this.dwmc = dwmc;
	}
	public String getQylx() {
		return qylx;
	}
	public void setQylx(String qylx) {
		this.qylx = qylx;
	}
	public String getQyzch() {
		return qyzch;
	}
	public void setQyzch(String qyzch) {
		this.qyzch = qyzch;
	}
	public String getZyfzr() {
		return zyfzr;
	}
	public void setZyfzr(String zyfzr) {
		this.zyfzr = zyfzr;
	}
	public String getZyfzrzw() {
		return zyfzrzw;
	}
	public void setZyfzrzw(String zyfzrzw) {
		this.zyfzrzw = zyfzrzw;
	}
	public String getZyfzrlxdh() {
		return zyfzrlxdh;
	}
	public void setZyfzrlxdh(String zyfzrlxdh) {
		this.zyfzrlxdh = zyfzrlxdh;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
