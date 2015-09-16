package com.founder.sydw.service;

import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.sydw.bean.Dwjbxxb;
import com.founder.sydw.bean.Dwxqxxb;

@TypeAnnotation("单位小区管理")
public interface DwXqjbxxbService {
	
	public EasyUIPage queryDwXq(EasyUIPage page, Dwxqxxb entity);
	
	public long queryCountDwXq(Dwxqxxb entity) ;
	
	public Dwxqxxb query(String id);
	
	public void save(Dwxqxxb entity, SessionBean sessionBean);
	
	public void update(Dwxqxxb entity, SessionBean sessionBean);
	
	public int dwxqzx(Dwxqxxb entity,SessionBean sessionBean);
}
