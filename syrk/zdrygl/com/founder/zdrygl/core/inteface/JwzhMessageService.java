package com.founder.zdrygl.core.inteface;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.core.inteface.JwzhMessageService.java]  
 * @ClassName:    [JwzhMessageService]   
 * @Description:  [警务综合消息服务接口]   
 * @Author:       [wei.wen@founder.com.cn]  
 * @CreateDate:   [2015年9月13日 下午4:47:43]   
 * @UpdateUser:   [wei.wen@founder.com.cn(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年9月13日 下午4:47:43，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
public interface JwzhMessageService {
	
	/**
	 * 
	 * @Title: sendMessage
	 * @Description: (根据 消息类型与消息源对象组装消息体，根据jslx发送消息到接收对象)
	 * @param @param xxlx 消息类型
	 * @param @param source 消息源对象 存放ZdryZb和发送人信息等对象
	 * @param @param jslx    接收类型
	 * @param @param jsdx    接收对象
	 * @return void    返回类型
	 * @throw
	 */
	public void sendMessage(String xxlx, Object source, String jslx, Object jsdx);
	
}
