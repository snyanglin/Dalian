package com.founder.sydw.service;

import java.util.Map;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.base.entity.SessionBean;
import com.founder.sydw.bean.JFDwzlzgtzs;
import com.founder.sydw.bean.JfFcyjs;
/**
 * ****************************************************************************
 * @Package:      [com.founder.sydw.service.JFjczgService.java]  
 * @ClassName:    [JFjczgService]   
 * @Description:  技防检查整改
 * @Author:       [xu_haibo@founder.com.cn]  
 * @CreateDate:   [2015-6-29 下午3:02:00]   
 * @UpdateUser:   [xuhaibo(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-29 下午3:02:00，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
public interface JFjczgService {
	/**
	 * 
	 * @Title: saveJfzlzgtzs
	 * @Description: 保存技防责令整改通知书
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void saveJfzlzgtzs(JFDwzlzgtzs entity, SessionBean sessionBean);
	/**
	 * 
	 * @Title: queryJfzlzgtzs
	 * @Description: 查询技防责令整改通知书
	 * @param @param param
	 * @param @return    设定文件
	 * @return JFDwzlzgtzs    返回类型
	 * @throws
	 */
	public JFDwzlzgtzs queryJfzlzgtzs(Map<String,Object> param);

	/**
	 * 
	 * @Title: saveJFfcyjs
	 * @Description: 保存技防复查意见书
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void saveJFfcyjs(JfFcyjs entity, SessionBean sessionBean);
	/**
	 * 
	 * @Title: queryJFfcyjs
	 * @Description: 查询技防复查意见书
	 * @param @param param
	 * @param @return    设定文件
	 * @return JfFcyjs    返回类型
	 * @throws
	 */
	public JfFcyjs queryJFfcyjs(Map<String,Object> param);
}
