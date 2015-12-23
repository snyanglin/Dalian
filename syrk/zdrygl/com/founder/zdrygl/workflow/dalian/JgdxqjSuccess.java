package com.founder.zdrygl.workflow.dalian;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.WebUtils;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.exception.BussinessException;
import com.founder.workflow.bean.BaseWorkFlowBean;
import com.founder.workflow.service.activiti.lisener.WorkflowDelegate;
import com.founder.zdrygl.base.message.MessageDict;
import com.founder.zdrygl.base.model.ZdryJgdxqxjdjb;
import com.founder.zdrygl.base.model.ZdryZb;
import com.founder.zdrygl.base.service.ZdryJgdxqxjdjbService;
import com.founder.zdrygl.core.inteface.JwzhMessageService;
import com.founder.zdrygl.workflow.utils.WorkflowUtil;
/**
 * ****************************************************************************
 * @Package:      [com.founder.activiti.demo.workflow.dalian.JgdxqjSuccess.java]  
 * @ClassName:    [JgdxqjSuccess]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [huang_jifei@founder.com.cn]  
 * @CreateDate:   [2015年12月7日 下午4:16:33]   
 * @UpdateUser:   [huangjifei(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年12月7日 下午4:16:33，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Component
public class JgdxqjSuccess extends WorkflowDelegate{

	@Resource(name="zdryJgdxqxjdjbService")
	ZdryJgdxqxjdjbService ZdryJgdxqxjdjbService;
    @Autowired
    private JwzhMessageService jwzhMessageService;
    @Resource(name="workflowUtil")
    private WorkflowUtil workflowUtil;
	@Override
	public void doBusiness(BaseWorkFlowBean arg0) {
		Map<String,Object> variables = arg0.getProcessVariables();
		try {
			String spyj=(String) variables.get("spyj");
			ZdryZb zdryzb = (ZdryZb) variables.get("zdryZb");
			ZdryJgdxqxjdjb entity = (ZdryJgdxqxjdjb) variables.get("jgdx");

			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes()).getRequest();
			SessionBean sessionBean = (SessionBean) WebUtils.getSessionAttribute(
					request, AppConst.USER_SESSION);
			entity.setSpjg("1");//不同意，不准假
			entity.setSpyj(spyj);
			ZdryJgdxqxjdjbService.updateSp(entity, sessionBean);
			//send message
			Map<String,Object> paraObj = workflowUtil.getMessageParam(sessionBean,zdryzb);//获取消息的参数
			paraObj.put("result", "qjSuccess");
			jwzhMessageService.sendMessage(MessageDict.ZDRYGL.JGDXQXJSPJG,paraObj);
		} catch(BussinessException aa){
			 throw  new BussinessException("重点人员请假出错");//抛出异常  
		}

	}

}
