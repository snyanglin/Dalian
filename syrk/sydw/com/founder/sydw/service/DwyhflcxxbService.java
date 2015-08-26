package com.founder.sydw.service;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.sydw.bean.Dwyhflcxxb;

@TypeAnnotation("单位银行分理处")
public interface DwyhflcxxbService {
	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void save(Dwyhflcxxb entity, SessionBean sessionBean);

	/**
	 * 修改<br>
	 * 
	 * @param entity
	 */
	@MethodAnnotation(value = "修改", type = logType.update)
	public void update(Dwyhflcxxb entity, SessionBean sessionBean);
	/**
	 * 查询单条<br>
	 * 
	 * @param entity
	 * @return
	 */
	public Dwyhflcxxb query(Dwyhflcxxb entity);
	
	@MethodAnnotation(value = "验证联系方式是否有效", type = logType.query)
	public boolean queryLxfsValid(String lxdh, String dwid);
}
