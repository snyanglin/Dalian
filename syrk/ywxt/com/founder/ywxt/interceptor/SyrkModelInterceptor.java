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
import com.founder.sydw_dl.bean.Dwjbxxb;
import com.founder.sydw_dl.dao.CyryxxbDao;
import com.founder.sydw_dl.dao.DwjbxxbDao;
import com.founder.syrkgl.bean.SyrkCzrkxxb;
import com.founder.syrkgl.bean.SyrkJwryxxb;
import com.founder.syrkgl.bean.SyrkJzrkxxb;
import com.founder.syrkgl.bean.SyrkLdrkxxb;
import com.founder.syrkgl.bean.SyrkSyrkxxzb;
import com.founder.syrkgl.bean.SyrkWlhryxxb;
import com.founder.syrkgl.dao.SyrkCzrkxxbDao;
import com.founder.syrkgl.dao.SyrkJwryxxbDao;
import com.founder.syrkgl.dao.SyrkJzrkxxbDao;
import com.founder.syrkgl.dao.SyrkLdrkxxbDao;
import com.founder.syrkgl.dao.SyrkSyrkxxzbDao;
import com.founder.syrkgl.dao.SyrkWlhryxxbDao;
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
public class SyrkModelInterceptor {
	private Logger logger = Logger.getLogger(this.getClass());
	@Resource(name = "syrkCzrkxxbDao")
	private SyrkCzrkxxbDao syrkCzrkxxbDao;
	@Resource(name = "syrkJwryxxbDao")
	private SyrkJwryxxbDao syrkJwryxxbDao;
	@Resource(name = "syrkJzrkxxbDao")
	private SyrkJzrkxxbDao syrkJzrkxxbDao;
	@Resource(name = "syrkLdrkxxbDao")
	private SyrkLdrkxxbDao syrkLdrkxxbDao;
	@Resource(name = "syrkWlhryxxbDao")
	private SyrkWlhryxxbDao syrkWlhryxxbDao;
	@Resource(name = "syrkSyrkxxzbDao")
	private SyrkSyrkxxzbDao syrkSyrkxxzbDao;
	@Resource(name = "cyryxxbDao")
	private CyryxxbDao cyryxxbDao;
	@Resource(name = "orgOrganizationService")
	private OrgOrganizationService orgOrganizationService;
	@Resource(name = "dzService")
	private DzService dzService;
	@Resource(name = "xtFactory")
	private XtFactory xtFactory;
	@Resource(name = "dwjbxxbDao")
	private DwjbxxbDao dwjbxxbDao;
	
	@Resource
	private YwxtsfqypzService ywxtsfqypzService;

	//人户分离协同类型
	private static String YWXTLX_RHFLXT="01";
	//实有人口注销协同
	private static String YWXTLX_SYRKZXXT="02";
	//工作单位协同
	private static String YWXTLX_RYGZDWXT="03";
	//联系电话协同
	private static String YWXTLX_RYLXDHXT="04";

	/***

	/***
	 * 
	 * @Title: srykPoint
	 * @Description: TODO(实有人口dao包下面的任意方法调用，进入切面)
	 * @param 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	@Pointcut("execution(* com.founder.syrkgl.dao.*.*(..))")
	public void srykPoint() {
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
	@AfterReturning(value = "srykPoint()")
	public void afterPoint(JoinPoint jp) {
		Object[] args = jp.getArgs();// 取得方法调用所有的参数
		String methodName = jp.getSignature().getName();// 取得切面的方法名称、
		// 根据参数和方法名称判断是否出发主数据对比业务
		// 规则：如果参数属于SyrkSyrkxxzb、SyrkCzrkxxb、SyrkJwryxxb、SyrkJzrkxxb、SyrkLdrkxxb、SyrkWlhryxxb
		// 并且方法名不包含query关键字
		if (methodName.indexOf("query") == -1) {
			try {
				for (int i = 0; i < args.length; i++) {
					if (args[i] instanceof SyrkSyrkxxzb) {
					
						// 人户一至协同
						rhflXt(args[i]);

					}
					if (args[i] instanceof SyrkCzrkxxb) {
						Object obj= syrkCzrkxxbDao.queryByIdWithOutZxbz((String)new PropertyDescriptor("id", args[i].getClass()).getReadMethod().invoke(args[i]));
						// 判断实有人口注销
						syrkzxXt(obj);
						//人员联系电话
						rylxdhXt(obj, "gmsfhm");
						// 判断人员工作单位
						rygzdwXt(obj, "gmsfhm");
					}
					if ((args[i] instanceof SyrkJwryxxb)) {
						Object obj= syrkJwryxxbDao.queryByIdWithOutZxbz((String)new PropertyDescriptor("id", args[i].getClass()).getReadMethod().invoke(args[i]));
						// 判断实有人口注销
						syrkzxXt(obj);
						//人员联系电话
						rylxdhXt(obj, "zjhm");
						// 判断人员工作单位
						rygzdwXt(obj, "zjhm");
					}
					if (args[i] instanceof SyrkJzrkxxb) {
						Object obj= syrkJzrkxxbDao.queryByIdWithOutZxbz((String)new PropertyDescriptor("id", args[i].getClass()).getReadMethod().invoke(args[i]));
						// 判断实有人口注销
						syrkzxXt(obj);
						//人员联系电话
						rylxdhXt(obj, "gmsfhm");
						// 判断人员工作单位
						rygzdwXt(obj, "gmsfhm");
					}
					if (args[i] instanceof SyrkLdrkxxb) {
						Object obj= syrkLdrkxxbDao.queryByIdWithOutZxbz((String)new PropertyDescriptor("id", args[i].getClass()).getReadMethod().invoke(args[i]));
						// 判断实有人口注销
						syrkzxXt(obj);
						//人员联系电话
						rylxdhXt(obj, "zjhm");
						// 判断人员工作单位
						rygzdwXt(obj, "zjhm");
					}
					if (args[i] instanceof SyrkWlhryxxb) {
						Object obj= syrkWlhryxxbDao.queryByIdWithOutZxbz((String)new PropertyDescriptor("id", args[i].getClass()).getReadMethod().invoke(args[i]));
						//人员联系电话
						rylxdhXt(obj, "zjhm");
						// 判断人员工作单位
						rygzdwXt(obj, "zjhm");
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
	private void rhflXt(Object obj) throws SecurityException,
			NoSuchMethodException, IntrospectionException,
			IllegalArgumentException, IllegalAccessException,
			InvocationTargetException {
		 Ywxtsfqypzb pz =ywxtsfqypzService.queryByYwxtlx(YWXTLX_RHFLXT);
		   if(pz!=null &&pz.getSfqy().equals("0")){
			   return;
		   }
		
		Class refClass = obj.getClass();
		// 这里bean内key值必须通用类型，由于没有抽象父类
		PropertyDescriptor cyzjdmP = new PropertyDescriptor("cyzjdm", refClass);
		PropertyDescriptor zjhmP = new PropertyDescriptor("zjhm", refClass);
		PropertyDescriptor syrkzbIdP = new PropertyDescriptor("id", refClass);
		// 取得证件号码和证件种类
		Method cyzjdmMethod = cyzjdmP.getReadMethod();
		Method zjhmMethod = zjhmP.getReadMethod();
		Method syrkzbIdMethod = syrkzbIdP.getReadMethod();
		String id = (String) syrkzbIdMethod.invoke( obj);
		String cyzjdm = (String) cyzjdmMethod.invoke(obj);
		String zjhm = (String) zjhmMethod.invoke( obj);
		// 根据证件信息，到数据库查询
		Map<String, String> queryMap = new HashMap<String, String>();
		queryMap.put("cyzjdm", cyzjdm);
		queryMap.put("zjhm", zjhm);
		if(StringUtils.isBlank(zjhm)){
			queryMap.put("zjhm", "");
		}
		SyrkCzrkxxb syrkCzrkxxb= new SyrkCzrkxxb();
		if(!StringUtils.isBlank(zjhm)){
		 syrkCzrkxxb = syrkCzrkxxbDao
				.queryCzrkByZjhmAndZjdm(queryMap);
		}
		// 查询结果，如果人户一至调用协同
		if (syrkCzrkxxb!=null&&"1".equals(syrkCzrkxxb.getSfrhyzdm())&&!id.equals(syrkCzrkxxb.getId())) {
			xtByCzrk(obj, syrkCzrkxxb, xtFactory.RHFL);
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
	 * @Description: TODO(实有人口注销协同，若实有人口注销时去往地址为本地标准地址，则向去往地址发送协同)
	 * @param @param C 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	private void syrkzxXt(Object obj) throws SecurityException,
			NoSuchMethodException, IntrospectionException,
			IllegalArgumentException, IllegalAccessException,
			InvocationTargetException {
		 Ywxtsfqypzb pz =ywxtsfqypzService.queryByYwxtlx(YWXTLX_SYRKZXXT);
		   if(pz!=null &&pz.getSfqy().equals("0")){
			   return;
		   }
		Class refClass = obj.getClass();
		// 这里bean内key值必须通用类型，由于没有抽象父类
		PropertyDescriptor xtZxbzP = new PropertyDescriptor("xt_zxbz", refClass);
		PropertyDescriptor qwdzidP = new PropertyDescriptor("qwd_dzid",refClass);
		PropertyDescriptor ryidP = new PropertyDescriptor("ryid",refClass);
		// 取得注销标志和去往地址代码
		Method xtZxbzMethod = xtZxbzP.getReadMethod();
		Method qwdzidMethod = qwdzidP.getReadMethod();
		Method  ryidMethod = ryidP.getReadMethod();
		String ryid = (String) ryidMethod.invoke(obj);
		String xtZxbz = (String) xtZxbzMethod.invoke(obj);
		String qwdzid = (String) qwdzidMethod.invoke(obj);
		// 查询结果，如果注销并且去往地址不为null出发协同,并且去向地址没有此人
		if ("1".equals(xtZxbz) && !StringUtils.isBlank(qwdzid)) {
			if(!syrkSyrkxxzbDao.isExistRyDz(ryid, qwdzid)){
				BzdzxxbVO vo = dzService.queryMldzDx((String)new PropertyDescriptor("qwd_mlpdm", obj.getClass()).getReadMethod().invoke(obj));
				if(vo!=null){
					xtByBzdz(obj, vo.getPcsdm(),vo.getZrqdm(),vo.getDzmc(), xtFactory.RKZX);
				}
			}
		}
	}

	/**
	 * @throws IntrospectionException 
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws IntrospectionException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 *             *
	 * @Title: rhflXt
	 * @Description: TODO(人员填写工作单位，但是工作单位没有添加从业人员，发送协同)
	 * @param @param C 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	private void rygzdwXt(Object obj,String zdmc) throws SecurityException,
			NoSuchMethodException, IllegalArgumentException,
			IllegalAccessException, InvocationTargetException, IntrospectionException {
		 Ywxtsfqypzb pz =ywxtsfqypzService.queryByYwxtlx(YWXTLX_RYGZDWXT);
		   if(pz!=null &&pz.getSfqy().equals("0")){
			   return;
		   }
		Class refClass = obj.getClass();
		// 这里bean内key值必须通用类型，由于没有抽象父类
		PropertyDescriptor gzdwidP;
		try {
			gzdwidP = new PropertyDescriptor("gzdwid", refClass);
		} catch (IntrospectionException e) {// 这里兼容境外人员单位KEY不一样问题
			gzdwidP = new PropertyDescriptor("gzdw_dwid", refClass);
		}
		String cyzjdm ="111";
		PropertyDescriptor zjhmP = new PropertyDescriptor(zdmc, refClass);
		if("zjhm".equals(zdmc)){
			cyzjdm=(String)new PropertyDescriptor("cyzjdm", obj.getClass()).getReadMethod().invoke(obj);
		}
		// 取得证件号码和证件种类
		Method zjhmMethod = zjhmP.getReadMethod();
		String zjhm = (String) zjhmMethod.invoke(obj);
		
		// 取得工作单位
		Method gzdwidMethod = gzdwidP.getReadMethod();
		String gzdwid = (String) gzdwidMethod.invoke(obj);
		//查询单位从业人员是否包含此人
		Cyryxxb cyryxxb=null;
		if (!StringUtils.isBlank(gzdwid)) {
			cyryxxb= new Cyryxxb();
			cyryxxb.setDwid(gzdwid);
			cyryxxb.setCyzjdm(cyzjdm);
			cyryxxb.setZjhm(zjhm);
			cyryxxb=cyryxxbDao.queryByZjlx(cyryxxb);
		}
		if(cyryxxb==null){
			//这里根据dwid取得管辖责任区，发送协同任务
			Dwjbxxb dwjbxxb = dwjbxxbDao.queryDwjbxxbById(gzdwid);
			if(dwjbxxb!=null){
				xtByBzdz(obj, dwjbxxb.getGlpcsid(),dwjbxxb.getGlbmid(),dwjbxxb.getDz_dwdzxz(), xtFactory.RYGZDW);
			}
			
		}
		
	}
	
	/**
	 * @throws IntrospectionException 
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws IntrospectionException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 *             *
	 * @Title: rylxdhXt
	 * @Description: TODO(人员联系电话与其他人员联系电话重复，发送协同)
	 * @param @param C 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	private void rylxdhXt(Object obj,String zdmc) throws SecurityException,
			NoSuchMethodException, IllegalArgumentException,
			IllegalAccessException, InvocationTargetException, IntrospectionException {
		 Ywxtsfqypzb pz =ywxtsfqypzService.queryByYwxtlx(YWXTLX_RYLXDHXT);
		   if(pz!=null &&pz.getSfqy().equals("0")){
			   return;
		   }
		Class refClass = obj.getClass();
		// 这里bean内key值必须通用类型，由于没有抽象父类
		PropertyDescriptor zjhmP = new PropertyDescriptor(zdmc, refClass);
		PropertyDescriptor lxdhP = new PropertyDescriptor("lxdh", refClass);
		// 取得证件号码和证件种类
		Method zjhmMethod = zjhmP.getReadMethod();
		String zjhm = (String) zjhmMethod.invoke(obj);
		String ryid =(String)new PropertyDescriptor("ryid", obj.getClass()).getReadMethod().invoke(obj);
		// 取得工作单位
		Method lxdhMethod = lxdhP.getReadMethod();
		String lxdh = (String) lxdhMethod.invoke(obj);
		//查询5大人口对象联系方式为这个电话并且证件号码不相同的数据
		List<SyrkCzrkxxb> czrkList =syrkCzrkxxbDao.queryRyByLxdh(lxdh,ryid);
		List<SyrkJwryxxb> JwryList =syrkJwryxxbDao.queryRyByLxdh(lxdh,ryid);
		List<SyrkJzrkxxb> JzrkList =syrkJzrkxxbDao.queryRyByLxdh(lxdh,ryid);
		List<SyrkLdrkxxb> LdrkList =syrkLdrkxxbDao.queryRyByLxdh(lxdh,ryid);
		List<SyrkWlhryxxb> WlhryList =syrkWlhryxxbDao.queryRyByLxdh(lxdh,ryid);
		//这里判断重复的，由于5类人内身份证字段有2个为gmsfzhm有3个为zjhm无法统一，只有单位做判断，这里逻辑重复度
		for (int i = 0; i < czrkList.size(); i++) {
			SyrkCzrkxxb syrkCzrkxxb =czrkList.get(i);
			if(!zjhm.equals(syrkCzrkxxb.getGmsfhm())){
				xtByCzrk(obj, syrkCzrkxxb, xtFactory.RYLXDH);
			}
		}
		for (int i = 0; i < JwryList.size(); i++) {
			SyrkJwryxxb syrkJwryxxb =JwryList.get(i);
			if(!zjhm.equals(syrkJwryxxb.getZjhm())){
				xtByJwry(obj, syrkJwryxxb, xtFactory.RYLXDH);
			}
		}
		for (int i = 0; i < JzrkList.size(); i++) {
			SyrkJzrkxxb syrkJzrkxxb =JzrkList.get(i);
			if(!zjhm.equals(syrkJzrkxxb.getGmsfhm())){
				xtByJzrk(obj, syrkJzrkxxb, xtFactory.RYLXDH);
			}
		}
		for (int i = 0; i < LdrkList.size(); i++) {
			SyrkLdrkxxb syrkLdrkxxb =LdrkList.get(i);
			if(!zjhm.equals(syrkLdrkxxb.getZjhm())){
				xtByLdrk(obj, syrkLdrkxxb, xtFactory.RYLXDH);
			}
		}
		for (int i = 0; i < WlhryList.size(); i++) {
			SyrkWlhryxxb syrkWlhryxxb =WlhryList.get(i);
			if(!zjhm.equals(syrkWlhryxxb.getZjhm())){
				xtByWlhry(obj, syrkWlhryxxb, xtFactory.RYLXDH);
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
		//这里适应境外人员,
		try{
			fqMap.put("gzdw",  (String)new PropertyDescriptor("gzdw", obj.getClass()).getReadMethod().invoke(obj));
			fqMap.put("gzdwid",  (String)new PropertyDescriptor("gzdwid", obj.getClass()).getReadMethod().invoke(obj));
		}
		catch(IntrospectionException e){
			fqMap.put("gzdw",  (String)new PropertyDescriptor("gzdw_dwmc", obj.getClass()).getReadMethod().invoke(obj));
			fqMap.put("gzdwid",  (String)new PropertyDescriptor("gzdw_dwid", obj.getClass()).getReadMethod().invoke(obj));
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
	private void xtByWlhry(Object obj ,SyrkWlhryxxb syrkWlhryxxb, String xtType ) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, IntrospectionException{
		//传递协同信息
		Map<String,Object> paramMap = new HashMap<String,Object>();
		List<Ywxtcyryxxb> listCyr=new ArrayList<Ywxtcyryxxb>();
		//建立json数据对象，由于数据不多，暂时用map代替，如果以后数据项增多可以用虚拟BEAN替换
		Map<String,String> fqMap=new HashMap<String,String>();
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
		fqMap.put("lxdh", syrkWlhryxxb.getLxdh());
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
		jsMap.put("zjhm", syrkWlhryxxb.getZjhm());
		jsMap.put("cyzjdm", syrkWlhryxxb.getCyzjdm());
		jsMap.put("id", syrkWlhryxxb.getId());
		jsMap.put("xm", syrkWlhryxxb.getXm());
		jsMap.put("ryid", syrkWlhryxxb.getRyid());
		ywxtcyryxxb=new Ywxtcyryxxb();
		ywxtcyryxxb.setCyrid(syrkWlhryxxb.getXt_zhxgrid());
		ywxtcyryxxb.setCyrxm(syrkWlhryxxb.getXt_zhxgrxm());
		ywxtcyryxxb.setSspcs(orgOrganizationService.queryParentOrgByOrgcode(syrkWlhryxxb.getXt_zhxgrbmid()).getOrgcode());
		ywxtcyryxxb.setSszrq(syrkWlhryxxb.getXt_zhxgrbmid());
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
	
	
	
	/**
	 * @throws IntrospectionException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException *
	 * 
	 * @Title: xtByLdrk
	 * @Description: TODO(流动人员协同参数拼接，这5类方法，由于人口模型抽象不具体，比如3类人有zjhm字段，2类人有gmsfzhm字段)
	 * @param @param obj
	 * @param @param syrkCzrkxxb
	 * @param @param xtType    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	private void xtByLdrk(Object obj ,SyrkLdrkxxb syrkLdrkxxb, String xtType ) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, IntrospectionException{
		//传递协同信息
		Map<String,Object> paramMap = new HashMap<String,Object>();
		List<Ywxtcyryxxb> listCyr=new ArrayList<Ywxtcyryxxb>();
		//建立json数据对象，由于数据不多，暂时用map代替，如果以后数据项增多可以用虚拟BEAN替换
		Map<String,String> fqMap=new HashMap<String,String>();
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
		fqMap.put("lxdh", syrkLdrkxxb.getLxdh());
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
		jsMap.put("zjhm", syrkLdrkxxb.getZjhm());
		jsMap.put("cyzjdm", syrkLdrkxxb.getCyzjdm());
		jsMap.put("id", syrkLdrkxxb.getId());
		jsMap.put("xm", syrkLdrkxxb.getXm());
		jsMap.put("ryid", syrkLdrkxxb.getRyid());
		ywxtcyryxxb=new Ywxtcyryxxb();
		ywxtcyryxxb.setCyrid(syrkLdrkxxb.getXt_zhxgrid());
		ywxtcyryxxb.setCyrxm(syrkLdrkxxb.getXt_zhxgrxm());
		ywxtcyryxxb.setSspcs(orgOrganizationService.queryParentOrgByOrgcode(syrkLdrkxxb.getXt_zhxgrbmid()).getOrgcode());
		ywxtcyryxxb.setSszrq(syrkLdrkxxb.getXt_zhxgrbmid());
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
	
	
	
	
	
	/**
	 * @throws IntrospectionException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException *
	 * 
	 * @Title: xtByJzrk
	 * @Description: TODO(寄住人员协同参数拼接，这5类方法，由于人口模型抽象不具体，比如3类人有zjhm字段，2类人有gmsfzhm字段)
	 * @param @param obj
	 * @param @param syrkCzrkxxb
	 * @param @param xtType    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	private void xtByJzrk(Object obj ,SyrkJzrkxxb syrkjzrkxxb, String xtType ) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, IntrospectionException{
		//传递协同信息
		Map<String,Object> paramMap = new HashMap<String,Object>();
		List<Ywxtcyryxxb> listCyr=new ArrayList<Ywxtcyryxxb>();
		//建立json数据对象，由于数据不多，暂时用map代替，如果以后数据项增多可以用虚拟BEAN替换
		Map<String,String> fqMap=new HashMap<String,String>();
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
		fqMap.put("lxdh", syrkjzrkxxb.getLxdh());
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
		jsMap.put("zjhm", syrkjzrkxxb.getGmsfhm());
		jsMap.put("cyzjdm", "111");
		jsMap.put("id", syrkjzrkxxb.getId());
		jsMap.put("xm", syrkjzrkxxb.getXm());
		jsMap.put("ryid", syrkjzrkxxb.getRyid());
		ywxtcyryxxb=new Ywxtcyryxxb();
		ywxtcyryxxb.setCyrid(syrkjzrkxxb.getXt_zhxgrid());
		ywxtcyryxxb.setCyrxm(syrkjzrkxxb.getXt_zhxgrxm());
		ywxtcyryxxb.setSspcs(orgOrganizationService.queryParentOrgByOrgcode(syrkjzrkxxb.getXt_zhxgrbmid()).getOrgcode());
		ywxtcyryxxb.setSszrq(syrkjzrkxxb.getXt_zhxgrbmid());
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
	
	
	
	
	/**
	 * @throws IntrospectionException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException *
	 * 
	 * @Title: xtByJwry
	 * @Description: TODO(境外人员协同参数拼接，这5类方法，由于人口模型抽象不具体，比如3类人有zjhm字段，2类人有gmsfzhm字段)
	 * @param @param obj
	 * @param @param syrkCzrkxxb
	 * @param @param xtType    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	private void xtByJwry(Object obj ,SyrkJwryxxb syrkJwryxxb, String xtType ) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, IntrospectionException{
		//传递协同信息
		Map<String,Object> paramMap = new HashMap<String,Object>();
		List<Ywxtcyryxxb> listCyr=new ArrayList<Ywxtcyryxxb>();
		//建立json数据对象，由于数据不多，暂时用map代替，如果以后数据项增多可以用虚拟BEAN替换
		Map<String,String> fqMap=new HashMap<String,String>();
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
		fqMap.put("lxdh", syrkJwryxxb.getLxdh());
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
		jsMap.put("zjhm", syrkJwryxxb.getZjhm());
		jsMap.put("cyzjdm", syrkJwryxxb.getCyzjdm());
		jsMap.put("id", syrkJwryxxb.getId());
		jsMap.put("xm", syrkJwryxxb.getXm());
		jsMap.put("ryid", syrkJwryxxb.getRyid());
		if(StringUtils.isBlank(jsMap.get("xm"))){
			jsMap.put("xm", syrkJwryxxb.getWwm());
		}
		jsMap.put("rylx", "syrkJwryxxb");
		ywxtcyryxxb=new Ywxtcyryxxb();
		ywxtcyryxxb.setCyrid(syrkJwryxxb.getXt_zhxgrid());
		ywxtcyryxxb.setCyrxm(syrkJwryxxb.getXt_zhxgrxm());
		ywxtcyryxxb.setSspcs(orgOrganizationService.queryParentOrgByOrgcode(syrkJwryxxb.getXt_zhxgrbmid()).getOrgcode());
		ywxtcyryxxb.setSszrq(syrkJwryxxb.getXt_zhxgrbmid());
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
	
	
	/**
	 * @throws IntrospectionException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException *
	 * 
	 * @Title: xtByCzrk
	 * @Description: TODO(常住人口协同参数拼接，这5类方法，由于人口模型抽象不具体，比如3类人有zjhm字段，2类人有gmsfzhm字段)
	 * @param @param obj
	 * @param @param syrkCzrkxxb
	 * @param @param xtType    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	private void xtByCzrk(Object obj ,SyrkCzrkxxb syrkCzrkxxb, String xtType ) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, IntrospectionException{
		//传递协同信息
		Map<String,Object> paramMap = new HashMap<String,Object>();
		List<Ywxtcyryxxb> listCyr=new ArrayList<Ywxtcyryxxb>();
		//建立json数据对象，由于数据不多，暂时用map代替，如果以后数据项增多可以用虚拟BEAN替换
		Map<String,String> fqMap=new HashMap<String,String>();
		try{
			fqMap.put("zjhm", (String)new PropertyDescriptor("zjhm", obj.getClass()).getReadMethod().invoke(obj));
		}
		catch(IntrospectionException e){
			fqMap.put("zjhm", (String)new PropertyDescriptor("gmsfhm", obj.getClass()).getReadMethod().invoke(obj));
		}
		fqMap.put("id", (String)new PropertyDescriptor("id", obj.getClass()).getReadMethod().invoke(obj));
		fqMap.put("xm",  (String)new PropertyDescriptor("xm", obj.getClass()).getReadMethod().invoke(obj));
		fqMap.put("lxdh", syrkCzrkxxb.getLxdh());
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
		jsMap.put("zjhm", syrkCzrkxxb.getGmsfhm());
		jsMap.put("cyzjdm", "111");//15年6月1号张悦说常口肯定是身份证，这里只作为json数据储存，常口表没有证件类型字段
		jsMap.put("id", syrkCzrkxxb.getId());
		jsMap.put("xm", syrkCzrkxxb.getXm());
		jsMap.put("ryid", syrkCzrkxxb.getRyid());
		ywxtcyryxxb=new Ywxtcyryxxb();
		ywxtcyryxxb.setCyrid(syrkCzrkxxb.getXt_zhxgrid());
		ywxtcyryxxb.setCyrxm(syrkCzrkxxb.getXt_zhxgrxm());
		ywxtcyryxxb.setSspcs(orgOrganizationService.queryParentOrgByOrgcode(syrkCzrkxxb.getXt_zhxgrbmid()).getOrgcode());
		ywxtcyryxxb.setSszrq(syrkCzrkxxb.getXt_zhxgrbmid());
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
