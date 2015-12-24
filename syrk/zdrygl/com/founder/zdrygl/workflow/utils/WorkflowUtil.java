package com.founder.zdrygl.workflow.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.config.SystemConfig;
import com.founder.framework.organization.department.bean.OrgOrganization;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.organization.position.service.OrgPositionService;
import com.founder.zdrygl.base.model.ZdryZb;
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
}
