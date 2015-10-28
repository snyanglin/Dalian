package com.founder.zdrygl.core.decorator;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.exception.BussinessException;
import com.founder.workflow.bean.StartProcessInstance;
import com.founder.workflow.service.inteface.JProcessDefinitionService;
import com.founder.zdrygl.base.message.MessageDict;
import com.founder.zdrygl.base.vo.ZdryVO;
import com.founder.zdrygl.core.inteface.JwzhMessageService;
import com.founder.zdrygl.core.inteface.ZdryService;
import com.founder.zdrygl.core.model.MessageSource;
import com.founder.zdrygl.core.model.Zdry;

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
	
	/**
	 * 消息源对象
	 */
	private MessageSource messageSource;
	
    @Autowired
	private JProcessDefinitionService processDefinitionService;
    @Autowired
    private JwzhMessageService jwzhMessageService;


	public ZdryServiceDecorator(ZdryService zdryService){
		this.zdryService = zdryService;
	}

	@Override
	public final void lg(SessionBean sessionBean) {
		zdryService.lg(sessionBean);
		lg_(sessionBean);
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
		// TODO 
//		if(messageSource != null){
//			jwzhMessageService.sendMessage(MessageDict.XXLX_LGSPJG,getZdry(), MessageDict.JSLX_TO_USER, "");
//		}
	}

	@Override
	public final void lgFail(SessionBean sessionBean) {
		zdryService.lgFail(sessionBean);
	}

	@Override
	public final void cg(SessionBean sessionBean) {
		zdryService.cg(sessionBean);
		cg_(sessionBean);
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
	}

	@Override
	public final void zlSuccess(SessionBean sessionBean) {
		//转类（小类）不涉及子表的修改
	}

	@Override
	public final void zlFail(SessionBean sessionBean) {
		//转类（小类）不涉及子表的修改
	}

	@Override
	public final void zd(SessionBean sessionBean) {
		//转递不涉及子表的修改
	}

	@Override
	public final void zdSuccess(SessionBean sessionBean) {
		//转递不涉及子表的修改
	}

	@Override
	public final void zdFail(SessionBean sessionBean) {
		//转递不涉及子表的修改
	}
	
	/**
	 * 
	 * @Title: update
	 * @Description: TODO(修改)
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
	 * @param @param zdryVO    设定文件
	 * @return void    返回类型
	 * @throw
	 */
	@Override
	public void queryZdryAllInfo(String zdryid,ZdryVO zdryVO) {
		zdryService.queryZdryAllInfo(zdryid,zdryVO);
		queryZdryAllInfo_(zdryid,zdryVO);
	}
	
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
	
	@Override
	public final void setMessageSource(String xxlx, Object source, String jslx, Object jsdx){
		messageSource.setXxlx(xxlx);
		messageSource.setSource(source);
		messageSource.setJslx(jslx);
		messageSource.setJsdx(jsdx);
	}
	
	protected abstract void lg_(SessionBean sessionBean);

	protected abstract void cg_(SessionBean sessionBean);
	
	protected abstract void update_(SessionBean sessionBean);
	
	protected abstract void queryZdryAllInfo_(String zdryid,ZdryVO zdryVO);

	private boolean checkWorkFlow(){
		return processDefinitionService != null;
	}
}
