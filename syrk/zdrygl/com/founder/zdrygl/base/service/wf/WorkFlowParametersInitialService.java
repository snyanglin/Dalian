package com.founder.zdrygl.base.service.wf;

import com.founder.framework.base.entity.SessionBean;
import com.founder.ldym.util.SystemConfig;
import com.founder.workflow.bean.StartProcessInstance;
import com.founder.zdrygl.base.service.ZdryInfoQueryService;
import com.founder.zdrygl.base.vo.ZdryVO;
import com.founder.zdrygl.core.utils.ZdryConstant;

public class WorkFlowParametersInitialService {
	ZdryConstant zdryConstant;
	ZdryInfoQueryService zdryQueryService;
	public WorkFlowParametersInitialService( ZdryConstant zdryConstant,ZdryInfoQueryService zdryQueryService) {
		super();
		this.zdryConstant = zdryConstant;
		this.zdryQueryService = zdryQueryService;
	}

	/**
	 * 
	 * @Title: startLgProcess
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param sessionBean
	 * @param @param zdryVO 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public StartProcessInstance initialProcessInstance(
			SessionBean sessionBean, ZdryVO zdryVO, LcgFlagEnum lcgFlag) {
		// StartProcessInstance initializes
		StartProcessInstance spi = new StartProcessInstance();
		String systemXzqh = SystemConfig.getString("systemXzqh")==null?"210000":SystemConfig.getString("systemXzqh");
		if(systemXzqh.equals(SysXzqhEnum.DALIAN.getName())){
			IfParamInitializer initializer = createInstanceByClassName(SysXzqhEnum.DALIAN.getValue());
			spi = initializer.initialProcessInstance(sessionBean, zdryVO, lcgFlag);
		}else if(systemXzqh.equals(SysXzqhEnum.LIAONING.getName())){
			IfParamInitializer initializer = createInstanceByClassName(SysXzqhEnum.LIAONING.getValue());
			spi = initializer.initialProcessInstance(sessionBean, zdryVO, lcgFlag);
		}else{
			//TODO:
		}
		return spi;
	}
	/**
	 * 
	 * @Title: create Instance By Class Name
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param processClassName
	 * @param @return    设定文件
	 * @return IfParamInitializer    返回类型
	 * @throws
	 */
	private IfParamInitializer createInstanceByClassName(String processClassName) {
		IfParamInitializer obj = null;
		try {
			obj = (IfParamInitializer) Class.forName(processClassName).newInstance();
			obj.setZdryConstant(zdryConstant);
			obj.setZdryQueryService(zdryQueryService);
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (IfParamInitializer) obj;
	}

	
}
