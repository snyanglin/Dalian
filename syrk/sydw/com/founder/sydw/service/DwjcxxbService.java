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
import com.founder.sydw.bean.Dwjcxxb;

@TypeAnnotation("单位检查信息")
public interface DwjcxxbService {
	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void save(Dwjcxxb entity, SessionBean sessionBean);
	/**
	 * 修改<br>
	 * 
	 * @param entity
	 */
	@MethodAnnotation(value = "修改", type = logType.update)
	public void update(Dwjcxxb entity, SessionBean sessionBean);	
	/**
	 * 查询单条<br>
	 * 
	 * @param entity
	 * @return
	 */
	public Dwjcxxb query(Dwjcxxb entity);
	/**
	 * 查询单位检查模板大类<br>
	 * 
	 * @param entity
	 * @return
	 */
	public List<Dwjctype> queryDwjctype(Map<String,Object> param);
	/**
	 * 查询单位检查项模板<br>
	 * 
	 * @param entity
	 * @return
	 */
	public List<Dwjcdata> queryDwjcdata(Map<String,Object> param);
	/**
	 * 
	 * @Title: queryList
	 * @Description: 查询列表-单位检查管理
	 * @param @param page
	 * @param @param entity
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryList(EasyUIPage page, Dwjcxxb entity);
	
	/**
	 * 
	 * @Title: queryDwfsxxByDwid
	 * @Description: 根据单位ID获取消防单位的一些附属信息回填
	 * @param @param dwid
	 * @param @return    设定文件
	 * @return Dwjcxxb    返回类型
	 * @throws
	 */
	public Dwjcxxb queryDwfsxxByDwid(String dwid);
	
	/**
	 *单位业务办理-单位检查信息
	 */
	public List<Dwjcxxb> dwjcxxb_query(Map<String, Object> map);
}
