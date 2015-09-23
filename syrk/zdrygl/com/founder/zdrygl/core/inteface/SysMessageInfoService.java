package com.founder.zdrygl.core.inteface;

import com.founder.zdrygl.core.model.SysMessage;

public interface SysMessageInfoService {

	/**
	 * 
	 * @Title: initSysMessage
	 * @Description: TODO(初始化信息对象)
	 * @param @param xxlx 信息类型
	 * @param @param param 参数对象
	 * @param @return    设定文件
	 * @return SysMessage    返回类型
	 * @throw
	 */
	public SysMessage initSysMessage(String xxlx,Object param);
	
}
