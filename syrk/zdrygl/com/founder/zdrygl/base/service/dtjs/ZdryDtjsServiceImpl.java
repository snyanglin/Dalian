package com.founder.zdrygl.base.service.dtjs;

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
import com.founder.zdrygl.base.dao.ZdryDtjsXsDao;
import com.founder.zdrygl.base.model.ZdryDtjsXsxxb;
import com.founder.zdrygl.base.service.ZdryDtjsService;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.service.impl.ZdryServiceImpl.java]  
 * @ClassName:    [ZdryServiceImpl]   
 * @Description:  [重点人员服务实现类]   
 * @Author:       [cong_rihong@founder.com.cn]  
 * @CreateDate:   [2015-12-3 上午9:45:56]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-12-3 上午9:45:56，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Service("zdryDtjsService")
@Transactional
public class ZdryDtjsServiceImpl extends BaseService implements ZdryDtjsService {
	
	@Resource(name = "zdryDtjsXsDao")
	private ZdryDtjsXsDao zdryDtjsXsDao;

	
	@Override
	public EasyUIPage queryRyxsList(EasyUIPage page, ZdryDtjsXsxxb entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", page.getBegin());
		map.put("end", page.getEnd());

		map.put("entity", entity);
		List<?> list = zdryDtjsXsDao.queryRyxsList(page, map);
		int count = (int) zdryDtjsXsDao.queryRyxsListCount(map);
		page.setTotal(count);
		page.setRows(list);	
		return page;
	}		

	@Override
	public String saveDtjs(ZdryDtjsXsxxb entity,SessionBean sessionBean) {	
		entity.setId(UUID.create());
		BaseService.setSaveProperties(entity, sessionBean);
		 zdryDtjsXsDao.saveRyxsb(entity);
		 return entity.getId();
	}
	@Override
	public String updateDtjs(ZdryDtjsXsxxb entity,SessionBean sessionBean) {		
		BaseService.setUpdateProperties(entity, sessionBean);

		return zdryDtjsXsDao.updateZdryDtjsXsxxb(entity);
	}

	@Override
	public ZdryDtjsXsxxb queryXsjbxxById(String xsid) {
		
		return zdryDtjsXsDao.querXsjbxxById(xsid);
	}


	@Override
	public void deleteDtjsXsjbxx(ZdryDtjsXsxxb entity, SessionBean sessionBean) {
	    setCrossoutProperties(entity, sessionBean);
		this.zdryDtjsXsDao.deleteDtjsXsjbxx(entity);	
	}

}
