package com.founder.sydw_dl.service;
import java.util.List;
import java.util.Map;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.sydw_dl.bean.Cyryxxb;

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
	public String add(Cyryxxb entity,  SessionBean sessionBean);
	
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
	 * 根据单位id查询从业人
	 * @Title: queryByDwid
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param dwid
	 * @param @return    设定文件
	 * @return List<Cyryxxb>    返回类型
	 * @throws
	 */
	public List<Cyryxxb> queryByDwid(String dwid);
	
	/**
	 * 单条注销从业人员
	 * @param cyryxxb
	 * @param sessionBean
	 */
	public void delete(Cyryxxb cyryxxb, SessionBean sessionBean);
	
	
}
