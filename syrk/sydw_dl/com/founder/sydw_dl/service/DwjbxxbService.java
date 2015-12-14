package com.founder.sydw_dl.service;

import java.util.List;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.sydw_dl.bean.Dwbmxxb;
import com.founder.sydw_dl.bean.Dwjbxxb;

@TypeAnnotation("实有单位基本信息")
public interface DwjbxxbService {

	/**
	 * 查询列表<br>
	 * 
	 * @param page
	 * @param entity
	 * @return
	 */
	public EasyUIPage queryList(EasyUIPage page, Dwjbxxb entity);

	/**
	 * 查询单条<br>
	 * 
	 * @param entity
	 * @return
	 */
	public Dwjbxxb query(Dwjbxxb entity);

	/**
	 * 查询未核实ById<br>
	 * 
	 * @param id
	 * @return
	 */
	public Dwjbxxb queryWhsById(String id);

	/**
	 * 查询单条，根据单位名称与单位地址代码<br>
	 * 
	 * @param dwmc
	 * @param dz_dwdzdm
	 * @return
	 */
	public Dwjbxxb queryByDwmcDwdzdm(String dwmc, String dz_dwdzdm);

	/**
	 * 判断是否存在该单位，根据单位ID、单位名称、单位地址代码<br>
	 * 
	 * @param dwmc
	 * @param dz_dwdzdm
	 * @return
	 */
	public boolean queryExistDw(String id, String dz_dwdzdm, String dwmc);


	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public String save(Dwjbxxb entity,Dwbmxxb [] dwbmxxbArray, 
			String hsrwid, SessionBean sessionBean);

	/**
	 * 更新<br>
	 * 
	 * @param entity
	 */
	@MethodAnnotation(value = "更新", type = logType.update)
	public void update(Dwjbxxb entity,  Dwbmxxb [] dwbmxxbArray,
			String hsrwid, SessionBean sessionBean);

	/**
	 * 删除<br>
	 * 
	 * @param entity
	 */
	@MethodAnnotation(value = "注销", type = logType.delete)
	public void delete(Dwjbxxb entity, SessionBean sessionBean);

	



	
	
	
	
	@MethodAnnotation(value = "验证联系方式是否有效", type = logType.query)
	public boolean queryLxfsValid(String lxdh, String dwid);
	
	
	/**
	 * 判断是否存在该别名，根据单位ID、单位别名
	 * 
	 * @param dwmc
	 * @param dz_dwdzdm
	 * @return
	 */
	public boolean queryExistBm(String id, String dwbm);

	/**
	 * @Title: queryDwbmxxbByDwid
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param dwid
	 * @param @return    设定文件
	 * @return List<Dwbmxxb>    返回类型
	 * @throws
	 */
	List<Dwbmxxb> queryDwbmxxbByDwid(String dwid);

}
