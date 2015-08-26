package com.founder.sydw.service;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.base.entity.SessionBean;
import com.founder.sydw.bean.Dwccxxb;

@TypeAnnotation("单位仓储")
public interface DwccxxbService {

	public Dwccxxb queryEntityById(Dwccxxb entity);

	public void saveEntity(Dwccxxb entity, SessionBean sessionBean);

	public void updateEntity(Dwccxxb entity, SessionBean sessionBean);
	
	@MethodAnnotation(value = "验证联系方式是否有效", type = logType.query)
	public boolean queryLxfsValid(String lxdh, String dwid);

}
