package com.founder.zafffwqz.service;
import java.util.List;
import java.util.Map;
import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zafffwqz.bean.Gzjsdmtxxb;
import com.founder.zafffwqz.bean.Gzjsxxb;

@TypeAnnotation("工作纪实")
public interface GzjsxxbService {
	
	@MethodAnnotation(value = "工作纪实", type = logType.query)
	public Gzjsxxb queryGzjsxxb(Gzjsxxb entity);
	
	@MethodAnnotation(value = "新增工作纪实", type = logType.insert)
	public void saveGzjsxxb(Gzjsxxb entity, SessionBean sessionBean);
	
	@MethodAnnotation(value = "修改工作纪实", type = logType.update)
	public void updateGzjsxxb(Gzjsxxb entity, SessionBean sessionBean);
	
	
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
	 * 注销-工作纪实信息
	 * @return
	 */
	public void delete(Gzjsxxb entity, SessionBean sessionBean);
	
	/**
	 * 添加工作纪实多媒体表记录
	 * @param entity
	 * @param sessionBean
	 */
	public void insertGzjsdmtxxb(Gzjsdmtxxb entity, SessionBean sessionBean);
	
	/**
	 * 删除工作纪实多媒体表记录
	 * @param entity
	 * @param sessionBean
	 */
	public void deleteGzjsdmtxxb(String gzjsid);
	
	/**
	 * 查询工作纪实多媒体表记录
	 * @param gzjsid
	 * @return
	 */
	public List<Gzjsdmtxxb> queryGzjsdmtxxb(String gzjsid);
}
