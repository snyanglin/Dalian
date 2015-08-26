package com.founder.sydw.service;

import java.util.Map;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.base.entity.SessionBean;
import com.founder.sydw.bean.Dwlscftzs;
import com.founder.sydw.bean.Dwzdhzyhzgtzs;
import com.founder.sydw.bean.Dwzlzgtzs;
/**
 * ****************************************************************************
 * @Package:      [com.founder.sydw.service.DwjczgService.java]  
 * @ClassName:    [DwjczgService]   
 * @Description:  单位检查整改
 * @Author:       [yu_guangli@founder.com.cn]  
 * @CreateDate:   [2015-6-24 下午3:02:00]   
 * @UpdateUser:   [yuguangli(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-24 下午3:02:00，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
public interface DwjczgService {
	/**
	 * 
	 * @Title: saveZlzgtzs
	 * @Description: 保存责令整改通知书
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void saveZlzgtzs(Dwzlzgtzs entity, SessionBean sessionBean);
	/**
	 * 
	 * @Title: queryZlzgtzs
	 * @Description: 查询责令整改通知书
	 * @param @param param
	 * @param @return    设定文件
	 * @return Dwzlzgtzs    返回类型
	 * @throws
	 */
	public Dwzlzgtzs queryZlzgtzs(Map<String,Object> param);
	/**
	 * 
	 * @Title: saveLscftzs
	 * @Description: 保存临时查封通知书
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void saveLscftzs(Dwlscftzs entity, SessionBean sessionBean);
	/**
	 * 
	 * @Title: queryLscftzs
	 * @Description: 查询临时查封通知书
	 * @param @param param
	 * @param @return    设定文件
	 * @return Dwlscftzs    返回类型
	 * @throws
	 */
	public Dwlscftzs queryLscftzs(Map<String,Object> param);
	/**
	 * 
	 * @Title: saveZdhzyhzgtzs
	 * @Description: 保存重大火灾隐患整改通知书
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void saveZdhzyhzgtzs(Dwzdhzyhzgtzs entity, SessionBean sessionBean);
	/**
	 * 
	 * @Title: queryZdhzyhzgtzs
	 * @Description: 查询重大火灾隐患整改通知书
	 * @param @param param
	 * @param @return    设定文件
	 * @return Dwzdhzyhzgtzs    返回类型
	 * @throws
	 */
	public Dwzdhzyhzgtzs queryZdhzyhzgtzs(Map<String,Object> param);
	/**
	 * 
	 * @Title: queryXh
	 * @Description: 查询序号
	 * @param @param param
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public String queryXh(Map<String,Object> param);
}
