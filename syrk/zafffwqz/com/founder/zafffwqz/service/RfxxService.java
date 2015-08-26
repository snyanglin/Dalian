package com.founder.zafffwqz.service;

import java.util.List;

import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zafffwqz.bean.ZaffRfcyxxb;
import com.founder.zafffwqz.bean.ZaffRfxxb;
@TypeAnnotation("人防信息")
public interface RfxxService {
	
	/**
	 * 
	 * @param entity
	 */
	public void insertRfxx(ZaffRfxxb entity, SessionBean sessionBean);
	public void insertRfxx(ZaffRfxxb entity, SessionBean sessionBean,List<ZaffRfcyxxb> insertList);
	/**
	 * 
	 * @param entity
	 * @return
	 */
	public ZaffRfxxb queryRfxxById(ZaffRfxxb entity);
	/**
	 * 
	 * @param entity
	 * @return
	 */
	public int updateRfxx(ZaffRfxxb entity, SessionBean sessionBean);
	public void updateRfxx(ZaffRfxxb entity, SessionBean sessionBean,List<ZaffRfcyxxb> insertList);
	public void updateRfxxAndDE(ZaffRfxxb entity, SessionBean sessionBean,List<ZaffRfcyxxb> deleteList);
	public void updateRfxx(ZaffRfxxb entity, SessionBean sessionBean,List<ZaffRfcyxxb> insertList,List<ZaffRfcyxxb> deleteList);
	/**
	 * 
	 * @param entity
	 * @return
	 */
	public int deleteRfxx(ZaffRfxxb entity, SessionBean sessionBean);
	/**
	 * 人防信息查询
	 * @param page
	 * @param entity
	 * @return
	 */
	@MethodAnnotation(value = "查询集合")
	public EasyUIPage queryRf(EasyUIPage page, ZaffRfxxb entity);
	
	/**
	 * 人防成员相关
	 * @param entity
	 */
	public void saveRfcyxx(ZaffRfcyxxb entity, SessionBean sessionBean);
	public int updateRfcyxx(ZaffRfcyxxb entity, SessionBean sessionBean);
	public int deleteRfcyxx(ZaffRfcyxxb entity, SessionBean sessionBean);
	public ZaffRfcyxxb queryRfcyxxById(ZaffRfcyxxb entity);
	public EasyUIPage queryRfcyxx(EasyUIPage page, ZaffRfcyxxb entity);
	
	public void saveRfcyxx(List<ZaffRfcyxxb> entity, SessionBean sessionBean,String id);
	public void deleteRfcyxx(List<ZaffRfcyxxb> entity, SessionBean sessionBean);
	public void updateRfcyxx(List<ZaffRfcyxxb> entity, SessionBean sessionBean);
	
}
