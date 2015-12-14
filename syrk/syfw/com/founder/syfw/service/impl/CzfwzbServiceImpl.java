package com.founder.syfw.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.UUID;
import com.founder.syfw.bean.Czfwjcxxb;
import com.founder.syfw.bean.Czfwxxb;
import com.founder.syfw.bean.FwCzqkdjxxb;
import com.founder.syfw.dao.CzfwzbDao;
import com.founder.syfw.service.CzfwzbService;

/**
 * ****************************************************************************
 * @Package:      [com.founder.syfw.service.impl.CzfwzbServiceImpl.java]  
 * @ClassName:    [CzfwzbServiceImpl]   Os
 * @Description:  [出租房屋子项信息]   
 * @Author:       [weiwen]  
 * @CreateDate:   [2015-4-28 上午9:59:23]   
 * @UpdateUser:   [weiwen]   
 * @UpdateDate:   [2015-4-28 上午9:59:23，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Service("czfwzbService")
@Transactional
public class CzfwzbServiceImpl extends BaseService implements CzfwzbService {
	
	@Resource(name = "czfwzbDao")
	private CzfwzbDao czfwzbDao;
	
	@Override
	public void saveCzfwxxb(Czfwxxb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		setSaveProperties(entity, sessionBean);
		czfwzbDao.insetCzfwxxb(entity);
		czfwzbDao.updateSfczfw("1", entity.getFwid());
	}

	@Override
	public void removeCzfwxxb(Czfwxxb entity, SessionBean sessionBean) {
		setCrossoutProperties(entity, sessionBean);
		czfwzbDao.deleteCzfwxxb(entity);
		czfwzbDao.updateSfczfw("0", entity.getFwid());
		
		Czfwjcxxb czfwjcxxb = new Czfwjcxxb();
		czfwjcxxb.setCzfwid(entity.getId());
		setCrossoutProperties(czfwjcxxb, sessionBean);
		czfwzbDao.deleteCzfwjcxxb(czfwjcxxb);
		
		FwCzqkdjxxb fwCzqkdjxxb = new FwCzqkdjxxb();
		fwCzqkdjxxb.setCzfwid(entity.getId());
		setCrossoutProperties(fwCzqkdjxxb, sessionBean);
		czfwzbDao.deleteCzqkdjxxb(fwCzqkdjxxb);
	}

	@Override
	public void updateCzfwxxb(Czfwxxb entity, SessionBean sessionBean) {
		setUpdateProperties(entity, sessionBean);
		czfwzbDao.updateCzfwxxb(entity);
	}

	@Override
	public Czfwxxb queryCzfwxxb(String id) {
		return czfwzbDao.queryCzfwxxb(id);
	}

	@Override
	public Czfwxxb queryCzfwxxbByfwid(String fwid) {
		return czfwzbDao.queryCzfwxxbByFwid(fwid);
	}
}
