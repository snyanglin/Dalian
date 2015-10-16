package com.founder.zdrygl.workflow;

import javax.annotation.Resource;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import com.founder.bzdz.service.DzService;
import com.founder.bzdz.vo.BzdzxxbVO;
import com.founder.framework.exception.BussinessException;
import com.founder.framework.organization.department.bean.OrgOrganization;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.organization.position.service.OrgPositionService;
import com.founder.syrkgl.bean.SyrkSyrkxxzb;
import com.founder.syrkgl.service.SyrkSyrkxxzbService;
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
public class Zaywjs implements JavaDelegate {

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

	@Override
	public void execute(DelegateExecution arg0) throws BussinessException {

		try {
			String zdrygllxdm = (String) arg0.getVariable("zdrylx");
			String zdryId = (String) arg0.getVariable("zdryId");
			String lrrzrq = (String) arg0.getVariable("lrrzrq");
			OrgOrganization orgOrganization = new OrgOrganization();
			ZdryZb zdryZb = (ZdryZb) zdryQueryService.queryById(zdryId);
			String syrkSyrkxxzbId = zdryZb.getSyrkid();
			SyrkSyrkxxzb syrkSyrkxxzb = syrkSyrkxxzbService
					.queryById(syrkSyrkxxzbId);
			String zdry_jzd_mlpdm = syrkSyrkxxzb.getJzd_mlpdm();// 重点人员居住地门楼盘代码
			String zdry_jzd_zrqdm = dzService.queryMldzDx(zdry_jzd_mlpdm)
					.getZrqdm();// 重点人员居住地责任区
			if (zdrygllxdm.equals("01")) { // 人口类别为社区矫正

				orgOrganization = orgOrganizationService.queryUpOrgByLevel(
						zdry_jzd_zrqdm, "32");
				String fsxOrgCode = orgOrganization.getOrgcode();// 得到本名等级为三级，派出所部门code
				String taskParameter = fsxOrgCode
						+ "_"
						+ orgPositionService.queryByPosid("SZ").getId()
								.toString(); // 部门code+所长岗位ID
				arg0.setVariableLocal("sz", taskParameter);
				arg0.setVariableLocal("businessType", "1");
				arg0.setVariableLocal("approvalMethod", "szApproval");
			}

			else {
				String zdry_hjd_mlpdm = syrkSyrkxxzbService.queryById(
						zdryZb.getSyrkid()).getHjd_mlpdm();// 重点人员户籍地门楼盘代码

				BzdzxxbVO bzdzxxbVO = dzService.queryMldzDx(zdry_hjd_mlpdm);

				if (zdry_hjd_mlpdm == null || bzdzxxbVO == null) {
					orgOrganization = orgOrganizationService.queryUpOrgByLevel(
							zdry_jzd_zrqdm, "32");
					String fsxOrgCode = orgOrganization.getOrgcode();// 得到本名等级为三级，派出所部门code
					String taskParameter = fsxOrgCode
							+ "_"
							+ orgPositionService.queryByPosid("SZ").getId()
									.toString(); // 部门code+所长岗位ID
					arg0.setVariableLocal("sz", taskParameter);
					arg0.setVariableLocal("businessType", "1");
					arg0.setVariableLocal("approvalMethod", "szApproval");
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
						arg0.setVariableLocal("sz", taskParameter);
						arg0.setVariableLocal("businessType", "1");
						arg0.setVariableLocal("approvalMethod", "szApproval");
					} else {

						orgOrganization = orgOrganizationService
								.queryByOrgcode(zdry_hjd_zrqdm);
						String taskParameter = zdry_hjd_zrqdm
								+ "_"
								+ orgPositionService.queryByPosid("ZRQMJ")
										.getId().toString(); // 责任区部门code+民警岗位ID
						arg0.setVariableLocal("hjdmj", taskParameter);
						arg0.setVariableLocal("businessType", "0");
						arg0.setVariableLocal("approvalMethod", "mjApproval");

					}

				}

			}

		} catch (BussinessException aa) {

			throw new BussinessException("未找到该重点人员户籍地址信息，请补充");// 抛出异常
		}

	}

}
