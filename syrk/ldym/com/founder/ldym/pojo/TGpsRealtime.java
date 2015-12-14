package com.founder.ldym.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * <p>标题：gps信息</p>
 * <p>描述：gps信息</p>
 * <p>Copyright：Copyright(c) 2014 founder</p>
 * <p>日期：2014-3-14</p>
 * @author	yangyongfei
 */
public class TGpsRealtime implements Serializable{
	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * gps实时信息id
	 */
	private String gpsId;
	
	/**
	 * gps实时信息，x坐标
	 */
	private float x;
	
	/**
	 * gps实时信息，y坐标
	 */
	private float y;
	
	/**
	 * gps实时信息，实时时间
	 */
	private Date realtime;
	
	/**
	 * gps实时信息，
	 */
	private float dir;
	
	/**
	 * gps实时信息,设备速度
	 */
	private float speed;
	
	/**
	 * gps实时信息，备注信息
	 */
	private String reamark;
	
	/**
	 * 分组ID
	 */
	private String groupid;
	
	/**
	 * 分组名
	 */
	private String groupname;
	
	/**
	 * 警员ID
	 */
	private String policeid;
	
	/**
	 * 警员姓名
	 */
	private String policename;
	
	/**
	 * 车牌号
	 */
	private String carno;
	
	/**
	 * 呼号
	 */
	private String callno;
	
	/**
	 * 类型
	 */
	private String picturetype;
	
	/**
	 * 状态ID
	 */
	private String statusid;
	
	/**
	 * 警力当前状态对应的业务编号，多个使用逗号分隔
	 */
    private String ywbh;


	public TGpsRealtime() {
		super();
	}

	public TGpsRealtime(String gpsId, float x, float y, Date realtime,
			float dir, float speed, String reamark, String groupid,
			String groupname, String policeid, String policename, String carno,
			String callno, String picturetype, String statusid, String ywbh) {
		super();
		this.gpsId = gpsId;
		this.x = x;
		this.y = y;
		this.realtime = realtime;
		this.dir = dir;
		this.speed = speed;
		this.reamark = reamark;
		this.groupid = groupid;
		this.groupname = groupname;
		this.policeid = policeid;
		this.policename = policename;
		this.carno = carno;
		this.callno = callno;
		this.picturetype = picturetype;
		this.statusid = statusid;
		this.ywbh = ywbh;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getGpsId() {
		return gpsId;
	}

	public void setGpsId(String gpsId) {
		this.gpsId = gpsId;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public Date getRealtime() {
		return realtime;
	}

	public void setRealtime(Date realtime) {
		this.realtime = realtime;
	}

	public float getDir() {
		return dir;
	}

	public void setDir(float dir) {
		this.dir = dir;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public String getReamark() {
		return reamark;
	}

	public void setReamark(String reamark) {
		this.reamark = reamark;
	}

	public String getGroupid() {
		return groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}

	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public String getPoliceid() {
		return policeid;
	}

	public void setPoliceid(String policeid) {
		this.policeid = policeid;
	}

	public String getPolicename() {
		return policename;
	}

	public void setPolicename(String policename) {
		this.policename = policename;
	}

	public String getCarno() {
		return carno;
	}

	public void setCarno(String carno) {
		this.carno = carno;
	}

	public String getCallno() {
		return callno;
	}

	public void setCallno(String callno) {
		this.callno = callno;
	}

	public String getPicturetype() {
		return picturetype;
	}

	public void setPicturetype(String picturetype) {
		this.picturetype = picturetype;
	}

	public String getStatusid() {
		return statusid;
	}

	public void setStatusid(String statusid) {
		this.statusid = statusid;
	}

	public String getYwbh() {
		return ywbh;
	}

	public void setYwbh(String ywbh) {
		this.ywbh = ywbh;
	}
	
}
