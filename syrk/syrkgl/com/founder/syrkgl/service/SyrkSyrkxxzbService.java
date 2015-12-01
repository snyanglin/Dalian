package com.founder.syrkgl.service;

import java.util.List;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.syrkgl.bean.SyrkCzrkxxb;
import com.founder.syrkgl.bean.SyrkJwryxxb;
import com.founder.syrkgl.bean.SyrkJzrkxxb;
import com.founder.syrkgl.bean.SyrkLdrkxxb;
import com.founder.syrkgl.bean.SyrkSyrkxxzb;
import com.founder.syrkgl.bean.SyrkWlhryxxb;
import com.founder.syrkgl.vo.SyrkAddVO;

@TypeAnnotation("实有人口信息")
public interface SyrkSyrkxxzbService {

	/**
	 * 
	 * @Title: queryById
	 * @Description: TODO(根据id（实有人口ID）查询总表)
	 * @param @param id
	 * @param @return 设定文件
	 * @return SyrkSyrkxxzb 返回类型
	 * @throws
	 */
	public SyrkSyrkxxzb queryById(String id);

	/**
	 * 
	 * @Title: queryListByRyid
	 * @Description: TODO(根据ryid查询列表)
	 * @param @param ryid
	 * @param @return 设定文件
	 * @return List<SyrkSyrkxxzb> 返回类型
	 * @throws
	 */
	public List<SyrkSyrkxxzb> queryListByRyid(String ryid);
	
	/**
	 * 根据条件查询所有实有人口总表数据
	 * @param entity
	 * @return
	 */
	public List<SyrkSyrkxxzb> queryList(SyrkSyrkxxzb entity);

	/**
	 * @Title: queryListByRyidYwlx
	 * @Description: TODO(根据ryid、实有人口业务类型查询列表)
	 * @param @param ryid
	 * @param @param syrkywlxdm
	 * @param @return 设定文件
	 * @return List<SyrkSyrkxxzb> 返回类型
	 * @throws
	 */
	public List<SyrkSyrkxxzb> queryListByRyidYwlx(SyrkSyrkxxzb entity);

	/**
	 * @Title: queryCzrkByRyid
	 * @Description: TODO(根据ryid查询实有人口业务类型为常住人口的对象)
	 * @param @param ryid
	 * @param @return 设定文件
	 * @return SyrkSyrkxxzb 返回类型
	 * @throws
	 */
	public SyrkSyrkxxzb queryCzrkByRyid(String ryid);

	/**
	 * @Title: isValidSyrkAdd
	 * @Description: TODO(是否为有效的实有人口新增)
	 * @param @param syrkAddVO
	 * @param @param sessionBean
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public String isValidSyrkAdd(SyrkAddVO syrkAddVO, SessionBean sessionBean);

	/**
	 * @Title: syrkAdd
	 * @Description: TODO(实有人口新增)
	 * @param @param syrkAddVO
	 * @param @param sessionBean 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public String syrkAdd(SyrkAddVO syrkAddVO, SessionBean sessionBean)
			throws Exception;
    /**
     * @Title: queryList 
     * @描述: 查询实有人口管理列表数据【服务接口】
     * @作者: zhang_guoliang@founder.com 
     * @参数: 传入参数定义 
     * @日期： 2015-4-14 上午11:21:55 
     * @返回值: EasyUIPage    返回类型 
     * @throws
     */
	public EasyUIPage queryList(SyrkSyrkxxzb entity, EasyUIPage page);
	
	/**
	 * @Title: querySyrk 
	 * @描述: 查询实有人口查询列表数据【服务接口】
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-4-15 上午10:06:17 
	 * @返回值: EasyUIPage    返回类型 
	 * @throws
	 */
	public EasyUIPage querySyrk(SyrkSyrkxxzb entity, EasyUIPage page);
	/**
	 * @Title: querySyrkCount 
	 * @描述: 查询实有人口查询列表数据总数【服务接口】
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-4-15 上午10:16:56 
	 * @返回值: long    返回类型 
	 * @throws
	 */
	public long querySyrkCount(SyrkSyrkxxzb entity);

	public void save(SyrkSyrkxxzb entity, SessionBean sessionBean);

	public void update(SyrkSyrkxxzb entity, SessionBean sessionBean);
	
    /**
     * @Title: cancelSyrk 
     * @描述: 实有人口注销【服务接口】
     * @作者: zhang_guoliang@founder.com 
     * @参数: 传入参数定义 
     * @日期： 2015-4-15 下午5:13:16 
     * @返回值: void    返回类型 
     * @throws
     */
	@MethodAnnotation(value = "注销", type = logType.delete)
	public String deleteSyrk(SyrkAddVO entity, SessionBean sessionBean);

	/**
	 * 
	 * @Title: synchronizeCrossoutSyrkxxzb
	 * @Description: TODO(根据5类人员信息同步注销总表信息)
	 * @param @param entity 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void synchronizeCrossoutSyrkxxzb(Object entity);

	/**
	 * 
	 * @Title: synchronizeSyrkxxzb
	 * @Description: TODO(根据5类人员信息同步总表信息)
	 * @param @param entity
	 * @return void 返回类型
	 * @throws
	 */
	public void synchronizeSyrkxxzb(SyrkCzrkxxb entity);

	/**
	 * 
	 * @Title: synchronizeSyrkxxzb
	 * @Description: TODO(根据5类人员信息同步总表信息)
	 * @param @param entity
	 * @return void 返回类型
	 * @throws
	 */
	public void synchronizeSyrkxxzb(SyrkJwryxxb entity);

	/**
	 * 
	 * @Title: synchronizeSyrkxxzb
	 * @Description: TODO(根据5类人员信息同步总表信息)
	 * @param @param entity
	 * @return void 返回类型
	 * @throws
	 */
	public void synchronizeSyrkxxzb(SyrkJzrkxxb entity);

	/**
	 * 
	 * @Title: synchronizeSyrkxxzb
	 * @Description: TODO(根据5类人员信息同步总表信息)
	 * @param @param entity
	 * @return void 返回类型
	 * @throws
	 */
	public void synchronizeSyrkxxzb(SyrkLdrkxxb entity);

	/**
	 * 
	 * @Title: synchronizeSyrkxxzb
	 * @Description: TODO(根据5类人员信息同步总表信息)
	 * @param @param entity
	 * @return void 返回类型
	 * @throws
	 */
	public void synchronizeSyrkxxzb(SyrkWlhryxxb entity);

}
