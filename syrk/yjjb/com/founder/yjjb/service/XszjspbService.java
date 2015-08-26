package com.founder.yjjb.service;

import java.util.List;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.yjjb.bean.Xszjspb;

/**
 * 线索举报</br>
 * @author chenwenlong
 * @since 2014-12-2
 */
@TypeAnnotation("有奖举报_线索征集审批")
public interface XszjspbService {
	/**
	 * 查询单条<br>
	 * @param entity
	 * @return
	 */
	public EasyUIPage queryList(EasyUIPage page,Xszjspb entity);
	
	/**
	 * 查询单条<br>
	 * @param entity
	 * @return
	 */
	public Xszjspb queryById(Xszjspb entity);
	
	/**
	 * 查询<br>
	 * @param entity
	 * @return
	 */
	public List<Xszjspb> queryBySqbh(Xszjspb entity);
	
	/**
	 * 同意或拒绝审批<br>
	 * @param entity
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void save(Xszjspb entity, SessionBean sessionBean);
	/**
	 * 同意或拒绝审批<br>
	 * @param entity
	 */
	@MethodAnnotation(value = "修改", type = logType.insert)
	public void update(Xszjspb entity, SessionBean sessionBean);
	
	
}
