package com.founder.zdrygl.base.message;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.founder.drools.core.inteface.RuleService;
import com.founder.framework.exception.BussinessException;
import com.founder.zdrygl.core.inteface.SysMessageInfoService;
import com.founder.zdrygl.core.model.SysMessage;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.base.message.SysMessageInfoRuleServiceImpl.java]  
 * @ClassName:    [SysMessageInfoRuleServiceImpl]   
 * @Description:  [消息规则引擎实现]   
 * @Author:       [wei.wen@founder.com.cn]  
 * @CreateDate:   [2015年10月15日 下午5:16:25]   
 * @UpdateUser:   [wei.wen@founder.com.cn(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年10月15日 下午5:16:25，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Service("sysMessageInfoService")
public class SysMessageInfoRuleServiceImpl implements SysMessageInfoService {
	
	@Autowired
	private RuleService ruleService;
		
	@Override
	public SysMessage initSysMessage(String xxlx, Object param) {
		//处理消息类型，格式:MESSAGE_模块（ZDRYGL）_消息类型
		String[] xxlxAry=xxlx.split("_");
		if(xxlxAry.length<3){
			throw new BussinessException("Message type must be like 'MESSAGE_ZDRYGL_LGSQ'");
		}
		
		//规则模块名
		String ruleName =xxlxAry[0]+"_"+xxlxAry[1];		
		SysMessage sysMessage=new SysMessage();
		sysMessage.setXxlb(xxlx);		
		if(param instanceof Map){
			Map paraMap=(Map) param;
			Map globalParam = (Map) paraMap.get("globalParam");//公共参数
			Object paramObj=paraMap.get("paramObj");//私有参数
			
			//参数处理，至少要传个SysMessage，成功构建消息后，sysMessage.status=0，默认为1。
			if(paramObj!=null){
				if(paramObj instanceof List){//多个私有参数		
					List list=(List)paramObj;
					list.add(sysMessage);
					//执行规则
					ruleService.executeRule(ruleName, list, globalParam);
				}else{//单个私有参数
					List list=new ArrayList(2);
					list.add(paramObj);
					list.add(sysMessage);
					ruleService.executeRule(ruleName, list, globalParam);
				}
				
			}else{//没有私有参数
				//执行规则
				ruleService.executeRule(ruleName, sysMessage, globalParam);
			}
			
			return sysMessage;
		}else{
			throw new BussinessException("param object must be java.util.Map");
		}
		
	}
	
}
