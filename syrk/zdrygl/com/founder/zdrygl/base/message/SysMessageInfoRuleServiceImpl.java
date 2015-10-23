package com.founder.zdrygl.base.message;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.founder.drools.base.zdry.service.ZdryRuleService;
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
	private ZdryRuleService zdryRuleService;
	
	@SuppressWarnings("unchecked")
	@Override
	public SysMessage initSysMessage(String xxlx, Object param) {
		if(param instanceof Map){
			Map<String,String> paraMap=(Map<String,String>) param;
			String fsrName=(String) paraMap.get("fsrName");//发送人姓名
			String fsrUserCode=(String) paraMap.get("fsrUserCode");//发送人代码					
			
			if(fsrName==null || fsrName.length()==0){
				throw new BussinessException("fsrName can not be null");
			}
			if(fsrUserCode==null || fsrUserCode.length()==0){
				throw new BussinessException("fsrUserCode can not be null");
			}
			
			Map<String, Object> map = zdryRuleService.getTitleAndContents(xxlx, paraMap);
			//信息标题
			String xxbt=(String) map.get("title");
			//信息内容
			String xxnr =(String) map.get("contents");									
			
			SysMessage sysMessage=new SysMessage();
			sysMessage.setXxbt(xxbt);
			sysMessage.setXxnr(xxnr);
			sysMessage.setFsr(fsrName);//发送人的名字 
			sysMessage.setFsrdm(fsrUserCode);//发送人的code								
			//sysMessage.setJslx("");//0 按人  1 按部门
			
			return sysMessage;
		}else{
			throw new BussinessException("param object must be java.util.Map");
		}
		
	}
	
}
