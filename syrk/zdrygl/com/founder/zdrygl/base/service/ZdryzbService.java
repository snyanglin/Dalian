package com.founder.zdrygl.base.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.components.AppConst;
import com.founder.framework.utils.UUID;
import com.founder.syrkgl.bean.SyrkSyrkxxzb;
import com.founder.syrkgl.service.SyrkSyrkxxzbService;
import com.founder.zdrygl.base.dao.ZdryZdryZbDao;
import com.founder.zdrygl.base.model.ZdryZb;
import com.founder.zdrygl.base.model.Zdrycx;
import com.founder.zdrygl.core.inteface.ZdryService;
import com.founder.zdrygl.core.model.ZOBean;
import com.founder.zdrygl.core.model.Zdry;
import com.founder.zdrygl.core.utils.ZdryConstant;
import com.founder.zdrygl.workflow.utils.ZdryZbUtil;
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
	
	@Autowired
	private ZdryZdryZbDao zdryZdryZbDao;	
	
	@Autowired
	private ZdryConstant zdryConstant;

	@Resource(name = "syrkSyrkxxzbService")
	private SyrkSyrkxxzbService syrkSyrkxxzbService;
 
	@MethodAnnotation(value = "列管", type = logType.insert)
	@Override
	public void lg(SessionBean sessionBean, ZOBean entity) {
		ZdryZb zdryzb = (ZdryZb) entity.getZdryzb();
		if(zdryzb.getSyrkid()!= null){
			SyrkSyrkxxzb ryjbxxb = syrkSyrkxxzbService.queryById(zdryzb.getSyrkid());//人员基本信息
			ZdryZbUtil.copyAttributes(ryjbxxb, zdryzb);
		}
		zdryzb.setId(UUID.create());
		zdryzb.setGlzt(ZdryConstant.LGSQ);
		zdryzb.setGlbm(sessionBean.getUserOrgCode());//管理部门
		BaseService.setSaveProperties(zdryzb, sessionBean);
		zdryZdryZbDao.insert(zdryzb);
	}
	
	@Override
	public void lgSuccess(SessionBean sessionBean, ZOBean entity) {
		ZdryZb zdryzb = (ZdryZb) entity.getZdryzb();
		zdryzb.setGlzt(ZdryConstant.YLG);
		updateZdry(sessionBean,zdryzb);
	}

	@Override
	public void lgFail(SessionBean sessionBean, ZOBean entity) {
		deleteZdry(sessionBean,(ZdryZb) entity.getZdryzb());
	}
	
	/**
	 * 1.Zdrycx对象中的id是 申请撤管重点人员总表ID
	 * 2.设置 申请撤管重点人员状态为 CGSQ
	 * 3.isDelete 判断是否撤管为其他类型
	 * 3-1.新增重点人员总表
	 */
	@MethodAnnotation(value = "撤管", type = logType.update)
	@Override
	public void cg(SessionBean sessionBean, ZOBean entity) {
		ZdryZb old = new ZdryZb();
		old.setId(entity.getZdrycx().getId());
		old.setGlzt(ZdryConstant.CGSQ);
		updateZdry(sessionBean, old);
		if(!isDelete(entity.getZdrycx())){
			BeanUtils.copyProperties(entity.getZdrycx(), entity.getZdryzb());
			lg(sessionBean, entity);
		}else {
			old=(ZdryZb)zdryZdryZbDao.queryById(old.getId());
			if ("07".equals(old.getZdrygllxdm())){
				old.setGlzt(ZdryConstant.YCG);
				deleteZdry(sessionBean,old);
			}
		}
	}

	@Override
	public void cgSuccess(SessionBean sessionBean, ZOBean entity) {
		ZdryZb old = new ZdryZb();
		old.setId(entity.getZdrycx().getId());
		old.setGlzt(ZdryConstant.YCG);
		deleteZdry(sessionBean,old);
		if(!isDelete(entity.getZdrycx())){
			ZdryZb newZb = new ZdryZb();
			newZb.setId( entity.getZdryzbId());
			newZb.setGlzt(ZdryConstant.YLG);
			updateZdry(sessionBean,newZb);
		}
	}

	@Override
	public void cgFail(SessionBean sessionBean, ZOBean entity) {
		ZdryZb old = new ZdryZb();
		old.setId(entity.getZdrycx().getId());
		old.setGlzt(ZdryConstant.YLG);
		old.setXt_zxbz(AppConst.STATUS_ENABLE);
		updateZdry(sessionBean,old);
		if(!isDelete(entity.getZdrycx())){
			ZdryZb newZb = new ZdryZb();
			newZb.setId( entity.getZdryzbId());
			deleteZdry(sessionBean,newZb);
		}
	}

	@MethodAnnotation(value = "转类", type = logType.update)
	@Override	
	public void zl(SessionBean sessionBean, ZOBean entity) {		
		// 查询原有信息，发送消息的时候需要
		ZdryZb oldLb = (ZdryZb) entity.getZdryzb();
		ZdryZb newLb = (ZdryZb) zdryZdryZbDao.queryById(oldLb.getId());
		newLb.setGlzt(ZdryConstant.ZLSQ);
		newLb.setZdrylb(oldLb.getZdrylb());		
		updateZdry(sessionBean,newLb);				
	}

	@Override
	public void zlSuccess(SessionBean sessionBean, ZOBean entity) {
		ZdryZb zdryzb = new ZdryZb();
		zdryzb.setId(entity.getZdryzbId());
		zdryzb.setGlzt(ZdryConstant.YLG);
		updateZdry(sessionBean,zdryzb);
	}

	@Override
	public void zlFail(SessionBean sessionBean, ZOBean entity) {
		ZdryZb zdryzb = new ZdryZb();
		zdryzb.setId(entity.getZdryzbId());
		zdryzb.setGlzt(ZdryConstant.YLG);
		zdryzb.setZdrylb(((ZdryZb)entity.getZdryzb()).getZdrylb());
		updateZdry(sessionBean,zdryzb);

	}

	@MethodAnnotation(value = "转递", type = logType.insert)
	@Override
	public void zd(SessionBean sessionBean, ZOBean entity) {
		ZdryZb zdry_old = new ZdryZb();
		zdry_old.setId(entity.getZdryzbId());
		zdry_old.setGlzt(ZdryConstant.ZDSQ);
		updateZdry(sessionBean,zdry_old);				
		if(!isDelete(entity.getZdrycx())){
			//BeanUtils.copyProperties(entity.getZdryzb(),entity.getZdrycx() );//ZdryZb为新数据对象，不可以copy覆盖
			lg(sessionBean, entity);
		}
	}

	@Override
	public void zdSuccess(SessionBean sessionBean, ZOBean entity) {
		
		//先把管辖部门和管理部门设置相同，如果是双列管，再设置为户籍地管理部门
		//ZdryGzb zdryGzb=zdryZdryZbDao.queryByZdrylx(zdryzb.getZdrygllxdm(),SystemConfig.getString("zdryQY"));
		//if(zdryGzb!=null && "1".equals(zdryGzb.getSfslg())){//双列管，查询户籍地管理部门
		ZdryZb tmpZb = (ZdryZb)entity.getZdryzb();
		SyrkSyrkxxzb ryjbxxb = syrkSyrkxxzbService.queryById(tmpZb.getSyrkid());//人员基本信息	
		String gxbm = "";
		if(ryjbxxb!=null && ryjbxxb.getHjd_mlpdm()!= null){
			//String zdry_hjd_zrqdm = dzService.queryMldzDx(ryjbxxb.getHjd_mlpdm()).getZrqdm();
			gxbm = zdryZdryZbDao.queryHjdZrqdm(ryjbxxb.getHjd_mlpdm());
		}
		
		ZdryZb old = new ZdryZb();
		old.setId(entity.getZdrycx().getId());
		old.setGlzt(ZdryConstant.YZD);
		deleteZdry(sessionBean,old);
		if(!isDelete(entity.getZdrycx())){
			ZdryZb newZb = new ZdryZb();
			BeanUtils.copyProperties(tmpZb,newZb );//ZdryZb为新数据对象，不可以copy覆盖
			//copy yid,syrkid,hjd info
			ZdryZbUtil.copyAttributes((ZdryZb)entity.getZdrycx(), newZb);
			newZb.setId( entity.getZdryzbId());
			newZb.setGlzt(ZdryConstant.YLG);
			//变更录入人信息:为下次转递提供正确的原辖区民警信息
			newZb.setXt_lrsj(tmpZb.getXt_lrsj());
			newZb.setXt_lrrxm(tmpZb.getXt_lrrxm());
			newZb.setXt_lrrid(tmpZb.getXt_lrrid());
			newZb.setXt_lrrbm(tmpZb.getXt_lrrbm());
			newZb.setXt_lrrbmid(tmpZb.getXt_lrrbmid());
			newZb.setXt_lrip(tmpZb.getXt_lrip());
			if(!StringUtils.isEmpty(gxbm))
				newZb.setGxbm(gxbm);
			updateZdry(sessionBean,newZb);
		}
	}

	@Override
	public void zdFail(SessionBean sessionBean, ZOBean entity) {
		ZdryZb old = new ZdryZb();
		old.setId(entity.getZdrycx().getId());
		old.setGlzt(ZdryConstant.YLG);
		old.setXt_zxbz(AppConst.STATUS_ENABLE);
		updateZdry(sessionBean,old);
		if(!isDelete(entity.getZdrycx())){
			ZdryZb newZb = new ZdryZb();
			newZb.setId( entity.getZdryzbId());
			newZb.setXt_zxyy(((ZdryZb)entity.getZdryzb()).getXt_zxyy());
			deleteZdry(sessionBean,newZb);
		}
	}

	/**
	 * 
	 * @Title: update
	 * @Description:  (修改)
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throw
	 */
	@MethodAnnotation(value = "修改", type = logType.update)
	@Override
	public void update(SessionBean sessionBean, ZOBean zdry) {
		//总表还不确定要修改	
		updateZdry(sessionBean,(ZdryZb) zdry.getZdryzb());
	}


	private void updateZdry(SessionBean sessionBean,ZdryZb entity){
		if(entity != null){
			BaseService.setUpdateProperties(entity, sessionBean);
			zdryZdryZbDao.update(entity);
		}
	}
	private void deleteZdry(SessionBean sessionBean,ZdryZb entity){
		BaseService.setCrossoutProperties(entity, sessionBean);
		zdryZdryZbDao.delete(entity);
	}
	
	
	private boolean isDelete(Zdry zdry){
		if(zdry != null && zdry.getClass().getName().equals(Zdrycx.class.getName())){
			Zdrycx zdrycx = (Zdrycx) zdry;
			if(!StringUtils.isEmpty(zdrycx.getZdrygllxdm())){
				return false;
			}
		}
		return true;
	}

	@Override
	public Map<String, String> getZdryXmAndZdrylxName(Zdry zdry) {
		Map<String, String> map = new HashMap<String,String>();
		ZdryZb zdryzb = (ZdryZb) zdry;
		map.put("zdryName", zdryzb.getXm());
		map.put("zdryGllxdm", zdryzb.getZdrygllxdm());
		map.put("zdrylxName", zdryConstant.getValueOfZdryDict(zdryzb.getZdrygllxdm()));
		return map;
	}

}
