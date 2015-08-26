package com.founder.syfw.service;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.syfw.bean.Czfwxxb;

@TypeAnnotation("出租房屋子表")
public interface CzfwzbService {
	

	@MethodAnnotation(value = "新增出租房屋子表", type = logType.insert)
	public void saveCzfwxxb(Czfwxxb entity, SessionBean sessionBean);

	@MethodAnnotation(value = "注销出租房屋子表", type = logType.delete)
	public void removeCzfwxxb(Czfwxxb entity, SessionBean sessionBean);

	@MethodAnnotation(value = "修改出租房屋子表", type = logType.update)
	public void updateCzfwxxb(Czfwxxb entity, SessionBean sessionBean);

	public Czfwxxb queryCzfwxxb(String id);
	
	public Czfwxxb queryCzfwxxbByfwid(String fwid);

}
