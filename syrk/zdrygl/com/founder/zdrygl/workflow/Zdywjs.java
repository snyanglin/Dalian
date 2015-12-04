package com.founder.zdrygl.workflow;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.founder.framework.exception.BussinessException;
import com.founder.framework.organization.department.bean.OrgOrganization;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.organization.position.bean.OrgPosition;
import com.founder.framework.organization.position.service.OrgPositionService;
import com.founder.syrkgl.service.RyRyjbxxbService;
import com.founder.syrkgl.service.SyrkSyrkxxzbService;
import com.founder.workflow.bean.BaseWorkFlowBean;
import com.founder.workflow.service.activiti.lisener.WorkflowDelegate;
import com.founder.zdrygl.base.service.ZdryInfoQueryService;

/**
 * ****************************************************************************
 * 
 * @Package: [com.founder.zdrygl.workflow.Zdrylxjs.java]
 * @ClassName: [Zaywjs]
 * @Description: [转递业务计算]
 * @Author: [he_minxi@founder.com.cn]
 * @CreateDate: [2015年8月4日 上午11:21:07]
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015年8月4日 上午11:21:07，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */

@Component
public class Zdywjs extends WorkflowDelegate {

	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;

	@Resource(name = "orgPositionService")
	private OrgPositionService orgPositionService;

	@Resource(name = "zdryQueryService")
	private ZdryInfoQueryService zdryQueryService;

	@Resource(name = "syrkSyrkxxzbService")
	private SyrkSyrkxxzbService syrkSyrkxxzbService;
	
	@Resource(name = "ryRyjbxxbService")
	private RyRyjbxxbService ryRyjbxxbService;
	/**
	 *1)  两个辖区在同一个派出所内，则共同上级为派出所所长；
	 *2）	若两个辖区在两个派出所，但在同一个分局内，则共同上级为分局业务部门；
	 *3）	若两个辖区在不同分局，则共同上级为市局业务部门。
	 *治安：社区矫正人员、重点人口、下落不明重点人口、非正常上访重点人员、肇事肇祸精神病人、其他关注对象、涉枪涉爆重点人员；
	 *反恐：反恐重点人员；
	 *环保：涉环保重点人员；
	 *信访：涉公安访重点人员
	 *
	 */
	@Override
	public void doBusiness(BaseWorkFlowBean arg0) {
		Map<String,Object> variables = arg0.getProcessVariables();
		String nextTaskOwner = null;
		try {
			String zdrygllxdm = (String) variables.get("zdrylx");
			//String zdryId = (String) variables.get("zdryId");
			String zdryName = (String) variables.get("zdryName");
			//String lrrzrq = (String) variables.get("lrrzrq");
			//String cyzjdm =  (String) variables.get("cyzjdm");
			//String zjhm =  (String) variables.get("zjhm");
			String sszrqdm = (String) variables.get("sszrqdm");//ygxzrqdm
			String ygxzrqdm = (String) variables.get("ygxzrqdm");//ygxzrqdm
			
			OrgOrganization orgOrganization = new OrgOrganization();
			/*ZdryZb zdryZb = (ZdryZb) zdryQueryService.queryById(zdryId);
			String syrkSyrkxxzbId = zdryZb.getSyrkid();
			SyrkSyrkxxzb syrkSyrkxxzb = syrkSyrkxxzbService.queryById(syrkSyrkxxzbId);*/
			
			String current_jzd_zrqdm = ygxzrqdm;// 重点人员原居住责任区
			String target_jzd_zrqdm = sszrqdm;// 重点人员新居住地责任区;
			//设定流程新责任区负责人
			//String zdry_hjd_zrqdm = dzService.queryMldzDx(target_jzd_mlpdm).getZrqdm();// 重点人员户籍地责任区
			OrgOrganization targetOrgOrganization = orgOrganizationService.queryByOrgcode(sszrqdm);
			String taskParameter = targetOrgOrganization.getOrgcode() + "_"
					+ orgPositionService.queryByPosid("ZRQMJ").getId().toString(); // 责任区部门code+民警岗位ID
			setLocalVariable("spmj", taskParameter);
			setVariable("xglbm", targetOrgOrganization.getOrgcode());
			setVariable("yglbm",orgOrganizationService.queryByOrgcode(ygxzrqdm).getOrgcode());

			//设定共同领导
			//部门相同，不同责任区
			//判断责任区所属组织
			orgOrganization = orgOrganizationService.queryUpOrgByLevel(current_jzd_zrqdm, "32");
			OrgOrganization newOrgOrganization = orgOrganizationService.queryUpOrgByLevel(target_jzd_zrqdm, "32");
			if( orgOrganization.getOrgcode().equals(newOrgOrganization.getOrgcode())
					&& orgOrganization.getOrgbiztype().equals(newOrgOrganization.getOrgbiztype()) 
					//&& orgOrganization.getOrgbiztype().equals("09")//责任区 
					&& orgOrganization.getOrglevel().equals(newOrgOrganization.getOrglevel())
					&& orgOrganization.getOrglevel().equals("32")//派出所
					){
				nextTaskOwner = newOrgOrganization.getOrgcode() + "_"
						+ orgPositionService.queryByPosid("SZ")
								.getId().toString(); // 责任区部门code+所长岗位ID
			}else {
				OrgOrganization sameParentOrg =orgOrganizationService.querySameParentOrg(orgOrganization.getOrgcode(),newOrgOrganization.getOrgcode());
				System.out.println("sameParentOrg--> " + sameParentOrg.getOrgcode() );
				nextTaskOwner = buildTaskOwner(sameParentOrg,newOrgOrganization,zdrygllxdm);
			}
			setVariable("gtld", nextTaskOwner);
			// set Other parameters
			setVariable("zdryName", zdryName);
			setLocalVariable("businessType", "0");
			setLocalVariable("approvalMethod", "zdmjApproval");
			setLocalVariable("org", targetOrgOrganization);
			setLocalVariable("isZdryLg", "0");//TODO:测试用，默认为非上级指定列管人员
			setVariable("xgxpcsdm", newOrgOrganization.getOrgcode());
			setVariable("ygxpcsdm", orgOrganization.getOrgcode());
		} catch (BussinessException aa) {

			throw new BussinessException("未找到该重点人员户籍地址信息，请补充");// 抛出异常
		}
	}
	/**
	 * 
	 * @Title: buildTaskOwner
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param sameParentOrg
	 * @param @param newOrgOrganization
	 * @param @param zdrygllxdm
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	private String buildTaskOwner(OrgOrganization sameParentOrg,
			OrgOrganization newOrgOrganization, String zdrygllxdm) {
		// TODO Auto-generated method stub
		String[] posCodes = null;
		String nextTaskOwner = null;
		if(zdrygllxdm.equals("01")||zdrygllxdm.equals("02")
				||zdrygllxdm.equals("03")||zdrygllxdm.equals("04")
				||zdrygllxdm.equals("06")||zdrygllxdm.equals("08")){
			//治安
			if(sameParentOrg.getOrglevel().equals("21")){
				//若两个辖区在两个派出所，但在同一个分局内，则共同上级为分局业务部门:FXJZAYWZG
				posCodes = new String[]{"FXJZAYWZG","FXJGLY"};
			}else if(sameParentOrg.getOrglevel().equals("10")){
				//若两个辖区在不同分局，则共同上级为市局业务部门： 市公安局
				posCodes = new String[]{"SJGLY"};
			}else{
				//其他
				
			}
			nextTaskOwner = getTaskOwnerFilterByOrglevel(sameParentOrg,newOrgOrganization,posCodes);
		}else if(zdrygllxdm.equals("07")){
			//环保
			if(sameParentOrg.getOrglevel().equals("21")){
				//若两个辖区在两个派出所，但在同一个分局内，则共同上级为分局业务部门:FXJZAYWZG
				posCodes = new String[]{"FXJZAYWZG","FXJGLY"};
			}else if(sameParentOrg.getOrglevel().equals("10")){
				//若两个辖区在不同分局，则共同上级为市局业务部门： 市公安局
				posCodes = new String[]{"SJGLY"};
			}else{
				//其他
				
			}
		}else if(zdrygllxdm.equals("05")){
			//信访
			if(sameParentOrg.getOrglevel().equals("21")){
				//若两个辖区在两个派出所，但在同一个分局内，则共同上级为分局业务部门:FXJZAYWZG
				posCodes = new String[]{"FXJSGAFYWZG"};
			}else if(sameParentOrg.getOrglevel().equals("10")){
				//若两个辖区在不同分局，则共同上级为市局业务部门： 市公安局
				posCodes = new String[]{"SJGLY"};
			}else{
				//其他
				
			}
		}else{
			//反恐
		}
		nextTaskOwner = getTaskOwnerFilterByOrglevel(sameParentOrg,newOrgOrganization,posCodes);
		return nextTaskOwner;
	}
	/**
	 * 
	 * @Title: getTaskOwnerFilterByOrglevel
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param sameParentOrg
	 * @param @param newOrgOrganization
	 * @param @param posCodes,like :new String[]{"FXJZAYWZG","FXJGLY"}
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String getTaskOwnerFilterByOrglevel(OrgOrganization sameParentOrg,OrgOrganization newOrgOrganization,String[] posCodes){
		String nextTaskOwner = null;
		if(sameParentOrg.getOrglevel().equals("21")){
			//若两个辖区在两个派出所，但在同一个分局内，则共同上级为分局业务部门:FXJZAYWZG
			nextTaskOwner = buildTaskOwnerByArray(sameParentOrg,posCodes);
		}else if(sameParentOrg.getOrglevel().equals("10")){
			//若两个辖区在不同分局，则共同上级为市局业务部门： 市公安局
			nextTaskOwner = buildTaskOwnerByArray(sameParentOrg,posCodes);
		}else{
			//其他
			
		}
		if( nextTaskOwner == null){
			throw new BussinessException("未找到共同业务主管，请审查。");// 抛出异常
		}
		return nextTaskOwner;
	}
	/**
	 * 
	 * @Title: findTaskOwnerByArray
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param sameParentOrg
	 * @param @param posCodes
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	private String buildTaskOwnerByArray(OrgOrganization sameParentOrg,String[] posCodes){
		String nextTaskOwner = null;
		for(String onePosCode: posCodes){
			OrgPosition  position =  orgPositionService.queryByPosid(onePosCode.trim());
			if(position != null){
				nextTaskOwner = sameParentOrg.getOrgcode() + "_" + position.getId().toString(); 
				break;
			}
		}
		return nextTaskOwner;
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
	 * @Title: notifyYxqsqmj
	 * @Description: TODO(通知原辖区社区民警)
	 * @param     设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void notifyYxqsqmj(){
		System.out.println("### 通知原辖区社区民警");
		
	}
	
}
