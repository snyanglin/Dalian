package com.founder.zafffwqz.service;

import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zafffwqz.bean.Kthb;
import com.founder.zafffwqz.bean.Slzxqzb;
import com.founder.zafffwqz.bean.Tsqtghb;
import com.founder.zafffwqz.bean.Zaffxcb;

@TypeAnnotation("服务群众")
public interface FwqzService {

	
	public EasyUIPage querySlzxqz(EasyUIPage page, Slzxqzb entity);
	public EasyUIPage queryKthb(EasyUIPage page, Kthb entity);
	public EasyUIPage queryZaffxcb(EasyUIPage page, Zaffxcb entity);
	public EasyUIPage queryTsqtghb(EasyUIPage page, Tsqtghb entity);
	
	public void saveSlzxqzb(Slzxqzb entity, SessionBean sessionBean);
	public void updateSlzxqzb(Slzxqzb entity, SessionBean sessionBean);
	public void deleteSlzxqzb(Slzxqzb entity, SessionBean sessionBean);
	public Slzxqzb querySlzxqzbById(Slzxqzb entity);
	
	public void saveKthb(Kthb entity, SessionBean sessionBean);
	public void updateKthb(Kthb entity, SessionBean sessionBean);
	public void deleteKthb(Kthb entity, SessionBean sessionBean);
	public Kthb queryKthbById(Kthb entity);
	
	public void saveZaffxcb(Zaffxcb entity, SessionBean sessionBean);
	public void updateZaffxcb(Zaffxcb entity, SessionBean sessionBean);
	public void deleteZaffxcb(Zaffxcb entity, SessionBean sessionBean);
	public Zaffxcb queryZaffxcbById(Zaffxcb entity);
	
	public void saveTsqtghb(Tsqtghb entity, SessionBean sessionBean);
	public void updateTsqtghb(Tsqtghb entity, SessionBean sessionBean);
	public void deleteTsqtghb(Tsqtghb entity, SessionBean sessionBean);
	public Tsqtghb queryTsqtghbById(Tsqtghb entity);
	
	
}
