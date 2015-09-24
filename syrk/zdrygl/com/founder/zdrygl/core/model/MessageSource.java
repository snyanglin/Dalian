package com.founder.zdrygl.core.model;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.core.model.MessageSource.java]  
 * @ClassName:    [MessageSource]   
 * @Description:  [业务发送消息源]   
 * @Author:       [wei.wen@founder.com.cn]  
 * @CreateDate:   [2015年9月24日 上午10:05:01]   
 * @UpdateUser:   [wei.wen@founder.com.cn(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年9月24日 上午10:05:01，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
public class MessageSource {
	
	/**
	 * 消息类型
	 */
	private String xxlx ;
	/**
	 * 消息源
	 */
	private Object source ;
	/**
	 * 接收类型
	 */
	private String jslx ;
	/**
	 * 接收对象
	 */
	private Object jsdx ;
	
	public String getXxlx() {
		return xxlx;
	}
	public void setXxlx(String xxlx) {
		this.xxlx = xxlx;
	}
	public Object getSource() {
		return source;
	}
	public void setSource(Object source) {
		this.source = source;
	}
	public String getJslx() {
		return jslx;
	}
	public void setJslx(String jslx) {
		this.jslx = jslx;
	}
	public Object getJsdx() {
		return jsdx;
	}
	public void setJsdx(Object jsdx) {
		this.jsdx = jsdx;
	}

	
}
