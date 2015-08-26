package com.founder.sydw.bean;

import java.io.Serializable;

import org.springframework.http.HttpEntity;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

@DBInfoAnnotation(tableName = "DW_DWJBXXB", pk = "id", logQueryField = "id")
public class Dwjbxxb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@FieldDesc("单位ID")
	private String id;
	@FieldDesc("单位类别代码 ")
	private String dwlbdm;
	@FieldDesc("上级单位ID ")
	private String sjdwid;
	@FieldDesc("管理部门ID")
	private String glbmid;
	@FieldDesc("管理派出所ID")
	private String glpcsid;
	@FieldDesc("管理分县局ID")
	private String glfxjid;
	@FieldDesc("单位编号")
	private String zagldwbm;
	@FieldDesc("单位名称")
	private String dwmc;
	@FieldDesc("是否办理营业执照代码")
	private String sfblyyzzdm;
	@FieldDesc("营业执照号")
	private String yyzzh;
	@FieldDesc("营业执照有效期_起始日期")
	private String yyzzyxq_qsrq;
	@FieldDesc("营业执照有效期_截止日期")
	private String yyzzyxq_jzrq;
	@FieldDesc("营业执照发证机关ID")
	private String yyzzfzjgid;
	@FieldDesc("营业执照发证机关")
	private String yyzzfzjg;
	@FieldDesc("注册资金")
	private String zczb;
	@FieldDesc("组织机构代码")
	private String zzjgdm;
	@FieldDesc("组织机构名称")
	private String zzjgmc;
	@FieldDesc("税务登记号码")
	private String swdjhm;
	@FieldDesc("经营范围（主营）")
	private String jyfwzy;
	@FieldDesc("经营范围（兼营）")
	private String jyfwjy;
	@FieldDesc("经营方式代码")
	private String jyfsdm;
	@FieldDesc("经营面积_面积（平方米）")
	private String jymj_mjpfm;
	@FieldDesc("经济类型代码")
	private String jjlxdm;
	@FieldDesc("联系电话")
	private String lxdh;
	@FieldDesc("传真")
	private String czhm;
	@FieldDesc("是否有房屋鉴定代码")
	private String sfyfwjddm;
	@FieldDesc("鉴定时间")
	private String jdsj;
	@FieldDesc("是否外资单位代码")
	private String sfwzdwdm;
	@FieldDesc("单位状态代码")
	private String dwztdm;
	@FieldDesc("核定容纳人数")
	private String hdrnrs;
	@FieldDesc("营业时间")
	private String yysj;
	@FieldDesc("是否周期性营业代码")
	private String sfzqxydm;
	@FieldDesc("周期性营业规律")
	private String zqxyygl;
	@FieldDesc("备注")
	private String bz;
	@FieldDesc("地址-单位地址代码")
	private String dz_dwdzdm;
	@FieldDesc("地址-单位地址省市县代码")
	private String dz_dwdzssxdm;
	@FieldDesc("地址-单位地址详址")
	private String dz_dwdzxz;
	@FieldDesc("地址-单位地址门楼牌代码")
	private String dz_dwdzmlpdm;
	@FieldDesc("地址-单位地址门楼牌详址")
	private String dz_dwdzmlpxz;
	@FieldDesc("是否涉外单位代码")
	private String sfswdwdm;
	@FieldDesc("是否有消防鉴定代码")
	private String sfyxfjddm;
	@FieldDesc("开业日期")
	private String kyrq;
	@FieldDesc("重点单位标识")
	private String zddwbs;
	@FieldDesc("是否周期性营业代码")
	private String sfzqxyydm;
	@FieldDesc("录入标识   0：系统新增   1：从其他系统抽取     默认：0")
	private String xt_lrbz;
	@FieldDesc("核实时间")
	private String xt_hssj;
	@FieldDesc("单位英文名称")
	private String dwywmc;
	@FieldDesc("单位英文缩写")
	private String dwywsx;
	@FieldDesc("行业类别代码")
	private String hylbdm;
	@FieldDesc("停业日期")
	private String tyrq01;
	@FieldDesc("网址")
	private String wz;
	@FieldDesc("空间图层的srid")
	private int srid;
	@FieldDesc("查询类型")
	private String type;
	@FieldDesc("坐标x")
	private String zbx;
	@FieldDesc("坐标y")
	private String zby;
	@FieldDesc("半径")
	private String mapRadius;
	@FieldDesc("坐标值")
	private String zbz;
	private HttpEntity<byte[]>  zpfj;
	private String condition;
	private String cxfs;
	private String dwbm;
	private String sjdwmc;
	//zhang_guoliang@founder.com 增加地址描述业务流程【开始】
	@FieldDesc("地址描述_坐标X")
	private String dzms_zbx;
	@FieldDesc("地址描述_坐标Y")
	private String dzms_zby;
	@FieldDesc("地址描述_所属责任区代码")
	private String dzms_sszrqdm;
	private String dzms_sszrqmc;
	@FieldDesc("地址描述_所属派出所代码")
	private String dzms_sspcsdm;
	private String dzms_sspcsmc;
	
	@FieldDesc("地址描述")
	private String dzms;
	@FieldDesc("层户地址")
	private String dzms_chdz;
	//地址描述_单位地址门楼牌代码
	private String dzms_dwdzmlpdm;
	//地址描述_单位地址门楼牌详址
	private String dzms_dwdzmlpxz;
	//地址状态
	private String dwdzzt;
	//zhang_guoliang@founder.com 增加地址描述业务流程【结束】
	/**
	 * @return the sjdwmc
	 */
	// @star新增是否安装治安管理系统开始
	@FieldDesc(" 是否安装治安管理系统")
	private String sfazzaglxxxt;


	public String getZzjgmc() {
		return zzjgmc;
	}

	public void setZzjgmc(String zzjgmc) {
		this.zzjgmc = zzjgmc;
	}

	public String getSfazzaglxxxt() {
		return sfazzaglxxxt;
	}

	public void setSfazzaglxxxt(String sfazzaglxxxt) {
		this.sfazzaglxxxt = sfazzaglxxxt;
	}
		
    // @star新增是否安装治安管理系统结束
	public String getSjdwmc() {
		return sjdwmc;
	}
   
	public String getDwdzzt() {
		return dwdzzt;
	}

	public void setDwdzzt(String dwdzzt) {
		this.dwdzzt = dwdzzt;
	}

	/**
	 * @param sjdwmc the sjdwmc to set
	 */
	public void setSjdwmc(String sjdwmc) {
		this.sjdwmc = sjdwmc;
	}

	/**
	 * @return the zpfj
	 */
	public HttpEntity<byte[]> getZpfj() {
		return zpfj;
	}

	/**
	 * @param zpfj the zpfj to set
	 */
	public void setZpfj(HttpEntity<byte[]> zpfj) {
		this.zpfj = zpfj;
	}

	/**
	 * @return the cxfs
	 */
	public String getCxfs() {
		return cxfs;
	}

	/**
	 * @param cxfs the cxfs to set
	 */
	public void setCxfs(String cxfs) {
		this.cxfs = cxfs;
	}

	/**
	 * @return the zczb
	 */
	public String getZczb() {
		return zczb;
	}

	/**
	 * @param zczb the zczb to set
	 */
	public void setZczb(String zczb) {
		this.zczb = zczb;
	}

	/**
	 * @return the jymj_mjpfm
	 */
	public String getJymj_mjpfm() {
		return jymj_mjpfm;
	}

	/**
	 * @param jymjMjpfm the jymj_mjpfm to set
	 */
	public void setJymj_mjpfm(String jymjMjpfm) {
		jymj_mjpfm = jymjMjpfm;
	}

	/**
	 * @return the hdrnrs
	 */
	public String getHdrnrs() {
		return hdrnrs;
	}

	/**
	 * @param hdrnrs the hdrnrs to set
	 */
	public void setHdrnrs(String hdrnrs) {
		this.hdrnrs = hdrnrs;
	}

	/**
	 * @return the dwbm
	 */
	public String getDwbm() {
		return dwbm;
	}

	/**
	 * @param dwbm the dwbm to set
	 */
	public void setDwbm(String dwbm) {
		this.dwbm = dwbm;
	}

	/**
	 * @return the condition
	 */
	public String getCondition() {
		return condition;
	}

	/**
	 * @param condition the condition to set
	 */
	public void setCondition(String condition) {
		this.condition = condition;
	}

	/**
	 * @return the srid
	 */
	public int getSrid() {
		return srid;
	}

	/**
	 * @param srid the srid to set
	 */
	public void setSrid(int srid) {
		this.srid = srid;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the zbx
	 */
	public String getZbx() {
		return zbx;
	}

	/**
	 * @param zbx the zbx to set
	 */
	public void setZbx(String zbx) {
		this.zbx = zbx;
	}

	/**
	 * @return the zby
	 */
	public String getZby() {
		return zby;
	}

	/**
	 * @param zby the zby to set
	 */
	public void setZby(String zby) {
		this.zby = zby;
	}

	/**
	 * @return the mapRadius
	 */
	public String getMapRadius() {
		return mapRadius;
	}

	/**
	 * @param mapRadius the mapRadius to set
	 */
	public void setMapRadius(String mapRadius) {
		this.mapRadius = mapRadius;
	}

	/**
	 * @return the zbz
	 */
	public String getZbz() {
		return zbz;
	}

	/**
	 * @param zbz the zbz to set
	 */
	public void setZbz(String zbz) {
		this.zbz = zbz;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the dwlbdm
	 */
	public String getDwlbdm() {
		return dwlbdm;
	}

	/**
	 * @param dwlbdm
	 *            the dwlbdm to set
	 */
	public void setDwlbdm(String dwlbdm) {
		this.dwlbdm = dwlbdm;
	}
	
	/**
	 * @return the sjdwid
	 */
	public String getSjdwid() {
		return sjdwid;
	}

	/**
	 * @param sjdwid
	 *            the sjdwid to set
	 */
	public void setSjdwid(String sjdwid) {
		this.sjdwid = sjdwid;
	}


	/**
	 * @return the glbmid
	 */
	public String getGlbmid() {
		return glbmid;
	}

	/**
	 * @param glbmid
	 *            the glbmid to set
	 */
	public void setGlbmid(String glbmid) {
		this.glbmid = glbmid;
	}

	/**
	 * @return the glpcsid
	 */
	public String getGlpcsid() {
		return glpcsid;
	}

	/**
	 * @param glpcsid
	 *            the glpcsid to set
	 */
	public void setGlpcsid(String glpcsid) {
		this.glpcsid = glpcsid;
	}

	/**
	 * @return the glfxjid
	 */
	public String getGlfxjid() {
		return glfxjid;
	}

	/**
	 * @param glfxjid
	 *            the glfxjid to set
	 */
	public void setGlfxjid(String glfxjid) {
		this.glfxjid = glfxjid;
	}

	/**
	 * @return the zagldwbm
	 */
	public String getZagldwbm() {
		return zagldwbm;
	}

	/**
	 * @param zagldwbm
	 *            the zagldwbm to set
	 */
	public void setZagldwbm(String zagldwbm) {
		this.zagldwbm = zagldwbm;
	}

	/**
	 * @return the dwmc
	 */
	public String getDwmc() {
		return dwmc;
	}

	/**
	 * @param dwmc
	 *            the dwmc to set
	 */
	public void setDwmc(String dwmc) {
		this.dwmc = dwmc;
	}

	/**
	 * @return the sfblyyzzdm
	 */
	public String getSfblyyzzdm() {
		return sfblyyzzdm;
	}

	/**
	 * @param sfblyyzzdm
	 *            the sfblyyzzdm to set
	 */
	public void setSfblyyzzdm(String sfblyyzzdm) {
		this.sfblyyzzdm = sfblyyzzdm;
	}

	/**
	 * @return the yyzzh
	 */
	public String getYyzzh() {
		return yyzzh;
	}

	/**
	 * @param yyzzh
	 *            the yyzzh to set
	 */
	public void setYyzzh(String yyzzh) {
		this.yyzzh = yyzzh;
	}

	/**
	 * @return the yyzzyxq_qsrq
	 */
	public String getYyzzyxq_qsrq() {
		return yyzzyxq_qsrq;
	}

	/**
	 * @param yyzzyxqQsrq
	 *            the yyzzyxq_qsrq to set
	 */
	public void setYyzzyxq_qsrq(String yyzzyxqQsrq) {
		yyzzyxq_qsrq = yyzzyxqQsrq;
	}

	/**
	 * @return the yyzzyxq_jzrq
	 */
	public String getYyzzyxq_jzrq() {
		return yyzzyxq_jzrq;
	}

	/**
	 * @param yyzzyxqJzrq
	 *            the yyzzyxq_jzrq to set
	 */
	public void setYyzzyxq_jzrq(String yyzzyxqJzrq) {
		yyzzyxq_jzrq = yyzzyxqJzrq;
	}

	/**
	 * @return the yyzzfzjgid
	 */
	public String getYyzzfzjgid() {
		return yyzzfzjgid;
	}

	/**
	 * @param yyzzfzjgid
	 *            the yyzzfzjgid to set
	 */
	public void setYyzzfzjgid(String yyzzfzjgid) {
		this.yyzzfzjgid = yyzzfzjgid;
	}

	/**
	 * @return the yyzzfzjg
	 */
	public String getYyzzfzjg() {
		return yyzzfzjg;
	}

	/**
	 * @param yyzzfzjg
	 *            the yyzzfzjg to set
	 */
	public void setYyzzfzjg(String yyzzfzjg) {
		this.yyzzfzjg = yyzzfzjg;
	}

	
	/**
	 * @return the zzjgdm
	 */
	public String getZzjgdm() {
		return zzjgdm;
	}

	/**
	 * @param zzjgdm
	 *            the zzjgdm to set
	 */
	public void setZzjgdm(String zzjgdm) {
		this.zzjgdm = zzjgdm;
	}

	/**
	 * @return the swdjhm
	 */
	public String getSwdjhm() {
		return swdjhm;
	}

	/**
	 * @param swdjhm
	 *            the swdjhm to set
	 */
	public void setSwdjhm(String swdjhm) {
		this.swdjhm = swdjhm;
	}

	/**
	 * @return the jyfwzy
	 */
	public String getJyfwzy() {
		return jyfwzy;
	}

	/**
	 * @param jyfwzy
	 *            the jyfwzy to set
	 */
	public void setJyfwzy(String jyfwzy) {
		this.jyfwzy = jyfwzy;
	}

	/**
	 * @return the jyfwjy
	 */
	public String getJyfwjy() {
		return jyfwjy;
	}

	/**
	 * @param jyfwjy
	 *            the jyfwjy to set
	 */
	public void setJyfwjy(String jyfwjy) {
		this.jyfwjy = jyfwjy;
	}

	/**
	 * @return the jyfsdm
	 */
	public String getJyfsdm() {
		return jyfsdm;
	}

	/**
	 * @param jyfsdm
	 *            the jyfsdm to set
	 */
	public void setJyfsdm(String jyfsdm) {
		this.jyfsdm = jyfsdm;
	}

	

	/**
	 * @return the jjlxdm
	 */
	public String getJjlxdm() {
		return jjlxdm;
	}

	/**
	 * @param jjlxdm
	 *            the jjlxdm to set
	 */
	public void setJjlxdm(String jjlxdm) {
		this.jjlxdm = jjlxdm;
	}

	/**
	 * @return the lxdh
	 */
	public String getLxdh() {
		return lxdh;
	}

	/**
	 * @param lxdh
	 *            the lxdh to set
	 */
	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}

	/**
	 * @return the czhm
	 */
	public String getCzhm() {
		return czhm;
	}

	/**
	 * @param czhm
	 *            the czhm to set
	 */
	public void setCzhm(String czhm) {
		this.czhm = czhm;
	}


	/**
	 * @return the sfyfwjddm
	 */
	public String getSfyfwjddm() {
		return sfyfwjddm;
	}

	/**
	 * @param sfyfwjddm
	 *            the sfyfwjddm to set
	 */
	public void setSfyfwjddm(String sfyfwjddm) {
		this.sfyfwjddm = sfyfwjddm;
	}

	/**
	 * @return the jdsj
	 */
	public String getJdsj() {
		return jdsj;
	}

	/**
	 * @param jdsj
	 *            the jdsj to set
	 */
	public void setJdsj(String jdsj) {
		this.jdsj = jdsj;
	}

	/**
	 * @return the sfwzdwdm
	 */
	public String getSfwzdwdm() {
		return sfwzdwdm;
	}

	/**
	 * @param sfwzdwdm
	 *            the sfwzdwdm to set
	 */
	public void setSfwzdwdm(String sfwzdwdm) {
		this.sfwzdwdm = sfwzdwdm;
	}

	/**
	 * @return the dwztdm
	 */
	public String getDwztdm() {
		return dwztdm;
	}

	/**
	 * @param dwztdm
	 *            the dwztdm to set
	 */
	public void setDwztdm(String dwztdm) {
		this.dwztdm = dwztdm;
	}

	

	/**
	 * @return the yysj
	 */
	public String getYysj() {
		return yysj;
	}

	/**
	 * @param yysj
	 *            the yysj to set
	 */
	public void setYysj(String yysj) {
		this.yysj = yysj;
	}

	/**
	 * @return the sfzqxydm
	 */
	public String getSfzqxydm() {
		return sfzqxydm;
	}

	/**
	 * @param sfzqxydm
	 *            the sfzqxydm to set
	 */
	public void setSfzqxydm(String sfzqxydm) {
		this.sfzqxydm = sfzqxydm;
	}

	/**
	 * @return the zqxyygl
	 */
	public String getZqxyygl() {
		return zqxyygl;
	}

	/**
	 * @param zqxyygl
	 *            the zqxyygl to set
	 */
	public void setZqxyygl(String zqxyygl) {
		this.zqxyygl = zqxyygl;
	}

	/**
	 * @return the bz
	 */
	public String getBz() {
		return bz;
	}

	/**
	 * @param bz
	 *            the bz to set
	 */
	public void setBz(String bz) {
		this.bz = bz;
	}


	/**
	 * @return the dz_dwdzdm
	 */
	public String getDz_dwdzdm() {
		return dz_dwdzdm;
	}

	/**
	 * @param dzDwdzdm
	 *            the dz_dwdzdm to set
	 */
	public void setDz_dwdzdm(String dzDwdzdm) {
		dz_dwdzdm = dzDwdzdm;
	}

	/**
	 * @return the dz_dwdzssxdm
	 */
	public String getDz_dwdzssxdm() {
		return dz_dwdzssxdm;
	}

	/**
	 * @param dzDwdzssxdm
	 *            the dz_dwdzssxdm to set
	 */
	public void setDz_dwdzssxdm(String dzDwdzssxdm) {
		dz_dwdzssxdm = dzDwdzssxdm;
	}

	/**
	 * @return the dz_dwdzxz
	 */
	public String getDz_dwdzxz() {
		return dz_dwdzxz;
	}

	/**
	 * @param dzDwdzxz
	 *            the dz_dwdzxz to set
	 */
	public void setDz_dwdzxz(String dzDwdzxz) {
		dz_dwdzxz = dzDwdzxz;
	}


	/**
	 * @return the dz_dwdzmlpdm
	 */
	public String getDz_dwdzmlpdm() {
		return dz_dwdzmlpdm;
	}

	/**
	 * @param dzDwdzmlpdm
	 *            the dz_dwdzmlpdm to set
	 */
	public void setDz_dwdzmlpdm(String dzDwdzmlpdm) {
		dz_dwdzmlpdm = dzDwdzmlpdm;
	}

	/**
	 * @return the dz_dwdzmlpxz
	 */
	public String getDz_dwdzmlpxz() {
		return dz_dwdzmlpxz;
	}

	/**
	 * @param dzDwdzmlpxz
	 *            the dz_dwdzmlpxz to set
	 */
	public void setDz_dwdzmlpxz(String dzDwdzmlpxz) {
		dz_dwdzmlpxz = dzDwdzmlpxz;
	}

	/**
	 * @return the sfswdwdm
	 */
	public String getSfswdwdm() {
		return sfswdwdm;
	}

	/**
	 * @param sfswdwdm
	 *            the sfswdwdm to set
	 */
	public void setSfswdwdm(String sfswdwdm) {
		this.sfswdwdm = sfswdwdm;
	}

	/**
	 * @return the sfyxfjddm
	 */
	public String getSfyxfjddm() {
		return sfyxfjddm;
	}

	/**
	 * @param sfyxfjddm
	 *            the sfyxfjddm to set
	 */
	public void setSfyxfjddm(String sfyxfjddm) {
		this.sfyxfjddm = sfyxfjddm;
	}

	/**
	 * @return the kyrq
	 */
	public String getKyrq() {
		return kyrq;
	}

	/**
	 * @param kyrq
	 *            the kyrq to set
	 */
	public void setKyrq(String kyrq) {
		this.kyrq = kyrq;
	}



	/**
	 * @return the zddwbs
	 */
	public String getZddwbs() {
		return zddwbs;
	}

	/**
	 * @param zddwbs the zddwbs to set
	 */
	public void setZddwbs(String zddwbs) {
		this.zddwbs = zddwbs;
	}

	/**
	 * @return the sfzqxyydm
	 */
	public String getSfzqxyydm() {
		return sfzqxyydm;
	}

	/**
	 * @param sfzqxyydm
	 *            the sfzqxyydm to set
	 */
	public void setSfzqxyydm(String sfzqxyydm) {
		this.sfzqxyydm = sfzqxyydm;
	}


	/**
	 * @return the xt_lrbz
	 */
	public String getXt_lrbz() {
		return xt_lrbz;
	}

	/**
	 * @param xtLrbz
	 *            the xt_lrbz to set
	 */
	public void setXt_lrbz(String xtLrbz) {
		xt_lrbz = xtLrbz;
	}

	/**
	 * @return the xt_hssj
	 */
	public String getXt_hssj() {
		return xt_hssj;
	}

	/**
	 * @param xtHssj
	 *            the xt_hssj to set
	 */
	public void setXt_hssj(String xtHssj) {
		xt_hssj = xtHssj;
	}

	/**
	 * @return the dwywmc
	 */
	public String getDwywmc() {
		return dwywmc;
	}

	/**
	 * @param dwywmc
	 *            the dwywmc to set
	 */
	public void setDwywmc(String dwywmc) {
		this.dwywmc = dwywmc;
	}

	/**
	 * @return the dwywsx
	 */
	public String getDwywsx() {
		return dwywsx;
	}

	/**
	 * @param dwywsx
	 *            the dwywsx to set
	 */
	public void setDwywsx(String dwywsx) {
		this.dwywsx = dwywsx;
	}

	/**
	 * @return the hylbdm
	 */
	public String getHylbdm() {
		return hylbdm;
	}

	/**
	 * @param hylbdm
	 *            the hylbdm to set
	 */
	public void setHylbdm(String hylbdm) {
		this.hylbdm = hylbdm;
	}

	/**
	 * @return the tyrq01
	 */
	public String getTyrq01() {
		return tyrq01;
	}

	/**
	 * @param tyrq01
	 *            the tyrq01 to set
	 */
	public void setTyrq01(String tyrq01) {
		this.tyrq01 = tyrq01;
	}

	/**
	 * @return the wz
	 */
	public String getWz() {
		return wz;
	}

	/**
	 * @param wz
	 *            the wz to set
	 */
	public void setWz(String wz) {
		this.wz = wz;
	}

	public String getDzms_zbx() {
		return dzms_zbx;
	}

	public void setDzms_zbx(String dzms_zbx) {
		this.dzms_zbx = dzms_zbx;
	}

	public String getDzms_zby() {
		return dzms_zby;
	}

	public void setDzms_zby(String dzms_zby) {
		this.dzms_zby = dzms_zby;
	}

	public String getDzms_sszrqdm() {
		return dzms_sszrqdm;
	}

	public void setDzms_sszrqdm(String dzms_sszrqdm) {
		this.dzms_sszrqdm = dzms_sszrqdm;
	}

	public String getDzms_sspcsdm() {
		return dzms_sspcsdm;
	}

	public void setDzms_sspcsdm(String dzms_sspcsdm) {
		this.dzms_sspcsdm = dzms_sspcsdm;
	}

	public String getDzms_chdz() {
		return dzms_chdz;
	}

	public void setDzms_chdz(String dzms_chdz) {
		this.dzms_chdz = dzms_chdz;
	}

	public String getDzms_dwdzmlpdm() {
		return dzms_dwdzmlpdm;
	}

	public void setDzms_dwdzmlpdm(String dzms_dwdzmlpdm) {
		this.dzms_dwdzmlpdm = dzms_dwdzmlpdm;
	}

	public String getDzms_dwdzmlpxz() {
		return dzms_dwdzmlpxz;
	}

	public void setDzms_dwdzmlpxz(String dzms_dwdzmlpxz) {
		this.dzms_dwdzmlpxz = dzms_dwdzmlpxz;
	}

	public String getDzms_sszrqmc() {
		return dzms_sszrqmc;
	}

	public void setDzms_sszrqmc(String dzms_sszrqmc) {
		this.dzms_sszrqmc = dzms_sszrqmc;
	}

	public String getDzms_sspcsmc() {
		return dzms_sspcsmc;
	}

	public void setDzms_sspcsmc(String dzms_sspcsmc) {
		this.dzms_sspcsmc = dzms_sspcsmc;
	}

	public String getDzms() {
		return dzms;
	}

	public void setDzms(String dzms) {
		this.dzms = dzms;
	}
	
	
}