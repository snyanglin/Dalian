package com.founder.jcj.bean;

import java.io.Serializable;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.base.entity.BaseEntity;
@DBInfoAnnotation(tableName = "JCJ_JJXXB", pk = "id")
public class JcjJjxxb extends BaseEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	@FieldDesc("接警ID")
	private String id;
	@FieldDesc("行政区划代码                       ")
	private String xzqhdm;
	@FieldDesc("接警单位代码                       ")
	private String jjdwdm;
	@FieldDesc("接警编号                           ")
	private String jjbh;
	@FieldDesc("接警类型代码                       ")
	private String jjlxdm;
	@FieldDesc("报警方式代码                       ")
	private String bjfsdm;
	@FieldDesc("重复警情编号                       ")
	private String cfjqbh;
	@FieldDesc("来话类型代码                       ")
	private String lhlxdm;
	@FieldDesc("关联警情编号                       ")
	private String gljqbh;
	@FieldDesc("接警录音号                         ")
	private String jjlyh;
	@FieldDesc("特服号码                           ")
	private String tfhm;
	@FieldDesc("接警警员编号                       ")
	private String jjjybh;
	@FieldDesc("接警员_姓名                        ")
	private String jjy_xm;
	@FieldDesc("报警_时间                          ")
	private String bj_sj;
	@FieldDesc("接警_时间                          ")
	private String jj_sj;
	@FieldDesc("话终_时间                          ")
	private String hz_sj;
	@FieldDesc("报警人_公民身份号码                ")
	private String bjr_gmsfhm;
	@FieldDesc("报警_联系电话                      ")
	private String bj_lxdh;
	@FieldDesc("报警电话用户_姓名                  ")
	private String bjdhyh_xm;
	@FieldDesc("报警电话用户地址                   ")
	private String bjdhyhdz;
	@FieldDesc("报警人_姓名                        ")
	private String bjr_xm;
	@FieldDesc("报警人_性别代码                    ")
	private String bjr_xbdm;
	@FieldDesc("报警人_联系电话                    ")
	private String bjr_lxdh;
	@FieldDesc("警情地址_行政区划代码              ")
	private String jqdz_zxzqhdm;
	@FieldDesc("警情地址_门楼牌代码                ")
	private String jqdz_mlpdm;
	@FieldDesc("警情地址_门楼牌详址                ")
	private String jqdz_mlpxz;
	@FieldDesc("警情地址代码                       ")
	private String jqdzdm;
	@FieldDesc("警情地址详址                       ")
	private String jqdzxz;
	@FieldDesc("警情地址描述                       ")
	private String jqdzms;
	@FieldDesc("警情_中心点横坐标                  ")
	private String jq_zxdhzb;
	@FieldDesc("警情_中心点纵坐标                  ")
	private String jq_zxdzzb;
	@FieldDesc("报警内容                           ")
	private String bjnr;
	@FieldDesc("管辖单位代码                       ")
	private String gxdwdm;
	@FieldDesc("警情类别代码                       ")
	private String jqlbdm;
	@FieldDesc("警情类型代码                       ")
	private String jqlxdm;
	@FieldDesc("警情细类代码                       ")
	private String jqxldm;
	@FieldDesc("路灯杆编号                         ")
	private String ldgbh;
	@FieldDesc("有无危险物质                       ")
	private Long ywwxwz=(long) 0;
	@FieldDesc("有无爆炸/泄漏                      ")
	private Long ywbzxl=(long) 0;
	@FieldDesc("报警车号牌种类代码                 ")
	private String bjchpzldm;
	@FieldDesc("报警车牌号                         ")
	private String bjcph;
	@FieldDesc("被困_人数                          ")
	private Long bk_rs=(long) 0;
	@FieldDesc("受伤_人数                          ")
	private Long ss_rs=(long) 0;
	@FieldDesc("死亡_人数                          ")
	private Long sw_rs=(long) 0;
	@FieldDesc("是否涉外                           ")
	private Long sfsw=(long) 0;
	@FieldDesc("是否是外语报警                     ")
	private Long sfswybj=(long) 0;
	@FieldDesc("自动定位_中心点横坐标（报警人位置）")
	private String zddw_zxdhzb;
	@FieldDesc("自动定位_中心点纵坐标（报警人位置）")
	private String zddw_zxdzzb;
	@FieldDesc("手工定位_中心点横坐标（报警人位置）")
	private String sgdw_zxdhhb;
	@FieldDesc("手工定位_中心点纵坐标（报警人位置）")
	private String sgdw_zxdzzb;
	@FieldDesc("补充接警内容                       ")
	private String bcjjnr;
	@FieldDesc("入库_时间                          ")
	private String rk_sj;
	@FieldDesc("警情状态代码                       ")
	private String jqztdm;
	@FieldDesc("作案工具代码                       ")
	private String zagjdm;
	@FieldDesc("更新_时间                          ")
	private String gx_sj;
	@FieldDesc("警情等级代码                       ")
	private String jqdjdm;
	@FieldDesc("火灾等级代码                       ")
	private String hzdjdm;
	@FieldDesc("起火建筑结构代码                   ")
	private String qhjzjgdm;
	@FieldDesc("火灾场所代码                       ")
	private String hzcsdm;
	@FieldDesc("起火建筑情况描述                   ")
	private String qhjzqkms;
	@FieldDesc("毗邻情况                           ")
	private String plqk;
	@FieldDesc("起火物代码                         ")
	private String qhwdm;
	@FieldDesc("有无逃逸                           ")
	private Long ywty=(long) 0;
	@FieldDesc("是否是危化车辆                     ")
	private Long sfswhcl=(long) 0;
	@FieldDesc("视图主键                     ")
	private String guid;
	@FieldDesc("消息编号                     ")
	private String msgid;
	@FieldDesc("消息类型                     ")
	private String msgtype;
	@FieldDesc("发送者                     ")
	private String msgsender;
	@FieldDesc("接收者                     ")
	private String msgreceiver;
	@FieldDesc("接收时间                     ")
	private String msgdatatime;
	@FieldDesc("原始发送席位号                     ")
	private String orgseatno;
	@FieldDesc("案件性质                     ")
	private String casekind;
	@FieldDesc("案件级别                     ")
	private String eventlevel;
	@FieldDesc("处警单编号                     ")
	private String processid;
	@FieldDesc("出警单位编号（GA380-2002标准）                     ")
	private String stationhousecode;
	@FieldDesc("出警单位名称                      ")
	private String stationhouse;
	@FieldDesc("终端类型                      ")
	private String terminaltype;
	@FieldDesc("IP                      ")
	private String ip;
	@FieldDesc("KYZT")
	private String kyzt;
	@FieldDesc("备注")
	private String bz;
	
	@FieldDesc("警情发生单位")
	private String jqfsdw;
	
	@FieldDesc("警情发生时间")
	private String jqfssj;
	
	@FieldDesc("警情摘要")
	private String jqzy;
	
	private String jj_sj1;
	
	private String cljgdm;
	
	private String cjy_xm;
	
	private String qszt;
	
	private String cjdbh;
	
	private String gxdwmc;
	
	private String currrentDay;
	
	private String rownum;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getXzqhdm() {
		return xzqhdm;
	}
	public void setXzqhdm(String xzqhdm) {
		this.xzqhdm = xzqhdm;
	}
	public String getJjdwdm() {
		return jjdwdm;
	}
	public void setJjdwdm(String jjdwdm) {
		this.jjdwdm = jjdwdm;
	}
	public String getJjbh() {
		return jjbh;
	}
	public void setJjbh(String jjbh) {
		this.jjbh = jjbh;
	}
	public String getJjlxdm() {
		return jjlxdm;
	}
	public void setJjlxdm(String jjlxdm) {
		this.jjlxdm = jjlxdm;
	}
	public String getBjfsdm() {
		return bjfsdm;
	}
	public void setBjfsdm(String bjfsdm) {
		this.bjfsdm = bjfsdm;
	}
	public String getCfjqbh() {
		return cfjqbh;
	}
	public void setCfjqbh(String cfjqbh) {
		this.cfjqbh = cfjqbh;
	}
	public String getLhlxdm() {
		return lhlxdm;
	}
	public void setLhlxdm(String lhlxdm) {
		this.lhlxdm = lhlxdm;
	}
	public String getGljqbh() {
		return gljqbh;
	}
	public void setGljqbh(String gljqbh) {
		this.gljqbh = gljqbh;
	}
	public String getJjlyh() {
		return jjlyh;
	}
	public void setJjlyh(String jjlyh) {
		this.jjlyh = jjlyh;
	}
	public String getTfhm() {
		return tfhm;
	}
	public void setTfhm(String tfhm) {
		this.tfhm = tfhm;
	}
	public String getJjjybh() {
		return jjjybh;
	}
	public void setJjjybh(String jjjybh) {
		this.jjjybh = jjjybh;
	}
	public String getJjy_xm() {
		return jjy_xm;
	}
	public void setJjy_xm(String jjy_xm) {
		this.jjy_xm = jjy_xm;
	}
	public String getBj_sj() {
		return bj_sj;
	}
	public void setBj_sj(String bj_sj) {
		this.bj_sj = bj_sj;
	}
	public String getJj_sj() {
		return jj_sj;
	}
	public void setJj_sj(String jj_sj) {
		this.jj_sj = jj_sj;
	}
	public String getHz_sj() {
		return hz_sj;
	}
	public void setHz_sj(String hz_sj) {
		this.hz_sj = hz_sj;
	}
	public String getBjr_gmsfhm() {
		return bjr_gmsfhm;
	}
	public void setBjr_gmsfhm(String bjr_gmsfhm) {
		this.bjr_gmsfhm = bjr_gmsfhm;
	}
	public String getBj_lxdh() {
		return bj_lxdh;
	}
	public void setBj_lxdh(String bj_lxdh) {
		this.bj_lxdh = bj_lxdh;
	}
	public String getBjdhyh_xm() {
		return bjdhyh_xm;
	}
	public void setBjdhyh_xm(String bjdhyh_xm) {
		this.bjdhyh_xm = bjdhyh_xm;
	}
	public String getBjdhyhdz() {
		return bjdhyhdz;
	}
	public void setBjdhyhdz(String bjdhyhdz) {
		this.bjdhyhdz = bjdhyhdz;
	}
	public String getBjr_xm() {
		return bjr_xm;
	}
	public void setBjr_xm(String bjr_xm) {
		this.bjr_xm = bjr_xm;
	}
	public String getBjr_xbdm() {
		return bjr_xbdm;
	}
	public void setBjr_xbdm(String bjr_xbdm) {
		this.bjr_xbdm = bjr_xbdm;
	}
	public String getBjr_lxdh() {
		return bjr_lxdh;
	}
	public void setBjr_lxdh(String bjr_lxdh) {
		this.bjr_lxdh = bjr_lxdh;
	}
	public String getJqdz_zxzqhdm() {
		return jqdz_zxzqhdm;
	}
	public void setJqdz_zxzqhdm(String jqdz_zxzqhdm) {
		this.jqdz_zxzqhdm = jqdz_zxzqhdm;
	}
	public String getJqdz_mlpdm() {
		return jqdz_mlpdm;
	}
	public void setJqdz_mlpdm(String jqdz_mlpdm) {
		this.jqdz_mlpdm = jqdz_mlpdm;
	}
	public String getJqdz_mlpxz() {
		return jqdz_mlpxz;
	}
	public void setJqdz_mlpxz(String jqdz_mlpxz) {
		this.jqdz_mlpxz = jqdz_mlpxz;
	}
	public String getJqdzdm() {
		return jqdzdm;
	}
	public void setJqdzdm(String jqdzdm) {
		this.jqdzdm = jqdzdm;
	}
	public String getJqdzxz() {
		return jqdzxz;
	}
	public void setJqdzxz(String jqdzxz) {
		this.jqdzxz = jqdzxz;
	}
	public String getJqdzms() {
		return jqdzms;
	}
	public void setJqdzms(String jqdzms) {
		this.jqdzms = jqdzms;
	}
	public String getJq_zxdhzb() {
		return jq_zxdhzb;
	}
	public void setJq_zxdhzb(String jq_zxdhzb) {
		this.jq_zxdhzb = jq_zxdhzb;
	}
	public String getJq_zxdzzb() {
		return jq_zxdzzb;
	}
	public void setJq_zxdzzb(String jq_zxdzzb) {
		this.jq_zxdzzb = jq_zxdzzb;
	}
	public String getBjnr() {
		return bjnr;
	}
	public void setBjnr(String bjnr) {
		this.bjnr = bjnr;
	}
	public String getGxdwdm() {
		return gxdwdm;
	}
	public void setGxdwdm(String gxdwdm) {
		this.gxdwdm = gxdwdm;
	}
	public String getJqlbdm() {
		return jqlbdm;
	}
	public void setJqlbdm(String jqlbdm) {
		this.jqlbdm = jqlbdm;
	}
	public String getJqlxdm() {
		return jqlxdm;
	}
	public void setJqlxdm(String jqlxdm) {
		this.jqlxdm = jqlxdm;
	}
	public String getJqxldm() {
		return jqxldm;
	}
	public void setJqxldm(String jqxldm) {
		this.jqxldm = jqxldm;
	}
	public String getLdgbh() {
		return ldgbh;
	}
	public void setLdgbh(String ldgbh) {
		this.ldgbh = ldgbh;
	}
	public Long getYwwxwz() {
		return ywwxwz;
	}
	public void setYwwxwz(Long ywwxwz) {
		this.ywwxwz = ywwxwz;
	}
	public Long getYwbzxl() {
		return ywbzxl;
	}
	public void setYwbzxl(Long ywbzxl) {
		this.ywbzxl = ywbzxl;
	}
	public String getBjchpzldm() {
		return bjchpzldm;
	}
	public void setBjchpzldm(String bjchpzldm) {
		this.bjchpzldm = bjchpzldm;
	}
	public String getBjcph() {
		return bjcph;
	}
	public void setBjcph(String bjcph) {
		this.bjcph = bjcph;
	}
	public Long getBk_rs() {
		return bk_rs;
	}
	public void setBk_rs(Long bk_rs) {
		this.bk_rs = bk_rs;
	}
	public Long getSs_rs() {
		return ss_rs;
	}
	public void setSs_rs(Long ss_rs) {
		this.ss_rs = ss_rs;
	}
	public Long getSw_rs() {
		return sw_rs;
	}
	public void setSw_rs(Long sw_rs) {
		this.sw_rs = sw_rs;
	}
	public Long getSfsw() {
		return sfsw;
	}
	public void setSfsw(Long sfsw) {
		this.sfsw = sfsw;
	}
	public Long getSfswybj() {
		return sfswybj;
	}
	public void setSfswybj(Long sfswybj) {
		this.sfswybj = sfswybj;
	}
	public String getZddw_zxdhzb() {
		return zddw_zxdhzb;
	}
	public void setZddw_zxdhzb(String zddw_zxdhzb) {
		this.zddw_zxdhzb = zddw_zxdhzb;
	}
	public String getZddw_zxdzzb() {
		return zddw_zxdzzb;
	}
	public void setZddw_zxdzzb(String zddw_zxdzzb) {
		this.zddw_zxdzzb = zddw_zxdzzb;
	}
	public String getSgdw_zxdhhb() {
		return sgdw_zxdhhb;
	}
	public void setSgdw_zxdhhb(String sgdw_zxdhhb) {
		this.sgdw_zxdhhb = sgdw_zxdhhb;
	}
	public String getSgdw_zxdzzb() {
		return sgdw_zxdzzb;
	}
	public void setSgdw_zxdzzb(String sgdw_zxdzzb) {
		this.sgdw_zxdzzb = sgdw_zxdzzb;
	}
	public String getBcjjnr() {
		return bcjjnr;
	}
	public void setBcjjnr(String bcjjnr) {
		this.bcjjnr = bcjjnr;
	}
	public String getRk_sj() {
		return rk_sj;
	}
	public void setRk_sj(String rk_sj) {
		this.rk_sj = rk_sj;
	}
	public String getJqztdm() {
		return jqztdm;
	}
	public void setJqztdm(String jqztdm) {
		this.jqztdm = jqztdm;
	}
	public String getZagjdm() {
		return zagjdm;
	}
	public void setZagjdm(String zagjdm) {
		this.zagjdm = zagjdm;
	}
	public String getGx_sj() {
		return gx_sj;
	}
	public void setGx_sj(String gx_sj) {
		this.gx_sj = gx_sj;
	}
	public String getJqdjdm() {
		return jqdjdm;
	}
	public void setJqdjdm(String jqdjdm) {
		this.jqdjdm = jqdjdm;
	}
	public String getHzdjdm() {
		return hzdjdm;
	}
	public void setHzdjdm(String hzdjdm) {
		this.hzdjdm = hzdjdm;
	}
	public String getQhjzjgdm() {
		return qhjzjgdm;
	}
	public void setQhjzjgdm(String qhjzjgdm) {
		this.qhjzjgdm = qhjzjgdm;
	}
	public String getHzcsdm() {
		return hzcsdm;
	}
	public void setHzcsdm(String hzcsdm) {
		this.hzcsdm = hzcsdm;
	}
	public String getQhjzqkms() {
		return qhjzqkms;
	}
	public void setQhjzqkms(String qhjzqkms) {
		this.qhjzqkms = qhjzqkms;
	}
	public String getPlqk() {
		return plqk;
	}
	public void setPlqk(String plqk) {
		this.plqk = plqk;
	}
	public String getQhwdm() {
		return qhwdm;
	}
	public void setQhwdm(String qhwdm) {
		this.qhwdm = qhwdm;
	}
	public Long getYwty() {
		return ywty;
	}
	public void setYwty(Long ywty) {
		this.ywty = ywty;
	}
	public Long getSfswhcl() {
		return sfswhcl;
	}
	public void setSfswhcl(Long sfswhcl) {
		this.sfswhcl = sfswhcl;
	}
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public String getMsgid() {
		return msgid;
	}
	public void setMsgid(String msgid) {
		this.msgid = msgid;
	}
	public String getMsgtype() {
		return msgtype;
	}
	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}
	public String getMsgsender() {
		return msgsender;
	}
	public void setMsgsender(String msgsender) {
		this.msgsender = msgsender;
	}
	public String getMsgreceiver() {
		return msgreceiver;
	}
	public void setMsgreceiver(String msgreceiver) {
		this.msgreceiver = msgreceiver;
	}
	public String getMsgdatatime() {
		return msgdatatime;
	}
	public void setMsgdatatime(String msgdatatime) {
		this.msgdatatime = msgdatatime;
	}
	public String getOrgseatno() {
		return orgseatno;
	}
	public void setOrgseatno(String orgseatno) {
		this.orgseatno = orgseatno;
	}
	public String getCasekind() {
		return casekind;
	}
	public void setCasekind(String casekind) {
		this.casekind = casekind;
	}
	public String getEventlevel() {
		return eventlevel;
	}
	public void setEventlevel(String eventlevel) {
		this.eventlevel = eventlevel;
	}
	public String getProcessid() {
		return processid;
	}
	public void setProcessid(String processid) {
		this.processid = processid;
	}
	public String getStationhousecode() {
		return stationhousecode;
	}
	public void setStationhousecode(String stationhousecode) {
		this.stationhousecode = stationhousecode;
	}
	public String getStationhouse() {
		return stationhouse;
	}
	public void setStationhouse(String stationhouse) {
		this.stationhouse = stationhouse;
	}
	public String getTerminaltype() {
		return terminaltype;
	}
	public void setTerminaltype(String terminaltype) {
		this.terminaltype = terminaltype;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getKyzt() {
		return kyzt;
	}
	public void setKyzt(String kyzt) {
		this.kyzt = kyzt;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getJj_sj1() {
		return jj_sj1;
	}
	public void setJj_sj1(String jj_sj1) {
		this.jj_sj1 = jj_sj1;
	}
	public String getCljgdm() {
		return cljgdm;
	}
	public void setCljgdm(String cljgdm) {
		this.cljgdm = cljgdm;
	}
	public String getCjy_xm() {
		return cjy_xm;
	}
	public void setCjy_xm(String cjy_xm) {
		this.cjy_xm = cjy_xm;
	}
	public String getQszt() {
		return qszt;
	}
	public void setQszt(String qszt) {
		this.qszt = qszt;
	}
	public String getCjdbh() {
		return cjdbh;
	}
	public void setCjdbh(String cjdbh) {
		this.cjdbh = cjdbh;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getJqfssj() {
		return jqfssj;
	}
	public void setJqfssj(String jqfssj) {
		this.jqfssj = jqfssj;
	}
	public String getJqfsdw() {
		return jqfsdw;
	}
	public void setJqfsdw(String jqfsdw) {
		this.jqfsdw = jqfsdw;
	}
	public String getJqzy() {
		return jqzy;
	}
	public void setJqzy(String jqzy) {
		this.jqzy = jqzy;
	}
	public String getGxdwmc() {
		return gxdwmc;
	}
	public void setGxdwmc(String gxdwmc) {
		this.gxdwmc = gxdwmc;
	}
	public String getCurrrentDay() {
		return currrentDay;
	}
	public void setCurrrentDay(String currrentDay) {
		this.currrentDay = currrentDay;
	}
	public String getRownum() {
		return rownum;
	}
	public void setRownum(String rownum) {
		this.rownum = rownum;
	}
	
	
	
	
	
	
}