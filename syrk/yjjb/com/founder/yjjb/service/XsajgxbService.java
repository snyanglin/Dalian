package com.founder.yjjb.service;

import java.util.List;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.yjjb.bean.Xsajgxb;
import com.founder.yjjb.bean.Xscljlb;

/**
 * </br>
 * @author 于宏宇
 * @since 2014-11-18
 */
@TypeAnnotation("有奖举报_线索案件")
public interface XsajgxbService {
	
	/**
	 * 查询单条</br>
	 * @param entity
	 * @return
	 */
	@MethodAnnotation(value = "查询单条", type = logType.query)
	public EasyUIPage queryList(EasyUIPage page,Xsajgxb entity);
	
	/**
	 * 查询单条</br>
	 * @param entity
	 * @return
	 */
	@MethodAnnotation(value = "查询单条", type = logType.query)
	public Xsajgxb queryById(Xsajgxb entity);
	
	/**
	 * 新增</br>
	 * @param entity
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void save(Xsajgxb entity, SessionBean sessionBean);

	/**
	 * 更新</br>
	 * @param entity
	 */
	@MethodAnnotation(value = "更新", type = logType.insert)
	public void update(Xsajgxb entity, SessionBean sessionBean);

	/**
	 * 删除</br>
	 * @param entity
	 */
	@MethodAnnotation(value = "注销", type = logType.delete)
	public void delete(Xsajgxb entity, SessionBean sessionBean);
	
	/**
	 * 更新sfffjl
	 * @param entity
	 */
	@MethodAnnotation(value = "更新sfffjl", type = logType.insert)
	public void updateSfffjl(Xsajgxb entity, SessionBean sessionBean);

	/**
	 * 查询某线索的所有案件</br>
	 * @param entity
	 * @return
	 */
	@MethodAnnotation(value = "查询某线索的所有案件", type = logType.query)
	public EasyUIPage queryByXsId(EasyUIPage page, String xsId);
	
	/**
	 * 查询某线索关联的案件数量</br>
	 * @param xsbh
	 * @return
	 */
	@MethodAnnotation(value = "查询某线索关联的案件数量", type = logType.query)
	public int ifExistAj(String xsbh);

	/**
	 * @Title: queryByXsidAjid
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param entityXsAj
	 * @param @return    设定文件
	 * @return Xsajgxb    返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "根据ajidxsid查询", type = logType.query)
	public Xsajgxb queryByXsidAjid(Xsajgxb entityXsAj);
	
	/**
	 * @Title: queryAJListByXsbh
	 * @Description: 通过线索id查询列表
	 * @param @param entityLog    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "通过线索id查询列表", type = logType.query)
	public List<Xsajgxb> queryAJListByXsbh(String xsbh);
}
