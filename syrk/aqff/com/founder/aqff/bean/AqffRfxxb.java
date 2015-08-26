package com.founder.aqff.bean;

import java.io.Serializable;
import java.util.List;
import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;
/******************************************************************************
 * @Package:      [com.founder.aqff.bean.AqffRfxxb]  
 * @ClassName:    [AqffRfxxb]   
 * @Description:  [人防信息实体类]   
 * @Author:       [xu_haibo@founder.com.cn]  
 * @CreateDate:   [2015-6-14 下午11:49:46]   
 * @UpdateUser:   [lk(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-14 下午11:49:46，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@DBInfoAnnotation(tableName = "AQFF_RF_JBXXB", pk = "id")
public class AqffRfxxb extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@FieldDesc("安全防范人防基本信息ID")
	private String id;
	@FieldDesc("组织名称")
	private String zzmc;
	@FieldDesc("组织类别")
	private String zzlbdm;
	@FieldDesc("防范组织形式")
	private String ffzzxsdm;
	@FieldDesc("地址-组织地址省市县（区）代码")
	private String dz_zzdzssxqdm;
	@FieldDesc("地址-组织地址门楼牌代码")
	private String dz_zzdzmlpdm;
	@FieldDesc("地址-组织地址门楼牌详址")
	private String dz_zzdzmlpxz;
	@FieldDesc("地址-组织地址代码")
	private String dz_zzdzdm;
	@FieldDesc("地址-组织地址详址")
	private String dz_zzdzxz;
	@FieldDesc("组建日期")
	private String zjrq;
	@FieldDesc("组织联系方式")
	private String zzlxfs;
	@FieldDesc("组织传真号码")
	private String zzczhm;
	@FieldDesc("隶属关系")
	private String lsggdm;
	@FieldDesc("经费来源")
	private String jflydm;
	@FieldDesc("是否治安承包")
	private String sfzacbdm;
	@FieldDesc("巡逻区域")
	private String xlqydm;
	@FieldDesc("巡逻点-X")
	private String xldx;
	@FieldDesc("巡逻点-Y")
	private String xldy;
	@FieldDesc("巡逻区域")
	private String xlqy;
	@FieldDesc("防范方式")
	private String fffsdm;
	@FieldDesc("责任范围")
	private String zrfwdm;
	@FieldDesc("地域类别")
	private String dylbdm;
	@FieldDesc("防范部位")
	private String ffbwdm;
	@FieldDesc("携带装备")
	private String xdzbdm;
	@FieldDesc("作用情况")
	private String zyqk;
	@FieldDesc("备注")
	private String bz;
	@FieldDesc("采集时间")
	private String xt_cjsj;
	@FieldDesc("录入时间")
	private String xt_lrsj;
	@FieldDesc("录入人姓名")
	private String xt_lrrxm;
	@FieldDesc("录入人ID")
	private String xt_lrrid;
	@FieldDesc("录入人部门")
	private String xt_lrrbm;
	@FieldDesc("录入人部门ID")
	private String xt_lrrbmid;
	@FieldDesc("录入IP")
	private String xt_lrip;
	@FieldDesc("最后修改时间")
	private String xt_zhxgsj;
	@FieldDesc("最后修改人姓名")
	private String xt_zhxgrxm;
	@FieldDesc("最后修改人ID")
	private String xt_zhxgrid;
	@FieldDesc("最后修改人部门")
	private String xt_zhxgrbm;
	@FieldDesc("最后修改人部门ID")
	private String xt_zhxgrbmid;
	@FieldDesc("最后修改IP")
	private String xt_zhxgip;
	@FieldDesc("注销标志")
	private String xt_zxbz;
	@FieldDesc("注销原因")
	private String xt_zxyy;
	
	//空间属性
	@FieldDesc("半径")
	private String mapRadius;
	@FieldDesc("坐标值")
	private String zbz;
	@FieldDesc("查询类型")
	private String type;
	@FieldDesc("空间图层的srid")
	private int srid;
	@FieldDesc("公共变量")
	private String gisUser;
	@FieldDesc("设置空间表名")
	private static String gisTable = "ZAFF_RFKJXXB_PT";
	@FieldDesc("空间图层的objectid")
	private Long objectid;
	@FieldDesc("rfid备用")
	private String rfid;
	@FieldDesc("所有的人员信息 数据库无此字段")
	private String ryAll;
	@FieldDesc("所有的人员返回的list 数据库无此字段")
	private List<Aqffrfryxxb> ryAllList;
	@FieldDesc("模糊查询用到的传参字段")
	private String ffzrrxm;
	private String ffzrrzjhm;
	private String ffzrrryly;
	private String fj;
	private String pcs;
	private String zrq;
	private int sfck;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getZzmc() {
		return zzmc;
	}
	public void setZzmc(String zzmc) {
		this.zzmc = zzmc;
	}
	public String getZzlbdm() {
		return zzlbdm;
	}
	public void setZzlbdm(String zzlbdm) {
		this.zzlbdm = zzlbdm;
	}
	public String getFfzzxsdm() {
		return ffzzxsdm;
	}
	public void setFfzzxsdm(String ffzzxsdm) {
		this.ffzzxsdm = ffzzxsdm;
	}
	public String getDz_zzdzssxqdm() {
		return dz_zzdzssxqdm;
	}
	public void setDz_zzdzssxqdm(String dz_zzdzssxqdm) {
		this.dz_zzdzssxqdm = dz_zzdzssxqdm;
	}
	public String getDz_zzdzmlpdm() {
		return dz_zzdzmlpdm;
	}
	public void setDz_zzdzmlpdm(String dz_zzdzmlpdm) {
		this.dz_zzdzmlpdm = dz_zzdzmlpdm;
	}
	public String getDz_zzdzmlpxz() {
		return dz_zzdzmlpxz;
	}
	public void setDz_zzdzmlpxz(String dz_zzdzmlpxz) {
		this.dz_zzdzmlpxz = dz_zzdzmlpxz;
	}
	public String getDz_zzdzdm() {
		return dz_zzdzdm;
	}
	public void setDz_zzdzdm(String dz_zzdzdm) {
		this.dz_zzdzdm = dz_zzdzdm;
	}
	public String getDz_zzdzxz() {
		return dz_zzdzxz;
	}
	public void setDz_zzdzxz(String dz_zzdzxz) {
		this.dz_zzdzxz = dz_zzdzxz;
	}
	public String getZjrq() {
		return zjrq;
	}
	public void setZjrq(String zjrq) {
		this.zjrq = zjrq;
	}
	public String getZzlxfs() {
		return zzlxfs;
	}
	public void setZzlxfs(String zzlxfs) {
		this.zzlxfs = zzlxfs;
	}
	public String getZzczhm() {
		return zzczhm;
	}
	public void setZzczhm(String zzczhm) {
		this.zzczhm = zzczhm;
	}
	public String getLsggdm() {
		return lsggdm;
	}
	public void setLsggdm(String lsggdm) {
		this.lsggdm = lsggdm;
	}
	public String getJflydm() {
		return jflydm;
	}
	public void setJflydm(String jflydm) {
		this.jflydm = jflydm;
	}
	public String getSfzacbdm() {
		return sfzacbdm;
	}
	public void setSfzacbdm(String sfzacbdm) {
		this.sfzacbdm = sfzacbdm;
	}
	public String getXlqydm() {
		return xlqydm;
	}
	public void setXlqydm(String xlqydm) {
		this.xlqydm = xlqydm;
	}
	public String getXldx() {
		return xldx;
	}
	public void setXldx(String xldx) {
		this.xldx = xldx;
	}
	public String getXldy() {
		return xldy;
	}
	public void setXldy(String xldy) {
		this.xldy = xldy;
	}
	public String getXlqy() {
		return xlqy;
	}
	public void setXlqy(String xlqy) {
		this.xlqy = xlqy;
	}
	public String getFffsdm() {
		return fffsdm;
	}
	public void setFffsdm(String fffsdm) {
		this.fffsdm = fffsdm;
	}
	public String getZrfwdm() {
		return zrfwdm;
	}
	public void setZrfwdm(String zrfwdm) {
		this.zrfwdm = zrfwdm;
	}
	public String getDylbdm() {
		return dylbdm;
	}
	public void setDylbdm(String dylbdm) {
		this.dylbdm = dylbdm;
	}
	public String getFfbwdm() {
		return ffbwdm;
	}
	public void setFfbwdm(String ffbwdm) {
		this.ffbwdm = ffbwdm;
	}
	public String getXdzbdm() {
		return xdzbdm;
	}
	public void setXdzbdm(String xdzbdm) {
		this.xdzbdm = xdzbdm;
	}
	public String getZyqk() {
		return zyqk;
	}
	public void setZyqk(String zyqk) {
		this.zyqk = zyqk;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getXt_cjsj() {
		return xt_cjsj;
	}
	public void setXt_cjsj(String xt_cjsj) {
		this.xt_cjsj = xt_cjsj;
	}
	public String getXt_lrsj() {
		return xt_lrsj;
	}
	public void setXt_lrsj(String xt_lrsj) {
		this.xt_lrsj = xt_lrsj;
	}
	public String getXt_lrrxm() {
		return xt_lrrxm;
	}
	public void setXt_lrrxm(String xt_lrrxm) {
		this.xt_lrrxm = xt_lrrxm;
	}
	public String getXt_lrrid() {
		return xt_lrrid;
	}
	public void setXt_lrrid(String xt_lrrid) {
		this.xt_lrrid = xt_lrrid;
	}
	public String getXt_lrrbm() {
		return xt_lrrbm;
	}
	public void setXt_lrrbm(String xt_lrrbm) {
		this.xt_lrrbm = xt_lrrbm;
	}
	public String getXt_lrrbmid() {
		return xt_lrrbmid;
	}
	public void setXt_lrrbmid(String xt_lrrbmid) {
		this.xt_lrrbmid = xt_lrrbmid;
	}
	public String getXt_lrip() {
		return xt_lrip;
	}
	public void setXt_lrip(String xt_lrip) {
		this.xt_lrip = xt_lrip;
	}
	public String getXt_zhxgsj() {
		return xt_zhxgsj;
	}
	public void setXt_zhxgsj(String xt_zhxgsj) {
		this.xt_zhxgsj = xt_zhxgsj;
	}
	public String getXt_zhxgrxm() {
		return xt_zhxgrxm;
	}
	public void setXt_zhxgrxm(String xt_zhxgrxm) {
		this.xt_zhxgrxm = xt_zhxgrxm;
	}
	public String getXt_zhxgrid() {
		return xt_zhxgrid;
	}
	public void setXt_zhxgrid(String xt_zhxgrid) {
		this.xt_zhxgrid = xt_zhxgrid;
	}
	public String getXt_zhxgrbm() {
		return xt_zhxgrbm;
	}
	public void setXt_zhxgrbm(String xt_zhxgrbm) {
		this.xt_zhxgrbm = xt_zhxgrbm;
	}
	public String getXt_zhxgrbmid() {
		return xt_zhxgrbmid;
	}
	public void setXt_zhxgrbmid(String xt_zhxgrbmid) {
		this.xt_zhxgrbmid = xt_zhxgrbmid;
	}
	public String getXt_zhxgip() {
		return xt_zhxgip;
	}
	public void setXt_zhxgip(String xt_zhxgip) {
		this.xt_zhxgip = xt_zhxgip;
	}
	public String getXt_zxbz() {
		return xt_zxbz;
	}
	public void setXt_zxbz(String xt_zxbz) {
		this.xt_zxbz = xt_zxbz;
	}
	public String getXt_zxyy() {
		return xt_zxyy;
	}
	public void setXt_zxyy(String xt_zxyy) {
		this.xt_zxyy = xt_zxyy;
	}
	public String getMapRadius() {
		return mapRadius;
	}
	public void setMapRadius(String mapRadius) {
		this.mapRadius = mapRadius;
	}
	public String getZbz() {
		return zbz;
	}
	public void setZbz(String zbz) {
		this.zbz = zbz;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getSrid() {
		return srid;
	}
	public void setSrid(int srid) {
		this.srid = srid;
	}
	public String getGisUser() {
		return gisUser;
	}
	public void setGisUser(String gisUser) {
		this.gisUser = gisUser;
	}
	public static String getGisTable() {
		return gisTable;
	}
	public static void setGisTable(String gisTable) {
		AqffRfxxb.gisTable = gisTable;
	}
	public Long getObjectid() {
		return objectid;
	}
	public void setObjectid(Long objectid) {
		this.objectid = objectid;
	}
	public String getRfid() {
		return rfid;
	}
	public void setRfid(String rfid) {
		this.rfid = rfid;
	}
	public String getRyAll() {
		return ryAll;
	}
	public void setRyAll(String ryAll) {
		this.ryAll = ryAll;
	}
	public List<Aqffrfryxxb> getRyAllList() {
		return ryAllList;
	}
	public void setRyAllList(List<Aqffrfryxxb> ryAllList) {
		this.ryAllList = ryAllList;
	}
	public String getFfzrrxm() {
		return ffzrrxm;
	}
	public void setFfzrrxm(String ffzrrxm) {
		this.ffzrrxm = ffzrrxm;
	}
	public String getFfzrrzjhm() {
		return ffzrrzjhm;
	}
	public void setFfzrrzjhm(String ffzrrzjhm) {
		this.ffzrrzjhm = ffzrrzjhm;
	}
	public String getFfzrrryly() {
		return ffzrrryly;
	}
	public void setFfzrrryly(String ffzrrryly) {
		this.ffzrrryly = ffzrrryly;
	}
	public String getFj() {
		return fj;
	}
	public void setFj(String fj) {
		this.fj = fj;
	}
	public String getPcs() {
		return pcs;
	}
	public void setPcs(String pcs) {
		this.pcs = pcs;
	}
	public String getZrq() {
		return zrq;
	}
	public void setZrq(String zrq) {
		this.zrq = zrq;
	}
	public int getSfck() {
		return sfck;
	}
	public void setSfck(int sfck) {
		this.sfck = sfck;
	}

}
