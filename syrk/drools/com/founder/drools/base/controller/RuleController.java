package com.founder.drools.base.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.founder.drools.core.inteface.RuleService;
import com.founder.drools.core.model.RuleConfig;
import com.founder.framework.annotation.RestfulAnnotation;
import com.founder.framework.base.controller.BaseController;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zdrygl.base.message.MessageDict;
import com.founder.zdrygl.core.inteface.SysMessageInfoService;
import com.founder.zdrygl.core.model.SysMessage;
import com.founder.zdrygl.core.utils.ZdryConstant;
/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.base.controller.RuleTestController.java]  
 * @ClassName:    [RuleTestController]   
 * @Description:  [规则引擎测试控制器]   
 * @Author:       [zhang.hai@founder.com.cn]  
 * @CreateDate:   [2015年10月14日 下午2:34:49]   
 * @UpdateUser:   [ZhangHai(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年10月14日 下午2:34:49，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Controller
@RequestMapping("ruleSys")
public class RuleController extends BaseController {					
	
	@Autowired
	private RuleService ruleService;
	
	@Resource
	private SysMessageInfoService sysMessageInfoService;
	
	@Autowired
	private ZdryConstant zdryConstant;

	@RestfulAnnotation(valiField = "zdrygllx", serverId = "3")
	@RequestMapping(value = "/getZdrylx", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody String getZdrylx(String zdrygllx){
		
		return zdryConstant.getValueOfZdryDict(zdrygllx);
	}
	
	/**
	 * 
	 * @Title: test
	 * @Description: TODO(规则引擎测试)
	 * @param @param sessionBean
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throw
	 */
	@RestfulAnnotation(serverId="3")
	@RequestMapping(value = "/test", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView test(String ruleModule,SessionBean sessionBean){
		ModelAndView mv = new ModelAndView("drools/"+ruleModule);
		sessionBean = getSessionBean(sessionBean);
		if("MESSAGE_ZDRYGL".equals(ruleModule)){
			mv.addObject("List",getMessageTestList(sessionBean));
		}
		return mv;
	
	}		
	
	private List getMessageTestList(SessionBean sessionBean){
		List list=new LinkedList();
		
		//通过规则引擎获取消息
		
		Object paraObj_LGSQ = getMessageParam(MessageDict.ZDRYGL.LGSQ,sessionBean);//获取消息的参数
		SysMessage sysMessage_LGSQ = sysMessageInfoService.initSysMessage(MessageDict.ZDRYGL.LGSQ, paraObj_LGSQ);		 		
		list.add(sysMessage_LGSQ);		
		
		
		Object paraObj_LGSPJG = getMessageParam(MessageDict.ZDRYGL.LGSPJG,sessionBean);//获取消息的参数
		SysMessage sysMessage_LGSPJG = sysMessageInfoService.initSysMessage(MessageDict.ZDRYGL.LGSPJG, paraObj_LGSPJG);		 		
		list.add(sysMessage_LGSPJG);
		
		Object paraObj_CGSQ = getMessageParam(MessageDict.ZDRYGL.CGSQ,sessionBean);//获取消息的参数
		SysMessage sysMessage_CGSQ = sysMessageInfoService.initSysMessage(MessageDict.ZDRYGL.CGSQ, paraObj_CGSQ);		 		
		list.add(sysMessage_CGSQ);
		
		Object paraObj_CGSPJG = getMessageParam(MessageDict.ZDRYGL.CGSPJG,sessionBean);//获取消息的参数
		SysMessage sysMessage_CGSPJG = sysMessageInfoService.initSysMessage(MessageDict.ZDRYGL.CGSPJG, paraObj_CGSPJG);		 		
		list.add(sysMessage_CGSPJG);
		
		Object paraObj_ZDSQ = getMessageParam(MessageDict.ZDRYGL.ZDSQ,sessionBean);//获取消息的参数
		SysMessage sysMessage_ZDSQ = sysMessageInfoService.initSysMessage(MessageDict.ZDRYGL.ZDSQ, paraObj_ZDSQ);		 		
		list.add(sysMessage_ZDSQ);
		
		Object paraObj_JSZD = getMessageParam(MessageDict.ZDRYGL.JSZD,sessionBean);//获取消息的参数
		SysMessage sysMessage_JSZD = sysMessageInfoService.initSysMessage(MessageDict.ZDRYGL.JSZD, paraObj_JSZD);		 		
		list.add(sysMessage_JSZD);
		
		Object paraObj_BJSZD = getMessageParam(MessageDict.ZDRYGL.BJSZD,sessionBean);//获取消息的参数
		SysMessage sysMessage_BJSZD = sysMessageInfoService.initSysMessage(MessageDict.ZDRYGL.BJSZD, paraObj_BJSZD);		 		
		list.add(sysMessage_BJSZD);
		
		Object paraObj_SJCDJG = getMessageParam(MessageDict.ZDRYGL.SJCDJG,sessionBean);//获取消息的参数
		SysMessage sysMessage_SJCDJG = sysMessageInfoService.initSysMessage(MessageDict.ZDRYGL.SJCDJG, paraObj_SJCDJG);		 		
		list.add(sysMessage_SJCDJG);
		
		Object paraObj_ZLSQ = getMessageParam(MessageDict.ZDRYGL.ZLSQ,sessionBean);//获取消息的参数
		SysMessage sysMessage_ZLSQ = sysMessageInfoService.initSysMessage(MessageDict.ZDRYGL.ZLSQ, paraObj_ZLSQ);		 		
		list.add(sysMessage_ZLSQ);
		
		Object paraObj_ZLSPJG = getMessageParam(MessageDict.ZDRYGL.ZLSPJG,sessionBean);//获取消息的参数
		SysMessage sysMessage_ZLSPJG = sysMessageInfoService.initSysMessage(MessageDict.ZDRYGL.ZLSPJG, paraObj_ZLSPJG);		 		
		list.add(sysMessage_ZLSPJG);
		
		return list;
	}
	
	/**
	 * 
	 * @Title: getMessageParam
	 * @Description: TODO(获取消息生产需要的参数)
	 * @param @param xxlx
	 * @param @param paraObj
	 * @param @return    设定文件
	 * @return Object    返回类型
	 * @throw
	 */
	private Object getMessageParam(String xxlx,SessionBean sessionBean){
		Map<String,Object> paramMap = new HashMap<String,Object>();
		//公共参数处理
//        Map<String,Object> globalParam = new HashMap<String,Object>();
//        globalParam.put("zdryZdryzbDao", zdryZdryZbDao);
//        paramMap.put("globalParam", globalParam);
        
        //私有参数处理
        Map<String,Object> paramObj = new HashMap<String,Object>();
        paramObj.put("fsrName", sessionBean.getUserName());//发送人姓名
        paramObj.put("fsrUserCode", sessionBean.getUserId());//发送人代码	
        paramObj.put("fsrOrgName", sessionBean.getUserOrgName());//发送人机构名
        paramObj.put("zdrylxName","zdrylxName");
        paramObj.put("zdryName","zdryName");
        paramMap.put("paramObj", paramObj);
        
        return paramMap;
	}
	
	/**
	 * 
	 * @Title: manager
	 * @Description: TODO(规则管理列表)
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throw
	 */	
	@RequestMapping(value = "/manager", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView manager(){			
		ModelAndView mv = new ModelAndView("drools/ruleManager");		
		return mv;	
	}	
	
	@RequestMapping(value = "/getManageList", method = RequestMethod.POST)
	public @ResponseBody EasyUIPage getManageList(EasyUIPage page,@RequestParam(value = "rows", required = false) Integer rows) {
		Map<String, RuleConfig> ruleConfigMap = ruleService.getRuleConfigMap();
		if(ruleConfigMap==null){
			if(ruleService.init())
				ruleConfigMap = ruleService.getRuleConfigMap();
		}
		
		
		List list=new LinkedList();
		if(ruleConfigMap!=null){
			Object[] objAry = ruleConfigMap.keySet().toArray();				
			for(int i=0;i<objAry.length;i++){
				Map map=new HashMap();
				map.put("key", objAry[i]);
				map.put("value", ruleConfigMap.get(objAry[i]).getUrl());
				list.add(map);
			}
		}
		page.setRows(list);
		page.setTotal(list.size());
		return page;
	}
	
	/**
	 * 
	 * @Title: reloadOne
	 * @Description: TODO(更新某一组规则)
	 * @param @param str
	 * @param @return    设定文件
	 * @return ModelAndView    返回类型
	 * @throw
	 */	
	@RequestMapping(value = "/reloadOne", method = {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public String reloadOne(String str){					
		if(ruleService.reLoadOne(str))
			return "success";
		else
			return "failed";
	}	
	
	/**
	 * 
	 * @Title: reloadAll
	 * @Description: TODO(reload全部)
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throw
	 */
	@RequestMapping(value = "/reloadAll", method = {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public String reloadAll(){			
		if(ruleService.init())
			return "success";
		else
			return "failed";		
	}
}
