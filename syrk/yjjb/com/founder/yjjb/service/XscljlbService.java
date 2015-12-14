package com.founder.yjjb.service;

import java.util.List;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.yjjb.bean.Xscljlb;

/**
 * 线索递转</br>
 * @author Administrator
 * @since 2014-11-17
 */
@TypeAnnotation("有奖举报_递转信息")
public interface XscljlbService {

	/**
	 * 查询单条<br>
	 * @param entity
	 * @return
	 */
	@MethodAnnotation(value = "查询单条", type = logType.query)
	public EasyUIPage queryList(EasyUIPage page,Xscljlb entity);
	
	/**
	 * 查询单条<br>
	 * @param entity
	 * @return
	 */
	@MethodAnnotation(value = "查询单条", type = logType.query)
	public Xscljlb queryById(Xscljlb entity);
	
	/**
	 * 新增<br>
	 * @param entity
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void save(Xscljlb entity, SessionBean sessionBean);

	/**
	 * 新增<br>
	 * 用于外部调用</br>
	 * @param entity
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void saveLog(String xsbh, String cznr, String czlx, SessionBean sessionBean);
	
	/**
	 * 更新<br>
	 * @param entity
	 */
	@MethodAnnotation(value = "更新", type = logType.update)
	public void update(Xscljlb entity, SessionBean sessionBean);

	/**
	 * 删除<br>
	 * @param entity
	 */
	@MethodAnnotation(value = "注销", type = logType.delete)
	public void delete(Xscljlb entity, SessionBean sessionBean);

	/**
	 * @Title: queryByXsbh
	 * @Description: 通过线索id查询列表
	 * @param @param entityLog    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "通过线索id查询列表", type = logType.query)
	public List<Xscljlb> queryListByXsbh(Xscljlb entity);
}
