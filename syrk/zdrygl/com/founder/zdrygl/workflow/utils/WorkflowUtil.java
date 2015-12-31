package com.founder.zdrygl.workflow.utils;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.founder.bzdz.service.DzService;
import com.founder.bzdz.vo.BzdzxxbVO;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.config.SystemConfig;
import com.founder.framework.organization.department.bean.OrgOrganization;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.organization.position.service.OrgPositionService;
import com.founder.syrkgl.bean.RyRyjbxxb;
import com.founder.syrkgl.bean.SyrkSyrkxxzb;
import com.founder.syrkgl.service.RyRyjbxxbService;
import com.founder.syrkgl.service.SyrkSyrkxxzbService;
import com.founder.zdrygl.base.model.ZdryZb;
import com.founder.zdrygl.base.service.wf.WfywEnum;
import com.founder.zdrygl.core.utils.SpringContextHolder;
import com.founder.zdrygl.core.utils.ZdryConstant;
import com.founder.zdrygl.workflow.exception.BaseWorkflowException;
/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.workflow.utils.WorkflowUtil.java]  
 * @ClassName:    [WorkflowUtil]   
 * @Description:  [support workflow]   
 * @Author:       [huang_jifei@founder.com.cn]  
 * @CreateDate:   [2015年12月23日 下午3:31:52]   
 * @UpdateUser:   [huangjifei(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年12月23日 下午3:31:52，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Component 
public class WorkflowUtil {

	@Resource(name = "orgPositionService")
	private OrgPositionService orgPositionService;
	
	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;
	
	@Autowired
	private ZdryConstant zdryConstant;

	@Resource(name = "dzService")
	private DzService dzService;
	
	@Resource(name = "ryRyjbxxbService")
	private RyRyjbxxbService ryRyjbxxbService;

	@Resource(name = "syrkSyrkxxzbService")
	private SyrkSyrkxxzbService syrkSyrkxxzbService;
	
	/**
	 * 
	 * @Title: buildWorkflowKey
	 * @Description: (build work flow key)
	 * @param @param suffixName
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public static String buildWorkflowKey(String suffixName){
		StringBuilder sb = new StringBuilder();
		sb.append("wf_");
		String systemXzqh = SystemConfig.getString("systemXzqh")==null?"210000":SystemConfig.getString("systemXzqh");
		sb.append(systemXzqh).append("_").append(suffixName);
		return sb.toString();
	}
	/**
	 * 
	 * @Title: getMessageParam
	 * @Description: (获取消息生产需要的参数)
	 * @param @param sessionBean
	 * @param @param zdry
	 * @param @return    设定文件
	 * @return Map<String,Object>    返回类型
	 * @throws
	 */
	public Map<String,Object> getMessageParam(SessionBean sessionBean , ZdryZb zdry){
        //私有参数处理
        Map<String,Object> paramObj = new HashMap<String,Object>();
        paramObj.put("fsrName", sessionBean.getUserName());//发送人姓名
        paramObj.put("fsrUserCode", sessionBean.getUserId());//发送人代码	
        paramObj.put("fsrOrgName", sessionBean.getUserOrgName());//发送人机构名
        paramObj.putAll(getZdryXmAndZdrylxName(zdry));
        return paramObj;
	}
	/**
	 * 
	 * @Title: getZdryXmAndZdrylxName
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param zdry
	 * @param @return    设定文件
	 * @return Map<String,String>    返回类型
	 * @throws
	 */
	private Map<String, String> getZdryXmAndZdrylxName(ZdryZb zdry) {
		Map<String, String> map = new HashMap<String,String>();
		ZdryZb zdryzb = (ZdryZb) zdry;
		map.put("zdryId", zdryzb.getId());
		map.put("zdryName", zdryzb.getXm());
		map.put("zdryGllxdm", zdryzb.getZdrygllxdm());
		map.put("zdrylxName", zdryConstant.getValueOfZdryDict(zdryzb.getZdrygllxdm()));
		return map;
	}
	/**
	 * @throws BaseWorkflowException 
	 * 
	 * @Title: camZazdTaskOwner
	 * @Description: (获取监督部门审批人员)
	 * @param @param syrkSyrkxxzb
	 * @param @param zdry_jzd_zrqdm
	 * @param @param orgLevel
	 * @param @param posId
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String camZazdTaskOwner(String orgLevel, String posId) throws BaseWorkflowException {
		String taskParameter = null;
		String orgName = "治安管理支队派出所工作大队";
		String systemXzqh = SystemConfig.getString("systemXzqh")==null?"210000":SystemConfig.getString("systemXzqh");
		List<OrgOrganization>  orgLst = orgOrganizationService.queryList(orgName,orgLevel,systemXzqh);
		if(orgLst.size() > 0 && orgLst.size()==1){
			taskParameter = orgLst.get(0).getOrgcode() + "_"
					+ orgPositionService.queryByPosid(posId).getId().toString();
		}else{
			throw new BaseWorkflowException("未定义" + orgName);
		}
		return taskParameter;
	}
	/**
	 * 
	 * @Title: camSzTaskOwner
	 * @Description: (计算工作指定委任人)
	 * @param @param ryId
	 * @param @param orgLevel
	 * @param @param posId
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String camSzTaskOwner(ZdryZb zdryZb, String orgLevel, String posId) {
		String zdry_hjd_mlpdm = null;
		OrgOrganization orgOrganization = null;
		String taskParameter = null;
		String zdry_jzd_mlpdm = null;
		
		SyrkSyrkxxzb syrkSyrkxxzb = syrkSyrkxxzbService.queryById(zdryZb.getSyrkid());
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
	 * @Title: getWorkflowParamBean
	 * @Description: (获取指定业务流程的参数)
	 * @param @param ywEnum
	 * @param @return    设定文件
	 * @return LinkedHashMap<String,String>    返回类型
	 * @throws
	 */
	public LinkedHashMap<String,String> getWorkflowParamBean(WfywEnum ywEnum){
		String beanId = WorkflowUtil.buildWorkflowKey(ywEnum.getValue());
		LinkedHashMap<String,String> wfParams = SpringContextHolder.getBean(beanId);
		return wfParams;
	}
}
