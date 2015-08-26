package com.founder.bzdz.vo;
import java.io.Serializable;
import com.founder.framework.base.entity.BaseEntity;
/**
 * @类名: BzdzxxbVO
 * @描述: 标准地址VO
 * @作者: zhang_guoliang@founder.com
 * @日期: 2014-12-25 下午2:42:20
 */
public class BzdzxxbVO extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 6458346650098524819L;
	//门楼地址对象表
	private String mldzid;
	private String xzqhdm;
	private String xzqhmc;
	private String dmdm;
	private String dmmc;
	private String olddmmc;
	private String sqdm;
	private String sqmc;
	private String zrqdm;
	private String zrqmc;
	private String pcsdm;
	private String pcsmc;
	private String fxjdm;
	private String fxjmc;
	private String mlphqz;
	private String mlphqzmc;
	private String mlph;
	private String mlphhz;
	private String mlphhzmc;
	private String mlphqc;
	private String dzmc;
	private String dzmcpy;
	private String dzmcpwd;
	private String dzmcpypwd;
	private String zbx;
	private String zby;
	private String bz;
	private String dzzt;
	private String dzbm;
	private String dtcwfk;
	//门楼地址审核表
	private String shrxm;
	private String shrid;
	private String shsj;
	private String shdwmc;
	private String shdwdm;
	private String shztdm;
	private String shbhgyy;
	//门楼地址别名表
	private String dzbmid;
	private String bmly;
	private BzdzxxbVO[] dzBmArray;
	//建筑物信息表
	private String jzwid;
	//地上单元信息
	private String dsdys;
	private String dszdcs;
	private String dszdhs;
	private String dsdyjbxx[];
	private String dslcjbxx[];
	private String dsfjjbxx[];
	//地下单元信息
	private String dxdys;
	private String dxzdcs;
	private String dxzdhs;
	private String dxdyjbxx[];
	private String dxlcjbxx[];
	private String dxfjjbxx[];
	//建筑物关联表
	private String glid;
	//层户地址对象表
	private String chdzid;
	private String dyh;
	private String dyhlx;
	private String lch;
	private String sh;
	private String shmc;
	private String shbs;
	private String dzjb;
	private String chdzmc;
	private String chdzmcpy;
	private String chdzmcpwd;
	private String chdzmcpypwd;
	//层户地址维护
	private String newdyh;
	private String newlcs;
	private String newhs;//新的户数
	private String newsh;//新的室号
	//建筑物层户结构表
	private String jzwchid;
	private String zdlcs;
	private String zdhs;
	private String dydzbs;
	//边界坐标值
	private String bjzbz;
    //地址日志表
	private String rzid;
	private String dzChb;
	//查询组织机构
	private String zzjgdm;
	private String zzjgmc;
	public String getZzjgdm() {
		return zzjgdm;
	}
	public void setZzjgdm(String zzjgdm) {
		this.zzjgdm = zzjgdm;
	}
	public String getZzjgmc() {
		return zzjgmc;
	}
	public void setZzjgmc(String zzjgmc) {
		this.zzjgmc = zzjgmc;
	}
	public String getOlddmmc() {
		return olddmmc;
	}
	public void setOlddmmc(String olddmmc) {
		this.olddmmc = olddmmc;
	}
	public String getDzChb() {
		return dzChb;
	}
	public void setDzChb(String dzChb) {
		this.dzChb = dzChb;
	}
	public String getNewsh() {
		return newsh;
	}
	public void setNewsh(String newsh) {
		this.newsh = newsh;
	}
	public String getNewhs() {
		return newhs;
	}
	public void setNewhs(String newhs) {
		this.newhs = newhs;
	}
	public String getNewlcs() {
		return newlcs;
	}
	public void setNewlcs(String newlcs) {
		this.newlcs = newlcs;
	}
	public String getNewdyh() {
		return newdyh;
	}
	public void setNewdyh(String newdyh) {
		this.newdyh = newdyh;
	}
	public String getRzid() {
		return rzid;
	}
	public void setRzid(String rzid) {
		this.rzid = rzid;
	}
	public String getBjzbz() {
		return bjzbz;
	}
	public void setBjzbz(String bjzbz) {
		this.bjzbz = bjzbz;
	}
	public String getSqmc() {
		return sqmc;
	}
	public void setSqmc(String sqmc) {
		this.sqmc = sqmc;
	}
	public String getZrqmc() {
		return zrqmc;
	}
	public void setZrqmc(String zrqmc) {
		this.zrqmc = zrqmc;
	}
	public String getPcsmc() {
		return pcsmc;
	}
	public void setPcsmc(String pcsmc) {
		this.pcsmc = pcsmc;
	}
	public String getFxjmc() {
		return fxjmc;
	}
	public void setFxjmc(String fxjmc) {
		this.fxjmc = fxjmc;
	}
	public String[] getDxdyjbxx() {
		return dxdyjbxx;
	}
	public void setDxdyjbxx(String[] dxdyjbxx) {
		this.dxdyjbxx = dxdyjbxx;
	}
	public String[] getDxlcjbxx() {
		return dxlcjbxx;
	}
	public void setDxlcjbxx(String[] dxlcjbxx) {
		this.dxlcjbxx = dxlcjbxx;
	}
	public String[] getDxfjjbxx() {
		return dxfjjbxx;
	}
	public void setDxfjjbxx(String[] dxfjjbxx) {
		this.dxfjjbxx = dxfjjbxx;
	}
	public String getJzwchid() {
		return jzwchid;
	}
	public void setJzwchid(String jzwchid) {
		this.jzwchid = jzwchid;
	}
	public String getZdlcs() {
		return zdlcs;
	}
	public void setZdlcs(String zdlcs) {
		this.zdlcs = zdlcs;
	}
	public String getZdhs() {
		return zdhs;
	}
	public void setZdhs(String zdhs) {
		this.zdhs = zdhs;
	}
	public String getDydzbs() {
		return dydzbs;
	}
	public void setDydzbs(String dydzbs) {
		this.dydzbs = dydzbs;
	}
	public String getChdzmc() {
		return chdzmc;
	}
	public void setChdzmc(String chdzmc) {
		this.chdzmc = chdzmc;
	}
	public String getChdzmcpy() {
		return chdzmcpy;
	}
	public void setChdzmcpy(String chdzmcpy) {
		this.chdzmcpy = chdzmcpy;
	}
	public String getChdzmcpwd() {
		return chdzmcpwd;
	}
	public void setChdzmcpwd(String chdzmcpwd) {
		this.chdzmcpwd = chdzmcpwd;
	}
	public String getChdzmcpypwd() {
		return chdzmcpypwd;
	}
	public void setChdzmcpypwd(String chdzmcpypwd) {
		this.chdzmcpypwd = chdzmcpypwd;
	}
	public String getMldzid() {
		return mldzid;
	}
	public void setMldzid(String mldzid) {
		this.mldzid = mldzid;
	}
	public String getXzqhdm() {
		return xzqhdm;
	}
	public void setXzqhdm(String xzqhdm) {
		this.xzqhdm = xzqhdm;
	}
	public String getXzqhmc() {
		return xzqhmc;
	}
	public void setXzqhmc(String xzqhmc) {
		this.xzqhmc = xzqhmc;
	}
	public String getDmdm() {
		return dmdm;
	}
	public void setDmdm(String dmdm) {
		this.dmdm = dmdm;
	}
	public String getDmmc() {
		return dmmc;
	}
	public void setDmmc(String dmmc) {
		this.dmmc = dmmc;
	}
	public String getSqdm() {
		return sqdm;
	}
	public void setSqdm(String sqdm) {
		this.sqdm = sqdm;
	}
	public String getZrqdm() {
		return zrqdm;
	}
	public void setZrqdm(String zrqdm) {
		this.zrqdm = zrqdm;
	}
	public String getPcsdm() {
		return pcsdm;
	}
	public void setPcsdm(String pcsdm) {
		this.pcsdm = pcsdm;
	}
	public String getFxjdm() {
		return fxjdm;
	}
	public void setFxjdm(String fxjdm) {
		this.fxjdm = fxjdm;
	}
	public String getMlphqz() {
		if(mlphqz == null){
			mlphqz = "";
		}
		return mlphqz;
	}
	public void setMlphqz(String mlphqz) {
		if(mlphqz == null){
			mlphqz = "";
		}
		this.mlphqz = mlphqz;
	}
	public String getMlphqzmc() {
		if(mlphqzmc == null){
			mlphqzmc = "";
		}
		return mlphqzmc;
	}
	public void setMlphqzmc(String mlphqzmc) {
		if(mlphqzmc == null){
			mlphqzmc = "";
		}
		this.mlphqzmc = mlphqzmc;
	}
	public String getMlph() {
		return mlph;
	}
	public void setMlph(String mlph) {
		this.mlph = mlph;
	}
	public String getMlphhz() {
		return mlphhz;
	}
	public void setMlphhz(String mlphhz) {
		this.mlphhz = mlphhz;
	}
	public String getMlphhzmc() {
		return mlphhzmc;
	}
	public void setMlphhzmc(String mlphhzmc) {
		this.mlphhzmc = mlphhzmc;
	}
	public String getMlphqc() {
		return mlphqc;
	}
	public void setMlphqc(String mlphqc) {
		this.mlphqc = mlphqc;
	}
	public String getDzmc() {
		//全文检索需将字母转为大写
		if(dzmc!=null&&!"".equals(dzmc)){
			dzmc = dzmc.toUpperCase();
		}
		return dzmc;
	}
	public void setDzmc(String dzmc) {
		//全文检索需将字母转为大写
		if(dzmc!=null&&!"".equals(dzmc)){
			dzmc = dzmc.toUpperCase();
		}
		this.dzmc = dzmc;
	}
	public String getDzmcpy() {
		return dzmcpy;
	}
	public void setDzmcpy(String dzmcpy) {
		this.dzmcpy = dzmcpy;
	}
	public String getDzmcpwd() {
		return dzmcpwd;
	}
	public void setDzmcpwd(String dzmcpwd) {
		this.dzmcpwd = dzmcpwd;
	}
	public String getDzmcpypwd() {
		return dzmcpypwd;
	}
	public void setDzmcpypwd(String dzmcpypwd) {
		this.dzmcpypwd = dzmcpypwd;
	}
	public String getZbx() {
		return zbx;
	}
	public void setZbx(String zbx) {
		this.zbx = zbx;
	}
	public String getZby() {
		return zby;
	}
	public void setZby(String zby) {
		this.zby = zby;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getDzzt() {
		return dzzt;
	}
	public void setDzzt(String dzzt) {
		this.dzzt = dzzt;
	}
	public String getDzbm() {
		return dzbm;
	}
	public void setDzbm(String dzbm) {
		this.dzbm = dzbm;
	}
	public String getDtcwfk() {
		return dtcwfk;
	}
	public void setDtcwfk(String dtcwfk) {
		this.dtcwfk = dtcwfk;
	}
	public String getShrxm() {
		return shrxm;
	}
	public void setShrxm(String shrxm) {
		this.shrxm = shrxm;
	}
	public String getShrid() {
		return shrid;
	}
	public void setShrid(String shrid) {
		this.shrid = shrid;
	}
	public String getShsj() {
		return shsj;
	}
	public void setShsj(String shsj) {
		this.shsj = shsj;
	}
	public String getShdwmc() {
		return shdwmc;
	}
	public void setShdwmc(String shdwmc) {
		this.shdwmc = shdwmc;
	}
	public String getShdwdm() {
		return shdwdm;
	}
	public void setShdwdm(String shdwdm) {
		this.shdwdm = shdwdm;
	}
	public String getShztdm() {
		return shztdm;
	}
	public void setShztdm(String shztdm) {
		this.shztdm = shztdm;
	}
	public String getShbhgyy() {
		return shbhgyy;
	}
	public void setShbhgyy(String shbhgyy) {
		this.shbhgyy = shbhgyy;
	}
	public String getDzbmid() {
		return dzbmid;
	}
	public void setDzbmid(String dzbmid) {
		this.dzbmid = dzbmid;
	}
	public String getBmly() {
		return bmly;
	}
	public void setBmly(String bmly) {
		this.bmly = bmly;
	}
	public BzdzxxbVO[] getDzBmArray() {
		return dzBmArray;
	}
	public void setDzBmArray(BzdzxxbVO[] dzBmArray) {
		this.dzBmArray = dzBmArray;
	}
	public String getJzwid() {
		return jzwid;
	}
	public void setJzwid(String jzwid) {
		this.jzwid = jzwid;
	}
	public String getDsdys() {
		return dsdys;
	}
	public void setDsdys(String dsdys) {
		this.dsdys = dsdys;
	}
	public String getDszdcs() {
		return dszdcs;
	}
	public void setDszdcs(String dszdcs) {
		this.dszdcs = dszdcs;
	}
	public String getDszdhs() {
		return dszdhs;
	}
	public void setDszdhs(String dszdhs) {
		this.dszdhs = dszdhs;
	}
	public String[] getDsdyjbxx() {
		return dsdyjbxx;
	}
	public void setDsdyjbxx(String[] dsdyjbxx) {
		this.dsdyjbxx = dsdyjbxx;
	}
	public String[] getDslcjbxx() {
		return dslcjbxx;
	}
	public void setDslcjbxx(String[] dslcjbxx) {
		this.dslcjbxx = dslcjbxx;
	}
	public String[] getDsfjjbxx() {
		return dsfjjbxx;
	}
	public void setDsfjjbxx(String[] dsfjjbxx) {
		this.dsfjjbxx = dsfjjbxx;
	}
	public String getDxdys() {
		return dxdys;
	}
	public void setDxdys(String dxdys) {
		this.dxdys = dxdys;
	}
	public String getDxzdcs() {
		return dxzdcs;
	}
	public void setDxzdcs(String dxzdcs) {
		this.dxzdcs = dxzdcs;
	}
	public String getDxzdhs() {
		return dxzdhs;
	}
	public void setDxzdhs(String dxzdhs) {
		this.dxzdhs = dxzdhs;
	}
	public String getGlid() {
		return glid;
	}
	public void setGlid(String glid) {
		this.glid = glid;
	}
	public String getChdzid() {
		return chdzid;
	}
	public void setChdzid(String chdzid) {
		this.chdzid = chdzid;
	}
	public String getDyh() {
		return dyh;
	}
	public void setDyh(String dyh) {
		this.dyh = dyh;
	}
	public String getDyhlx() {
		return dyhlx;
	}
	public void setDyhlx(String dyhlx) {
		this.dyhlx = dyhlx;
	}
	public String getLch() {
		return lch;
	}
	public void setLch(String lch) {
		this.lch = lch;
	}
	public String getSh() {
		return sh;
	}
	public void setSh(String sh) {
		this.sh = sh;
	}
	public String getShmc() {
		return shmc;
	}
	public void setShmc(String shmc) {
		this.shmc = shmc;
	}
	public String getShbs() {
		return shbs;
	}
	public void setShbs(String shbs) {
		this.shbs = shbs;
	}
	public String getDzjb() {
		return dzjb;
	}
	public void setDzjb(String dzjb) {
		this.dzjb = dzjb;
	}
}