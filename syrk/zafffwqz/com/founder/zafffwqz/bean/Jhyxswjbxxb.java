/**********************************************************************   
 * <p>文件名：Jhyxswjbxxb.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author tian_chengwei@founder.com.cn 
 * @date 2015-5-18 上午9:39:05 
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
 * @Package:      [com.founder.zafffwqz.bean.Jhyxswjbxxb.java]  
 * @ClassName:    [AFxxb]   
 * @Description:  [物防信息实体类]   
 * @Author:       [tian_chengwei@founder.com.cn]  
 * @CreateDate:   [2015-5-18 上午9:39:05]   
 * @UpdateUser:   [lk(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-5-18 上午9:39:05，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 * 
 * @review      : wu.w@founder.com.cn
 * @reviewDate  : 20150604
 */
@DBInfoAnnotation(tableName = "JHYXSW_JBXXB" , pk = "id")
		public class Jhyxswjbxxb extends BaseEntity implements Serializable {
		private static final long serialVersionUID = 1L;
		@FieldDesc("集会游行基本信息ID")
		private String id;
		@FieldDesc("姓名")
		private String xm;
		@FieldDesc("公民身份号码")
		private String gmsfhm;
		@FieldDesc("年龄")
		private Long nl;
		@FieldDesc("性别代码")
		private String xbdm;
		@FieldDesc("民族代码")
		private String mzdm;
		@FieldDesc("联系电话")
		private String lxdh;
		@FieldDesc("工作单位ID")
		private String gzdwid;
		@FieldDesc("工作单位")
		private String gzdw;
		@FieldDesc("地址-居住地址省市县代码")
		private String dz_jzdzssxdm;
		@FieldDesc("地址-居住地门楼牌代码")
		private String dz_jzdmlpdm;
		@FieldDesc("地址-居住地门楼牌详址")
		private String dz_jzdmlpxz;
		@FieldDesc("地址-居住地址代码")
		private String dz_jzdzdm;
		@FieldDesc("地址-居住地址详址")
		private String dz_jzdzxz;
		@FieldDesc("申请时间")
		private String sqsj;
		@FieldDesc("活动方式代码")
		private String hdfsdm;
		@FieldDesc("目的")
		private String md;
		@FieldDesc("采集人数")
		private Long cjrs;
		@FieldDesc("开始时间")
		private String kssj;
		@FieldDesc("结束时间")
		private String jssj;
		@FieldDesc("维持秩序人数")
		private Long wczxrs;
		@FieldDesc("集合地")
		private String jhd;
		@FieldDesc("解散地")
		private String jsd;
		@FieldDesc("使用音响")
		private String syyx;
		@FieldDesc("使用车辆")
		private String sycl;
		@FieldDesc("游行示威路线")
		private String yxswlx;
		@FieldDesc("集合示威场所")
		private String jhswcs;
		@FieldDesc("标语、口号")
		private String bykh;
		@FieldDesc("备注")
		private String bz;
		@FieldDesc("职业")
		private String zy;
		public String getZy() {
			return zy;
		}
		public void setZy(String zy) {
			this.zy = zy;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getXm() {
			return xm;
		}
		public void setXm(String xm) {
			this.xm = xm;
		}
		public String getGmsfhm() {
			return gmsfhm;
		}
		public void setGmsfhm(String gmsfhm) {
			this.gmsfhm = gmsfhm;
		}
		public Long getNl() {
			return nl;
		}
		public void setNl(Long nl) {
			this.nl = nl;
		}
		public String getXbdm() {
			return xbdm;
		}
		public void setXbdm(String xbdm) {
			this.xbdm = xbdm;
		}
		public String getMzdm() {
			return mzdm;
		}
		public void setMzdm(String mzdm) {
			this.mzdm = mzdm;
		}
		public String getLxdh() {
			return lxdh;
		}
		public void setLxdh(String lxdh) {
			this.lxdh = lxdh;
		}
		public String getGzdwid() {
			return gzdwid;
		}
		public void setGzdwid(String gzdwid) {
			this.gzdwid = gzdwid;
		}
		public String getGzdw() {
			return gzdw;
		}
		public void setGzdw(String gzdw) {
			this.gzdw = gzdw;
		}
		public String getDz_jzdzssxdm() {
			return dz_jzdzssxdm;
		}
		public void setDz_jzdzssxdm(String dz_jzdzssxdm) {
			this.dz_jzdzssxdm = dz_jzdzssxdm;
		}
		public String getDz_jzdmlpdm() {
			return dz_jzdmlpdm;
		}
		public void setDz_jzdmlpdm(String dz_jzdmlpdm) {
			this.dz_jzdmlpdm = dz_jzdmlpdm;
		}
		public String getDz_jzdmlpxz() {
			return dz_jzdmlpxz;
		}
		public void setDz_jzdmlpxz(String dz_jzdmlpxz) {
			this.dz_jzdmlpxz = dz_jzdmlpxz;
		}
		public String getDz_jzdzdm() {
			return dz_jzdzdm;
		}
		public void setDz_jzdzdm(String dz_jzdzdm) {
			this.dz_jzdzdm = dz_jzdzdm;
		}
		public String getDz_jzdzxz() {
			return dz_jzdzxz;
		}
		public void setDz_jzdzxz(String dz_jzdzxz) {
			this.dz_jzdzxz = dz_jzdzxz;
		}
		public String getSqsj() {
			return sqsj;
		}
		public void setSqsj(String sqsj) {
			this.sqsj = sqsj;
		}
		public String getHdfsdm() {
			return hdfsdm;
		}
		public void setHdfsdm(String hdfsdm) {
			this.hdfsdm = hdfsdm;
		}
		public String getMd() {
			return md;
		}
		public void setMd(String md) {
			this.md = md;
		}
		public Long getCjrs() {
			return cjrs;
		}
		public void setCjrs(Long cjrs) {
			this.cjrs = cjrs;
		}
		public String getKssj() {
			return kssj;
		}
		public void setKssj(String kssj) {
			this.kssj = kssj;
		}
		public String getJssj() {
			return jssj;
		}
		public void setJssj(String jssj) {
			this.jssj = jssj;
		}
		public Long getWczxrs() {
			return wczxrs;
		}
		public void setWczxrs(Long wczxrs) {
			this.wczxrs = wczxrs;
		}
		public String getJhd() {
			return jhd;
		}
		public void setJhd(String jhd) {
			this.jhd = jhd;
		}
		public String getJsd() {
			return jsd;
		}
		public void setJsd(String jsd) {
			this.jsd = jsd;
		}
		public String getSyyx() {
			return syyx;
		}
		public void setSyyx(String syyx) {
			this.syyx = syyx;
		}
		public String getSycl() {
			return sycl;
		}
		public void setSycl(String sycl) {
			this.sycl = sycl;
		}
		public String getYxswlx() {
			return yxswlx;
		}
		public void setYxswlx(String yxswlx) {
			this.yxswlx = yxswlx;
		}
		public String getJhswcs() {
			return jhswcs;
		}
		public void setJhswcs(String jhswcs) {
			this.jhswcs = jhswcs;
		}
		public String getBykh() {
			return bykh;
		}
		public void setBykh(String bykh) {
			this.bykh = bykh;
		}
		public String getBz() {
			return bz;
		}
		public void setBz(String bz) {
			this.bz = bz;
		}

}
