/**********************************************************************   
 * <p>文件名：Dwxyaqxxb.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author wu_chunhui@founder.com.cn 
 * @date 2014-12-4 下午02:20:39 
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
 * @Package: [com.founder.sydw.bean.Dwxyaqxxb.java]
 * @ClassName: [Dwxyaqxxb]
 * @Description: [一句话描述该类的功能]
 * @Author: [wu_chunhui@founder.com.cn]
 * @CreateDate: [2014-12-4 下午02:20:39]
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2014-12-4 下午02:20:39，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@DBInfoAnnotation(tableName = "DW_XYAQXXB", pk = "id")
public class Dwxyaqxxb extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@FieldDesc("校园ID")
	private String id;
	@FieldDesc("单位ID")
	private String dwid;
	@FieldDesc("校门数量")
	private Long xmsl;
	@FieldDesc("办公电话")
	private String bbdh;
	@FieldDesc("学校安保负责人证件种类")
	private String xxabfzrzjlx;
	@FieldDesc("学校安保负责人证件号码")
	private String xxabfzrzjhm;
	@FieldDesc("学校安保负责人姓名")
	private String xxabfzrxm;
	@FieldDesc("学校安保负责人电话")
	private String xxabfzrdh;
	@FieldDesc("法制副校长证件种类")
	private String fzfxzzjlx;
	@FieldDesc("法制副校长证件号码")
	private String fzfxzzjhm;
	@FieldDesc("法制副校长姓名")
	private String fzfxzxm;
	@FieldDesc("法制副校长电话")
	private String fzfxzdh;
	@FieldDesc("校园警务室民警姓名")
	private String xyjwsmjxm;
	@FieldDesc("校园警务室民警电话")
	private String xyjwsmjdh;
	@FieldDesc("学校人数")
	private Long xxrs;
	@FieldDesc("校车接送学生数量")
	private Long xcjsxssl;
	@FieldDesc("学校类别代码")
	private String xxlbdm;
	@FieldDesc("学校隶属关系代码")
	private String xxlsgxdm;
	@FieldDesc("有无许可代码")
	private String ywxkdm;
	@FieldDesc("宿舍情况")
	private String ssqk;
	@FieldDesc("安全等级")
	private String aqdj;
	@FieldDesc("是否签订安全责任状代码")
	private String sfqdaqzrzdm;
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
	 * @return the dwid
	 */
	public String getDwid() {
		return dwid;
	}

	/**
	 * @param dwid
	 *            the dwid to set
	 */
	public void setDwid(String dwid) {
		this.dwid = dwid;
	}

	/**
	 * @return the xmsl
	 */
	public Long getXmsl() {
		return xmsl;
	}

	/**
	 * @param xmsl
	 *            the xmsl to set
	 */
	public void setXmsl(Long xmsl) {
		this.xmsl = xmsl;
	}

	/**
	 * @return the bbdh
	 */
	public String getBbdh() {
		return bbdh;
	}

	/**
	 * @param bbdh
	 *            the bbdh to set
	 */
	public void setBbdh(String bbdh) {
		this.bbdh = bbdh;
	}

	/**
	 * @return the xxabfzrzjlx
	 */
	public String getXxabfzrzjlx() {
		return xxabfzrzjlx;
	}

	/**
	 * @param xxabfzrzjlx
	 *            the xxabfzrzjlx to set
	 */
	public void setXxabfzrzjlx(String xxabfzrzjlx) {
		this.xxabfzrzjlx = xxabfzrzjlx;
	}

	/**
	 * @return the xxabfzrzjhm
	 */
	public String getXxabfzrzjhm() {
		return xxabfzrzjhm;
	}

	/**
	 * @param xxabfzrzjhm
	 *            the xxabfzrzjhm to set
	 */
	public void setXxabfzrzjhm(String xxabfzrzjhm) {
		this.xxabfzrzjhm = xxabfzrzjhm;
	}

	/**
	 * @return the xxabfzrxm
	 */
	public String getXxabfzrxm() {
		return xxabfzrxm;
	}

	/**
	 * @param xxabfzrxm
	 *            the xxabfzrxm to set
	 */
	public void setXxabfzrxm(String xxabfzrxm) {
		this.xxabfzrxm = xxabfzrxm;
	}

	/**
	 * @return the xxabfzrdh
	 */
	public String getXxabfzrdh() {
		return xxabfzrdh;
	}

	/**
	 * @param xxabfzrdh
	 *            the xxabfzrdh to set
	 */
	public void setXxabfzrdh(String xxabfzrdh) {
		this.xxabfzrdh = xxabfzrdh;
	}

	/**
	 * @return the fzfxzzjlx
	 */
	public String getFzfxzzjlx() {
		return fzfxzzjlx;
	}

	/**
	 * @param fzfxzzjlx
	 *            the fzfxzzjlx to set
	 */
	public void setFzfxzzjlx(String fzfxzzjlx) {
		this.fzfxzzjlx = fzfxzzjlx;
	}

	/**
	 * @return the fzfxzzjhm
	 */
	public String getFzfxzzjhm() {
		return fzfxzzjhm;
	}

	/**
	 * @param fzfxzzjhm
	 *            the fzfxzzjhm to set
	 */
	public void setFzfxzzjhm(String fzfxzzjhm) {
		this.fzfxzzjhm = fzfxzzjhm;
	}

	/**
	 * @return the fzfxzxm
	 */
	public String getFzfxzxm() {
		return fzfxzxm;
	}

	/**
	 * @param fzfxzxm
	 *            the fzfxzxm to set
	 */
	public void setFzfxzxm(String fzfxzxm) {
		this.fzfxzxm = fzfxzxm;
	}

	/**
	 * @return the fzfxzdh
	 */
	public String getFzfxzdh() {
		return fzfxzdh;
	}

	/**
	 * @param fzfxzdh
	 *            the fzfxzdh to set
	 */
	public void setFzfxzdh(String fzfxzdh) {
		this.fzfxzdh = fzfxzdh;
	}

	/**
	 * @return the xyjwsmjxm
	 */
	public String getXyjwsmjxm() {
		return xyjwsmjxm;
	}

	/**
	 * @param xyjwsmjxm
	 *            the xyjwsmjxm to set
	 */
	public void setXyjwsmjxm(String xyjwsmjxm) {
		this.xyjwsmjxm = xyjwsmjxm;
	}

	/**
	 * @return the xyjwsmjdh
	 */
	public String getXyjwsmjdh() {
		return xyjwsmjdh;
	}

	/**
	 * @param xyjwsmjdh
	 *            the xyjwsmjdh to set
	 */
	public void setXyjwsmjdh(String xyjwsmjdh) {
		this.xyjwsmjdh = xyjwsmjdh;
	}

	/**
	 * @return the xxrs
	 */
	public Long getXxrs() {
		return xxrs;
	}

	/**
	 * @param xxrs
	 *            the xxrs to set
	 */
	public void setXxrs(Long xxrs) {
		this.xxrs = xxrs;
	}

	/**
	 * @return the xcjsxssl
	 */
	public Long getXcjsxssl() {
		return xcjsxssl;
	}

	/**
	 * @param xcjsxssl
	 *            the xcjsxssl to set
	 */
	public void setXcjsxssl(Long xcjsxssl) {
		this.xcjsxssl = xcjsxssl;
	}

	/**
	 * @return the xxlbdm
	 */
	public String getXxlbdm() {
		return xxlbdm;
	}

	/**
	 * @param xxlbdm
	 *            the xxlbdm to set
	 */
	public void setXxlbdm(String xxlbdm) {
		this.xxlbdm = xxlbdm;
	}

	/**
	 * @return the xxlsgxdm
	 */
	public String getXxlsgxdm() {
		return xxlsgxdm;
	}

	/**
	 * @param xxlsgxdm
	 *            the xxlsgxdm to set
	 */
	public void setXxlsgxdm(String xxlsgxdm) {
		this.xxlsgxdm = xxlsgxdm;
	}

	/**
	 * @return the ywxkdm
	 */
	public String getYwxkdm() {
		return ywxkdm;
	}

	/**
	 * @param ywxkdm
	 *            the ywxkdm to set
	 */
	public void setYwxkdm(String ywxkdm) {
		this.ywxkdm = ywxkdm;
	}

	/**
	 * @return the ssqk
	 */
	public String getSsqk() {
		return ssqk;
	}

	/**
	 * @param ssqk
	 *            the ssqk to set
	 */
	public void setSsqk(String ssqk) {
		this.ssqk = ssqk;
	}

	/**
	 * @return the aqdj
	 */
	public String getAqdj() {
		return aqdj;
	}

	/**
	 * @param aqdj
	 *            the aqdj to set
	 */
	public void setAqdj(String aqdj) {
		this.aqdj = aqdj;
	}

	/**
	 * @return the sfqdaqzrzdm
	 */
	public String getSfqdaqzrzdm() {
		return sfqdaqzrzdm;
	}

	/**
	 * @param sfqdaqzrzdm
	 *            the sfqdaqzrzdm to set
	 */
	public void setSfqdaqzrzdm(String sfqdaqzrzdm) {
		this.sfqdaqzrzdm = sfqdaqzrzdm;
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

}
