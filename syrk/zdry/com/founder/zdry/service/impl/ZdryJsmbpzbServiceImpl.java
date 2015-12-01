/**********************************************************************   
 * <p>文件名：ZdryJsmbpzbServiceImpl.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk_syrk
 * @author xu_wenjun@founder.com.cn 
 * @date 2015-3-13 下午1:46:41 
 * @history
 * @department：研发部
 *
*/
package com.founder.zdry.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.UUID;
import com.founder.zdry.bean.ZdryJsmbpzb;
import com.founder.zdry.dao.ZdryJsmbpzbDao;
import com.founder.zdry.service.ZdryJsmbpzbService;

/******************************************************************************
 * @Package:      [com.founder.zdry.service.impl.ZdryJsmbpzbServiceImpl.java]  
 * @ClassName:    [ZdryJsmbpzbServiceImpl]   
 * @Description:  [重点人员纪实模板配置表]   
 * @Author:       [xu_wenjun@founder.com.cn]  
 * @CreateDate:   [2015-3-13 下午1:46:41]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-3-13 下午1:46:41，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@Service("zdryJsmbpzbService")
@Transactional
public class ZdryJsmbpzbServiceImpl implements ZdryJsmbpzbService {
	
	@Resource(name = "zdryJsmbpzbDao")
	private ZdryJsmbpzbDao zdryJsmbpzbDao;

	/**
	 * 新增
	 */
	@Override
	public void insert(ZdryJsmbpzb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		BaseService.setSaveProperties(entity, sessionBean);
		zdryJsmbpzbDao.insert(entity);
	}

	/**
	 * 查询单条
	 */
	@Override
	public ZdryJsmbpzb queryById(String id) {
		if(id == null){
			return null;
		}else{
			return zdryJsmbpzbDao.queryById(id);
		}
	}

	/**
	 * 修改
	 */
	@Override
	public int update(ZdryJsmbpzb entity, SessionBean sessionBean) {
		BaseService.setUpdateProperties(entity, sessionBean);
		return zdryJsmbpzbDao.update(entity);
	}
	
	/**
	 * 注销
	 */
	@Override
	public void delete(ZdryJsmbpzb entity, SessionBean sessionBean) {
		BaseService.setCrossoutProperties(entity, sessionBean);
		zdryJsmbpzbDao.delete(entity);
	}

	/**
	 * 查询列表
	 */
	@Override
	public EasyUIPage queryList(EasyUIPage page, ZdryJsmbpzb entity) {
		return zdryJsmbpzbDao.queryList(page, entity);
	}

	/**
	 * 根据【重点人员管理类型代码】查询
	 */
	@Override
	public List<ZdryJsmbpzb> queryForList(String zdrygllxdm) {
		ZdryJsmbpzb entity = new ZdryJsmbpzb();
		entity.setZdrygllxdm(zdrygllxdm);
		return zdryJsmbpzbDao.queryForList(entity);
	}

	/**
	 * 根据【默认】查询(一个类型:单条)
	 */
	@Override
	public ZdryJsmbpzb queryDefault(String zdrygllxdm) {
		ZdryJsmbpzb entity = new ZdryJsmbpzb();
		entity.setZdrygllxdm(zdrygllxdm);
		entity.setSfmr("1");
		List<ZdryJsmbpzb> list = zdryJsmbpzbDao.queryForList(entity);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}

	/**
	 * 设置[默认]模板
	 */
	@Override
	public void setDefault(ZdryJsmbpzb entity, SessionBean sessionBean) {
		BaseService.setUpdateProperties(entity, sessionBean);
		entity.setSfmr("0");//设为非默认
		zdryJsmbpzbDao.updateBeforeSetDefault(entity);
		entity = zdryJsmbpzbDao.queryById(entity.getId());
		entity.setSfmr("1");//设为默认
		zdryJsmbpzbDao.update(entity);
	}

	/**
	 * 根据【默认】查询(一个类型:多条)
	 */
	@Override
	public List<ZdryJsmbpzb> queryDefaultList() {
		ZdryJsmbpzb entity = new ZdryJsmbpzb();
		entity.setSfmr("1");
		return zdryJsmbpzbDao.queryForList(entity);
	}

}
