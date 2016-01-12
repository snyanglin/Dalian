package com.founder.zdrygl.core.utils;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.core.utils.ZdryQbDict.java]  
 * @ClassName:    [ZdryQbDict]   
 * @Description:  [情报人员 状态字典]   
 * @Author:       [zhang.hai@founder.com.cn]  
 * @CreateDate:   [2015年12月25日 下午2:37:35]   
 * @UpdateUser:   [ZhangHai(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年12月25日 下午2:37:35，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
public class ZdryQbDict {
	public static String GLZT_DXF="1";//待下发
	public static String GLZT_THSQZ="2";//退回申请中
	public static String GLZT_THJJ="3";//退回拒绝
	public static String GLZT_YJS="9";//已接收

	
	//业务操作类型
	public static String YWCZLX_XF="1";//下发
	public static String YWCZLX_TH="2";//退回
	public static String YWCZLX_THJJ="3";//退回拒绝
	public static String YWCZLX_THTY="4";//退回同意
	public static String YWCZLX_THCX="8";//退回撤销
	public static String YWCZLX_JS="9";//接收
}
