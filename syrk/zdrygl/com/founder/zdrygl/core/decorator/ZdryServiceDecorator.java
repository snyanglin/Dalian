package com.founder.zdrygl.core.decorator;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.exception.BussinessException;
import com.founder.workflow.bean.StartProcessInstance;
import com.founder.workflow.service.inteface.JProcessDefinitionService;
import com.founder.zdrygl.base.message.MessageDict;
import com.founder.zdrygl.core.inteface.JwzhMessageService;
import com.founder.zdrygl.core.inteface.ZdryService;
import com.founder.zdrygl.core.model.Zdry;
import com.founder.zdrygl.core.utils.ZdryConstant;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.core.decorator.ZdryServiceDecorator.java]  
 * @ClassName:    [ZdryServiceDecorator]   
 * @Description:  [重点人员业务服务装饰器]   
 * @Author:       [wei.wen@founder.com.cn]  
 * @CreateDate:   [2015年8月31日 下午3:52:17]   
 * @UpdateUser:   [wei.wen@founder.com.cn(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年8月31日 下午3:52:17，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Transactional
public abstract class ZdryServiceDecorator implements ZdryService{

	protected ZdryService zdryService;

	/**
	 * 流程启动对象
	 */
	private StartProcessInstance processInstance;
		
    @Autowired
	private JProcessDefinitionService processDefinitionService;
    @Autowired
    private JwzhMessageService jwzhMessageService;
    
    @Autowired
	private ZdryConstant zdryConstant;

	public ZdryServiceDecorator(ZdryService zdryService){
		this.zdryService = zdryService;
	}

	@Override
	public final void lg(SessionBean sessionBean) {
		zdryService.lg(sessionBean);
		lg_(sessionBean);
		
		Object paraObj = getMessageParam(sessionBean);//获取消息的参数
		jwzhMessageService.sendMessage(MessageDict.ZDRYGL.LGSQ,paraObj);
		
		//put zdryId & name to variables
		processInstance.setBusinessKey(zdryService.getZdryId());
		processInstance.getVariables().put("zdryId", zdryService.getZdryId());
		
		if(checkWorkFlow()) {
			if(processInstance != null && StringUtils.isEmpty(processInstance.getProcessKey())){
				throw new BussinessException("缺少流程启动参数！");
			}else{
				processDefinitionService.startProcessInstance(processInstance.getApplyUserId(),processInstance.getProcessKey(), processInstance.getBusinessKey(), processInstance.getVariables());
			}
		}
	}

	@Override
	public final void lgSuccess(SessionBean sessionBean) {
		zdryService.lgSuccess(sessionBean);		
	}

	@Override
	public final void lgFail(SessionBean sessionBean) {
		zdryService.lgFail(sessionBean);
	}

	@Override
	public final void cg(SessionBean sessionBean) {
		zdryService.cg(sessionBean);
		cg_(sessionBean);
		//put zdryId & name to variables
		processInstance.setBusinessKey(zdryService.getZdryId());
		processInstance.getVariables().put("zdryId", zdryService.getZdryId());
		
		if(checkWorkFlow()) {
			if(processInstance != null && StringUtils.isEmpty(processInstance.getProcessKey())){
				throw new BussinessException("缺少流程启动参数！");
			}else{
				processDefinitionService.startProcessInstance(processInstance.getApplyUserId(),processInstance.getProcessKey(), processInstance.getBusinessKey(), processInstance.getVariables());
			}
		}
	}

	@Override
	public final void cgSuccess(SessionBean sessionBean) {
		zdryService.cgSuccess(sessionBean);
	}

	@Override
	public final void cgFail(SessionBean sessionBean) {
		zdryService.cgFail(sessionBean);
	}

	@Override
	public final void zl(SessionBean sessionBean) {
		//转类（小类）不涉及子表的修改
		zdryService.zl(sessionBean);//新加，改变状态
		if(checkWorkFlow()) {
			if(processInstance != null && StringUtils.isEmpty(processInstance.getProcessKey())){
				throw new BussinessException("缺少流程启动参数！");
			}else{
				processDefinitionService.startProcessInstance(processInstance.getApplyUserId(),processInstance.getProcessKey(), processInstance.getBusinessKey(), processInstance.getVariables());
			}
		}
	}

	@Override
	public final void zlSuccess(SessionBean sessionBean) {
		//转类（小类）不涉及子表的修改
		zdryService.zlSuccess(sessionBean);
	}

	@Override
	public final void zlFail(SessionBean sessionBean) {
		//转类（小类）不涉及子表的修改
		zdryService.zlFail(sessionBean);
	}

	@Override
	public final void zd(SessionBean sessionBean) {
		//转递不涉及子表的修改
		zdryService.zd(sessionBean);//新加，改变状态
		if(checkWorkFlow()) {
			if(processInstance != null && StringUtils.isEmpty(processInstance.getProcessKey())){
				throw new BussinessException("缺少流程启动参数！");
			}else{
				processDefinitionService.startProcessInstance(processInstance.getApplyUserId(),processInstance.getProcessKey(), processInstance.getBusinessKey(), processInstance.getVariables());
			}
		}
	}

	@Override
	public final void zdSuccess(SessionBean sessionBean) {
		//转递不涉及子表的修改
		zdryService.zdSuccess(sessionBean);
	}

	@Override
	public final void zdFail(SessionBean sessionBean) {
		//转递不涉及子表的修改
		zdryService.zdFail(sessionBean);
	}
	
	/**
	 * 
	 * @Title: update
	 * @Description: (修改，重点人员编辑页面用)
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throw
	 */
	@Override
	public final void update(SessionBean sessionBean) {
		zdryService.update(sessionBean);//总表修改
		update_(sessionBean);//子表修改		
	}
	
	/**
	 * 
	 * @Title: queryZdryAllInfo
	 * @Description: TODO(查询重点人员总表和子表)
	 * @param @param zdryid
	 * @return void    返回类型
	 * @throw
	 */
//	@Override
//	public final Zdry[] queryZdryAllInfo(String zdryid) {
//		Zdry[] zdryArray = zdryService.queryZdryAllInfo(zdryid);
//		zdryArray[1] = queryZdryInfo_(zdryid);
//		return zdryArray;
//	}
	
	@Override
	public Zdry getZdry() {
		return zdryService.getZdry();
	}
	
	@Override
	public String getZdryId() {
		return getZdry().getId();
	}
	
	
	@Override
	public final void setStartProcessInstance(String processKey, String applyUserId, Map<String,Object> variables){
		if(processInstance == null){
			processInstance = new StartProcessInstance();
		}
		processInstance.setProcessKey(processKey);
		processInstance.setApplyUserId(applyUserId);
		processInstance.setVariables(variables);
	}
		
	
	protected abstract void lg_(SessionBean sessionBean);

	protected abstract void cg_(SessionBean sessionBean);
	
	protected abstract void update_(SessionBean sessionBean);
	
//	protected abstract Zdry queryZdryInfo_(String zdryid);
	
	/**
	 * 
	 * @Title: getMessageParam
	 * @Description: (获取消息生产需要的参数)
	 * @param @param paraObj
	 * @param @return    设定文件
	 * @return Object    返回类型
	 * @throw
	 */
	protected Object getMessageParam(SessionBean sessionBean){
		Map<String,Object> paramMap = new HashMap<String,Object>();
        
        //私有参数处理
        Map<String,Object> paramObj = new HashMap<String,Object>();
        paramObj.put("fsrName", sessionBean.getUserName());//发送人姓名
        paramObj.put("fsrUserCode", sessionBean.getUserId());//发送人代码	
        paramObj.put("fsrOrgName", sessionBean.getUserOrgName());//发送人机构名
        paramObj.putAll(getZdryXmAndZdrylxName());
        paramMap.put("paramObj", paramObj);
        
        return paramMap;
	}
	
	@Override
	public final  Map<String,String> getZdryXmAndZdrylxName(){
		return zdryService.getZdryXmAndZdrylxName();
	}

	private boolean checkWorkFlow(){
		return processDefinitionService != null;
	}
}
