package com.founder.ldym.pojo; 


import java.io.Serializable;
import java.util.Date;

/**
 * <p>标题：警力历史轨迹POJO类</p>
 * <p>描述：对应数据表 GA_GPS_HISTORY</p>
 * <p>Copyright：Copyright(c) 2014 founder</p>
 * <p>日期：2014-04-01</p>
 * @author pan_xiaoming
 */
public class TZhddSsjlLsgj implements Serializable { 

	/**
	 * GaGpsHistory20140401 POJO类序列号
	 */
	private static final long serialVersionUID = 1L; 

	/**
	 * 移动id
	 */
	private String mobileid;
	/**
	 * GPS编号
	 */
	private String gpsid;
	/**
	 * X坐标
	 */
	private Float x;
	/**
	 * Y坐标
	 */
	private Float y;
	/**
	 * 时间
	 */
	private Date time;
	/**
	 * 速度
	 */
	private Float speed;
	/**
	 * 方向
	 */
	private Float dir;
	/**
	 * 备注
	 */
	private String remark;


	/**
	 * <p>说明：设置手机id</p>
	 * <p>时间：2014-04-01 下午 17:40:39</p>
	 * @param mobileid 手机id
	 */
	public void setMobileid(String mobileid) {
		this.mobileid = mobileid;
	}

	/**
	 * <p>说明：获取手机id</p>
	 * <p>时间：2014-04-01 下午 17:40:39</p>
	 * @return 手机id
	 */
	public String getMobileid() {
		return this.mobileid;
	}

	/**
	 * <p>说明：设置GPS编号</p>
	 * <p>时间：2014-04-01 下午 17:40:39</p>
	 * @param gpsid GPS编号
	 */
	public void setGpsid(String gpsid) {
		this.gpsid = gpsid;
	}

	/**
	 * <p>说明：获取GPS编号</p>
	 * <p>时间：2014-04-01 下午 17:40:39</p>
	 * @return GPS编号
	 */
	public String getGpsid() {
		return this.gpsid;
	}

	/**
	 * <p>说明：设置X坐标</p>
	 * <p>时间：2014-04-01 下午 17:40:39</p>
	 * @param x X坐标
	 */
	public void setX(Float x) {
		this.x = x;
	}

	/**
	 * <p>说明：获取X坐标</p>
	 * <p>时间：2014-04-01 下午 17:40:39</p>
	 * @return X坐标
	 */
	public Float getX() {
		return this.x;
	}

	/**
	 * <p>说明：设置Y坐标</p>
	 * <p>时间：2014-04-01 下午 17:40:39</p>
	 * @param y Y坐标
	 */
	public void setY(Float y) {
		this.y = y;
	}

	/**
	 * <p>说明：获取Y坐标</p>
	 * <p>时间：2014-04-01 下午 17:40:39</p>
	 * @return Y坐标
	 */
	public Float getY() {
		return this.y;
	}

	/**
	 * <p>说明：设置时间</p>
	 * <p>时间：2014-04-01 下午 17:40:39</p>
	 * @param time 时间
	 */
	public void setTime(Date time) {
		this.time = time;
	}

	/**
	 * <p>说明：获取时间</p>
	 * <p>时间：2014-04-01 下午 17:40:39</p>
	 * @return 时间
	 */
	public Date getTime() {
		return this.time;
	}

	/**
	 * <p>说明：设置速度</p>
	 * <p>时间：2014-04-01 下午 17:40:39</p>
	 * @param speed 速度
	 */
	public void setSpeed(Float speed) {
		this.speed = speed;
	}

	/**
	 * <p>说明：获取速度</p>
	 * <p>时间：2014-04-01 下午 17:40:39</p>
	 * @return 速度
	 */
	public Float getSpeed() {
		return this.speed;
	}

	/**
	 * <p>说明：设置方向</p>
	 * <p>时间：2014-04-01 下午 17:40:39</p>
	 * @param dir 方向
	 */
	public void setDir(Float dir) {
		this.dir = dir;
	}

	/**
	 * <p>说明：获取方向</p>
	 * <p>时间：2014-04-01 下午 17:40:39</p>
	 * @return 方向
	 */
	public Float getDir() {
		return this.dir;
	}

	/**
	 * <p>说明：设置备注</p>
	 * <p>时间：2014-04-01 下午 17:40:39</p>
	 * @param remark 备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * <p>说明：获取备注</p>
	 * <p>时间：2014-04-01 下午 17:40:39</p>
	 * @return 备注
	 */
	public String getRemark() {
		return this.remark;
	}
}