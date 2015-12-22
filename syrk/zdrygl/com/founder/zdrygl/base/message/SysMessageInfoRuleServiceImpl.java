package com.founder.zdrygl.base.message;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.founder.drools.base.zdry.service.ZdryRuleService;
import com.founder.framework.exception.BussinessException;
import com.founder.framework.exception.RuleException;
import com.founder.zdrygl.core.inteface.SysMessageInfoService;

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
	
	private static Logger logger = Logger.getLogger(SysMessageInfoRuleServiceImpl.class);
	
	@Autowired	
	private ZdryRuleService zdryRuleService;
	
	@Override
	public SysMessage initSysMessage(String xxlx, Map<String,Object> param) {
		
		try{
			Map<String,Object> resMap = zdryRuleService.getZdryMessage(xxlx, param);
		
			SysMessage sysMessage = new SysMessage();
			sysMessage.setXxlb(resMap.get("xxlb").toString());
			sysMessage.setXxbt(resMap.get("msgTitle").toString());//信息标题
			sysMessage.setXxnr(resMap.get("msgContent").toString());//信息内容
			sysMessage.setStatus(0);
			sysMessage.setSfck("0");
			sysMessage.setFsr(param.get("fsrName").toString());
			sysMessage.setFsrdm(param.get("fsrUserCode").toString());
			sysMessage.setFsrssdw(param.get("fsrOrgName").toString());
			sysMessage.setJslx(resMap.get("jslx").toString());
			//还需要添加信息其他内容
			setJsdx(resMap, sysMessage);
			return sysMessage;			
		}catch(Exception e){
			logger.error("消息规则调用出错", e);
			if(e instanceof RuleException)
				throw new RuleException(e.getLocalizedMessage());
			else
				throw new BussinessException(e.toString());
		}
		
	}
	
	/**
	 * 
	 * @Title: setJsdx
	 * @Description: TODO(设置接收对象)
	 * @param @param resMap
	 * @param @param sysMessage    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	private void setJsdx(Map<String,Object> resMap, SysMessage sysMessage){
		if("0".equals(sysMessage.getJslx())){
			if(resMap.get("msgJsr") instanceof String[]){
				String[] jsr = (String[]) resMap.get("msgJsr");
				sysMessage.setJsr(jsr[1]);
				sysMessage.setJsrdm(jsr[0]);
			}else if(resMap.get("msgJsr") instanceof String[][]){
				//TODO:
				String[][] jsr = (String[][]) resMap.get("msgJsr");
				sysMessage.setJsr(jsr[0][1]);
				sysMessage.setJsrdm(jsr[0][0]);
			}
		}else if("1".equals(sysMessage.getJslx())){
			sysMessage.setJsrssdw(resMap.get("jsrssdw").toString());
			sysMessage.setJsrssdwdm(resMap.get("jsrssdwdm").toString());
		}
	}
	
}
