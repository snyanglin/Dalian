package com.founder.syrkgl.service;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.syrkgl.bean.RyRylxfsxxb;

/**
 * ****************************************************************************
 * @Package:      [com.founder.syrkgl.service.RyRylxfsxxbService.java]  
 * @ClassName:    [RyRylxfsxxbService]   
 * @Description:  [实有人口附加信息-人员联系方式信息表]   
 * @Author:       [xu_wenjun@founder.com.cn]  
 * @CreateDate:   [2015-4-7 下午7:47:41]   
 * @UpdateUser:   [Administrator(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-4-7 下午7:47:41，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@TypeAnnotation("实有人口附加信息-人员联系方式信息表")
public interface RyRylxfsxxbService {

	/**
	 * @Title: queryById
	 * @Description: TODO(根据ID查询单条记录)
	 * @param @param id
	 * @param @return 设定文件
	 * @return RyRylxfsxxb 返回类型
	 * @throws
	 */
	public RyRylxfsxxb queryById(String id);

	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void save(RyRylxfsxxb entity, SessionBean sessionBean);

	/**
	 * 更新<br>
	 * 
	 * @param entity
	 */
	@MethodAnnotation(value = "更新", type = logType.update)
	public void update(RyRylxfsxxb entity, SessionBean sessionBean);

	/**
	 * 删除<br>
	 * 
	 * @param entity
	 */
	@MethodAnnotation(value = "注销", type = logType.delete)
	public void delete(RyRylxfsxxb entity, SessionBean sessionBean);
	
	/**
	 * 
	 * @Title: queryCount
	 * @Description: TODO(根据条件查询记录数)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Integer    返回类型
	 * @throws
	 */
	public Integer queryCount(RyRylxfsxxb entity);
	
	/**
	 * 
	 * @Title: queryLastLxfs
	 * @Description: TODO(返回最新的联系方式)
	 * @param @param ryid
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String queryLastLxfs(String ryid);
	
	/**
	 * 
	 * @Title: saveLxdh
	 * @Description: TODO(如果存在则保存，否则返回)
	 * @param @param ryid
	 * @param @param lxfs
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public void saveLxdh(String ryid, String lxfs, SessionBean sessionBean);
	
	/**
	 * 
	 * @Title: check
	 * @Description: TODO(校验联系方式)
	 * @param @param ryid
	 * @param @param lxfs
	 * @param @return    设定文件
	 * @return RyRylxfsxxb    返回类型
	 * @throws
	 */
	public RyRylxfsxxb check(String ryid, String lxfs);

}
