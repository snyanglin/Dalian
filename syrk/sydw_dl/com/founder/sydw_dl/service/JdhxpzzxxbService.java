package com.founder.sydw_dl.service;

import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.sydw_dl.bean.Jdhxpzzxxb;

@TypeAnnotation("剧毒化学品资质")
public interface JdhxpzzxxbService {

	public Jdhxpzzxxb queryjdhxpzzxxbByRyid(Jdhxpzzxxb entity);

	public void saveJdhxpzzxxb(Jdhxpzzxxb entity, SessionBean sessionBean);

	public void updateJdhxpzzxxb(Jdhxpzzxxb entity, SessionBean sessionBean);

}
