package com.founder.zdrygl.core.decorator;

import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.workflow.service.inteface.JProcessDefinitionService;
import com.founder.zdrygl.core.inteface.ZdryService;
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

	// private 流程开始对象

	//	@Autowired
	private JProcessDefinitionService processDefinitionService;


	public ZdryServiceDecorator(ZdryService zdryService){
		this.zdryService = zdryService;
	}

	@Override
	public final void lg(SessionBean sessionBean) {
		zdryService.lg(sessionBean);
		lg_(sessionBean);
		if(checkWorkFlow()) 
			processDefinitionService.startProcessInstance("", "", "",null);

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
		zdryService.zl(sessionBean);
	}

	@Override
	public final void zlSuccess(SessionBean sessionBean) {
		zdryService.zlSuccess(sessionBean);
	}

	@Override
	public final void zlFail(SessionBean sessionBean) {
		zdryService.zlFail(sessionBean);
	}

	@Override
	public final void zd(SessionBean sessionBean) {
		zdryService.zd(sessionBean);
	}

	@Override
	public final void zdSuccess(SessionBean sessionBean) {
		zdryService.zdSuccess(sessionBean);
	}

	@Override
	public final void zdFail(SessionBean sessionBean) {
		zdryService.zdFail(sessionBean);
	}
	
	@Override
	public Zdry getZdry() {
		return zdryService.getZdry();
	}
	
	@Override
	public String getZdryId() {
		return getZdry().getId();
	}

	protected abstract void lg_(SessionBean sessionBean);

	protected abstract void cg_(SessionBean sessionBean);

	private boolean checkWorkFlow(){
		return processDefinitionService != null;
	}
}
