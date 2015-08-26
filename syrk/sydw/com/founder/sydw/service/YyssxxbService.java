package com.founder.sydw.service;

import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.sydw.bean.Yyssxxb;

@TypeAnnotation("营业设备")
public interface YyssxxbService {

	public Yyssxxb queryEntityById(Yyssxxb entity);

	public void saveEntity(Yyssxxb entity, SessionBean sessionBean);

	public void updateEntity(Yyssxxb entity, SessionBean sessionBean);

}
