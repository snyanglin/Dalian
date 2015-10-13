package com.founder.zdrygl.core.inteface;

import java.util.Map;

public interface ZdryglMessageService {

	/**
	 * 根据消息类型获取消息标题和正文
	 * @param xxlx 消息类型
	 * @param paraMap 消息查询参数
	 * @return Map[String,Object] :{title:标题(String),contents:正文(String)} 
	 */
	public Map<String,Object> getTitleAndContents(String xxlx,Map<String,String> paraMap);
	
	/**
	 * 获取消息的接受对象和接受类型
	 * @param xxlx 消息类型
	 * @param paraMap 消息查询参数
	 * @return Map[String,Object] :{receiveType:接受类型(String),receiver:接受对象(List[String])} 
	 */
	public Map<String,Object> getReceiverAndReceiveType(String xxlx,Map<String,String> paraMap);
	
}
