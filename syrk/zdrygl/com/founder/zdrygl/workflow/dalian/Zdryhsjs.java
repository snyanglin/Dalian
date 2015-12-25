package com.founder.zdrygl.workflow.dalian;

import java.util.List;
import java.util.Map;

import com.founder.bzdz.service.DzService;
import com.founder.bzdz.vo.BzdzxxbVO;
import com.founder.framework.organization.department.bean.OrgOrganization;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.organization.position.service.OrgPositionService;
import com.founder.ldym.util.SystemConfig;
import com.founder.syrkgl.bean.SyrkSyrkxxzb;
import com.founder.zdrygl.workflow.exception.BaseWorkflowException;
import org.springframework.stereotype.Component;

import com.founder.framework.exception.BussinessException;
import com.founder.workflow.bean.BaseWorkFlowBean;
import com.founder.workflow.service.activiti.lisener.WorkflowDelegate;

import javax.annotation.Resource;


/**
 * ****************************************************************************
 * @Package:      [com.founder.activiti.demo.workflow.dalian.Zdryhsjs.java]  
 * @ClassName:    [Zdryhsjs]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [huang_jifei@founder.com.cn]  
 * @CreateDate:   [2015年12月7日 下午2:29:27]   
 * @UpdateUser:   [huangjifei(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年12月7日 下午2:29:27，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */

@Component
public class Zdryhsjs extends WorkflowDelegate{

	@Resource
	private OrgOrganizationService orgOrganizationService;

	@Resource
	private OrgPositionService orgPositionService;

	@Resource
	private DzService dzService;

	@Override
	public void doBusiness(BaseWorkFlowBean arg0) {
		Map<String,Object> variables = arg0.getProcessVariables();
		String variableKey="sz";
		String taskOwner =null;
		try {
			setLocalVariable("isSz",true);
			String sqlxdm=(String) variables.get("sqlxdm");
			if ("04".equals(sqlxdm) || "06".equals(sqlxdm)){
				setLocalVariable("isSz",false);
				variableKey = "zazd";
				taskOwner=camZazdTaskOwner("30", "DDZ");
			}else {
				String sqrOrgCode = (String) variables.get("sqrOrgCode");
				taskOwner=camSzTaskOwner(sqrOrgCode,"SZ");
			}
			setLocalVariable("approvalMethod", "zdryApproval");
			setLocalVariable(variableKey,taskOwner);
		} catch(Exception aa){
			 throw  new BussinessException("重点人员转类出错");//抛出异常  
		}

	}
	/**
	 * 
	 * @Title: notifyAllPersons
	 * @Description: TODO(通知双方民警及所长)
	 * @param     设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void notifyAllPersons(){
		System.out.println("### 通知双方民警及所长");
	}
	/**
	 * 
	 * @Title: notifyCsxfbm
	 * @Description: TODO(通知初始下发部门)
	 * @param     设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void notifyCsxfbm(){
		System.out.println("### 通知初始下发部门");
		
	}
	/**
	 * 
	 * @Title: notifyCsxfbm
	 * @Description: 通知所长
	 * @param     设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void notifySz(){
		System.out.println("### 通知所长");
		
	}
	/**
	 * 
	 * @Title: notifyZazd
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param     设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void notifyZazd(){
		System.out.println("### 通知治安支队:");
	}
	/**
	 * 
	 * @Title: notifyYxqsqmj
	 * @Description: TODO(通知原辖区社区民警)
	 * @param     设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void notifyYxqsqmj(){
		System.out.println("### 通知原辖区社区民警");
		
	}
	/**
	 * 
	 * @Title: hsSucess
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param     设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void hsSuccess(){
		System.out.println("### 核实成功");
	}
	/**
	 * 
	 * @Title: hsFail
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param     设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void hsFail(){
		System.out.println("### 核实失败");
	}


	/**
	 *
	 * @Title: camSzTaskOwner
	 * @Description: 設置task owner
	 * @param @param syrkSyrkxxzb
	 * @param @param zdry_jzd_zrqdm
	 * @param @param orgLevel
	 * @param @param posId
	 * @param @param variableKey    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	private String camSzTaskOwner(String sqrOrgCode,String posId) {

		OrgOrganization orgOrganization = orgOrganizationService.queryUpOrgByLevel(sqrOrgCode, "32");
		String fsxOrgCode = orgOrganization.getOrgcode();// 得到本名等级为三级，派出所部门code
		String	taskParameter = fsxOrgCode + "_"
					+ orgPositionService.queryByPosid(posId).getId().toString();
		return taskParameter;
	}


	/**
	 * @throws BaseWorkflowException
	 *
	 * @Title: camZazdTaskOwner
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param syrkSyrkxxzb
	 * @param @param zdry_jzd_zrqdm
	 * @param @param orgLevel
	 * @param @param posId
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	private String camZazdTaskOwner(String orgLevel, String posId) throws BaseWorkflowException {
		String taskParameter = null;
		String orgName = "治安管理支队派出所工作大队";
		String systemXzqh = SystemConfig.getString("systemXzqh")==null?"210000":SystemConfig.getString("systemXzqh");
		List<OrgOrganization> orgLst = orgOrganizationService.queryList(orgName,orgLevel,systemXzqh);
		if(orgLst.size() > 0 && orgLst.size()==1){
			taskParameter = orgLst.get(0).getOrgcode() + "_"
					+ orgPositionService.queryByPosid(posId).getId().toString();
		}else{
			throw new BaseWorkflowException("未定义" + orgName);
		}
		return taskParameter;
	}
}
