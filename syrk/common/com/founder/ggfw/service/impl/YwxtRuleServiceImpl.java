package com.founder.ggfw.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import com.founder.ggfw.dao.YwxtgzrwbDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.apache.commons.beanutils.MethodUtils;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.message.bean.SysMessage;
import com.founder.framework.message.dao.SysMessageDao;
import com.founder.framework.message.service.SysMessageService;
import com.founder.framework.organization.user.bean.OrgUser;
import com.founder.framework.organization.user.service.OrgUserService;
import com.founder.framework.utils.DateUtils;
import com.founder.ggfw.bean.Ywxtgzrwb;
import com.founder.ggfw.dao.YwxtRuleDao;
import com.founder.ggfw.service.YwxtRuleService;

@Service("ywxtRuleService")
@Transactional
public class YwxtRuleServiceImpl extends BaseService implements YwxtRuleService {

	@Resource(name = "ywxtRuleDao")
	private YwxtRuleDao ywxtRuleDao;

	@Resource(name = "ywxtgzrwbDao")
	private YwxtgzrwbDao ywxtgzrwbDao;
	
	@Resource
	private SysMessageDao sysMessageDao;

	@Resource(name = "sysMessageService")
	private SysMessageService sysMessageService;
	
	@Autowired
	private ApplicationContext applicationContext;

	@Resource(name = "orgUserService")
	private OrgUserService orgUserService;
	/**
	 * 联系电话变更核实规则 -- 同意方法
	 * 直接更新[实有人口_人员联系方式子表]
	 * 参数：
	 * 1.ryid  人员id
	 * 2.lxfslxdm  联系方式类型代码
	 * 3.lxfs  联系方式
	 */
	@Override
	public Object lxdh_agree(Map<String, Object> param, String flag, String methodName, 
			//实有人口核实参数
			String hsrwid, String hslx, String userid,
			//联系电话变更参数
			String ryid, String lxfslxdm, String lxfs,
			//从业人员变更参数
			/*ryid*/ String dwid,
			//服务处所变更参数
			/*ryid*/ String fwcsid, String fwcs, /*hslx*/
			String ywxtgzrwbid,
			String messageid) {
		SessionBean sessionBean = (SessionBean)param.get("sessionBean");
		SysMessage entity = (SysMessage) param.get("entity");
		Ywxtgzrwb ywxtgzrwb=new Ywxtgzrwb();
		String rwclsm="同意变更联系电话";
		ywxtgzrwb.setId(ywxtgzrwbid);
		if(flag.equals("1")){
			ywxtgzrwb.setCjjgdm("0");//0-接受1-拒绝2-共存
			ywxtgzrwb.setYwrwztdm("4");//协同任务状态代码0-待发起1－已发起2-已接收3-待裁决4－已裁决
			BaseService.setUpdateProperties(ywxtgzrwb, sessionBean);
			//BaseService.setSaveProperties(czrkxxb, sessionBean);
			ywxtgzrwbDao.updateYwxtgzrwbByCjr(ywxtgzrwb,sessionBean);
			OrgUser orguser=new OrgUser();
			orguser=orgUserService.queryByUserid(entity.getFsrdm());
			sessionBean=orgUserService.initSessionUser(orguser);
		}else{
			//修改业务协同任务表
			ywxtgzrwb.setRwcljgdm("0");//任务处理结果代码0-接受1-拒绝2-共存
			ywxtgzrwb.setRwclsm(rwclsm);
			ywxtgzrwb.setYwrwztdm("2");//协同任务状态代码0-待发起1－已发起2-已接收3-待裁决4－已裁决
			BaseService.setUpdateProperties(ywxtgzrwb, sessionBean);
			//BaseService.setSaveProperties(czrkxxb, sessionBean);
			ywxtgzrwbDao.updateYwxtgzrwbByClr(ywxtgzrwb,sessionBean);
		}
		//调用联系电话变更业务方法
		try {
			MethodUtils.invokeMethod(sysMessageService, methodName, new Object[]{
					//联系电话变更参数
					ryid, lxfslxdm, lxfs, sessionBean});
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//发送任务回执
		common_agree(param);
		return null;
	}

	@Override
	public Object lxdh_coexist(Map<String, Object> param, String flag, String methodName, 
			//实有人口核实参数
			String hsrwid, String hslx, String userid,
			//联系电话变更参数
			String ryid, String lxfslxdm, String lxfs,
			//从业人员变更参数
			/*ryid*/ String dwid,
			//服务处所变更参数
			/*ryid*/ String fwcsid, String fwcs, /*hslx*/
			String ywxtgzrwbid,
			String messageid) {
		SessionBean sessionBean = (SessionBean)param.get("sessionBean");
		Ywxtgzrwb ywxtgzrwb=new Ywxtgzrwb();
		ywxtgzrwb.setId(ywxtgzrwbid);
		String rwclsm="联系电话共存";
		ywxtgzrwb.setCjjgdm("2");//0-接受1-拒绝2-共存
		ywxtgzrwb.setYwrwztdm("4");//协同任务状态代码0-待发起1－已发起2-已接收3-待裁决4－已裁决
		BaseService.setUpdateProperties(ywxtgzrwb, sessionBean);
		//BaseService.setSaveProperties(czrkxxb, sessionBean);
		ywxtgzrwbDao.updateYwxtgzrwbByCjr(ywxtgzrwb,sessionBean);
		common_coexist(param);
		return null;
	}

	@Override
	public Object lxdh_refuse(Map<String, Object> param, String flag, String methodName, 
			//实有人口核实参数
			String hsrwid, String hslx, String userid,
			//联系电话变更参数
			String ryid, String lxfslxdm, String lxfs,
			//从业人员变更参数
			/*ryid*/ String dwid,
			//服务处所变更参数
			/*ryid*/ String fwcsid, String fwcs, /*hslx*/
			String ywxtgzrwbid,
			String messageid) {
		SessionBean sessionBean = (SessionBean)param.get("sessionBean");
		Ywxtgzrwb ywxtgzrwb=new Ywxtgzrwb();
		ywxtgzrwb.setId(ywxtgzrwbid);
		String rwclsm="拒绝联系电话变更";
		if(flag.equals("1")){
			ywxtgzrwb.setCjjgdm("1");//0-接受1-拒绝2-共存
			ywxtgzrwb.setYwrwztdm("4");//协同任务状态代码0-待发起1－已发起2-已接收3-待裁决4－已裁决
			BaseService.setUpdateProperties(ywxtgzrwb, sessionBean);
			//BaseService.setSaveProperties(czrkxxb, sessionBean);
			ywxtgzrwbDao.updateYwxtgzrwbByCjr(ywxtgzrwb,sessionBean);
			common_leader_refuse(param);
		}else{
			//修改业务协同任务表
			ywxtgzrwb.setRwcljgdm("1");//任务处理结果代码0-接受1-拒绝2-共存
			ywxtgzrwb.setRwclsm(rwclsm);
			ywxtgzrwb.setYwrwztdm("3");//协同任务状态代码0-待发起1－已发起2-已接收3-待裁决4－已裁决
			BaseService.setUpdateProperties(ywxtgzrwb, sessionBean);
			//BaseService.setSaveProperties(czrkxxb, sessionBean);
			ywxtgzrwbDao.updateYwxtgzrwbByClr(ywxtgzrwb,sessionBean);
			common_refuse(param);
		}
		return null;
	}
	
	/**
	 * 从业人员变更核实规则 -- 同意方法
	 * 1.注销原从业人员信息
	 * 2.新增新从业人员信息
	 * 参数：
	 * 1.ryid  人员id
	 * 2.dwid  单位id
	 */
	@Override
	public Object cyry_agree(Map<String, Object> param, String flag, String methodName, 
			//实有人口核实参数
			String hsrwid, String hslx, String userid,
			//联系电话变更参数
			String ryid, String lxfslxdm, String lxfs,
			//从业人员变更参数
			/*ryid*/ String dwid,
			//服务处所变更参数
			/*ryid*/ String fwcsid, String fwcs, /*hslx*/
			String ywxtgzrwbid,
			String messageid) {
		SessionBean sessionBean = (SessionBean)param.get("sessionBean");
		SysMessage entity = (SysMessage) param.get("entity");
		Ywxtgzrwb ywxtgzrwb=new Ywxtgzrwb();
		String rwclsm="同意从业人员变更";
		ywxtgzrwb.setId(ywxtgzrwbid);
		if(flag.equals("1")){
//			sessionBean = (SessionBean)param.get("sessionBeanTemp");
			ywxtgzrwb.setCjjgdm("0");//0-接受1-拒绝2-共存
			ywxtgzrwb.setYwrwztdm("4");//协同任务状态代码0-待发起1－已发起2-已接收3-待裁决4－已裁决
			BaseService.setUpdateProperties(ywxtgzrwb, sessionBean);
			//BaseService.setSaveProperties(czrkxxb, sessionBean);
			ywxtgzrwbDao.updateYwxtgzrwbByCjr(ywxtgzrwb,sessionBean);
			OrgUser orguser=new OrgUser();
			orguser=orgUserService.queryByUserid(entity.getFsrdm());
			sessionBean=orgUserService.initSessionUser(orguser);
		}else{
			//修改业务协同任务表
			ywxtgzrwb.setRwcljgdm("0");//任务处理结果代码0-接受1-拒绝2-共存
			ywxtgzrwb.setRwclsm(rwclsm);
			ywxtgzrwb.setYwrwztdm("2");//协同任务状态代码0-待发起1－已发起2-已接收3-待裁决4－已裁决
			BaseService.setUpdateProperties(ywxtgzrwb, sessionBean);
			//BaseService.setSaveProperties(czrkxxb, sessionBean);
			ywxtgzrwbDao.updateYwxtgzrwbByClr(ywxtgzrwb,sessionBean);
		}
		//调用从业人员变更业务方法
		try {
			MethodUtils.invokeMethod(sysMessageService, methodName, new Object[]{
					//联系电话变更参数
					ryid, dwid,
					messageid, sessionBean});
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//发送任务回执
		common_agree(param);
		return null;
	}

	@Override
	public Object cyry_coexist(Map<String, Object> param, String flag, String methodName, 
			//实有人口核实参数
			String hsrwid, String hslx, String userid,
			//联系电话变更参数
			String ryid, String lxfslxdm, String lxfs,
			//从业人员变更参数
			/*ryid*/ String dwid,
			//服务处所变更参数
			/*ryid*/ String fwcsid, String fwcs, /*hslx*/
			String ywxtgzrwbid,
			String messageid) {
		SessionBean sessionBean = (SessionBean)param.get("sessionBean");
		Ywxtgzrwb ywxtgzrwb=new Ywxtgzrwb();
		ywxtgzrwb.setId(ywxtgzrwbid);
		String rwclsm="从业人员共存";
		ywxtgzrwb.setCjjgdm("2");//0-接受1-拒绝2-共存
		ywxtgzrwb.setYwrwztdm("4");//协同任务状态代码0-待发起1－已发起2-已接收3-待裁决4－已裁决
		BaseService.setUpdateProperties(ywxtgzrwb, sessionBean);
		//BaseService.setSaveProperties(czrkxxb, sessionBean);
		ywxtgzrwbDao.updateYwxtgzrwbByCjr(ywxtgzrwb,sessionBean);
		common_coexist(param);
		return null;
	}

	@Override
	public Object cyry_refuse(Map<String, Object> param, String flag, String methodName, 
			//实有人口核实参数
			String hsrwid, String hslx, String userid,
			//联系电话变更参数
			String ryid, String lxfslxdm, String lxfs,
			//从业人员变更参数
			/*ryid*/ String dwid,
			//服务处所变更参数
			/*ryid*/ String fwcsid, String fwcs, /*hslx*/
			String ywxtgzrwbid,
			String messageid) {
		SessionBean sessionBean = (SessionBean)param.get("sessionBean");
		Ywxtgzrwb ywxtgzrwb=new Ywxtgzrwb();
		ywxtgzrwb.setId(ywxtgzrwbid);
		String rwclsm="拒绝联系电话变更";
		if(flag.equals("1")){
			ywxtgzrwb.setCjjgdm("1");//0-接受1-拒绝2-共存
			ywxtgzrwb.setYwrwztdm("4");//协同任务状态代码0-待发起1－已发起2-已接收3-待裁决4－已裁决
			BaseService.setUpdateProperties(ywxtgzrwb, sessionBean);
			//BaseService.setSaveProperties(czrkxxb, sessionBean);
			ywxtgzrwbDao.updateYwxtgzrwbByCjr(ywxtgzrwb,sessionBean);
			common_leader_refuse(param);
		}else{
			//修改业务协同任务表
			ywxtgzrwb.setRwcljgdm("1");//任务处理结果代码0-接受1-拒绝2-共存
			ywxtgzrwb.setRwclsm(rwclsm);
			ywxtgzrwb.setYwrwztdm("3");//协同任务状态代码0-待发起1－已发起2-已接收3-待裁决4－已裁决
			BaseService.setUpdateProperties(ywxtgzrwb, sessionBean);
			//BaseService.setSaveProperties(czrkxxb, sessionBean);
			ywxtgzrwbDao.updateYwxtgzrwbByClr(ywxtgzrwb,sessionBean);
			common_refuse(param);
		}
		return null;
	}

	/**
	 * 服务处所变更核实规则 -- 同意方法
	 * 参数：
	 * 1.ryid  人员id
	 * 2.fwcsid  服务处所id（单位id）
	 * 3.fwcs  服务处所（单位名称）
	 */
	@Override
	public Object fwcsxz_agree(Map<String, Object> param, String flag, String methodName, 
			//实有人口核实参数
			String hsrwid, String hslx, String userid,
			//联系电话变更参数
			String ryid, String lxfslxdm, String lxfs,
			//从业人员变更参数
			/*ryid*/ String dwid,
			//服务处所变更参数
			/*ryid*/ String fwcsid, String fwcs, /*hslx*/
			String ywxtgzrwbid,
			String messageid) {
		SessionBean sessionBean = (SessionBean)param.get("sessionBean");
		SysMessage entity = (SysMessage) param.get("entity");
		Ywxtgzrwb ywxtgzrwb=new Ywxtgzrwb();
		String rwclsm="同意服务处所新增";
		ywxtgzrwb.setId(ywxtgzrwbid);
		if(flag.equals("1")){
//			sessionBean = (SessionBean)param.get("sessionBeanTemp");
			ywxtgzrwb.setCjjgdm("0");//0-接受1-拒绝2-共存
			ywxtgzrwb.setYwrwztdm("4");//协同任务状态代码0-待发起1－已发起2-已接收3-待裁决4－已裁决
			BaseService.setUpdateProperties(ywxtgzrwb, sessionBean);
			//BaseService.setSaveProperties(czrkxxb, sessionBean);
			ywxtgzrwbDao.updateYwxtgzrwbByCjr(ywxtgzrwb,sessionBean);
			OrgUser orguser=new OrgUser();
			orguser=orgUserService.queryByUserid(entity.getFsrdm());
			sessionBean=orgUserService.initSessionUser(orguser);
		}else{
			//修改业务协同任务表
			ywxtgzrwb.setRwcljgdm("0");//任务处理结果代码0-接受1-拒绝2-共存
			ywxtgzrwb.setRwclsm(rwclsm);
			ywxtgzrwb.setYwrwztdm("2");//协同任务状态代码0-待发起1－已发起2-已接收3-待裁决4－已裁决
			BaseService.setUpdateProperties(ywxtgzrwb, sessionBean);
			//BaseService.setSaveProperties(czrkxxb, sessionBean);
			ywxtgzrwbDao.updateYwxtgzrwbByClr(ywxtgzrwb,sessionBean);
		}
		//调用服务处所变更业务方法
		try {
			MethodUtils.invokeMethod(sysMessageService, methodName, new Object[]{
					//服务处所变更参数
					ryid, dwid, hslx, 
					sessionBean});
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//发送任务回执
		common_agree(param);
		return null;
	}

	@Override
	public Object fwcsxz_coexist(Map<String, Object> param, String flag, String methodName, 
			//实有人口核实参数
			String hsrwid, String hslx, String userid,
			//联系电话变更参数
			String ryid, String lxfslxdm, String lxfs,
			//从业人员变更参数
			/*ryid*/ String dwid,
			//服务处所变更参数
			/*ryid*/ String fwcsid, String fwcs, /*hslx*/
			String ywxtgzrwbid,
			String messageid) {
		SessionBean sessionBean = (SessionBean)param.get("sessionBean");
		Ywxtgzrwb ywxtgzrwb=new Ywxtgzrwb();
		ywxtgzrwb.setId(ywxtgzrwbid);
		String rwclsm="服务处所共存";
		ywxtgzrwb.setCjjgdm("2");//0-接受1-拒绝2-共存
		ywxtgzrwb.setYwrwztdm("4");//协同任务状态代码0-待发起1－已发起2-已接收3-待裁决4－已裁决
		BaseService.setUpdateProperties(ywxtgzrwb, sessionBean);
		//BaseService.setSaveProperties(czrkxxb, sessionBean);
		ywxtgzrwbDao.updateYwxtgzrwbByCjr(ywxtgzrwb,sessionBean);
		common_coexist(param);
		return null;
	}

	@Override
	public Object fwcsxz_refuse(Map<String, Object> param, String flag, String methodName, 
			//实有人口核实参数
			String hsrwid, String hslx, String userid,
			//联系电话变更参数
			String ryid, String lxfslxdm, String lxfs,
			//从业人员变更参数
			/*ryid*/ String dwid,
			//服务处所变更参数
			/*ryid*/ String fwcsid, String fwcs, /*hslx*/
			String ywxtgzrwbid,
			String messageid) {
		SessionBean sessionBean = (SessionBean)param.get("sessionBean");
		Ywxtgzrwb ywxtgzrwb=new Ywxtgzrwb();
		ywxtgzrwb.setId(ywxtgzrwbid);
		String rwclsm="拒绝服务处所新增";
		if(flag.equals("1")){
			ywxtgzrwb.setCjjgdm("1");//0-接受1-拒绝2-共存
			ywxtgzrwb.setYwrwztdm("4");//协同任务状态代码0-待发起1－已发起2-已接收3-待裁决4－已裁决
			BaseService.setUpdateProperties(ywxtgzrwb, sessionBean);
			//BaseService.setSaveProperties(czrkxxb, sessionBean);
			ywxtgzrwbDao.updateYwxtgzrwbByCjr(ywxtgzrwb,sessionBean);
			common_leader_refuse(param);
		}else{
			ywxtgzrwb.setRwcljgdm("1");//任务处理结果代码0-接受1-拒绝2-共存
			ywxtgzrwb.setRwclsm(rwclsm);
			ywxtgzrwb.setYwrwztdm("3");//协同任务状态代码0-待发起1－已发起2-已接收3-待裁决4－已裁决
			BaseService.setUpdateProperties(ywxtgzrwb, sessionBean);
			//BaseService.setSaveProperties(czrkxxb, sessionBean);
			ywxtgzrwbDao.updateYwxtgzrwbByClr(ywxtgzrwb,sessionBean);
			common_refuse(param);
		}
		return null;
	}
	
	/**
	 * 服务处所注销核实规则 -- 同意方法
	 * 参数：
	 * 1.ryid  人员id
	 * 2.fwcsid  服务处所id（单位id）
	 * 3.fwcs  服务处所（单位名称）
	 */
	@Override
	public Object fwcszx_agree(Map<String, Object> param, String flag, String methodName, 
			//实有人口核实参数
			String hsrwid, String hslx, String userid,
			//联系电话变更参数
			String ryid, String lxfslxdm, String lxfs,
			//从业人员变更参数
			/*ryid*/ String dwid,
			//服务处所变更/注销参数
			/*ryid*/ String fwcsid, String fwcs, /*hslx*/
			String ywxtgzrwbid,
			String messageid) {
		SessionBean sessionBean = (SessionBean)param.get("sessionBean");
		SysMessage entity = (SysMessage) param.get("entity");
		Ywxtgzrwb ywxtgzrwb=new Ywxtgzrwb();
		String rwclsm="同意服务处所注销";
		ywxtgzrwb.setId(ywxtgzrwbid);
		if(flag.equals("1")){
//			sessionBean = (SessionBean)param.get("sessionBeanTemp");
			ywxtgzrwb.setCjjgdm("0");//0-接受1-拒绝2-共存
			ywxtgzrwb.setYwrwztdm("4");//协同任务状态代码0-待发起1－已发起2-已接收3-待裁决4－已裁决
			BaseService.setUpdateProperties(ywxtgzrwb, sessionBean);
			//BaseService.setSaveProperties(czrkxxb, sessionBean);
			ywxtgzrwbDao.updateYwxtgzrwbByCjr(ywxtgzrwb,sessionBean);
			OrgUser orguser=new OrgUser();
			orguser=orgUserService.queryByUserid(entity.getFsrdm());
			sessionBean=orgUserService.initSessionUser(orguser);
		}else{
			//修改业务协同任务表
			ywxtgzrwb.setRwcljgdm("0");//任务处理结果代码0-接受1-拒绝2-共存
			ywxtgzrwb.setRwclsm(rwclsm);
			ywxtgzrwb.setYwrwztdm("2");//协同任务状态代码0-待发起1－已发起2-已接收3-待裁决4－已裁决
			BaseService.setUpdateProperties(ywxtgzrwb, sessionBean);
			//BaseService.setSaveProperties(czrkxxb, sessionBean);
			ywxtgzrwbDao.updateYwxtgzrwbByClr(ywxtgzrwb,sessionBean);
		}
		//调用服务处所注销业务方法
		try {
			MethodUtils.invokeMethod(sysMessageService, methodName, new Object[]{
					//服务处所变更参数
					ryid, dwid, hslx,
					sessionBean});
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//发送任务回执
		common_agree(param);
		return null;
	}

	@Override
	public Object fwcszx_coexist(Map<String, Object> param, String flag, String methodName, 
			//实有人口核实参数
			String hsrwid, String hslx, String userid,
			//联系电话变更参数
			String ryid, String lxfslxdm, String lxfs,
			//从业人员变更参数
			/*ryid*/ String dwid,
			//服务处所变更参数
			/*ryid*/ String fwcsid, String fwcs, /*hslx*/
			String ywxtgzrwbid,
			String messageid) {
		SessionBean sessionBean = (SessionBean)param.get("sessionBean");
		Ywxtgzrwb ywxtgzrwb=new Ywxtgzrwb();
		ywxtgzrwb.setId(ywxtgzrwbid);
		String rwclsm="服务处所共存";
		ywxtgzrwb.setCjjgdm("2");//0-接受1-拒绝2-共存
		ywxtgzrwb.setYwrwztdm("4");//协同任务状态代码0-待发起1－已发起2-已接收3-待裁决4－已裁决
		BaseService.setUpdateProperties(ywxtgzrwb, sessionBean);
		//BaseService.setSaveProperties(czrkxxb, sessionBean);
		ywxtgzrwbDao.updateYwxtgzrwbByCjr(ywxtgzrwb,sessionBean);
		common_coexist(param);
		return null;
	}

	@Override
	public Object fwcszx_refuse(Map<String, Object> param, String flag, String methodName, 
			//实有人口核实参数
			String hsrwid, String hslx, String userid,
			//联系电话变更参数
			String ryid, String lxfslxdm, String lxfs,
			//从业人员变更参数
			/*ryid*/ String dwid,
			//服务处所变更参数
			/*ryid*/ String fwcsid, String fwcs, /*hslx*/
			String ywxtgzrwbid,
			String messageid) {
		SessionBean sessionBean = (SessionBean)param.get("sessionBean");
		Ywxtgzrwb ywxtgzrwb=new Ywxtgzrwb();
		ywxtgzrwb.setId(ywxtgzrwbid);
		String rwclsm="拒绝服务处所注销";
		//调用服务处所注销业务方法
		if(flag.equals("1")){//上级【拒绝】【注销】
			ywxtgzrwb.setCjjgdm("1");//0-接受1-拒绝2-共存
			ywxtgzrwb.setYwrwztdm("4");//协同任务状态代码0-待发起1－已发起2-已接收3-待裁决4－已裁决
			BaseService.setUpdateProperties(ywxtgzrwb, sessionBean);
			//BaseService.setSaveProperties(czrkxxb, sessionBean);
			ywxtgzrwbDao.updateYwxtgzrwbByCjr(ywxtgzrwb,sessionBean);
			sessionBean = (SessionBean)param.get("sessionBeanTemp");
			try {
				MethodUtils.invokeMethod(sysMessageService, methodName, new Object[]{
						//服务处所变更参数
						ryid, dwid, hslx,
						sessionBean});
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			common_leader_refuse(param);
		}else{
			ywxtgzrwb.setRwcljgdm("1");//任务处理结果代码0-接受1-拒绝2-共存
			ywxtgzrwb.setRwclsm(rwclsm);
			ywxtgzrwb.setYwrwztdm("3");//协同任务状态代码0-待发起1－已发起2-已接收3-待裁决4－已裁决
			BaseService.setUpdateProperties(ywxtgzrwb, sessionBean);
			//BaseService.setSaveProperties(czrkxxb, sessionBean);
			ywxtgzrwbDao.updateYwxtgzrwbByClr(ywxtgzrwb,sessionBean);
			common_refuse(param);
		}
		return null;
	}

	/**
	 * flag=0
	 * &methodName=createSyrk
	 * &hsrwid="+srykhsrw.getId()+"
	 * &hslx=0
	 */
	@Override
	public Object syrkxz_agree(Map<String, Object> param, String flag, String methodName, 
			//实有人口核实参数
			String hsrwid, String hslx, String userid,
			//联系电话变更参数
			String ryid, String lxfslxdm, String lxfs,
			//从业人员变更参数
			/*ryid*/ String dwid,
			//服务处所变更参数
			/*ryid*/ String fwcsid, String fwcs, /*hslx*/
			String ywxtgzrwbid,
			String messageid){
		SessionBean sessionBean = (SessionBean)param.get("sessionBean");
		SysMessage entity = (SysMessage) param.get("entity");
		Ywxtgzrwb ywxtgzrwb=new Ywxtgzrwb();
		String rwclsm="同意实有人口新增";
		ywxtgzrwb.setId(ywxtgzrwbid);
		if(flag.equals("1")){
			ywxtgzrwb.setCjjgdm("0");//0-接受1-拒绝2-共存
			ywxtgzrwb.setYwrwztdm("4");//协同任务状态代码0-待发起1－已发起2-已接收3-待裁决4－已裁决
			BaseService.setUpdateProperties(ywxtgzrwb, sessionBean);
			//BaseService.setSaveProperties(czrkxxb, sessionBean);
			ywxtgzrwbDao.updateYwxtgzrwbByCjr(ywxtgzrwb,sessionBean);
			OrgUser orguser=new OrgUser();
			orguser=orgUserService.queryByUserid(entity.getFsrdm());
			sessionBean=orgUserService.initSessionUser(orguser);
		}else{
			//修改业务协同任务表
			ywxtgzrwb.setRwcljgdm("0");//任务处理结果代码0-接受1-拒绝2-共存
			ywxtgzrwb.setRwclsm(rwclsm);
			ywxtgzrwb.setYwrwztdm("2");//协同任务状态代码0-待发起1－已发起2-已接收3-待裁决4－已裁决
			BaseService.setUpdateProperties(ywxtgzrwb, sessionBean);
			//BaseService.setSaveProperties(czrkxxb, sessionBean);
			ywxtgzrwbDao.updateYwxtgzrwbByClr(ywxtgzrwb,sessionBean);
		}
		try {
			MethodUtils.invokeMethod(sysMessageService, methodName, new Object[]{
					//实有人口核实参数
					hsrwid, hslx, 
					messageid, sessionBean});
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//发送同意方法回执
		common_agree(param);
		return null;
	}

	@Override
	public Object syrkxz_coexist(Map<String, Object> param, String flag, String methodName, 
			//实有人口核实参数
			String hsrwid, String hslx, String userid,
			//联系电话变更参数
			String ryid, String lxfslxdm, String lxfs,
			//从业人员变更参数
			/*ryid*/ String dwid,
			//服务处所变更参数
			/*ryid*/ String fwcsid, String fwcs, /*hslx*/
			String ywxtgzrwbid,
			String messageid) {
		SessionBean sessionBean = (SessionBean)param.get("sessionBean");
		Ywxtgzrwb ywxtgzrwb=new Ywxtgzrwb();
		ywxtgzrwb.setId(ywxtgzrwbid);
		String rwclsm="实有人口共存";
		ywxtgzrwb.setCjjgdm("2");//0-接受1-拒绝2-共存
		ywxtgzrwb.setYwrwztdm("4");//协同任务状态代码0-待发起1－已发起2-已接收3-待裁决4－已裁决
		BaseService.setUpdateProperties(ywxtgzrwb, sessionBean);
		//BaseService.setSaveProperties(czrkxxb, sessionBean);
		ywxtgzrwbDao.updateYwxtgzrwbByCjr(ywxtgzrwb,sessionBean);
		common_coexist(param);
		return null;
	}

	@Override
	public Object syrkxz_refuse(Map<String, Object> param, String flag, String methodName, 
			//实有人口核实参数
			String hsrwid, String hslx, String userid,
			//联系电话变更参数
			String ryid, String lxfslxdm, String lxfs,
			//从业人员变更参数
			/*ryid*/ String dwid,
			//服务处所变更参数
			/*ryid*/ String fwcsid, String fwcs, /*hslx*/
			String ywxtgzrwbid,
			String messageid) {
		SessionBean sessionBean = (SessionBean)param.get("sessionBean");
		Ywxtgzrwb ywxtgzrwb=new Ywxtgzrwb();
		ywxtgzrwb.setId(ywxtgzrwbid);
		String rwclsm="拒绝实有人口新增";
		if(flag.equals("1")){
			ywxtgzrwb.setCjjgdm("1");//0-接受1-拒绝2-共存
			ywxtgzrwb.setYwrwztdm("4");//协同任务状态代码0-待发起1－已发起2-已接收3-待裁决4－已裁决
			BaseService.setUpdateProperties(ywxtgzrwb, sessionBean);
			//BaseService.setSaveProperties(czrkxxb, sessionBean);
			ywxtgzrwbDao.updateYwxtgzrwbByCjr(ywxtgzrwb,sessionBean);
			common_leader_refuse(param);
		}else{
			ywxtgzrwb.setRwcljgdm("1");//任务处理结果代码0-接受1-拒绝2-共存
			ywxtgzrwb.setRwclsm(rwclsm);
			ywxtgzrwb.setYwrwztdm("3");//协同任务状态代码0-待发起1－已发起2-已接收3-待裁决4－已裁决
			BaseService.setUpdateProperties(ywxtgzrwb, sessionBean);
			//BaseService.setSaveProperties(czrkxxb, sessionBean);
			ywxtgzrwbDao.updateYwxtgzrwbByClr(ywxtgzrwb,sessionBean);
			common_refuse(param);
		}
		return null;
	}

	/**
	 * 实有人口注销核实 -- 同意方法
	 */
	@Override
	public Object syrkzx_agree(Map<String, Object> param, String flag, String methodName, 
			//实有人口核实参数
			String hsrwid, String hslx, String userid,
			//联系电话变更参数
			String ryid, String lxfslxdm, String lxfs,
			//从业人员变更参数
			/*ryid*/ String dwid,
			//服务处所变更参数
			/*ryid*/ String fwcsid, String fwcs, /*hslx*/
			String ywxtgzrwbid,
			String messageid) {
		SessionBean sessionBean = (SessionBean)param.get("sessionBean");
		SysMessage entity = (SysMessage) param.get("entity");
		Ywxtgzrwb ywxtgzrwb=new Ywxtgzrwb();
		String rwclsm="同意实有人口注销";
		ywxtgzrwb.setId(ywxtgzrwbid);
		if(flag.equals("1")){//上级【同意】【注销】任务时，注销任务接收人辖区的该实有人口
			ywxtgzrwb.setCjjgdm("0");//0-接受1-拒绝2-共存
			ywxtgzrwb.setYwrwztdm("4");//协同任务状态代码0-待发起1－已发起2-已接收3-待裁决4－已裁决
			BaseService.setUpdateProperties(ywxtgzrwb, sessionBean);
			//BaseService.setSaveProperties(czrkxxb, sessionBean);
			ywxtgzrwbDao.updateYwxtgzrwbByCjr(ywxtgzrwb,sessionBean);
			OrgUser orguser=new OrgUser();
			orguser=orgUserService.queryByUserid(entity.getFsrdm());
			sessionBean=orgUserService.initSessionUser(orguser);
		}else{
			//修改业务协同任务表
			ywxtgzrwb.setRwcljgdm("0");//任务处理结果代码0-接受1-拒绝2-共存
			ywxtgzrwb.setRwclsm(rwclsm);
			ywxtgzrwb.setYwrwztdm("2");//协同任务状态代码0-待发起1－已发起2-已接收3-待裁决4－已裁决
			BaseService.setUpdateProperties(ywxtgzrwb, sessionBean);
			//BaseService.setSaveProperties(czrkxxb, sessionBean);
			ywxtgzrwbDao.updateYwxtgzrwbByClr(ywxtgzrwb,sessionBean);
		}
		try {
			MethodUtils.invokeMethod(sysMessageService, methodName, new Object[]{
					//实有人口核实参数
					hsrwid, hslx, 
					messageid, sessionBean});
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//发送同意方法回执
		common_agree(param);
		return null;
	}

	@Override
	public Object syrkzx_coexist(Map<String, Object> param, String flag, String methodName, 
			//实有人口核实参数
			String hsrwid, String hslx, String userid,
			//联系电话变更参数
			String ryid, String lxfslxdm, String lxfs,
			//从业人员变更参数
			/*ryid*/ String dwid,
			//服务处所变更参数
			/*ryid*/ String fwcsid, String fwcs, /*hslx*/
			String ywxtgzrwbid,
			String messageid) {
		SessionBean sessionBean = (SessionBean)param.get("sessionBean");
		Ywxtgzrwb ywxtgzrwb=new Ywxtgzrwb();
		ywxtgzrwb.setId(ywxtgzrwbid);
		String rwclsm="实有人口共存";
		ywxtgzrwb.setCjjgdm("2");//0-接受1-拒绝2-共存
		ywxtgzrwb.setYwrwztdm("4");//协同任务状态代码0-待发起1－已发起2-已接收3-待裁决4－已裁决
		BaseService.setUpdateProperties(ywxtgzrwb, sessionBean);
		//BaseService.setSaveProperties(czrkxxb, sessionBean);
		ywxtgzrwbDao.updateYwxtgzrwbByCjr(ywxtgzrwb,sessionBean);
		common_coexist(param);
		return null;
	}

	@Override
	public Object syrkzx_refuse(Map<String, Object> param, String flag, String methodName, 
			//实有人口核实参数
			String hsrwid, String hslx, String userid,
			//联系电话变更参数
			String ryid, String lxfslxdm, String lxfs,
			//从业人员变更参数
			/*ryid*/ String dwid,
			//服务处所变更参数
			/*ryid*/ String fwcsid, String fwcs, /*hslx*/
			String ywxtgzrwbid,
			String messageid) {
		SessionBean sessionBean = (SessionBean)param.get("sessionBean");
		Ywxtgzrwb ywxtgzrwb=new Ywxtgzrwb();
		ywxtgzrwb.setId(ywxtgzrwbid);
		String rwclsm="拒绝实有人口注销";
		if(flag.equals("1")){//上级【拒绝】【注销】任务时，注销任务第一发起人辖区的该实有人口
			ywxtgzrwb.setCjjgdm("1");//0-接受1-拒绝2-共存
			ywxtgzrwb.setYwrwztdm("4");//协同任务状态代码0-待发起1－已发起2-已接收3-待裁决4－已裁决
			BaseService.setUpdateProperties(ywxtgzrwb, sessionBean);
			//BaseService.setSaveProperties(czrkxxb, sessionBean);
			ywxtgzrwbDao.updateYwxtgzrwbByCjr(ywxtgzrwb,sessionBean);
			sessionBean = (SessionBean)param.get("sessionBeanTemp");
			try {
				MethodUtils.invokeMethod(sysMessageService, methodName, new Object[]{
						//实有人口核实参数
						hsrwid, hslx, 
						messageid, sessionBean});
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			common_leader_refuse(param);
		}else{
			ywxtgzrwb.setRwcljgdm("1");//任务处理结果代码0-接受1-拒绝2-共存
			ywxtgzrwb.setRwclsm(rwclsm);
			ywxtgzrwb.setYwrwztdm("3");//协同任务状态代码0-待发起1－已发起2-已接收3-待裁决4－已裁决
			BaseService.setUpdateProperties(ywxtgzrwb, sessionBean);
			//BaseService.setSaveProperties(czrkxxb, sessionBean);
			ywxtgzrwbDao.updateYwxtgzrwbByClr(ywxtgzrwb,sessionBean);
			common_refuse(param);
		}
		return null;
	}

	@Override
	public Object common_agree(Map<String, Object> param) {
		SysMessage sysMsg = new SysMessage();
		SessionBean sessionBean = (SessionBean) param.get("sessionBean");
		SysMessage entity = (SysMessage) param.get("entity");
		sysMsg.setFsr(sessionBean.getUserName());
		sysMsg.setFsrdm(sessionBean.getUserId());
		sysMsg.setFsrssdw(sessionBean.getUserOrgName());
		sysMsg.setFsrssdwdm(sessionBean.getUserOrgCode());
		sysMsg.setFssj(DateUtils.getSystemDateTimeString());
		sysMsg.setYwurl("");
		sysMsg.setSfck("0");
		sysMsg.setXxlb("1");
		String xxnr = "";
		xxnr = "【"+ entity.getXxbt() +" 回执】你发起的 "+ entity.getXxbt() +" 核实成功，谢谢！";
		sysMsg.setXxnr(xxnr);
		sysMessageDao.saveMessageByUser(sysMsg, entity.getFsrdm());
		if(param.get("flag") != null && param.get("flag").toString().equals("1")){//当前为上级处理
			SessionBean sessionBeanTemp = param.get("sessionBeanTemp") != null ? (SessionBean)param.get("sessionBeanTemp") : null;
			//向第一次发送人发送回执
			sysMessageDao.saveMessageByOrg(sysMsg, sessionBeanTemp != null ? sessionBeanTemp.getUserOrgCode() : null, false, false);
		}
		//更新任务查看状态
		ywxtRuleDao.updateMessageSfck(entity.getId());
		return null;
	}

	@Override
	public Object common_coexist(Map<String, Object> param) {
		SysMessage sysMsg = new SysMessage();
		SessionBean sessionBean = (SessionBean) param.get("sessionBean");
		SysMessage entity = (SysMessage) param.get("entity");
		sysMsg.setFsr(sessionBean.getUserName());
		sysMsg.setFsrdm(sessionBean.getUserId());
		sysMsg.setFsrssdw(sessionBean.getUserOrgName());
		sysMsg.setFsrssdwdm(sessionBean.getUserOrgCode());
		sysMsg.setFssj(DateUtils.getSystemDateTimeString());
		sysMsg.setSfck("0");
		sysMsg.setXxlb("1");
		String xxnr = "";
		xxnr = "【"+ entity.getXxbt() +" 回执】你发起的 "+ entity.getXxbt() +" 经核实共存，谢谢！";
		sysMsg.setXxnr(xxnr);
		sysMessageDao.saveMessageByUser(sysMsg, entity.getFsrdm());
		SessionBean sessionBeanTemp = param.get("sessionBeanTemp") != null ? (SessionBean)param.get("sessionBeanTemp") : null;
		//向第一次发送人发送回执
		sysMessageDao.saveMessageByOrg(sysMsg, sessionBeanTemp != null ? sessionBeanTemp.getUserOrgCode() : null, false, false);
		//更新任务查看状态
		ywxtRuleDao.updateMessageSfck(entity.getId());
		return null;
	}

	@Override
	public Object common_refuse(Map<String, Object> param) {
//		SysMessage sysMsg = new SysMessage();
		SessionBean sessionBean = (SessionBean) param.get("sessionBean");
		SysMessage entity = (SysMessage) param.get("entity");
		String fsr=entity.getFsr();
		String fsrdm=entity.getFsrdm();
		String fsrssdw=entity.getFsrssdw();
		String fsrssdwdm=entity.getFsrssdwdm();
		String xxnrTmp = entity.getXxnr();
		String ywurl=entity.getYwurl();
		String url=ywurl;
		if(ywurl.indexOf("&messageid")>0){
			ywurl=ywurl.substring(0,url.indexOf("&messageid"));
		}
		String url1=ywurl;
		if(url1.indexOf("0&businessName")>0){
			String a=ywurl.substring(0,url1.indexOf("0&businessName"));
			String b=ywurl.substring(url.indexOf("&businessName"));
//			ywurl=ywurl.substring(0,url.indexOf("&messageid"));
			ywurl=a+"1"+b;
		}
		
		entity.setFsr(sessionBean.getUserName());
		entity.setFsrdm(sessionBean.getUserId());
		entity.setFsrssdw(sessionBean.getUserOrgName());
		entity.setFsrssdwdm(sessionBean.getUserOrgCode());
		entity.setFssj(DateUtils.getSystemDateTimeString());
		entity.setJsr(fsr);
		entity.setJsrdm(fsrdm);
		entity.setJsrssdw(fsrssdw);
		entity.setJsrssdwdm(fsrssdwdm);
		entity.setSfck("0");
		entity.setXxlb("1");
		entity.setYwurl("");
		String xxnr = "";
		xxnr = "【"+ entity.getXxbt() +" 回执】你发起的 "+ entity.getXxbt() +" 核实失败，将交上级部门裁决，请知晓！";
		entity.setXxnr(xxnr);
		sysMessageDao.saveMessageByUser(entity, entity.getJsrdm());
		//获取共同上级部门代码
		String fsrbmdm = fsrssdwdm;
		String jsrbmdm = sessionBean.getUserOrgCode();
		Map<String, String> fsrsjbmdm = ywxtRuleDao.getLeaderOrgcode(fsrbmdm);
		Map<String, String> jsrsjbmdm = ywxtRuleDao.getLeaderOrgcode(jsrbmdm);
		if(!fsrsjbmdm.get("ORGLEVEL").equals(jsrsjbmdm.get("ORGLEVEL"))){//部门级别不同，对级别低的部门再次向上查找知道级别相同
			if(fsrsjbmdm.get("ORGLEVEL") != null && jsrsjbmdm.get("ORGLEVEL") != null){
				if(Integer.parseInt(fsrsjbmdm.get("ORGLEVEL")) > Integer.parseInt(jsrsjbmdm.get("ORGLEVEL"))){
					fsrsjbmdm = ywxtRuleDao.getLeaderOrgcode(fsrsjbmdm.get("ORGCODE"));
					if(Integer.parseInt(fsrsjbmdm.get("ORGLEVEL")) > Integer.parseInt(jsrsjbmdm.get("ORGLEVEL"))){
						fsrsjbmdm = ywxtRuleDao.getLeaderOrgcode(fsrsjbmdm.get("ORGCODE"));
					}
					if(Integer.parseInt(fsrsjbmdm.get("ORGLEVEL")) > Integer.parseInt(jsrsjbmdm.get("ORGLEVEL"))){
						fsrsjbmdm = ywxtRuleDao.getLeaderOrgcode(fsrsjbmdm.get("ORGCODE"));
					}
					if(Integer.parseInt(fsrsjbmdm.get("ORGLEVEL")) > Integer.parseInt(jsrsjbmdm.get("ORGLEVEL"))){
						fsrsjbmdm = ywxtRuleDao.getLeaderOrgcode(fsrsjbmdm.get("ORGCODE"));
					}
				}else{
					jsrsjbmdm = ywxtRuleDao.getLeaderOrgcode(jsrsjbmdm.get("ORGCODE"));
					if(Integer.parseInt(jsrsjbmdm.get("ORGLEVEL")) > Integer.parseInt(fsrsjbmdm.get("ORGLEVEL"))){
						jsrsjbmdm = ywxtRuleDao.getLeaderOrgcode(jsrsjbmdm.get("ORGCODE"));
					}
					if(Integer.parseInt(jsrsjbmdm.get("ORGLEVEL")) > Integer.parseInt(fsrsjbmdm.get("ORGLEVEL"))){
						jsrsjbmdm = ywxtRuleDao.getLeaderOrgcode(jsrsjbmdm.get("ORGCODE"));
					}
					if(Integer.parseInt(jsrsjbmdm.get("ORGLEVEL")) > Integer.parseInt(fsrsjbmdm.get("ORGLEVEL"))){
						jsrsjbmdm = ywxtRuleDao.getLeaderOrgcode(jsrsjbmdm.get("ORGCODE"));
					}
				}
			}
		}
		if(!fsrsjbmdm.get("ORGCODE").equals(jsrsjbmdm.get("ORGCODE"))){//上级部门不同
			fsrsjbmdm = ywxtRuleDao.getLeaderOrgcode(fsrsjbmdm.get("ORGCODE"));
			jsrsjbmdm = ywxtRuleDao.getLeaderOrgcode(jsrsjbmdm.get("ORGCODE"));
		}
		if(!fsrsjbmdm.get("ORGCODE").equals(jsrsjbmdm.get("ORGCODE"))){//第二次向上级查询，上级部门仍然不相同
			fsrsjbmdm = ywxtRuleDao.getLeaderOrgcode(fsrsjbmdm.get("ORGCODE"));
			jsrsjbmdm = ywxtRuleDao.getLeaderOrgcode(jsrsjbmdm.get("ORGCODE"));
		}if(!fsrsjbmdm.get("ORGCODE").equals(jsrsjbmdm.get("ORGCODE"))){//第三次向上级查询，上级部门仍然不相同
			
		}else{//上级部门相同，向上级发送消息
			entity.setXxlb("2");
			xxnrTmp="由"+entity.getFsr()+"发起的内容为：\""+entity.getXxbt()+"\"的任务经核实实际情况并不属实，请您决定";
			entity.setXxnr(xxnrTmp);
			entity.setYwurl(ywurl);
			sysMessageDao.saveMessageByOrg(entity, fsrsjbmdm.get("ORGCODE"), false, false);
		}
		//更新任务查看状态
		ywxtRuleDao.updateMessageSfck(entity.getId());
		return null;
	}
	
	public Object common_leader_refuse(Map<String, Object> param) {
		SessionBean sessionBean = (SessionBean) param.get("sessionBean");
		SysMessage entity = (SysMessage) param.get("entity");
		
		String fsr = entity.getFsr();
		String fsrdm = entity.getFsrdm();
		String fsrssdw = entity.getFsrssdw();
		String fsrssdwdm = entity.getFsrssdw();
		
		//向下级接收方发送
		entity.setFsr(sessionBean.getUserName());
		entity.setFsrdm(sessionBean.getUserId());
		entity.setFsrssdw(sessionBean.getUserOrgName());
		entity.setFsrssdwdm(sessionBean.getUserOrgCode());
		entity.setFssj(DateUtils.getSystemDateTimeString());
		entity.setJsr(fsr);
		entity.setJsrdm(fsrdm);
		entity.setJsrssdw(fsrssdw);
		entity.setJsrssdwdm(fsrssdwdm);
		entity.setSfck("0");
		entity.setXxlb("1");
		entity.setYwurl("");
		String xxnr = "";
		xxnr = "【"+ entity.getXxbt() +" 回执】你发起的 "+ entity.getXxbt() +" 经上级核实拒绝，请知晓！";
		entity.setXxnr(xxnr);
		sysMessageDao.saveMessageByUser(entity, fsrdm);
		SessionBean sessionBeanTemp = param.get("sessionBeanTemp") != null ? (SessionBean)param.get("sessionBeanTemp") : null;
		//向第一次发送人发送回执
		sysMessageDao.saveMessageByOrg(entity, sessionBeanTemp != null ? sessionBeanTemp.getUserOrgCode() : null, false, false);
		ywxtRuleDao.updateMessageSfck(entity.getId());
		return null;
	}
	
	

	@Override
	public SysMessage getMessageById(Long id) {
		SysMessage entity = new SysMessage();
		entity.setId(id);
		return sysMessageDao.query(entity);
	}
	
}
