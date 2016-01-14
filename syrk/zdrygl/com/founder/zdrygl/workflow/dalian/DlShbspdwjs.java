package com.founder.zdrygl.workflow.dalian;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.components.AppConst;
import com.founder.framework.organization.department.bean.OrgOrganization;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.organization.position.service.OrgPositionService;
import com.founder.workflow.bean.BaseWorkFlowBean;
import com.founder.workflow.service.activiti.lisener.WorkflowDelegate;
import com.founder.zdrygl.base.dao.ZdryShbzdryxxbDao;
import com.founder.zdrygl.base.model.ZdryShbzdryxxb;
import com.founder.zdrygl.base.model.ZdryZb;
import com.founder.zdrygl.base.service.ZdryShbzdryxxbService;
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
 * @Package:      [com.founder.zdrygl.workflow.dalian]
 * @ClassName:    [Userbmjs]
 * @Description:  [大连涉环保 动态计算审批人]
 * @Author:       [cong_rihong@founder.com.cn]
 * @CreateDate:   [2015年8月11日 上午11:07:19]
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate:   [2015年8月11日 上午11:07:19，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version:      [v1.0]
 */
@Component
public class DlShbspdwjs extends WorkflowDelegate {

    @Resource(name = "orgOrganizationService")
    private OrgOrganizationService orgOrganizationService;
    @Resource
    private OrgPositionService orgPositionService;
    @Autowired
    public ZdryAbstractFactory zdryFactory;

    @Override
    public void doBusiness(BaseWorkFlowBean baseWorkFlowBean) {
        //TODO:需要重新确定该审批人
        Map<String,Object> variables = baseWorkFlowBean.getProcessVariables();
        String zdrylx = (String) variables.get("zdrylx");

        //如果是涉环保重点人员
        if("30".equals(zdrylx)){
            String sqrOrgCode = (String) variables.get("sqrOrgCode");
            String sqrOrgLevel = (String) variables.get("sqrOrgLevel");
            //String sqrOrgBiztype=(String) variables.get("sqrOrgBiztype");
            String splevel=(String) variables.get("splevel");
            OrgOrganization ssOrg =new OrgOrganization();
            //申请人部门
            ssOrg =orgOrganizationService.queryByOrgcode(sqrOrgCode);
            String ssOrgCode =ssOrg.getOrgcode();//  得到申请人所属部门code
            OrgOrganization upOrg=orgOrganizationService.queryParentOrgByOrgcode(sqrOrgCode);
            setVariable("org",upOrg);
            //一级审批
            if(splevel.equals("1")){
                //分县局环保大队和市局环保大队申请的，由大队长一级审批
                if("31".equals(sqrOrgLevel)||"30".equals(sqrOrgLevel)){
                    String ddz=orgPositionService.queryByPosid("DDZ").getId().toString();
                    this.setVariable("level1spr", ssOrgCode+"_"+ddz);

                }else if("".equals(sqrOrgLevel)){//省厅环保大队申请的

                }else{
                    try {
                        throw new Exception("无法定义审批人，只有分县局环保大队和市局环保大队才能申请！");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }else if(splevel.equals("2")){//二级审批
                //分县局环保大队申请的
                if("31".equals(sqrOrgLevel)){
                    String fjz=orgPositionService.queryByPosid("FJZ").getId().toString();

                    this.setVariable("level2spr", upOrg.getOrgcode()+"_"+fjz);

                }else if("30".equals(sqrOrgLevel)){//市局环保大队申请的 由支队长审批
                    String zdz=orgPositionService.queryByPosid("ZDZ").getId().toString();
                    this.setVariable("level2spr", upOrg.getOrgcode()+"_"+zdz);
                }else if("".equals(sqrOrgLevel)){//省厅环保大队申请的

                }
            }
        }
    }

    @Override
    public void sendMsgByType(BaseWorkFlowBean baseWorkFlowBean, String msgType) {

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
        ZdryZb zdryzb = (ZdryZb) variables.get("zdryZb");
        Zdry zdrylbdx = (Zdry) variables.get("zdrylbdx");
        ZdryService zdryService = zdryFactory.createZdryService(zdrylx, zdryzb, zdrylbdx);
        ZOBean entity = new ZOBean(zdryzb, zdrylbdx);
        if(resultType.trim().equals("0")){
            //String zdryId = (String) variables.get("zdryId");
            //add sp reason
            zdryzb.setXt_zxyy("审批未通过");
            ZdryZbUtil.setXtZxyy(zdrylbdx, "审批未通过");
            zdryService.lgFail(sessionBean,entity);
            return;
        }else if(resultType.trim().equals("1")){
            zdryService.lgSuccess(sessionBean,entity);
            return;
        }else{
            System.out.println("审批结果异常");
            return;
        }
    }
}
