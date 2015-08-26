package com.founder.bzdz.vo;
import java.io.Serializable;
/**
 * @类名: DzXxbVO 
 * @描述: 对外提供地址VO
 * @作者: zhang_guoliang@founder.com 
 * @日期: 2015-4-3 上午11:19:23 
 */
public class DzXxbVO implements Serializable{
	private static final long serialVersionUID = 6458346610098524819L;
	private String  hjd_xzqhdm;
	private String  hjd_mlpdm;
	private String  hjd_mlpxz;
	private String  hjd_dzid;
	private String  hjd_dzxz;
	public String getHjd_xzqhdm() {
		return hjd_xzqhdm;
	}
	public void setHjd_xzqhdm(String hjd_xzqhdm) {
		this.hjd_xzqhdm = hjd_xzqhdm;
	}
	public String getHjd_mlpdm() {
		return hjd_mlpdm;
	}
	public void setHjd_mlpdm(String hjd_mlpdm) {
		this.hjd_mlpdm = hjd_mlpdm;
	}
	public String getHjd_mlpxz() {
		return hjd_mlpxz;
	}
	public void setHjd_mlpxz(String hjd_mlpxz) {
		this.hjd_mlpxz = hjd_mlpxz;
	}
	public String getHjd_dzid() {
		return hjd_dzid;
	}
	public void setHjd_dzid(String hjd_dzid) {
		this.hjd_dzid = hjd_dzid;
	}
	public String getHjd_dzxz() {
		return hjd_dzxz;
	}
	public void setHjd_dzxz(String hjd_dzxz) {
		this.hjd_dzxz = hjd_dzxz;
	}
}