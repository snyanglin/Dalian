/**********************************************************************   
 * <p>文件名：AqffXcXcjyxxb.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author wu.w@founder.com.cn 
 * @date 2015-5-25 上午9:38:07 
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
 * @Package:      [com.founder.aqff.bean.AqffXcXcjyxxb.java]  
 * @ClassName:    [AqffXcXcjyxxb]   
 * @Description:  [宣传教育信息表]   
 * @Author:       [wu.w@founder.com.cn]  
 * @CreateDate:   [2015-5-25 上午9:38:07]   
 * @UpdateUser:   [way(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-25 上午9:38:07，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 * 
 * @review      : tian_chengwei@founder.com.cn
 * @reviewDate  : 20150604
 */
@DBInfoAnnotation(tableName = "AQFF_XC_XCJYXXB", pk = "id")
public class AqffXcXcjyxxb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@FieldDesc("ID")
	private String id;
	@FieldDesc("宣传教育主题")
	private String xcjyzt;
	@FieldDesc("宣传教育内容")
	private String xcjynr;
	@FieldDesc("开展日期")
	private String kzrq;
	@FieldDesc("宣传教育形式")
	private String xcjyxs;
	@FieldDesc("投入经费")
	private Long trjf;
	@FieldDesc("教育群众人数")
	private Long jyqzrs;
	@FieldDesc("教育单位数量")
	private Long jydwsl;
	@FieldDesc("地址")
	private String dz;
	@FieldDesc("备注")
	private String bz;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getXcjyzt() {
		return xcjyzt;
	}
	public void setXcjyzt(String xcjyzt) {
		this.xcjyzt = xcjyzt;
	}
	public String getXcjynr() {
		return xcjynr;
	}
	public void setXcjynr(String xcjynr) {
		this.xcjynr = xcjynr;
	}
	public String getKzrq() {
		return kzrq;
	}
	public void setKzrq(String kzrq) {
		this.kzrq = kzrq;
	}
	public String getXcjyxs() {
		return xcjyxs;
	}
	public void setXcjyxs(String xcjyxs) {
		this.xcjyxs = xcjyxs;
	}
	public Long getTrjf() {
		return trjf;
	}
	public void setTrjf(Long trjf) {
		this.trjf = trjf;
	}
	public Long getJyqzrs() {
		return jyqzrs;
	}
	public void setJyqzrs(Long jyqzrs) {
		this.jyqzrs = jyqzrs;
	}
	public Long getJydwsl() {
		return jydwsl;
	}
	public void setJydwsl(Long jydwsl) {
		this.jydwsl = jydwsl;
	}
	public String getDz() {
		return dz;
	}
	public void setDz(String dz) {
		this.dz = dz;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}

}
