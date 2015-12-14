package com.founder.ggfw.service;

import java.util.Map;

import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.message.bean.SysMessage;

@TypeAnnotation("业务协同规则处理")
public interface YwxtRuleService {
	
	/**
	 * 联系电话变更核实规则
	 */
	public Object lxdh_agree(Map<String, Object> param, String flag, String methodName, 
			//实有人口核实参数
			String hsrwid, String hslx, String zrqdm,
			//联系电话变更参数
			String ryid, String lxfslxdm, String lxfs,
			//从业人员变更参数
			/*ryid*/ String dwid,
			//服务处所变更参数
			/*ryid*/ String fwcsid, String fwcs, /*hslx*/
			String ywxtgzrwbid,
			String messageid);
	public Object lxdh_refuse(Map<String, Object> param, String flag, String methodName, 
			//实有人口核实参数
			String hsrwid, String hslx, String zrqdm,
			//联系电话变更参数
			String ryid, String lxfslxdm, String lxfs,
			//从业人员变更参数
			/*ryid*/ String dwid,
			//服务处所变更参数
			/*ryid*/ String fwcsid, String fwcs, /*hslx*/
			String ywxtgzrwbid,
			String messageid);
	public Object lxdh_coexist(Map<String, Object> param, String flag, String methodName, 
			//实有人口核实参数
			String hsrwid, String hslx, String zrqdm,
			//联系电话变更参数
			String ryid, String lxfslxdm, String lxfs,
			//从业人员变更参数
			/*ryid*/ String dwid,
			//服务处所变更参数
			/*ryid*/ String fwcsid, String fwcs, /*hslx*/
			String ywxtgzrwbid,
			String messageid);
	
	/**
	 * 服务处所变更核实规则
	 */
	public Object fwcsxz_agree(Map<String, Object> param, String flag, String methodName, 
			//实有人口核实参数
			String hsrwid, String hslx, String zrqdm,
			//联系电话变更参数
			String ryid, String lxfslxdm, String lxfs,
			//从业人员变更参数
			/*ryid*/ String dwid,
			//服务处所变更参数
			/*ryid*/ String fwcsid, String fwcs, /*hslx*/
			String ywxtgzrwbid,
			String messageid);
	public Object fwcsxz_refuse(Map<String, Object> param, String flag, String methodName, 
			//实有人口核实参数
			String hsrwid, String hslx, String zrqdm,
			//联系电话变更参数
			String ryid, String lxfslxdm, String lxfs,
			//从业人员变更参数
			/*ryid*/ String dwid,
			//服务处所变更参数
			/*ryid*/ String fwcsid, String fwcs, /*hslx*/
			String ywxtgzrwbid,
			String messageid);
	public Object fwcsxz_coexist(Map<String, Object> param, String flag, String methodName, 
			//实有人口核实参数
			String hsrwid, String hslx, String zrqdm,
			//联系电话变更参数
			String ryid, String lxfslxdm, String lxfs,
			//从业人员变更参数
			/*ryid*/ String dwid,
			//服务处所变更参数
			/*ryid*/ String fwcsid, String fwcs, /*hslx*/
			String ywxtgzrwbid,
			String messageid);
	
	/**
	 * 服务处所注销核实规则
	 */
	public Object fwcszx_agree(Map<String, Object> param, String flag, String methodName, 
			//实有人口核实参数
			String hsrwid, String hslx, String zrqdm,
			//联系电话变更参数
			String ryid, String lxfslxdm, String lxfs,
			//从业人员变更参数
			/*ryid*/ String dwid,
			//服务处所变更参数
			/*ryid*/ String fwcsid, String fwcs, /*hslx*/
			String ywxtgzrwbid,
			String messageid);
	public Object fwcszx_refuse(Map<String, Object> param, String flag, String methodName, 
			//实有人口核实参数
			String hsrwid, String hslx, String zrqdm,
			//联系电话变更参数
			String ryid, String lxfslxdm, String lxfs,
			//从业人员变更参数
			/*ryid*/ String dwid,
			//服务处所变更参数
			/*ryid*/ String fwcsid, String fwcs, /*hslx*/
			String ywxtgzrwbid,
			String messageid);
	public Object fwcszx_coexist(Map<String, Object> param, String flag, String methodName, 
			//实有人口核实参数
			String hsrwid, String hslx, String zrqdm,
			//联系电话变更参数
			String ryid, String lxfslxdm, String lxfs,
			//从业人员变更参数
			/*ryid*/ String dwid,
			//服务处所变更参数
			/*ryid*/ String fwcsid, String fwcs, /*hslx*/
			String ywxtgzrwbid,
			String messageid);
	
	/**
	 * 从业人员核实规则
	 */
	public Object cyry_agree(Map<String, Object> param, String flag, String methodName, 
			//实有人口核实参数
			String hsrwid, String hslx, String zrqdm,
			//联系电话变更参数
			String ryid, String lxfslxdm, String lxfs,
			//从业人员变更参数
			/*ryid*/ String dwid,
			//服务处所变更参数
			/*ryid*/ String fwcsid, String fwcs, /*hslx*/
			String ywxtgzrwbid,
			String messageid);
	public Object cyry_refuse(Map<String, Object> param, String flag, String methodName, 
			//实有人口核实参数
			String hsrwid, String hslx, String zrqdm,
			//联系电话变更参数
			String ryid, String lxfslxdm, String lxfs,
			//从业人员变更参数
			/*ryid*/ String dwid,
			//服务处所变更参数
			/*ryid*/ String fwcsid, String fwcs, /*hslx*/
			String ywxtgzrwbid,
			String messageid);
	public Object cyry_coexist(Map<String, Object> param, String flag, String methodName, 
			//实有人口核实参数
			String hsrwid, String hslx, String zrqdm,
			//联系电话变更参数
			String ryid, String lxfslxdm, String lxfs,
			//从业人员变更参数
			/*ryid*/ String dwid,
			//服务处所变更参数
			/*ryid*/ String fwcsid, String fwcs, /*hslx*/
			String ywxtgzrwbid,
			String messageid);
	
	/**
	 * 实有人口新增核实规则
	 */
	public Object syrkxz_agree(Map<String, Object> param, String flag, String methodName, 
			//实有人口核实参数
			String hsrwid, String hslx, String zrqdm,
			//联系电话变更参数
			String ryid, String lxfslxdm, String lxfs,
			//从业人员变更参数
			/*ryid*/ String dwid,
			//服务处所变更参数
			/*ryid*/ String fwcsid, String fwcs, /*hslx*/
			String ywxtgzrwbid,
			String messageid);
	public Object syrkxz_refuse(Map<String, Object> param, String flag, String methodName, 
			//实有人口核实参数
			String hsrwid, String hslx, String zrqdm,
			//联系电话变更参数
			String ryid, String lxfslxdm, String lxfs,
			//从业人员变更参数
			/*ryid*/ String dwid,
			//服务处所变更参数
			/*ryid*/ String fwcsid, String fwcs, /*hslx*/
			String ywxtgzrwbid,
			String messageid);
	public Object syrkxz_coexist(Map<String, Object> param, String flag, String methodName, 
			//实有人口核实参数
			String hsrwid, String hslx, String zrqdm,
			//联系电话变更参数
			String ryid, String lxfslxdm, String lxfs,
			//从业人员变更参数
			/*ryid*/ String dwid,
			//服务处所变更参数
			/*ryid*/ String fwcsid, String fwcs, /*hslx*/
			String ywxtgzrwbid,
			String messageid);
	
	/**
	 * 实有人口注销核实规则
	 */
	public Object syrkzx_agree(Map<String, Object> param, String flag, String methodName, 
			//实有人口核实参数
			String hsrwid, String hslx, String zrqdm,
			//联系电话变更参数
			String ryid, String lxfslxdm, String lxfs,
			//从业人员变更参数
			/*ryid*/ String dwid,
			//服务处所变更参数
			/*ryid*/ String fwcsid, String fwcs, /*hslx*/
			String ywxtgzrwbid,
			String messageid);
	public Object syrkzx_refuse(Map<String, Object> param, String flag, String methodName, 
			//实有人口核实参数
			String hsrwid, String hslx, String zrqdm,
			//联系电话变更参数
			String ryid, String lxfslxdm, String lxfs,
			//从业人员变更参数
			/*ryid*/ String dwid,
			//服务处所变更参数
			/*ryid*/ String fwcsid, String fwcs, /*hslx*/
			String ywxtgzrwbid,
			String messageid);
	public Object syrkzx_coexist(Map<String, Object> param, String flag, String methodName, 
			//实有人口核实参数
			String hsrwid, String hslx, String zrqdm,
			//联系电话变更参数
			String ryid, String lxfslxdm, String lxfs,
			//从业人员变更参数
			/*ryid*/ String dwid,
			//服务处所变更参数
			/*ryid*/ String fwcsid, String fwcs, /*hslx*/
			String ywxtgzrwbid,
			String messageid);
	
	/**
	 * 规则公共方法(eg：发送回执消息)
	 */
	public Object common_agree(Map<String, Object> param);
	public Object common_refuse(Map<String, Object> param);
	public Object common_coexist(Map<String, Object> param);
	
	public SysMessage getMessageById(Long id);

}
