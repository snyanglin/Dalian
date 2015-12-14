package com.founder.shhxxcj.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.StringUtils;
import com.founder.shhxxcj.bean.CzrhsCzqkdjxxb;
import com.founder.shhxxcj.bean.Houses;
import com.founder.shhxxcj.bean.LesseeJZs;
import com.founder.shhxxcj.bean.LesseeZZs;
import com.founder.shhxxcj.dao.CzrDao;
import com.founder.shhxxcj.service.CzrService;
import com.founder.shhxxcj.service.HousesService;
import com.founder.syfw.service.SyfwEditService;
import com.founder.syrkgl.bean.SyrkSyrkxxzb;
import com.founder.syrkgl.dao.SyrkSyrkxxzbDao;

@Service
@Transactional
public class CzrServiceImpl implements CzrService {

	@Resource
	private CzrDao czrDao;
	@Resource
	private HousesService housesService;
	@Resource
	private SyrkSyrkxxzbDao syrkSyrkxxzbDao;
	
	@Resource
	private SyfwEditService syfwEditService;
	
	@Override
	public EasyUIPage queryList(LesseeZZs entity, EasyUIPage page,
			SessionBean sessionBean) {
		 page =czrDao.queryList(entity, page);
		 Houses houses= housesService.queryById(entity.getHouseid());
		 List<LesseeZZs> czrList=(List<LesseeZZs>)page.getRows();
		 if(czrList!=null &&czrList.size()>0){
			 for(int i=0;i<czrList.size();i++){
				 if(StringUtils.isBlank(czrList.get(i).getSyrkid())){
					 SyrkSyrkxxzb syrk=new SyrkSyrkxxzb();

					 syrk.setJzd_dzid(houses.getBzdzid());
					 syrk.setZjhm(czrList.get(i).getCzrzjhm());
					 syrk.setCyzjdm("111");//身份证
					 if("寄住人口".equals(czrList.get(i).getCzrlb())){
						 syrk.setSyrkywlxdm("2");					
					 }else{//流动人口
						 syrk.setSyrkywlxdm("3");
					 }
					 List<SyrkSyrkxxzb> syrkList=syrkSyrkxxzbDao.queryList(syrk);
                	

	                 if(syrkList!=null && syrkList.size()>0){
	                	 if("zz".equals(czrList.get(i).getType())){
		                	 czrList.get(i).setSyrkid(syrkList.get(0).getId());

		                	 czrDao.updateLesseeZZs(czrList.get(i));
		                	 czrList.get(i).setSyrkid(syrkList.get(0).getId());
		                	 czrList.get(i).setRyid(syrkList.get(0).getRyid());

	                	 }else{
	                		 LesseeJZs jz= czrDao.queryLesseeJZsById(czrList.get(i).getId());
	                		 jz.setSyrkid(syrkList.get(0).getId());
		                	 czrDao.updateLesseeJZs(jz);

		                	 czrList.get(i).setSyrkid(syrkList.get(0).getId());
		                	 czrList.get(i).setRyid(syrkList.get(0).getRyid());
	                	 }
	                 }
				 }else{
					 SyrkSyrkxxzb syrkzb=this.syrkSyrkxxzbDao.queryById(czrList.get(i).getSyrkid());
					 czrList.get(i).setRyid(syrkzb.getRyid());
				 }
				 
			 }
		 }	
		page.setRows(czrList);
		return page;

	}

	@Override
	public void updateLesseeZZs(LesseeZZs entity, SessionBean sessionBean) {
		czrDao.updateLesseeZZs(entity);
		
	}

	@Override
	public void updateLesseeJZs(LesseeJZs entity, SessionBean sessionBean) {
		
		czrDao.updateLesseeJZs(entity);

	}

	@Override
	public LesseeZZs queryLesseeZZsById(String id) {
		
		return czrDao.queryLesseeZZsById(id);
	}

	@Override
	public LesseeJZs queryLesseeJZsById(String id) {
		return czrDao.queryLesseeJZsById(id);
	}

	@Override
	public void saveCzrhs(CzrhsCzqkdjxxb entity,SessionBean sessionBean) {

		try{
            syfwEditService.saveCzqkdjxx(entity, sessionBean);
			
			LesseeZZs zzs=this.queryLesseeZZsById(entity.getCzrId());
			if(zzs!=null){
				zzs.setHszt("1");
				this.czrDao.updateLesseeZZs(zzs);
			}else{				
				LesseeJZs jzs=this.queryLesseeJZsById(entity.getCzrId());
                if(jzs!=null){
                	jzs.setHszt("1");
                	this.czrDao.updateLesseeJZs(jzs);
                }
			}
		}catch (Exception e) {

			e.printStackTrace();
		}
			
		
		
	}

}
