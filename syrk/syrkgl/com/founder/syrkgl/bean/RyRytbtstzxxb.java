/**********************************************************************   
 * <p>文件名：RyRytbtstzxxb.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk_syrk
 * @author xu_wenjun@founder.com.cn 
 * @date 2015-4-12 下午10:26:37 
 * @history
 * @department：研发部
 *
*/
package com.founder.syrkgl.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/******************************************************************************
 * @Package:      [com.founder.syrkgl.bean.RyRytbtstzxxb.java]  
 * @ClassName:    [RyRytbtstzxxb]   
 * @Description:  [实有人口附加信息-人员体表特殊特征信息表]   
 * @Author:       [xu_wenjun@founder.com.cn]  
 * @CreateDate:   [2015-4-12 下午10:26:37]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-12 下午10:26:37，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@DBInfoAnnotation(tableName = "RY_RYTBTSTZXXB", pk = "id")
public class RyRytbtstzxxb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@FieldDesc("特殊特征ID")
	private String id;
	@FieldDesc("人员ID")
	private String ryid;
	@FieldDesc("特殊体貌特征类型代码")
	private String tstmtzlxdm;
	@FieldDesc("特殊体貌特征代码")
	private String tstmtzdm;
	@FieldDesc("特殊特征描述")
	private String tstzms;
	@FieldDesc("备注")
	private String bz;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRyid() {
		return ryid;
	}
	public void setRyid(String ryid) {
		this.ryid = ryid;
	}
	public String getTstmtzlxdm() {
		return tstmtzlxdm;
	}
	public void setTstmtzlxdm(String tstmtzlxdm) {
		this.tstmtzlxdm = tstmtzlxdm;
	}
	public String getTstmtzdm() {
		return tstmtzdm;
	}
	public void setTstmtzdm(String tstmtzdm) {
		this.tstmtzdm = tstmtzdm;
	}
	public String getTstzms() {
		return tstzms;
	}
	public void setTstzms(String tstzms) {
		this.tstzms = tstzms;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}

}
