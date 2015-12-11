package com.founder.zdrygl.core.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.founder.framework.exception.BussinessException;
import com.founder.zdrygl.core.inteface.ZdryService;
import com.founder.zdrygl.core.model.Zdry;
import com.founder.zdrygl.core.utils.SpringContextHolder;
import com.founder.zdrygl.core.utils.ZdryConstant;

/**
 * ****************************************************************************
 * @Package:      [com.founder.zdrygl.base.service.ZdryFactory.java]  
 * @ClassName:    [ZdryFactory]   
 * @Description:  [重点人员业务服务工厂]   
 * @Author:       [wei.wen@founder.com.cn]  
 * @CreateDate:   [2015年9月9日 上午10:07:15]   
 * @UpdateUser:   [wei.wen@founder.com.cn(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年9月9日 上午10:07:15，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Component
public class ZdryFactory implements ZdryAbstractFactory {

	@Autowired
	private ZdryConstant  zdryConstant;

	private static String ZDRYZB = "";
	private static ConfigurableApplicationContext applicationContext ;  
	private static DefaultListableBeanFactory beanFactory ;  

	@Override
	public ZdryService createZdryService(String zdrylx) {
		// TODO Auto-generated method stub
		return createZdryService(zdrylx,null,null);
	}
	
	@Override
	public ZdryService createZdryService(String zdrylx, Zdry zdryzb, Zdry zdrylbdx) {
		applicationContext = getConfigurableApplicationContext();
		beanFactory = getBeanFactory();  

		ZdryService zdryzbService = createZdryzbService(getBeanName(getZdryzbDm()));
//		zdryzbService.setZdry(zdryzb);
		String className = zdryConstant.zdryServiceMap().get(zdrylx);
		if(!StringUtils.isEmpty(className)){
			String beanName = getBeanName(className) ;  
			registerBeanDefinition(beanName,className,zdryzbService); 
			ZdryService zdryService= (ZdryService) getBean(beanName);
			return zdryService;  
		}else if(zdrylbdx==null){//撤管的时候，以及列管“其他关注对象”等没有子表的重点人员类型时，就获取不到子表对应的服务类
			return zdryzbService;
		}else{
			throw new BussinessException("重点人员类型匹配错误!");
		}
	}
	
	private ZdryService createZdryzbService(String beanName){
		registerBeanDefinition(beanName,getZdryzbDm(),null); 
		return (ZdryService)  getBean(beanName);
	}
	
	private Object getBean(String beanName){
		return beanFactory.getBean(beanName); 
	}

	/**
	 * 
	 * @Title: registerBeanDefinition
	 * @Description: (注册重点人员类别BEAN)
	 * @param @param beanName 注册springBean 名称
	 * @param @param className 注册全路径类名
	 * @param @param constructorArgValue 构造方法对象注册
	 * @param @param zdry   注册重点人员成员变量 
	 * @return void    返回类型
	 * @throws
	 */
	private void registerBeanDefinition(String beanName,String className,Object constructorArgValue){
		if (!beanFactory.containsBean(beanName) ) {  
			BeanDefinitionBuilder bdb = BeanDefinitionBuilder.rootBeanDefinition(className);  
//			bdb.setScope("prototype"); 
			if(constructorArgValue != null)
				bdb.addConstructorArgValue(constructorArgValue);
//			if(zdry != null)
//				bdb.addPropertyValue("zdry", zdry);
			beanFactory.registerBeanDefinition(beanName,bdb.getBeanDefinition());  
		}  
	}

	private String getBeanName(String className){
		return firstLetterLower(className.substring(className.lastIndexOf(".")+1));
	}

	private String firstLetterLower(String str){
		char[] chars = new char[1];  
		chars[0] = str.charAt(0);  
		String temp = new String(chars);  
		if(chars[0]>='A'  &&  chars[0]<='Z')  
			return str.replaceFirst(temp,temp.toLowerCase());
		return str;
	}
	
	private ConfigurableApplicationContext getConfigurableApplicationContext(){
		if(applicationContext == null) 
			applicationContext = (ConfigurableApplicationContext) SpringContextHolder.getApplicationContext();  	
		return applicationContext;	
	}
	
	private DefaultListableBeanFactory getBeanFactory(){
		if(beanFactory == null) 
			beanFactory = (DefaultListableBeanFactory) applicationContext.getBeanFactory();   	
		return beanFactory;	
	}
	
	private String getZdryzbDm(){
		return StringUtils.isEmpty(ZDRYZB)?zdryConstant.zdryServiceMap().get("00"):ZDRYZB;
	}

}
