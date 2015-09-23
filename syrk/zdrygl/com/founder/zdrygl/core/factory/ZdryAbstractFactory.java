package com.founder.zdrygl.core.factory;

import com.founder.zdrygl.core.inteface.ZdryService;
import com.founder.zdrygl.core.model.Zdry;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.core.factory.ZdryAbstractFactory.java]  
 * @ClassName:    [ZdryAbstractFactory]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [wei.wen@founder.com.cn]  
 * @CreateDate:   [2015年9月6日 上午10:00:31]   
 * @UpdateUser:   [wei.wen@founder.com.cn(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年9月6日 上午10:00:31，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
public interface ZdryAbstractFactory {
	
	/**
	 * 
	 * @Title: createZdryService
	 * @Description: (创建普通重点人员业务对象)
	 * @param @param zdrylx 重点人员类型
	 * @param @param zdryzb 重点人员总表对象
	 * @param @param zdrylbdx 重点人员类型表对象(撤管为注销时传null)
	 * @param @return    设定文件
	 * @return ZdryService    返回类型
	 * @throw
	 */
	public ZdryService createZdryService(String zdrylx ,Zdry zdryzb, Zdry zdrylbdx);
	
}
