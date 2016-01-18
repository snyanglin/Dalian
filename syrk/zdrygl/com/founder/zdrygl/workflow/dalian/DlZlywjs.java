package com.founder.zdrygl.workflow.dalian;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.exception.BussinessException;
import com.founder.framework.organization.department.bean.OrgOrganization;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.organization.position.service.OrgPositionService;
import com.founder.workflow.bean.BaseWorkFlowBean;
import com.founder.workflow.service.activiti.lisener.WorkflowDelegate;
import com.founder.zdrygl.base.model.ZdryZb;
import com.founder.zdrygl.core.factory.ZdryAbstractFactory;
import com.founder.zdrygl.core.inteface.ZdryService;
import com.founder.zdrygl.core.model.ZOBean;
import com.founder.zdrygl.core.model.Zdry;
import com.founder.zdrygl.workflow.utils.ZdryZbUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.WebUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;


/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.workflow.Zdrylxjs.java]  
 * @ClassName:    [Zaywjs]   
 * @Description:  [治安人员类型业务计算]   
 * @Author:       [he_minxi@founder.com.cn]  
 * @CreateDate:   [2015年8月4日 上午11:21:07]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年8月4日 上午11:21:07，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */

@Component
public class DlZlywjs extends WorkflowDelegate {
	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;
	
	@Resource(name = "orgPositionService")
	private OrgPositionService orgPositionService;
	@Autowired
	public ZdryAbstractFactory zdryFactory;

	@Override
	public void doBusiness(BaseWorkFlowBean arg0) {
		Map<String,Object> variables = arg0.getProcessVariables();
		try {
			String lrrzrq=(String) variables.get("lrrzrq");
			OrgOrganization orgOrganization =new OrgOrganization();
			orgOrganization =orgOrganizationService.queryUpOrgByLevel(lrrzrq,"32");	
			String fsxOrgCode =orgOrganization.getOrgcode();//  得到本名等级为三级，派出所部门code
			String taskParameter=fsxOrgCode+"_"+orgPositionService.queryByPosid("SZ").getId().toString();   //部门code+所长岗位ID
			setLocalVariable("sz", taskParameter);
			setLocalVariable("approvalMethod", "szzlApproval");
		
		} catch(BussinessException aa){
			 throw  new BussinessException("重点人员转类出错");//抛出异常
		}

	}

	@Override
	public void sendMsgByType(BaseWorkFlowBean bwf, String msgType) {
		// TODO Auto-generated method stub
	}

	/**
	 * 处理审批结果：0，审批失败；1，审批通过
	 */
	@Override
	public void doResult(BaseWorkFlowBean bwf, String resultType){

		Map<String,Object> variables = bwf.getProcessVariables();
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		SessionBean sessionBean = (SessionBean) WebUtils.getSessionAttribute(
				request, AppConst.USER_SESSION);
		//TODO:
		String zdrylx = (String) variables.get("zdrylx");
		ZdryZb zdryzb = (ZdryZb) variables.get("zdryzb");
		Zdry zdrylbdx = (Zdry) variables.get("zdrylbdx");
		zdryzb.setZdrylb( (String) variables.get("yzdrylb"));
		ZdryService zdryService = zdryFactory.createZdryService(zdrylx);
		ZOBean entity = new ZOBean(zdryzb, zdrylbdx);

		if(resultType.trim().equals("0")){
			//审批失败

			zdryzb.setXt_zxyy("审批未通过");
			ZdryZbUtil.setXtZxyy(zdrylbdx, "审批未通过");
			zdryService.zlFail(sessionBean,entity);
			return;
		}else if(resultType.trim().equals("1")){
			zdryzb.setXt_zxyy(zdryzb.getXt_zxyy() + ";转类为"+zdryzb.getZdrylb());
			zdryService.zlSuccess(sessionBean,entity);
			return;
		}else{
			System.out.println("审批结果异常");
			return;
		}
	}
}
