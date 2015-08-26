package com.founder.ggfw.controller;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.apache.commons.beanutils.MethodUtils;

import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.message.bean.SysMessage;
import com.founder.framework.organization.user.bean.OrgUser;
import com.founder.framework.organization.user.service.OrgUserService;
import com.founder.ggfw.service.YwxtRuleService;
import com.founder.ggfw.service.YwxtgzrwbService;

@Controller
@RequestMapping(value = "/ywxtgzrwb")
public class YwxtgzrwbController extends BaseController {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource(name = "ywxtgzrwbService")
	private YwxtgzrwbService ywxtgzrwbService;
	@Resource(name = "ywxtRuleService")
	private YwxtRuleService ywxtRuleService;
	@Resource(name = "orgUserService")
	private OrgUserService orgUserService;
	
	/**
	 * 向协同任务处理页面的请求转发
	 * @param operType        操作类型：   	"_agree" 同意 / "_refuse" 拒绝 / "_conexist" 共存
	 * @param flag            发送类型：   	0:第一次发送任务   1：第二次发送任务（由【拒绝】操作发送到共同上级）
	 * @param businessName    业务代码：   	反射到规则service的对应方法， eg："syrkxz" "syrkzx" "lxdh" "cyry" "fwcs"
	 * @param methodName      业务方法：   	反射到业务service的对应方法， eg："createSyrk"
	 * @param hsrwid		  核实任务id：   核实任务表主键，针对【实有人口新增核实】、【实有人口注销核实】业务
	 * @param hslx			  核实类型：     0：实有人口新增核实，1：实有人口注销核实，针对【实有人口新增核实】、【实有人口注销核实】业务
	 * @param messageid		  消息id：       消息表主键
	 * @return
	 */
	@RequestMapping(value = "/ywxtgzrwbView", method = RequestMethod.GET)
	public ModelAndView ywxtgzrwbView(String operType, String flag, String businessName, String methodName, 
			//实有人口核实参数
			String hsrwid, String hslx, String userid,
			//联系电话变更参数
			String ryid, String lxfslxdm, String lxfs,
			//从业人员变更参数
			/*ryid*/ String dwid,
			//服务处所变更参数
			/*ryid*/ String fwcsid, String fwcs, /*hslx*/
			//业务协同工作任务id
			String ywxtgzrwbid,
			String messageid){
		ModelAndView mv = new ModelAndView("ggfw/ywxtgzrwbView");
		try {
			SysMessage entity = ywxtgzrwbService.queryYwxtgzrwbById(messageid);
			mv.addObject("entity", entity);
			mv.addObject("operType", operType);
			mv.addObject("flag", flag);
			mv.addObject("businessName", businessName);
			mv.addObject("methodName", methodName);
			mv.addObject("hsrwid", hsrwid);
			mv.addObject("hslx", hslx);
			mv.addObject("userid", userid);
			mv.addObject("ryid", ryid);
			mv.addObject("lxfslxdm", lxfslxdm);
			mv.addObject("lxfs", lxfs);
			mv.addObject("dwid", dwid);
			mv.addObject("fwcsid", fwcsid);
			mv.addObject("fwcs", fwcs);
			mv.addObject("ywxtgzrwbid", ywxtgzrwbid);
			mv.addObject("messageid", messageid);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("查询【业务协同规则任务表】失败！", e);
		}
		return mv;
	}
	
	/**
	 * 执行业务协同规则的（同意、拒绝、共存）方法
	 * @param operType        操作类型：   	"_agree" 同意 / "_refuse" 拒绝 / "_conexist" 共存
	 * @param flag            发送类型：   	0:第一次发送任务   1：第二次发送任务（由【拒绝】操作发送到共同上级）
	 * @param businessName    业务代码：   	反射到规则service的对应方法， eg："syrkxz" "syrkzx" "lxdh" "cyry" "fwcs"
	 * @param methodName      业务方法：   	反射到业务service的对应方法， eg："createSyrk"
	 * @param hsrwid		  核实任务id：   核实任务表主键，针对【实有人口新增核实】、【实有人口注销核实】业务
	 * @param hslx			  核实类型：     0：实有人口新增核实，1：实有人口注销核实，针对【实有人口新增核实】、【实有人口注销核实】业务
	 * @param messageid		  消息id：       消息表主键
	 * @return
	 */
	@RequestMapping(value = "/executeRuleMethod", method=RequestMethod.POST)
	public ModelAndView executeRuleMethod(String operType, String flag, String businessName, String methodName, 
			//实有人口核实参数
			String hsrwid, String hslx, String userid,
			//联系电话变更参数
			String ryid, String lxfslxdm, String lxfs,
			//从业人员变更参数
			/*ryid*/ String dwid,
			//服务处所变更参数
			/*ryid*/ String fwcsid, String fwcs, /*hslx*/
			//业务协同工作任务id
			String ywxtgzrwbid,
			String messageid, SysMessage entity){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("sessionBean", getSessionBean());
		entity = ywxtRuleService.getMessageById(Long.parseLong(messageid));
		param.put("entity", entity);
		param.put("userid", userid);
		param.put("flag", flag);
		if(flag.equals("1")){//上级处理
			//获取并传递第一次发起人的sessionBean
			OrgUser orguser=new OrgUser();
			orguser=orgUserService.queryByUserid(userid);
			SessionBean ysessionBean=orgUserService.initSessionUser(orguser);
			param.put("sessionBeanTemp", ysessionBean);
		}
		try {
			MethodUtils.invokeMethod(ywxtRuleService, businessName + operType, new Object[]{param, flag, methodName, 
					//实有人口核实参数
					hsrwid, hslx, userid,
					//联系电话变更参数
					ryid, lxfslxdm, lxfs,
					//从业人员变更参数
					/*ryid*/ dwid,
					//服务处所变更参数
					/*ryid*/ fwcsid, fwcs, /*hslx*/	
					//业务协同工作任务id
					ywxtgzrwbid,
					messageid});
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args){
		try {
			Class<?> classType = Class.forName("com.founder.framework.message.dao.SysMessageDao");
			Object instance = classType.newInstance();
			Method[] methods = classType.getDeclaredMethods();
			for(Method method : methods){
				if("testMethod".equals(method.getName())){
					method.invoke(instance, new Object[]{"testParam"});
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 向协同任务处理页面的请求转发
	 * @param operType        操作类型：   	"_agree" 同意 / "_refuse" 拒绝 / "_conexist" 共存
	 * @param flag            发送类型：   	0:第一次发送任务   1：第二次发送任务（由【拒绝】操作发送到共同上级）
	 * @param businessName    业务代码：   	反射到规则service的对应方法， eg："syrkxz" "syrkzx" "lxdh" "cyry" "fwcs"
	 * @param methodName      业务方法：   	反射到业务service的对应方法， eg："createSyrk"
	 * @param hsrwid		  核实任务id：   核实任务表主键，针对【实有人口新增核实】、【实有人口注销核实】业务
	 * @param hslx			  核实类型：     0：实有人口新增核实，1：实有人口注销核实，针对【实有人口新增核实】、【实有人口注销核实】业务
	 * @param messageid		  消息id：       消息表主键
	 * @return
	 */
	@RequestMapping(value = "/ywxtgzrwbViews", method = RequestMethod.GET)
	public 
		ModelAndView ywxtgzrwbView(String id){
		ModelAndView mv = new ModelAndView("dbrw/backMsg");
		try {
			SysMessage entity = ywxtgzrwbService.queryYwxtgzrwbById(id);
			mv.addObject("entity", entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	

}
