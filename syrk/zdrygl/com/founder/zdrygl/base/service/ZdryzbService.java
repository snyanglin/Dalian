package com.founder.zdrygl.base.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.ParaAnnotation;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.UUID;
import com.founder.zdrygl.base.dao.ZdryZdryZbDao;
import com.founder.zdrygl.base.model.ZdryZb;
import com.founder.zdrygl.base.model.Zdrycg;
import com.founder.zdrygl.base.vo.ZdryVO;
import com.founder.zdrygl.core.inteface.ZdryService;
import com.founder.zdrygl.core.inteface.ZdryglMessageService;
import com.founder.zdrygl.core.model.Zdry;
import com.founder.zdrygl.core.utils.ZdryConstant;
/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.base.service.ZdryzbService.java]  
 * @ClassName:    [ZdryzbService]   
 * @Description:  [重点人员总表业务服务]   
 * @Author:       [wei.wen@founder.com.cn]  
 * @CreateDate:   [2015年9月16日 下午5:23:22]   
 * @UpdateUser:   [wei.wen@founder.com.cn(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年9月16日 下午5:23:22，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@TypeAnnotation("重点人员管理")
public class ZdryzbService implements ZdryService {
	
	/**
	 * 重点人员总表对象，需要存日志表，必须是public或者指定获取方法getZdry
	 */
	@ParaAnnotation("getZdry")
	private ZdryZb zdryzb;
	
	/**
	 * 撤管对象
	 */
	private Zdrycg zdrycg;
	
	@Autowired
	private ZdryZdryZbDao zdryZdryZbDao;
	
	@Resource(name="zdryglMessageService")
	private ZdryglMessageService zdryglMessageService;

	@MethodAnnotation(value = "列管", type = logType.insert)
	@Override
	public void lg(SessionBean sessionBean) {
		zdryzb.setId(UUID.create());
		zdryzb.setGlzt(ZdryConstant.LGSQ);
		zdryzb.setGlbm(sessionBean.getUserOrgCode());//管理部门
		BaseService.setSaveProperties(zdryzb, sessionBean);		
		zdryZdryZbDao.insert(zdryzb);
	}

	@Override
	public void lgSuccess(SessionBean sessionBean) {
		zdryzb.setGlzt(ZdryConstant.YLG);
		updateZdry(sessionBean,zdryzb);
	}

	@Override
	public void lgFail(SessionBean sessionBean) {
		deleteZdry(sessionBean,zdryzb);
	}

	@MethodAnnotation(value = "撤管", type = logType.update)
	@Override
	public void cg(SessionBean sessionBean) {
		ZdryZb entity = new ZdryZb();
		entity.setId(zdrycg.getZdryid_old());
		entity.setGlzt(ZdryConstant.CGSQ);
		updateZdry(sessionBean,entity);				
		if(!isDelete()){
			this.lg(sessionBean);			
		}
	}

	@Override
	public void cgSuccess(SessionBean sessionBean) {
		ZdryZb entity = new ZdryZb();
		entity.setId(zdrycg.getZdryid_old());
		entity.setGlzt(ZdryConstant.YCG);
		deleteZdry(sessionBean,entity);
		if(!isDelete()){
			zdryzb.setGlzt(ZdryConstant.YLG);
			updateZdry(sessionBean,zdryzb);
		}
	}

	@Override
	public void cgFail(SessionBean sessionBean) {
		ZdryZb entity = new ZdryZb();
		entity.setId(zdrycg.getZdryid_old());
		entity.setGlzt(ZdryConstant.YLG);
		if(!isDelete()){
			deleteZdry(sessionBean,zdryzb);
		}
	}

	@MethodAnnotation(value = "转类", type = logType.update)
	@Override	
	public void zl(SessionBean sessionBean) {		
		//查询原有信息，发送消息的时候需要
		ZdryZb old = (ZdryZb) zdryZdryZbDao.queryById(zdryzb.getId());
		old.setGlzt(ZdryConstant.ZLSQ);
		old.setZdrylb(zdryzb.getZdrylb());		
		updateZdry(sessionBean,old);				
	}

	@Override
	public void zlSuccess(SessionBean sessionBean) {
		zdryzb.setGlzt(ZdryConstant.YLG);
		deleteZdry(sessionBean,zdryzb);
	}

	@Override
	public void zlFail(SessionBean sessionBean) {
		zdryzb.setGlzt(ZdryConstant.YLG);
		updateZdry(sessionBean,zdryzb);
	}

	@MethodAnnotation(value = "转递", type = logType.update)
	@Override
	public void zd(SessionBean sessionBean) {
		ZdryZb entity = new ZdryZb();
		entity.setId(zdryzb.getId());
		entity.setGlzt(ZdryConstant.ZDSQ);
		entity.setGlbm(zdryzb.getGlbm());	
		entity.setJzd_dzid(zdryzb.getJzd_dzid());
		entity.setJzd_dzxz(zdryzb.getJzd_dzxz());
		entity.setJzd_mlpdm(zdryzb.getJzd_mlpdm());
		entity.setJzd_mlpxz(zdryzb.getJzd_mlpxz());
		entity.setJzd_xzqhdm(zdryzb.getJzd_xzqhdm());
		entity.setJzd_zbx(zdryzb.getJzd_zbx());
		entity.setJzd_zby(zdryzb.getJzd_zby());
		
		updateZdry(sessionBean,entity);
	}

	@Override
	public void zdSuccess(SessionBean sessionBean) {
		zdryzb.setGlzt(ZdryConstant.YLG);
		deleteZdry(sessionBean,zdryzb);
	}

	@Override
	public void zdFail(SessionBean sessionBean) {
		zdryzb.setGlzt(ZdryConstant.YLG);
		updateZdry(sessionBean,zdryzb);
	}
	
	/**
	 * 
	 * @Title: update
	 * @Description: TODO(修改)
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throw
	 */
	@MethodAnnotation(value = "修改", type = logType.update)
	@Override
	public final void update(SessionBean sessionBean) {
		//总表还不确定要修改	
	}

	private void updateZdry(SessionBean sessionBean,ZdryZb entity){
		BaseService.setUpdateProperties(entity, sessionBean);
		zdryZdryZbDao.update(entity);
	}
	private void deleteZdry(SessionBean sessionBean,ZdryZb entity){
		BaseService.setCrossoutProperties(entity, sessionBean);
		zdryZdryZbDao.delete(entity);
	}
	
	/**
	 * 
	 * @Title: isDelete
	 * @Description: (判断是注销还是撤管)
	 * @param @return    设定文件
	 * @return boolean    返回类型
	 * @throws
	 */
	private boolean isDelete(){
		if(zdrycg != null && !StringUtils.isEmpty(zdrycg.getZdrygllxdm())){
			return false;
		}
		return true;
	}

	@Override
	public void setZdry(Zdry entity) {
		if(entity!=null){
			if(entity.getClass().getName().equals(Zdrycg.class.getName())){
				this.zdrycg = (Zdrycg) entity;
				this.zdryzb = new ZdryZb();
				BeanUtils.copyProperties(zdrycg, zdryzb);
			}else{
				this.zdryzb = (ZdryZb) entity;
			}
		}
	}

	@Override
	public Zdry getZdry() {
		return zdryzb;
	}

	@Override
	public String getZdryId() {
		return getZdry().getId();
	}

	@Override
	@Deprecated  
	public void setStartProcessInstance(String processKey, String businessKey,
			String applyUserId, Map<String, Object> variables) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Deprecated  
	public void setMessageSource(String xxlx, Object source, String jslx,
			Object jsdx) {
		// TODO Auto-generated method stub
		
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
		zdryVO.setZdryZdryzb((ZdryZb)zdryZdryZbDao.queryById(zdryid));
	}
}
