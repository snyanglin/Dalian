package com.founder.zdrygl.workflow.dalian;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.founder.bzdz.service.DzService;
import com.founder.bzdz.vo.BzdzxxbVO;
import com.founder.framework.exception.BussinessException;
import com.founder.framework.organization.department.bean.OrgOrganization;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.organization.position.service.OrgPositionService;
import com.founder.syrkgl.bean.RyRyjbxxb;
import com.founder.syrkgl.bean.SyrkSyrkxxzb;
import com.founder.syrkgl.service.RyRyjbxxbService;
import com.founder.syrkgl.service.SyrkSyrkxxzbService;
import com.founder.workflow.bean.BaseWorkFlowBean;
import com.founder.workflow.service.activiti.lisener.WorkflowDelegate;
import com.founder.zdrygl.base.model.ZdryZb;
import com.founder.zdrygl.base.service.ZdryInfoQueryService;
import com.founder.zdrygl.workflow.exception.BaseWorkflowException;
/**
 * ****************************************************************************
 * @Package:      [com.founder.activiti.demo.workflow.dalian.Jgdxqjjs.java]  
 * @ClassName:    [Jgdxqjjs]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [huang_jifei@founder.com.cn]  
 * @CreateDate:   [2015年12月7日 下午4:14:13]   
 * @UpdateUser:   [huangjifei(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年12月7日 下午4:14:13，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Component
public class Jgdxqjjs extends WorkflowDelegate{
	
	Log log = LogFactory.getLog(this.getClass());
	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;

	@Resource(name = "orgPositionService")
	private OrgPositionService orgPositionService;

	@Resource(name = "dzService")
	private DzService dzService;

	@Resource(name = "zdryQueryService")
	private ZdryInfoQueryService zdryQueryService;

	@Resource(name = "syrkSyrkxxzbService")
	private SyrkSyrkxxzbService syrkSyrkxxzbService;

	@Resource(name = "ryRyjbxxbService")
	private RyRyjbxxbService ryRyjbxxbService;
	@Override
	public void doBusiness(BaseWorkFlowBean arg0) {
		Map<String, Object> variables = arg0.getProcessVariables();
		String zdry_jzd_mlpdm = null;
		try {
			String zdryId = (String) variables.get("zdryId");
			ZdryZb zdryZb = (ZdryZb) zdryQueryService.queryById(zdryId);
			OrgOrganization orgOrganization = new OrgOrganization();
			String syrkSyrkxxzbId = zdryZb.getSyrkid();
			SyrkSyrkxxzb syrkSyrkxxzb = syrkSyrkxxzbService
					.queryById(syrkSyrkxxzbId);
			if (syrkSyrkxxzb != null) {
				zdry_jzd_mlpdm = syrkSyrkxxzb.getJzd_mlpdm();// 重点人员居住地门楼盘代码
			} else {
				// 查询人员基本信息表
				RyRyjbxxb ryRyjbxxb = ryRyjbxxbService.queryByCyzjdmZjhm(
						zdryZb.getCyzjdm(), zdryZb.getZjhm());
				zdry_jzd_mlpdm = ryRyjbxxb.getJzd_mlpdm();
			}
			String zdry_jzd_zrqdm = dzService.queryMldzDx(zdry_jzd_mlpdm)
					.getZrqdm();// 重点人员居住地责任区
			String variableKey = "sz";
			String taskOwner = camSzTaskOwner(syrkSyrkxxzb, zdry_jzd_zrqdm, "32", "SZ");
			//setLocalVariable("isSz",true);
			if(taskOwner == null){
				throw new BaseWorkflowException("没有对应的组织或岗位。");
			}
			setLocalVariable(variableKey, taskOwner);
			//setLocalVariable("businessType", "1");
			//setLocalVariable("org", orgOrganization);
			setLocalVariable("approvalMethod", "szApproval");

		} catch (BussinessException aa) {
			throw new BussinessException("未找到该重点人员户籍地址信息，请补充");// 抛出异常
		} catch (BaseWorkflowException e) {
			e.printStackTrace();
		} catch(Exception ee){
			ee.printStackTrace();
		}

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
	private String camSzTaskOwner(SyrkSyrkxxzb syrkSyrkxxzb,
			String zdry_jzd_zrqdm, String orgLevel, String posId) {
		String zdry_hjd_mlpdm = null;
		OrgOrganization orgOrganization = null;
		String taskParameter = null;
		if (syrkSyrkxxzb != null) {
			zdry_hjd_mlpdm = syrkSyrkxxzb.getHjd_mlpdm();// 重点人员户籍地门楼盘代码
		}
		BzdzxxbVO bzdzxxbVO = dzService.queryMldzDx(zdry_hjd_mlpdm);
		if (zdry_hjd_mlpdm == null || bzdzxxbVO == null) {
			orgOrganization = orgOrganizationService.queryUpOrgByLevel(
					zdry_jzd_zrqdm, orgLevel);
			String fsxOrgCode = orgOrganization.getOrgcode();// 得到本名等级为三级，派出所部门code
			taskParameter = fsxOrgCode + "_"
					+ orgPositionService.queryByPosid(posId).getId().toString(); // 部门code+所长岗位ID
		} else {

			String zdry_hjd_zrqdm = dzService.queryMldzDx(zdry_hjd_mlpdm)
					.getZrqdm();// 重点人员户籍地责任区
			orgOrganization = orgOrganizationService.queryUpOrgByLevel(
					zdry_hjd_zrqdm, orgLevel);
			String fsxOrgCode = orgOrganization.getOrgcode();// 得到本名等级为三级，派出所部门code
			taskParameter = fsxOrgCode + "_"
					+ orgPositionService.queryByPosid(posId).getId().toString(); // 部门code+所长岗位ID
		}
		
		return taskParameter;
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
	 * @Title: qjSuccess
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param     设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void qjSuccess(){
		System.out.println("### 请假成功");
	}
	/**
	 * 
	 * @Title: qjFail
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param     设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void qjFail(){
		System.out.println("### 请假失败");
	}
	
}
