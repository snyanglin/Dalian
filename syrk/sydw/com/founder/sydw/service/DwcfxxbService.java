package com.founder.sydw.service;

import java.util.List;
import java.util.Map;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.sydw.bean.Dwcfxxb;
/**
 * ****************************************************************************
 * @Package:      [com.founder.sydw.service.DwcfxxbService.java]  
 * @ClassName:    [DwcfxxbService]   
 * @Description:  [单位处罚 service]   
 * @Author:       [yu_guangli@founder.com.cn]  
 * @UpdateUser:   [yuguangli(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-6-11 上午9:44:41，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [增加分页查询queryList方法]  
 * @Version:      [v1.0]
 */
@TypeAnnotation("单位处罚信息表")
public interface DwcfxxbService {
	/**
	 * 新增<br>
	 * 
	 * @param entity
	 */
	@MethodAnnotation(value = "新增", type = logType.insert)
	public void save(Dwcfxxb entity, SessionBean sessionBean);

	/**
	 * 修改<br>
	 * 
	 * @param entity
	 */
	@MethodAnnotation(value = "修改", type = logType.update)
	public void update(Dwcfxxb entity, SessionBean sessionBean);
	/**
	 * 查询单条<br>
	 * 
	 * @param entity
	 * @return
	 */
	public Dwcfxxb queryEntityById(Dwcfxxb entity);
	
	/**
	 * 
	 * @Title: queryList
	 * @Description: 查询列表-单位处罚
	 * @param @param page
	 * @param @param entity
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public EasyUIPage queryList(EasyUIPage page, Dwcfxxb entity);
	/**
	 * 
	 * @Title: dwcfxxb_query
	 * @Description: 单位处罚信息
	 * @param @param map
	 * @param @return    设定文件
	 * @return List<Dwcfxxb>    返回类型
	 * @throws
	 */
	public List<Dwcfxxb> dwcfxxb_query(Map<String, Object> map);
}
