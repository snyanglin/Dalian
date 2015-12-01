package com.founder.zdry.service;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.exception.BussinessException;
import com.founder.zdry.bean.ZdryLczywblb;
import com.founder.zdry.vo.ZdryZdryzbVO;

/***
 * ****************************************************************************
 * @Package:      [com.founder.zdry.service.ZdService.java]  
 * @ClassName:    [ZdService]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [wu_chunhui@founder.com.cn]  
 * @CreateDate:   [2015-3-11 下午7:26:24]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-3-11 下午7:26:24，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@TypeAnnotation("转递管业务处理")
public interface ZdryZdService {
	
	/***
	 * 
	 * @Title: sendZd
	 * @Description: TODO(发起转递)
	 * @param @param zdryLczywblb
	 * @param @param zdryZbId
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "转递业务发起", type = logType.insert)
	public String sendZd(ZdryLczywblb zdryLczywblb,ZdryZdryzbVO zdryZdryzb,SessionBean sessionBean) throws BussinessException;
	
	/***
	 * 
	 * @Title: receiveZd
	 * @Description: TODO(接收转递/拒绝转递，发起裁定)
	 * @param @param lczywblbID
	 * @param @param messageID
	 * @param @param zdryLczywblb
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "转递业务接收/拒绝逻辑", type = logType.insert)
	public String receiveZd(String messageID,ZdryLczywblb zdryLczywblb,SessionBean sessionBean, String xgxzrqdm,
			String xgxpcsdm) throws BussinessException;
	/***
	 * 
	 * @Title: ruleZd
	 * @Description: TODO(转递裁定业务逻辑)
	 * @param @param lczywblbID
	 * @param @param messageID
	 * @param @param zdryLczywblb
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "转递业务裁定", type = logType.insert)
	public void ruleZd(String messageID,ZdryLczywblb zdryLczywblb,
			SessionBean sessionBean) throws BussinessException;
}
