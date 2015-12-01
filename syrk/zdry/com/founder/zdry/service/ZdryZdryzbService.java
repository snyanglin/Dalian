package com.founder.zdry.service;

import java.util.List;

import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zdry.bean.ZdryZdryzb;
import com.founder.zdry.vo.ZdryZdryzbVO;

@TypeAnnotation("重点人员总表")
public interface ZdryZdryzbService {

	public List<ZdryZdryzb> queryZdryByRyid(String ryid) ;
	
	public List<ZdryZdryzbVO> queryZdryBySyrkid(String syrkid) ;
	
	public ZdryZdryzb queryById(String id);

	public void insert(ZdryZdryzb entity,SessionBean sessionBean);
	
	public void update(ZdryZdryzb entity,SessionBean sessionBean);
	
	public void delete(ZdryZdryzb entity,SessionBean sessionBean);
	
	public EasyUIPage queryList(ZdryZdryzb entity, EasyUIPage page);
	
	public ZdryZdryzb queryBySyrkidAndgllx(String syrkid , String gllx);
	
	public EasyUIPage queryDwDzOnPT(EasyUIPage page, ZdryZdryzbVO entity);
	
	public List<ZdryZdryzb> queryZdrylxdmByGmsfhm(String zjhm);
	
	public Integer queryForCount(String syrkId);
}
