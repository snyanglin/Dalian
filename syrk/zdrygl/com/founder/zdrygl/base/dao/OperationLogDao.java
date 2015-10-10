package com.founder.zdrygl.base.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.founder.framework.base.dao.BaseDaoImpl;
import com.founder.framework.entity.ManagerLog;
import com.founder.framework.entity.OperationLog;
import com.founder.framework.entity.ServiceLog;
import com.founder.framework.entity.ServiceRestLog;

import org.springframework.stereotype.Repository;

@Repository("operationLogDaoDev")
public class OperationLogDao extends BaseDaoImpl {
	public void insertOperationLog(OperationLog log) {
		super.insert("OpeLogDev.insertInfoLog", log);
	}

	public void insertServiceLog(ServiceLog log) {
		super.insert("", log);
	}

	public void insertManagerLog(ManagerLog log) {
		super.insert("", log);
	}

	public void insertRestServiceLog(ServiceRestLog serviceRestLog) {
		super.insert("OpeLogDev.insertServiceLog", serviceRestLog);
	}
	
	/**
	 * 
	 * @Title: queryById
	 * @Description: TODO(通过主键NUM_ID查询单条日志记录)
	 * @param @param num_id
	 * @param @return    设定文件
	 * @return OperationLog    返回类型
	 * @throw
	 */
	public OperationLog queryById(String num_id){
		return (OperationLog) queryForObject("OpeLogDev.queryById", num_id);
	}
	
	/**
	 * 
	 * @Title: queryListByEntity
	 * @Description: TODO(通过日志对象查询list)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return List<OperationLog>    返回类型
	 * @throw
	 */
	public List<OperationLog> queryListByEntity(OperationLog entity){
		return queryForList("OpeLogDev.queryListByEntity", entity);
	}
	
	/**
	 * 
	 * @Title: countByType
	 * @Description: TODO(通过日志类型和时间段统计数量)
	 * @param @param operate_type
	 * @param @param startDate(例如：>= 20140805135647)
	 * @param @param endDate(例如：< 20150805135647)
	 * @param @return    设定文件
	 * @return int    返回类型
	 * @throw
	 */
	public int countByType(String operate_type,String startDate,String endDate){
		Map map=new HashMap();
		map.put("operate_type", operate_type);
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		return (int) queryForObject("OpeLogDev.countByType", map);
	}
}