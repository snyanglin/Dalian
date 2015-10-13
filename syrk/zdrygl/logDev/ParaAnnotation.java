package logDev;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ****************************************************************************
 * @Package:      [logDev.ParaAnnotation.java]  
 * @ClassName:    [ParaAnnotation]   
 * @Description:  [参数注解类，有此注解的参数会记录在日志表中]   
 * @Author:       [zhang.hai@founder.com.cn]  
 * @CreateDate:   [2015年10月9日 上午9:53:48]   
 * @UpdateUser:   [ZhangHai(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2015年10月9日 上午9:53:48，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0]
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ParaAnnotation {		
	public abstract String value();		
}
