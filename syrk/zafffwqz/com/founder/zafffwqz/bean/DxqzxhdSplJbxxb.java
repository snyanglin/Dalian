/**********************************************************************   
 * <p>文件名：DxqzxhdSplJbxxb.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author wu.w@founder.com.cn 
 * @date 2015-5-15 下午2:20:54 
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
 * @Package:      [com.founder.zafffwqz.bean.DxqzxhdSplJbxxb.java]  
 * @ClassName:    [DxqzxhdSplJbxxb]   
 * @Description:  [大型群众性活动审批类-基本信息表]   
 * @Author:       [wu.w@founder.com.cn]  
 * @CreateDate:   [2015-5-15 下午2:20:54]   
 * @UpdateUser:   [way(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-15 下午2:20:54，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 * @review      : tian_chengwei@founder.com.cn
 * @reviewDate  : 20150604
 */
@DBInfoAnnotation(tableName = "DXQZXHDSPL_JBXXB", pk = "hdid")
public class DxqzxhdSplJbxxb extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@FieldDesc("活动ID")
	private String hdid;
	@FieldDesc("活动类型代码")
	private String hdlxdm;
	@FieldDesc("活动性质代码")
	private String hdxzdm;
	@FieldDesc("活动名称")
	private String hdmc;
	@FieldDesc("活动场次")
	private String hdcc;
	@FieldDesc("每场次预计人数代码")
	private String mccyjrsdm;
	@FieldDesc("额定容量")
	private String edrl;
	@FieldDesc("拟发售票数")
	private String nfsps;
	@FieldDesc("地址-活动地点省市县代码")
	private String dz_hdddssxdm;
	@FieldDesc("地址-活动地点门楼牌代码")
	private String dz_hdddmlpdm;
	@FieldDesc("地址-活动地点门楼牌详址")
	private String dz_hdddmlpxz;
	@FieldDesc("DZ_HDDDDZDM")
	private String dz_hddddzdm;
	@FieldDesc("地址-活动地点详址")
	private String dz_hdddxz;
	@FieldDesc("补充说明")
	private String bcsm;
	@FieldDesc("每场次实际人数")
	private Long mccsjrs;
	@FieldDesc("地址-活动路线起始门楼牌代码")
	private String dz_hdlxqsmlpdm;
	@FieldDesc("地址-活动路线起始门楼牌详址")
	private String dz_hdlxqsmlpxz;
	@FieldDesc("地址-活动路线结束门楼牌代码")
	private String dz_hdlxjsmlpdm;
	@FieldDesc("地址-活动路线结束门楼牌详址")
	private String dz_hdlxjsmlpxz;
	@FieldDesc("场地面积")
	private String cdmj;
	@FieldDesc("里程")
	private Long lc;
	@FieldDesc("活动开始时间")
	private String hdkssj;
	@FieldDesc("活动结束时间")
	private String hdjssj;
	@FieldDesc("活动主要内容")
	private String hdzynr;
	@FieldDesc("处理结果代码")
	private String cljgdm;
	@FieldDesc("备注")
	private String bz;
	
	//for query 
	@FieldDesc("活动开始时间-截止")
	private String hdkssjjz;
	@FieldDesc("活动结束时间-截止")
	private String hdjssjjz;
	public String getHdid() {
		return hdid;
	}
	public void setHdid(String hdid) {
		this.hdid = hdid;
	}
	public String getHdlxdm() {
		return hdlxdm;
	}
	public void setHdlxdm(String hdlxdm) {
		this.hdlxdm = hdlxdm;
	}
	public String getHdxzdm() {
		return hdxzdm;
	}
	public void setHdxzdm(String hdxzdm) {
		this.hdxzdm = hdxzdm;
	}
	public String getHdmc() {
		return hdmc;
	}
	public void setHdmc(String hdmc) {
		this.hdmc = hdmc;
	}
	public String getHdcc() {
		return hdcc;
	}
	public void setHdcc(String hdcc) {
		this.hdcc = hdcc;
	}
	public String getMccyjrsdm() {
		return mccyjrsdm;
	}
	public void setMccyjrsdm(String mccyjrsdm) {
		this.mccyjrsdm = mccyjrsdm;
	}
	public String getEdrl() {
		return edrl;
	}
	public void setEdrl(String edrl) {
		this.edrl = edrl;
	}
	public String getNfsps() {
		return nfsps;
	}
	public void setNfsps(String nfsps) {
		this.nfsps = nfsps;
	}
	public String getDz_hdddssxdm() {
		return dz_hdddssxdm;
	}
	public void setDz_hdddssxdm(String dz_hdddssxdm) {
		this.dz_hdddssxdm = dz_hdddssxdm;
	}
	public String getDz_hdddmlpdm() {
		return dz_hdddmlpdm;
	}
	public void setDz_hdddmlpdm(String dz_hdddmlpdm) {
		this.dz_hdddmlpdm = dz_hdddmlpdm;
	}
	public String getDz_hddddzdm() {
		return dz_hddddzdm;
	}
	public void setDz_hddddzdm(String dz_hddddzdm) {
		this.dz_hddddzdm = dz_hddddzdm;
	}
	public String getDz_hdddxz() {
		return dz_hdddxz;
	}
	public void setDz_hdddxz(String dz_hdddxz) {
		this.dz_hdddxz = dz_hdddxz;
	}
	public String getBcsm() {
		return bcsm;
	}
	public void setBcsm(String bcsm) {
		this.bcsm = bcsm;
	}
	public Long getMccsjrs() {
		return mccsjrs;
	}
	public void setMccsjrs(Long mccsjrs) {
		this.mccsjrs = mccsjrs;
	}
	public String getDz_hdlxqsmlpdm() {
		return dz_hdlxqsmlpdm;
	}
	public void setDz_hdlxqsmlpdm(String dz_hdlxqsmlpdm) {
		this.dz_hdlxqsmlpdm = dz_hdlxqsmlpdm;
	}
	public String getDz_hdlxjsmlpdm() {
		return dz_hdlxjsmlpdm;
	}
	public void setDz_hdlxjsmlpdm(String dz_hdlxjsmlpdm) {
		this.dz_hdlxjsmlpdm = dz_hdlxjsmlpdm;
	}
	public String getCdmj() {
		return cdmj;
	}
	public void setCdmj(String cdmj) {
		this.cdmj = cdmj;
	}
	public Long getLc() {
		return lc;
	}
	public void setLc(Long lc) {
		this.lc = lc;
	}
	public String getHdkssj() {
		return hdkssj;
	}
	public void setHdkssj(String hdkssj) {
		this.hdkssj = hdkssj;
	}
	public String getHdjssj() {
		return hdjssj;
	}
	public void setHdjssj(String hdjssj) {
		this.hdjssj = hdjssj;
	}
	public String getHdzynr() {
		return hdzynr;
	}
	public void setHdzynr(String hdzynr) {
		this.hdzynr = hdzynr;
	}
	public String getCljgdm() {
		return cljgdm;
	}
	public void setCljgdm(String cljgdm) {
		this.cljgdm = cljgdm;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getHdkssjjz() {
		return hdkssjjz;
	}
	public void setHdkssjjz(String hdkssjjz) {
		this.hdkssjjz = hdkssjjz;
	}
	public String getHdjssjjz() {
		return hdjssjjz;
	}
	public void setHdjssjjz(String hdjssjjz) {
		this.hdjssjjz = hdjssjjz;
	}
	public String getDz_hdddmlpxz() {
		return dz_hdddmlpxz;
	}
	public void setDz_hdddmlpxz(String dz_hdddmlpxz) {
		this.dz_hdddmlpxz = dz_hdddmlpxz;
	}
	public String getDz_hdlxqsmlpxz() {
		return dz_hdlxqsmlpxz;
	}
	public void setDz_hdlxqsmlpxz(String dz_hdlxqsmlpxz) {
		this.dz_hdlxqsmlpxz = dz_hdlxqsmlpxz;
	}
	public String getDz_hdlxjsmlpxz() {
		return dz_hdlxjsmlpxz;
	}
	public void setDz_hdlxjsmlpxz(String dz_hdlxjsmlpxz) {
		this.dz_hdlxjsmlpxz = dz_hdlxjsmlpxz;
	}
}
