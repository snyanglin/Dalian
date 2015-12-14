package com.founder.yjjb.service;

import java.util.List;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.ComboBox;
import com.founder.framework.utils.EasyUIPage;
import com.founder.yjjb.bean.Xsjbxxb;
import com.founder.yjjb.bean.Xszjxxb;

/**
 * 线索举报</br>
 * @author chenwenlong
 * @since 2014-11-27
 */
@TypeAnnotation("有奖举报_线索征集")
public interface XszjxxbService {
	/**
	 * 查询单条<br>
	 * @param entity
	 * @return
	 */
	public EasyUIPage queryList(EasyUIPage page,Xszjxxb entity);
	
	/**
	 * 查询单条<br>
	 * @param entity
	 * @return
	 */
	public Xszjxxb queryById(Xszjxxb entity);
	
	/**
	 * 新增<br>
	 * @param entity
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void save(Xszjxxb entity, SessionBean sessionBean);
	
	/**
	 * 设置线索征集信息被同意或拒绝<br>
	 * @param entity
	 */
	@MethodAnnotation(value = "修改", type = logType.insert)
	public void update(Xszjxxb entity, SessionBean sessionBean);
}
