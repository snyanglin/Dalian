package com.founder.yjjb.service;

import java.util.List;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.yjjb.bean.Xszcspb;

/**
 * 线索递转</br>
 * @author Administrator
 * @since 2014-11-24
 */
@TypeAnnotation("有奖举报_递转")
public interface XszcspbService {

	/**
	 * 查询单条</br>
	 * @param entity
	 * @return
	 */
	@MethodAnnotation(value = "查询单条", type = logType.query)
	public EasyUIPage queryList(EasyUIPage page,Xszcspb entity);
	
	/**
	 * 查询单条</br>
	 * @param entity
	 * @return
	 */
	@MethodAnnotation(value = "查询单条", type = logType.query)
	public Xszcspb queryById(Xszcspb entity);
	
	/**
	 * 新增</br>
	 * @param entity
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void save(Xszcspb entity, SessionBean sessionBean);

	/**
	 * 更新</br>
	 * @param entity
	 */
	@MethodAnnotation(value = "更新", type = logType.update)
	public void update(Xszcspb entity, SessionBean sessionBean);

	/**
	 * 删除</br>
	 * @param entity
	 */
	@MethodAnnotation(value = "注销", type = logType.delete)
	public void delete(Xszcspb entity, SessionBean sessionBean);

	/**
	 * 通过线索申请id查询列表</br>
	 * @param entity
	 */
	@MethodAnnotation(value = "通过线索申请id查询列表", type = logType.query)
	public List<Xszcspb> queryListBySqid(String sqid);

}
