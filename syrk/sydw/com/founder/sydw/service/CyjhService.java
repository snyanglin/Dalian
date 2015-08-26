package com.founder.sydw.service;

import java.util.List;
import java.util.Map;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.sydw.bean.Dwcyjcrwxxb;
import com.founder.sydw.bean.Xfdwcccsxxb;

/**
 * ****************************************************************************
 * @Package:      [com.founder.sydw.service.CyjhService.java]  
 * @ClassName:    [CyjhService]   
 * @Description:  抽样计划  
 * @Author:       [yu_guangli@founder.com.cn]  
 * @CreateDate:   [2015-7-6 上午9:25:55]   
 * @UpdateUser:   [yuguangli(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-7-6 上午9:25:55，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@TypeAnnotation("抽样计划")
public interface CyjhService {
	/**
	 * 
	 * @Title: queryXfdwlxByJbdwlb
	 * @Description: 按照消防监管类别统计本辖区消防单位数量
	 * @param @param param
	 * @param @return    设定文件
	 * @return Map<String,Object>    返回类型
	 * @throws
	 */
	public Map<String,Object> queryXfdwlxByJbdwlb(Map<String,Object> param);
	
	/**
	 * 
	 * @Title: saveXfdwcccsxxb
	 * @Description: 保存消防单位抽查参数配置
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void saveXfdwcccsxxb(Xfdwcccsxxb entity, SessionBean sessionBean);
	/**
	 * 
	 * @Title: modifyXfdwcccsxxb
	 * @Description: 修改消防单位抽查参数配置
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "修改", type = logType.update)
	public void modifyXfdwcccsxxb(Xfdwcccsxxb entity, SessionBean sessionBean);
	/**
	 * 
	 * @Title: deleteXfdwcccsxxb
	 * @Description: 删除消防单位抽查参数配置
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "删除", type = logType.delete)
	public void deleteXfdwcccsxxb(Xfdwcccsxxb entity, SessionBean sessionBean);
	/**
	 * 
	 * @Title: queryXfdwcccsxxbForPage
	 * @Description: 分页查询消防单位抽查参数配置
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryXfdwcccsxxbForPage(EasyUIPage page,Xfdwcccsxxb entity);
	
	/**
	 * 
	 * @Title: queryXfdwcccsxxb
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return Xfdwcccsxxb    返回类型
	 * @throws
	 */
	public Xfdwcccsxxb queryXfdwcccsxxb(Xfdwcccsxxb entity);
	
	/**
	 * 
	 * @Title: modifyDwcyjcrwxxb
	 * @Description: 修改单位抽样检查任务
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "修改", type = logType.update)
	public void modifyDwcyjcrwxxb(Dwcyjcrwxxb entity, SessionBean sessionBean);
	
	/**
	 * 
	 * @Title: queryDwcyjcrwxxbForPage
	 * @Description: 单位抽样检查任务分页查询
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryDwcyjcrwxxbForPage(EasyUIPage page,Dwcyjcrwxxb entity);
	
	/**
	 * 
	 * @Title: saveDwcyjcrwxxb
	 * @Description: 添加单位抽样检查任务
	 * @param @param entity
	 * @param @param sessionBean    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void saveDwcyjcrwxxb(Dwcyjcrwxxb entity, SessionBean sessionBean);
	
	/**
	 * 
	 * @Title: queryDwcyjcrwxxbsByRwid
	 * @Description: 查询单位检查任务列表
	 * @param @param param
	 * @param @return    设定文件
	 * @return List<Dwcyjcrwxxb>    返回类型
	 * @throws
	 */
	public List<Dwcyjcrwxxb> queryDwcyjcrwxxbsByRwid(Map<String,Object> param);
}
