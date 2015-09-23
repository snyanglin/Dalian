package com.founder.zdrygl.core.inteface.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.founder.zdrygl.core.inteface.JwzhMessageService;
import com.founder.zdrygl.core.inteface.SendMessageService;
import com.founder.zdrygl.core.inteface.SysMessageInfoService;
import com.founder.zdrygl.core.model.SysMessage;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.core.inteface.impl.JwzhMessageServiceImpl.java]  
 * @ClassName:    [JwzhMessageServiceImpl]   
 * @Description:  [警务综合消息服务接口实现类]   
 * @Author:       [wei.wen@founder.com.cn]  
 * @CreateDate:   [2015年9月18日 上午11:11:19]   
 * @UpdateUser:   [wei.wen@founder.com.cn(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年9月18日 上午11:11:19，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Service
public class JwzhMessageServiceImpl implements JwzhMessageService {


	/**
	 * 消息发送接口
	 */
	@Resource
	private SendMessageService sendMessageService;
	/**
	 * 消息组装接口
	 */
	@Resource
	private SysMessageInfoService sysMessageInfoService;
	
	@Override
	public void sendMessage(String xxlx, Object source, String jslx, Object jsdx) {		
		SysMessage sysMessage = sysMessageInfoService.initSysMessage(xxlx, source);
		sendMessageService.sendMessage(sysMessage,jslx,jsdx);
	}
	

}
