package com.founder.sydw_dl.service;

import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.sydw_dl.bean.Jdcxlxxb;

@TypeAnnotation("机动车修理信息")
public interface JdcxlxxbService {

	Jdcxlxxb queryjdcxlxxbByRyid(Jdcxlxxb entity);

	void saveJdcxlxxb(Jdcxlxxb entity, SessionBean sessionBean);

	void updateJdcxlxxb(Jdcxlxxb entity, SessionBean sessionBean);

}
