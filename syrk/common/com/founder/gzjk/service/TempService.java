package com.founder.gzjk.service;

import com.founder.framework.base.entity.SessionBean;
import com.founder.gzjk.vo.LogGzjltjb;

public interface TempService {
	
	public LogGzjltjb querySingle(LogGzjltjb entity);
	
	public void updateGzjl(String id, String type, String businessType, SessionBean sessionBean);

}
