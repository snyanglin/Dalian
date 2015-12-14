/**********************************************************************   
 * <p>文件名：AqffXcZatbxxb.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author wu.w@founder.com.cn 
 * @date 2015-5-25 上午9:41:05 
 * @history
 * @department：研发部
 *
*/
package com.founder.aqff.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/******************************************************************************
 * @Package:      [com.founder.aqff.bean.AqffXcZatbxxb.java]  
 * @ClassName:    [AqffXcZatbxxb]   
 * @Description:  [治安通报信息表]   
 * @Author:       [wu.w@founder.com.cn]  
 * @CreateDate:   [2015-5-25 上午9:41:05]   
 * @UpdateUser:   [way(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-25 上午9:41:05，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 * 
 * @review      : tian_chengwei@founder.com.cn
 * @reviewDate  : 20150604
 */
@DBInfoAnnotation(tableName = "AQFF_XC_ZATBXXB", pk = "id")
public class AqffXcZatbxxb extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@FieldDesc("ID")
	private String id;
	@FieldDesc("通报日期")
	private String tbrq;
	@FieldDesc("通报期号")
	private String tbqh;
	@FieldDesc("通报标题")
	private String tbbt;
	@FieldDesc("发布单位")
	private String fbdw;
	@FieldDesc("发布份数")
	private Long fbfs;
	@FieldDesc("通报内容")
	private String tbnr;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTbrq() {
		return tbrq;
	}
	public void setTbrq(String tbrq) {
		this.tbrq = tbrq;
	}
	public String getTbqh() {
		return tbqh;
	}
	public void setTbqh(String tbqh) {
		this.tbqh = tbqh;
	}
	public String getTbbt() {
		return tbbt;
	}
	public void setTbbt(String tbbt) {
		this.tbbt = tbbt;
	}
	public String getFbdw() {
		return fbdw;
	}
	public void setFbdw(String fbdw) {
		this.fbdw = fbdw;
	}
	public Long getFbfs() {
		return fbfs;
	}
	public void setFbfs(Long fbfs) {
		this.fbfs = fbfs;
	}
	public String getTbnr() {
		return tbnr;
	}
	public void setTbnr(String tbnr) {
		this.tbnr = tbnr;
	}
}
