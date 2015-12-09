package com.founder.zdrygl.base.service.wf;

import com.founder.framework.base.entity.SessionBean;
import com.founder.workflow.bean.StartProcessInstance;
import com.founder.zdrygl.base.vo.ZdryVO;
/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.base.service.dl.IfParamInitialize.java]  
 * @ClassName:    [IfParamInitialize]   
 * @Description:  工作流参数实例化接口   
 * @Author:       [huang_jifei@founder.com.cn]  
 * @CreateDate:   [2015年12月8日 下午6:03:52]   
 * @UpdateUser:   [huangjifei(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年12月8日 下午6:03:52，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
public interface IfParamInitializer {
	/**
	 * 
	 * @Title: initialProcessInstance
	 * @Description: 实例化工作流，准备需要的数据
	 * @param @param sessionBean
	 * @param @param zdryVO
	 * @param @param lcgFlag    设定文件
	 * @return StartProcessInstance    返回类型
	 * @throws
	 */
	StartProcessInstance initialProcessInstance(SessionBean sessionBean, ZdryVO zdryVO, LcgFlagEnum lcgFlag);
}
