package com.founder.ldym.pojo; 

import java.io.Serializable;

import java.util.Date;


/**
 * <p>标题：设备管理-定位设备信息POJO类</p>
 * <p>描述：对应数据表 T_GPS_INFO</p>
 * <p>Copyright：Copyright(c) 2014 founder</p>
 * <p>日期：2014-07-30</p>
 * @author lee
 */
public class TGpsInfo extends GridPage implements Serializable { 

	/**
	 * TGpsInfo POJO类序列号
	 */
	private static final long serialVersionUID = 1L; 

	/**
	 * G[SID 唯一标识GPS
	 */
	private String gpsid;
	/**
	 * 警种类型
	 */
	private Integer policetypeid;
	/**
	 * GPS接入类型
	 */
	private Integer gpsstyleid;
	/**
	 * 设备分组ID
	 */
	private String orgid;
	/**
	 * 呼叫NO号码
	 */
	private String callno;
	/**
	 * 设备UIM号
	 */
	private String uim;
	/**
	 * 车型
	 */
	private String cartype;
	/**
	 * 车牌号
	 */
	private String carno;
	/**
	 * 警员ID
	 */
	private String policeid;
	/**
	 * 警察名字
	 */
	private String policename;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 定位类型
	 */
	private Integer loctype;
	/**
	 * 信道
	 */
	private String xindao;
	/**
	 * 拥有者
	 */
	private Integer havemonitor;
	/**
	 * 图片名称
	 */
	private String imagename;
	/**
	 * 备注一
	 */
	private String remark1;
	/**
	 * 备注二
	 */
	private String remark2;
	/**
	 * 备注二
	 */
	private String remark3;
	/**
	 * 备注二
	 */
	private String remark4;
	/**
	 * 备注二
	 */
	private String remark5;
	/**
	 * X坐标
	 */
	private Integer x;
	/**
	 * Y坐标
	 */
	private Integer y;
	/**
	 * 实时时间
	 */
	private Date realtime;
	/**
	 * 原有分组ID
	 */
	private String oldorgid;
	/**
	 * 图片类型
	 */
	private String picturetype;
	
	/**
	 * 警种中文名称
	 */
	private String policetypename;

	/**
	 * gps设备类型名称
	 */
	private String gpsstylename;
	
	/**
	 *接入类型名称
	 */
	private String loctypename;
	
	/**
	 * 增加时间
	 */
	private Date addtime;

	/**
	 * 排序
	 */
	private String order;

	/**
	 *分组名称
	 */
	private String orgname;
	/**
	 * SPID
	 */
	private String spid;
	
	/**
	 * gps使用类型（1：警用，2：非警用，需要重点监控的GPS，0：其他）
	 */
	private String gpsusertype;
	
	/**
	 * GPS状态
	 */
	private String status;
	
	/**
	 * 统计变量
	 */
	private String count;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getGpsusertype() {
		return gpsusertype;
	}

	public void setGpsusertype(String gpsusertype) {
		this.gpsusertype = gpsusertype;
	}

	/**
	 * <p>说明：设置G[SID 唯一标识GPS</p>
	 * <p>时间：2014-07-30 上午 10:59:45</p>
	 * @param gpsid G[SID 唯一标识GPS
	 */
	public void setGpsid(String gpsid) {
		this.gpsid = gpsid;
	}

	/**
	 * <p>说明：获取G[SID 唯一标识GPS</p>
	 * <p>时间：2014-07-30 上午 10:59:45</p>
	 * @return G[SID 唯一标识GPS
	 */
	public String getGpsid() {
		return this.gpsid;
	}

	/**
	 * <p>说明：设置警种类型</p>
	 * <p>时间：2014-07-30 上午 10:59:45</p>
	 * @param policetypeid 警种类型
	 */
	public void setPolicetypeid(Integer policetypeid) {
		this.policetypeid = policetypeid;
	}

	/**
	 * <p>说明：获取警种类型</p>
	 * <p>时间：2014-07-30 上午 10:59:45</p>
	 * @return 警种类型
	 */
	public Integer getPolicetypeid() {
		return this.policetypeid;
	}

	/**
	 * <p>说明：设置GPS接入类型</p>
	 * <p>时间：2014-07-30 上午 10:59:45</p>
	 * @param gpsstyleid GPS接入类型
	 */
	public void setGpsstyleid(Integer gpsstyleid) {
		this.gpsstyleid = gpsstyleid;
	}

	/**
	 * <p>说明：获取GPS接入类型</p>
	 * <p>时间：2014-07-30 上午 10:59:45</p>
	 * @return GPS接入类型
	 */
	public Integer getGpsstyleid() {
		return this.gpsstyleid;
	}

	/**
	 * <p>说明：设置设备分组ID</p>
	 * <p>时间：2014-07-30 上午 10:59:45</p>
	 * @param orgid 设备分组ID
	 */
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	/**
	 * <p>说明：获取设备分组ID</p>
	 * <p>时间：2014-07-30 上午 10:59:45</p>
	 * @return 设备分组ID
	 */
	public String getOrgid() {
		return this.orgid;
	}

	/**
	 * <p>说明：设置呼叫NO号码</p>
	 * <p>时间：2014-07-30 上午 10:59:45</p>
	 * @param callno 呼叫NO号码
	 */
	public void setCallno(String callno) {
		this.callno = callno;
	}

	/**
	 * <p>说明：获取呼叫NO号码</p>
	 * <p>时间：2014-07-30 上午 10:59:45</p>
	 * @return 呼叫NO号码
	 */
	public String getCallno() {
		return this.callno;
	}

	/**
	 * <p>说明：设置设备UIM号</p>
	 * <p>时间：2014-07-30 上午 10:59:45</p>
	 * @param uim 设备UIM号
	 */
	public void setUim(String uim) {
		this.uim = uim;
	}

	/**
	 * <p>说明：获取设备UIM号</p>
	 * <p>时间：2014-07-30 上午 10:59:45</p>
	 * @return 设备UIM号
	 */
	public String getUim() {
		return this.uim;
	}

	/**
	 * <p>说明：设置车型</p>
	 * <p>时间：2014-07-30 上午 10:59:45</p>
	 * @param cartype 车型
	 */
	public void setCartype(String cartype) {
		this.cartype = cartype;
	}

	/**
	 * <p>说明：获取车型</p>
	 * <p>时间：2014-07-30 上午 10:59:45</p>
	 * @return 车型
	 */
	public String getCartype() {
		return this.cartype;
	}

	/**
	 * <p>说明：设置车牌号</p>
	 * <p>时间：2014-07-30 上午 10:59:45</p>
	 * @param carno 车牌号
	 */
	public void setCarno(String carno) {
		this.carno = carno;
	}

	/**
	 * <p>说明：获取车牌号</p>
	 * <p>时间：2014-07-30 上午 10:59:45</p>
	 * @return 车牌号
	 */
	public String getCarno() {
		return this.carno;
	}

	/**
	 * <p>说明：设置警员ID</p>
	 * <p>时间：2014-07-30 上午 10:59:45</p>
	 * @param policeid 警员ID
	 */
	public void setPoliceid(String policeid) {
		this.policeid = policeid;
	}

	/**
	 * <p>说明：获取警员ID</p>
	 * <p>时间：2014-07-30 上午 10:59:45</p>
	 * @return 警员ID
	 */
	public String getPoliceid() {
		return this.policeid;
	}

	/**
	 * <p>说明：设置警察名字</p>
	 * <p>时间：2014-07-30 上午 10:59:45</p>
	 * @param policename 警察名字
	 */
	public void setPolicename(String policename) {
		this.policename = policename;
	}

	/**
	 * <p>说明：获取警察名字</p>
	 * <p>时间：2014-07-30 上午 10:59:45</p>
	 * @return 警察名字
	 */
	public String getPolicename() {
		return this.policename;
	}

	/**
	 * <p>说明：设置备注</p>
	 * <p>时间：2014-07-30 上午 10:59:45</p>
	 * @param remark 备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * <p>说明：获取备注</p>
	 * <p>时间：2014-07-30 上午 10:59:45</p>
	 * @return 备注
	 */
	public String getRemark() {
		return this.remark;
	}

	/**
	 * <p>说明：设置定位类型</p>
	 * <p>时间：2014-07-30 上午 10:59:45</p>
	 * @param loctype 定位类型
	 */
	public void setLoctype(Integer loctype) {
		this.loctype = loctype;
	}

	/**
	 * <p>说明：获取定位类型</p>
	 * <p>时间：2014-07-30 上午 10:59:45</p>
	 * @return 定位类型
	 */
	public Integer getLoctype() {
		return this.loctype;
	}

	/**
	 * <p>说明：设置信道</p>
	 * <p>时间：2014-07-30 上午 10:59:45</p>
	 * @param xindao 信道
	 */
	public void setXindao(String xindao) {
		this.xindao = xindao;
	}

	/**
	 * <p>说明：获取信道</p>
	 * <p>时间：2014-07-30 上午 10:59:45</p>
	 * @return 信道
	 */
	public String getXindao() {
		return this.xindao;
	}

	/**
	 * <p>说明：设置拥有者</p>
	 * <p>时间：2014-07-30 上午 10:59:45</p>
	 * @param havemonitor 拥有者
	 */
	public void setHavemonitor(Integer havemonitor) {
		this.havemonitor = havemonitor;
	}

	/**
	 * <p>说明：获取拥有者</p>
	 * <p>时间：2014-07-30 上午 10:59:45</p>
	 * @return 拥有者
	 */
	public Integer getHavemonitor() {
		return this.havemonitor;
	}

	/**
	 * <p>说明：设置图片名称</p>
	 * <p>时间：2014-07-30 上午 10:59:45</p>
	 * @param imagename 图片名称
	 */
	public void setImagename(String imagename) {
		this.imagename = imagename;
	}

	/**
	 * <p>说明：获取图片名称</p>
	 * <p>时间：2014-07-30 上午 10:59:45</p>
	 * @return 图片名称
	 */
	public String getImagename() {
		return this.imagename;
	}

	/**
	 * <p>说明：设置备注一</p>
	 * <p>时间：2014-07-30 上午 10:59:45</p>
	 * @param remark1 备注一
	 */
	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

	/**
	 * <p>说明：获取备注一</p>
	 * <p>时间：2014-07-30 上午 10:59:45</p>
	 * @return 备注一
	 */
	public String getRemark1() {
		return this.remark1;
	}

	/**
	 * <p>说明：设置备注二</p>
	 * <p>时间：2014-07-30 上午 10:59:45</p>
	 * @param remark2 备注二
	 */
	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

	/**
	 * <p>说明：获取备注二</p>
	 * <p>时间：2014-07-30 上午 10:59:45</p>
	 * @return 备注二
	 */
	public String getRemark2() {
		return this.remark2;
	}

	/**
	 * <p>说明：设置备注二</p>
	 * <p>时间：2014-07-30 上午 10:59:45</p>
	 * @param remark3 备注二
	 */
	public void setRemark3(String remark3) {
		this.remark3 = remark3;
	}

	/**
	 * <p>说明：获取备注二</p>
	 * <p>时间：2014-07-30 上午 10:59:45</p>
	 * @return 备注二
	 */
	public String getRemark3() {
		return this.remark3;
	}

	/**
	 * <p>说明：设置备注二</p>
	 * <p>时间：2014-07-30 上午 10:59:45</p>
	 * @param remark4 备注二
	 */
	public void setRemark4(String remark4) {
		this.remark4 = remark4;
	}

	/**
	 * <p>说明：获取备注二</p>
	 * <p>时间：2014-07-30 上午 10:59:45</p>
	 * @return 备注二
	 */
	public String getRemark4() {
		return this.remark4;
	}

	/**
	 * <p>说明：设置备注二</p>
	 * <p>时间：2014-07-30 上午 10:59:45</p>
	 * @param remark5 备注二
	 */
	public void setRemark5(String remark5) {
		this.remark5 = remark5;
	}

	/**
	 * <p>说明：获取备注二</p>
	 * <p>时间：2014-07-30 上午 10:59:45</p>
	 * @return 备注二
	 */
	public String getRemark5() {
		return this.remark5;
	}

	/**
	 * <p>说明：设置X坐标</p>
	 * <p>时间：2014-07-30 上午 10:59:45</p>
	 * @param x X坐标
	 */
	public void setX(Integer x) {
		this.x = x;
	}

	/**
	 * <p>说明：获取X坐标</p>
	 * <p>时间：2014-07-30 上午 10:59:45</p>
	 * @return X坐标
	 */
	public Integer getX() {
		return this.x;
	}

	/**
	 * <p>说明：设置Y坐标</p>
	 * <p>时间：2014-07-30 上午 10:59:45</p>
	 * @param y Y坐标
	 */
	public void setY(Integer y) {
		this.y = y;
	}

	/**
	 * <p>说明：获取Y坐标</p>
	 * <p>时间：2014-07-30 上午 10:59:45</p>
	 * @return Y坐标
	 */
	public Integer getY() {
		return this.y;
	}

	/**
	 * <p>说明：设置实时时间</p>
	 * <p>时间：2014-07-30 上午 10:59:45</p>
	 * @param realtime 实时时间
	 */
	public void setRealtime(Date realtime) {
		this.realtime = realtime;
	}

	/**
	 * <p>说明：获取实时时间</p>
	 * <p>时间：2014-07-30 上午 10:59:45</p>
	 * @return 实时时间
	 */
	public Date getRealtime() {
		return this.realtime;
	}

	/**
	 * <p>说明：设置原有分组ID</p>
	 * <p>时间：2014-07-30 上午 10:59:45</p>
	 * @param oldorgid 原有分组ID
	 */
	public void setOldorgid(String oldorgid) {
		this.oldorgid = oldorgid;
	}

	/**
	 * <p>说明：获取原有分组ID</p>
	 * <p>时间：2014-07-30 上午 10:59:45</p>
	 * @return 原有分组ID
	 */
	public String getOldorgid() {
		return this.oldorgid;
	}

	/**
	 * <p>说明：设置图片类型</p>
	 * <p>时间：2014-07-30 上午 10:59:45</p>
	 * @param picturetype 图片类型
	 */
	public void setPicturetype(String picturetype) {
		this.picturetype = picturetype;
	}

	/**
	 * <p>说明：获取图片类型</p>
	 * <p>时间：2014-07-30 上午 10:59:45</p>
	 * @return 图片类型
	 */
	public String getPicturetype() {
		return this.picturetype;
	}

	/**
	 * <p>说明：设置SPID</p>
	 * <p>时间：2014-07-30 上午 10:59:45</p>
	 * @param spid SPID
	 */
	public void setSpid(String spid) {
		this.spid = spid;
	}

	/**
	 * <p>说明：获取SPID</p>
	 * <p>时间：2014-07-30 上午 10:59:45</p>
	 * @return SPID
	 */
	public String getSpid() {
		return this.spid;
	}
	
	
	public String getPolicetypename() {
		return policetypename;
	}

	public void setPolicetypename(String policetypename) {
		this.policetypename = policetypename;
	}

	public String getGpsstylename() {
		return gpsstylename;
	}

	public void setGpsstylename(String gpsstylename) {
		this.gpsstylename = gpsstylename;
	}

	public String getLoctypename() {
		return loctypename;
	}

	public void setLoctypename(String loctypename) {
		this.loctypename = loctypename;
	}
	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}
	
	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}
	
	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}
}