package com.founder.zafffwqz.service;
import java.util.Map;
import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zafffwqz.bean.Mdxxb;


@TypeAnnotation("矛盾调解")
public interface MdxxbService {
	
	@MethodAnnotation(value = "矛盾调解", type = logType.query)
	public Mdxxb queryMdxxb(Mdxxb entity);
	
	@MethodAnnotation(value = "新增矛盾调解", type = logType.insert)
	public void saveMdxxb(Mdxxb entity, SessionBean sessionBean);
	
	@MethodAnnotation(value = "修改矛盾调解", type = logType.update)
	public void updateMdxxb(Mdxxb entity, SessionBean sessionBean);
	
	/**
	 * 查询列表<br>
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	@MethodAnnotation(value = "查询")
	public EasyUIPage queryList(EasyUIPage page,Map map);
	
	
	/**
	 * 注销矛盾调解信息
	 * @return
	 */
	public void delete(Mdxxb entity, SessionBean sessionBean);
}
