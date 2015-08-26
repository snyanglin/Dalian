/**********************************************************************   
 * <p>文件名：DwOwnsydwServiceImpl.java </p>
 * <p>文件描述：TODO(描述该文件做什么) 
 * @project_name：syrk
 * @author star 
 * @date 2015-04-20 
 * @history
 * @department：研发部
 *
*/
package com.founder.sydw.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.base.service.BaseService;
import com.founder.framework.utils.UUID;
import com.founder.sydw.bean.DwOwnAmfwcsBean;
import com.founder.sydw.bean.DwOwnGqwbBean;
import com.founder.sydw.bean.DwOwnGwylcsBean;
import com.founder.sydw.bean.DwOwnMbBean;
import com.founder.sydw.bean.DwOwnMbXmyjBean;
import com.founder.sydw.bean.DwOwnMqBean;
import com.founder.sydw.bean.DwOwnMqZgryBean;
import com.founder.sydw.bean.DwOwnSealBean;
import com.founder.sydw.bean.DwOwnXFBean;
import com.founder.sydw.bean.DwOwnYhBean;
import com.founder.sydw.bean.DwOwnYxyycsBean;
import com.founder.sydw.bean.DwOwnZjbxBean;
import com.founder.sydw.dao.DwOwnsydwDao;
import com.founder.sydw.service.DwOwnsydwService;
/******************************************************************************
 * @Package:      [com.founder.sydw.service.impl.DwOwnsydwServiceImpl.java]  
 * @ClassName:    [DwOwnsydwServiceImpl]   
 * @Description:  [实有单位补充信息]   
 * @Author:       [star]  
 * @CreateDate:   [2015-04-20 ]   
 * @Version:      [v1.0] 
 */
@Service("dwownsydwService")
@Transactional
public class DwOwnsydwServiceImpl extends BaseService implements DwOwnsydwService {
	@Resource(name = "dwOwnsydwDao")
	private DwOwnsydwDao dwOwnsydwDao;

	/*
	 * (非 Javadoc)
	 * <p>Title: queryGwylcsByRyid</p>
	 * <p>歌舞娱乐场所信息查询 </p>
	 * @param entity
	 * @return
	 * @see com.founder.sydw.service.DwOwnsydwService#queryGwylcsByRyid(com.founder.sydw.bean.DwOwnGwylcsBean)
	 */
	@Override
	public DwOwnGwylcsBean queryGwylcsByRyid(DwOwnGwylcsBean entity) {
		return dwOwnsydwDao.queryGwylcsByRyid(entity);
	}
	/*
	 * (非 Javadoc)
	 * <p>Title: saveGwylcs</p>
	 * <p>Description:歌舞娱乐场所信息 </p>
	 * @param entity
	 * @param sessionBean
	 * @see com.founder.sydw.service.DwOwnsydwService#saveGwylcs(com.founder.sydw.bean.DwOwnGwylcsBean, com.founder.framework.base.entity.SessionBean)
	 */
	@Override
	public void saveGwylcs(DwOwnGwylcsBean entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		setSaveProperties(entity,sessionBean);
		dwOwnsydwDao.saveGwylcs(entity);
		
	}
	
	/*
	 * (非 Javadoc)
	 * <p>Title: updateGwylcs</p>
	 * <p>Description: 歌舞娱乐场所信息</p>
	 * @param entity
	 * @param sessionBean
	 * @see com.founder.sydw.service.DwOwnsydwService#updateGwylcs(com.founder.sydw.bean.DwOwnGwylcsBean, com.founder.framework.base.entity.SessionBean)
	 */
	@Override
	public void updateGwylcs(DwOwnGwylcsBean entity, SessionBean sessionBean) {
		setUpdateProperties(entity,sessionBean);
		dwOwnsydwDao.updateGwylcs(entity);
		
	}

	/*
	 * (非 Javadoc)
	 * <p>Title: queryAmfwcsByRyid</p>
	 * <p>Description: 按摩服务场所信息</p>
	 * @param entity
	 * @return
	 * @see com.founder.sydw.service.DwOwnsydwService#queryAmfwcsByRyid(com.founder.sydw.bean.DwOwnAmfwcsBean)
	 */
	@Override
	public DwOwnAmfwcsBean queryAmfwcsByRyid(DwOwnAmfwcsBean entity) {
		return dwOwnsydwDao.queryAmfwcsByRyid(entity);
	}
	/*
	 * (非 Javadoc)
	 * <p>Title: saveAmfwcs</p>
	 * <p>Description: 按摩服务场所信息</p>
	 * @param entity
	 * @param sessionBean
	 * @see com.founder.sydw.service.DwOwnsydwService#saveAmfwcs(com.founder.sydw.bean.DwOwnAmfwcsBean, com.founder.framework.base.entity.SessionBean)
	 */
	@Override
	public void saveAmfwcs(DwOwnAmfwcsBean entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		setSaveProperties(entity,sessionBean);
		dwOwnsydwDao.saveAmfwcs(entity);
		
	}
	/*
	 * (非 Javadoc)
	 * <p>Title: updateAmfwcs</p>
	 * <p>Description: 按摩服务场所信息</p>
	 * @param entity
	 * @param sessionBean
	 * @see com.founder.sydw.service.DwOwnsydwService#updateAmfwcs(com.founder.sydw.bean.DwOwnAmfwcsBean, com.founder.framework.base.entity.SessionBean)
	 */
	@Override
	public void updateAmfwcs(DwOwnAmfwcsBean entity, SessionBean sessionBean) {
		setUpdateProperties(entity,sessionBean);
		dwOwnsydwDao.updateAmfwcs(entity);
		
	}
	
	/*
	 * (非 Javadoc)
	 * <p>Title: queryYxyycsByRyid</p>
	 * <p>Description:游戏游艺场所信息 </p>
	 * @param entity
	 * @return
	 * @see com.founder.sydw.service.DwOwnsydwService#queryYxyycsByRyid(com.founder.sydw.bean.DwOwnYxyycsBean)
	 */
	@Override
	public DwOwnYxyycsBean queryYxyycsByRyid(DwOwnYxyycsBean entity) {
		return dwOwnsydwDao.queryYxyycsByRyid(entity);
	}
	/*
	 * (非 Javadoc)
	 * <p>Title: saveYxyycs</p>
	 * <p>Description:游戏游艺场所信息 </p>
	 * @param entity
	 * @param sessionBean
	 * @see com.founder.sydw.service.DwOwnsydwService#saveYxyycs(com.founder.sydw.bean.DwOwnYxyycsBean, com.founder.framework.base.entity.SessionBean)
	 */
  @Override
   public void saveYxyycs(DwOwnYxyycsBean entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		setSaveProperties(entity,sessionBean);
		dwOwnsydwDao.saveYxyycs(entity);
		
	}
    /*
     * (非 Javadoc)
     * <p>Title: updateYxyycs</p>
     * <p>Description:游戏游艺场所信息 </p>
     * @param entity
     * @param sessionBean
     * @see com.founder.sydw.service.DwOwnsydwService#updateYxyycs(com.founder.sydw.bean.DwOwnYxyycsBean, com.founder.framework.base.entity.SessionBean)
     */
	@Override
	public void updateYxyycs(DwOwnYxyycsBean entity, SessionBean sessionBean) {
		setUpdateProperties(entity,sessionBean);
		dwOwnsydwDao.updateYxyycs(entity);
		
	}

	/*
	 * (非 Javadoc)
	 * <p>Title: queryYzByRyid</p>
	 * <p>Description: 印章基本信息</p>
	 * @param entity
	 * @return
	 * @see com.founder.sydw.service.DwOwnsydwService#queryYzByRyid(com.founder.sydw.bean.DwOwnSealBean)
	 */
	@Override
	public DwOwnSealBean queryYzByRyid(DwOwnSealBean entity) {
		return dwOwnsydwDao.queryYzByRyid(entity);
	}
	/*
	 * (非 Javadoc)
	 * <p>Title: saveYz</p>
	 * <p>Description: 印章基本信息</p>
	 * @param entity
	 * @param sessionBean
	 * @see com.founder.sydw.service.DwOwnsydwService#saveYz(com.founder.sydw.bean.DwOwnSealBean, com.founder.framework.base.entity.SessionBean)
	 */
	@Override
	public void saveYz(DwOwnSealBean entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		setSaveProperties(entity,sessionBean);
		dwOwnsydwDao.saveYz(entity);
		
	}
	/*
	 * (非 Javadoc)
	 * <p>Title: updateYz</p>
	 * <p>Description:印章基本信息 </p>
	 * @param entity
	 * @param sessionBean
	 * @see com.founder.sydw.service.DwOwnsydwService#updateYz(com.founder.sydw.bean.DwOwnSealBean, com.founder.framework.base.entity.SessionBean)
	 */
	@Override
	public void updateYz(DwOwnSealBean entity, SessionBean sessionBean) {
		setUpdateProperties(entity,sessionBean);
		dwOwnsydwDao.updateYz(entity);
		
	}

	/*
	 * (非 Javadoc)
	 * <p>Title: queryMbByRyid</p>
	 * <p>Description:民爆单位基本信息 </p>
	 * @param entity
	 * @return
	 * @see com.founder.sydw.service.DwOwnsydwService#queryMbByRyid(com.founder.sydw.bean.DwOwnMbBean)
	 */
	@Override
	public DwOwnMbBean queryMbByRyid(DwOwnMbBean entity) {
		return dwOwnsydwDao.queryMbByRyid(entity);
	}
	/*
	 * (非 Javadoc)
	 * <p>Title: saveMb</p>
	 * <p>Description:民爆单位基本信息 </p>
	 * @param entity
	 * @param sessionBean
	 * @see com.founder.sydw.service.DwOwnsydwService#saveMb(com.founder.sydw.bean.DwOwnMbBean, com.founder.framework.base.entity.SessionBean)
	 */
	@Override
	public void saveMb(DwOwnMbBean entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		setSaveProperties(entity,sessionBean);
		dwOwnsydwDao.saveMb(entity);
		
	}
	/*
	 * (非 Javadoc)
	 * <p>Title: updateMb</p>
	 * <p>Description: 民爆单位基本信息</p>
	 * @param entity
	 * @param sessionBean
	 * @see com.founder.sydw.service.DwOwnsydwService#updateMb(com.founder.sydw.bean.DwOwnMbBean, com.founder.framework.base.entity.SessionBean)
	 */
	@Override
	public void updateMb(DwOwnMbBean entity, SessionBean sessionBean) {
		setUpdateProperties(entity,sessionBean);
		dwOwnsydwDao.updateMb(entity);
	}

	/*
	 * (非 Javadoc)
	 * <p>Title: queryMbXmyjByRyid</p>
	 * <p>Description: 民爆施工项目业绩</p>
	 * @param entity
	 * @return
	 * @see com.founder.sydw.service.DwOwnsydwService#queryMbXmyjByRyid(com.founder.sydw.bean.DwOwnMbXmyjBean)
	 */
	public DwOwnMbXmyjBean queryMbXmyjByRyid(DwOwnMbXmyjBean entity) {
		return dwOwnsydwDao.queryMbXmyjByRyid(entity);
	}
	
	/*
	 * (非 Javadoc)
	 * <p>Title: saveMbXmyj</p>
	 * <p>Description:民爆施工项目业绩 </p>
	 * @param entity
	 * @param sessionBean
	 * @see com.founder.sydw.service.DwOwnsydwService#saveMbXmyj(com.founder.sydw.bean.DwOwnMbXmyjBean, com.founder.framework.base.entity.SessionBean)
	 */
	@Override
	public void saveMbXmyj(DwOwnMbXmyjBean entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		setSaveProperties(entity,sessionBean);
		dwOwnsydwDao.saveMbXmyj(entity);		
	}
	/*
	 * (非 Javadoc)
	 * <p>Title: updateMbXmyj</p>
	 * <p>Description: 民爆施工项目业绩</p>
	 * @param entity
	 * @param sessionBean
	 * @see com.founder.sydw.service.DwOwnsydwService#updateMbXmyj(com.founder.sydw.bean.DwOwnMbXmyjBean, com.founder.framework.base.entity.SessionBean)
	 */
	@Override
	public void updateMbXmyj(DwOwnMbXmyjBean entity, SessionBean sessionBean) {
		setUpdateProperties(entity,sessionBean);
		dwOwnsydwDao.updateMbXmyj(entity);
	}
	/*
	 * (非 Javadoc)
	 * <p>Title: deleteMbxmyj</p>
	 * <p>Description: 民爆施工项目业绩</p>
	 * @param entity
	 * @param sessionBean
	 * @see com.founder.sydw.service.DwOwnsydwService#deleteMbxmyj(com.founder.sydw.bean.DwOwnMbXmyjBean, com.founder.framework.base.entity.SessionBean)
	 */
	@Override
	public void deleteMbxmyj(DwOwnMbXmyjBean entity, SessionBean sessionBean) {
		BaseService.setCrossoutProperties(entity, sessionBean);
		dwOwnsydwDao.deleteMbxmyj(entity);
	}
	
	/*
	 * (非 Javadoc)
	 * <p>Title: queryMqByRyid</p>
	 * <p>Description: 民枪配置单位信息</p>
	 * @param entity
	 * @return
	 * @see com.founder.sydw.service.DwOwnsydwService#queryMqByRyid(com.founder.sydw.bean.DwOwnMqBean)
	 */
	@Override
	public DwOwnMqBean queryMqByRyid(DwOwnMqBean entity) {
		return dwOwnsydwDao.queryMqByRyid(entity);
	}
	/*
	 * (非 Javadoc)
	 * <p>Title: saveMq</p>
	 * <p>Description: 民枪配置单位信息</p>
	 * @param entity
	 * @param sessionBean
	 * @see com.founder.sydw.service.DwOwnsydwService#saveMq(com.founder.sydw.bean.DwOwnMqBean, com.founder.framework.base.entity.SessionBean)
	 */
	@Override
	public void saveMq(DwOwnMqBean entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		setSaveProperties(entity,sessionBean);
		dwOwnsydwDao.saveMq(entity);
		
	}
	/*
	 * (非 Javadoc)
	 * <p>Title: updateMq</p>
	 * <p>Description: 民枪配置单位信息</p>
	 * @param entity
	 * @param sessionBean
	 * @see com.founder.sydw.service.DwOwnsydwService#updateMq(com.founder.sydw.bean.DwOwnMqBean, com.founder.framework.base.entity.SessionBean)
	 */
	@Override
	public void updateMq(DwOwnMqBean entity, SessionBean sessionBean) {
		setUpdateProperties(entity,sessionBean);
		dwOwnsydwDao.updateMq(entity);
		
	}
	

	/*
	 * (非 Javadoc)
	 * <p>Title: queryMqzgryByRyid</p>
	 * <p>Description: 民枪专管</p>
	 * @param entity
	 * @return
	 * @see com.founder.sydw.service.DwOwnsydwService#queryMqzgryByRyid(com.founder.sydw.bean.DwOwnMqZgryBean)
	 */
	public DwOwnMqZgryBean queryMqzgryByRyid(DwOwnMqZgryBean entity) {
		return dwOwnsydwDao.queryMqzgryByRyid(entity);
	}
	/*
	 * (非 Javadoc)
	 * <p>Title: saveMqzgry</p>
	 * <p>Description:民枪专管 </p>
	 * @param entity
	 * @param sessionBean
	 * @see com.founder.sydw.service.DwOwnsydwService#saveMqzgry(com.founder.sydw.bean.DwOwnMqZgryBean, com.founder.framework.base.entity.SessionBean)
	 */
	@Override
	public void saveMqzgry(DwOwnMqZgryBean entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		setSaveProperties(entity,sessionBean);
		dwOwnsydwDao.saveMqzgry(entity);		
	}
	/*
	 * (非 Javadoc)
	 * <p>Title: updateMqzgry</p>
	 * <p>Description: 民枪专管</p>
	 * @param entity
	 * @param sessionBean
	 * @see com.founder.sydw.service.DwOwnsydwService#updateMqzgry(com.founder.sydw.bean.DwOwnMqZgryBean, com.founder.framework.base.entity.SessionBean)
	 */
	@Override
	public void updateMqzgry(DwOwnMqZgryBean entity, SessionBean sessionBean) {
		setUpdateProperties(entity,sessionBean);
		dwOwnsydwDao.updateMqzgry(entity);
	}
	/*
	 * (非 Javadoc)
	 * <p>Title: deleteMqzgry</p>
	 * <p>Description: 民枪专管</p>
	 * @param entity
	 * @param sessionBean
	 * @see com.founder.sydw.service.DwOwnsydwService#deleteMqzgry(com.founder.sydw.bean.DwOwnMqZgryBean, com.founder.framework.base.entity.SessionBean)
	 */
	@Override
	public void deleteMqzgry(DwOwnMqZgryBean entity, SessionBean sessionBean) {
		BaseService.setCrossoutProperties(entity, sessionBean);
		dwOwnsydwDao.deleteMqzgry(entity);
	}

	/*
	 * (非 Javadoc)
	 * <p>Title: queryYhByRyid</p>
	 * <p>Description: 烟花配置单位信息</p>
	 * @param entity
	 * @return
	 * @see com.founder.sydw.service.DwOwnsydwService#queryYhByRyid(com.founder.sydw.bean.DwOwnYhBean)
	 */
	@Override
	public DwOwnYhBean queryYhByRyid(DwOwnYhBean entity) {
		return dwOwnsydwDao.queryYhByRyid(entity);
	}
	/*
	 * (非 Javadoc)
	 * <p>Title: saveYh</p>
	 * <p>Description: 烟花配置单位信息</p>
	 * @param entity
	 * @param sessionBean
	 * @see com.founder.sydw.service.DwOwnsydwService#saveYh(com.founder.sydw.bean.DwOwnYhBean, com.founder.framework.base.entity.SessionBean)
	 */
	@Override
	public void saveYh(DwOwnYhBean entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		setSaveProperties(entity,sessionBean);
		dwOwnsydwDao.saveYh(entity);
		
	}
	/*
	 * (非 Javadoc)
	 * <p>Title: updateYh</p>
	 * <p>Description: 烟花配置单位信息</p>
	 * @param entity
	 * @param sessionBean
	 * @see com.founder.sydw.service.DwOwnsydwService#updateYh(com.founder.sydw.bean.DwOwnYhBean, com.founder.framework.base.entity.SessionBean)
	 */
	@Override
	public void updateYh(DwOwnYhBean entity, SessionBean sessionBean) {
		setUpdateProperties(entity,sessionBean);
		dwOwnsydwDao.updateYh(entity);
		
	}

	/*
	 * (非 Javadoc)
	 * <p>Title: queryGqwbByRyid</p>
	 * <p>Description: 工企/文保单位信息</p>
	 * @param entity
	 * @return
	 * @see com.founder.sydw.service.DwOwnsydwService#queryGqwbByRyid(com.founder.sydw.bean.DwOwnGqwbBean)
	 */
	@Override
	public DwOwnGqwbBean queryGqwbByRyid(DwOwnGqwbBean entity) {
		return dwOwnsydwDao.queryGqwbByRyid(entity);
	}
	/*
	 * (非 Javadoc)
	 * <p>Title: saveGqwb</p>
	 * <p>Description: 工企/文保单位信息</p>
	 * @param entity
	 * @param sessionBean
	 * @see com.founder.sydw.service.DwOwnsydwService#saveGqwb(com.founder.sydw.bean.DwOwnGqwbBean, com.founder.framework.base.entity.SessionBean)
	 */
	@Override
	public void saveGqwb(DwOwnGqwbBean entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		setSaveProperties(entity,sessionBean);
		dwOwnsydwDao.saveGqwb(entity);
		
	}
	/*
	 * (非 Javadoc)
	 * <p>Title: updateGqwb</p>
	 * <p>Description: 工企/文保单位信息</p>
	 * @param entity
	 * @param sessionBean
	 * @see com.founder.sydw.service.DwOwnsydwService#updateGqwb(com.founder.sydw.bean.DwOwnGqwbBean, com.founder.framework.base.entity.SessionBean)
	 */
	@Override
	public void updateGqwb(DwOwnGqwbBean entity, SessionBean sessionBean) {
		setUpdateProperties(entity,sessionBean);
		dwOwnsydwDao.updateGqwb(entity);
		
	}

	/*
	 * (非 Javadoc)
	 * <p>Title: queryZjbxyByRyid</p>
	 * <p>Description: 证券/保险业单位信息</p>
	 * @param entity
	 * @return
	 * @see com.founder.sydw.service.DwOwnsydwService#queryZjbxyByRyid(com.founder.sydw.bean.DwOwnZjbxBean)
	 */
	@Override
	public DwOwnZjbxBean queryZjbxyByRyid(DwOwnZjbxBean entity) {
		return dwOwnsydwDao.queryZjbxyByRyid(entity);
	}
	
	/*
	 * (非 Javadoc)
	 * <p>Title: saveZjbxy</p>
	 * <p>Description:证券/保险业单位信息 </p>
	 * @param entity
	 * @param sessionBean
	 * @see com.founder.sydw.service.DwOwnsydwService#saveZjbxy(com.founder.sydw.bean.DwOwnZjbxBean, com.founder.framework.base.entity.SessionBean)
	 */
	@Override
	public void saveZjbxy(DwOwnZjbxBean entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		setSaveProperties(entity,sessionBean);
		dwOwnsydwDao.saveZjbxy(entity);
		
	}
	
	/*
	 * (非 Javadoc)
	 * <p>Title: updateZjbxy</p>
	 * <p>Description: 证券/保险业单位信息</p>
	 * @param entity
	 * @param sessionBean
	 * @see com.founder.sydw.service.DwOwnsydwService#updateZjbxy(com.founder.sydw.bean.DwOwnZjbxBean, com.founder.framework.base.entity.SessionBean)
	 */
	@Override
	public void updateZjbxy(DwOwnZjbxBean entity, SessionBean sessionBean) {
		setUpdateProperties(entity,sessionBean);
		dwOwnsydwDao.updateZjbxy(entity);
		
	}

	/*
	 * (非 Javadoc)
	 * <p>Title: queryXfByRyid</p>
	 * <p>Description:消防信息 </p>
	 * @param entity
	 * @return
	 * @see com.founder.sydw.service.DwOwnsydwService#queryXfByRyid(com.founder.sydw.bean.DwOwnXFBean)
	 */
	@Override
	public DwOwnXFBean queryXfByRyid(DwOwnXFBean entity) {
		return dwOwnsydwDao.queryXfByRyid(entity);
	}
	
	/*
	 * (非 Javadoc)
	 * <p>Title: saveXf</p>
	 * <p>Description: 消防信息</p>
	 * @param entity
	 * @param sessionBean
	 * @see com.founder.sydw.service.DwOwnsydwService#saveXf(com.founder.sydw.bean.DwOwnXFBean, com.founder.framework.base.entity.SessionBean)
	 */
	@Override
	public void saveXf(DwOwnXFBean entity, SessionBean sessionBean) {
		entity.setId(UUID.create());
		setSaveProperties(entity,sessionBean);
		dwOwnsydwDao.saveXf(entity);
		
	}
	
	/*
	 * (非 Javadoc)
	 * <p>Title: updateXf</p>
	 * <p>Description:消防信息 </p>
	 * @param entity
	 * @param sessionBean
	 * @see com.founder.sydw.service.DwOwnsydwService#updateXf(com.founder.sydw.bean.DwOwnXFBean, com.founder.framework.base.entity.SessionBean)
	 */
	@Override
	public void updateXf(DwOwnXFBean entity, SessionBean sessionBean) {
		setUpdateProperties(entity,sessionBean);
		dwOwnsydwDao.updateXf(entity);
		
	}
}
