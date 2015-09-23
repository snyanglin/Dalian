package com.founder.zdrygl.base.message;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.base.service.impl.MessageDict.java]  
 * @ClassName:    [MessageDict]   
 * @Description:  [消息相关的字典]   
 * @Author:       [zhang.hai@founder.com.cn]  
 * @CreateDate:   [2015年9月15日 上午9:29:58]   
 * @UpdateUser:   [ZhangHai(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年9月15日 上午9:29:58，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
public class MessageDict {
	/**
	 * 消息业务类型 列管申请
	 */
	public static String XXLX_LGSQ="LGSQ";
	/**
	 * 列管审批结果
	 */
	public static String XXLX_LGSPJG="LGSPJG";

	
	/**
	 * 消息业务类型 撤管申请
	 */
	public static String XXLX_CGSQ="CGSQ";
	/**
	 * 撤管审批结果
	 */
	public static String XXLX_CGSPJG="CGSPJG";

	
	/**
	 * 消息业务类型 转递
	 */
	public static String XXLX_ZDSQ="ZDSQ";
	
	/**
	 * 接收转递
	 */
	public static String XXLX_JSZD="JSZD";
	
	/**
	 * 不接收转递
	 */
	public static String XXLX_BJSZD="BJSZD";
	/**
	 * 上级转递裁定结果
	 */
	public static String XXLX_ZD_SJCDJG="ZD_SJCDJG";

	/**
	 * 消息业务类型 转类
	 */
	public static String XXLX_ZLSQ="ZLSQ";
	/**
	 * 转类审批结果
	 */
	public static String XXLX_ZLSPJG="ZLSPJG";
	
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
