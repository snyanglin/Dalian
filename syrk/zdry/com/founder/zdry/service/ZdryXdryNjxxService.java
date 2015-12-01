package com.founder.zdry.service;

import com.founder.framework.base.entity.SessionBean;
import com.founder.zdry.bean.ZdryXdrynjxxb;

public interface ZdryXdryNjxxService {
	
	public ZdryXdrynjxxb queryById(String id);
	
	public ZdryXdrynjxxb getZdryXdryxdqk(String zdryId);
	
	public void save(ZdryXdrynjxxb entity, SessionBean sessionBean);

	public void update(ZdryXdrynjxxb entity, SessionBean sessionBean);
	
}
