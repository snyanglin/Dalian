package com.founder.zdrygl.base.service;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.entity.ManagerLog;
import com.founder.framework.entity.OperationLog;
import com.founder.framework.entity.ServiceLog;
import com.founder.framework.entity.ServiceRestLog;
import com.founder.framework.utils.DateTimeHelper;
import com.founder.framework.utils.UUID;
import com.founder.zdrygl.base.dao.OperationLogDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import logDev.OperationLogServiceDev;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("operationLogServiceDev")
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
public class OperationLogServiceDevImpl implements OperationLogServiceDev {

	@Resource(name = "operationLogDaoDev")
	private OperationLogDao operationLogDao;

	public void removeOperationLogById(String logId) {
	}

	public void insertOperationLog(String moduleId, String operationId,
			int operationType, String paras, Boolean result,
			SessionBean sessionBean, String exMessage, String operate_content,
			String tablename, String pk, String operate_jsonContent,
			String query_filed) {
		switch (operationType) {
		case 5:
			ServiceLog serviceLog = new ServiceLog();
			this.operationLogDao.insertServiceLog(serviceLog);
			break;
		case 6:
			ManagerLog managerLog = new ManagerLog();
			this.operationLogDao.insertManagerLog(managerLog);
			break;
		default:
			OperationLog operationLog = new OperationLog();
			operationLog.setOperate_result((result.booleanValue()) ? 1 : 0);
			operationLog.setOperate_type(operationType);
			operationLog.setOperation_time(DateTimeHelper.getNowTime());
			if (sessionBean != null) {
				operationLog.setTerminal_id(sessionBean.getRemoteAddr());
				operationLog.setUser_id(sessionBean.getUserId());
				operationLog.setUser_name(sessionBean.getUserName());
				operationLog.setOrganization(sessionBean.getUserOrgName());
			} else {
				operationLog.setTerminal_id("127.0.0.4");
				operationLog.setUser_id("123456789");
				operationLog.setUser_name("jack");
				operationLog.setOrganization("RPC");
			}
			operationLog.setOperate_condition(paras);
			operationLog.setModName(moduleId);
			operationLog.setFuncName(operationId);
			operationLog.setOperate_content(operate_content);
			operationLog.setOperate_jsonContent(operate_jsonContent);
			operationLog.setTable_pk(pk);
			operationLog.setTable_name(tablename);
			operationLog.setQuery_filed(query_filed);
			this.operationLogDao.insertOperationLog(operationLog);
		}
	}

	public Map<String, Object> queryObj(String table, String pk, Object id) {
		Map map = new HashMap();
		map.put("tablename", table);
		map.put("pk", pk);
		map.put("id", id);
		return ((Map) this.operationLogDao.queryForObject("OpeLog.queryObj",
				map));
	}

	public void insertServiceLog(ServiceRestLog serviceRestLog) {
		serviceRestLog.setId(UUID.create());
		this.operationLogDao.insertRestServiceLog(serviceRestLog);
	}
	
	/**
	 * 
	 * @Title: queryOperationLogById
	 * @Description: TODO(通过主键NUM_ID查询单条日志记录)
	 * @param @param num_id
	 * @param @return    设定文件
	 * @return OperationLog    返回类型
	 * @throw
	 */
	public OperationLog queryOperationLogById(String num_id){
		return operationLogDao.queryById(num_id);
	}
	
	/**
	 * 
	 * @Title: queryOperationLogListByEntity
	 * @Description: TODO(通过日志对象查询list)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return List<OperationLog>    返回类型
	 * @throw
	 */
	public List<OperationLog> queryOperationLogListByEntity(OperationLog entity){
		return operationLogDao.queryListByEntity(entity);
	}
	
	/**
	 * 
	 * @Title: CountOperationLogByType
	 * @Description: TODO(通过日志类型和时间段统计数量)
	 * @param @param operate_type
	 * @param @param startDate(例如：>= 20140805135647)
	 * @param @param endDate(例如：< 20150805135647)
	 * @param @return    设定文件
	 * @return int    返回类型
	 * @throw
	 */
	public int countOperationLogByType(String operate_type,String startDate,String endDate){
		return operationLogDao.countByType(operate_type, startDate, endDate);
	}
}
