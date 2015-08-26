/**********************************************************************   
 * <p>文件名：ZdryGlpzpzbServiceImpl.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk_syrk
 * @author xu_wenjun@founder.com.cn 
 * @date 2015-3-13 下午2:06:34 
 * @history
 * @department：研发部
 *
*/
package com.founder.zdrygl.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.EasyUIPage;
import com.founder.framework.utils.UUID;
import com.founder.zdrygl.bean.ZdryGlpzpzb;
import com.founder.zdrygl.dao.ZdryGlpzpzbDao;
import com.founder.zdrygl.service.ZdryGlpzpzbService;

/******************************************************************************
 * @Package:      [com.founder.zdrygl.service.impl.ZdryGlpzpzbServiceImpl.java]  
 * @ClassName:    [ZdryGlpzpzbServiceImpl]   
 * @Description:  [重点人员管理配置表]   
 * @Author:       [xu_wenjun@founder.com.cn]  
 * @CreateDate:   [2015-3-13 下午2:06:34]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-3-13 下午2:06:34，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */
@Service("zdryGlpzpzbService")
@Transactional
public class ZdryGlpzpzbServiceImpl implements ZdryGlpzpzbService {
	
	@Resource(name = "zdryGlpzpzbDao")
	private ZdryGlpzpzbDao zdryGlpzpzbDao;

	/**
	 * 保存
	 */
	@Override
	public void insert(ZdryGlpzpzb entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		BaseService.setSaveProperties(entity, sessionBean);
		zdryGlpzpzbDao.insert(entity);
	}
	
	/**
	 * 修改
	 */
	@Override
	public int update(ZdryGlpzpzb entity, SessionBean sessionBean) {
		BaseService.setUpdateProperties(entity, sessionBean);
		return zdryGlpzpzbDao.update(entity);
	}

	/**
	 * 注销
	 */
	@Override
	public void delete(ZdryGlpzpzb entity, SessionBean sessionBean) {
		BaseService.setCrossoutProperties(entity, sessionBean);
		zdryGlpzpzbDao.delete(entity);
	}

	/**
	 * 查询[根据主键]
	 */
	@Override
	public ZdryGlpzpzb queryById(String id) {
		return zdryGlpzpzbDao.queryById(id);
	}

	/**
	 * 查询列表
	 */
	@Override
	public EasyUIPage queryList(EasyUIPage page, ZdryGlpzpzb entity) {
		return zdryGlpzpzbDao.queryList(page, entity);
	}

	/**
	 * 
	 */
	@Override
	public String getKlglx(String zdryzbId) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 */
	@Override
	public String getKcglx(String zdrygllxdm) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 查询[根据管理类型代码]
	 */
	@Override
	public ZdryGlpzpzb queryByZdrygllxdm(String zdrygllxdm) {
		return zdryGlpzpzbDao.queryByZdrygllxdm(zdrygllxdm);
	}

	/**
	 * 查询【动态纪实周期】不为空的记录
	 */
	@Override
	public List<ZdryGlpzpzb> queryByDtjszqdmNotNull() {
		return zdryGlpzpzbDao.queryByDtjszqdmNotNull();
	}

}
