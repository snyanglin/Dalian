package com.founder.zdrygl.base.service;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.entity.ManagerLog;
import com.founder.framework.entity.OperationLog;
import com.founder.framework.entity.ServiceLog;
import com.founder.framework.entity.ServiceRestLog;
import com.founder.framework.utils.Base64Utils;
import com.founder.framework.utils.DateTimeHelper;
import com.founder.framework.utils.UUID;
import com.founder.zdrygl.base.dao.OperationLogDao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
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
	 * @Title: countTrs
	 * @Description: TODO(通过日志统计交易)
	 * @param @return    设定文件
	 * @return List    返回类型
	 * @throw
	 */
	public List countTrs(){		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date=new Date();
		String endDate=sdf.format(date);
		String startDate=sdf.format(DateTimeHelper.addSeconds(date,-60));
		List list=new LinkedList();
		//1、按操作成功失败统计：OPERATE_RESULT  0=失败  1=成功
		countByResult(list,startDate,endDate);
		//2、按操作类型统计：OPERATE_TYPE   1=查询 2=新增  3=修改 4=注销
		countByType(list,startDate,endDate);
		//3、按模块名称统计：MODNAME
		countByMod(list,startDate,endDate);
		//4、按单位统计：ORGANIZATION
		countByOrg(list,startDate,endDate);
		
		return list;
	}
	
	/**
	 * 
	 * @Title: countByResult
	 * @Description: TODO(按操作成功失败统计)
	 * @param @param list
	 * @param @param startDate 
	 * @param @param endDate    设定文件
	 * @return void    返回类型
	 * @throw
	 */
	private void countByResult(List list,String startDate,String endDate){
		//OPERATE_RESULT的值列表，一般是0和1
		List resultList=operationLogDao.queryListByColName("OPERATE_RESULT");
		
		if(resultList!=null && resultList.size()>0){
			String result,resName;
			for(int i=0;i<resultList.size();i++){
				result=(String) resultList.get(i);
				if(result==null){
					resultList.remove(i);
					i--;
					continue;
				}
				
				
				//查询所有OPERATE_RESULT=result的数量
				if(result.equals("0"))
					resName="failure";
				else if(result.equals("1"))
					resName="success";
				else
					resName="other";
				Map resMap=new HashMap();
				resMap.put("key", "ops.results."+resName+".total_count");
				resMap.put("value", operationLogDao.countByColAndVale("OPERATE_RESULT",result,null,null));
				resMap.put("value_type", "integer");
				resMap.put("result", result);
				list.add(resMap);
				
				//查询最近一分钟OPERATE_RESULT=result的数量
				Map resMap2=new HashMap();
				resMap2.put("key", "ops.results."+resName+".count");
				resMap2.put("value", operationLogDao.countByColAndVale("OPERATE_RESULT",result,startDate,endDate));
				resMap2.put("value_type", "integer");
				resMap2.put("result", result);
				list.add(resMap2);
			}						
		}
		
		Map map=new HashMap();
		map.put("key", "ops.results");		
		map.put("value_type", "json");		
		if(resultList!=null && resultList.size()>0)
			map.put("value", resultList);
		else 
			map.put("value", "{}");
		
		list.add(map);
	}
	
	/**
	 * 
	 * @Title: countByType
	 * @Description: TODO(按操作类型统计)
	 * @param @param list
	 * @param @param startDate
	 * @param @param endDate    设定文件
	 * @return void    返回类型
	 * @throw
	 */
	private void countByType(List list,String startDate,String endDate){
		//按操作类型统计：OPERATE_TYPE   1=查询 2=新增  3=修改 4=注销
		List typeList=operationLogDao.queryListByColName("OPERATE_TYPE");
		
		if(typeList!=null  && typeList.size()>0){
			String type,typeName;
			for(int i=0;i<typeList.size();i++){
				type=(String) typeList.get(i);
				if(type==null){
					typeList.remove(i);
					i--;
					continue;
				}
				
				if(type.equals("1"))
					typeName="query";
				else if(type.equals("2"))
					typeName="new";
				else if(type.equals("3"))
					typeName="update";
				else if(type.equals("4"))
					typeName="delete";
				else
					typeName="other";
				
				//查询所有OPERATE_TYPE=type的数量
				Map resMap=new HashMap();
				resMap.put("key", "ops.results."+typeName+".total_count");
				resMap.put("value", operationLogDao.countByColAndVale("OPERATE_TYPE",type,null,null));
				resMap.put("value_type", "integer");
				resMap.put("result", type);
				list.add(resMap);
				
				//查询最近一分钟OPERATE_TYPE=type的数量
				Map resMap2=new HashMap();
				resMap2.put("key", "ops.results."+typeName+".count");
				resMap2.put("value", operationLogDao.countByColAndVale("OPERATE_TYPE",type,startDate,endDate));
				resMap2.put("value_type", "integer");
				resMap2.put("result", type);
				list.add(resMap2);
			}						
		}
		
		Map map=new HashMap();
		map.put("key", "ops.types");		
		map.put("value_type", "json");
		if(typeList!=null && typeList.size()>0)
			map.put("value", typeList);
		else 
			map.put("value", "{}");
		
		list.add(map);
	}
	
	/**
	 * 
	 * @Title: countByMod
	 * @Description: TODO(按模块名称统计)
	 * @param @param list
	 * @param @param startDate
	 * @param @param endDate    设定文件
	 * @return void    返回类型
	 * @throw
	 */
	private void countByMod(List list,String startDate,String endDate){
		//3、按模块名称统计：MODNAME
		List modList=operationLogDao.queryListByColName("MODNAME");		
		if(modList!=null && modList.size()>0){
			String mod;
			String base64Mod;
			for(int i=0;i<modList.size();i++){								
				mod=(String) modList.get(i);				
				if(mod==null){
					modList.remove(i);
					i--;
					continue;
				}
				base64Mod=strToBase64(mod);
				//列表中的中文也要编码
				modList.set(i, base64Mod);
				if(i>=10){ //最多查询10条					
					continue;
				}
				
				//查询所有MODNAME=mod的数量
				Map resMap=new HashMap();
				resMap.put("key", "ops.mods."+base64Mod+".total_count");
				resMap.put("value", operationLogDao.countByColAndVale("MODNAME",mod,null,null));
				resMap.put("value_type", "integer");
				resMap.put("mod", base64Mod);
				list.add(resMap);
				
				//查询最近一分钟MODNAME=mod的数量
				Map resMap2=new HashMap();
				resMap2.put("key", "ops.mods."+base64Mod+".count");
				resMap2.put("value", operationLogDao.countByColAndVale("MODNAME",mod,startDate,endDate));
				resMap2.put("value_type", "integer");
				resMap2.put("mod", base64Mod);
				list.add(resMap2);								
			}						
		}
		
		Map map=new HashMap();
		map.put("key", "ops.mods");		
		map.put("value_type", "json");		
		if(modList!=null && modList.size()>0)
			map.put("value", modList);
		else 
			map.put("value", "{}");
		
		list.add(map);
	}
	
	/**
	 * 
	 * @Title: countByOrg
	 * @Description: TODO(按单位统计)
	 * @param @param list
	 * @param @param startDate
	 * @param @param endDate    设定文件
	 * @return void    返回类型
	 * @throw
	 */
	private void countByOrg(List list,String startDate,String endDate){
		//按单位统计：ORGANIZATION
		List orgList=operationLogDao.queryListByColName("ORGANIZATION");
		
		if(orgList!=null && orgList.size()>0){
			String org;
			String base64Org;
			for(int i=0;i<orgList.size();i++){								
				org=(String) orgList.get(i);				
				if(org==null){
					orgList.remove(i);
					i--;
					continue;
				}
				
				base64Org=strToBase64(org);
				//列表中的中文也要编码
				orgList.set(i, base64Org);
				if(i>=10){//最多查询10条					
					continue;
				}
				//查询所有ORGANIZATION=org的数量
				Map resMap=new HashMap();
				resMap.put("key", "ops.orgs."+base64Org+".total_count");
				resMap.put("value", operationLogDao.countByColAndVale("ORGANIZATION",org,null,null));
				resMap.put("value_type", "integer");
				resMap.put("org", base64Org);
				list.add(resMap);
				
				//查询最近一分钟ORGANIZATION=org的数量
				Map resMap2=new HashMap();
				resMap2.put("key", "ops.orgs."+base64Org+".count");
				resMap2.put("value", operationLogDao.countByColAndVale("ORGANIZATION",org,startDate,endDate));
				resMap2.put("value_type", "integer");
				resMap2.put("org", base64Org);
				list.add(resMap2);
			}
									
		}
		
		Map map=new HashMap();
		map.put("key", "ops.orgs");	
		map.put("value_type", "json");
		if(orgList!=null && orgList.size()>0)
			map.put("value", orgList);
		else 
			map.put("value", "{}");
			
		list.add(map);
	}
	
	private String strToBase64(String str){
		return Base64Utils.base64Encoder(str.getBytes());
	}
}
