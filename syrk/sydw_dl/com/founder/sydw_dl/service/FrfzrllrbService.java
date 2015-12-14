package com.founder.sydw_dl.service;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.sydw_dl.bean.Frfzrllrb;

@TypeAnnotation("法人/负责人/联络员")
public interface FrfzrllrbService {
	
	/**
	 * 根据法人/负责人/联络员id查询对象
	 * @param entity
	 * @return
	 */
	public Frfzrllrb queryById(String id);
	
	/**
	 * 新增法人/负责人/联络员
	 * @param entity
	 * @return String
	 */
	public boolean add(Frfzrllrb entity, SessionBean sessionBean);
	
	/**
	 * 修改法人/负责人/联络员
	 * @param entity
	 * @return
	 */
	@MethodAnnotation(value = "修改", type = logType.update)
	public boolean update(Frfzrllrb entity, SessionBean sessionBean);

	public EasyUIPage queryList(EasyUIPage page, String dwid);

	public void delete(Frfzrllrb entity, SessionBean sessionBean);
	
	@MethodAnnotation(value = "验证联系方式是否有效", type = logType.query)
	public boolean queryLxfsValid(String lxdh, String dwid);

	/**
	 * 
	 * @Title: queryFrByDwid
	 * @Description: TODO(根据单位ID查询单位法人)
	 * @param @param dwid
	 * @param @return    设定文件
	 * @return Frfzrllrb    返回类型
	 * @throws
	 */
	public Frfzrllrb queryFrByDwid(String dwid);

}
