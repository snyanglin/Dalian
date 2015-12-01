package com.founder.spsxt.service;
import java.util.Map;
import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.spsxt.bean.Spjkxt;
@TypeAnnotation("视频监控系统")
public interface SpjkxtService {

	@MethodAnnotation(value = "视频监控系统", type = logType.insert)
	public void insertSpjkxt(Spjkxt entity, SessionBean sessionBean);
	
	@MethodAnnotation(value = "视频监控系统")//不能设置属性 type = logType.update	
	public void updateSpjkxt(Spjkxt entity, SessionBean sessionBean);
	
	@MethodAnnotation(value = "视频监控系统", type = logType.query)	
	public Spjkxt querySpjkxtByXh(int xh);
	
	//根据主键删除
	@MethodAnnotation(value = "视频建设单位", type = logType.delete)//, type = logType.delete
	public String deleteSpjkxtByXh(String xh);
	

	/**
	 * 查询列表<br>
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	@MethodAnnotation(value = "查询")
	public EasyUIPage queryList(EasyUIPage page,Map map);
	
	
	public Integer checkSameName(Map map);
	public Map<String, String> queryLwsxByXh(String xh);
}
