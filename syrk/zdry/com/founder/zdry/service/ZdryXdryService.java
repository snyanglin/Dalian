package com.founder.zdry.service;

import com.founder.framework.base.entity.SessionBean;
import com.founder.zdry.bean.ZdryXdryxxb;

public interface ZdryXdryService {
	
	public ZdryXdryxxb queryById(String id);
	
	public ZdryXdryxxb getZdryXdryxdqk(String zdryId);
	
	public void save(ZdryXdryxxb entity, SessionBean sessionBean);

	public void update(ZdryXdryxxb entity, SessionBean sessionBean);
	
}
