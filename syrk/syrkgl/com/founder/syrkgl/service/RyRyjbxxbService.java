package com.founder.syrkgl.service;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.syrkgl.bean.RyRyjbxxb;
import com.founder.syrkgl.bean.SyrkCzrkxxb;
import com.founder.syrkgl.bean.SyrkJwryxxb;
import com.founder.syrkgl.bean.SyrkJzrkxxb;
import com.founder.syrkgl.bean.SyrkLdrkxxb;
import com.founder.syrkgl.bean.SyrkWlhryxxb;
import com.founder.syrkgl.vo.SyrkZtxx;

/******************************************************************************
 * @Package: [com.founder.syrkgl.service.RyRyjbxxbService.java]
 * @ClassName: [RyRyjbxxbService]
 * @Description: [人员基本信息表接口]
 * @Author: [hongguanjun]
 * @CreateDate: [2015-4-2 下午4:48:31]
 * @UpdateUser: [hongguanjun(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-4-2 下午4:48:31，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
/**
 * @author Administrator
 *
 */
@TypeAnnotation("人员基本信息表")
public interface RyRyjbxxbService {

	/**
	 * @Title: queryList
	 * @Description: TODO(查询列表)
	 * @param @param page
	 * @param @param entity
	 * @param @return 设定文件
	 * @return EasyUIPage 返回类型
	 * @throws
	 */
	public EasyUIPage queryList(EasyUIPage page, RyRyjbxxb entity);

	/**
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return 设定文件
	 * @return RyRyjbxxb 返回类型
	 * @throws
	 */
	public RyRyjbxxb queryById(String id);

	/**
	 * @Title: queryByCyzjdmZjhm
	 * @Description: 查询单条（根据证件种类和证件号码）
	 * @param @param cyzjdm
	 * @param @param zjhm
	 * @param @return 设定文件
	 * @return RyRyjbxxb 返回类型
	 * @throws
	 */
	public RyRyjbxxb queryByCyzjdmZjhm(String cyzjdm, String zjhm);

	/**
	 * @Title: save
	 * @Description: TODO(新增或更新，自动判断是否存在数据)
	 * @param @param entity
	 * @param @param sessionBean 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "新增或更新", type = logType.insert)
	public void saveOrUpdate(RyRyjbxxb entity, SessionBean sessionBean)
			throws Exception;

	/**
	 * @Title: delete
	 * @Description: TODO(注销)
	 * @param @param entity
	 * @param @param sessionBean 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "注销", type = logType.delete)
	public void delete(RyRyjbxxb entity, SessionBean sessionBean);

	/**
	 * @Title: dataApply
	 * @Description: TODO(人员基本信息数据复用，自动请求全国库，无照片的自动补)
	 * @param @param cyzjdm
	 * @param @param zjhm
	 * @param @param sessionBean
	 * @param @return 设定文件
	 * @return RyRyjbxxb 返回类型
	 * @throws
	 */
	public RyRyjbxxb dataApply(String cyzjdm, String zjhm,
			SessionBean sessionBean);

	
	/**
	 * 在逃人员信息
	 * @param ztrysfzh
	 * @return
	 */
	public SyrkZtxx getZtxx(String ztrysfzh);
	
	
	/**
	 * @Title: bcPhoto
	 * @Description: TODO(补充人员照片信息)
	 * @param @param sessionBean
	 * @param @return 设定文件
	 * @return  返回类型
	 * @throws
	 */
	public long bcPhoto(SessionBean sessionBean);
	
	/**
	 * @Title: bcRyJbxx
	 * @Description: TODO(补充人员基本信息)
	 * @param @param sessionBean
	 * @param @return 设定文件
	 * @return  返回类型
	 * @throws
	 */
	public long bcRyJbxx(SessionBean sessionBean);
	
	/**
	 * 
	 * @Title: synchronizeSyrkxxzb
	 * @Description: TODO(根据5类人员信息同步人员基本信息表)
	 * @param @param entity
	 * @return void 返回类型
	 * @throws
	 */
	public void synchronizeRyjbxxb(SyrkCzrkxxb entity, SessionBean sessionBean);

	/**
	 * 
	 * @Title: synchronizeSyrkxxzb
	 * @Description: TODO(根据5类人员信息同步人员基本信息表)
	 * @param @param entity
	 * @return void 返回类型
	 * @throws
	 */
	public void synchronizeRyjbxxb(SyrkJzrkxxb entity, SessionBean sessionBean);

	/**
	 * 
	 * @Title: synchronizeSyrkxxzb
	 * @Description: TODO(根据5类人员信息同步人员基本信息表)
	 * @param @param entity
	 * @return void 返回类型
	 * @throws
	 */
	public void synchronizeRyjbxxb(SyrkLdrkxxb entity, SessionBean sessionBean);

	/**
	 * 
	 * @Title: synchronizeSyrkxxzb
	 * @Description: TODO(根据5类人员信息同步人员基本信息表)
	 * @param @param entity
	 * @return void 返回类型
	 * @throws
	 */
	public void synchronizeRyjbxxb(SyrkJwryxxb entity, SessionBean sessionBean);

	/**
	 * 
	 * @Title: synchronizeSyrkxxzb
	 * @Description: TODO(根据5类人员信息同步人员基本信息表)
	 * @param @param entity
	 * @return void 返回类型
	 * @throws
	 */
	public void synchronizeRyjbxxb(SyrkWlhryxxb entity, SessionBean sessionBean);
	/**
	 * @Title: update 
	 * @描述: 更新【人员基本信息表】 
	 * @作者: zhang_guoliang@founder.com 
	 * @参数: 传入参数定义 
	 * @日期： 2015-4-15 下午9:24:42 
	 * @返回值: void    返回类型 
	 * @throws
	 */
	public void update(RyRyjbxxb entity, SessionBean sessionBean);
	
}
