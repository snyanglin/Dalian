package com.founder.zdrygl.base.message;

import java.io.Serializable;

public class SysMessage implements Serializable {		

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	/**
	 * 消息标题
	 */
	private String xxbt;
	
	/**
	 * 消息内容
	 */
	private String xxnr;
	/**
	 * 消息类别 字典D_SYS_XXLB
	 * 1消息提醒 2业务协同 3通知公告 4 通报公告 5 工作任务
	 */
	private String xxlb;
	/**
	 * 业务url
	 */
	private String ywurl;
	/**
	 * 发送人
	 */
	private String fsr;
	/**
	 * 发送人代码
	 */
	private String fsrdm;
	/**
	 * 发送时间
	 */
	private String fssj;
	/**
	 * 发送人所属单位
	 */
	private String fsrssdw;
	/**
	 * 发送人所属单位代码
	 */
	private String fsrssdwdm;

	/**
	 * 接收类型0按人 1按部门
	 */
	private String jslx;
	/**
	 * 接收人
	 */
	private String jsr;
	/**
	 * 接收人代码
	 */
	private String jsrdm;
	/**
	 * 接收人所属单位
	 */
	private String jsrssdw;
	/**
	 * 接收人所属单位代码
	 */
	private String jsrssdwdm;
	/**
	 * 是否查看
	 */
	private String sfck;
	/**
	 * 查看时间
	 */
	private String cksj;
	
	/**
	 * 消息状态，0：成功，1失败
	 */
	private int status=1;
	
	/**
	 * 打开方式
	 */
	private String dkfs;
	
	private String errorMessage = "message init error";

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getXxbt() {
		return xxbt;
	}

	public void setXxbt(String xxbt) {
		this.xxbt = xxbt;
	}

	public String getXxnr() {
		return xxnr;
	}

	public void setXxnr(String xxnr) {
		this.xxnr = xxnr;
	}

	public String getXxlb() {
		return xxlb;
	}

	public void setXxlb(String xxlb) {
		this.xxlb = xxlb;
	}

	public String getYwurl() {
		return ywurl;
	}

	public void setYwurl(String ywurl) {
		this.ywurl = ywurl;
	}

	public String getFsr() {
		return fsr;
	}

	public void setFsr(String fsr) {
		this.fsr = fsr;
	}

	public String getFsrdm() {
		return fsrdm;
	}

	public void setFsrdm(String fsrdm) {
		this.fsrdm = fsrdm;
	}

	public String getFssj() {
		return fssj;
	}

	public void setFssj(String fssj) {
		this.fssj = fssj;
	}

	public String getFsrssdw() {
		return fsrssdw;
	}

	public void setFsrssdw(String fsrssdw) {
		this.fsrssdw = fsrssdw;
	}

	public String getFsrssdwdm() {
		return fsrssdwdm;
	}

	public void setFsrssdwdm(String fsrssdwdm) {
		this.fsrssdwdm = fsrssdwdm;
	}

	public String getJslx() {
		return jslx;
	}

	public void setJslx(String jslx) {
		this.jslx = jslx;
	}

	public String getJsr() {
		return jsr;
	}

	public void setJsr(String jsr) {
		this.jsr = jsr;
	}

	public String getJsrdm() {
		return jsrdm;
	}

	public void setJsrdm(String jsrdm) {
		this.jsrdm = jsrdm;
	}

	public String getJsrssdw() {
		return jsrssdw;
	}

	public void setJsrssdw(String jsrssdw) {
		this.jsrssdw = jsrssdw;
	}

	public String getJsrssdwdm() {
		return jsrssdwdm;
	}

	public void setJsrssdwdm(String jsrssdwdm) {
		this.jsrssdwdm = jsrssdwdm;
	}

	public String getSfck() {
		return sfck;
	}

	public void setSfck(String sfck) {
		this.sfck = sfck;
	}

	public String getCksj() {
		return cksj;
	}

	public void setCksj(String cksj) {
		this.cksj = cksj;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getDkfs() {
		return dkfs;
	}

	public void setDkfs(String dkfs) {
		this.dkfs = dkfs;
	}
	
}
