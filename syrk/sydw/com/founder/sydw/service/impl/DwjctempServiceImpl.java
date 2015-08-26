package com.founder.sydw.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.UUID;
import com.founder.sydw.bean.Dwjcdata;
import com.founder.sydw.bean.Dwjctype;
import com.founder.sydw.dao.DwjctempDao;
import com.founder.sydw.service.DwjctempService;

@Service("dwjctempService")
@Transactional
public class DwjctempServiceImpl extends BaseService implements DwjctempService {

	@Resource(name = "dwjctempDao")
	private DwjctempDao dwjctempDao;
	
	@Override
	public void addMultDwjctype(Dwjctype entity, SessionBean sessionBean) {
		String[] names = entity.getNames();
		for(String name:names){
			entity.setName(name);
			entity.setId(UUID.create());
			dwjctempDao.saveDwjctype(entity, sessionBean);
		}
	}

	@Override
	public void updateDwjctype(Dwjctype entity, SessionBean sessionBean) {
		dwjctempDao.updateDwjctype(entity, sessionBean);
	}

	@Override
	public void deleteDwjctype(Dwjctype entity, SessionBean sessionBean) {
		dwjctempDao.deleteDwjctype(entity, sessionBean);
	}

	@Override
	public EasyUIPage queryDwjctype(EasyUIPage page, Dwjctype entity) {
		return dwjctempDao.queryDwjctype(page, entity);
	}

	@Override
	public void addMultDwjcdata(Dwjcdata entity, SessionBean sessionBean) {
		String[] names = entity.getNames();
		String[] defs = entity.getDefs();
		for (int i = 0; i < names.length; i++) {
			entity.setId(UUID.create());
			entity.setName(names[i]);
			int j= defs.length;
			if(j==0){
				entity.setDef("");
			}else{
				entity.setDef(defs[i]);
			}
			dwjctempDao.saveDwjcdata(entity, sessionBean);
		}
	}

	@Override
	public void updateDwjcdata(Dwjcdata entity, SessionBean sessionBean) {
		dwjctempDao.updateDwjcdata(entity, sessionBean);
	}

	@Override
	public void deleteDwjcdata(Dwjcdata entity, SessionBean sessionBean) {
		dwjctempDao.deleteDwjcdata(entity, sessionBean);
	}

	@Override
	public EasyUIPage queryDwjcdata(EasyUIPage page, Dwjcdata entity) {
		return dwjctempDao.queryDwjcdata(page, entity);
	}

	@Override
	public Dwjctype queryOneDwjctype(Dwjctype entity) {
		return dwjctempDao.queryOneDwjctype(entity);
	}

	@Override
	public Dwjcdata queryOneDwjcdata(Dwjcdata entity) {
		return dwjctempDao.queryOneDwjcdata(entity);
	}

	@Override
	public List<Dwjctype> queryDwjcTemp(Map<String, Object> param) {
		List<Dwjctype> list = dwjctempDao.queryDwjctypeTemp(param);
		if(list!=null&&list.size()>0){
			Map<String,Object> map = new HashMap<String,Object>();
			for(Dwjctype dwjctype:list){
				map.put("typeid", dwjctype.getId());
				List<Dwjcdata> datas = dwjctempDao.queryDwjcdataTemp(map);
				dwjctype.setList(datas);
			}
		}
		return list;
	}

}
