package com.founder.yjjb.service;

import java.util.List;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.yjjb.bean.Jbjlxxb;

/**
 * 举报奖励信息</br>
 * @author yuhongyu
 * @since 2014-11-27
 */
@TypeAnnotation("有奖举报_奖励信息")
public interface JbjlxxbService {
	
	/**
	 * 查询单条<br>
	 * @param entity
	 * @return
	 */
	@MethodAnnotation(value = "查询单条", type = logType.query)
	public EasyUIPage queryList(EasyUIPage page,Jbjlxxb entity);
	
	/**
	 * 查询单条<br>
	 * @param entity
	 * @return
	 */
	@MethodAnnotation(value = "查询单条", type = logType.query)
	public Jbjlxxb queryById(Jbjlxxb entity);
	
	/**
	 * 新增<br>
	 * @param entity
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void save(Jbjlxxb entity, SessionBean sessionBean);
	
	/**
	 * 更新<br>
	 * @param entity
	 */
	@MethodAnnotation(value = "更新", type = logType.update)
	public void update(Jbjlxxb entity, SessionBean sessionBean);

	
	/**
	 * 删除<br>
	 * @param entity
	 */
	@MethodAnnotation(value = "删除", type = logType.delete)
	public void delete(Jbjlxxb entity, SessionBean sessionBean);

	/**
	 * @Title: queryId
	 * @Description:根据案件编号和id查询主键 
	 * @param @param jbjlxxb
	 * @param @return    设定文件
	 * @return Jbjlxxb    返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "ajbhxsbh查询id", type = logType.query)
	public Jbjlxxb queryId(Jbjlxxb jbjlxxb);

	/**
	 * @Title: queryByXsbhAjbh
	 * @Description: 根据线索编号案件编号查询申请表中的数据
	 * @param @param entJbjlxxb
	 * @param @return    设定文件
	 * @return List<Jbjlxxb>    返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "ajbhxsbh查询list", type = logType.query)
	public List<Jbjlxxb> queryByXsbhAjbh(Jbjlxxb entJbjlxxb);
}
