package com.founder.yjjb.service;

import java.util.List;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.yjjb.bean.Jbjlspb;

/**
 * 举报奖励信息</br>
 * @author yuhongyu
 * @since 2014-12-04
 */
@TypeAnnotation("有奖举报_奖励审批")
public interface JbjlspbService {
	
	/**
	 * 查询单条<br>
	 * @param entity
	 * @return
	 */
	@MethodAnnotation(value = "查询单条", type = logType.query)
	public EasyUIPage queryList(EasyUIPage page,Jbjlspb entity);
	
	/**
	 * 查询单条<br>
	 * @param entity
	 * @return
	 */
	@MethodAnnotation(value = "查询单条", type = logType.query)
	public Jbjlspb queryById(Jbjlspb entity);
	
	/**
	 * 新增<br>
	 * @param entity
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void save(Jbjlspb entity, SessionBean sessionBean);
	
	/**
	 * 更新<br>
	 * @param entity
	 */
	@MethodAnnotation(value = "更新", type = logType.update)
	public void update(Jbjlspb entity, SessionBean sessionBean);

	
	/**
	 * 删除<br>
	 * @param entity
	 */
	@MethodAnnotation(value = "删除", type = logType.delete)
	public void delete(Jbjlspb entity, SessionBean sessionBean);

	/**
	 * @Title: queryBySqbh
	 * @Description: 根据申请id查询
	 * @param @param entityJbjlspb
	 * @param @return    设定文件
	 * @return List<Jbjlspb>    返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "根据申请id查询", type = logType.query)
	public List<Jbjlspb> queryBySqbh(Jbjlspb entity);
}
