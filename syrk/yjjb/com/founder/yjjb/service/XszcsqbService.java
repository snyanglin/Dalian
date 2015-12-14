package com.founder.yjjb.service;

import java.util.List;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.yjjb.bean.Xscljlb;
import com.founder.yjjb.bean.Xszcsqb;

/**
 * 线索递转</br>
 * @author Administrator
 * @since 2014-11-17
 */
@TypeAnnotation("有奖举报_递转申请")
public interface XszcsqbService {

	/**
	 * 查询单条<br>
	 * @param entity
	 * @return
	 */
	@MethodAnnotation(value = "查询单条", type = logType.query)
	public EasyUIPage queryList(EasyUIPage page,Xszcsqb entity);
	
	/**
	 * 查询单条<br>
	 * @param entity
	 * @return
	 */
	@MethodAnnotation(value = "查询单条", type = logType.query)
	public Xszcsqb queryById(Xszcsqb entity);
	
	/**
	 * 新增<br>
	 * @param entity
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void save(Xszcsqb entity, SessionBean sessionBean);

	/**
	 * 更新<br>
	 * @param entity
	 */
	@MethodAnnotation(value = "更新", type = logType.update)
	public void update(Xszcsqb entity, SessionBean sessionBean);

	/**
	 * 删除<br>
	 * @param entity
	 */
	@MethodAnnotation(value = "注销", type = logType.delete)
	public void delete(Xszcsqb entity, SessionBean sessionBean);

	/**
	 * @Title: queryListByXsbh
	 * @Description: 通过线索id查询申请表的数据list
	 * @param @param entitySq    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public List<Xszcsqb> queryListByXsbh(Xszcsqb entity);
}
