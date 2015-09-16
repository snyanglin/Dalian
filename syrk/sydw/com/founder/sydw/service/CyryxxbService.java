package com.founder.sydw.service;
import java.util.Map;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.sydw.bean.Cyryxxb;
import com.founder.sydw.bean.Dictxxb;

@TypeAnnotation("从业人员")
public interface CyryxxbService {
	
	/**
	 * 根据从业人员id查询对象
	 * @param entity
	 * @return
	 */
	public Cyryxxb queryById(String id);
	
	/**
	 * 根据证件及类别查询有效的从业人员信息
	 * @param entity
	 * @return
	 */
	public Cyryxxb queryByZjlx(Cyryxxb entity);
	
	/**
	 * 新增从业人员
	 * @param entity
	 */
	public void add(Cyryxxb entity,  SessionBean sessionBean);
	
	/**
	 * 修改从业人员
	 * @param entity
	 * @return
	 */
	public void update(Cyryxxb entity, SessionBean sessionBean);

	
	/**
	 * 根据单位ID查从业人员分页列表
	 * @param page
	 * @param dwid
	 * @return
	 */
	public EasyUIPage queryList(EasyUIPage page, String dwid);

	/**
	 * 单条注销从业人员
	 * @param cyryxxb
	 * @param sessionBean
	 */
	public void delete(Cyryxxb cyryxxb, SessionBean sessionBean);
	
	/**
	 * 实有单位添加从业人员比对重点人员获取字典项词条信息
	 * @param sfzh
	 * @return
	 */
	public Dictxxb getCt(String sfzh);
	
	
}
