package com.founder.zdrygl.workflow;

import java.util.Map;

import javax.annotation.Resource;

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

/**
 * ****************************************************************************
 * 
 * @Package: [com.founder.zdrygl.workflow.Zdrylxjs.java]
 * @ClassName: [Zaywjs]
 * @Description: [治安人员类型业务计算]
 * @Author: [he_minxi@founder.com.cn]
 * @CreateDate: [2015年8月4日 上午11:21:07]
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015年8月4日 上午11:21:07，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */

@Component
public class Zaywjs extends WorkflowDelegate{

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

	Object service = null;
	@Override
	public void doBusiness(BaseWorkFlowBean arg0) {
		service = new String("test");
		Map<String,Object> variables = arg0.getProcessVariables();
		String zdry_jzd_mlpdm = null;
		String zdry_hjd_mlpdm = null;
		try {
			String zdrygllxdm = (String) variables.get("zdrylx");
			ZdryZb zdryZb = (ZdryZb) variables.get("zdryZb");
			//String lrrzrq = (String) variables.get("lrrzrq");
			String cyzjdm =  (String) variables.get("cyzjdm");
			String zjhm =  (String) variables.get("zjhm");
			
			OrgOrganization orgOrganization = new OrgOrganization();
			String syrkSyrkxxzbId = zdryZb.getSyrkid();
			SyrkSyrkxxzb syrkSyrkxxzb = syrkSyrkxxzbService.queryById(syrkSyrkxxzbId);
			if(syrkSyrkxxzb != null){
				zdry_jzd_mlpdm = syrkSyrkxxzb.getJzd_mlpdm();// 重点人员居住地门楼盘代码
			}else{
				//查询人员基本信息表
				RyRyjbxxb ryRyjbxxb  = ryRyjbxxbService.queryByCyzjdmZjhm(cyzjdm, zjhm);
				zdry_jzd_mlpdm = ryRyjbxxb.getJzd_mlpdm();
			}
			String zdry_jzd_zrqdm = dzService.queryMldzDx(zdry_jzd_mlpdm).getZrqdm();// 重点人员居住地责任区
			if (zdrygllxdm.equals("01")) { // 人口类别为社区矫正

				orgOrganization = orgOrganizationService.queryUpOrgByLevel(
						zdry_jzd_zrqdm, "32");
				String fsxOrgCode = orgOrganization.getOrgcode();// 得到本名等级为三级，派出所部门code
				String taskParameter = fsxOrgCode
						+ "_"
						+ orgPositionService.queryByPosid("SZ").getId()
								.toString(); // 部门code+所长岗位ID
				setLocalVariable("sz", taskParameter);
				setLocalVariable("businessType", "1");
				setLocalVariable("approvalMethod", "szApproval");
			}

			else {
				if(syrkSyrkxxzb != null){
					zdry_hjd_mlpdm = syrkSyrkxxzb.getHjd_mlpdm();// 重点人员户籍地门楼盘代码
				}

				BzdzxxbVO bzdzxxbVO = dzService.queryMldzDx(zdry_hjd_mlpdm);

				if (zdry_hjd_mlpdm == null || bzdzxxbVO == null) {
					orgOrganization = orgOrganizationService.queryUpOrgByLevel(
							zdry_jzd_zrqdm, "32");
					String fsxOrgCode = orgOrganization.getOrgcode();// 得到本名等级为三级，派出所部门code
					String taskParameter = fsxOrgCode
							+ "_"
							+ orgPositionService.queryByPosid("SZ").getId()
									.toString(); // 部门code+所长岗位ID
					setLocalVariable("sz", taskParameter);
					setLocalVariable("businessType", "1");
					setLocalVariable("approvalMethod", "szApproval");
					// throw new BussinessException("未找到该重点人员户籍地址信息，请补充");//抛出异常
				} else {

					String zdry_hjd_zrqdm = dzService.queryMldzDx(
							zdry_hjd_mlpdm).getZrqdm();// 重点人员户籍地责任区
					if (zdry_hjd_mlpdm.equals(zdry_jzd_mlpdm)) { // 居住地为户籍地

						orgOrganization = orgOrganizationService
								.queryUpOrgByLevel(zdry_hjd_zrqdm, "32");
						String fsxOrgCode = orgOrganization.getOrgcode();// 得到本名等级为三级，派出所部门code
						String taskParameter = fsxOrgCode
								+ "_"
								+ orgPositionService.queryByPosid("SZ").getId()
										.toString(); // 部门code+所长岗位ID
						setLocalVariable("sz", taskParameter);
						setLocalVariable("businessType", "1");
						setLocalVariable("approvalMethod", "szApproval");
					} else {

						orgOrganization = orgOrganizationService
								.queryByOrgcode(zdry_hjd_zrqdm);
						String taskParameter = zdry_hjd_zrqdm
								+ "_"
								+ orgPositionService.queryByPosid("ZRQMJ")
										.getId().toString(); // 责任区部门code+民警岗位ID
						setLocalVariable("hjdmj", taskParameter);
						setLocalVariable("businessType", "0");
						setLocalVariable("approvalMethod", "mjApproval");

					}

				}

				setLocalVariable("org", orgOrganization);
			}

		} catch (BussinessException aa) {

			throw new BussinessException("未找到该重点人员户籍地址信息，请补充");// 抛出异常
		}

		
	}
	/**
	 * 消息标题：重点人员列管审批
消息内容：[社区民警辖区]民警[社区民警姓名]提交[重点人员管理类型][重点人员姓名]的列管申请，请审批。

	 * @Title: notifySzSign
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param     设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void notifySzSign(){
		
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
		System.out.println("### 通知双方民警及所长:" + service.toString());
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
		System.out.println("### 通知初始下发部门:" + service.toString());
		
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
		System.out.println("### 通知原辖区社区民警:" + service.toString());
		
	}
	/**
	 * 
	 * @Title: notifySz
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param     设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void notifySz(){
		System.out.println("### 通知所长 :" + service.toString());
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
		System.out.println("### 通知治安支队:" + service.toString());
	}
	/**
	 * 
	 * @Title: notifyJzdxq
	 * @Description: 通知实有人口其他居住地辖区
	 * @param     设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void notifyOtherJzdxq(){
		System.out.println("### 通知实有人口其他居住地辖区:" + service.toString());
	}
	@Override
	public void sendMsgByType(BaseWorkFlowBean bwf, String msgType) {
		// TODO Auto-generated method stub
		
	}
	
}
