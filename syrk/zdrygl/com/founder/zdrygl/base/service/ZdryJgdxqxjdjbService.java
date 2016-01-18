package com.founder.zdrygl.base.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.UUID;
import com.founder.workflow.bean.StartProcessInstance;
import com.founder.workflow.service.inteface.JProcessDefinitionService;
import com.founder.zdrygl.base.dao.ZdryJgdxqxjdjbDao;
import com.founder.zdrygl.base.model.ZdryJgdxqxjdjb;
import com.founder.zdrygl.base.service.wf.LcgFlagEnum;
import com.founder.zdrygl.base.service.wf.WorkFlowParametersInitialService;
import com.founder.zdrygl.base.vo.ZdryVO;
import com.founder.zdrygl.core.model.Zdry;
import com.founder.zdrygl.core.utils.ZdryConstant;


/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.service.ZdryJgdxqxjdjbService.java]  
 * @ClassName:    [ZdryJgdxqxjdjbService]   
 * @Description:  [监管对象请销假服务类]   
 * @Author:       [zhang.hai@founder.com.cn]  
 * @CreateDate:   [2015年9月6日 下午3:28:12]   
 * @UpdateUser:   [ZhangHai(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年9月6日 下午3:28:12，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Service("zdryJgdxqxjdjbService")
@Transactional
public class ZdryJgdxqxjdjbService extends BaseService {

	@Resource(name = "zdryJgdxqxjdjbDao")
	private ZdryJgdxqxjdjbDao zdryJgdxqxjdjbDao;
	
	@Autowired
	private ZdryConstant zdryConstant;

	@Autowired
	private JProcessDefinitionService processDefinitionService;
	
	@Resource(name = "zdryQueryService")
	private ZdryInfoQueryService zdryQueryService;

	/**
	 * @Title: queryById
	 * @Description: (根据ID查询单条记录)
	 * @param @param id
	 * @param @return 设定文件
	 * @return ZdryJgdxqxjdjb 返回类型
	 * @throws
	 */
	
	public ZdryJgdxqxjdjb queryById(String id) {
		return zdryJgdxqxjdjbDao.queryById(id);
	}

	
	public void save(ZdryJgdxqxjdjb entity, SessionBean sessionBean, ZdryVO zdryVO) {
		entity.setId(UUID.create()); // 生成主键
		BaseService.setSaveProperties(entity, sessionBean);
		zdryJgdxqxjdjbDao.save(entity, sessionBean);
		
		Zdry zdryzb = zdryQueryService.queryById(zdryVO.getZdryJgdxqxjdjb().getZdryid());
		// start process
		WorkFlowParametersInitialService wfpis = new WorkFlowParametersInitialService(zdryConstant,zdryQueryService);
		StartProcessInstance spi = wfpis.initialProcessInstance(sessionBean, zdryVO,LcgFlagEnum.QXJ);
		spi.getVariables().put("zdryZb", zdryzb);
		spi.getVariables().put("jgdx", zdryVO.getZdryJgdxqxjdjb());
		processDefinitionService.startProcessInstance(spi.getApplyUserId(),spi.getProcessKey(), spi.getBusinessKey(), spi.getVariables());
	}

	
	public void update(ZdryJgdxqxjdjb entity, SessionBean sessionBean) {
		BaseService.setUpdateProperties(entity, sessionBean);
		zdryJgdxqxjdjbDao.update(entity);
	}

	/**
	 * 
	 * @Title: sfnqj
	 * @Description: (查询是否可请假)
	 * @param @param zdryId
	 * @param @return    设定文件
	 * @return boolean    返回类型
	 * @throw
	 */
	public boolean sfnqj(String zdryId) {		
		if(zdryJgdxqxjdjbDao.queryWxjNum(zdryId)>0){
			return false;
		}
		return true;
	}
	/**
	 * 更新审批<br>
	 * 
	 * @param entity
	 */
	public void updateSp(ZdryJgdxqxjdjb entity, SessionBean sessionBean) {
		BaseService.setUpdateProperties(entity, sessionBean);
		entity.setSpr_xm(sessionBean.getUserName());
		entity.setSpr_id(sessionBean.getUserId());
		entity.setSpsj(DateUtils.getSystemDateTimeString());
		zdryJgdxqxjdjbDao.updateSp(entity, sessionBean);
	
	}
}
