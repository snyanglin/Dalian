package com.founder.zdry.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.UUID;
import com.founder.zdry.bean.Zdrylxylbdyb;
import com.founder.zdry.dao.ZdrylxylbdybDao;
import com.founder.zdry.service.ZdrylxylbdybService;

/**
 * 
 * 类描述<br>
 * @author zhangxijiu@founder.com.cn
 * @version 2015-2-2
 * 
 */
@Service("zdrylxylbdybService")
public class ZdrylxylbdybServiceImpl extends BaseService implements ZdrylxylbdybService{
	@Resource(name = "zdrylxylbdybDao")
	private ZdrylxylbdybDao zdrylxylbdybDao;
	
	/***
	 * 
	 * @Title: queryList
	 * @Description:重点人员类型与类别对应列表
	 * @author zhangxijiu@founder.com.cn
	 * @param @param page
	 * @param @param rows
	 * @param @param entity
	 * @param @return    
	 * @return EasyUIPage    
	 * @throws
	 */
	
	@Override
	public EasyUIPage queryList(EasyUIPage page, Zdrylxylbdyb entity) {
		return zdrylxylbdybDao.queryList(page, entity);
	}

	/***
	 * 
	 * @Title: queryCount
	 * @Description:重点人员类型与类别对应列表
	 * @author zhangxijiu@founder.com.cn
	 * @param @param entity
	 * @param @return    
	 * @return long    
	 * @throws
	 */
	@Override
	public long queryCount(Zdrylxylbdyb entity) {
		return zdrylxylbdybDao.queryCount(entity);
	}

	/***
	 * 
	 * @Title: delete
	 * @Description:删除重点人员类型与类别对应关系
	 * @author zhangxijiu@founder.com.cn
	 * @param @param entity
	 * @param @return    
	 * @throws
	 */
	@Override
	public void delete(Zdrylxylbdyb entity, SessionBean sessionBean) {
		setCrossoutProperties(entity, sessionBean);
		zdrylxylbdybDao.delete(entity,sessionBean);
	}

	/***
	 * 
	 * @Title: saveZdrylxylbdyb
	 * @Description: 保存重点人员类型与类别对应关系
	 * @author zhang_xijiu@founder.com.cn
	 * @param @param entity,SppzbArray,sessionBean
	 * @param @return    
	 * @return  
	 * @throws
	 */
	@Override
	public void saveZdrylxylbdyb(Zdrylxylbdyb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		BaseService.setSaveProperties(entity, sessionBean);
		zdrylxylbdybDao.save(entity,sessionBean);
	}

	/***
	 * 
	 * @Title: query
	 * @Description: 根据实体条件查询
	 * @author zhang_xijiu@founder.com.cn
	 * @param @param entity
	 * @param @return    
	 * @return Zdrylxylbdyb 
	 * @throws
	 */
	@Override
	public Zdrylxylbdyb query(Zdrylxylbdyb entity) {
		return zdrylxylbdybDao.query(entity);
	}

	/***
	 * 
	 * @Title: updateZdrylxylbdyb
	 * @Description: 更新重点人员类型与类别对应关系
	 * @author zhang_xijiu@founder.com.cn
	 * @param @param entity,sessionBean
	 * @param @return    
	 * @return  
	 * @throws
	 */
	@Override
	public void updateZdrylxylbdyb(Zdrylxylbdyb entity, SessionBean sessionBean) {
		BaseService.setUpdateProperties(entity, sessionBean);
		zdrylxylbdybDao.update(entity,sessionBean);
	}
	/***
	 * 
	 * @Title: deletePatch
	 * @Description:批量删除重点人员类型与类别对应关系
	 * @author zhangxijiu@founder.com.cn
	 * @param @param Zdrylxylbdyb[] entityArray
	 * @param @return    
	 * @throws
	 */

	@Override
	public void deletePatch(Zdrylxylbdyb[] entityArray, SessionBean sessionBean) {
		for (int i = 0; i < entityArray.length; i++) {
			BaseService.setCrossoutProperties(entityArray[i], sessionBean);
			zdrylxylbdybDao.delete(entityArray[i], sessionBean);
		}
	}
	/***
	 * 
	 * @Title: queryZdrylbdm
	 * @Description:查询重点人员类型与类别对应关系
	 * @author zhangxijiu@founder.com.cn
	 * @param @param zdrylxdm
	 * @param @return    
	 * @throws
	 */
	public List<Zdrylxylbdyb> queryZdrylbdm(String zdrylxdm){
		return zdrylxylbdybDao.queryZdrylbdm(zdrylxdm);
	}
	/***
	 * 
	 * @Title: getisExist
	 * @Description:判断重点人员类型与类别对应关系
	 * @author zhangxijiu@founder.com.cn
	 * @param @param zdrylbdm
	 * @param @return  List<Zdrylxylbdyb>  
	 * @throws
	 */

	public List<Zdrylxylbdyb> getisExist(String zdrylbdm){
		return zdrylxylbdybDao.getisExist(zdrylbdm);
	}
	
}

