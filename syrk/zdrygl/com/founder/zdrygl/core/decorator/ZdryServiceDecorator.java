package com.founder.zdrygl.core.decorator;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.exception.BussinessException;
import com.founder.framework.message.bean.MessageDict;
import com.founder.framework.message.service.JwzhMessageService;
import com.founder.workflow.bean.StartProcessInstance;
import com.founder.workflow.service.inteface.JProcessDefinitionService;
import com.founder.zdrygl.base.model.ZdryZb;
import com.founder.zdrygl.base.model.Zdrycx;
import com.founder.zdrygl.core.inteface.ZdryService;
import com.founder.zdrygl.core.model.ZOBean;
import com.founder.zdrygl.core.model.Zdry;
import com.founder.zdrygl.core.utils.ZdryConstant;
import com.founder.zdrygl.workflow.utils.ZdryZbUtil;

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
	public final void lg(SessionBean sessionBean , ZOBean entity){
		zdryService.lg(sessionBean, entity);
		setZdrylbdxId(entity);
		lg_(sessionBean,entity.getZdrylbdx());
		if(entity.getStartProcessInstance()!=null && entity.getStartProcessInstance().isHasWorkflow()){
			entity.setProcessInstanceBusinessKey(entity.getZdryzb().getId());
			entity.getStartProcessInstance().getVariables().put("zdryId", entity.getZdryzbId());
			entity.getStartProcessInstance().getVariables().put("zdryZb", entity.getZdryzb());
			entity.getStartProcessInstance().getVariables().put("zdrycx", entity.getZdrycx());
			entity.getStartProcessInstance().getVariables().put("zdrylbdx", entity.getZdrylbdx());
			startProcessInstance(entity.getStartProcessInstance());
		}
	}

	@Override
	public final void lgSuccess(SessionBean sessionBean , ZOBean entity){
		zdryService.lgSuccess(sessionBean,entity);	
		Map<String,Object> paraObj = getMessageParam(sessionBean,entity.getZdryzb());
		paraObj.put("result", "lgSuccess");
		paraObj.put("zdryId", entity.getZdryzbId());
		sendMessage(MessageDict.ZDRYGL.LGSPJG,paraObj);
	}
	
	@Override
	public final void lgFail(SessionBean sessionBean, ZOBean entity) {
		zdryService.lgFail(sessionBean,entity);
		lgFail_(sessionBean, entity.getZdrycx());
		Map<String,Object> paraObj = getMessageParam(sessionBean,entity.getZdryzb());
		paraObj.put("result", "lgFail");
		paraObj.put("zdryId", entity.getZdryzbId());
		sendMessage(MessageDict.ZDRYGL.LGSPJG,paraObj);
	}
	
	@Override
	public final void cg(SessionBean sessionBean , ZOBean entity){
		zdryService.cg(sessionBean, entity);
		setZdrylbdxId(entity);
		cg_(sessionBean,entity.getZdrylbdx());
		if(entity.getStartProcessInstance()!=null  && entity.getStartProcessInstance().isHasWorkflow()){
			entity.setProcessInstanceBusinessKey(entity.getZdryzb().getId());
			entity.getStartProcessInstance().getVariables().put("zdryId", entity.getZdryzbId());
			entity.getStartProcessInstance().getVariables().put("zdryZb", entity.getZdryzb());
			entity.getStartProcessInstance().getVariables().put("zdrycx", entity.getZdrycx());
			entity.getStartProcessInstance().getVariables().put("zdrylbdx", entity.getZdrylbdx());
			startProcessInstance(entity.getStartProcessInstance());
		}
	}
	
	@Override
	public final void cgSuccess(SessionBean sessionBean , ZOBean entity) {
		zdryService.cgSuccess(sessionBean,entity);
		//注销原子表列管记录
		Zdry subZdry = ZdryZbUtil.getZdrylbdx( (Zdrycx) entity.getZdrycx());
		subZdry.setId(entity.getZdrycx().getId());
		cgFail_(sessionBean, subZdry);
		//发送消息
		Map<String,Object> paraObj = getMessageParam(sessionBean,entity.getZdryzb());
		paraObj.put("result", "cgSuccess");
		paraObj.put("zdryId", entity.getZdryzbId());
		sendMessage(MessageDict.ZDRYGL.CGSPJG,paraObj);
	}

	@Override
	public final void cgFail(SessionBean sessionBean , ZOBean entity) {
		zdryService.cgFail(sessionBean,entity);
		cgFail_(sessionBean, entity.getZdrylbdx());
		Map<String,Object> paraObj = getMessageParam(sessionBean,entity.getZdryzb());
		paraObj.put("result", "cgFail");
		paraObj.put("zdryId", entity.getZdryzbId());
		sendMessage(MessageDict.ZDRYGL.CGSPJG,paraObj);
	}

	@Override
	public final void zl(SessionBean sessionBean, ZOBean entity) {
		//转类（小类）不涉及子表的修改
		zdryService.zl(sessionBean, entity);//新加，改变状态
		if(entity.getStartProcessInstance()!= null){
			entity.setProcessInstanceBusinessKey(entity.getZdryzb().getId());
			entity.getStartProcessInstance().getVariables().put("zdryId", entity.getZdryzbId());
			startProcessInstance(entity.getStartProcessInstance());
		}
	}

	@Override
	public final void zlSuccess(SessionBean sessionBean, ZOBean entity) {
		//转类（小类）不涉及子表的修改
		zdryService.zlSuccess(sessionBean ,entity);
	}

	@Override
	public final void zlFail(SessionBean sessionBean, ZOBean entity) {
		//转类（小类）不涉及子表的修改
		zdryService.zlFail(sessionBean , entity);
	}

	@Override
	public final void zd(SessionBean sessionBean , ZOBean entity) {
		zdryService.zd(sessionBean,entity);//新加，改变状态
		setZdrylbdxId(entity);
		zd_(sessionBean,entity.getZdrylbdx());
		if(entity.getStartProcessInstance()!=null){
			entity.setProcessInstanceBusinessKey(entity.getZdryzb().getId());
			entity.getStartProcessInstance().getVariables().put("zdryId", entity.getZdryzbId());
			entity.getStartProcessInstance().getVariables().put("zdryZb", entity.getZdryzb());
			entity.getStartProcessInstance().getVariables().put("zdrycx", entity.getZdrycx());
			entity.getStartProcessInstance().getVariables().put("zdrylbdx", entity.getZdrylbdx());
			startProcessInstance(entity.getStartProcessInstance());
		}
	}

	@Override
	public final void zdSuccess(SessionBean sessionBean , ZOBean entity) {
		Map<String,Object> paraObj = getMessageParam(sessionBean,entity.getZdryzb());//获取消息的参数
		if(entity.getMsgType()!=null && !entity.getMsgType().trim().equals("")){
			paraObj.put("result", entity.getMsgType());
		}else{
			paraObj.put("result", "zdSuccess");
		}
		paraObj.put("zdryId", entity.getZdryzbId());

		//put sqrId/sqrName into map, to support send message
		paraObj.put("jsrUserId", sessionBean.getExtendMap().get("sqrId"));
		paraObj.put("jsrUserName", sessionBean.getExtendMap().get("sqrName"));
		//clear used data
		sessionBean.getExtendMap().remove("sqrId");
		sessionBean.getExtendMap().remove("sqrName");
		
		zdryService.zdSuccess(sessionBean ,entity);
		sendMessage(MessageDict.ZDRYGL.ZDSPJG,paraObj);
	}

	@Override
	public final void zdFail(SessionBean sessionBean , ZOBean entity) {
		Map<String,Object> paraObj = getMessageParam(sessionBean,entity.getZdryzb());//获取消息的参数
		paraObj.put("result", "zdFail");
		paraObj.put("zdryId", entity.getZdryzbId());
		
		//put sqrId/sqrName into map, to support send message
		paraObj.put("jsrUserId", sessionBean.getExtendMap().get("sqrId"));
		paraObj.put("jsrUserName", sessionBean.getExtendMap().get("sqrName"));
		//clear used data
		sessionBean.getExtendMap().remove("sqrId");
		sessionBean.getExtendMap().remove("sqrName");
		
		zdryService.zdFail(sessionBean,entity);
		zdFail_(sessionBean, entity.getZdrylbdx());
		sendMessage(MessageDict.ZDRYGL.ZDSPJG,paraObj);
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
	public final void update(SessionBean sessionBean, ZOBean zdry) {
		zdryService.update(sessionBean,zdry);//总表修改
		update_(sessionBean,zdry.getZdrylbdx());
	}

	protected abstract void lg_(SessionBean sessionBean,Zdry zdrylbdx);
	
	protected abstract void lgFail_(SessionBean sessionBean,Zdry zdrylbdx);

	protected abstract void cg_(SessionBean sessionBean,Zdry zdrylbdx);
	
	protected abstract void cgFail_(SessionBean sessionBean,Zdry zdrylbdx);

	protected abstract void zd_(SessionBean sessionBean,Zdry zdrylbdx);
	
	protected abstract void zdFail_(SessionBean sessionBean,Zdry zdrylbdx);
	
	protected abstract void update_(SessionBean sessionBean,Zdry zdrylbdx);
	
	
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
	protected Map<String,Object> getMessageParam(SessionBean sessionBean , Zdry zdry){
        //私有参数处理
        Map<String,Object> paramObj = new HashMap<String,Object>();
        paramObj.put("fsrName", sessionBean.getUserName());//发送人姓名
        paramObj.put("fsrUserCode", sessionBean.getUserId());//发送人代码	
        paramObj.put("fsrOrgName", sessionBean.getUserOrgName());//发送人机构名
        paramObj.putAll(getZdryXmAndZdrylxName(zdry));
        return paramObj;
	}
	
	@Override
	public final Map<String,String> getZdryXmAndZdrylxName(Zdry zdry){
		return zdryService.getZdryXmAndZdrylxName(zdry);
	}
	
	public void setZdrylbdxId(ZOBean entity){
		if(entity.getZdrylbdx() != null)
			entity.getZdrylbdx().setId(entity.getZdryzb().getId());
	}
	
	private void startProcessInstance(StartProcessInstance startProcessInstance){
		if(startProcessInstance != null && StringUtils.isEmpty(startProcessInstance.getProcessKey())){
			throw new BussinessException("缺少流程启动参数！");
		}else{
			processDefinitionService.startProcessInstance(startProcessInstance.getApplyUserId(),startProcessInstance.getProcessKey(), startProcessInstance.getBusinessKey(), startProcessInstance.getVariables());
		}
	}
	
	private void sendMessage(String xxlx ,Map<String,Object> source ){
		try{
		jwzhMessageService.sendMessage(xxlx,source);
		}catch(Exception e){
			
		}
	}
}
