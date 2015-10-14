package logDev;

import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.entity.OperationLog;
import com.founder.framework.entity.ServiceRestLog;

import java.util.List;
import java.util.Map;

public abstract interface OperationLogServiceDev {
	public abstract void removeOperationLogById(String paramString);

	public abstract void insertOperationLog(String paramString1,
			String paramString2, int paramInt, String paramString3,
			Boolean paramBoolean, SessionBean paramSessionBean,
			String paramString4, String paramString5, String paramString6,
			String paramString7, String paramString8, String paramString9);

	public abstract Map<String, Object> queryObj(String paramString1,
			String paramString2, Object paramObject);

	public abstract void insertServiceLog(ServiceRestLog paramServiceRestLog);
	
	/**
	 * 
	 * @Title: queryOperationLogById
	 * @Description: TODO(通过主键NUM_ID查询单条日志记录)
	 * @param @param num_id
	 * @param @return    设定文件
	 * @return OperationLog    返回类型
	 * @throw
	 */
	public abstract OperationLog queryOperationLogById(String num_id);
	
	/**
	 * 
	 * @Title: queryOperationLogListByEntity
	 * @Description: TODO(通过日志对象查询list)
	 * @param @param entity
	 * @param @return    设定文件
	 * @return List<OperationLog>    返回类型
	 * @throw
	 */
	public abstract List<OperationLog> queryOperationLogListByEntity(OperationLog entity);		
	
	/**
	 * 
	 * @Title: countTrs
	 * @Description: TODO(通过日志统计交易)
	 * @param @return    设定文件
	 * @return List    返回类型
	 * @throw
	 */
	public abstract List countTrs();
}
