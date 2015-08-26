package com.founder.sydw.service;

import java.util.List;
import java.util.Map;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.sydw.bean.Dwjcdata;
import com.founder.sydw.bean.Dwjctype;
/**
 * @描述: 单位检查模板配置
 * @作者:yu_guangli@founder.com 
 * @日期： 2015-6-5 下午1:28:39 
 * @throws
 */
@TypeAnnotation("单位检查模板信息")
public interface DwjctempService {
	/**
	 * @Title: addMultDwjctype 
	 * @描述: 保存到DW_DWJC_TYPE表数据
	 * @作者: yu_guangli@founder.com 
	 * @参数: 传入参数定义 
	 * @日期：  2015-6-5 下午1:28:39 
	 * @返回值: void    返回类型 
	 * @throws
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void addMultDwjctype(Dwjctype entity, SessionBean sessionBean);
	/**
	 * @Title: queryOneDwjctype 
	 * @描述: 从DW_DWJC_TYPE表中查询单条数据
	 * @作者: yu_guangli@founder.com 
	 * @参数: 传入参数定义 
	 * @日期：  2015-6-5 下午1:28:39 
	 * @返回值: Dwjctype    返回类型 
	 * @throws
	 */
	public Dwjctype queryOneDwjctype(Dwjctype entity);
	/**
	 * @Title: updateDwjctype 
	 * @描述: 修改DW_DWJC_TYPE表数据
	 * @作者: yu_guangli@founder.com 
	 * @参数: 传入参数定义 
	 * @日期：  2015-6-5 下午1:28:39 
	 * @返回值: void    返回类型 
	 * @throws
	 */
	@MethodAnnotation(value = "更新", type = logType.update)
	public void updateDwjctype(Dwjctype entity,SessionBean sessionBean);
	/**
	 * @Title: deleteDwjctype 
	 * @描述: 变更DW_DWJC_TYPE表数据的状态
	 * @作者: yu_guangli@founder.com 
	 * @参数: 传入参数定义 
	 * @日期：  2015-6-5 下午1:28:39 
	 * @返回值: void    返回类型 
	 * @throws
	 */
	@MethodAnnotation(value = "注销", type = logType.delete)
	public void deleteDwjctype(Dwjctype entity,SessionBean sessionBean);
	/**
	 * @Title: queryDwjctype 
	 * @描述: 单位检查类型分页查询
	 * @作者: yu_guangli@founder.com 
	 * @参数: 传入参数定义 
	 * @日期：  2015-6-5 下午1:28:39 
	 * @返回值: void    返回类型 
	 * @throws
	 */
	public EasyUIPage queryDwjctype(EasyUIPage page, Dwjctype entity);
	/**
	 * @Title: addMultDwjcdata 
	 * @描述: 保存到DW_DWJC_DATA表数据
	 * @作者: yu_guangli@founder.com 
	 * @参数: 传入参数定义 
	 * @日期：  2015-6-5 下午1:28:39 
	 * @返回值: void    返回类型 
	 * @throws
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void addMultDwjcdata(Dwjcdata entity, SessionBean sessionBean);
	/**
	 * @Title: queryOneDwjcdata 
	 * @描述: 从DW_DWJC_DATA表中查询单条数据
	 * @作者: yu_guangli@founder.com 
	 * @参数: 传入参数定义 
	 * @日期：  2015-6-5 下午1:28:39 
	 * @返回值: Dwjcdata    返回类型 
	 * @throws
	 */
	public Dwjcdata queryOneDwjcdata(Dwjcdata entity);
	/**
	 * @Title: updateDwjcdata 
	 * @描述: 修改DW_DWJC_DATA表数据
	 * @作者: yu_guangli@founder.com 
	 * @参数: 传入参数定义 
	 * @日期：  2015-6-5 下午1:28:39 
	 * @返回值: void    返回类型 
	 * @throws
	 */
	@MethodAnnotation(value = "更新", type = logType.update)
	public void updateDwjcdata(Dwjcdata entity,SessionBean sessionBean);
	/**
	 * @Title: deleteDwjcdata 
	 * @描述: 变更DW_DWJC_DATA表数据的状态
	 * @作者: yu_guangli@founder.com 
	 * @参数: 传入参数定义 
	 * @日期：  2015-6-5 下午1:28:39 
	 * @返回值: void    返回类型 
	 * @throws
	 */
	@MethodAnnotation(value = "注销", type = logType.delete)
	public void deleteDwjcdata(Dwjcdata entity,SessionBean sessionBean);
	/**
	 * @Title: queryDwjcdata 
	 * @描述: 单位检查项分页查询
	 * @作者: yu_guangli@founder.com 
	 * @参数: 传入参数定义 
	 * @日期：  2015-6-5 下午1:28:39 
	 * @返回值: void    返回类型 
	 * @throws
	 */
	public EasyUIPage queryDwjcdata(EasyUIPage page, Dwjcdata entity);
	
	/**
	 * @Title: queryDwjcTemp 
	 * @描述: 查询单位检查模板
	 * @作者: yu_guangli@founder.com 
	 * @参数: 传入参数定义 
	 * @日期：  2015-6-5 下午1:28:39 
	 * @返回值:List<Dwjctype>    返回类型 
	 * @throws
	 */
	public List<Dwjctype> queryDwjcTemp(Map<String,Object> param);
}
