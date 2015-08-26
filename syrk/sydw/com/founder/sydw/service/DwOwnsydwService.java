/**********************************************************************   
 * <p>文件名：DwOwnsydwService.java </p>
 * <p>文件描述：实有单位特色信息
 * @project_name：syrk
 * @author star
 * @date 2015-04-20
 * @history
 * @department：研发部
 *
*/
package com.founder.sydw.service;
import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.base.entity.SessionBean;
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

/******************************************************************************
 * @Package:      [com.founder.sydw.service.DwOwnsydwService.java]  
 * @ClassName:    [DwOwnsydwService]   
 * @Description:  [一句话描述该类的功能]   
 * @Author:       [star]  
 * @CreateDate:   [2015-04-20]   
 * @Version:      [v1.0] 
 */

@TypeAnnotation("实有单位特色信息")
public interface DwOwnsydwService {

    /**
     * 
     * @Title: queryGwylcsByRyid
     * @Description: 歌舞娱乐场所信息
     * @param @param entity
     * @param @return    设定文件
     * @return DwOwnGwylcsBean    返回类型
     * @throws
     */
	public DwOwnGwylcsBean queryGwylcsByRyid(DwOwnGwylcsBean entity);
	/**
	 * 
	 * @Title: saveGwylcs
	 * @Description: 歌舞娱乐场所信息
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void saveGwylcs(DwOwnGwylcsBean entity, SessionBean sessionBean);
	/**
	 * 
	 * @Title: updateGwylcs
	 * @Description: 歌舞娱乐场所信息
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "更新", type = logType.update)
	public void updateGwylcs(DwOwnGwylcsBean entity, SessionBean sessionBean);

	/**
	 * 
	 * @Title: queryAmfwcsByRyid
	 * @Description: 按摩服务场所信息
	 * @param @param entity
	 * @param @return    设定文件
	 * @return DwOwnAmfwcsBean    返回类型
	 * @throws
	 */
	public DwOwnAmfwcsBean queryAmfwcsByRyid(DwOwnAmfwcsBean entity);
	
	/**
	 * 
	 * @Title: saveAmfwcs
	 * @Description: 按摩服务场所信息
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void saveAmfwcs(DwOwnAmfwcsBean entity, SessionBean sessionBean);
	
	/**
	 * 
	 * @Title: updateAmfwcs
	 * @Description: 按摩服务场所信息
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "更新", type = logType.update)
	public void updateAmfwcs(DwOwnAmfwcsBean entity, SessionBean sessionBean);
	
	/**
	 * 
	 * @Title: queryYxyycsByRyid
	 * @Description: 按摩服务场所信息
	 * @param @param entity
	 * @param @return    设定文件
	 * @return DwOwnYxyycsBean    返回类型
	 * @throws
	 */
	public DwOwnYxyycsBean queryYxyycsByRyid(DwOwnYxyycsBean entity);
	/**
	 * 
	 * @Title: saveYxyycs
	 * @Description: 按摩服务场所信息
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void saveYxyycs(DwOwnYxyycsBean entity, SessionBean sessionBean);
	
	/**
	 * 
	 * @Title: updateYxyycs
	 * @Description:按摩服务场所信息
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "更新", type = logType.update)
	public void updateYxyycs(DwOwnYxyycsBean entity, SessionBean sessionBean);
	
	/**
	 * 
	 * @Title: queryYzByRyid
	 * @Description: 印章基本信息
	 * @param @param entity
	 * @param @return    设定文件
	 * @return DwOwnSealBean    返回类型
	 * @throws
	 */
	public DwOwnSealBean queryYzByRyid(DwOwnSealBean entity);
	
	/**
	 * 
	 * @Title: saveYz
	 * @Description: 印章基本信息
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void saveYz(DwOwnSealBean entity, SessionBean sessionBean);
	/**
	 * 
	 * @Title: updateYz
	 * @Description: 印章基本信息
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "更新", type = logType.update)
	public void updateYz(DwOwnSealBean entity, SessionBean sessionBean);

	/**
	 * 
	 * @Title: queryMbByRyid
	 * @Description:民爆单位基本信息
	 * @param @param entity
	 * @param @return    设定文件
	 * @return DwOwnMbBean    返回类型
	 * @throws
	 */
	public DwOwnMbBean queryMbByRyid(DwOwnMbBean entity);
	/**
	 * 
	 * @Title: saveMb
	 * @Description: 民爆单位基本信息
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void saveMb(DwOwnMbBean entity, SessionBean sessionBean);
	
	/**
	 * 
	 * @Title: updateMb
	 * @Description: 民爆单位基本信息
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "更新", type = logType.update)
	public void updateMb(DwOwnMbBean entity, SessionBean sessionBean);

	/**
	 * 
	 * @Title: queryMbXmyjByRyid
	 * @Description: 民爆施工项目业绩
	 * @param @param entity
	 * @param @return    设定文件
	 * @return DwOwnMbXmyjBean    返回类型
	 * @throws
	 */
	public DwOwnMbXmyjBean queryMbXmyjByRyid(DwOwnMbXmyjBean entity);
	/**
	 * 
	 * @Title: saveMbXmyj
	 * @Description: 民爆施工项目业绩
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void saveMbXmyj(DwOwnMbXmyjBean entity, SessionBean sessionBean);
	/**
	 * 
	 * @Title: updateMbXmyj
	 * @Description: 民爆施工项目业绩
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "更新", type = logType.update)
	public void updateMbXmyj(DwOwnMbXmyjBean entity, SessionBean sessionBean);
	/**
	 * 
	 * @Title: deleteMbxmyj
	 * @Description: 民爆施工项目业绩
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void deleteMbxmyj(DwOwnMbXmyjBean entity, SessionBean sessionBean);
	
	/**
	 * 
	 * @Title: queryMqByRyid
	 * @Description: 民枪配置单位信息
	 * @param @param entity
	 * @param @return    设定文件
	 * @return DwOwnMqBean    返回类型
	 * @throws
	 */
	public DwOwnMqBean queryMqByRyid(DwOwnMqBean entity);
	
	/**
	 * 
	 * @Title: saveMq
	 * @Description: 民枪配置单位信息
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void saveMq(DwOwnMqBean entity, SessionBean sessionBean);
	/**
	 * 
	 * @Title: updateMq
	 * @Description: 民枪配置单位信息
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "更新", type = logType.update)
	public void updateMq(DwOwnMqBean entity, SessionBean sessionBean);
	
	/**
	 * 
	 * @Title: queryMqzgryByRyid
	 * @Description:民枪专管
	 * @param @param entity
	 * @param @return    设定文件
	 * @return DwOwnMqZgryBean    返回类型
	 * @throws
	 */
	public DwOwnMqZgryBean queryMqzgryByRyid(DwOwnMqZgryBean entity);
	/**
	 * 
	 * @Title: saveMqzgry
	 * @Description: 民枪专管
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void saveMqzgry(DwOwnMqZgryBean entity, SessionBean sessionBean);
	
	/**
	 * @Title: updateMqzgry
	 * @Description: 民枪专管
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "更新", type = logType.update)
	public void updateMqzgry(DwOwnMqZgryBean entity, SessionBean sessionBean);
	
	/**
	 * 
	 * @Title: deleteMqzgry
	 * @Description: 民枪专管
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	
	public void deleteMqzgry(DwOwnMqZgryBean entity, SessionBean sessionBean);
	
	/**
	 * 
	 * @Title: queryYhByRyid
	 * @Description: 烟花配置单位信息
	 * @param @param entity
	 * @param @return    设定文件
	 * @return DwOwnYhBean    返回类型
	 * @throws
	 */
	public DwOwnYhBean queryYhByRyid(DwOwnYhBean entity);
	/**
	 * 
	 * @Title: saveYh
	 * @Description: 烟花配置单位信息
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void saveYh(DwOwnYhBean entity, SessionBean sessionBean);
	/**
	 * 
	 * @Title: updateYh
	 * @Description: 烟花配置单位信息
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "更新", type = logType.update)
	public void updateYh(DwOwnYhBean entity, SessionBean sessionBean);

	/**
	 * 
	 * @Title: queryZjbxyByRyid
	 * @Description: 证券/保险业单位信息
	 * @param @param entity
	 * @param @return    设定文件
	 * @return DwOwnZjbxBean    返回类型
	 * @throws
	 */
	public DwOwnZjbxBean queryZjbxyByRyid(DwOwnZjbxBean entity);
	
	/**
	 * @Title: saveZjbxy
	 * @Description: 证券/保险业单位信息
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void saveZjbxy(DwOwnZjbxBean entity, SessionBean sessionBean);
	/**
	 * 
	 * @Title: updateZjbxy
	 * @Description: 证券/保险业单位信息
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "更新", type = logType.update)
	public void updateZjbxy(DwOwnZjbxBean entity, SessionBean sessionBean);
	
	/**
	 * 
	 * @Title: queryGqwbByRyid
	 * @Description:工企/文保单位信息
	 * @param @param entity
	 * @param @return    设定文件
	 * @return DwOwnGqwbBean    返回类型
	 * @throws
	 */
	public DwOwnGqwbBean queryGqwbByRyid(DwOwnGqwbBean entity);
	/**
	 * 
	 * @Title: saveGqwb
	 * @Description: 工企/文保单位信息
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void saveGqwb(DwOwnGqwbBean entity, SessionBean sessionBean);
	/**
	 * 
	 * @Title: updateGqwb
	 * @Description:工企/文保单位信息
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "更新", type = logType.update)
	public void updateGqwb(DwOwnGqwbBean entity, SessionBean sessionBean);
	
	/**
	 * @Title: queryXfByRyid
	 * @Description: 消防信息
	 * @param @param entity
	 * @param @return    设定文件
	 * @return DwOwnXFBean    返回类型
	 * @throws
	 */
	public DwOwnXFBean queryXfByRyid(DwOwnXFBean entity);
	
	/**
	 * @Title: saveXf
	 * @Description: 消防信息
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void saveXf(DwOwnXFBean entity, SessionBean sessionBean);
	
	/**
	 * @Title: updateXf
	 * @Description: 消防信息
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "更新", type = logType.update)
	public void updateXf(DwOwnXFBean entity, SessionBean sessionBean);
}
