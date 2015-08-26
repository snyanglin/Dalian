/**********************************************************************   
 * <p>文件名：DwxyaqxxbBay.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author wu_chunhui@founder.com.cn 
 * @date 2014-12-5 下午12:07:03 
 * @history
 * @department：研发部
 *
 */
package com.founder.sydw.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;

/******************************************************************************
 * @Package: [com.founder.sydw.bean.DwjbxxbBay.java]
 * @ClassName: [DwjbxxbBay]
 * @Description: [一句话描述该类的功能]
 * @Author: [wu_chunhui@founder.com.cn]
 * @CreateDate: [2014-12-5 下午12:07:03]
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2014-12-5 下午12:07:03，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@DBInfoAnnotation(tableName = "DW_DWBAY", pk = "id")
public class DwjbxxbBay extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@FieldDesc("保安员ID")
	private String id;
	@FieldDesc("单位ID")
	private String dwid;
	@FieldDesc("人员ID")
	private String ryid;
	@FieldDesc("姓名")
	private String xm;
	@FieldDesc("性别")
	private String xbdm;
	@FieldDesc("证件种类代码")
	private String zjlxdm;
	@FieldDesc("证件号码")
	private String zjhm;
	@FieldDesc("联系电话")
	private String lxdh;
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
	@FieldDesc("曾用名")
	private String cym;
	@FieldDesc("民族代码")
	private String mzdm;
	@FieldDesc("出生日期")
	private String csrq;
	@FieldDesc("户籍地省市县代码")
	private String hjdssxdm;
	@FieldDesc("户籍地详址")
	private String hjdxz;
	@FieldDesc("现住址省市县代码")
	private String xzzssxdm;
	@FieldDesc("现住址详址")
	private String xzzxz;
	@FieldDesc("学历代码")
	private String xldm;
	@FieldDesc("兵役状况")
	private String byzkdm;
	@FieldDesc("婚姻状况代码")
	private String hyzkdm;
	@FieldDesc("身高")
	private Long sg;
	@FieldDesc("血型代码")
	private String xxdm;
	@FieldDesc("健康状况代码")
	private String jkzkdm;
	@FieldDesc("政治面貌")
	private String zzmmdm;
	@FieldDesc("报名日期")
	private String bmrq;
	@FieldDesc("准考证号")
	private String zkzh;
	@FieldDesc("考试地点")
	private String ksdd;
	@FieldDesc("考试时间")
	private String kssj;
	@FieldDesc("考试成绩")
	private Long kscj;
	@FieldDesc("审查公安机关ID")
	private String scgajgid;
	@FieldDesc("审查公安机关")
	private String scgajg;
	@FieldDesc("审查结果")
	private String scjg;
	@FieldDesc("审查不通过原因")
	private String scbtgyy;
	@FieldDesc("十指指纹捺印卡号")
	private String szzwaykh;
	@FieldDesc("指纹采集公安机关ID")
	private String zwcjgajgid;
	@FieldDesc("指纹采集公安机关")
	private String zwcjgajg;
	@FieldDesc("指纹采集日期")
	private String zwcjrq;
	@FieldDesc("保安员证编码")
	private String bayzbh;
	@FieldDesc("发证机关ID")
	private String fzjgid;
	@FieldDesc("发证机关")
	private String fzjg;
	@FieldDesc("发证日期")
	private String fzrq;
	@FieldDesc("保安员证撤销原因")
	private String bayzcxyy;
	@FieldDesc("保安员证撤销决定机关ID")
	private String bayzcxjdjgid;
	@FieldDesc("保安员证撤销决定机关")
	private String bayzcxjdjg;
	@FieldDesc("保安员证撤销日期")
	private String bayzcxrq;
	@FieldDesc("保安员证吊销原因")
	private String bayzdxyy;
	@FieldDesc("保安员证吊销决定机关ID")
	private String bayzdxjdjgid;
	@FieldDesc("保安员证吊销决定机关")
	private String bayzdxjdjg;
	@FieldDesc("保安员证吊销日期")
	private String bayzdxrq;
	@FieldDesc("其他专业资格证名称")
	private String qtzyzgzmc;
	@FieldDesc("其他专业资格证号码")
	private String qtzyzgzhm;
	@FieldDesc("保安员职业技能等级代码")
	private String bayzyjndjdm;
	@FieldDesc("职业等级证书编码")
	private String zydjzsbh;
	@FieldDesc("取得职业等级证书时间")
	private String qdzydjzssj;
	@FieldDesc("是否是信息员")
	private String sfsxxydm;
	@FieldDesc("信息员批准公安机关ID")
	private String xxypzgajgid;
	@FieldDesc("信息员批准公安机关")
	private String xxypzgajg;
	@FieldDesc("信息员批准日期")
	private String xxypzrq;


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

	public String getDwid() {
		return dwid;
	}

	public void setDwid(String dwid) {
		this.dwid = dwid;
	}

	/**
	 * @return the ryid
	 */
	public String getRyid() {
		return ryid;
	}

	/**
	 * @param ryid
	 *            the ryid to set
	 */
	public void setRyid(String ryid) {
		this.ryid = ryid;
	}

	/**
	 * @return the xm
	 */
	public String getXm() {
		return xm;
	}

	/**
	 * @param xm
	 *            the xm to set
	 */
	public void setXm(String xm) {
		this.xm = xm;
	}

	/**
	 * @return the xbdm
	 */
	public String getXbdm() {
		return xbdm;
	}

	/**
	 * @param xbdm
	 *            the xbdm to set
	 */
	public void setXbdm(String xbdm) {
		this.xbdm = xbdm;
	}

	/**
	 * @return the zjlxdm
	 */
	public String getZjlxdm() {
		return zjlxdm;
	}

	/**
	 * @param zjlxdm
	 *            the zjlxdm to set
	 */
	public void setZjlxdm(String zjlxdm) {
		this.zjlxdm = zjlxdm;
	}

	/**
	 * @return the zjhm
	 */
	public String getZjhm() {
		return zjhm;
	}

	/**
	 * @param zjhm
	 *            the zjhm to set
	 */
	public void setZjhm(String zjhm) {
		this.zjhm = zjhm;
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
	 * @return the xt_cjsj
	 */
	public String getXt_cjsj() {
		return xt_cjsj;
	}

	/**
	 * @param xtCjsj
	 *            the xt_cjsj to set
	 */
	public void setXt_cjsj(String xtCjsj) {
		xt_cjsj = xtCjsj;
	}

	/**
	 * @return the xt_lrsj
	 */
	public String getXt_lrsj() {
		return xt_lrsj;
	}

	/**
	 * @param xtLrsj
	 *            the xt_lrsj to set
	 */
	public void setXt_lrsj(String xtLrsj) {
		xt_lrsj = xtLrsj;
	}

	/**
	 * @return the xt_lrrxm
	 */
	public String getXt_lrrxm() {
		return xt_lrrxm;
	}

	/**
	 * @param xtLrrxm
	 *            the xt_lrrxm to set
	 */
	public void setXt_lrrxm(String xtLrrxm) {
		xt_lrrxm = xtLrrxm;
	}

	/**
	 * @return the xt_lrrid
	 */
	public String getXt_lrrid() {
		return xt_lrrid;
	}

	/**
	 * @param xtLrrid
	 *            the xt_lrrid to set
	 */
	public void setXt_lrrid(String xtLrrid) {
		xt_lrrid = xtLrrid;
	}

	/**
	 * @return the xt_lrrbm
	 */
	public String getXt_lrrbm() {
		return xt_lrrbm;
	}

	/**
	 * @param xtLrrbm
	 *            the xt_lrrbm to set
	 */
	public void setXt_lrrbm(String xtLrrbm) {
		xt_lrrbm = xtLrrbm;
	}

	/**
	 * @return the xt_lrrbmid
	 */
	public String getXt_lrrbmid() {
		return xt_lrrbmid;
	}

	/**
	 * @param xtLrrbmid
	 *            the xt_lrrbmid to set
	 */
	public void setXt_lrrbmid(String xtLrrbmid) {
		xt_lrrbmid = xtLrrbmid;
	}

	/**
	 * @return the xt_lrip
	 */
	public String getXt_lrip() {
		return xt_lrip;
	}

	/**
	 * @param xtLrip
	 *            the xt_lrip to set
	 */
	public void setXt_lrip(String xtLrip) {
		xt_lrip = xtLrip;
	}

	/**
	 * @return the xt_zhxgsj
	 */
	public String getXt_zhxgsj() {
		return xt_zhxgsj;
	}

	/**
	 * @param xtZhxgsj
	 *            the xt_zhxgsj to set
	 */
	public void setXt_zhxgsj(String xtZhxgsj) {
		xt_zhxgsj = xtZhxgsj;
	}

	/**
	 * @return the xt_zhxgrxm
	 */
	public String getXt_zhxgrxm() {
		return xt_zhxgrxm;
	}

	/**
	 * @param xtZhxgrxm
	 *            the xt_zhxgrxm to set
	 */
	public void setXt_zhxgrxm(String xtZhxgrxm) {
		xt_zhxgrxm = xtZhxgrxm;
	}

	/**
	 * @return the xt_zhxgrid
	 */
	public String getXt_zhxgrid() {
		return xt_zhxgrid;
	}

	/**
	 * @param xtZhxgrid
	 *            the xt_zhxgrid to set
	 */
	public void setXt_zhxgrid(String xtZhxgrid) {
		xt_zhxgrid = xtZhxgrid;
	}

	/**
	 * @return the xt_zhxgrbm
	 */
	public String getXt_zhxgrbm() {
		return xt_zhxgrbm;
	}

	/**
	 * @param xtZhxgrbm
	 *            the xt_zhxgrbm to set
	 */
	public void setXt_zhxgrbm(String xtZhxgrbm) {
		xt_zhxgrbm = xtZhxgrbm;
	}

	/**
	 * @return the xt_zhxgrbmid
	 */
	public String getXt_zhxgrbmid() {
		return xt_zhxgrbmid;
	}

	/**
	 * @param xtZhxgrbmid
	 *            the xt_zhxgrbmid to set
	 */
	public void setXt_zhxgrbmid(String xtZhxgrbmid) {
		xt_zhxgrbmid = xtZhxgrbmid;
	}

	/**
	 * @return the xt_zhxgip
	 */
	public String getXt_zhxgip() {
		return xt_zhxgip;
	}

	/**
	 * @param xtZhxgip
	 *            the xt_zhxgip to set
	 */
	public void setXt_zhxgip(String xtZhxgip) {
		xt_zhxgip = xtZhxgip;
	}

	/**
	 * @return the xt_zxbz
	 */
	public String getXt_zxbz() {
		return xt_zxbz;
	}

	/**
	 * @param xtZxbz
	 *            the xt_zxbz to set
	 */
	public void setXt_zxbz(String xtZxbz) {
		xt_zxbz = xtZxbz;
	}

	/**
	 * @return the xt_zxyy
	 */
	public String getXt_zxyy() {
		return xt_zxyy;
	}

	/**
	 * @param xtZxyy
	 *            the xt_zxyy to set
	 */
	public void setXt_zxyy(String xtZxyy) {
		xt_zxyy = xtZxyy;
	}

	public String getCym() {
		return cym;
	}

	public void setCym(String cym) {
		this.cym = cym;
	}

	public String getMzdm() {
		return mzdm;
	}

	public void setMzdm(String mzdm) {
		this.mzdm = mzdm;
	}

	public String getCsrq() {
		return csrq;
	}

	public void setCsrq(String csrq) {
		this.csrq = csrq;
	}

	public String getHjdssxdm() {
		return hjdssxdm;
	}

	public void setHjdssxdm(String hjdssxdm) {
		this.hjdssxdm = hjdssxdm;
	}

	public String getHjdxz() {
		return hjdxz;
	}

	public void setHjdxz(String hjdxz) {
		this.hjdxz = hjdxz;
	}

	public String getXzzssxdm() {
		return xzzssxdm;
	}

	public void setXzzssxdm(String xzzssxdm) {
		this.xzzssxdm = xzzssxdm;
	}

	public String getXzzxz() {
		return xzzxz;
	}

	public void setXzzxz(String xzzxz) {
		this.xzzxz = xzzxz;
	}

	public String getXldm() {
		return xldm;
	}

	public void setXldm(String xldm) {
		this.xldm = xldm;
	}

	public String getByzkdm() {
		return byzkdm;
	}

	public void setByzkdm(String byzkdm) {
		this.byzkdm = byzkdm;
	}

	public String getHyzkdm() {
		return hyzkdm;
	}

	public void setHyzkdm(String hyzkdm) {
		this.hyzkdm = hyzkdm;
	}

	public Long getSg() {
		return sg;
	}

	public void setSg(Long sg) {
		this.sg = sg;
	}

	public String getXxdm() {
		return xxdm;
	}

	public void setXxdm(String xxdm) {
		this.xxdm = xxdm;
	}

	public String getJkzkdm() {
		return jkzkdm;
	}

	public void setJkzkdm(String jkzkdm) {
		this.jkzkdm = jkzkdm;
	}

	public String getZzmmdm() {
		return zzmmdm;
	}

	public void setZzmmdm(String zzmmdm) {
		this.zzmmdm = zzmmdm;
	}

	public String getBmrq() {
		return bmrq;
	}

	public void setBmrq(String bmrq) {
		this.bmrq = bmrq;
	}

	public String getZkzh() {
		return zkzh;
	}

	public void setZkzh(String zkzh) {
		this.zkzh = zkzh;
	}

	public String getKsdd() {
		return ksdd;
	}

	public void setKsdd(String ksdd) {
		this.ksdd = ksdd;
	}

	public String getKssj() {
		return kssj;
	}

	public void setKssj(String kssj) {
		this.kssj = kssj;
	}

	public Long getKscj() {
		return kscj;
	}

	public void setKscj(Long kscj) {
		this.kscj = kscj;
	}

	public String getScgajg() {
		return scgajg;
	}

	public void setScgajg(String scgajg) {
		this.scgajg = scgajg;
	}

	public String getScjg() {
		return scjg;
	}

	public void setScjg(String scjg) {
		this.scjg = scjg;
	}

	public String getScbtgyy() {
		return scbtgyy;
	}

	public void setScbtgyy(String scbtgyy) {
		this.scbtgyy = scbtgyy;
	}

	public String getSzzwaykh() {
		return szzwaykh;
	}

	public void setSzzwaykh(String szzwaykh) {
		this.szzwaykh = szzwaykh;
	}

	public String getZwcjgajg() {
		return zwcjgajg;
	}

	public void setZwcjgajg(String zwcjgajg) {
		this.zwcjgajg = zwcjgajg;
	}

	public String getZwcjrq() {
		return zwcjrq;
	}

	public void setZwcjrq(String zwcjrq) {
		this.zwcjrq = zwcjrq;
	}

	public String getBayzbh() {
		return bayzbh;
	}

	public void setBayzbh(String bayzbh) {
		this.bayzbh = bayzbh;
	}

	public String getFzjg() {
		return fzjg;
	}

	public void setFzjg(String fzjg) {
		this.fzjg = fzjg;
	}

	public String getFzrq() {
		return fzrq;
	}

	public void setFzrq(String fzrq) {
		this.fzrq = fzrq;
	}

	public String getBayzcxyy() {
		return bayzcxyy;
	}

	public void setBayzcxyy(String bayzcxyy) {
		this.bayzcxyy = bayzcxyy;
	}

	public String getBayzcxjdjg() {
		return bayzcxjdjg;
	}

	public void setBayzcxjdjg(String bayzcxjdjg) {
		this.bayzcxjdjg = bayzcxjdjg;
	}

	public String getBayzcxrq() {
		return bayzcxrq;
	}

	public void setBayzcxrq(String bayzcxrq) {
		this.bayzcxrq = bayzcxrq;
	}

	public String getBayzdxyy() {
		return bayzdxyy;
	}

	public void setBayzdxyy(String bayzdxyy) {
		this.bayzdxyy = bayzdxyy;
	}

	public String getBayzdxjdjg() {
		return bayzdxjdjg;
	}

	public void setBayzdxjdjg(String bayzdxjdjg) {
		this.bayzdxjdjg = bayzdxjdjg;
	}

	public String getBayzdxrq() {
		return bayzdxrq;
	}

	public void setBayzdxrq(String bayzdxrq) {
		this.bayzdxrq = bayzdxrq;
	}

	public String getQtzyzgzmc() {
		return qtzyzgzmc;
	}

	public void setQtzyzgzmc(String qtzyzgzmc) {
		this.qtzyzgzmc = qtzyzgzmc;
	}

	public String getQtzyzgzhm() {
		return qtzyzgzhm;
	}

	public void setQtzyzgzhm(String qtzyzgzhm) {
		this.qtzyzgzhm = qtzyzgzhm;
	}

	public String getBayzyjndjdm() {
		return bayzyjndjdm;
	}

	public void setBayzyjndjdm(String bayzyjndjdm) {
		this.bayzyjndjdm = bayzyjndjdm;
	}

	public String getZydjzsbh() {
		return zydjzsbh;
	}

	public void setZydjzsbh(String zydjzsbh) {
		this.zydjzsbh = zydjzsbh;
	}

	public String getQdzydjzssj() {
		return qdzydjzssj;
	}

	public void setQdzydjzssj(String qdzydjzssj) {
		this.qdzydjzssj = qdzydjzssj;
	}

	public String getScgajgid() {
		return scgajgid;
	}

	public void setScgajgid(String scgajgid) {
		this.scgajgid = scgajgid;
	}

	public String getZwcjgajgid() {
		return zwcjgajgid;
	}

	public void setZwcjgajgid(String zwcjgajgid) {
		this.zwcjgajgid = zwcjgajgid;
	}

	public String getFzjgid() {
		return fzjgid;
	}

	public void setFzjgid(String fzjgid) {
		this.fzjgid = fzjgid;
	}

	public String getBayzcxjdjgid() {
		return bayzcxjdjgid;
	}

	public void setBayzcxjdjgid(String bayzcxjdjgid) {
		this.bayzcxjdjgid = bayzcxjdjgid;
	}

	public String getBayzdxjdjgid() {
		return bayzdxjdjgid;
	}

	public void setBayzdxjdjgid(String bayzdxjdjgid) {
		this.bayzdxjdjgid = bayzdxjdjgid;
	}

	public String getSfsxxydm() {
		return sfsxxydm;
	}

	public void setSfsxxydm(String sfsxxydm) {
		this.sfsxxydm = sfsxxydm;
	}

	public String getXxypzgajgid() {
		return xxypzgajgid;
	}

	public void setXxypzgajgid(String xxypzgajgid) {
		this.xxypzgajgid = xxypzgajgid;
	}

	public String getXxypzgajg() {
		return xxypzgajg;
	}

	public void setXxypzgajg(String xxypzgajg) {
		this.xxypzgajg = xxypzgajg;
	}

	public String getXxypzrq() {
		return xxypzrq;
	}

	public void setXxypzrq(String xxypzrq) {
		this.xxypzrq = xxypzrq;
	}
}
