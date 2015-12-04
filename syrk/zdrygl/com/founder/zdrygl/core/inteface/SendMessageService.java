package com.founder.zdrygl.core.inteface;

import com.founder.zdrygl.base.message.SysMessage;

public interface SendMessageService {

	/**
	 * 
	 * @Title: sendMessage
	 * @Description: TODO(根据jslx 发送给不同的消息接收人)
	 * @param @param sysMessage 消息对象
	 * @param @param jslx    接收类型
	 * @return void    返回类型
	 * @throw
	 */
	public void sendMessage(SysMessage sysMessage, String jslx,Object jsdx);
	
}
