package logDev;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.MethodUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.util.WebUtils;

import com.founder.framework.annotation.DBInfoAnnotation;
import com.founder.framework.annotation.FieldDesc;
import com.founder.framework.annotation.MethodAnnotation;
import com.founder.framework.annotation.MethodAnnotation.logType;
import com.founder.framework.annotation.TypeAnnotation;
import com.founder.framework.base.entity.SessionBean;
import com.founder.framework.components.AppConst;
import com.founder.framework.config.SystemConfig;
import com.founder.framework.operationLog.service.OperationLogService;


/**
 * ****************************************************************************
 * 
 * @ClassName: [LogInterceptor]
 * @Description: [操作日志拦截器类]
 * @Author: [weiwen ]
 * @CreateDate: [2013-12-3 下午1:33:39]
 * @UpdateUser: [weiwen(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2013-12-6 下午1:33:39，(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@Aspect
public class LogInterceptor {

	private static final Log log = LogFactory.getLog(LogInterceptor.class);
	private static Map<String, Integer> logMap = new HashMap<String, Integer>();
	private static String validDataType = ",BOOLEAN,BYTE,DOUBLE,FLOAT,INTEGER,LONG,NUMBER,STRING,DATE,INT,"; // 写日志的有效数据类型

	static {
		for (int i = 0; i < logType.values().length; i++) {
			logMap.put(logType.values()[i].name(), i);
		}
	}

	@Autowired
	protected HttpServletRequest request;

	private Map<Integer, Object> jpContainer = new HashMap<Integer, Object>();

	@Resource(name = "operationLogServiceDev")
	private OperationLogServiceDev operationLogService;	
	
	/**
	 * 
	 * @Title: TypeAnnotation
	 * @Description: TODO(类上有TypeAnnotation的注解)
	 * @param     设定文件
	 * @return void    返回类型
	 * @throw
	 */
	@Pointcut("@within(com.founder.framework.annotation.TypeAnnotation)")
	public void TypeAnnotation() {

	}
	
	/**
	 * 
	 * @Title: MethodAnnotation
	 * @Description: TODO(方法上有MethodAnnotation的注解)
	 * @param     设定文件
	 * @return void    返回类型
	 * @throw
	 */
	@Pointcut("@annotation(com.founder.framework.annotation.MethodAnnotation)")
	public void MethodAnnotation() {

	}		

	/**
	 * 
	 * @Title: afterReturning
	 * @Description: TODO(Service的方法执行结束后的AOP)
	 * @param @param jp 切点
	 * @param @throws Throwable 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	@AfterReturning(value = "TypeAnnotation() && MethodAnnotation()")
	public void afterReturning(JoinPoint jp) throws Throwable {
		logService(jp, true, null);
	}

	@AfterThrowing(value = "TypeAnnotation() && MethodAnnotation()", throwing = "excep")
	public void afterThrowing(JoinPoint jp, Exception excep) throws Throwable {
		logService(jp, false, excep);
	}

	@Before(value = "TypeAnnotation() && MethodAnnotation()")
	public void before(JoinPoint jp) throws ClassNotFoundException {
		String moduleId = null; // 模块ID
		String operationId = null; // 操作ID
		String operationType = null;// 操作类型		
		
		Map map=doAnnotation(jp);
		if(map!=null){			
			moduleId=(String) map.get("moduleId");
			operationId=(String) map.get("operationId");
			operationType=(String) map.get("operationType");
		}else{
			return;
		}
		
		if (moduleId != null && operationId != null
				&& operationType.equals(logType.update.name())) {
			DBInfoAnnotation dbInfoAnnotation = null;
			
			Object[] args = getArgAray(jp);
			if (args != null && args.length > 0) {					
				try {
					if (args[0].getClass().isAnnotationPresent(
							DBInfoAnnotation.class)) {
						dbInfoAnnotation = args[0].getClass().getAnnotation(
								DBInfoAnnotation.class);
					}
				} catch (Exception e) {
					log.error("变更日志准备出错-01!" + e.getMessage(), e);
				}
				try {
					jpContainer.put(jp.hashCode(), operationLogService
							.queryObj(dbInfoAnnotation.tableName(),
									dbInfoAnnotation.pk(), MethodUtils
											.invokeMethod(args[0], "getId",
													null)));
				} catch (NoSuchMethodException e) {
				} catch (IllegalAccessException e) {
				} catch (InvocationTargetException e) {
				} catch (Exception e) {
					log.error("变更日志准备出错-02!" + e.getMessage(), e);
				}
			}
		}
		if (!"".equals(SystemConfig.getString("logLoader"))) { // 系统注册信息错误，退出系统
			System.exit(0);
		}
	}

	/**
	 * @throws Throwable
	 * 
	 * @Title: logService
	 * @Description: TODO(记录日志的方法调用)
	 * @param @param jp 切点
	 * @param @param result 操作成功标记
	 * @param @param ex 异常
	 * @param @throws ClassNotFoundException
	 * @param @throws SecurityException
	 * @param @throws NoSuchMethodException 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public void logService(JoinPoint jp, Boolean result, Exception ex)
			throws Throwable {
		String moduleId = null; // 模块ID
		String operationId = null; // 操作ID
		String operationType = null;// 操作类型
		//String ruleFlowName = null; // 规则名称
		String paras = "";// 传入参数
						
		Map map=doAnnotation(jp);
		if(map!=null){			
			moduleId=(String) map.get("moduleId");
			operationId=(String) map.get("operationId");
			operationType=(String) map.get("operationType");
		}else{
			jpContainer.remove(jp.hashCode());
			return;
		}			

		//参数处理
		if (moduleId != null && operationType != null && operationId != null) {					
			Map<String, Object> primaryObject = (Map<String, Object>) jpContainer.get(jp.hashCode());
			SessionBean sessionBean = (SessionBean) WebUtils
					.getSessionAttribute(request, AppConst.USER_SESSION);
			
			String operate_content="";			
			String jsonContent = "";
			String queryFiledValue="";
			String tableName="";
			String tablepk="";
			
			Object[] args = getArgAray(jp);
			if (args != null && args.length > 0) {	
				
				//数据库对象参数update操作
				String[] strAry=doDbPara(args[0],operationType,result,primaryObject);
				if(strAry!=null){
					operate_content=strAry[0];
					jsonContent=strAry[1];
					queryFiledValue=strAry[2];
					tableName=strAry[3];
					tablepk=strAry[4];
				}
				
				//List参数处理
				paras=this.doListPara(args[0]);
				
			}
			
			operationLogService.insertOperationLog(moduleId, operationId,
					logMap.get(operationType), paras.length() < 1000 ? paras
							: paras.substring(0, 1000), result, sessionBean,
					null == ex ? null : ex.getMessage(),
							operate_content.length() < 1000 ? operate_content.toString() : operate_content.substring(0, 1000),
									tableName,
									tablepk,
					jsonContent, queryFiledValue);
		}
		jpContainer.remove(jp.hashCode());
	}

	/**
	 * 
	 * @Title: doListPara
	 * @Description: TODO(List类型的参数处理)
	 * @param @param paraObj
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throw
	 */
	private String doListPara(Object paraObj) {
		try {			
			StringBuffer parasSb = new StringBuffer();
			
			if (paraObj instanceof List) {
				List list = (List) paraObj;
				parasSb.append("[");
				for (int i = 0; i < list.size(); i++) {
					parasSb.append("[");
					Object object = list.get(i);
					parasSb.append(getLogData(object));
					if (i < list.size() - 1) {
						parasSb.append(",");
					}
					parasSb.append("]");
				}
				parasSb.append("]");
			} else {
				parasSb.append("[");
				parasSb.append(getLogData(paraObj));
				parasSb.append("]");
			}
			return parasSb.toString();			
		
		} catch (Exception e) {
			log.error("日志记录解析参数出错!" + e.getMessage(), e);
		}
		return null;
	}

	private String getLogData(Object object) {
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		boolean startFlag = true;
		Field[] fields = object.getClass().getDeclaredFields();
		for (Field field : fields) {
			String fieldName = field.getName();
			Class fieldType = field.getType();
			String fieldTypeName = ","
					+ fieldType.getSimpleName().toUpperCase() + ",";
			if (!fieldType.isArray()
					&& validDataType.indexOf(fieldTypeName) != -1) { // 只处理基本数据类型，数组和其他对象不处理
				Object fieldValue = null;// 提交的数据
				try {
					fieldValue = PropertyUtils.getProperty(object, fieldName);
				} catch (Exception e) {
				}
				if (fieldValue != null) {
					String fieldValueString = String.valueOf(fieldValue);
					if (startFlag) {
						startFlag = false;
					} else {
						sb.append(",");
					}
					sb.append("\"" + fieldName + "\":");
					sb.append("\"" + fieldValueString + "\"");
				}
			}
		}
		sb.append("}");
		return sb.toString();
	}

	/**
	 * 
	 * @Title: getArgAray
	 * @Description: TODO(获取方法参数和需要记录的成员变量的数组)
	 * @param @param JoinPoint
	 * @param @return    设定文件
	 * @return Object[]    返回类型
	 * @throw
	 */
	private Object[] getArgAray(JoinPoint jp){
		Object[] args=jp.getArgs();//方法中传递的参数数组
		//获取类中需要当作参数处理的成员变量，即要记录日志的成员变量		
		Class classObj = jp.getTarget().getClass();//当前调用的对象，如zdryzbservice
		Field[] fields = classObj.getDeclaredFields();//变量数组
		Object paraObj;
		Method method;
		String methodName;
		if(fields!=null){
			List argList=new LinkedList();
			for(int i=0;i<fields.length;i++){
				if (fields[i].isAnnotationPresent(ParaAnnotation.class)) {//该变量已标记为需要记录日志
					try {
						if(fields[i].getModifiers()==Modifier.PUBLIC){//可访问
							paraObj = fields[i].get(jp.getTarget());
						}else{
							ParaAnnotation paraAnnotation = fields[i].getAnnotation(ParaAnnotation.class);
							methodName=paraAnnotation.value();//获取对象的方法名
							method=classObj.getDeclaredMethod(methodName, null);
							paraObj=method.invoke(jp.getTarget(), null);
						}
						argList.add(paraObj);
					} catch (Exception e) {						
						e.printStackTrace();
					} 
				}
				
			}
			
			if(argList.size()>0){//有需要处理的变量				
				Object[] paras = new Object[args.length+argList.size()];				
				System.arraycopy(argList.toArray(), 0, paras, 0, argList.size());
				System.arraycopy(args, 0, paras, argList.size(), args.length);
				return paras;
			}
		}
		return args;
	}
	
	/**
	 * 
	 * @Title: doAnnotation
	 * @Description: TODO(判断对象是否有类和方法的注解。并获取注解信息)
	 * @param @param jp
	 * @param @return    设定文件
	 * @return Map    返回类型
	 * @throw
	 */
	private Map doAnnotation(JoinPoint jp){
		String moduleId=null;
		String operationType=null;
		String operationId=null;
		try {
			log.debug("Module Class Name: " + jp.getTarget().getClass());
			Class<?> cls = jp.getTarget().getClass();
			boolean flag = cls.isAnnotationPresent(TypeAnnotation.class);
			if (flag) {
				TypeAnnotation moduleNameAnnotation = cls
						.getAnnotation(TypeAnnotation.class);
				moduleId = moduleNameAnnotation.value();
			} else {
				return null;
			}
		
			Method superMethod = ((MethodSignature) jp.getSignature()).getMethod();//可能是父类的方法，没有注解			
			Method method= cls.getDeclaredMethod(superMethod.getName(), superMethod.getParameterTypes());
			log.debug("Operation Method Name: " + method.getName());			
			flag = method.isAnnotationPresent(MethodAnnotation.class);			

			if (flag) {
				MethodAnnotation operationNameAnnotation = method
						.getAnnotation(MethodAnnotation.class);
				operationType = operationNameAnnotation.type().name();
				operationId = operationNameAnnotation.value();
			} else {
				return null;
			}
		} catch (Exception e) {			
			log.error("Log Error!");
			e.printStackTrace();
		}		
		
		Map map=new HashMap();
		map.put("moduleId", moduleId);
		map.put("operationType", operationType);
		map.put("operationId", operationId);
		return map;
	}
	
	/**
	 * 
	 * @Title: doDbPara
	 * @Description: TODO(处理数据表参数)
	 * @param @param obj
	 * @param @param operationType
	 * @param @param result
	 * @param @param primaryObject
	 * @param @return    设定文件
	 * @return String[]    返回类型
	 * @throw
	 */
	private String[] doDbPara(Object obj,String operationType,boolean result,Map primaryObject){
		if (operationType.equals(logType.update.name())
				&& primaryObject != null && !primaryObject.isEmpty()
				&& result) { // 变更日志条件			
			
			String queryFiled = "";
			String tableName = "";
			String tablepk = "";
			if (obj.getClass().isAnnotationPresent(
					DBInfoAnnotation.class)) {
				DBInfoAnnotation dbInfoAnnotation = obj.getClass().getAnnotation(
						DBInfoAnnotation.class);
				queryFiled = dbInfoAnnotation.logQueryField()
						.toUpperCase();
				tableName=dbInfoAnnotation.tableName();
				tablepk=dbInfoAnnotation.pk();
			}
			StringBuffer sb=new StringBuffer();
			StringBuffer jsonBuffer=new StringBuffer();
			String jsonContent;
			String queryFiledValue=doDbObject(obj,primaryObject,queryFiled,sb,jsonBuffer);
												
			if (jsonBuffer.length() == 0) {
				jsonContent = "{}";
			} else {
				jsonContent = "{"
						+ (jsonBuffer.lastIndexOf(",") == jsonBuffer.length() - 1 ? jsonBuffer.substring(0, jsonBuffer.length() - 1) : jsonBuffer.toString()) 
						+ "}";
			}
			
			String[] strAry=new String[5];
			strAry[0]=sb.toString();
			strAry[1]=jsonContent;
			strAry[2]=queryFiledValue;
			strAry[3]=tableName;
			strAry[4]=tablepk;
			return strAry;
		}
		
		return null;
	}
	
	/**
	 * 
	 * @Title: doDbObject
	 * @Description: TODO(处理数据库对象)
	 * @param @param obj
	 * @param @param primaryObject
	 * @param @param queryFiled
	 * @param @param sb
	 * @param @param jsonBuffer
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @throw
	 */
	private String doDbObject(Object obj,Map primaryObject,String queryFiled,StringBuffer sb,StringBuffer jsonBuffer){				
		Field[] fields = obj.getClass().getDeclaredFields();
	
		String fieldName,fieldTypeName;
		Class fieldType;
		for (Field field : fields) {
			fieldName = field.getName();//变量名
			fieldType = field.getType();//变量类型

			fieldTypeName = ","+ fieldType.getSimpleName().toUpperCase() + ",";
			if (!fieldType.isArray()
					&& validDataType.indexOf(fieldTypeName) != -1) { // 只处理基本数据类型，数组和其他对象不处理
				Object obj2 = null;// 提交的数据
				try {
					obj2 = PropertyUtils.getProperty(obj,
							fieldName);
				} catch (Exception e) {
				}
				if (obj2 != null
						&& primaryObject.containsKey(fieldName
								.toUpperCase())) {
					Object obj1 = null;// 原数据
					String str2 = String.valueOf(obj2);
					obj1 = primaryObject.get(fieldName.toUpperCase());
					String str1 = obj1 != null ? String.valueOf(obj1) : "";
					if (!str1.equals(str2)) { // 属性值不相同
						sb.append("【"
								+ (field.isAnnotationPresent(FieldDesc.class) ? field.getAnnotation(FieldDesc.class).value() : fieldName)
								+ "】由[" + str1 + "]变更为[" + str2
								+ "]，\n");
						jsonBuffer.append("'"
								+ fieldName
								+ "':'【"
								+ (field.isAnnotationPresent(FieldDesc.class) ? field
										.getAnnotation(
												FieldDesc.class)
										.value() : fieldName)
								+ "】由<" + str1 + ">变更为<" + str2
								+ ">',");
					}
					if (queryFiled.equals(fieldName.toUpperCase())) {
						return str2;
					}
				}
			}

		}
		
		return "";
	}
}
