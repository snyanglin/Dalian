package com.founder.zdrygl.base.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.utils.EasyUIPage;
import com.founder.zdrygl.base.model.ZdryDtjsXsxxb;

/**
 * ****************************************************************************
 * @Package:      [com.founder.qbld.dao.RyxsDao.java]  
 * @ClassName:    [RyxsDao]   
 * @Description:  [動態紀實 寫實基本信息]   
 * @Author:       [cong_rihong@founder.com.cn]  
 * @CreateDate:   [2015-12-7 上午9:30:05]   
 * @UpdateUser:   [founder(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015-12-7 上午9:30:05，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Repository("zdryDtjsXsDao")
public class ZdryDtjsXsDao extends BaseDaoImpl {

	/**
	 * @Title: saveXscjb
	 * @Description: TODO(保存人员写实表数据)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	public void saveRyxsb(ZdryDtjsXsxxb entity) {
		insert("ZdryDtjsXs.saveZdryDtjsXsxxb", entity); 
	
	}
	
	public String updateZdryDtjsXsxxb(ZdryDtjsXsxxb entity) {
		update("ZdryDtjsXs.updateZdryDtjsXsxxb", entity); 
		return entity.getId();
	}
	
	public ZdryDtjsXsxxb querXsjbxxById(String id){
		return (ZdryDtjsXsxxb)queryForObject("ZdryDtjsXs.queryZdryDtjsXsxxbById", id);
	}
	
	public List<ZdryDtjsXsxxb> queryZdryDtjsXsxxbByZdryZjhm(String zdryZjhm){
		return (List<ZdryDtjsXsxxb>)queryForList("ZdryDtjsXs.queryZdryDtjsXsxxbByZdryZjhm", zdryZjhm);

	}
	
	public void deleteDtjsXsjbxx(ZdryDtjsXsxxb entity){
		update("ZdryDtjsXs.deleteZdryDtjsXsxxb", entity); 

	}
	

	/**
	 * @Title: queryRyxsList
	 * @Description: TODO(人员写实列表查询)
	 * @param @param page
	 * @param @param entity
	 * @param @return    设定文件
	 * @return EasyUIPage    返回类型
	 * @throws
	 */
	public List<?> queryRyxsList(EasyUIPage page, Map<String, Object> map) {
		return queryForList("ZdryDtjsXs.queryXsjbxxPageByZdryZjhm", map);
	}

	
	/**
	 * @Title: queryRyxsListCount
	 * @Description: TODO(人员写实条数查询)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return long    返回类型
	 * @throws
	 */
	public long queryRyxsListCount(Map<String, Object> map) {
		Integer count = (Integer) queryForObject("ZdryDtjsXs.queryXsjbxxCountByZdryZjhm", map);
		return count.longValue();
	}	
	
}
