package com.founder.zdrygl.base.message;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.base.service.impl.MessageDict.java]  
 * @ClassName:    [MessageDict]   
 * @Description:  [消息相关的字典，命名规则：MESSAGE_模块_消息类型]   
 * @Author:       [zhang.hai@founder.com.cn]  
 * @CreateDate:   [2015年9月15日 上午9:29:58]   
 * @UpdateUser:   [ZhangHai(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年9月15日 上午9:29:58，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
public class MessageDict {
	public static MessageDictZdrygl ZDRYGL = new MessageDictZdrygl();
	
	/**
	 * 发送给人员
	 */
	public static String JSLX_TO_USER="TO_USER";
	
	/**
	 * 发送给人员List
	 */
	public static String JSLX_TO_USERLIST="TO_USERLIST";
	
	/**
	 * 发送给部门
	 */
	public static String JSLX_TO_ORG="TO_ORG";
	
	/**
	 * 发送给部门+岗位
	 */
	public static String JSLX_TO_ORGANDPOS="TO_ORGANDPOS";
}
