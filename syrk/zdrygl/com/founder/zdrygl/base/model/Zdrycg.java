package com.founder.zdrygl.base.model;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.base.model.Zdrycg.java]  
 * @ClassName:    [Zdrycg]   
 * @Description:  [重点人员撤管]   
 * @Author:       [wei.wen@founder.com.cn]  
 * @CreateDate:   [2015年9月16日 下午5:32:32]   
 * @UpdateUser:   [wei.wen@founder.com.cn(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年9月16日 下午5:32:32，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
public class Zdrycg  extends ZdryZb {

	private static final long serialVersionUID = -543790100757572975L;
	
	private String zdryid_old;
	private String zdrygllxdm_old;
	
	public String getZdryid_old() {
		return zdryid_old;
	}

	public void setZdryid_old(String zdryid_old) {
		this.zdryid_old = zdryid_old;
	}

	public String getZdrygllxdm_old() {
		return zdrygllxdm_old;
	}

	public void setZdrygllxdm_old(String zdrygllxdm_old) {
		this.zdrygllxdm_old = zdrygllxdm_old;
	}
}
