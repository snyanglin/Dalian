package com.founder.zdry.service;
import java.util.List;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zdry.bean.Zdrylxylbdyb;

/**
 * 
 * 类描述<br>
 * @author zhangxijiu@founder.com.cn
 * @version 2015-2-2
 * 
 */

public interface ZdrylxylbdybService {
	

	/**
	 * 查询重点人员类型与类别对应信息列表
	 * @return
	 */
	public EasyUIPage queryList(EasyUIPage page, Zdrylxylbdyb entity);

	/**
	 * 查询重点人员类型与类别对应信息统计列表记录数
	 * @return
	 */
	public long queryCount(Zdrylxylbdyb entity);
	
	
	/**
	 * 删除重点人员类型与类别对应关系
	 * @return
	 */
	public void delete(Zdrylxylbdyb entity, SessionBean sessionBean);
	
	/**
	 * 添加重点人员类型与类别对应关系
	 * @return
	 */
	 

	public void saveZdrylxylbdyb(Zdrylxylbdyb entity, SessionBean sessionBean);
	/**
	 * 更新重点人员类型与类别对应关系
	 * @return
	 */
	 
	public void updateZdrylxylbdyb(Zdrylxylbdyb entity, SessionBean sessionBean);
	/**
	 * 查询重点人员类型与类别对应关系
	 * @return
	 */
	public Zdrylxylbdyb query(Zdrylxylbdyb entity);
	
	/**
	 *批量删除重点人员类型与类别对应关系
	 * @return
	 */
	public  void deletePatch(Zdrylxylbdyb[] entityArray, SessionBean sessionBean);
	
	/**
	 *param:zdrylxdm查询重点人员类型与类别对应关系
	 * @return
	 */
	public List<Zdrylxylbdyb> queryZdrylbdm(String zdrylxdm);
	/**
	 *判断查询重点人员类型与类别对应关系
	 * @return
	 */
	
	public List<Zdrylxylbdyb> getisExist(String zdrylbdm);
	
	
}

