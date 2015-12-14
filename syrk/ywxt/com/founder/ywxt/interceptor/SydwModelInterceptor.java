package com.founder.ywxt.interceptor;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import com.founder.bzdz.service.DzService;
import com.founder.bzdz.vo.BzdzxxbVO;
import com.founder.framework.organization.department.service.OrgOrganizationService;
import com.founder.framework.utils.DateUtils;
import com.founder.framework.utils.StringUtils;
import com.founder.sydw_dl.bean.Cyryxxb;
import com.founder.syrkgl.bean.SyrkCzrkxxb;
import com.founder.syrkgl.dao.SyrkSyrkxxzbDao;
import com.founder.ywxt.bean.Ywxtcyryxxb;
import com.founder.ywxt.bean.Ywxtsfqypzb;
import com.founder.ywxt.factory.XtFactory;
import com.founder.ywxt.service.AbstractXtTask;
import com.founder.ywxt.service.XtTaskService;
import com.founder.ywxt.service.YwxtsfqypzService;

/**
 * ****************************************************************************
 * 
 * @Package: [com.founder.ywxt.aop.SyrkModelAop.java]
 * @ClassName: [SyrkModelAop]
 * @Description: [实有人口模型层切面方法]
 * @Author: [wu_chunhui@founder.com.cn]
 * @CreateDate: [2015-5-27 上午9:22:04]
 * @UpdateUser: [Administrator(如多次修改保留历史记录，增加修改记录)]
 * @UpdateDate: [2015-5-27 上午9:22:04，(如多次修改保留历史记录，增加修改记录)]
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]
 * @Version: [v1.0]
 */
@Aspect
public class SydwModelInterceptor {
	private Logger logger = Logger.getLogger(this.getClass());
	@Resource(name = "syrkSyrkxxzbDao")
	private SyrkSyrkxxzbDao syrkSyrkxxzbDao;
	@Resource(name = "dzService")
	private DzService dzService;
	@Resource(name = "xtFactory")
	private XtFactory xtFactory;
	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;
	@Resource
	private YwxtsfqypzService ywxtsfqypzService;

	
	private static String YWXTLX_CYRYSYRKXT="05";
	/***
	 * 
	 * @Title: srykPoint
	 * @Description: TODO(实有人口dao包下面的任意方法调用，进入切面)
	 * @param 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	@Pointcut("execution(* com.founder.sydw_dl.dao.*.*(..))")
	public void srdwPoint() {
	}

	/***
	 * 
	 * @Title: afterPoint
	 * @Description: TODO(方法成功执行以后，数据发生变化。这里判断5类人和基本信息的变动出发实有人口协同任务)
	 *               如果有新的人口协同任务请在这里添加
	 * @param @param jp 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	@AfterReturning(value = "srdwPoint()")
	public void afterPoint(JoinPoint jp) {
		Object[] args = jp.getArgs();// 取得方法调用所有的参数
		String methodName = jp.getSignature().getName();// 取得切面的方法名称、
		// 根据参数和方法名称判断是否出发主数据对比业务
		// 规则：如果参数属于SyrkSyrkxxzb、SyrkCzrkxxb、SyrkJwryxxb、SyrkJzrkxxb、SyrkLdrkxxb、SyrkWlhryxxb
		// 并且方法名不包含query关键字
		if (methodName.indexOf("query") == -1) {
			try {
				for (int i = 0; i < args.length; i++) {
					if (args[i] instanceof Cyryxxb) {
					  
							// 从业人员人口协同
							cyrySyrkXt(args[i]);
					   
					
					}
				}
			} catch (SecurityException e) {
				logger.error(e.getMessage());
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				logger.error(e.getMessage());
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				logger.error(e.getMessage());
				e.printStackTrace();
			} catch (IntrospectionException e) {
				logger.error(e.getMessage());
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				logger.error(e.getMessage());
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				logger.error(e.getMessage());
				e.printStackTrace();
			}
		}
	}

	/**
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws IntrospectionException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 *             *
	 * 
	 * @Title: rhflXt
	 * @Description: TODO(分户分离协同，根据证件号码和证件类型，查询非本责任区情况)
	 * @param @param C 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	private void cyrySyrkXt(Object obj) throws SecurityException,
			NoSuchMethodException, IntrospectionException,
			IllegalArgumentException, IllegalAccessException,
			InvocationTargetException {
		 Ywxtsfqypzb pz =ywxtsfqypzService.queryByYwxtlx(YWXTLX_CYRYSYRKXT);
		   if(pz!=null &&pz.getSfqy().equals("0")){
			   return;
		   }
		
		Class refClass = obj.getClass();
		// 这里bean内key值必须通用类型，由于没有抽象父类
		PropertyDescriptor dzXzzdmP = new PropertyDescriptor("dz_xzzdmlpdm", refClass);
		PropertyDescriptor ryidP = new PropertyDescriptor("ryid", refClass);
		// 取得证件号码和证件种类
		Method dzXzzdmMethod = dzXzzdmP.getReadMethod();
		Method ryidMethod = ryidP.getReadMethod();
		String dz_xzzdm = (String) dzXzzdmMethod.invoke(obj);
		String ryid = (String) ryidMethod.invoke(obj);
		String zxzt =(String)new PropertyDescriptor("xt_zxbz", obj.getClass()).getReadMethod().invoke(obj);
		// 数据库查询
		boolean isExistRyDz = syrkSyrkxxzbDao.isExistRyDz(ryid, dz_xzzdm);
		// 查询结果， 如果该地址没有人则发送协同消息
		if (!isExistRyDz&&"0".equals(zxzt)) {
				BzdzxxbVO vo = dzService.queryMldzDx(dz_xzzdm);
				if(vo!=null){
					xtByBzdz(obj, vo.getPcsdm(),vo.getZrqdm(),vo.getDzmc(), xtFactory.CYRYSYRK);
				}
		
		}
	}
	
	/**
	 * @throws IntrospectionException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException *
	 * 
	 * @Title: xtByWlhry
	 * @Description: TODO(未落户协同参数拼接，这5类方法，由于人口模型抽象不具体，比如3类人有zjhm字段，2类人有gmsfzhm字段)
	 * @param @param obj
	 * @param @param syrkCzrkxxb
	 * @param @param xtType    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	private void xtByBzdz(Object obj ,String pcsdm,String zrqdm,String dzxz, String xtType ) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, IntrospectionException{
		//传递协同信息
		Map<String,Object> paramMap = new HashMap<String,Object>();
		List<Ywxtcyryxxb> listCyr=new ArrayList<Ywxtcyryxxb>();
		//建立json数据对象，由于数据不多，暂时用map代替，如果以后数据项增多可以用虚拟BEAN替换
		Map<String,String> fqMap=new HashMap<String,String>();
		fqMap.put("dzxz", dzxz);
		try{
			fqMap.put("zjhm", (String)new PropertyDescriptor("zjhm", obj.getClass()).getReadMethod().invoke(obj));
		}
		catch(IntrospectionException e){
			fqMap.put("zjhm", (String)new PropertyDescriptor("gmsfhm", obj.getClass()).getReadMethod().invoke(obj));
		}
		fqMap.put("id", (String)new PropertyDescriptor("id", obj.getClass()).getReadMethod().invoke(obj));
		fqMap.put("xm",  (String)new PropertyDescriptor("xm", obj.getClass()).getReadMethod().invoke(obj));
		if(StringUtils.isBlank(fqMap.get("xm"))){
			fqMap.put("xm", (String)new PropertyDescriptor("wwm", obj.getClass()).getReadMethod().invoke(obj));
		}
		Ywxtcyryxxb ywxtcyryxxb=new Ywxtcyryxxb();
		ywxtcyryxxb.setCyrid((String)new PropertyDescriptor("xt_lrrid", obj.getClass()).getReadMethod().invoke(obj));
		ywxtcyryxxb.setCyrxm((String)new PropertyDescriptor("xt_lrrxm", obj.getClass()).getReadMethod().invoke(obj));
		String sszrq =(String)new PropertyDescriptor("xt_zhxgrbmid", obj.getClass()).getReadMethod().invoke(obj);
		ywxtcyryxxb.setSspcs(orgOrganizationService.queryParentOrgByOrgcode(sszrq).getOrgcode());
		ywxtcyryxxb.setSszrq(sszrq);
		ywxtcyryxxb.setXtdz("发起");
		ywxtcyryxxb.setXtjg(AbstractXtTask.RIGHT);
		ywxtcyryxxb.setXt_cjsj(DateUtils.getSystemDateTimeString());
		ywxtcyryxxb.setXt_zhxgsj(DateUtils.getSystemDateTimeString());
		listCyr.add(ywxtcyryxxb);
		Map<String,String> jsMap=new HashMap<String,String>();
		ywxtcyryxxb=new Ywxtcyryxxb();
		ywxtcyryxxb.setSspcs(pcsdm);
		ywxtcyryxxb.setSszrq(zrqdm);
		ywxtcyryxxb.setXtdz("接收");
		ywxtcyryxxb.setXtjg(AbstractXtTask.ERROR);
		ywxtcyryxxb.setXt_cjsj(DateUtils.getSystemDateTimeString());
		ywxtcyryxxb.setXt_zhxgsj(DateUtils.getSystemDateTimeString());
		listCyr.add(ywxtcyryxxb);
		paramMap.put("users", listCyr);
		//这里拼接JSONMap用于生产JSON
		Map<String,Object> jsonMap=new HashMap<String,Object>();
		jsonMap.put("fq", fqMap);
		jsonMap.put("js", jsMap);
		paramMap.put("json", jsonMap);
		XtTaskService  XtTaskService =	xtFactory.factory(xtType);
		XtTaskService.createTask(paramMap);
	}
	

}
